package com.aires.pages.pdt;


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
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.pages.PDT_Mylo_CoreFlex_Common_LoginPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_LoginPage extends Base {
	public PDT_LoginPage(WebDriver driver) {
		super(driver);
	}

	// Input UserName field
	@FindBy(how = How.ID, using = "username")
	private WebElement _inputUserName;

	// Input Password field
	@FindBy(how = How.ID, using = "password")
	private WebElement _inputPassword;

	// Login button
	@FindBy(how = How.CSS, using = "button[type='submit']")
	private WebElement _btnLogin;

	// AIRES Logo Image
	@FindBy(how = How.CSS, using = "img[src='assets/img/login/aires-blueprint.png']")
	private WebElement _imgAIRESLogo;

	// Aires Policy Tool
	@FindBy(how = How.XPATH, using = "//h1[text()='Aires Policy Tool']")
	private WebElement _txtAiresPolicyTool;

	private PDT_LoginDetails _loginDetailsApplication = FileReaderManager.getInstance().getJsonReader().getLoginByApplication(CoreFunctions.getPropertyFromConfig("application").toLowerCase());

	final By _imgAIRESLogoByLocator = By.cssSelector("img[src='assets/img/aires.png']");
	final By _btnLoginByLocator = By.cssSelector("button[type='submit']");
	
	public void VerifyAIRESLogo() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _imgAIRESLogo, PDTConstants.AIRESLOGO_TEXT);
		if (_imgAIRESLogo.isDisplayed()) {
			CoreFunctions.highlightObject(driver, _imgAIRESLogo);
			Log.info(CoreConstants.VRFIED + PDTConstants.APPLICATION_LAUNCHED_AND_LOGO_DISPLAYED);
		} else
			Assert.fail(CoreConstants.FAIL + PDTConstants.APPLICATION_FAILED_TO_LAUNCH);
	}

	public void openApplication() {
		//Log.info(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);
		Log.info("Inside openApplication");
		VerifyAIRESLogo();
		CoreFunctions.switchToNewTab(driver);
	}

	public void enterLoginCredentials(String userName, String password) {
		try {
			PDT_Mylo_CoreFlex_Common_LoginPage loginPage = new PDT_Mylo_CoreFlex_Common_LoginPage(driver);
			loginPage.enterUserEmailAndPassword(userName, password);
			loginPage.clickSignIn();
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickLoginBtn() {
		CoreFunctions.click(driver, _btnLogin, _btnLogin.getText());
	}
	
	public void verifyLoginCredentials() {
		if (CoreFunctions.isElementByLocatorExist(driver, _btnLoginByLocator, 5)) {
			Assert.fail("Invalid login credentials are entered.");
		}
	}

	public boolean loginByUserType(String userType, PDT_ViewPolicyPage viewPolicyPage) {		
		boolean isSuccessfullyLoggedIn = false;		
		try {
			openApplication();
			switch (userType) {
			case PDTConstants.CSM:
				enterLoginCredentials(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0], BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[1]);
				clickLoginBtn();
				isSuccessfullyLoggedIn = viewPolicyPage.verifyUserlogin(BusinessFunctions.getCSMCredentials(_loginDetailsApplication)[0],
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
}
