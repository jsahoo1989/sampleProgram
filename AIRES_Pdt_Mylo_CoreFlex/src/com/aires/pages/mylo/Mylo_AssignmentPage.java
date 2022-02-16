package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.text.ParseException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.MyloAssignmentDetails;
import com.aires.testdatatypes.mylo.MyloCAStates;
import com.aires.testdatatypes.mylo.MyloIndiaStates;
import com.aires.testdatatypes.mylo.MyloUSStates;
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

	@FindBy(how = How.XPATH, using = "//h1[text()='Aires File Team']/parent::td/following-sibling::td/button[text()='Save']")
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
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Save ']")
	private WebElement _SaveButton;
	
	@FindBy(how = How.XPATH, using = "//span[text()='Save']")
	private WebElement _otherAddressSaveButton;
	
	@FindBy(how = How.XPATH, using = "//button[text()=' Cancel ']")
	private WebElement _CancelButton;

	@FindBy(how = How.CSS, using = "input[placeholder='FILE ID']")
	private WebElement _fileInfoFileId;

	@FindBy(how = How.CSS, using = "input[placeholder='Client Id']")
	private WebElement _fileInfoClientId;

	@FindBy(how = How.XPATH, using = "//ng-select[@name='policyType']//span[contains(@class,'ng-value-label')]")
	private WebElement _fileInfoPolicyType;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']/span")
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

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//span[@class='form-check-sign']")
	private List<WebElement> _fileInfoCheckboxes;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//input[@type='checkbox']")
	private List<WebElement> _fileInfoCheckBoxText;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::button[text()='Save']")
	private WebElement _fileInfoSaveButton;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::button[text()='Cancel']")
	private WebElement _fileInfoCancelButton;

	@FindBy(how = How.XPATH, using = "//button[text()=' File Information ']//following::div[@id='collapseOne']//descendant::button[text()='Edit']")
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
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Mailing Address']/preceding-sibling::img")
	private WebElement _addMailAddressBtn;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Temporary Address']/preceding-sibling::img")
	private WebElement _addTempAddressBtn;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@name='popupcountry']")
	private WebElement _countryDropdown;
	
	@FindBy(how = How.XPATH, using = "//h1[@class='popupheader']/following::ng-select[@name='state']")
	private WebElement _stateDropdown;
	
	@FindBy(how = How.XPATH, using = "//h1[@class='popupheader']/following::ng-select[@name='state']//following-sibling::label")
	private WebElement _stateFieldName;
	
	@FindBy(how = How.XPATH, using = "//h1[@class='popupheader']/following::input[@formcontrolname='stateProvince']")
	private WebElement _stateFieldTextType;
	
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
	
	@FindBy(how = How.CSS, using = "input[id='state']")
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
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='temporaryAddress']//span[text()='Edit']")
	private WebElement _tempEditButton;
	
	@FindBy(how = How.XPATH, using = "//app-address[@id='mailingAddress']//span[text()='Edit']")
	private WebElement _mailEditButton;
	
	@FindBy(how = How.XPATH, using = "//h2[text()='Success']//following::div[@id='swal2-content']")
	private WebElement _successMessage;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.XPATH, using = "//button[contains(@class,'toast-close-btn')]")
	private WebElement _closeBtn;
	
	
	int noOfAiresFileTeamMember;
	String updatedTeamMember;
	LinkedHashMap<String, String> airesFileTeamExistingMembers = new LinkedHashMap<String, String>();
	LinkedHashMap<String, WebElement> airesFileInfoFieldsMap = new LinkedHashMap<String, WebElement>();
	List<WebElement> countryList = new ArrayList<WebElement>();
	List<WebElement> typeDropDownList = new ArrayList<WebElement>();
	List<WebElement> stateList = new ArrayList<WebElement>();

	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	final By _fileInfoOfficeDropdownReadOnly = By.xpath("//ng-select[@name='office']//descendant::input[@disabled='']");
	final By _fileInfoPolicyTypeDropdownReadOnly = By.xpath("//ng-select[@name='policyType']//input[@disabled]");
	final By _assignmentSubMenus = By.xpath("//div[contains(@class,'navlist__container')]/li/a");

	MyloAssignmentDetails assignmentDetails = FileReaderManager.getInstance().getMyloJsonReader()
			.getAssignmentDetailsByApplication(MYLOConstants.IRIS);
	
	
	String updatedPolicyType, updatedTaxTreatment, updatedOffice, updatedJourneyType, updatedTransferType,
			updatedHomeStatus;
	String updatedFileInfoCheckboxSelected;
	String updatedTempAddressCityValue,updatedMailAddressCityValue;
	String updatedTempAddressZipCodeValue,updatedMailAddressZipCodeValue;
	String updatedTempAddressCommentsValue,updatedMailAddressCommentsValue;
	String updatedTempAddressStateValue,updatedMailAddressStateValue;
	String updatedTempAddress1Value,updatedMailAddress1Value;
	String updatedTempAddress2Value,updatedMailAddress2Value;
	String updatedTempAddressFromDateValue,updatedMailAddressFromDateValue;

	/**
	 * @param option 
	 * Click Different tabs in Assignment page
	 */
	public void clickAssignmentTabs(String option) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		CoreFunctions.explicitWaitTillElementListVisibility(driver, subTabs);
		CoreFunctions.selectItemInListByText(driver, subTabs, option);
	}

	/**
	 * @param tabName
	 * @return 
	 * Verify Active tab in Assignment page
	 */
	public boolean verifyActiveTab(String tabName) {
		List<WebElement> subTabs = CoreFunctions.getElementListByLocator(driver, _assignmentSubMenus);
		noOfAiresFileTeamMember = _noOfAddedAiresFileTeamMember.size();
		airesFileTeamExistingMembers = CoreFunctions.returnMapFromBothLists(driver, _airesFileTeamRoleName,
				_airesFileTeamMemberName);
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
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
			break;
		case MYLOConstants.CANCEL_BUTTON:
			CoreFunctions.click(driver, _airesFileTeamAddButton, _airesFileTeamAddButton.getText());
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
		CoreFunctions.click(driver, _roleSelectButtton, _roleSelectButtton.getAttribute(MYLOConstants.NAME));
		CoreFunctions.selectItemInListByText(driver, CoreFunctions.getElementListByLocator(driver, _dropdownOptions),
				roleName);
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
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _popUpMessage, _popUpMessage.getText());
			Assert.assertEquals(_popUpMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
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
		if (allTeamMembers.get(allRoleNames.indexOf(roleName)).trim().equals(updatedTeamMember)
				&& allStartDates.get(allRoleNames.indexOf(roleName)).trim().equals(currentDate)
				&& allEndDates.get(allRoleNames.indexOf(roleName)).trim().equals(MYLOConstants.ACTIVE)
				&& allEndDates.get(allRoleNames.lastIndexOf(roleName)).trim().equals(currentDate)) {

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
			CoreFunctions.click(driver, _fileInfoCancelButton, _fileInfoCancelButton.getText());
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoEditButton, _fileInfoEditButton.getText());
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _fileInfoSaveButton, _fileInfoSaveButton.getText());
			CoreFunctions.click(driver, _fileInfoSaveButton, _fileInfoSaveButton.getText());
			break;
		case MYLOConstants.DETAILS_CARROT_BUTTON:
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
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, _fileInfoEditButton.getText()));
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
		System.out.println(airesFileInfoFieldsMap.get(fieldName).getText());
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
			Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
			clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
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
		clickButtonOnAiresFileInformationSection(MYLOConstants.EDIT_BUTTON);
		updateFileInfoFields(MYLOConstants.POLICY_TYPE, MYLOConstants.POLICY_TYPE_VALUE);
		updateFileInfoFields(MYLOConstants.JOURNEY_TYPE, MYLOConstants.JOURNEY_TYPE_VALUE);
		updateFileInfoFields(MYLOConstants.HOMESTATUS, MYLOConstants.HOMESTATUS_VALUE);
		clickCheckBoxOnAiresFileInfoSection(MYLOConstants.INHERITED_FILE);
		clickButtonOnAiresFileInformationSection(MYLOConstants.SAVE_BUTTON);
		Assert.assertTrue(verifyMessage(MYLOConstants.SUCCESS_MESSAGE));
		clickButtonOnAiresFileInformationSection(MYLOConstants.OK_BUTTON);
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
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.closedFile.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.closedFile.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.closedFile.clientName);
			break;
		case MYLOConstants.RELOCATION_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.relocationPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.relocationPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.relocationPolicyType.clientName);
			break;
		case MYLOConstants.LUMP_SUM_PLAN_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.lumpSumpPlanPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.lumpSumpPlanPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.lumpSumpPlanPolicyType.clientName);
			break;
		case MYLOConstants.DOMESTIC_POLICY:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.domesticPolicyType.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.domesticPolicyType.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.domesticPolicyType.clientName);
			break;
		case MYLOConstants.ACTIVE_ASSIGNMENT:
			fileInfoDetailsmap.put(MYLOConstants.FILE_ID, assignmentDetails.activeAssignment.fileID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_ID, assignmentDetails.activeAssignment.clientID);
			fileInfoDetailsmap.put(MYLOConstants.CLIENT_NAME, assignmentDetails.activeAssignment.clientName);
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return fileInfoDetailsmap.get(requiredField);

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
			CoreFunctions.click(driver, _addMailAddressBtn, MYLOConstants.MAILING_ADDRESS);
			break;
		case MYLOConstants.TEMPORARY_ADDRESS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _addTempAddressBtn,
					MYLOConstants.TEMPORARY_ADDRESS);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _addTempAddressBtn,
					MYLOConstants.TEMPORARY_ADDRESS);
			CoreFunctions.click(driver, _addTempAddressBtn, MYLOConstants.TEMPORARY_ADDRESS);
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
		case MYLOConstants.CITY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _otherAddressaddCityValue, MYLOConstants.CITY);
			CoreFunctions.click(driver, _otherAddressaddCityValue, MYLOConstants.CITY);
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _SaveButton, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.click(driver, _SaveButton, MYLOConstants.SAVE_BUTTON);
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
			CoreFunctions.click(driver, _mailEditButton, _mailEditButton.getText());
			break;
		case MYLOConstants.TEMP_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressCountryDropdown,
					MYLOConstants.TEMP_ADDRESS_COUNTRY);
			CoreFunctions.click(driver, _tempAddressCountryDropdown, MYLOConstants.TEMP_ADDRESS_COUNTRY);
			countryList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			break;
		case MYLOConstants.MAIl_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressCountryDropdown,
					MYLOConstants.MAIl_ADDRESS_COUNTRY);
			CoreFunctions.click(driver, _mailAddressCountryDropdown, MYLOConstants.MAIl_ADDRESS_COUNTRY);
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
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressDropdown,
					_tempAddressDropdown.getText());
			CoreFunctions.click(driver, _tempAddressDropdown, _tempAddressDropdown.getText());
			break;
		case MYLOConstants.MAILING_ADDRESS_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressDropdown,
					_mailAddressDropdown.getText());
			CoreFunctions.click(driver, _mailAddressDropdown, _mailAddressDropdown.getText());
			break;
		case MYLOConstants.DELETE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _DeleteButton, _DeleteButton.getText());
			CoreFunctions.click(driver, _DeleteButton, _DeleteButton.getText());
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
		switch (fieldName) {
		case MYLOConstants.STATE:
		case MYLOConstants.TEMP_ADDRESS_STATE:
		case MYLOConstants.MAIL_ADDRESS_STATE:
			return CoreFunctions.getElementText(driver, _otherAddressStateLabelName);
		}
		return null;
	}
	
	/**
	 * @param dropDownName
	 * @return
	 * Verify DropdownList order for passed field name
	 */
	public boolean verifyDropdownListAlphabeticalOrder(String dropDownName) {
		switch (dropDownName) {
		case MYLOConstants.COUNTRY:		
			List<String> countryText = countryList.stream().map(x -> x.getText()).collect(Collectors.toList());
			List<String> copyCountryList = new ArrayList<String>(countryText);
			copyCountryList.remove("Select One");
			copyCountryList.remove("USA");
			return CoreFunctions.verifyListOrder(copyCountryList,MYLOConstants.ASCENDING);
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set the value of passed parameter
	 */
	public void setFieldValueOnOtherAddressesSection(String fieldName, String fieldValue) {
		switch (fieldName) {
		case MYLOConstants.COUNTRY:
			if (fieldValue.equals(MYLOConstants.RANDOM)) {
				List<String> valuesToIgnore = new ArrayList<String>();
				valuesToIgnore.add("USA");
				valuesToIgnore.add("INDIA");
				valuesToIgnore.add("CANADA");
				BusinessFunctions.selectItemFromListUsingText(driver, countryList,
						CoreFunctions.getRandomOutOfSelectedElementValueFromList(driver, countryList, valuesToIgnore));
			} else
				BusinessFunctions.selectItemFromListUsingText(driver, countryList, fieldValue);
			break;
		case MYLOConstants.STATE:
			CoreFunctions.explicitWaitTillElementListVisibility(driver, stateList);
			if (fieldValue.equals(MYLOConstants.RANDOM))
				CoreFunctions.selectItemInListByText(driver, stateList,
						CoreFunctions.getRandomElementValueFromList(driver, stateList));
			else
				CoreFunctions.selectItemInListByText(driver, stateList, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_TYPE:
			CoreFunctions.explicitWaitTillElementListVisibility(driver, typeDropDownList);
			if (fieldValue.equals(MYLOConstants.RANDOM))
				CoreFunctions.selectItemInListByText(driver, typeDropDownList,
						CoreFunctions.getRandomElementValueFromList(driver, typeDropDownList));
			else
				CoreFunctions.selectItemInListByText(driver, typeDropDownList, fieldValue);
			break;
		case MYLOConstants.MAIl_ADDRESS_TYPE:
			CoreFunctions.explicitWaitTillElementListVisibility(driver, typeDropDownList);
			if (fieldValue.equals(MYLOConstants.RANDOM))
				CoreFunctions.selectItemInListByText(driver, typeDropDownList,
						CoreFunctions.getRandomElementValueFromList(driver, typeDropDownList));
			else
				CoreFunctions.selectItemInListByText(driver, typeDropDownList, fieldValue);
			break;
		case MYLOConstants.TEMP_ADDRESS_CITY:
			try {
				updatedTempAddressCityValue = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, updatedTempAddressCityValue);
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedTempAddressCityValue = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, updatedTempAddressCityValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, fieldValue);
					updatedTempAddressCityValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_CITY:
			try {
				updatedMailAddressCityValue = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, updatedMailAddressCityValue);

			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedMailAddressCityValue = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, updatedMailAddressCityValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddCityValue, fieldValue);
					updatedMailAddressCityValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
			try {
				if (Integer.parseInt(fieldValue) < 100) {
					updatedTempAddressZipCodeValue = CoreFunctions
							.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, updatedTempAddressZipCodeValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, fieldValue);
					updatedTempAddressZipCodeValue = fieldValue;
				}
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedTempAddressZipCodeValue = CoreFunctions.generateRandomCharOfLength(4,
							MYLOConstants.SPECIAL_CHARACTERS_STRING,	
							2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, updatedTempAddressZipCodeValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, fieldValue);
					updatedTempAddressZipCodeValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
			try {
				if (Integer.parseInt(fieldValue) < 100) {
					updatedMailAddressZipCodeValue = CoreFunctions
							.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, updatedMailAddressZipCodeValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, fieldValue);
					updatedMailAddressZipCodeValue = fieldValue;
				}
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedMailAddressZipCodeValue = CoreFunctions.generateRandomCharOfLength(4,
							MYLOConstants.SPECIAL_CHARACTERS_STRING,2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, updatedMailAddressZipCodeValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddZipCodeValue, fieldValue);
					updatedMailAddressZipCodeValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_STATE:
			try {
				updatedTempAddressStateValue = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, updatedTempAddressStateValue);
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedTempAddressStateValue = CoreFunctions.generateRandomCharOfLength(4, MYLOConstants.SPECIAL_CHARACTERS_STRING,2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, updatedTempAddressStateValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, fieldValue);
					updatedTempAddressStateValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_STATE:
			try {
				updatedMailAddressStateValue = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, updatedMailAddressStateValue);

			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedMailAddressStateValue = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, updatedMailAddressStateValue);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddStateValue, fieldValue);
					updatedMailAddressStateValue = fieldValue;
				}
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
			try {
				updatedTempAddress1Value = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, updatedTempAddress1Value);
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedTempAddress1Value = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, updatedTempAddress1Value);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, fieldValue);
					updatedTempAddress1Value = fieldValue;
				}
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
			try {
				updatedMailAddress1Value = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, updatedMailAddress1Value);
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedMailAddress1Value = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, updatedMailAddress1Value);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress1Value, fieldValue);
					updatedMailAddress1Value = fieldValue;
				}
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
			try {
				updatedTempAddress2Value = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, updatedTempAddress2Value);
			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedTempAddress2Value = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, updatedTempAddress2Value);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, fieldValue);
					updatedTempAddress2Value = fieldValue;
				}
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
			try {
				updatedMailAddress2Value = CoreFunctions.generateRandomCharOfLength(Integer.parseInt(fieldValue),MYLOConstants.ONLY_CHARACTERS,0);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, updatedMailAddress2Value);

			} catch (NumberFormatException e) {
				if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
					updatedMailAddress2Value = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, updatedMailAddress2Value);
				} else {
					CoreFunctions.clearAndSetText(driver, _otherAddressaddAddress2Value, fieldValue);
					updatedMailAddress2Value = fieldValue;
				}
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_COMMENTS:
			if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
				updatedTempAddressCommentsValue = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING, 2);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCommentValue, updatedTempAddressCommentsValue);
			} else {
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCommentValue, fieldValue);
				updatedTempAddressCommentsValue = fieldValue;
			}
			break;
		case MYLOConstants.MAIL_ADDRESS_COMMENTS:
			if (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING)) {
				updatedMailAddressCommentsValue = CoreFunctions.generateRandomCharOfLength(4,MYLOConstants.SPECIAL_CHARACTERS_STRING
						,2);
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCommentValue, updatedMailAddressCommentsValue);
			} else {
				CoreFunctions.clearAndSetText(driver, _otherAddressaddCommentValue, fieldValue);
				updatedMailAddressCommentsValue = fieldValue;
			}
			break;
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
			if (fieldValue.equals("current")) {
				fieldValue = CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy");
			}
			CoreFunctions.clearAndSetText(driver, _otherAddressaddAddressFromDateValue, fieldValue);
			updatedTempAddressFromDateValue = fieldValue;
			break;
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			if (fieldValue.equals("current")) {
				fieldValue = CoreFunctions.getCurrentDateAsGivenFormat("MM/dd/yyyy");
			}
			CoreFunctions.clearAndSetText(driver, _otherAddressaddAddressFromDateValue, fieldValue);
			updatedMailAddressFromDateValue = fieldValue;
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
		switch (fieldName) {
		case MYLOConstants.STATE:
			return CoreFunctions.isElementExist(driver, _stateFieldTextType, 5);
		case MYLOConstants.TEMP_ADDRESS_STATE:
			return CoreFunctions.isElementExist(driver, _tempAddressStateTextField, 5);
		case MYLOConstants.MAIL_ADDRESS_STATE:
			return CoreFunctions.isElementExist(driver, _mailAddressStateTextField, 5);
		case MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN:
			return CoreFunctions.isElementExist(driver, _tempAddressDropdown, 5);
		case MYLOConstants.MAILING_ADDRESS_DROPDOWN:
			return CoreFunctions.isElementExist(driver, _mailAddressDropdown, 5);
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify whether field values got updated
	 */
	public boolean verifyUpdatedFieldValueOtherAddress(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.TEMP_ADDRESS_CITY:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddressCityValue));
		case MYLOConstants.MAIL_ADDRESS_CITY:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddressCityValue));
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddressZipCodeValue));
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddressZipCodeValue));
		case MYLOConstants.TEMP_ADDRESS_STATE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddressStateValue));
		case MYLOConstants.MAIL_ADDRESS_STATE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddressStateValue));
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddress1Value));
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddress1Value));
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddress2Value));
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddress2Value));
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedTempAddressFromDateValue));
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			return (getFieldValueAddressOnOtherAddressesSection(fieldName).equals(updatedMailAddressFromDateValue));
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return false;		
	}
	
	/**
	 * @param fieldName
	 * @return
	 * get the field value present on Other Address section
	 */
	public String getFieldValueAddressOnOtherAddressesSection(String fieldName) {
		switch (fieldName) {
		case MYLOConstants.TEMP_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressCountryValue, MYLOConstants.TEMP_ADDRESS_COUNTRY);
			CoreFunctions.highlightObject(driver, _tempAddressCountryValue);
			return CoreFunctions.getElementText(driver,_tempAddressCountryValue);
		case MYLOConstants.MAIl_ADDRESS_COUNTRY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressCountryValue, MYLOConstants.MAIl_ADDRESS_COUNTRY);
			CoreFunctions.highlightObject(driver, _mailAddressCountryValue);
			return CoreFunctions.getElementText(driver,_mailAddressCountryValue);
		case MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressStateDropdownValue, MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN);
			CoreFunctions.highlightObject(driver, _tempAddressStateDropdownValue);
			return CoreFunctions.getElementText(driver,_tempAddressStateDropdownValue);
		case MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressStateDropDownValue, MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN);
			CoreFunctions.highlightObject(driver, _mailAddressStateDropDownValue);
			return CoreFunctions.getElementText(driver,_mailAddressStateDropDownValue);
		case MYLOConstants.TEMP_ADDRESS_CITY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressCityValue, MYLOConstants.TEMP_ADDRESS_CITY);
			CoreFunctions.highlightObject(driver, _tempAddressCityValue);
			return CoreFunctions.getAttributeText( _tempAddressCityValue,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_CITY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressCityValue, MYLOConstants.MAIL_ADDRESS_CITY);
			CoreFunctions.highlightObject(driver, _tempAddressCountryValue);
			return CoreFunctions.getAttributeText(_mailAddressCityValue, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_ZIPCODE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressZipCodeValue, MYLOConstants.TEMP_ADDRESS_ZIPCODE);
			CoreFunctions.highlightObject(driver, _tempAddressZipCodeValue);
			return CoreFunctions.getAttributeText( _tempAddressZipCodeValue,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_ZIPCODE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressZipCodeValue, MYLOConstants.MAIL_ADDRESS_ZIPCODE);
			CoreFunctions.highlightObject(driver, _mailAddressZipCodeValue);
			return CoreFunctions.getAttributeText(_mailAddressZipCodeValue, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressStateValue, MYLOConstants.TEMP_ADDRESS_STATE);
			CoreFunctions.highlightObject(driver, _tempAddressStateValue);
			return CoreFunctions.getAttributeText( _tempAddressStateValue,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_STATE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressStateValue, MYLOConstants.MAIL_ADDRESS_STATE);
			CoreFunctions.highlightObject(driver, _mailAddressStateValue);
			return CoreFunctions.getAttributeText(_mailAddressStateValue, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_ADDRESS1:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddress1Value, MYLOConstants.TEMP_ADDRESS_ADDRESS1);
			CoreFunctions.highlightObject(driver, _tempAddress1Value);
			return CoreFunctions.getAttributeText( _tempAddress1Value,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_ADDRESS1:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddress1Value, MYLOConstants.MAIL_ADDRESS_ADDRESS1);
			CoreFunctions.highlightObject(driver, _mailAddress1Value);
			return CoreFunctions.getAttributeText(_mailAddress1Value, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_ADDRESS2:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddress2Value, MYLOConstants.TEMP_ADDRESS_ADDRESS2);
			CoreFunctions.highlightObject(driver, _tempAddress2Value);
			return CoreFunctions.getAttributeText( _tempAddress2Value,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_ADDRESS2:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddress2Value, MYLOConstants.MAIL_ADDRESS_ADDRESS2);
			CoreFunctions.highlightObject(driver, _mailAddress2Value);
			return CoreFunctions.getAttributeText(_mailAddress2Value, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_COMMENTS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressCommentsValue, MYLOConstants.TEMP_ADDRESS_COMMENTS);
			CoreFunctions.highlightObject(driver, _tempAddressCommentsValue);
			return CoreFunctions.getAttributeText( _tempAddressCommentsValue,MYLOConstants.VALUE);
		case MYLOConstants.MAIL_ADDRESS_COMMENTS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressCommentsValue, MYLOConstants.MAIL_ADDRESS_COMMENTS);
			CoreFunctions.highlightObject(driver, _mailAddressCommentsValue);
			return CoreFunctions.getAttributeText(_mailAddressCommentsValue, MYLOConstants.VALUE);
		case MYLOConstants.TEMP_ADDRESS_FROMDATE:
			String tempdateValue = null;
			CoreFunctions.explicitWaitTillElementVisibility(driver, _tempAddressFromDateValue, MYLOConstants.MAIL_ADDRESS_FROMDATE);
			CoreFunctions.highlightObject(driver, _tempAddressFromDateValue);
			try {
				tempdateValue=CoreFunctions.getStringDateInFormat(CoreFunctions.getAttributeText(_tempAddressFromDateValue, MYLOConstants.VALUE), "dd MMM yyyy", "MM/dd/yyyy");
			} catch (ParseException e) {
			}
			return tempdateValue;
		case MYLOConstants.MAIL_ADDRESS_FROMDATE:
			String dateValue = null;
			CoreFunctions.explicitWaitTillElementVisibility(driver, _mailAddressFromDateValue, MYLOConstants.MAIL_ADDRESS_FROMDATE);	
			CoreFunctions.highlightObject(driver, _mailAddressFromDateValue);
			try {
				dateValue=CoreFunctions.getStringDateInFormat(CoreFunctions.getAttributeText(_mailAddressFromDateValue, MYLOConstants.VALUE), "dd MMM yyyy", "MM/dd/yyyy");
			} catch (ParseException e) {
			}
			return dateValue;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
		return fieldName;
	}
	
	/**
	 * @param sectionType
	 * @param table
	 * @return
	 * Verify fieldValues on Different sections on Other Address
	 */
	public boolean verifyOtherAddressFieldValues(String sectionType, DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		try {
			if (sectionType.equals(MYLOConstants.MAILING_ADDRESS_DROPDOWN)) {
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIl_ADDRESS_COUNTRY),
						data.get(0).get(MYLOConstants.COUNTRY));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS1),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS1));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ADDRESS2),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ADDRESS2));
				Assert.assertEquals(
						getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_STATE_DROPDOWN));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_CITY),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_CITY));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_ZIPCODE),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_ZIPCODE));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_FROMDATE),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_FROMDATE));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.MAIL_ADDRESS_COMMENTS),
						data.get(0).get(MYLOConstants.MAIL_ADDRESS_COMMENTS));
			} else if (sectionType.equals(MYLOConstants.TEMPORARY_ADDRESS_DROPDOWN)) {
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COUNTRY),
						data.get(0).get(MYLOConstants.COUNTRY));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS1),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS1));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ADDRESS2),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ADDRESS2));
				Assert.assertEquals(
						getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_STATE_DROPDOWN));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_CITY),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_CITY));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_ZIPCODE),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_ZIPCODE));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_FROMDATE),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_FROMDATE));
				Assert.assertEquals(getFieldValueAddressOnOtherAddressesSection(MYLOConstants.TEMP_ADDRESS_COMMENTS),
						data.get(0).get(MYLOConstants.TEMP_ADDRESS_COMMENTS));
			}
			return true;
		} catch (Exception e) {
			return false;
		}
	}
	
	
	/**
	 * @param countryName
	 * @return
	 * get state list from json of corresponding country passed as a parameter
	 */
	public List<String> getMyoStatesByCountry(String countryName) {
		List<String> stateNames = new ArrayList<String>();
		switch (countryName) {
		case MYLOConstants.USA_STATE:
			List<MyloUSStates> myloUSStates = FileReaderManager.getInstance().getMyloJsonReader().getMyloUSStates();
			for (MyloUSStates myloUSStates2 : myloUSStates) {
				stateNames.add(myloUSStates2.value);
			}
			break;

		case MYLOConstants.CANADA_STATE:
			List<MyloCAStates> myloCAStates = FileReaderManager.getInstance().getMyloJsonReader().getMyloCAStates();
			for (MyloCAStates myloCAStates2 : myloCAStates) {
				stateNames.add(myloCAStates2.value);
			}
			break;
		case MYLOConstants.INDIA_STATE:
			List<MyloIndiaStates> myloIndiaStates = FileReaderManager.getInstance().getMyloJsonReader()
					.getMyloIndiaStates();
			stateNames.addAll(myloIndiaStates.stream().map(x -> x.value).collect(Collectors.toList()));
			break;

		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
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
		return copyStateList.equals(getMyoStatesByCountry(countryName));
	}
	
	/**
	 * @param msg
	 * @return
	 * Verify success message on Other Address section
	 */
	public boolean verifySuccessMessage(String msg) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _successMessage, _successMessage.getText());
			Assert.assertEquals(_successMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}
	
	public boolean verifyAlertMessage(String msg) {
		try {
			CoreFunctions.isElementVisible(_alertMessage);
			System.out.println(_alertMessage.getText());
			Assert.assertEquals(_alertMessage.getText(), msg);
		} catch (Throwable e) {
			return false;
		}
		return true;
	}
}