package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.mylo.Mylo_DropDownFieldData;
import com.vimalselvam.cucumber.listener.Reporter;
import cucumber.api.DataTable;

public class MyloJourneyPage_TaxReportingSection extends Base {

	public MyloJourneyPage_TaxReportingSection(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//app-expense-taxes/descendant::i[@class='icon-Pencil_Open']/parent::button")
	private WebElement _taxReportingEditBtn;

	@FindBy(how = How.XPATH, using = "//app-expense-taxes/descendant::i[@class='icon-FloppyDisk_Open']/parent::button")
	private WebElement _taxReportingSaveBtn;

	@FindBy(how = How.ID, using = "ExpenseMgmt")
	private WebElement _taxReportingExpnseMgmtCheckBox;

	@FindBy(how = How.CSS, using = "#ExpenseMgmt+span")
	private WebElement _taxReportingExpnseMgmt;

	@FindBy(how = How.CSS, using = "input[placeholder='Salary']")
	private WebElement _taxReportingSalary;

	@FindBy(how = How.CSS, using = "input[placeholder='Estimated Itemized Amount']")
	private WebElement _taxReportingEstimatedItemizedAmount;

	@FindBy(how = How.CSS, using = "input[placeholder='Salary Comments']")
	private WebElement _taxReportingSalaryComments;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familySize']")
	private WebElement _taxReportingFamilySizeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='familySize'] span[class='ng-value-label']")
	private WebElement _taxReportingFamilySizeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='dependentSize']")
	private WebElement _taxReportingDependentSizeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='dependentSize'] span[class='ng-value-label']")
	private WebElement _taxReportingDependentSizeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='salaryCurrencyCode']")
	private WebElement _taxReportingSalaryCurrencyDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='salaryCurrencyCode'] span[class='ng-value-label']")
	private WebElement _taxReportingSalaryCurrencyDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='dependentUnderSeventeenSize']")
	private WebElement _taxReportingDependentUnder17SizeDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='dependentUnderSeventeenSize'] span[class='ng-value-label']")
	private WebElement _taxReportingDependentUnder17SizeDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='trueHomeCountryCode']")
	private WebElement _taxReportingTrueHomeCountryDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='trueHomeCountryCode'] span[class='ng-value-label']")
	private WebElement _taxReportingTrueHomeCountryDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='filingStatusCode']")
	private WebElement _taxReportingFilingStatusDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='filingStatusCode'] span[class='ng-value-label']")
	private WebElement _taxReportingFilingStatusDropdownValue;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='transfereeDeduction']")
	private WebElement _taxReportingDeductionMethodDropdown;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='transfereeDeduction'] span[class='ng-value-label']")
	private WebElement _taxReportingDeductionMethodDropdownValue;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _popUpMessage;

	@FindBy(how = How.CSS, using = "input[placeholder='Updated By']")
	private WebElement _taxReportingUpdatedBy;

	private final By _dropdownOptions = By.cssSelector("div[role='option']>span");

	LinkedHashMap<String, WebElement> taxReportingWebElementsMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, WebElement> taxReportingWebElementsValuesMap = new LinkedHashMap<String, WebElement>();
	LinkedHashMap<String, String> taxReportingUpdatedFieldsValueMap = new LinkedHashMap<String, String>();
	LinkedHashMap<String, List<String>> taxReportingDropdownOptionsMap = new LinkedHashMap<String, List<String>>();
	LinkedHashMap<String, List<String>> taxReportingExpectedDropdownOptionsMap = new LinkedHashMap<String, List<String>>();
	Set<String> taxReportingFreeTextFieldList = new HashSet<String>();

	public void mapTaxReportingWebElements() {
		taxReportingWebElementsMap.put(MYLOConstants.FAMILY_SIZE, _taxReportingFamilySizeDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.TOTAL_NUMBER_OF_DEPENDENT, _taxReportingDependentSizeDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.SALARY_CURRENCY, _taxReportingSalaryCurrencyDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.DEPENDENT_UNDER_17, _taxReportingDependentUnder17SizeDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.TRUE_HOME_COUNTRY, _taxReportingTrueHomeCountryDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.FILING_STATUS, _taxReportingFilingStatusDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.DEDUCTION_METHOD, _taxReportingDeductionMethodDropdown);
		taxReportingWebElementsMap.put(MYLOConstants.EDIT_BUTTON, _taxReportingEditBtn);
		taxReportingWebElementsMap.put(MYLOConstants.SAVE_BUTTON, _taxReportingSaveBtn);
		taxReportingWebElementsMap.put(MYLOConstants.EXPENSE_MANAGEMENT_CHECKBOX, _taxReportingExpnseMgmtCheckBox);
		taxReportingWebElementsMap.put(MYLOConstants.EXPENSE_MANAGEMENT, _taxReportingExpnseMgmt);
		taxReportingWebElementsMap.put(MYLOConstants.SALARY, _taxReportingSalary);
		taxReportingWebElementsMap.put(MYLOConstants.SALARY_COMMENTS, _taxReportingSalaryComments);
		taxReportingWebElementsMap.put(MYLOConstants.ESTIMATED_ITEMIZED_AMOUNT, _taxReportingEstimatedItemizedAmount);
		taxReportingFreeTextFieldList.add(MYLOConstants.SALARY);
		taxReportingFreeTextFieldList.add(MYLOConstants.ESTIMATED_ITEMIZED_AMOUNT);
		taxReportingFreeTextFieldList.add(MYLOConstants.SALARY_COMMENTS);
	}

	public void taxReportingButtonEnabilityStatus(String type, String btnName) {
		mapTaxReportingWebElements();
		BusinessFunctions.verifyMyloButtonEnabilityStatus(type, taxReportingWebElementsMap.get(btnName), btnName,
				MYLOConstants.TAX_REPORTING_SECTION, MYLOConstants.JOURNEY);
	}

	public void clickFieldsOnTaxReportingSection(String fieldName) {
		mapTaxReportingWebElements();
		try {
			WebElement element = taxReportingWebElementsMap.get(fieldName);
			CoreFunctions.highlightElementAndClick(driver, element, fieldName);
			CoreFunctions.waitForMyloSpinnnerInvisibilityIfExist(driver, _spinner);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
	}

	public boolean checkBoxIsSelectedOnTaxReportingSection(String fieldName) {
		boolean flag = false;
		mapTaxReportingWebElements();
		try {
			WebElement element = taxReportingWebElementsMap.get(fieldName);
			CoreFunctions.highlightObject(driver, element);
			flag = element.isSelected();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
		return flag;
	}

	public boolean verifyPopUpMessage(String msg) {
		return BusinessFunctions.verifyMyloPopUpMessage(driver, _popUpMessage, msg, MYLOConstants.JOURNEY);
	}

	public void saveDropdownOptionsListOnTaxReportingSection(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			clickFieldsOnTaxReportingSection(fieldName);
			List<WebElement> dropdownOptionWebelementsList = CoreFunctions.getElementListByLocator(driver,
					_dropdownOptions);
			List<String> optionsDisplayed = dropdownOptionWebelementsList.stream().map(x -> x.getText().trim())
					.collect(Collectors.toList());
			taxReportingDropdownOptionsMap.put(fieldName, optionsDisplayed);
		}
	}

	public List<String> getDropdownListOptions(String fieldName) {
		Mylo_DropDownFieldData myloDropDownList = FileReaderManager.getInstance().getMyloJsonReader()
				.getDropDownListByFieldName(fieldName);
		List<String> optionList = Arrays.asList(myloDropDownList.value.split(";")).stream().map(String::trim)
				.collect(Collectors.toList());
		return optionList;
	}

	public List<String> getSequenceNo(int min, int max) {
		List<Integer> list2 = IntStream.iterate(min, i -> i + 1).limit(max + 1).boxed().collect(Collectors.toList());
		List<String> newList = list2.stream().map(String::valueOf).collect(Collectors.toList()).stream()
				.map(String::trim).collect(Collectors.toList());
		newList.add(0, MYLOConstants.SELECT_ONE);
		return newList;

	}

	public void saveExpectedDropdownOptionsMap() {
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.FAMILY_SIZE, getSequenceNo(1, 9));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.TOTAL_NUMBER_OF_DEPENDENT, getSequenceNo(0, 20));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.SALARY_CURRENCY,
				getDropdownListOptions(MYLOConstants.SALARY_CURRENCY));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.DEPENDENT_UNDER_17, getSequenceNo(0, 20));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.TRUE_HOME_COUNTRY,
				getDropdownListOptions(MYLOConstants.TRUE_HOME_COUNTRY));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.FILING_STATUS,
				getDropdownListOptions(MYLOConstants.FILING_STATUS));
		taxReportingExpectedDropdownOptionsMap.put(MYLOConstants.DEDUCTION_METHOD,
				getDropdownListOptions(MYLOConstants.DEDUCTION_METHOD));
	}

	public void verifyDropDownListOnTaxReportInfo(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			Assert.assertTrue(verifyTaxReportingInformationDropDownList(fieldName),
					MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_DOESNT_MATCH, CoreConstants.FAIL,
							fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
	}

	public boolean verifyTaxReportingInformationDropDownList(String fieldName) {
		saveExpectedDropdownOptionsMap();
		boolean flag = taxReportingDropdownOptionsMap.get(fieldName)
				.equals(taxReportingExpectedDropdownOptionsMap.get(fieldName));
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_DROPDOWN_OPTIONS_MATCHES,
					CoreConstants.PASS, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		return flag;
	}

	public String getUpdatedValueForTaxReportingSectionField(String fieldValue) {
		String updatedValue = "";
		try {
			updatedValue = (fieldValue.equals(MYLOConstants.RANDOM))
					? (CoreFunctions.generateRandomNumberAsGivenLength(4))
					: (CoreFunctions.generateRandomNumberAsGivenLength((Integer.parseInt(fieldValue))));
		} catch (NumberFormatException e) {
			updatedValue = fieldValue;
		}

		return updatedValue;
	}

	public void setFreeTextTaxReportingSectionFields(String fieldName, String fieldValue) {
		mapTaxReportingWebElements();
		String updatedValue = getUpdatedValueForTaxReportingSectionField(fieldValue);
		WebElement reqWebElement = taxReportingWebElementsMap.get(fieldName);
		try {
			CoreFunctions.clearAndSetText(driver, reqWebElement, fieldName, updatedValue);
			taxReportingUpdatedFieldsValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
	}

	public void setDifferentDropDownFieldsOnTaxReportingSection(String fieldName, String fieldValue) {
		String updatedValue = null;
		clickFieldsOnTaxReportingSection(fieldName);
		try {
			List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, _dropdownOptions);
			updatedValue = CoreFunctions.setDifferentDropDownFieldsForMylo(driver, fieldValue, optionList);
			taxReportingUpdatedFieldsValueMap.put(fieldName, updatedValue);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
	}

	public void setTaxReportingFieldValues(String fieldName, String fieldValue) {
		if (taxReportingFreeTextFieldList.contains(fieldName))
			setFreeTextTaxReportingSectionFields(fieldName, fieldValue);
		else
			setDifferentDropDownFieldsOnTaxReportingSection(fieldName, fieldValue);

	}

	public void setValuesOnTaxReportingSection(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String fieldValue = data.get(i).get(MYLOConstants.FIELD_VALUE);
			setTaxReportingFieldValues(fieldName, fieldValue);
		}
	}

	public void mapTaxReportingWebElementsValues() {
		taxReportingWebElementsValuesMap.put(MYLOConstants.FAMILY_SIZE, _taxReportingFamilySizeDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.TOTAL_NUMBER_OF_DEPENDENT,
				_taxReportingDependentSizeDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.SALARY_CURRENCY, _taxReportingSalaryCurrencyDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.DEPENDENT_UNDER_17,
				_taxReportingDependentUnder17SizeDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.TRUE_HOME_COUNTRY,
				_taxReportingTrueHomeCountryDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.FILING_STATUS, _taxReportingFilingStatusDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.DEDUCTION_METHOD, _taxReportingDeductionMethodDropdownValue);
		taxReportingWebElementsValuesMap.put(MYLOConstants.SALARY, _taxReportingSalary);
		taxReportingWebElementsValuesMap.put(MYLOConstants.SALARY_COMMENTS, _taxReportingSalaryComments);
		taxReportingWebElementsValuesMap.put(MYLOConstants.ESTIMATED_ITEMIZED_AMOUNT,
				_taxReportingEstimatedItemizedAmount);
	}

	public String getTaxReportingInfoValue(String fieldName) {
		mapTaxReportingWebElementsValues();
		String requiredValue = "";
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, taxReportingWebElementsValuesMap.get(fieldName),
					fieldName);
			requiredValue = (fieldName.equals(MYLOConstants.SALARY)
					|| fieldName.equals(MYLOConstants.ESTIMATED_ITEMIZED_AMOUNT)
					|| fieldName.equals(MYLOConstants.SALARY_COMMENTS))
							? CoreFunctions.getAttributeText(taxReportingWebElementsValuesMap.get(fieldName),
									MYLOConstants.VALUE).split("\\.")[0].replace(",", "")
							: CoreFunctions.getElementText(driver, taxReportingWebElementsValuesMap.get(fieldName));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, fieldName, MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					fieldName, MYLOConstants.TAX_REPORTING_SECTION));
		}
		return requiredValue;
	}

	public void verifyDifferentTaxReportingFieldsUpdatedValue(DataTable table) {
		java.util.List<Map<String, String>> data = table.asMaps(String.class, String.class);
		for (int i = 0; i < data.size(); i++) {
			String fieldName = data.get(i).get(MYLOConstants.FIELD_NAME);
			String updatedValue = ((fieldName.equals(MYLOConstants.SALARY)
					|| fieldName.equals(MYLOConstants.ESTIMATED_ITEMIZED_AMOUNT))
					&& taxReportingUpdatedFieldsValueMap.get(fieldName).length() > 8)
							? taxReportingUpdatedFieldsValueMap.get(fieldName).substring(0, 8)
							: taxReportingUpdatedFieldsValueMap.get(fieldName);
			Assert.assertEquals(getTaxReportingInfoValue(fieldName), updatedValue,
					MessageFormat.format(MYLOConstants.FAILED_TO_VERIFY_UPDATED_VALUE, CoreConstants.FAIL, fieldName,
							MYLOConstants.TAX_REPORTING_SECTION));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_FIELD_VALUE, CoreConstants.PASS,
					fieldName, updatedValue, MYLOConstants.TAX_REPORTING_SECTION));
		}
	}

	public boolean verifyUpdatedByField(String userName) {
		mapTaxReportingWebElementsValues();
		String currentDate = CoreFunctions.getCurrentDateAsGivenFormat("d MMM YYY");
		boolean flag = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _taxReportingUpdatedBy,
					_taxReportingUpdatedBy.getAttribute("placeholder"));
			flag = (CoreFunctions.getAttributeText(_taxReportingUpdatedBy, MYLOConstants.VALUE))
					.contains(userName + " on " + currentDate);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
							_taxReportingUpdatedBy.getAttribute("placeholder"), MYLOConstants.TAX_REPORTING_SECTION));
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_taxReportingUpdatedBy.getAttribute("placeholder"), MYLOConstants.TAX_REPORTING_SECTION));
		}

		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFY_UPDATED_USER_DATE, CoreConstants.PASS,
					userName, currentDate, MYLOConstants.TAX_REPORTING_SECTION));
		return flag;
	}

}
