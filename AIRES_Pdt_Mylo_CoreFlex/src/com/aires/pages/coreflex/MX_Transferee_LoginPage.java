/***********************************Header Start*********************************************************************************
 * Application/ Module Name				: AIRES
 * Class Name        				    : Login Page 
 * Owner								: Test Automation Team
 ***********************************************************************
 * Creation /Modification Log: 
 * Date				By					  Notes                                    
 ---------			--------			---------
 *17/04/2020		Rahul Sharma		Created login page repository and function for MobilityX Application 
 ***********************************************************************
 * Review/Feedback Log: 
 * Date				By					Notes                                    
 ---------			--------			---------
 * [Date]			[Reviewer]			[Brief description of the review/feedback comments]

 ************************************************************************************************
 * Functional Test Coverage Description  : Identified and defined all web elements in Add Role.												   
 ************************************************************************************************
 * Notes								: NA
 * Assumptions							: NA
 * Limitations							: NA
=============List of Resources used=========================
 * User Defined Functions				: BusinessFunctions
 ***********************************Header End*********************************************************************************/

package com.aires.pages.coreflex;

import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.MX_Transferee_LoginData;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;
import microsoft.exchange.webservices.data.core.ExchangeService;
import microsoft.exchange.webservices.data.core.enumeration.misc.ExchangeVersion;
import microsoft.exchange.webservices.data.core.enumeration.property.WellKnownFolderName;
import microsoft.exchange.webservices.data.core.enumeration.search.LogicalOperator;
import microsoft.exchange.webservices.data.core.service.folder.Folder;
import microsoft.exchange.webservices.data.core.service.item.Item;
import microsoft.exchange.webservices.data.core.service.schema.ItemSchema;
import microsoft.exchange.webservices.data.credential.ExchangeCredentials;
import microsoft.exchange.webservices.data.credential.WebCredentials;
import microsoft.exchange.webservices.data.search.ItemView;
import microsoft.exchange.webservices.data.search.filter.SearchFilter;

public class MX_Transferee_LoginPage extends Base {

	public MX_Transferee_LoginPage(WebDriver driver) {
		super(driver);
	}

	/*********************************************************************************************************/

	// Next Button
	@FindBy(how = How.XPATH, using = "//span[@class='RXBiggerTextMuted'][contains(text(),'Sign in')]")
	private WebElement _textSignIn;

	// AIRES Logo Image
	@FindBy(how = How.CSS, using = "img[id*='logoicon']")
	private WebElement _imageAIRESLogo;

	// UserName Input Field
	@FindBy(how = How.CSS, using = "input[id='username::content']")
	private WebElement _inputUserName;

	// Next Button
	@FindBy(how = How.XPATH, using = "//span[text()='NEXT']/parent::a")
	private WebElement _buttonNext;

	// Password Input Field
	@FindBy(how = How.CSS, using = "input[id='password::content']")
	private WebElement _inputPassword;

	// Login Button Field
	@FindBy(how = How.CSS, using = "div[id='loginButton']")
	private WebElement _buttonLogin;

	// MobilityX Home Page UserName Text
	@FindBy(how = How.CSS, using = "span[id='dcmjhhr:openUserProfileText']")
	private WebElement _textTransfereeuserNameTitle;

	// Forget Password Link
	@FindBy(how = How.LINK_TEXT, using = "Forgot password?")
	private WebElement _linkForgotPassword;

	// LogOut Link
	@FindBy(how = How.CSS, using = "span[id*=logoutText]")
	private WebElement _linkLogout;

	// AccountSetting Link
	@FindBy(how = How.ID, using = "dcmjhhr:settingsText")
	private WebElement _linkAccountSettings;

	private WebElement webElement;
	private static String _loginValue[] = new String[4];
	Boolean isExists = false;

	/**************************************************************************************************************/

	MX_Transferee_LoginData loginData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getloginDetailsByUserFirstName(COREFLEXConstants.USER_FIRST_NAME);

