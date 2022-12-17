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
import com.aires.pages.PDT_Mylo_CoreFlex_Common_LoginPage;
import com.aires.pages.coreflex.CoreFlex_BluePrint_LoginPage;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_AssignmentHousingPage;
import com.aires.pages.pdt.PDT_CompensationServicesPage;
import com.aires.pages.pdt.PDT_CulturalTrainingPage;
import com.aires.pages.pdt.PDT_DestinationServicesPage;
import com.aires.pages.pdt.PDT_DuplicateHousingPage;
import com.aires.pages.pdt.PDT_FinalMovePage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.pages.pdt.PDT_HomeLeavePage;
import com.aires.pages.pdt.PDT_HomePurchasePage;
import com.aires.pages.pdt.PDT_HouseHoldGoodsPage;
import com.aires.pages.pdt.PDT_HouseHuntingTripPage;
import com.aires.pages.pdt.PDT_ImmigrationPage;
import com.aires.pages.pdt.PDT_LanguageTrainingPage;
import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_OneTimePaymentReimbursemenPage;
import com.aires.pages.pdt.PDT_OngoingPaymentReimbursementPage;
import com.aires.pages.pdt.PDT_PolicyAssignmentPage;
import com.aires.pages.pdt.PDT_PolicyBenefitCategoryPage;
import com.aires.pages.pdt.PDT_PreAcceptanceService;
import com.aires.pages.pdt.PDT_PropertyManagementPage;
import com.aires.pages.pdt.PDT_RentalAssistancePage;
import com.aires.pages.pdt.PDT_SharedSubBenefitPage;
import com.aires.pages.pdt.PDT_TemporaryLivingPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

public class PageObjectManager_Pdt {

	private WebDriver _driver;
	private PDT_LoginPage _loginPage;
	private PDT_ViewPolicyPage _viewPolicyPage;
	private PDT_AddNewPolicyPage _addNewPolicyPage;
	private PDT_GeneralInformationPage _generalInfoPage;
	private PDT_PolicyBenefitCategoryPage _policyBenefitCategoryPage;
	private PDT_PreAcceptanceService _pdtPreAcceptanceServicePage;
	private PDT_ImmigrationPage _pdtImmigrationPage;
	private PDT_SharedSubBenefitPage _sharedSubBenefitPage;
	private PDT_HouseHuntingTripPage _houseHuntingTripPage;
	private PDT_LanguageTrainingPage _languageTrainingPage;
	private PDT_CulturalTrainingPage _culturalTrainingPage;
	private PDT_FinalMovePage _finalMovePage;
	private PDT_HomeLeavePage _homeLeavePage;
	private PDT_TemporaryLivingPage _temporaryLivingPage;
	private PDT_DestinationServicesPage _destinationServicesPage;
	private PDT_RentalAssistancePage _rentalAssistancePage;
	private PDT_AssignmentHousingPage _assignmentHousingPage;
	private PDT_CompensationServicesPage _compensationServicesPage;
	private PDT_DuplicateHousingPage _duplicateHousingPage;
	private PDT_OneTimePaymentReimbursemenPage _oneTimePaymentPage;
	private PDT_OngoingPaymentReimbursementPage _ongoingPaymentReimbursementPage;
	private PDT_Mylo_CoreFlex_Common_LoginPage _commonLoginPage;
	private PDT_PropertyManagementPage _propertyManagementPage;
	private PDT_HomePurchasePage _homePurchasePage;
	private CoreFlex_BluePrint_LoginPage _bluePrintCFLoginPage;
	private PDT_HouseHoldGoodsPage _houseHoldGoodsPage;
	private PDT_PolicyAssignmentPage _policyAssigmentPage;
	
	public PageObjectManager_Pdt(WebDriver driver) {
		this._driver = driver;
	}
	
	public PDT_LoginPage getLoginPage() {
		return (_loginPage == null) ? _loginPage = new PDT_LoginPage(_driver) : _loginPage;
	}
	
	public PDT_ViewPolicyPage getViewPolicyPage() {
		return (_viewPolicyPage == null) ? _viewPolicyPage = new PDT_ViewPolicyPage(_driver) : _viewPolicyPage;
	}
	
	public PDT_AddNewPolicyPage getAddNewPolicyPage() {
		return (_addNewPolicyPage == null) ? _addNewPolicyPage = new PDT_AddNewPolicyPage(_driver) : _addNewPolicyPage;
	}
	
	public PDT_GeneralInformationPage getGeneralInfoPage() {
		return (_generalInfoPage == null) ? _generalInfoPage = new PDT_GeneralInformationPage(_driver) : _generalInfoPage;
	}
	
	public PDT_PolicyBenefitCategoryPage getpolicyBenefitCategoryPage() {
		return (_policyBenefitCategoryPage == null) ? _policyBenefitCategoryPage = new PDT_PolicyBenefitCategoryPage(_driver) : _policyBenefitCategoryPage;
	}
	
	public PDT_PreAcceptanceService getPreAcceptanceServicePage() {
		return (_pdtPreAcceptanceServicePage == null) ? _pdtPreAcceptanceServicePage = new PDT_PreAcceptanceService(_driver) : _pdtPreAcceptanceServicePage;
	}
	
