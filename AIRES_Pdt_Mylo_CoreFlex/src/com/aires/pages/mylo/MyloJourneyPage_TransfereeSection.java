package com.aires.pages.mylo;

import java.text.MessageFormat;
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
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_TransfereeSection extends Base {

	public MyloJourneyPage_TransfereeSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "app-transferee-family button span")
	private WebElement _transfereeFamilyDetailsButton;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsechildOne']")
	private WebElement _expandTransfereeSection;

	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseTwo']")
	private WebElement _transfereeAndFamilySection;

	@FindBy(how = How.CSS, using = "h2[class*='accchildhead']")
	private List<WebElement> _transfereeAndFamilySectionHeaders;

	@FindBy(how = How.CSS, using = "app-transferee i[class='icon-Pencil_Open']")
	private WebElement _transfereeEditButton;

	@FindBy(how = How.ID, using = "T_firstname")
	private WebElement _transfereeFirstName;

	@FindBy(how = How.ID, using = "T_lastname")
	private WebElement _transfereeLastName;

	@FindBy(how = How.ID, using = "T_middlename")
	private WebElement _transfereeMiddleName;

	@FindBy(how = How.ID, using = "T_Suffix")
	private WebElement _transfereeSuffix;

	@FindBy(how = How.ID, using = "T_Grade")
	private WebElement _transfereeGrade;

	@FindBy(how = How.ID, using = "T_preferredname")
	private WebElement _transfereePreferredName;

	@FindBy(how = How.ID, using = "T_Title")
	private WebElement _transfereeTitle;
	
	@FindBy(how = How.ID, using = "T_DOB")
	private WebElement _transfereeDateOfBirth;
	
	@FindBy(how = How.ID, using = "T_MaidenName")
	private WebElement _transfereeMaidenName;
	
	@FindBy(how = How.ID, using = "T_Age")
	private WebElement _transfereeAge;

	@FindBy(how = How.ID, using = "P_Number")
	private List<WebElement> _transfereePhoneNumber;

	@FindBy(how = How.ID, using = "T_Email")
	private List<WebElement> _transfereeEmailAddress;

	@FindBy(how = How.CSS, using = "ng-select[name='T_marritalstatus']")
	private WebElement _transfereeMaritalStatusDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_marritalstatus'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _transfereeMaritalStatusDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Pronouns']")
	private WebElement _transfereePronounsDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Citizenship']")
	private WebElement _transfereeCitizenshipDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Citizenship'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _transfereeCitizenshipDropdownValue;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Gender']")
	private WebElement _transfereeGenderDropDown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Gender'] span[class='ng-value-label ng-star-inserted']")
	private WebElement _transfereeGenderDropDownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private List<WebElement> _transfereeEmailTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type']")
	private List<WebElement> _transfereePhoneTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig']")
	private List<WebElement> _transfereePhoneOrgDestDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _transfereePhoneOrgDestDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _transfereePhoneTypeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _transfereeEmailTypeDropdownValue;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _transfereeSaveBtn;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;

	@FindBy(how = How.CSS, using = "i[class='icon-Trash_Open trashimg']")
	private List<WebElement> _deleteIcon;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _transfereeAddPhone;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _transfereeAddEmail;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm btn']")
	private WebElement _YesButton;

	@FindBy(how = How.CSS, using = "input[id='P_Preferred']")
	private List<WebElement> _transfereePhonePreferred;

	@FindBy(how = How.CSS, using = "input[id='P_Preferred']+span")
	private List<WebElement> _transfereePhonePreferredSelect;

	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']")
	private List<WebElement> _transfereeEmailPreferred;

	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']+ span")
	private List<WebElement> _transfereeEmailPreferredSelect;

	final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	final By _genderDropdownOptions = By.cssSelector("div[role='option']>div");
	

	List<String> maritalStatusOption = new ArrayList<String>();
	List<String> pronounOption = new ArrayList<String>();
	List<String> citizenshipOption = new ArrayList<String>();
	List<String> originDestOption = new ArrayList<String>();
	List<String> phoneTypeOption = new ArrayList<String>();
	List<String> emailTypeOption = new ArrayList<String>();

	LinkedHashMap<String, List<String>> transfereeFieldsDropDownValuesMap = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, List<WebElement>> transfereePhoneEmailFieldsMap = new LinkedHashMap<String, List<WebElement>>();
	LinkedHashMap<String, WebElement> transfereeWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> transfereeUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> transfereeUpdatedDropdownFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> transfereeFieldCharacterLimitMap = new LinkedHashMap<String, String>();

	/**
	 * Map all Transferee Web Elements with Name
	 */
	public void mapTransfereeWebElementFields() {
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME, _transfereeFirstName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_LASTNAME, _transfereeLastName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_MIDDLENAME, _transfereeMiddleName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_SUFFIX, _transfereeSuffix);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_GRADE, _transfereeGrade);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_MAIDEN_NAME, _transfereeMaidenName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_TITLE, _transfereeTitle);
		transfereeWebElementsMap.put(MYLOConstants.DATEOFBIRTH, _transfereeDateOfBirth);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_PREFERREDNAME, _transfereePreferredName);
		transfereeWebElementsMap.put(MYLOConstants.MARITAL_STATUS, _transfereeMaritalStatusDropdownValue);
		transfereeWebElementsMap.put(MYLOConstants.CITIZENSHIP, _transfereeCitizenshipDropdownValue);
		transfereeWebElementsMap.put(MYLOConstants.GENDER, _transfereeGenderDropDownValue);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_DRODOWN_ARROW, _expandTransfereeSection);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON, _transfereeFamilyDetailsButton);
		transfereeWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _transfereeEditButton);
		transfereeWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_ADD_PHONE, _transfereeAddPhone);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_ADD_EMAIL, _transfereeAddEmail);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_ADD_EMAIL, _transfereeAddEmail);
	}

	/**
	 * Map all Character Limits with respective Fields
	 */
	public void mapTransfereeFieldsCharacterLimitMap() {
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME,
				MYLOConstants.TRANSFEREE_FIRSTNAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_LASTNAME,
				MYLOConstants.TRANSFEREE_LASTNAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_MIDDLENAME,
				MYLOConstants.TRANSFEREE_MIDDLENAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_SUFFIX,
				MYLOConstants.TRANSFEREE_SUFFIX_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_GRADE, MYLOConstants.TRANSFEREE_GRADE_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_MAIDEN_NAME,
				MYLOConstants.TRANSFEREE_MAIDEN_NAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_TITLE, MYLOConstants.TRANSFEREE_TITLE_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_PHONE_NUMBER,
				MYLOConstants.TRANSFEREE_PHONE_NUMBER_CHAR_LIMIT);
	}

	/**
	 * Map all Transferee Phone/Email Field Values
	 */
	public void mapTransfereePhoneEmailField() {
		transfereePhoneEmailFieldsMap.put(MYLOConstants.TRANSFEREE_PHONE_NUMBER, _transfereePhoneNumber);
		transfereePhoneEmailFieldsMap.put(MYLOConstants.TRANSFEREE_ORGDEST, _transfereePhoneOrgDestDropdownValue);
		transfereePhoneEmailFieldsMap.put(MYLOConstants.TRANSFEREE_PHONE_TYPE, _transfereePhoneTypeDropdownValue);
		transfereePhoneEmailFieldsMap.put(MYLOConstants.TRANSFEREE_EMAIL_ADDRESS, _transfereeEmailAddress);
		transfereePhoneEmailFieldsMap.put(MYLOConstants.TRANSFEREE_EMAIL_TYPE, _transfereeEmailTypeDropdownValue);
	}

	/**
	 * Map all OptionList with respective transferee dropdown fields
	 */
	public void mapDropdownFieldOptions() {
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.MARITAL_STATUS, maritalStatusOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.PRONOUNS, pronounOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.CITIZENSHIP, citizenshipOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.TRANSFEREE_EMAIL_TYPE, emailTypeOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.TRANSFEREE_PHONE_TYPE, phoneTypeOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.TRANSFEREE_ORGDEST, originDestOption);
	}

	/**
	 * @param sectionName
	 * @return
	 * Highlight and Verify Transferee & Family Section Header Text
	 */
	public boolean verifySectionHeader(String sectionName) {
		boolean flag = false;
		switch (sectionName) {
		case MYLOConstants.TRANSFEREE_FAMILY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAndFamilySection, sectionName);
			CoreFunctions.highlightObject(driver, _transfereeAndFamilySection);
			flag = (_transfereeAndFamilySection.getText().contains(MYLOConstants.TRANSFEREE_FAMILY));
			break;
		case MYLOConstants.TRANSFEREE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAndFamilySectionHeaders.get(0),
					sectionName);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.highlightObject(driver, _transfereeAndFamilySectionHeaders.get(0));
			flag = (_transfereeAndFamilySectionHeaders.get(0).getText().contains(MYLOConstants.TRANSFEREE_FAMILY));
			break;
		case MYLOConstants.PARTNER:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAndFamilySectionHeaders.get(1),
					sectionName);
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.highlightObject(driver, _transfereeAndFamilySectionHeaders.get(1));
			flag = (_transfereeAndFamilySectionHeaders.get(1).getText().equals(sectionName+MYLOConstants.COLON));
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_SECTION_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_SECTION_NAME);
		}
		return flag;
	}

	/**
	 * @param elementName
	 * Scroll to respective element of transferee Fields 
	 */
	public void scrollToTransfereeElement(String elementName) {
		mapTransfereeWebElementFields();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, transfereeWebElementsMap.get(elementName),
					elementName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * @param fieldName
	 * Click respective fields of Transferee section
	 */
	public void clickFieldsOnTransfereeSection(String fieldName) {
		mapTransfereeWebElementFields();
		try {
			WebElement element = transfereeWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName,100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * @param elementName
	 * @param index
	 * Click respective dropdown fields of Transferee section
	 */
	public void clickDropdownFieldsOnTransfereeSection(String elementName, int index) {
		switch (elementName) {
		case MYLOConstants.MARITAL_STATUS:
			maritalStatusOption = returnDropDownOptionsList(_transfereeMaritalStatusDropdown, elementName);
			break;
		case MYLOConstants.PRONOUNS:
			pronounOption = returnDropDownOptionsList(_transfereePronounsDropdown, elementName);
			break;
		case MYLOConstants.CITIZENSHIP:
			citizenshipOption = returnDropDownOptionsList(_transfereeCitizenshipDropdown, elementName);
			break;
		case MYLOConstants.TRANSFEREE_ORGDEST:
			originDestOption = returnDropDownOptionsList(_transfereePhoneOrgDestDropdown.get(index), elementName);
			break;
		case MYLOConstants.TRANSFEREE_PHONE_TYPE:
			phoneTypeOption = returnDropDownOptionsList(_transfereePhoneTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.TRANSFEREE_EMAIL_TYPE:
			emailTypeOption = returnDropDownOptionsList(_transfereeEmailTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.TRANSFEREE_PHONE_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeTitle, MYLOConstants.TRANSFEREE_TITLE);
			CoreFunctions.click(driver, _transfereePhonePreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.TRANSFEREE_EMAIL_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeTitle, MYLOConstants.TRANSFEREE_TITLE);
			CoreFunctions.click(driver, _transfereeEmailPreferredSelect.get(index), elementName);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}

	/**
	 * Click on Close Icon of Toast Message
	 */
	public void clickToastMesssgeCloseIcon() {
		try {
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, MYLOConstants.CLOSE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
		}
	}

	/**
	 * Click on Transferee Save button
	 */
	public void clickTransfereeSaveButton() {
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeSaveBtn, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _transfereeSaveBtn, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
		}
	}

	/**
	 * @param index
	 * Click on respective Delete icon of Transferee Email & Phone section
	 */
	public void clickDeleteIcon(int index) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _deleteIcon.get(index),
					MYLOConstants.DELETE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _deleteIcon.get(index), MYLOConstants.DELETE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.DELETE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.DELETE_BUTTON, MYLOConstants.TRANSFEREE_FAMILY, MYLOConstants.JOURNEY));
		}
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different fields on Transferee section
	 */
	public void setTransfereeFields(String fieldName, String fieldValue) {
		mapTransfereeWebElementFields();
		try {
			WebElement reqWebElement = transfereeWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
						MYLOConstants.TRANSFEREE_FAMILY);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			transfereeUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different dropdown fields on Transferee section
	 */
	public void setDifferentDropDownFields(String fieldName, String fieldValue) {
		String updatedValue = null;
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = CoreFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			transfereeUpdatedDropdownFieldValuesMap.put(fieldName, updatedValue);
			transfereeUpdatedFieldValuesMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * @param fieldName
	 * @param fieldValue
	 * @param index
	 * Set Value of different Phone/Email fields on Transferee section
	 */
	public void setTransfereePhoneEmailFields(String fieldName, String fieldValue, int index) {
		mapTransfereePhoneEmailField();
		try {
			WebElement reqWebElement = transfereePhoneEmailFieldsMap.get(fieldName).get(index);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
						MYLOConstants.TRANSFEREE_FAMILY);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			transfereeUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
	}

	/**
	 * @param table
	 * @param index
	 * Set Value of all Phone fields on Transferee section
	 */
	public void setMandatoryFieldsTransfereePhoneSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereePhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH), index);
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_ORGDEST, index);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_ORGDEST,
					data.get(i).get(MYLOConstants.TRANSFEREE_ORGDEST));
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_PHONE_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_PHONE_TYPE,
					data.get(i).get(MYLOConstants.TRANSFEREE_PHONE_TYPE));
		}
	}

	/**
	 * @param table
	 * @param index
	 * Set Value of all Email fields on Transferee section
	 */
	public void setMandatoryFieldsTransfereeEmailSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereePhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.FIELD_VALUE), index);
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_EMAIL_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.TRANSFEREE_EMAIL_TYPE));
		}
	}

	/**
	 * @param table
	 * @param buttonName
	 * Set Value of all Phone/Email fields on Transferee section
	 */
	public void setFieldsTransfereePhoneEmailSection(DataTable table, String buttonName) {
		if (buttonName.equals(MYLOConstants.TRANSFEREE_ADD_PHONE))
			setMandatoryFieldsTransfereePhoneSection(table, 0);
		else
			setMandatoryFieldsTransfereeEmailSection(table, 0);
	}

	/**
	 * @param element
	 * @param elementName
	 * @return
	 * It returns the list off all options available in passed Dropdown field
	 */
	public List<String> returnDropDownOptionsList(WebElement element, String elementName) {
		List<String> requiredList = new ArrayList<String>();
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			CoreFunctions.highlightElementAndClick(driver, element, elementName);
			requiredList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream()
					.map(x -> x.getText()).collect(Collectors.toList());
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.TRANSFEREE));
		}
		return requiredList;
	}

	/**
	 * @param fieldName
	 * @return
	 * Get the Field Value of all Fields available on Transferee section
	 */
	public String getTransfereeFields(String fieldName) {
		mapTransfereeWebElementFields();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.MARITAL_STATUS);
		dropdownFields.add(MYLOConstants.PRONOUNS);
		dropdownFields.add(MYLOConstants.CITIZENSHIP);
		dropdownFields.add(MYLOConstants.GENDER);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, transfereeWebElementsMap.get(fieldName), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, transfereeWebElementsMap.get(fieldName))
					: CoreFunctions.getAttributeText(transfereeWebElementsMap.get(fieldName),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		return requiredValue;
	}

	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Get the Field Value of all Phone/Email Fields available on Transferee section
	 */
	public String getTransfereePhoneEmailFields(String fieldName, int index) {
		mapTransfereePhoneEmailField();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.TRANSFEREE_EMAIL_TYPE);
		dropdownFields.add(MYLOConstants.TRANSFEREE_PHONE_TYPE);
		dropdownFields.add(MYLOConstants.TRANSFEREE_ORGDEST);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver,
					transfereePhoneEmailFieldsMap.get(fieldName).get(index), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, transfereePhoneEmailFieldsMap.get(fieldName).get(index))
					: CoreFunctions.getAttributeText(transfereePhoneEmailFieldsMap.get(fieldName).get(index),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		return requiredValue;
	}

	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Transferee section
	 */
	public boolean verifyMandatoryFieldsToastMessagesTransfereeSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereeFields(MYLOConstants.TRANSFEREE_FIRSTNAME,
					data.get(i).get(MYLOConstants.TRANSFEREE_FIRSTNAME));
			setTransfereeFields(MYLOConstants.TRANSFEREE_LASTNAME, data.get(i).get(MYLOConstants.TRANSFEREE_LASTNAME));
			clickTransfereeSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}

	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Special Characters entered in fields of Transferee section
	 */
	public boolean verifySpecialCharacterToastMessagesTransfereeSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			setTransfereeFields(fieldName, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickTransfereeSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
			clickToastMesssgeCloseIcon();
			setTransfereeFields(fieldName, MYLOConstants.TEST);
		}
		return flag;
	}

	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Mandatory Fields of Transferee Phone section
	 */
	public boolean verifyMandatoryFieldsToastMessagesTransfereePhoneSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereePhoneEmailFields(MYLOConstants.TRANSFEREE_PHONE_NUMBER,
					data.get(i).get(MYLOConstants.TRANSFEREE_PHONE_NUMBER), 0);
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_ORGDEST, 0);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_ORGDEST,
					data.get(i).get(MYLOConstants.TRANSFEREE_ORGDEST));
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_PHONE_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_PHONE_TYPE,
					data.get(i).get(MYLOConstants.TRANSFEREE_PHONE_TYPE));
			clickTransfereeSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}

	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Transferee Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesTransfereeEmailSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereePhoneEmailFields(MYLOConstants.TRANSFEREE_EMAIL_ADDRESS,
					data.get(i).get(MYLOConstants.TRANSFEREE_EMAIL_ADDRESS), 0);
			clickDropdownFieldsOnTransfereeSection(MYLOConstants.TRANSFEREE_EMAIL_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.TRANSFEREE_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.TRANSFEREE_EMAIL_TYPE));
			clickTransfereeSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}

	/**
	 * @param table
	 * @param buttonName
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Transferee Phone/Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesTransfereePhoneEmailSection(DataTable table, String buttonName) {
		boolean flag = false;
		flag = (buttonName.equals(MYLOConstants.TRANSFEREE_ADD_PHONE))
				? verifyMandatoryFieldsToastMessagesTransfereePhoneSection(table)
				: verifyMandatoryFieldsToastMessagesTransfereeEmailSection(table);
		return flag;
	}

	/**
	 * @param fieldName
	 * @return
	 * Verify Updated Values in respective fields of Transferee section
	 */
	public boolean verifyTransfereeFieldsUpdatedValue(String fieldName) {
		boolean flag = false;
		mapTransfereeFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = transfereeUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(transfereeFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getTransfereeFields(fieldName).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}

	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Transferee Phone section
	 */
	public boolean verifyTransfereePhoneFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		mapTransfereeFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = transfereeUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(transfereeFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getTransfereePhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}

	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Transferee Email section
	 */
	public boolean verifyTransfereeEmailFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		String updatedValue = null;
		try {
			updatedValue = transfereeUpdatedFieldValuesMap.get(fieldName);
			flag = getTransfereePhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}

	/**
	 * @param table
	 * @return
	 * Verify Updated Values in respective fields of Transferee section
	 */
	public boolean verifyDifferentTransfereeFieldsUpdatedValue(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyTransfereeFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}

	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Transferee Phone section
	 */
	public boolean verifyDifferentTransfereePhoneFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyTransfereePhoneFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index));
		}
		return flag;
	}

	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Transferee Email section
	 */
	public boolean verifyDifferentTransfereeEmailFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = ((verifyTransfereeEmailFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index)));
		}
		return flag;
	}

	/**
	 * @param msg
	 * @param sectionType
	 * @return
	 * Verify Toast Messages appearing for Transferee Section
	 */
	public boolean verifyToastMessage(String msg, String sectionType) {
		boolean flag = false;
		try {
			CoreFunctions.isElementVisible(_alertMessage);
			CoreFunctions.highlightObject(driver, _alertMessage);
			flag = (_alertMessage.getText().equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.ALERT_MESSAGE, sectionType));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.JOURNEY));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					_alertMessage.getText(), MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * @param fieldName
	 * @return
	 * Verify DropDownList values from Database
	 */
	public boolean verifyFieldDropdownListValuesFromDB(String fieldName) {
		mapDropdownFieldOptions();
		boolean flag = false;
		try {
			List<String> dropdownListValuesFromDB = DbFunctions.getTransfereeDropdownListValues(fieldName);
			List<String> dropdownListFromUI = transfereeFieldsDropDownValuesMap.get(fieldName);
			dropdownListFromUI.remove(MYLOConstants.SELECT_ONE);
			if (fieldName.equals(MYLOConstants.CITIZENSHIP)) {
				dropdownListValuesFromDB.remove(MYLOConstants.USA_STATE);
				dropdownListFromUI.remove(MYLOConstants.USA_STATE);
			}
			flag = (dropdownListValuesFromDB.equals(dropdownListFromUI)) ? true : false;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}

	/**
	 * @param section
	 * @param index
	 * @param number
	 * @return
	 * Check whether Preferred checkbox is selected for Transferee Phone/Email section
	 */
	public boolean isPreferredChecked(String section, int index, String number) {
		boolean flag=false;
		try {
			flag = (section.equals(MYLOConstants.TRANSFEREE_PHONE_NUMBER))
					? _transfereePhonePreferred.get(index).isSelected()
					: _transfereeEmailPreferred.get(index).isSelected();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, section, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					section, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.TRANSFEREE));
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 */
	public boolean verifyDifferentTransfereeFieldsValue(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyTransfereeFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * @return
	 * Verify Existing Values on Different fields in Transferee section
	 */
	public boolean verifyExistingValuesInTransfereeSection(String fieldName, String fieldValue) {
		boolean flag = false;
		flag = (fieldValue.contentEquals(getTransfereeFields(fieldName)));
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, fieldValue, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;

	}
	
	/**
	 * @param msg
	 * @return
	 * Verify Hover Message for Gender X
	 */
	public boolean getGenderXHoverMessage(String msg) {
		boolean flag = false;
		try {
			clickFieldsOnTransfereeSection(MYLOConstants.GENDER);
			List<WebElement> genderOptions = CoreFunctions.getElementListByLocator(driver, _genderDropdownOptions);
			WebElement genderXWebElement = CoreFunctions.returnItemInListByText(driver, genderOptions, MYLOConstants.GENDER_X);
			CoreFunctions.hover(driver, genderXWebElement);
			flag = genderXWebElement.getAttribute(MYLOConstants.TITLE).equals(msg);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_HOVER_MESSAGE_ON_SECTION,
					CoreConstants.FAIL, msg, MYLOConstants.TRANSFEREE));
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_VERIFY_HOVER_MESSAGE_ON_SECTION, CoreConstants.FAIL,
					msg, MYLOConstants.TRANSFEREE));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_HOVER_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_HOVER_MESSAGE_NOT_DISPLAYED, CoreConstants.FAIL,
					msg, MYLOConstants.TRANSFEREE));
		return flag;

	}
}