	/**************************************************************************************************************/

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigation() {
		try {
			return CoreFunctions.isElementExist(driver, _textSignIn, 5);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_MOBILITYX_LOGIN_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	// Methods
	public void VerifyAIRESLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imageAIRESLogo, COREFLEXConstants.AIRESLOGO_TEXT);
		if (_imageAIRESLogo.isDisplayed())
			Log.info(CoreConstants.VRFIED + COREFLEXConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		else
			Assert.fail(CoreConstants.FAIL + COREFLEXConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public String[] getLoginDataAsPerEnvt(MX_Transferee_LoginData loginData) {
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("Dev")
				|| CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("QA")) {
			_loginValue[0] = CoreFunctions.getPropertyFromConfig("Transferee_UserNameInEMail");
			_loginValue[1] = CoreFunctions.getPropertyFromConfig("Transferee_PasswordInEMail");
			_loginValue[2] = CoreFunctions.getPropertyFromConfig("Transferee_firstName");
			_loginValue[3] = CoreFunctions.getPropertyFromConfig("Transferee_lastName");
		} else {
			_loginValue[0] = loginData.userName_Prod;
			_loginValue[1] = loginData.password_Prod;
			_loginValue[2] = loginData.firstName_Prod;
			_loginValue[3] = loginData.lastName_Prod;
		}
		return _loginValue;
	}

	public void enterUsernameAndPasswordForMobilityX(String userName, String password) {
		try {
			CoreFunctions.clearAndSetText(driver, _inputUserName, _inputUserName.getAttribute("name"), userName);
			CoreFunctions.clickElement(driver, _buttonNext);
			CoreFunctions.clearAndSetText(driver, _inputPassword, _inputPassword.getAttribute("name"), password);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ENTERING_USERNAME_AND_PASSWORD_ON_MOBILITYX_LOGIN_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void clickSignIn() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonLogin, _buttonLogin.getText());
		CoreFunctions.clickUsingJS(driver, _buttonLogin, _buttonLogin.getText());
	}

	public void openApplication() throws InterruptedException {
		Log.info(FileReaderManager.getInstance().getConfigReader().getMobilityXUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		VerifyAIRESLogo();
	}

	public boolean loginToMobilityXApplication() throws InterruptedException {
		boolean isLoginSuccessful = false;
		openApplication();
		try {
			if (CoreFunctions.isElementExist(driver, _inputUserName, 5)) {
				_loginValue = getLoginDataAsPerEnvt(loginData);
				enterUsernameAndPasswordForMobilityX(_loginValue[0], _loginValue[1]);
				CoreFunctions.clickElement(driver, _buttonLogin);
				isLoginSuccessful = true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_LOGIN_IN_ON_MOBILITYX_LOGIN_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return isLoginSuccessful;
	}

	public void loginAgain(String username, String password) {
		try {
			if (CoreFunctions.isElementExist(driver, _inputUserName, 5)) {
				enterUsernameAndPasswordForMobilityX(username, password);
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonLogin, _buttonLogin.getText());
				CoreFunctions.clickUsingJS(driver, _buttonLogin, _buttonLogin.getText());
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_LOGIN_IN_ON_MOBILITYX_LOGIN_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
	}

	public Boolean verifyUserlogin(String fName, String lName) {
		Boolean isExists = false;
		if (CoreFunctions.isElementExist(driver, _textTransfereeuserNameTitle, 15)
				&& _textTransfereeuserNameTitle.getText().equalsIgnoreCase(fName + " " + lName)) {
			isExists = true;
			Reporter.addStepLog(CoreConstants.PASS + COREFLEXConstants.VERIFIED + COREFLEXConstants.USER_NAME
					+ CoreConstants.IS_DISPLAYED_AS + _textTransfereeuserNameTitle.getText()
					+ COREFLEXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
		} else {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.USER_NAME_NOT_EXIST, CoreConstants.FAIL,
					fName + " " + lName));
		}
		return isExists;
	}

	public void logout() {
		try {
			CoreFunctions.waitHandler(4);
			CoreFunctions.clickElement(driver, _textTransfereeuserNameTitle);
			CoreFunctions.clickElement(driver, _linkLogout);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_PERFORMING_LOGOUT_OPERATION_ON_MOBILITYX_JOURNEY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public Boolean verifyTransfereeUserlogins(DataTable table) {
		Boolean isExists = false;
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		String fName = data.get(0).get(COREFLEXConstants.FIRST_NAME);
		String lName = data.get(0).get(COREFLEXConstants.LAST_NAME);
		if (_textTransfereeuserNameTitle.getText().equalsIgnoreCase(fName + " " + lName)) {
			isExists = true;
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VERIFIED_NAME_ON_MOBILITYX_PAGE,
					CoreConstants.PASS, fName, lName));
		}
		return isExists;
	}

	public void enterTransfereeUsernameAndPassword(DataTable table) {
		List<Map<String, String>> data = table.asMaps(String.class, String.class);
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("Test")) {
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%';");
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
					_inputUserName.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputUserName,
					data.get(0).get(COREFLEXConstants.USER_NAME_DATA_TABLE));
			CoreFunctions.clickUsingJS(driver, _buttonNext, _buttonNext.getText());
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputPassword,
					_inputPassword.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputPassword,
					data.get(0).get(COREFLEXConstants.PASSWORD_DATA_TABLE));
			((JavascriptExecutor) driver).executeScript("document.body.style.zoom='90%';");
		} else {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
					_inputUserName.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputUserName,
					data.get(0).get(COREFLEXConstants.USER_NAME_DATA_TABLE));
			CoreFunctions.clickUsingJS(driver, _buttonNext, _buttonNext.getText());
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputPassword,
					_inputPassword.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputPassword,
					data.get(0).get(COREFLEXConstants.PASSWORD_DATA_TABLE));
		}
	}

