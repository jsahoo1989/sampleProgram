package com.aires.pages.coreflex;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.TransfereeSubmissions_LoginData;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class TransfereeSubmissions_LoginPage extends Base {

	public TransfereeSubmissions_LoginPage(WebDriver driver) {
		super(driver);
	}

	// Login Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Login')]")
	private WebElement _buttonLogin;

	// UserName Input Field
	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement _inputUserEmail;

	// Next Button
	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _buttonNext;

	// SignIn Button
	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _buttonSignIn;

	// Password Input Field
	@FindBy(how = How.CSS, using = "input[type='password']")
	private WebElement _inputPassword;

	// AIRES Logo Image
	@FindBy(how = How.CSS, using = "img[src='assets/img/aires.png']")
	private WebElement _imgAIRESLogo;

	// Aires Policy Tool
	@FindBy(how = How.XPATH, using = "//h1[text()='Aires Policy Tool']")
	private WebElement _txtAiresPolicyTool;

	// Stay Signed In Yes Button
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'idSIButton')]")
	private WebElement _staySignedInYes;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	/**********************************************************************/

	private TransfereeSubmissions_LoginData _transfereeSubmissionLoginData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getTransfereeSubmissionLoginDataList(COREFLEXConstants.TRANSFEREE_SUBMISSIONS);
	
	/**********************************************************************/

	public void VerifyAIRESLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgAIRESLogo, COREFLEXConstants.AIRESLOGO_TEXT);
		if (_imgAIRESLogo.isDisplayed()) {
			CoreFunctions.highlightObject(driver, _imgAIRESLogo);
			Log.info(CoreConstants.VRFIED + COREFLEXConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		} else
			Assert.fail(CoreConstants.FAIL + COREFLEXConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public void openApplication() {
		Log.info(FileReaderManager.getInstance().getConfigReader().getCoreFlexTransfereeSubmissionsApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		VerifyAIRESLogo();
	}

	public void verifyLoginCredentials() {
		if (CoreFunctions.isElementExist(driver, _buttonSignIn, 5)) {
			Assert.fail("Invalid login credentials are entered.");
		}
	}

	public void clickSignIn() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSignIn,
				_buttonSignIn.getAttribute("value"));
		CoreFunctions.clickElement(driver, _buttonSignIn);
		if (CoreFunctions.isElementExist(driver, _staySignedInYes, 10)) {
			CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
		}
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
	}

	public void enterUserEmailAndPassword(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserEmail,
					_inputUserEmail.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputUserEmail, _inputUserEmail.getAttribute("placeholder"),
					userName);
			CoreFunctions.clickUsingJS(driver, _buttonNext, _buttonNext.getAttribute("value"));
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputPassword,
					_inputPassword.getAttribute("name"));
			CoreFunctions.clearAndSetText(driver, _inputPassword, _inputPassword.getAttribute("name"), password);
		} catch (ElementNotFoundException e) {
		}
	}

	public boolean loginByUserType(String userType, TransfereeSubmissions_DashboardHomePage dashboardHomePage) {
		boolean isSuccessfullyLoggedIn = false;
		try {
			switch (userType) {
			case COREFLEXConstants.MSPEC_PPC:
				enterUserEmailAndPassword(getCSMCredentials(_transfereeSubmissionLoginData)[0], getCSMCredentials(_transfereeSubmissionLoginData)[1]);
				clickSignIn();
				isSuccessfullyLoggedIn = dashboardHomePage.verifyUserlogin(getCSMUserName(_transfereeSubmissionLoginData),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_DASHBOARD_HOME_PAGE);
				break;
			default:
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.LOGIN_USER_TYPE_NOT_VALID,
						CoreConstants.FAIL, userType));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_LOGGING_TO_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSuccessfullyLoggedIn) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_LOGGED_INTO_TRANSFEREE_SUBMISSIONS_APPLICATION, CoreConstants.PASS));
		}
		return isSuccessfullyLoggedIn;
	}
	
	private String getCSMUserName(TransfereeSubmissions_LoginData _transfereeSubmissionLoginData2) {
		String csmUserFullName = null;
		switch(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()) {
		case CoreConstants.ENVT_DEV:
			csmUserFullName = _transfereeSubmissionLoginData.dev.fullName;
			break;
		case CoreConstants.ENVT_QA:
			csmUserFullName = _transfereeSubmissionLoginData.qa.fullName;
			break;
		case CoreConstants.ENVT_UAT:
			csmUserFullName = _transfereeSubmissionLoginData.uat.fullName;
			break;
		case CoreConstants.ENVT_PROD:
			csmUserFullName = _transfereeSubmissionLoginData.prod.fullName;
			break;
		}
		return csmUserFullName;
	}

	private String[] getCSMCredentials(TransfereeSubmissions_LoginData _transfereeSubmissionLoginData) {
		String csmCredentials[] = new String[2];
		switch(CoreFunctions.getPropertyFromConfig("envt").toLowerCase()) {
		case CoreConstants.ENVT_DEV:
			csmCredentials[0] = _transfereeSubmissionLoginData.dev.userName;
			csmCredentials[1] = _transfereeSubmissionLoginData.dev.password;
			break;
		case CoreConstants.ENVT_QA:
			csmCredentials[0] = _transfereeSubmissionLoginData.qa.userName;
			csmCredentials[1] = _transfereeSubmissionLoginData.qa.password;
			break;
		case CoreConstants.ENVT_UAT:
			csmCredentials[0] = _transfereeSubmissionLoginData.uat.userName;
			csmCredentials[1] = _transfereeSubmissionLoginData.uat.password;
			break;
		case CoreConstants.ENVT_PROD:
			csmCredentials[0] = _transfereeSubmissionLoginData.prod.userName;
			csmCredentials[1] = _transfereeSubmissionLoginData.prod.password;
			break;
		}
		return csmCredentials;
	}
}
