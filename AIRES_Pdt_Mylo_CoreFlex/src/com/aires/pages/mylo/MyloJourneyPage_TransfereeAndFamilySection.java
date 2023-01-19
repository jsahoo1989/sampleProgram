package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.List;
import java.util.Map;

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

import cucumber.api.DataTable;

public class MyloJourneyPage_TransfereeAndFamilySection extends Base {

	public MyloJourneyPage_TransfereeAndFamilySection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div#accordionExampleTransferee a")
	private List<WebElement> _addTransfereeAndFamilyLinks;
	
	@FindBy(how = How.CSS, using = "app-transferee-family h2[class*='accchildhead']")
	private List<WebElement> _addTransfereeAndFamilyHeaders;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup input")
	private List<WebElement> _addTransfereeInput;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup ng-select")
	private List<WebElement> _addTransfereeDropDown;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup div[role='option']")
	private List<WebElement> _addTransfereeDropDownOptions;

	@FindBy(how = How.CSS, using = "i[class='icon-FloppyDisk_Open']")
	private WebElement _saveIcon;

	@FindBy(how = How.CSS, using = "app-transferee-family-add-popup  button[class*='submit']")
	private WebElement _saveButton;

	@FindBy(how = How.CSS, using = "app-partner i[class='icon-Pencil_Open']")
	private WebElement _partnerEditButton;

	@FindBy(how = How.CSS, using = "app-dependents i[class='icon-Pencil_Open']")
	private WebElement _dependentEditButton;

	@FindBy(how = How.CSS, using = "app-others i[class='icon-Pencil_Open']")
	private WebElement _otherEditButton;

	@FindBy(how = How.CSS, using = "app-transferee-family input")
	private List<WebElement> _editTransfereeInput;

	@FindBy(how = How.CSS, using = "app-transferee-family ng-select")
	private List<WebElement> _editTransfereeDropDown;

	@FindBy(how = How.CSS, using = "app-transferee-family div[role='option']")
	private List<WebElement> _editTransfereeDropDownOptions;

	@FindBy(how = How.CSS, using = "ng-select[name='T_Type2']")
	private WebElement _emailTypeDropdown;

	@FindBy(how = How.CSS, using = "app-transferee-family button[aria-controls='collapseOneTransferee']")
	private WebElement _transfereeAndFamilySection;

