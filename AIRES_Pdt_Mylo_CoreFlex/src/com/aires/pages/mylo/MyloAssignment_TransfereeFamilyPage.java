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

public class MyloAssignment_TransfereeFamilyPage extends Base {
	
	public MyloAssignment_TransfereeFamilyPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//button[text()=' Transferee & Family ']/span")
	private WebElement _transfereeFamilyDetailsButton;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapsechildOne']")
	private WebElement _expandTransfereeSection;

	@FindBy(how = How.XPATH, using = "//app-transferee-family/descendant::button[@aria-controls='collapseTwo']")
	private WebElement _transfereeAndFamilySection;

	@FindBy(how = How.CSS, using = "h2[class='accchildhead']")
	private List<WebElement> _transfereeAndFamilySectionHeaders;

	@FindBy(how = How.XPATH, using = "//app-tf-transferee-form//label[text()='Edit']")
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
	
	@FindBy(how = How.ID, using = "T_Title")
	private WebElement _transfereeTitle;
	
	@FindBy(how = How.ID, using = "T_MaidenName")
	private WebElement _transfereeMaidenName;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_marritalstatus']")
	private WebElement _transfereeMaritalStatusDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Pronouns']")
	private WebElement _transfereePronounsDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Citizenship']")
	private WebElement _transfereeCitizenshipDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private List<WebElement> _transfereeEmailTypeDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Type']")
	private List<WebElement> _transfereePhoneTypeDropdown;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Orig']")
	private List<WebElement> _transfereePhoneOrgDestDropdown;
			
	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;
	
	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _transfereeSaveBtn;	
	
	@FindBy(how = How.XPATH, using = "//button[contains(@class,'toast-close-btn')]")
	private WebElement _closeBtn;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _transfereeAddPhone;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _transfereeAddEmail;
	
	
	final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	
	List<String> maritalStatusOption = new ArrayList<String>();
	List<String> pronounOption = new ArrayList<String>();
	List<String> citizenshipOption = new ArrayList<String>();
	List<String> originDestOption = new ArrayList<String>();
	List<String> phoneTypeOption = new ArrayList<String>();
	List<String> emailTypeOption = new ArrayList<String>();
	