	public void clickLogOut() {
		CoreFunctions.click(driver, _textTransfereeuserNameTitle, _textTransfereeuserNameTitle.getText());
		CoreFunctions.click(driver, _linkLogout, COREFLEXConstants.LINK_LOGOUT);
		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
				_inputUserName.getAttribute("placeholder"));
	}

	public Boolean verifyLogout() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
				_inputUserName.getAttribute("placeholder"));
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imageAIRESLogo, COREFLEXConstants.AIRESLOGO_TEXT);
		if (_inputUserName.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VERIFIED_LOGOUT, CoreConstants.PASS,
					COREFLEXConstants.LINK_LOGOUT));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_LOGOUT, CoreConstants.FAIL,
				COREFLEXConstants.LINK_LOGOUT));
		return false;
	}

	public WebElement getElementByName(String elementName) {
		switch (elementName) {
		case COREFLEXConstants.USERNAME:
			return _inputUserName;
		default:
			Assert.fail(COREFLEXConstants.NO_ELEMENT_FOUND);
		}
		return webElement;
	}

	public boolean verifyElementPresentOnLoginPage(String elementName, String pageName) {
		return CoreFunctions.verifyElementPresentOnPage(driver, getElementByName(elementName), pageName, 10);
	}

	public boolean readCredentialsFromMail() {
		try {
			// Reading Transferee Username and Password from email and writing to the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "test_csm@aires.com";
			// Enter expected email subject
			String expEmailSubject = "MobilityX Username";
			String resultUserName = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromUserName,
					expEmailSubject, PDTConstants.TRANSFEREE_USER_NAME);
			String userName_InEmail = resultUserName.trim();
			String expFromPwd = "testrelonet@aires.com";
			String expEmailSubjectPwd = "MobilityX Password";
			String resultPassword = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromPwd,
					expEmailSubjectPwd, PDTConstants.TRANSFEREE_PASSWORD);
			CoreFunctions.writeToPropertiesFile("Transferee_PasswordInEMail", resultPassword);
			CoreFunctions.writeToPropertiesFile("Transferee_UserNameInEMail", userName_InEmail);
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT
					+ "UserName & Password Successfully received in Email for User : " + userName_InEmail);
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_CREDENTIALS_FROM_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}

		return false;
	}

	public boolean verifyBasePolicySubmitted() {
		return Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CoreFlexMultipleSubmissionFlag"));
	}

	public boolean verifyPreviousPolicySubmittedDate(String firstPolicySubmissionDate) {
		return firstPolicySubmissionDate.equals(CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy")) ? false
				: true;
	}

}