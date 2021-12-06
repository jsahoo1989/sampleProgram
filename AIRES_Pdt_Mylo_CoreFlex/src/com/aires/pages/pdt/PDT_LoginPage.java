package com.aires.pages.pdt;


import java.text.MessageFormat;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_LoginData;
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
	@FindBy(how = How.CSS, using = "img[src='assets/img/aires.png']")
	private WebElement _imgAIRESLogo;

	// Aires Policy Tool
	@FindBy(how = How.XPATH, using = "//h1[text()='Aires Policy Tool']")
	private WebElement _txtAiresPolicyTool;

	PDT_LoginData loginData = FileReaderManager.getInstance().getJsonReader()
			.getloginDetailsByUserFirstName(PDTConstants.USER_FIRST_NAME);

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
		Log.info(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl());
		CoreFunctions.waitForBrowserToLoad(driver);		
		VerifyAIRESLogo();
	}

	public void enterLoginCredentials(String userName, String password) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _inputUserName,
					_inputUserName.getAttribute("placeholder"));
			CoreFunctions.clearAndSetText(driver, _inputUserName, _inputUserName.getAttribute("name"), userName);
			CoreFunctions.clearAndSetText(driver, _inputPassword, _inputPassword.getAttribute("name"), password);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
	}

	public void clickLoginBtn() {
		CoreFunctions.click(driver, _btnLogin, _btnLogin.getText());
	}
	
	public void verifyLoginCredentials() {
		if (CoreFunctions.isElementByLocatorExist(driver, _btnLoginByLocator, 1)) {
			Assert.fail(PDTConstants.INVALID_CREDENTIALS_ENTERED);
		}
	}

	public boolean loginByUserType(String userType, PDT_ViewPolicyPage viewPolicyPage) {
		
		boolean isSuccessfullyLoggedIn = false;
		
		try {
			openApplication();

			switch (userType) {
			case PDTConstants.CSM:
				enterLoginCredentials(loginData.CSMUserName, loginData.CSMPassword);
				clickLoginBtn();
				isSuccessfullyLoggedIn = viewPolicyPage.verifyUserlogin(loginData.CSMFullName,
						PDTConstants.VIEW_POLICY_PAGE);
				break;
			default:
				Assert.fail(PDTConstants.TEXT_NOT_FOUND);
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
