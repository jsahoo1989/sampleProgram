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

import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
//import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_LoginPage;


public class PageObjectManager_Mylo {

	private WebDriver _driver;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _dashboardHomePage;
	private Mylo_AssignmentPage _assignmentPage; 
	private MyloJourneyPage_TransfereeSection _journeyTransfereeSection;
	//private Mylo_RestApiRequest _restApiRequest;

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
	
	
	 public Mylo_AssignmentPage getAssignmentPage() {
		return (_assignmentPage == null) ? _assignmentPage = new Mylo_AssignmentPage(_driver)
				: _assignmentPage;
	}
	 
	/* public Mylo_RestApiRequest getRestApiRequest() {
			return (_restApiRequest == null) ? _restApiRequest = new Mylo_RestApiRequest(_driver)
					: _restApiRequest;
		}*/
	 public MyloJourneyPage_TransfereeSection getJourneyPageTransfereeSection() {
			return (_journeyTransfereeSection == null) ? _journeyTransfereeSection = new MyloJourneyPage_TransfereeSection(_driver)
					: _journeyTransfereeSection;
		}
}