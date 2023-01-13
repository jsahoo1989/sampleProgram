package com.aires.pages.mylo;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.text.MessageFormat;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_LoginPage extends Base {

	public Mylo_LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "img[src*='mylo-logo']")
	private WebElement _imgMYLOLogo;

	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement _txtUserEmail;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _submit;

	@FindBy(how = How.CSS, using = "#KmsiDescription")
	private WebElement _staySignedInMsg;

	@FindBy(how = How.CSS, using = "input[id*='idSIButton']")
	private WebElement _staySignedInYes;

	@FindBy(how = How.CSS, using = "#displayName")
	private WebElement _staySignedInUserName;

	@FindBy(how = How.CSS, using = "div[role='heading']")
	private WebElement _staySignedInHeader;

	@FindBy(how = How.CSS, using = "div[class='profile-img']>a>img")
	private WebElement _userProfileImg;

	@FindBy(how = How.CSS, using = "img[class='tile-img']")
	private WebElement _logoutUserImg;

	@FindBy(how = How.ID, using = "otherTileText")
	private WebElement _anotherAccount;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[id='user-profile']")
	private WebElement _userProfile;

	@FindBy(how = How.ID, using = "usernameError")
	private WebElement _userNameError;

	@FindBy(how = How.ID, using = "passwordError")
	private WebElement _passwordError;

	@FindBy(how = How.CSS, using = "button[class*='btn mylo-login-btn']")
	private WebElement _loginBtn;

	private final By _txtPassword = By.cssSelector("input[type='password']");

	private Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	/**
	 * Open Mylo Application
	 * @throws InterruptedException
	 */
	public void openApplication() throws InterruptedException {
		Log.info(FileReaderManager.getInstance().getConfigReader()
				.getApplicationUrl(System.getProperty(MYLOConstants.APPLICATION)));
		CoreFunctions.waitForBrowserToLoad(driver);
		verifyMYLOLogo();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _loginBtn, MYLOConstants.LOGIN_IMAGE, 10);
		CoreFunctions.hoverAndClick(driver, _loginBtn, MYLOConstants.LOGIN_IMAGE);
		CoreFunctions.switchToNewTab(driver);
	}

	/**
	 * Verify Mylo Logo on Login Page
	 */
	public void verifyMYLOLogo() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _imgMYLOLogo, MYLOConstants.MYLOLOGO_TEXT);
			Assert.assertTrue(CoreFunctions.isElementVisible(_imgMYLOLogo), MYLOConstants.MYLO_LOGO_NOT_DISPLAYED);
			CoreFunctions.highlightObject(driver, _imgMYLOLogo);
			Reporter.addStepLog(CoreConstants.VRFIED + MYLOConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.MYLOLOGO_TEXT, MYLOConstants.LOGIN));
		}
	}

	/**
	 * Enter Mylo Login Credentials
	 * @param userName
	 * @param password
	 */
	public void enterUserEmailAndPasswordForMylo(String userName, String password) {
		try {
			CoreFunctions.clearAndSetText(driver, _txtUserEmail, MYLOConstants.USER_EMAIL, userName);
			CoreFunctions.clickUsingJS(driver, _submit, MYLOConstants.NEXT_BUTTON);
			WebElement pswdElement = CoreFunctions.getElementByLocator(driver, _txtPassword);
			CoreFunctions.clearAndSetText(driver, pswdElement, MYLOConstants.PASSWORD, password);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.USER_EMAIL + MYLOConstants.AND + MYLOConstants.PASSWORD, MYLOConstants.LOGIN));
		}
	}

	/**
	 * Clicks on Sign In button and StaySignedIn Yes button If appears
	 */
	public void clickSignIn() {
		try {
			CoreFunctions.click(driver, _submit, _submit.getAttribute(MYLOConstants.VALUE));
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			clickStaySignedIn();
			CoreFunctions.switchToParentWindow(driver);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			navigateToMyloHomePage();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.UNABLE_TO_SIGN_IN_MYLO, CoreConstants.FAIL));
		}
	}

	/**
	 * Clicks on Stay Signed In Yes button and verify the message and header Text of Stay Signed In section if appears
	 */
	public void clickStaySignedIn() {
		if (CoreFunctions.isElementExist(driver, _staySignedInYes, 8)) {
			String signedInMsg = CoreFunctions.getElementText(driver, _staySignedInMsg);
			String signedInHeaderText = CoreFunctions.getElementText(driver, _staySignedInHeader);
			Assert.assertEquals(signedInMsg, MYLOConstants.STAY_SIGNED_IN_MESSAGE,
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							MYLOConstants.STAY_SIGNED_IN_MESSAGE, signedInMsg, MYLOConstants.LOGIN));
			Assert.assertEquals(signedInHeaderText, MYLOConstants.STAY_SIGNED_IN,
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							MYLOConstants.STAY_SIGNED_IN, signedInHeaderText, MYLOConstants.LOGIN));
			CoreFunctions.click(driver, _staySignedInYes, MYLOConstants.YES_BUTTON);
		}
	}

	/**
	 * Navigate to Mylo Home Page if Login Page appears after successful login with valid credentials
	 */
	public void navigateToMyloHomePage() {
		try {
			while (!(CoreFunctions.isElementExist(driver, _userProfile, 3))) {
				CoreFunctions.refreshPage(driver);
				CoreFunctions.waitForBrowserToLoad(driver);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _loginBtn, MYLOConstants.LOGIN_IMAGE, 10);
				CoreFunctions.hoverAndClick(driver, _loginBtn, MYLOConstants.LOGIN_IMAGE);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
			CoreFunctions.highlightObject(driver, _userProfile);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.UNABLE_TO_SIGN_IN_MYLO, CoreConstants.FAIL));
		}
	}

	/**
	 * Logout from Mylo Application
	 */
	public void logout() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE, 60);
			CoreFunctions.clickUsingJS(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
			CoreFunctions.waitHandler(5);
			CoreFunctions.pressEnter();
			CoreFunctions.waitHandler(5);
			//CoreFunctions.explicitWaitTillElementVisibility(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE, 60);		
			if(CoreFunctions.isElementExist(driver, _logoutUserImg, 60))
				CoreFunctions.click(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE);
			
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.USER_PROFILE_IMAGE + MYLOConstants.AND + MYLOConstants.LOGOUT_IMAGE,
					MYLOConstants.LOGIN));
		}
	}


	/**
	 * Logout and then Relogin to Mylo application for given userType
	 * @param userType
	 */
	public void loginWithUser(String userType) {
		try {
			logout();
			openApplication();
			CoreFunctions.click(driver, _anotherAccount, MYLOConstants.ANOTHER_ACCOUNT);
			if (userType.contains(MYLOConstants.WITHOUT))
				enterUserEmailAndPasswordForMylo(loginData.MyloWithOutResource, loginData.MyloPassword);
			else
				enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
			clickSignIn();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.UNABLE_TO_SIGN_IN_MYLO, CoreConstants.FAIL));
		}
	}

	/**
	 * Verify all the error message associated with Mylo user email
	 * @param userName
	 * @param msg
	 * @return
	 */
	public boolean verifyUserNameErrorMessage(String userName, String msg) {
		String errorTextDisplayed = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtUserEmail, MYLOConstants.USER_EMAIL, 60);
			CoreFunctions.clearAndSetText(driver, _txtUserEmail, MYLOConstants.USER_EMAIL, userName);
			CoreFunctions.clickUsingJS(driver, _submit, MYLOConstants.NEXT_BUTTON);
			errorTextDisplayed = CoreFunctions.getElementText(driver, _userNameError);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_ERROR_MESSAGE_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.USER_EMAIL, MYLOConstants.LOGIN));
		}
		return (BusinessFunctions.verifyMyloValidationMessage(msg, errorTextDisplayed, MYLOConstants.LOGIN));
	}

	/**
	 * Verify all the error message associated with Mylo password
	 * @param userName
	 * @param password
	 * @param msg
	 * @return
	 */
	public boolean verifyPasswordErrorMessage(String userName, String password, String msg) {
		String errorTextDisplayed = "";
		try {
			enterUserEmailAndPasswordForMylo(userName, password);
			CoreFunctions.click(driver, _submit, _submit.getAttribute(MYLOConstants.VALUE));
			errorTextDisplayed = CoreFunctions.getElementText(driver, _passwordError);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_ERROR_MESSAGE_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.PASSWORD, MYLOConstants.LOGIN));
			
		}
		return (BusinessFunctions.verifyMyloValidationMessage(msg, errorTextDisplayed, MYLOConstants.LOGIN));
	}

	/**
	 * Read MobilityX Transferee UserName and Password from Mail sent from Mylo application
	 * @return
	 */
	public boolean readCredentialsFromMail() {
		try {
			CoreFunctions.waitHandler(10);
			String host = "outlook.office365.com";
			String userName = "airesautomation@aires.com";
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			String expFromUserName = "securelogin@aires.com";
			String expEmailSubject = "Aires MobilityX Login User Name";
			String resultUserName = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromUserName,
					expEmailSubject, MYLOConstants.MYLO_TRANSFEREE_USER_NAME);
			String userName_InEmail = resultUserName.trim();
			String expFromPwd = "securelogin@aires.com";
			String expEmailSubjectPwd = "Aires MobilityX Login User Password";
			String resultPassword = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromPwd,
					expEmailSubjectPwd, MYLOConstants.MYLO_TRANSFEREE_PASSWORD);
			CoreFunctions.writeToPropertiesFile("Mylo_Transferee_PasswordInEMail", resultPassword);
			CoreFunctions.writeToPropertiesFile("Mylo_Transferee_UserNameInEMail", userName_InEmail);
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
}
