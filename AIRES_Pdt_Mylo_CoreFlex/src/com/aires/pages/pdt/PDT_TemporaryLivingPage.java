package com.aires.pages.pdt;

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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_TemporaryLivingBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_TemporaryLivingPage extends Base {
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
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownMaxAmtLodgingOptions;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownMaxAmtLodgingOptionsSelected;
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-lodging//label[contains(text(),'Flat Amount')]")
	private WebElement _lblFlatAmount;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-lodging input[formcontrolname='flatAmount']")
	private WebElement _txtBoxFlatAmount;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownCurrencyOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownCurrencyOptionsSelected;
	
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
	
	@FindBy(how = How.XPATH, using = "//app-temporary-living-meals//label[text()='Max. Amount ']")
	private WebElement _lblMaxAmtMeals;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _drpDownMaxAmtMeals;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownMaxAmtMealsOptions;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-meals ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownMaxAmtMealsOptionsSelected;
	
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Max. Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
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
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeAdult'] span.ng-option-label")
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

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeChild'] span.ng-option-label")
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
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempLivingTransportTypeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownTransportationTypeOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempLivingTransportTypeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;
	
	@FindBy(how = How.CSS, using = "input[formcontrolname='tlTransportTypeOther']")
	private WebElement _txtBoxTransportationTypeOther;
	
	@FindBy(how = How.CSS, using = "app-temporary-living-transportation label.form-check-label")
	private List<WebElement> _radioBtnTempLivingTransportation;

	@FindBy(how = How.CSS, using = "app-temporary-living-transportation input[formcontrolname='paidByOther']")
	private WebElement _txtBoxTempLivingTransportationReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-temporary-living-transportation textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaTempLivingTransportationComment;
	
	PDT_TemporaryLivingBenefit tempLivingBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getTemporaryLivingDataList("Temporary Living");
	
	private String maxAmtTempLivingLodging, maxAmtTempLivingMeals, transportType;
	
	public void setMaxAmtTempLivingLodging(String maxAmt) {
		maxAmtTempLivingLodging = maxAmt;
	}

	public String getMaxAmtTempLivingLodging() {
		return maxAmtTempLivingLodging;
	}
	
	public void setMaxAmtTempLivingMeals(String maxAmt) {
		maxAmtTempLivingMeals = maxAmt;
	}

	public String getMaxAmtTempLivingMeals() {
		return maxAmtTempLivingMeals;
	}
	
	public void setTransportType(String transType) {
		transportType = transType;
	}
	
	public String getTransportType() {
		return transportType;
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
	
	public void verifyAndFillCurrency(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (CoreFunctions.isElementExist(driver, _drpDownCurrency, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clickElement(driver, _drpDownCurrency);
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
	
	public void fillTemporaryLivingLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
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
			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					tempLivingBenefitData.temporaryLivingLodging.reimbursedBy,
					_txtBoxTempLivingLodgingReimbursedByOther,
					tempLivingBenefitData.temporaryLivingLodging.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingLodgingComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingLodging.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillTemporaryLivingMealsForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
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

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					tempLivingBenefitData.temporaryLivingMeals.reimbursedBy,
					_txtBoxTempLivingMealsReimbursedByOther,
					tempLivingBenefitData.temporaryLivingMeals.reimbursedByOther, subBenefitFormName);

			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingMealsComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingMeals.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void selectRandomTransportTypeOption(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			String randTransportTypeOption = CoreFunctions
					.getRandomAndUniqueMultipleSelectDropDownOptions(_drpDownTransportationTypeOptions);
			String[] transportationType = randTransportTypeOption.split(",");
			for (int i = 0; i < transportationType.length; i++) {
				CoreFunctions.selectItemInListByText(driver, _drpDownTransportationTypeOptions,
						transportationType[i].trim(), _lblTransportationType.getText(), PDTConstants.DROP_DOWN, true);
			}
			if (_drpDownTransportationTypeMultiSelectOptions.size() > 1) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, _lblTransportationType.getText(),
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownTransportationTypeMultiSelectOptions)
								.toString()));
			}
			setTransportType(randTransportTypeOption);
			if (_drpDownTransportationTypeMultiSelectOptions.contains(PDTConstants.OTHER) && CoreFunctions.isElementExist(driver, _txtBoxTransportationTypeOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.OTHER, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, _txtBoxTransportationTypeOther, PDTConstants.OTHER,
						tempLivingBenefitData.temporaryLivingTransportation.transportationTypeOther);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));
		}
	}
	
	public void fillTemporaryLivingTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxTransportationDuration, _lblDurationTransportation.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxTransportationDuration, _lblDurationTransportation.getText(),
					tempLivingBenefitData.temporaryLivingTransportation.durationInDays);
			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingTransportation,
					tempLivingBenefitData.temporaryLivingTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTempLivingTransportation,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedBy,
					_txtBoxTempLivingTransportationReimbursedByOther,
					tempLivingBenefitData.temporaryLivingTransportation.reimbursedByOther, subBenefitFormName);

			CoreFunctions.clearAndSetText(driver, _txtAreaTempLivingTransportationComment, PDTConstants.COMMENT,
					tempLivingBenefitData.temporaryLivingTransportation.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
}