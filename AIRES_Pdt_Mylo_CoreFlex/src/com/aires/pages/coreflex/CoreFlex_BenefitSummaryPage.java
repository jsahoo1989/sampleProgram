package com.aires.pages.coreflex;

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
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_AllowancesBenefitsData;
import com.aires.testdatatypes.coreflex.CoreFlex_HousingBenefitsData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_BenefitSummaryPage extends Base {

	public CoreFlex_BenefitSummaryPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Continue')]")
	private WebElement _buttonContinue;

	// Save & Continue Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'SAVE & CONTINUE')]")
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

	// Left Navigation Active Tile
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']/li[contains(@class,'nav-item active')]//p")
	private WebElement _leftNavigationTitleActive;

	// Left Navigation Completed Sections
	@FindBy(how = How.XPATH, using = "//ul[@class='nav']//li[contains(@class,'nav-item')]//p")
	private List<WebElement> _leftNavigationTitleList;

	// Added Benefit Group List
	@FindBy(how = How.CSS, using = "label[class*='benefit-group']")
	private List<WebElement> _textAddedBenefitGroupList;

	// Added Benefit Name List
	@FindBy(how = How.CSS, using = "a[class*='headingBenefit']")
	private List<WebElement> _textAddedBenefitNameList;

	// Benefit Expand Icon
	@FindBy(how = How.CSS, using = "a[class*='collapsed']")
	private List<WebElement> _iconBenefitExpandList;

	// Collapsed SubBenefit List
	@FindBy(how = How.XPATH, using = "//div[@class='collapse show']//label[@class='d-flex collapsed']")
	private List<WebElement> _subBenefitList;

	// Benefits Points List
	@FindBy(how = How.CSS, using = "p[class*='pointText']")
	private List<WebElement> _benefitsPointsList;

	// Policy Status
	@FindBy(how = How.XPATH, using = "//strong[contains(text(),'Policy Status')]/parent::label/following-sibling::label")
	private WebElement _textPolicyStatus;

	/*********************************************************************/

	CoreFlex_HousingBenefitsData housingBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getHousingBenefitDataList(COREFLEXConstants.DUPLICATE_HOUSING);

	CoreFlex_AllowancesBenefitsData lumpSumBenefitData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getLifeStyleBenefitDataList(COREFLEXConstants.LUMP_SUM);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	/*********************************************************************/

	/**
	 * Method to verify navigated Page Header Title
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return CoreFunctions.verifyElementOnPage(driver, _headerPage, COREFLEXConstants.BENEFIT_SUMMARY,
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
			case COREFLEXConstants.LOGOUT:
				CoreFunctions.clickElement(driver, _buttonLogout);
				break;
			case COREFLEXConstants.SAVE_AND_CONTINUE:
				CoreFunctions.clickElement(driver, _buttonSaveAndContinue);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.CONTINUE:
				CoreFunctions.clickElement(driver, _buttonContinue);
				break;
			case COREFLEXConstants.BACK:
				CoreFunctions.clickElement(driver, _buttonBack);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.EXIT:
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
			case COREFLEXConstants.BENEFIT_SUMMARY:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.BENEFIT_SUMMARY);
				break;
			case COREFLEXConstants.CUSTOM_BUNDLES:
				CoreFunctions.selectItemInListByText(driver, _leftNavigationTitleList,
						COREFLEXConstants.CUSTOM_BUNDLES);
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
	 * Method to iterate and verify Added Benefits & SubBenefits on Benefit Summary
	 * page
	 */
	public boolean iterateAndVerifyBenefitSummaryDetails(String policyRequiredFor, String numberOfTracing) {
		boolean isBenefitSummaryDetailsVerified = false;
		try {
			switch (policyRequiredFor) {
			case COREFLEXConstants.CLONING:
			case COREFLEXConstants.VERSIONING:
				isBenefitSummaryDetailsVerified = iterateAndVerifyCloningBenefitsSummaryDetails();
				break;
			case COREFLEXConstants.SIGNIFICANT_CHANGE:
				isBenefitSummaryDetailsVerified = iterateAndVerifySignificantChangeBenefitsSummaryDetails();
				break;
			case COREFLEXConstants.ALL_BENEFITS:
			case COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS:
			case COREFLEXConstants.END_TO_END:
				isBenefitSummaryDetailsVerified = iterateAndVerifyAllBenefitsSummaryDetails(policyRequiredFor,
						numberOfTracing);
				break;
			default:
				Assert.fail(COREFLEXConstants.BLUEPRINT_POLICY_REQUIRED_FOR_OPTION_NOT_PRESENT_IN_THE_LIST);
			}

			if (isBenefitSummaryDetailsVerified) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean iterateAndVerifyAllBenefitsSummaryDetails(String policyRequiredFor, String numberOfMilestones) {
		boolean isFlexBenefitSummaryVerified = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
							&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitGroupList, benefitList.getCategory(), true);
						isFlexBenefitSummaryVerified = (CoreFunctions
								.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
								.contains(benefitList.getCategory()))
								&& verifyBenefitSummaryDetails(indexBenefit, benefit);
						if (!isFlexBenefitSummaryVerified) {
							break;
						}
					} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
							&& (benefit.getAiresManagedService().equals("Yes"))
							&& (benefit.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitGroupList, benefitList.getCategory(), true);
						isFlexBenefitSummaryVerified = (CoreFunctions
								.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
								.contains(benefitList.getCategory()))
								&& verifyBenefitSummaryDetails(indexBenefit, benefit);
						if (!isFlexBenefitSummaryVerified) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isFlexBenefitSummaryVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitSummaryVerified;
	}

	private boolean verifyBenefitSummaryDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit, true))
						.equals(benefit.getPoints()));
	}

	private boolean iterateAndVerifyCloningBenefitsSummaryDetails() {
		boolean isFlexBenefitSummaryVerified = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if ((benefit.getPolicyCreationGroup().contains(COREFLEXConstants.CLONING))
							|| (benefit.getPolicyCreationGroup().contains(COREFLEXConstants.VERSIONING))) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitGroupList, benefitList.getCategory(), true);
						isFlexBenefitSummaryVerified = (CoreFunctions
								.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
								.contains(benefitList.getCategory()))
								&& verifyBenefitSummaryDetails(indexBenefit, benefit);
						if (!isFlexBenefitSummaryVerified) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isFlexBenefitSummaryVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitSummaryVerified;
	}

	private boolean iterateAndVerifySignificantChangeBenefitsSummaryDetails() {
		boolean isFlexBenefitSummaryVerified = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getPolicyCreationGroup().contains(COREFLEXConstants.VERSIONING)
							|| benefit.isSelectBenefitOnPBCPage()) {
						int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitNameList, benefit.getBenefitDisplayName());
						int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
								_textAddedBenefitGroupList, benefitList.getCategory(), true);
						isFlexBenefitSummaryVerified = (CoreFunctions
								.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
								.contains(benefitList.getCategory()))
								&& verifyBenefitSummaryDetails(indexBenefit, benefit);
						if (!isFlexBenefitSummaryVerified) {
							break;
						}
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isFlexBenefitSummaryVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_CATEGORIES_AND_TYPE_ON_BENEFIT_SUMMARY_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitSummaryVerified;
	}

	public boolean verifyPolicyStatus(String expectedPolicyStatus) {
		if (CoreFunctions.getElementText(driver, _textPolicyStatus).equals(expectedPolicyStatus)) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_STATUS,
					CoreConstants.PASS, expectedPolicyStatus));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_POLICY_STATUS,
					CoreConstants.FAIL, CoreFunctions.getElementText(driver, _textPolicyStatus), expectedPolicyStatus));
			return false;
		}
	}

}
