package com.aires.pages.mobilityx;

import java.text.MessageFormat;
import java.util.List;

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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.DefaultAuthForm;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class MobilityX_AuthorizationPage extends Base {
	public MobilityX_AuthorizationPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[id='aRegion:0:ID_1_main'] input")
	private List<WebElement> _authPageInputFields;

	@FindBy(how = How.CSS, using = "div[id='aRegion:0:ID_1_main'] select")
	private List<WebElement> _authPageDropdownFields;

	@FindBy(how = How.CSS, using = "input[name='homeStatus']+label")
	private List<WebElement> _homeStatus;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submit to Aires')]")
	private WebElement _buttonSubmitToAires;

	@FindBy(how = How.CSS, using = "select.af_selectOneChoice_content")
	private WebElement _drpdown_AuthorizationFormTemplate;

	@FindBy(how = How.CSS, using = "div.RXPrimaryButton.af_button.p_AFTextOnly")
	private WebElement _btn_Continue_AuthorizationForm;

	@FindBy(how = How.ID, using = "ctot1")
	private WebElement _titleAuthorizationForm;

	@FindBy(how = How.CSS, using = "div[id='growls'] div")
	private WebElement _dialogSuccessMessage;

	@FindBy(how = How.XPATH, using = "//*[@id='growls']//div[@class='growl-message']")
	private WebElement _txtGrowlMessage;
	
	@FindBy(how = How.CSS, using = "iframe[id*='j_id']")
	private WebElement _foundSimilarEmpFrame;
	
	@FindBy(how = How.CSS, using = "img[src*='ajax-loader.gif']")
	private WebElement _imgSpinner;
	
	@FindBy(how = How.CSS, using = "div[class='RXModalTitle af_panelGroupLayout'] span[class='RXBiggerText']")
	private WebElement _foundSimilarEmpTitle;
	
	private final By _similarEmployeeOption = By.cssSelector("li[class='aircomplete-list-item']");
	private final By _headingText = By.cssSelector("span#ctot1");
	private final By _growlMessageByLocator = By.className("growl-message");
	private final By _closeGrowlMessageByLocator = By.className("growl-close");
	private	final By _busyPopUpByLocator = By.cssSelector("div#uiBusyPopup");
	private final By _loadingPopUpByLocator = By.id("busyStateMessage");
	
	public String setAuthPageInputFields(String fieldName, String fieldValue, String type, String section) {
		String updatedValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_authPageInputFields, fieldName, MYLOConstants.PLACEHOLDER);
			updatedValue = BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, fieldElement, type);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MobilityXConstants.AUTHORIZATION_PAGE));
		}
		return updatedValue;
	}

	public String setAuthPageDropdownValues(String fieldName, String fieldValue) {
		String updatedValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_authPageDropdownFields, fieldName, MYLOConstants.TITLE);
			BusinessFunctions.selectOptionValueFromDropdown(fieldElement, fieldValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MobilityXConstants.AUTHORIZATION_PAGE));
		}
		return updatedValue;
	}

	public void selectAuthFormTemplate(String templateName) {
		try {
			BusinessFunctions.selectValueFromDropdown(_drpdown_AuthorizationFormTemplate, templateName);
			CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, _btn_Continue_AuthorizationForm.getText());
			CoreFunctions.waitUntilBrowserReady(driver);
			driver.switchTo().defaultContent();
		} catch (Exception e) {

		}
	}

	public boolean verifyAuthFormTitle() {
		boolean flag = false;
		if (CoreFunctions.isElementByLocatorExist(driver, _headingText, 7))
			flag = CoreFunctions.getElementText(driver, _titleAuthorizationForm)
					.equals(MobilityXConstants.AUTHORIZATION_FORM_TITLE_TEXT);
		if (flag)
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.IS_DISPLAYED);
		return flag;
	}

	public void fillAuthFormBasedOnTemplate(MobilityX_AuthorizationData authorizationData, String templateName) {
		driver.switchTo().defaultContent();
		switch (templateName) {
		case MobilityXConstants.DEFAULT_AUTH_FORM:
			fillDefaultAuthFormTemplate(authorizationData.defaultAuthForm);
			break;
		default:
			Assert.fail("Please provide the correct template name");
		}
	}

	public void fillDefaultAuthFormTemplate(DefaultAuthForm defaultAuthForm) {
		setAuthPageDropdownValues(MobilityXConstants.RELOCATION_POLICY, defaultAuthForm.relocationPolicy);
		setAuthPageInputFields(MYLOConstants.ORIGIN_CITY, defaultAuthForm.originCity, MYLOConstants.VALUE,
				MobilityXConstants.AUTHORIZATION_PAGE);
		setAuthPageDropdownValues(MYLOConstants.ORIGIN_COUNTRY, defaultAuthForm.originCountry);
		setAuthPageInputFields(MYLOConstants.DESTINATION_CITY, defaultAuthForm.destinationCity, MYLOConstants.VALUE,
				MobilityXConstants.AUTHORIZATION_PAGE);
		setAuthPageDropdownValues(MYLOConstants.DESTINATION_COUNTRY, defaultAuthForm.destinationCountry);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _homeStatus, defaultAuthForm.homeStatus);
	}

	public void submitToAires() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
				_buttonSubmitToAires.getText());
		CoreFunctions.click(driver, _buttonSubmitToAires, _buttonSubmitToAires.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public boolean verifySuccessDialogDisplayed() {
		boolean flag = false;
		String tName = CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + MYLOConstants.SPACE
				+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT);
		try {
			if (CoreFunctions.isElementByLocatorExist(driver, _growlMessageByLocator, MYLOConstants.CUSTOM_WAIT_TIME)) {
				String expectedText = "The initiation for " + tName
						+ " is in the submission process. You will receive an email notification when the initiation has been successfully submitted.";
				String actualText = CoreFunctions.getElementText(driver, _dialogSuccessMessage);
				System.out.println(expectedText);
				System.out.println(actualText);
				flag = actualText.toLowerCase().contains(expectedText.toLowerCase());
				CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _closeGrowlMessageByLocator);
				CoreFunctions.writeToPropertiesFile("assignmentSubmitStatus", "true");
				Log.info("assignmentSubmitStatus==" + CoreFunctions.getPropertyFromConfig("assignmentSubmitStatus"));
				CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _growlMessageByLocator);
			}
			if (flag)
				Reporter.addStepLog(CoreConstants.PASS + CoreConstants.VRFIED_THAT
						+ MobilityXConstants.SUCCESS_MESSAGE_TEXT + CoreConstants.IS_DISPLAYED_AS
						+ MessageFormat.format(MobilityXConstants.AUTH_FORM_SUBMIT_MSG, tName));
		} catch (Exception e) {
			Assert.fail();
		}
		return flag;
	}
	
	public void switchToiFrame_Authorization() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _foundSimilarEmpFrame, MobilityXConstants.IFRAME,
					MYLOConstants.CUSTOM_WAIT_TIME);
			driver.switchTo().frame(_foundSimilarEmpFrame);
			Log.info("busy pop-up id==" + CoreFunctions.isElementByLocatorExist(driver, _busyPopUpByLocator, 10));
			if (CoreFunctions.isElementByLocatorExist(driver, _loadingPopUpByLocator, 10)) {
				Log.info("inside loading pop up locator");
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgSpinner);
			} else {
				Log.info("inside else condition of loading pop up locator");
			}

		} catch (ElementNotFoundException e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}
	
	public void selectOptionForSimilarEmployees(String option) {
		driver.switchTo().defaultContent();
		switchToiFrame_Authorization();
		CoreFunctions.click(driver, _drpdown_AuthorizationFormTemplate, option);
		CoreFunctions.highlightObject(driver, _foundSimilarEmpTitle);
		List<WebElement> elementList = CoreFunctions.getElementListByLocator(driver, _similarEmployeeOption);
		WebElement element =CoreFunctions.returnItemInListByText(driver, elementList, option);
		CoreFunctions.hoverAndClick(driver, element, option);
		CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, _btn_Continue_AuthorizationForm.getText());
		CoreFunctions.waitUntilBrowserReady(driver);	
	}

}