	LinkedHashMap<String, List<String>> transfereeFieldsDropDownValuesMap = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, WebElement> transfereeWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> transfereeUpdatedFieldValuesMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> transfereeFieldCharacterLimitMap = new LinkedHashMap<String, String>();
	
	
	public void highlightSectionHeader(String sectionName) {
		switch (sectionName) {
		case MYLOConstants.TRANSFEREE_FAMILY:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAndFamilySection,
					sectionName);
			CoreFunctions.highlightObject(driver, _transfereeAndFamilySection);
			break;
		case MYLOConstants.TRANSFEREE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAndFamilySectionHeaders.get(0),
					sectionName);
			CoreFunctions.highlightObject(driver, _transfereeAndFamilySectionHeaders.get(0));
			System.out.println(_transfereeAndFamilySectionHeaders.get(0).getText());
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_SECTION_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_SECTION_NAME);
		}
	}

	public void clickElementOnTransfereeSection(String elementName) {
		switch (elementName) {
		case MYLOConstants.TRANSFEREE_DRODOWN_ARROW:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _expandTransfereeSection,
					elementName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _expandTransfereeSection, elementName);
			break;
		case MYLOConstants.TRANSFEREE_FAMILY_DETAILS_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeFamilyDetailsButton,
					elementName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _transfereeFamilyDetailsButton, elementName);
			break;
		case MYLOConstants.EDIT_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeEditButton, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeEditButton, elementName);
			break;
		case MYLOConstants.TRANSFEREE_ADD_PHONE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAddPhone, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeAddPhone, elementName);
			break;
		case MYLOConstants.TRANSFEREE_ADD_EMAIL:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeAddEmail, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeAddEmail, elementName);
			break;
		case MYLOConstants.SAVE_BUTTON:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeSaveBtn, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeSaveBtn, elementName);
			break;
		case MYLOConstants.CLOSE_BUTTON:
			CoreFunctions.isElementVisible(_closeBtn);
			CoreFunctions.highlightObject(driver, _closeBtn);
			CoreFunctions.sendKeysUsingAction(driver, _closeBtn, elementName);
			break;
		case MYLOConstants.MARITAL_STATUS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeMaritalStatusDropdown, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeMaritalStatusDropdown, elementName);
			maritalStatusOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			maritalStatusOption.remove(MYLOConstants.SELECT_ONE);
			break;
		case MYLOConstants.PRONOUNS:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereePronounsDropdown, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereePronounsDropdown, elementName);
			pronounOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			pronounOption.remove(MYLOConstants.SELECT_ONE);
			break;
		case MYLOConstants.CITIZENSHIP:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeCitizenshipDropdown, elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeCitizenshipDropdown, elementName);
			citizenshipOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			citizenshipOption.remove(MYLOConstants.SELECT_ONE);
			citizenshipOption.remove(MYLOConstants.USA_STATE);
			break;
		case MYLOConstants.ORIGIN_DEST:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereePhoneOrgDestDropdown.get(0), elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereePhoneOrgDestDropdown.get(0), elementName);
			originDestOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			originDestOption.remove(MYLOConstants.SELECT_ONE);
			break;
		case MYLOConstants.PHONE_TYPE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereePhoneTypeDropdown.get(0), elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereePhoneTypeDropdown.get(0), elementName);
			phoneTypeOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			phoneTypeOption.remove(MYLOConstants.SELECT_ONE);
			break;
		case MYLOConstants.EMAIL_TYPE:
			CoreFunctions.explicitWaitTillElementVisibility(driver, _transfereeEmailTypeDropdown.get(0), elementName);
			CoreFunctions.highlightElementAndClick(driver, _transfereeEmailTypeDropdown.get(0), elementName);
			emailTypeOption = CoreFunctions.getElementListByLocator(driver, _dropdownOptions).stream().map(x -> x.getText()).collect(Collectors.toList());
			emailTypeOption.remove(MYLOConstants.SELECT_ONE);
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_ELEMENT_NAME);
		}
	}

	public boolean verifyMandatoryFieldsToastMessagesTransfereeSection(DataTable table) {
		boolean flag = false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			setTransfereeFields(MYLOConstants.TRANSFEREE_FIRSTNAME,data.get(i).get(MYLOConstants.TRANSFEREE_FIRSTNAME));
			setTransfereeFields(MYLOConstants.TRANSFEREE_LASTNAME,data.get(i).get(MYLOConstants.TRANSFEREE_LASTNAME));
			clickElementOnTransfereeSection(MYLOConstants.SAVE_BUTTON);
			flag=(verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE),MYLOConstants.TRANSFEREE_FAMILY));
		}
		return flag;
	}
	
	public boolean verifySpecialCharacterToastMessagesTransfereeSection(DataTable table) {
		boolean flag=false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName=data.get(i).get(MYLOConstants.FIELD_NAME);
			setTransfereeFields(fieldName,MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickElementOnTransfereeSection(MYLOConstants.SAVE_BUTTON);
			flag = (verifyAlertMessage(data.get(i).get(MYLOConstants.MESSAGE),MYLOConstants.TRANSFEREE_FAMILY));
			clickElementOnTransfereeSection(MYLOConstants.CLOSE_BUTTON);
			setTransfereeFields(fieldName, MYLOConstants.TEST);
		}
		return flag;
	}

	public boolean verifyDifferentTransfereeFieldsUpdatedValue(DataTable table) {
		boolean flag=false;
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			flag=(verifyTransfereeFieldsUpdatedValue(data.get(i).get(MYLOConstants.FIELD_NAME)));
		}
		return flag;
	}
	
	public void mapTransfereeWebElementFields() {
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME, _transfereeFirstName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_LASTNAME, _transfereeLastName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_MIDDLENAME, _transfereeMiddleName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_SUFFIX, _transfereeSuffix);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_GRADE, _transfereeGrade);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_MAIDEN_NAME, _transfereeMaidenName);
		transfereeWebElementsMap.put(MYLOConstants.TRANSFEREE_TITLE, _transfereeTitle);
	}
	
	public void mapTransfereeFieldsCharacterLimitMap() {
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_FIRSTNAME, MYLOConstants.TRANSFEREE_FIRSTNAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_LASTNAME,MYLOConstants.TRANSFEREE_LASTNAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_MIDDLENAME, MYLOConstants.TRANSFEREE_MIDDLENAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_SUFFIX,MYLOConstants.TRANSFEREE_SUFFIX_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_GRADE,MYLOConstants.TRANSFEREE_GRADE_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_MAIDEN_NAME, MYLOConstants.TRANSFEREE_MAIDEN_NAME_CHAR_LIMIT);
		transfereeFieldCharacterLimitMap.put(MYLOConstants.TRANSFEREE_TITLE,MYLOConstants.TRANSFEREE_TITLE_CHAR_LIMIT);
	}
	
	public void setTransfereeFields(String fieldName,String fieldValue) {
		mapTransfereeWebElementFields();
		WebElement reqWebElement = transfereeWebElementsMap.get(fieldName);
		CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement,
				fieldName);
		String setValue=CoreFunctions.setDifferentFieldsForMylo(driver,reqWebElement, fieldName, fieldValue);
		transfereeUpdatedFieldValuesMap.put(fieldName, setValue);
	}
	
	public String getTransfereeFields(String fieldName) {
		mapTransfereeWebElementFields();
		CoreFunctions.explicitWaitTillElementVisibility(driver, transfereeWebElementsMap.get(fieldName),
				fieldName);
		return CoreFunctions.getAttributeText(transfereeWebElementsMap.get(fieldName), MYLOConstants.TITLE);
	}
	
	public boolean verifyTransfereeFieldsUpdatedValue(String fieldName) {
		boolean flag=false;
		mapTransfereeFieldsCharacterLimitMap();
		String updatedValue = transfereeUpdatedFieldValuesMap.get(fieldName);
		int fieldCharLimit = Integer.parseInt(transfereeFieldCharacterLimitMap.get(fieldName));
		updatedValue = updatedValue.length()>fieldCharLimit?updatedValue.substring(0, fieldCharLimit):updatedValue;
		flag= getTransfereeFields(fieldName).equals(updatedValue);
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}
	
	public boolean verifyAlertMessage(String msg, String sectionType) {
		boolean flag = false;
		try {
			CoreFunctions.isElementVisible(_alertMessage);
			CoreFunctions.highlightObject(driver, _alertMessage);
			flag = (_alertMessage.getText().equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
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
	
	public void mapTableColumnFields() {
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.MARITAL_STATUS, maritalStatusOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.PRONOUNS, pronounOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.CITIZENSHIP, citizenshipOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.EMAIL_TYPE, emailTypeOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.PHONE_TYPE, phoneTypeOption);
		transfereeFieldsDropDownValuesMap.put(MYLOConstants.ORIGIN_DEST, originDestOption);
		
	}
	
	public boolean verifyFieldDropdownListValues(String fieldName) {
		mapTableColumnFields();
		boolean flag = false;
		List<String> dropdownListValuesFromDB = DbFunctions.getTransfereeDropdownListValues(fieldName);
		if (fieldName.equals(MYLOConstants.CITIZENSHIP))
			dropdownListValuesFromDB.remove(MYLOConstants.USA_STATE);
		flag = (dropdownListValuesFromDB.equals(transfereeFieldsDropDownValuesMap.get(fieldName))) ? true : false;
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.TRANSFEREE));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE));
		return flag;
	}
}
