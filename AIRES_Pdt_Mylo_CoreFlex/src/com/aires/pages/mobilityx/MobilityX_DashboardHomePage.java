package com.aires.pages.mobilityx;

import java.text.MessageFormat;
import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.DefaultAuthForm;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.GlobalReloAuthorizationInfo;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.GlobalReloEmpIdentificationInfo;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.GlobalReloFamilyInfo;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.GlobalReloFinancialInfo;
import com.aires.testdatatypes.mobilityx.MobilityX_AuthorizationData.GlobalReloTransferInfo;
import com.aires.utilities.ClientPolicyDetails;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class MobilityX_DashboardHomePage extends Base {
	public MobilityX_DashboardHomePage(WebDriver driver) {
		super(driver);
	}

	// Create an Authorization Link
	@FindBy(how = How.ID, using = "ot1")
	private WebElement _linkAuthorization;

	// Continue Button
	@FindBy(how = How.CSS, using = "#stec1 > a")
	private WebElement _btnContinue;

	// Employee Name dialog Title Text
	@FindBy(how = How.ID, using = "stot1")
	private WebElement _titleTextDialogEmployeeName;

	// Employee First Name
	@FindBy(how = How.CSS, using = "input[placeholder='First Name*']")
	private WebElement _txtBoxEmpFirstName;

	// Employee Last Name
	@FindBy(how = How.CSS, using = "input[placeholder='Last Name*']")
	private WebElement _txtBoxEmpLastName;

	// iFrame - Employee Details
	@FindBy(how = How.CSS, using = "iframe[id*= 'j_id']")
	private WebElement _iframeEmployeName;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Manually input employee information')][@class='p_OraHiddenLabel']")
	private WebElement _radioBtnManuallyInput;

	@FindBy(how = How.CSS, using = "div[class='RXModal af_panelGroupLayout']")
	private WebElement _selectNewTransfereePage;

	@FindBy(how = How.ID, using = "crtot7")
	private WebElement _titleText_AuthorizationNextStep;

	// Option1 - A New Transfer or assignment Link
	@FindBy(how = How.CSS, using = "span[id='cdot2']")
	private WebElement _link_ANewTransfer;

	// FirstName on AuthForm
	@FindBy(how = How.CSS, using = "input[id*='firstName::content']")
	private WebElement _txtBoxFirstNameOnAuthForm;

	// Lastname on AuthForm
	@FindBy(how = How.CSS, using = "input[id*='lastName::content']")
	private WebElement _txtBoxLastNameOnAuthForm;

	@FindBy(how = How.CSS, using = "select.af_selectOneChoice_content")
	private WebElement _drpdown_AuthorizationFormTemplate;

	@FindBy(how = How.ID, using = "ctot1")
	private WebElement _titleAuthorizationForm;

	@FindBy(how = How.CSS, using = "div.RXPrimaryButton.af_button.p_AFTextOnly")
	private WebElement _btn_Continue_AuthorizationForm;

	private boolean _isDisplayed = false;
	final By _headingText_ByLocator = By.cssSelector("span#ctot1");

	// Employee Id on AuthForm
	@FindBy(how = How.CSS, using = "input[id*='employeeID::content']")
	private WebElement _txtBoxEmployeeId;

	// Office Telephone on AuthForm
	@FindBy(how = How.CSS, using = "input[id*='officePhone::content']")
	private WebElement _txtBoxOfficePhone;

	// Email
	@FindBy(how = How.CSS, using = "input[placeholder='E-mail*']")
	private WebElement _txtBoxEmail;

	// Gender
	@FindBy(how = How.CSS, using = "select[id*='gender::content']")
	private WebElement _drpDownGender;

	// Origin City - Text Field
	@FindBy(how = How.CSS, using = "input[id*='originCity']")
	private WebElement _txtBoxOriginCity;

	@FindBy(how = How.CSS, using = "input[id*='destCity']")
	private WebElement _txtBoxDestCity;

	@FindBy(how = How.CSS, using = "select[id*='originCountry']")
	private WebElement _drpDownoriginCountry;

	@FindBy(how = How.CSS, using = "select[id*='destCountry::content']")
	private WebElement _drpDowndestinationCountry;

	@FindBy(how = How.CSS, using = "label[id*='empAssign'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioBtnEmpCurrentlyOnAssignment;

	@FindBy(how = How.CSS, using = "select[id*='homeCtry::content']")
	private WebElement _drpDownHomeCountry;

	@FindBy(how = How.CSS, using = "input[name='homeStatus']+label")
	private List<WebElement> _homeStatus;

	@FindBy(how = How.CSS, using = "select[id*='dualCitizenYN::content']")
	private WebElement _drpDownDualCitizenShip;

	@FindBy(how = How.CSS, using = "select[id*='dowRegionCode::content']")
	private WebElement _drpDownReceivingRegion;

	@FindBy(how = How.CSS, using = "label[id*='relateProject'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioBtnProjectRelated;

	@FindBy(how = How.CSS, using = "select[id*='relocationPolicy']")
	private WebElement _relocationPolicy;

	@FindBy(how = How.CSS, using = "input[id*='startDate']")
	private WebElement _txtBoxStartDateInNewLocation;

	@FindBy(how = How.CSS, using = "input[id*='endDate']")
	private WebElement _txtBoxAssignmentEndDate;

	@FindBy(how = How.CSS, using = "input[id*='businessGroup']")
	private WebElement _txtBoxBusinessGroup;

	@FindBy(how = How.CSS, using = "input[id*='jobFamily']")
	private WebElement _txtBoxJobFamily;

	@FindBy(how = How.CSS, using = "select[id*='payRollCode']")
	private WebElement _drpDownPayRoll;

	@FindBy(how = How.CSS, using = "select[id*='rfgl']")
	private WebElement _drpDownRFGL;

	@FindBy(how = How.CSS, using = "input[id*='costCenter']")
	private WebElement _txtBoxCostCenter;

	@FindBy(how = How.CSS, using = "input[id*='origHostCostCtr']")
	private WebElement _txtBoxTafCostCenter;

	@FindBy(how = How.CSS, using = "label[id*='marriageStatus'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioBtnMaritalStatus;

	@FindBy(how = How.CSS, using = "select[id*='gcHolder::content']")
	private WebElement _drpDownGreenCardHolder;

	@FindBy(how = How.CSS, using = "label[id*='isSpouseEmployed'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioBtnIsSpouseEmployed;

	@FindBy(how = How.CSS, using = "input[id*='authorizedBy']")
	private WebElement _txtBoxAuthorizedBy;

	@FindBy(how = How.CSS, using = "select[id*='homeMobPartner']")
	private WebElement _drpDownHomeMobPartner;

	@FindBy(how = How.CSS, using = "input[id*='levelOneName']")
	private WebElement _txtBoxLevelOneManagerName;

	@FindBy(how = How.CSS, using = "input[id*='levelOneEmail']")
	private WebElement _txtBoxLevelOneManagerEmail;

	@FindBy(how = How.CSS, using = "input[id*='managerId']")
	private WebElement _txtBoxLevelOneManagerId;

	@FindBy(how = How.CSS, using = "input[id*='hrManagerName']")
	private WebElement _txtBoxHrManagerName;

	@FindBy(how = How.CSS, using = "input[id*='hrManagerEmail']")
	private WebElement _txtBoxHrManagerEmail;

	@FindBy(how = How.CSS, using = "input[id*='hrManagerId::content']")
	private WebElement _txtBoxHrManagerID;

	@FindBy(how = How.CSS, using = "input[id*='sponsorName']")
	private WebElement _txtBoxSponsorName;

	@FindBy(how = How.CSS, using = "input[id*='sponsorEmail']")
	private WebElement _txtBoxSponsorEmail;

	@FindBy(how = How.CSS, using = "input[id*='sponsorID']")
	private WebElement _txtBoxSponsorId;

	@FindBy(how = How.XPATH, using = "//label[text()='Employee Identification']")
	private WebElement _lblEmpIdentification;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submit to Aires')]")
	private WebElement _buttonSubmitToAires;

	@FindBy(how = How.CSS, using = "img[src*='ajax-loader.gif']")
	private WebElement _imgSpinner;

	@FindBy(how = How.CSS, using = "div#uiBusyPopup")
	private WebElement _busyPopUp;

	// Dialog - Success Message - New Transferee Creation
	@FindBy(how = How.XPATH, using = "//div[@id='growls']/div")
	private WebElement _dialogSuccessMessage;

	@FindBy(how = How.XPATH, using = "//*[@id='growls']//div[@class='growl-message']")
	private WebElement _txtGrowlMessage;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'openUserProfileText')]")
	private WebElement _txt_userNameTitle;

	@FindBy(how = How.CSS, using = "[id$=logoutText]")
	private WebElement _link_logout;

	@FindBy(how = How.CSS, using = "img[src*='basicloader.gif']")
	private WebElement _imgBasicLoader;

	final By _growlMessageByLocator = By.className("growl-message");
	final By _closeGrowlMessageByLocator = By.className("growl-close");
	final By _txtUserNameTitleByLocator = By.xpath("//*[contains(@id,'openUserProfileText')]");
	final By _txtLogoutByLocator = By.cssSelector("[id$=logoutText]");
	final By _loadingPopUpByLocator = By.id("busyStateMessage");
	final By _busyPopUpByLocator = By.cssSelector("div#uiBusyPopup");
	final By _costCenterByLocator = By.cssSelector("input[id*='costCenter']");

	public void enterEmpFirstAndLastNameForNewAuthorization() {
		try {
			BusinessFunctions.generateUniqueValuesAndWriteToConfig(5);
			if (CoreFunctions.isElementExist(driver, _imgBasicLoader, 4))
				BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgBasicLoader);
			CoreFunctions.clickUsingJS(driver, _linkAuthorization, _linkAuthorization.getText());
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _btnContinue, _btnContinue.getText());
			if (!selectUploadOrManualOption()) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleTextDialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			}
			// Enter Employee First Name and Last Name
			CoreFunctions.clearAndSetText(driver, _txtBoxEmpFirstName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT));
			CoreFunctions.clearAndSetText(driver, _txtBoxEmpLastName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
			// Click Continue button
			CoreFunctions.click(driver, _btnContinue, _btnContinue.getText());
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void enterEmpFirstAndLastNameForNewAuthorization(String fName, String lName, String type) {
		try {
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgBasicLoader);
			CoreFunctions.clickUsingJS(driver, _linkAuthorization, _linkAuthorization.getText());
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _btnContinue, _btnContinue.getText());
			if (!selectUploadOrManualOption())
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleTextDialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxEmpLastName,
					MYLOConstants.TRANSFEREE_FIRST_NAME);
			String tLastName = BusinessFunctions.setMyloInputFields(driver, MYLOConstants.TRANSFEREE_LAST_NAME, lName,
					_txtBoxEmpLastName, type);
			CoreFunctions.writeToPropertiesFile(MobilityXConstants.LAST_NAME_TEXT,
					tLastName.substring(0, 1).toUpperCase() + tLastName.substring(1));
			String tFirstName = BusinessFunctions.setMyloInputFields(driver, MYLOConstants.TRANSFEREE_FIRST_NAME, fName,
					_txtBoxEmpFirstName, type);
			CoreFunctions.writeToPropertiesFile(MobilityXConstants.FIRST_NAME_TEXT,
					tFirstName.substring(0, 1).toUpperCase() + tFirstName.substring(1));
			CoreFunctions.click(driver, _btnContinue, _btnContinue.getText());
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void switchToiFrame_Authorization() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _iframeEmployeName, MobilityXConstants.IFRAME,
					MYLOConstants.CUSTOM_WAIT_TIME);
			driver.switchTo().frame(_iframeEmployeName);
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

	public boolean selectUploadOrManualOption() {
		_isDisplayed = CoreFunctions.verifyElementPresentOnPage(_radioBtnManuallyInput,
				MobilityXConstants.CREATE_AN_AUTHORIZATION);
		if (_isDisplayed) {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _radioBtnManuallyInput,
					_radioBtnManuallyInput.getText());
			CoreFunctions.click(driver, _radioBtnManuallyInput, _radioBtnManuallyInput.getText());
		} else
			Log.info("Fail: to select the options");
		return _isDisplayed;
	}

	public void selectAuthorizationOptionForEmployee(String option) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _selectNewTransfereePage,
					MobilityXConstants.IFRAME_TITLE, MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _titleText_AuthorizationNextStep,
					MobilityXConstants.IFRAME_TITLE);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_AuthorizationNextStep).toLowerCase(),
					(MobilityXConstants.THIS_NEW_AUTHORIZATION_FOR_TEXT
							+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT)
							+ MobilityXConstants.IS_TEXT).toLowerCase(),
					MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.TITLE
							+ MobilityXConstants.IS_NOT_DISPLAYED);
			CoreFunctions.highlightObject(driver, _titleText_AuthorizationNextStep);

			switch (option) {
			case MobilityXConstants.NEW_TRANSFER_ASSIGNMENT:
				CoreFunctions.clickUsingJS(driver, _link_ANewTransfer, MobilityXConstants.NEW_TRANSFER_ASSIGNMENT_LINK);
				CoreFunctions.waitUntilBrowserReady(driver);
				break;
			default:
				Assert.fail(option + MobilityXConstants.NOT_EXIST);
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void fillAuthFormBasedOnTemplate(MobilityX_AuthorizationData authorizationData, String templateName) {
		// CoreFunctions.waitHandler(12);
		// BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgSpinner);
		/*
		 * if (CoreFunctions.isElementByLocatorExist(driver, _loadingPopUpByLocator,
		 * 10)) BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgSpinner);
		 */
		authFormExists(templateName);
		switch (templateName) {
		case MobilityXConstants.TEMPLATE_GLOBAL_RELOCATION_AUTH:
			fillGlobalReloEmployeeIdentificationInfo(authorizationData.globalReloEmpIdentificationInfo);
			fillGlobalReloTransferInfo(authorizationData.globalReloTransferInfo);
			fillGlobalReloFinancialInfo(authorizationData.globalReloFinancialInfo);
			fillGlobalReloFamilyInfo(authorizationData.globalReloFamilyInfo);
			fillGlobalReloAuthorizationInfo(authorizationData.globalReloAuthInfo);
			submitToAires();
			break;
		case MobilityXConstants.DEFAULT_AUTH_FORM:
			fillDefaultAuthFormTemplate(authorizationData.defaultAuthForm);
			submitToAires();
			break;
		default:
			break;
		}
	}

	public void fillDefaultAuthFormTemplate(DefaultAuthForm defaultAuthForm) {
		BusinessFunctions.selectOptionValueFromDropdown(_relocationPolicy, defaultAuthForm.relocationPolicy);
		CoreFunctions.clearAndSetText(driver, _txtBoxOriginCity, defaultAuthForm.originCity);
		BusinessFunctions.selectValueFromDropdown(_drpDownoriginCountry, defaultAuthForm.originCountry);
		CoreFunctions.clearAndSetText(driver, _txtBoxDestCity, defaultAuthForm.destinationCity);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _homeStatus, defaultAuthForm.homeStatus);
		BusinessFunctions.selectValueFromDropdown(_drpDowndestinationCountry, defaultAuthForm.destinationCountry);
	}

	public void fillGlobalReloEmployeeIdentificationInfo(GlobalReloEmpIdentificationInfo employeeInfo) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _lblEmpIdentification, "Employee Identification");
			CoreFunctions.clearAndSetText(driver, _txtBoxEmployeeId, employeeInfo.employeeId);
			CoreFunctions.clearAndSetText(driver, _txtBoxOfficePhone, employeeInfo.officePhone);
			CoreFunctions.clearAndSetText(driver, _txtBoxEmail, employeeInfo.email);
			BusinessFunctions.selectValueFromDropdown(_drpDownGender, employeeInfo.gender);
			CoreFunctions.clearAndSetText(driver, _txtBoxOriginCity, employeeInfo.originCity);
			BusinessFunctions.selectValueFromDropdown(_drpDownoriginCountry, employeeInfo.originCountry);
			CoreFunctions.waitHandler(3);
			BusinessFunctions.selectValueFromDropdown(_drpDowndestinationCountry, employeeInfo.destinationCountry);
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioBtnEmpCurrentlyOnAssignment,
					employeeInfo.empCurrentlyOnAssignment);

			try {
				BusinessFunctions.selectValueFromDropdown(_drpDownHomeCountry, employeeInfo.homeCountry);
			} catch (StaleElementReferenceException e) {
				WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));

				BusinessFunctions.selectValueFromDropdown(
						wait.until(ExpectedConditions
								.refreshed(ExpectedConditions.elementToBeClickable(_drpDownHomeCountry))),
						employeeInfo.homeCountry);
			}

			BusinessFunctions.selectValueFromDropdown(_drpDownDualCitizenShip, employeeInfo.dualCitizenShip);
		} catch (ElementNotFoundException e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void fillGlobalReloTransferInfo(GlobalReloTransferInfo transferInfo) {
		try {
			BusinessFunctions.selectValueFromDropdown(_drpDownReceivingRegion, transferInfo.receivingRegion);
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioBtnProjectRelated, transferInfo.projectRelated);
			BusinessFunctions.selectOptionValueFromDropdown(_relocationPolicy,
					ClientPolicyDetails.getPolicyName().replace("(", "").replace(")", "").split("#")[0].trim());
			CoreFunctions.waitHandler(3);
			CoreFunctions.clearAndSetText(driver, _txtBoxStartDateInNewLocation, CoreFunctions.getcurrentdate());
			CoreFunctions.waitHandler(3);
			CoreFunctions.clearAndSetText(driver, _txtBoxAssignmentEndDate,
					CoreFunctions.addDaysMonthYearToCurrentDate(MobilityXConstants.YEAR, "dd-MMM-yyyy", 1));
			CoreFunctions.waitHandler(3);
			CoreFunctions.clearAndSetText(driver, _txtBoxBusinessGroup, transferInfo.businessGroup);
			CoreFunctions.waitHandler(3);
			CoreFunctions.clearAndSetText(driver, _txtBoxJobFamily, transferInfo.jobFamily);

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void fillGlobalReloFamilyInfo(GlobalReloFamilyInfo familyInfo) {
		try {
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioBtnMaritalStatus, familyInfo.maritalStatus);
			BusinessFunctions.selectValueFromDropdown(_drpDownGreenCardHolder, familyInfo.greenCardHolder);
			// CoreFunctions.clearAndSetText(driver, _txtBoxStartDateInNewLocation,
			// familyInfo.startDateInNewLocation);
			BusinessFunctions.selectRadioAsPerLabelText(driver, _radioBtnIsSpouseEmployed, familyInfo.isSpouseEmployed);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void fillGlobalReloFinancialInfo(GlobalReloFinancialInfo financialInfo) {
		try {
			BusinessFunctions.selectValueFromDropdown(_drpDownPayRoll, financialInfo.payRoll);
			BusinessFunctions.selectValueFromDropdown(_drpDownRFGL, financialInfo.rfgl);
			CoreFunctions.waitHandler(5);
			if (CoreFunctions.isElementByLocatorClickable(driver, _costCenterByLocator, 10)) {
				CoreFunctions.waitHandler(3);
				CoreFunctions.clearAndSetText(driver, _txtBoxCostCenter, financialInfo.costCenter);
			}
			CoreFunctions.waitHandler(3);
			CoreFunctions.clearAndSetText(driver, _txtBoxTafCostCenter, financialInfo.tafCostCenter);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void fillGlobalReloAuthorizationInfo(GlobalReloAuthorizationInfo authorizationInfo) {
		try {
			CoreFunctions.clearAndSetText(driver, _txtBoxAuthorizedBy, authorizationInfo.authorizedBy);
			BusinessFunctions.selectValueFromDropdown(_drpDownHomeMobPartner, authorizationInfo.homeMobilityPartner);
			CoreFunctions.clearAndSetText(driver, _txtBoxLevelOneManagerName, authorizationInfo.levelOneManagerName);
			CoreFunctions.clearAndSetText(driver, _txtBoxLevelOneManagerEmail, authorizationInfo.levelOneManagerEmail);
			CoreFunctions.clearAndSetText(driver, _txtBoxLevelOneManagerId, authorizationInfo.levelOneManagerId);
			CoreFunctions.clearAndSetText(driver, _txtBoxHrManagerName, authorizationInfo.hrManagerName);
			CoreFunctions.clearAndSetText(driver, _txtBoxHrManagerEmail, authorizationInfo.hrManagerEmail);
			CoreFunctions.clearAndSetText(driver, _txtBoxHrManagerID, authorizationInfo.hrManagerId);
			CoreFunctions.clearAndSetText(driver, _txtBoxSponsorName, authorizationInfo.sponsorName);
			CoreFunctions.clearAndSetText(driver, _txtBoxSponsorEmail, authorizationInfo.sponsorEmail);
			CoreFunctions.clearAndSetText(driver, _txtBoxSponsorId, authorizationInfo.sponsorId);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public boolean authFormExists(String templateName) {
		_isDisplayed = CoreFunctions.isElementByLocatorExist(driver, _headingText_ByLocator, 7);
		if (_isDisplayed) {
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.IS_DISPLAYED);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleAuthorizationForm),
					MobilityXConstants.AUTHORIZATION_FORM_TITLE_TEXT, MobilityXConstants.AUTHORIZATION_FORM_TITLE
							+ MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
			BusinessFunctions.selectValueFromDropdown(_drpdown_AuthorizationFormTemplate, templateName);
			CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, _btn_Continue_AuthorizationForm.getText());
			CoreFunctions.waitUntilBrowserReady(driver);
			/*
			 * if (CoreFunctions.isElementByLocatorExist(driver, _loadingPopUpByLocator,
			 * 10)) BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _imgSpinner);
			 */
			// BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _busyPopUp);
			driver.switchTo().defaultContent();
		} else
			Log.info(MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.NOT_EXIST);
		return _isDisplayed;
	}

	public void submitToAires() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
				_buttonSubmitToAires.getText());
		CoreFunctions.click(driver, _buttonSubmitToAires, _buttonSubmitToAires.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public boolean verifySuccessDialogDisplayed() {
		try {
			if (CoreFunctions.isElementByLocatorExist(driver, _growlMessageByLocator, 25)) {
				Reporter.addStepLog(
						CoreConstants.PASS + CoreConstants.VRFIED_THAT + MobilityXConstants.SUCCESS_MESSAGE_TEXT
								+ CoreConstants.IS_DISPLAYED_AS + "<b>\"" + _dialogSuccessMessage.getText() + "\"</b>");
				CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _closeGrowlMessageByLocator);
				CoreFunctions.writeToPropertiesFile("assignmentSubmitStatus", "true");
				Log.info("assignmentSubmitStatus==" + CoreFunctions.getPropertyFromConfig("assignmentSubmitStatus"));
				return true;
			}
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.GROWL_MESSAGE_NOT_MATCHED, CoreConstants.FAIL,
					_txtGrowlMessage.getText()));
			CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, _growlMessageByLocator);
		} catch (Exception e) {
			Log.info("Exception :" + e);
			return false;
		}
		return false;
	}

	public void logout() {
		try {
			if (CoreFunctions.isElementByLocatorClickable(driver, _txtUserNameTitleByLocator, 30)) {
				_txt_userNameTitle.click();
			}
			if (CoreFunctions.isElementByLocatorClickable(driver, _txtLogoutByLocator, 30)) {
				_link_logout.click();
			}
		} catch (ElementNotFoundException e) {
			Log.info(CoreConstants.ERROR + e.getStackTrace());
		}
	}
}
