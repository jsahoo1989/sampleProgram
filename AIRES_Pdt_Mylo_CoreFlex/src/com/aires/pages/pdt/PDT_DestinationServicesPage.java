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
import com.aires.testdatatypes.pdt.PDT_DestinationServicesBenefit;

public class PDT_DestinationServicesPage extends Base {
	public PDT_DestinationServicesPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "#collapseAirport label.form-check-label")
	private List<WebElement> _radioBtnAirportPickup;

	@FindBy(how = How.CSS, using = "#collapseAirport input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForAirportPickup;

	@FindBy(how = How.CSS, using = "#collapseAirport textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForAirportPickup;

	@FindBy(how = How.XPATH, using = "//app-auto-tour//input[@formcontrolname ='numOfDays']/preceding-sibling::label")
	private WebElement _lblDurationForAreaTour;

	@FindBy(how = How.CSS, using = "app-auto-tour input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationForAreaTour;

	@FindBy(how = How.CSS, using = "app-auto-tour label.form-check-label")
	private List<WebElement> _radioBtnAreaTour;

	@FindBy(how = How.CSS, using = "app-auto-tour input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForAreaTour;

	@FindBy(how = How.CSS, using = "app-auto-tour textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForAreaTour;

	// Auto Rental
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='carTypeCode']/preceding-sibling::label")
	private WebElement _lblCarType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='carTypeCode']")
	private WebElement _drpDownCarType;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='carTypeCode'] div.ng-option")
	private List<WebElement> _drpDownCarTypeOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='carTypeCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownCarTypeOptionSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='carTypeOther']/preceding-sibling::label")
	private WebElement _lblCarTypeOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='carTypeOther']")
	private WebElement _txtBoxCarTypeOther;

	@FindBy(how = How.CSS, using = "app-auto-rental label.form-check-label")
	private List<WebElement> _radioBtnAutoRental;

	@FindBy(how = How.CSS, using = "app-auto-rental input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForAutoRental;

	@FindBy(how = How.CSS, using = "app-auto-rental textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForAutoRental;

	// Conceirge Srvices
	@FindBy(how = How.CSS, using = "app-concierge-service label.form-check-label")
	private List<WebElement> _radioBtnConciergeServices;

	@FindBy(how = How.CSS, using = "app-concierge-service input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForConciergeServices;

	@FindBy(how = How.CSS, using = "app-concierge-service textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForConciergeServices;

	// Departure Services
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='noOfDayCode']/preceding-sibling::label")
	private WebElement _lblNoOfDays;

	@FindBy(how = How.CSS, using = "app-departure-service ng-select[formcontrolname='noOfDayCode']")
	private WebElement _drpDownNoOfDays;

	@FindBy(how = How.CSS, using = "app-departure-service ng-select[formcontrolname='noOfDayCode'] div.ng-option")
	private List<WebElement> _drpDownNoOfDaysOptions;

	@FindBy(how = How.CSS, using = "app-departure-service ng-select[formcontrolname='noOfDayCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownNoOfDaysOptionSelected;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='noOfDayOther']/preceding-sibling::label")
	private WebElement _lblNoOfDaysOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='noOfDayOther']")
	private WebElement _txtBoxNoOfDaysOther;

	@FindBy(how = How.CSS, using = "app-departure-service label.form-check-label")
	private List<WebElement> _radioBtnDepartureServices;

	@FindBy(how = How.CSS, using = "app-departure-service input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherForDepartureServices;

	@FindBy(how = How.CSS, using = "app-departure-service textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForDepartureServices;

	// Furniture Rental
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='durationCode']/preceding-sibling::label")
	private WebElement _lblDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode']")
	private WebElement _drpDownDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode'] div.ng-option")
	private List<WebElement> _drpDownDurationOptions;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='durationCode'] span.ng-value-label.ng-star-inserted")
	private WebElement _drpDownDurationOptionSelected;
	
	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='durationOther']/preceding-sibling::label")
	private WebElement _lblDurationOther;

	@FindBy(how = How.CSS, using = "input[formcontrolname='durationOther']")
	private WebElement _txtBoxDurationOther;

	@FindBy(how = How.CSS, using = "app-furniture-rental label.form-check-label")
	private List<WebElement> _radioBtnFurnitureRental;

	@FindBy(how = How.CSS, using = "app-furniture-rental input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherFurnitureRental;

	@FindBy(how = How.CSS, using = "app-furniture-rental textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForFurnitureRental;
	
	//Reimbursement Of Membership Dues	
	@FindBy(how = How.CSS, using = "app-health-club-dues label.form-check-label")
	private List<WebElement> _radioBtnMembershipDues;

	@FindBy(how = How.CSS, using = "app-health-club-dues input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherMemberShipDues;

	@FindBy(how = How.CSS, using = "app-health-club-dues textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForMembershipDues;
	
	//School Search
	@FindBy(how = How.XPATH, using = "//app-school-search//input[@formcontrolname='numOfDays']/preceding-sibling::label")
	private WebElement _lblDurationInDays;
	
	@FindBy(how = How.CSS, using = "app-school-search input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationInDays;	
	
	@FindBy(how = How.CSS, using = "app-school-search label.form-check-label")
	private List<WebElement> _radioBtnSchoolSearch;

	@FindBy(how = How.CSS, using = "app-school-search input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherSchoolSearch;

	@FindBy(how = How.CSS, using = "app-school-search textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForSchoolSearch;
	
	//Settling In Services
	@FindBy(how = How.XPATH, using = "//app-settling-in-services//input[@formcontrolname='numOfDays']/preceding-sibling::label")
	private WebElement _lblDurationInDaysForSettlingServices;
	
	@FindBy(how = How.CSS, using = "app-settling-in-services input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationInDaysForSettlingServices;	
	
	@FindBy(how = How.CSS, using = "app-settling-in-services label.form-check-label")
	private List<WebElement> _radioBtnSettlingServices;

	@FindBy(how = How.CSS, using = "app-settling-in-services input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherSettlingServices;

	@FindBy(how = How.CSS, using = "app-settling-in-services textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForSettlingServices;
	
	//Transition Assistance Program
	@FindBy(how = How.XPATH, using = "//app-transition-assistance-program//input[@formcontrolname='numOfDays']/preceding-sibling::label")
	private WebElement _lblDurationInDaysForTransitionAssistanceProg;
	
	@FindBy(how = How.CSS, using = "app-transition-assistance-program input[formcontrolname='numOfDays']")
	private WebElement _txtBoxDurationInDaysForTransitionAssistanceProg;
	
	@FindBy(how = How.XPATH, using = "//app-transition-assistance-program//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblMaxAmtForTransitionAssistanceProg;
	
	@FindBy(how = How.CSS, using = "app-transition-assistance-program input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMaxAmtTransitionAssistanceProg;
	
	@FindBy(how = How.CSS, using = "app-transition-assistance-program ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyTransitionAssistanceProg;

	@FindBy(how = How.CSS, using = "app-transition-assistance-program ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptionsTransitionAssistanceProg;

	@FindBy(how = How.CSS, using = "app-transition-assistance-program ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelectedTransitionAssistanceProg;
	
	@FindBy(how = How.CSS, using = "app-transition-assistance-program label.form-check-label")
	private List<WebElement> _radioBtnTransitionAssistanceProg;

	@FindBy(how = How.CSS, using = "app-transition-assistance-program input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherTransitionAssistanceProg;

	@FindBy(how = How.CSS, using = "app-transition-assistance-program textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForTransitionAssistanceProg;
	
	//Tution and Eduction
	@FindBy(how = How.XPATH, using = "//app-tution-and-education//input[@formcontrolname='maxAmount']/preceding-sibling::label")
	private WebElement _lblMaxAmtForTutionAndEduction;
	
	@FindBy(how = How.CSS, using = "app-tution-and-education input[formcontrolname='maxAmount']")
	private WebElement _txtBoxMaxAmtTutionAndEduction;
	
	@FindBy(how = How.CSS, using = "app-tution-and-education ng-select[formcontrolname='currencyCode']")
	private WebElement _drpDownCurrencyTutionAndEduction;

	@FindBy(how = How.CSS, using = "app-tution-and-education ng-select[formcontrolname='currencyCode'] span.ng-option-label")
	private List<WebElement> _drpDownCurrencyOptionsTutionAndEduction;

	@FindBy(how = How.CSS, using = "app-tution-and-education ng-select[formcontrolname='currencyCode'] span.ng-value-label")
	private WebElement _drpDownCurrencyOptionSelectedTutionAndEduction;

	@FindBy(how = How.CSS, using = "app-tution-and-education label.form-check-label")
	private List<WebElement> _radioBtnTutionAndEduction;

	@FindBy(how = How.CSS, using = "app-tution-and-education input[formcontrolname='paidByOther']")
	private WebElement _txtBoxReimbursedByOtherTutionAndEduction;

	@FindBy(how = How.CSS, using = "app-tution-and-education textarea[formcontrolname='benefitComment']")
	private WebElement _txtAreaCommentForTutionAndEduction;		
	

	PDT_DestinationServicesBenefit destinationServicesBenefitData = FileReaderManager.getInstance().getJsonReader()
			.getDestinationServicesDataList("Destination Services");

	private String carType, noOfDaysForDepartureServices, durationForFurntiureRental;

	public void setCarType(String carTypeSelected) {
		carType = carTypeSelected;
	}

	public String getCarType() {
		return carType;
	}

	public void setNoOfDaysForDepartureServices(String noOfDays) {
		noOfDaysForDepartureServices = noOfDays;
	}

	public String getNoOfDaysForDepartureServices() {
		return noOfDaysForDepartureServices;
	}
	
	public void setDurationForFurntiureRental(String duration) {
		durationForFurntiureRental = duration;
	}

	public String getDurationForFurntiureRental() {
		return durationForFurntiureRental;
	}

	public void fillAirPortPickUpForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {

		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnAirportPickup);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirportPickup,
					destinationServicesBenefitData.airPortPickup.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAirportPickup,
					destinationServicesBenefitData.airPortPickup.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.airPortPickup.reimbursedBy, _txtBoxReimbursedByOtherForAirportPickup,
					destinationServicesBenefitData.airPortPickup.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForAirportPickup, PDTConstants.COMMENT,
					destinationServicesBenefitData.airPortPickup.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillAreaTourForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {

		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationForAreaTour,
					_lblDurationForAreaTour.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationForAreaTour, _lblDurationForAreaTour.getText(),
					destinationServicesBenefitData.areaTour.durationInDays);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnAreaTour);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAreaTour,
					destinationServicesBenefitData.areaTour.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAreaTour,
					destinationServicesBenefitData.areaTour.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.areaTour.reimbursedBy, _txtBoxReimbursedByOtherForAreaTour,
					destinationServicesBenefitData.areaTour.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForAreaTour, PDTConstants.COMMENT,
					destinationServicesBenefitData.areaTour.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillAutoRentalForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {

		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownCarTypeOptions);			

			String randCarType = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownCarType, _drpDownCarTypeOptions, _drpDownCarTypeOptionSelected,
					_lblCarType);
			setCarType(randCarType);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownCarTypeOptionSelected, _lblCarType.getText(), _txtBoxCarTypeOther,
					_lblCarTypeOther, subBenefitFormName);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnAutoRental);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoRental,
					destinationServicesBenefitData.autoRentalDuringAssignment.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnAutoRental,
					destinationServicesBenefitData.autoRentalDuringAssignment.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.autoRentalDuringAssignment.reimbursedBy,
					_txtBoxReimbursedByOtherForAutoRental,
					destinationServicesBenefitData.autoRentalDuringAssignment.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForAutoRental, PDTConstants.COMMENT,
					destinationServicesBenefitData.autoRentalDuringAssignment.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillConciergeServicesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnConciergeServices);
			CoreFunctions.selectItemInListByText(driver, _radioBtnConciergeServices,
					destinationServicesBenefitData.conciergeServices.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnConciergeServices,
					destinationServicesBenefitData.conciergeServices.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.conciergeServices.reimbursedBy,
					_txtBoxReimbursedByOtherForConciergeServices,
					destinationServicesBenefitData.conciergeServices.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForConciergeServices, PDTConstants.COMMENT,
					destinationServicesBenefitData.conciergeServices.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillDepartureServicesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {

		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownNoOfDaysOptions);

			String randNoOfDays = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownNoOfDays, _drpDownNoOfDaysOptions, _drpDownNoOfDaysOptionSelected,
					_lblNoOfDays);
			setNoOfDaysForDepartureServices(randNoOfDays);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownNoOfDaysOptionSelected, _lblNoOfDays.getText(), _txtBoxNoOfDaysOther, _lblNoOfDaysOther,
					destinationServicesBenefitData.departureServices.other);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnDepartureServices);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDepartureServices,
					destinationServicesBenefitData.departureServices.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnDepartureServices,
					destinationServicesBenefitData.departureServices.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.departureServices.reimbursedBy,
					_txtBoxReimbursedByOtherForDepartureServices,
					destinationServicesBenefitData.departureServices.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForDepartureServices, PDTConstants.COMMENT,
					destinationServicesBenefitData.departureServices.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}

	public void fillFurnitureRentalForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownDurationOptions);

			String randDuration = BusinessFunctions.selectAndReturnRandomValueFromDropDown(driver, addNewPolicyPage,
					subBenefitFormName, _drpDownDuration, _drpDownDurationOptions, _drpDownDurationOptionSelected,
					_lblDuration);
			setDurationForFurntiureRental(randDuration);
			BusinessFunctions.verifyAndFillOtherTextBoxForSubBenefitForm(driver, addNewPolicyPage, subBenefitFormName,
					_drpDownDurationOptionSelected, _lblDuration.getText(), _txtBoxDurationOther, _lblDurationOther,
					destinationServicesBenefitData.furnitureRental.durationOther);

			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnFurnitureRental);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFurnitureRental,
					destinationServicesBenefitData.furnitureRental.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnFurnitureRental,
					destinationServicesBenefitData.furnitureRental.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.furnitureRental.reimbursedBy,
					_txtBoxReimbursedByOtherFurnitureRental,
					destinationServicesBenefitData.furnitureRental.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForFurnitureRental, PDTConstants.COMMENT,
					destinationServicesBenefitData.furnitureRental.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillReimbursementOfMembershipDuesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnMembershipDues);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMembershipDues,
					destinationServicesBenefitData.reimbursementOfMemberShipDues.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnMembershipDues,
					destinationServicesBenefitData.reimbursementOfMemberShipDues.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.reimbursementOfMemberShipDues.reimbursedBy,
					_txtBoxReimbursedByOtherMemberShipDues,
					destinationServicesBenefitData.reimbursementOfMemberShipDues.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForMembershipDues, PDTConstants.COMMENT,
					destinationServicesBenefitData.reimbursementOfMemberShipDues.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillSchoolSearchForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationInDays,
					_lblDurationInDays.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationInDays, _lblDurationInDays.getText(),
					destinationServicesBenefitData.schoolSearch.durationInDays);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnSchoolSearch);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSchoolSearch,
					destinationServicesBenefitData.schoolSearch.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSchoolSearch,
					destinationServicesBenefitData.schoolSearch.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.schoolSearch.reimbursedBy, _txtBoxReimbursedByOtherSchoolSearch,
					destinationServicesBenefitData.schoolSearch.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForSchoolSearch, PDTConstants.COMMENT,
					destinationServicesBenefitData.schoolSearch.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillSettlingServicesForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationInDaysForSettlingServices,
					_lblDurationInDaysForSettlingServices.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationInDaysForSettlingServices, _lblDurationInDaysForSettlingServices.getText(),
					destinationServicesBenefitData.settlingInServices.durationInDays);
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnSettlingServices);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSettlingServices,
					destinationServicesBenefitData.settlingInServices.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnSettlingServices,
					destinationServicesBenefitData.settlingInServices.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.settlingInServices.reimbursedBy, _txtBoxReimbursedByOtherSettlingServices,
					destinationServicesBenefitData.settlingInServices.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForSettlingServices, PDTConstants.COMMENT,
					destinationServicesBenefitData.settlingInServices.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillTransitionAssistanceProgramForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxDurationInDaysForTransitionAssistanceProg,
					_lblDurationInDaysForTransitionAssistanceProg.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxDurationInDaysForTransitionAssistanceProg, _lblDurationInDaysForTransitionAssistanceProg.getText(),
					destinationServicesBenefitData.transitionAssistanceProgram.durationInDays);
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtTransitionAssistanceProg, _lblMaxAmtForTransitionAssistanceProg.getText(),
					destinationServicesBenefitData.transitionAssistanceProgram.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrencyTransitionAssistanceProg);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptionsTransitionAssistanceProg,
					destinationServicesBenefitData.transitionAssistanceProgram.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnTransitionAssistanceProg);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTransitionAssistanceProg,
					destinationServicesBenefitData.transitionAssistanceProgram.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTransitionAssistanceProg,
					destinationServicesBenefitData.transitionAssistanceProgram.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.transitionAssistanceProgram.reimbursedBy, _txtBoxReimbursedByOtherTransitionAssistanceProg,
					destinationServicesBenefitData.transitionAssistanceProgram.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForTransitionAssistanceProg, PDTConstants.COMMENT,
					destinationServicesBenefitData.transitionAssistanceProgram.comment);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}
	
	public void fillTutionAndEductionForm(PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _txtBoxMaxAmtTutionAndEduction,
					_lblMaxAmtForTutionAndEduction.getText());
			CoreFunctions.clearAndSetText(driver, _txtBoxMaxAmtTutionAndEduction, _lblMaxAmtForTutionAndEduction.getText(),
					destinationServicesBenefitData.tutionAndEducation.maxAmount);
			CoreFunctions.clickElement(driver, _drpDownCurrencyTutionAndEduction);
			CoreFunctions.selectItemInListByText(driver, _drpDownCurrencyOptionsTutionAndEduction,
					destinationServicesBenefitData.tutionAndEducation.currency, PDTConstants.CURRENCY,
					PDTConstants.DROP_DOWN, true);
			
			CoreFunctions.explicitWaitTillElementListClickable(driver, _radioBtnTutionAndEduction);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTutionAndEduction,
					destinationServicesBenefitData.tutionAndEducation.grossUp, PDTConstants.GROSS_UP,
					PDTConstants.RADIO_BUTTON_LIST, true);
			CoreFunctions.selectItemInListByText(driver, _radioBtnTutionAndEduction,
					destinationServicesBenefitData.tutionAndEducation.reimbursedBy, PDTConstants.REIMBURSED_BY,
					PDTConstants.RADIO_BUTTON_LIST, true);

			BusinessFunctions.verifyReimbursedByOtherTextBoxIsDisplayed(driver, addNewPolicyPage,
					destinationServicesBenefitData.tutionAndEducation.reimbursedBy, _txtBoxReimbursedByOtherTutionAndEduction,
					destinationServicesBenefitData.tutionAndEducation.reimbursedByOther, subBenefitFormName);
			CoreFunctions.clearAndSetText(driver, _txtAreaCommentForTutionAndEduction, PDTConstants.COMMENT,
					destinationServicesBenefitData.tutionAndEducation.comment);
		} catch (Exception e) {			
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL, subBenefitFormName));
		}
	}


}
