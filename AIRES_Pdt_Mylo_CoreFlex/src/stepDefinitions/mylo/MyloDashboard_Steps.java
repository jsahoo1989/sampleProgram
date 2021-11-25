package stepDefinitions.mylo;

import org.testng.Assert;

import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;

import cucumber.api.DataTable;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class MyloDashboard_Steps {
	TestContext testContext;
	Mylo_LoginPage loginPage;
	Mylo_DashboardHomePage myloDashboardPage;

	public MyloDashboard_Steps(TestContext context) {
		testContext = context;
		loginPage = testContext.getMyloPageObjectManager().getLoginPage();
		myloDashboardPage = testContext.getMyloPageObjectManager().getDashboardHomePage();
	}
	
	@Given("^he has logged into 'Mylo' application$")
	public void he_has_logged_into_Mylo_application() throws Throwable {
		loginPage.openApplication();
		loginPage.switchWindow();
		loginPage.enterUserEmailAndPasswordForMylo("mxssodev5@corp.aires.com", "AiresSSOTestPW2021!");
		loginPage.clickSignIn();
		
	}
	
	@Given("^he is on Mylo Dashboard Home page$")
	public void he_is_on_Mylo_Dashboard_Home_page() throws Throwable {
		Assert.assertTrue(myloDashboardPage.verifyUserName("mxsso!"));
	}

	@When("^he clicks on the Assignment option in the Mylo Menu on the sidebar$")
	public void he_clicks_on_the_Assignment_option_in_the_Mylo_Menu_on_the_sidebar() throws Throwable {
		myloDashboardPage.clickOptionsFromMainMenu("Assignment");
	}

	@Then("^the Select Query Type screen should display with the given parameters$")
	public void the_Select_Query_Type_screen_should_display_with_the_given_parameters(DataTable data) throws Throwable {
		Assert.assertTrue(myloDashboardPage.verifySelectQueryOptions(data),"Incorrect Select Query Parameters");
	}
	
	@Given("^he clicks on Hamburger Menu after closing the Assignment option$")
	public void he_clicks_on_Hamburger_Menu_after_closing_the_Assignment_option() throws Throwable {
	   myloDashboardPage.closePopUp();
	   Assert.assertTrue(myloDashboardPage.clickHamburgerMenu(), "Hamburger Menu Not Appearing");
	   
	}

	@When("^he clicks on \"([^\"]*)\" Option in the Hamburger Menu$")
	public void he_clicks_on_Option_in_the_Hamburger_Menu(String options) throws Throwable {
	   myloDashboardPage.selectOptionsFromHamburgerMenu(options);
	}

}
