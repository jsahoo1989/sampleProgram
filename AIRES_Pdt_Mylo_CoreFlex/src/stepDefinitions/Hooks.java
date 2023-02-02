/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 28/10/2021			Sarika Pant						Created a cucumber hook class
 * 29/10/2021			Rahul Sharma					Added failed screen shot capture utility for MobilityX application
 * 01/11/2021			Rahul Sharma					Added/Updated After methods to implement TestRail utility to update result in TestRail
 * 02/11/2021			Rahul Sharma					Added logError method to log the exception in TestRail in case of test case failed
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package stepDefinitions;

import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import javax.imageio.ImageIO;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.pdt.PDT_LoginInfo;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.Log;
import com.aires.utilities.TestRail;
import com.aventstack.extentreports.Status;
import com.google.common.io.Files;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.Scenario;
import cucumber.api.java.After;
import cucumber.api.java.Before;
import cucumber.runtime.ScenarioImpl;
import gherkin.formatter.model.Result;

public class Hooks {

	TestContext testContext;
	public static int testResult;
	public static Scenario scenarioName;
	private PDT_LoginInfo _loginInfo;
	private CoreFlex_LoginInfo _coreFlexLoginInfo;

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps(Scenario scenario) throws Exception {
		scenarioName = scenario;
		Reporter.assignAuthor("AIRES - Automation - By : " + System.getProperty("user.name"));
		testContext.initializeWebManager(scenario.getName().contains("IRIS"));
		String url = "";
		if (scenario.getName().contains("IRIS")) {
			testContext.getBasePage().invokeIrisApplication();
			testContext.getBasePage().killExistingBrowsers();
		} else
			url = remoteGetURL(scenario);
//			url = localGetURL(scenario);

		Log.info(url);
		testContext.getWebDriverManager().getDriver().navigate().to(url);
		CoreFunctions.writeToPropertiesFile("assignmentSubmitStatus", "false");
	}

	@After(order = 2)
	public void afterScenario(Scenario scenario) throws Exception {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed() && scenario.getName().contains("IRIS")) {
			String screenshotPath = System.getProperty("user.dir") + "/IRISScreenShots/" + screenshotName + ".png";
			File fileObj = new File(screenshotPath);
			Rectangle screen = new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
			BufferedImage capture = new Robot().createScreenCapture(screen);
			testResult = 5;
			try {
				ImageIO.write(capture, "png", fileObj);
			} catch (IOException e) {
				e.printStackTrace();
			}
			Reporter.addScreenCaptureFromPath(screenshotPath.toString());
		} else if (scenario.isFailed()) {
			Reporter.addStepLog(Status.FAIL + " : Please refer failed screen shot attached here.");
			testResult = 5;
			try {
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);
				File destinationPath = new File(
						System.getProperty("user.dir") + "/Failed_Screenshots/" + screenshotName + ".png");
				Files.copy(sourcePath, destinationPath);
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
				dataCleanUp();
			} catch (IOException e) {
			}
		} else if (scenario.getStatus().equalsIgnoreCase("passed")) {
			dataCleanUp();
			Reporter.addScenarioLog(Status.PASS + " : Test Scenario is Passed");
			testResult = 1;
		} else {
			Reporter.addScenarioLog(Status.SKIP + " : Test Scenario is Skipped");
			testResult = 2;
		}
	}

//	@After(order = 1)
	public void updateResultInTestRail(Scenario scenario) {
		String Case_ID = BusinessFunctions.getTestRailIdAsPerApplication(BusinessFunctions.getApplicationBasedOnExecutionType(),
				scenario.getSourceTagNames().toString());
		Log.info(Case_ID);
		String testrailRunName = (CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId"));
		TestRail.addResultForTestCase(Case_ID, testResult, testrailRunName, CoreConstants.TEST_RAIL_URL,
				CoreConstants.testRailUseriD, CoreConstants.testRailPassword, logError(scenario));
		Runtime.getRuntime().gc();
	}

	@After(order = 0)
	public void AfterSteps(Scenario scenario) throws Exception {
		if (scenario.getName().contains("IRIS")) {
			testContext.getBasePage().cleanIrisProcesses();
		} else {
			quitDriver();
		}
		Runtime.getRuntime().gc();
	}

	public String remoteGetURL(Scenario scenario) {
		CoreFunctions.writeToPropertiesFile("ExecutionType", "remote");
		String appName = System.getProperty("application");
		CoreFunctions.writeToPropertiesFile("application", appName);
		String enviroment = System.getProperty("envt");
		CoreFunctions.writeToPropertiesFile("envt", enviroment);
		_coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(System.getProperty("envt").toLowerCase());
		return (appName.equals(CoreConstants.COREFLEX)
				&& (scenario.getName().contains("MXTransferee") || scenario.getName().contains("MXClient"))
						? _coreFlexLoginInfo.details.mobilityXURL
						: (appName.equals(CoreConstants.COREFLEX)
								&& scenario.getName().contains("TransfereeSubmissions"))
										? _coreFlexLoginInfo.details.transfereeSubmissionsURL
										: System.getProperty("testURL"));

	}

	public String localGetURL(Scenario scenario) {
		CoreFunctions.writeToPropertiesFile("ExecutionType", "local");
		_loginInfo = FileReaderManager.getInstance().getJsonReader()
				.getLoginByEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase());
		_coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginByEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase());
		return (scenario.getName().contains("PDT")) ? _loginInfo.details.pdtUrl
				: (scenario.getName().contains("Mylo"))
						? FileReaderManager.getInstance().getConfigReader().getMyloApplicationUrl()
						: (scenario.getName().contains("CoreFlex")) ? _coreFlexLoginInfo.details.blueprintURL
								: (scenario.getName().contains("MXTransferee")
										|| scenario.getName().contains("MXClient"))
												? _coreFlexLoginInfo.details.mobilityXURL
												: _coreFlexLoginInfo.details.transfereeSubmissionsURL;
	}

	private void dataCleanUp() {
		if (ClientPolicyDetails.getPolicyId() != null)
			DbFunctions.deletePolicyByPolicyId(ClientPolicyDetails.getPolicyId());
		if (CoreFunctions.getPropertyFromConfig("assignmentSubmitStatus").equalsIgnoreCase("true"))
			DbFunctions.updateAssignmentStatus(PDTConstants.INACTIVE_ASSGN_STATUS_CODE,
					ClientPolicyDetails.getPolicyId());
	}

	public void quitDriver() {
		Log.info("testContext.getWebDriverManager().toString()=="
				+ testContext.getWebDriverManager().getCurrentDriverStatus());
		if (!(testContext.getWebDriverManager().getCurrentDriverStatus() == null))
			testContext.getWebDriverManager().closeDriver();
	}

	@SuppressWarnings("unchecked")
	private static String logError(Scenario scenario) {
		String getErrorResult = null;
		Field field = FieldUtils.getField(((ScenarioImpl) scenario).getClass(), "stepResults", true);
		field.setAccessible(true);
		try {
			ArrayList<Result> results = (ArrayList<Result>) field.get(scenario);
			for (Result result : results) {
				if (result.getError() != null) {
					getErrorResult = result.getErrorMessage();
					Log.info("Error Scenario: {} -- " + scenario.getId() + " --Result.getError--" + result.getError());
				}
			}
		} catch (Exception e) {
			Log.info("Error while logging error " + e);
		}
		return (getErrorResult);
	}
}