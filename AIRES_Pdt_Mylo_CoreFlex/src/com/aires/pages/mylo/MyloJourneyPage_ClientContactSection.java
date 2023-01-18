package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
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
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;

public class MyloJourneyPage_ClientContactSection extends Base {
	public MyloJourneyPage_ClientContactSection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Client Contact section

	@FindBy(how = How.CSS, using = "app-client-contact-form input")
	private List<WebElement> _clientContactInputFields;

	@FindBy(how = How.CSS, using = "app-client-popup input")
	private List<WebElement> _addClientContactInputFields;

	@FindBy(how = How.CSS, using = "app-client-contact button")
	private List<WebElement> _clientContactButtons;

	@FindBy(how = How.CSS, using = "app-client-contact button[class$='collapsed']")
	private WebElement _clientContactDetailsButton;

	@FindBy(how = How.CSS, using = "app-client-contact p")
	private WebElement _addClientContactLink;

	@FindBy(how = How.CSS, using = "ng-select[name='Client_Pronouns']")
	private WebElement _pronounsDropdown;

	@FindBy(how = How.CSS, using = "app-client-popup ng-select[name='Client_Pronouns']")
	private WebElement _addClientContactPronounsDropdown;

	@FindBy(how = How.CSS, using = "app-client-contact-form button")
	private List<WebElement> _addClientContactPopUpButtons;

	@FindBy(how = How.CSS, using = "app-client-contact-card div[class$='usertitle']")
	private List<WebElement> _clientContactCardNames;

