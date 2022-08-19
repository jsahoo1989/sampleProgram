package com.aires.pages.mylo;

import java.text.MessageFormat;
import org.openqa.selenium.By;
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
	
	@FindBy(how = How.XPATH, using = "//img[contains(@src,'login-with-office-365.jpg')]")
	private WebElement _loginImg;

	final By _txtPassword=By.cssSelector("input[type='password']");
	
	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public void openApplication() throws InterruptedException {
		Log.info(FileReaderManager.getInstance().getConfigReader().getApplicationUrl(System.getProperty(MYLOConstants.APPLICATION)));
		CoreFunctions.waitForBrowserToLoad(driver);
		Assert.assertTrue(verifyMYLOLogo(),CoreConstants.FAIL + MYLOConstants.APPLICATION_FAILED_TO_LAUNCH);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _loginImg, MYLOConstants.LOGIN_IMAGE, 10);
		CoreFunctions.hoverAndClick(driver, _loginImg, MYLOConstants.LOGIN_IMAGE);
		CoreFunctions.switchToNewTab(driver);
	}

	public boolean verifyMYLOLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgMYLOLogo, MYLOConstants.MYLOLOGO_TEXT);
		boolean flag = CoreFunctions.isElementVisible(_imgMYLOLogo);
		if (flag)
			Reporter.addStepLog(CoreConstants.VRFIED + MYLOConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		return flag;
	}

	public void clickSignIn() {
		CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
		if (CoreFunctions.isElementExist(driver, _staySignedInYes, 8)&& _staySignedInYes.isDisplayed() ) {
			Assert.assertEquals(CoreFunctions.getElementText(driver, _staySignedInMsg), "Do this to reduce the number of times you are asked to sign in.");
			CoreFunctions.click(driver, _staySignedInYes, MYLOConstants.YES_BUTTON);
		}
		CoreFunctions.switchToParentWindow(driver);
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		while (!(CoreFunctions.isElementExist(driver, _userProfile, 3))) {
			CoreFunctions.refreshPage(driver);
			CoreFunctions.waitForBrowserToLoad(driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _loginImg, MYLOConstants.LOGIN_IMAGE, 10);
			CoreFunctions.hoverAndClick(driver, _loginImg, MYLOConstants.LOGIN_IMAGE);
		}
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		CoreFunctions.highlightObject(driver, _userProfile);
	}

	public void enterUserEmailAndPasswordForMylo(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtUserEmail, MYLOConstants.USER_EMAIL, 60);
			CoreFunctions.clearAndSetText(driver, _txtUserEmail, _txtUserEmail.getAttribute("placeholder"), userName);
			CoreFunctions.clickUsingJS(driver, _submit, _submit.getAttribute(MYLOConstants.VALUE));
			if (password != "") {
				WebElement pswdElement = CoreFunctions.getElementByLocator(driver, _txtPassword);
				CoreFunctions.clearAndSetText(driver, pswdElement, MYLOConstants.PASSWORD, password);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.USER_EMAIL + MYLOConstants.PASSWORD, MYLOConstants.LOGIN));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.USER_EMAIL + MYLOConstants.PASSWORD, MYLOConstants.LOGIN));
		}
	}

	public void logout() {
		CoreFunctions.clickUsingJS(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.click(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE);
	}

	public void loginWithUser(String userType) throws InterruptedException {
		logout();
		openApplication();
		CoreFunctions.click(driver, _anotherAccount, MYLOConstants.ANOTHER_ACCOUNT);
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15)
				|| userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300096)
				|| userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300140)
				|| userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300139))
			enterUserEmailAndPasswordForMylo(loginData.MyloWithOutResource15UserName, loginData.MyloPassword);
		else
			enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		clickSignIn();
	}
	
	/**
	 * @param table 
	 * Verify Error Messages for Different UserNames & Passwords on Login Page
	 */
	public boolean verifyUserNamePasswordErrorMessage(String userName, String password, String msg,
			String errorMessageType) {
		enterUserEmailAndPasswordForMylo(userName, password);
		String errorTextDisplayed = null;
		if (errorMessageType.equals(MYLOConstants.PASSWORD)) {
			CoreFunctions.click(driver, _submit, _submit.getAttribute(MYLOConstants.VALUE));
			errorTextDisplayed = CoreFunctions.getElementText(driver, _passwordError);
		} else
			errorTextDisplayed = CoreFunctions.getElementText(driver, _userNameError);
		return (BusinessFunctions.verifyMyloValidationMessage(msg, errorTextDisplayed, MYLOConstants.LOGIN));
	}
	
	public boolean readCredentialsFromMail() {
		try {
			CoreFunctions.waitHandler(10);
			// Reading Transferee Username and Password from email and writing to the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "securelogin@aires.com";
			// Enter expected email subject
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
