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

import com.aires.pages.mylo.MyloJourneyPage_AccountingQuerySection;
import com.aires.pages.mylo.MyloJourneyPage_AddressSection;
import com.aires.pages.mylo.MyloJourneyPage_AdvancedQuerySection;
import com.aires.pages.mylo.MyloJourneyPage_AuthTrackSection;
import com.aires.pages.mylo.MyloJourneyPage_ClientContactSection;
import com.aires.pages.mylo.MyloJourneyPage_CreateNewFileSection;
import com.aires.pages.mylo.MyloJourneyPage_DependentSection;
import com.aires.pages.mylo.MyloJourneyPage_FileTeamSection;
import com.aires.pages.mylo.MyloJourneyPage_IdentityChallengeSection;
import com.aires.pages.mylo.MyloJourneyPage_OtherSection;
import com.aires.pages.mylo.MyloJourneyPage_PartnerSection;
import com.aires.pages.mylo.MyloJourneyPage_QueryBySubServiceID;
import com.aires.pages.mylo.MyloJourneyPage_SendLoginCredentials;
import com.aires.pages.mylo.MyloJourneyPage_TaxReportingSection;
import com.aires.pages.mylo.MyloJourneyPage_TeamPostSection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeNameQuerySection;
import com.aires.pages.mylo.MyloJourneyPage_TransfereeSection;
import com.aires.pages.mylo.Mylo_AssignmentPage;
import com.aires.pages.mylo.Mylo_DashboardHomePage;
import com.aires.pages.mylo.Mylo_JourneyPage;
import com.aires.pages.mylo.Mylo_LoginPage;
import com.aires.pages.mylo.Mylo_RestApiRequest;
import com.aires.utilities.MyloNewFileUtil;

public class PageObjectManager_Mylo {

