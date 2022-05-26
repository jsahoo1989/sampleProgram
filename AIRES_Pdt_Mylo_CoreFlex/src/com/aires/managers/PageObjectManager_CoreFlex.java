/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			 Rahul Sharma					 used to manage the page repositories
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.managers;

import org.openqa.selenium.WebDriver;

import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_DuplicateHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_LanguageTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LumpSum_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_OtherHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.CoreFlex_TemporaryLiving_BenefitsPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_LoginPage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.MX_Transferee_MyProfilePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DashboardHomePage;
import com.aires.pages.coreflex.TransfereeSubmissions_DetailsPage;
import com.aires.pages.coreflex.TransfereeSubmissions_LoginPage;

public class PageObjectManager_CoreFlex {

	private WebDriver _driver;
	private CoreFlex_FlexPolicySetupPage _flexPolicySetupPage;
	private CoreFlex_PolicyBenefitsCategoriesPage _coreFlexPolicyBenefitsCategoriesPage;
	private CoreFlex_DuplicateHousing_BenefitsPage _coreFlexDuplicateHousingBenefitsPage;
	private CoreFlex_LumpSum_BenefitsPage _coreFlexLumpSumBenefitsPage;
	private CoreFlex_BenefitSummaryPage _coreFlexBenefitsSummaryPage;
	private CoreFlex_CustomBundlesPage _coreFlexCustomBundlesPage;
	private CoreFlex_LanguageTraining_BenefitsPage _coreFlexLanguageTrainingBenefitsPage;
	private CoreFlex_OtherHousing_BenefitsPage _coreFlexOtherHousingBenefitsPage;
	private CoreFlex_TemporaryLiving_BenefitsPage _coreFlexTemporaryLivingBenefitsPage;
	private MX_Transferee_MyProfilePage _mxTransfereeMyProfilePage;
	private MX_Transferee_LoginPage _mxTransfereeLoginPage;
	private MX_Transferee_JourneyHomePage _mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page _mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage _myBenefitsBundlePage;
	private TransfereeSubmissions_LoginPage _transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage _transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage _transfereeSubmissionsDetailsPage;
	private CoreFlex_PreviewTransfereePage _coreFlexTransfereePreviewPage;

	public PageObjectManager_CoreFlex(WebDriver driver) {
		this._driver = driver;
	}

	public CoreFlex_FlexPolicySetupPage getFlexPolicySetupPage() {
		return (_flexPolicySetupPage == null) ? _flexPolicySetupPage = new CoreFlex_FlexPolicySetupPage(_driver)
				: _flexPolicySetupPage;
	}

	public CoreFlex_PolicyBenefitsCategoriesPage getCoreFlexPolicyBenefitsCategoriesPage() {
		return (_coreFlexPolicyBenefitsCategoriesPage == null)
				? _coreFlexPolicyBenefitsCategoriesPage = new CoreFlex_PolicyBenefitsCategoriesPage(_driver)
				: _coreFlexPolicyBenefitsCategoriesPage;
	}

	public CoreFlex_DuplicateHousing_BenefitsPage getCoreFlexDuplicateHousingBenefitsPage() {
		return (_coreFlexDuplicateHousingBenefitsPage == null)
				? _coreFlexDuplicateHousingBenefitsPage = new CoreFlex_DuplicateHousing_BenefitsPage(_driver)
				: _coreFlexDuplicateHousingBenefitsPage;
	}

	public CoreFlex_LumpSum_BenefitsPage getCoreFlexLumpSumBenefitsPage() {
		return (_coreFlexLumpSumBenefitsPage == null)
				? _coreFlexLumpSumBenefitsPage = new CoreFlex_LumpSum_BenefitsPage(_driver)
				: _coreFlexLumpSumBenefitsPage;
	}

	public CoreFlex_LanguageTraining_BenefitsPage getCoreFlexLanguageTrainingBenefitsPage() {
		return (_coreFlexLanguageTrainingBenefitsPage == null)
				? _coreFlexLanguageTrainingBenefitsPage = new CoreFlex_LanguageTraining_BenefitsPage(_driver)
				: _coreFlexLanguageTrainingBenefitsPage;
	}

