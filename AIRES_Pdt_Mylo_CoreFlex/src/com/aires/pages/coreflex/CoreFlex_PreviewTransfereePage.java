package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

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
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFlex_PreviewTransfereePage extends Base {

	public CoreFlex_PreviewTransfereePage(WebDriver driver) {
		super(driver);
	}

	/****************** Page Objects *************************************/

	@FindBy(how = How.CSS, using = "div[class*='close-transferee-link']")
	private WebElement _buttonCloseTransfereePreviewPage;

	@FindBy(how = How.XPATH, using = "//app-transferee-preview//div[contains(@class,'flex-tool')]")
	private WebElement _transfereePreviewPageTitle;

	@FindBy(how = How.XPATH, using = "//div[contains(text(),'Your total available point balance is')]/span")
	private WebElement _textAvailablePointBalance;

	@FindBy(how = How.CSS, using = "//h5[contains(text(),'Core Benefits')]/ancestor::div[@role='benefitlist']")
	private WebElement _coreBenefitSection;

	@FindBy(how = How.CSS, using = "//h5[contains(text(),'Flex Benefits')]/ancestor::div[@role='benefitlist']")
	private WebElement _flexBenefitSection;

	@FindBy(how = How.CSS, using = "label[class*='BenefitDescription']")
	private List<WebElement> _optedCoreBenefits;

	@FindBy(how = How.CSS, using = "div[class*='benefit-card']")
	private List<WebElement> _flexBenefitList;

	@FindBy(how = How.XPATH, using = "//div[@id='collapseFlexBenefit']//span[contains(@class,'cardtopinner')]")
	private List<WebElement> _flexCategories;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'cashOutTopCardBorder')]//span[contains(@class,'cardtopinner')]")
	private WebElement _textCashOutName;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'BenefitDescription')]//span[@class='mb-2']")
	private WebElement _textCashOutSuggestion;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Available for Cashout')]//ancestor::div[contains(@class,'d-flex')]//div[@class='BenefitPoint']/span[not (contains(text(),'Points'))]")
	private WebElement _textPointsAvailableForCashOut;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Cashout value:')]//ancestor::div[contains(@class,'d-flex')]//div[@class='BenefitPoint']/span")
	private WebElement _textCashOutValue;

	@FindBy(how = How.XPATH, using = "//div[@class='BenefitDescription']/following-sibling::a[contains(text(),'More')]")
	private List<WebElement> _moreLinkBenefitDesc;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Added Benefit Group List
	@FindBy(how = How.CSS, using = "span[class*='cardtopinner']")
	private List<WebElement> _textAddedBenefitGroupList;

	// Added Benefit Name List
	@FindBy(how = How.CSS, using = "span[class='BenefitName']")
	private List<WebElement> _textAddedBenefitNameList;

	// Benefits Points List
	@FindBy(how = How.XPATH, using = "//div[@id='collapseFlexBenefit']//div[@class='BenefitPoint']/span[not (contains(text(),'Points'))]")
	private List<WebElement> _benefitsPointsList;

	// Allowance Amount List
	@FindBy(how = How.XPATH, using = "//span[@class='BenefitName']/following-sibling::span")
	private List<WebElement> _allowanceAmountList;

	// Benefit Description List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'d-flex')]//div[@class='BenefitDescription']")
	private List<WebElement> _benefitDescList;

	// Tracing Prompt Label
	@FindBy(how = How.CSS, using = "span[class='tracingPromptLable']")
	private List<WebElement> _textTracingPrompt;

	// Flex Planning Tool Label
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'flex-tool')][contains(text(),'Flex Planning Tool')]")
	private WebElement _textFlexPlanningTool;

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

	public boolean isPreviewTransfereePageDisplayed() {
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonCloseTransfereePreviewPage,
				COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW);
		return (CoreFunctions.getElementText(driver, _buttonCloseTransfereePreviewPage)
				.equals(COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW)
				&& (CoreFunctions.isElementExist(driver, _textFlexPlanningTool, 5)));
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.CLOSE_TRANSFEREE_PREVIEW:
				CoreFunctions.clickElement(driver, _buttonCloseTransfereePreviewPage);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonPreviewTransfereeExp, COREFLEXConstants.PREVIEW_TRANSFEREE_EXPERIENCE);
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

	public boolean verifyCoreBenefitName() {
		boolean isBenefitNamePresent = false;
		try {
			for (int i = 0; i < _optedCoreBenefits.size(); i++) {
				WebElement benefit = _optedCoreBenefits.get(i);
				System.out.println(benefit.getText());
				isBenefitNamePresent = coreBenefits.stream()
						.filter(o -> o.getBenefitDisplayName().equals(benefit.getText())).findAny()
						.orElse(null) != null;
				if (!isBenefitNamePresent)
					return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CORE_BENEFITS_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			isBenefitNamePresent = false;
		}
		if (isBenefitNamePresent) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.CORE_BENEFITS_MATCHED_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.PASS));
		} else {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.CORE_BENEFITS_NOT_MATCHED_ON_PREVIEW_TRANSFEREE_PAGE, CoreConstants.FAIL));
		}
		return isBenefitNamePresent;
	}

	public boolean validatePortionCashOutSection() {
		boolean isPortionCashoutVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				double cashoutPoints = Double
						.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
						* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100;
				isPortionCashoutVerified = verifyCashOutContent(cashoutPoints);
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_PORTION_CASHOUT_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public boolean verifyBenefitDetailsOnPreviewTransfereePage(String policyType) {
		switch (policyType) {
		case COREFLEXConstants.FLEX:
			return verifyFlexBenefitsDetails();
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitName();
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitName() && verifyFlexBenefitsDetails();
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
	}

	
	private boolean verifyFlexBenefitsDetails() {
		boolean isFlexBenefitPreviewVerified = false;
		try {
			for (WebElement element : _moreLinkBenefitDesc) {
				CoreFunctions.clickElement(driver, element);
			}
			for (FlexBenefit benefitList : flexBenefits) {				
				for (Benefit benefit : benefitList.getBenefits()) {					
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);				
					isFlexBenefitPreviewVerified = (CoreFunctions
							.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
							.equals(benefitList.getCategory()))
							&& verifyFlexPlanningToolBenefitDetails(indexBenefit, benefit);					
					if (!isFlexBenefitPreviewVerified) {
						break;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isFlexBenefitPreviewVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitPreviewVerified;
	}
	
	private boolean verifyFlexPlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitDescList, indexBenefit, true))
						.equals(benefit.getBenefitDesc()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit, true))
						.equals(benefit.getPoints()));
	}

	public boolean verifyCashOutContent(double cashoutPoints) {
		return Objects.equals(CoreFunctions.getElementText(driver, _textCashOutName),
				policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)
				&& Objects.equals(CoreFunctions.getElementText(driver, _textCashOutSuggestion),
						MobilityXConstants.CASHOUT_SUGGESTION_TEXT_PREVIEW_TRANSFEREE)
				&& Objects.equals(
						Double.parseDouble(CoreFunctions.getElementText(driver, _textPointsAvailableForCashOut)),
						(cashoutPoints))
				&& CoreFunctions.getElementText(driver, _textCashOutValue).contains(String.valueOf(cashoutPoints));
	}

	public boolean verifyPreviewTransfereeExperience(String policyType) {
		return verifyBenefitDetailsOnPreviewTransfereePage(policyType) && validatePortionCashOutSection();
	}

	private boolean verifyTracingPromptText() {
		boolean isTracingPromptTextVerified = false;
		String actualLockBenefitDateArray[], actualBenefitExpirationDateArray[];

		try {
			String expectedLockBenefitDate = (policySetupPageData.flexPolicySetupPage.lockTheBenefitsPointsSelection)
					.replace("After", "on").trim();
			String expectedBenefitExpirationDate = (policySetupPageData.flexPolicySetupPage.benefitsExpirationDate)
					.toLowerCase();

			List<String> actualTracingPromtText = _textTracingPrompt.stream().map(x -> x.getText())
					.collect(Collectors.toList());
			if (actualTracingPromtText.size() > 0) {
				actualLockBenefitDateArray = actualTracingPromtText.get(0).split("=");
				actualBenefitExpirationDateArray = actualTracingPromtText.get(1).split("=");
				String actualLockBenefitDate = actualLockBenefitDateArray[1].trim();
				String actualBenefitExpirationDate = actualBenefitExpirationDateArray[1].trim().toLowerCase();
				isTracingPromptTextVerified = (actualLockBenefitDate.equalsIgnoreCase(expectedLockBenefitDate))
						&& (actualBenefitExpirationDate.contains(expectedBenefitExpirationDate));
			} else {
				actualBenefitExpirationDateArray = actualTracingPromtText.get(0).split("=");
				String actualBenefitExpirationDate = actualBenefitExpirationDateArray[1].replace("on", "").trim();
				isTracingPromptTextVerified = (actualBenefitExpirationDate
						.equalsIgnoreCase(expectedBenefitExpirationDate));
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRACING_PROMPT_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isTracingPromptTextVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_TRACING_PROMPT_DETAILS_ON_PREVIEW_TRANSFEREE_PAGE,
					CoreConstants.PASS));
		}
		return isTracingPromptTextVerified;
	}

}