	// WebElements related to Journey Page

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _toastMessageCloseBtn;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.CSS, using = "button[class*='swal2-cancel']")
	private WebElement _noBtn;

	@FindBy(how = How.CSS, using = "button[class*='swal2-close']")
	private WebElement _closeBtn;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _yesBtn;

	private final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	private final HashMap<String, String> _clientContactFieldsUpdatedValueMap = new LinkedHashMap<String, String>();

	/**
	 * Click on Buttons available on Client Contact Section based on button Name
	 * passed as a parameter
	 * 
	 * @param btnName
	 */
	public void clickButtonsOnClientContactSection(String btnName, String section) {
		try {
			List<WebElement> _clientContactBtns = (section.equals(MYLOConstants.ADD_CLIENT_CONTACT))
					? _addClientContactPopUpButtons
					: _clientContactButtons;
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, _clientContactBtns, btnName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, btnName, MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.scrollToElementUsingJS(driver, element, btnName);
			CoreFunctions.moveToElement(driver, element);
			CoreFunctions.clickUsingJS(driver, element, btnName);
			// BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

	/**
	 * Click on Add Client Contact Link on Client Contact section
	 * 
	 * @param linkName
	 */
	public void clickAddClientContact(String linkName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _addClientContactLink, linkName,
					MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.scrollClickUsingJS(driver, _addClientContactLink, linkName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, linkName));
		}
	}

	/**
	 * Click on Details button available under Client Contact section
	 */
	public void clickClientContactDetailsBtn() {
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _clientContactDetailsButton, MYLOConstants.DETAILS,
					MYLOConstants.CUSTOM_WAIT_TIME);
			CoreFunctions.scrollToElementUsingJS(driver, _clientContactDetailsButton, MYLOConstants.DETAILS);
			CoreFunctions.click(driver, _clientContactDetailsButton, MYLOConstants.DETAILS);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.DETAILS));
		}

	}

	/**
	 * Set Client Contact field Values Section based on fieldName,fieldValue,type &
	 * section passed as a parameter
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @param type
	 * @param section
	 * @return
	 */
	public String setClientContactInformation(String fieldName, String fieldValue, String type, String section) {
		String updatedValue = "";
		try {
			List<WebElement> _clientContactFields = (section.equals(MYLOConstants.ADD_CLIENT_CONTACT))
					? _addClientContactInputFields
					: _clientContactInputFields;
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver, _clientContactFields,
					fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			updatedValue = BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, fieldElement, type);
			_clientContactFieldsUpdatedValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CLIENT_CONTACT));
		}
		return updatedValue;
	}

	/**
	 * Set Pronoun dropdown field based on the dropdown value passed as a parameter
	 * 
	 * @param fieldValue
	 * @param section
	 * @return
	 */
	public String setPronounFieldDropdownValue(String fieldValue, String section) {
		String updatedValue = "";
		try {

			WebElement _pronounsElement = (section.equals(MYLOConstants.ADD_CLIENT_CONTACT))
					? _addClientContactPronounsDropdown
					: _pronounsDropdown;
			CoreFunctions.scrollToElementUsingJS(driver, _pronounsElement, MYLOConstants.PRONOUNS);
			CoreFunctions.highlightElementAndClick(driver, _pronounsElement, MYLOConstants.PRONOUNS);
			updatedValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue,
					MYLOConstants.PRONOUNS);
			_clientContactFieldsUpdatedValueMap.put(MYLOConstants.PRONOUNS, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.PRONOUNS, MYLOConstants.CLIENT_CONTACT));
		}
		return updatedValue;
	}

	/**
	 * Set All Client Contact fields with random values based on the section name
	 * 
	 * @param sectionName
	 */
	public void setAllClientContactFieldWithRandomValues(String sectionName) {
		setClientContactInformation(MYLOConstants.FIRST_NAME, MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.RANDOM_STRING, sectionName);
		setClientContactInformation(MYLOConstants.LAST_NAME, MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.RANDOM_STRING, sectionName);
		setPronounFieldDropdownValue(MYLOConstants.RANDOM, sectionName);
		setClientContactInformation(MYLOConstants.PHONETIC_PREFERRED_NAME, MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.RANDOM_STRING, sectionName);
		setClientContactInformation(MYLOConstants.EMAIL, MYLOConstants.AUTOMATION_EMAIL, MYLOConstants.VALUE,
				sectionName);
		setClientContactInformation(MYLOConstants.PHONE_NUMBER, MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.RANDOM_INTEGER, sectionName);
		setClientContactInformation(MYLOConstants.COMMENT, MYLOConstants.CUSTOM_FIELD_LENGTH,
				MYLOConstants.RANDOM_STRING, sectionName);
	}

	/**
	 * Set Client Contact fields with random values beyond respective character
	 * limit
	 */
	public void setClientContactBeyondCharacterLimit() {
		setClientContactInformation(MYLOConstants.FIRST_NAME, String.valueOf(MYLOConstants.FIRST_NAME_CHAR_LIMIT + 1),
				MYLOConstants.RANDOM_STRING, MYLOConstants.ADD_CLIENT_CONTACT);
		setClientContactInformation(MYLOConstants.LAST_NAME, String.valueOf(MYLOConstants.LAST_NAME_CHAR_LIMIT + 1),
				MYLOConstants.RANDOM_STRING, MYLOConstants.ADD_CLIENT_CONTACT);
		setClientContactInformation(MYLOConstants.PHONETIC_PREFERRED_NAME,
				String.valueOf(MYLOConstants.PREFERRED_NAME_CHAR_LIMIT + 1), MYLOConstants.RANDOM_STRING,
				MYLOConstants.ADD_CLIENT_CONTACT);
		setClientContactInformation(MYLOConstants.EMAIL, String.valueOf(MYLOConstants.EMAIL_CHAR_LIMIT + 1),
				MYLOConstants.RANDOM_STRING, MYLOConstants.ADD_CLIENT_CONTACT);
		setClientContactInformation(MYLOConstants.PHONE_NUMBER,
				String.valueOf(MYLOConstants.PHONE_NUMBER_CHAR_LIMIT + 1), MYLOConstants.RANDOM_INTEGER,
				MYLOConstants.ADD_CLIENT_CONTACT);
		setClientContactInformation(MYLOConstants.COMMENT, String.valueOf(MYLOConstants.COMMENT_CHAR_LIMIT + 1),
				MYLOConstants.RANDOM_STRING, MYLOConstants.ADD_CLIENT_CONTACT);
	}

	/**
	 * Set First & last Name field on Client Contact section
	 * 
	 * @param fName
	 * @param lName
	 * @param type
	 * @param section
	 */
	public void setMandatoryClientContactFields(String fName, String lName, String type, String section) {
		setClientContactInformation(MYLOConstants.FIRST_NAME, fName, type, section);
		setClientContactInformation(MYLOConstants.LAST_NAME, lName, type, section);
	}

	/**
	 * Get Client Contact field Value based on field Name & section passed as a
	 * parameter
	 * 
	 * @param fieldName
	 * @param section
	 * @return
	 */
	public String getClientContact(String fieldName, String section) {
		String requiredValue = "";
		try {
			List<WebElement> _clientContactFields = (section.equals(MYLOConstants.ADD_CLIENT_CONTACT))
					? _addClientContactInputFields
					: _clientContactInputFields;
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver, _clientContactFields,
					fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldName);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			CoreFunctions.highlightObject(driver, fieldElement);
			requiredValue = CoreFunctions.getAttributeText(fieldElement, MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.CLIENT_CONTACT));
		}
		return requiredValue;
	}

	/**
	 * Get Client Contact Pronoun field value
	 * 
	 * @return
	 */
	public String getPronounFieldDropdownValue() {
		String requiredValue = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _pronounsDropdown, MYLOConstants.PRONOUNS);
			CoreFunctions.scrollToElementUsingJS(driver, _pronounsDropdown, MYLOConstants.PRONOUNS);
			CoreFunctions.highlightObject(driver, _pronounsDropdown);
			requiredValue = CoreFunctions.getElementText(driver, _pronounsDropdown);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.PRONOUNS, MYLOConstants.CLIENT_CONTACT));
		}
		return requiredValue;
	}

	/**
	 * Verify that Client Contact Field values are successfully saved on Journey
	 * page
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyClientContactUpdated(DataTable table) {
		boolean flag = true;
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
			for (Map<String, String> data : dataList) {
				String fieldName = data.get(MYLOConstants.FIELD_NAME);
				String actualValue = (fieldName.equals(MYLOConstants.PRONOUNS)) ? getPronounFieldDropdownValue()
						: getClientContact(fieldName, MYLOConstants.CLIENT_CONTACT);
				String expectedValue = (fieldName.equals(MYLOConstants.UPDATED_BY)) ? MYLOConstants.MXSSODEV5
						: (fieldName.contains(MYLOConstants.DATE))
								? CoreFunctions.getCurrentDateAsGivenFormat("d MMM YYY")
								: _clientContactFieldsUpdatedValueMap.get(fieldName);
				if (!(actualValue.equals(expectedValue))) {
					Reporter.addStepLog(
							MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
									expectedValue, fieldName, MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
					flag = false;
				} else
					Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_UPDATED_ON_SECTION, CoreConstants.PASS,
							expectedValue, fieldName, MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
					MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify Client Contact field Values entered on Add Client Contact section
	 * 
	 * @param table
	 * @return
	 */
	public boolean verifyClientContactFieldValuesEntered(DataTable table) {
		boolean flag = true;
		try {
			java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
			for (Map<String, String> data : dataList) {

				String fieldName = data.get(MYLOConstants.FIELD_NAME);
				int fieldCharLimit = Integer.parseInt(data.get(MYLOConstants.CHARACTER_LIMIT));
				if (!(CoreFunctions.verifyTextForMaxLength(
						getClientContact(fieldName, MYLOConstants.ADD_CLIENT_CONTACT),
						_clientContactFieldsUpdatedValueMap.get(fieldName), fieldName, fieldCharLimit + 1,
						fieldCharLimit)))
					flag = false;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE_SECTION, CoreConstants.FAIL,
					MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify button is enable or disable on Client Contact based on button name &
	 * type passed as a parameter
	 * 
	 * @param btnName
	 */
	public boolean verifyClientContactButtonEnabilityStatus(String btnName, String type) {
		boolean flag = false;
		try {
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, _clientContactButtons, btnName);
			flag = BusinessFunctions.verifyMyloButtonEnabilityStatus(type, element, btnName,
					MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					btnName, MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify Add button is enable or disable on Client Contact based on button name
	 * & type passed as a parameter
	 * 
	 * @param btnName
	 */
	public boolean isClientContactAddLinkDisable() {
		boolean flag = false;
		try {
			flag = CoreFunctions.getElementAttributeValue(driver, _addClientContactLink, MYLOConstants.CLASS)
					.contains(MYLOConstants.DISABLED);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.ADD_BUTTON, MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify all tag script toast message validation for Client Contact fields
	 * 
	 * @param table
	 * @param btnName
	 * @return
	 */
	public boolean verifyClientContactTagSciptToastMsg(DataTable table, String btnName) {
		boolean flag = true;
		try {
			java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
			for (Map<String, String> data : dataList) {
				String fieldName = data.get(MYLOConstants.FIELD_NAME);
				setClientContactInformation(fieldName, MYLOConstants.RANDOM, MYLOConstants.SPECIAL_CHARACTERS_STRING,
						MYLOConstants.ADD_CLIENT_CONTACT);
				clickButtonsOnClientContactSection(btnName, MYLOConstants.ADD_CLIENT_CONTACT);
				if (!(BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, data.get(MYLOConstants.MESSAGE),
						MYLOConstants.CLIENT_CONTACT)))
					flag = false;
				CoreFunctions.clickButtonsUsingSendKeys(driver, MYLOConstants.CLOSE_BUTTON, _toastMessageCloseBtn,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY);
				setClientContactInformation(fieldName, MYLOConstants.BLANK, MYLOConstants.BLANK,
						MYLOConstants.ADD_CLIENT_CONTACT);
				setMandatoryClientContactFields(String.valueOf(MYLOConstants.CUSTOM_FIELD_LENGTH),
						String.valueOf(MYLOConstants.CUSTOM_FIELD_LENGTH), MYLOConstants.RANDOM_STRING,
						MYLOConstants.ADD_CLIENT_CONTACT);
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
					MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify all mandatory toast message & email validation for Client Contact
	 * fields
	 * 
	 * @param table
	 * @param btnName
	 * @return
	 */
	public boolean verifyClientContactMandatoryFieldsToastMessage(DataTable table, String btnName) {
		boolean flag = true;
		try {
			java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
			for (Map<String, String> data : dataList) {
				String firstName = !(data.get(MYLOConstants.FIRST_NAME).equals(MYLOConstants.BLANK))
						? String.valueOf(MYLOConstants.CUSTOM_FIELD_LENGTH)
						: MYLOConstants.BLANK;
				String lastName = !(data.get(MYLOConstants.LAST_NAME).equals(MYLOConstants.BLANK))
						? String.valueOf(MYLOConstants.CUSTOM_FIELD_LENGTH)
						: MYLOConstants.BLANK;
				setMandatoryClientContactFields(firstName, lastName, MYLOConstants.RANDOM_STRING,
						MYLOConstants.ADD_CLIENT_CONTACT);
				setClientContactInformation(MYLOConstants.EMAIL, data.get(MYLOConstants.EMAIL), MYLOConstants.VALUE,
						MYLOConstants.ADD_CLIENT_CONTACT);
				clickButtonsOnClientContactSection(btnName, MYLOConstants.ADD_CLIENT_CONTACT);
				if (!(BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, data.get(MYLOConstants.MESSAGE),
						MYLOConstants.CLIENT_CONTACT)))
					flag = false;
				CoreFunctions.clickButtonsUsingSendKeys(driver, MYLOConstants.CLOSE_BUTTON, _toastMessageCloseBtn,
						MYLOConstants.CLIENT_CONTACT, MYLOConstants.JOURNEY);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_ALERT_MESSAGE_SECTION, CoreConstants.FAIL,
					MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

	/**
	 * Verify that Client Contact Card is deleted or not
	 * 
	 * @param btnName
	 * @return
	 */
	public boolean verifyClientContactDeleted(String btnName) {
		WebElement btnWebElement = (btnName.equals(MYLOConstants.NO_BUTTON)) ? _noBtn
				: (btnName.equals(MYLOConstants.CLOSE_BUTTON)) ? _closeBtn : _yesBtn;
		CoreFunctions.highlightElementAndClick(driver, btnWebElement, btnName);
		return verifyRecentClientContactCardDisplayed();
	}

	/**
	 * Verify that Client Card is displayed on Client Contact section
	 * 
	 * @return
	 */
	public boolean verifyRecentClientContactCardDisplayed() {
		boolean flag = false;
		try {
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
			String cardName = _clientContactFieldsUpdatedValueMap.get(MYLOConstants.FIRST_NAME) + MYLOConstants.SPACE
					+ _clientContactFieldsUpdatedValueMap.get(MYLOConstants.LAST_NAME);
			flag = (CoreFunctions.getElementText(driver, _clientContactCardNames.get(0)).equals(cardName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					MYLOConstants.CLIENT_CONTACT_CARD, MYLOConstants.CLIENT_CONTACT));
		}
		return flag;
	}

}
