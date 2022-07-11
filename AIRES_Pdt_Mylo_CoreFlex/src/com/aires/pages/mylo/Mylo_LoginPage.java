package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.Map;

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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

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

	@FindBy(how = How.CSS, using = "input[type='password']")
	private WebElement _txtPassword;

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

	final By _loginImg = By.xpath("//img[contains(@src,'login-with-office-365.jpg')]");
	final By _password = By.cssSelector("input[type='password']");

	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	public void openApplication() throws InterruptedException {
		Log.info(
				FileReaderManager.getInstance().getConfigReader().getApplicationUrl(System.getProperty("application")));
		CoreFunctions.waitForBrowserToLoad(driver);
		VerifyMYLOLogo();
		WebElement loginImageElement = CoreFunctions.explicitWaitTillVisiblityAndReturnElement(driver, _loginImg);
		CoreFunctions.hoverAndClick(driver, loginImageElement, MYLOConstants.LOGIN_IMAGE);
		CoreFunctions.switchToNewTab(driver);
	}

	public void VerifyMYLOLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgMYLOLogo, MYLOConstants.MYLOLOGO_TEXT);
		if (_imgMYLOLogo.isDisplayed())
			Log.info(CoreConstants.VRFIED + MYLOConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		else
			Assert.fail(CoreConstants.FAIL + MYLOConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public void clickSignIn() {
		CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
		CoreFunctions.clickMyloElementIfExist(driver, _staySignedInYes, MYLOConstants.YES_BUTTON, 8);
		CoreFunctions.switchToParentWindow(driver);
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		while (!(CoreFunctions.isElementExist(driver, _userProfile, 6))) {
			WebElement loginImageElement = CoreFunctions.explicitWaitTillVisiblityAndReturnElement(driver, _loginImg);
			CoreFunctions.hoverAndClick(driver, loginImageElement, MYLOConstants.LOGIN_IMAGE);
		}
		CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		CoreFunctions.highlightObject(driver, _userProfile);
	}

	public void enterUserEmailAndPasswordForMylo(String userName, String password) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _txtUserEmail, MYLOConstants.USER_EMAIL, 60);
		CoreFunctions.clearAndSetText(driver, _txtUserEmail, _txtUserEmail.getAttribute("placeholder"), userName);
		CoreFunctions.clickUsingJS(driver, _submit, _submit.getAttribute("value"));
		if (password != "" && CoreFunctions.isElementByLocatorExist(driver, _password, 60)) {
			WebElement pswdElement = CoreFunctions.getElementByLocator(driver, _password);
			CoreFunctions.clearAndSetText(driver, pswdElement, pswdElement.getAttribute("type"), password);
		}
	}

	public void logout() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE, 15);
		CoreFunctions.clickUsingJS(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _logoutUserImg, _logoutUserImg.getText());
		CoreFunctions.click(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE);
	}

	public void loginWithUser(String userType) throws InterruptedException {
		logout();
		openApplication();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _anotherAccount, _anotherAccount.getText());
		CoreFunctions.click(driver, _anotherAccount, _anotherAccount.getText());
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15)
				|| userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300096)
				|| userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300140))
			enterUserEmailAndPasswordForMylo(loginData.MyloWithOutResource15UserName, loginData.MyloPassword);
		else
			enterUserEmailAndPasswordForMylo(loginData.MyloUserName, loginData.MyloPassword);
		clickSignIn();
	}

	/**
	 * @param table 
	 * Verify Error Messages for Different UserNames & Passwords on Login Page
	 */
	public void verifyUserNamePasswordErrorMessage(DataTable table, String errorMessageType) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String password = (errorMessageType.equals(MYLOConstants.PASSWORD))
					? data.get(i).get(MYLOConstants.PASSWORD)
					: "";
			enterUserEmailAndPasswordForMylo(data.get(i).get(MYLOConstants.USER_EMAIL), password);
			if (errorMessageType.equals(MYLOConstants.PASSWORD))
				CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
			String errorTextDisplayed = (errorMessageType.equals(MYLOConstants.PASSWORD))
					? CoreFunctions.getElementText(driver, _passwordError)
					: CoreFunctions.getElementText(driver, _userNameError);
			Assert.assertTrue(verifyErrorMessage(data.get(i).get(MYLOConstants.MESSAGE), errorTextDisplayed),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(i).get(MYLOConstants.MESSAGE), errorTextDisplayed, MYLOConstants.LOGIN));
		}
	}

	public boolean verifyErrorMessage(String expectedMessage, String actualMessage) {
		boolean flag = actualMessage.equals(expectedMessage);
		String msg = (flag)
				? MessageFormat.format(MYLOConstants.VERIFIED_ERROR_MESSAGE_DISPLAYED, CoreConstants.PASS,
						actualMessage, MYLOConstants.LOGIN)
				: MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, expectedMessage,
						actualMessage, MYLOConstants.LOGIN);
		Reporter.addStepLog(msg);
		return flag;
	}

}