	/**
	 * add transferee
	 * 
	 * @param table
	 */
	public void addTransfereeAndFamily(DataTable table) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			switch (data.get("Member")) {
			case (MYLOConstants.PARTNER):
				addPartnerWithMandatoryFields(data.get("Relationship"));
				break;
			case (MYLOConstants.DEPENDENT):
				addDependentWithMandatoryFields(data.get("Relationship"));
				break;
			case (MYLOConstants.OTHER):
				addOtherMemberWithMandatoryFields(data.get("Relationship"));
			}
		}
	}

	/**
	 * Add Partner
	 * 
	 * @param relationship
	 */
	public void addPartnerWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_PARTNER_LINK);
			enterRandomFirstNameAndLastName();
			selectValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_PARTNER, relationship));
		}
	}

	/**
	 * Add Dependent
	 * 
	 * @param relationship
	 */
	public void addDependentWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_DEPENDENT_LINK);
			enterRandomFirstNameAndLastName();
			selectValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_DEPENDENT, relationship));
		}
	}

	/**
	 * Add Other Member
	 * 
	 * @param relationship
	 */
	public void addOtherMemberWithMandatoryFields(String relationship) {
		try {
			clickAddLink(MYLOConstants.ADD_OTHER_LINK);
			enterRandomFirstNameAndLastName();
			enterText(MYLOConstants.TITLE, MYLOConstants.OTHER);
			clickSaveOnAddMemberPopup();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ADD_OTHER_MEMBER, relationship));
		}
	}

	/**
	 * Enter first Name and Last on Add Member Popup
	 */
	public void enterRandomFirstNameAndLastName() {
		enterText(MYLOConstants.FIRST_NAME, CoreFunctions.generateRandomString(5));
		enterText(MYLOConstants.LAST_NAME, CoreFunctions.generateRandomString(5));
	}

	/**
	 * Click Save On Add member Popup
	 */
	public void clickSaveOnAddMemberPopup() {
		try {
			CoreFunctions.click(driver, _saveButton, MYLOConstants.SAVE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SAVE_BUTTON));
		}
	}

	/**
	 * add transferee and family based on member
	 * 
	 * @param member
	 */
	public void addTransfereeAndFamily(String member) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		switch (member) {
		case (MYLOConstants.PARTNER):
			addPartnerWithMandatoryFields(MYLOConstants.DOMESTIC_PARTNER);
			break;
		case (MYLOConstants.DEPENDENT):
			addDependentWithMandatoryFields(MYLOConstants.PARENT);
			break;
		case (MYLOConstants.OTHER):
			addOtherMemberWithMandatoryFields(MYLOConstants.OTHER);
		}
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);

	}

	/**
	 * Click Add Links on transferee and Family Section
	 * 
	 * @param linkName
	 */
	private void clickAddLink(String linkName) {
		try {		
			WebElement scrollElement = CoreFunctions.returnItemInListByText(driver, _addTransfereeAndFamilyHeaders, linkName.replaceAll(MYLOConstants.ADD_BUTTON, ""));
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_addTransfereeAndFamilyLinks, linkName, MYLOConstants.TEXT);
			CoreFunctions.scrollToElementUsingJS(driver, scrollElement, linkName);
			CoreFunctions.click(driver, fieldElement, linkName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_CLICK_LINK, linkName));
		}
	}

	/**
	 * Enter Text in text box on add popup
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void enterText(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver, _addTransfereeInput,
					fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.clearAndSetText(driver, fieldElement, fieldValue, MYLOConstants.TRUE);
			CoreFunctions.waitHandler(MYLOConstants.WAIT_5SECS);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, fieldName));
		}
	}

	/**
	 * select drop down values on add popup
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void selectValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_addTransfereeDropDown, fieldName, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.waitHandler(MYLOConstants.WAIT_5SECS);
			CoreFunctions.selectItemInListByText(driver, _addTransfereeDropDownOptions, fieldValue, MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * Enter text in input fields in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void enterTextEditTransfereeFamily(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeInput, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.clearAndSetText(driver, fieldElement, fieldValue, MYLOConstants.TRUE);
			CoreFunctions.waitHandler(MYLOConstants.WAIT_5SECS);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, fieldName));
		}
	}

	/**
	 * select drop down values in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void editValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, fieldName, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.waitHandler(MYLOConstants.WAIT_5SECS);
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, fieldValue,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * select phone/email value from drop down in edit mode
	 * 
	 * @param fieldName
	 * @param fieldValue
	 */
	private void selectPhoneEmailValueFromDropdown(String fieldName, String fieldValue) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, fieldElement, fieldName);
			CoreFunctions.click(driver, fieldElement, fieldName);
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, fieldValue,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_VALUE_FROM_DROPDOWN, fieldName));
		}
	}

	/**
	 * Update tranferee and family details
	 * 
	 * @param member
	 * @param table
	 */
	public void updateFields(String member, DataTable table) {
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.scrollClickUsingJS(driver, _partnerEditButton, MYLOConstants.EDIT_BUTTON);
			editFirstNameLastName(MYLOConstants.FIRST_NAME_TEST, MYLOConstants.LAST_NAME_TEST);
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editPartnerOrDependentRelationship(MYLOConstants.SPOUSE);
			addPhoneDetails();
			addEmailDetails(MYLOConstants.SPOUSE_PERSONAL);
			clickSaveInEditMember();
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.scrollClickUsingJS(driver, _dependentEditButton, MYLOConstants.EDIT_BUTTON);
			editFirstNameLastName(MYLOConstants.FIRST_NAME_TEST, MYLOConstants.LAST_NAME_TEST);
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editPartnerOrDependentRelationship(MYLOConstants.CHILD);
			addPhoneDetails();
			addEmailDetails(MYLOConstants.OTHER);
			clickSaveInEditMember();
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.scrollClickUsingJS(driver, _otherEditButton, MYLOConstants.EDIT_BUTTON);
			editFirstNameLastName(MYLOConstants.FIRST_NAME_TEST, MYLOConstants.LAST_NAME_TEST);
			editPronoun(MYLOConstants.PREFER_NOT_TO_ANSWER);
			editOtherRelationship(MYLOConstants.OTHER_EDIT);
			addPhoneDetailsInOther();
			addEmailDetailsInOther();
			clickSaveInEditMember();
			break;
		}
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
	}

	/**
	 * edit first and last name
	 */
	public void editFirstNameLastName(String firstName, String lastName) {
		enterTextEditTransfereeFamily(MYLOConstants.FIRST_NAME, firstName);
		enterTextEditTransfereeFamily(MYLOConstants.LAST_NAME, lastName);
	}

	/**
	 * edit pronoun
	 */
	public void editPronoun(String pronoun) {
		try {
			editValueFromDropdown(MYLOConstants.PRONOUN_FORM_CONTROL, pronoun);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.PRONOUNS));
		}
	}

	/**
	 * Edit partner relationship
	 * 
	 * @param relationship
	 */
	public void editPartnerOrDependentRelationship(String relationship) {
		try {
			editValueFromDropdown(MYLOConstants.RELATIONSHIP_FORM_CONTROL, relationship);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.RELATIONSHIP));
		}
	}

	/**
	 * Edit Other Relationship
	 * 
	 * @param relationship
	 */
	public void editOtherRelationship(String relationship) {
		try {
			enterTextEditTransfereeFamily(MYLOConstants.TITLE, relationship);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_TEXT, MYLOConstants.RELATIONSHIP));
		}
	}

	/**
	 * add Phone Details
	 */
	public void addPhoneDetails() {
		try {
			clickAddLink(MYLOConstants.ADD_PHONE);
			enterTextEditTransfereeFamily(MYLOConstants.NUMBER, MYLOConstants.PHONE_NUMBER_TEST);
			selectPhoneEmailValueFromDropdown(MYLOConstants.ORIG_DEST, MYLOConstants.ORIGIN);
			selectPhoneEmailValueFromDropdown(MYLOConstants.TYPE, MYLOConstants.CELL_PHONE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.PHONE_DETAILS));
		}
	}

	/**
	 * add Email details
	 */
	public void addEmailDetails(String emailType) {
		try {
			clickAddLink(MYLOConstants.ADD_EMAIL);
			enterTextEditTransfereeFamily(MYLOConstants.EMAIL_ADDRESS, MYLOConstants.EMAIL_ADDRESS_TEST);
			CoreFunctions.click(driver, _emailTypeDropdown, MYLOConstants.EMAIL_TYPE_COLUMN);
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, emailType,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.EMAIL_DETAILS));
		}
	}

	/**
	 * add phone details in Other
	 */
	public void addPhoneDetailsInOther() {
		try {
			
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, MYLOConstants.CITIZENSHIP, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.scrollToElementUsingJavaScript(driver, fieldElement, MYLOConstants.CITIZENSHIP);
			clickAddLink(MYLOConstants.ADD_PHONE);
			selectPhoneEmailValueFromDropdown(MYLOConstants.ORIG_DEST, MYLOConstants.ORIGIN);
			selectPhoneEmailValueFromDropdown(MYLOConstants.TYPE, MYLOConstants.CELL_PHONE);
			enterTextEditTransfereeFamily(MYLOConstants.NUMBER, MYLOConstants.PHONE_NUMBER_TEST);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.PHONE_DETAILS));
		}
	}

	/**
	 * add email details in other
	 */
	public void addEmailDetailsInOther() {
		try {
			
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_editTransfereeDropDown, MYLOConstants.CITIZENSHIP, MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.scrollToElementUsingJavaScript(driver, fieldElement, MYLOConstants.CITIZENSHIP);
			clickAddLink(MYLOConstants.ADD_EMAIL);
			enterTextEditTransfereeFamily(MYLOConstants.EMAIL_ADDRESS, MYLOConstants.EMAIL_ADDRESS_TEST);
			CoreFunctions.click(driver, _emailTypeDropdown, MYLOConstants.EMAIL_TYPE_COLUMN);
			CoreFunctions.waitHandler(MYLOConstants.WAIT_5SECS);
			CoreFunctions.selectItemInListByText(driver, _editTransfereeDropDownOptions, MYLOConstants.OTHER,
					MYLOConstants.TRUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_ENTER_VALUES, MYLOConstants.EMAIL_DETAILS));
		}
	}

	/**
	 * Click Save in Edit member
	 */
	public void clickSaveInEditMember() {
		try {
			CoreFunctions.scrollToElementUsingJavaScript(driver, _transfereeAndFamilySection,
					MYLOConstants.TRANSFEREE_FAMILY);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _saveIcon, MYLOConstants.SAVE_BUTTON);
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 180);
			CoreFunctions.highlightElementAndClick(driver, _saveIcon, MYLOConstants.SAVE_BUTTON);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SAVE_BUTTON));
		}
	}
}
