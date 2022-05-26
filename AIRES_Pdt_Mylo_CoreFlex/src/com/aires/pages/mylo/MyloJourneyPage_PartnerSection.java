package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
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

public class MyloJourneyPage_PartnerSection extends Base {
	
	public MyloJourneyPage_PartnerSection(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "#partnerList+div a")
	private WebElement _addPartnerLink;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Gender']")
	private WebElement _partnerGender;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Title']")
	private WebElement _partnerRelationship;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Dest']")
	private WebElement _partnerNewDestination;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Citizenship']")
	private WebElement _partnerCitizenship;
	
	@FindBy(how = How.ID, using = "P_firstname")
	private WebElement _partnerFirstName;
	
	@FindBy(how = How.ID, using = "P_middlename")
	private WebElement _partnerMiddleName;
	
	@FindBy(how = How.ID, using = "P_lastname")
	private WebElement _partnerLastName;
	
	@FindBy(how = How.ID, using = "P_Suffix")
	private WebElement _partnerSuffix;
	
	@FindBy(how = How.ID, using = "P_MaidenName")
	private WebElement _partnerMaidenName;
	
	@FindBy(how = How.ID, using = "P_preferredname")
	private WebElement _partnerPreferredName;
	
	@FindBy(how = How.CSS, using = "ng-select[name='P_Pronouns']")
	private WebElement _partnerPronouns;
	
	@FindBy(how = How.ID, using = "P_Age")
	private WebElement _partnerAge;
	
	@FindBy(how = How.ID, using = "P_DOB")
	private WebElement _partnerDateOfBirth;
	
	@FindBy(how = How.XPATH, using = "//a[text()=' Add Phone ']")
	private WebElement _partnerAddPhone;

	@FindBy(how = How.XPATH, using = "//a[text()=' Add Email ']")
	private WebElement _partnerAddEmail;
	
	final By _dropdownOptions = By.cssSelector("div[role='option']>span");
	final By _genderDropdownOptions = By.cssSelector("div[role='option']>div");
	
	LinkedHashMap<String, WebElement> partnerWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, List<String>> partnerDropdownFieldOptions = new LinkedHashMap<String, List<String>>();
	
	/**
	 * Map all Partner Web Elements with Name
	 */
	public void mapPartnerWebElementFields() {
		partnerWebElementsMap.put(MYLOConstants.ADD_PARTNER_LINK, _addPartnerLink);
		partnerWebElementsMap.put(MYLOConstants.GENDER, _partnerGender);
		partnerWebElementsMap.put(MYLOConstants.RELATIONSHIP, _partnerRelationship);
		partnerWebElementsMap.put(MYLOConstants.NEW_DESTINATION, _partnerNewDestination);
		partnerWebElementsMap.put(MYLOConstants.CITIZENSHIP, _partnerCitizenship);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_FIRSTNAME, _partnerFirstName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_MIDDLENAME, _partnerMiddleName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_LASTNAME, _partnerLastName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_SUFFIX, _partnerSuffix);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_MAIDENNAME, _partnerMaidenName);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_PREFERREDNAME, _partnerPreferredName);
		partnerWebElementsMap.put(MYLOConstants.PRONOUNS, _partnerPronouns);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_AGE, _partnerAge);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_DOB, _partnerDateOfBirth);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_ADD_PHONE, _partnerAddPhone);
		partnerWebElementsMap.put(MYLOConstants.PARTNER_ADD_EMAIL, _partnerAddEmail);
	}
	
	/**
	 * @param fieldName
	 * Click respective fields of Partner section
	 */
	public void clickFieldsOnPartnerSection(String fieldName) {
		mapPartnerWebElementFields();
		try {
			WebElement element = partnerWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, fieldName,100);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
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
					CoreConstants.FAIL, elementName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					elementName, MYLOConstants.PARTNER));
		}
		return requiredList;
	}
	
	
	public void saveDropdownListOptionsOnPartnerSection(String fieldName) {
		mapPartnerWebElementFields();
		partnerDropdownFieldOptions.put(fieldName, returnDropDownOptionsList(partnerWebElementsMap.get(fieldName), fieldName));
	}
	
	/**
	 * @param fieldName
	 * @return
	 * Verify DropDownList values from Database
	 */
	public boolean verifyPartnerFieldDropdownListOptions(String fieldName) {
		boolean flag = false;
		List<String> destinationOption = new ArrayList<String>();
		destinationOption.add("Yes");
		destinationOption.add("No");
		List<String> countryList = partnerDropdownFieldOptions.get(fieldName);
		 for (String country : countryList) {
				System.out.println(country);
			}
		try {	
			flag=(fieldName.equals(MYLOConstants.NEW_DESTINATION))?destinationOption.equals(partnerDropdownFieldOptions.get(fieldName)):
				DbFunctions.getTransfereeDropdownListValues(fieldName).equals(partnerDropdownFieldOptions.get(fieldName));
						
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.PARTNER));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCH, CoreConstants.PASS,
					fieldName, MYLOConstants.PARTNER));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MISMATCH,
					CoreConstants.FAIL, fieldName, MYLOConstants.PARTNER));
		return flag;
	}

}
