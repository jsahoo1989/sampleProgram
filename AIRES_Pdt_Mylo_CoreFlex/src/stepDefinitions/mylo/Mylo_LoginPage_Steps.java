package stepDefinitions.mylo;

import java.text.MessageFormat;
import org.testng.Assert;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class Mylo_LoginPage_Steps {
	private TestContext testContext;
	private Mylo_LoginPage loginPage;
	private Mylo_DashboardHomePage myloDashboardPage;

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
		Assert.assertTrue(myloDashboardPage.verifyUserName(userName),
				MessageFormat.format(MYLOConstants.VERIFIED_SECTION_NOT_DISPLAYED, CoreConstants.FAIL, userName,
						MYLOConstants.MYLO_DASHBOARD_HOME_PAGE));
	}
	
	@Then("^messages corresponding to different usernames mentioned below should be displayed on Mylo login page$")
	public void messages_corresponding_to_different_usernames_mentioned_below_should_be_displayed_on_Mylo_login_page(DataTable table){
		loginPage.verifyUserNamePasswordErrorMessage(table, MYLOConstants.USER_EMAIL);
	}
	
	@Then("^messages corresponding to different combination of username password mentioned below should be displayed on Mylo login page$")
	public void messages_corresponding_to_different_combination_of_username_password_mentioned_below_should_be_displayed_on_Mylo_login_page(DataTable table){
		loginPage.verifyUserNamePasswordErrorMessage(table, MYLOConstants.PASSWORD);
	}
}
