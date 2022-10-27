package stepDefinitions;

import com.aires.businessrules.CoreFunctions;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;

import cucumber.api.java.en.Given;

public class SharedSteps {
	TestContext testContext;
	IRIS_Corporation_Main irisCorporation_Main;

	private CoreFlex_LoginInfo _loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getLoginInfoByEnviroment((CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
			
			//private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(System.getProperty("application").toLowerCase());

	public SharedSteps(TestContext context) {
		testContext = context;
		if (Hooks.scenarioName.getName().contains("IRIS")) {
			irisCorporation_Main = testContext.getIrisPageManager().irisCorporationMain;
		} else {
			irisCorporation_Main = testContext.getIrisPageManager().irisCorporationMain;
		}
	}

	@Given("^he is logged into IRIS application as \"([^\"]*)\" user$")
	public void he_is_logged_into_iris_application_as_something_user(String userName) throws Throwable {
//		_loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
	}
	
	@Given("^he is logged into IRIS application$")
	public void he_is_logged_into_IRIS_application() throws Throwable {
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginInfo);
		
	}

}