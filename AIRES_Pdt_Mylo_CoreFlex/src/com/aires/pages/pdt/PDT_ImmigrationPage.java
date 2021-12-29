package com.aires.pages.pdt;

import java.text.MessageFormat;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.pdt.PDT_ImmigrationBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class PDT_ImmigrationPage extends Base {
	public PDT_ImmigrationPage(WebDriver driver) {
		super(driver);
	}
	
	@FindBy(how = How.CSS, using = "a[href='#collapseOne']")
	private WebElement _formImmigrationFees;

	@FindBy(how = How.CSS, using = "a[href='#collapseTwo']")
	private WebElement _formImmigrationTravel;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='authorizedFeeCodeList']")
	private WebElement _drpDownAuthorizedFees;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Fees authorized in addition to customary visa related expenses:']")
	private WebElement _lblAuthorizedFeesCode;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='authorizedFeeCodeList'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownAuthorizedFeesOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='authorizedFeeCodeList'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownAuthorizedFeesSelected;
	
	@FindBy(how = How.CSS, using = "#collapseOne label.form-check-label")
	private List<WebElement> _radioBtnImmigrationFees;
	
	@FindBy(how = How.CSS, using = "#collapseOne input[formcontrolname='paidByOther']")
	private WebElement _txtBoxImmigrationFeesReimbursedByOther;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Number of Trips']")
	private WebElement _lblNoOfTrips;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='noOfTripsCode']")
	private WebElement _drpDownNoOfTrips;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='noOfTripsCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownNoOfTripsOptions;	
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='noOfTripsCode'] span.ng-value-label.ng-star-inserted")
	private List<WebElement> _drpDownNoOfTripsSelectedOption;	
	
	@FindBy(how = How.XPATH, using = "//label[text()='Other Number of Trips']")
	private WebElement _lblOtherNoOfTrips;
		
	@FindBy(how = How.CSS, using = "input[formcontrolname='noOfTripsOther']")
	private WebElement _txtBoxNoOfTripsOther;
	
	@FindBy(how = How.XPATH, using = "//label[text()='Accompanying Family Members']")
	private WebElement _lblAccompanyingFamilyMembers;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode']")
	private WebElement _drpDownAccompanyingFamilyMember;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-option-label.ng-star-inserted")
	private List<WebElement> _drpDownAccompanyingFamilyMemberOptions;
	
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='accompanyingFamilyMemberCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownAccompanyingFamilyMemberOptionSelected;
	
	@FindBy(how = How.CSS, using = "#collapseTwo label.form-check-label")
	private List<WebElement> _radioBtnImmigrationTravel;
	
	@FindBy(how = How.CSS, using = "#collapseTwo input[formcontrolname='paidByOther']")
	private WebElement _txtBoxImmigrationTravelReimbursedByOther;
	
	@FindBy(how = How.CSS, using = "#collapseTwo textArea[formcontrolname='benefitComment']")
	private WebElement _txtAreaImmigrationComment;

	@FindBy(how = How.CSS, using = "button.btn-next[type='submit']")
	private WebElement _btnSaveAndContinue;
	
	@FindBy(how = How.CSS, using = "button.btn-save[type='submit']")
	private WebElement _btnSaveAsDraft;	

	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitCategories;
	
	PDT_ImmigrationBenefit immigrationBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getImmigrationDataList("Immigration");
	
	private String authorizedFees, numberOfTrips, accompanyingFamilyMember;
	
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
	
	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		switch (elementName) {
		case PDTConstants.IMMIGRATION_FEES:
			element = _formImmigrationFees;
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			element = _formImmigrationTravel;
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}
	
	public boolean verifyFormIsDisplayed(String formName, WebElement element, String pageName) {
		if (element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					formName, pageName));
			return true;
		}
		return false;
	}
	
	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed")) {
			CoreFunctions.clickElement(driver, subBenefitForm);
		}
	}
	
	public void iterateAndSelectImmigrationSubBenefits(String pageName, DataTable subBenefitTable,
			PDT_AddNewPolicyPage addNewPolicyPage) {
		CoreFunctions.waitHandler(3);
		List<String> subBenefits = subBenefitTable.asList(String.class);
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		for (String subBenefit : subBenefits) {
			CoreFunctions.selectItemInListByText(driver, _subBenefitCategories, subBenefit, true);
			Assert.assertTrue(verifyFormIsDisplayed(subBenefit, getElementByName(subBenefit), pageName),
					MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_NOT_DISPLAYED, subBenefit, pageName));
			fillPreAcceptanceSubBenefit(subBenefit, addNewPolicyPage);
		}
		CoreFunctions.click(driver, _btnSaveAndContinue, _btnSaveAndContinue.getText());
	}
	
	public void fillPreAcceptanceSubBenefit(String subBenefit, PDT_AddNewPolicyPage addNewPolicyPage) {
		switch (subBenefit) {
		case PDTConstants.IMMIGRATION_FEES:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.IMMIGRATION_FEES));
			fillImmigrationFeesForm(addNewPolicyPage);
			break;
		case PDTConstants.IMMIGRATION_TRAVEL:
			expandSubBenefitIfCollapsed(getElementByName(PDTConstants.IMMIGRATION_TRAVEL));
			fillImmigrationTravelForm(addNewPolicyPage);
			break;
		default:
			Assert.fail(MessageFormat.format(PDTConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}
	
	public void fillImmigrationFeesForm(PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownAuthorizedFees, _lblAuthorizedFeesCode.getText());
			CoreFunctions.clickElement(driver, _drpDownAuthorizedFees);
			String randAuthorizedFeeOption = _drpDownAuthorizedFeesOptions
					.get(CoreFunctions.getRandomNumber(0, _drpDownAuthorizedFeesOptions.size() - 1)).getText()
					+ ", "
					+ _drpDownAuthorizedFeesOptions
							.get(CoreFunctions.getRandomNumber(0, _drpDownAuthorizedFeesOptions.size() - 1))
							.getText();
			String[] transportationType = randAuthorizedFeeOption.split(",");
			for (int i = 0; i < transportationType.length; i++) {
				CoreFunctions.selectItemInListByText(driver, _drpDownAuthorizedFeesOptions,
						transportationType[i].trim(), _lblAuthorizedFeesCode.getText(), PDTConstants.DROP_DOWN, true);
				CoreFunctions.clickElement(driver, _drpDownAuthorizedFees);
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
			if (immigrationBenefitData.immigrationFees.reimbursedBy.equalsIgnoreCase(PDTConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _txtBoxImmigrationFeesReimbursedByOther,
						PDTConstants.REIMBURSED_BY_OTHER,
						immigrationBenefitData.immigrationFees.reimbursedByOther);
			}			
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			e.printStackTrace();
			Assert.fail("Failed to fill Immigration Fees form");
		}
	}
	
	public void selectNoOfTrips(PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.clickElement(driver, _drpDownNoOfTrips);
			String randNumberOfTrips = _drpDownNoOfTripsOptions
					.get(CoreFunctions.getRandomNumber(0,_drpDownNoOfTripsOptions.size() - 1))
					.getText();
			String[] numOfTrips = randNumberOfTrips.split(",");
			for(int i=0; i<numOfTrips.length; i++) {
				CoreFunctions.selectItemInListByText(driver, _drpDownNoOfTripsOptions,
						randNumberOfTrips, _lblNoOfTrips.getText(), PDTConstants.DROP_DOWN, true);				
				CoreFunctions.clickElement(driver, _drpDownNoOfTrips);
			}			
			if (_drpDownNoOfTripsSelectedOption.size() > 1) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, _lblNoOfTrips.getText(),
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownNoOfTripsSelectedOption)
								.toString()));
			}
			setNumberOfTrips(randNumberOfTrips);
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownNoOfTripsSelectedOption)
					.toString().contains(PDTConstants.OTHER)) {
				CoreFunctions.clickElement(driver, _txtBoxNoOfTripsOther);
				CoreFunctions.clearAndSetText(driver, _txtBoxNoOfTripsOther, _lblOtherNoOfTrips.getText(),
						immigrationBenefitData.immigrationTravel.otherNumberOfTrips);
			}
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			e.printStackTrace();
			Assert.fail("Failed to select Number of Trips");
		}
	}
	
	public void fillImmigrationTravelForm(PDT_AddNewPolicyPage addNewPolicyPage) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _drpDownNoOfTrips, _lblNoOfTrips.getText());
			selectNoOfTrips(addNewPolicyPage);
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
			if (immigrationBenefitData.immigrationTravel.reimbursedBy.equalsIgnoreCase(PDTConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _txtBoxImmigrationTravelReimbursedByOther,
						PDTConstants.REIMBURSED_BY_OTHER,
						immigrationBenefitData.immigrationTravel.reimbursedByOther);
				
			}
			CoreFunctions.clearAndSetText(driver, _txtAreaImmigrationComment, PDTConstants.COMMENT,
					immigrationBenefitData.immigrationTravel.comment);
		} catch (Exception e) {
			DbFunctions.deletePolicyByPolicyId(addNewPolicyPage.getPolicyId());
			e.printStackTrace();
			Assert.fail("Failed to fill Immigration Travel form");
		}
	}
	
	
	
	
	
}
