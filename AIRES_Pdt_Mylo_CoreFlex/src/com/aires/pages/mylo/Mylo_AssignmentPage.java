package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;
import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.aires.testdatatypes.mylo.MyloCAStates;
import com.aires.testdatatypes.mylo.MyloIndiaStates;
import com.aires.testdatatypes.mylo.MyloUSStates;
import com.aires.testdatatypes.mylo.Mylo_AssignmentShipmentDetails;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_PREPROD;
import com.aires.testdatatypes.mylo.Mylo_Assignment_HistoryDetails_UAT;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;

public class Mylo_AssignmentPage extends Base {

	public Mylo_AssignmentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[id='empName']")
	private List<WebElement> _airesFileTeamMemberName;

	@FindBy(how = How.CSS, using = "input[id='startDate']")
	private List<WebElement> _airesFileTeamStartDates;

	@FindBy(how = How.CSS, using = "input[id='endDate']")
	private List<WebElement> _airesFileTeamEndDates;

	@FindBy(how = How.CSS, using = "input[id='empFunctionCode']")
	private List<WebElement> _airesFileTeamRoleName;

	@FindBy(how = How.XPATH, using = "//label[text()='Role']//preceding-sibling::ng-select")
	private WebElement _roleSelectButtton;

	@FindBy(how = How.XPATH, using = "//label[text()='Name']//preceding-sibling::ng-select")
	private WebElement _memberNameSelectButtton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button")
	private WebElement _airesFileTeamAddButton;
	
	@FindBy(how = How.XPATH, using = "//i[@class='icon-XCircle_Open']/parent::button")
	private WebElement _airesFileTeamCancelButton;
	
	@FindBy(how = How.XPATH, using = "//i[@class='icon-FloppyDisk_Open']")
	private WebElement _airesFileTeamSaveButton;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/following::tbody[1]/tr")
	private List<WebElement> _noOfAddedAiresFileTeamMember;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _popUpMessage;

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/ancestor::tr/following-sibling::tbody/descendant::input")
	private List<WebElement> _airesFileTeamMemberGrid;

	@FindBy(how = How.XPATH, using = "//button[text()='No' and contains(@class,'smallbutton')]")
	private WebElement _NoButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Yes']")
	private WebElement _YesButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _SaveButton;
	
	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open save_section']")
	private WebElement _otherAddressSaveButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement _CancelButton;

	@FindBy(how = How.CSS, using = "input[placeholder='FILE ID']")
	private WebElement _fileInfoFileId;

	@FindBy(how = How.CSS, using = "input[placeholder='Client Id']")
	private WebElement _fileInfoClientId;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='policyType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoPolicyType;

