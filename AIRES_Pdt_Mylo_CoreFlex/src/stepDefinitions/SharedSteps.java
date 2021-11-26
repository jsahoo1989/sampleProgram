package stepDefinitions;

import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.iris.IRIS_Corporation_Main;
import com.aires.pages.iris.IRIS_LoginPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

import cucumber.api.java.en.Given;
import stepDefinitions.Hooks;

public class SharedSteps {
	TestContext testContext;
	IRIS_Corporation_Main irisCorporation_Main;
	private PDT_LoginDetails _loginDetails = null;

	public SharedSteps(TestContext context) {
		testContext = context;
		if (!Hooks.scenarioName.getName().contains("IRIS")) {
			irisCorporation_Main = testContext.getIrisPageManager().irisCorporationMain;
		} else {
			irisCorporation_Main = testContext.getIrisPageManager().irisCorporationMain;
		}
	}

	@Given("^he has logged into IRIS application as \"([^\"]*)\" user$")
	public void he_ha_logged_into_iris_application_as_something_user(String userName) throws Throwable {
		_loginDetails = FileReaderManager.getInstance().getJsonReader().getLoginByApplication("IRIS");
		testContext.getIrisPageManager().irisLoginPage = new IRIS_LoginPage();
		testContext.getIrisPageManager().irisLoginPage.getIRISLoginAsPerEnvt(_loginDetails);
	}

}