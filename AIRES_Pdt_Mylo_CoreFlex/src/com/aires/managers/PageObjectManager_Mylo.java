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

import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;


public class PageObjectManager_Mylo {

	private WebDriver _driver;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _dashboardHomePage;

	public PageObjectManager_Mylo(WebDriver driver) {
		this._driver = driver;
	}
	
	public Mylo_LoginPage getLoginPage() {
		return (_loginPage == null) ? _loginPage = new Mylo_LoginPage(_driver) : _loginPage;
	}
	
	public Mylo_DashboardHomePage getDashboardHomePage() {
		return (_dashboardHomePage == null) ? _dashboardHomePage = new Mylo_DashboardHomePage(_driver)
				: _dashboardHomePage;
	}
}