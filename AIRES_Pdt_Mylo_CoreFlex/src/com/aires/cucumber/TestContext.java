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

import java.text.MessageFormat;

import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.IrisPageManager;
import com.aires.managers.PageObjectManager_CoreFlex;
import com.aires.managers.PageObjectManager_MobilityX;
import com.aires.managers.PageObjectManager_Mylo;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.aires.pages.iris.basepage.BasePage;
import com.aires.utilities.CustomSoftAssert;
import com.hp.lft.sdk.GeneralLeanFtException;

public class TestContext {
	private WebDriverManager _webDriverManager;
	private PageObjectManager_Pdt _pageObjectManagerPDT;
	private PageObjectManager_Mylo _pageObjectManagerMylo;
	private PageObjectManager_CoreFlex _pageObjectManagerCoreFlex;
	private PageObjectManager_MobilityX _pageObjectManagerMobilityX;
	private BasePage _basePage;
	private IrisPageManager _irisPageManager;
	private String browserTitle;	
	private CustomSoftAssert _customSoftAssert;

	public TestContext() throws Exception {
		_basePage = new BasePage();
		_irisPageManager = new IrisPageManager(browserTitle);
	}

	public void initializeWebManager(boolean isIrisTestCase) throws Exception {

		if (!isIrisTestCase) {
			_webDriverManager = new WebDriverManager();
			_pageObjectManagerPDT = new PageObjectManager_Pdt(_webDriverManager.getDriver());
			_pageObjectManagerMylo = new PageObjectManager_Mylo(_webDriverManager.getDriver());
			_pageObjectManagerCoreFlex = new PageObjectManager_CoreFlex(_webDriverManager.getDriver());
			_customSoftAssert = new CustomSoftAssert();
			_pageObjectManagerMobilityX = new PageObjectManager_MobilityX(_webDriverManager.getDriver());	
		}
	}
	
	public void initializeWebManager(String appName) {
		_webDriverManager = new WebDriverManager();
		_customSoftAssert = new CustomSoftAssert();
		switch(appName) {
		case PDTConstants.APPLICATION_PDT:
			_pageObjectManagerPDT = new PageObjectManager_Pdt(_webDriverManager.getDriver());
			break;
		case PDTConstants.APPLICATION_MYLO:
			_pageObjectManagerMylo = new PageObjectManager_Mylo(_webDriverManager.getDriver());
			break;
		case PDTConstants.APPLICATION_COREFLEX:
			_pageObjectManagerCoreFlex = new PageObjectManager_CoreFlex(_webDriverManager.getDriver());
			break;
		case PDTConstants.APPLICATION_MOBILITYX:
			_pageObjectManagerMobilityX = new PageObjectManager_MobilityX(_webDriverManager.getDriver());
			break;
		case PDTConstants.APPLICATION_IRIS:
			try {
				getBasePage().invokeIrisApplication();
			} catch (Exception e) {
				Assert.fail("Failed to invoke IRIS application");
			}
			try {
				getBasePage().killExistingBrowsers();
			} catch (GeneralLeanFtException e) {
				Assert.fail("Failed to kill existing browsers");
			}
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.INVALID_APP, CoreConstants.FAIL, appName));
		}
	}

	public WebDriverManager getWebDriverManager() {
		return _webDriverManager;
	}

	public PageObjectManager_Pdt getPageObjectManager() {
		return _pageObjectManagerPDT;
	}
	
	public PageObjectManager_CoreFlex getCoreFlexPageObjectManager() {
		return _pageObjectManagerCoreFlex;
	}

	public PageObjectManager_Mylo getMyloPageObjectManager() {
		return _pageObjectManagerMylo;
	}

	public BasePage getBasePage() {
		return _basePage;
	}

	public IrisPageManager getIrisPageManager() {
		return _irisPageManager;
	}
	
	public PageObjectManager_MobilityX getMobilityXPageObjectManager() {
		return _pageObjectManagerMobilityX;
	}
	
	public CustomSoftAssert getSoftAssertObject() {
		return _customSoftAssert;
	}
}