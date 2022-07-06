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
import com.aires.testdatatypes.pdt.PDT_HouseHuntingTripBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_HouseHuntingTripPage extends Base {
	public PDT_HouseHuntingTripPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfTrip']")
	private WebElement _txtBoxNumOfTrips;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList']")
	private WebElement _drpDownTransportationType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span.ng-option-label")
	private List<WebElement> _drpDownTransportationTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='houseHuntingTripTransportTypeList'] span.ng-value-label")
	private List<WebElement> _drpDownTransportationTypeMultiSelectOptions;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageEconomy']")
	private WebElement _txtBoxMinMileageEconomy;

	@FindBy(how = How.CSS, using = "input[formcontrolname='minMileageBusiness']")
	private WebElement _txtBoxMinMileageBusiness;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMemberCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label")
	private List<WebElement> _drpDownAccompanyingFamilyMemberCodeOptions;

	@FindBy(how = How.CSS, using = "#collapseOne1 label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripTransport;

	@FindBy(how = How.CSS, using = "#collapseOne1 input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripTransportReimbursedByOther;

	@FindBy(how = How.CSS, using = "#collapseOne1 textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripTransportComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='numOfNightsPerTrip']")
	private WebElement _txtBoxNumOfNightsPerTrip;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode']")
	private WebElement _drpDownMaxAmt;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmtOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountPerNightCode'] span.ng-value-label")
	private WebElement _drpDownMaxAmtSelectedOption;

	@FindBy(how = How.CSS, using = "input[formcontrolname='flatAmountPerNight']")
	private WebElement _txtBoxFlatAmtPerNight;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyCodeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyCodeSelected;

	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripLodging;

	@FindBy(how = How.CSS, using = "app-trip-lodging input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripLodgingReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-trip-lodging textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripLodgingComment;

	@FindBy(how = How.CSS, using = "input[formcontrolname='durationPerTrip']")
	private WebElement _txtBoxDurationPerTrip;

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeals;

	@FindBy(how = How.CSS, using = "#collapseThree ng-select[formcontrolname='maxAmountCode']")
	private WebElement _drpDownMaxAmount;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='maxAmountCode'] span.ng-option-label")
	private List<WebElement> _drpDownMaxAmountOptions;

	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='maxAmountCode']/descendant::span[contains(@class,'ng-value-label')]")
	private WebElement _drpDownMaxAmountSelectedVal;

	@FindBy(how = How.CSS, using = "input[formcontrolname='maxAmountEe']")
	private WebElement _txtBoxMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='detailEeCode']/parent::label[contains(@class,'form-check-label')]")
	private List<WebElement> _radioDetailTransfereeCode;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']")
	private WebElement _drpDownTransfereeCurrency;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe'] span.ng-option-label")
	private List<WebElement> _drpDownTransfereeCurrencyOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='currencyCodeEe']  span.ng-value-label")
	private WebElement _drpDownTransfereeCurrencyOptionSelected;

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

	@FindBy(how = How.CSS, using = "#collapseThree label.form-check-label")
	private List<WebElement> _radioBtnHouseHuntingTripMeal;

	@FindBy(how = How.CSS, using = "app-trip-meals input[formcontrolname='paidByOther']")
	private WebElement _txtBoxHouseHuntingTripReimbursedByOther;

	@FindBy(how = How.CSS, using = "app-trip-meals textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaHouseHuntingTripMealComment;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Trips']")
	private WebElement _lblNoOfTrips;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Type']")
	private WebElement _lblTransportationType;

	@FindBy(how = How.XPATH, using = "//label[text()='Transportation Other']")
	private WebElement _lblTransportationOther;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minMileageEconomy']/preceding-sibling::label")
	private WebElement _lblMinMileageForEconomyAirTravel;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='minMileageBusiness']/preceding-sibling::label")
	private WebElement _lblMinMileageForBusinessAirTravel;

	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Members']")
	private WebElement _lblAccompanyingFamilyMember;

	@FindBy(how = How.XPATH, using = "//label[text()='Number of Nights per Trip']")
	private WebElement _lblNumOfNightsPerTrip;

	@FindBy(how = How.XPATH, using = "//app-trip-lodging//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmt;

	@FindBy(how = How.XPATH, using = "//label[text()='Flat Amount/Night']")
	private WebElement _lblFlatAmount;

	@FindBy(how = How.XPATH, using = "//label[text()='Currency']")
	private WebElement _lblCurrency;

	@FindBy(how = How.XPATH, using = "//label[text()='Duration per Trip (Days)']")
	private WebElement _lblDurationPerTrip;

	@FindBy(how = How.XPATH, using = "//label[text()='Type']")
	private WebElement _lblType;

	@FindBy(how = How.CSS, using = "button.btn-next[type='submit']")
	private WebElement _btnSaveAndContinue;

	@FindBy(how = How.CSS, using = "div.swal2-popup.swal2-modal.swal2-icon-success.swal2-show")
	private WebElement _successPopUp;

	@FindBy(how = How.CSS, using = "div.swal2-html-container")
	private WebElement _successMsg;

	@FindBy(how = How.CSS, using = "button.swal2-confirm.swal2-styled")
	private WebElement _btnOkOnSuccessPopUp;
	
	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max. Amount')]")
	private WebElement _lblMaxAmtHouseHuntingTripMeals;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max Amount - Transferee')]")
	private WebElement _lblMaxAmtTransferee;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max Amount - Other Adults')]")
	private WebElement _lblMaxAmtOtherAdults;

	@FindBy(how = How.XPATH, using = "//app-trip-meals//label[contains(text(), 'Max Amount - Children')]")
	private WebElement _lblMaxAmtChildren;

	PDT_HouseHuntingTripBenefit houseHuntingTripBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHouseHuntingTripDataList("House Hunting Trip");

	private String transportType, accompanyingFamilyMemeber, maxAmtHouseHuntingTripLodging, maxAmtHouseHuntingTripMeals;

	public void setTransportType(String transType) {
		transportType = transType;
	}

	public String getTransportType() {
		return transportType;
	}

	public void setAccompanyingFamilyMember(String accFamilyMem) {
		accompanyingFamilyMemeber = accFamilyMem;
	}

	public String getAccompanyingFamilyMember() {
		return accompanyingFamilyMemeber;
	}

	public void setMaxAmtHouseHuntingTripLodging(String maxAmt) {
		maxAmtHouseHuntingTripLodging = maxAmt;
	}

	public String getMaxAmtHouseHuntingTripLodging() {
		return maxAmtHouseHuntingTripLodging;
	}

	public void setMaxAmtHouseHuntingTripMeals(String maxAmt) {
		maxAmtHouseHuntingTripMeals = maxAmt;
	}

	public String getMaxAmtHouseHuntingTripMeals() {
		return maxAmtHouseHuntingTripMeals;
	}


	public void selectRandomTransportTypeOption(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownTransportationType);
			String randTransportTypeOption = CoreFunctions.getRandomAndUniqueMultipleSelectDropDownOptions(_drpDownTransportationTypeOptions);			
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
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblTransportationType.getText(), subBenefitFormName));			
		}
	}

	public void fillHouseHuntingTripTransportationForm(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfTrips, _lblNoOfTrips.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.numberOfTrips);

			selectRandomTransportTypeOption(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.clickElement(driver, _txtBoxMinMileageEconomy);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageEconomy, _lblMinMileageForEconomyAirTravel.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.minMileageEconomyAir);
			CoreFunctions.clearAndSetText(driver, _txtBoxMinMileageBusiness,
					_lblMinMileageForBusinessAirTravel.getText(),
					houseHuntingTripBenefitData.houseHuntingTripTransportation.minMileageBusinessAir);
			CoreFunctions.clickElement(driver, _drpDownAccompanyingFamilyMemberCode);

			String randAccompanyingFamilMember = _drpDownAccompanyingFamilyMemberCodeOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAccompanyingFamilyMemberCodeOptions.size() - 1))
					.getText();
			
			CoreFunctions.selectItemInListByText(driver, _drpDownAccompanyingFamilyMemberCodeOptions,
					randAccompanyingFamilMember, _lblAccompanyingFamilyMember.getText(), PDTConstants.DROP_DOWN, true);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripTransport);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripTransport,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripTransport,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedBy,
					_txtBoxHouseHuntingTripTransportReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripTransportComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripTransportation.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName) {
		try {
			if (_drpDownMaxAmtSelectedOption.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT_PER_NIGHT)
					&& CoreFunctions.isElementExist(driver, _txtBoxNumOfNightsPerTrip, 1)
							& CoreFunctions.isElementExist(driver, _drpDownCurrencyCode, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.FLAT_AMT_PER_NIGHT, subBenefitFormName));
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.CURRENCY, subBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxFlatAmtPerNight);
				CoreFunctions.clearAndSetText(driver, _txtBoxFlatAmtPerNight, _lblFlatAmount.getText(),
						houseHuntingTripBenefitData.houseHuntingTripLodging.flatAmtPerNight);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCode);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeOptions,
						houseHuntingTripBenefitData.houseHuntingTripLodging.currencyCode, _lblCurrency.getText(),
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.FAILED_TO_FILL_FIELD_VALUES);
		}
	}

	public void fillHouseHuntingTripLodgingForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxNumOfNightsPerTrip,
					_lblNumOfNightsPerTrip.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxNumOfNightsPerTrip, _lblNumOfNightsPerTrip.getText(),
					houseHuntingTripBenefitData.houseHuntingTripLodging.numberOfNightsPerTrip);
			CoreFunctions.clickElement(driver, _drpDownMaxAmt);
			String randMaxAmtOptions = _drpDownMaxAmtOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmtOptions.size() - 1)).getText();
			
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmtOptions, randMaxAmtOptions, _lblMaxAmt.getText(),
					PDTConstants.DROP_DOWN, true);
			
			setMaxAmtHouseHuntingTripLodging(randMaxAmtOptions);			
			verifyAndFillFlatAmtPerNightTextBoxAndCurrencyDrpDown(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripLodging);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripLodging,
					houseHuntingTripBenefitData.houseHuntingTripLodging.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripLodging,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedBy,
					_txtBoxHouseHuntingTripLodgingReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripLodging.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripLodgingComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripLodging.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}

	}

	public void checkIfFlatAmtIsSelected(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			if (_drpDownMaxAmountSelectedVal.getText().equalsIgnoreCase(PDTConstants.FLAT_AMT)) {
				verifyAndFillTransfereeMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillAdultMealInfo(addNewPolicyPage, subBenefitFormName);
				verifyAndFillChildMealInfo(addNewPolicyPage, subBenefitFormName);
			}
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SELECTED_VAL, CoreConstants.FAIL, PDTConstants.FLAT_AMT));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransferee);
				CoreFunctions.selectItemInListByText(driver, _radioDetailTransfereeCode,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransfereeDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownTransfereeCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownTransfereeCurrencyOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtTransfereeCurrency,
						PDTConstants.CURRENCY, PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdult);
				CoreFunctions.selectItemInListByText(driver, _radioDetailAdult,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdultDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownAdultCurrency);
				CoreFunctions.selectItemInListByText(driver, _drpDownAdultCurrencyOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtAdultCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
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
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChild);
				CoreFunctions.selectItemInListByText(driver, _radioDetailChild,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChildDetail, PDTConstants.DETAIL,
						PDTConstants.RADIO_BUTTON_LIST, true);
				CoreFunctions.clickElement(driver, _drpDownCurrencyCodeChild);
				CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyCodeChildOptions,
						houseHuntingTripBenefitData.houseHuntingTripMeals.maxAmtChildCurrency, PDTConstants.CURRENCY,
						PDTConstants.DROP_DOWN, true);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillHouseHuntingTripMealForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationPerTrip,
					_lblDurationPerTrip.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationPerTrip, _lblDurationPerTrip.getText(),
					houseHuntingTripBenefitData.houseHuntingTripMeals.durationPerTripDays);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.mealTypeCode, _lblType.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.clickElement(driver, _drpDownMaxAmount);
			String randMaxAmtTripMeals = _drpDownMaxAmountOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownMaxAmountOptions.size() - 1)).getText();			
			CoreFunctions.selectItemInListByText(driver, _drpDownMaxAmountOptions, randMaxAmtTripMeals,
					_lblMaxAmtHouseHuntingTripMeals.getText(), PDTConstants.DROP_DOWN, true);
			
			setMaxAmtHouseHuntingTripMeals(randMaxAmtTripMeals);
			checkIfFlatAmtIsSelected(addNewPolicyPage, subBenefitFormName);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnHouseHuntingTripMeals);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHouseHuntingTripMeals,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedBy,
					_txtBoxHouseHuntingTripReimbursedByOther,
					houseHuntingTripBenefitData.houseHuntingTripMeals.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaHouseHuntingTripMealComment, PDTConstants.COMMENT,
					houseHuntingTripBenefitData.houseHuntingTripMeals.comment);

		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

}
