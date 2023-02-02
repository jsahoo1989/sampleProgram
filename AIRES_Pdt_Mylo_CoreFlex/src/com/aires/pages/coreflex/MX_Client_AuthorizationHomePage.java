package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.StringUtils;
import org.openqa.selenium.By;
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

import cucumber.api.DataTable;

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
	@FindBy(how = How.CSS, using = "div#stec1")
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

	// Button - Start routing
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Start routing')]")
	private WebElement _buttonStartRouting;

	// Button - Start routing
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cancel Routing')]")
	private WebElement _buttonCancelRouting;

	// Button - Start routing
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

	@FindBy(how = How.XPATH, using = "//div[contains(@id,'floatingMenu')]//span[contains(@class,'RXAuthFormAutoSaveText')][contains(text(),'Saved')] | //div[contains(@id,'floatingMenu')]//span[contains(@class,'RXAuthFormAutoSaveText')][contains(text(),'All changes saved')]")
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

	@FindBy(how = How.XPATH, using = "//span[text()='Upload or Create a Document']")
	private WebElement _linkUploadOrCreateADocument;

	@FindBy(how = How.XPATH, using = "//span[text()='Create LOU']")
	private WebElement _linkCreateLOU;

	@FindBy(how = How.CSS, using = "span[class='RXSmallText RXBold'][id*='otatt']")
	private WebElement _documentHeading;

	@FindBy(how = How.CSS, using = "span[id='searchViewAll']")
	private WebElement _downloadDocument;

	@FindBy(how = How.XPATH, using = "//span[text()='Send document to employee to begin relocation']")
	private WebElement _linkSendDocumentToEmployee;

	@FindBy(how = How.CSS, using = "select[id*='exlop']")
	private WebElement _selectEmployeeName;

	@FindBy(how = How.CSS, using = "form[action*='AuthFormClonePopup'] span[class='RXBiggerText']")
	private WebElement _dialogCloneAuthFormFieldSelectionHeading;

	@FindBy(how = How.CSS, using = "span[id*='relocationPolicy']")
	private WebElement _textRelocationPolicyCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "span[id*='homeStatus']")
	private WebElement _textHomeStatusCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "span[id*='mobileTelephone']")
	private WebElement _textMobilePhoneCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "span[id*='email']")
	private WebElement _textEmailCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "span[id*='transferType']")
	private WebElement _textTransferTypeCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "span[id*='assignmentType']")
	private WebElement _textAssignmentTypeCloneAuthFormFieldDialog;

	@FindBy(how = How.CSS, using = "input[id*='relocationPolicy_chk']")
	private WebElement _checkBoxRelocationPolicy;

	@FindBy(how = How.CSS, using = "input[id*='globalMobilityInd_chk']")
	private WebElement _checkBoxGlobalMobilityAssesment;

	@FindBy(how = How.CSS, using = "input[id*='authorizationType_chk']")
	private WebElement _checkBoxAiresInstructions;

	@FindBy(how = How.CSS, using = "input[id*='costEstimateReqInd_chk'")
	private WebElement _checkBoxCostEstimateRequired;

	@FindBy(how = How.CSS, using = "input[id*='selectall']")
	private List<WebElement> _checkBoxSelectAllList;

	@FindBy(how = How.XPATH, using = "//input[contains(@id,'flexBenefits_chk')]//ancestor::table[@id='flexBenefits']")
	private WebElement _checkBoxFlexBenefits;

	@FindBy(how = How.CSS, using = "input[id*='hrManager_chk']")
	private WebElement _checkBoxHrManagerName;

	@FindBy(how = How.CSS, using = "input[id*='hiringManager_chk']")
	private WebElement _checkBoxHiringManagerName;

	@FindBy(how = How.CSS, using = "input[id*='fundECName_chk']")
	private WebElement _checkBoxFundingEcMember;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Complete cloning')]")
	private WebElement _btnCompleteCloning;

	@FindBy(how = How.CSS, using = "input[name='fname']")
	private WebElement _inputSearchEmployee;

	@FindBy(how = How.CSS, using = "ul[class='aircomplete-list']>li")
	private List<WebElement> _searchedEmployeeList;

	@FindBy(how = How.CSS, using = "span[id*='mRegion'][class='RXHeaderText RXBold RXWrappedText']")
	private WebElement _textTransfereeUserNameTitle;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Policy')]/parent::div/following-sibling::div/span")
	private WebElement _textPolicyName;

	@FindBy(how = How.CSS, using = "a[class*='RXCFPointLink'] > span")
	private WebElement _textInitialSpentAndTotalPoints;

	@FindBy(how = How.XPATH, using = "//span[@class='RXHeaderText'][contains(text(),'Documents')]")
	private WebElement _headingDocuments;

	@FindBy(how = How.XPATH, using = "//span[@class='RXHeaderText'][contains(text(),'Documents')]/ancestor::table[contains(@class,'RXMobilityJourneySection')]//div[contains(@class,'RXLightGreyBorder RXThinBorder RXBottomBorder')]//span[@class='RXSmallText RXBolder RXWrappedText']")
	private List<WebElement> _linkDocumentsFileName;

	@FindBy(how = How.XPATH, using = "//span[@class='RXHeaderText'][contains(text(),'Documents')]/ancestor::table[contains(@class,'RXMobilityJourneySection')]//div[contains(@class,'RXLightGreyBorder RXThinBorder RXBottomBorder')]")
	private List<WebElement> _linkDocumentsParentElementList;

	By _textDocumentsFileName = By.xpath(".//span[@class='RXSmallText RXBolder RXWrappedText']");

	By _textDocumentsCategoryService = By.xpath(".//span[@class='RXSmallerTextMuted RXWrappedText']");

	@FindBy(how = How.CSS, using = "span[class='RXSmallTextMuted'][id*='otatt']")
	private WebElement _documentType;

	@FindBy(how = How.CSS, using = "select[id*='destLocation'] > option")
	private List<WebElement> _destinationOfficeCityStateList;

	@FindBy(how = How.CSS, using = "select[id*='officeOrigin'] > option")
	private List<WebElement> _originOfficeCityStateList;

	@FindBy(how = How.CSS, using = "select[id*='legalEntity']")
	private WebElement _legalEntity;

	@FindBy(how = How.CSS, using = "select[id*='legalEntity'] > option")
	private List<WebElement> _legalEntityList;

	@FindBy(how = How.CSS, using = "input[id*='immigration_chk']")
	private WebElement _checkBoxImmigration;

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
			if (CoreFunctions.getElementText(driver, _textInitiationFor).contains(expectedIntiationForText)) {
				CoreFunctions.highlightObject(driver, _textAuthTypeHeader);
				return CoreFunctions.isElementExist(driver, _textAuthTypeHeader, 2);
			}
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
		try {
			CoreFunctions.verifyText(driver, _textClientUserNameTitle, userProfileName,
					MobilityXConstants.USER_PROFILE_NAME);
			CoreFunctions.verifyText(driver, _textClientName, clientName, MobilityXConstants.CLIENT_NAME);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_CLIENT_DETAILS_ON_MOBILITYX_CLIENT_HOME_PAGE,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLIENT_DETAILS_ON_MOBILITYX_CLIENT_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

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
			Log.info("Exception :" + e);
			return false;
		}
	}

	public void switchToiFrame_Authorization() {
		try {
			CoreFunctions.waitHandler(5);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _iframe_EmployeName, MobilityXConstants.IFRAME);
			driver.switchTo().frame(_iframe_EmployeName);
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
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
//			CoreFunctions.waitHandler(3);
//			CoreFunctions.explicitWaitTillElementVisibility(driver, _titleText_AuthorizationNextStep,
//					MobilityXConstants.IFRAME_TITLE);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _link_ANewTransfer,
					MobilityXConstants.NEW_TRANSFER_ASSIGNMENT_LINK);
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
			BusinessFunctions.selectValueFromDropdown(driver, _drpdownAuthorizationFormTemplate,
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
//		CoreFunctions.waitHandler(2);
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _btn_Continue_AuthorizationForm,
				MobilityXConstants.CONTINUE_BUTTON);
		_isDisplayed = CoreFunctions.isElementExist(driver, _titleAuthorizationForm, 10);
		if (_isDisplayed) {
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.IS_DISPLAYED);
			Assert.assertEquals(CoreFunctions.getElementText(driver, _titleAuthorizationForm),
					MobilityXConstants.AUTHORIZATION_FORM_TITLE_TEXT, MobilityXConstants.AUTHORIZATION_FORM_TITLE
							+ MobilityXConstants.TITLE + MobilityXConstants.NOT_EXIST);
			BusinessFunctions.selectValueFromDropdown(driver, _drpdownAuthorizationFormTemplateCompanyName,
					companyName + " (" + companyId + ")");
			CoreFunctions.waitHandler(2);
			BusinessFunctions.selectValueFromDropdown(driver, _drpdownAuthorizationFormTemplate, option);
			CoreFunctions.click(driver, _btn_Continue_AuthorizationForm, MobilityXConstants.CONTINUE_BUTTON);
			CoreFunctions.waitUntilBrowserReady(driver);
			driver.switchTo().defaultContent();
		} else
			Log.info(MobilityXConstants.AUTHORIZATION_FORM_TITLE + MobilityXConstants.NOT_EXIST);
		return _isDisplayed;
	}

	public void clickTabOnAuthorisationPage(String tabName) {
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
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkCollaboration,
					MobilityXConstants.COLLABORATION_TAB);
			CoreFunctions.clickUsingJS(driver, _linkCollaboration, MobilityXConstants.COLLABORATION_TAB);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.CREATE_OR_UPLOAD_A_DOCUMENT:
			CoreFunctions.waitUntilBrowserReady(driver);
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkUploadOrCreateADocument,
					MobilityXConstants.CREATE_OR_UPLOAD_A_DOCUMENT);
			CoreFunctions.clickUsingJS(driver, _linkUploadOrCreateADocument,
					MobilityXConstants.CREATE_OR_UPLOAD_A_DOCUMENT);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		default:
			Assert.fail(tabName + MobilityXConstants.NOT_EXIST);
		}
	}

	public void clickOnElementsOfFloatingMenu(String linkName) {
		switch (linkName) {
		case MobilityXConstants.SUBMIT_TO_AIRES:
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSubmitToAires,
					MobilityXConstants.SUBMIT_TO_AIRES);
			CoreFunctions.clickElement(driver, _buttonSubmitToAires);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.RESUBMIT_TO_AIRES:
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonResubmitToAires,
					MobilityXConstants.RESUBMIT_TO_AIRES);
			CoreFunctions.click(driver, _buttonResubmitToAires, MobilityXConstants.RESUBMIT_TO_AIRES);
			CoreFunctions.waitUntilBrowserReady(driver);
			break;
		case MobilityXConstants.START_ROUTING:
			CoreFunctions.waitHandler(1);
			CoreFunctions.clickElement(driver, _buttonStartRouting);
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

	public void clickOnElementOnAuthorizationPage(String element) {
		switch (element) {
		case MobilityXConstants.SUBMIT_APPROVED_INITIATION:
			CoreFunctions.click(driver, _btnSubmitApprover, element);
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
			CoreFunctions.hoverAndClick(driver, _btnFlexBenefitSelection, element);
			break;
		case MobilityXConstants.VIEW_ALL_INITIATIONS:
			CoreFunctions.clickElement(driver, _linkViewAllInitiations);
			break;
		case MobilityXConstants.RESUBMIT_WITH_CHANGES_MADE_TO_LETTER_POLICY_DOCUMENTS:
			if (!CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("PreProd"))
				CoreFunctions.clickElement(driver, _buttonLetterPolicyDocuments);
			break;
		case MobilityXConstants.COMPLETE_CLONING:
			CoreFunctions.click(driver, _btnCompleteCloning, element);
			driver.switchTo().defaultContent();
			break;
		case MobilityXConstants.POINT_SUMMARY_PDF:
			int documentIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _linkDocumentsFileName,
					element);
			CoreFunctions.clickElement(driver, _linkDocumentsFileName.get(documentIndex));
			break;
		case MobilityXConstants.DOWNLOAD_DOCUMENT:
			Log.info(System.getProperty("user.home"));
			CoreFunctions.removeFileMatchingName(System.getProperty("user.home") + "/Downloads/", "Point Summary");
			CoreFunctions.clickElement(driver, _downloadDocument);
			CoreFunctions.waitForAMatchingFileToBeDownloaded(System.getProperty("user.home") + "/Downloads/",
					"Point Summary");
			break;
		default:
			Assert.fail(element + MobilityXConstants.NOT_EXIST);
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
		BusinessFunctions.selectValueFromDropdown(driver, _fundingECMember, authorisationInfo.fundingECMember);
		if (CoreFunctions.getPropertyFromConfig("envt").equalsIgnoreCase("PreProd")) {
			BusinessFunctions.selectOptionValueFromDropdown(_legalEntity, 2);
		}
	}

	private void fillAuthorizationReportingInfoForBSCDomesticForm(ReportingInfo reportingInfo) {
		CoreFunctions.clearAndSetText(driver, _inputCostCenter, reportingInfo.costCenter);
		BusinessFunctions.selectValueFromDropdown(driver, _selectDivision, reportingInfo.division);
		BusinessFunctions.selectValueFromDropdown(driver, _selectOperatingUnit, reportingInfo.operatingUnit);
	}

	private void fillAuthorizationRelocationInfoForBSCDomesticForm(RelocationInfo relocationInfo) {
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_listForAll, relocationInfo.transferType);
		BusinessFunctions.selectValueFromDropdown(driver, _assignmentType, relocationInfo.assignmentType);
		CoreFunctions.clearAndSetText(driver, _inputStartDate, CoreFunctions.getcurrentdate());
		CoreFunctions.clearAndSetText(driver, _txt_jobTitle, relocationInfo.newJobTitle);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _radioButtonLabel_Immigration, relocationInfo.immigration);
	}

	private void fillAuthorizationEmployeeInfoForBSCDomesticForm(BscEmployeeInfo bscEmployeeInfo) {
		BusinessFunctions.selectValueFromDropdown(driver, _relocationPolicy,
				CoreFunctions.getPropertyFromConfig("Assignment_Policy"));
		CoreFunctions.waitHandler(3);
		CoreFunctions.clearAndSetText(driver, _txt_EmployeeID, bscEmployeeInfo.employeeID);
		BusinessFunctions.selectRadioAsPerLabelText(driver, _homeStatusRadio, bscEmployeeInfo.homeStatus);
		CoreFunctions.clearAndSetText(driver, _txt_OriginHomeAddress, bscEmployeeInfo.originHomeAddress);
		CoreFunctions.clearAndSetText(driver, _txt_OriginCity, bscEmployeeInfo.originHomeCity);
		BusinessFunctions.selectValueFromDropdown(driver, _originState, bscEmployeeInfo.originHomeState);
		BusinessFunctions.selectValueFromDropdown(driver, _originCountry, bscEmployeeInfo.originHomeCountry.trim());
		BusinessFunctions.selectOptionValueFromDropdown(_originOfficeCityState, 2);
		BusinessFunctions.selectOptionValueFromDropdown(_destinationOfficeCityState, 2);
		CoreFunctions.waitHandler(3);
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _txt_mobileTelephone, MobilityXConstants.MOBILE_PHONE);
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
			return CoreFunctions.isElementExist(driver, _txtAuthFormSaved, 60);
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
			String expectedGrowlMessage = (buttonName
					.equals(MobilityXConstants.START_BENEFIT_SELECTION)
							? MobilityXConstants.GROWL_MESSAGE_FOR_MISSING_INFORMATION
							: (buttonName.equals(MobilityXConstants.SUBMIT_TO_AIRES) && (CoreFunctions
									.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")
									.equals(COREFLEXConstants.STATIC_FIXED)))
											? MobilityXConstants.GROWL_MESSAGE_FOR_MISSING_FLEX_BENEFITS_SELECTION
											: MobilityXConstants.GROWL_MESSAGE_FOR_SUBMIT_AUTHORIZATION);

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
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _textGrowlMessage);
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
			return (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")
					.equals(COREFLEXConstants.STATIC_FIXED)) ? true
							: checkFieldValidation(COREFLEXConstants.TOTAL_POINTS_VALUE, "0.49");

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_TOTAL_POINTS_FIELD_VALIDATION_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean checkFieldValidation(String fieldName, String inputValue) {
		boolean isValidationMessageDisplayed = false;
		switch (fieldName) {
		case COREFLEXConstants.TOTAL_POINTS_VALUE:
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputTotalPoints, inputValue,
					COREFLEXConstants.TOTAL_POINTS_VALUE);
			clickOnElementOnAuthorizationPage(MobilityXConstants.SUBMIT_TO_AIRES);
			if (CoreFunctions.isElementExist(driver, _textTotalPointsErrorMessage, 2)) {
				isValidationMessageDisplayed = CoreFunctions.getElementText(driver, _textTotalPointsErrorMessage)
						.equals(COREFLEXConstants.POINT_FIVE_TO_ONE_THOUSAND_RANGE_OLD_MESSAGE);
				BusinessFunctions.checkValidationBasedOnInput(isValidationMessageDisplayed, fieldName, inputValue);
				return true;
			}
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
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
			BusinessFunctions.selectValueFromDropdown(driver, _relocationPolicy,
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
					&& verifySelectedPointsDetailsOnBBPage();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_SECTION_DETAILS_ON_AUTH_FORM_POST_BENEFIT_CASHOUT_SELECTION,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isFlexBenefitSectionVerified;
	}

	private boolean verifySelectedPointsDetailsOnBBPage() {
		try {
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getElementText(driver, _selectedPoints)),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					MobilityXConstants.TOTAL_SELECTED_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getElementText(driver, _totalPoints)),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_REVIEWING_SELECTED_BENEFITS_POINTS_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
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
			for (Benefit benefit : getCoreBenefits(benefitType, policyRequiredFor)) {
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
		try {
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _textSelectedCoreBenefitsNameList,
					indexBenefit, true), benefit.getBenefitDisplayName(), MobilityXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textCoreAllowanceAmountList, indexBenefit, true),
					benefit.getBenefitAmount(), MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CORE_BENEFIT_DETAILS_ON_AUTH_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private List<Benefit> getCoreBenefits(String policyType, String policyRequiredFor) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (Benefit benefit : coreBenefits) {
				if (benefit.getPolicyCreationGroup().contains(policyRequiredFor)) {
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
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
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

	private List<Benefit> getBenefits(String policyType, String policyRequiredFor) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if (ben.getPolicyCreationGroup().contains(policyRequiredFor))
						benefitNameList.add(ben);
				}
			}
		}
		return benefitNameList;
	}

	private boolean verifySelectedBenefitDetailsOnAuthForm(int indexBenefit, Benefit benefit) {
		try {
			CoreFunctions.verifyText(CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsNameList,
					indexBenefit, true), benefit.getBenefitDisplayName(), MobilityXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsAmountAllowanceList,
							indexBenefit, true),
					benefit.getBenefitAmount(), MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsQuantityList, indexBenefit,
							true),
					String.valueOf(benefit.getNumberOfBenefitSelected()), MobilityXConstants.BENEFIT_QUANTITY);
			CoreFunctions.verifyValue(
					Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsPointsList, indexBenefit, true)
							.replace("pts", "").trim())),
					(Double.parseDouble(benefit.getPoints())) * (benefit.getNumberOfBenefitSelected()),
					MobilityXConstants.BENEFIT_POINTS);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_FLEX_BENEFIT_DETAILS_ON_SUBMISSION_CONFIRMATION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public boolean verifyInitiationSubmittedSuccessGrowlMessage() {
		boolean isGrowlMessageVerified = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textAuthFormSubmissionGrowlMessage,
					MobilityXConstants.INITIATION_GROWL_MESSAGE);
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

	public boolean verifyInitiationBenefitsSubmissionEmail() {
		try {
			String expEmailSubject = "New relocation authorization from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			return verifyFileIDPresent(expEmailSubject)
					&& verifyBenefitPointsInInitiationSubmittedEmail(expEmailSubject)
					&& verifyAuthFormSubmissionStatus(expEmailSubject)
					&& verifyBenefitsAndCashoutDetails(expEmailSubject);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyRevisedBenefitsSubmissionEmail() {
		try {
			String expEmailSubject = "Revised mobility initiation from "
					+ CoreFunctions.getPropertyFromConfig("Policy_ClientName") + " for  "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + ", "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT);
			return verifyFileIDPresent(expEmailSubject)
					&& verifyBenefitPointsInRevisedInitiationSubmittedEmail(expEmailSubject)
					&& verifyAuthFormSubmissionStatus(expEmailSubject);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_REVISED_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyMobilityApprovalSubmissionEmail() {
		try {
			String expEmailSubject = "Mobility Initiation for "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT) + " has been submitted";
			return verifyBenefitPointsInInitiationSubmittedEmail(expEmailSubject);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_MOBILITY_SUBMITTED_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyFileIDPresent(String expEmailSubject) {
		boolean isFileIDVerified = false;
		String actualResultFileID = null;
		try {
			actualResultFileID = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					MobilityXConstants.AUTH_FORM_SUBMISSION_USER_EMAILID, MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.AUTH_FORM_SUBMISSION_EMAIL_SENDER, expEmailSubject,
					MobilityXConstants.INITIATION_FILE_ID);
			isFileIDVerified = !(actualResultFileID.isEmpty());
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_READING_FILE_ID_FROM_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isFileIDVerified) {
			CoreFunctions.writeToPropertiesFile("Assignment_FileID", actualResultFileID.trim());
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_FILE_ID_PRESENT_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.PASS, actualResultFileID));
		}
		return isFileIDVerified;
	}

	private boolean verifyBenefitPointsInInitiationSubmittedEmail(String expectedEmailSubject) {
		boolean isBenefitPointsVerified = true;
		try {
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					MobilityXConstants.AUTH_FORM_SUBMISSION_USER_EMAILID, MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.AUTH_FORM_SUBMISSION_EMAIL_SENDER, expectedEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS);
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim();
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");
			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					MobilityXConstants.TOTAL_SUBMITTED_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[1].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);
			isBenefitPointsVerified = true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_SUBMITTED_AND_TOTAL_AVAILABLE_BENEFIT_POINTS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isBenefitPointsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_AND_TOTAL_AVAILABLE_BENEFIT_POINTS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.PASS));
		}
		return isBenefitPointsVerified;
	}

	private boolean verifyBenefitPointsInRevisedInitiationSubmittedEmail(String expectedEmailSubject) {
		try {
			String actualResultBenefitTotalPoints = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					MobilityXConstants.AUTH_FORM_SUBMISSION_USER_EMAILID, MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.AUTH_FORM_SUBMISSION_EMAIL_SENDER, expectedEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_TOTAL_POINTS_AND_SUBMITTED_POINTS);

			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim()
					.replace("<span style=\"color:Red\">", "").replace("<span style=\"\">", "").replace("</span>", "");
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");

			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					MobilityXConstants.TOTAL_SUBMITTED_POINTS);
			CoreFunctions.verifyValue(Double.parseDouble(actualResultBenefitPoints[1].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);

			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_REVISED_MOBILITY_INITIATION_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyAuthFormSubmissionStatus(String expectedEmailSubject) {
		boolean isSubmissionStatusVerified = true;
		try {
			String actualSubmissionStatus = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					MobilityXConstants.AUTH_FORM_SUBMISSION_USER_EMAILID, MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.AUTH_FORM_SUBMISSION_EMAIL_SENDER, expectedEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_STATUS);
			CoreFunctions.verifyText(actualSubmissionStatus, MobilityXConstants.SUBMITTED,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_STATUS);
			isSubmissionStatusVerified = true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AUTH_FORM_SUBMISSION_STATUS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isSubmissionStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_AUTH_FORM_SUBMISSION_STATUS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.PASS, MobilityXConstants.SUBMITTED));
		}
		return isSubmissionStatusVerified;
	}

	public boolean verifyRevisedBenefitsSubmissionEmail(MX_Client_Dashboard_BscData authorizationData) {
		try {
			boolean isBenefitPointsVerified = false;
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
			actualResultBenefitTotalPoints = actualResultBenefitTotalPoints.trim()
					.replace("<span style=\"color:Red\">", "").replace("<span style=\"\">", "").replace("</span>", "");
			String actualResultBenefitPoints[] = actualResultBenefitTotalPoints.split("/");
			double expectedTotalBenefitPoints = Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
			double expectedSubmittedBenefitPoints = Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints"));
			if ((Double.parseDouble((actualResultBenefitPoints[1].trim())) == (expectedTotalBenefitPoints))
					&& (Double.parseDouble(actualResultBenefitPoints[0].trim())) == (expectedSubmittedBenefitPoints)) {
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
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_REVISED_MOBILITY_INITIATION_SUBMISSION_EMAIL_CONTENTS,
						CoreConstants.PASS));
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
		boolean iFlexBenefitsSectionVerified = false, flag = false;
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
					flag = true;
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
		if (iFlexBenefitsSectionVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFITS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_PERSON_RESPONSIBLE_FOR_BENEFIT_SELECTION_IN_BLUEPRINT_APPLICATION,
					CoreConstants.FAIL, CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")));
			CoreFunctions.writeToPropertiesFile("CF_Client_BenefitSubmitted", "true");
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

	public boolean verifyCashoutSelectionOnAuthForm() {
		boolean isSelectedPortionCashoutDetailsVerified = false;
		for (WebElement element : _textSelectedFlexBenefitsNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_textSelectedFlexBenefitsNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				isSelectedPortionCashoutDetailsVerified = verifySelectedCashoutDetails(indexCashout,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				break;
			}
		}
		if (isSelectedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SELECTED_PORTION_CASHOUT_DETAILS_UNDER_FLEX_BENEFIT_SECTION_ON_AUTHORIZATION_FORM_PAGE,
					CoreConstants.PASS));
		}
		return isSelectedPortionCashoutDetailsVerified;
	}

	private boolean verifySelectedCashoutDetails(int indexCashout, String customCashoutBenefitName) {
		try {
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsNameList, indexCashout,
							true),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyValue(
					(Double.parseDouble((CoreFunctions
							.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsPointsList, indexCashout, true)
							.replace("pts", "").trim()))),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")),
					MobilityXConstants.CASHOUT_POINTS);
			CoreFunctions.verifyText(
					CoreFunctions.getItemsFromListByIndex(driver, _textSelectedFlexBenefitsAmountAllowanceList,
							indexCashout, true),
					BusinessFunctions.getMXClientExpectedCashoutDescription(),
					MobilityXConstants.CLIENT_CASHOUT_DESCRIPTION);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_PORTION_CASHOUT_DETAILS_UNDER_FLEX_BENEFIT_SECTION_ON_AUTHORIZATION_FORM_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public void resetPropertiesValue() {
		CoreFunctions.writeToPropertiesFile("CF_Client_AvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_SelectedCashOutPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalAvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Client_SelectedCashOutPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestTotalPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalSelectedPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Client_TotalSelectedPoints", "0");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestDenied", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestDenied", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_UndoDeleteBenefit", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestApproved", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestApproved", "false");
		CoreFunctions.writeToPropertiesFile("CF_Client_UndoDeleteBenefit", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeleteFlag", "false");
		CoreFunctions.writeToPropertiesFile("CF_Transferee_BenefitDeleteFlag", "false");
	}

	public boolean clickOnCreateLOU() {
		try {
			switchToiFrame_Authorization();
			CoreFunctions.clickElement(driver, _linkCreateLOU);
			driver.switchTo().defaultContent();
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	public boolean validateDynamicDocumnet(String documentName) {
		try {
			CoreFunctions.waitHandler(5);
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _downloadDocument,
					MobilityXConstants.DOWNLOAD_DOCUMENT);
			Log.info(CoreFunctions.getElementText(driver, _documentHeading));
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _documentHeading), documentName,
					MobilityXConstants.DEMO_DYNAMIC_DOCUMENT);
			CoreFunctions.removeFileMatchingName(System.getProperty("user.home") + "/Downloads/",
					"Demo Dynamic Document");
			CoreFunctions.clickElement(driver, _downloadDocument);
			CoreFunctions.waitForAMatchingFileToBeDownloaded(System.getProperty("user.home") + "/Downloads/",
					"Demo Dynamic Document");
			String filePath = System.getProperty("user.home") + "/Downloads/" + documentName;
			String file_content = documentName.contains(".docx") ? BusinessFunctions.getDocContent(filePath)
					: BusinessFunctions.getPdfDocContent(filePath);
			Log.info(file_content);
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					CoreFunctions.verifyTextContains(file_content, benefit.getBenefitDisplayName(),
							MobilityXConstants.BENEFIT_DISPLAY_NAME);
					if (!(StringUtils.countMatches(file_content, benefit.getBenefitDisplayName()) == 1))
						return false;
				}
			}
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_DYNAMIC_DOCUMENT_CONTENTS,
					CoreConstants.PASS, documentName));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DYNAMIC_DOCUMENT_CONTENTS,
							CoreConstants.FAIL, e.getMessage(), documentName));
			return false;
		}
	}

	public void enterEmpFirstAndLastNameForClonedAuthorization() {
		try {
			BusinessFunctions.generateUniqueValuesAndWriteToConfig(5);
			switchToiFrame_Authorization();
			CoreFunctions.explicitWaitTillElementVisibility(driver, _button_Continue,
					MobilityXConstants.CONTINUE_BUTTON);
			BusinessFunctions.selectValueFromDropdown(driver, _selectEmployeeName,
					MobilityXConstants.A_DIFFERENT_EMPLOYEE);
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

	/**
	 * Method to verify page navigation to CloneAuthForm field selection dialog page
	 */
	public boolean verifyPageNavigationToCloneAuthFormFieldSelectionDialog() {
		try {
			switchToiFrame_Authorization();
			CoreFunctions.waitHandler(3);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _dialogCloneAuthFormFieldSelectionHeading,
					MobilityXConstants.CLONE_AUTH_FORM_FIELD_SELECTION_DIALOG_HEADING);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _dialogCloneAuthFormFieldSelectionHeading),
					MobilityXConstants.CLONE_AUTH_FORM_FIELD_SELECTION_DIALOG_HEADING);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_NAVIGATED_TO_CLONE_AUTH_FORM_FIELD_SELECTION_DIALOG,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_CLONE_AUTH_FORM_FIELD_SELECTION_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}

	}

	public void verifyCloneAuthFormFieldValues(MX_Client_Dashboard_BscData authorizationData, String fieldName) {
		try {
			switch (fieldName) {
			case MobilityXConstants.RELOCATION_POLICY:
				CoreFunctions.verifyText(
						CoreFunctions.getElementText(driver, _textRelocationPolicyCloneAuthFormFieldDialog),
						CoreFunctions.getPropertyFromConfig("Assignment_Policy"), MobilityXConstants.RELOCATION_POLICY);
				break;
			case MobilityXConstants.HOME_STATUS:
				CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _textHomeStatusCloneAuthFormFieldDialog),
						authorizationData.bscEmployeeInfo.homeStatus, MobilityXConstants.HOME_STATUS);
				break;
			case MobilityXConstants.MOBILE_PHONE:
				CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _textMobilePhoneCloneAuthFormFieldDialog),
						authorizationData.bscEmployeeInfo.mobilePhone, MobilityXConstants.MOBILE_PHONE);
				break;
			case MobilityXConstants.EMAIL:
				CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _textEmailCloneAuthFormFieldDialog),
						authorizationData.bscEmployeeInfo.emailOne, MobilityXConstants.EMAIL);
				break;
			case MobilityXConstants.TRANSFER_TYPE:
				CoreFunctions.verifyText(
						CoreFunctions.getElementText(driver, _textTransferTypeCloneAuthFormFieldDialog),
						authorizationData.relocationInfo.transferType, MobilityXConstants.TRANSFER_TYPE);
				break;
			case MobilityXConstants.ASSIGNMENT_TYPE:
				CoreFunctions.verifyText(
						CoreFunctions.getElementText(driver, _textAssignmentTypeCloneAuthFormFieldDialog),
						authorizationData.relocationInfo.assignmentType, MobilityXConstants.ASSIGNMENT_TYPE);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLONE_AUTH_FORM_DIALOG_DEFAULT_POPULATED_FIELD_VALUE,
					CoreConstants.FAIL, e.getMessage(), fieldName));
		}

	}

	public void selectCloneAuthFormFieldCheckbox(String checkBoxName) {
		try {
			switch (checkBoxName) {
			case MobilityXConstants.RELOCATION_POLICY:
				CoreFunctions.hoverAndClick(driver, _checkBoxRelocationPolicy, MobilityXConstants.RELOCATION_POLICY);
				break;
			case MobilityXConstants.FLEX_BENEFITS:
				CoreFunctions.hoverAndClick(driver, _checkBoxFlexBenefits, MobilityXConstants.FLEX_BENEFITS);
				break;
			case MobilityXConstants.AUTHORIZATION_TYPE:
				CoreFunctions.hoverAndClick(driver, _checkBoxGlobalMobilityAssesment,
						MobilityXConstants.GLOBAL_MOBILITY_ASSESMENT);
				CoreFunctions.hoverAndClick(driver, _checkBoxAiresInstructions, MobilityXConstants.AIRES_INSTRUCTIONS);
				CoreFunctions.hoverAndClick(driver, _checkBoxCostEstimateRequired,
						MobilityXConstants.COST_ESTIMATE_REQUIRED);
				break;
			case MobilityXConstants.SELECT_ALL:
				for (int index = 0; index < _checkBoxSelectAllList.size(); index++) {
					CoreFunctions.hoverAndClick(driver, _checkBoxSelectAllList.get(index),
							MobilityXConstants.SELECT_ALL);
					CoreFunctions.waitHandler(1);
				}
				break;
			case MobilityXConstants.AUTHORIZATION_INFORMATION:
				CoreFunctions.hoverAndClick(driver, _checkBoxHrManagerName, MobilityXConstants.HR_MANAGER_NAME);
				CoreFunctions.hoverAndClick(driver, _checkBoxHiringManagerName, MobilityXConstants.HIRING_MANAGER_NAME);
				CoreFunctions.hoverAndClick(driver, _checkBoxFundingEcMember, MobilityXConstants.FUNDING_EC_MEMBER);
				break;
			case MobilityXConstants.IMMIGRATION:
				CoreFunctions.hoverAndClick(driver, _checkBoxImmigration, MobilityXConstants.IMMIGRATION);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CLONE_AUTH_FORM_DIALOG_DEFAULT_POPULATED_FIELD_VALUE,
					CoreConstants.FAIL, e.getMessage(), checkBoxName));
		}

	}

	public boolean verifyFlexBenefitsFieldDisplayed() {
		try {
			CoreFunctions.waitHandler(2);
			CoreFunctions.scrollDownUsigActions(driver);
//			CoreFunctions.scrollToElementUsingJS(driver, _checkBoxFlexBenefits, COREFLEXConstants.FLEX_BENEFITS);;
			CoreFunctions.hover(driver, _checkBoxFlexBenefits);
			Log.info(CoreFunctions.getAttributeText(_checkBoxFlexBenefits, "style"));
			if (CoreFunctions.getAttributeText(_checkBoxFlexBenefits, "style").contains("display:none")) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.FLEX_BENEFIT_FIELD_NOT_DISPLAYED_POST_RELOCATION_POLICY_SELECTION_ON_CLONE_AUTH_FORM_DIALOG,
						CoreConstants.FAIL));
				return false;
			} else {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_FIELD_DISPLAYED_POST_RELOCATION_POLICY_SELECTION_ON_CLONE_AUTH_FORM_DIALOG,
						CoreConstants.PASS));
				selectCloneAuthFormFieldCheckbox(MobilityXConstants.FLEX_BENEFITS);
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_FLEX_BENEFIT_FIELD_DISPLAYED_POST_RELOCATION_POLICY_SELECTION_ON_CLONE_AUTH_FORM_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}

	}

	public boolean verifyAuthFormPopulatedPostCloning(MX_Client_Dashboard_BscData authorizationData) {
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
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AUTH_FORM_FIELDS_POPULATED_POST_CLONING,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyTotalPointsSectionPostCloning() {
		boolean isTotalPointsSectionVerified = false, flag = false;
		try {
			switch (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_FlexSetupType")) {
			case COREFLEXConstants.USER_DEFINED:
				if (CoreFunctions.isElementExist(driver, _inputTotalPoints, 3)) {
					Reporter.addStepLog(MessageFormat.format(
							MobilityXConstants.TOTAL_POINTS_SECTION_DISPLAYED_ON_AUTH_FORM_FOR_USER_DEFINED_POLICY_TYPE_SELECTION_IN_BLUEPRINT_APPLICATION,
							CoreConstants.PASS));
					isTotalPointsSectionVerified = verifyTotalPointsContents() && verifyTotalPointsValue();
					flag = true;
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
		if (isTotalPointsSectionVerified && flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_TOTAL_POINTS_SECTION_AND_VALUE_ON_AUTH_FORM_POST_CLONING,
					CoreConstants.PASS));
		}
		return isTotalPointsSectionVerified;
	}

	private boolean verifyTotalPointsValue() {
		try {
			CoreFunctions.verifyText(CoreFunctions.getAttributeText(_inputTotalPoints, "value"),
					CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"),
					MobilityXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _inputTotalPoints);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_TOTAL_POINTS_VALUE_POST_AUTH_FORM_CLONING,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Log.info(e.getMessage());
			return false;
		}
	}

	public void searchAndSelectEmployee(String employeeName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.waitUntilBrowserReady(driver);
		CoreFunctions.clearAndSetText(driver, _inputSearchEmployee, employeeName);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _searchedEmployeeList);
		CoreFunctions.selectItemInListByText(driver, _searchedEmployeeList, employeeName);
		CoreFunctions.waitUntilBrowserReady(driver);
	}

	public boolean verifyAssignmentSubmittedPointsDetails() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _textTransfereeUserNameTitle,
					MobilityXConstants.TRANSFEREE_NAME);
			String actualPointsWithText[] = CoreFunctions.getElementText(driver, _textInitialSpentAndTotalPoints)
					.split(" ");
			String actualSpentAndTotalPoints[] = actualPointsWithText[0].split("/");
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _textClientName),
					CoreFunctions.getPropertyFromConfig("Policy_ClientName"), MobilityXConstants.CLIENT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _textTransfereeUserNameTitle),
					(CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
					MobilityXConstants.TRANSFEREE_NAME);

			CoreFunctions.verifyValue(Double.parseDouble(actualSpentAndTotalPoints[0]),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					MobilityXConstants.TOTAL_SPENT_POINTS);

			CoreFunctions.verifyValue(Double.parseDouble(actualSpentAndTotalPoints[1]),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					MobilityXConstants.TOTAL_AVAILABLE_POINTS);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.ASSIGNMENT_SUBMITTED_POINTS_DETAIL_MATCHED_ON_MOBILITY_JOURNEY_HOME_PAGE,
					CoreConstants.PASS));
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ASSIGNMENT_SUBMITTED_POINTS_DETAIL_ON_MOBILITY_JOURNEY_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		return false;
	}

	public boolean verifyFlexPdfUnderDocumentsSection(String sectionTitle, DataTable dataTable) {
		try {
			List<Map<String, String>> dataMap = dataTable.asMaps(String.class, String.class);
//			CoreFunctions.scrollToElementUsingJS(driver, _headingDocuments, MobilityXConstants.DOCUMENTS);
			int documentIndex = BusinessFunctions.returnindexItemFromListUsingText(driver, _linkDocumentsFileName,
					dataMap.get(0).get("FileName"));
			CoreFunctions.verifyText(
					CoreFunctions.getElementText(driver,
							CoreFunctions.findSubElement(_linkDocumentsParentElementList.get(documentIndex),
									_textDocumentsFileName)),
					dataMap.get(0).get("FileName"), MobilityXConstants.FLEX_PDF_DOCUMENT_FILE_NAME);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getElementText(driver, _linkDocumentsParentElementList.get(documentIndex)),
					dataMap.get(0).get("Category"), MobilityXConstants.FLEX_PDF_DOCUMENT_CATEGORY);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getElementText(driver, _linkDocumentsParentElementList.get(documentIndex)),
					dataMap.get(0).get("Service"), MobilityXConstants.FLEX_PDF_DOCUMENT_SERVICE);
			CoreFunctions.verifyTextContains(
					CoreFunctions.getElementText(driver, _linkDocumentsParentElementList.get(documentIndex)),
					CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"),
					MobilityXConstants.FLEX_PDF_DOCUMENT_UPLOAD_DATE);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_POINT_SUMMARY_FLEX_PDF_DOCUMENT_DETAILS_UNDER_DOCUMENTS_SECTION_OF_MOBILITY_JOURNEY_PAGE,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POINT_SUMMARY_FLEX_PDF_DOCUMENT_DETAILS_UNDER_DOCUMENTS_SECTION_OF_MOBILITY_JOURNEY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyFlexPdfPreviewScreen(String documentName) {
		try {
			switchToiFrame_Authorization();
			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _documentHeading, "document heading");
			Log.info(CoreFunctions.getElementText(driver, _documentHeading));
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _documentHeading), documentName,
					MobilityXConstants.FLEX_PDF_DOCUMENT_FILE_NAME_PREVIEW_PAGE);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _documentType),
					MobilityXConstants.AUTHORIZATION_FORMS, MobilityXConstants.FLEX_PDF_DOCUMENT_TYPE_PREVIEW_PAGE);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_POINT_SUMMARY_FLEX_PDF_DOCUMENT_OPENED_IN_PREVIEW_MODE_ON_MOBILITY_JOURNEY_PAGE,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POINT_SUMMARY_FLEX_PDF_DOCUMENT_OPENED_IN_PREVIEW_MODE_ON_MOBILITY_JOURNEY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyFlexPdfDownloadedDocument(String documentName, String clientName, String clientUserName) {
		try {
			String filePath = System.getProperty("user.home") + "/Downloads/" + documentName;
			String file_content = BusinessFunctions.getPdfDocContent(filePath);

			if (verifyPointSummaryPDFContents(documentName, file_content, clientName, clientUserName)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
						CoreConstants.PASS, documentName));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
					CoreConstants.FAIL, e.getMessage(), documentName));
			return false;
		}
		return false;
	}

	private boolean verifyPointSummaryPDFContents(String documentName, String actualFileContent, String clientName,
			String clientUserName) {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		try {
			CoreFunctions.verifyTextContainsIgnoreCase(actualFileContent,
					(CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
					MobilityXConstants.TRANSFEREE_NAME);
			CoreFunctions
					.verifyTextContains(actualFileContent,
							MobilityXConstants.EXPECTED_SPENT_POINTS_TEXT_PDF_DOCUMENT
									.replace("SP",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Client_TotalSelectedPoints"))))
									.replace("TP",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))),
							MobilityXConstants.SPENT_AND_TOTAL_POINTS);
			CoreFunctions.verifyTextContains(actualFileContent,
					MobilityXConstants.EXPECTED_CURRENT_POINT_BALANCE_TEXT_PDF_DOCUMENT.replace("CB",
							format.format(Double
									.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_AvailablePoints")))),
					MobilityXConstants.CURRENT_POINT_BALANCE);

			CoreFunctions.verifyTextContains(
					actualFileContent, MobilityXConstants.EXPECTED_POINTS_SUBMITTED_BY_CLIENT_PDF_DOCUMENT
							.replace("CN", clientName).replace("CUN", clientUserName),
					MobilityXConstants.POINTS_SUBMITTED_BY_CLIENT_TEXT);

			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					CoreFunctions.verifyTextContains(actualFileContent, benefit.getBenefitDisplayName(),
							MobilityXConstants.BENEFIT_DISPLAY_NAME);
					CoreFunctions.verifyTextContains(actualFileContent, benefit.getBenefitAmount(),
							MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyTextContains(actualFileContent,
							format.format(
									Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
							MobilityXConstants.BENEFIT_POINTS);
				} else {
					continue;
				}
			}
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				CoreFunctions.verifyTextContains(actualFileContent,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						MobilityXConstants.CUSTOM_CASHOUT_NAME);
				CoreFunctions.verifyTextContains(actualFileContent,
						format.format(Double
								.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints"))),
						MobilityXConstants.CASHOUT_POINTS);
				CoreFunctions.verifyTextContains(actualFileContent,
						BusinessFunctions.getMXClientExpectedCashoutDescription(),
						MobilityXConstants.CLIENT_CASHOUT_DESCRIPTION);
			}

			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_AND_POINTS_DETAILS_BY_CLIENT_ON_FLEX_PDF_DOWNLOADED_DOCUMENT,
					CoreConstants.FAIL, e.getMessage(), documentName));
			return false;
		}
	}

	private boolean verifyBenefitsAndCashoutDetails(String expectedEmailSubject) {
		try {
			String actualResultBenefitsAndCashoutDetails = EmailUtil.searchEmailAndReturnResult(MobilityXConstants.HOST,
					MobilityXConstants.AUTH_FORM_SUBMISSION_USER_EMAILID, MobilityXConstants.AUTO_EMAIL_PWD,
					MobilityXConstants.AUTH_FORM_SUBMISSION_EMAIL_SENDER, expectedEmailSubject,
					MobilityXConstants.NEW_INITIATION_SUBMISSION_BENEFIT_CASHOUT_DETAILS);
			verifyBenefitCashoutDetailsInEmail(actualResultBenefitsAndCashoutDetails);
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_SUBMITTED_BENEFITS_AND_CASHOUT_DETAILS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.PASS));
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_SUBMITTED_BENEFITS_AND_CASHOUT_DETAILS_IN_NEW_INITIATION_SUBMITTED_EMAIL,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private void verifyBenefitCashoutDetailsInEmail(String actualText) {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
				CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
			if (benefit.getSelectBenefitOnFPTPage()) {
				CoreFunctions.verifyTextContains(actualText, benefit.getBenefitDisplayName(),
						MobilityXConstants.BENEFIT_DISPLAY_NAME);
				CoreFunctions.verifyTextContains(actualText, benefit.getBenefitAmount(),
						MobilityXConstants.BENEFIT_ALLOWANCE_AMOUNT);
				CoreFunctions.verifyTextContains(actualText,
						format.format(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
						MobilityXConstants.BENEFIT_POINTS);
			} else {
				continue;
			}
		}
		if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
				|| (((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
						.equals(MobilityXConstants.AFTER_RELOCATION_ONLY)))
						&& CoreFunctions.getPropertyFromConfig("CF_CashoutSubmitted_Flag").equalsIgnoreCase("true"))) {
			CoreFunctions.verifyTextContains(actualText,
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyTextContains(actualText,
					format.format(
							Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints"))),
					MobilityXConstants.CASHOUT_POINTS);
//		CoreFunctions.verifyTextContains(actualText, BusinessFunctions.getMXClientExpectedCashoutDescription(),
//					MobilityXConstants.CLIENT_CASHOUT_DESCRIPTION);
		}
	}

}