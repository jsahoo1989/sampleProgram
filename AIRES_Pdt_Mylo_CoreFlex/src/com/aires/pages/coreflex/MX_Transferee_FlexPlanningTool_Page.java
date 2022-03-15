package com.aires.pages.coreflex;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;
import java.util.Objects;

import org.openqa.selenium.By;
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
import com.aires.testdatatypes.coreflex.OtherBenefit;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Transferee_FlexPlanningTool_Page extends Base {

	public MX_Transferee_FlexPlanningTool_Page(WebDriver driver) {
		super(driver);
	}

	public static double totalSelectedPoints = 0;

	@FindBy(how = How.CSS, using = "span[class*='RXCFGreenBox '] > span")
	private WebElement flexHomePageTitle;

	@FindBy(how = How.CSS, using = "td[title='Core Benefits']")
	private WebElement coreBenefitSection;

	@FindBy(how = How.CSS, using = "td[title='Flex Benefits']")
	private WebElement flexBenefitSection;

	@FindBy(how = How.XPATH, using = "//div[@id='fRegion:0:pglcb1']/child::*")
	private List<WebElement> optedCoreBenefits;

	By tooltipLocator = By.xpath(".//span[@class='RXCFIcon RXGrey icon-help']");

	@FindBy(how = How.CSS, using = "a.af_panelWindow_close-icon-style")
	private WebElement closeTooltip;

	@FindBy(how = How.XPATH, using = "//div[@class='af_panelAccordion_body-content p_AFFlow'][1]")
	private List<WebElement> coreOrFlexBenefitType;

	@FindBy(how = How.CSS, using = "span.RXCFBigText.RXWrappedText.RXGraniteGrey.RXBolder")
	private WebElement tooltip_benefitName;

	@FindBy(how = How.XPATH, using = "(//div[@id='fRegion:0:fHint::popup-container']//span)[2]")
	private WebElement tooltip_benefitAmount;

	@FindBy(how = How.XPATH, using = "(//div[@id='fRegion:0:fHint::popup-container']//span)[3]")
	private WebElement tooltip_benefitDescription;

	@FindBy(how = How.XPATH, using = "//div[@class='af_panelAccordion_body-content p_AFFlow'][2]")
	private List<WebElement> BothBenefitsType;

	@FindBy(how = How.CSS, using = "span.af_selectBooleanCheckbox_content-input")
	private List<WebElement> bothTypeSelected;

	@FindBy(how = How.CSS, using = "table.RXCFBenefitCard.AFStretchWidth.af_panelGroupLayout")
	private List<WebElement> flexBenefits_list;

	@FindBy(how = How.XPATH, using = "//div[@id='fRegion:0:pane3']//table//span[@class='RXCFText RXGraniteGrey']")
	private List<WebElement> flex_categories;

	@FindBy(how = How.XPATH, using = "//a[@class='RXCFGreenSmallRoundedButton af_link p_AFTextOnly']//span[text()='Select This']")
	private List<WebElement> _buttonSelectThis;

	@FindBy(how = How.XPATH, using = "//div[@class='RXCFInnerRightSelectedCard af_panelGroupLayout']")
	private WebElement pointBalance;

	@FindBy(how = How.CSS, using = "span.RXCFEnormousText.RXBold.RXWhite")
	private WebElement remaining_points;

	@FindBy(how = How.XPATH, using = "//div[@class='RXCFInnerRightSelectedCard af_panelGroupLayout']//span[@class='RXCFText RXWhite']")
	private WebElement total_points;

	@FindBy(how = How.CSS, using = "span.RXCFIcon.RXWhite.icon-help")
	private WebElement pointBalance_tooltip;

	@FindBy(how = How.CSS, using = "span.RXCFSmallText.RXWrappedText.RXWhite")
	private WebElement pointBalance_tooltip_content;

	@FindBy(how = How.CSS, using = "span.RXCFText.RXWhite.RXTextUnderline")
	private WebElement _btn_next;

	@FindBy(how = How.XPATH, using = "(//table[contains(@class,'RXCFCuriousBlueRoundedBox')]//span[@class='RXCFText RXWhite'])[1]")
	private WebElement selectedPoints;

	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Next')]/parent::td/preceding-sibling::td/span[@class='RXCFText RXWhite'][not(contains(text(),'pts'))]")
	private WebElement _afterSubmissionRemainingPoints;

	@FindBy(how = How.CSS, using = "a[id*='plus']")
	private List<WebElement> _buttonPlusBenefit;

	@FindBy(how = How.CSS, using = "a[id*='minus']")
	private List<WebElement> _buttonMinusBenefit;

	@FindBy(how = How.CSS, using = "table.RXCFRoundedTitleBox.RXMineShaftBoxBorder.af_panelGroupLayout span.RXCFText.RXGraniteGrey")
	private WebElement _text_cashOutName;

	@FindBy(how = How.CSS, using = "span.RXCFText.RXWrappedText.RXGraniteGrey")
	private WebElement _text_cashOutSuggestion;

	@FindBy(how = How.CSS, using = "span.RXMineShaft.RXBold.RXCFBiggerText")
	private WebElement _text_howManyPoints;

	@FindBy(how = How.CSS, using = "a.RXCFGreenRoundedButton.af_link.p_AFTextOnly")
	private WebElement _btn_selectThis_Cash;

	@FindBy(how = How.CSS, using = "span.RXCFEnormousText.RXBolder.RXWrappedText.RXWhite")
	private WebElement _text_pointsAvailableForCashOut;

	@FindBy(how = How.CSS, using = "span[id*='fcot'][class='RXCFBiggerText RXWrappedText RXWhite RXBolder']")
	private WebElement _text_cashOutValue;

	@FindBy(how = How.CSS, using = "td.AFContentCell > input")
	private WebElement _input_cashOutValue;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'csb')]/span[text()='+']")
	private WebElement _btn_incrCashValue;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'csb')]/span[text()='-']")
	private WebElement _btn_decrCashValue;

	@FindBy(how = How.XPATH, using = "//a[@class='RXCFGreenBorderSmallRoundButton af_link p_AFDisabled p_AFTextOnly']/span[text()='+']")
	private WebElement _btn_disabled_incrCashValue;

	@FindBy(how = How.XPATH, using = "//a[@class='RXCFGreenBorderSmallRoundButton af_link p_AFDisabled p_AFTextOnly']/span[text()='-']")
	private WebElement _btn_disabled_decrCashValue;

	@FindBy(how = How.CSS, using = "select[name*='reimAccount']")
	private WebElement _select_selectAccount;

	@FindBy(how = How.CSS, using = "span.RXCFSmallerText.RXAiresSeaglass")
	private WebElement _btn_selected;

	@FindBy(how = How.XPATH, using = "//span[text()='Take a look at some suggested options!']")
	private WebElement _link_suggestedOptions;

	@FindBy(how = How.CSS, using = "span.RXCFOrangeBox.af_panelGroupLayout  > span")
	private WebElement _text_suggestedBundles;

	@FindBy(how = How.CSS, using = "span.RXBigText.RXBolder")
	private WebElement _customBundleName;

	@FindBy(how = How.CSS, using = "div[id*='innerDiv'] > div > table")
	private List<WebElement> _benefitList;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to benefits list']")
	private WebElement _link_backToBenefitList;

	@FindBy(how = How.CSS, using = "div[class='RXBold af_panelGroupLayout']")
	private WebElement _textTotalPointBalance;

	@FindBy(how = How.CSS, using = "table[id*='pglmms']")
	private WebElement _textAvailablePointBalance;

	// Added Benefit Name List
	@FindBy(how = How.CSS, using = "span[class='RXCFText RXBold RXMineShaft']")
	private List<WebElement> _textAddedBenefitNameList;

	// Added Benefit Group List
	@FindBy(how = How.CSS, using = "span[class='RXCFText RXGraniteGrey']")
	private List<WebElement> _textAddedBenefitGroupList;

	// Benefits Points List
	@FindBy(how = How.CSS, using = "span[class='RXCFEnormousText RXBold RXMineShaft']")
	private List<WebElement> _benefitsPointsList;

	// Allowance Amount List
	@FindBy(how = How.CSS, using = "span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _allowanceAmountList;

	// Benefit Description List
	@FindBy(how = How.CSS, using = "span[class='RXCFSmallerText RXBold RXMineShaft RXWrappedText']")
	private List<WebElement> _benefitDescList;

	// Suggested Benefit Name List
	@FindBy(how = How.CSS, using = "span[class='RXText RXMineShaft RXBolder']")
	private List<WebElement> _suggestedBenefitNameList;

	// Suggested Allowance Amount List
	@FindBy(how = How.CSS, using = "span[class='RXText RXMineShaft RXBold']")
	private List<WebElement> _suggestedAllowanceAmountList;

	// Suggested Benefits Points List
	@FindBy(how = How.CSS, using = "span[class='RXCFText RXBold RXAiresSeaglass']")
	private List<WebElement> _suggestedBenefitsPointsList;

	// Suggested/Custom Bundle Available and Total Points
	@FindBy(how = How.CSS, using = "span[class*='RXCFBigText RXWhite RXBolder']")
	private WebElement _textCustomBundleTotalPoints;

	// Suggested/Custom Bundle Disabled Select This Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select This')]/parent::a[contains(@class,'Disabled')]")
	private WebElement _buttonCustomBundleDisabledSelectThis;

	// Suggested/Custom Bundle Enabled Select This Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Select This')]/parent::a [not(contains(@class,'Disabled'))]")
	private WebElement _buttonCustomBundleEnabledSelectThis;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> categoryWiseFlexBenefits = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getMXTransfereeFlexBenefitDetails();

	public static final List<OtherBenefit> otherBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeOtherBenefitDetails();

	public final List<Benefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getAllFlexBenefits();

	/*********************************************************************/

	public boolean isFlexPlanningToolHomePageDisplayed() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, flexHomePageTitle,
				MobilityXConstants.FLEX_PLANNING_TOOL);
		return CoreFunctions.getElementText(driver, flexHomePageTitle).equals(MobilityXConstants.FLEX_PLANNING_TOOL);
	}

	public void verifyFlexPlanningToolHomePageContent() {
		if (flexBenefits != null) {
			assertTrue(CoreFunctions.isElementExist(driver, pointBalance, 10),
					MobilityXConstants.POINT_BALANCE_NOT_DISPLAYED_ON_FLEX_PLANNING_TOOL_PAGE);
			CoreFunctions.clickElement(driver, pointBalance_tooltip);
			assertEquals(CoreFunctions.getElementText(driver, pointBalance_tooltip_content), pointBalanceDetails(),
					MobilityXConstants.POINT_BALANCE_DATA_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE);
		}
	}

	public boolean verifyDefaultPointsBalanceSection() {
		boolean isDefaultPointBalanceCorrect = false;
		try {
			if (CoreFunctions.isElementExist(driver, pointBalance, 10)) {
				String defaultActualRemainingPointBalance = CoreFunctions.getElementText(driver, remaining_points);
				String defaultActualTotalPointBalance = CoreFunctions.getElementText(driver, total_points)
						.replace("/", "").trim();
				isDefaultPointBalanceCorrect = ((policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
						.equals(defaultActualRemainingPointBalance))
						&& ((policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
								.equals(defaultActualTotalPointBalance));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DEFAULT_REMAINING_AND_TOTAL_POINTS_BALANCE_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDefaultPointBalanceCorrect) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_DEFAULT_REMAINING_AND_TOTAL_POINTS_BALANCE_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isDefaultPointBalanceCorrect;
	}

	public boolean verifyPostSubmissionPointsBalanceSection() {
		boolean isDefaultPointBalanceCorrect = false;
		try {
			if (CoreFunctions.isElementExist(driver, pointBalance, 10)) {
				String defaultActualRemainingPointBalance = CoreFunctions.getElementText(driver, remaining_points);
				String defaultActualTotalPointBalance = CoreFunctions.getElementText(driver, total_points)
						.replace("/", "").trim();
				isDefaultPointBalanceCorrect = ((MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission) == (Double
						.parseDouble(defaultActualRemainingPointBalance)))
						&& ((policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable)
								.equals(defaultActualTotalPointBalance));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_DEFAULT_REMAINING_AND_TOTAL_POINTS_BALANCE_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isDefaultPointBalanceCorrect) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_DEFAULT_REMAINING_AND_TOTAL_POINTS_BALANCE_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isDefaultPointBalanceCorrect;
	}

	public boolean verifyPointBalanceTooltipContent() {
		CoreFunctions.clickElement(driver, pointBalance_tooltip);
		return CoreFunctions.getElementText(driver, pointBalance_tooltip_content).equals(pointBalanceDetails());
	}

	public String pointBalanceDetails() {
		String total = CoreFunctions.getElementText(driver, total_points).replace("/", "").trim();
		String remaining = CoreFunctions.getElementText(driver, remaining_points);
		double consumed = Double.parseDouble(total) - Double.parseDouble(remaining);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.POINT_BALANCE_DETAILS_FPT.replace("used_points", format.format(consumed))
				.replace("total_points", total).replace("current_balance", remaining);
	}

	public boolean verifyCoreBenefitTooltipText() {
		boolean isBenefitNisTooltipTextMatched = false;
		try {
			for (int i = 0; i < optedCoreBenefits.size(); i++) {
				WebElement coreBenefit = optedCoreBenefits.get(i);
				WebElement tooltip = CoreFunctions.findSubElement(coreBenefit, tooltipLocator);
				CoreFunctions.clickElement(driver, tooltip);
				CoreFunctions.waitHandler(2);
				Benefit benefit = new Benefit(CoreFunctions.getElementText(driver, tooltip_benefitName),
						CoreFunctions.getElementText(driver, tooltip_benefitAmount),
						CoreFunctions.getElementText(driver, tooltip_benefitDescription));
				isBenefitNisTooltipTextMatched = coreBenefits.contains(benefit);
				CoreFunctions.clickElement(driver, closeTooltip);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CORE_BENEFIT_TOOLTIP_DETAILS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			isBenefitNisTooltipTextMatched = false;
		}
		if (isBenefitNisTooltipTextMatched)
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CORE_BENEFITS_TOOLTIP_DETAILS_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		return isBenefitNisTooltipTextMatched;
	}

	public boolean verifyCoreBenefitName() {
		boolean isBenefitNamePresent = false;
		try {
			for (int i = 0; i < optedCoreBenefits.size(); i++) {
				WebElement benefit = optedCoreBenefits.get(i);
				System.out.println(benefit.getText());
				isBenefitNamePresent = coreBenefits.stream().filter(o -> o.getBenefitType().equals(benefit.getText()))
						.findAny().orElse(null) != null;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.CORE_BENEFITS_NOT_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE,
							CoreConstants.FAIL, e.getMessage()));
			isBenefitNamePresent = false;
		}
		if (isBenefitNamePresent)
			Reporter.addStepLog(MessageFormat
					.format(MobilityXConstants.CORE_BENEFITS_MATCHED_ON_FLEX_PLANNING_TOOL_PAGE, CoreConstants.PASS));
		return isBenefitNamePresent;
	}

	public boolean selectBenefitsAndProceedToReviewAndSubmit() {
		boolean benefitsSelectedSuccessfully = false;
		try {
			benefitsSelectedSuccessfully = selectFlexBenefitsonFPT() && selectOtherBenefitsonFPT()
					&& validatePointsAndClickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (benefitsSelectedSuccessfully) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.SUCCESSFULLY_SELECTED_BENEFITS_AND_PROCEEDED_TO_REVIEW_PAGE,
							CoreConstants.PASS));
		}
		return benefitsSelectedSuccessfully;
	}

	public boolean validateAndSelectPortionCashOut() {
		boolean isPortionCashoutVerified = false;
		try {
			if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT)) {
				double totalPointsOnPolicy = Double
						.parseDouble(CoreFunctions.getElementText(driver, total_points).replace("/", "").trim());
				double cashoutPoints = totalPointsOnPolicy
						* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100;
				isPortionCashoutVerified = verifyCashOutContent(cashoutPoints)
						&& selectPointsForCashoutAndAccountDetails(cashoutPoints);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_AND_SELECTING_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_AND_SELECTED_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public boolean validatePointsAndClickOnNext() {
		CoreFunctions.waitHandler(3);
		if (Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints)) == totalSelectedPoints) {
			CoreFunctions.clickElement(driver, _btn_next);
			return true;
		}
		return false;
	}

	public boolean verifyBenefitDetailsOnFPT(String policyType) {
		switch (policyType) {
		case COREFLEXConstants.FLEX:
			return verifyDefaultPointsBalanceSection() && verifyPointBalanceTooltipContent()
					&& verifyFlexBenefitsDetails() & verifyOtherBenefitsDetails();
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitName() && verifyCoreBenefitTooltipText();
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitName() && verifyCoreBenefitTooltipText() && verifyDefaultPointsBalanceSection()
					&& verifyPointBalanceTooltipContent() && verifyFlexBenefitsDetails() & verifyOtherBenefitsDetails();
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
	}

	public boolean verifyCoreBenefitRelatedContent() {
		if (coreBenefits != null)
			return verifyCoreBenefitName() && verifyCoreBenefitTooltipText();
		return true;
	}

	public boolean verifyCashOutContent(double cashoutPoints) {
		return Objects.equals(CoreFunctions.getElementText(driver, _text_cashOutName),
				policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)
				&& Objects.equals(CoreFunctions.getElementText(driver, _text_cashOutSuggestion),
						MobilityXConstants.CASHOUT_SUGGESTION_TEXT)
				&& Objects.equals(CoreFunctions.getElementText(driver, _text_howManyPoints),
						MobilityXConstants.HOW_MANY_POINTS_WOULD_YOU_LIKE_TO_CASH_OUT)
				&& Objects.equals(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut),
						String.valueOf(cashoutPoints))
				&& CoreFunctions.getElementText(driver, _text_cashOutValue).contains(String.valueOf(cashoutPoints));
	}

	public boolean selectPointsForCashoutAndAccountDetails(double cashoutPoints) {
		CoreFunctions.selectByVisibleText(driver, _select_selectAccount, "CHECK - INR (default)");
		CoreFunctions.clearAndSetText(driver, _input_cashOutValue, String.valueOf(cashoutPoints));
		totalSelectedPoints += cashoutPoints;
		CoreFunctions.clickElement(driver, _btn_selectThis_Cash);
		return CoreFunctions.isElementExist(driver, _btn_selected, 5)
				&& CoreFunctions.isElementExist(driver, _btn_disabled_incrCashValue, 5)
				&& CoreFunctions.isElementExist(driver, _btn_disabled_decrCashValue, 5);
	}

	public boolean verifySuggestedBundlesDetails() {
		boolean isCustomBundleHeaderDetailsVerified = false, isCustomBundleBenefitListVerified = false,
				customBundleMatched = false;
		boolean isCustomBundleTotalPointsMatched = false;
		try {
			CoreFunctions.clickElement(driver, _link_suggestedOptions);
			isCustomBundleHeaderDetailsVerified = ((CoreFunctions.getElementText(driver, _text_suggestedBundles))
					.equals(MobilityXConstants.SUGGESTED_BUNDLES))
					&& (CoreFunctions.getElementText(driver, _customBundleName)
							.equals(policySetupPageData.customBundlesPage.customBundleName));
			isCustomBundleBenefitListVerified = verifyCustomBundlesBenefitListDetails();
			isCustomBundleTotalPointsMatched = verifyCustomBundlePointsDetails();
			customBundleMatched = isCustomBundleHeaderDetailsVerified & isCustomBundleBenefitListVerified
					& isCustomBundleTotalPointsMatched;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.FAILED_TO_VERIFY_CUSTOM_BUNDLE_DETAILS,
					CoreConstants.FAIL, e.getMessage()));
			customBundleMatched = false;
		}
		if (customBundleMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_CUSTOM_BUNDLE_NAME_LIST_AND_POINTS, CoreConstants.PASS));
		}
		return customBundleMatched;
	}

	private boolean verifyCustomBundlePointsDetails() {
		double calculatedTotalPoints = 0;
		for (WebElement element : _suggestedBenefitsPointsList) {
			calculatedTotalPoints += Double.parseDouble(element.getText().replace("pts", "").trim());
		}
		String expectedCustomBundleTotalPoints = String.valueOf(calculatedTotalPoints) + "/"
				+ policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable + " pts";
		String actualCustomBundleTotalPoints = CoreFunctions.getElementText(driver, _textCustomBundleTotalPoints);

		return (actualCustomBundleTotalPoints.equals(expectedCustomBundleTotalPoints))
				&& validateSuggestedBundlesSelectThisButton(calculatedTotalPoints,
						Double.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable));
	}

	private boolean validateSuggestedBundlesSelectThisButton(double calculatedTotalPoints,
			double staticFixedTotalPointsAvailable) {

		if ((calculatedTotalPoints > staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleDisabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_DISABLED_FOR_CALCULATED_TOTALPOINTS_GREATER_THAN_TOTALAVAILABLEPOINTS,
					CoreConstants.PASS, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return true;
		} else if ((calculatedTotalPoints > staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleEnabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_ENABLED_FOR_CALCULATED_TOTALPOINTS_GREATER_THAN_TOTALAVAILABLEPOINTS,
					CoreConstants.FAIL, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return false;
		} else if ((calculatedTotalPoints == staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleEnabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_ENABLED_FOR_CALCULATED_TOTALPOINTS_EQUAL_TO_TOTALAVAILABLEPOINTS,
					CoreConstants.PASS, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return true;
		} else if ((calculatedTotalPoints == staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleDisabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_DISABLED_FOR_CALCULATED_TOTALPOINTS_EQUAL_TO_TOTALAVAILABLEPOINTS,
					CoreConstants.FAIL, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return false;
		} else if ((calculatedTotalPoints < staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleEnabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_ENABLED_FOR_CALCULATED_TOTALPOINTS_LESS_THAN_TOTALAVAILABLEPOINTS,
					CoreConstants.PASS, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return true;
		} else if ((calculatedTotalPoints < staticFixedTotalPointsAvailable)
				&& CoreFunctions.isElementExist(driver, _buttonCustomBundleDisabledSelectThis, 2)) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.CUSTOM_BUNDLE_SELECT_THIS_BUTTON_IS_DISABLED_FOR_CALCULATED_TOTALPOINTS_LESS_THAN_TOTALAVAILABLEPOINTS,
					CoreConstants.FAIL, calculatedTotalPoints, staticFixedTotalPointsAvailable));
			return false;
		} else
			return false;
	}

	private boolean verifyCustomBundlesBenefitListDetails() {
		boolean isFlexBenefitsVerified = false, isOtherBenefitsVerified = false;
		for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _suggestedBenefitNameList,
						benefit.getBenefitDisplayName());
				isFlexBenefitsVerified = verifySuggestedBenefitDetails(indexBenefit, benefit);
				if (!isFlexBenefitsVerified)
					return false;
			}
		}
		for (OtherBenefit benefitList : otherBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _suggestedBenefitNameList,
						benefit.getBenefitDisplayName());
				isOtherBenefitsVerified = verifySuggestedBenefitDetails(indexBenefit, benefit);
				if (!isOtherBenefitsVerified)
					return false;
			}
		}
		if (isFlexBenefitsVerified & isOtherBenefitsVerified) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_CUSTOM_BUNDLE_DETAILS,
					CoreConstants.PASS));
		}
		return isFlexBenefitsVerified & isOtherBenefitsVerified;
	}

	private boolean verifySuggestedBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _suggestedBenefitNameList, indexBenefit)
				.equals(benefit.getBenefitDisplayName()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _suggestedAllowanceAmountList, indexBenefit)
						.replace("/", "").trim()).equals(benefit.getBenefitAmount()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _suggestedBenefitsPointsList, indexBenefit)
						.replace("pts", "").trim()).equals(benefit.getPoints()));
	}

	public boolean verifyUpdatedPointDetails() {
		boolean isPointBalanceMatched = false;
		try {
			isPointBalanceMatched = Double
					.parseDouble(CoreFunctions.getElementText(driver, remaining_points)) == totalSelectedPoints;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_UPADTED_POINT_BALANCE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPointBalanceMatched) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_UPADTED_POINT_BALANCE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPointBalanceMatched;
	}

	public boolean verifySubmittedPointsDetails() {
		return verifyPostSubmissionPointsBalanceSection() && verifyPointBalanceTooltipContent()
				&& validatePointsAfterSubmissionAndClickOnNext();
	}

	private boolean validatePointsAfterSubmissionAndClickOnNext() {
		CoreFunctions.waitHandler(1);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		if ((CoreFunctions.getElementText(driver, _afterSubmissionRemainingPoints))
				.equals(format.format((MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission)))) {
			CoreFunctions.clickElement(driver, _btn_next);
			return true;
		}
		return false;
	}

	public boolean verifyAvailablePointsMessage() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return CoreFunctions.getElementText(driver, _textTotalPointBalance)
				.contains(MobilityXConstants.AVAILABLE_POINTS_TEXT.replace("available_points", format.format(
						Double.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable))));
	}

	public boolean verifyAvailablePointsMessageAfterSubmission() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		isFlexPlanningToolHomePageDisplayed();
		return CoreFunctions.getElementText(driver, _textTotalPointBalance)
				.contains(MobilityXConstants.AVAILABLE_POINTS_TEXT.replace("available_points",
						format.format((MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission))));
	}

	public boolean verifyFlexBenefitsDetails() {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		try {
			for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);
					isFlexBenefitDetailsOnFTPVerified = (CoreFunctions
							.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory)
							.equals(benefitList.getCategory()))
							&& verifyFlexPlanningToolBenefitDetails(indexBenefit, benefit);
					if (!isFlexBenefitDetailsOnFTPVerified) {
						break;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnFTPVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnFTPVerified;
	}

	private boolean verifyOtherBenefitsDetails() {
		boolean isOtherBenefitDetailsOnFPTVerified = false;
		try {
			for (OtherBenefit benefitList : otherBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);
					isOtherBenefitDetailsOnFPTVerified = (CoreFunctions
							.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory)
							.equals(benefitList.getCategory()))
							&& verifyFlexPlanningToolBenefitDetails(indexBenefit, benefit);
					if (!isOtherBenefitDetailsOnFPTVerified) {
						break;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_OTHER_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}

		if (isOtherBenefitDetailsOnFPTVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_OTHER_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isOtherBenefitDetailsOnFPTVerified;
	}

	private boolean verifyFlexPlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textAddedBenefitNameList, indexBenefit)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _allowanceAmountList, indexBenefit)
						.equals(benefit.getBenefitAmount()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitDescList, indexBenefit))
						.equals(benefit.getBenefitDesc()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _benefitsPointsList, indexBenefit))
						.equals(benefit.getPoints()));
	}

	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case MobilityXConstants.BACK_TO_BENEFITS_LIST:
				CoreFunctions.clickElement(driver, _link_backToBenefitList);
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

	private boolean selectFlexBenefitsonFPT() {
		boolean benefitsSelection = false, benefitsSelectionPerformed = false;
		for (FlexBenefit benefitList : categoryWiseFlexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);
					benefitsSelectionPerformed = performFlexBenefitSelection(benefit, indexBenefit, indexCategory);
					if (!benefitsSelectionPerformed) {
						return false;
					} else {
						benefitsSelection = benefitsSelectionPerformed;
					}
				} else {
					benefitsSelection = true;
				}
			}
		}
		return benefitsSelection;
	}

	private boolean selectOtherBenefitsonFPT() {
		boolean benefitsSelection = false, benefitsSelectionPerformed = false;
		for (OtherBenefit benefitList : otherBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (benefit.getSelectBenefitOnFPTPage()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);
					benefitsSelectionPerformed = performFlexBenefitSelection(benefit, indexBenefit, indexCategory);
					if (!benefitsSelectionPerformed) {
						return false;
					} else {
						benefitsSelection = benefitsSelectionPerformed;
					}
				} else {
					benefitsSelection = true;
				}
			}
		}
		return benefitsSelection;
	}

	private boolean performFlexBenefitSelection(Benefit benefit, int indexBenefit, int indexCategory) {
		boolean isBenefitSelected = false;
		try {
			double points = Double.parseDouble(benefit.getPoints());
			if ((benefit.getMultipleBenefitSelection()).equals("Yes")) {
				BusinessFunctions.selectValueFromListUsingIndex(_buttonSelectThis, indexBenefit);
				totalSelectedPoints += points;
				for (int j = 1; j < benefit.getNumberOfBenefitSelected(); j++) {
					CoreFunctions.waitHandler(2);
					BusinessFunctions.selectValueFromListUsingIndex(_buttonPlusBenefit, indexBenefit);
					totalSelectedPoints += points;
					isBenefitSelected = true;
				}
			} else {
				BusinessFunctions.selectValueFromListUsingIndex(_buttonSelectThis, indexBenefit);
				CoreFunctions.waitHandler(2);
				totalSelectedPoints += points;
				isBenefitSelected = true;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isBenefitSelected;
	}

}
