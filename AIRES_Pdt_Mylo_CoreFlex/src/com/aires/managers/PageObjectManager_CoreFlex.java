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

import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.WebDriver;

import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.pages.coreflex.BenefitPage;
import com.aires.pages.coreflex.CoreFlex_AirShipment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AirportPickup_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AreaTour_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AutoRentalDuringAssignment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_AutoShipment_BenefitsPage;
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
import com.aires.pages.coreflex.CoreFlex_Inland_Shipment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LanguageTraining_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_LumpSum_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_OtherHousing_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PermanentStorage_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_Pet_Shipment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PolicyBenefitsCategoriesPage;
import com.aires.pages.coreflex.CoreFlex_PreAcceptanceServices_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_PreviewTransfereePage;
import com.aires.pages.coreflex.CoreFlex_Sea_Surface_Shipment_BenefitsPage;
import com.aires.pages.coreflex.CoreFlex_TemporaryLiving_BenefitsPage;
import com.aires.pages.coreflex.MX_Client_AuthWorkflow_ApprovalActionPage;
import com.aires.pages.coreflex.MX_Client_AuthorizationHomePage;
import com.aires.pages.coreflex.MX_Client_AuthorizationHome_CollaborationPage;
import com.aires.pages.coreflex.MX_Client_BenefitSelectionToolPage;
import com.aires.pages.coreflex.MX_Client_BenefitsBundlePage;
import com.aires.pages.coreflex.MX_Client_ViewAllInitiationsPage;
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
	private CoreFlex_AirportPickup_BenefitsPage _coreFlexAirportPickupBenefitsPage;
	private CoreFlex_PreAcceptanceServices_BenefitsPage _coreFlexPreAcceptanceServicesBenefitsPage;
	private CoreFlex_FurnitureRental_BenefitsPage _coreFlexFurnitureRentalBenefitsPage;
	private CoreFlex_AutoRentalDuringAssignment_BenefitsPage _coreFlexAutoRentalDuringAssignmentBenefitsPage;
	private CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage _coreFlexEducationAssistanceBenefitsPage;
	private CoreFlex_HouseHuntingTrip_BenefitsPage _coreFlexHouseHuntingTripBenefitsPage;
	private MX_Client_AuthorizationHomePage _mxClientAuthorizationHomePage;
	private MX_Client_BenefitSelectionToolPage _mxClientBenefitSelectionToolPage;
	private MX_Client_BenefitsBundlePage _mxClientBenefitsBundlePage;
	private MX_Client_ViewAllInitiationsPage _mxClientViewAllInitiationsPage;
	private CoreFlex_AirShipment_BenefitsPage _coreFlexAirShipmentBenefitsPage;
	private CoreFlex_AutoShipment_BenefitsPage _coreFlexAutoShipmentBenefitsPage;
	private CoreFlex_Sea_Surface_Shipment_BenefitsPage _coreFlexSeaSurfaceShipmentBenefitsPage;
	private CoreFlex_Inland_Shipment_BenefitsPage _coreFlexInlandShipmentBenefitsPage;
	private CoreFlex_Pet_Shipment_BenefitsPage _coreFlexPetShipmentBenefitsPage;

	private static Map<String, BenefitPage> benefitPageObjects = new HashMap<String, BenefitPage>();

	private MX_Client_AuthorizationHome_CollaborationPage _mxClientAuthCollaborationPage;
	private MX_Client_AuthWorkflow_ApprovalActionPage _mxClientAuthWFApprovalActionPage;
 
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
		return (_coreFlexAirportPickupBenefitsPage == null)
				? _coreFlexAirportPickupBenefitsPage = new CoreFlex_AirportPickup_BenefitsPage(_driver)
				: _coreFlexAirportPickupBenefitsPage;
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
				? _coreFlexAutoRentalDuringAssignmentBenefitsPage = new CoreFlex_AutoRentalDuringAssignment_BenefitsPage(
						_driver)
				: _coreFlexAutoRentalDuringAssignmentBenefitsPage;
	}

	public CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage getCoreFlexEducationAssistanceBenefitsPage() {
		return (_coreFlexEducationAssistanceBenefitsPage == null)
				? _coreFlexEducationAssistanceBenefitsPage = new CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage(
						_driver)
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

	public MX_Client_BenefitSelectionToolPage getMXClientBenefitSelectionToolPage() {
		return (_mxClientBenefitSelectionToolPage == null)
				? _mxClientBenefitSelectionToolPage = new MX_Client_BenefitSelectionToolPage(_driver)
				: _mxClientBenefitSelectionToolPage;
	}

	public MX_Client_BenefitsBundlePage getMXClientBenefitsBundlePage() {
		return (_mxClientBenefitsBundlePage == null)
				? _mxClientBenefitsBundlePage = new MX_Client_BenefitsBundlePage(_driver)
				: _mxClientBenefitsBundlePage;
	}

	public MX_Client_ViewAllInitiationsPage getMXClientViewAllInitiationsPage() {
		return (_mxClientViewAllInitiationsPage == null)
				? _mxClientViewAllInitiationsPage = new MX_Client_ViewAllInitiationsPage(_driver)
				: _mxClientViewAllInitiationsPage;
	}

	public CoreFlex_AirShipment_BenefitsPage getCoreFlexAirShipmentBenefitsPage() {
		return (_coreFlexAirShipmentBenefitsPage == null)
				? _coreFlexAirShipmentBenefitsPage = new CoreFlex_AirShipment_BenefitsPage(_driver)
				: _coreFlexAirShipmentBenefitsPage;
	}

	public CoreFlex_AutoShipment_BenefitsPage getCoreFlexAutoShipmentBenefitsPage() {
		return (_coreFlexAutoShipmentBenefitsPage == null)
				? _coreFlexAutoShipmentBenefitsPage = new CoreFlex_AutoShipment_BenefitsPage(_driver)
				: _coreFlexAutoShipmentBenefitsPage;
	}

	public CoreFlex_Sea_Surface_Shipment_BenefitsPage getCoreFlexSeaSurfaceShipmentBenefitsPage() {
		return (_coreFlexSeaSurfaceShipmentBenefitsPage == null)
				? _coreFlexSeaSurfaceShipmentBenefitsPage = new CoreFlex_Sea_Surface_Shipment_BenefitsPage(_driver)
				: _coreFlexSeaSurfaceShipmentBenefitsPage;
	}

	public CoreFlex_Inland_Shipment_BenefitsPage getCoreFlexInlandShipmentBenefitsPage() {
		return (_coreFlexInlandShipmentBenefitsPage == null)
				? _coreFlexInlandShipmentBenefitsPage = new CoreFlex_Inland_Shipment_BenefitsPage(_driver)
				: _coreFlexInlandShipmentBenefitsPage;
	}

	public CoreFlex_Pet_Shipment_BenefitsPage getCoreFlexPetShipmentBenefitsPage() {
		return (_coreFlexPetShipmentBenefitsPage == null)
				? _coreFlexPetShipmentBenefitsPage = new CoreFlex_Pet_Shipment_BenefitsPage(_driver)
				: _coreFlexPetShipmentBenefitsPage;
	}

	public Map<String, BenefitPage> getPageObjects() {
		benefitPageObjects.put(COREFLEXConstants.DUPLICATE_HOUSING, _coreFlexDuplicateHousingBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.LUMP_SUM, _coreFlexLumpSumBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.OTHER_HOUSING_BENEFIT, _coreFlexOtherHousingBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.LANGUAGE_TRAINING, _coreFlexLanguageTrainingBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.CULTURAL_TRAINING, _coreFlexCulturalTrainingBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.TEMPORARY_LIVING, _coreFlexTemporaryLivingBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.CONCIERGE_SERVICES, _coreFlexConciergeServicesBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.HOME_PURCHASE, _coreFlexHomePurchaseBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.FINAL_MOVE, _coreFlexFinalMoveBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.AREA_TOUR, _coreFlexAreaTourBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.HOME_LEAVE, _coreFlexHomeLeaveBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.PRE_ACCEPTANCE_SERVICES, _coreFlexPreAcceptanceServicesBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.FURNITURE_RENTAL, _coreFlexFurnitureRentalBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT,
				_coreFlexAutoRentalDuringAssignmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH,
				_coreFlexEducationAssistanceBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.HOUSE_HUNTING_TRIP, _coreFlexHouseHuntingTripBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.AIR_SHIPMENT, _coreFlexAirShipmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.AUTO_SHIPMENT, _coreFlexAutoShipmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.SEA_OR_SURFACE_SHIPMENT, _coreFlexSeaSurfaceShipmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.INLAND_SHIPMENT, _coreFlexInlandShipmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.PET_SHIPMENT, _coreFlexPetShipmentBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.PERMANENT_STORAGE, _coreFlexPermanentStorageBenefitsPage);
		benefitPageObjects.put(COREFLEXConstants.AIRPORT_PICKUP, _coreFlexAirportPickupBenefitsPage);
		return benefitPageObjects;
	}

	public void initializeCoreFlexPageObjects() {
		_coreFlexDuplicateHousingBenefitsPage = this.getCoreFlexDuplicateHousingBenefitsPage();
		_coreFlexLumpSumBenefitsPage = this.getCoreFlexLumpSumBenefitsPage();
		_coreFlexOtherHousingBenefitsPage = this.getOtherHousingBenefitPage();
		_coreFlexLanguageTrainingBenefitsPage = this.getCoreFlexLanguageTrainingBenefitsPage();
		_coreFlexTemporaryLivingBenefitsPage = this.getCoreFlexTemporaryLivingBenefitPage();
		_coreFlexCulturalTrainingBenefitsPage = this.getCoreFlexCulturalTrainingBenefitsPage();
		_coreFlexConciergeServicesBenefitsPage = this.getCoreFlexConciergeServicesBenefitsPage();
		_coreFlexHomePurchaseBenefitsPage = this.getCoreFlexHomePurchaseBenefitsPage();
		_coreFlexFinalMoveBenefitsPage = this.getCoreFlexFinalMoveBenefitsPage();
		_coreFlexAreaTourBenefitsPage = this.getCoreFlexAreaTourBenefitsPage();
		_coreFlexHomeLeaveBenefitsPage = this.getCoreFlexHomeLeaveBenefitsPage();
		_coreFlexAirportPickupBenefitsPage = this.getCoreFlexAirportPickupBenefitsPage();
		_coreFlexPreAcceptanceServicesBenefitsPage = this.getCoreFlexPreAcceptanceServicesBenefitsPage();
		_coreFlexFurnitureRentalBenefitsPage = this.getCoreFlexFurnitureRentalBenefitsPage();
		_coreFlexAutoRentalDuringAssignmentBenefitsPage = this.getCoreFlexAutoRentalDuringAssignmentBenefitsPage();
		_coreFlexEducationAssistanceBenefitsPage = this.getCoreFlexEducationAssistanceBenefitsPage();
		_coreFlexHouseHuntingTripBenefitsPage = this.getCoreFlexHouseHuntingTripBenefitsPage();
		_coreFlexAirShipmentBenefitsPage = this.getCoreFlexAirShipmentBenefitsPage();
		_coreFlexAutoShipmentBenefitsPage = this.getCoreFlexAutoShipmentBenefitsPage();
		_coreFlexSeaSurfaceShipmentBenefitsPage = this.getCoreFlexSeaSurfaceShipmentBenefitsPage();
		_coreFlexInlandShipmentBenefitsPage = this.getCoreFlexInlandShipmentBenefitsPage();
		_coreFlexPetShipmentBenefitsPage = this.getCoreFlexPetShipmentBenefitsPage();
		_coreFlexPermanentStorageBenefitsPage = this.getCoreFlexPermanentStorageBenefitsPage();
	}
	
	public MX_Client_AuthorizationHome_CollaborationPage getMXClientAuthCollaborationPage() {
		return (_mxClientAuthCollaborationPage == null)
				? _mxClientAuthCollaborationPage = new MX_Client_AuthorizationHome_CollaborationPage(_driver)
				: _mxClientAuthCollaborationPage;
	}
	
	public MX_Client_AuthWorkflow_ApprovalActionPage getMXClientAuthWFApprovalActionPage() {
		return (_mxClientAuthWFApprovalActionPage == null)
				? _mxClientAuthWFApprovalActionPage = new MX_Client_AuthWorkflow_ApprovalActionPage(_driver)
				: _mxClientAuthWFApprovalActionPage;
	}	
}