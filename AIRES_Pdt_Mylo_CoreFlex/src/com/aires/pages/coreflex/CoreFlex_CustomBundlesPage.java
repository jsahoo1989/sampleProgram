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

public class CoreFlex_CustomBundlesPage extends Base {

	public CoreFlex_CustomBundlesPage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	// Submit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Submit')]")
	private WebElement _buttonSubmit;

	// Save & Submit Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Save & Submit')]")
	private WebElement _buttonSaveAndSubmit;

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

	// Added New Custom Bundle Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Add New Custom Bundle')]")
	private WebElement _buttonAddNewCustomBundle;

	// Bundle Name TextArea
	@FindBy(how = How.CSS, using = "*[formcontrolname='bundleName']")
	private WebElement _fieldBundleName;

	// Bundle List Select
	@FindBy(how = How.CSS, using = "ng-select[formcontrolname='benefitList']")
	private WebElement _selectBundleList;

	// Bundle List Select Options
	@FindBy(how = How.XPATH, using = "//ng-select[@formcontrolname='benefitList']//div[@role='option']/span")
	private List<WebElement> _selectBundleListOptions;

	// Save Custom Bundle Button
	@FindBy(how = How.XPATH, using = "//button/span[contains(text(),'Save Custom Bundle')]")
	private WebElement _buttonSaveCustomBundle;

	// Cancel Link
	@FindBy(how = How.CSS, using = "a[class='cancel-btn']")
	private WebElement _linkCancel;

	// Saved Custom Bundles Text
	@FindBy(how = How.XPATH, using = "//label/b[contains(text(),'Saved Custom Bundles')]")
	private WebElement _textSavedCustomBundles;

	// Saved Custom Bundles List
	@FindBy(how = How.CSS, using = "span[class='bundleName']")
	private List<WebElement> _textSavedCustomBundlesList;

	// Pop-Up Submit Status
	@FindBy(how = How.CSS, using = "h2[id='swal2-title']")
	private WebElement _popUpTextSubmitStatus;

	// Pop-Up Submit Message
	@FindBy(how = How.CSS, using = "div[id='swal2-content']")
	private WebElement _popUpTextSubmitMessage;

	// Pop-Up OK Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'OK')]")
	private WebElement _popUpButtonOk;

	// Preview Transferee Experience Button
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Preview Transferee Experience')]")
	private WebElement _buttonPreviewTransfereeExp;

	/*********************************************************************/

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/*********************************************************************/

