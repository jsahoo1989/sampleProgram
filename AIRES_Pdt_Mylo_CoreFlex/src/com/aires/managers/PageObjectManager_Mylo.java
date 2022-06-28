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

import com.aires.pages.mylo.MyloJourneyPage_DependentSection;
import com.aires.pages.mylo.MyloJourneyPage_OtherSection;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
//import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.pages.mylo.Mylo_RestApiRequest;


public class PageObjectManager_Mylo {

	private WebDriver _driver;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _dashboardHomePage;
	private Mylo_AssignmentPage _assignmentPage; 
	private MyloJourneyPage_TransfereeSection _journeyTransfereeSection;
	private MyloJourneyPage_PartnerSection _journeyPartnerSection;
	private MyloJourneyPage_DependentSection _journeyDependentSection;
	private MyloJourneyPage_OtherSection _journeyOtherSection;
	private Mylo_RestApiRequest _restApiRequest;
	private Mylo_JourneyPage _journeyPage;

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
	 
	 public Mylo_JourneyPage getJourneyPage() {
			return (_journeyPage == null) ? _journeyPage = new Mylo_JourneyPage(_driver)
					: _journeyPage;
		}
	 
	public Mylo_RestApiRequest getRestApiRequest() {
			return (_restApiRequest == null) ? _restApiRequest = new Mylo_RestApiRequest(_driver)
					: _restApiRequest;
		}
	
	 public MyloJourneyPage_TransfereeSection getJourneyPageTransfereeSection() {
			return (_journeyTransfereeSection == null) ? _journeyTransfereeSection = new MyloJourneyPage_TransfereeSection(_driver)
					: _journeyTransfereeSection;
		}
	 public MyloJourneyPage_PartnerSection getJourneyPagePartnerSection() {
			return (_journeyPartnerSection == null) ? _journeyPartnerSection = new MyloJourneyPage_PartnerSection(_driver)
					: _journeyPartnerSection;
		}
	 public MyloJourneyPage_DependentSection getJourneyPageDependentSection() {
			return (_journeyDependentSection == null) ? _journeyDependentSection = new MyloJourneyPage_DependentSection(_driver)
					: _journeyDependentSection;
		}
	 public MyloJourneyPage_OtherSection getJourneyPageOtherSection() {
			return (_journeyOtherSection == null) ? _journeyOtherSection = new MyloJourneyPage_OtherSection(_driver)
					: _journeyOtherSection;
		}
}