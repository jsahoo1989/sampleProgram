package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
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
			case COREFLEXConstants.LANGUAGE_TRAINING:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.LANGUAGE_TRAINING);
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
		}
	}

	/**
	 * Method to select specified Benefit Name (If Not Already Checked)
	 * 
	 * @param policyType
	 * @return
	 */
	public boolean selectBenefits(String policyType) {
		try {
			expandAllBenefitCategories();
			// Method to select Provided benefit from the List
			List<String> benefitList = getBenefitList(policyType);
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

	private void expandAllBenefitCategories() {
		for (WebElement element : _linkShowMoreList) {
			CoreFunctions.clickElement(driver, element);
		}
	}

	private List<String> getBenefitList(String policyType) {

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
	public boolean verifyBenefitsDisplayedOnLeftNavigation(String policyType) {
		boolean isBenefitsAddedVerifiedOnLeftNavigation = false;
		try {
			List<String> benefitList = getBenefitList(policyType);
			List<String> leftNavigationBenefitsList = CoreFunctions.getElementTextAndStoreInList(driver,
					_leftNavigationTitleSelectedBenefitsList);
			isBenefitsAddedVerifiedOnLeftNavigation = benefitList.containsAll(leftNavigationBenefitsList);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_PAGE,
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
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage) {
		boolean isBenefitSuccessfullySelectedAndFilled = false;
		try {
			if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
				isBenefitSuccessfullySelectedAndFilled = fillFlexBenefitDetails(policyType,
						coreFlexDuplicateHousingBenefitsPage, coreFlexLumpSumBenefitsPage,
						coreFlexOtherHousingBenefitsPage);
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

	private boolean fillFlexBenefitDetails(String policyType,
			CoreFlex_DuplicateHousing_BenefitsPage coreFlexDuplicateHousingBenefitsPage,
			CoreFlex_LumpSum_BenefitsPage coreFlexLumpSumBenefitsPage,
			CoreFlex_OtherHousing_BenefitsPage coreFlexOtherHousingBenefitsPage) {
		boolean isFlexBenefitSuccessfullySelectedAndFilled = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
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
//						coreFlexOtherHousingBenefitsPage.verifyNumericRangeFieldsValidation();
						coreFlexOtherHousingBenefitsPage.selectAndFillBenefitsDetails(benefit.getBenefitDisplayName(),
								benefit.getPoints(), benefit.getMultipleBenefitSelection(), benefit.getBenefitAmount(),
								benefit.getBenefitDesc(), benefit.getComment(), benefit.getGrossUp(),
								benefit.getReimbursedBy(), benefit.getPayments());
						break;
					default:
						Assert.fail(PDTConstants.INVALID_ELEMENT);
					}
					isFlexBenefitSuccessfullySelectedAndFilled = true;
				}
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
}