	@FindBy(how = How.XPATH, using = "//app-aires-file-information/descendant::span[text()='Details']")
	private WebElement _fileInfoDetailsCarrot;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='status']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoStatus;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='provider']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoProvider;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='office']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoOffice;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='transferType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoTransferType;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='journeyType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoJourneyType;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='homeStatus']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoHomeStatus;

	@FindBy(how = How.CSS, using = "app-aires-file-information  span[class='form-check-sign']")
	private List<WebElement> _fileInfoCheckboxes;

	@FindBy(how = How.CSS, using = "app-aires-file-information input[type='checkbox']")
	private List<WebElement> _fileInfoCheckBoxText;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-FloppyDisk_Open save_section']")
	private WebElement _fileInfoSaveButton;

	@FindBy(how = How.XPATH, using = "//i[@class='icon-XCircle_Open close_section']/parent::button")
	private WebElement _fileInfoCancelButton;

	@FindBy(how = How.CSS, using = "app-aires-file-information button[class='action-icon-right-panel']")
	private WebElement _fileInfoEditButton;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='taxTreatment']")
	private WebElement _fileInfoTaxTreatmentSection;

	@FindBy(how = How.XPATH, using = "//div[@style='display: block;']")
	private WebElement _fileInfoSuccessMessage;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _Okbutton;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@name='policyType']")
	private WebElement _fileInfoPolicyTypeBgColor;
	
	// *************** Other Adddresses section ***********************//
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Mailing Address']/preceding-sibling::i")
	private WebElement _addMailAddressBtn;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Temporary Address']/preceding-sibling::i")
	private WebElement _addTempAddressBtn;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@name='popupcountry']")
	private WebElement _countryDropdown;
	
	@FindBy(how = How.XPATH, using = "//h5[@class='modal-title']/following::ng-select[@name='state']")
	private WebElement _stateDropdown;
	
	@FindBy(how = How.XPATH, using = "//h5[@class='modal-title']/following::ng-select[@name='state']//following-sibling::label")
	private WebElement _stateFieldName;
	
	@FindBy(how = How.XPATH, using = "//h5[@class='modal-title']/following::input[@formcontrolname='stateProvince']")
	private WebElement _stateFieldTextType;
	
	@FindBy(how = How.CSS, using = "h1[class='popupheader']")
	private WebElement _popUpHeader;
	
	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _modalTitle;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//ng-select[@name='country']")
	private WebElement _tempAddressCountryDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//ng-select[@name='country']")
	private WebElement _mailAddressCountryDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//ng-select[@name='state']")
	private WebElement _tempAddressStateDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@name='state']")
	private WebElement _tempAddressStateTextField;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//ng-select[@name='state']")
	private WebElement _mailAddressStateDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@name='state']")
	private WebElement _mailAddressStateTextField;

	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//ng-select[@name='type']")
	private WebElement _tempAddressTypeDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//ng-select[@name='type']")
	private WebElement _mailAddressTypeDropdown;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='city']")
	private WebElement _tempAddressCityValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='city']")
	private WebElement _mailAddressCityValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//ng-select[@name='country']//descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _mailAddressCountryValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//ng-select[@name='country']//descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _tempAddressCountryValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//ng-select[@name='state']//descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _mailAddressStateDropDownValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//ng-select[@name='state']//descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _tempAddressStateDropdownValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='zipCode']")
	private WebElement _tempAddressZipCodeValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='zipCode']")
	private WebElement _mailAddressZipCodeValue;

	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='state']")
	private WebElement _tempAddressStateValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='address1']")
	private WebElement _tempAddress1Value;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='address2']")
	private WebElement _tempAddress2Value;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='comment']")
	private WebElement _tempAddressCommentsValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//input[@id='fromDate']")
	private WebElement _tempAddressFromDateValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='state']")
	private WebElement _mailAddressStateValue;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='address1']")
	private WebElement _mailAddress1Value;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='address2']")
	private WebElement _mailAddress2Value;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='comment']")
	private WebElement _mailAddressCommentsValue;

	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//input[@id='fromDate']")
	private WebElement _mailAddressFromDateValue;
	
	@FindBy(how = How.CSS, using = "input[id='popupcity']")
	private WebElement _otherAddressaddCityValue;
	
	@FindBy(how = How.CSS, using = "input[id='popupfromDate']")
	private WebElement _otherAddressaddFromDateValue;
	
	@FindBy(how = How.CSS, using = "input[id='popupzipCode']")
	private WebElement _otherAddressaddZipCodeValue;
	
	@FindBy(how = How.CSS, using = "input[id='popupcomment']")
	private WebElement _otherAddressaddCommentValue;
	
	@FindBy(how = How.CSS, using = "input[name='popupstate']")
	private WebElement _otherAddressaddStateValue;

	@FindBy(how = How.XPATH, using = "//input[@id='state']//following-sibling::label")
	private WebElement _otherAddressStateLabelName;
	
	@FindBy(how = How.CSS, using = "input[id='popupaddress1']")
	private WebElement _otherAddressaddAddress1Value;
	
	@FindBy(how = How.CSS, using = "input[id='popupaddress2']")
	private WebElement _otherAddressaddAddress2Value;
	
	@FindBy(how = How.CSS, using = "input[id='popupfromDate']")
	private WebElement _otherAddressaddAddressFromDateValue;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-controls='collapsetemporaryAddress']")
	private WebElement _tempAddressDropdown;
	
	@FindBy(how = How.XPATH, using = "//button[@aria-controls='collapsemailingAddress']")
	private WebElement _mailAddressDropdown;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Delete']")
	private WebElement _DeleteButton;
	
	@FindBy(how = How.CSS, using = "app-address i[class='icon-Trash_Open Trash_icon']")
	private WebElement _addressDeleteButton;
	
	@FindBy(how = How.CSS, using = "app-address[id='temporaryAddress'] i[class='icon-Pencil_Open']")
	private WebElement _tempEditButton;
	
	@FindBy(how = How.CSS, using = "app-address[id='mailingAddress'] i[class='icon-Pencil_Open']")
	private WebElement _mailEditButton;
	
	@FindBy(how = How.XPATH, using = "//h2[text()='Success']//following::div[@id='swal2-content']")
	private WebElement _successMessage;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'toast-close-btn')]")
	private WebElement _closeBtn;
	
	// *************** History section ***********************//

	@FindBy(how = How.CSS, using = "p[class='history-address']")
	private List<WebElement> _historyCardDropdownAddress;
	
	@FindBy(how = How.CSS, using = "span[class='history-id']")
	private List<WebElement> _historyCardDropdownFileIdClient;
	
	@FindBy(how = How.XPATH, using = "//figcaption/h3")
	private List<WebElement> _historyCardDropdownTransferreName;
		
	@FindBy(how = How.CSS, using = "div[class='historyusertitle text-truncate']")
	private List<WebElement> _historyCardDisplayedAddress;
	
	@FindBy(how = How.XPATH, using = "//div[@class='historyrole text-truncate']/span")
	private List<WebElement> _historyCardDisplayedFileIdClient;
	
	@FindBy(how = How.CSS, using = "div[class='historyfiletitle text-truncate']")
	private List<WebElement> _historyCardDisplayedTransferreName;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'historycard')]")
	private WebElement _historyCardSection;
	
	@FindBy(how = How.CSS, using = "button[id='closedesc']")
	private List<WebElement> _historyCardCloseBtn;
	
	@FindBy(how = How.CSS, using = "button[aria-controls='collapseHistory']")
	private WebElement _historyCardDropdown;
	
	@FindBy(how = How.XPATH, using = "//canvas[@data-id='canvas']/following-sibling::input")
	private WebElement __webSwingSection;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "a[class='dropdown-item']")
	private List<WebElement> _shipmentDropdownValues;
	
	// *************** Identification & Documentation section ***********************//
	
	@FindBy(how = How.XPATH, using = "//app-aires-identification/descendant::label[text()='Add']/parent::button")
	private WebElement _identDocAddIcon;
	
	@FindBy(how = How.XPATH, using = "//app-aires-identification/descendant::label[text()='Edit']/parent::button")
	private WebElement _identDocEditIcon;
	
	@FindBy(how = How.XPATH, using = "//app-aires-identification/descendant::label[text()='Save']/parent::button")
	private WebElement _identDocSaveIcon;
	
	@FindBy(how = How.XPATH, using = "//app-aires-identification/descendant::label[text()='Cancel']/parent::button")
	private WebElement _identDocCancelIcon;
	
	@FindBy(how = How.XPATH, using = "//app-identification-detail/tbody/tr")
	private WebElement _noOfRowsIdentDocDetails;
	
	@FindBy(how = How.XPATH, using = "//ng-select[contains(@id,'IDType')]//descendant::span[@class='ng-arrow-wrapper']")
	private List<WebElement> _identDocTypeDropdowns;
	
	@FindBy(how = How.XPATH, using = "//ng-select[contains(@id,'IDCountry')]")
	private List<WebElement> _identDocCountryDropdowns;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'IDNumber')]")
	private List<WebElement> _identDocNumbers;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'fromDate')]")
	private List<WebElement> _identDocFromDates;
	
	@FindBy(how = How.XPATH, using = "//input[contains(@id,'toDate')]")
	private List<WebElement> _identDocToDates;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Remove']//parent::button")
	private List<WebElement> _identDocDeleteIcon;	
	
	@FindBy(how = How.XPATH, using = "//ng-select[contains(@id,'IDType')]//span[contains(@class,'ng-value-label')]")
	private List<WebElement> _identDocTypeValuesSelected;
	
	@FindBy(how = How.XPATH, using = "//ng-select[contains(@id,'IDCountry')]/descendant::span[contains(@class,'ng-value-label')]")
	private List<WebElement> _identDocCountryValuesSelected;
	
	@FindBy(how = How.XPATH, using = "//a[contains(@class,'idlist__item')]")
	private List<WebElement> _identDocTransferreFamilyMembersName;
	
	@FindBy(how = How.XPATH, using = "//tr[@class='tablehead']//h1")
	private List<WebElement> _assignmentSectionHeaders;
	
	@FindBy(how = How.CSS, using = "h1[id='purple_bubble_name']")
	private WebElement _transfereeNameHeader;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private List<WebElement> _alertMessageList;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'toast-error')]")
	private List<WebElement> _alertMessageListBackColour;
	
	@FindBy(how = How.XPATH, using = "//ng-select[contains(@id,'IDType')]")
	private List<WebElement> _identDocTypeBackColour;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Remove']/preceding-sibling::i")
	private List<WebElement> _removeButton;
	
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mylo-errorpopup')]")
	private WebElement _myloErrorPopUp;
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'swal2-confirm btn btn-primary smallbutton margintop')]")
	private WebElement _OKButtonPopUp;
			
	int noOfAiresFileTeamMember;
	LinkedHashMap<String, String> airesFileTeamExistingMembers = new LinkedHashMap<String, String>();
	LinkedHashMap<String, WebElement> airesFileInfoFieldsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> otherAdressFieldValueMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> otherAdressvalidFieldValueMap = new LinkedHashMap<String, String>();
	List<WebElement> countryList = new ArrayList<WebElement>();
	List<WebElement> identityTypeList = new ArrayList<WebElement>();
	List<WebElement> typeDropDownList = new ArrayList<WebElement>();
	List<WebElement> stateList = new ArrayList<WebElement>();
	List<String> historyfileIds = new ArrayList<String>();
	List<String> historyDetails = new ArrayList<String>();
	List<String> identDocTypeValues = new ArrayList<String>();
	List<String> identDocCountryValues = new ArrayList<String>();
	List<String> identDocNumberValues = new ArrayList<String>();
	List<String> identDocFromDateValues = new ArrayList<String>();
	List<String> identDocToDateValues = new ArrayList<String>();

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	final By _fileInfoOfficeDropdownReadOnly = By.xpath("//ng-select[@name='office']//descendant::input[@disabled='']");
	final By _fileInfoPolicyTypeDropdownReadOnly = By.xpath("//ng-select[@name='policyType']//input[@disabled]");
	final By _assignmentSubMenus = By.xpath("//div[contains(@class,'navlist__container')]/li/descendant::a");

	MyloAssignmentDetails assignmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentDetailsByApplication(MYLOConstants.IRIS);
	//Commented Code is used for debugging in local
	/*Mylo_AssignmentShipmentDetails assignmentShipmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentShipmentDetailsByEnv(CoreFunctions.getPropertyFromConfig("envt"));*/
			
	Mylo_AssignmentShipmentDetails assignmentShipmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentShipmentDetailsByEnv(System.getProperty("envt"));
	
	String updatedTeamMember, updatedPolicyType, updatedTaxTreatment, updatedOffice, updatedJourneyType, updatedTransferType,
	updatedHomeStatus, updatedFileInfoCheckboxSelected, updatedTempAddressCityValue,
	updatedMailAddressCityValue, updatedTempAddressZipCodeValue, updatedMailAddressZipCodeValue,
	updatedTempAddressCommentsValue, updatedMailAddressCommentsValue, updatedTempAddressStateValue,
	updatedMailAddressStateValue, updatedTempAddress1Value, updatedMailAddress1Value, updatedTempAddress2Value,
	updatedMailAddress2Value, updatedTempAddressFromDateValue, updatedMailAddressFromDateValue,updatedCountryValue,updatedTypeValue,updatedNoValue,updatedFromDate,updatedToDate;

	/**
	 * @param option 
	 * Click Different tabs in Assignment page
	 */
	public void clickAssignmentTabs(String option) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		CoreFunctions.selectItemInListByText(driver, subTabs, option);
	}

	/**
	 * @param tabName
	 * @return 
	 * Verify Active tab in Assignment page
	 */
	public boolean verifyActiveTab(String tabName) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, subTabs, tabName);
		return (tabElement.getAttribute("class").contains("active")) ? true : false;
	}

	// *************** Aires File Team Section***********************//

	/**
	 * @param buttonName 
	 * Click Different Buttons on Aires File Team section
	 */
	public void clickButtonOnAiresFileTeamSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			noOfAiresFileTeamMember = _noOfAddedAiresFileTeamMember.size();
			airesFileTeamExistingMembers = CoreFunctions.returnMapFromBothLists(driver, _airesFileTeamRoleName,
					_airesFileTeamMemberName);
			CoreFunctions.click(driver, _airesFileTeamAddButton, MYLOConstants.ADD_BUTTON);
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamCancelButton, MYLOConstants.CANCEL_BUTTON);
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamSaveButton, _airesFileTeamSaveButton.getText());
			break;
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _NoButton, _NoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			break;
		}
	}

	/**
	 * @param roleName 
	 * Add Role By Name on Aires File Team section
	 */
	public void addRole(String roleName) {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _roleSelectButtton,
				_roleSelectButtton.getAttribute(MYLOConstants.NAME));
		CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
		List<WebElement> roleList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, roleList);
		CoreFunctions.selectItemInListByText(driver, roleList, roleName);
	}

	/**
	 * @param userType
	 * @param roleName
	 * @return
	 * Verifying Role availability for specific Users on Aires File Team section
	 */
	public boolean verifyRoleAccessFromUserType(String userType, String roleName) {
		try {
			if (userType.equals(MYLOConstants.USER_WITHOUT_RESOURCE15))
				Assert.assertFalse(verifyRoleInDropdown(roleName));
			else
				Assert.assertTrue(verifyRoleInDropdown(roleName));
		} catch (Exception e) {
			return false;
		}
		return true;
	}

	/**
	 * @param roleName
	 * @return
	 * Verifying Role availability in the dropdown on Aires File Team section
	 */
	public boolean verifyRoleInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList, roleName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, roleName, MYLOConstants.ROLE_NAME));
			return false;
		}
	}

	/**
	 * @param memberName
	 * Add Team Member By Name or Random selection on Aires File Team section
	 */
	public void addTeamMember(String memberName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			if (memberName != MYLOConstants.RANDOM) {
				CoreFunctions.selectItemInListByText(driver, optionsList, memberName);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, memberName, MYLOConstants.AIRES_FILE_TEAM));
			} else {
				optionsList.remove(0);
				updatedTeamMember = CoreFunctions.getRandomElementValueFromList(driver, optionsList);
				CoreFunctions.selectItemInListByText(driver, optionsList, updatedTeamMember);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_ELEMENT_VALUE_ON_SECTION,
						CoreConstants.PASS, MYLOConstants.ROLE_NAME, updatedTeamMember, MYLOConstants.AIRES_FILE_TEAM));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, memberName, MYLOConstants.MEMBER_NAME));
		}

	}

	/**
	 * @param roleName
	 * @return
	 * Verify Team Member which is displaying not available in the dropdown on Aires File Team section
	 */
	public boolean verifyExistingTeamMemberInDropdown(String roleName) {
		try {
			CoreFunctions.click(driver, _memberNameSelectButtton,
					_memberNameSelectButtton.getAttribute(MYLOConstants.NAME));
			List<WebElement> optionsList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			return CoreFunctions.searchElementExistsInListByText(driver, optionsList,
					airesFileTeamExistingMembers.get(roleName));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_DROPDOWN,
					CoreConstants.FAIL, airesFileTeamExistingMembers.get(roleName), MYLOConstants.MEMBER_NAME));
			return false;
		}
	}

	/**
	 * @param msg
	 * @return
	 * Verifying the Warning Message Text on Aires File Team section
	 */
	public boolean verifyPopUpMessage(String msg) {
		boolean flag=false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText(),60);
			CoreFunctions.highlightObject(driver, _popUpMessage);
			flag=(_popUpMessage.getText().equals(msg));
		}
		catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
					MYLOConstants.EXPECTED_POPUP_MESSAGE, MYLOConstants.ASSIGNMENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					_popUpMessage.getText(), MYLOConstants.ASSIGNMENT));
		return flag;
	}

	/**
	 * @return
	 * Verifying any Role Added on Aires File Team section
	 */
	public boolean verifyRowAddedInAiresFileTeam() {
		return (_noOfAddedAiresFileTeamMember.size() != noOfAiresFileTeamMember) ? true : false;
	}

	/**
	 * @param roleName
	 * @return
	 * Verifying the Updated Team Member by RoleName along with fields associated with it
	 */
	public boolean verifyUpdatedRowAiresFileTeamSection(String roleName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _airesFileTeamMemberGrid);
		List<String> allRoleNames = _airesFileTeamRoleName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allTeamMembers = _airesFileTeamMemberName.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allStartDates = _airesFileTeamStartDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		List<String> allEndDates = _airesFileTeamEndDates.stream().map(x -> x.getAttribute(MYLOConstants.VALUE))
				.collect(Collectors.toList());
		String currentDate = DateTimeFormatter.ofPattern("MM/dd/yyyy").format(LocalDate.now());		
		String expectedDateFormat= CoreFunctions.getStringDateInFormat(currentDate, "MM/dd/yyyy",
				"dd MMM yyyy");
		
		if (allTeamMembers.get(allRoleNames.indexOf(roleName)).trim().equals(updatedTeamMember)
				&& allStartDates.get(allRoleNames.indexOf(roleName)).trim().equals(expectedDateFormat)
				&& allEndDates.get(allRoleNames.indexOf(roleName)).trim().equals(MYLOConstants.ACTIVE)
				&& allEndDates.get(allRoleNames.lastIndexOf(roleName)).trim().equals(expectedDateFormat)) {

			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRYFD_UPDATED_ROW, CoreConstants.PASS, roleName,
					MYLOConstants.AIRES_FILE_TEAM));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_UPDATED_ROW, CoreConstants.FAIL, roleName,
				MYLOConstants.AIRES_FILE_TEAM));
		return false;
	}

	/**
	 * @return
	 * Verifying all fields Displaying on Aires File Team section are readonly
	 */
	public boolean verifyAiresFileTeamRecordsReadonly() {
		for (WebElement element : _airesFileTeamMemberGrid) {
			if (element.getAttribute(MYLOConstants.CLASS).contains(MYLOConstants.MYLO_READONLY))
				continue;
			else
				return false;
		}
		return true;
	}

	// ***************Aires File Information Section***********************//

	/**
	 * @param buttonName
	 * Click Different Buttons on Aires File Information section
	 */
	public void clickButtonOnAiresFileInformationSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			CoreFunctions.click(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoCancelButton,
					_fileInfoCancelButton.getText());
			CoreFunctions.scrollVerticallyDownByGivenPixle(driver, 20);
			CoreFunctions.click(driver, _fileInfoCancelButton, _fileInfoCancelButton.getText());
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoSaveButton, buttonName);
			CoreFunctions.click(driver, _fileInfoSaveButton, buttonName);
			break;
		case MYLOConstants.DETAILS_CARROT_BUTTON:
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoDetailsCarrot,
					_fileInfoDetailsCarrot.getText());
			CoreFunctions.click(driver, _fileInfoDetailsCarrot, _fileInfoDetailsCarrot.getText());
			mapFileInfoWebElementFields();
			break;
		case MYLOConstants.OK_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _Okbutton,
					_Okbutton.getText());
			CoreFunctions.click(driver, _Okbutton, _Okbutton.getText());
			break;
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _NoButton, _NoButton.getText());
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
		}
	}

	/**
	 * @param fileID
	 * @param clientIDandName
	 * @param policyType
	 * @return
	 * Verifying Field Values displayed on Aires File Information section
	 */
	public boolean verifyFileInfoDisplayedFields(String fileID, String clientIDandName, String policyType) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoFileId, _fileInfoFileId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoClientId, _fileInfoClientId.getText());
		CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoPolicyType, _fileInfoPolicyType.getText());
		if (_fileInfoFileId.getAttribute(CoreConstants.VALUE).equals(fileID)
				&& _fileInfoClientId.getAttribute(CoreConstants.VALUE).equals(clientIDandName)
				&& _fileInfoPolicyType.getText().equals(policyType)) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FIELD_NAME_VALUE_DISPLAYED, CoreConstants.PASS,
					_fileInfoFileId.getAttribute(MYLOConstants.NAME), fileID, MYLOConstants.AIRES_FILE_INFORMATION,
					MYLOConstants.ASSIGNMENT));
			return true;
		}
		return false;
	}
	
	
	/**
	 * @param fieldName
	 * @param propertyType
	 * @param expectedValue
	 * @return
	 * Verifying CSS Property Value of Elements available in any section
	 */
	public boolean verifyElementCSSValue(String fieldName, String propertyType, String expectedValue) {
			String code = null;
			switch (fieldName) {
			case MYLOConstants.POLICY_TYPE:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoPolicyTypeBgColor, propertyType);
				break;
			case MYLOConstants.FILE_ID:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoFileId, propertyType);
				break;
			case MYLOConstants.CLIENT_ID:
				code=CoreFunctions.getElementCSSProperty(driver, _fileInfoClientId, propertyType);
				break;
			default:
				Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
				Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			}
			if(code.equals(expectedValue))
				return true;
			return false;
	}
	
	/**
	 * Mapping the AiresFileInformation WebElements with associated fields
	 */
	public void mapFileInfoWebElementFields() {
		airesFileInfoFieldsMap.put(MYLOConstants.POLICY_TYPE, _fileInfoPolicyType);
		airesFileInfoFieldsMap.put(MYLOConstants.STATUS, _fileInfoStatus);
		airesFileInfoFieldsMap.put(MYLOConstants.OFFICE, _fileInfoOffice);
		airesFileInfoFieldsMap.put(MYLOConstants.TRANSFER_TYPE, _fileInfoTransferType);
		airesFileInfoFieldsMap.put(MYLOConstants.JOURNEY_TYPE, _fileInfoJourneyType);
		airesFileInfoFieldsMap.put(MYLOConstants.HOMESTATUS, _fileInfoHomeStatus);
	}

	/**
	 * @return
	 * Verifying Additional Fields displayed on Aires File Information section after clicking on Details Carrot button
	 */
	public boolean verifyFileInfoAdditionalFieldsDisplayed() {
		if (CoreFunctions.verifyElementPresentOnPage(_fileInfoTaxTreatmentSection,
				_fileInfoTaxTreatmentSection.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoStatus, _fileInfoStatus.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoProvider, _fileInfoProvider.getText())
				&& CoreFunctions.verifyElementPresentOnPage(_fileInfoEditButton, _fileInfoEditButton.getText())) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoTaxTreatmentSection.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoStatus.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoProvider.getText()));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, MYLOConstants.EDIT_BUTTON));
			return true;
		}
		Reporter.addStepLog(
				MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL, _fileInfoEditButton.getText()));
		return false;
	}

	/**
	 * @param fieldName
	 * @return
	 * Get value of specific fields by FieldName on Aires File Information section
	 */
	public String getFileInfoFieldValue(String fieldName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, airesFileInfoFieldsMap.get(fieldName),
					airesFileInfoFieldsMap.get(fieldName).getText());
		} catch (Exception e) {
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.FIELD_NAME_VALUE_DISPLAYED, CoreConstants.PASS,
				fieldName, airesFileInfoFieldsMap.get(fieldName).getText(), MYLOConstants.AIRES_FILE_INFORMATION,
				MYLOConstants.ASSIGNMENT));
		return airesFileInfoFieldsMap.get(fieldName).getText();
	}

	/**
	 * @param scenarioType
	 * @param fieldName
	 * @throws InterruptedException
	 * Verifying Fields ReadOnly status for different Users and Different File Type on Aires File Information section
	 */
	public void verifyFileInfoFieldsForScenarioType(String scenarioType, String fieldName) throws InterruptedException {
		switch (scenarioType) {
		case MYLOConstants.USER_WITHOUT_RESOURCE300096:
		case MYLOConstants.NOT_AIRESSH_PROVIDER:
		case MYLOConstants.AFFINITY_ENABLED:
			Assert.assertFalse(verifyFileInfoFieldsReadOnly(fieldName));
			break;
		case MYLOConstants.USER_WITH_RESOURCE300096:
		case MYLOConstants.AIRESSH_PROVIDER:
		case MYLOConstants.NOT_AFFINITY_ENABLED:
			Assert.assertTrue(verifyFileInfoFieldsReadOnly(fieldName));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_SCENARIO_TYPE);
			Assert.fail(MYLOConstants.ENTER_CORRECT_SCENARIO_TYPE);
		}
	}

	/**
	 * @param elementName
	 * @return
	 * Verifying Fields ReadOnly status by FieldName on Aires File Information section
	 */
	public boolean verifyFileInfoFieldsReadOnly(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			return CoreFunctions.isElementPresent(driver, _fileInfoPolicyTypeDropdownReadOnly, 2,
					MYLOConstants.POLICY_TYPE_READONLY);
		case MYLOConstants.OFFICE:
			return CoreFunctions.isElementPresent(driver, _fileInfoOfficeDropdownReadOnly, 2, MYLOConstants.OFFICE_READONLY);
		case MYLOConstants.EDIT_BUTTON:
			return CoreFunctions.isElementVisible(_fileInfoEditButton);
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
		return false;
	}

	/**
	 * @param chechboxText
	 * @return
	 * Verify checkbox is Selected or Not on Aires File Information section
	 */
	public boolean verifyFileInfoCheckboxSelected(String chechboxText) {
		if (chechboxText.equals(MYLOConstants.RANDOM))
			return BusinessFunctions.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText,
					updatedFileInfoCheckboxSelected, MYLOConstants.NAME).isSelected();
		else
			return BusinessFunctions
					.returnItemFromListUsingAttribute(driver, _fileInfoCheckBoxText, chechboxText, MYLOConstants.NAME)
					.isSelected();
	}

	/**
	 * @param checkboxName
	 * @param checkBoxStatus
	 * Verify checkbox is Selected or Not according to the checkBoxStatus provided
	 */
	public void verifyFileInfoCheckBoxIsChecked(String checkboxName, String checkBoxStatus) {
		if (checkBoxStatus.equals(MYLOConstants.CHECKED))
			Assert.assertTrue(verifyFileInfoCheckboxSelected(checkboxName));
		else
			Assert.assertFalse(verifyFileInfoCheckboxSelected(checkboxName));
	}

	/**
	 * @param chechboxText
	 * Click on CheckBox by CheckboxName or Random Selection on Aires File Information section
	 */
	public void clickCheckBoxOnAiresFileInfoSection(String chechboxText) {
		if (chechboxText.equals(MYLOConstants.RANDOM) && updatedFileInfoCheckboxSelected == null) {
			int randomIndex = CoreFunctions.getRandomNumber(0, _fileInfoCheckBoxText.size());
			updatedFileInfoCheckboxSelected = _fileInfoCheckBoxText.get(randomIndex).getAttribute(MYLOConstants.NAME);
			_fileInfoCheckboxes.get(randomIndex).click();
		} else if (chechboxText.equals(MYLOConstants.RANDOM) && updatedFileInfoCheckboxSelected != null) {
			_fileInfoCheckboxes.get(BusinessFunctions.returnindexItemFromListUsingAttribute(driver,
					_fileInfoCheckBoxText, updatedFileInfoCheckboxSelected, MYLOConstants.NAME)).click();
		} else {
			updatedFileInfoCheckboxSelected = chechboxText;
			_fileInfoCheckboxes.get(BusinessFunctions.returnindexItemFromListUsingAttribute(driver,
					_fileInfoCheckBoxText, chechboxText, MYLOConstants.NAME)).click();
		}
	}

	/**
	 * @param fieldName
	 * @param options
	 * @return
	 * Select Random Dropdown options By fieldName on Aires File Information section
	 */
	public String selectRandomDropdownOptions(String fieldName, List<WebElement> options) {
		WebElement element = null;
		String selectedText;
		do {
			element = (fieldName.equals(MYLOConstants.POLICY_TYPE )||fieldName.equals(MYLOConstants.JOURNEY_TYPE)) ? options.get(CoreFunctions.getRandomNumber(2, 4))
					: options.get(CoreFunctions.getRandomNumber(1, options.size()));
			selectedText = element.getText();
		} while (element.getText() == airesFileInfoFieldsMap.get(fieldName).getText());
		CoreFunctions.clickElement(driver, element);
		return selectedText;

	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * Select DropDown options by FieldName from fieldValue or Randomly and Return the Text which is selected on Aires File Information section
	 */
	public String selectDropdownOptionsAndReturnText(String fieldName, String fieldValue) {
		String selectedText = null;
		List<WebElement> allOptions = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			selectedText = selectRandomDropdownOptions(fieldName, allOptions);
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.RANDOM_VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
					selectedText, fieldName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.ASSIGNMENT));
		} else {
			if (fieldValue != airesFileInfoFieldsMap.get(fieldName).getText())
				selectedText = CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue).getText();
			CoreFunctions.clickElement(driver, CoreFunctions.returnItemInListByText(driver, allOptions, fieldValue));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
					selectedText, fieldName, MYLOConstants.AIRES_FILE_INFORMATION, MYLOConstants.ASSIGNMENT));
		}
		return selectedText;
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * Update Field Values by Field Name on Aires File Information section
	 */
	public void updateFileInfoFields(String fieldName, String fieldValue) {
		CoreFunctions.click(driver, airesFileInfoFieldsMap.get(fieldName),
				airesFileInfoFieldsMap.get(fieldName).getText());
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			updatedPolicyType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.OFFICE:
			updatedOffice = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.TRANSFER_TYPE:
			updatedTransferType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.JOURNEY_TYPE:
			updatedJourneyType = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		case MYLOConstants.HOMESTATUS:
			updatedHomeStatus = selectDropdownOptionsAndReturnText(fieldName, fieldValue);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * Verify Passed Value present in the Dropdown fields By FieldName on Aires File Information section
	 */
	public boolean verifyFileInfoDropDownValues(String fieldName, String fieldValue) {
		CoreFunctions.click(driver, airesFileInfoFieldsMap.get(fieldName),
				airesFileInfoFieldsMap.get(fieldName).getText());
		List<WebElement> allOptions = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
		return CoreFunctions.searchElementExistsInListByText(driver, allOptions, fieldValue);
	}

	/**
	 * @param buttonName
	 * Verify Fields Updated or Nor Depending upon the option selected on Aires File Information section
	 */
	public void verifyFileInfoFieldsOnClickedButton(String buttonName) {
		if (buttonName.equals(MYLOConstants.CANCEL_BUTTON)) {
			CoreFunctions.explicitWaitTillElementVisibility(driver,_fileInfoEditButton, _fileInfoEditButton.getText(), 5);
			clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
			Assert.assertFalse(verifyFileInfoUpdatedFields(MYLOConstants.JOURNEY_TYPE));
			Assert.assertFalse(verifyFileInfoUpdatedFields(MYLOConstants.HOMESTATUS));
			Assert.assertFalse(verifyFileInfoCheckboxSelected(MYLOConstants.INHERITED_FILE));
		}

		else if (buttonName.equals(MYLOConstants.SAVE_BUTTON)) {
			//Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
			//clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.POLICY_TYPE));
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.JOURNEY_TYPE));
			Assert.assertTrue(verifyFileInfoUpdatedFields(MYLOConstants.HOMESTATUS));
			Assert.assertTrue(verifyFileInfoCheckboxSelected(MYLOConstants.INHERITED_FILE));
			resetFileInfoField();
		}
	}
	
	/**
	 * Resetting File Information fields to earlier values
	 */
	public void resetFileInfoField() {
		if (CoreFunctions.isElementExist(driver, _myloErrorPopUp, 5)
				&& CoreFunctions.isElementExist(driver, _OKButtonPopUp, 5)) {
			CoreFunctions.clickElement(driver, _OKButtonPopUp);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		}
		clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.POLICY_TYPE_VALUE);
		if(CoreFunctions.isElementExist(driver, _YesButton, 30))
			CoreFunctions.click(driver, _YesButton, MYLOConstants.YES_BUTTON);
		if(CoreFunctions.isElementExist(driver, _OKButtonPopUp, 30))
			CoreFunctions.click(driver, _OKButtonPopUp, MYLOConstants.OK_BUTTON);
		updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE_VALUE);
		// CoreFunctions.scrollToElementUsingJS(driver, _fileInfoOffice,
		// MYLOConstants.OFFICE);
		updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.HOMESTATUS_VALUE);
		clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		clickButtonOnAiresFileInformationSection(MYLOConstants.SAVE_BUTTON);
		// Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
		// clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
	}

	/**
	 * @param fieldName
	 * @return
	 * Verifying Fields getting updated or not on Aires File Information section
	 */
	public boolean verifyFileInfoUpdatedFields(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.POLICY_TYPE:
			return updatedPolicyType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.OFFICE:
			return updatedOffice.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.TRANSFER_TYPE:
			return updatedTransferType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.JOURNEY_TYPE:
			return updatedJourneyType.equals(getFileInfoFieldValue(fieldName));
		case MYLOConstants.HOMESTATUS:
			return updatedHomeStatus.equals(getFileInfoFieldValue(fieldName));
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}
	

	/**
	 * @param messageType
	 * @return
	 * Verify Success Message on Aires File Information section 
	 */
	public boolean verifyMessage(String messageType) {
		switch (messageType) {
		case MYLOConstants.SUCCESS_MESSAGE:
			return _fileInfoSuccessMessage.getText().equals(MYLOConstants.FILE_INFO_SUCCESS_MESSAGE);
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
		

	}

	/**
	 * @param fileStatusMode
	 * @param requiredField
	 * @return
	 * Retrieve Required Assignment Field Data from json file based on the fileStatusMode
	 */
	public String getFileDetailsDataByFieldAndStatus(String fileStatusMode, String requiredField) {
		LinkedHashMap<String, String> fileInfoDetailsmap = new LinkedHashMap<String, String>();
		switch (fileStatusMode) {
		case MYLOConstants.AFFINITY_ENABLED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.affinityEnabled.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.affinityEnabled.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.affinityEnabled.clientName);
			break;
		case MYLOConstants.NOT_AFFINITY_ENABLED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.affinityNotEnabled.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.affinityNotEnabled.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.affinityNotEnabled.clientName);
			break;
		case MYLOConstants.AIRESSH_PROVIDER:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.airesshProvider.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.airesshProvider.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.airesshProvider.clientName);
			break;
		case MYLOConstants.NOT_AIRESSH_PROVIDER:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.notairesshProvider.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.notairesshProvider.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.notairesshProvider.clientName);
			break;
		case MYLOConstants.CANCELED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.canceledFile.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.canceledFile.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.canceledFile.clientName);
			break;
		case MYLOConstants.CLOSED:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataClosedFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.closedFile.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.closedFile.clientName);
			break;
		case MYLOConstants.RELOCATION_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataRelocationTypeFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.relocationPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.relocationPolicyType.clientName);
			break;
		case MYLOConstants.LUMP_SUM_PLAN_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataLumpSumTypeFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.lumpSumpPlanPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.lumpSumpPlanPolicyType.clientName);
			break;
		case MYLOConstants.DOMESTIC_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataDomesticTypeFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.domesticPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.domesticPolicyType.clientName);
			break;
		case MYLOConstants.ACTIVE_ASSIGNMENT:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataActiveFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.activeAssignment.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.activeAssignment.clientName);
			break;
		case MYLOConstants.CLOSED_IDENTITYDOC:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataClosedIdentityDocFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.closedFileIdentDoc.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.closedFileIdentDoc.clientName);
			break;
		case MYLOConstants.TRANSFEREE_WITH_FAMILY_MEMBER:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.transfereeWithFamily.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.transfereeWithFamily.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.transfereeWithFamily.clientName);
			break;
		case MYLOConstants.TRANSFEREE_WITH_OTHER_FAMILY_MEMBERS:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.transfereeWithOtherFamilyMembers.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.transfereeWithOtherFamilyMembers.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.transfereeWithOtherFamilyMembers.clientName);
			break;
		case MYLOConstants.TRANSFEREE_ALLDATA:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, getTestDataTransfereeAllDataFileId());
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.transfereeAllData.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.transfereeAllData.clientName);
			break;
		case MYLOConstants.TRANSFEREEEMAILPHONE_ALLDATA:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.transfereeEmailPhone_preprod.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.transfereeEmailPhone_preprod.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.transfereeEmailPhone_preprod.clientName);
			break;
		case MYLOConstants.PARTNER_DATA:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.partnerData.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.partnerData.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.partnerData.clientName);
			break;
		case MYLOConstants.PARTNER_ALL_DATA:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.partnerAllData.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.partnerAllData.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.partnerAllData.clientName);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return fileInfoDetailsmap.get(requiredField);

	}
	
	public String getTestDataActiveFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.activeAssignment.fileID;
			break;
		case MYLOConstants.RELONETQA4:
			fileID = assignmentDetails.activeAssignment_relonetqa4.fileID;
			break;
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.activeAssignment_preprod.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataClosedFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.closedFile.fileID;
			break;
		case MYLOConstants.RELONETQA4:
			fileID = assignmentDetails.closedFile.fileID;
			break;
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.closedFile_preprod.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataClosedIdentityDocFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.closedFileIdentDoc.fileID;
			break;
		case MYLOConstants.RELONETQA4:
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.closedFileIdentDocrelonetqa4.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataRelocationTypeFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.relocationPolicyType.fileID;
			break;
		case MYLOConstants.RELONETQA4:
			fileID = assignmentDetails.relocationPolicyTyperelonetqa4.fileID;
			break;
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.relocationPolicyType_preprod.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataLumpSumTypeFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.lumpSumpPlanPolicyType.fileID;
			break;
		case MYLOConstants.RELONETQA4:
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.lumpSumpPlanPolicyTyperelonetqa4.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataDomesticTypeFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
			fileID = assignmentDetails.domesticPolicyType.fileID;
			break;
		case MYLOConstants.RELONETQA4:
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.domesticPolicyTyperelonetqa4.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	public String getTestDataTransfereeAllDataFileId() {
		String environment = CoreFunctions.getPropertyFromConfig("envt");
		String fileID = null;
		switch(environment) {
		case MYLOConstants.UAT:
		case MYLOConstants.RELONETQA4:
			fileID = assignmentDetails.transfereeAllData.fileID;
			break;
		case MYLOConstants.PREPROD:
			fileID = assignmentDetails.transfereeAllData_preprod.fileID;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);	
		}
		return fileID;
	}
	
	// *************** Other Addresses Section***********************//
	
	/**
	 * @param elementName
	 * Click different fields on Other Address section
	 */
	public void clickElementOnOtherAddressesSection(String elementName) {
		switch (elementName) {
		case MYLOConstants.MAILING_ADDRESS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _addMailAddressBtn, MYLOConstants.MAILING_ADDRESS);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _addMailAddressBtn,
					MYLOConstants.MAILING_ADDRESS);
			CoreFunctions.click(driver, _addMailAddressBtn, MYLOConstants.ADD_MAILING_ADDRESS);
			CoreFunctions.highlightObject(driver, _modalTitle);
			Assert.assertEquals(MYLOConstants.ADD_MAILING_ADDRESS, _modalTitle.getText());
			break;
		case MYLOConstants.TEMPORARY_ADDRESS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _addTempAddressBtn,
					MYLOConstants.TEMPORARY_ADDRESS);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _addTempAddressBtn,
					MYLOConstants.TEMPORARY_ADDRESS);
			CoreFunctions.click(driver, _addTempAddressBtn, MYLOConstants.ADD_TEMPORARY_ADDRESS);
			CoreFunctions.highlightObject(driver, _modalTitle);
			Assert.assertEquals(MYLOConstants.ADD_TEMPORARY_ADDRESS, _modalTitle.getText());
			break;
		case MYLOConstants.COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _countryDropdown, MYLOConstants.COUNTRY);
			CoreFunctions.click(driver, _countryDropdown, MYLOConstants.COUNTRY);
			countryList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _stateDropdown, MYLOConstants.STATE);
			CoreFunctions.click(driver, _stateDropdown, MYLOConstants.STATE);
			stateList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _SaveButton, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.clickUsingJS(driver, _SaveButton, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.waitForBrowserToLoad(driver);
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _CancelButton, MYLOConstants.CANCEL_BUTTON);
			CoreFunctions.clickUsingJS(driver, _CancelButton, MYLOConstants.CANCEL_BUTTON);
			CoreFunctions.waitForBrowserToLoad(driver);
			break;
		case MYLOConstants.OTHER_ADDRESS_SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherAddressSaveButton, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.click(driver, _otherAddressSaveButton, MYLOConstants.SAVE_BUTTON);
			break;
		case MYLOConstants.OK_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _Okbutton, MYLOConstants.OK_BUTTON);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _Okbutton, MYLOConstants.OK_BUTTON);
			CoreFunctions.click(driver, _Okbutton, _Okbutton.getText());
			break;
		case MYLOConstants.CLOSE_BUTTON:
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, _closeBtn.getText());
			break;
		case MYLOConstants.TEMP_EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempEditButton, MYLOConstants.TEMP_EDIT_BUTTON);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _tempEditButton,
					MYLOConstants.TEMP_EDIT_BUTTON);
			CoreFunctions.click(driver, _tempEditButton, _tempEditButton.getText());
			break;
		case MYLOConstants.MAIL_EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailEditButton, MYLOConstants.MAIL_EDIT_BUTTON);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _mailEditButton,
					MYLOConstants.MAIL_EDIT_BUTTON);
			CoreFunctions.click(driver, _mailEditButton, elementName);
			break;
		case MYLOConstants.TEMP_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressCountryDropdown,
					MYLOConstants.TEMP_ADDRESS_COUNTRY);
			CoreFunctions.click(driver, _tempAddressCountryDropdown, MYLOConstants.TEMP_ADDRESS_COUNTRY);
			countryList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.MAIL_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressCountryDropdown,
					MYLOConstants.MAIL_ADDRESS_COUNTRY);
			CoreFunctions.click(driver, _mailAddressCountryDropdown, MYLOConstants.MAIL_ADDRESS_COUNTRY);
			countryList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.TEMP_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressStateDropdown,
					MYLOConstants.TEMP_ADDRESS_STATE);
			CoreFunctions.click(driver, _tempAddressStateDropdown, MYLOConstants.TEMP_ADDRESS_STATE);
			CoreFunctions.highlightObject(driver, _tempAddressStateDropdown);
			stateList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.MAIL_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressStateDropdown,
					MYLOConstants.MAIL_ADDRESS_STATE);
			CoreFunctions.click(driver, _mailAddressStateDropdown, MYLOConstants.MAIL_ADDRESS_STATE);
			CoreFunctions.highlightObject(driver, _mailAddressStateDropdown);
			stateList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.TEMP_ADDRESS_TYPE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressTypeDropdown,
					MYLOConstants.TEMP_ADDRESS_TYPE);
			CoreFunctions.click(driver, _tempAddressTypeDropdown, MYLOConstants.TEMP_ADDRESS_TYPE);
			typeDropDownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.MAIl_ADDRESS_TYPE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressTypeDropdown,
					MYLOConstants.MAIl_ADDRESS_TYPE);
			CoreFunctions.click(driver, _mailAddressTypeDropdown, MYLOConstants.MAIl_ADDRESS_TYPE);
			typeDropDownList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver,_tempAddressDropdown, MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN);
			CoreFunctions.scrollClickUsingJS(driver, _tempAddressDropdown, MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN);
			mapOtherAddresssWebElementFields();
			break;
		case MYLOConstants.MAILING_ADDRESS_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressDropdown,
					MYLOConstants.MAILING_ADDRESS_DROPDOWN);
			CoreFunctions.scrollClickUsingJS(driver, _mailAddressDropdown, MYLOConstants.MAILING_ADDRESS_DROPDOWN);
			mapOtherAddresssWebElementFields();
			break;
		case MYLOConstants.DELETE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _addressDeleteButton, elementName);
			CoreFunctions.click(driver, _addressDeleteButton, elementName);
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _YesButton, _YesButton.getText());
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
	}
	
	/**
	 * @param countryName
	 * @return
	 * Verify first Country displayed in the dropdown
	 */
	public boolean verifyFirstCountry(String countryName) {
		return (countryList.get(1).getText().equals(countryName));
	}
	
	/**
	 * @param listContent
	 * @return
	 * Verify options available in Type dropdown
	 */
	public boolean verifyTypeDropwnList(String listContent) {
		return CoreFunctions.searchElementExistsInListByTextIgnoreCase(driver, typeDropDownList, listContent);
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Get the Label of passed field
	 */
	public String verifyOtherAddressFieldLabel(String fieldName) {
		String valueToBeReturned=null;
		switch (fieldName) {
		case MYLOConstants.STATE:
		case MYLOConstants.TEMP_ADDRESS_STATE:
		case MYLOConstants.MAIL_ADDRESS_STATE:
			valueToBeReturned= CoreFunctions.getElementText(driver, _otherAddressStateLabelName);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return valueToBeReturned;
	}
	
	/**
	 * @param dropDownName
	 * @return
	 * Verify DropdownList order for passed field name
	 */
	public boolean verifyDropdownListOrder(String dropDownName) {
		boolean flag = false;
		switch (dropDownName) {
		case MYLOConstants.COUNTRY:
			List<String> countryText = countryList.stream().map(x -> x.getText()).collect(Collectors.toList());
			List<String> copyCountryList = new ArrayList<String>(countryText);
			copyCountryList.remove(MYLOConstants.SELECT_ONE);
			copyCountryList.remove(MYLOConstants.USA_STATE);
			flag = CoreFunctions.verifyListOrder(copyCountryList, MYLOConstants.ASCENDING);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return flag;
	}
	
	/**
	 * @param fieldValue
	 * Set the value of Country dropdown on Other Address section
	 */
	public void setOtherAddressCountry(String fieldValue) {
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			List<String> valuesToIgnore = new ArrayList<String>();
			valuesToIgnore.add(MYLOConstants.USA_STATE);
			valuesToIgnore.add(MYLOConstants.INDIA_STATE);
			valuesToIgnore.add(MYLOConstants.CANADA_STATE);
			countryList.remove(0);
			updatedCountryValue = CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, countryList, valuesToIgnore);
			BusinessFunctions.selectItemFromListUsingText(driver, countryList,
					updatedCountryValue);
		} else {
			updatedCountryValue=fieldValue;
			BusinessFunctions.selectItemFromListUsingText(driver, countryList, fieldValue);
		}
	}
	
	/**
	 * @param fieldValue
	 * Set the value of State field on Other Address section
	 */
	public void setOtherAddressState(String fieldValue) {
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			List<String> valuesToIgnore = new ArrayList<String>();
			valuesToIgnore.add("Select One");
			stateList.remove(0);
			stateList.remove(1);
			CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, stateList, 60);
			BusinessFunctions.selectItemFromListUsingText(driver, stateList,
					CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, stateList, valuesToIgnore));
		} else
			CoreFunctions.selectItemInListByText(driver, stateList, fieldValue);
	}
	
	/**
	 * @param fieldValue
	 * Set the value of Type Dropdown on Other Address section
	 */
	public void setOtherAddressTypeDropdown(String fieldValue) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, typeDropDownList);
		if (fieldValue.equals(MYLOConstants.RANDOM))
			CoreFunctions.selectItemInListByText(driver, typeDropDownList,
					CoreFunctions.getRandomElementValueFromList(driver, typeDropDownList));
		else
			CoreFunctions.selectItemInListByText(driver, typeDropDownList, fieldValue);
	}
	
	public String setFieldOtherAddress(WebElement element, String fieldValue) {
		String updatedValue;
		try {
			updatedValue = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),
					MYLOConstants.ONLY_CHARACTERS, 0);
		} catch (NumberFormatException e) {
			updatedValue = (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING))
					? CoreFunctions.generateRandomCharOfLength(4, MYLOConstants.SPECIAL_CHARACTERS_STRING, 2)
					: fieldValue;
		}
		CoreFunctions.clearAndSetText(driver, element, updatedValue);
		return updatedValue;
	}
	
	/**
	 * @param fieldValue
	 * @return
	 * Set the value of ZipCode on Other Address section
	 */
	public String setOtherAddressZipCode(String fieldValue) {
		String updatedZipCodeValue;
		try {
			updatedZipCodeValue = (Integer.parseInt(fieldValue) < 100) ? CoreFunctions.generateRandomCharOfLength(
					Integer.parseInt(fieldValue), MYLOConstants.ONLY_CHARACTERS, 0) : fieldValue;
		} catch (NumberFormatException e) {
			updatedZipCodeValue = (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING))
					? CoreFunctions.generateRandomCharOfLength(4, MYLOConstants.SPECIAL_CHARACTERS_STRING, 2)
					: fieldValue;
		}
		CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, updatedZipCodeValue);
		return updatedZipCodeValue;
	}
	
	
	/**
	 * @param fieldValue
	 * @return
	 * Set the value of From Date on Other Address section
	 */
	public String setOtherAddressFromDate(String fieldValue) {
		String updatedFromDate = (fieldValue.equals("current"))
				? CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy")
				: fieldValue;
		CoreFunctions.clearAndSetText(driver, _otherAddressaddAddressFromDateValue, updatedFromDate);
		return updatedFromDate;
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set the value of passed parameter
	 */
	public void setFieldValueOnOtherAddressesSection(String fieldName, String fieldValue) {
		switch (fieldName) {
		case MYLOConstants.COUNTRY:
			setOtherAddressCountry(fieldValue);
			break;
		case MYLOConstants.STATE:
			setOtherAddressState(fieldValue);
			break;
		case MYLOConstants.STATE_TEXT_FIELD:
			clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			setOtherAddressCountry(MYLOConstants.RANDOM);
			setFieldOtherAddress(_otherAddressaddStateValue, fieldValue);
			break;		
		case MYLOConstants.TEMP_ADDRESS_TYPE:
		case MYLOConstants.MAIl_ADDRESS_TYPE:
			setOtherAddressTypeDropdown(fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_CITY:
		case MYLOConstants.CITY:
			updatedTempAddressCityValue = setFieldOtherAddress(_otherAddressaddCityValue, fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_CITY:
			updatedMailAddressCityValue = setFieldOtherAddress(_otherAddressaddCityValue, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
		case MYLOConstants.ZIPCODE:
			updatedTempAddressZipCodeValue = setOtherAddressZipCode(fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
			updatedMailAddressZipCodeValue = setOtherAddressZipCode(fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherAddressaddStateValue, fieldName,60);
			updatedTempAddressStateValue = setFieldOtherAddress(_otherAddressaddStateValue, fieldValue);;
			break;
		case MYLOConstants.MAIL_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherAddressaddStateValue, fieldName,60);
			updatedMailAddressStateValue = setFieldOtherAddress(_otherAddressaddStateValue, fieldValue);;
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
		case MYLOConstants.ADDRESS1:
			updatedTempAddress1Value = setFieldOtherAddress(_otherAddressaddAddress1Value, fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
			updatedMailAddress1Value = setFieldOtherAddress(_otherAddressaddAddress1Value, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
		case MYLOConstants.ADDRESS2:
			updatedTempAddress2Value =setFieldOtherAddress(_otherAddressaddAddress2Value, fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
			updatedMailAddress2Value = setFieldOtherAddress(_otherAddressaddAddress2Value, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_COMMENTS:
		case MYLOConstants.COMMENTS:
			updatedTempAddressCommentsValue = setFieldOtherAddress(_otherAddressaddCommentValue, fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_COMMENTS:
			updatedMailAddressCommentsValue = setFieldOtherAddress(_otherAddressaddCommentValue, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
		case MYLOConstants.FROMDATE:
			updatedTempAddressFromDateValue = setOtherAddressFromDate(fieldValue);
			break;
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			updatedMailAddressFromDateValue = setOtherAddressFromDate(fieldValue);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify field availability for Other Address section
	 */
	public boolean verifyOtherAddressFieldAvailability(String fieldName) {
		boolean flag=false;
		switch (fieldName) {
		case MYLOConstants.STATE:
			flag= CoreFunctions.isElementExist(driver, _stateFieldTextType, 5);
			break;
		case MYLOConstants.TEMP_ADDRESS_STATE:
			flag= CoreFunctions.isElementExist(driver, _tempAddressStateTextField, 5);
			break;
		case MYLOConstants.MAIL_ADDRESS_STATE:
			flag= CoreFunctions.isElementExist(driver, _mailAddressStateTextField, 5);
			break;
		case MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN:
			flag= CoreFunctions.isElementExist(driver, _tempAddressDropdown, 5);
			break;
		case MYLOConstants.MAILING_ADDRESS_DROPDOWN:
			flag= CoreFunctions.isElementExist(driver, _mailAddressDropdown, 5);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify whether field values got updated
	 */
	public boolean verifyUpdatedFieldValueOtherAddress(String fieldName) {
		boolean flag = false;
		switch (fieldName) {
		case MYLOConstants.COUNTRY:
		case MYLOConstants.TEMP_ADDRESS_COUNTRY:
		case MYLOConstants.MAIL_ADDRESS_COUNTRY:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedCountryValue));
			break;
		case MYLOConstants.TEMP_ADDRESS_CITY:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddressCityValue));
			break;
		case MYLOConstants.MAIL_ADDRESS_CITY:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddressCityValue));
			break;
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddressZipCodeValue));
			break;
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddressZipCodeValue));
			break;
		case MYLOConstants.TEMP_ADDRESS_STATE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddressStateValue));
			break;
		case MYLOConstants.MAIL_ADDRESS_STATE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddressStateValue));
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddress1Value));
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddress1Value));
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddress2Value));
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddress2Value));
			break;
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedTempAddressFromDateValue));
			break;
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			flag = (getFieldValueOtherAddressesSection(fieldName).equals(updatedMailAddressFromDateValue));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}

		if (flag)
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.VERIFIED_VALUE_SUCCESSFULLY_SAVED, CoreConstants.PASS,
							getFieldValueOtherAddressesSection(fieldName), fieldName, MYLOConstants.OTHER_ADDRESS));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER_ADDRESS));
		return flag;
	}
	
	/**
	 * Mapping the Other Address WebElements with associated fields
	 */
	public void mapOtherAddresssWebElementFields() {
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_COUNTRY, _tempAddressCountryValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_COUNTRY, _mailAddressCountryValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN, _tempAddressStateDropdownValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN, _mailAddressStateDropDownValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_CITY, _tempAddressCityValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_CITY, _mailAddressCityValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_ZIPCODE, _tempAddressZipCodeValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_ZIPCODE, _mailAddressZipCodeValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_STATE, _tempAddressStateValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_STATE, _mailAddressStateValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_ADDRESS1, _tempAddress1Value);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_ADDRESS1, _mailAddress1Value);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_ADDRESS2, _tempAddress2Value);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_ADDRESS2, _mailAddress2Value);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_COMMENTS, _tempAddressCommentsValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_COMMENTS, _mailAddressCommentsValue);
		otherAdressFieldValueMap.put(MYLOConstants.TEMP_ADDRESS_FROMDATE, _tempAddressFromDateValue);
		otherAdressFieldValueMap.put(MYLOConstants.MAIL_ADDRESS_FROMDATE, _mailAddressFromDateValue);
	}
	
	/**
	 * @param fieldName
	 * @return
	 *  Get the values of different fields on Other Address section
	 */
	public String getFieldValueOtherAddressesSection(String fieldName) {
		String valueToBeReturned = null;
		WebElement fieldElement = otherAdressFieldValueMap.get(fieldName);
		switch (fieldName) {
		case MYLOConstants.TEMP_ADDRESS_COUNTRY:
		case MYLOConstants.MAIL_ADDRESS_COUNTRY:
		case MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN:
		case MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldElement.getText());
			CoreFunctions.highlightObject(driver, fieldElement);
			valueToBeReturned = CoreFunctions.getElementText(driver, fieldElement);
			break;
		case MYLOConstants.TEMP_ADDRESS_CITY:
		case MYLOConstants.MAIL_ADDRESS_CITY:
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
		case MYLOConstants.TEMP_ADDRESS_STATE:
		case MYLOConstants.MAIL_ADDRESS_STATE:
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
		case MYLOConstants.TEMP_ADDRESS_COMMENTS:
		case MYLOConstants.MAIL_ADDRESS_COMMENTS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement,
					fieldElement.getAttribute(MYLOConstants.VALUE));
			CoreFunctions.highlightObject(driver, fieldElement);
			valueToBeReturned = CoreFunctions.getAttributeText(fieldElement, MYLOConstants.VALUE);
			break;
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement,
					fieldElement.getAttribute(MYLOConstants.VALUE));
			CoreFunctions.highlightObject(driver, fieldElement);
			valueToBeReturned = CoreFunctions.getStringDateInFormat(
					CoreFunctions.getAttributeText(fieldElement, MYLOConstants.VALUE), "dd MMM yyyy",
					"MM/dd/yyyy");
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return valueToBeReturned;
	}
	
	/**
	 * @param countryName
	 * @return
	 * get state list from json of corresponding country passed as a parameter
	 */
	public List<String> getMyloStatesByCountry(String countryName) {
		List<String> stateNames = new ArrayList<String>();
		switch (countryName) {
		case MYLOConstants.USA_STATE:
			List<MyloUSStates> myloUSStates = FileReaderManager.getInstance().getMyloJsonReader().getMyloUSStates();
			stateNames.addAll(myloUSStates.stream().map(x -> x.value).collect(Collectors.toList()));
			break;

		case MYLOConstants.CANADA_STATE:
			List<MyloCAStates> myloCAStates = FileReaderManager.getInstance().getMyloJsonReader().getMyloCAStates();
			stateNames.addAll(myloCAStates.stream().map(x -> x.value).collect(Collectors.toList()));
			break;
		case MYLOConstants.INDIA_STATE:
			List<MyloIndiaStates> myloIndiaStates = FileReaderManager.getInstance().getMyloJsonReader()
					.getMyloIndiaStates();
			stateNames.addAll(myloIndiaStates.stream().map(x -> x.value).collect(Collectors.toList()));
			break;

		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_COUNTRY_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_COUNTRY_NAME);
		}
		return stateNames;

	}
		
	
	/**
	 * @param countryName
	 * @return
	 * verify whether state belongs to corresponding country or not in Other address section
	 */
	public boolean verifyStateListWithCountry(String countryName) {
		List<String> stateText = stateList.stream().map(x -> x.getText()).collect(Collectors.toList());
		List<String> copyStateList = new ArrayList<String>(stateText);
		copyStateList.remove("Select One");
		return copyStateList.equals(getMyloStatesByCountry(countryName));
	}
	
	/**
	 * @param msg
	 * @return
	 * Verify all the Alert Messages
	 */
	public boolean verifyAlertMessage(String msg) {
		boolean flag = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _alertMessage, msg);
			CoreFunctions.isElementVisible(_alertMessage);
			CoreFunctions.highlightObject(driver, _alertMessage);
			System.out.println(_alertMessage.getText());
			flag = (_alertMessage.getText().equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
					MYLOConstants.ALERT_MESSAGE, MYLOConstants.OTHER_ADDRESS));
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.OTHER_ADDRESS));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					_alertMessage.getText(), MYLOConstants.OTHER_ADDRESS));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param element
	 * @return
	 */
	public boolean verifyFieldBorderRedColor(String fieldName, WebElement element) {
		boolean flag = false;
		CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName);
		String hexColorValue = Color.fromString(element.getCssValue(MYLOConstants.BORDER_COLOR)).asHex();
		flag = (hexColorValue.equals(MYLOConstants.RED_COLOR_HEXCODE));
		return flag;
	}
	
	/**
	 * @param msg
	 * @return
	 * Verify all the Alert Messages
	 */
	public boolean verifyFieldErrorBackground(String fieldName) {
		boolean flag = false;
		switch (fieldName) {
		case MYLOConstants.COUNTRY:
			flag=verifyFieldBorderRedColor(fieldName, _countryDropdown);
			break;
		case MYLOConstants.STATE:
			flag=verifyFieldBorderRedColor(fieldName, _stateDropdown);
			break;
		case MYLOConstants.STATE_TEXT_FIELD:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddStateValue);
			break;
		case MYLOConstants.CITY:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddCityValue);
			break;
		case MYLOConstants.ZIPCODE:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddZipCodeValue);
			break;
		case MYLOConstants.ADDRESS1:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddAddress1Value);
			break;
		case MYLOConstants.ADDRESS2:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddAddress2Value);
			break;
		case MYLOConstants.FROMDATE:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddFromDateValue);
			break;
		case MYLOConstants.COMMENTS:
			flag=verifyFieldBorderRedColor(fieldName, _otherAddressaddCommentValue);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_HIGHLIGHTED, CoreConstants.PASS,
					fieldName, MYLOConstants.OTHER_ADDRESS));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
					fieldName, MYLOConstants.OTHER_ADDRESS));

		return flag;
	}
	
	
	/**
	 * @param sectionType
	 * @param countryName
	 * @param stateName
	 * @param cityName
	 * Set above mandatory fields on Other Address section
	 */
	public void setOtherAddressMandatoryFields(String sectionType,String countryName, String stateName,String cityName) {
		clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
		setOtherAddressCountry(countryName);
		setOtherAddressStateField(sectionType, stateName);
		setFieldOtherAddress(_otherAddressaddCityValue, cityName) ;
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Verify Toast messages of other Fields on Other Address section
	 */
	public void verifyOtherAddressSectionToastMessages(String sectionType,DataTable table) {
		setOtherAddressMandatoryFields(sectionType,MYLOConstants.USA_STATE, MYLOConstants.RANDOM, MYLOConstants.CITY_VALUE);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.FIELD_VALUE);
			setFieldValueOnOtherAddressesSection(fieldName, fieldValue);
			clickElementOnOtherAddressesSection(MYLOConstants.SAVE_BUTTON);
			Assert.assertTrue(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE)));
			Assert.assertTrue(verifyFieldErrorBackground(fieldName));
			clickElementOnOtherAddressesSection(MYLOConstants.CLOSE_BUTTON);
			mapOtherAddresssValidFieldValue();
			setFieldValueOnOtherAddressesSection(fieldName, otherAdressvalidFieldValueMap.get(fieldName));
		}
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Verify Toast messages of Mandatory fields on Other Address section
	 */
	public void verifyMandatoryFieldsToastMessagesOtherAddress(String sectionType,DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setOtherAddressMandatoryFields(sectionType, data.get(i).get(MYLOConstants.COUNTRY),
					data.get(i).get(MYLOConstants.STATE), data.get(i).get(MYLOConstants.CITY));
			clickElementOnOtherAddressesSection(MYLOConstants.SAVE_BUTTON);
			Assert.assertTrue(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE)));
			clickElementOnOtherAddressesSection(MYLOConstants.CLOSE_BUTTON);
		}
	}
	
	/**
	 * @param sectionType
	 * @param stateValue
	 * Set State Field on Other Address section
	 */
	public void setOtherAddressStateField(String sectionType,String stateValue) {
		if (verifyOtherAddressFieldAvailability(MYLOConstants.STATE)
				&& sectionType.equals(MYLOConstants.MAILING_ADDRESS))
			updatedMailAddressStateValue = setFieldOtherAddress(_otherAddressaddStateValue, stateValue);
		else if (verifyOtherAddressFieldAvailability(MYLOConstants.STATE)
				&& sectionType.equals(MYLOConstants.TEMPORARY_ADDRESS))
			updatedTempAddressStateValue = setFieldOtherAddress(_otherAddressaddStateValue, stateValue);
		else {
			clickElementOnOtherAddressesSection(MYLOConstants.STATE);
			setFieldValueOnOtherAddressesSection(MYLOConstants.STATE, stateValue);
		}
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Set Mandatory Field Values on Other Address section
	 */
	public void setMandatoryFieldValuesOtherAddressSection(String sectionType,DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		if (sectionType.equals(MYLOConstants.MAILING_ADDRESS)) {
			clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, data.get(0).get(MYLOConstants.COUNTRY));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_CITY,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_CITY));
			setOtherAddressStateField(MYLOConstants.MAILING_ADDRESS,data.get(0).get(MYLOConstants.STATE));
		}
		else if (sectionType.equals(MYLOConstants.TEMPORARY_ADDRESS)) {
			clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, data.get(0).get(MYLOConstants.COUNTRY));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_CITY,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_CITY));
			setOtherAddressStateField(MYLOConstants.TEMPORARY_ADDRESS,data.get(0).get(MYLOConstants.STATE));
		}
	}
	
	/**
	 * @param table
	 * Set Field Value on Other Address section
	 */
	public void setFieldValueOtherAddressSection(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		if (data.get(0).get("SectionType").equals(MYLOConstants.MAILING_ADDRESS)) {
			clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, data.get(0).get(MYLOConstants.COUNTRY));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_CITY,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_CITY));
			setOtherAddressStateField(MYLOConstants.MAILING_ADDRESS,data.get(0).get(MYLOConstants.STATE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ZIPCODE,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_ZIPCODE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_FROMDATE,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_FROMDATE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS1,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS1));
			setFieldValueOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS2,
					data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS2));
		}
		else if (data.get(0).get("SectionType").equals(MYLOConstants.TEMPORARY_ADDRESS)) {
			clickElementOnOtherAddressesSection(MYLOConstants.COUNTRY);
			setFieldValueOnOtherAddressesSection(MYLOConstants.COUNTRY, data.get(0).get(MYLOConstants.COUNTRY));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_CITY,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_CITY));
			setOtherAddressStateField(MYLOConstants.TEMPORARY_ADDRESS,data.get(0).get(MYLOConstants.STATE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ZIPCODE,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_ZIPCODE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_FROMDATE,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_FROMDATE));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS1,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS1));
			setFieldValueOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS2,
					data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS2));
		}
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Verify updated field values
	 * @return
	 */
	public boolean verifyFieldValuesOtherAddress(String sectionType, DataTable table) {
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		try {
			if (sectionType.equals(MYLOConstants.MAILING_ADDRESS_DROPDOWN)) {
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_COUNTRY),
						data.get(0).get(MYLOConstants.COUNTRY),MYLOConstants.COUNTRY + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_CITY),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_CITY),MYLOConstants.MAIL_ADDRESS_CITY + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(
					getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN),
						data.get(0).get(MYLOConstants.STATE),MYLOConstants.STATE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ZIPCODE),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ZIPCODE),MYLOConstants.MAIL_ADDRESS_ZIPCODE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_FROMDATE),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_FROMDATE),MYLOConstants.MAIL_ADDRESS_FROMDATE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS1),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS1),MYLOConstants.MAIL_ADDRESS_ADDRESS1 + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS2),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS2),MYLOConstants.MAIL_ADDRESS_ADDRESS2 + MYLOConstants.VALUE_NOT_UPDATED);
			} else if (sectionType.equals(MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN)) {
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY),
						data.get(0).get(MYLOConstants.COUNTRY),MYLOConstants.COUNTRY + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(
						getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN),
						data.get(0).get(MYLOConstants.STATE),MYLOConstants.STATE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_CITY),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_CITY),MYLOConstants.TEMP_ADDRESS_CITY + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ZIPCODE),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ZIPCODE),MYLOConstants.TEMP_ADDRESS_ZIPCODE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_FROMDATE),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_FROMDATE),MYLOConstants.TEMP_ADDRESS_FROMDATE + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS1),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS1),MYLOConstants.TEMP_ADDRESS_ADDRESS1 + MYLOConstants.VALUE_NOT_UPDATED);
				Assert.assertEquals(getFieldValueOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS2),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS2),MYLOConstants.TEMP_ADDRESS_ADDRESS2 + MYLOConstants.VALUE_NOT_UPDATED);
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * @param sectionType
	 * @param table
	 * Verify toast message for Special Characters
	 */
	public void verifySpecialCharactersToastMessage(String sectionType, DataTable table) {
		setOtherAddressMandatoryFields(sectionType, MYLOConstants.USA_STATE, MYLOConstants.RANDOM,
				MYLOConstants.CITY_VALUE);
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName=data.get(i).get(MYLOConstants.FIELD_NAME);
			setFieldValueOnOtherAddressesSection(fieldName,
					MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickElementOnOtherAddressesSection(MYLOConstants.SAVE_BUTTON);
			if (sectionType.equals(MYLOConstants.MAILING_ADDRESS))
				Assert.assertTrue(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE) + MYLOConstants.SPACE
						+ MYLOConstants.MAILING_ADDRESS.toLowerCase() + MYLOConstants.DOT));
			else
				Assert.assertTrue(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE) + MYLOConstants.SPACE
						+ MYLOConstants.TEMPORARY_ADDRESS.toLowerCase() + MYLOConstants.DOT));
			clickElementOnOtherAddressesSection(MYLOConstants.CLOSE_BUTTON);
			mapOtherAddresssValidFieldValue();
			setFieldValueOnOtherAddressesSection(fieldName, otherAdressvalidFieldValueMap.get(fieldName));
		}
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Enter special characters in different fields on Other Address section
	 */
	public void setSpecialCharacters(String sectionType,DataTable table) {
		if(sectionType.equals(MYLOConstants.TEMPORARY_ADDRESS)) {
			clickElementOnOtherAddressesSection(MYLOConstants.CANCEL_BUTTON);
			clickElementOnOtherAddressesSection(MYLOConstants.TEMPORARY_ADDRESS);
		}
		verifySpecialCharactersToastMessage(sectionType, table);
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * Verify values updated or not on Other Address section
	 */
	public void verifyOtherAddressUpdatedFieldValues(String sectionType,DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			Assert.assertTrue(verifyUpdatedFieldValueOtherAddress(fieldName));
		}	
	}
	
	/**
	 * Map FieldName with Values
	 */
	public void mapOtherAddresssValidFieldValue() {
		otherAdressvalidFieldValueMap.put(MYLOConstants.CITY, MYLOConstants.CITY_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.ZIPCODE, MYLOConstants.ZIPCODE_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.COMMENTS, MYLOConstants.COMMENTS_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.ADDRESS1, MYLOConstants.ADDRESS1_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.ADDRESS2, MYLOConstants.ADDRESS2_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.STATE_TEXT_FIELD, MYLOConstants.STATE_VALUE);
		otherAdressvalidFieldValueMap.put(MYLOConstants.FROMDATE, MYLOConstants.CURRENT);		
	}
	
	// *************** History Cards***********************//
	
	public void clickElementHistoryCardSection(String elementName) {
		switch (elementName) {
		case MYLOConstants.HistoryCardDropdown:
			CoreFunctions.clickUsingJS(driver, _historyCardDropdown, MYLOConstants.HistoryCardDropdown);
			break;
		case MYLOConstants.CloseHistoryCard:
			CoreFunctions.clickUsingJS(driver, _historyCardCloseBtn.get(0), _historyCardCloseBtn.get(0).getAttribute("aria-label"));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}
		
	public boolean verifyHistoryDetails(List<Map<String, String>> data) {
		boolean flag = true;
		for (int i = 0; i < data.size(); i++) {
			if (!(CoreFunctions.getElementText(driver, _historyCardDisplayedTransferreName.get(i))
					.equals(data.get(i).get("Transferee Name"))
					&& CoreFunctions.getElementText(driver, _historyCardDisplayedFileIdClient.get(i))
							.equals(data.get(i).get("FileId & Client Name"))
					&& CoreFunctions.getElementText(driver, _historyCardDisplayedAddress.get(i))
							.equals(data.get(i).get("Origin & Destination Address")))) {
				flag = false;
			}
		}
		return flag;
	}
	
	public void pageRefresh() {
		CoreFunctions.refreshPage(driver);
	}
	
	public void deleteHistoryCard(int totalCount) {	
	    int historyCardNo = CoreFunctions.getRandomNumber(0, 2);
		CoreFunctions.clickUsingJS(driver, _historyCardCloseBtn.get(historyCardNo), _historyCardCloseBtn.get(historyCardNo).getAttribute("aria-label"));
		historyDetails.remove(totalCount-historyCardNo-2);
	}
	
	public boolean verifyHistoryCardPresent() {	
		boolean flag =CoreFunctions.isElementExist(driver, _historyCardSection, 5); 
		if(flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.HISTORYCARD_PRESENT, CoreConstants.PASS, MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.HISTORYCARD_NOT_PRESENT, CoreConstants.PASS, MYLOConstants.ASSIGNMENT));
		return flag;
	}
	
	/**
	 * @param countryName
	 * @return
	 * get Mylo Assignment HistoryDetails from json of corresponding country passed as a parameter
	 */
	public List<String> getMyloHistoryDetailsByEnv() {
		String env = CoreFunctions.getPropertyFromConfig("envt");
		switch (env) {
		case MYLOConstants.UAT:
		case MYLOConstants.RELONETQA4:
			List<Mylo_Assignment_HistoryDetails_UAT> myloUATHistoryDetails = FileReaderManager.getInstance().getMyloJsonReader().getMyloAssignmentUATHistoryDetails();
			historyfileIds.addAll(myloUATHistoryDetails.stream().map(x -> x.fileId).collect(Collectors.toList()));
			historyDetails.addAll(myloUATHistoryDetails.stream().map(x -> x.historyDetails).collect(Collectors.toList()));
			break;
		case MYLOConstants.PREPROD:
			List<Mylo_Assignment_HistoryDetails_PREPROD> myloPreProdHistoryDetails = FileReaderManager.getInstance().getMyloJsonReader().getMyloAssignmentPREPRODHistoryDetails();
			historyfileIds.addAll(myloPreProdHistoryDetails.stream().map(x -> x.fileId).collect(Collectors.toList()));
			historyDetails.addAll(myloPreProdHistoryDetails.stream().map(x -> x.historyDetails).collect(Collectors.toList()));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_COUNTRY_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_COUNTRY_NAME);
		}
		return historyfileIds;
	}
	
	/**
	 * @param count
	 * @return
	 * Verify History Card Details displayed like Transferre Name,FileId,ClientName,Address
	 */
	public boolean verifyHistoryCardDetailsDisplayed(int count) {
		boolean flag = true;
		for (int i =0; i <3; i++) {
			count--;
			String[] details = historyDetails.get(count).split(";");
			if (!(CoreFunctions.getElementText(driver, _historyCardDisplayedTransferreName.get(i)).equals(details[0].trim())
					&& CoreFunctions.getElementText(driver, _historyCardDisplayedFileIdClient.get(i)).equals(details[1].trim())
					&& CoreFunctions.getElementText(driver, _historyCardDisplayedAddress.get(i)).equals(details[2].trim()))) {
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * @param count
	 * @return
	 * Verify History Card Details displayed like Transferre Name,FileId,ClientName,Address in the History Dropdown section
	 */
	public boolean verifyHistoryCardDetailsDropdown(int count) {
		boolean flag = true;
		for (int i =0; i <_historyCardDropdownTransferreName.size(); i++) {
			count--;
			String[] details = historyDetails.get(count).split(";");
			CoreFunctions.scrollToElementUsingJavaScript(driver, _historyCardDropdownTransferreName.get(i), _historyCardDropdownTransferreName.get(i).getText());
			CoreFunctions.scrollToElementUsingJavaScript(driver, _historyCardDropdownFileIdClient.get(i), _historyCardDropdownFileIdClient.get(i).getText());
			CoreFunctions.scrollToElementUsingJavaScript(driver, _historyCardDropdownAddress.get(i), _historyCardDropdownAddress.get(i).getText());
			if (!(CoreFunctions.getElementText(driver, _historyCardDropdownTransferreName.get(i)).equals(details[0].trim())
					&& CoreFunctions.getElementText(driver, _historyCardDropdownFileIdClient.get(i)).equals(details[1].trim())
					&& CoreFunctions.getElementText(driver, _historyCardDropdownAddress.get(i)).equals(details[2].trim()))) {	
				System.out.println(CoreFunctions.getElementText(driver, _historyCardDropdownTransferreName.get(i)) + "-------" + details[0].trim());
				System.out.println(CoreFunctions.getElementText(driver, _historyCardDropdownFileIdClient.get(i))+ "-------" + details[1].trim());
				System.out.println(CoreFunctions.getElementText(driver, _historyCardDropdownAddress.get(i))+ "-------" + details[2].trim());
				
				flag = false;
			}
		}
		return flag;
	}
	
	/**
	 * @param shipmentStatus
	 * @param requiredField
	 * @return
	 * Get FileDetails Related to Shipment Services
	 */
	public String getFileDetailsByShipmentServices(String shipmentStatus, String requiredField ) {
		HashMap<String, String> shipmentFileDetailsmap = new HashMap<String, String>();
		switch (shipmentStatus) {
		case MYLOConstants.NO_SHIPMENT:
			shipmentFileDetailsmap.put(MYLOConstants.FILE_ID, assignmentShipmentDetails.noShipment.fileID);
			shipmentFileDetailsmap.put(MYLOConstants.SHIPMENT_DETAILS, assignmentShipmentDetails.noShipment.shipmentDetails);
			break;
		case MYLOConstants.ONE_SHIPMENT:
			shipmentFileDetailsmap.put(MYLOConstants.FILE_ID, assignmentShipmentDetails.oneShipment.fileID);
			shipmentFileDetailsmap.put(MYLOConstants.SHIPMENT_DETAILS, assignmentShipmentDetails.oneShipment.shipmentDetails);
			break;
		case MYLOConstants.TWO_SHIPMENT:
			shipmentFileDetailsmap.put(MYLOConstants.FILE_ID, assignmentShipmentDetails.twoShipment.fileID);
			shipmentFileDetailsmap.put(MYLOConstants.SHIPMENT_DETAILS, assignmentShipmentDetails.twoShipment.shipmentDetails);
			break;
		case MYLOConstants.MULTIPLE_SHIPMENT:
			shipmentFileDetailsmap.put(MYLOConstants.FILE_ID, assignmentShipmentDetails.multipleShipment.fileID);
			shipmentFileDetailsmap.put(MYLOConstants.SHIPMENT_DETAILS, assignmentShipmentDetails.multipleShipment.shipmentDetails);
			break;
		
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_STATUS);
		}
		return shipmentFileDetailsmap.get(requiredField);

	}
	
	/**
	 * @param option
	 * @return
	 * Get Background Color of Different Assignment Tabs
	 */
	public String getAssignmentTabsBgColor(String option) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, subTabs, option);
		CoreFunctions.explicitWaitTillElementVisibility(driver, tabElement, tabElement.getText());
		String hexColorValue = Color.fromString(tabElement.getCssValue(MYLOConstants.BACKGROUND_COLOR)).asHex();
		return hexColorValue;
	}
	
	/**
	 * @param option
	 * @return
	 * Get Hover Message on Mentioned Assignment Tab
	 */
	public String getAssignmentTabsHoverMessage(String option) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, subTabs);
		WebElement tabElement = CoreFunctions.returnItemInListByText(driver, subTabs, option);
		CoreFunctions.explicitWaitTillElementVisibility(driver, tabElement, tabElement.getText());
		CoreFunctions.hover(driver, tabElement);
		return tabElement.getAttribute(MYLOConstants.TITLE);
	}
	
	/**
	 * @return
	 * Verify Shipment Section Availability
	 */
	public boolean verifyShipmentSectionDisplayed() {
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		return CoreFunctions.verifyElementPresentOnPage(__webSwingSection, MYLOConstants.SHIPMENT_WEBSWING);	
	}
	
	/**
	 * @param shipmentStatus
	 * @return
	 * Verify Available Shipment Services in the Shipment Dropdown tab
	 */
	public boolean verifyShipmentDropdown(String shipmentStatus) {
		boolean flag = true;
		String[] shipmentDetail = getFileDetailsByShipmentServices(shipmentStatus, MYLOConstants.SHIPMENT_DETAILS)
				.split(";");
		for (int i = 0; i < _shipmentDropdownValues.size(); i++) {
			if (!(CoreFunctions.getElementText(driver, _shipmentDropdownValues.get(i))
					.equals(shipmentDetail[i].trim())))
				flag = false;
		}
		return flag;
	}
	
	// *************** Identification & Documentation section ***********************//
	
	/**
	 * @param buttonName
	 * @return
	 * verify enability of Buttons in Identification & Documentation section
	 */
	public boolean verifyIdentDocButtonDisplayed(String buttonName) {
		boolean flag = false;
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			flag = CoreFunctions.isElementVisible(_identDocAddIcon);
			break;
		case MYLOConstants.EDIT_BUTTON:
			flag = CoreFunctions.isElementVisible(_identDocEditIcon);
			break;
		case MYLOConstants.SAVE_BUTTON:
			flag = CoreFunctions.isElementVisible(_identDocSaveIcon);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.PASS,
					buttonName,MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.PASS,
					buttonName,MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		return flag;
	}
	
	/**
	 * @param sectionName
	 * Highlight Section Header
	 */
	public void highlightSectionHeader(String sectionName) {	
		CoreFunctions.highlightObject(driver, _transfereeNameHeader);
		CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		WebElement requiredElement = CoreFunctions.returnItemInListByText(driver, _assignmentSectionHeaders, sectionName);
		CoreFunctions.scrollToElementUsingJavaScript(driver, requiredElement, sectionName);
		CoreFunctions.highlightObject(driver, requiredElement);
	}
	
	/**
	 * @param index
	 * Select Transferee/Family details
	 */
	public void selectIdentDocTransfereeDetails(int index) {	
		CoreFunctions.highlightObject(driver, _identDocTransferreFamilyMembersName.get(index));
		CoreFunctions.click(driver, _identDocTransferreFamilyMembersName.get(index), _identDocTransferreFamilyMembersName.get(index).getText());
	}
	
	/**
	 * @param buttonName
	 * Click button on Identification & Documentation section
	 * 
	 */
	public void clickButtonOnIentificationAndDocumentationSection(String buttonName) {
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			CoreFunctions.click(driver, _identDocAddIcon, MYLOConstants.ADD_BUTTON);
			CoreFunctions.explicitWaitTillElementListVisibilityCustomTime(driver, _identDocTypeDropdowns, 10);		
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.click(driver, _identDocCancelIcon, MYLOConstants.CANCEL_BUTTON);
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.click(driver, _identDocSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 200);
			break;
		case MYLOConstants.EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocEditIcon, _identDocEditIcon.getText());
			CoreFunctions.click(driver, _identDocEditIcon,  MYLOConstants.EDIT_BUTTON);
			break;
		case MYLOConstants.YES_BUTTON:
			CoreFunctions.click(driver, _YesButton, _YesButton.getText());
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			break;
		case MYLOConstants.NO_BUTTON:
			CoreFunctions.click(driver, _NoButton, _NoButton.getText());
			break;
		case MYLOConstants.CLOSE_BUTTON:
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, _closeBtn.getText());
			break;
		case MYLOConstants.REMOVE_BUTTON:
			CoreFunctions.click(driver, _removeButton.get(0), MYLOConstants.REMOVE_BUTTON);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}
	
	/**
	 * @param elementName
	 * @param index
	 * Click Different Elements on IdentificationAndDocumentation section
	 */
	public void clickElementOnIdentificationAndDocumentationSection(String elementName,int index) {
		switch (elementName) {
		case MYLOConstants.IDENTITY_TYPE_DROPDOWN:
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _identDocTypeDropdowns);
			CoreFunctions.highlightObject(driver, _identDocTypeDropdowns.get(index));
			CoreFunctions.click(driver, _identDocTypeDropdowns.get(index), MYLOConstants.IDENTITY_TYPE_DROPDOWN);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocTypeDropdowns.get(index), MYLOConstants.IDENTITY_TYPE_DROPDOWN);
			identityTypeList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocCountryDropdowns.get(index), MYLOConstants.COUNTRY);
			CoreFunctions.click(driver, _identDocCountryDropdowns.get(index), MYLOConstants.COUNTRY);
			countryList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.REMOVE_BUTTON:
			CoreFunctions.click(driver, _removeButton.get(index), MYLOConstants.REMOVE_BUTTON);
			identDocTypeValues.remove(index);
			identDocNumberValues.remove(index);
			identDocToDateValues.remove(index);
			identDocFromDateValues.remove(index);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}
	
	/**
	 * @param fieldValue
	 * Set Type value on Identification & Documentation section
	 */
	public String setIdentityDocMembersTypeValue(String fieldValue) {
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			identityTypeList.remove(0);
			updatedTypeValue = CoreFunctions.getRandomElementValueFromList(driver, identityTypeList);
			BusinessFunctions.selectItemFromListUsingText(driver, identityTypeList,
					updatedTypeValue);
		} else {
			updatedTypeValue=fieldValue;
			BusinessFunctions.selectItemFromListUsingText(driver, identityTypeList, fieldValue);
		}
		
		return updatedTypeValue;
	}
	
	public boolean verifyIdentityTypeValuesListFromDB() {
		boolean flag = false;	
		List<String> identityTypeListFromUI = identityTypeList.stream().map(x -> x.getText())
				.collect(Collectors.toList());
		identityTypeListFromUI.remove(MYLOConstants.SELECT_ONE);
		List<String> identTypeOptionsFromDB = DbFunctions.getIdentTypeOptionsFromDB();
		flag = identityTypeListFromUI.equals(identTypeOptionsFromDB);
		return flag;
	}
	
	
	/**
	 * @param fieldValue
	 * Set Country Value on Identification & Documentation section
	 */
	public String setIdentityDocMembersCountryValue(String fieldValue) {
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			countryList.remove(0);
			updatedCountryValue = CoreFunctions.getRandomElementValueFromList(driver, countryList);
			BusinessFunctions.selectItemFromListUsingText(driver, countryList,
					updatedCountryValue);
		} else {
			updatedCountryValue=fieldValue;
			BusinessFunctions.selectItemFromListUsingText(driver, countryList, fieldValue);
		}	
		return updatedCountryValue;
	}
	
	/**
	 * @param fieldValue
	 * @param index
	 * @return
	 * Set From Date Value in Identification & Documentation section
	 */
	public String setIdentityDocMembersFromDateValue(String fieldValue, int index) {
		updatedFromDate = (fieldValue.equals(MYLOConstants.CURRENT))
				? CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy")
				: fieldValue;
		if (updatedFromDate == "") {
			//CoreFunctions.clearTextField(driver, _identDocFromDates.get(index), MYLOConstants.FROMDATE);
			CoreFunctions.click(driver, _identDocFromDates.get(index), MYLOConstants.FROMDATE);
			_identDocFromDates.get(index).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			_identDocFromDates.get(index).sendKeys(Keys.BACK_SPACE);
	}
		else
			CoreFunctions.clearAndSetText(driver, _identDocFromDates.get(index), updatedFromDate);
		return updatedFromDate;
	}
	
	/**
	 * @param fieldValue
	 * @param index
	 * @return
	 * Set To Date Value in Identification & Documentation section
	 */
	public String setIdentityDocMembersToDateValue(String fieldValue, int index) {
		updatedToDate = (fieldValue.equals(MYLOConstants.CURRENT))
				? CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy")
				: fieldValue;
		if (updatedToDate == "")
			CoreFunctions.clearTextField(driver, _identDocToDates.get(index), MYLOConstants.FROMDATE);
		else
			CoreFunctions.clearAndSetText(driver, _identDocToDates.get(index), updatedToDate);
		return updatedToDate;
	}
	
	/**
	 * @param fieldValue
	 * @param index
	 * @return
	 * Set Number Value in Identification & Documentation section
	 */
	public String setIdentityDocMembersNumberValue(String fieldValue, int index) {
		try {
			updatedNoValue = CoreFunctions.generateRandomString(Integer.parseInt(fieldValue));
			CoreFunctions.clearAndSetText(driver, _identDocNumbers.get(index), updatedNoValue);
		} catch (NumberFormatException e) {
			updatedNoValue = fieldValue;
			if (updatedNoValue == "") {
				CoreFunctions.click(driver, _identDocNumbers.get(index), MYLOConstants.NUMBER);
			_identDocNumbers.get(index).sendKeys(Keys.chord(Keys.CONTROL, "a"));
			_identDocNumbers.get(index).sendKeys(Keys.BACK_SPACE);
			}
			else
				CoreFunctions.clearAndSetText(driver, _identDocNumbers.get(index), updatedNoValue);
		}
		return updatedNoValue;
	}
	
	/**
	 * @param typeValue
	 * @param number
	 * @param fromDate
	 * Set Mandatory Field Values of Identification & Documentation section
	 */
	public void setIdentDocMembersMandatoryFields(String typeValue, String number,String fromDate) {
		clickElementOnIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE_DROPDOWN,0);
		setIdentityDocMembersTypeValue(typeValue);
		setIdentityDocMembersNumberValue(number,0);
		setIdentityDocMembersFromDateValue(fromDate,0) ;
	}
	
	/**
	 * @param table
	 * Verifying the values of mandatory fields of Identification & Documentation section
	 */
	public void verifyMandatoryFieldsToastMessagesIdentDocSection(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setIdentDocMembersMandatoryFields(data.get(i).get(MYLOConstants.IDENTITY_TYPE),
					data.get(i).get(MYLOConstants.NUMBER), data.get(i).get(MYLOConstants.FROMDATE));
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.SAVE_BUTTON);
			Assert.assertTrue(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE)));
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.CLOSE_BUTTON);
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.CANCEL_BUTTON);
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.YES_BUTTON);
			//verifyActiveTab(MYLOConstants.SUMMARY);
			highlightSectionHeader(MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION);
			CoreFunctions.highlightObject(driver, _identDocAddIcon);
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
		}
	}
	
	/**
	 * @param table
	 * Set Different Field Values for Multiple rows of Identification & Documentation section
	 */
	public void setIdentDocMultipleRowFieldValues(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			clickButtonOnIentificationAndDocumentationSection(MYLOConstants.ADD_BUTTON);
			clickElementOnIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE_DROPDOWN,0);
			identDocTypeValues.add(setIdentityDocMembersTypeValue(data.get(i).get(MYLOConstants.IDENTITY_TYPE)));
			clickElementOnIdentificationAndDocumentationSection(MYLOConstants.COUNTRY,0);
			identDocCountryValues.add(setIdentityDocMembersCountryValue(data.get(i).get(MYLOConstants.COUNTRY)));
			identDocNumberValues.add(setIdentityDocMembersNumberValue(data.get(i).get(MYLOConstants.NUMBER),0));
			identDocFromDateValues.add(setIdentityDocMembersFromDateValue(data.get(i).get(MYLOConstants.FROMDATE),0)) ;
			identDocToDateValues.add(setIdentityDocMembersToDateValue(data.get(i).get(MYLOConstants.TODATE),0)) ;
		}
	}
	
	/**
	 * @param table
	 * Update Different Field Values for Multiple Rows of Identification & Documentation section
	 */
	public void updateIdentDocMultipleRowFieldValues(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			int row=Integer.parseInt(data.get(i).get(MYLOConstants.ROW))-1;
			clickElementOnIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE_DROPDOWN,row);
			identDocTypeValues.set(row,setIdentityDocMembersTypeValue(data.get(i).get(MYLOConstants.IDENTITY_TYPE)));
			clickElementOnIdentificationAndDocumentationSection(MYLOConstants.COUNTRY,row);
			identDocCountryValues.set(row,setIdentityDocMembersCountryValue(data.get(i).get(MYLOConstants.COUNTRY)));
			identDocNumberValues.set(row,setIdentityDocMembersNumberValue(data.get(i).get(MYLOConstants.NUMBER),row));
			identDocFromDateValues.set(row,setIdentityDocMembersFromDateValue(data.get(i).get(MYLOConstants.FROMDATE),row)) ;
			identDocToDateValues.set(row,setIdentityDocMembersToDateValue(data.get(i).get(MYLOConstants.TODATE),row)) ;
		}
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Get Different Field Value for specific records of Identification & Documentation section
	 */
	public String getFieldValuesIdentificationAndDocumentationSection(String fieldName, int index) {
		String requiredValue = null;
		switch (fieldName) {
		case MYLOConstants.IDENTITY_TYPE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocTypeValuesSelected.get(index), MYLOConstants.IDENTITY_TYPE);
			requiredValue = CoreFunctions.getElementText(driver, _identDocTypeValuesSelected.get(index));
			break;
		case MYLOConstants.NUMBER:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocNumbers.get(index), MYLOConstants.NUMBER);
			requiredValue = CoreFunctions.getAttributeText(_identDocNumbers.get(index), CoreConstants.VALUE);
			break;
		case MYLOConstants.FROMDATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocFromDates.get(index), MYLOConstants.FROMDATE);
			requiredValue = CoreFunctions.getAttributeText(_identDocFromDates.get(index), CoreConstants.VALUE);
			break;
		case MYLOConstants.TODATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocToDates.get(index), MYLOConstants.TODATE);
			requiredValue = CoreFunctions.getAttributeText(_identDocToDates.get(index), CoreConstants.VALUE);
			break;
		case MYLOConstants.COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _identDocCountryValuesSelected.get(index), MYLOConstants.COUNTRY);
			requiredValue = CoreFunctions.getElementText(driver,_identDocCountryValuesSelected.get(index));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
		return requiredValue;
	}
	
	/**
	 * @param index
	 * @return
	 * Verify Mandatory Field Values for Specified rows of of Identification & Documentation section
	 */
	public boolean verifyMandatoryFieldValuesIdentificationAndDocumentationSection(int index) {
		boolean flag = false;
		String updatedDate = CoreFunctions.getStringDateInFormat(
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.FROMDATE, index), "dd MMM yyyy",
				"MM/dd/yyyy");
		if (getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE, index)
				.equals(updatedTypeValue)
				&& getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.NUMBER, index)
						.equals(updatedNoValue)
				&& updatedDate.equals(updatedFromDate)) {
			flag = true;
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ELEMENT_DISPLAYED_IDENTDOC_SECTION,
					CoreConstants.PASS, updatedTypeValue, updatedNoValue, updatedFromDate,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		} else
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
		return flag;
	}
	
	/**
	 * @param index
	 * @return
	 * Verify Mandatory Field Initial Values for Specified rows of Identification & Documentation section
	 */
	public boolean verifyMandatoryFieldInitialValuesIdentificationAndDocumentationSection(int index) {
		boolean flag=false;
		if(getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE,index).contentEquals("Select One")&&
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.NUMBER,index).contentEquals("")&&
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.FROMDATE,index).contentEquals("")) {
			flag=true;
		Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ELEMENT_DISPLAYED_IDENTDOC_SECTION,
				CoreConstants.PASS, updatedTypeValue, updatedNoValue, updatedFromDate,
				MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
	} else
		Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
	return flag;
	}
	
	/**
	 * Reverse List order of Type,Number,FromDate and ToDate of Identification & Documentation section
	 */
	public void reverseidentDocList() {
		Collections.reverse(identDocTypeValues);
		Collections.reverse(identDocNumberValues);
		Collections.reverse(identDocFromDateValues);
		Collections.reverse(identDocToDateValues);
		Collections.reverse(identDocCountryValues);
	}
	
	/**
	 * @return
	 * Verify Different FieldValues for Multiple Rows of Identification & Documentation section
	 */
	public boolean verifyMultipleRowsFieldValuesIdentDocSection() {
		boolean flag = true;	
		for(int i=0;i<_identDocTypeDropdowns.size();i++) {
		String updatedFromDate = CoreFunctions.getStringDateInFormat(
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.FROMDATE, i), "dd MMM yyyy",
				"MM/dd/yyyy");
		String updatedToDate = CoreFunctions.getStringDateInFormat(
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.TODATE, i), "dd MMM yyyy",
				"MM/dd/yyyy");
		if (!(getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE, i)
				.equals(identDocTypeValues.get(i))
				&& getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.COUNTRY, i)
				.equals(identDocCountryValues.get(i))
				&& getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.NUMBER, i)
						.equals(identDocNumberValues.get(i))
				&& updatedFromDate.equals(identDocFromDateValues.get(i))
				&& updatedToDate.equals(identDocToDateValues.get(i)))) {
			flag = false;
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
			break;
		} else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ELEMENT_DISPLAYED_IDENTDOC_SECTION,
					CoreConstants.PASS, updatedTypeValue, updatedNoValue, updatedFromDate,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));		
	}
		return flag;
	}
	
	/**
	 * @param msg
	 * @param index
	 * @return
	 * Verify Multiple Toast Messages appearing simultaneously
	 */
	public boolean verifyAlertMessageList(String msg,int index) {
		boolean flag = false;
		try {
			CoreFunctions.isElementListExist(driver, _alertMessageList,5);
			CoreFunctions.highlightObject(driver, _alertMessageList.get(index));
			System.out.println(_alertMessageList.get(index).getText());
			flag = (_alertMessageList.get(index).getText().equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
					MYLOConstants.ALERT_MESSAGE, MYLOConstants.ASSIGNMENT));
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					_alertMessage.getText(), MYLOConstants.ASSIGNMENT));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Background is Red Colour for Different Fields for which error messages appearing of Identification & Documentation section
	 */
	public boolean verifyIdentDocFieldErrorBackground(String fieldName, int index) {
		boolean flag = false;
		switch (fieldName) {
		case MYLOConstants.COUNTRY:
			flag=verifyFieldBorderRedColor(fieldName, _identDocCountryDropdowns.get(index));
			break;	
		case MYLOConstants.IDENTITY_TYPE:
			flag=verifyFieldBorderRedColor(fieldName, _identDocTypeBackColour.get(index));
			break;
		case MYLOConstants.NUMBER:
			flag=verifyFieldBorderRedColor(fieldName, _identDocNumbers.get(index));
			break;
		case MYLOConstants.FROMDATE:
			flag=verifyFieldBorderRedColor(fieldName, _identDocFromDates.get(index));
			break;
		case MYLOConstants.TODATE:
			flag=verifyFieldBorderRedColor(fieldName, _identDocToDates.get(index));
			break;	
		case MYLOConstants.ALERT_MESSAGE:
			flag=verifyFieldBackgroundRedColor(fieldName, _alertMessageListBackColour.get(index));
			break;	
			
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_HIGHLIGHTED, CoreConstants.PASS,
					fieldName, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_FIELD_NOT_HIGHLIGHTED, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));

		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param element
	 * @return
	 * Verfiied Background is Red Color
	 * 
	 */
	public boolean verifyFieldBackgroundRedColor(String fieldName, WebElement element) {
		boolean flag = false;
		CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName);
		String hexColorValue = Color.fromString(element.getCssValue(MYLOConstants.BACKGROUND_COLOR)).asHex();
		flag = (hexColorValue.equals(MYLOConstants.RED_COLOR_HEXCODE));
		return flag;
	}
	
	/**
	 * @return
	 * Verify Toast message is present or not
	 */
	public boolean verifyAlertMessagesPresent() {
		boolean flag;
		flag =CoreFunctions.isElementListExist(driver, _alertMessageList,5);	
		
		if(flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.TOAST_MESSAGE_PRESENT, CoreConstants.PASS,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.TOAST_MESSAGE_NOT_PRESENT, CoreConstants.PASS,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		return flag;
	}
	
	/**
	 * @param buttonName
	 * @return
	 * Verify Buttons present on Identification & Documentation section
	 */
	public boolean verifyIdentDocButtonPresent(String buttonName) {
		boolean flag=false;
		switch (buttonName) {
		case MYLOConstants.ADD_BUTTON:
			flag = CoreFunctions.isElementExist(driver, _identDocAddIcon, 5);
			break;
		case MYLOConstants.EDIT_BUTTON:
			flag = CoreFunctions.isElementExist(driver,_identDocEditIcon,5);
			break;
		case MYLOConstants.SAVE_BUTTON:
			flag = CoreFunctions.isElementExist(driver,_identDocSaveIcon,5);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_BUTTON_NAME);
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_PRESENT, CoreConstants.PASS,
					buttonName,MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.PASS,
					buttonName,MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION,MYLOConstants.ASSIGNMENT));
		return flag;
	}
	
	/**
	 * @return
	 * Verfied Data Appearing in Different Fields on Identification & Documentation section
	 */
	public boolean verifyRowsFieldValuesIdentDocSection() {
		boolean flag = true;	
		String updatedFromDate = CoreFunctions.getStringDateInFormat(
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.FROMDATE, 0), "dd MMM yyyy",
				"MM/dd/yyyy");
		String updatedToDate = CoreFunctions.getStringDateInFormat(
				getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.TODATE, 0), "dd MMM yyyy",
				"MM/dd/yyyy");
		if (!(getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.IDENTITY_TYPE, 0)
				.equals(MYLOConstants.IDENTDOC_TYPE)
				&& getFieldValuesIdentificationAndDocumentationSection(MYLOConstants.COUNTRY, 0)
				.equals(MYLOConstants.IDENTDOC_COUNTRY)
				&& updatedFromDate.equals(MYLOConstants.IDENTDOC_FROMDATE)
				&& updatedToDate.equals(MYLOConstants.IDENTDOC_TODATE))) {
			flag = false;
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.EXPECTED_FIELD_VALUE_NOTDISPLAYED);
		} else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ELEMENT_DISPLAYED_IDENTDOC_SECTION,
					CoreConstants.PASS, "Cedula", "USA", updatedFromDate,
					MYLOConstants.IDENTIFICATION_AND_DOCUMENTATION));		
		return flag;
	}
	
	/**
	 * Click on Close Icon of Toast Message
	 */
	public void clickToastMesssgeCloseIcon() {
		if (CoreFunctions.isElementExist(driver,_closeBtn,5)) {
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, MYLOConstants.CLOSE_BUTTON);
		}
	}
	
	public void clickPopUpOkButton() {
		if (CoreFunctions.isElementExist(driver, _myloErrorPopUp, 5)
				&& CoreFunctions.isElementExist(driver, _OKButtonPopUp, 5)) {
			CoreFunctions.clickElement(driver, _OKButtonPopUp);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 60);
		}
	}
}