	private WebDriver _driver;
	private Mylo_LoginPage _loginPage;
	private Mylo_DashboardHomePage _dashboardHomePage;
	private Mylo_AssignmentPage _assignmentPage;
	private MyloJourneyPage_TransfereeSection _journeyTransfereeSection;
	private MyloJourneyPage_PartnerSection _journeyPartnerSection;
	private MyloJourneyPage_DependentSection _journeyDependentSection;
	private MyloJourneyPage_OtherSection _journeyOtherSection;
	private MyloJourneyPage_CreateNewFileSection _journeyCreateNewFileSection;
	private Mylo_RestApiRequest _restApiRequest;
	private Mylo_JourneyPage _journeyPage;
	private MyloJourneyPage_IdentityChallengeSection _journeyIdentityChallengeSection;
	private MyloJourneyPage_SendLoginCredentials _journeySendLoginCredentials;
	private MyloJourneyPage_AuthTrackSection _journeyAuthTrackSection;
	private MyloJourneyPage_TaxReportingSection _journeyPageTaxReportingSection;
	private MyloJourneyPage_AddressSection _journeyPage_AddressSection;
	private MyloJourneyPage_TeamPostSection _journeyPage_TeamPostSection;
	private MyloJourneyPage_AccountingQuerySection _journeyPage_AccountingQuerySection;
	private MyloJourneyPage_AdvancedQuerySection _journeyPage_AdvancedQuerySection;
	private MyloJourneyPage_FileTeamSection _journeyPage_FileTeamSection;
	private MyloJourneyPage_TransfereeNameQuerySection _journeyPage_TransfereeNameQuerySection;	
	private MyloJourneyPage_QueryBySubServiceID _journeyPage_QueryBySubServiceID;
	private MyloJourneyPage_ClientContactSection _journeyPage_ClientContactSection;	
	private MyloNewFileUtil _myloNewFileUtil;

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
		return (_assignmentPage == null) ? _assignmentPage = new Mylo_AssignmentPage(_driver) : _assignmentPage;
	}

	public Mylo_JourneyPage getJourneyPage() {
		return (_journeyPage == null) ? _journeyPage = new Mylo_JourneyPage(_driver) : _journeyPage;
	}

	public Mylo_RestApiRequest getRestApiRequest() {
		return (_restApiRequest == null) ? _restApiRequest = new Mylo_RestApiRequest(_driver) : _restApiRequest;
	}

	public MyloJourneyPage_TransfereeSection getJourneyPageTransfereeSection() {
		return (_journeyTransfereeSection == null)
				? _journeyTransfereeSection = new MyloJourneyPage_TransfereeSection(_driver)
				: _journeyTransfereeSection;
	}

	public MyloJourneyPage_PartnerSection getJourneyPagePartnerSection() {
		return (_journeyPartnerSection == null) ? _journeyPartnerSection = new MyloJourneyPage_PartnerSection(_driver)
				: _journeyPartnerSection;
	}

	public MyloJourneyPage_DependentSection getJourneyPageDependentSection() {
		return (_journeyDependentSection == null)
				? _journeyDependentSection = new MyloJourneyPage_DependentSection(_driver)
				: _journeyDependentSection;
	}

	public MyloJourneyPage_OtherSection getJourneyPageOtherSection() {
		return (_journeyOtherSection == null) ? _journeyOtherSection = new MyloJourneyPage_OtherSection(_driver)
				: _journeyOtherSection;
	}

	public MyloJourneyPage_CreateNewFileSection getJourneyPageCreateNewFileSection() {
		return (_journeyCreateNewFileSection == null)
				? _journeyCreateNewFileSection = new MyloJourneyPage_CreateNewFileSection(_driver)
				: _journeyCreateNewFileSection;
	}

	public MyloJourneyPage_IdentityChallengeSection getJourneyPageIdentityChallengeSection() {
		return (_journeyIdentityChallengeSection == null)
				? _journeyIdentityChallengeSection = new MyloJourneyPage_IdentityChallengeSection(_driver)
				: _journeyIdentityChallengeSection;
	}

	public MyloJourneyPage_SendLoginCredentials getJourneyPageSendLoginCredential() {
		return (_journeySendLoginCredentials == null)
				? _journeySendLoginCredentials = new MyloJourneyPage_SendLoginCredentials(_driver)
				: _journeySendLoginCredentials;
	}

	public MyloJourneyPage_AuthTrackSection getJourneyPageAuthTrackSection() {
		return (_journeyAuthTrackSection == null)
				? _journeyAuthTrackSection = new MyloJourneyPage_AuthTrackSection(_driver)
				: _journeyAuthTrackSection;
	}

	public MyloJourneyPage_TaxReportingSection getJourneyPageTaxReportingSection() {
		return (_journeyPageTaxReportingSection == null)
				? _journeyPageTaxReportingSection = new MyloJourneyPage_TaxReportingSection(_driver)
				: _journeyPageTaxReportingSection;
	}

	public MyloJourneyPage_AddressSection getJourneyPageAddressSection() {
		return (_journeyPage_AddressSection == null)
				? _journeyPage_AddressSection = new MyloJourneyPage_AddressSection(_driver)
				: _journeyPage_AddressSection;
	}

	public MyloJourneyPage_TeamPostSection getJourneyPageTeamPostSection() {
		return (_journeyPage_TeamPostSection == null)
				? _journeyPage_TeamPostSection = new MyloJourneyPage_TeamPostSection(_driver)
				: _journeyPage_TeamPostSection;
	}

	public MyloNewFileUtil getMyloNewFileUtil() {
		return (_myloNewFileUtil == null) ? _myloNewFileUtil = new MyloNewFileUtil() : _myloNewFileUtil;
	}

	public MyloJourneyPage_AccountingQuerySection getJourneyAccountingQuery() {
		return (_journeyPage_AccountingQuerySection == null)
				? _journeyPage_AccountingQuerySection = new MyloJourneyPage_AccountingQuerySection(_driver)
				: _journeyPage_AccountingQuerySection;
	}
	
	public MyloJourneyPage_TransfereeNameQuerySection getJourneyTransfereeNameQuery() {
		return (_journeyPage_TransfereeNameQuerySection == null)
				? _journeyPage_TransfereeNameQuerySection = new MyloJourneyPage_TransfereeNameQuerySection(_driver)
				: _journeyPage_TransfereeNameQuerySection;
	}
	
	public MyloJourneyPage_ClientContactSection getJourneyClientContact() {
		return (_journeyPage_ClientContactSection == null)
				? _journeyPage_ClientContactSection = new MyloJourneyPage_ClientContactSection(_driver)
				: _journeyPage_ClientContactSection;
	}

	public MyloJourneyPage_AdvancedQuerySection getJourneyAdvancedQuery() {
		return (_journeyPage_AdvancedQuerySection == null)
				? _journeyPage_AdvancedQuerySection = new MyloJourneyPage_AdvancedQuerySection(_driver)
				: _journeyPage_AdvancedQuerySection;
	}

	public MyloJourneyPage_FileTeamSection getJourneyFileTeam() {
		return (_journeyPage_FileTeamSection == null)
				? _journeyPage_FileTeamSection = new MyloJourneyPage_FileTeamSection(_driver)
				: _journeyPage_FileTeamSection;
	}
	
	public MyloJourneyPage_QueryBySubServiceID getJourneyQueryBySubServiceID() {
		return (_journeyPage_QueryBySubServiceID == null) ? _journeyPage_QueryBySubServiceID = new MyloJourneyPage_QueryBySubServiceID(_driver)
				: _journeyPage_QueryBySubServiceID;
	}
}