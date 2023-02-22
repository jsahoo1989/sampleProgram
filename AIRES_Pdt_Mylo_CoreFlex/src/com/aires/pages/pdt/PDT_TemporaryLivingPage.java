package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_TemporaryLivingBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_TemporaryLivingPage extends PDT_SharedSubBenefitPage {
	public PDT_TemporaryLivingPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-lodging//label[contains(text(),'Duration (Days)')]")
	private WebElement _lblDurationLodging;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging input[formcontrolname='duration']")
	private WebElement _txtBoxLodgingDuration;
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-lodging//label[contains(text(),'Max. Amount')]")
	private WebElement _lblMaxAmtLodging;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _drpDownMaxAmtLodging;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownMaxAmtLodgingOptions;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtLodgingOptionsSelected;
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-lodging//label[contains(text(),'Flat Amount')]")
	private WebElement _lblFlatAmount;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging input[formcontrolname='flatAmount']")
	private WebElement _txtBoxFlatAmount;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownCurrencyOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionsSelected;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-clear-wrapper")
	private WebElement _clearCurrency;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging label.form-check-label")
	private List<WebElement> _radioBtnTempLivingLodging;

	@FindBy(how = How.CSS, using = "app-temporary-living-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxTempLivingLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-temporary-living-lodging textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaTempLivingLodgingComment;
	
	//Temp Living Meals
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-meals//label[contains(text(),'Duration (Days)')]")
	private WebElement _lblDurationMeals;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals input[formcontrolname='duration']")
	private WebElement _txtBoxMealsDuration;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-meals//label[text()='Max. Amount']")
	private WebElement _lblMaxAmtMeals;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmtMeals;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownMaxAmtMealsOptions;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals ng-select[formcontrolname='maxAmountCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtMealsOptionsSelected;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-value-label")
	private WebElement _drpDownTransfereeCurrencyOptionSelected;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountAdult']")
	private WebElement _txtBoxMaxAmtAdult;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailAdultCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailAdult;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult']")
	private WebElement _drpDownAdultCurrency;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownAdultCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-value-label")
	private WebElement _drpDownAdultCurrencyOptionSelected;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Children')]")
	private WebElement _lblMaxAmtChildren;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountChild']")
	private WebElement _txtBoxMaxAmtChild;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailChildCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailChild;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild']")
	private WebElement _drpDownCurrencyCodeChild;

	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownCurrencyCodeChildOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-value-label")
	private WebElement _drpDownCurrencyCodeChildOptionSelected;	
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals label.form-check-label")
	private List<WebElement> _radioBtnTempLivingMeals;

	@FindBy(how = How.CSS, using = "app-temporary-living-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxTempLivingMealsReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-temporary-living-meals textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaTempLivingMealsComment;
	
	//Temp Living Transportation
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-transportation//label[contains(text(),'Duration (Days)')]")
	private WebElement _lblDurationTransportation;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-transportation input[formcontrolname='duration']")
	private WebElement _txtBoxTransportationDuration;
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-transportation//label[contains(text(),'Transportation Type')]")
	private WebElement _lblTransportationType;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempLivingTransportTypeList']")
	private WebElement _drpDownTransportationType;
	
	@FindBy(how = How.CSS, using = "div[role='option'] span")
	private List<WebElement> _drpDownOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempLivingTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='tlTransportTypeOther']")
	private WebElement _txtBoxTransportationTypeOther;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-transportation label.form-check-label")
	private List<WebElement> _radioBtnTempLivingTransportation;

	@FindBy(how = How.CSS, using = "app-temporary-living-transportation input[formcontrolname='paidByOther']")
	private WebElement _txtBoxTempLivingTransportationReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-temporary-living-transportation textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaTempLivingTransportationComment;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _formHeaderTempLivingLodging;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderTempLivingMeals;

	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _formHeaderTempLivingTransportation;
	
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode']")
	private WebElement _drpDownSizeClass;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='classSizeCode'] span.ng-value-label")
	private WebElement _drpDownSelectedSizeClass;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='classSizeOther']")
	private WebElement _txtBoxOtherSizeClass;
	
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='classSizeCode']/preceding-sibling::label")
	private WebElement _lblSizeClass;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='classSizeOther']/preceding-sibling::label")
	private WebElement _lblSizeClassOther;
	
	PDT_TemporaryLivingBenefit tempLivingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getTemporaryLivingDataList("Temporary Living");
	
	private String _maxAmtTempLivingLodging, _maxAmtTempLivingMeals, _sizeClass;
	private ArrayList<String> _transportType = null;
	private List<String> _expectedSizeClassList;
	String [] _sizeClassArr = new String[] {PDTConstants.MID_SIZE, PDTConstants.FULL_SIZE, PDTConstants.PREMIUM, PDTConstants.OTHER};
	
	public void setMaxAmtTempLivingLodging(String maxAmt) {
		_maxAmtTempLivingLodging = maxAmt;
	}

	public String getMaxAmtTempLivingLodging() {
		return _maxAmtTempLivingLodging;
	}
	
	public void setMaxAmtTempLivingMeals(String maxAmt) {
		_maxAmtTempLivingMeals = maxAmt;
	}

	public String getMaxAmtTempLivingMeals() {
		return _maxAmtTempLivingMeals;
	}
	
	public void setTransportType(ArrayList<String> transportTypeOptions) {
		this._transportType = transportTypeOptions;
	}

	public ArrayList<String> getTransportType() {
		return _transportType;
	}
	
	public void setSizeClassList(){
		_expectedSizeClassList = Arrays.asList(_sizeClassArr);
	}
	
	public List<String> getExpectedSizeClassList(){
		return _expectedSizeClassList;
	}
	
	public void setSizeClass(String sizeClass) {
		_sizeClass = sizeClass;
	}

	public String getSizeClass() {
		return _sizeClass;
	}
	
	/**
	 * Add the Form Header of Temporary Living Transportation, Temporary Living Lodging & Temporary Living Meals in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.TEMPORARY_LIVING_LODGING, _formHeaderTempLivingLodging);
		subBenefitHeaderMap.put(PDTConstants.TEMPORARY_LIVING_MEALS, _formHeaderTempLivingMeals);
		subBenefitHeaderMap.put(PDTConstants.TEMPORARY_LIVING_TRANSPORTATION, _formHeaderTempLivingTransportation);
	}
	
	public void checkIfFlatAmtIsSelectedForLodging(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (_drpDownMaxAmtLodgingOptionsSelected.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
			verifyAndFillFlatAmount(addNewPolicyPage, subBenefitFormName);
			verifyAndFillDetail(addNewPolicyPage, subBenefitFormName);
			verifyAndFillCurrency(addNewPolicyPage, subBenefitFormName);
		}
	}
	
	public void verifyAndFillFlatAmount(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxFlatAmount, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblFlatAmount.getText(), subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxFlatAmount, _lblFlatAmount.getText(),
						tempLivingBenefitData.temporaryLivingLodging.flatAmount);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.CURRENCY, subBenefitFormName));
		}
	}
	
	public void verifyAndFillDetail(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementListExist(driver, _radioBtnTempLivingLodging, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_RADIO_BTN_DISPLAYED,
						CoreConstants.PASS, PDTConstants.DETAIL, subBenefitFormName));
				CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingLodging,
						tempLivingBenefitData.temporaryLivingLodging.detail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.DETAIL, subBenefitFormName));
		}
	}
	
	public void verifyDefaultCurrency(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if(_drpDownCurrencyOptionsSelected.getText().equalsIgnoreCase(PDTConstants.DEFAULT_CURRENCY)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_CURR_SELECTED,
					CoreConstants.PASS, PDTConstants.DEFAULT_CURRENCY, subBenefitFormName));			
		}
	}
	
	public void verifyAndFillCurrency(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _drpDownCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				verifyDefaultCurrency(addNewPolicyPage, subBenefitFormName);
				CoreFunctions.clickElement(driver, _drpDownCurrency);
				CoreFunctions.explicitWaitTillElementListClickable(driver, _drpDownCurrencyOptions);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
						tempLivingBenefitData.temporaryLivingLodging.currencyCode,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.FLAT_AMT, subBenefitFormName));
		}
	}
	
	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		if (_drpDownMaxAmtMealsOptionsSelected.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
			verifyAndFillTransfereeMealInfo(addNewPolicyPage, subBenefitFormName);
			verifyAndFillAdultMealInfo(addNewPolicyPage, subBenefitFormName);
			verifyAndFillChildMealInfo(addNewPolicyPage, subBenefitFormName);
		}
	}

	public void verifyAndFillTransfereeMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtTransferee, 1)
					& CoreFunctions.isElementExist(driver, _drpDownTransfereeCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtTransferee.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtTransferee, _lblMaxAmtTransferee.getText(),
						tempLivingBenefitData.temporaryLivingMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtTransfereeCurrency,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.TRANSFEREE_INFO, subBenefitFormName));
		}
	}

	public void verifyAndFillAdultMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtAdult, 1)
					& CoreFunctions.isElementExist(driver, _drpDownAdultCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtOtherAdults.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtAdult, _lblMaxAmtOtherAdults.getText(),
						tempLivingBenefitData.temporaryLivingMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.ADULT_INFO, subBenefitFormName));
		}
	}

	public void verifyAndFillChildMealInfo(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _txtBoxMaxAmtChild, 1)
					& CoreFunctions.isElementExist(driver, _drpDownCurrencyCodeChild, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, _lblMaxAmtChildren.getText(), subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtChild, _lblMaxAmtChildren.getText(),
						tempLivingBenefitData.temporaryLivingMeals.maxAmtChild);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtChildDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						tempLivingBenefitData.temporaryLivingMeals.maxAmtChildCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_INFO, CoreConstants.FAIL, PDTConstants.CHILDREN_INFO, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Temporary Living Lodging Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillTemporaryLivingLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxLodgingDuration, _lblDurationLodging.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxLodgingDuration, _lblDurationLodging.getText(),
					tempLivingBenefitData.temporaryLivingLodging.durationInDays);
			
			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownMaxAmtLodging, _drpDownMaxAmtLodgingOptions,
					_drpDownMaxAmtLodgingOptionsSelected, _lblMaxAmtLodging.getText());
			setMaxAmtTempLivingLodging(maxAmt);
			checkIfFlatAmtIsSelectedForLodging(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnTempLivingLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingLodging,
					tempLivingBenefitData.temporaryLivingLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingLodging,
					tempLivingBenefitData.temporaryLivingLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					tempLivingBenefitData.temporaryLivingLodging.reimbursedBy,
					_txtBoxTempLivingLodgingReimbursedByOther,
					tempLivingBenefitData.temporaryLivingLodging.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingLodgingComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Temporary Living Meals Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillTemporaryLivingMealsForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMealsDuration, _lblDurationMeals.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMealsDuration, _lblDurationMeals.getText(),
					tempLivingBenefitData.temporaryLivingMeals.durationInDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingMeals,
					tempLivingBenefitData.temporaryLivingMeals.type, _lblType.getText(), PDTConstants.RADIO_BUTTON_LIST,
					true);
			String maxAmt = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownMaxAmtMeals, _drpDownMaxAmtMealsOptions,
					_drpDownMaxAmtMealsOptionsSelected, _lblMaxAmtMeals.getText());
			setMaxAmtTempLivingMeals(maxAmt);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingMeals,
					tempLivingBenefitData.temporaryLivingMeals.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingMeals,
					tempLivingBenefitData.temporaryLivingMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					tempLivingBenefitData.temporaryLivingMeals.reimbursedBy,
					_txtBoxTempLivingMealsReimbursedByOther,
					tempLivingBenefitData.temporaryLivingMeals.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingMealsComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingMeals.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void selectRandomTransportTypeOption(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);

			ArrayList<String> randTransportTypeOption = CoreFunctions.getMultipleRandomOptionsForDropDown(0,
					_drpDownOptions.size(), 4, driver, _drpDownOptions);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.TRANSPORTATION_TYPE,
					_drpDownTransportationType, _drpDownOptions,
					_drpDownTransportationTypeMultiSelectOptions, randTransportTypeOption, subBenefitFormName);
			if (_drpDownTransportationTypeMultiSelectOptions.size() > 1) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, _lblTransportationType.getText(),
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
								.toString()));
			}
			setTransportType(randTransportTypeOption);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));
		}
	}
	
	public void verifyAndSelectSizeClassDropDown(PDT_SharedSubBenefit_Steps sharedSubBenefitStep, String subBenefitFormName) {
		if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
				.contains(PDTConstants.RENTAL_CAR)) {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					CoreFunctions.verifyElementPresentOnPage(_lblSizeClass, PDTConstants.LABEL,
							PDTConstants.SIZE_CLASS),
					MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL,
							PDTConstants.LABEL, PDTConstants.SIZE_CLASS));
			
			sharedSubBenefitStep.getCustomSoftAssertObj()
			.assertTrue(CoreFunctions.verifyElementPresentOnPage(_drpDownSizeClass,
					PDTConstants.DROP_DOWN, PDTConstants.SIZE_CLASS), MessageFormat.format(PDTConstants.VRFIED_ELE_TYPE_NOT_AVAILABLE, CoreConstants.FAIL, PDTConstants.DROP_DOWN, PDTConstants.SIZE_CLASS));
		
			CoreFunctions.clickElement(driver, _drpDownSizeClass);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptions)
					.equals(getExpectedSizeClassList())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROPDOWN, CoreConstants.PASS, _lblSizeClass.getText(), getExpectedSizeClassList().toString()));
			}
			String randSizeClass = _drpDownOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownOptions,
					randSizeClass, _lblSizeClass.getText(), PDTConstants.DROP_DOWN, true);
			setSizeClass(randSizeClass);
			
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					tempLivingBenefitData.temporaryLivingTransportation.sizeClass,
					_txtBoxOtherSizeClass,
					tempLivingBenefitData.temporaryLivingTransportation.sizeClassOther, subBenefitFormName,
					PDTConstants.SIZE_CLASS_OTHER);
		}
		
	}
	
	/**
	 * Fill Temporary Living Transportation Form
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillTemporaryLivingTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxTransportationDuration, _lblDurationTransportation.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxTransportationDuration, _lblDurationTransportation.getText(),
					tempLivingBenefitData.temporaryLivingTransportation.durationInDays);
			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			verifyAndSelectSizeClassDropDown(sharedSubBenefitStep, subBenefitFormName);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingTransportation,
					tempLivingBenefitData.temporaryLivingTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingTransportation,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedBy,
					_txtBoxTempLivingTransportationReimbursedByOther,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingTransportationComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Final Move sub-benefit based on sub-benefit name
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param subBenefitPage
	 */
	public void fillTemporaryLivingSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage, PDT_SharedSubBenefit_Steps objStep) {		
		switch (subBenefit) {
		case PDTConstants.TEMPORARY_LIVING_TRANSPORTATION:
			fillTemporaryLivingTransportationForm(addNewPolicyPage, subBenefit, pageName, objStep);
			break;
		case PDTConstants.TEMPORARY_LIVING_LODGING:
			fillTemporaryLivingLodgingForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.TEMPORARY_LIVING_MEALS:
			fillTemporaryLivingMealsForm(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Temporary Living sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillTempLivingSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			waitForProgressBarToDisapper();
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillTemporaryLivingSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage, objStep);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
}