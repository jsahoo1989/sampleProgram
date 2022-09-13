package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.AuthTypeInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.AuthorizationInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.BscEmployeeInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.RelocationInfo;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData.ReportingInfo;
import com.aires.utilities.EmailUtil;
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

	// Employee First Name Input
	@FindBy(how = How.CSS, using = "input[id*='firstName']")
	private WebElement _inputEmpFirstName;

	// Employee Last Name Input
	@FindBy(how = How.CSS, using = "input[id*='lastName']")
	private WebElement _inputEmpLastName;

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

	// Button - Resubmit To Aires
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Resubmit to Aires')]")
	private WebElement _buttonResubmitToAires;

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

	@FindBy(how = How.CSS, using = "span[id*='authStatusId']")
	private WebElement _textAuthFormStatus;

	@FindBy(how = How.CSS, using = "div[id*='savedCore'] label")
	private List<WebElement> _textSelectedCoreBenefitsNameList;

	@FindBy(how = How.CSS, using = "div[id*='savedCore'] span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _textCoreAllowanceAmountList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] span[class*='RXCFSubmitBenefitsBenefits']")
	private List<WebElement> _textSelectedFlexBenefitsNameList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] div>span[class*='RXAiresSeaglass']")
	private List<WebElement> _textSelectedFlexBenefitsAmountAllowanceList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] td>span[class*='RXAiresSeaglass']")
	private List<WebElement> _textSelectedFlexBenefitsPointsList;

	@FindBy(how = How.CSS, using = "div[id*='savedFlex'] td>span[class*='RXBolder RXCFSmallText']")
	private List<WebElement> _textSelectedFlexBenefitsQuantityList;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFSubmitBenefitsGrPnl')]//td[1]/span")
	private WebElement _selectedPoints;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFSubmitBenefitsGrPnl')]//td[3]/span")
	private WebElement _totalPoints;

	@FindBy(how = How.CSS, using = "div[id*='proceedApproverListBtn'] span[class='af_button_text']")
	private WebElement _buttonSubmit;

	@FindBy(how = How.CSS, using = "div[class='growl-message']")
	private WebElement _textAuthFormSubmissionGrowlMessage;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'View all initiations')]")
	private WebElement _linkViewAllInitiations;

	@FindBy(how = How.CSS, using = "td[id*='fwpppw'] div[class*='RXModalTitle'] span")
	private WebElement _dialogPointsText;

	@FindBy(how = How.CSS, using = "td[id*='pppw'] div[class*='RXModalTitle'] span")
	private WebElement _dialogCannotDecreasePointsText;

	@FindBy(how = How.XPATH, using = "//td[contains(@id,'fwpppw')]//span[contains(text(),'Yes')]")
	private WebElement _buttonYesPoints;

	@FindBy(how = How.XPATH, using = "//td[contains(@id,'pppw')]//span[contains(text(),'OK')]")
	private WebElement _buttonDialogOK;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'LETTER/POLICY DOCUMENTS ONLY')]")
	private WebElement _buttonLetterPolicyDocuments;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Resubmit without revising documents')]")
	private WebElement _buttonResubmitWithoutRevisingDoc;

	/**************************************************************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	/**************************************************************************************************************/

	private boolean _isExists = false;
	String empName;
	private boolean _isDisplayed = false;
	public static double clientCashoutPoints;

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
			return CoreFunctions.isElementExist(driver, _textAuthTypeHeader, 2);
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
			CoreFunctions.writeToPropertiesFile("Transferee_firstName",
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT));

			CoreFunctions.clearAndSetText(driver, _txt_EmpLastName,
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
			CoreFunctions.writeToPropertiesFile("Transferee_lastName",
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
		CoreFunctions.waitHandler(2);
		_isDisplayed = CoreFunctions.isElementExist(driver, _titleAuthorizationForm, 10);
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
		case MobilityXConstants.RESUBMIT_TO_AIRES:
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonResubmitToAires,
					_buttonResubmitToAires.getText());
			CoreFunctions.click(driver, _buttonResubmitToAires, MobilityXConstants.RESUBMIT_TO_AIRES);
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
		case MobilityXConstants.SUBMIT_TO_AIRES:
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
					_buttonSubmitToAires.getText());
			CoreFunctions.click(driver, _buttonSubmitToAires, MobilityXConstants.SUBMIT_TO_AIRES);
			break;
		case MobilityXConstants.SUBMIT:
			CoreFunctions.click(driver, _buttonSubmit, MobilityXConstants.SUBMIT);
			break;
		case MobilityXConstants.CREATE_AN_AUTHORIZATION:
			CoreFunctions.click(driver, _linkCreateAnAuthorization, MobilityXConstants.CREATE_AN_AUTHORIZATION);
			break;
		case MobilityXConstants.START_BENEFIT_SELECTION:
		case MobilityXConstants.MANAGE_BENEFIT_SELECTION:
			CoreFunctions.clickElement(driver, _btnFlexBenefitSelection);
			break;
		case MobilityXConstants.VIEW_ALL_INITIATIONS:
			CoreFunctions.clickElement(driver, _linkViewAllInitiations);
			break;
		case MobilityXConstants.RESUBMIT_WITH_CHANGES_MADE_TO_LETTER_POLICY_DOCUMENTS:
			CoreFunctions.clickElement(driver, _buttonLetterPolicyDocuments);
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
		CoreFunctions.waitHandler(3);
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
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_USER_DEFINED_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					isTotalPointsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.STATIC_FIXED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_STATIC_FIXED_FLEX_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					isTotalPointsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_TOTAL_POINTS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_STATIC_FIXED_FLEX_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					isTotalPointsSectionVerified = true;
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

	public boolean verifyFlexBenefitsSection(String personResponsible) {
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
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					iFlexBenefitsSectionVerified = true;
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
			CoreFunctions.verifyText(driver, _btnFlexBenefitSelection, MobilityXConstants.START_BENEFIT_SELECTION,
					MobilityXConstants.START_BENEFIT_SELECTION);
			return true;
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	private boolean verifyFlexBenefitsSectionContentsPostAuthFormSubmission() {
		try {
			CoreFunctions.verifyText(driver, _textFlexBenefitsHeader, MobilityXConstants.FLEX_BENEFITS,
					MobilityXConstants.FLEX_BENEFITS_HEADER);
			CoreFunctions.verifyText(driver, _textFlexBenefitsDesc, MobilityXConstants.FLEX_BENEFITS_SECTION_DESC,
					MobilityXConstants.FLEX_BENEFITS_SECTION_TEXT);
			CoreFunctions.verifyText(driver, _btnFlexBenefitSelection, MobilityXConstants.MANAGE_BENEFIT_SELECTION,
					MobilityXConstants.MANAGE_BENEFIT_SELECTION);
			return true;
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	public boolean verifyRequiredFieldsValidation(String buttonName) {
		boolean areRequiredFieldsVerified = false, isGrowlMessageVerified = false,
				isItemsNeedsAttentionVerified = false;
		try {
			String expectedGrowlMessage = buttonName.equals(MobilityXConstants.START_BENEFIT_SELECTION)
					? MobilityXConstants.GROWL_MESSAGE_FOR_FLEX_BENEFITS
					: (buttonName.equals(MobilityXConstants.SUBMIT_TO_AIRES)
							? MobilityXConstants.GROWL_MESSAGE_FOR_SUBMIT_AUTHORIZATION
							: null);
			if (CoreFunctions.isElementExist(driver, _textGrowlMessage, 3)) {
				isGrowlMessageVerified = CoreFunctions.verifyText(driver, _textGrowlMessage, expectedGrowlMessage,
						MobilityXConstants.REQUIRED_FIELDS_GROWL_MESSAGE, true);
			}
			isItemsNeedsAttentionVerified = CoreFunctions.verifyText(driver, _textItemsNeedAttention,
					buttonName.equals(MobilityXConstants.START_BENEFIT_SELECTION)
							? MobilityXConstants.EXPECTED_ONE_ITEM_NEEDS_ATTENTION
							: ((CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")
									.equals(COREFLEXConstants.USER_DEFINED))
									&& (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")
											.equals(COREFLEXConstants.CLIENT_INITIATOR)))
													? MobilityXConstants.EXPECTED_TWO_ITEM_NEEDS_ATTENTION
													: MobilityXConstants.EXPECTED_ONE_ITEM_NEEDS_ATTENTION,
					MobilityXConstants.ITEM_NEEDS_ATTENTION, true);
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
			clickOnElementOnAuthorizationPage(MobilityXConstants.SUBMIT_TO_AIRES);
			if (CoreFunctions.isElementExist(driver, _textTotalPointsErrorMessage, 2))
				isValidationMessageDisplayed = CoreFunctions.getElementText(driver, _textTotalPointsErrorMessage)
						.equals(COREFLEXConstants.POINT_FIVE_TO_ONE_THOUSAND_RANGE_OLD_MESSAGE);
			BusinessFunctions.checkValidationBasedOnInput(isValidationMessageDisplayed, fieldName, inputValue);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	public void enterValidInitialTotalPointsValue(MX_Client_Dashboard_BscData authorizationData) {
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints,
				authorizationData.flexBenefitInfo.initialTotalPoints, COREFLEXConstants.TOTAL_POINTS_VALUE);
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalAvailablePoints",
				authorizationData.flexBenefitInfo.initialTotalPoints);
	}

	public void enterValidDecreasedTotalPointsValue(MX_Client_Dashboard_BscData authorizationData) {
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints,
				authorizationData.flexBenefitInfo.decreasedTotalPoints, COREFLEXConstants.TOTAL_POINTS_VALUE);
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalAvailablePoints",
				authorizationData.flexBenefitInfo.decreasedTotalPoints);
	}

	public void enterValidIncreasedTotalPointsValue(MX_Client_Dashboard_BscData authorizationData) {
		CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints,
				authorizationData.flexBenefitInfo.increasedTotalPoints, COREFLEXConstants.TOTAL_POINTS_VALUE);
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalAvailablePoints",
				authorizationData.flexBenefitInfo.increasedTotalPoints);
	}

	public boolean selectRelocationPolicy() {
		try {
			BusinessFunctions.selectValueFromDropdown(_relocationPolicy,
					CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_SELECTED_RELOCATION_POLICY_ON_AUTH_FORM_PAGE,
							CoreConstants.PASS, CoreFunctions.getPropertyFromConfig("Assignment_Policy")));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_RELOCATION_POLICY_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage(), CoreFunctions.getPropertyFromConfig("Assignment_Policy")));
		}
		return false;
	}

	public boolean verifyAuthFormAutoSavedAfterNavigation(MX_Client_Dashboard_BscData authorizationData,
			String benefitPoints) {
		try {
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_inputEmpFirstName, "value"),
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT),
					MobilityXConstants.FIRST_NAME_TEXT);
			CoreFunctions.highlightObject(driver, _inputEmpFirstName);
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_inputEmpLastName, "value"),
					CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT),
					MobilityXConstants.LAST_NAME_TEXT);
			CoreFunctions.highlightObject(driver, _inputEmpLastName);
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_relocationPolicy, "title"),
					CoreFunctions.getPropertyFromConfig("Assignment_Policy"), MobilityXConstants.RELOCATION_POLICY);
			CoreFunctions.highlightObject(driver, _relocationPolicy);
			String expectedTotalBenefitPoints = benefitPoints.equals(MobilityXConstants.INITIAL_BENEFIT_TOTAL_POINTS)
					? authorizationData.flexBenefitInfo.initialTotalPoints
					: benefitPoints.equals(MobilityXConstants.INCREASED_BENEFIT_TOTAL_POINTS)
							? authorizationData.flexBenefitInfo.increasedTotalPoints
							: authorizationData.flexBenefitInfo.decreasedTotalPoints;
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_inputTotalPoints, "value"),
					expectedTotalBenefitPoints, MobilityXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _inputTotalPoints);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AUTH_FORM_SELECTION_AFTER_NAVIGATING_BACK_TO_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyAuthFormStatus(String expectedAuthFormStatus) {
		try {
			if (CoreFunctions.verifyText(driver, _textAuthFormStatus, expectedAuthFormStatus,
					MobilityXConstants.AUTH_FORM_STATUS, true)) {
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_AUTH_FORM_STATUS,
						CoreConstants.PASS, expectedAuthFormStatus));
				return true;
			} else {
				Reporter.addStepLog(
						MessageFormat.format(COREFLEXConstants.AUTH_FORM_STATUS_NOT_MATCHED, CoreConstants.FAIL,
								expectedAuthFormStatus, CoreFunctions.getElementText(driver, _textAuthFormStatus)));
				return false;
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AUTH_FORM_STATUS,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifySelectedCoreFlexBenefits() {
		boolean isFlexBenefitSectionVerified = false;
		try {
			isFlexBenefitSectionVerified = verifySelectedBenefitDetails(
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"))
					&& Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))
					&& (Double.parseDouble(CoreFunctions.getElementText(driver, _totalPoints)) == (Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))));
