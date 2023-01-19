package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

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
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_AdvancedQuerySection extends Base {

	public MyloJourneyPage_AdvancedQuerySection(WebDriver driver) {
		super(driver);
	}

	// WebElements related to Advanced Query section

	@FindBy(how = How.CSS, using = "app-advance-query")
	private WebElement _advancedQueryPopUp;

	@FindBy(how = How.CSS, using = "app-advance-query input")
	private List<WebElement> _advancedQueryInputFields;

	@FindBy(how = How.CSS, using = "app-advance-query ng-select")
	private List<WebElement> _advancedQueryDropdownFields;

	@FindBy(how = How.CSS, using = "app-advance-query a")
	private List<WebElement> _advancedQueryTabFields;

	@FindBy(how = How.CSS, using = "app-advance-query button")
	private List<WebElement> _advancedQueryButtons;

	// WebElements related to Journey Page

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "button[class*='toast-close-btn']")
	private WebElement _closeBtn;

	@FindBy(how = How.CSS, using = "div[role='alert']")
	private WebElement _alertMessage;

	private final By _dropdownOptions = By.xpath("//div[@role='option']/span");
	private final HashMap<String, String> advancedFieldsUpdatedValueMap = new LinkedHashMap<String, String>();
	private final List<String> realEstateFields = Stream
			.of(MYLOConstants.CITY, MYLOConstants.STREET1, MYLOConstants.STREET2, MYLOConstants.COUNTRY,
					MYLOConstants.STATEPROVINCE, MYLOConstants.STATE, MYLOConstants.ZIP_POSTAL)
			.collect(Collectors.toList());

	private final List<String> advancedQueryDropdownFieldList = Stream.of(MYLOConstants.PPC, MYLOConstants.MSpec,
			MYLOConstants.SERVICE, MYLOConstants.SERVICE_STATUS, MYLOConstants.CLIENT_NAME)
			.collect(Collectors.toList());

	LinkedHashMap<String, String> advancedQueryFieldValueMap = new LinkedHashMap<String, String>();

	public String setAdvancedQueryInputValues(String fieldName, String fieldValue, String type) {
		String updatedValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver,
					_advancedQueryInputFields, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			updatedValue = BusinessFunctions.setMyloInputFields(driver, fieldName, fieldValue, fieldElement, type);
			advancedFieldsUpdatedValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ADVANCED_QUERY));
		}
		return updatedValue;
	}

	public String setAdvancedQueryDropdownValues(String fieldName, String fieldValue) {
		String updatedValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_advancedQueryDropdownFields, fieldName.replace(" ", ""), MYLOConstants.FORMCONTROLNAME);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, fieldName);
			updatedValue = BusinessFunctions.setMyloDropdownFields(driver, _dropdownOptions, fieldValue, fieldName);
			advancedFieldsUpdatedValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ADVANCED_QUERY));
		}
		return updatedValue;
	}

	public void clickButtonsOnAdvancedQuerySection(String btnName) {
		try {
			WebElement element = BusinessFunctions.returnItemIfExistsInList(driver, _advancedQueryButtons, btnName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, btnName, 10);
			CoreFunctions.scrollClickUsingJS(driver, element, btnName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, btnName));
		}

	}

	public void clickAdvancedQueryTabsIfNeeded(String fieldName) {
		String sectionName = (realEstateFields.contains(fieldName)) ? MYLOConstants.REAL_ESTATE
				: MYLOConstants.SHIPMENT;
		WebElement tabElement = BusinessFunctions.returnItemIfExistsInList(driver, _advancedQueryTabFields,
				sectionName);
		CoreFunctions.click(driver, tabElement, sectionName);
	}

	public void verifySpecialCharactersToastMessage(DataTable table, CustomSoftAssert softAssert) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAdvancedQueryTabsIfNeeded(fieldName);
			setAdvancedQueryInputValues(fieldName, MYLOConstants.RANDOM, MYLOConstants.SPECIAL_CHARACTERS_STRING);
			clickButtonsOnAdvancedQuerySection(MYLOConstants.EXECUTE);
			softAssert.assertTrue(
					BusinessFunctions.verifyMyloToastMessage(driver, _alertMessage, data.get(MYLOConstants.MESSAGE),
							MYLOConstants.ADVANCED_QUERY),
					MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL,
							data.get(MYLOConstants.MESSAGE), _alertMessage.getText(), MYLOConstants.JOURNEY));
			CoreFunctions.clickButtonsUsingSendKeys(driver, MYLOConstants.CLOSE_BUTTON, _closeBtn,
					MYLOConstants.ADVANCED_QUERY, MYLOConstants.JOURNEY);
			setAdvancedQueryInputValues(fieldName, MYLOConstants.BLANK, MYLOConstants.BLANK);
		}
	}

	public void setFieldValueAsPerCharacterLimit(DataTable table) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAdvancedQueryTabsIfNeeded(fieldName);
			String type = (fieldName.contains(MYLOConstants.ID) || fieldName.contains(MYLOConstants.NUMBER))
					? MYLOConstants.RANDOM_INTEGER
					: MYLOConstants.RANDOM_STRING;
			setAdvancedQueryInputValues(fieldName, data.get(MYLOConstants.CHARACTER_LENGTH), type);
		}
	}

	public void verifyAdvancedQueryFieldValueEntered(DataTable table, CustomSoftAssert softAssert) {
		java.util.List<Map<String, String>> dataList = table.asMaps(String.class, String.class);
		for (Map<String, String> data : dataList) {
			String fieldName = data.get(MYLOConstants.FIELD_NAME);
			clickAdvancedQueryTabsIfNeeded(fieldName);
			int fieldCharLimit = Integer.parseInt(data.get(MYLOConstants.CHARACTER_LENGTH));
			String updatedValue = advancedFieldsUpdatedValueMap.get(fieldName).length() > fieldCharLimit
					? advancedFieldsUpdatedValueMap.get(fieldName).substring(0, fieldCharLimit)
					: advancedFieldsUpdatedValueMap.get(fieldName);
			boolean flag = (getAdvancedQueryFieldValues(fieldName).equals(updatedValue));
			softAssert.assertTrue(flag, MessageFormat.format(MYLOConstants.FIELDS_NOT_UPDATED_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.ADVANCED_QUERY));
			if (flag)
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
						fieldName, updatedValue, MYLOConstants.ADVANCED_QUERY));
			else
				Reporter.addStepLog(MessageFormat.format(MYLOConstants.VALUE_NOT_UPDATED_ON_SECTION, CoreConstants.FAIL,
						updatedValue, fieldName, MYLOConstants.ADVANCED_QUERY, MYLOConstants.JOURNEY));
		}
	}

	public String getAdvancedQueryFieldValues(String fieldName) {
		String requiredValue = "";
		try {
			WebElement fieldElement = BusinessFunctions.returnItemFromListUsingAttribute(driver,
					_advancedQueryInputFields, fieldName, MYLOConstants.PLACEHOLDER);
			CoreFunctions.scrollToElementUsingJS(driver, fieldElement, fieldName);
			CoreFunctions.explicitWaitTillElementVisibility(driver, fieldElement, fieldName);
			CoreFunctions.highlightObject(driver, fieldElement);
			requiredValue = CoreFunctions.getAttributeText(fieldElement, MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.ADVANCED_QUERY));
		}
		return requiredValue;
	}

	public boolean verifyAdvancedQueryPopUpDisplayed() {
		boolean flag = CoreFunctions.isElementExist(driver, _advancedQueryPopUp, 5);
		return flag;
	}

	public void mapAdvancedQueryFieldValueToEnter() {
		advancedQueryFieldValueMap.put(MYLOConstants.TRANSFEREE_ID, DbFunctions
				.getMyloAssignmentRequiredFieldValues(MyloNewFileUtil.getFileID(), MYLOConstants.TRANSFEREEID));
		advancedQueryFieldValueMap.put(MYLOConstants.CLIENT_ID, MyloNewFileUtil.getClientID());
		advancedQueryFieldValueMap.put(MYLOConstants.TRACKING_NUMBER, MyloNewFileUtil.get_trackingNumber());
		advancedQueryFieldValueMap.put(MYLOConstants.LEAD_COMPANY_ID, MyloNewFileUtil.get_leadCompanyID());
		advancedQueryFieldValueMap.put(MYLOConstants.TRANSFEREE_FIRST_NAME, MyloNewFileUtil.getTransfereeFirstName());
		advancedQueryFieldValueMap.put(MYLOConstants.TRANSFEREE_LAST_NAME, MyloNewFileUtil.getTransfereeLastName());
		advancedQueryFieldValueMap.put(MYLOConstants.EMAIL, MyloNewFileUtil.get_transfereeEmail());
		advancedQueryFieldValueMap.put(MYLOConstants.PPC, MyloNewFileUtil.get_ppc());
		advancedQueryFieldValueMap.put(MYLOConstants.MSpec, MyloNewFileUtil.get_mspec());
		advancedQueryFieldValueMap.put(MYLOConstants.FAMILY_FIRST_NAME, MyloNewFileUtil.get_partnerFName());
		advancedQueryFieldValueMap.put(MYLOConstants.FAMILY_LAST_NAME, MyloNewFileUtil.get_partnerLName());
		advancedQueryFieldValueMap.put(MYLOConstants.PHONE_NUMBER, MyloNewFileUtil.get_transfereePhoneNo());
	}

	public void setAdvancedFieldValueForSearch(String fields) {
		mapAdvancedQueryFieldValueToEnter();
		List<String> advancedSectionfields = Arrays.asList(fields.split(","));
		for (String fieldName : advancedSectionfields) {
			if (advancedQueryDropdownFieldList.contains(fieldName))
				setAdvancedQueryDropdownValues(fieldName, advancedQueryFieldValueMap.get(fieldName));
			else
				setAdvancedQueryInputValues(fieldName, advancedQueryFieldValueMap.get(fieldName), MYLOConstants.VALUE);
		}
	}

}
