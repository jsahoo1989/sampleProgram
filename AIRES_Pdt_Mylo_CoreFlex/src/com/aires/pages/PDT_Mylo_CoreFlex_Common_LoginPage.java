package com.aires.pages;

import java.text.MessageFormat;
import java.util.Date;
import java.util.LinkedHashMap;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.mylo.Mylo_LoginData;
import com.aires.testdatatypes.pdt.PDT_LoginInfo;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_Mylo_CoreFlex_Common_LoginPage extends Base {	
	public PDT_Mylo_CoreFlex_Common_LoginPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[type='email']")
	private WebElement _txt_UserEmail;
	
	@FindBy(how = How.CSS, using = "input[type='submit']")
	private WebElement _submit;

	@FindBy(how = How.CSS, using = "input[type='password']")
	private WebElement _txt_Password;
	
	@FindBy(how = How.CSS, using = "input[id*='idSIButton']")
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
	
	@FindBy(how = How.XPATH, using = "//div[text()='Sign in']")
	private WebElement _headingSignIn;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	@FindBy(how = How.CSS, using = "a.logout")
	private WebElement _imgPDTLogout;

    @FindBy(how = How.CSS, using = "#KmsiDescription")
    private WebElement _staySignedInMsg;
	
	final By _loginImg = By.xpath("//img[contains(@src,'login-with-office-365')]");
	final By _spinnerImg = By.cssSelector("div[class='sk-three-strings']");
	final By _password = By.cssSelector("input[type='password']");
	long timeBeforeAction, timeAfterAction;
	LinkedHashMap<String, WebElement> applicationLogoMap = new LinkedHashMap<String, WebElement>();
	
	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);

	
	//private PDT_LoginInfo _loginInfo = FileReaderManager.getInstance().getJsonReader().getLoginByEnvt(CoreFunctions.getPropertyFromConfig("envt").toLowerCase());	
	
	private PDT_LoginInfo _loginInfo = FileReaderManager.getInstance().getJsonReader().getLoginByEnvt(System.getProperty("envt").toLowerCase());

	public void openApplication() {		
		CoreFunctions.waitForBrowserToLoad(driver);		
		VerifyAIRESLogo();
		CoreFunctions.switchToNewTab(driver);
	}
	
	public void VerifyAIRESLogo() {
		WebElement imgApplicationLogo;
		populateApplicationLogoMap();
		imgApplicationLogo = applicationLogoMap.get(FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication().toUpperCase());
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, imgApplicationLogo, PDTConstants.AIRESLOGO_TEXT);
			if (imgApplicationLogo.isDisplayed()) {
				CoreFunctions.highlightObject(driver, imgApplicationLogo);
				Log.info(CoreConstants.VRFIED + PDTConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
			} else
				Assert.fail(CoreConstants.FAIL + PDTConstants.APPLICATION_FAILED_TO_LAUNCH);
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.APPLICATION_NOT_VALID, CoreConstants.FAIL, FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()));
		}

	}
	
	public void enterUserEmailAndPassword(String userName, String password) {
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, _headingSignIn, "Sign in", 20);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txt_UserEmail,
					_txt_UserEmail.getAttribute("placeholder"), 120);
			CoreFunctions.clearAndSetText(driver, _txt_UserEmail, _txt_UserEmail.getAttribute("placeholder"), userName);
			CoreFunctions.clickUsingJS(driver, _submit, _submit.getAttribute("value"));
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 10);
			WebElement _pswd = CoreFunctions.getElementByLocator(driver, _password);
			CoreFunctions.clearAndSetText(driver, _pswd, _pswd.getAttribute("type"), password);
		} catch (Exception e) {
			Assert.fail("Failed to enter username & password");
		}
	}
	
	public void waitForProgressBarToDisappear() {
		try {
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_WAIT_PROGRESS_BAR, CoreConstants.FAIL));
		}
		
	}
	
	public void navigateToViewPolicyPage() {
		try {
			if(CoreFunctions.isElementExist(driver,  _progressBar, 5)) {
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);			
			}							
			else if(CoreFunctions.isElementPresent(driver, _loginImg, 5, MYLOConstants.LOGIN_BUTTON)) {
				CoreFunctions.click(driver, CoreFunctions.getElementByLocator(driver,_loginImg), MYLOConstants.LOGIN_BUTTON);
				waitForProgressBarToDisappear();
			}
		} catch(Exception e ) {
			Assert.fail("Failed to navigate to View Policy Page.");
		}
	}
	
	public void clickSignIn() {
		try {
			CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
			if (CoreFunctions.isElementExist(driver, _staySignedInYes, 5)) {
				CoreFunctions.explicitWaitTillElementVisibility(driver, _staySignedInYes,
						_staySignedInYes.getAttribute("value"), 10);
				Assert.assertEquals(CoreFunctions.getElementText(driver, _staySignedInMsg), "Do this to reduce the number of times you are asked to sign in.");
				CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
			}
			CoreFunctions.switchToParentWindow(driver);
			navigateToViewPolicyPage();

		} catch(Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_LOGGING_TO_APPLICATION,
					CoreConstants.FAIL,e.getMessage()));
		}
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
	
	public void loginWithUser(String userType) throws InterruptedException {
		logout();
		openApplication();
		CoreFunctions.explicitWaitTillElementVisibility(driver, _anotherAccount, _anotherAccount.getText());
		CoreFunctions.click(driver, _anotherAccount, _anotherAccount.getText());
		if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15)||userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE300096)) {
			enterUserEmailAndPassword(loginData.MyloWithOutResource, loginData.MyloPassword);	
		}
		else {
			enterUserEmailAndPassword(loginData.MyloUserName, loginData.MyloPassword);	
		}
		clickSignIn();
	}
	
	public boolean loginByUserType(String userType, PDT_ViewPolicyPage viewPolicyPage) {		
		boolean isSuccessfullyLoggedIn = false;		
		try {
			openApplication();
			switch (userType) {
			case PDTConstants.CSM:
				enterUserEmailAndPassword(_loginInfo.details.csmUserName, _loginInfo.details.csmPassword);
				timeBeforeAction = new Date().getTime();
				clickSignIn();
				timeAfterAction = new Date().getTime();
				BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.VIEW_POLICY_PAGE);
				isSuccessfullyLoggedIn = viewPolicyPage.verifyUserlogin(_loginInfo.details.firstName + " " + _loginInfo.details.lastName,
						PDTConstants.VIEW_POLICY_PAGE);
				break;
			default:
				Reporter.addStepLog(MessageFormat.format(PDTConstants.LOGIN_USER_TYPE_NOT_VALID,
						CoreConstants.FAIL,userType));
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_WHILE_LOGGING_TO_APPLICATION,
					CoreConstants.FAIL,e.getMessage()));
		}		
		if(isSuccessfullyLoggedIn) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.SUCCESSFULLY_LOGGED_IN_TO_APPLICATION,
					CoreConstants.PASS));
		}
		return isSuccessfullyLoggedIn;
	}
	
	public void populateApplicationLogoMap() {
		applicationLogoMap.put(PDTConstants.APPLICATION_PDT, _imgAIRESLogo);
		applicationLogoMap.put(PDTConstants.APPLICATION_MYLO, _img_MYLOLogo);		
	}

	public void logoutFromPDTApplication() {
		CoreFunctions.clickUsingJS(driver, _imgPDTLogout, "Logout");
		CoreFunctions.clickUsingJS(driver, _logoutUserImg, "Logout");
	}

}
