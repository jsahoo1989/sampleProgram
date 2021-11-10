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

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.ArrayList;

import org.apache.commons.lang3.reflect.FieldUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.utilities.Log;
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

	public Hooks(TestContext context) {
		testContext = context;
	}

	@Before
	public void BeforeSteps(Scenario scenario) throws Exception {
		scenarioName = scenario;
		Reporter.assignAuthor("AIRES - Automation - By : " + System.getProperty("user.name"));
		testContext.initializeWebManager();
		if (scenario.getName().contains("PDT")) {
			Log.info(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
			testContext.getWebDriverManager().getDriver().navigate()
					.to(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		} else if (scenario.getName().contains("Mylo")) {
			Log.info(FileReaderManager.getInstance().getConfigReader().getMyloApplicationUrl());
			testContext.getWebDriverManager().getDriver().navigate()
					.to(FileReaderManager.getInstance().getConfigReader().getMyloApplicationUrl());
		}
	}

	@After(order = 2)
	public void afterScenario(Scenario scenario) throws Exception {
		String screenshotName = scenario.getName().replaceAll(" ", "_");
		if (scenario.isFailed()) {
			Reporter.addStepLog(Status.FAIL + " : Please refer failed screen shot attached here.");
			testResult = 5;
			try {
				// Takes a screenshot from the driver and save it to the specified location
				File sourcePath = ((TakesScreenshot) testContext.getWebDriverManager().getDriver())
						.getScreenshotAs(OutputType.FILE);

				// Building up the destination path for the screenshot to save
				// Also make sure to create a folder 'Failed_Screenshots' with in the project
				// hierarchy
				File destinationPath = new File(
						System.getProperty("user.dir") + "/Failed_Screenshots/" + screenshotName + ".png");

				// Copy taken screenshot from source location to destination location
				Files.copy(sourcePath, destinationPath);

				// Attach the specified screenshot to the test
				Reporter.addScreenCaptureFromPath(destinationPath.toString());
			} catch (IOException e) {
			}
		} else if (scenario.getStatus().equalsIgnoreCase("passed")) {
			Reporter.addScenarioLog(Status.PASS + " : Test Scenario is Passed");
			testResult = 1;
		} else {
			Reporter.addScenarioLog(Status.SKIP + " : Test Scenario is Skipped");
			testResult = 2;
		}
	}

/*	@After(order = 1)
	public void updateResultInTestRail(Scenario scenario) {
		// String Case_ID =
		// CoreFunctions.extractIntValue(scenario.getSourceTagNames().toString());
		String Case_ID = BusinessFunctions.getTestRailIdAsPerEnvt(CoreConstants.TAG_VALUE,
				scenario.getSourceTagNames().toString());
		Log.info(Case_ID);
		String testrailRunName = (CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId"));
		TestRail.addResultForTestCase(Case_ID, testResult, testrailRunName, AiresConstants.TEST_RAIL_URL,
				AiresConstants.testRailUseriD, AiresConstants.testRailPassword, logError(scenario));
		Runtime.getRuntime().gc();
	}*/

	@After(order = 0)
	public void AfterSteps(Scenario scenario) throws Exception {
		testContext.getWebDriverManager().closeDriver();
		Runtime.getRuntime().gc();
	}

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