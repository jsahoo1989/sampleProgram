package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.List;

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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.AuthTypeInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.AuthorizationInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.BscEmployeeInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.RelocationInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.ReportingInfo;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Client_AuthorizationHomePage extends Base {

	public MX_Client_AuthorizationHomePage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'airesBrand')]/parent::td/following-sibling::td/span[contains(@class,'RXSmallText')]")
	private WebElement _textClientName;

	@FindBy(how = How.CSS, using = "span[id*='UserProfileText']")
	private WebElement _textClientUserNameTitle;

	// Create an Authorization Link
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Create an authorization')]")
	private WebElement _linkCreateAnAuthorization;

	// Initiation For Transferee Text
	@FindBy(how = How.CSS, using = "span[id*='HeaderEEPanel']")
	private WebElement _textInitiationFor;

	// CookiePopUp
	@FindBy(how = How.ID, using = "cookiePupupButtonId")
	private WebElement _btn_OkOnSiteCookieAfterLogin;

	// iFrame - Employee Details
	@FindBy(how = How.CSS, using = "iframe[id*='j_id']")
	private WebElement _iframe_EmployeName;

	// Employee Name dialog Title Text
	@FindBy(how = How.ID, using = "stot1")
	private WebElement _titleText_dialogEmployeeName;

	// Employee First Name
	@FindBy(how = How.CSS, using = "span[id='fname'] > input[id='fname::content']")
	private WebElement _txt_EmpFirstName;

	// Employee Last Name
	@FindBy(how = How.CSS, using = "span[id='lname'] > input[id='lname::content']")
	private WebElement _txt_EmpLastName;

	// Continue Button
	@FindBy(how = How.CSS, using = "#stec1 > a")
	private WebElement _button_Continue;

	// Authorization Next Step dialog Title 'This new authorization for <First Name>
	// is:'
	@FindBy(how = How.ID, using = "crtot7")
	private WebElement _titleText_AuthorizationNextStep;

	// Option1 - A New Transfer or assignment Link
	@FindBy(how = How.CSS, using = "span[id='cdot2']")
	private WebElement _link_ANewTransfer;

	// Authorization Type - Authorized Initation Radio Button checked
	@FindBy(how = How.CSS, using = "input[id*='authorizationType']")
	private WebElement _radioButton_AuthorizedInitation;

	@FindBy(how = How.CSS, using = "input[id*='preMoveSalary']")
	private WebElement _txt_PreMoveSalary;

	// Origin City - Text Field
	@FindBy(how = How.CSS, using = "input[id*='originCity']")
	private WebElement _txt_OriginCity;

	// Employee Email - Text Field
	@FindBy(how = How.CSS, using = "input[id*='email']")
	private WebElement _txt_employeeEmail;

	@FindBy(how = How.CSS, using = "input[id*='newJobTitle']")
	private WebElement _txt_jobTitle;

	// Radio Button Label List - Authorization Type
	@FindBy(how = How.CSS, using = "span[class='af_selectBooleanRadio_content-input'] > label")
	private List<WebElement> _radioButtonLabel_listForAll;

	// Radio Button Immigration Type
	@FindBy(how = How.CSS, using = "label[id*='immigration'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioButtonLabel_Immigration;

	// Text Employee ID
	@FindBy(how = How.CSS, using = "input[id*='employeeID']")
	private WebElement _txt_EmployeeID;

	// Button - Submit To Aires
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Submit to Aires')]")
	private WebElement _buttonSubmitToAires;

	@FindBy(how = How.ID, using = "aRegion:0:nlWindow::close")
	private WebElement _closeTeamComments;

	// Add Contributor in floating menu
	@FindBy(how = How.ID, using = "aRegion:0:floatingMenuIterator:2:displayName")
	private WebElement _floatingMenu_AddContributors;

	// Add Approver in floating menu
	@FindBy(how = How.CSS, using = "span.RXAuthFormFloatText")
	private List<WebElement> _floatingMenu_DisplayTextList;

	@FindBy(how = How.CSS, using = "select[id*='originState']")
	private WebElement _originState;

	@FindBy(how = How.CSS, using = "select[id*='originCountry']")
	private WebElement _originCountry;

	@FindBy(how = How.CSS, using = "select[id*='officeOrigin']")
	private WebElement _originOfficeCityState;

	@FindBy(how = How.CSS, using = "select[id*='destLocation']")
	private WebElement _destinationOfficeCityState;

	@FindBy(how = How.CSS, using = "select[id*='relocationPolicy']")
	private WebElement _relocationPolicy;

	@FindBy(how = How.CSS, using = "select[id*='assignmentType']")
	private WebElement _assignmentType;

	@FindBy(how = How.ID, using = "ctot1")
	private WebElement _titleAuthorizationForm;

	@FindBy(how = How.ID, using = "aRegion:0:authText")
	private WebElement _textauthorization;

	@FindBy(how = How.CSS, using = "div.RXPrimaryButton.af_button.p_AFTextOnly")
	private WebElement _btn_Continue_AuthorizationForm;

	@FindBy(how = How.ID, using = "estot6")
	private WebElement _title_UploadOrManualAuthorizationOption;

	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Manually input employee information')][@class='p_OraHiddenLabel']")
	private WebElement _radioButton_ManuallyInput;

	@FindBy(how = How.XPATH, using = "//span[text()='Collaboration']")
	private WebElement _tabCollaboration;

	@FindBy(how = How.XPATH, using = "//span[text()='Collaboration']")
	private WebElement _tabCollaboration_Selected;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back to search results')]")
	private WebElement _linkBackToSearchResults;

	@FindBy(how = How.CSS, using = "select[id='soctoc2::content']")
	private WebElement _drpdownAuthorizationFormTemplateCompanyName;

	@FindBy(how = How.CSS, using = "select[id='soc2::content']")
	private WebElement _drpdownAuthorizationFormTemplate;

	@FindBy(how = How.XPATH, using = "//span[text()='Go back to mobility journey']")
	private WebElement _linkGoBackToMobilityJourney;

	// Growl message in header
	@FindBy(how = How.XPATH, using = "//*[@id='growls']//div[@class='growl-message']")
	private WebElement _txtGrowlMessage;

	@FindBy(how = How.CSS, using = "input[id*='startDate']")
	private WebElement _inputStartDate;

	@FindBy(how = How.CSS, using = "input[id*='costCenter']")
	private WebElement _inputCostCenter;

	@FindBy(how = How.CSS, using = "select[id*='division']")
	private WebElement _selectDivision;

	@FindBy(how = How.CSS, using = "select[id*='businessGroup']")
	private WebElement _selectOperatingUnit;

	@FindBy(how = How.CSS, using = "input[id*='hiringManager']")
	private WebElement _hiringManagerName;

	@FindBy(how = How.XPATH, using = "//*[contains(@id,'wwproceedApproverListBtnwww')]/a")
	private WebElement _btnSubmitApprover;

	@FindBy(how = How.CSS, using = "label[id*='globalMobility'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioGlobalMobility;

	@FindBy(how = How.CSS, using = "label[id*='costEstimateReqInd'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioCostEstimate;

	@FindBy(how = How.CSS, using = "label[id*='authorizationType'][class='p_OraHiddenLabel']")
	private List<WebElement> _radioAuthorizationTypeList;

	@FindBy(how = How.CSS, using = "input[id*='hrManager']")
	private WebElement _hrManagerTextField;

	@FindBy(how = How.CSS, using = "select[id*='fundECName']")
	private WebElement _fundingECMember;

	@FindBy(how = How.CSS, using = "label[id*=authorizationType]")
	private List<WebElement> _airesInstructionsRadioList;

	@FindBy(how = How.XPATH, using = "//span[text()='Default Auth Form']")
	private WebElement _defaultAuthFormLabel;

	@FindBy(how = How.CSS, using = "select[id*='currState']")
	private WebElement _currentState;

	@FindBy(how = How.CSS, using = "select[id*='currCountry']")
	private WebElement _currentCountry;

	@FindBy(how = How.CSS, using = "input[id*='mobileTelephone']")
	private WebElement _txt_mobileTelephone;

	// Home Status Radio Button
	@FindBy(how = How.CSS, using = "label[id*='homeStatus'][class='p_OraHiddenLabel']")
	private List<WebElement> _homeStatusRadio;

	// Origin City - Text Field
	@FindBy(how = How.CSS, using = "input[id*='originAddress']")
	private WebElement _txt_OriginHomeAddress;

	@FindBy(how = How.CSS, using = "div[class='growl-message']")
	private WebElement _txt_GrowlMessage;

	@FindBy(how = How.CSS, using = "div[class='growl-close']")
	private WebElement _btn_GrowlClose;

	@FindBy(how = How.CSS, using = "div[id='growls'] > div")
	private WebElement _dialogSuccessMessage;

	@FindBy(how = How.XPATH, using = "//span[text()='Authorization']")
	private WebElement _tabAuthorizationText;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Create a budget')]")
	private WebElement _linkCreateBudgetTile;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'inactiveWorkflowTab')]//span[contains(text(),'Collaboration')]")
	private WebElement _linkCollaboration;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'RXAuthFormAutoSaveText')][contains(text(),'Saved')] | //span[contains(@class,'TextMessageHandler')][contains(text(),'All changes saved')]")
	private WebElement _txtAuthFormSaved;

	@FindBy(how = How.XPATH, using = "//span[contains(@class,'TextMessageHandler')][contains(text(),'Not yet saved')]")
	private WebElement _txtAuthFormNotSaved;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) input[id*='totalInput']")
	private WebElement _inputTotalPoints;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) span[class*='RXHeaderText']")
	private WebElement _textTotalPointsHeader;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] :not([style*='display:none']) span[class*='RXInputHint'] label[for*='totalInput']")
	private WebElement _labelTotalPointsInputHint;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class='RXHeaderText']")
	private WebElement _textFlexBenefitsHeader;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class='RXCFSmallText']")
	private WebElement _textFlexBenefitsDesc;

	@FindBy(how = How.CSS, using = "span[id*='coreFlex'] span[class*='button']")
	private WebElement _btnFlexBenefitSelection;

	@FindBy(how = How.CSS, using = "div[class='growl-message']")
	private WebElement _textGrowlMessage;

	@FindBy(how = How.CSS, using = "a[id*='activeAuthFormTab'] span[id*='AFErrorTextLabel'] label")
	private WebElement _textItemsNeedAttention;

	@FindBy(how = How.CSS, using = "span[id*='totalPoints'] span[id*='msgFortotalInput']:not([style*='display: none'])")
	private WebElement _textTotalPointsErrorMessage;

	@FindBy(how = How.XPATH, using = "//table[contains(@class,'ParaTitleContainer')]//label[contains(text(),'Authorization Type')]")
	private WebElement _textAuthTypeHeader;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to dashboard']")
	private WebElement _linkBackToDashboard;

	/**************************************************************************************************************/

	/**************************************************************************************************************/

	private boolean _isExists = false;
	String empName;
	private boolean _isDisplayed = false;

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigation() {
		try {
			return CoreFunctions.isElementExist(driver, _linkCreateAnAuthorization, 5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_MOBILITYX_CLIENT_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to verify navigated Page
	 */
	public boolean verifyPageNavigationToAuthForm() {
		try {
			String expectedIntiationForText = MobilityXConstants.INITIATION_FOR + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textInitiationFor,
					MobilityXConstants.INITIATION_FOR);
			CoreFunctions.verifyText(driver, _textInitiationFor, expectedIntiationForText,
					MobilityXConstants.INITIATION_FOR);
			CoreFunctions.highlightObject(driver, _textAuthTypeHeader);
			return CoreFunctions.isElementExist(driver, _textAuthTypeHeader, 2)
					&& CoreFunctions.isElementExist(driver, _linkBackToDashboard, 2);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_AUTH_FORM_PAGE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void handle_Cookie_AfterLogin() {
		CoreFunctions.waitForBrowserToLoad(driver);
		if (CoreFunctions.isElementExist(driver, _btn_OkOnSiteCookieAfterLogin, 15)) {
			HandleCookiePopUp(_btn_OkOnSiteCookieAfterLogin);
		}
	}

	public void HandleCookiePopUp(WebElement element) {
		boolean isExists = CoreFunctions.verifyElementPresentOnPage(element, MobilityXConstants.DAILOG_SITECOOKIE);
		if (isExists) {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, MobilityXConstants.DAILOG_SITECOOKIE);
			CoreFunctions.click(driver, element, MobilityXConstants.COOKIEDAILOG_OKBUTTON);
			CoreFunctions.explicitWaitTillElementInVisibility(driver, element);
			Log.info(MobilityXConstants.VERIFIED + MobilityXConstants.DAILOG_SITECOOKIE
					+ MobilityXConstants.IS_DISPLAYED + MobilityXConstants.ON_MOBILITYX_DASHBOARD_PAGE);
		} else
			Log.info(MobilityXConstants.SITE_COOKIE_DIALOG_NOT_DISPLAY);
	}

	public boolean verifyClientDetails(String userProfileName, String clientName) {
		boolean isClientDetailsVerified = false;
		try {
			CoreFunctions.verifyText(driver, _textClientUserNameTitle, userProfileName,
					MobilityXConstants.USER_PROFILE_NAME);
			CoreFunctions.verifyText(driver, _textClientName, clientName, MobilityXConstants.CLIENT_NAME);
			isClientDetailsVerified = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLIENT_DETAILS_ON_MOBILITYX_CLIENT_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			isClientDetailsVerified = false;
		}
		if (isClientDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_CLIENT_DETAILS_ON_MOBILITYX_CLIENT_HOME_PAGE,
					CoreConstants.PASS));
		}
		return isClientDetailsVerified;
	}

//	// Methods
	public boolean selectUploadOrManualOption() {
		_isDisplayed = CoreFunctions.verifyElementPresentOnPage(_radioButton_ManuallyInput,
				MobilityXConstants.CREATE_AN_AUTHORIZATION);
		if (_isDisplayed) {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _radioButton_ManuallyInput,
					_radioButton_ManuallyInput.getText());
			CoreFunctions.click(driver, _radioButton_ManuallyInput, _radioButton_ManuallyInput.getText());
		} else
			Log.info("Fail: to select the options");
		return _isDisplayed;
	}

	public void submitToAires() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
				_buttonSubmitToAires.getText());
		CoreFunctions.click(driver, _buttonSubmitToAires, MobilityXConstants.SUBMIT_TO_AIRES);

		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public boolean verifyAuthFormSuccessDialogDisplayed() {
		try {
			CoreFunctions.waitHandler(2);
			if (CoreFunctions.isElementExist(driver, _txt_GrowlMessage, 15)) {
				_isDisplayed = true;
				Reporter.addStepLog(
						CoreConstants.PASS + CoreConstants.VRFIED_THAT + MobilityXConstants.SUCCESS_MESSAGE_TEXT
								+ CoreConstants.IS_DISPLAYED_AS + "<b>\"" + _dialogSuccessMessage.getText() + "\"</b>");
				Reporter.addStepLog(MessageFormat.format(MobilityXConstants.NEW_TRANSFEREE_CREATED, CoreConstants.PASS,
						CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
						CoreFunctions.getPropertyFromConfig("Transferee_lastName")));
				return true;
			} else {
				Log.info(CoreConstants.FAIL + MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
				Assert.fail(MobilityXConstants.SUCCESS_DIALOG + MobilityXConstants.IS_NOT_DISPLAYED);
				return false;
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			Log.info("Exception :" + e);
			return false;
		}
	}

	public void switchToiFrame_Authorization() {
		try {
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _iframe_EmployeName, MobilityXConstants.IFRAME);
			driver.switchTo().frame(_iframe_EmployeName);
		} catch (ElementNotFoundException e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void enterEmpFirstAndLastNameForNewAuthorization() {
		try {
			BusinessFunctions.generateUniqueValuesAndWriteToConfig(5);
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _button_Continue,
					MobilityXConstants.CONTINUE_BUTTON);
			if (!selectUploadOrManualOption()) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_dialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			}
			// Enter Employee First Name and Last Name
			CoreFunctions.clearAndSetText(driver, _txt_EmpFirstName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT));

			CoreFunctions.clearAndSetText(driver, _txt_EmpLastName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
			// Click Continue button
			CoreFunctions.click(driver, _button_Continue, MobilityXConstants.CONTINUE_BUTTON);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void selectUploadOrManualOptionForNewAuth() {
		try {
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _button_Continue,
					MobilityXConstants.CONTINUE_BUTTON);
			if (!selectUploadOrManualOption()) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_dialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			}
			CoreFunctions.waitHandler(2);
			CoreFunctions.click(driver, _button_Continue, MobilityXConstants.CONTINUE_BUTTON);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void switchToAuthoriztionForm() {
		try {
			String randomString = CoreFunctions.generateRandomString(5);
			CoreFunctions.writeToPropertiesFile(MobilityXConstants.SPOUSE_NAME_TEXT,
					MobilityXConstants.SPOUSE_NAME + randomString);
			CoreFunctions.writeToPropertiesFile(MobilityXConstants.EMP_ID_TEXT,
					MobilityXConstants.EMP_ID + randomString);
			switchToiFrame_Authorization();
			if (!selectUploadOrManualOption()) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_dialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			}
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _button_Continue,
					MobilityXConstants.CONTINUE_BUTTON);
			CoreFunctions.click(driver, _button_Continue, _button_Continue.getText());
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	public void selectAuthorizationOptionForEmployee(String option) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _titleText_AuthorizationNextStep,
					MobilityXConstants.IFRAME_TITLE);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_AuthorizationNextStep),
					MobilityXConstants.THIS_NEW_AUTHORIZATION_FOR_TEXT
							+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT)
							+ MobilityXConstants.IS_TEXT,
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

	public void selectTabOnAuthorizationPage(String tabName) {
		switch (tabName) {
		case MobilityXConstants.COLLABORATION_TAB:
			CoreFunctions.click(driver, _tabCollaboration, tabName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tabCollaboration_Selected,
					tabName + CoreConstants.IS_SELECTED);
			break;
		case MobilityXConstants.AUTHORIZATION_TAB:
			CoreFunctions.waitHandler(10);
			CoreFunctions.clickUsingJS(driver, _tabAuthorizationText, tabName);
			authFormExists();
			break;
		default:
			Assert.fail(tabName + MobilityXConstants.NOT_EXIST);
		}
	}

	public boolean verifyAuthorizationPage(String authFormTextName, String pageName) {
		CoreFunctions.waitHandler(10);
		if (_textauthorization.getText().trim().equals(authFormTextName)) {
			_isExists = true;
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.AUTH_FORM_TEXT, CoreConstants.PASS,
					MobilityXConstants.AUTHORIZATION_TEXT, pageName));
			CoreFunctions.highlightObject(driver, _textauthorization);
		}
		return _isExists;
	}

	public void selectElementOnFloatingMenu(String elementName) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _floatingMenu_DisplayTextList);
		BusinessFunctions.selectItemFromListUsingText(driver, _floatingMenu_DisplayTextList, elementName);
	}

	public boolean authFormExists() {
		_isDisplayed = CoreFunctions.isElementExist(driver, _titleAuthorizationForm, 5);
		if (_isDisplayed) {
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.IS_DISPLAYED);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleAuthorizationForm),
					MobilityXConstants.AUTHORIZATION_FORM_TITLE_TEXT, MobilityXConstants.AUTHORIZATION_FORM_TITLE
							+ MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
			BusinessFunctions.selectValueFromDropdown(_drpdownAuthorizationFormTemplate,
					MobilityXConstants.DROPDOWN_AUTHORIZATION_FORM_TEMPLATE_VALUE);
			CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, MobilityXConstants.CONTINUE_BUTTON);
			CoreFunctions.waitUntilBrowserReady(driver);
			driver.switchTo().defaultContent();
		} else
			Log.info(MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.NOT_EXIST);
		return _isDisplayed;
	}

	public boolean verifySuccessDialogDisplayed() {
		try {
			if (CoreFunctions.isElementExist(driver, _txt_GrowlMessage, 25)) {
				Reporter.addStepLog(
						CoreConstants.PASS + CoreConstants.VRFIED_THAT + MobilityXConstants.SUCCESS_MESSAGE_TEXT
								+ CoreConstants.IS_DISPLAYED_AS + "<b>\"" + _dialogSuccessMessage.getText() + "\"</b>");
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _txt_GrowlMessage);
				return true;
			}
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.GROWL_MESSAGE_NOT_MATCHED, CoreConstants.FAIL,
					_txtGrowlMessage.getText()));
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _txt_GrowlMessage);
		} catch (Exception e) {
			Log.info("Exception :" + e);
			return false;
		}
		return false;
	}

	public boolean selectAuthorizationFormTemplate(String companyId, String companyName, String option) {
		_isDisplayed = CoreFunctions.isElementExist(driver, _titleAuthorizationForm, 7);
		if (_isDisplayed) {
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.IS_DISPLAYED);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleAuthorizationForm),
					MobilityXConstants.AUTHORIZATION_FORM_TITLE_TEXT, MobilityXConstants.AUTHORIZATION_FORM_TITLE
							+ MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
			BusinessFunctions.selectValueFromDropdown(_drpdownAuthorizationFormTemplateCompanyName,
					companyName + " (" + companyId + ")");
			CoreFunctions.waitHandler(2);
			BusinessFunctions.selectValueFromDropdown(_drpdownAuthorizationFormTemplate, option);
			CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, MobilityXConstants.CONTINUE_BUTTON);
			CoreFunctions.waitUntilBrowserReady(driver);
			driver.switchTo().defaultContent();
		} else
			Log.info(MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.NOT_EXIST);
		return _isDisplayed;
	}

	public void ClickTabFromAuthorisationPage(String tabName) {
		switch (tabName) {
		case MobilityXConstants.CREATE_A_BUDGET:
			CoreFunctions.waitUntilBrowserReady(driver);
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkCreateBudgetTile,
					MobilityXConstants.CREATE_A_BUDGET);
			CoreFunctions.clickUsingJS(driver, _linkCreateBudgetTile, MobilityXConstants.CREATE_A_BUDGET);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.COLLABORATION_TAB:
			CoreFunctions.waitUntilBrowserReady(driver);
			CoreFunctions.waitHandler(6);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkCollaboration,
					MobilityXConstants.COLLABORATION_TAB);
			CoreFunctions.clickUsingJS(driver, _linkCollaboration, MobilityXConstants.COLLABORATION_TAB);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		default:
			Assert.fail(tabName + MobilityXConstants.NOT_EXIST);
		}
	}

	public void clickOnElementsOfFloatingMenu(String linkName) {
		CoreFunctions.waitHandler(3);

		if (CoreFunctions.isElementExist(driver, _closeTeamComments, 5)) {
			CoreFunctions.clickElement(driver, _closeTeamComments);
		}
		switch (linkName) {
		case MobilityXConstants.SUBMIT_TO_AIRES:
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
					_buttonSubmitToAires.getText());
			CoreFunctions.click(driver, _buttonSubmitToAires, MobilityXConstants.SUBMIT_TO_AIRES);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		default:
			Assert.fail(linkName + MobilityXConstants.NOT_EXIST);
		}
	}

	public void backToAdvanceSearchResults() {
		CoreFunctions.highlightElementAndClick(driver, _linkBackToSearchResults, _linkBackToSearchResults.getText());
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public String enterEmployeeFirstAndLastNameForNewAuthorization() {
		try {
			BusinessFunctions.generateUniqueValuesAndWriteToConfig(5);

			// Click on Create an authorization link on a Dashboard
			CoreFunctions.click(driver, _linkCreateAnAuthorization, MobilityXConstants.CREATE_AN_AUTHORIZATION);

			// Switch to Frame
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _button_Continue,
					MobilityXConstants.CONTINUE_BUTTON);
			if (!selectUploadOrManualOption()) {
				Assert.assertEquals(CoreFunctions.getElementText(driver, _titleText_dialogEmployeeName),
						MobilityXConstants.EXPECTED_EMP_NAME_TITLE,
						MobilityXConstants.EMPLOYEE_NAME + MobilityXConstants.IS_NOT_DISPLAYED);
			}
			CoreFunctions.waitHandler(2);

			// Enter Employee First Name and Last Name
			CoreFunctions.clearAndSetText(driver, _txt_EmpFirstName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT));
			CoreFunctions.clearAndSetText(driver, _txt_EmpLastName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));

			empName = CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT);

			// Click Continue button
			CoreFunctions.click(driver, _button_Continue, MobilityXConstants.CONTINUE_BUTTON);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return empName;
	}

	public void clickOnElementOnAuthorizationPage(String tabName) {
		switch (tabName) {
		case MobilityXConstants.SUBMIT_APPROVED_INITIATION:
			CoreFunctions.click(driver, _btnSubmitApprover, tabName);
			break;
		case MobilityXConstants.TEXT_SUBMIT_TO_AIRES:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
					_buttonSubmitToAires.getText());
			CoreFunctions.click(driver, _buttonSubmitToAires, MobilityXConstants.SUBMIT_TO_AIRES);
			break;
		case MobilityXConstants.CREATE_AN_AUTHORIZATION:
			CoreFunctions.click(driver, _linkCreateAnAuthorization, MobilityXConstants.CREATE_AN_AUTHORIZATION);
			break;
		case MobilityXConstants.START_BENEFIT_SELECTION:
			CoreFunctions.clickElement(driver, _btnFlexBenefitSelection);
			break;
		default:
			Assert.fail(tabName + MobilityXConstants.NOT_EXIST);
		}
	}

	public void submitToAiresForAnAuthorisation() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
				_buttonSubmitToAires.getText());
		CoreFunctions.click(driver, _buttonSubmitToAires, MobilityXConstants.SUBMIT_TO_AIRES);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _btnSubmitApprover,
				_btnSubmitApprover.getText() + CoreConstants.IS_SELECTED);
		CoreFunctions.click(driver, _btnSubmitApprover, _btnSubmitApprover.getText());
		CoreFunctions.waitHandler(2);
	}

	public void fillAuthorizationForBSCDomesticForm(MX_Client_Dashboard_BscData authorizationData) {
		fillAuthorizationTypeInfoForBSCDomesticForm(authorizationData.authTypeInfo);
		fillAuthorizationEmployeeInfoForBSCDomesticForm(authorizationData.bscEmployeeInfo);
		fillAuthorizationRelocationInfoForBSCDomesticForm(authorizationData.relocationInfo);
		fillAuthorizationReportingInfoForBSCDomesticForm(authorizationData.reportingInfo);
		fillAuthorizationInfoForBSCDomesticForm(authorizationData.authorisationInfo);
	}

	private void fillAuthorizationInfoForBSCDomesticForm(AuthorizationInfo authorisationInfo) {
		CoreFunctions.clearAndSetText(driver, _hrManagerTextField, authorisationInfo.hrManagerName);
		CoreFunctions.clearAndSetText(driver, _hiringManagerName, authorisationInfo.hiringManagerName);
		BusinessFunctions.selectValueFromDropdown(_fundingECMember, authorisationInfo.fundingECMember);
	}

	private void fillAuthorizationReportingInfoForBSCDomesticForm(ReportingInfo reportingInfo) {
		CoreFunctions.clearAndSetText(driver, _inputCostCenter, reportingInfo.costCenter);
		BusinessFunctions.selectValueFromDropdown(_selectDivision, reportingInfo.division);
		BusinessFunctions.selectValueFromDropdown(_selectOperatingUnit, reportingInfo.operatingUnit);
	}

	private void fillAuthorizationRelocationInfoForBSCDomesticForm(RelocationInfo relocationInfo) {
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_listForAll, relocationInfo.transferType);
		BusinessFunctions.selectValueFromDropdown(_assignmentType, relocationInfo.assignmentType);
		CoreFunctions.clearAndSetText(driver, _inputStartDate, CoreFunctions.getcurrentdate());
		CoreFunctions.clearAndSetText(driver, _txt_jobTitle, relocationInfo.newJobTitle);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_Immigration, relocationInfo.immigration);
	}

	private void fillAuthorizationEmployeeInfoForBSCDomesticForm(BscEmployeeInfo bscEmployeeInfo) {
		BusinessFunctions.selectValueFromDropdown(_relocationPolicy,
				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
		CoreFunctions.clearAndSetText(driver, _txt_EmployeeID, bscEmployeeInfo.employeeID);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _homeStatusRadio, bscEmployeeInfo.homeStatus);
		CoreFunctions.clearAndSetText(driver, _txt_OriginHomeAddress, bscEmployeeInfo.originHomeAddress);
		CoreFunctions.clearAndSetText(driver, _txt_OriginCity, bscEmployeeInfo.originHomeCity);
		BusinessFunctions.selectValueFromDropdown(_originState, bscEmployeeInfo.originHomeState);
		BusinessFunctions.selectValueFromDropdown(_originCountry, bscEmployeeInfo.originHomeCountry.trim());
		BusinessFunctions.selectValueFromDropdown(_originOfficeCityState, bscEmployeeInfo.officeOriginCityState);
		BusinessFunctions.selectValueFromDropdown(_destinationOfficeCityState,
				bscEmployeeInfo.destinationOfficeLocation);
		CoreFunctions.waitHandler(2);
		CoreFunctions.clearAndSetText(driver, _txt_mobileTelephone, bscEmployeeInfo.mobilePhone);
		CoreFunctions.clearAndSetText(driver, _txt_employeeEmail, bscEmployeeInfo.emailOne);
	}

	private void fillAuthorizationTypeInfoForBSCDomesticForm(AuthTypeInfo authTypeInfo) {
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioGlobalMobility, authTypeInfo.assesment);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioAuthorizationTypeList, authTypeInfo.airesInstruction);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioCostEstimate, authTypeInfo.costEstimate);
	}

	public boolean verifyAuthFormChangesAutoSaved() {
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _txtAuthFormNotSaved);
			return CoreFunctions.isElementExist(driver, _txtAuthFormSaved, 5);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_AUTO_SAVE_AUTH_FORM,
							CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return false;
	}

	public boolean verifyTotalPointsSection() {
		boolean isTotalPointsSectionVerified = false;
		try {
			switch (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")) {
			case COREFLEXConstants.USER_DEFINED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_USER_DEFINED_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					isTotalPointsSectionVerified = verifyTotalPointsContents();
				}
				break;
			case COREFLEXConstants.STATIC_FIXED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_STATIC_FIXED_FLEX_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					isTotalPointsSectionVerified = false;
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TOTAL_POINTS_SECTION_ON_AUTH_FORM,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return isTotalPointsSectionVerified;
	}

	private boolean verifyTotalPointsContents() {
		try {
			CoreFunctions.verifyText(driver, _textTotalPointsHeader, MobilityXConstants.TOTAL_POINTS,
					MobilityXConstants.TOTAL_POINTS);
			CoreFunctions.verifyText(driver, _labelTotalPointsInputHint, MobilityXConstants.TOTAL_POINTS_INPUT_HINT,
					MobilityXConstants.TOTAL_POINTS_HINT);
			return true;
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	public boolean verifyFlexBenefitsSection() {
		boolean iFlexBenefitsSectionVerified = false;
		try {
			switch (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")) {
			case COREFLEXConstants.CLIENT_INITIATOR:
			case COREFLEXConstants.CLIENT_AND_TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = verifyFlexBenefitsSectionContents();
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_SECTION_ON_AUTH_FORM,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return iFlexBenefitsSectionVerified;
	}

	private boolean verifyFlexBenefitsSectionContents() {
		try {
			CoreFunctions.verifyText(driver, _textFlexBenefitsHeader, MobilityXConstants.FLEX_BENEFITS,
					MobilityXConstants.FLEX_BENEFITS_HEADER);
			CoreFunctions.verifyText(driver, _textFlexBenefitsDesc, MobilityXConstants.FLEX_BENEFITS_SECTION_DESC,
					MobilityXConstants.FLEX_BENEFITS_SECTION_TEXT);
			return CoreFunctions.isElementExist(driver, _btnFlexBenefitSelection, 3);
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	public boolean verifyRequiredFieldsValidation() {
		boolean areRequiredFieldsVerified = false, isGrowlMessageVerified = false,
				isItemsNeedsAttentionVerified = false;
		try {
			if (CoreFunctions.isElementExist(driver, _textGrowlMessage, 3)) {
				isGrowlMessageVerified = CoreFunctions.verifyText(driver, _textGrowlMessage,
						MobilityXConstants.GROWL_MESSAGE_FOR_FLEX_BENEFITS,
						MobilityXConstants.REQUIRED_FIELDS_GROWL_MESSAGE, true);
			}
			isItemsNeedsAttentionVerified = CoreFunctions.verifyText(driver, _textItemsNeedAttention,
					MobilityXConstants.EXPECTED_ITEM_NEEDS_ATTENTION, MobilityXConstants.ITEM_NEEDS_ATTENTION, true);
			areRequiredFieldsVerified = isGrowlMessageVerified && isItemsNeedsAttentionVerified
					&& verifyNumericRangeFieldsValidation();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_REQUIRED_FIELDS_VALIDATION_ON_AUTH_FORM,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		if (areRequiredFieldsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_REQUIRED_FIELDS_VALIDATION_ON_AUTH_FORM,
					CoreConstants.PASS));
		}
		return areRequiredFieldsVerified;
	}

	public boolean verifyNumericRangeFieldsValidation() {
		try {
			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_VALUE, "0.49");
//			checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_VALUE, "1000.1");
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_TOTAL_POINTS_FIELD_VALIDATION_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void checkFieldValidation(String fieldName, String inputValue) {
		boolean isValidationMessageDisplayed = false;
		switch (fieldName) {
		case COREFLEXConstants.TOTAL_POINTS_VALUE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints, inputValue,
					COREFLEXConstants.TOTAL_POINTS_VALUE);
			clickOnElementOnAuthorizationPage(MobilityXConstants.START_BENEFIT_SELECTION);
			if (CoreFunctions.isElementExist(driver, _textTotalPointsErrorMessage, 2))
				isValidationMessageDisplayed = CoreFunctions.getElementText(driver, _textTotalPointsErrorMessage)
						.equals(COREFLEXConstants.POINT_FIVE_TO_ONE_THOUSAND_RANGE_OLD_MESSAGE);
			BusinessFunctions.checkValidationBasedOnInput(isValidationMessageDisplayed, fieldName, inputValue);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	public void enterValidTotalPointsValue(MX_Client_Dashboard_BscData authorizationData) {
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints, authorizationData.flexBenefitInfo.totalPoints,
				COREFLEXConstants.TOTAL_POINTS_VALUE);
	}

}