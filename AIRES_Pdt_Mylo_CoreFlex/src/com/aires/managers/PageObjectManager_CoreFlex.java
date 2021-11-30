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

	public PageObjectManager_CoreFlex(WebDriver driver) {
		this._driver = driver;
	}	
	
	public CoreFlex_FlexPolicySetupPage getFlexPolicySetupPage() {
		return (_flexPolicySetupPage == null) ? _flexPolicySetupPage = new CoreFlex_FlexPolicySetupPage(_driver) : _flexPolicySetupPage;
	}
}