	/**
	 * Method to get Navigated Page Header.
	 * 
	 * @return
	 */
	public String getPageHeaderTitle() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _headerPage, COREFLEXConstants.CUSTOM_BUNDLES);
			return CoreFunctions.getElementText(driver, _headerPage);
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_PAGE_HEADER_TITLE,
							CoreConstants.FAIL, e.getMessage()));
		}
		return null;
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
			case COREFLEXConstants.SAVE_AND_SUBMIT:
				CoreFunctions.clickElement(driver, _buttonSaveAndSubmit);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.SUBMIT:
				CoreFunctions.clickElement(driver, _buttonSubmit);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.ADD_NEW_CUSTOM_BUNDLE:
				CoreFunctions.clickElement(driver, _buttonAddNewCustomBundle);
				break;
			case COREFLEXConstants.SAVE_CUSTOM_BUNDLE:
				CoreFunctions.clickUsingJS(driver, _buttonSaveCustomBundle, COREFLEXConstants.SAVE_CUSTOM_BUNDLE);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.OK:
				CoreFunctions.clickElement(driver, _popUpButtonOk);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE:
				CoreFunctions.clickElement(driver, _buttonPreviewTransfereeExp);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);				
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
	 * Method to verify navigated Page Header Title and Left Navigation
	 * 
	 * @param expectedPageName
	 * @return
	 */
	public boolean verifyPageNavigation(String expectedPageName) {
		return (getPageHeaderTitle().equals(expectedPageName))
				& (getLeftNavigationPageTitle().equals(expectedPageName));
	}

	/**
	 * Method to Verify Policy Submit status and Message
	 * 
	 * @param submitStatusMessage
	 * @param policyName
	 * @return
	 */
	public boolean verifyPolicySubmitStatus(String submitStatusMessage, String policyName) {
		boolean isPolicySubmitStatusVerified = false;
		boolean isSubmitStatusVerified, isSubmitMessageVerified;
		String actualSubmitMessage = null, expectedSubmitMessage = null;
		try {			
			String[] expectedSubmitStatusMessage = submitStatusMessage.split("\\|");
			isSubmitStatusVerified = (expectedSubmitStatusMessage[0].trim())
					.equalsIgnoreCase(CoreFunctions.getElementText(driver, _popUpTextSubmitStatus));
			expectedSubmitStatusMessage[1] = expectedSubmitStatusMessage[1].replace("PolicyName", policyName);
			actualSubmitMessage = CoreFunctions.getElementText(driver, _popUpTextSubmitMessage);
			expectedSubmitMessage = expectedSubmitStatusMessage[1].trim();
			isSubmitMessageVerified = (expectedSubmitMessage)
					.equalsIgnoreCase(actualSubmitMessage);
			isPolicySubmitStatusVerified = isSubmitStatusVerified & isSubmitMessageVerified;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POLICY_SUBMIT_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPolicySubmitStatusVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_POLICY_SUBMIT_STATUS_AND_MESSAGE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.PASS, actualSubmitMessage));
		}
		else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.POLICY_SUBMIT_STATUS_AND_MESSAGE_NOT_MATCHED_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL,expectedSubmitMessage, actualSubmitMessage));
		}
		return isPolicySubmitStatusVerified;
	}

	/**
	 * Method to iterate through DataTable List and Call Create New Custom Bundle
	 * 
	 * @param addNewCustomBundleButton
	 * @param policyType
	 * @param saveCustomBundleButton
	 * @param benefitType
	 * @return
	 */
	public boolean iterateAndAddNewCustomBundle(String addNewCustomBundleButton, String policyType,
			String saveCustomBundleButton) {
		boolean isCustomBundleCreated = false;
		try {
			List<String> bundleBenefitList = getBenefitList(policyType);
			if (policyType.equals(COREFLEXConstants.CORE)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.CANNOT_CREATE_CUSTOM_BUNDLE_FOR_CORE_BENEFIT_TYPE, CoreConstants.PASS));
				return true;
			}
			clickElementOfPage(addNewCustomBundleButton);
			isCustomBundleCreated = createNewCustomBundle(policySetupPageData.customBundlesPage.customBundleName,
					bundleBenefitList, saveCustomBundleButton);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_ADDING_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCustomBundleCreated) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_ADDED_A_NEW_CUSTOM_BUNDLE_ON_CUSTOM_BUNDLES_PAGE, CoreConstants.PASS,
					policySetupPageData.customBundlesPage.customBundleName));
		}
		return isCustomBundleCreated;
	}

	/**
	 * Method to create a new Custom Bundle
	 * 
	 * @param bundleName
	 * @param bundleBenefitList
	 * @param saveCustomBundleButton
	 * @return
	 */
	private boolean createNewCustomBundle(String bundleName, List<String> bundleBenefitList,
			String saveCustomBundleButton) {
		CoreFunctions.clearAndSetText(driver, _fieldBundleName, bundleName);
		for (String benefit : bundleBenefitList) {
			CoreFunctions.clickElement(driver, _selectBundleList);
			CoreFunctions.selectItemInListByText(driver, _selectBundleListOptions, benefit, true);
		}
		clickElementOfPage(saveCustomBundleButton);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _textSavedCustomBundles,
				COREFLEXConstants.SAVED_CUSTOM_BUNDLES);
		return CoreFunctions.searchElementExistsInListByText(driver, _textSavedCustomBundlesList, bundleName, true);
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

}
