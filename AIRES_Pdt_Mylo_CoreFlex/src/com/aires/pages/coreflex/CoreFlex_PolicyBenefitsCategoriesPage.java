package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_PolicyBenefitsCategoriesPage extends Base {

	public CoreFlex_PolicyBenefitsCategoriesPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Next Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'NEXT')]")
	private WebElement _buttonNext;

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

	// Flex Policy Setup Header
	@FindBy(how = How.CSS, using = "div[class*='pcard-header'] > h4[class='card-title']")
	private WebElement _headerPage;

	// Flex Policy Left Navigation Active Tile
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[@class='disabled nav-item active']//p")
	private WebElement _leftNavigationTitleActive;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Select All Selection - Toggle Button
	@FindBy(how = How.XPATH, using = "//mat-slide-toggle[@formcontrolname='checkAll']//span[contains(string(),'Select All')]")
	private WebElement _toggleButtonSelectAll;

	// Deselect All Selection - Toggle Button
	@FindBy(how = How.XPATH, using = "//mat-slide-toggle[@formcontrolname='checkAll']//span[contains(string(),'Deselect All')]")
	private WebElement _toggleButtonDeselectAll;

	// List of Benefits selected by Select All Toggle
	@FindBy(how = How.XPATH, using = "//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _selectAllSelectedList;

	// List of Benefits Present on the page (Excluding Non Visible Benefits)
	@FindBy(how = How.CSS, using = "label[class='checkboxLabel']")
	private List<WebElement> _allBenefitsList;

	// List of Benefits Parent Element on the page (Excluding Non Visible Benefits)
	@FindBy(how = How.XPATH, using = "//div[@class='cardbody']")
	private List<WebElement> _allBenefitsParentElementList;

	// List of Benefits Button Element on the page (Excluding Non Visible Benefits)
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox'][contains(@class,'ng-valid')]")
	private List<WebElement> _allBenefitsButtonElementList;

	// List of Benefits Label Element on the page (Excluding Non Visible Benefits)
	@FindBy(how = How.XPATH, using = "//input[@type='checkbox'][contains(@class,'ng-valid')]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _allBenefitsLabelElementList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//a[contains(@class,'menu-pad')]//p")
	private List<WebElement> _leftNavigationTitleSelectedBenefitsList;

	// Left Navigation Selected Benefits List
	@FindBy(how = How.XPATH, using = "//a[contains(text(),'Show More')]")
	private List<WebElement> _linkShowMoreList;

	// All Benefits Heading Benefits
	@FindBy(how = How.CSS, using = "span[class*='cardtopinner']")
	private List<WebElement> _allBenefitsHeading;

	// Housing Tab Selectable Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'housingCardBorder')]//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _housingTabSelectableBenefitList;

	// Housing Tab all Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'housingCardBorder')]//input/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _housingTabAllBenefitList;

	// Moving Tab Selectable Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'movingCardBorder')]//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _movingTabSelectableBenefitList;

	// Moving Tab all Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'movingCardBorder')]//input/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _movingTabAllBenefitList;

	// Settling In Tab Selectable Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'settingInCardBorder')]//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _settlingInTabSelectableBenefitList;

	// Settling In Tab all Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'settingInCardBorder')]//input/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _settlingInTabAllBenefitList;

	// Lifestyle Tab Selectable Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'lifeStyleCardBorder')]//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _lifestyleTabSelectableBenefitList;

	// Lifestyle Tab all Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'lifeStyleCardBorder')]//input/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _lifestyleTabAllBenefitList;

	// Allowances Tab Selectable Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'allowanceCardBorder')]//input[not(@disabled)]/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _allowanceTabSelectableBenefitList;

	// Allowances Tab all Benefits List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'allowanceCardBorder')]//input/following-sibling::label[@class='checkboxLabel']")
	private List<WebElement> _allowanceTabAllBenefitList;

	// Unsaved Changes Pop-Up
	@FindBy(how = How.XPATH, using = "//h2[@id='swal2-title'][contains(text(),'Unsaved Changes')]")
	private WebElement _popUpUnsavedChanges;

	// Unsaved Changes Pop-Up Ok Button
	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _popUpUnsavedChangesOkButton;

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'SAVE & CONTINUE')]")
	private WebElement _buttonSaveAndContinue;

	// If Applicable Text
	@FindBy(how = How.XPATH, using = "//*[contains(text(),'if applicable')]")
	private WebElement _textIfApplicable;

	/*********************************************************************/

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.POLICY_BENEFIT_CATEGORIES,
				expectedPageName, expectedPageName, true);
	}

	/**
	 * Method to get currently active Left Navigation Menu.
	 * 
	 * @return
	 */
	public String getLeftNavigationPageTitle() {
		try {
			return CoreFunctions.getElementText(driver, _leftNavigationTitleActive);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_LEFT_NAVIGATION_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
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
			case PDTConstants.NEXT:
				CoreFunctions.clickElement(driver, _buttonNext);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case PDTConstants.SELECT_ALL:
				CoreFunctions.clickElement(driver, _toggleButtonSelectAll);
				break;
			case PDTConstants.DESELECT_ALL:
				CoreFunctions.clickElement(driver, _toggleButtonDeselectAll);
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
			case COREFLEXConstants.DUPLICATE_HOUSING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.DUPLICATE_HOUSING);
				break;
			case COREFLEXConstants.LUMP_SUM:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.LUMP_SUM);
				break;
			case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.OTHER_HOUSING_BENEFIT);
				break;
			case COREFLEXConstants.TEMPORARY_LIVING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.TEMPORARY_LIVING);
				break;
			case COREFLEXConstants.LANGUAGE_TRAINING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.LANGUAGE_TRAINING);
				break;
			case COREFLEXConstants.CULTURAL_TRAINING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.CULTURAL_TRAINING);
				break;
			case COREFLEXConstants.CONCIERGE_SERVICES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.CONCIERGE_SERVICES);
				break;
			case COREFLEXConstants.HOME_PURCHASE:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.HOME_PURCHASE);
				break;
			case COREFLEXConstants.FINAL_MOVE:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.FINAL_MOVE);
				break;
			case COREFLEXConstants.AREA_TOUR:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.AREA_TOUR);
				break;
			case COREFLEXConstants.HOME_LEAVE:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList, COREFLEXConstants.HOME_LEAVE);
				break;
			case COREFLEXConstants.AIRPORT_PICKUP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.AIRPORT_PICKUP);
				break;
			case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.PRE_ACCEPTANCE_SERVICES);
				break;
			case COREFLEXConstants.FURNITURE_RENTAL:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.FURNITURE_RENTAL);
				break;
			case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT);
				break;
			case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH);
				break;
			case COREFLEXConstants.HOUSE_HUNTING_TRIP:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.HOUSE_HUNTING_TRIP);
				break;
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.CUSTOM_BUNDLES);
				break;
			default:
				Assert.fail(PDTConstants.INVALID_ELEMENT + elementName);
			}
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_LEFTNAVIGATION_ELEMENT_OF_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
		}
	}

	/**
	 * Method to select specified Benefit Name (If Not Already Checked)
	 * 
	 * @param policyType
	 * @return
	 */
	public boolean selectBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		try {
			expandAllBenefitCategories();
			// Method to select Provided benefit from the List
			List<String> benefitList = getBenefitList(policyType, policyRequiredFor, numberOfMilestones);
			for (String benefit : benefitList) {
				CoreFunctions.selectItemInListByText(driver, _allBenefitsList, benefit, true);
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_PAGE,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return true;
	}

	/**
	 * Method to select specified Aires Managed Benefit Name (If Not Already
	 * Checked)
	 * 
	 * @param policyType
	 * @return
	 */
	public boolean selectAiresManagedBenefits(String policyType) {
		try {
			expandAllBenefitCategories();
			// Method to select Provided benefit from the List
			List<String> benefitList = getAiresManagedBenefitList(policyType);
			for (String benefit : benefitList) {
				CoreFunctions.selectItemInListByText(driver, _allBenefitsList, benefit, true);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AIRES_MANAGED_BENEFITS_ON_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return true;
	}

	/**
	 * Method to select specified Benefit Name (If Not Already Checked)
	 * 
	 * @param policyType
	 * @return
	 */
	public boolean selectBenefit(String benefitName) {
		try {
			CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
			expandAllBenefitCategories();
			CoreFunctions.selectItemInListByText(driver, _allBenefitsList, benefitName, true);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_PAGE,
							CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return true;
	}

	private void expandAllBenefitCategories() {
		for (WebElement element : _linkShowMoreList) {
			CoreFunctions.clickElement(driver, element);
		}
	}

	private List<String> getBenefitList(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<String> benefitNameList = new ArrayList<String>();
		switch (policyRequiredFor) {
		case COREFLEXConstants.CLONING:
		case COREFLEXConstants.VERSIONING:
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((ben.getPolicyCreationGroup().contains(COREFLEXConstants.CLONING))
							|| (ben.getPolicyCreationGroup().contains(COREFLEXConstants.VERSIONING)))
						benefitNameList.add(ben.getBenefitType());
				}
			}
			break;
		case COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS:
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((ben.getAiresManagedService().equals("Yes"))
							&& (ben.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
						benefitNameList.add(ben.getBenefitType());
					}
				}
			}
			System.out.println("Total Tracing Benefit Count : " + benefitNameList.size());
			break;
		case COREFLEXConstants.ALL_BENEFITS:
		case COREFLEXConstants.END_TO_END:
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if (ben.getPolicyCreationGroup().contains(COREFLEXConstants.ALL_BENEFITS)) {
						benefitNameList.add(ben.getBenefitType());
					}
				}
			}
			break;
		default:
			Assert.fail(COREFLEXConstants.BLUEPRINT_POLICY_REQUIRED_FOR_OPTION_NOT_PRESENT_IN_THE_LIST);
		}
		return benefitNameList;

	}

	private List<String> getAiresManagedBenefitList(String policyType) {

		List<String> benefitNameList = new ArrayList<String>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					benefitNameList.add(ben.getBenefitType());
				}
			}
		}
		return benefitNameList;
	}

	/**
	 * Method to verify benefits added in PolicyBenefits Categories Page are
	 * displayed on Left Navigation
	 * 
	 * @param dataTable
	 * @return
	 */
	public boolean verifyBenefitsDisplayedOnLeftNavigation(String policyType, String policyRequiredFor,
			String numberOfTracing) {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		boolean isBenefitsAddedVerifiedOnLeftNavigation = false;
		try {
			List<String> benefitList = getBenefitList(policyType, policyRequiredFor, numberOfTracing);
			List<String> leftNavigationBenefitsList = CoreFunctions.getElementTextAndStoreInList(driver,
					_leftNavigationTitleSelectedBenefitsList);
			isBenefitsAddedVerifiedOnLeftNavigation = benefitList.containsAll(leftNavigationBenefitsList);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_BENEFITS_ON_LEFT_NAVIGATION,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isBenefitsAddedVerifiedOnLeftNavigation) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFITS_ADDED_ON_LEFT_NAVIGATION, CoreConstants.PASS));
		}
		return isBenefitsAddedVerifiedOnLeftNavigation;
	}

	/**
	 * Method to select and fill Benefits & SubBenefits From Left Navigation
	 * 
	 * @param policyType
	 * @param coreFlexDuplicateHousingBenefitsPage
	 * @param coreFlexLumpSumBenefitsPage
	 * @param coreFlexLanguageTrainingBenefitsPage
	 */
	public boolean selectAndFillAddedBenefits(String policyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage,
			CoreFlex_TemporaryLiving_BenefitsPage coreFlexTemporaryLivingBenefitsPage,
			CoreFlex_CulturalTraining_BenefitsPage coreFlexCulturalTrainingBenefitsPage,
			CoreFlex_ConciergeServices_BenefitsPage coreFlexConciergeServicesBenefitsPage,
			CoreFlex_HomePurchase_BenefitsPage coreFlexHomePurchaseBenefitsPage,
			CoreFlex_FinalMove_BenefitsPage coreFlexFinalMoveBenefitsPage,
			CoreFlex_AreaTour_BenefitsPage coreFlexAreaTourBenefitsPage,
			CoreFlex_HomeLeave_BenefitsPage coreFlexHomeLeaveBenefitsPage,
			CoreFlex_AirportPickup_BenefitsPage coreFlexAirportPickupBenefitsPage,
			CoreFlex_PreAcceptanceServices_BenefitsPage coreFlexPreAcceptanceServicesBenefitsPage,
			CoreFlex_FurnitureRental_BenefitsPage coreFlexFurnitureRentalBenefitsPage,
			CoreFlex_AutoRentalDuringAssignment_BenefitsPage coreFlexAutoRentalDuringAssignmentBenefitsPage,
			CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage coreFlexEducationAssistanceBenefitsPage,
			CoreFlex_HouseHuntingTrip_BenefitsPage coreFlexHouseHuntingTripBenefitsPage, String policyRequiredFor,
			String numberOfMilestones) {
		boolean isBenefitSuccessfullySelectedAndFilled = false;
		try {
			if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
				switch (policyRequiredFor) {
				case COREFLEXConstants.CLONING:
				case COREFLEXConstants.VERSIONING:
					isBenefitSuccessfullySelectedAndFilled = fillFlexBenefitDetailsForCloning(policyType,
							policyRequiredFor, numberOfMilestones, coreFlexDuplicateHousingBenefitsPage,
							coreFlexLumpSumBenefitsPage, coreFlexOtherHousingBenefitsPage,
							coreFlexLanguageTrainingBenefitsPage);
					break;
				case COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS:
				case COREFLEXConstants.ALL_BENEFITS:
				case COREFLEXConstants.END_TO_END:
					isBenefitSuccessfullySelectedAndFilled = fillAllFlexBenefitDetails(policyType,
							coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage,
							coreFlexOtherHousingBenefitsPage, coreFlexLanguageTrainingBenefitsPage,
							coreFlexTemporaryLivingBenefitsPage, coreFlexCulturalTrainingBenefitsPage,
							coreFlexConciergeServicesBenefitsPage, coreFlexHomePurchaseBenefitsPage,
							coreFlexFinalMoveBenefitsPage, coreFlexAreaTourBenefitsPage, coreFlexHomeLeaveBenefitsPage,
							coreFlexAirportPickupBenefitsPage, coreFlexPreAcceptanceServicesBenefitsPage,
							coreFlexFurnitureRentalBenefitsPage, coreFlexAutoRentalDuringAssignmentBenefitsPage,
							coreFlexEducationAssistanceBenefitsPage, coreFlexHouseHuntingTripBenefitsPage,
							policyRequiredFor, numberOfMilestones);
					break;
				case COREFLEXConstants.SIGNIFICANT_CHANGE:
					isBenefitSuccessfullySelectedAndFilled = fillFlexBenefitDetailsForSignificantChange(policyType,
							policyRequiredFor, coreFlexLanguageTrainingBenefitsPage);
					break;

				default:
					Assert.fail(COREFLEXConstants.BLUEPRINT_POLICY_REQUIRED_FOR_OPTION_NOT_PRESENT_IN_THE_LIST);
				}

			} else if (policyType.equals(COREFLEXConstants.CORE)) {
				isBenefitSuccessfullySelectedAndFilled = fillAiresManagedCardCoreBenefitDetails(policyType,
						coreFlexLanguageTrainingBenefitsPage);
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_ADDED_BENEFITS,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitSuccessfullySelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_ADDED_BENEFITS,
					CoreConstants.PASS));
			clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		}
		return isBenefitSuccessfullySelectedAndFilled;
	}

	private boolean fillFlexBenefitDetailsForSignificantChange(String policyType, String policyRequiredFor,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isFlexBenefitSuccessfullySelectedAndFilled = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.isSelectBenefitOnPBCPage()) {
						clickLeftNavigationMenuOfPage(benefit.getBenefitType());
						switch (benefit.getBenefitType()) {
						case COREFLEXConstants.LANGUAGE_TRAINING:
							coreFlexLanguageTrainingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
									benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(),
									benefit.getPoints(), benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getAiresManagedService());
							break;
						default:
							Assert.fail(PDTConstants.INVALID_ELEMENT);
						}
						isFlexBenefitSuccessfullySelectedAndFilled = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_ADDED_FLEX_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitSuccessfullySelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_ADDED_ADDITIONAL_FLEX_BENEFITS,
					CoreConstants.PASS));
		}
		return isFlexBenefitSuccessfullySelectedAndFilled;
	}

	private boolean fillFlexBenefitDetailsForCloning(String policyType, String policyRequiredFor,
			String numberOfMilestones, CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isFlexBenefitSuccessfullySelectedAndFilled = false;
		try {
			for (Benefit benefit : getBenefits(policyType, policyRequiredFor, numberOfMilestones)) {
				clickLeftNavigationMenuOfPage(benefit.getBenefitType());
				switch (benefit.getBenefitType()) {
				case COREFLEXConstants.DUPLICATE_HOUSING:
					coreFlexDuplicateHousingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getPayments());
					break;
				case COREFLEXConstants.LUMP_SUM:
					coreFlexLumpSumBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getPayments());
					break;
				case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
					coreFlexOtherHousingBenefitsPage.verifyFieldTextUpdates();
					coreFlexOtherHousingBenefitsPage.selectAndFillBenefitsDetails(benefit.getBenefitDisplayName(),
							benefit.getPoints(), benefit.getMultipleBenefitSelection(), benefit.getBenefitAmount(),
							benefit.getBenefitDesc(), benefit.getComment(), benefit.getGrossUp(),
							benefit.getReimbursedBy(), benefit.getPayments());
					break;
				case COREFLEXConstants.LANGUAGE_TRAINING:
					coreFlexLanguageTrainingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					break;
				default:
					Assert.fail(PDTConstants.INVALID_ELEMENT);
				}
				isFlexBenefitSuccessfullySelectedAndFilled = true;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_ADDED_FLEX_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitSuccessfullySelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_ADDED_FLEX_BENEFITS, CoreConstants.PASS));
		}
		return isFlexBenefitSuccessfullySelectedAndFilled;
	}

	private boolean fillAllFlexBenefitDetails(String policyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage,
			CoreFlex_TemporaryLiving_BenefitsPage coreFlexTemporaryLivingBenefitsPage,
			CoreFlex_CulturalTraining_BenefitsPage coreFlexCulturalTrainingBenefitsPage,
			CoreFlex_ConciergeServices_BenefitsPage coreFlexConciergeServicesBenefitsPage,
			CoreFlex_HomePurchase_BenefitsPage coreFlexHomePurchaseBenefitsPage,
			CoreFlex_FinalMove_BenefitsPage coreFlexFinalMoveBenefitsPage,
			CoreFlex_AreaTour_BenefitsPage coreFlexAreaTourBenefitsPage,
			CoreFlex_HomeLeave_BenefitsPage coreFlexHomeLeaveBenefitsPage,
			CoreFlex_AirportPickup_BenefitsPage coreFlexAirportPickupBenefitsPage,
			CoreFlex_PreAcceptanceServices_BenefitsPage coreFlexPreAcceptanceServicesBenefitsPage,
			CoreFlex_FurnitureRental_BenefitsPage coreFlexFurnitureRentalBenefitsPage,
			CoreFlex_AutoRentalDuringAssignment_BenefitsPage coreFlexAutoRentalDuringAssignmentBenefitsPage,
			CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage coreFlexEducationAssistanceBenefitsPage,
			CoreFlex_HouseHuntingTrip_BenefitsPage coreFlexHouseHuntingTripBenefitsPage, String policyRequiredFor,
			String numberOfMilestones) {
		boolean isFlexBenefitSuccessfullySelectedAndFilled = false;
		try {
			for (Benefit benefit : getBenefits(policyType, policyRequiredFor, numberOfMilestones)) {
				clickLeftNavigationMenuOfPage(benefit.getBenefitType());
				switch (benefit.getBenefitType()) {
				case COREFLEXConstants.DUPLICATE_HOUSING:
					coreFlexDuplicateHousingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getPayments());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.LUMP_SUM:
					coreFlexLumpSumBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getPayments());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
//						coreFlexOtherHousingBenefitsPage.verifyNumericRangeFieldsValidation();
					coreFlexOtherHousingBenefitsPage.verifyFieldTextUpdates();
					coreFlexOtherHousingBenefitsPage.selectAndFillBenefitsDetails(benefit.getBenefitDisplayName(),
							benefit.getPoints(), benefit.getMultipleBenefitSelection(), benefit.getBenefitAmount(),
							benefit.getBenefitDesc(), benefit.getComment(), benefit.getGrossUp(),
							benefit.getReimbursedBy(), benefit.getPayments());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.LANGUAGE_TRAINING:
					coreFlexLanguageTrainingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.CULTURAL_TRAINING:
					coreFlexCulturalTrainingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.TEMPORARY_LIVING:
					coreFlexTemporaryLivingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.CONCIERGE_SERVICES:
					coreFlexConciergeServicesBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.HOME_PURCHASE:
					coreFlexHomePurchaseBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.FINAL_MOVE:
					coreFlexFinalMoveBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.AREA_TOUR:
					coreFlexAreaTourBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.HOME_LEAVE:
					coreFlexHomeLeaveBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.AIRPORT_PICKUP:
					coreFlexAirportPickupBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
					coreFlexPreAcceptanceServicesBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.FURNITURE_RENTAL:
					coreFlexFurnitureRentalBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
					coreFlexAutoRentalDuringAssignmentBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
					coreFlexEducationAssistanceBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				case COREFLEXConstants.HOUSE_HUNTING_TRIP:
					coreFlexHouseHuntingTripBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(policyType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					BusinessFunctions.verifyFieldNotPresentOnBenefitPage(driver, _textIfApplicable, benefit.getBenefitType(),
							COREFLEXConstants.IF_APPLICABLE);
					break;
				default:
					Assert.fail(PDTConstants.INVALID_ELEMENT);
				}
				isFlexBenefitSuccessfullySelectedAndFilled = true;
			}

		} catch (

		Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_ADDED_FLEX_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitSuccessfullySelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_ADDED_FLEX_BENEFITS, CoreConstants.PASS));
		}
		return isFlexBenefitSuccessfullySelectedAndFilled;
	}

	public boolean verifyPolicyCategoriesBenefitsAndOrder() {
		boolean isPolicyCategoriesBenefitsAndOrderVerified = false;
		try {
			verifyDefaultToggleSelection();
			expandAllBenefitCategories();
			isPolicyCategoriesBenefitsAndOrderVerified = verifySelectableBenefitsAndDisplayOrder();
			CoreFunctions.clickElement(driver, _toggleButtonDeselectAll);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTALL_DESELECTALL_BENEFITS_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPolicyCategoriesBenefitsAndOrderVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTALL_DESELECTALL_BENEFITS_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
					CoreConstants.PASS));
		}
		return isPolicyCategoriesBenefitsAndOrderVerified;
	}

	private boolean verifySelectableBenefitsAndDisplayOrder() {
		try {
			CoreFunctions.clickElement(driver, _toggleButtonSelectAll);
			List<String> actualBenefitCategoryList = CoreFunctions.getElementTextAndStoreInList(driver,
					_allBenefitsHeading);
			if ((actualBenefitCategoryList.equals(policySetupPageData.policyBenefitsCategories.benefitsCategories))
					&& verifySelectableBenefitsDisplayOrder(actualBenefitCategoryList)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFITS_CATEGORIES_AND_SELECTABLE_BENEFITS_NAMES_AND_DISPLAY_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_BENEFITS_CATEGORIES_AND_SELECTABLE_BENEFITS_NAMES_AND_DISPLAY_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;

	}

	private boolean verifySelectableBenefitsDisplayOrder(List<String> actualBenefitCategoryList) {
		boolean isBenefitsNamesAndOrderVerified = false;
		for (String benefitCategory : actualBenefitCategoryList) {
			isBenefitsNamesAndOrderVerified = false;
			switch (benefitCategory) {
			case COREFLEXConstants.HOUSING:
				isBenefitsNamesAndOrderVerified = CoreFunctions
						.getElementTextAndStoreInList(driver, _housingTabSelectableBenefitList)
						.equals(policySetupPageData.policyBenefitsCategories.housingSelectableBenefits);
				break;
			case COREFLEXConstants.MOVING:
				isBenefitsNamesAndOrderVerified = CoreFunctions
						.getElementTextAndStoreInList(driver, _movingTabSelectableBenefitList)
						.equals(policySetupPageData.policyBenefitsCategories.movingSelectableBenefits);
				break;
			case COREFLEXConstants.SETTLING_IN:
				isBenefitsNamesAndOrderVerified = CoreFunctions
						.getElementTextAndStoreInList(driver, _settlingInTabSelectableBenefitList)
						.equals(policySetupPageData.policyBenefitsCategories.settlingInSelectableBenefits);
				break;
			case COREFLEXConstants.LIFESTYLE:
				isBenefitsNamesAndOrderVerified = CoreFunctions
						.getElementTextAndStoreInList(driver, _lifestyleTabSelectableBenefitList)
						.equals(policySetupPageData.policyBenefitsCategories.lifeStyleSelectableBenefits);
				break;
			case COREFLEXConstants.ALLOWANCES:
				isBenefitsNamesAndOrderVerified = CoreFunctions
						.getElementTextAndStoreInList(driver, _allowanceTabSelectableBenefitList)
						.equals(policySetupPageData.policyBenefitsCategories.allowancesSelectableBenefits);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);
			}
			if (isBenefitsNamesAndOrderVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_SELECTABLE_BENEFITS_NAMES_AND_DISPLAY_ORDER_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.PASS, benefitCategory));
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SELECTABLE_BENEFITS_NAMES_AND_DISPLAY_ORDER_NOT_MATCHED_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.FAIL, benefitCategory));
				break;
			}
		}
		return isBenefitsNamesAndOrderVerified;
	}

	private void verifyDefaultToggleSelection() {
		if (CoreFunctions.isElementExist(driver, _toggleButtonSelectAll, 3)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DESELECTALL_AS_DEFAULT_TOGGLE_SELECTION_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
					CoreConstants.PASS));
		} else if (CoreFunctions.isElementExist(driver, _toggleButtonDeselectAll, 3)) {
			Assert.fail(COREFLEXConstants.INCORRECT_DEFAULT_POLICY_CATEGORIES_TOGGLE_SELECTION);
		}
	}

	private boolean fillAiresManagedCardCoreBenefitDetails(String benefitType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isBenefitSuccessfullySelectedAndFilled = false;
		try {
			for (Benefit benefit : coreBenefits) {
				clickLeftNavigationMenuOfPage(benefit.getBenefitType());
				switch (benefit.getBenefitType()) {
				case COREFLEXConstants.LANGUAGE_TRAINING:
					coreFlexLanguageTrainingBenefitsPage.selectAndFillBenefitsAndSubBenefitDetails(benefitType,
							benefit.getSubBenefits(), benefit.getMultipleBenefitSelection(), benefit.getPoints(),
							benefit.getBenefitDisplayName(), benefit.getBenefitAmount(), benefit.getBenefitDesc(),
							benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.HOME_PURCHASE:
					break;
				default:
					Assert.fail(PDTConstants.INVALID_ELEMENT);
				}
				isBenefitSuccessfullySelectedAndFilled = true;

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_AIRES_MANAGED_BENEFITS,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitSuccessfullySelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_AIRES_MANAGED_BENEFITS, CoreConstants.PASS));
		}
		return isBenefitSuccessfullySelectedAndFilled;
	}

	public boolean verifySelectedBenefitsPostVersioningCloning(String policyType, String policyRequiredFor,
			String numberOfTracing) {
		try {
			expandAllBenefitCategories();
			List<String> expectedBenefitList = getBenefitList(policyType, policyRequiredFor, numberOfTracing);
			Collections.sort(expectedBenefitList);
			List<String> actualBenefitList = getSelectedBenefitList();
			Collections.sort(actualBenefitList);

			if (expectedBenefitList.equals(actualBenefitList)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VALIDATED_SELECTED_BENEFITS_OF_NEW_VERSION_POLICY_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SELECTED_BENEFITS_OF_NEW_VERSION_POLICY_ON_POLICY_BENEFITS_CATEGORIES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private List<String> getSelectedBenefitList() {
		List<String> actualSelectedBenefitList = new ArrayList<String>();
		try {
			for (int i = 0; i < _allBenefitsButtonElementList.size(); i++) {
				if (_allBenefitsButtonElementList.get(i).getDomProperty("checked").equalsIgnoreCase("true")) {
					actualSelectedBenefitList.add(_allBenefitsLabelElementList.get(i).getText());
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_SELECTED_BENEFITS_LIST,
							CoreConstants.FAIL, e.getMessage()));
		}
		return actualSelectedBenefitList;
	}

	public boolean verifyAddedBenefitDetailsPostVersioningCloning(String policyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage,
			CoreFlex_TemporaryLiving_BenefitsPage coreFlexTemporaryLivingBenefitsPage,
			CoreFlex_CulturalTraining_BenefitsPage coreFlexCulturalTrainingBenefitsPage,
			CoreFlex_ConciergeServices_BenefitsPage coreFlexConciergeServicesBenefitsPage,
			CoreFlex_HomePurchase_BenefitsPage coreFlexHomePurchaseBenefitsPage,
			CoreFlex_FinalMove_BenefitsPage coreFlexFinalMoveBenefitsPage,
			CoreFlex_AreaTour_BenefitsPage coreFlexAreaTourBenefitsPage,
			CoreFlex_HomeLeave_BenefitsPage coreFlexHomeLeaveBenefitsPage,
			CoreFlex_AirportPickup_BenefitsPage coreFlexAirportPickupBenefitsPage,
			CoreFlex_PreAcceptanceServices_BenefitsPage coreFlexPreAcceptanceServicesBenefitsPage,
			CoreFlex_FurnitureRental_BenefitsPage coreFlexFurnitureRentalBenefitsPage,
			CoreFlex_AutoRentalDuringAssignment_BenefitsPage coreFlexAutoRentalDuringAssignmentBenefitsPage,
			CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage coreFlexEducationAssistanceBenefitsPage,
			CoreFlex_HouseHuntingTrip_BenefitsPage coreFlexHouseHuntingTripBenefitsPage, String policyRequiredFor,
			String numberOfMilestones) {
		boolean isAddedBenefitSuccessfullyVerified = false;
		try {
			if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
				switch (policyRequiredFor) {
				case COREFLEXConstants.CLONING:
				case COREFLEXConstants.VERSIONING:
					isAddedBenefitSuccessfullyVerified = verifyAddedFlexBenefitSubBenefitDetailsForCloning(policyType,
							policyRequiredFor, coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage,
							coreFlexOtherHousingBenefitsPage, coreFlexLanguageTrainingBenefitsPage);
					break;
				case COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS:
					break;
				case COREFLEXConstants.ALL_BENEFITS:
				case COREFLEXConstants.END_TO_END:
					isAddedBenefitSuccessfullyVerified = verifyAddedFlexBenefitSubBenefitDetails(policyType,
							coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage,
							coreFlexOtherHousingBenefitsPage, coreFlexLanguageTrainingBenefitsPage,
							coreFlexTemporaryLivingBenefitsPage, coreFlexCulturalTrainingBenefitsPage,
							coreFlexConciergeServicesBenefitsPage, coreFlexHomePurchaseBenefitsPage,
							coreFlexFinalMoveBenefitsPage, coreFlexAreaTourBenefitsPage, coreFlexHomeLeaveBenefitsPage,
							coreFlexAirportPickupBenefitsPage, coreFlexPreAcceptanceServicesBenefitsPage,
							coreFlexFurnitureRentalBenefitsPage, coreFlexAutoRentalDuringAssignmentBenefitsPage,
							coreFlexEducationAssistanceBenefitsPage, coreFlexHouseHuntingTripBenefitsPage,
							policyRequiredFor, numberOfMilestones);
					break;
				default:
					Assert.fail(COREFLEXConstants.BLUEPRINT_POLICY_REQUIRED_FOR_OPTION_NOT_PRESENT_IN_THE_LIST);
				}
			} else if (policyType.equals(COREFLEXConstants.CORE)) {
				isAddedBenefitSuccessfullyVerified = verifyAddedCoreBenefitSubBenefitDetails(policyType,
						coreFlexLanguageTrainingBenefitsPage);
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_BENEFITS_POST_VERSIONING_CLONING,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isAddedBenefitSuccessfullyVerified) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_ADDED_BENEFITS,
					CoreConstants.PASS));
			clickLeftNavigationMenuOfPage(COREFLEXConstants.BENEFIT_SUMMARY);
		}
		return isAddedBenefitSuccessfullyVerified;
	}

	private boolean verifyAddedFlexBenefitSubBenefitDetailsForCloning(String policyType, String policyRequiredFor,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isBenefitDetailsSuccessfullyVerified = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getPolicyCreationGroup().contains(policyRequiredFor)) {
						clickLeftNavigationMenuOfPage(benefit.getBenefitType());
						isBenefitDetailsSuccessfullyVerified = false;
						switch (benefit.getBenefitType()) {
						case COREFLEXConstants.DUPLICATE_HOUSING:
							isBenefitDetailsSuccessfullyVerified = coreFlexDuplicateHousingBenefitsPage
									.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
											benefit.getMultipleBenefitSelection(), benefit.getPoints(),
											benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
											benefit.getBenefitDesc(), benefit.getPayments(),
											benefit.getAiresManagedService());
							break;
						case COREFLEXConstants.LUMP_SUM:
							isBenefitDetailsSuccessfullyVerified = coreFlexLumpSumBenefitsPage
									.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
											benefit.getMultipleBenefitSelection(), benefit.getPoints(),
											benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
											benefit.getBenefitDesc(), benefit.getPayments(),
											benefit.getAiresManagedService());
							break;
						case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
							coreFlexOtherHousingBenefitsPage.verifyFieldTextUpdates();
							isBenefitDetailsSuccessfullyVerified = coreFlexOtherHousingBenefitsPage
									.verifyAddedOtherBenefitsDetails(benefit.getBenefitDisplayName(),
											benefit.getPoints(), benefit.getMultipleBenefitSelection(),
											benefit.getBenefitAmount(), benefit.getBenefitDesc(), benefit.getComment(),
											benefit.getGrossUp(), benefit.getReimbursedBy(), benefit.getPayments(),
											benefit.getAiresManagedService());
							break;
						case COREFLEXConstants.LANGUAGE_TRAINING:
							isBenefitDetailsSuccessfullyVerified = coreFlexLanguageTrainingBenefitsPage
									.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
											benefit.getMultipleBenefitSelection(), benefit.getPoints(),
											benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
											benefit.getBenefitDesc(), benefit.getPayments(),
											benefit.getAiresManagedService());
							break;
						default:
							Assert.fail(PDTConstants.INVALID_ELEMENT);
						}

						if (!isBenefitDetailsSuccessfullyVerified) {
							Reporter.addStepLog(MessageFormat.format(
									COREFLEXConstants.ADDED_BENEFIT_DETAILS_NOT_MATCHED_POST_VERSIONING_CLONING,
									CoreConstants.FAIL, benefit.getBenefitType()));
							return false;
						} else {
							Reporter.addStepLog(MessageFormat.format(
									COREFLEXConstants.SUCCESSFULLY_VALIDATED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
									CoreConstants.PASS, benefit.getBenefitType()));
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitDetailsSuccessfullyVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_ADDED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
					CoreConstants.PASS));
		}
		return isBenefitDetailsSuccessfullyVerified;
	}

	private boolean verifyAddedCoreBenefitSubBenefitDetails(String policyType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		// To be Handled Later. Adding only CoreBenefit is Out Of Scope
		return false;
	}

	private boolean verifyAddedFlexBenefitSubBenefitDetails(String policyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage,
			CoreFlex_TemporaryLiving_BenefitsPage coreFlexTemporaryLivingBenefitsPage,
			CoreFlex_CulturalTraining_BenefitsPage coreFlexCulturalTrainingBenefitsPage,
			CoreFlex_ConciergeServices_BenefitsPage coreFlexConciergeServicesBenefitsPage,
			CoreFlex_HomePurchase_BenefitsPage coreFlexHomePurchaseBenefitsPage,
			CoreFlex_FinalMove_BenefitsPage coreFlexFinalMoveBenefitsPage,
			CoreFlex_AreaTour_BenefitsPage coreFlexAreaTourBenefitsPage,
			CoreFlex_HomeLeave_BenefitsPage coreFlexHomeLeaveBenefitsPage,
			CoreFlex_AirportPickup_BenefitsPage coreFlexAirportPickupBenefitsPage,
			CoreFlex_PreAcceptanceServices_BenefitsPage coreFlexPreAcceptanceServicesBenefitsPage,
			CoreFlex_FurnitureRental_BenefitsPage coreFlexFurnitureRentalBenefitsPage,
			CoreFlex_AutoRentalDuringAssignment_BenefitsPage coreFlexAutoRentalDuringAssignmentBenefitsPage,
			CoreFlex_EducationAssistanceSchoolSearch_BenefitsPage coreFlexEducationAssistanceBenefitsPage,
			CoreFlex_HouseHuntingTrip_BenefitsPage coreFlexHouseHuntingTripBenefitsPage, String policyRequiredFor,
			String numberOfMilestones) {
		boolean isBenefitDetailsSuccessfullyVerified = false;
		try {
			for (Benefit benefit : getBenefits(policyType, policyRequiredFor, numberOfMilestones)) {
				clickLeftNavigationMenuOfPage(benefit.getBenefitType());
				isBenefitDetailsSuccessfullyVerified = false;
				switch (benefit.getBenefitType()) {
				case COREFLEXConstants.DUPLICATE_HOUSING:
					isBenefitDetailsSuccessfullyVerified = coreFlexDuplicateHousingBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.LUMP_SUM:
					isBenefitDetailsSuccessfullyVerified = coreFlexLumpSumBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
					coreFlexOtherHousingBenefitsPage.verifyFieldTextUpdates();
					isBenefitDetailsSuccessfullyVerified = coreFlexOtherHousingBenefitsPage
							.verifyAddedOtherBenefitsDetails(benefit.getBenefitDisplayName(), benefit.getPoints(),
									benefit.getMultipleBenefitSelection(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getComment(), benefit.getGrossUp(),
									benefit.getReimbursedBy(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.LANGUAGE_TRAINING:
					isBenefitDetailsSuccessfullyVerified = coreFlexLanguageTrainingBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.CULTURAL_TRAINING:
					isBenefitDetailsSuccessfullyVerified = coreFlexCulturalTrainingBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.TEMPORARY_LIVING:
					isBenefitDetailsSuccessfullyVerified = coreFlexTemporaryLivingBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.CONCIERGE_SERVICES:
					isBenefitDetailsSuccessfullyVerified = coreFlexConciergeServicesBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.HOME_PURCHASE:
					isBenefitDetailsSuccessfullyVerified = coreFlexHomePurchaseBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.FINAL_MOVE:
					isBenefitDetailsSuccessfullyVerified = coreFlexFinalMoveBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.AREA_TOUR:
					isBenefitDetailsSuccessfullyVerified = coreFlexAreaTourBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.HOME_LEAVE:
					isBenefitDetailsSuccessfullyVerified = coreFlexHomeLeaveBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.AIRPORT_PICKUP:
					isBenefitDetailsSuccessfullyVerified = coreFlexAirportPickupBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.PRE_ACCEPTANCE_SERVICES:
					isBenefitDetailsSuccessfullyVerified = coreFlexPreAcceptanceServicesBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.FURNITURE_RENTAL:
					isBenefitDetailsSuccessfullyVerified = coreFlexFurnitureRentalBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.AUTO_RENTAL_DURING_ASSIGNMENT:
					isBenefitDetailsSuccessfullyVerified = coreFlexAutoRentalDuringAssignmentBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.EDUCATION_ASSISTANCE_SCHOOL_SEARCH:
					isBenefitDetailsSuccessfullyVerified = coreFlexEducationAssistanceBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				case COREFLEXConstants.HOUSE_HUNTING_TRIP:
					isBenefitDetailsSuccessfullyVerified = coreFlexHouseHuntingTripBenefitsPage
							.verifyAddedBenefitsAndSubBenefitDetails(policyType, benefit.getSubBenefits(),
									benefit.getMultipleBenefitSelection(), benefit.getPoints(),
									benefit.getBenefitDisplayName(), benefit.getBenefitAmount(),
									benefit.getBenefitDesc(), benefit.getPayments(), benefit.getAiresManagedService());
					break;
				default:
					Assert.fail(PDTConstants.INVALID_ELEMENT);
				}

				if (!isBenefitDetailsSuccessfullyVerified) {
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.ADDED_BENEFIT_DETAILS_NOT_MATCHED_POST_VERSIONING_CLONING,
							CoreConstants.FAIL, benefit.getBenefitType()));
					return false;
				} else {
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.SUCCESSFULLY_VALIDATED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
							CoreConstants.PASS, benefit.getBenefitType()));
				}

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isBenefitDetailsSuccessfullyVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_ADDED_BENEFIT_DETAILS_POST_VERSIONING_CLONING,
					CoreConstants.PASS));
		}
		return isBenefitDetailsSuccessfullyVerified;
	}

	public boolean deselectSelectedBenefit() {
		boolean isbenefitDeselected = false;
		try {
			expandAllBenefitCategories();
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.isDeselectBenefitOnPBCPage()) {
						CoreFunctions.selectItemInListByText(driver, _allBenefitsList, benefit.getBenefitType(), true);
						Reporter.addStepLog(MessageFormat.format(
								COREFLEXConstants.SUCCESSFULLY_DESELECTED_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
								CoreConstants.PASS, benefit.getBenefitType()));
						isbenefitDeselected = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DESELECTING_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isbenefitDeselected;
	}

	public boolean selectAdditionalBenefit() {
		boolean isbenefitSelected = false;
		try {
			expandAllBenefitCategories();
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.isSelectBenefitOnPBCPage()) {
						CoreFunctions.selectItemInListByText(driver, _allBenefitsList, benefit.getBenefitType(), true);
						Reporter.addStepLog(MessageFormat.format(
								COREFLEXConstants.SUCCESSFULLY_SELECTED_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
								CoreConstants.PASS, benefit.getBenefitType()));
						isbenefitSelected = true;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFIT_ON_POLICY_BENEFIT_CATEGORIES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isbenefitSelected;
	}

	/**
	 * Method to verify benefits added in PolicyBenefits Categories Page are
	 * displayed on Left Navigation
	 * 
	 * @param dataTable
	 * @return
	 */
	public boolean verifySelectedBenefitDisplayedOnLeftNavigation() {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		boolean isBenefitAddedVerifiedOnLeftNavigation = false;
		try {
			List<String> benefitList = getAdditionalAddedBenefitList();
			List<String> leftNavigationBenefitsList = CoreFunctions.getElementTextAndStoreInList(driver,
					_leftNavigationTitleSelectedBenefitsList);
			isBenefitAddedVerifiedOnLeftNavigation = leftNavigationBenefitsList.containsAll(benefitList);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_ADDED_BENEFITS_ON_LEFT_NAVIGATION,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isBenefitAddedVerifiedOnLeftNavigation) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFITS_ADDED_ON_LEFT_NAVIGATION, CoreConstants.PASS));
		}
		return isBenefitAddedVerifiedOnLeftNavigation;
	}

	private List<String> getAdditionalAddedBenefitList() {
		List<String> additionalBenefitList = new ArrayList<String>();
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (benefit.isSelectBenefitOnPBCPage()) {
					additionalBenefitList.add(benefit.getBenefitType());
				}
			}
		}
		return additionalBenefitList;
	}

	public boolean iterateAndChangePolicyBenefitType(String previousPolicyType, String changedPolicyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage) {
		boolean isBenefitTypeSuccessfullyChanged = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getPolicyCreationGroup().contains(COREFLEXConstants.VERSIONING)) {
						clickLeftNavigationMenuOfPage(benefit.getBenefitType());
						isBenefitTypeSuccessfullyChanged = false;
						switch (benefit.getBenefitType()) {
						case COREFLEXConstants.DUPLICATE_HOUSING:
							isBenefitTypeSuccessfullyChanged = coreFlexDuplicateHousingBenefitsPage
									.changePolicyBenefitType(benefit.getBenefitType(), changedPolicyType);
							break;
						case COREFLEXConstants.LUMP_SUM:
							isBenefitTypeSuccessfullyChanged = coreFlexLumpSumBenefitsPage
									.changePolicyBenefitType(benefit.getBenefitType(), changedPolicyType);
							break;
						case COREFLEXConstants.OTHER_HOUSING_BENEFIT:
							isBenefitTypeSuccessfullyChanged = coreFlexOtherHousingBenefitsPage.changeBenefitDetails();
							break;
						default:
							Assert.fail(COREFLEXConstants.INVALID_OPTION);
						}
						if (!isBenefitTypeSuccessfullyChanged)
							return false;
					}
				}

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CHANGING_POLICY_BENEFIT_TYPE_OF_ADDED_BENEFITS,
					CoreConstants.FAIL, e.getMessage(), previousPolicyType, changedPolicyType));
		}

		if (isBenefitTypeSuccessfullyChanged) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_CHANGED_POLICY_BENEFIT_TYPE_OF_ADDED_BENEFITS,
							CoreConstants.PASS, previousPolicyType, changedPolicyType));
		}
		return isBenefitTypeSuccessfullyChanged;
	}

	private List<Benefit> getBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
							&& (ben.getAiresManagedService().equals("Yes"))
							&& (ben.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
						benefitNameList.add(ben);
					} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
							|| ((policyRequiredFor.equals(COREFLEXConstants.VERSIONING))))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList;
	}

	public boolean deselectSelectedSubBenefit(String benefitType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isSubBenefitDeselected = false;
		try {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if (ben.isSelectBenefitOnPBCPage()) {
						isSubBenefitDeselected = deselectSubBenefit(ben, benefitType,
								coreFlexLanguageTrainingBenefitsPage);
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_DESELECTING_SUBBENEFIT_FROM_SELECTED_BENEFIT,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubBenefitDeselected) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_DESELECTED_SUBBENEFIT_FROM_SELECTED_BENEFIT, CoreConstants.PASS));
		}
		return isSubBenefitDeselected;
	}

	private boolean deselectSubBenefit(Benefit benefit, String benefitType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isSubBenefitDeselected = false;
		clickLeftNavigationMenuOfPage(benefit.getBenefitType());
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		switch (benefit.getBenefitType()) {
		case COREFLEXConstants.LANGUAGE_TRAINING:
			isSubBenefitDeselected = coreFlexLanguageTrainingBenefitsPage.deselectSelectedSubbenefit(benefitType,
					benefit);
			break;
		default:
			Assert.fail(PDTConstants.INVALID_ELEMENT);
		}
		return isSubBenefitDeselected;
	}

	public boolean selectAndFillUnSelectedSubBenefit(String benefitType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isSubBenefitSelectedAndFilled = false;
		try {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if (ben.isSelectBenefitOnPBCPage()) {
						isSubBenefitSelectedAndFilled = selectAndFillSubBenefit(ben, benefitType,
								coreFlexLanguageTrainingBenefitsPage);
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_AND_FILLING_SUBBENEFIT,
							CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubBenefitSelectedAndFilled) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_SELECTED_AND_FILLED_SUBBENEFIT_FORM,
					CoreConstants.PASS));
		}
		return isSubBenefitSelectedAndFilled;
	}

	private boolean selectAndFillSubBenefit(Benefit benefit, String benefitType,
			CoreFlex_LanguageTraining_BenefitsPage coreFlexLanguageTrainingBenefitsPage) {
		boolean isSubBenefitDeselected = false;
		clickLeftNavigationMenuOfPage(benefit.getBenefitType());
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		switch (benefit.getBenefitType()) {
		case COREFLEXConstants.LANGUAGE_TRAINING:
			isSubBenefitDeselected = coreFlexLanguageTrainingBenefitsPage.selectAndFillUnSelectedSubbenefit(benefitType,
					benefit);
			break;
		default:
			Assert.fail(PDTConstants.INVALID_ELEMENT);
		}
		return isSubBenefitDeselected;
	}

}
