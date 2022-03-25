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
import com.aires.testdatatypes.coreflex.MX_Transferee_AccountSetupDetails;
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

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFBenefitOuterCard')]//span[text()='Select This'] | //div[contains(@class,'RXCFBenefitOuterCard')]//span[contains(text(),'Selected')]")
	private List<WebElement> _buttonSelectThis;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFBenefitOuterCard')]//span[contains(text(),'Selected')]")
	private List<WebElement> _buttonSelected;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFBenefitOuterCard')]//span[starts-with(text(),'Selected')]")
	private WebElement _buttonSelectedBenefit;

	@FindBy(how = How.XPATH, using = "//div[contains(@class,'RXCFBenefitOuterCard')]//span[text()='Select This']")
	private WebElement _buttonSelectThisBenefit;

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

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'plus')][not(contains(@aria-disabled,'true'))] | //a[contains(@id,'selb')][not(contains(@aria-disabled,'true'))]")
	private WebElement _benefitAvailableForSelection;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'minus')] | //a[@class='RXCFGreenSmallRoundedButton af_link p_AFTextOnly']//span[text()='Select This']")
	private List<WebElement> _buttonMinusBenefit;

	@FindBy(how = How.CSS, using = "a[id*='minus']")
	private WebElement _buttonMinus;

	@FindBy(how = How.CSS, using = "table.RXCFRoundedTitleBox.RXMineShaftBoxBorder.af_panelGroupLayout span.RXCFText.RXGraniteGrey")
	private WebElement _text_cashOutName;

	@FindBy(how = How.CSS, using = "table.RXCFRoundedContainer.RXGumboContainerBorder.af_panelGroupLayout span.RXCFText.RXWrappedText.RXGraniteGrey")
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
	private WebElement _selectSelectAccount;

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

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.CSS, using = "td.AFContentCell > input")
	private WebElement _inputCashoutPoints;

	// Cashout Points Field Non Editable Text
	@FindBy(how = How.CSS, using = "span[class='RXAiresSeaglass RXBold RXCFText']")
	private WebElement _textInputCashoutPoints;

	// CashOut Section Select This Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//span[contains(text(),'Select This')]")
	private WebElement _buttonSelectThisCashoutPoints;

	// CashOut Section Selected Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//span[contains(text(),'Selected')]")
	private WebElement _buttonSelectedCashoutPoints;

	// Disabled CashOut Section Select This Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//span[contains(text(),'Select This')]/parent::a[@aria-disabled='true']")
	private WebElement _disabledSelectThisCashoutPointsButton;

	// CashOut Button Disabled Minus
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[contains(@id,'csb1')][@aria-disabled='true']")
	private WebElement _buttonCashoutDisabledMinus;

	// CashOut Button Minus
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[contains(@id,'csb2')][@aria-disabled='true']")
	private WebElement _buttonCashoutDisabledPlus;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails();

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	public static final List<Benefit> allBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getAllFlexBenefitsData();

	public static double totalPointsOnPolicy;
	public static double cashoutPoints;
	public static double selectedCashoutPoints;

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
				isBenefitNamePresent = coreBenefits.stream()
						.filter(o -> o.getBenefitDisplayName().equals(benefit.getText())).findAny()
						.orElse(null) != null;
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
			benefitsSelectedSuccessfully = selectFlexBenefitsonFPT() && selectPortionCashOutOnFPT()
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

	public boolean selectPortionCashOutOnFPT() {
		boolean isPortionCashoutSelected = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutSelected = selectPointsForCashout(cashoutPoints*0.15);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutSelected) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutSelected;
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
					&& verifyFlexBenefitsDetails();
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitName() && verifyCoreBenefitTooltipText();
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitName() && verifyCoreBenefitTooltipText() && verifyDefaultPointsBalanceSection()
					&& verifyPointBalanceTooltipContent() && verifyFlexBenefitsDetails();
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

	public boolean selectPointsForCashout(double cashoutPoints) {
		CoreFunctions.clearAndSetTextUsingKeys(driver, _input_cashOutValue, String.valueOf(cashoutPoints),MobilityXConstants.CASHOUT_INPUT_FIELD);		
		CoreFunctions.clickElement(driver, _buttonSelectThisCashoutPoints);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectedCashoutPoints,
				MobilityXConstants.CASHOUT_SELECTED);
		selectedCashoutPoints = Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
		totalSelectedPoints += selectedCashoutPoints;
		return CoreFunctions.isElementExist(driver, _buttonSelectedCashoutPoints, 2);
	}

	public boolean verifySuggestedBundlesDetails() {
		boolean isCustomBundleHeaderDetailsVerified = false, isCustomBundleBenefitListVerified = false,
				customBundleMatched = false;
		boolean isCustomBundleTotalPointsMatched = false;
		try {
			CoreFunctions.clickElement(driver, _link_suggestedOptions);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_suggestedBundles,
					MobilityXConstants.SUGGESTED_BUNDLES);
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
		boolean isFlexBenefitsVerified = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _suggestedBenefitNameList,
						benefit.getBenefitDisplayName());
				isFlexBenefitsVerified = verifySuggestedBenefitDetails(indexBenefit, benefit);
				if (!isFlexBenefitsVerified)
					return false;
			}
		}
		if (isFlexBenefitsVerified) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_CUSTOM_BUNDLE_DETAILS,
					CoreConstants.PASS));
		}
		return isFlexBenefitsVerified;
	}

	private boolean verifySuggestedBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _suggestedBenefitNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _suggestedAllowanceAmountList, indexBenefit, true)
						.replace("/", "").trim()).equals(benefit.getBenefitAmount()))
				&& ((CoreFunctions.getItemsFromListByIndex(driver, _suggestedBenefitsPointsList, indexBenefit, true)
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
		totalPointsOnPolicy = Double
				.parseDouble(CoreFunctions.getElementText(driver, total_points).replace("/", "").trim());
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
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					int indexCategory = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitGroupList, benefitList.getCategory(), true);
					isFlexBenefitDetailsOnFTPVerified = (CoreFunctions
							.getItemsFromListByIndex(driver, _textAddedBenefitGroupList, indexCategory, true)
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
		for (FlexBenefit benefitList : flexBenefits) {
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
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
						MobilityXConstants.SELECT_THIS);
				BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexBenefit);
				totalSelectedPoints += points;
				isBenefitSelected = true;
				for (int j = 1; j < benefit.getNumberOfBenefitSelected(); j++) {
					BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonPlusBenefit, indexBenefit);
					totalSelectedPoints += points;
					isBenefitSelected = true;
				}
			} else {
				BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexBenefit);
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

	public boolean verifyPortionCashOutOnFPT() {
		boolean isPortionCashoutVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutVerified = verifyInitialCashOutContent(false)
						&& verifyCashoutContentBySelectingPointsLessThanMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingPointsEqualToMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingPointsMoreThanMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingAllBenefitPoints()
						&& selectAllAvailablePointsForCashoutAndVerify() && verifyEnteredCustomPortionCashoutValue()
						&& verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMinBenefitValue()
						&& verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMaxBenefitValue()
						&& deselectSelectedCashoutAndBenefits();
				flag = true;
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				isPortionCashoutVerified = true;
				flag = false;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_FUNCTIONALITY_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public double getAvailableCashoutPoints(boolean submittedBenefits) {
		if (!submittedBenefits) {
			cashoutPoints = totalPointsOnPolicy
					* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100;
		} else {
			cashoutPoints = MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission < cashoutPoints
					? MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission
					: cashoutPoints;
		}
		return cashoutPoints;
	}

	public boolean verifyInitialCashOutContent(boolean isBenefitsSubmitted) {
		try {
			getAvailableCashoutPoints(isBenefitsSubmitted);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_cashOutName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutName),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutSuggestion),
					MobilityXConstants.CASHOUT_SUGGESTION_TEXT, MobilityXConstants.CASHOUT_SUGGESTION);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_howManyPoints),
					MobilityXConstants.HOW_MANY_POINTS_WOULD_YOU_LIKE_TO_CASH_OUT,
					MobilityXConstants.HOW_MANY_POINTS_TEXT);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut)),
					cashoutPoints, MobilityXConstants.POINTS_AVAILABLE_FOR_CASHOUT);
			String[] cashOutValue = CoreFunctions.getElementText(driver, _text_cashOutValue).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutValue[0].trim()), cashoutPoints,
					MobilityXConstants.CASHOUT_VALUE);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					cashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);
			String[] cashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutInputText[0].trim()), cashoutPoints,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			if ((CoreFunctions.getAttributeText(_selectSelectAccount, "title")
					.contains((((accountDetails.accountType).toUpperCase()) + " - "
							+ (((accountDetails.currency).equals("U.S. Dollar")) ? "USD" : null))))
					&& CoreFunctions.isElementExist(driver, _buttonSelectThisCashoutPoints, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_PORTION_CASHOUT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_CASHOUT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCashoutContentBySelectingPointsLessThanMaxPortionCashoutPercent() {
		boolean isPortionCashoutVerified = false;
		try {
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
			int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
					duplicateHosuingBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexBenefit);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _buttonSelected);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					Double.parseDouble(duplicateHosuingBenefit.getPoints()), false, 0);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonMinus,
					MobilityXConstants.REMOVE_BENEFIT);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_BENEFITS_POINTS_LESS_THAN_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_POINTS_LESS_THAN_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyCashoutContentBySelectingPointsEqualToMaxPortionCashoutPercent() {
		boolean isPortionCashoutVerified = false;
		try {
			Benefit otherHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.OTHER_HOUSING_BENEFIT)).findAny()
					.orElse(null);
			int indexOtherBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
					_textAddedBenefitNameList, otherHosuingBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexOtherBenefit);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _buttonSelected);
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					(Double.parseDouble(duplicateHosuingBenefit.getPoints()))
							+ (Double.parseDouble(otherHosuingBenefit.getPoints())),
					false, 0);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonMinus,
					MobilityXConstants.REMOVE_BENEFIT);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_BENEFITS_POINTS_EQUAL_TO_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_POINTS_EQUAL_TO_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyCashoutContentBySelectingPointsMoreThanMaxPortionCashoutPercent() {
		boolean isPortionCashoutVerified = false;
		try {
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
			Benefit otherHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.OTHER_HOUSING_BENEFIT)).findAny()
					.orElse(null);
			Benefit lumpSumBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LUMP_SUM)).findAny().orElse(null);
			int indexLumpSumBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
					_textAddedBenefitNameList, lumpSumBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexLumpSumBenefit);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					(Double.parseDouble(duplicateHosuingBenefit.getPoints()))
							+ (Double.parseDouble(otherHosuingBenefit.getPoints()))
							+ (Double.parseDouble(lumpSumBenefit.getPoints())),
					false, 0);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectedBenefit,
					MobilityXConstants.REMOVE_BENEFIT);
			CoreFunctions.clickElement(driver, _buttonSelectedBenefit);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			if (isPortionCashoutVerified && verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					(Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints))), false, 0)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_BENEFITS_POINTS_MORE_THAN_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_POINTS_GREATER_THAN_MAX_PORTION_CASHOUT_PERCENT_VALUE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyCashoutContentBySelectingAllBenefitPoints() {
		boolean isPortionCashoutVerified = false;
		try {
			double remainingPoints = Double.parseDouble(CoreFunctions.getElementText(driver, remaining_points));
			double selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);

			while (selectedBenefitPoints < remainingPoints) {
				selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
				if (selectedBenefitPoints == remainingPoints) {
					isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
							selectedBenefitPoints, false, 0);
					break;
				} else {
					isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
							selectedBenefitPoints, false, 0);
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, duplicateHosuingBenefit.getBenefitDisplayName());
					BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonPlusBenefit, indexBenefit);
					CoreFunctions.explicitWaitTillElementListVisibility(driver, _buttonSelected);
				}
				if (!isPortionCashoutVerified)
					break;
			}
			if (isPortionCashoutVerified && verifyBenefitCashoutSelectionDisabled()) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_ALL_BENEFITS_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_ALL_BENEFIT_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyBenefitCashoutSelectionDisabled() {
		try {
			if (!(CoreFunctions.isElementExist(driver, _benefitAvailableForSelection, 2))
					&& (CoreFunctions.isElementExist(driver, _disabledSelectThisCashoutPointsButton, 2))) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_BENEFIT_CASHOUT_FIELDS_ARE_DISABLED_AFTER_ALL_AVAILABLE_POINTS_ARE_CONSUMED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;

			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_BENEFIT_CASHOUT_FIELDS_ARE_DISABLED_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(double selectedBenefitPoints,
			boolean isCashoutSelected, double selectedCashoutPoints) {
		try {
			double expectedCashOutPoints = 0;
			double remainingPoints = Double.parseDouble(CoreFunctions.getElementText(driver, remaining_points));

			if (isCashoutSelected && selectedBenefitPoints == 0) {
				expectedCashOutPoints = cashoutPoints - selectedCashoutPoints;
			} else if (isCashoutSelected && selectedBenefitPoints != 0) {
				expectedCashOutPoints = (remainingPoints - selectedBenefitPoints) >= cashoutPoints
						? (cashoutPoints - selectedCashoutPoints)
						: (remainingPoints - (selectedBenefitPoints + selectedCashoutPoints));
			} else if (!isCashoutSelected) {
				expectedCashOutPoints = (remainingPoints - selectedBenefitPoints) >= cashoutPoints ? cashoutPoints
						: (remainingPoints - selectedBenefitPoints);
				selectedCashoutPoints = expectedCashOutPoints;
			}
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut)),
					expectedCashOutPoints, MobilityXConstants.POINTS_AVAILABLE_FOR_CASHOUT);
			String[] cashOutValue = CoreFunctions.getElementText(driver, _text_cashOutValue).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutValue[0].trim()), expectedCashOutPoints,
					MobilityXConstants.CASHOUT_VALUE);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					selectedCashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);
			String[] cashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints).split("\\(");
			CoreFunctions.verifyValue(Double.parseDouble(cashOutInputText[0].trim()), selectedCashoutPoints,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_AFTER_BENEFIT_SELECTION_DESELCTION_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean selectAllAvailablePointsForCashoutAndVerify() {
		boolean isPortionCashoutVerified = false;
		try {
			deselectAllBenefitsonFPTPage();
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisCashoutPoints,
					MobilityXConstants.SELECT_CASHOUT);
			double totalPointsAvailableForCashout = Double
					.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
			CoreFunctions.clickElement(driver, _buttonSelectThisCashoutPoints);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectedCashoutPoints,
					MobilityXConstants.CASHOUT_SELECTED);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(0, true,
					totalPointsAvailableForCashout)
					& CoreFunctions.isElementExist(driver, _buttonCashoutDisabledMinus, 2)
					& CoreFunctions.isElementExist(driver, _buttonCashoutDisabledPlus, 2)
					& CoreFunctions.isElementExist(driver, _buttonSelectedCashoutPoints, 2);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_ALL_BENEFITS_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_ALL_AVAILABLE_CASHOUT_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private void deselectAllBenefitsonFPTPage() {
		double selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
		while (selectedBenefitPoints >= 0.0) {
			selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
			if (selectedBenefitPoints == 0.0) {
				break;
			} else {
				if (CoreFunctions.isElementExist(driver, _buttonMinus, 4))
					CoreFunctions.clickElement(driver, _buttonMinus);
				else if (CoreFunctions.isElementExist(driver, _buttonSelectedBenefit, 4))
					CoreFunctions.clickElement(driver, _buttonSelectedBenefit);
			}
		}
	}

	private boolean verifyEnteredCustomPortionCashoutValue() {
		boolean isPortionCashoutVerified = false;
		try {
			CoreFunctions.clickElement(driver, _buttonSelectedCashoutPoints);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisCashoutPoints,
					MobilityXConstants.SELECT_CASHOUT);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputCashoutPoints, String.valueOf(cashoutPoints * 0.25),
					MobilityXConstants.CASHOUT_INPUT_FIELD);
			double totalPointsAvailableForCashout = Double
					.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
			CoreFunctions.clickElement(driver, _buttonSelectThisCashoutPoints);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectedCashoutPoints,
					MobilityXConstants.CASHOUT_SELECTED);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(0, true,
					totalPointsAvailableForCashout);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_CUSTOM_CASHOUT_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_ENTERING_CUSTOM_CASHOUT_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMinBenefitValue() {
		boolean isPortionCashoutVerified = false;
		try {
			CoreFunctions.clickElement(driver, _buttonSelectedCashoutPoints);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisCashoutPoints,
					MobilityXConstants.SELECT_CASHOUT);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputCashoutPoints, String.valueOf(cashoutPoints * 0.55),
					MobilityXConstants.CASHOUT_INPUT_FIELD);
			double totalPointsAvailableForCashout = Double
					.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
			CoreFunctions.clickElement(driver, _buttonSelectThisCashoutPoints);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectedCashoutPoints,
					MobilityXConstants.CASHOUT_SELECTED);
			CoreFunctions.scrollToElementUsingJS(driver, flexHomePageTitle, MobilityXConstants.FLEX_PLANNING_TOOL);
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
			int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
					duplicateHosuingBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexBenefit);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _buttonSelected);
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					(Double.parseDouble(duplicateHosuingBenefit.getPoints())), true, totalPointsAvailableForCashout);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_CUSTOM_CASHOUT_AND_BENEFIT_POINTS_LESS_THAN_MAX_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_CUSTOM_CASHOUT_AND_BENEFIT_POINTS_LESS_THAN_MAX_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMaxBenefitValue() {
		boolean isPortionCashoutVerified = false;
		try {
			Benefit duplicateHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.DUPLICATE_HOUSING)).findAny().orElse(null);
			Benefit otherHosuingBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.OTHER_HOUSING_BENEFIT)).findAny()
					.orElse(null);
			int indexOtherBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
					_textAddedBenefitNameList, otherHosuingBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexOtherBenefit);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _buttonSelected);
			Benefit lumpSumBenefit = allBenefits.stream()
					.filter(b -> b.getBenefitType().equals(COREFLEXConstants.LUMP_SUM)).findAny().orElse(null);
			int indexLumpSumBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
					_textAddedBenefitNameList, lumpSumBenefit.getBenefitDisplayName());
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisBenefit,
					MobilityXConstants.SELECT_THIS);
			BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexLumpSumBenefit);
			double totalPointsAvailableForCashout = Double
					.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
			isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
					(Double.parseDouble(duplicateHosuingBenefit.getPoints()))
							+ (Double.parseDouble(otherHosuingBenefit.getPoints()))
							+ (Double.parseDouble(lumpSumBenefit.getPoints())),
					true, totalPointsAvailableForCashout);
			if (isPortionCashoutVerified) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_BY_SELECTING_CUSTOM_CASHOUT_AND_BENEFIT_POINTS_MORE_THAN_MAX_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_BY_SELECTING_CUSTOM_CASHOUT_AND_BENEFIT_POINTS_MORE_THAN_MAX_PORTION_CASHOUT_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isPortionCashoutVerified;
	}

	private boolean deselectSelectedCashoutAndBenefits() {
		try {
			if (CoreFunctions.isElementExist(driver, _buttonSelectedCashoutPoints, 5)) {
				CoreFunctions.clickElement(driver, _buttonSelectedCashoutPoints);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectThisCashoutPoints,
						MobilityXConstants.SELECT_CASHOUT);
				CoreFunctions.scrollToElementUsingJS(driver, flexHomePageTitle, MobilityXConstants.FLEX_PLANNING_TOOL);
			}
			deselectAllBenefitsonFPTPage();
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_DESELECTING_SELECTED_CASHOUT_AND_BENEFIT_POINTS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

}
