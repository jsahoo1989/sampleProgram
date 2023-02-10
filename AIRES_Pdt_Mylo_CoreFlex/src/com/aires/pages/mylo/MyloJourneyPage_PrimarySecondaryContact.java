package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;
import java.util.List;

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
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

public class MyloJourneyPage_PrimarySecondaryContact extends Base {

	public MyloJourneyPage_PrimarySecondaryContact(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "app-primary-contact")
	private WebElement _primaryContactSection;

	@FindBy(how = How.CSS, using = "button[aria-controls='collapseOneContact']")
	private WebElement _expandPrimaryContactSection;

	@FindBy(how = How.CSS, using = "div#secondaryContact a")
	private List<WebElement> _secondaryContactSectionLinks;

	@FindBy(how = How.CSS, using = "mat-dialog-container[class*='mat-dialog']")
	private WebElement _selectContactPopup;

	@FindBy(how = How.CSS, using = "app-add-contact-popup button")
	private List<WebElement> _selectContactButtons;

	@FindBy(how = How.CSS, using = "div[class*='primary-secondry-card']")
	private List<WebElement> _contactListOnPopup;

	@FindBy(how = How.CSS, using = "p[class*='contact-card-blue']")
	private List<WebElement> _contactNameOnPopup;

	@FindBy(how = How.CSS, using = "div[class='custom-radio']")
	private List<WebElement> _contactRadioButtonsOnPopup;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='usertitle']")
	private WebElement _selectedSecondaryContactName;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='userdesignation']")
	private WebElement _selectedSecondaryContactRelationship;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='user-role'] div[class*='title']")
	private WebElement _selectedSecondaryContactPronoun;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='userphnumber']")
	private WebElement _selectedSecondaryContactPhoneNumber;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] div[class*='usermailid']")
	private WebElement _selectedSecondaryContactEmail;

	@FindBy(how = How.CSS, using = "div[class*='mylo-errorpopup']")
	private WebElement _errorDialog;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _errorDialogHeader;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogOkButton;

	@FindBy(how = How.CSS, using = "div[id='secondaryContact'] span")
	private List<WebElement> _secondaryContactCardButtons;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='usertitle']")
	private WebElement _selectedPrimaryContactName;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='userdesignation']")
	private WebElement _selectedPrimaryContactRelationship;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='user-role'] div[class*='title']")
	private WebElement _selectedPrimaryContactPronoun;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='userphnumber']")
	private WebElement _selectedPrimaryContactPhoneNumber;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] div[class*='usermailid']")
	private WebElement _selectedPrimaryContactEmail;

	@FindBy(how = How.CSS, using = "div[id='primaryContact'] button")
	private WebElement _primaryContactChangeButton;

	@FindBy(how = How.CSS, using = "p[class*='contact-card-blue']")
	private List<WebElement> _selectPrimaryContactText;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	private boolean _isExists = false;
	LinkedHashMap<String, String> primaryContactfieldValueMapping = new LinkedHashMap<String, String>();
	LinkedHashMap<String, String> secondaryContactfieldValueMapping = new LinkedHashMap<String, String>();

	/**
	 * Verify if error dialog is displayed
	 * 
	 */
	public void verifySecondaryErrorDialogDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _errorDialog, MYLOConstants.WAIT);
			if (_isExists) {
				_isExists = BusinessFunctions.verifyMyloPopUpMessage(driver, _errorDialogHeader,
						MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR,
						MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP);
				CoreFunctions.clickElement(driver, _errorDialogOkButton);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_errorDialog, MYLOConstants.SECONDARY_CONTACT_INCORRECT_SELECTION_ERROR));
		}

	}

	/**
	 * Verify if error dialog is displayed
	 * 
	 */
	public void verifyPrimaryErrorDialogDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _errorDialog, MYLOConstants.WAIT);
			if (_isExists) {
				_isExists = BusinessFunctions.verifyMyloPopUpMessage(driver, _errorDialogHeader,
						MYLOConstants.PRIMARY_CONTACT_INCORRECT_SELECTION_ERROR,
						MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP);
				CoreFunctions.clickElement(driver, _errorDialogOkButton);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_errorDialog, MYLOConstants.PRIMARY_CONTACT_INCORRECT_SELECTION_ERROR));
		}

	}

	/**
	 * Verify if select secondary contact popup is displayed
	 * 
	 * @return
	 */
	public boolean isSelectSecondaryContactPopupDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectContactPopup, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectContactPopup, MYLOConstants.SELECT_SECONDARY_CONTACT_POPUP));
		}
		return _isExists;
	}

	/**
	 * Verify if select secondary contact link is displayed
	 *  
	 */
	public void verifySelectSecondaryContactLinkDisplayed() {

		try {
			WebElement element = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactSectionLinks, MYLOConstants.SELECT_SECONDARY_CONTACT, MYLOConstants.TEXT);
			_isExists = CoreFunctions.isElementExist(driver, element, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_SECONDARY_CONTACT_LINK, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
	}

	/**
	 * Click button in secondary contact card
	 * 
	 * @param buttonName
	 */
	public void clickButtonInSecondaryContactCard(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactCardButtons, buttonName, MYLOConstants.OUTER_TEXT);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * Click Select Secondary Contact Card link
	 */
	public void clickSelectSecondaryContactLink() {
		try {
			WebElement element = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_secondaryContactSectionLinks, MYLOConstants.SELECT_SECONDARY_CONTACT, MYLOConstants.TEXT);
			CoreFunctions.click(driver, element, MYLOConstants.SELECT_SECONDARY_CONTACT);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.SELECT_SECONDARY_CONTACT_LINK));
		}
	}

	/**
	 * Expand Primary Contact Details Section
	 */
	public void expandPrimaryContactDetailsSection() {
		try {
			CoreFunctions.clickUsingJS(driver, _expandPrimaryContactSection,
					MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION);
			String expanded = CoreFunctions.getElementAttributeValue(driver, _expandPrimaryContactSection,
					"aria-expanded");
			if (expanded.equals("false"))
				CoreFunctions.click(driver, _expandPrimaryContactSection, MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION);
		} catch (Exception e) {
			Assert.fail(
					MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION));
		}

	}

	/**
	 * Click button in Select secondary contact popup
	 * 
	 * @param buttonName
	 */
	public void clickButtonInSelectContactDialog(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_selectContactButtons, buttonName, MYLOConstants.CLASS);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * Select Secondary contact on Popup by Name
	 * 
	 * @param name
	 */
	public void selectSecondaryContactOnPopup(String name) {
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _contactNameOnPopup, name);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_SECONDARY_CONTACT, name));
		}
	}

	/**
	 * Maps the selected contact details
	 * 
	 * @param field
	 * @return
	 */
	public void mapSelectedSecondaryContactDetails() {
		secondaryContactfieldValueMapping.put(MYLOConstants.NAME,
				CoreFunctions.getElementText(driver, _selectedSecondaryContactName));
		secondaryContactfieldValueMapping.put(MYLOConstants.RELATIONSHIP,
				CoreFunctions.getElementText(driver, _selectedSecondaryContactRelationship));
		secondaryContactfieldValueMapping.put(MYLOConstants.PRONOUN,
				CoreFunctions.getElementText(driver, _selectedSecondaryContactPronoun));
		secondaryContactfieldValueMapping.put(MYLOConstants.PHONE_DETAILS,
				CoreFunctions.getAttributeText(_selectedSecondaryContactPhoneNumber, MYLOConstants.TITLE));
		secondaryContactfieldValueMapping.put(MYLOConstants.EMAIL_DETAILS,
				CoreFunctions.getAttributeText(_selectedSecondaryContactEmail, MYLOConstants.TITLE));

	}
	
	/**
	 * Verify if contact details are updated on Secondary Contact Card
	 * 
	 * @param member
	 */
	public void isSelectedSecondaryContactUpdated(String member) {
		mapSelectedSecondaryContactDetails();
		CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.NAME),
				MyloNewFileUtil.get_partnerFName() + " " + MyloNewFileUtil.get_partnerLName(),
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.PRONOUN),
				MYLOConstants.PREFER_NOT_TO_ANSWER, MYLOConstants.PRONOUN);
		CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.PHONE_DETAILS),
				MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);

		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.SPOUSE, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.CHILD, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.OTHER_EDIT, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		}

	}

	/**
	 * Maps the selected primary contact details
	 * 
	 * @param field
	 * @return
	 */
	public void mapSelectedPrimaryContactDetails() {
		primaryContactfieldValueMapping.put(MYLOConstants.NAME,
				CoreFunctions.getElementText(driver, _selectedPrimaryContactName));
		primaryContactfieldValueMapping.put(MYLOConstants.RELATIONSHIP,
				CoreFunctions.getElementText(driver, _selectedPrimaryContactRelationship));
		primaryContactfieldValueMapping.put(MYLOConstants.PRONOUN,
				CoreFunctions.getElementText(driver, _selectedPrimaryContactPronoun));
		primaryContactfieldValueMapping.put(MYLOConstants.PHONE_DETAILS,
				CoreFunctions.getAttributeText(_selectedPrimaryContactPhoneNumber, MYLOConstants.TITLE));
		primaryContactfieldValueMapping.put(MYLOConstants.EMAIL_DETAILS,
				CoreFunctions.getAttributeText(_selectedPrimaryContactEmail, MYLOConstants.TITLE));
	}

	/**
	 * Click Change button on Primary contact card
	 * 
	 * @param buttonName
	 */
	public void clickChangeButtonInPrimaryContactCard() {
		try {
			CoreFunctions.highlightElementAndClick(driver, _primaryContactChangeButton, MYLOConstants.CHANGE_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CHANGE_BUTTON));
		}
	}

	/**
	 * Verify if select Primary contact popup is displayed
	 * 
	 * @return
	 */
	public boolean isSelectPrimaryContactPopupDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _selectContactPopup, MYLOConstants.WAIT);
			if (_isExists)
				Reporter.addStepLog(
						MessageFormat.format(MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP, CoreConstants.PASS));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_selectContactPopup, MYLOConstants.SELECT_PRIMARY_CONTACT_POPUP));
		}
		return _isExists;
	}

	/**
	 * Select Primary contact on Popup by Name
	 * 
	 * @param name
	 */
	public void selectPrimaryContactOnPopup(String name) {
		try {
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _contactNameOnPopup, name);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_PRIMARY_CONTACT, name));
		}
	}

	/**
	 * Verify if contact details are updated on Primary Contact Card
	 * 
	 * @param member
	 */
	public void isSelectedPrimaryContactUpdated(String member) {
		mapSelectedPrimaryContactDetails();
		CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.NAME),
				MyloNewFileUtil.get_partnerFName() + " " + MyloNewFileUtil.get_partnerLName(),
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.PRONOUN),
				MYLOConstants.PREFER_NOT_TO_ANSWER, MYLOConstants.PRONOUN);
		CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.PHONE_DETAILS),
				MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);

		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.SPOUSE, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.CHILD, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.RELATIONSHIP),
					MYLOConstants.OTHER_EDIT, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		}

	}

	/**
	 * scroll to primary contact section
	 */
	public void scrollToPrimaryContactSection() {
		CoreFunctions.waitHandler(MYLOConstants.WAIT);
		CoreFunctions.scrollToElementUsingJS(driver, _primaryContactSection, MYLOConstants.PRIMARY_CONTACT_SECTION);
	}

	/**
	 * Remove secondary contact if present
	 */
	public void verifyAndRemoveSecondaryContactIfPresent() {
		expandPrimaryContactDetailsSection();
		if (!CoreFunctions.searchElementExistsInListByText(driver, _secondaryContactSectionLinks,
				MYLOConstants.SELECT_SECONDARY_CONTACT))
			clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
	}

	/**
	 * Update Primary Contact Details
	 * 
	 * @param firstName
	 * @param lastName
	 */
	public void verifyAndUpdatePrimaryContact(String transfereeName) {
		mapSelectedPrimaryContactDetails();
		if (!primaryContactfieldValueMapping.get(MYLOConstants.NAME).equals(transfereeName)) {
			clickChangeButtonInPrimaryContactCard();
			selectPrimaryContactOnPopup(transfereeName);
			clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		}
	}

	/**
	 * verify selected secondary contact name
	 * 
	 * @param name
	 */
	public void verifySelectedSecondaryContactName(String name) {
		mapSelectedSecondaryContactDetails();
		CoreFunctions.verifyText(secondaryContactfieldValueMapping.get(MYLOConstants.NAME), name,
				MYLOConstants.SECONDARY_CONTACT_NAME);
	}

	/**
	 * Verify Member Present on page
	 * 
	 * @param name
	 */
	public void verifyMembersPresentOnPopup(List<String> member) {
		for (String name : member) 
			CoreFunctions.searchElementExistsInListByText(driver, _contactNameOnPopup, name, true);		
	}
	
	/**
	 * verify selected Primary contact name
	 * 
	 * @param name
	 */
	public void verifySelectedPrimaryContactName(String name) {
		mapSelectedPrimaryContactDetails();
		CoreFunctions.verifyText(primaryContactfieldValueMapping.get(MYLOConstants.NAME), name,
				MYLOConstants.PRIMARY_CONTACT_NAME);
	}

}
