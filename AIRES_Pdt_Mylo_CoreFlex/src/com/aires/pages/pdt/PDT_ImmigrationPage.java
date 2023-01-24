package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.ArrayList;
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
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_ImmigrationBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class PDT_ImmigrationPage extends PDT_SharedSubBenefitPage {
	public PDT_ImmigrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formHeaderImmigrationFees;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formHeaderImmigrationTravel;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='authorizedFeeCodeList']")
	private WebElement _drpDownAuthorizedFees;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Fees authorized in addition to customary visa related expenses:']")
	private WebElement _lblAuthorizedFeesCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownAuthorizedFeesOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='authorizedFeeCodeList'] span.ng-value-label")
	private List<WebElement> _drpDownAuthorizedFeesSelected;
	
	@FindBy(how = How.CSS, using = "#collapseOne label.form-check-label")
	private List<WebElement> _radioBtnImmigrationFees;
	
	@FindBy(how = How.CSS, using = "#collapseOne input[formcontrolname='paidByOther']")
	private WebElement _txtBoxImmigrationFeesReimbursedByOther;
	
	@FindBy(how = How.CSS, using = "app-immigration-fees textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaImmigrationFeesComment;	
	
	@FindBy(how = How.XPATH, using = "//label[text()='Number of Trips']")
	private WebElement _lblNoOfTrips;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='noOfTripsCode']")
	private WebElement _drpDownNoOfTrips;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownNoOfTripsOptions;	
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='noOfTripsCode'] span.ng-value-label")
	private List<WebElement> _drpDownNoOfTripsSelectedOption;	
	
	@FindBy(how = How.XPATH, using = "//label[text()='Other Number of Trips']")
	private WebElement _lblOtherNoOfTrips;
		
	@FindBy(how = How.CSS, using = "input[formcontrolname='noOfTripsOther']")
	private WebElement _txtBoxNoOfTripsOther;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Members']")
	private WebElement _lblAccompanyingFamilyMembers;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMember;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownAccompanyingFamilyMemberOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-value-label")
	private WebElement _drpDownAccompanyingFamilyMemberOptionSelected;
	
	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnImmigrationTravel;
	
	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxImmigrationTravelReimbursedByOther;
	
	@FindBy(how = How.CSS, using = "#collapseTwo textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaImmigrationComment;

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='immigratFeeExpenseCodeList']")
	private WebElement _drpDownImmigrationFeesExpenseCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsImmigrationFeesExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='immigratFeeExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsImmigrationFeesExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='immigratTravelExpenseCodeList']")
	private WebElement _drpDownImmigrationTravelExpenseCode;
	
	@FindBy(how = How.CSS, using = "span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownOptionsImmigrationTravelExpenseCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='immigratTravelExpenseCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownSelectedOptionsImmigrationTravelExpenseCode;

	PDT_ImmigrationBenefit immigrationBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getImmigrationDataList("Immigration");
	
	private String authorizedFees, numberOfTrips, accompanyingFamilyMember;
	private ArrayList<String> _expenseCodeImmiFees = null;
	private ArrayList<String> _expenseCodeImmiTravel = null;
	
	public void setAuthorizedFees(String feeName) {
		authorizedFees = feeName;
	}

	public String getAuthorizedFees() {
		return authorizedFees;
	}
	
	public void setNumberOfTrips(String noOfTrips) {
		numberOfTrips = noOfTrips;
	}

	public String getNumberOfTrips() {
		return numberOfTrips;
	}
	
	public void setAccompanyingFamilyMember(String accomFamilyMember) {
		accompanyingFamilyMember = accomFamilyMember;
	}

	public String getAccompanyingFamilyMember() {
		return accompanyingFamilyMember;
	}
	
	public void setExpenseCodeImmigrationFees(ArrayList <String> expenseCode) {
		this._expenseCodeImmiFees = expenseCode;
	}

	public ArrayList <String> getExpenseCodeImmigrationFees() {
		return _expenseCodeImmiFees;
	}
	
	public void setExpenseCodeImmigrationTravel(ArrayList <String> expenseCode) {
		this._expenseCodeImmiTravel = expenseCode;
	}
	
	public ArrayList <String> getExpenseCodeImmigrationTravel() {
		return _expenseCodeImmiTravel;
	}
	/**
	 * Add the Form Header of Immigration Fees & Immigration Travel in Hash map i.e. subBenefitHeaderMap
	 */
	public void populateSubBenefitHeaderMap() {
		subBenefitHeaderMap.put(PDTConstants.IMMIGRATION_FEES, _formHeaderImmigrationFees);
		subBenefitHeaderMap.put(PDTConstants.IMMIGRATION_TRAVEL, _formHeaderImmigrationTravel);
	}
	
	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		populateSubBenefitHeaderMap();
		try {
			element = subBenefitHeaderMap.get(elementName);
		} catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}
	
	/**
	 * Fill Immigration Fees Form.
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillImmigrationFeesForm(String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownAuthorizedFees, _lblAuthorizedFeesCode.getText());
			CoreFunctions.clickElement(driver, _drpDownAuthorizedFees);
			String randAuthorizedFeeOption = CoreFunctions.getRandomAndUniqueMultipleSelectDropDownOptions(_drpDownAuthorizedFeesOptions);
			String[] authorizedFees = randAuthorizedFeeOption.split(",");
			for (int i = 0; i < authorizedFees.length; i++) {				
				CoreFunctions.selectItemInListByText(driver, _drpDownAuthorizedFeesOptions,
						authorizedFees[i].trim(), _lblAuthorizedFeesCode.getText(), PDTConstants.DROP_DOWN, true);			
			}

			if (_drpDownAuthorizedFeesSelected.size() > 1) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, _lblAuthorizedFeesCode.getText(),
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownAuthorizedFeesSelected)
								.toString()));
			}
			setAuthorizedFees(randAuthorizedFeeOption);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnImmigrationFees,
					immigrationBenefitData.immigrationFees.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnImmigrationFees,
					immigrationBenefitData.immigrationFees.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, immigrationBenefitData.immigrationFees.reimbursedBy, _txtBoxImmigrationFeesReimbursedByOther, immigrationBenefitData.immigrationFees.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
		
			CoreFunctions.clearAndSetText(driver, _txtAreaImmigrationFeesComment, PDTConstants.COMMENT,
					immigrationBenefitData.immigrationFees.comment);
			CoreFunctions.clickElement(driver, _drpDownImmigrationFeesExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.IMMIGRATION, PDTConstants.IMMIGRATION_FEES,
							_drpDownOptionsImmigrationFeesExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.IMMIGRATION_FEES, DbFunctions.getExpenseCodeListForBenefit(PDTConstants.IMMIGRATION).toString(), CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsImmigrationFeesExpenseCode).toString()));
			ArrayList <String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0, _drpDownOptionsImmigrationFeesExpenseCode.size(), 5, driver, _drpDownOptionsImmigrationFeesExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownImmigrationFeesExpenseCode, _drpDownOptionsImmigrationFeesExpenseCode, _drpDownSelectedOptionsImmigrationFeesExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeImmigrationFees(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void verifyOtherNumberOfTripsTextBoxIsDisplayed(String SubBenefitFormName) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownNoOfTripsSelectedOption)
					.toString().contains(PDTConstants.OTHER) && CoreFunctions.isElementExist(driver, _txtBoxNoOfTripsOther, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED, CoreConstants.PASS, _lblOtherNoOfTrips.getText(), SubBenefitFormName));
				CoreFunctions.clickElement(driver, _txtBoxNoOfTripsOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxNoOfTripsOther, _lblOtherNoOfTrips.getText(),
						immigrationBenefitData.immigrationTravel.otherNumberOfTrips);
			}
		}catch(Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_FIELD, _lblOtherNoOfTrips.getText(), SubBenefitFormName));
		}
	}
	
	public void selectNoOfTrips(String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _drpDownNoOfTrips);
			String randNumberOfTrips = _drpDownNoOfTripsOptions
					.get(CoreFunctions.getRandomNumber(0,_drpDownNoOfTripsOptions.size() - 1))
					.getText();
				CoreFunctions.selectItemInListByText(driver, _drpDownNoOfTripsOptions,
						randNumberOfTrips, _lblNoOfTrips.getText(), PDTConstants.DROP_DOWN, true);				
			setNumberOfTrips(randNumberOfTrips);
			verifyOtherNumberOfTripsTextBoxIsDisplayed(subBenefitFormName);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL, _lblNoOfTrips.getText(), subBenefitFormName));
		}
	}
	
	/**
	 * Fill Immigration Travel form
	 * @param addNewPolicyPage
	 * @param subBenefitFormName
	 * @param pageName
	 */
	public void fillImmigrationTravelForm(String subBenefitFormName, String pageName) {
		try {
			populateSubBenefitHeaderMap();
			Assert.assertTrue(BusinessFunctions.verifySubBenefitFormHeaderIsDisplayed(driver, subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefitFormName, pageName));
			BusinessFunctions.expandSubBenefitIfCollapsed(subBenefitHeaderMap.get(subBenefitFormName), subBenefitFormName, driver);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownNoOfTrips, _lblNoOfTrips.getText());
			selectNoOfTrips(subBenefitFormName);
			CoreFunctions.clickElement(driver, _drpDownAccompanyingFamilyMember);

			String randAccompanyingFamilMember = _drpDownAccompanyingFamilyMemberOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAccompanyingFamilyMemberOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownAccompanyingFamilyMemberOptions,
					randAccompanyingFamilMember, _lblAccompanyingFamilyMembers.getText(), PDTConstants.DROP_DOWN, true);
			setAccompanyingFamilyMember(randAccompanyingFamilMember);
			
			CoreFunctions.selectItemInListByText(driver, _radioBtnImmigrationTravel,
					immigrationBenefitData.immigrationTravel.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnImmigrationTravel,
					immigrationBenefitData.immigrationTravel.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);
			BusinessFunctions.verifyOtherTextBoxIsDisplayed(driver, immigrationBenefitData.immigrationTravel.reimbursedBy, _txtBoxImmigrationTravelReimbursedByOther, immigrationBenefitData.immigrationTravel.reimbursedByOther, subBenefitFormName, PDTConstants.REIMBURSED_BY_OTHER);
			CoreFunctions.clearAndSetText(driver, _txtAreaImmigrationComment, PDTConstants.COMMENT,
					immigrationBenefitData.immigrationTravel.comment);
			
			CoreFunctions.clickElement(driver, _drpDownImmigrationTravelExpenseCode);
			Assert.assertTrue(
					BusinessFunctions.verifyAllExpenseCodesArePopulatedForSubBenefit(driver,
							PDTConstants.IMMIGRATION, PDTConstants.IMMIGRATION_TRAVEL,
							_drpDownOptionsImmigrationTravelExpenseCode),
					MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_NOT_POPULATED, CoreConstants.FAIL,
							PDTConstants.IMMIGRATION_TRAVEL,  DbFunctions.getExpenseCodeListForBenefit(PDTConstants.IMMIGRATION).toString(), CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsImmigrationTravelExpenseCode).toString()));
			ArrayList <String> randExpenseCodeOptions = CoreFunctions.getMultipleRandomOptionsForDropDown(0, _drpDownOptionsImmigrationTravelExpenseCode.size(), 5, driver, _drpDownOptionsImmigrationTravelExpenseCode);
			BusinessFunctions.selectRandomDropDownOption(driver, PDTConstants.EXPENSE_CODES, _drpDownImmigrationTravelExpenseCode, _drpDownOptionsImmigrationTravelExpenseCode, _drpDownSelectedOptionsImmigrationTravelExpenseCode, randExpenseCodeOptions, subBenefitFormName);
			setExpenseCodeImmigrationTravel(randExpenseCodeOptions);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	/**
	 * Fill Immigration Travel sub-benefit based on sub-benefit name 
	 * @param subBenefit
	 * @param pageName
	 * @param addNewPolicyPage
	 * @param sharedSubBenefitPage
	 */
	public void fillImmigrationSubBenefit(String subBenefit, String pageName, PDT_SharedSubBenefitPage sharedSubBenefitPage) {		
		switch (subBenefit) {
		case PDTConstants.IMMIGRATION_FEES:
			fillImmigrationFeesForm(subBenefit, pageName);
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			fillImmigrationTravelForm(subBenefit, pageName);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.SUBBENEFIT_NOT_FOUND, CoreConstants.FAIL, subBenefit, pageName));
		}		
	}
	
	/**
	 * Iterate Immigration sub-benefits and fill their corresponding form.
	 * @param pageName
	 * @param subBenefits
	 * @param addNewPolicyPage
	 * @param objStep
	 * @param btnName
	 * @param subBenefitPage 
	 */
	public void iterateAndFillImmigrationSubBenefits(String pageName, List<String> subBenefits, PDT_SharedSubBenefit_Steps objStep, String btnName, PDT_SharedSubBenefitPage subBenefitPage) {
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
			fillImmigrationSubBenefit(subBenefit, pageName, subBenefitPage);
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