	public PDT_ImmigrationPage getImmigrationPage() {
		return (_pdtImmigrationPage == null) ? _pdtImmigrationPage = new PDT_ImmigrationPage(_driver) : _pdtImmigrationPage;
	}
	
	public PDT_SharedSubBenefitPage getSharedSubBenefitPage() {
		return (_sharedSubBenefitPage == null) ? _sharedSubBenefitPage = new PDT_SharedSubBenefitPage(_driver) : _sharedSubBenefitPage;
	}
	
	public PDT_HouseHuntingTripPage getHouseHuntingTripPage() {
		return (_houseHuntingTripPage == null ) ? _houseHuntingTripPage = new PDT_HouseHuntingTripPage(_driver) : _houseHuntingTripPage;
	}
	
	public PDT_LanguageTrainingPage getLanguageTrainingPage() {
		return (_languageTrainingPage == null ) ? _languageTrainingPage = new PDT_LanguageTrainingPage(_driver) : _languageTrainingPage;
	}
	
	public PDT_CulturalTrainingPage getCulturalTrainingPage() {
		return (_culturalTrainingPage == null ) ? _culturalTrainingPage = new PDT_CulturalTrainingPage(_driver) : _culturalTrainingPage;
	}
	
	public PDT_FinalMovePage getFinalMovePage() {
		return (_finalMovePage == null ) ? _finalMovePage = new PDT_FinalMovePage(_driver) : _finalMovePage;
	}
	
	public PDT_HomeLeavePage getHomeLeavePage() {
		return (_homeLeavePage == null ) ? _homeLeavePage = new PDT_HomeLeavePage(_driver) : _homeLeavePage;
	}
	
	public PDT_TemporaryLivingPage getTemporaryLivingPage() {
		return (_temporaryLivingPage == null ) ? _temporaryLivingPage = new PDT_TemporaryLivingPage(_driver) : _temporaryLivingPage;
	}
	
	public PDT_DestinationServicesPage getDestinationServicesPage() {
		return (_destinationServicesPage == null ) ? _destinationServicesPage = new PDT_DestinationServicesPage(_driver) : _destinationServicesPage;
	}
	
	public PDT_AssignmentHousingPage getAssignmentHousingPage() {
		return (_assignmentHousingPage == null ) ? _assignmentHousingPage = new PDT_AssignmentHousingPage(_driver) : _assignmentHousingPage;
	}
	
	public PDT_RentalAssistancePage getRentalAssistancePage() {
		return (_rentalAssistancePage == null ) ? _rentalAssistancePage = new PDT_RentalAssistancePage(_driver) : _rentalAssistancePage;
	}
	
	public PDT_CompensationServicesPage getCompensationServicesPage() {
		return (_compensationServicesPage == null ) ? _compensationServicesPage = new PDT_CompensationServicesPage(_driver) : _compensationServicesPage;
	}
	
	public PDT_DuplicateHousingPage getDuplicateHousingPage() {
		return (_duplicateHousingPage == null ) ? _duplicateHousingPage = new PDT_DuplicateHousingPage(_driver) : _duplicateHousingPage;
	}
	
	public PDT_OneTimePaymentReimbursemenPage getOneTimePaymentPage() {
		return (_oneTimePaymentPage == null ) ? _oneTimePaymentPage = new PDT_OneTimePaymentReimbursemenPage(_driver) : _oneTimePaymentPage;
	}
	
	public PDT_OngoingPaymentReimbursementPage getOngoingPaymentReimbursementPage() {
		return (_ongoingPaymentReimbursementPage == null ) ? _ongoingPaymentReimbursementPage = new PDT_OngoingPaymentReimbursementPage(_driver) : _ongoingPaymentReimbursementPage;
	}
	
	public PDT_Mylo_CoreFlex_Common_LoginPage getCommonLoginPage() {
		return (_commonLoginPage == null ) ? _commonLoginPage = new PDT_Mylo_CoreFlex_Common_LoginPage(_driver) : _commonLoginPage;
	}
	
	public PDT_PropertyManagementPage getPropertyManagementPage() {
		return (_propertyManagementPage == null ) ? _propertyManagementPage = new PDT_PropertyManagementPage(_driver) : _propertyManagementPage;
	}
	
	public PDT_HomePurchasePage getHomePurchasePage() {
		return (_homePurchasePage == null ) ? _homePurchasePage = new PDT_HomePurchasePage(_driver) : _homePurchasePage;
	}

	public CoreFlex_BluePrint_LoginPage getBluePrintCoreFlexLoginPage() {
		return (_bluePrintCFLoginPage == null ) ? _bluePrintCFLoginPage = new CoreFlex_BluePrint_LoginPage(_driver) : _bluePrintCFLoginPage;
	}
	
	public PDT_HouseHoldGoodsPage getHouseHoldGoodsPage() {
		return (_houseHoldGoodsPage == null ) ? _houseHoldGoodsPage = new PDT_HouseHoldGoodsPage(_driver) : _houseHoldGoodsPage;
	}
	
	public PDT_PolicyAssignmentPage getPolicyAssignmentPage() {
		return (_policyAssigmentPage == null ) ? _policyAssigmentPage = new PDT_PolicyAssignmentPage(_driver) : _policyAssigmentPage;
	}
}