//					&& verifySelectedCashoutDetails();

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_SECTION_DETAILS_ON_AUTH_FORM_POST_BENEFIT_CASHOUT_SELECTION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexBenefitSectionVerified;
	}

	private boolean verifySelectedBenefitDetails(String policyRequiredFor, String benefitType) {
		switch (benefitType) {
		case COREFLEXConstants.FLEX:
			return verifySelectedFlexBenefitsDetails(policyRequiredFor, benefitType);
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitsDetails(policyRequiredFor, benefitType);
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitsDetails(policyRequiredFor, benefitType)
					&& verifySelectedFlexBenefitsDetails(policyRequiredFor, benefitType);
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
	}

	private boolean verifyCoreBenefitsDetails(String policyRequiredFor, String benefitType) {
		boolean isCoreBenefitDetailsOnAuthFormVerified = false;
		try {
			for (Benefit benefit : getCoreBenefits(benefitType, policyRequiredFor, "0")) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSelectedCoreBenefitsNameList, benefit.getBenefitDisplayName());
				isCoreBenefitDetailsOnAuthFormVerified = verifyCorePlanningToolBenefitDetails(indexBenefit, benefit);
				if (!isCoreBenefitDetailsOnAuthFormVerified) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CORE_BENEFIT_DETAILS_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCoreBenefitDetailsOnAuthFormVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_DETAILS_ON_AUTH_FORM_PAGE,
					CoreConstants.PASS));
		}
		return isCoreBenefitDetailsOnAuthFormVerified;
	}

	private boolean verifyCorePlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedCoreBenefitsNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textCoreAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()));
	}

	private List<Benefit> getCoreBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (Benefit benefit : coreBenefits) {
				if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
						&& (benefit.getAiresManagedService().equals("Yes"))
						&& (benefit.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
					benefitNameList.add(benefit);
				} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				}

			}
		}
		return benefitNameList;
	}

	private boolean verifySelectedFlexBenefitsDetails(String policyRequiredFor, String benefitType) {
		boolean isFlexBenefitDetailsVerified = false;
		boolean flag = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textSelectedFlexBenefitsNameList, benefit.getBenefitDisplayName());
					isFlexBenefitDetailsVerified = verifySelectedBenefitDetailsOnAuthForm(indexBenefit, benefit);
					if (!isFlexBenefitDetailsVerified) {
						return false;
					} else {
						flag = true;
					}
				} else {
					isFlexBenefitDetailsVerified = true;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsVerified;
	}

	private List<Benefit> getBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
							&& (ben.getAiresManagedService().equals("Yes"))
							&& (ben.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
						benefitNameList.add(ben);
					} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList;
	}

	private boolean verifySelectedBenefitDetailsOnAuthForm(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsAmountAllowanceList,
						indexBenefit, true).equals(benefit.getBenefitAmount()))
				&& (CoreFunctions
						.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsQuantityList, indexBenefit, true)
						.equals(String.valueOf(benefit.getNumberOfBenefitSelected())))
				&& ((Double.parseDouble((CoreFunctions
						.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsPointsList, indexBenefit, true)
						.replace("pts", "").trim()))) == ((Double.parseDouble(benefit.getPoints()))
								* (benefit.getNumberOfBenefitSelected())));
	}

	public boolean verifyInitiationSubmittedSuccessGrowlMessage() {
		boolean isGrowlMessageVerified = false;
		try {
			isGrowlMessageVerified = CoreFunctions.isElementExist(driver, _textAuthFormSubmissionGrowlMessage, 10)
					&& CoreFunctions.verifyText(driver, _textAuthFormSubmissionGrowlMessage,
							MobilityXConstants.EXPECTED_INITIATION_GROWL_MESSAGE
									.replace("FirstName", CoreFunctions.getPropertyFromConfig("FirstName"))
									.replace("LastName", CoreFunctions.getPropertyFromConfig("LastName")),
							MobilityXConstants.INITIATION_GROWL_MESSAGE, true);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_INITIATION_SUBMIT_SUCCESS_GROWL_MESSAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isGrowlMessageVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_INITIATION_SUBMITTED_SUCCESS_GROWL_MESSAGE_AFTER_AUTH_FORM_SUBMISSION,
					CoreConstants.PASS));
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _textAuthFormSubmissionGrowlMessage);
		}
		return isGrowlMessageVerified;
	}

	public boolean verifyInitiationSubmissionEmail(MX_Client_Dashboard_BscData authorizationData) {
		try {
			boolean isBenefitTotalPointsVerified = false, isFileIDVerified = false;
			// Reading Transferee FileID and Benefits TotalPoints from email and writing to
			// the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";
			// Enter expected email subject
			String expEmailSubject = "New relocation authorization from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			String actualResultFileID = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromUserName,
					expEmailSubject, MobilityXConstants.INITIATION_FILE_ID);
			isFileIDVerified = !(actualResultFileID.isEmpty());
			if (isFileIDVerified) {
				CoreFunctions.writeToPropertiesFile("Assignment_FileID", actualResultFileID.trim());
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified New Initiation Submitted Email generated for created Assignment.");
			}
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String expectedTotalBenefitPoints = CoreFunctions
					.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints");
			if (actualResultBenefitTotalPoints.equals(expectedTotalBenefitPoints)) {
				isBenefitTotalPointsVerified = true;
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified Benefit Total Points displayed in New Initiation Submitted Email.");
			}
			return isFileIDVerified && isBenefitTotalPointsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyInitiationBenefitsSubmissionEmail(MX_Client_Dashboard_BscData authorizationData) {
		try {
			boolean isBenefitPointsVerified = false, isFileIDVerified = false;
			// Reading Transferee FileID and Benefits TotalPoints from email and writing to
			// the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";
			// Enter expected email subject
			String expEmailSubject = "New relocation authorization from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			String actualResultFileID = EmailUtil.searchEmailAndReturnResult(host, userName, pwd, expFromUserName,
					expEmailSubject, MobilityXConstants.INITIATION_FILE_ID);
			isFileIDVerified = !(actualResultFileID.isEmpty());
			if (isFileIDVerified) {
				CoreFunctions.writeToPropertiesFile("Assignment_FileID", actualResultFileID.trim());
				Log.info(CoreConstants.PASS
						+ "Successfully verified New Initiation Benefits Submitted Email generated for created Assignment.");
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified New Initiation Benefits Submitted Email generated for created Assignment.");
			}
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");
			double expectedTotalBenefitPoints = Double.parseDouble(CoreFunctions
					.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
			double expectedSubmittedBenefitPoints = Double.parseDouble(CoreFunctions
					.getPropertyFromConfig("CF_Client_TotalSelectedPoints"));
			if ((Double.parseDouble((actualResultBenefitPoints[1].trim()))==(expectedTotalBenefitPoints))
					&& (Double.parseDouble(actualResultBenefitPoints[0].trim()))==(expectedSubmittedBenefitPoints)) {
				isBenefitPointsVerified = true;
				Log.info(CoreConstants.PASS
						+ "Successfully verified Benefit Submitted & Total Points displayed in New Initiation Submitted Email.");
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified Benefit Submitted & Total Points displayed in New Initiation Submitted Email.");
			}
			return isFileIDVerified && isBenefitPointsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}
	
	public boolean verifyRevisedBenefitsSubmissionEmail(MX_Client_Dashboard_BscData authorizationData) {
		try {
			boolean isBenefitPointsVerified = false, isFileIDVerified = false;
			// Reading Transferee FileID and Benefits TotalPoints from email and writing to
			// the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";
			// Enter expected email subject
			String expEmailSubject = "Revised mobility initiation from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for  "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");
			double expectedTotalBenefitPoints = Double.parseDouble(CoreFunctions
					.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
			double expectedSubmittedBenefitPoints = Double.parseDouble(CoreFunctions
					.getPropertyFromConfig("CF_Client_TotalSelectedPoints"));
			if ((Double.parseDouble((actualResultBenefitPoints[1].trim()))==(expectedTotalBenefitPoints))
					&& (Double.parseDouble(actualResultBenefitPoints[0].trim()))==(expectedSubmittedBenefitPoints)) {
				isBenefitPointsVerified = true;
				Log.info(CoreConstants.PASS
						+ "Successfully verified Benefit Submitted & Total Points displayed in Revised mobility Initiation Email.");
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified Benefit Submitted & Total Points displayed in Revised mobility Initiation Email.");
			}
			return isBenefitPointsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_REVISED_MOBILITY_INITIATION_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyRevisedSubmissionEmail(MX_Client_Dashboard_BscData authorizationData) {
		try {
			boolean isBenefitTotalPointsVerified = false;
			// Reading Transferee FileID and Benefits TotalPoints from email and writing to
			// the Config
			// Properties File
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";
			// Enter expected email subject
			String expEmailSubject = "Revised mobility initiation from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for  "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject,
					MobilityXConstants.REVISED_MOBILITY_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String expectedTotalBenefitPoints = CoreFunctions
					.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints");
			if ((actualResultBenefitTotalPoints).equals(expectedTotalBenefitPoints)) {
				isBenefitTotalPointsVerified = true;
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified Benefit Total Points displayed in Revised mobility Initiation Submitted Email.");
			}
			return isBenefitTotalPointsVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyAndAcceptIncreasedPointsDialog() {
		boolean isIncreasedPointsDialogVerified = false;
		try {
			isIncreasedPointsDialogVerified = CoreFunctions.isElementExist(driver, _dialogPointsText, 5)
					&& CoreFunctions.verifyText(driver, _dialogPointsText,
							MobilityXConstants.EXPECTED_INCREASED_POINTS_MESSAGE.replace("BenefitTP",
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
							MobilityXConstants.INCREASED_POINTS_DIALOG, true);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_INCREASED_POINTS_DIALOG_MESSAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isIncreasedPointsDialogVerified) {
			CoreFunctions.clickElement(driver, _buttonYesPoints);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_AND_ACCEPTED_INCREASED_POINTS_DIALOG_MESSAGE,
					CoreConstants.PASS));
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _textAuthFormSubmissionGrowlMessage);
		}
		return isIncreasedPointsDialogVerified;
	}

	public boolean verifyAndAcceptCannotDecreasedPointsAfterSubmissionDialog() {
		boolean isDecreasedPointsDialogVerified = false;
		try {
			isDecreasedPointsDialogVerified = CoreFunctions.isElementExist(driver, _dialogCannotDecreasePointsText, 5)
					&& CoreFunctions.verifyText(driver, _dialogCannotDecreasePointsText,
							MobilityXConstants.EXPECTED_CANNOT_DECREASED_POINTS_AFTER_SUBMISSION_MESSAGE,
							MobilityXConstants.CANNOT_DECREASE_POINTS_AFTER_SUBMISSION_DIALOG, true);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CANNOT_DECREASE_POINTS_AFTER_SUBMISSION_DIALOG_MESSAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDecreasedPointsDialogVerified) {
			CoreFunctions.clickElement(driver, _buttonDialogOK);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_AND_ACCEPTED_CANNOT_DECREASE_POINTS_AFTER_SUBMISSION_DIALOG_MESSAGE,
					CoreConstants.PASS));
		}
		return isDecreasedPointsDialogVerified;
	}

	public boolean verifyFlexBenefitsSectionPostBenefitSelection(String personResponsible) {
		boolean iFlexBenefitsSectionVerified = false;
		try {
			switch (personResponsible) {
			case COREFLEXConstants.CLIENT_INITIATOR:
			case COREFLEXConstants.CLIENT_AND_TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = verifyFlexBenefitsSectionContents()
							&& verifySelectedCoreFlexBenefits();
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					iFlexBenefitsSectionVerified = true;
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

	public boolean verifyFlexBenefitsSectionPostAuthFormSubmission(String personResponsible) {
		boolean iFlexBenefitsSectionVerified = false;
		try {
			switch (personResponsible) {
			case COREFLEXConstants.CLIENT_INITIATOR:
			case COREFLEXConstants.CLIENT_AND_TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = verifyFlexBenefitsSectionContentsPostAuthFormSubmission()
							&& verifySelectedCoreFlexBenefits();
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL,
							CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
					iFlexBenefitsSectionVerified = false;
				}
				break;
			case COREFLEXConstants.TRANSFEREE:
				if (CoreFunctions.isElementExist(driver, _textFlexBenefitsHeader, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.FAIL));
					iFlexBenefitsSectionVerified = false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_NOT_DISPLAYED_ON_AUTH_FORM_FOR_TRANSFEREE_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					iFlexBenefitsSectionVerified = true;
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
}