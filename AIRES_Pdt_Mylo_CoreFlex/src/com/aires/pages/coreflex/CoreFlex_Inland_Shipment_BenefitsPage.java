package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.iris.helpers.Helpers;
import com.aires.managers.FileReaderManager;
import com.aires.pages.iris.IRIS_AssignmentServicePage;
import com.aires.pages.iris.IRIS_PageMaster;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_MovingBenefitsData;
import com.aires.utilities.Log;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.DialogDescription;
import com.hp.lft.sdk.java.Menu;
import com.hp.lft.sdk.java.TabControl;
import com.hp.lft.sdk.java.Table;
import com.hp.lft.sdk.java.TableDescription;
import com.hp.lft.sdk.java.Window;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_Inland_Shipment_BenefitsPage extends BenefitPage {

	public CoreFlex_Inland_Shipment_BenefitsPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

	// Back Button
	@FindBy(how = How.CSS, using = "button[class*='btn-back']")
	private WebElement _buttonBack;

	// Exit Button
	@FindBy(how = How.CSS, using = "button[class*='btn-exit']")
	private WebElement _buttonExit;

	// Logout Button
	@FindBy(how = How.XPATH, using = "//i[contains(text(),'exit_to_app')]")
	private WebElement _buttonLogout;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Policy Header
	@FindBy(how = How.CSS, using = "h4[class='card-title'] > b")
	private WebElement _headerPolicyInfo;

	// Page Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Core Type Selection
	@FindBy(how = How.ID, using = "core")
	private WebElement _textCore;

	// Flex Type Selection
	@FindBy(how = How.ID, using = "flex")
	private WebElement _textFlex;

	// Flex Points Input Field
	@FindBy(how = How.CSS, using = "input[formcontrolname='flexPoints']")
	private WebElement _inputFlexPoints;

	// Core Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Core Benefits')]")
	private WebElement _textCoreBenefits;

	// Flex Benefit - Both Selection
	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Flex Benefits')]")
	private WebElement _textFlexBenefits;

	// Both Benefit Type Selection
	@FindBy(how = How.ID, using = "both")
	private WebElement _textBoth;

	// Benefit Display Name Input Field
	@FindBy(how = How.ID, using = "benefitName")
	private WebElement _inputBenefitName;

	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private List<WebElement> _inputMultiAddBenefitLabel;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']")
	private List<WebElement> _inputMultiAddBenefitButton;

	// Aires Managed Benefit Radio Label Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div/label[@class='form-check-label']")
	private List<WebElement> _radioAiresManagedLabelList;

	// Aires Managed Benefit Radio Button Selection
	@FindBy(how = How.XPATH, using = "//label[contains(text(),'Aires Managed Service')]/following-sibling::div//input")
	private List<WebElement> _radioAiresManagedButtonList;

	// Allowance / Amount Message TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='shortDesc']")
	private WebElement _textAreaAllowanceAmountMessage;

	// Benefit Long Description TextArea Field
	@FindBy(how = How.CSS, using = "textarea[name='longDesc']")
	private WebElement _textAreaBenefitLongDescription;

	// SubBenefit List
	@FindBy(how = How.CSS, using = "div.form-check > label.form-check-label")
	private List<WebElement> _subBenefitList;

	// Gross Up - Radio Button Selection
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='grossedUpInd']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioBtnGrossUp;

	// Radio Button Selection From Entire SubBenefit Section
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[@class='form-check-label']")
	private List<WebElement> _radioBtnCandidateSelection;

	// Reimbursed By Other Input
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//input[@formcontrolname='paidByOther']")
	private WebElement _inputReimbursedBy;

	// Comment Text Area
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//textarea[@formcontrolname='benefitComment']")
	private WebElement _txtAreaComment;

	// Aires Managed Service Radio Button
	@FindBy(how = How.CSS, using = "div[class*='form-check-radio'] > label[class*='form-check']")
	private List<WebElement> _radioAiresManagedService;

	// Benefit can be selected more than once Checkbox
	@FindBy(how = How.XPATH, using = "//input[@id='multiAddInd']/parent::label")
	private WebElement _inputMultiAddBenefit;

	// Policy Benefits data Missing Error Dialog
	@FindBy(how = How.XPATH, using = "//div[@id='swal2-content'][contains(text(),'Policy Benefits data missing. Please complete all the benefits.')]")
	private WebElement _errorDialogPolicyBenefitsDataMissing;

	// Policy Benefits data Missing Error Dialog - OK Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _errorDialogPolicyBenefitsDataMissingOKButton;

	// SubBenefit - Collapsable Menu 1
	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Inland Shipment')]/ancestor::a[contains(@href,'collapse')]")
	private WebElement _formInlandShipment;

	@FindBy(how = How.XPATH, using = "//h5[contains(text(),'Inland Shipment')]")
	private WebElement _headerInlandShipment;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempStorageDurationCode']")
	private WebElement _selectTempStorageDuration;

	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='tempStorageDurationCode'] span.ng-option-label")
	private List<WebElement> _selectTempStorageDurationOptions;

	@FindBy(how = How.XPATH, using = "//input[@formcontrolname='insuranceType']/parent::label[@class='form-check-label']")
	private List<WebElement> _radioInsuranceType;

	@FindBy(how = How.CSS, using = "input[formcontrolname='insuranceTypeOther']")
	private WebElement _inputInsuranceTypeOther;
	
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Flex Benefits')]/ancestor::div[contains(@id,'secondItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> flexCardPanelList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//div[contains(@class,'RXCFServicesMonitoringBorderPanel')]")
	private List<WebElement> coreCardPanelList;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Core Benefits')]/ancestor::div[contains(@id,'firstItemDiv')]//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]")
	private WebElement coreCardStartingSoonStatus;

	private By beginPackStatus = By
			.xpath(".//span[contains(@class,'RXSmallerTextMuted RXBold')][contains(text(),'Begin Pack')]");

	private By beginPackEstimatedDate = By.xpath(".//div[5]//span[not(contains(text(),'estimated'))]");

	private By deliveryEstimatedDate = By
			.xpath(".//div[5]//span[not(contains(text(),'estimated'))][@class='RXSmallerTextMuted RXBold']");

	private By flexCardStartingSoonStatusBy = By
			.xpath(".//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]");

	private By startingSoonStatusBy = By
			.xpath(".//table[contains(@class,'RXRightIconPanel')]//span[contains(text(),'Starting Soon')]");

	private By deliveryStatus = By.xpath(
			".//span[contains(@class,'ServicesSuccessIcon')]/ancestor::div[contains(@class,'ServicesTrain')]//span[contains(text(),'Delivery')]");

	/*********************************************************************/

	CoreFlex_MovingBenefitsData inlandShipmentBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMovingBenefitDataList(COREFLEXConstants.INLAND_SHIPMENT);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.INLAND_SHIPMENT,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case PDTConstants.LOGOUT:
				CoreFunctions.clickElement(driver, _buttonLogout);
				break;
			case COREFLEXConstants.SAVE_AND_CONTINUE:
				CoreFunctions.clickElement(driver, _buttonSaveAndContinue);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.EXIT:
				CoreFunctions.clickElement(driver, _buttonExit);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_AN_ELEMENT_OF_PAGE,
							CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
	}

	/**
	 * Generic method to click on an Left Navigation Menu.
	 * 
	 * @param elementName
	 */
	public void clickLeftNavigationMenuOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.GENERAL_INFORMATION:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.GENERAL_INFORMATION);
				break;
			case COREFLEXConstants.FLEX_POLICY_SETUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.FLEX_POLICY_SETUP);
				break;
			case COREFLEXConstants.POLICY_BENEFIT_CATEGORIES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.POLICY_BENEFIT_CATEGORIES);
				break;
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			default:
				Assert.fail(PDTConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_LEFTNAVIGATION_ELEMENT_OF_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);

		}
	}

	/**
	 * Method to call select Benefit Type and Sub Benefits, fill all mandatory
	 * fields methods
	 * 
	 * @param benefitType
	 * @param subBenefitNames
	 * @param multipleBenefitSelection
	 * @param flexPoints
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	public void selectAndFillBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.CORE_BENEFITS);
			selectBenefitTypeAndFillMandatoryFields(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection,
					flexPoints, benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, COREFLEXConstants.FLEX_BENEFITS);
		} else {
			selectBenefitTypeAndFillMandatoryFields(benefitType, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, aireManagedService);
			selectSubBenefitsAndFillMandatoryFields(subBenefitNames, benefitType);
		}
		clickElementOfPage(COREFLEXConstants.SAVE_AND_CONTINUE);

		if (CoreFunctions.isElementExist(driver, _errorDialogPolicyBenefitsDataMissing, 7)) {
			CoreFunctions.clickElement(driver, _errorDialogPolicyBenefitsDataMissingOKButton);
		}
	}

	/**
	 * Method to select and fill mentioned SubBenefits and fill all the SubBenefits
	 * section fields
	 * 
	 * @param subBenefitNames
	 * @param benefitType
	 */
	public void selectSubBenefitsAndFillMandatoryFields(String subBenefitNames, String benefitType) {
		try {
			List<String> subBenefitNamesList = new ArrayList<String>();
			if (subBenefitNames.contains(";"))
				subBenefitNamesList = Arrays.asList(subBenefitNames.split(";"));
			else
				subBenefitNamesList.add(subBenefitNames);

			for (String subBenefit : subBenefitNamesList) {
				if (subBenefitNamesList.size() > 1) {
					CoreFunctions.selectItemInListByText(driver, _subBenefitList, subBenefit.trim(), true);
				}
				if (CoreFunctions.isElementExist(driver, getElementByName(subBenefit.trim()), 5)) {
					fillSubBenefit(subBenefit.trim(), benefitType);
				} else {
					Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.INLAND_SHIPMENT_BENEFITS_PAGE));
					throw new RuntimeException(MessageFormat.format(COREFLEXConstants.SUB_BENEFIT_FORM_NOT_DISPLAYED,
							CoreConstants.FAIL, subBenefit, COREFLEXConstants.INLAND_SHIPMENT_BENEFITS_PAGE));
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_AIRES_MANAGED_SUB_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	/**
	 * Method to Expand and call FillSubBenefit method
	 * 
	 * @param subBenefit
	 * @param benefitType
	 */
	public void fillSubBenefit(String subBenefit, String benefitType) {
		switch (subBenefit) {
		case COREFLEXConstants.INLAND_SHIPMENT:
			expandSubBenefitIfCollapsed(getElementByName(COREFLEXConstants.INLAND_SHIPMENT));
//			if (benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) {
//				CoreFunctions.clickElement(driver, _headerInlandShipment);
//			}
			fillInlandShipmentSubBenefitForm(COREFLEXConstants.INLAND_SHIPMENT);
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
	}

	/**
	 * Method to fill Area Tour subBenefit form
	 * 
	 * @param subBenefitFormName
	 */
	private void fillInlandShipmentSubBenefitForm(String subBenefitFormName) {
		try {
			CoreFunctions.clickElement(driver, _selectTempStorageDuration);
			CoreFunctions.selectItemInListByText(driver, _selectTempStorageDurationOptions,
					inlandShipmentBenefitData.inlandShipment.temporaryStorageDuration, true);

			CoreFunctions.clearAndSetText(driver, _txtAreaComment, inlandShipmentBenefitData.inlandShipment.comment);
			CoreFunctions.selectItemInListByText(driver, _radioBtnGrossUp,
					inlandShipmentBenefitData.inlandShipment.grossUp, true);
			CoreFunctions.selectItemInListByText(driver, _radioInsuranceType,
					inlandShipmentBenefitData.inlandShipment.insuranceType, true);
			if (inlandShipmentBenefitData.inlandShipment.insuranceType.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputInsuranceTypeOther,
						inlandShipmentBenefitData.inlandShipment.insuranceTypeOther);
			}
			CoreFunctions.selectItemInListByText(driver, _radioBtnCandidateSelection,
					inlandShipmentBenefitData.inlandShipment.reimbursedBy, true);
			if (inlandShipmentBenefitData.inlandShipment.reimbursedBy.equalsIgnoreCase(COREFLEXConstants.OTHER)) {
				CoreFunctions.clearAndSetText(driver, _inputReimbursedBy,
						inlandShipmentBenefitData.inlandShipment.reimbursedByOther);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_FILL_SUBBENEFIT_FORM, CoreConstants.FAIL,
					subBenefitFormName, e.getMessage()));
		}

	}

	/**
	 * Method to Expand SubBenefits Section is collapsed
	 * 
	 * @param subBenefitForm
	 */
	public void expandSubBenefitIfCollapsed(WebElement subBenefitForm) {
		if (subBenefitForm.getAttribute("class").equalsIgnoreCase("collapsed")) {
			CoreFunctions.clickElement(driver, subBenefitForm);
		}
	}

	/**
	 * Method to get SubBenefit Section Element
	 * 
	 * @param elementName
	 * @return
	 */
	public WebElement getElementByName(String elementName) {
		WebElement element = null;
		switch (elementName) {
		case COREFLEXConstants.INLAND_SHIPMENT:
			element = _formInlandShipment;
			break;
		default:
			Assert.fail(MessageFormat.format(COREFLEXConstants.ELEMENT_NOT_FOUND, CoreConstants.FAIL));
		}
		return element;
	}

	/**
	 * Method to select Benefit Type and fill all Mandatory Fields
	 * 
	 * @param benefitType
	 * @param multipleBenefitSelection
	 * @param flexPoints
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	public void selectBenefitTypeAndFillMandatoryFields(String benefitType, String multipleBenefitSelection,
			String flexPoints, String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription,
			String aireManagedService) {
		Benefit inlandShipmentBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.INLAND_SHIPMENT)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, inlandShipmentBenefit.getBenefitDisplayName(),
					inlandShipmentBenefit.getBenefitAmount(), inlandShipmentBenefit.getBenefitDesc(),
					aireManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, inlandShipmentBenefit.getBenefitDisplayName(),
					inlandShipmentBenefit.getBenefitAmount(), inlandShipmentBenefit.getBenefitDesc(),
					aireManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputFlexPoints, flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			fillManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, aireManagedService);
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
	}

	/**
	 * Method to fill Default Mandatory Fields of Benefit
	 * 
	 * @param benefitType
	 * @param multipleBenefitSelection
	 * @param benefitDisplayName
	 * @param benefitAllowanceAmount
	 * @param benefitDescription
	 * @param aireManagedService
	 */
	public void fillManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String aireManagedService) {
		try {
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputBenefitName, benefitDisplayName,
					COREFLEXConstants.BENEFIT_DISPLAY_NAME);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaAllowanceAmountMessage, benefitAllowanceAmount,
					COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _textAreaBenefitLongDescription, benefitDescription,
					COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
			if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
				if ((multipleBenefitSelection.equals(COREFLEXConstants.YES)))
					CoreFunctions.clickElement(driver, _inputMultiAddBenefit);
				CoreFunctions.selectItemInListByText(driver, _radioAiresManagedService, aireManagedService, true,
						COREFLEXConstants.AIRES_MANAGED_SERVICE);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FILLING_MANDATORY_FIELDS_OF_BENEFIT,
							CoreConstants.FAIL, e.getMessage(), benefitDisplayName));
		}
	}

	public boolean verifyAddedBenefitsAndSubBenefitDetails(String benefitType, String subBenefitNames,
			String multipleBenefitSelection, String flexPoints, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if (benefitType.equals(COREFLEXConstants.BOTH)) {
			CoreFunctions.clickElement(driver, _textBoth);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.CORE_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			verifyBenefitsMandatoryDetails(COREFLEXConstants.FLEX_BENEFITS, multipleBenefitSelection, flexPoints,
					benefitDisplayName, benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			return true;
		} else {
			verifyBenefitsMandatoryDetails(benefitType, multipleBenefitSelection, flexPoints, benefitDisplayName,
					benefitAllowanceAmount, benefitDescription, paymentOption, airesManagedService);
			return true;
		}
	}

	private void verifyBenefitsMandatoryDetails(String benefitType, String multipleBenefitSelection, String flexPoints,
			String benefitDisplayName, String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		Benefit culturalTrainingBenefit = coreBenefits.stream()
				.filter(b -> b.getBenefitType().equals(COREFLEXConstants.CULTURAL_TRAINING)).findAny().orElse(null);
		switch (benefitType) {
		case COREFLEXConstants.CORE:
			CoreFunctions.clickElement(driver, _textCore);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					culturalTrainingBenefit.getBenefitDisplayName(), culturalTrainingBenefit.getBenefitAmount(),
					culturalTrainingBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX:
			CoreFunctions.clickElement(driver, _textFlex);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.CORE_BENEFITS:
			CoreFunctions.clickElement(driver, _textCoreBenefits);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection,
					culturalTrainingBenefit.getBenefitDisplayName(), culturalTrainingBenefit.getBenefitAmount(),
					culturalTrainingBenefit.getBenefitDesc(), paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.FLEX_BENEFITS:
			CoreFunctions.clickElement(driver, _textFlexBenefits);
			CoreFunctions.verifyText(_inputFlexPoints.getDomProperty("value"), flexPoints,
					COREFLEXConstants.FLEX_POINTS_VALUE);
			CoreFunctions.highlightObject(driver, _inputFlexPoints);
			verifyManadatoryDetails(benefitType, multipleBenefitSelection, benefitDisplayName, benefitAllowanceAmount,
					benefitDescription, paymentOption, airesManagedService);
			break;
		case COREFLEXConstants.BOTH:
			CoreFunctions.clickElement(driver, _textBoth);
			break;
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}

	}

	private void verifyManadatoryDetails(String benefitType, String multipleBenefitSelection, String benefitDisplayName,
			String benefitAllowanceAmount, String benefitDescription, String paymentOption,
			String airesManagedService) {
		if ((benefitType.equals(COREFLEXConstants.FLEX_BENEFITS)) || (benefitType.equals(COREFLEXConstants.FLEX))) {
			if ((multipleBenefitSelection.equals(COREFLEXConstants.YES))) {
				CoreFunctions.verifyRadioButtonSelection(driver, _inputMultiAddBenefitLabel,
						_inputMultiAddBenefitButton, COREFLEXConstants.BENEFIT_SELECTED_MORE_THAN_ONCE,
						COREFLEXConstants.MULTIPLE_BENEFIT_SELECTION);
			}
			CoreFunctions.verifyRadioButtonSelection(driver, _radioAiresManagedLabelList, _radioAiresManagedButtonList,
					airesManagedService, COREFLEXConstants.AIRES_MANAGED_SERVICE);
		}
		CoreFunctions.verifyText(_inputBenefitName.getDomProperty("value"), benefitDisplayName,
				COREFLEXConstants.BENEFIT_DISPLAY_NAME);
		CoreFunctions.highlightObject(driver, _inputBenefitName);
		CoreFunctions.verifyText(_textAreaAllowanceAmountMessage.getDomProperty("value"), benefitAllowanceAmount,
				COREFLEXConstants.ALLOWANCE_AMOUNT_MESSAGE);
		CoreFunctions.highlightObject(driver, _textAreaAllowanceAmountMessage);
		CoreFunctions.verifyText(_textAreaBenefitLongDescription.getDomProperty("value"), benefitDescription,
				COREFLEXConstants.BENEFIT_LONG_DESCRIPTION);
		CoreFunctions.highlightObject(driver, _textAreaBenefitLongDescription);
	}

	@Override
	public boolean verifyFlexBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		Log.info(CoreFunctions.getElementText(driver,
				CoreFunctions.findSubElement(flexCardPanelList.get(index), beginPackEstimatedDate)) + ":"
				+ expectedEstimatedDate);
		return (CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(flexCardPanelList.get(index), beginPackStatus), 3)
				&& (CoreFunctions
						.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(index), beginPackEstimatedDate))
						.equals(expectedEstimatedDate))
				&& (!CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), startingSoonStatusBy), 3)));
	}

	@Override
	protected boolean verifyFlexBenefitCardStatusAfterEndActualization(int index, String expectedEstimatedDate) {
		return (CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(flexCardPanelList.get(index), deliveryStatus), 3)
				&& (CoreFunctions
						.getElementText(driver,
								CoreFunctions.findSubElement(flexCardPanelList.get(index), deliveryEstimatedDate))
						.equals(expectedEstimatedDate))
				&& (!CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(flexCardPanelList.get(index), flexCardStartingSoonStatusBy), 3)));
	}

	@Override
	public boolean verifyCoreBenefitCardStatusAfterInitialActualization(int index, String expectedEstimatedDate) {
		return (CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(coreCardPanelList.get(index), beginPackStatus), 3)
				&& (CoreFunctions
						.getElementText(driver,
								CoreFunctions.findSubElement(coreCardPanelList.get(index), beginPackEstimatedDate))
						.equals(expectedEstimatedDate))
				&& (!CoreFunctions.isElementExist(driver,
						CoreFunctions.findSubElement(coreCardPanelList.get(index), startingSoonStatusBy), 3)));
	}

	@Override
	protected boolean verifyCoreBenefitCardStatusAfterEndActualization(int index, Benefit benefit) {
		return (CoreFunctions.isElementExist(driver,
				CoreFunctions.findSubElement(coreCardPanelList.get(index), deliveryStatus), 3)
				&& (!CoreFunctions.isElementExist(driver, coreCardStartingSoonStatus, 3)));
	}

	@Override
	public void addSubService(Window _IRIS, Table table, Benefit benefit, String coreFlexType) {
		try {
			String initialSubSerivceWindow = MessageFormat.format(IRISConstants.INITIAL_SUB_SERVICE_TITLE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
					CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
					CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientID"));

			Log.info(initialSubSerivceWindow);

			DateTimeFormatter dtf = DateTimeFormatter.ofPattern("MM/dd/uuuu");
			LocalDateTime now = LocalDateTime.now();

			_IRIS = IRIS_PageMaster.getWindowObject(initialSubSerivceWindow);
			_IRIS.waitUntilVisible();
			System.out.println(benefit.getSubServiceDetails());
			Map<String, String> details = benefit.shipmentSubSeriveDetails();
			IRIS_PageMaster.getListObject(_IRIS, IRISConstants.PACK, 0).select(details.get("Pack"));
			IRIS_PageMaster.getListObject(_IRIS, IRISConstants.PACK, 1).select(details.get("Routing1"));
			IRIS_PageMaster.getListObject(_IRIS, IRISConstants.ROUTING).select(details.get("Routing2"));
			IRIS_PageMaster.getListObject(_IRIS, IRISConstants.MODE).select(details.get("Mode"));
			IRIS_PageMaster.getListObject(_IRIS, IRISConstants.TYPE_SUBSERVICE).select(details.get("Type"));
			IRIS_PageMaster.getEditorObjectWithNativeClass(_IRIS, IRISConstants.EST_MOVE_DATE,
					"com.aires.iris.shipment.viewcommon.component.ISISDateTextField").setText(dtf.format(now));
			if (details.get("StateCross") != null)
				IRIS_PageMaster.getListObject(_IRIS, IRISConstants.STATE_CROSS).select(details.get("StateCross"));

			Helpers.clickButton(IRIS_PageMaster.getButtonObject(_IRIS, IRISConstants.SAVE_BUTTON),
					IRIS_PageMaster.getButtonObject(_IRIS, IRISConstants.SAVE_BUTTON).getAttachedText());

			Helpers.clickButton(IRIS_PageMaster.getButtonObjectFromLabel(
					IRIS_PageMaster.getDialogObject(_IRIS, IRISConstants.MESSAGE_DIALOG), IRISConstants.OK_BUTTON),
					IRIS_PageMaster.getButtonObjectFromLabel(
							IRIS_PageMaster.getDialogObject(_IRIS, IRISConstants.MESSAGE_DIALOG),
							IRISConstants.OK_BUTTON).getAttachedText());
			CoreFunctions.writeToPropertiesFile("irisWindowTitle", "");

			String assignmentWindowTitle = MessageFormat.format(
					IRISConstants.CLIENT_SPECIFIC_TRANSFEREE_TITLE_TO_APPEND_WITH_REDUCED_SPACE,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
					CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
					CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"));

			Log.info(assignmentWindowTitle);

			_IRIS = IRIS_PageMaster.getWindowObject(assignmentWindowTitle);

			int rowCount = Helpers
					.getTableRowCount(IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1));

			String subServiceId = String
					.valueOf(new Double(IRIS_PageMaster.getTableObjectWithIndex(_IRIS, "javax.swing.JTable", 1)
							.getCell(rowCount - 1, IRISConstants.ID_TEXT).getValue().toString()).intValue());
			CoreFunctions.writeToPropertiesFile("Assignment_subServiceID", subServiceId);

			String subServiceWindow = MessageFormat.format(IRISConstants.SUB_SERVICE_TITLE_WITH_ID, subServiceId,
					CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
					CoreFunctions.getPropertyFromConfig("Transferee_firstName"),
					CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientID"));

			_IRIS = IRIS_PageMaster.getWindowObject(subServiceWindow);

			Log.info(_IRIS.getTitle());
			activateSubService(_IRIS);
			addRequiredPartners(_IRIS, benefit);
			_IRIS.close();

			_IRIS = IRIS_PageMaster.getWindowObject(assignmentWindowTitle);
			_IRIS.waitUntilVisible();

			CoreFunctions.waitHandler(2);
			Reporter.addStepLog(
					MessageFormat.format(IRISConstants.SUCCESSFULLY_ADDED_SUB_SERVICE_DETAILS, CoreConstants.PASS));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(IRISConstants.FAILED_TO_ADD_SUB_SERVICE_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			Assert.fail(IRISConstants.FAILED_TO_ADD_SUB_SERVICE_DETAILS_ON_SEB_SERVICE_WINDOW);
		}

	}

	private void activateSubService(Window _IRIS) throws Exception {
		Menu optionsMenu = IRIS_PageMaster.getMenuObject(_IRIS, "Options");
		Menu changeShipmentStatusMenu = IRIS_PageMaster.getMenuObject(optionsMenu, "Change Shipment Status");
		Menu activateMenu = IRIS_PageMaster.getMenuObject(changeShipmentStatusMenu, "Activate");
		activateMenu.select();
		IRIS_PageMaster.getButtonObjectFromLabel(IRIS_PageMaster.getDialogObject(_IRIS, "Change Shipment Status"), "OK")
				.click();
	}

	private static void addRequiredPartners(Window _IRIS, Benefit benefit) throws Exception {
		TabControl tabControl = IRIS_PageMaster.getTabControlObject(_IRIS, "javax.swing.JTabbedPane", 0);
		Helpers.selectTabControl(tabControl, "Activity & Finance");
		Table activityFinanceTable = IRIS_PageMaster.getTableObject(_IRIS,
				"com.aires.iris.shipment.activityfinance.ActivityFinancePanel$3");
		int rowId = Helpers.getRowIdMatchingCellValue(activityFinanceTable, "Co. Name", "Aires");
		activityFinanceTable.selectRows(rowId);

		for (String partner : benefit.getPartners().split(",")) {

			Button selectPartnerButton = IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Select Partner");
			selectPartnerButton.click();

			Dialog partnerRecommendationDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation");

			if (partner.trim().equals("OA")) {
				partnerRecommendationDialog.waitUntilVisible();
				Helpers.selectFromList(IRIS_PageMaster.getListObject(partnerRecommendationDialog,
						"Select a participant, then select a partner"), "Origin Agent", "");

				Helpers.setTableCellValue(IRIS_PageMaster.getTableObject(partnerRecommendationDialog), 0, "Partner ID",
						"0");

				IRIS_PageMaster.getTableObject(partnerRecommendationDialog).getCell(0, "Partner Name").click();

				IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog, "...").click();

				Dialog companyLookupDialog = IRIS_PageMaster.getDialogObject(partnerRecommendationDialog,
						"Company Lookup");
				Table companyLookupTableTable = IRIS_PageMaster.getTableObject(companyLookupDialog);
				Helpers.selectTableRow(companyLookupTableTable, 0);

				Button selectButton = IRIS_PageMaster.getButtonObjectFromLabel(companyLookupDialog, "Select");
				selectButton.click();

				Button selectPartnerButton1 = IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog,
						"Select Partner");
				selectPartnerButton1.click();

				Button saveButton = IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog, "Save");
				saveButton.click();

				Dialog participantTracingDialog = IRIS_PageMaster.getDialogObject(partnerRecommendationDialog,
						"Participant Tracing");
				Button yesButton = IRIS_PageMaster.getButtonObjectFromLabel(participantTracingDialog, "Yes");
				yesButton.click();

				Dialog reportingRequirementsDialog = IRIS_PageMaster.getDialogObject(partnerRecommendationDialog,
						"Reporting Requirements");
				Button saveButton1 = IRIS_PageMaster.getButtonObjectFromLabel(reportingRequirementsDialog, "Save");
				saveButton1.click();

				Dialog messageDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Message");
				Button oKButton = IRIS_PageMaster.getButtonObject(messageDialog, "OK",
						"javax.swing.plaf.basic.BasicOptionPaneUI$ButtonFactory$ConstrainedButton");
				oKButton.click();

				if (benefit.getPartners().contains("DA")) {
					selectPartnerButton.click();
					partnerRecommendationDialog = IRIS_PageMaster.getDialogObject(_IRIS, "Partner Recommendation");
					Helpers.selectFromList(IRIS_PageMaster.getListObject(partnerRecommendationDialog,
							"Select a participant, then select a partner"), "Destination Agent", "");

					Helpers.selectTableRow(IRIS_PageMaster.getTableObject(partnerRecommendationDialog), 1);

					selectPartnerButton1.click();

					saveButton.click();

					yesButton.click();

					Table tonnagePanel1Table = reportingRequirementsDialog.describe(Table.class,
							new TableDescription());
					tonnagePanel1Table.selectRows(1);

					saveButton1.click();

					oKButton.click();
				}
				Button saveButton2 = IRIS_PageMaster.getButtonObjectFromLabel(_IRIS, "Save");
				saveButton2.click();

				oKButton.click();
			}

			if (partner.trim().equals("IMVR")) {
				partnerRecommendationDialog.waitUntilVisible();
				Helpers.selectFromList(IRIS_PageMaster.getListObject(partnerRecommendationDialog,
						"Select a participant, then select a partner"), "International Mover", "");

				Helpers.setTableCellValue(IRIS_PageMaster.getTableObject(partnerRecommendationDialog), 0, "Partner ID",
						"0");

				IRIS_PageMaster.getTableObject(partnerRecommendationDialog).getCell(0, "Partner Name").click();

				IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog, "...").click();

				Dialog companyLookupDialog = IRIS_PageMaster.getDialogObject(partnerRecommendationDialog,
						"Company Lookup");
				Table companyLookupTableTable = IRIS_PageMaster.getTableObject(companyLookupDialog);

				rowId = Helpers.getRowIdMatchingCellValue(companyLookupTableTable, "Partner ID", "98392");

				companyLookupTableTable.activateRow(rowId);

				Button selectButton = companyLookupDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Select").build());
				selectButton.click();

				Button selectPartnerButton1 = IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog,
						"Select Partner");
				selectPartnerButton1.click();

				Button saveButton = partnerRecommendationDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Save").build());
				saveButton.click();

				Dialog participantTracingDialog = partnerRecommendationDialog.describe(Dialog.class,
						new DialogDescription.Builder().title("Participant Tracing").build());
				Button yesButton = participantTracingDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Yes").build());
				yesButton.click();

				Dialog messageDialog = Desktop.describe(Dialog.class,
						new DialogDescription.Builder().title("Message").build());
				Button oKButton = messageDialog.describe(Button.class,
						new ButtonDescription.Builder().label("OK").build());
				oKButton.click();
			}

			if (partner.trim().equals("INS")) {
				partnerRecommendationDialog.waitUntilVisible();
				Helpers.selectFromList(IRIS_PageMaster.getListObject(partnerRecommendationDialog,
						"Select a participant, then select a partner"), "Insurance", "");

				Table showPartnersForTable = partnerRecommendationDialog.describe(Table.class, new TableDescription());
				showPartnersForTable.getCell(0, "Partner ID").setValue("0");

				IRIS_PageMaster.getTableObject(partnerRecommendationDialog).getCell(0, "Partner Name").click();

				IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog, "...").click();

				Dialog companyLookupDialog = partnerRecommendationDialog.describe(Dialog.class,
						new DialogDescription.Builder().title("Company Lookup").build());
				Table companyLookupTableTable = companyLookupDialog.describe(Table.class, new TableDescription());
				companyLookupTableTable.selectColumnHeader("Partner ID");

				rowId = Helpers.getRowIdMatchingCellValue(companyLookupTableTable, "Partner ID", "89685");

				companyLookupTableTable.activateRow(rowId);

				Button selectButton = companyLookupDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Select").build());
				selectButton.click();

				Button selectPartnerButton1 = IRIS_PageMaster.getButtonObjectFromLabel(partnerRecommendationDialog,
						"Select Partner");
				selectPartnerButton1.click();

				Button saveButton = partnerRecommendationDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Save").build());
				saveButton.click();

				Dialog participantTracingDialog = partnerRecommendationDialog.describe(Dialog.class,
						new DialogDescription.Builder().title("Participant Tracing").build());
				Button yesButton = participantTracingDialog.describe(Button.class,
						new ButtonDescription.Builder().label("Yes").build());
				yesButton.click();

				Dialog messageDialog = Desktop.describe(Dialog.class,
						new DialogDescription.Builder().title("Message").build());
				Button oKButton = messageDialog.describe(Button.class,
						new ButtonDescription.Builder().label("OK").build());
				oKButton.click();
			}
			if (partnerRecommendationDialog.exists())
				partnerRecommendationDialog.close();
		}
	}

}
