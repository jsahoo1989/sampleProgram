package stepDefinitions.coreFlex;

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.cucumber.TestContext;
import com.aires.managers.FileReaderManager;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;

public class CF_Transferee_MobilityJourney_Both_Cards_Steps {

	private TestContext testContext;
	private MX_Transferee_JourneyHomePage mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage mxTransfereeMyBenefitsBundlePage;
	int _initialTableRowCount = 0;
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	public CF_Transferee_MobilityJourney_Both_Cards_Steps(TestContext context) {
		testContext = context;

		mxTransfereeJourneyHomePage = testContext.getCoreFlexPageObjectManager().getMXTransfereeJourneyHomePage();
		mxTransfereeFlexPlanningToolPage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeFlexPlanningToolPage();
		mxTransfereeMyBenefitsBundlePage = testContext.getCoreFlexPageObjectManager()
				.getMXTransfereeMyBenefitsBundlePage();
	}

	/**********************************************************************/
	
	@Given("^he has verified \"([^\"]*)\" Flex and Core card having \"([^\"]*)\" status displayed under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_Flex_and_Core_card_having_status_displayed_under_Service_Monitoring_section_of_page(
			String cardBenefitName, String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
	}
	
	@Given("^he has verified \"([^\"]*)\" Flex and Core card status updated to \"([^\"]*)\" under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void he_has_verified_card_status_updated_to_under_Service_Monitoring_section_of_page(String cardBenefitName,
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
	}
	
	@Then("^\"([^\"]*)\" Flex and Core card status should be updated to \"([^\"]*)\" under 'Service Monitoring' section of \"([^\"]*)\" page$")
	public void card_status_should_be_updated_to_under_Service_Monitoring_section_of_page(String cardBenefitName,
			String expectedStatus, String pageName) throws Throwable {
		mxTransfereeJourneyHomePage.clickElementOfPage(MobilityXConstants.MANAGE_MY_POINTS);
		Assert.assertTrue(mxTransfereeFlexPlanningToolPage.isFlexPlanningToolHomePageDisplayed(),
				MessageFormat.format(MobilityXConstants.FLEX_PLANNING_TOOL_PAGE_NOT_DISPLAYED, CoreConstants.FAIL));
		mxTransfereeFlexPlanningToolPage.clickElementOfPage(MobilityXConstants.BACK_TO_MOBILITY_JOURNEY);
		Assert.assertTrue(mxTransfereeJourneyHomePage.isFlexBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_FLEX_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
		Assert.assertTrue(mxTransfereeJourneyHomePage.isCoreBenefitCardVerified(cardBenefitName, expectedStatus),
				MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CORE_BENEFIT_CARD, CoreConstants.FAIL,
						cardBenefitName, pageName));
	}

}
