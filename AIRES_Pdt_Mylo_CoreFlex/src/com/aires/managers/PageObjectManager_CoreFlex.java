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

import com.aires.pages.coreflex.CoreFlex_AirportPickup_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AreaTour_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AutoRentalDuringAssignment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_BenefitSummaryPage;
import com.aires.pages.coreflex.CoreFlex_ConciergeServices_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_CulturalTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_CustomBundlesPage;
import com.aires.pages.coreflex.CoreFlex_DuplicateHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FinalMove_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;
import com.aires.pages.coreflex.CoreFlex_FurnitureRental_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HomeLeave_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HomePurchase_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_HouseHuntingTrip_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LanguageTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LumpSum_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_OtherHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PermanentStorage_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreAcceptanceServices_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.CoreFlex_TemporaryLiving_BenefitsPage;
import com.aires.pages.coreflex.MX_Client_AuthorizationHomePage;
import com.aires.pages.coreflex.MX_Client_BenefitSelectionToolPage;
import com.aires.pages.coreflex.MX_Transferee_FlexPlanningTool_Page;
import com.aires.pages.coreflex.MX_Transferee_JourneyHomePage;
import com.aires.pages.coreflex.MX_Transferee_MyBenefitsBundlePage;
import com.aires.pages.coreflex.MX_Transferee_MyProfilePage;
import com.aires.pages.coreflex.MobilityX_LoginPage;
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
	private CoreFlex_CulturalTraining_BenefitsPage _coreFlexCulturalTrainingBenefitsPage;
	private MX_Transferee_MyProfilePage _mxTransfereeMyProfilePage;
	private MobilityX_LoginPage _mobilityXLoginPage;
	private MX_Transferee_JourneyHomePage _mxTransfereeJourneyHomePage;
	private MX_Transferee_FlexPlanningTool_Page _mxTransfereeFlexPlanningToolPage;
	private MX_Transferee_MyBenefitsBundlePage _myBenefitsBundlePage;
	private TransfereeSubmissions_LoginPage _transfereeSubmissionsLoginPage;
	private TransfereeSubmissions_DashboardHomePage _transfereeSubmissionsDashboardHomePage;
	private TransfereeSubmissions_DetailsPage _transfereeSubmissionsDetailsPage;
	private CoreFlex_PreviewTransfereePage _coreFlexTransfereePreviewPage;
	private CoreFlex_ConciergeServices_BenefitsPage _coreFlexConciergeServicesBenefitsPage;
	private CoreFlex_HomePurchase_BenefitsPage _coreFlexHomePurchaseBenefitsPage;
	private CoreFlex_FinalMove_BenefitsPage _coreFlexFinalMoveBenefitsPage;
	private CoreFlex_AreaTour_BenefitsPage _coreFlexAreaTourBenefitsPage;
	private CoreFlex_HomeLeave_BenefitsPage _coreFlexHomeLeaveBenefitsPage;
	private CoreFlex_PermanentStorage_BenefitsPage _coreFlexPermanentStorageBenefitsPage;
	private CoreFlex_AirportPickup_BenefitsPage _coreFlexAireportPickupBenefitsPage;
	private CoreFlex_PreAcceptanceServices_BenefitsPage _coreFlexPreAcceptanceServicesBenefitsPage;
	private CoreFlex_FurnitureRental_BenefitsPage _coreFlexFurnitureRentalBenefitsPage;
	private CoreFlex_AutoRentalDuringAssignment_BenefitsPage _coreFlexAutoRentalDuringAssignmentBenefitsPage;
	private CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage _coreFlexEducationAssistanceBenefitsPage;
	private CoreFlex_HouseHuntingTrip_BenefitsPage _coreFlexHouseHuntingTripBenefitsPage;
	private MX_Client_AuthorizationHomePage _mxClientAuthorizationHomePage;
	private MX_Client_BenefitSelectionToolPage _mxClientBenefitSelectionToolPage;

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

	public MobilityX_LoginPage getMobilityXLoginPage() {
		return (_mobilityXLoginPage == null) ? _mobilityXLoginPage = new MobilityX_LoginPage(_driver)
				: _mobilityXLoginPage;
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
	
	public CoreFlex_CulturalTraining_BenefitsPage getCoreFlexCulturalTrainingBenefitsPage() {
		return (_coreFlexCulturalTrainingBenefitsPage == null)
				? _coreFlexCulturalTrainingBenefitsPage = new CoreFlex_CulturalTraining_BenefitsPage(_driver)
				: _coreFlexCulturalTrainingBenefitsPage;
	}
	
	public CoreFlex_ConciergeServices_BenefitsPage getCoreFlexConciergeServicesBenefitsPage() {
		return (_coreFlexConciergeServicesBenefitsPage == null)
				? _coreFlexConciergeServicesBenefitsPage = new CoreFlex_ConciergeServices_BenefitsPage(_driver)
				: _coreFlexConciergeServicesBenefitsPage;
	}
	
	public CoreFlex_HomePurchase_BenefitsPage getCoreFlexHomePurchaseBenefitsPage() {
		return (_coreFlexHomePurchaseBenefitsPage == null)
				? _coreFlexHomePurchaseBenefitsPage = new CoreFlex_HomePurchase_BenefitsPage(_driver)
				: _coreFlexHomePurchaseBenefitsPage;
	}
	
	public CoreFlex_FinalMove_BenefitsPage getCoreFlexFinalMoveBenefitsPage() {
		return (_coreFlexFinalMoveBenefitsPage == null)
				? _coreFlexFinalMoveBenefitsPage = new CoreFlex_FinalMove_BenefitsPage(_driver)
				: _coreFlexFinalMoveBenefitsPage;
	}
	
	public CoreFlex_AreaTour_BenefitsPage getCoreFlexAreaTourBenefitsPage() {
		return (_coreFlexAreaTourBenefitsPage == null)
				? _coreFlexAreaTourBenefitsPage = new CoreFlex_AreaTour_BenefitsPage(_driver)
				: _coreFlexAreaTourBenefitsPage;
	}
	
	public CoreFlex_HomeLeave_BenefitsPage getCoreFlexHomeLeaveBenefitsPage() {
		return (_coreFlexHomeLeaveBenefitsPage == null)
				? _coreFlexHomeLeaveBenefitsPage = new CoreFlex_HomeLeave_BenefitsPage(_driver)
				: _coreFlexHomeLeaveBenefitsPage;
	}
	
	public CoreFlex_PermanentStorage_BenefitsPage getCoreFlexPermanentStorageBenefitsPage() {
		return (_coreFlexPermanentStorageBenefitsPage == null)
				? _coreFlexPermanentStorageBenefitsPage = new CoreFlex_PermanentStorage_BenefitsPage(_driver)
				: _coreFlexPermanentStorageBenefitsPage;
	}
	
	public CoreFlex_AirportPickup_BenefitsPage getCoreFlexAirportPickupBenefitsPage() {
		return (_coreFlexAireportPickupBenefitsPage == null)
				? _coreFlexAireportPickupBenefitsPage = new CoreFlex_AirportPickup_BenefitsPage(_driver)
				: _coreFlexAireportPickupBenefitsPage;
	}
	
	public CoreFlex_PreAcceptanceServices_BenefitsPage getCoreFlexPreAcceptanceServicesBenefitsPage() {
		return (_coreFlexPreAcceptanceServicesBenefitsPage == null)
				? _coreFlexPreAcceptanceServicesBenefitsPage = new CoreFlex_PreAcceptanceServices_BenefitsPage(_driver)
				: _coreFlexPreAcceptanceServicesBenefitsPage;
	}
	
	public CoreFlex_FurnitureRental_BenefitsPage getCoreFlexFurnitureRentalBenefitsPage() {
		return (_coreFlexFurnitureRentalBenefitsPage == null)
				? _coreFlexFurnitureRentalBenefitsPage = new CoreFlex_FurnitureRental_BenefitsPage(_driver)
				: _coreFlexFurnitureRentalBenefitsPage;
	}
	
	public CoreFlex_AutoRentalDuringAssignment_BenefitsPage getCoreFlexAutoRentalDuringAssignmentBenefitsPage() {
		return (_coreFlexAutoRentalDuringAssignmentBenefitsPage == null)
				? _coreFlexAutoRentalDuringAssignmentBenefitsPage = new CoreFlex_AutoRentalDuringAssignment_BenefitsPage(_driver)
				: _coreFlexAutoRentalDuringAssignmentBenefitsPage;
	}
	
	public CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage getCoreFlexEducationAssistanceBenefitsPage() {
		return (_coreFlexEducationAssistanceBenefitsPage == null)
				? _coreFlexEducationAssistanceBenefitsPage = new CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage(_driver)
				: _coreFlexEducationAssistanceBenefitsPage;
	}	
	
	public CoreFlex_HouseHuntingTrip_BenefitsPage getCoreFlexHouseHuntingTripBenefitsPage() {
		return (_coreFlexHouseHuntingTripBenefitsPage == null)
				? _coreFlexHouseHuntingTripBenefitsPage = new CoreFlex_HouseHuntingTrip_BenefitsPage(_driver)
				: _coreFlexHouseHuntingTripBenefitsPage;
	}
	
	public MX_Client_AuthorizationHomePage getMXClientAuthorizationHomePage() {
		return (_mxClientAuthorizationHomePage == null)
				? _mxClientAuthorizationHomePage = new MX_Client_AuthorizationHomePage(_driver)
				: _mxClientAuthorizationHomePage;
	}
	
	public MX_Client_BenefitSelectionToolPage getMXClientBenefitSelectionTollPage() {
		return (_mxClientBenefitSelectionToolPage == null)
				? _mxClientBenefitSelectionToolPage = new MX_Client_BenefitSelectionToolPage(_driver)
				: _mxClientBenefitSelectionToolPage;
	}
}