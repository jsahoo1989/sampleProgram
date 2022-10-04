package com.aires.pages.coreflex;

import java.text.MessageFormat;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.pages.pdt.PDT_ViewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_BluePrint_LoginPage extends Base {

	public CoreFlex_BluePrint_LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement _txt_UserEmail;

	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _submit;

	@FindBy(how = How.CSS, using = "input[type='submit'][value='Next']")
	private WebElement _btnNext;

	@FindBy(how = How.CSS, using = "input[type='password']")
	private WebElement _txt_Password;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'idSIButton')]")
	private WebElement _staySignedInYes;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "img[src*='mylo-logo']")
	private WebElement _img_MYLOLogo;

	// AIRES Logo Image
	@FindBy(how = How.CSS, using = "img[src='assets/img/login/aires-blueprint.png']")
	private WebElement _imgAIRESLogo;

	@FindBy(how = How.XPATH, using = "//div[@class='profile-img']/a/img")
	private WebElement _userProfileImg;

	@FindBy(how = How.XPATH, using = "//img[@class='tile-img']")
	private WebElement _logoutUserImg;

	@FindBy(how = How.XPATH, using = "//div[text()='Use another account']")
	private WebElement _anotherAccount;

	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Login With Office 365')]")
	private WebElement _loginWithOfficeImg;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader()
			.getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	public void openApplication() {
		Log.info(FileReaderManager.getInstance().getConfigReader().getCoreFlexPolicySetupApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		Log.info("Inside openApplication");
		VerifyAIRESLogo();
		CoreFunctions.waitHandler(2);
		CoreFunctions.switchToNewTab(driver);
	}

	public void VerifyAIRESLogo() {
		WebElement imgApplicationLogo;
		if ((FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()
				.equalsIgnoreCase("pdt"))
				|| (FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()
						.equalsIgnoreCase("coreflex"))) {
			imgApplicationLogo = _imgAIRESLogo;
		} else if (FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()
				.equalsIgnoreCase("mylo")) {
			imgApplicationLogo = _img_MYLOLogo;
		} else {
			throw new RuntimeException("Application "
					+ FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()
					+ " is not a valid application");
		}

		CoreFunctions.explicitWaitTillElementVisibility(driver, imgApplicationLogo, PDTConstants.AIRESLOGO_TEXT);
		if (imgApplicationLogo.isDisplayed()) {
			CoreFunctions.highlightObject(driver, imgApplicationLogo);
			Log.info(CoreConstants.VRFIED + PDTConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		} else
			Assert.fail(CoreConstants.FAIL + PDTConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public void enterUserEmailAndPassword(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_UserEmail, PDTConstants.USER_NAME);
			CoreFunctions.clearAndSetText(driver, _txt_UserEmail, _txt_UserEmail.getAttribute("placeholder"), userName);
			CoreFunctions.clickUsingJS(driver, _btnNext, _btnNext.getAttribute("value"));
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_Password,
					_txt_Password.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _txt_Password, _txt_Password.getAttribute("placeholder"), password);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_LOGGING_TO_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public void clickSignIn() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _submit, _submit.getAttribute("value"));
		CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
		if (CoreFunctions.isElementExist(driver, _staySignedInYes, 5)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _staySignedInYes,
					_staySignedInYes.getAttribute("value"), 10);
			CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
		}
		CoreFunctions.switchToParentWindow(driver);
		CoreFunctions.waitHandler(1);
		if (CoreFunctions.isElementExist(driver, _spinner, 5))
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 20);
		else if (CoreFunctions.isElementExist(driver, _loginWithOfficeImg, 5)) {
			CoreFunctions.clickElement(driver, _loginWithOfficeImg);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 20);			
		}else if (CoreFunctions.isElementExist(driver, _loginWithOfficeImg, 5)) {
			CoreFunctions.clickElement(driver, _loginWithOfficeImg);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 20);
		}
		CoreFunctions.waitHandler(1);
	}

	public void logout() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.click(driver, _userProfileImg, MYLOConstants.USER_PROFILE_IMAGE);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _logoutUserImg, _logoutUserImg.getText());
		CoreFunctions.click(driver, _logoutUserImg, MYLOConstants.LOGOUT_IMAGE);
	}

	public void clickAnotherAccount() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _anotherAccount, _anotherAccount.getText());
		CoreFunctions.click(driver, _anotherAccount, _anotherAccount.getText());
	}

	public boolean loginByUserType(String userType, PDT_ViewPolicyPage viewPolicyPage) {
		boolean isSuccessfullyLoggedIn = false;
		try {
			openApplication();
			switch (userType) {
			case PDTConstants.CSM:
				enterUserEmailAndPassword(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0],
						BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[1]);
				clickSignIn();
				isSuccessfullyLoggedIn = viewPolicyPage.verifyCFUserlogin(
						BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[2],
						PDTConstants.VIEW_POLICY_PAGE);
				break;
			default:
				Reporter.addStepLog(
						MessageFormat.format(PDTConstants.LOGIN_USER_TYPE_NOT_VALID, CoreConstants.FAIL, userType));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_LOGGING_TO_APPLICATION,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSuccessfullyLoggedIn) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.SUCCESSFULLY_LOGGED_IN_TO_APPLICATION, CoreConstants.PASS));
		}
		return isSuccessfullyLoggedIn;
	}

	public boolean verifyLoginPageNavigation() {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgAIRESLogo, PDTConstants.AIRESLOGO_TEXT);
		return CoreFunctions.isElementExist(driver, _loginWithOfficeImg, 5);
	}

}
