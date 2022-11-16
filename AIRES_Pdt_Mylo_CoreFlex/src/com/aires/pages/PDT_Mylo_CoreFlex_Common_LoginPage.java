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
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
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
	
	final By _loginImg = By.xpath("//img[contains(@src,'login-with-office-365')]");
	final By _spinnerImg = By.cssSelector("div[class='sk-three-strings']");
	final By _password = By.cssSelector("input[type='password']");
	long timeBeforeAction, timeAfterAction;
	LinkedHashMap<String, WebElement> applicationLogoMap = new LinkedHashMap<String, WebElement>();
	
	Mylo_LoginData loginData = FileReaderManager.getInstance().getMyloJsonReader()
			.getloginDetailsByUserProfileName(MYLOConstants.USER_PROFILE_NAME);
	
	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());
	//private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(System.getProperty("application").toLowerCase());
	public void VerifyMYLOLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _img_MYLOLogo, MYLOConstants.MYLOLOGO_TEXT);
		if (_img_MYLOLogo.isDisplayed())
			Log.info(CoreConstants.VRFIED + MYLOConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		else
			Assert.fail(CoreConstants.FAIL + MYLOConstants.APPLICATION_FAILED_TO_LAUNCH);
	}
	
	public void openApplication() {		
		CoreFunctions.waitForBrowserToLoad(driver);		
		VerifyAIRESLogo();
		CoreFunctions.switchToNewTab(driver);
	}
	
	public void VerifyAIRESLogo() {
		WebElement imgApplicationLogo;
		populateApplicationLogoMap();
		imgApplicationLogo = applicationLogoMap.get(FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication().toUpperCase());
		/*try {
			imgApplicationLogo = applicationLogoMap.get(FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication().toUpperCase());
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.APPLICATION_NOT_VALID, CoreConstants.FAIL, FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()));
		}*/
		
		/*if (FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication().equalsIgnoreCase("pdt")) {
			imgApplicationLogo = _imgAIRESLogo;
		} else if(FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication().equalsIgnoreCase("mylo")) {
			imgApplicationLogo = _img_MYLOLogo;
		} else {
			throw new RuntimeException(
					"Application "+FileReaderManager.getInstance().getConfigReader().getNameOfCurrentLaunchedApplication()+" is not a valid application");
		}*/
		
		CoreFunctions.explicitWaitTillElementVisibility(driver, imgApplicationLogo, PDTConstants.AIRESLOGO_TEXT);
		if (imgApplicationLogo.isDisplayed()) {
			CoreFunctions.highlightObject(driver, _imgAIRESLogo);
			Log.info(CoreConstants.VRFIED + PDTConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		} else
			Assert.fail(CoreConstants.FAIL + PDTConstants.APPLICATION_FAILED_TO_LAUNCH);
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
		}
	}
	
	public void clickSignIn() {
		try {
			CoreFunctions.click(driver, _submit, _submit.getAttribute("value"));
			if (CoreFunctions.isElementExist(driver, _staySignedInYes, 5)) {
				CoreFunctions.explicitWaitTillElementVisibility(driver, _staySignedInYes,
						_staySignedInYes.getAttribute("value"), 10);
				CoreFunctions.click(driver, _staySignedInYes, _staySignedInYes.getAttribute("value"));
			}
			CoreFunctions.switchToParentWindow(driver);		
			if(CoreFunctions.isElementExist(driver,  _progressBar, 2))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);			
			else if(CoreFunctions.isElementPresent(driver, _loginImg, 5, MYLOConstants.LOGIN_BUTTON)) {
				CoreFunctions.click(driver, CoreFunctions.getElementByLocator(driver,_loginImg), MYLOConstants.LOGIN_BUTTON);
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);			
			}
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
				enterUserEmailAndPassword(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0], BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[1]);
				timeBeforeAction = new Date().getTime();
				clickSignIn();
				timeAfterAction = new Date().getTime();
				BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, PDTConstants.VIEW_POLICY_PAGE);
				isSuccessfullyLoggedIn = viewPolicyPage.verifyUserlogin(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[2],
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
}
