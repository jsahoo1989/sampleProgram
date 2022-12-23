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
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_DependentSection extends Base {
	
	public MyloJourneyPage_DependentSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.XPATH, using = "//a[text()='Add Dependent']")
	private WebElement _addDependentLink;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Gender']")
	private WebElement _dependentGender;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Title']")
	private WebElement _dependentRelationship;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Dest']")
	private WebElement _dependentDestination;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Citizenship']")
	private WebElement _dependentCitizenship;
	
	@FindBy(how = How.ID, using = "P_firstname")
	private WebElement _dependentFirstName;
	
	@FindBy(how = How.ID, using = "P_middlename")
	private WebElement _dependentMiddleName;
	
	@FindBy(how = How.ID, using = "P_lastname")
	private WebElement _dependentLastName;
	
	@FindBy(how = How.ID, using = "P_preferredname")
	private WebElement _dependentPreferredName;
	
	@FindBy(how = How.ID, using = "P_Suffix")
	private WebElement _dependentSuffix;
	
	@FindBy(how = How.ID, using = "P_MaidenName")
	private WebElement _dependentMaidenName;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Pronouns']")
	private WebElement _dependentPronouns;
	
	@FindBy(how = How.ID, using = "P_DOB")
	private WebElement _dependentDateOfBirth;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _dependentAddPhone;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _dependentAddEmail;
	
	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseOneTransferee']")
	private WebElement _transfereeAndFamilySection;
	
	@FindBy(how = How.CSS, using = "h2[class*='accchildhead']")
	private List<WebElement> _transfereeAndFamilySectionHeaders;
	
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _dependentSaveIcon;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _dependentSaveButton;
	
	@FindBy(how = How.CSS, using = "app-dependents i[class='icon-Pencil_Open']")
	private WebElement _dependentEditButton;
	
	@FindBy(how = How.CSS, using = "h2[id='headingChildFour'] button")
	private WebElement _expandDependentSection;
	
	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private List<WebElement> _dependentEmailTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type']")
	private List<WebElement> _dependentPhoneTypeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig']")
	private List<WebElement> _dependentPhoneOrgDestDropdown;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _dependentPhoneOrgDestDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='P_Type'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _dependentPhoneTypeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2'] span[class='ng-value-label ng-star-inserted']")
	private List<WebElement> _dependentEmailTypeDropdownValue;
	
	@FindBy(how = How.CSS, using = "input[id='P_Preferred']")
	private List<WebElement> _dependentPhonePreferred;

	@FindBy(how = How.CSS, using = "input[id='P_Preferred']+span")
	private List<WebElement> _dependentPhonePreferredSelect;
	
	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']")
	private List<WebElement> _dependentEmailPreferred;

	@FindBy(how = How.CSS, using = "input[id='T_Preferred2']+ span")
	private List<WebElement> _dependentEmailPreferredSelect;
	
	@FindBy(how = How.ID, using = "P_Number")
	private List<WebElement> _dependentPhoneNumber;

	@FindBy(how = How.ID, using = "T_Email")
	private List<WebElement> _dependentEmailAddress;
	
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm btn']")
	private WebElement _YesButton;
	
	final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	final By _genderDropdownOptions = By.cssSelector("div[role='option']>div");
	
	LinkedHashMap<String, WebElement> dependentWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<String>> dependentDropdownFieldOptions = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, String> dependentUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> dependentFieldCharacterLimitMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> dependentUpdatedDropdownFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<WebElement>> dependentPhoneEmailFieldsMap = new LinkedHashMap<String, List<WebElement>>();
	List<String> originDestOption = new ArrayList<String>();
	List<String> phoneTypeOption = new ArrayList<String>();
	List<String> emailTypeOption = new ArrayList<String>();
	
	/**
	 * Map all Dependent Web Elements with Name
	 */
	public void mapDependentWebElementFields() {
		dependentWebElementsMap.put(MYLOConstants.ADD_DEPENDENT_LINK, _addDependentLink);
		dependentWebElementsMap.put(MYLOConstants.GENDER, _dependentGender);
		dependentWebElementsMap.put(MYLOConstants.RELATIONSHIP, _dependentRelationship);
		dependentWebElementsMap.put(MYLOConstants.DESTINATION, _dependentDestination);
		dependentWebElementsMap.put(MYLOConstants.CITIZENSHIP, _dependentCitizenship);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_FIRSTNAME, _dependentFirstName);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_MIDDLENAME, _dependentMiddleName);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_LASTNAME, _dependentLastName);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_PREFERREDNAME, _dependentPreferredName);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_SUFFIX, _dependentSuffix);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_MAIDENNAME, _dependentMaidenName);
		dependentWebElementsMap.put(MYLOConstants.PRONOUNS, _dependentPronouns);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_DOB, _dependentDateOfBirth);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_ADD_PHONE, _dependentAddPhone);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_ADD_EMAIL, _dependentAddEmail);
		dependentWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _dependentEditButton);
		dependentWebElementsMap.put(MYLOConstants.DEPENDENT_DRODOWN_ARROW, _expandDependentSection);
		dependentWebElementsMap.put(MYLOConstants.YES_BUTTON, _YesButton);
		dependentWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _dependentSaveButton);
	}
	
	/**
	 * @param fieldName
	 * Click respective fields of Dependent section
	 */
	public void clickFieldsOnDependentSection(String fieldName) {
		mapDependentWebElementFields();
		try {
			WebElement element = dependentWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName,100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
	}
	
	public void saveDropdownListOptionsOnPartnerSection(String fieldName) {
		mapDependentWebElementFields();
		dependentDropdownFieldOptions.put(fieldName, returnDropDownOptionsList(dependentWebElementsMap.get(fieldName), fieldName));
	}
	
	/**
	 * @param element
	 * @param elementName
	 * @return
	 * It returns the list of all options available in Partner Dropdown field
	 */
	public List<String> returnDropDownOptionsList(WebElement element, String elementName) {
		List<String> requiredList = new ArrayList<String>();
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			CoreFunctions.highlightElementAndClick(driver, element, elementName);
			requiredList = (elementName.equals(MYLOConstants.GENDER))?CoreFunctions.getElementListByLocator(driver, _genderDropdownOptions).stream()
					.map(x -> x.getText()).collect(Collectors.toList()):CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream()
					.map(x -> x.getText()).collect(Collectors.toList());
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.DEPENDENT));
		}
		return requiredList;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify DropDownList values from Database
	 */
	public boolean verifyDependentFieldDropdownListOptions(String fieldName) {
		boolean flag = false;
		List<String> destinationOption = new ArrayList<String>();
		destinationOption.add("Yes");
		destinationOption.add("No");
		List<String> dependentRelationshipOption = new ArrayList<String>();
		dependentRelationshipOption.add("Child");
		dependentRelationshipOption.add("Parent");
		List<String> valuesFromUI = dependentDropdownFieldOptions.get(fieldName);
		valuesFromUI.remove(MYLOConstants.SELECT_ONE);
		valuesFromUI.remove(MYLOConstants.USA_STATE);
		try {
			flag=(fieldName.equals(MYLOConstants.DESTINATION))?destinationOption.equals(valuesFromUI):
				(fieldName.equals(MYLOConstants.RELATIONSHIP))?dependentRelationshipOption.equals(valuesFromUI):
					(fieldName.equals(MYLOConstants.CITIZENSHIP))?getCountryDBValues(fieldName).equals(valuesFromUI):
					DbFunctions.getTransfereeDropdownListValues(fieldName).equals(valuesFromUI);

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.DEPENDENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
		return flag;
	}
	
	public List<String> getCountryDBValues(String fieldName) {
		List<String> countryDBValues = DbFunctions.getTransfereeDropdownListValues(fieldName);
		countryDBValues.remove(MYLOConstants.USA_STATE);
		return countryDBValues;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner section
	 */
	public boolean verifyMandatoryFieldsToastMessagesDependentSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentFields(MYLOConstants.DEPENDENT_FIRSTNAME,
					data.get(i).get(MYLOConstants.DEPENDENT_FIRSTNAME));
			setDependentFields(MYLOConstants.DEPENDENT_LASTNAME, data.get(i).get(MYLOConstants.DEPENDENT_LASTNAME));
			clickDependentSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different fields on Dependent section
	 */
	public void setDependentFields(String fieldName, String fieldValue) {
		mapDependentWebElementFields();
		try {
			WebElement reqWebElement = dependentWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySectionHeaders.get(2),
						MYLOConstants.TRANSFEREE_FAMILY);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			dependentUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
	}
	
	/**
	 * Click on Partner Save button
	 */
	public void clickDependentSaveButton() {
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _dependentSaveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _dependentSaveIcon, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.DEPENDENT, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.SAVE_BUTTON, MYLOConstants.DEPENDENT, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * @param msg
	 * @param sectionType
	 * @return
	 * Verify Toast Messages appearing for Dependent Section
	 */
	public boolean verifyToastMessage(String msg, String sectionType) {
		return BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg, sectionType);
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Updated Values in respective fields of Dependent section
	 */
	public boolean verifyDifferentDependentFieldsUpdatedValue(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyDependentFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify Updated Values in respective fields of Partner section
	 */
	public boolean verifyDependentFieldsUpdatedValue(String fieldName) {
		boolean flag = false;
		mapDependentFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = dependentUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(dependentFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getDependentFields(fieldName).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.DEPENDENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		return flag;
	}
	
	/**
	 * Map all Character Limits with respective Fields
	 */
	public void mapDependentFieldsCharacterLimitMap() {
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_FIRSTNAME,
				MYLOConstants.PARTNER_FIRSTNAME_CHAR_LIMIT);
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_LASTNAME,
				MYLOConstants.PARTNER_LASTNAME_CHAR_LIMIT);
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_MIDDLENAME,
				MYLOConstants.PARTNER_MIDDLENAME_CHAR_LIMIT);
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_SUFFIX,
				MYLOConstants.PARTNER_SUFFIX_CHAR_LIMIT);
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_MAIDENNAME,
				MYLOConstants.PARTNER_MAIDENNAME_CHAR_LIMIT);
		dependentFieldCharacterLimitMap.put(MYLOConstants.DEPENDENT_PHONE_NUMBER,
				MYLOConstants.PARTNER_PHONE_NUMBER_CHAR_LIMIT);
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Get the Field Value of all Fields available on Partner section
	 */
	public String getDependentFields(String fieldName) {
		mapDependentWebElementFields();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.RELATIONSHIP);
		dropdownFields.add(MYLOConstants.CITIZENSHIP);
		dropdownFields.add(MYLOConstants.GENDER);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, dependentWebElementsMap.get(fieldName), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, dependentWebElementsMap.get(fieldName))
					: CoreFunctions.getAttributeText(dependentWebElementsMap.get(fieldName),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		return requiredValue;
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Special Characters entered in fields of Partner section
	 */
	public boolean verifySpecialCharacterToastMessagesDependentSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			setDependentFields(fieldName, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickDependentSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
			clickToastMesssgeCloseIcon();
			setDependentFields(fieldName, MYLOConstants.TEST);
		}
		return flag;
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
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.DEPENDENT, MYLOConstants.JOURNEY));
			Assert.fail(MessageFormat.format(MYLOConstants.BUTTON_NOT_PRESENT, CoreConstants.FAIL,
					MYLOConstants.CLOSE_BUTTON, MYLOConstants.DEPENDENT, MYLOConstants.JOURNEY));
		}
	}
	
	/**
	 * @param elementName
	 * Scroll to respective element of Dependent Fields 
	 */
	public void scrollToDependentElement(String elementName) {
		mapDependentWebElementFields();
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, dependentWebElementsMap.get(elementName),
					elementName);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, elementName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.DEPENDENT));
		}
	}
	
	/**
	 * @param table
	 * @param buttonName
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Dependent Phone/Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesDependentPhoneEmailSection(DataTable table, String buttonName) {
		boolean flag = false;
		flag = (buttonName.equals(MYLOConstants.DEPENDENT_ADD_PHONE))
				? verifyMandatoryFieldsToastMessagesDependentPhoneSection(table)
				: verifyMandatoryFieldsToastMessagesDependentEmailSection(table);
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Partner Email section
	 */
	public boolean verifyMandatoryFieldsToastMessagesDependentEmailSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentPhoneEmailFields(MYLOConstants.DEPENDENT_EMAIL_ADDRESS,
					data.get(i).get(MYLOConstants.DEPENDENT_EMAIL_ADDRESS), 0);
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_EMAIL_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.DEPENDENT_EMAIL_TYPE));
			clickDependentSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * 	Verify Toast Messages for Mandatory Fields of Dependent Phone section
	 */
	public boolean verifyMandatoryFieldsToastMessagesDependentPhoneSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentPhoneEmailFields(MYLOConstants.DEPENDENT_PHONE_NUMBER,
					data.get(i).get(MYLOConstants.DEPENDENT_PHONE_NUMBER), 0);
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_ORGDEST, 0);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_ORGDEST,
					data.get(i).get(MYLOConstants.DEPENDENT_ORGDEST));
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_PHONE_TYPE, 0);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_PHONE_TYPE,
					data.get(i).get(MYLOConstants.DEPENDENT_PHONE_TYPE));
			clickDependentSaveButton();
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	/**
	 * @param elementName
	 * @param index
	 * Click respective dropdown fields of Dependent section
	 */
	public void clickDropdownFieldsOnDependentSection(String elementName, int index) {
		CoreFunctions.scrollToElementUsingJavaScript(driver, _dependentPreferredName, MYLOConstants.DEPENDENT_PREFERREDNAME);
		switch (elementName) {
		case MYLOConstants.DEPENDENT_ORGDEST:
			originDestOption = returnDropDownOptionsList(_dependentPhoneOrgDestDropdown.get(index), elementName);
			break;
		case MYLOConstants.DEPENDENT_PHONE_TYPE:
			phoneTypeOption = returnDropDownOptionsList(_dependentPhoneTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.DEPENDENT_EMAIL_TYPE:
			emailTypeOption = returnDropDownOptionsList(_dependentEmailTypeDropdown.get(index), elementName);
			break;
		case MYLOConstants.DEPENDENT_PHONE_PREFERRED:
			CoreFunctions.click(driver, _dependentPhonePreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.DEPENDENT_EMAIL_PREFERRED:
			CoreFunctions.scrollToElementUsingJavaScript(driver,_dependentCitizenship ,
					MYLOConstants.CITIZENSHIP);
			CoreFunctions.click(driver, _dependentEmailPreferredSelect.get(index), elementName);
			break;
		case MYLOConstants.RELATIONSHIP:
			CoreFunctions.click(driver, _dependentRelationship, elementName);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * Set Value of different dropdown fields on Dependent section
	 */
	public void setDifferentDropDownFields(String fieldName, String fieldValue) {
		String updatedValue = null;
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = BusinessFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			dependentUpdatedDropdownFieldValuesMap.put(fieldName, updatedValue);
			dependentUpdatedFieldValuesMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
	}
	
	/**
	 * @param fieldName
	 * @param fieldValue
	 * @param index
	 * Set Value of different Phone/Email fields on Dependent section
	 */
	public void setDependentPhoneEmailFields(String fieldName, String fieldValue, int index) {
		mapDependentPhoneEmailField();
		try {
			WebElement reqWebElement = dependentPhoneEmailFieldsMap.get(fieldName).get(index);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			if (fieldValue.equals(""))
				CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySectionHeaders.get(2),
						MYLOConstants.DEPENDENT);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			dependentUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
	}
	
	/**
	 * Map all Dependent Phone/Email Field Values
	 */
	public void mapDependentPhoneEmailField() {
		dependentPhoneEmailFieldsMap.put(MYLOConstants.DEPENDENT_PHONE_NUMBER, _dependentPhoneNumber);
		dependentPhoneEmailFieldsMap.put(MYLOConstants.DEPENDENT_ORGDEST, _dependentPhoneOrgDestDropdownValue);
		dependentPhoneEmailFieldsMap.put(MYLOConstants.DEPENDENT_PHONE_TYPE, _dependentPhoneTypeDropdownValue);
		dependentPhoneEmailFieldsMap.put(MYLOConstants.DEPENDENT_EMAIL_ADDRESS, _dependentEmailAddress);
		dependentPhoneEmailFieldsMap.put(MYLOConstants.DEPENDENT_EMAIL_TYPE, _dependentEmailTypeDropdownValue);
	}

	/**
	 * @param table
	 * @param buttonName
	 * Set Value of all Phone/Email fields on Dependent section
	 */
	public void setFieldsDependentPhoneEmailSection(DataTable table, String buttonName) {
		if (buttonName.equals(MYLOConstants.DEPENDENT_ADD_PHONE))
			setMandatoryFieldsDependentPhoneSection(table, 0);
		else
			setMandatoryFieldsDependentEmailSection(table, 0);
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Email fields on Partner section
	 */
	public void setMandatoryFieldsDependentEmailSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.FIELD_VALUE), index);
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_EMAIL_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_EMAIL_TYPE,
					data.get(i).get(MYLOConstants.DEPENDENT_EMAIL_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * Set Value of all Phone fields on Partner section
	 */
	public void setMandatoryFieldsDependentPhoneSection(DataTable table, int index) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentPhoneEmailFields(data.get(i).get(MYLOConstants.FIELD_NAME),
					data.get(i).get(MYLOConstants.CHARACTER_LENGTH), index);
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_ORGDEST, index);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_ORGDEST,
					data.get(i).get(MYLOConstants.DEPENDENT_ORGDEST));
			clickDropdownFieldsOnDependentSection(MYLOConstants.DEPENDENT_PHONE_TYPE, index);
			setDifferentDropDownFields(MYLOConstants.DEPENDENT_PHONE_TYPE,
					data.get(i).get(MYLOConstants.DEPENDENT_PHONE_TYPE));
		}
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Phone section
	 */
	public boolean verifyDifferentDependentPhoneFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = (verifyDependentPhoneFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Dependent Phone section
	 */
	public boolean verifyDependentPhoneFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		mapDependentFieldsCharacterLimitMap();
		String updatedValue = null;
		try {
			updatedValue = dependentUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(dependentFieldCharacterLimitMap.get(fieldName));
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getDependentPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.DEPENDENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Get the Field Value of all Phone/Email Fields available on Dependent section
	 */
	public String getDependentPhoneEmailFields(String fieldName, int index) {
		mapDependentPhoneEmailField();
		String requiredValue = null;
		List<String> dropdownFields = new ArrayList<String>();
		dropdownFields.add(MYLOConstants.DEPENDENT_EMAIL_TYPE);
		dropdownFields.add(MYLOConstants.DEPENDENT_PHONE_TYPE);
		dropdownFields.add(MYLOConstants.DEPENDENT_ORGDEST);
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver,
					dependentPhoneEmailFieldsMap.get(fieldName).get(index), fieldName);
			requiredValue = (dropdownFields.contains(fieldName))
					? CoreFunctions.getElementText(driver, dependentPhoneEmailFieldsMap.get(fieldName).get(index))
					: CoreFunctions.getAttributeText(dependentPhoneEmailFieldsMap.get(fieldName).get(index),
							MYLOConstants.TITLE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		return requiredValue;
	}
	
	/**
	 * @param table
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyDifferentDependentEmailFieldsUpdatedValue(DataTable table, int index) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag = ((verifyDependentEmailFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME), index)));
		}
		return flag;
	}
	
	/**
	 * @param fieldName
	 * @param index
	 * @return
	 * Verify Updated Values in respective fields of Partner Email section
	 */
	public boolean verifyDependentEmailFieldsUpdatedValue(String fieldName, int index) {
		boolean flag = false;
		String updatedValue = null;
		try {
			updatedValue = dependentUpdatedFieldValuesMap.get(fieldName);
			flag = getDependentPhoneEmailFields(fieldName, index).equals(updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.DEPENDENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.DEPENDENT));
		return flag;
	}
	
	/**
	 * @param section
	 * @param index
	 * @param number
	 * @return
	 * Check whether Preferred checkbox is selected for Dependent Phone/Email section
	 */
	public boolean isPreferredChecked(String section, int index, String number) {
		boolean flag=false;
		try {
			flag = (section.equals(MYLOConstants.DEPENDENT_PHONE_NUMBER))
					? _dependentPhonePreferred.get(index).isSelected()
					: _dependentEmailPreferred.get(index).isSelected();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, section, MYLOConstants.DEPENDENT));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					section, MYLOConstants.DEPENDENT));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_CHECKBOX_NOT_SELECTED, CoreConstants.PASS,
					number, MYLOConstants.PREFERRED, section, MYLOConstants.DEPENDENT));
		return flag;
	}
	
	/**
	 * @param table
	 * @return
	 * Verify Toast Messages for Mandatory Fields of Dependent section
	 */
	public boolean verifyMandatoryToastMessageNewDependentSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setDependentFields(MYLOConstants.DEPENDENT_FIRSTNAME,
					data.get(i).get(MYLOConstants.DEPENDENT_FIRSTNAME));
			setDependentFields(MYLOConstants.DEPENDENT_LASTNAME, data.get(i).get(MYLOConstants.DEPENDENT_LASTNAME));
			clickFieldsOnDependentSection(MYLOConstants.SAVE_BUTTON);
			flag = (verifyToastMessage(data.get(i).get(MYLOConstants.MESSAGE), MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}

}
