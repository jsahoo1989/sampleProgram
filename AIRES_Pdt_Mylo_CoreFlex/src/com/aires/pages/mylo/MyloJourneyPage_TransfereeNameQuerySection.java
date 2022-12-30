package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
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
import com.aires.utilities.CustomSoftAssert;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;

public class MyloJourneyPage_TransfereeNameQuerySection extends Base {
	public MyloJourneyPage_TransfereeNameQuerySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Transferee Name Query section

	@FindBy(how = How.CSS, using = "app-transferee-name")
	private WebElement _transfereeNameQueryPopUp;

	@FindBy(how = How.CSS, using = "app-transferee-name input")
	private List<WebElement> _transfereeNameQueryInputFields;

	@FindBy(how = How.CSS, using = "app-transferee-name button")
	private List<WebElement> _transfereeNameQueryButtons;

	@FindBy(how = How.CSS, using = "button[class*='btn-close']")
	private WebElement _transfereeNameQueryCloseIcon;

	@FindBy(how = How.XPATH, using = "//button[text()='New Query']")
	private WebElement _newQueryBtn;

	@FindBy(how = How.XPATH, using = "//button[text()='Transferee Name']")
	private WebElement _transfereeNameBtn;

	// WebElements related to Journey Page

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _toastMessageCloseBtn;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	@FindBy(how = How.XPATH, using = "//cdk-virtual-scroll-viewport//ul/li[3]")
	private List<WebElement> _tNamesQueryResult;

	@FindBy(how = How.CSS, using = ".errortext")
	private WebElement _errorPopUpText;

	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _OKButtonPopUp;

	private final HashMap<String, String> tNameFieldsUpdatedValueMap = new LinkedHashMap<String, String>();