	public CoreFlex_BenefitSummaryPage getCoreFlexBenefitSummaryPage() {
		return (_coreFlexBenefitsSummaryPage == null)
				? _coreFlexBenefitsSummaryPage = new CoreFlex_BenefitSummaryPage(_driver)
				: _coreFlexBenefitsSummaryPage;
	}

	public CoreFlex_CustomBundlesPage getCoreFlexCustomBundlesPage() {
		return (_coreFlexCustomBundlesPage == null)
				? _coreFlexCustomBundlesPage = new CoreFlex_CustomBundlesPage(_driver)
				: _coreFlexCustomBundlesPage;
	}

	public MX_Transferee_LoginPage getMXTransfereeLoginPage() {
		return (_mxTransfereeLoginPage == null) ? _mxTransfereeLoginPage = new MX_Transferee_LoginPage(_driver)
				: _mxTransfereeLoginPage;
	}

	public MX_Transferee_JourneyHomePage getMXTransfereeJourneyHomePage() {
		return (_mxTransfereeJourneyHomePage == null)
				? _mxTransfereeJourneyHomePage = new MX_Transferee_JourneyHomePage(_driver)
				: _mxTransfereeJourneyHomePage;
	}

	public MX_Transferee_FlexPlanningTool_Page getMXTransfereeFlexPlanningToolPage() {
		return (_mxTransfereeFlexPlanningToolPage == null)
				? _mxTransfereeFlexPlanningToolPage = new MX_Transferee_FlexPlanningTool_Page(_driver)
				: _mxTransfereeFlexPlanningToolPage;
	}

	public MX_Transferee_MyBenefitsBundlePage getMXTransfereeMyBenefitsBundlePage() {
		return (_myBenefitsBundlePage == null) ? _myBenefitsBundlePage = new MX_Transferee_MyBenefitsBundlePage(_driver)
				: _myBenefitsBundlePage;
	}

	public TransfereeSubmissions_LoginPage getTransfereeSubmissionsLoginPage() {
		return (_transfereeSubmissionsLoginPage == null)
				? _transfereeSubmissionsLoginPage = new TransfereeSubmissions_LoginPage(_driver)
				: _transfereeSubmissionsLoginPage;
	}

	public TransfereeSubmissions_DashboardHomePage getTransfereeSubmissionsDashboardHomePage() {
		return (_transfereeSubmissionsDashboardHomePage == null)
				? _transfereeSubmissionsDashboardHomePage = new TransfereeSubmissions_DashboardHomePage(_driver)
				: _transfereeSubmissionsDashboardHomePage;
	}

	public TransfereeSubmissions_DetailsPage getTransfereeSubmissionsDetailsPage() {
		return (_transfereeSubmissionsDetailsPage == null)
				? _transfereeSubmissionsDetailsPage = new TransfereeSubmissions_DetailsPage(_driver)
				: _transfereeSubmissionsDetailsPage;
	}

	public MX_Transferee_MyProfilePage getTransfereeMyProfilePage() {
		return (_mxTransfereeMyProfilePage == null)
				? _mxTransfereeMyProfilePage = new MX_Transferee_MyProfilePage(_driver)
				: _mxTransfereeMyProfilePage;
	}

	public CoreFlex_OtherHousing_BenefitsPage getOtherHousingBenefitPage() {
		return (_coreFlexOtherHousingBenefitsPage == null)
				? _coreFlexOtherHousingBenefitsPage = new CoreFlex_OtherHousing_BenefitsPage(_driver)
				: _coreFlexOtherHousingBenefitsPage;
	}
	
	public CoreFlex_PreviewTransfereePage getCoreFlexTransfereePreviewPage() {
		return (_coreFlexTransfereePreviewPage == null)
				? _coreFlexTransfereePreviewPage = new CoreFlex_PreviewTransfereePage(_driver)
				: _coreFlexTransfereePreviewPage;
	}
	
	public CoreFlex_TemporaryLiving_BenefitsPage getCoreFlexTemporaryLivingBenefitPage() {
		return (_coreFlexTemporaryLivingBenefitsPage == null)
				? _coreFlexTemporaryLivingBenefitsPage = new CoreFlex_TemporaryLiving_BenefitsPage(_driver)
				: _coreFlexTemporaryLivingBenefitsPage;
	}
}