package com.aires.pages.mobilityx;

import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class MobilityX_LoginPage extends Base {
	
	// Mobility Login Page Locators
	@FindBy(how = How.CSS, using = "img[id*='logoicon']")
	private WebElement _img_AIRESLogo;
	
	@FindBy(how = How.CSS, using = "div#nextButton")
	private WebElement _btnNext;
	
	@FindBy(how = How.CSS, using = "input[id='username::content']")
	private WebElement _inputUserName;	

	@FindBy(how = How.CSS, using = "input[id='password::content']")
	private WebElement _inputPassword;
	
	@FindBy(how = How.CSS, using = "div#loginButton")
	private WebElement _btnLogin;
	
	@FindBy(how = How.ID, using = "cookiePupupButtonId")
	private WebElement _btnOkOnSiteCookieAfterLogin;
	
	@FindBy(how = How.CSS, using = "span[id$='openUserProfileText']")
	private WebElement _txtUserNameTitle;	
	
	public MobilityX_LoginPage(WebDriver driver) {
		super(driver);
	}

	public void openApplication() {
		try {
			CoreFunctions.waitForBrowserToLoad(driver);
			VerifyAIRESLogo();
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btnNext, _btnNext.getText());
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL, MobilityXConstants.APPLICATION_FAILED_TO_LAUNCH));
		}
	}
	
	/**
	 * Verify Aires Logo on MobilityX Login Page
	 */
	public void VerifyAIRESLogo() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _img_AIRESLogo, MobilityXConstants.AIRESLOGO_TEXT);
			Assert.assertTrue(CoreFunctions.isElementVisible(_img_AIRESLogo), MobilityXConstants.AIRES_LOGO_NOT_DISPLAYED);
			CoreFunctions.highlightObject(driver, _img_AIRESLogo);
			Reporter.addStepLog(MessageFormat.format(CoreConstants.PASS, MobilityXConstants.AIRES_LOGO_DISPLAYED));
		} catch (Exception e) {
			Assert.fail((MessageFormat.format(CoreConstants.FAIL, MobilityXConstants.AIRES_LOGO_NOT_DISPLAYED)));
		}
	}
	
	public void enterUsernameAndPasswordForMobilityX(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
					_inputUserName.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputUserName, _inputUserName.getAttribute("name"), userName);
			CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getText());
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputPassword,
					_inputPassword.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputPassword, _inputPassword.getAttribute("name"), password);
		} catch (Exception e) {
			Assert.fail(MobilityXConstants.FAILED_TO_ENTER_LOGIN_CREDENTIALS);
		}
	}
	
	public void clickSignIn() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btnLogin, _btnLogin.getText());
		CoreFunctions.clickUsingJS(driver, _btnLogin, _btnLogin.getText());
	}
	
	public void handle_Cookie_AfterLogin() {
		if (CoreFunctions.isElementExist(driver, _btnOkOnSiteCookieAfterLogin, MYLOConstants.CUSTOM_WAIT_TIME)) {
			HandleCookiePopUp(_btnOkOnSiteCookieAfterLogin);
		}
	}
	
	public void HandleCookiePopUp(WebElement element) {
		Boolean isExists;
		isExists = CoreFunctions.verifyElementPresentOnPage(element, MobilityXConstants.DAILOG_SITECOOKIE);
		if (isExists) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, MobilityXConstants.DAILOG_SITECOOKIE);
			CoreFunctions.click(driver, element, MobilityXConstants.COOKIEDAILOG_OKBUTTON);
			Log.info(MobilityXConstants.VERIFIED + MobilityXConstants.DAILOG_SITECOOKIE + MobilityXConstants.IS_DISPLAYED
					+ MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
		} else
			Log.info(MobilityXConstants.SITE_COOKIE_DIALOG_NOT_DISPLAY);
	}
	
	public Boolean verifyUserlogin(String profileName) {
		Boolean isExists = false;
		if (CoreFunctions.isElementExist(driver, _txtUserNameTitle, MYLOConstants.CUSTOM_WAIT_TIME)
				&& _txtUserNameTitle.getText().equalsIgnoreCase(profileName)) {
			isExists = true;
			Reporter.addStepLog(CoreConstants.PASS + MobilityXConstants.VERIFIED + MobilityXConstants.USER_NAME
					+ CoreConstants.IS_DISPLAYED_AS + _txtUserNameTitle.getText()
					+ MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
		} else {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.USER_NAME_NOT_EXIST, CoreConstants.FAIL, profileName));
		}
		return isExists;
	}
}