	/**
	 * Click on Buttons available on Transferee Name Query Section based on button
	 * Name passed as a parameter
	 * 
	 * @param btnName
	 */
	public void clickButtonsOnTransfereeNameQuerySection(String btnName) {
		try {
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, _transfereeNameQueryButtons,
					btnName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, btnName, 10);
			CoreFunctions.scrollClickUsingJS(driver, element, btnName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}

	/**
	 * Set Transferee Name Query field Values Section based on fieldName,fieldValue
	 * & type passed as a parameter
	 * 
	 * @param fieldName
	 * @param fieldValue
	 * @param type
	 * @return
	 */
	public String setTransfereeName(String fieldName, String fieldValue, String type) {
		String updatedValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver,
					_transfereeNameQueryInputFields, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			updatedValue = BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, fieldElement, type);
			tNameFieldsUpdatedValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE_NAME_QUERY));
		}
		return updatedValue;
	}

	/**
	 * Set Random Transferee Name Query fields as per character limit
	 * 
	 * @param table
	 */
	public void setTransfereeNameAsPerCharacterLimit(DataTable table) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			setTransfereeName(fieldName, data.get(MYLOConstants.CHARACTER_LENGTH), MYLOConstants.RANDOM_STRING);
		}
	}

	/**
	 * Get Transferee Name Query field Value based on field Name passed as a
	 * parameter
	 * 
	 * @param fieldName
	 * @return
	 */
	public String getTransfereeName(String fieldName) {
		String requiredValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver,
					_transfereeNameQueryInputFields, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldName);
			CoreFunctions.highlightObject(driver, fieldElement);
			requiredValue = CoreFunctions.getAttributeText(fieldElement, MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TRANSFEREE_NAME_QUERY));
		}
		return requiredValue;
	}

	/**
	 * Verify Tag Script Validation Message for all Transferee Name Query fields
	 * 
	 * @param table
	 * @param softAssert
	 */
	public void verifyTagSciptErrorToastMsg(DataTable table, CustomSoftAssert softAssert) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			setTransfereeName(fieldName, MYLOConstants.RANDOM, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickButtonsOnTransfereeNameQuerySection(MYLOConstants.EXECUTE);
			softAssert.assertTrue(
					BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, data.get(MYLOConstants.MESSAGE),
							MYLOConstants.TRANSFEREE_NAME_QUERY),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			CoreFunctions.clickButtonsUsingSendKeys(driver, MYLOConstants.CLOSE_BUTTON, _toastMessageCloseBtn,
					MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY);
			setTransfereeName(fieldName, MYLOConstants.BLANK, MYLOConstants.BLANK);
		}
	}

	/**
	 * Verify Transferee Name Query field Values entered
	 * 
	 * @param table
	 * @param softAssert
	 */
	public void verifyTNameFieldValuesEntered(DataTable table, CustomSoftAssert softAssert) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			int fieldCharLimit = Integer.parseInt(data.get(MYLOConstants.CHARACTER_LENGTH));
			String updatedValue = tNameFieldsUpdatedValueMap.get(fieldName).length() > fieldCharLimit
					? tNameFieldsUpdatedValueMap.get(fieldName).substring(0, fieldCharLimit)
					: tNameFieldsUpdatedValueMap.get(fieldName);
			boolean flag = (getTransfereeName(fieldName).equals(updatedValue));
			softAssert.assertTrue(flag, MessageFormat.format(MYLOConstants.FIELDS_NOT_UPDATED_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TRANSFEREE_NAME_QUERY));
			if (flag)
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
						fieldName, updatedValue, MYLOConstants.TRANSFEREE_NAME_QUERY));
			else
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
						updatedValue, fieldName, MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY));
		}
	}

	/**
	 * Verify Transferee Name Query results as per searched First & last Name on
	 * Transferee Name Query section
	 * 
	 * @param table
	 * @param softAssert
	 */
	public void verifyQueryResultAsPerSearchedTName(DataTable table, CustomSoftAssert softAssert) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fName = data.get(MYLOConstants.FIRST_NAME);
			String lName = data.get(MYLOConstants.LAST_NAME);
			setTransfereeName(MYLOConstants.FIRST_NAME, fName, MYLOConstants.VALUE);
			setTransfereeName(MYLOConstants.LAST_NAME, lName, MYLOConstants.VALUE);
			clickButtonsOnTransfereeNameQuerySection(MYLOConstants.EXECUTE);
			boolean flag = verifySearchedTransfereeName(fName, lName);
			softAssert.assertTrue(flag,
					MessageFormat.format(MYLOConstants.VERIFIED_QUERY_RESULTS_VALUES_MISMATCH, CoreConstants.FAIL,
							MYLOConstants.TRANSFEREE_NAME, MYLOConstants.TRANSFEREE_NAME_QUERY,
							MYLOConstants.FIRST_NAME, fName, MYLOConstants.LAST_NAME, lName));
			if (flag)
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_QUERY_RESULTS_VALUES_MATCHED,
						CoreConstants.PASS, MYLOConstants.TRANSFEREE_NAME, MYLOConstants.TRANSFEREE_NAME_QUERY,
						MYLOConstants.FIRST_NAME, fName, MYLOConstants.LAST_NAME, lName));
			CoreFunctions.click(driver, _newQueryBtn, MYLOConstants.NEW_QUERY);
			CoreFunctions.click(driver, _transfereeNameBtn, MYLOConstants.TRANSFEREE_NAME);
		}
	}

	/**
	 * Verify Searched Transferee Name in Transferee Name Query results
	 * 
	 * @param fName
	 * @param lName
	 * @return
	 */
	public boolean verifySearchedTransfereeName(String fName, String lName) {
		boolean flag = false;
		if (fName.equals(""))
			flag = getTransfereeNameFromQueryResult(MYLOConstants.LAST_NAME).stream()
					.allMatch(x -> x.contains(lName.toLowerCase()));
		else if (lName.equals(""))
			flag = getTransfereeNameFromQueryResult(MYLOConstants.FIRST_NAME).stream()
					.allMatch(x -> x.contains(fName.toLowerCase()));
		else
			flag = getTransfereeNameFromQueryResult(MYLOConstants.LAST_NAME).stream()
					.allMatch(x -> x.contains(fName.toLowerCase()))
					& getTransfereeNameFromQueryResult(MYLOConstants.FIRST_NAME).stream()
							.allMatch(x -> x.contains(lName.toLowerCase()));
		return flag;

	}

	/**
	 * Get TransfereeName from Transferee Name Query results as per FirstName or
	 * Lastname
	 * 
	 * @param parameter
	 * @return
	 */
	public List<String> getTransfereeNameFromQueryResult(String parameter) {
		List<String> transfereeNames = new ArrayList<String>();
		int maxRecords = Integer.parseInt(CoreFunctions.getPropertyFromConfig("maxRecordsToValidate"));
		int index = (parameter.equals(MYLOConstants.FIRST_NAME)) ? 1 : 0;
		try {
			transfereeNames = _tNamesQueryResult.stream().limit(maxRecords)
					.map(x -> CoreFunctions.getElementText(driver, x).split(",")[index].toLowerCase())
					.collect(Collectors.toList());
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_VERFY, MYLOConstants.QUERY_RESULTS));
		}
		return transfereeNames;
	}

	/**
	 * Verify "No Such File Found" for invalid Transferee Names
	 * 
	 * @param table
	 * @param msg
	 */
	public void verifyTransfereeNameNotExist(DataTable table, String msg) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			setTransfereeName(MYLOConstants.FIRST_NAME, data.get(MYLOConstants.FIRST_NAME),
					MYLOConstants.RANDOM_STRING);
			setTransfereeName(MYLOConstants.LAST_NAME, data.get(MYLOConstants.LAST_NAME), MYLOConstants.RANDOM_STRING);
			clickButtonsOnTransfereeNameQuerySection(MYLOConstants.EXECUTE);
			BusinessFunctions.verifyMyloPopUpMessage(driver, _errorPopUpText, msg, MYLOConstants.JOURNEY);
			CoreFunctions.clickUsingJS(driver, _OKButtonPopUp, MYLOConstants.OK_BUTTON);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		}
	}

	/**
	 * Click on Close Icon available on Transferee Query Section
	 */
	public void clickCloseIcon() {
		CoreFunctions.click(driver, _transfereeNameQueryCloseIcon, MYLOConstants.CLOSE_BUTTON);
		BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
	}

	/**
	 * Verify Transferee Name Query Pop Up is displayed or not
	 * 
	 * @return
	 */
	public boolean verifyTransfereeNameQueryPopUpDisplayed() {
		boolean flag = CoreFunctions.isElementExist(driver, _transfereeNameQueryPopUp, 5);
		return flag;
	}

	/**
	 * Verify button is enable or disable on Transferee Name Query popUp based on
	 * button name passed as a parameter
	 * 
	 * @param btnName
	 */
	public void verifyTNameQueryButtonEnabilityStatus(String btnName) {
		try {
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, _transfereeNameQueryButtons,
					btnName);
			BusinessFunctions.verifyMyloButtonEnabilityStatus(MYLOConstants.DISABLE, element, btnName,
					MYLOConstants.TRANSFEREE_NAME_QUERY, MYLOConstants.JOURNEY);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}
	}
}
