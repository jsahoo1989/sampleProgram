package stepDefinitions.mylo;

import org.testng.Assert;

import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Mylo_LoginPage_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;

	public Mylo_LoginPage_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
	}

	@Given("^he is on the Mylo login page$")
	public void he_is_on_the_Mylo_login_page() throws Throwable {
		loginPage.openApplication();
	}

	@Given("^he has entered \"([^\"]*)\" and \"([^\"]*)\" in username and password field$")
	public void he_has_entered_and_in_username_and_password_field(String userEmail, String password) {
		loginPage.enterUserEmailAndPasswordForMylo(userEmail, password);
	}

	@When("^he clicks on Sign in button$")
	public void he_clicks_on_Sign_In_button() {
		loginPage.clickSignIn();
	}

	@Then("^he should successfuly redirected onto the Dashboard home page of Mylo Application with \"([^\"]*)\" getting displayed$")
	public void he_should_successfuly_redirected_onto_the_Dashboard_home_page_of_Mylo_Application_with_getting_displayed(
			String userName) {
		myloDashboardPage.verifyUserName(userName);
	}
}
