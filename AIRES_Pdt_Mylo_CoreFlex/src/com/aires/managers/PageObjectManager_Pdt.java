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

import com.aires.pages.pdt.PDT_LoginPage;
import com.aires.pages.pdt.PDT_ViewPolicyPage;

public class PageObjectManager_Pdt {

	private WebDriver _driver;
	private PDT_LoginPage _loginPage;
	private PDT_ViewPolicyPage _viewPolicyPage;

	public PageObjectManager_Pdt(WebDriver driver) {
		this._driver = driver;
	}
	
	public PDT_LoginPage getLoginPage() {
		return (_loginPage == null) ? _loginPage = new PDT_LoginPage(_driver) : _loginPage;
	}
	
	public PDT_ViewPolicyPage getViewPolicyPage() {
		return (_viewPolicyPage == null) ? _viewPolicyPage = new PDT_ViewPolicyPage(_driver) : _viewPolicyPage;
	}	
	
}