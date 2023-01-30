package com.aires.pages.mylo;

import java.text.MessageFormat;
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
import com.aires.utilities.Log;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

public class MyloJourneyPage_SecondaryContact extends Base {

	public MyloJourneyPage_SecondaryContact(WebDriver driver) {
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

	/**
	 * Verify if error dialog is displayed
	 * 
	 * @return
	 */
	public boolean isErrorDialogDisplayed() {

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
		return _isExists;

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
	 * @return
	 */
	public boolean isSelectSecondaryContactLinkDisplayed() {

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
		return _isExists;
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
			CoreFunctions.scrollClickUsingJS(driver, _expandPrimaryContactSection,
					MYLOConstants.EXPAND_PRIMARY_CONTACT_SECTION);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
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
	 * Select Secondary contact on Popup by Index
	 * 
	 * @param index
	 */
	public void selectSecondaryContactOnPopup(int index) {
		try {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, index);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_SELECT_SECONDARY_CONTACT_AT_INDEX, index));
		}
	}

	/**
	 * Select Primary Contact on Select Secondary Contact Popup
	 */
	public void selectPrimaryContactOnSecondaryContactPopup() {
		try {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, 0);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL, MYLOConstants.FAILED_TO_SELECT_PRIMARY_CONTACT));
		}
	}

	/**
	 * Gets the selected contact details
	 * 
	 * @param field
	 * @return
	 */
	public String getSelectedSecondaryContactDetails(String field) {
		String fieldValue = "";
		try {
			switch (field) {
			case MYLOConstants.NAME:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactName);
				break;
			case MYLOConstants.RELATIONSHIP:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactRelationship);
				break;
			case MYLOConstants.PRONOUN:
				fieldValue = CoreFunctions.getElementText(driver, _selectedSecondaryContactPronoun);
				break;
			case MYLOConstants.PHONE_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedSecondaryContactPhoneNumber, MYLOConstants.TITLE);
				break;
			case MYLOConstants.EMAIL_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedSecondaryContactEmail, MYLOConstants.TITLE);
				break;
			}

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT, field));
		}
		return fieldValue;
	}

	/**
	 * Select Secondary Contact on Popup and verify name on secondary contact card
	 */
	public void selectAndVerifySecondaryContact() {

		for (int i = 1; i < _contactListOnPopup.size(); i++) {
			BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, i);
			String secondaryContactName = CoreFunctions.getItemsFromListByIndex(driver, _contactNameOnPopup, i,
					MYLOConstants.TRUE);
			clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.NAME), secondaryContactName,
					MYLOConstants.SECONDARY_CONTACT_NAME);
			clickButtonInSecondaryContactCard(MYLOConstants.REMOVE_BUTTON);
			clickSelectSecondaryContactLink();
		}
	}

	/**
	 * Get Contact Name on Popup by Index
	 * 
	 * @param index
	 * @return
	 */
	public String getContactNameOnPopUp(int index) {
		return CoreFunctions.getItemsFromListByIndex(driver, _contactNameOnPopup, index, MYLOConstants.TRUE);
	}

	/**
	 * Verify if contact details are updated on Secondary Contact Card
	 * 
	 * @param member
	 */
	public void isSelectedSecondaryContactUpdated(String member) {

		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.NAME),
				MyloNewFileUtil.get_partnerFName() + " " + MyloNewFileUtil.get_partnerLName(),
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.PRONOUN),
				MYLOConstants.PREFER_NOT_TO_ANSWER, MYLOConstants.PRONOUN);
		CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.PHONE_DETAILS),
				MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);

		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.SPOUSE, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.CHILD, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.OTHER_EDIT, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedSecondaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		}

	}

	/**
	 * Gets the selected primary contact details
	 * 
	 * @param field
	 * @return
	 */
	public String getSelectedPrimaryContactDetails(String field) {
		String fieldValue = "";
		try {
			switch (field) {
			case MYLOConstants.NAME:
				fieldValue = CoreFunctions.getElementText(driver, _selectedPrimaryContactName);
				break;
			case MYLOConstants.RELATIONSHIP:
				fieldValue = CoreFunctions.getElementText(driver, _selectedPrimaryContactRelationship);
				break;
			case MYLOConstants.PRONOUN:
				fieldValue = CoreFunctions.getElementText(driver, _selectedPrimaryContactPronoun);
				break;
			case MYLOConstants.PHONE_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedPrimaryContactPhoneNumber, MYLOConstants.TITLE);
				break;
			case MYLOConstants.EMAIL_DETAILS:
				fieldValue = CoreFunctions.getAttributeText(_selectedPrimaryContactEmail, MYLOConstants.TITLE);
				break;
			}

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
			Assert.fail(MessageFormat.format(MYLOConstants.FAIL_TO_GET_ELEMENT_TEXT, field));
		}
		return fieldValue;
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
	 * Select Primary Contact on Popup and verify name on primary contact card
	 */
	public void selectAndVerifyPrimaryContact() {
		int contactSize = _contactListOnPopup.size();
		List<String> transfereeNames = CoreFunctions.getElementTextAndStoreInList(driver, _contactNameOnPopup);

		for (int i = 0; i < contactSize - 1; i++) {
			String contactName = CoreFunctions.getItemsFromListByIndex(driver, _contactNameOnPopup, i,
					MYLOConstants.TRUE);
			for (int j = 0; j < transfereeNames.size(); j++) {
				if (contactName.equalsIgnoreCase(transfereeNames.get(i))) {
					BusinessFunctions.selectValueFromListUsingIndex(driver, _contactRadioButtonsOnPopup, i);
					clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
					BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
					CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.NAME), contactName,
							MYLOConstants.PRIMARY_CONTACT_NAME);
					clickChangeButtonInPrimaryContactCard();
					transfereeNames.remove(contactName);
					break;
				}
			}
		}
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

		CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.NAME),
				MyloNewFileUtil.get_partnerFName() + " " + MyloNewFileUtil.get_partnerLName(),
				MYLOConstants.SECONDARY_CONTACT_NAME);
		CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.PRONOUN),
				MYLOConstants.PREFER_NOT_TO_ANSWER, MYLOConstants.PRONOUN);
		CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.PHONE_DETAILS),
				MyloNewFileUtil.get_transfereePhoneNo() + " " + MYLOConstants.CELL_PHONE, MYLOConstants.PHONE_NUMBER);

		switch (member) {
		case (MYLOConstants.PARTNER):
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.RELATIONSHIP), MYLOConstants.SPOUSE,
					MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.SPOUSE_PERSONAL, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.DEPENDENT):
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.RELATIONSHIP), MYLOConstants.CHILD,
					MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.EMAIL_DETAILS),
					MyloNewFileUtil.get_transfereeEmail() + " " + MYLOConstants.OTHER, MYLOConstants.EMAIL);
			break;
		case (MYLOConstants.OTHER):
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.RELATIONSHIP),
					MYLOConstants.OTHER_EDIT, MYLOConstants.RELATIONSHIP);
			CoreFunctions.verifyText(getSelectedPrimaryContactDetails(MYLOConstants.EMAIL_DETAILS),
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
	 * highlight primary contact section
	 */
	public void highlightPrimaryContactSection() {
		CoreFunctions.highlightObject(driver, _primaryContactSection);
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
	public void verifyAndUpdatePrimaryContact(String firstName, String lastName) {
		if (!getSelectedPrimaryContactDetails(MYLOConstants.NAME).equals(firstName + " " + lastName)) {
			clickChangeButtonInPrimaryContactCard();
			selectPrimaryContactOnPopup(firstName + " " + lastName);
			clickButtonInSelectContactDialog(MYLOConstants.SUBMIT_BUTTON);
		}
	}

}