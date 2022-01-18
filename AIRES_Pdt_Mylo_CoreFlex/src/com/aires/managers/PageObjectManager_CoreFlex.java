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

import com.aires.pages.coreflex.CoreFlex_FlexPolicySetupPage;


public class PageObjectManager_CoreFlex {

	private WebDriver _driver;
	private CoreFlex_FlexPolicySetupPage _flexPolicySetupPage;
//	private CoreFlex_PolicyBenefitsCategoriesPage _coreFlexPolicyBenefitsCategoriesPage;
//	private CoreFlex_DuplicateHousing_BenefitsPage _coreFlexDuplicateHousingBenefitsPage;
//	private CoreFlex_LumpSum_BenefitsPage _coreFlexLumpSumBenefitsPage;
//	private CoreFlex_BenefitSummaryPage _coreFlexBenefitsSummaryPage;
//	private CoreFlex_CustomBundlesPage _coreFlexCustomBundlesPage;

	public PageObjectManager_CoreFlex(WebDriver driver) {
		this._driver = driver;
	}	
	
	public CoreFlex_FlexPolicySetupPage getFlexPolicySetupPage() {
		return (_flexPolicySetupPage == null) ? _flexPolicySetupPage = new CoreFlex_FlexPolicySetupPage(_driver) : _flexPolicySetupPage;
	}
	
//	public CoreFlex_PolicyBenefitsCategoriesPage getCoreFlexPolicyBenefitsCategoriesPage() {
//		return (_coreFlexPolicyBenefitsCategoriesPage == null) ? _coreFlexPolicyBenefitsCategoriesPage = new CoreFlex_PolicyBenefitsCategoriesPage(_driver) : _coreFlexPolicyBenefitsCategoriesPage;
//	}
//	
//	public CoreFlex_DuplicateHousing_BenefitsPage getCoreFlexDuplicateHousingBenefitsPage() {
//		return (_coreFlexDuplicateHousingBenefitsPage == null) ? _coreFlexDuplicateHousingBenefitsPage = new CoreFlex_DuplicateHousing_BenefitsPage(_driver) : _coreFlexDuplicateHousingBenefitsPage;
//	}
//	
//	public CoreFlex_LumpSum_BenefitsPage getCoreFlexLumpSumBenefitsPage() {
//		return (_coreFlexLumpSumBenefitsPage == null) ? _coreFlexLumpSumBenefitsPage = new CoreFlex_LumpSum_BenefitsPage(_driver) : _coreFlexLumpSumBenefitsPage;
//	}
//	
//	public CoreFlex_BenefitSummaryPage getCoreFlexBenefitSummaryPage() {
//		return (_coreFlexBenefitsSummaryPage == null) ? _coreFlexBenefitsSummaryPage = new CoreFlex_BenefitSummaryPage(_driver) : _coreFlexBenefitsSummaryPage;
//	}
//	
//	public CoreFlex_CustomBundlesPage getCoreFlexCustomBundlesPage() {
//		return (_coreFlexCustomBundlesPage == null) ? _coreFlexCustomBundlesPage = new CoreFlex_CustomBundlesPage(_driver) : _coreFlexCustomBundlesPage;
//	}
}