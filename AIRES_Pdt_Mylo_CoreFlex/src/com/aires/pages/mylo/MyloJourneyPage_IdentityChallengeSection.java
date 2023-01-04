package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.LinkedHashMap;

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

public class MyloJourneyPage_IdentityChallengeSection extends Base {

	public MyloJourneyPage_IdentityChallengeSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.XPATH, using = "//button[text()='Identity Challenge Question']")
	private WebElement _identityChallengeButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Save']")
	private WebElement _identityChallengeSaveButton;

	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement _identityChallengeCancelButton;

	@FindBy(how = How.CSS, using = ".icon-X_Open")
	private WebElement _identityChallengeClosePopUp;

	@FindBy(how = How.CSS, using = "label[class='identity-question p-0']")
	private WebElement _identityChallengeQuestion;

	@FindBy(how = How.CSS, using = "#Identity-Answer")
	private WebElement _identityChallengeAnswer;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	LinkedHashMap<String, WebElement> identityChallengeWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> identityChallengeUpdatedFieldValuesMap = new LinkedHashMap<String, String>();

	public void mapIdentityChallengeWebElementFields() {
		identityChallengeWebElementsMap.put(MYLOConstants.IDENTITY_CHALLENGE_QUESTION, _identityChallengeButton);
		identityChallengeWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _identityChallengeSaveButton);
		identityChallengeWebElementsMap.put(MYLOConstants.CANCEL_BUTTON, _identityChallengeCancelButton);
		identityChallengeWebElementsMap.put(MYLOConstants.CLOSE_BUTTON, _identityChallengeClosePopUp);
		identityChallengeWebElementsMap.put(MYLOConstants.IC_QUESTION, _identityChallengeQuestion);
		identityChallengeWebElementsMap.put(MYLOConstants.IC_ANSWER, _identityChallengeAnswer);
	}

	public void clickFieldsOnIdentityChallengeSection(String fieldName) {
		mapIdentityChallengeWebElementFields();
		try {
			WebElement element = identityChallengeWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		}
	}

	public void setFieldValueOfIdentityChallengeSection(String fieldName, String fieldValue) {
		mapIdentityChallengeWebElementFields();
		try {
			WebElement reqWebElement = identityChallengeWebElementsMap.get(fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, reqWebElement, fieldName);
			String setValue = CoreFunctions.setDifferentFieldsForMylo(driver, reqWebElement, fieldName, fieldValue);
			identityChallengeUpdatedFieldValuesMap.put(fieldName, setValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		}
	}

	public String getFieldValueOfIdentityChallengeSection(String fieldName) {
		String requiredText = null;
		mapIdentityChallengeWebElementFields();
		try {
			WebElement element = identityChallengeWebElementsMap.get(fieldName);
			requiredText = (fieldName.equals(MYLOConstants.IC_QUESTION)) ? CoreFunctions.getElementText(driver, element)
					: CoreFunctions.getAttributeText(element, MYLOConstants.VALUE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		}
		return requiredText;
	}

	public boolean verifyIdentityChallengeFieldsUpdatedValue(String fieldName) {
		boolean flag = false;
		mapIdentityChallengeWebElementFields();
		String updatedValue = null;
		try {
			updatedValue = identityChallengeUpdatedFieldValuesMap.get(fieldName);
			int fieldCharLimit = Integer.parseInt(MYLOConstants.IDENT_CHALLENGE_ANSWER_CHAR_LIMIT);
			updatedValue = updatedValue.length() > fieldCharLimit ? updatedValue.substring(0, fieldCharLimit)
					: updatedValue;
			flag = getFieldValueOfIdentityChallengeSection(fieldName).equals(updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL,
					fieldName, MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		return flag;
	}

	public boolean verifyIdentityChallengeButtonExist() {
		return CoreFunctions.isElementVisible(_identityChallengeButton);
	}

	public boolean verifyToastMessage(String msg) {
		boolean flag = false;
		flag = (BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, msg,
				MYLOConstants.IDENTITY_CHALLENGE_QUESTION));
		return flag;
	}

}
