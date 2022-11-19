package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

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
import com.aires.testdatatypes.pdt.PDT_HomePurchaseBenefit;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_HomePurchasePage extends PDT_SharedSubBenefitPage {
	public PDT_HomePurchasePage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.XPATH, using = "//label[text()='Direct Bill Eligible']")
	private WebElement _lblDirectBillEligible;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Direct Bill Eligible']/following-sibling::div/label")
	private List<WebElement> _radioBtnDirectBillEligible;

	@FindBy(how = How.CSS, using = "app-closing-costs div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnClosingCosts;

	@FindBy(how = How.XPATH, using = "//app-closing-costs//input[@formcontrolname='maxPrice']/preceding-sibling::label")
	private WebElement _lblMaxPriceForClosingCost;

	@FindBy(how = How.CSS, using = "app-closing-costs input[formcontrolname='maxPrice']")
	private WebElement _txtBoxMaxPercentOfHomePurPriceForClosingCost;

	@FindBy(how = How.XPATH, using = "//app-closing-costs//input[@formcontrolname='cap']/preceding-sibling::label")
	private WebElement _lblClosingCost;

	@FindBy(how = How.CSS, using = "app-closing-costs input[formcontrolname='cap']")
	private WebElement _txtBoxClosingCostCap;

	@FindBy(how = How.CSS, using = "app-closing-costs ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrency;

	@FindBy(how = How.CSS, using = "app-closing-costs ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptions;

	@FindBy(how = How.CSS, using = "app-closing-costs ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelected;

	@FindBy(how = How.XPATH, using = "//label[text()='Aires Preferred Lenders']")
	private WebElement _lblAiresPrefLenders;

	@FindBy(how = How.CSS, using = "app-closing-costs div[formarrayname='airesPreferredLenders'] label.form-check-label")
	private List<WebElement> _chkBoxAiresPreferredLenders;

	@FindBy(how = How.CSS, using = "input[formcontrolname='preferredLendersOther']")
	private WebElement _txtBoxPrefLendersOtherClosingCost;

	@FindBy(how = How.XPATH, using = "//app-closing-costs//label[text()='Gross-Up']/following-sibling::div/label")
	private List<WebElement> _radioBtnGrossUp;
	
	@FindBy(how = How.CSS, using = "app-closing-costs input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherClosingCost;

	@FindBy(how = How.CSS, using = "app-closing-costs textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForClosingCost;

	// HomePurchase Points
	@FindBy(how = How.XPATH, using = "//app-points//input[@formcontrolname='maxPrice']/preceding-sibling::label")
	private WebElement _lblMaxPercentOfHomePurchasePrice;

	@FindBy(how = How.CSS, using = "app-points input[formcontrolname='maxPrice']")
	private WebElement _txtBoxMaxPercentOfHomePurchasePrice;

	@FindBy(how = How.CSS, using = "app-points div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnHomePurchasePoints;

	@FindBy(how = How.CSS, using = "app-points input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherHomPurPoints;

	@FindBy(how = How.CSS, using = "app-points textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentHomPurPoints;

	// Home Purchase Inspection
	@FindBy(how = How.CSS, using = "app-inspections div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnHomePurInspection;

	@FindBy(how = How.CSS, using = "app-inspections input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherHomePurInspection;

	@FindBy(how = How.CSS, using = "app-inspections textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentHomePurInspection;

	// Home Purchase Bonus
	@FindBy(how = How.CSS, using = "app-bonus input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMaxAmtHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptionsHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelectedHomePurBonus;

	@FindBy(how = How.XPATH, using = "//app-bonus//textarea[@formcontrolname='describe']/preceding-sibling::label")
	private WebElement _lblDescCalcHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus textarea[formcontrolname='describe']")
	private WebElement _txtAreaDescCalcHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherHomePurBonus;

	@FindBy(how = How.CSS, using = "app-bonus textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentHomePurBonus;

	// Mortgage Differentials
	@FindBy(how = How.CSS, using = "app-mortgage-differentials div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnMortDiff;

	@FindBy(how = How.CSS, using = "app-mortgage-differentials input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherMortDiff;

	@FindBy(how = How.CSS, using = "app-mortgage-differentials textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentMortDiff;

	// Mortgage Subsidy
	@FindBy(how = How.CSS, using = "app-mortgage-subsidy div.form-check-radio label.form-check-label")
	private List<WebElement> _radioBtnMortSubsidy;

	@FindBy(how = How.CSS, using = "app-mortgage-subsidy input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherMortSubsidy;

	@FindBy(how = How.CSS, using = "app-mortgage-subsidy textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentMortSubsidy;

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne1']")
	private WebElement _headerFormHomePurchaseClosingCost;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _headerFormHomePurchasePoints;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseThree']")
	private WebElement _headerFormHomePurchaseInspections;

	@FindBy(how = How.CSS, using = "a[href='#collapseFour']")
	private WebElement _headerFormHomePurchaseBonus;
	
	@FindBy(how = How.CSS, using = "a[href='#collapseFive']")
	private WebElement _headerFormMortgageDifferentials;

	@FindBy(how = How.CSS, using = "a[href='#collapseSix']")
	private WebElement _headerFormMortgageSubsidy;
	
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	PDT_HomePurchaseBenefit homePurchaseBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getHomePurchaseDataList("Home Purchase");
	
	/**
	 * Add the Form Header of Home Purchase sub-benefit in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.HOME_PURCHASE_CLOSING_COSTS, _headerFormHomePurchaseClosingCost);
		subBenefitHeaderMap.put(PDTConstants.HOME_PURCHASE_POINTS, _headerFormHomePurchasePoints);
		subBenefitHeaderMap.put(PDTConstants.HOME_PURCHASE_INSPECTIONS, _headerFormHomePurchaseInspections);
		subBenefitHeaderMap.put(PDTConstants.HOME_PURCHASE_BONUS, _headerFormHomePurchaseBonus);
		subBenefitHeaderMap.put(PDTConstants.MORTGAGE_DIFFERENTIALS, _headerFormMortgageDifferentials);
		subBenefitHeaderMap.put(PDTConstants.MORTGAGE_SUBSIDY, _headerFormMortgageSubsidy);
	}

	public void selectAiresPreferredLenders(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			List<String> airesPrefLendersList = Arrays.stream(homePurchaseBenefitData.homePurchaseClosingCost.airesPreferredLenders.split(","))
				    .map(String::trim)
				    .collect(Collectors.toList());
			
			for (String airesPrefLenders : airesPrefLendersList) {
				CoreFunctions.selectItemInListByText(driver, _chkBoxAiresPreferredLenders,
						airesPrefLenders, _lblAiresPrefLenders.getText(), PDTConstants.CHECK_BOX_LIST,
						true);
			}			
			
			if (airesPrefLendersList.contains(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, _txtBoxPrefLendersOtherClosingCost, 1)) {
				CoreFunctions.clearAndSetText(driver, _txtBoxPrefLendersOtherClosingCost,
						PDTConstants.OTHER,
						homePurchaseBenefitData.homePurchaseClosingCost.airesPreferredLendersOther);
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_SELECT_AIRES_PREFERRED_LENDERS,
					CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillHomePurchaseClosingCostForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnDirectBillEligible);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDirectBillEligible,
					homePurchaseBenefitData.homePurchaseClosingCost.directBillEligible,
					_lblDirectBillEligible.getText(), PDTConstants.RADIO_BUTTON_LIST, true);

			CoreFunctions.clearAndSetText(driver, _txtBoxMaxPercentOfHomePurPriceForClosingCost,
					_lblMaxPriceForClosingCost.getText(),
					homePurchaseBenefitData.homePurchaseClosingCost.maxPercentHomePurPrice);

			CoreFunctions.clearAndSetText(driver, _txtBoxClosingCostCap, _lblClosingCost.getText(),
					homePurchaseBenefitData.homePurchaseClosingCost.closingCostCap);

			Assert.assertTrue(BusinessFunctions.verifyDefaultOptionIsSelectedInDrpDown(_drpDownCurrencyOptionSelected.getText(),
					PDTConstants.DEFAULT_CURRENCY, PDTConstants.CURRENCY), MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_OPTION_NOT_SELECTED,
							CoreConstants.FAIL, PDTConstants.DEFAULT_CURRENCY, PDTConstants.CURRENCY));
			
			CoreFunctions.clickElement(driver, _drpDownCurrency);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptions,
					homePurchaseBenefitData.homePurchaseClosingCost.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);

			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					homePurchaseBenefitData.homePurchaseClosingCost.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);

			selectAiresPreferredLenders(addNewPolicyPage, subBenefitFormName);

			CoreFunctions.selectItemInListByText(driver, _radioBtnClosingCosts,
					homePurchaseBenefitData.homePurchaseClosingCost.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.homePurchaseClosingCost.reimbursedBy, _txtBoxReimbursedByOtherClosingCost,
					homePurchaseBenefitData.homePurchaseClosingCost.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForClosingCost, PDTConstants.COMMENT,
					homePurchaseBenefitData.homePurchaseClosingCost.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillHomePurchasePointsForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxPercentOfHomePurchasePrice,
					_lblMaxPercentOfHomePurchasePrice.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxPercentOfHomePurchasePrice,
					_lblMaxPercentOfHomePurchasePrice.getText(),
					homePurchaseBenefitData.homePurchasePoints.maxPercentHomePurPrice);

			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurchasePoints,
					homePurchaseBenefitData.homePurchasePoints.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurchasePoints,
					homePurchaseBenefitData.homePurchasePoints.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.homePurchasePoints.reimbursedBy, _txtBoxReimbursedByOtherHomPurPoints,
					homePurchaseBenefitData.homePurchasePoints.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentHomPurPoints, PDTConstants.COMMENT,
					homePurchaseBenefitData.homePurchasePoints.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillHomePurchaseInspectionForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnHomePurInspection);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurInspection,
					homePurchaseBenefitData.homePurchaseInspections.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurInspection,
					homePurchaseBenefitData.homePurchaseInspections.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.homePurchaseInspections.reimbursedBy,
					_txtBoxReimbursedByOtherHomePurInspection,
					homePurchaseBenefitData.homePurchaseInspections.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentHomePurInspection, PDTConstants.COMMENT,
					homePurchaseBenefitData.homePurchaseInspections.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillHomePurchaseBonusForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxAmtHomePurBonus, PDTConstants.MAX_AMOUNT);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtHomePurBonus, PDTConstants.MAX_AMOUNT,
					homePurchaseBenefitData.homePurchaseBonus.maxAmount);

			Assert.assertTrue(BusinessFunctions.verifyDefaultOptionIsSelectedInDrpDown(
					_drpDownCurrencyOptionSelectedHomePurBonus.getText(), PDTConstants.DEFAULT_CURRENCY,
					PDTConstants.CURRENCY), MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_OPTION_NOT_SELECTED,
							CoreConstants.FAIL, PDTConstants.DEFAULT_CURRENCY, PDTConstants.CURRENCY));

			CoreFunctions.clickElement(driver, _drpDownCurrencyHomePurBonus);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptionsHomePurBonus,
					homePurchaseBenefitData.homePurchaseBonus.currency, PDTConstants.CURRENCY, PDTConstants.DROP_DOWN,
					true);

			CoreFunctions.clearAndSetText(driver, _txtAreaDescCalcHomePurBonus, _lblDescCalcHomePurBonus.getText(),
					homePurchaseBenefitData.homePurchaseBonus.desirableCalculation);

			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurBonus,
					homePurchaseBenefitData.homePurchaseBonus.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnHomePurBonus,
					homePurchaseBenefitData.homePurchaseBonus.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.homePurchaseBonus.reimbursedBy, _txtBoxReimbursedByOtherHomePurBonus,
					homePurchaseBenefitData.homePurchaseBonus.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentHomePurBonus, PDTConstants.COMMENT,
					homePurchaseBenefitData.homePurchaseBonus.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillMortgageDifferentialForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnMortDiff);

			CoreFunctions.selectItemInListByText(driver, _radioBtnMortDiff, homePurchaseBenefitData.mortgDiff.grossUp,
					PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMortDiff,
					homePurchaseBenefitData.mortgDiff.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.mortgDiff.reimbursedBy, _txtBoxReimbursedByOtherMortDiff,
					homePurchaseBenefitData.mortgDiff.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentMortDiff, PDTConstants.COMMENT,
					homePurchaseBenefitData.mortgDiff.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}

	public void fillMortgageSubsidyForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _radioBtnMortSubsidy);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMortSubsidy,
					homePurchaseBenefitData.mortgSubsidy.grossUp, PDTConstants.GROSS_UP, PDTConstants.RADIO_BUTTON_LIST,
					true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMortSubsidy,
					homePurchaseBenefitData.mortgSubsidy.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver,
					homePurchaseBenefitData.mortgSubsidy.reimbursedBy, _txtBoxReimbursedByOtherMortSubsidy,
					homePurchaseBenefitData.mortgSubsidy.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);

			CoreFunctions.clearAndSetText(driver, _txtAreaCommentMortSubsidy, PDTConstants.COMMENT,
					homePurchaseBenefitData.mortgSubsidy.comments);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName));
		}
	}
	
	public void fillHomePurchaseSubBenefit(String subBenefit, String pageName, PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefitPage subBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.HOME_PURCHASE_CLOSING_COSTS:
			fillHomePurchaseClosingCostForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_PURCHASE_POINTS:
			fillHomePurchasePointsForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_PURCHASE_INSPECTIONS:
			fillHomePurchaseInspectionForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.HOME_PURCHASE_BONUS:
			fillHomePurchaseBonusForm(addNewPolicyPage,	subBenefit, pageName);
			break;
		case PDTConstants.MORTGAGE_DIFFERENTIALS:
			fillMortgageDifferentialForm(addNewPolicyPage, subBenefit, pageName);
			break;
		case PDTConstants.MORTGAGE_SUBSIDY:
			fillMortgageSubsidyForm(addNewPolicyPage, subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Home Purchase sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillHomePurchaseSubBenefits(String pageName, List<String> subBenefits,
			PDT_AddNewPolicyPage addNewPolicyPage, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);			
		populateBtnMap();
		populateConfirmDialogbuttonMap();
		WebElement btnToClick = (btnName != null) ?  buttonMap.get(btnName) : buttonMap.get(PDTConstants.SAVE);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			timeBeforeAction = new Date().getTime();
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);
			timeAfterAction = new Date().getTime();
			BusinessFunctions.printTimeTakenByPageToLoad(timeBeforeAction, timeAfterAction, pageName, subBenefit);
			fillHomePurchaseSubBenefit(subBenefit, pageName, addNewPolicyPage, subBenefitPage);
		}
		try {
			CoreFunctions.click(driver, btnToClick, btnToClick.getText());
		} catch (NoSuchElementException e) {
			Assert.fail(MessageFormat.format(PDTConstants.MISSING_BTN, CoreConstants.FAIL, btnName));
		} catch (Exception e) {
			e.printStackTrace();
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_CLICK_ON_BTN, CoreConstants.FAIL, btnName));
		}
	}
}
