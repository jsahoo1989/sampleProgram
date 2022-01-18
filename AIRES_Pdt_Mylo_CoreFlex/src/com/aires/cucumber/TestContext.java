/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 19/04/2020			 Rahul Sharma					 Sharing data between steps in cucumber
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.cucumber;

import com.aires.managers.PageObjectManager_Mylo;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;

public class TestContext {
	private WebDriverManager _webDriverManager;
	private PageObjectManager_Pdt _pageObjectManagerPDT;	
	private PageObjectManager_Mylo _pageObjectManagerMylo;
	
	public TestContext() throws Exception {
		
	}
	
	public void initializeWebManager()throws Exception {		
		_webDriverManager = new WebDriverManager(); 
		_pageObjectManagerPDT = new PageObjectManager_Pdt(_webDriverManager.getDriver());
		_pageObjectManagerMylo = new PageObjectManager_Mylo(_webDriverManager.getDriver());
			
	}

	public WebDriverManager getWebDriverManager() { return _webDriverManager; }
	public PageObjectManager_Pdt getPageObjectManager() { return _pageObjectManagerPDT; }
	public PageObjectManager_Mylo getMyloPageObjectManager() {return _pageObjectManagerMylo;
	}
}