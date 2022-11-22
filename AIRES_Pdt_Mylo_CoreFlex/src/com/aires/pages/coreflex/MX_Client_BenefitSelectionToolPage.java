package com.aires.pages.coreflex;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
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
import com.aires.testdatatypes.coreflex.CoreFlex_SettlingInBenefitsData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.testdatatypes.coreflex.MX_Client_Dashboard_BscData;
import com.aires.testdatatypes.coreflex.MX_Transferee_AccountSetupDetails;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class MX_Client_BenefitSelectionToolPage extends Base {

	public MX_Client_BenefitSelectionToolPage(WebDriver driver) {
		super(driver);
	}

	public static double totalSelectedPoints = 0;

	@FindBy(how = How.CSS, using = "span[class*='RXCFGreenBox '] > span")
	private WebElement benefitSelectionToolPageTitle;

	@FindBy(how = How.CSS, using = "td[title='Core Benefits']")
	private WebElement coreBenefitSection;

	@FindBy(how = How.CSS, using = "td[title='Flex Benefits']")
	private WebElement flexBenefitSection;

	@FindBy(how = How.CSS, using = "table[id*='benefitsWrapper'] td[class='AFContentCell'] label")
	private List<WebElement> optedCoreBenefits;

	@FindBy(how = How.CSS, using = "table[id*='benefitsWrapper'] td[class='AFContentCell'] label")
	private List<WebElement> _textCoreBenefitsNameList;

	// Allowance Amount List
	@FindBy(how = How.CSS, using = "table[id*='benefitsWrapper'] span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _textCoreAllowanceAmountList;

	@FindBy(how = How.CSS, using = "//div[@id='fRegion:0:pglcb1']/child::*")
	private List<WebElement> optedCoreBenefitsList;

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

	private By _buttonSelectPlus = By.xpath(".//a[contains(@id,'plus')]");

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'plus')][not(contains(@aria-disabled,'true'))] | //a[contains(@id,'selb')][not(contains(@aria-disabled,'true'))]")
	private WebElement _benefitAvailableForSelection;

	@FindBy(how = How.XPATH, using = "//a[contains(@id,'minus')] | //a[@class='RXCFGreenSmallRoundedButton af_link p_AFTextOnly']//span[text()='Select This']")
	private List<WebElement> _buttonMinusBenefit;

	@FindBy(how = How.CSS, using = "a[id*='minus']")
	private WebElement _buttonMinus;

	@FindBy(how = How.CSS, using = "a[id*='plus']")
	private WebElement _buttonPlus;

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

	@FindBy(how = How.XPATH, using = "//span[text()='Back to mobility journey']")
	private WebElement _link_backToMobilityJourney;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to benefits list']")
	private WebElement _link_backToBenefitList;

	@FindBy(how = How.XPATH, using = "//span[text()='Back to initiation']")
	private WebElement _link_backToIntiation;

	@FindBy(how = How.CSS, using = "div[class='RXBold af_panelGroupLayout']")
	private WebElement _textTotalPointBalance;

	@FindBy(how = How.CSS, using = "table[id*='pglmms']")
	private WebElement _textAvailablePointBalance;

	// Added Benefit Name List
	@FindBy(how = How.CSS, using = "table[class*='RXCFBenefitCard'] span[class='RXCFText RXBold RXMineShaft']")
	private List<WebElement> _textAddedBenefitNameList;

	// Added Benefit Group List
	@FindBy(how = How.CSS, using = "span[class='RXCFText RXGraniteGrey']")
	private List<WebElement> _textAddedBenefitGroupList;

	// Benefits Points List
	@FindBy(how = How.CSS, using = "table[class*='RXCFBenefitCard'] span[class='RXCFEnormousText RXBold RXMineShaft']")
	private List<WebElement> _benefitsPointsList;

	// Allowance Amount List
	@FindBy(how = How.CSS, using = "table[class*='RXCFBenefitCard'] span[class='RXCFSmallText RXAiresSeaglass']")
	private List<WebElement> _allowanceAmountList;

	// Benefit Description List
	@FindBy(how = How.CSS, using = "table[class*='RXCFBenefitCard'] span[class='RXCFSmallerText RXBold RXMineShaft RXWrappedText']")
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

	// Disabled CashOut Section Submitted Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//span[contains(text(),'Submitted')]/parent::a[@aria-disabled='true']")
	private WebElement _disabledSubmittedCashoutPointsButton;

	// CashOut Button Disabled Minus
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[contains(@id,'csb1')][@aria-disabled='true']")
	private WebElement _buttonCashoutDisabledMinus;

	// CashOut Button Minus
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[contains(@id,'csb2')][@aria-disabled='true']")
	private WebElement _buttonCashoutDisabledPlus;

	// More Link
	@FindBy(how = How.XPATH, using = "//div[@class='BenefitDescription']/following-sibling::a[contains(text(),'More')]")
	private List<WebElement> _moreLinkBenefitDesc;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// Initiation For
	@FindBy(how = How.CSS, using = "table[id*='contentclient'] span[class='RXSecondaryBigText']")
	private WebElement _textInitiationFor;

	// Core Benefit Section Text
	@FindBy(how = How.CSS, using = "table[id*='benefitsWrapper'] span[class='RXCFText RXGraniteGrey RXBold']")
	private WebElement _textCoreBenefitSectionText;

	// Flex Benefit Section Text
	@FindBy(how = How.CSS, using = "div[id*='secondItemDiv'] span[class='RXCFText RXGraniteGrey RXWrappedText']")
	private WebElement _textFlexBenefitSectionText;

	// Edit Submitted Benefits Button
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Edit Submitted Benefits')]")
	private WebElement _buttonEditSubmittedBenefits;

	// Cashout - After Relocation Note
	@FindBy(how = How.CSS, using = "span[id*='note'] > span")
	private WebElement _textAfterRelocationNote;

	// CashOut Section Disabled Select This Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[contains(@class,'Disabled ')]/span[contains(text(),'Select This')]")
	private WebElement _buttonDisabledSelectThisCashoutPoints;

	// CashOut Section Enabled Select This Button
	@FindBy(how = How.XPATH, using = "//table[contains(@id,'flexCash')]//a[not(contains(@class,'Disabled'))]/span[contains(text(),'Select This')]")
	private WebElement _buttonEnabledSelectThisCashoutPoints;

	/*********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	MX_Transferee_AccountSetupDetails accountDetails = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMxTransfereeAccountSetupDetails("AddPaymentAccount");

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	public static final List<Benefit> allBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getAllFlexBenefitsData();

	CoreFlex_SettlingInBenefitsData languageTrainingBenefitData = FileReaderManager.getInstance()
			.getCoreFlexJsonReader().getSettlingInBenefitDataList(COREFLEXConstants.LANGUAGE_TRAINING);

	MX_Client_Dashboard_BscData bscAuthorizationData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getBscDataByModuleName("DomesticAuthorizationFormData");

	public static double totalPointsOnPolicy = 0.0;
	public static double cashoutPoints = 0.0;
	public static double selectedCashoutPoints;

	public static String reimAccountType;

	/*********************************************************************/

	public static String getReimAccountType() {
		return reimAccountType;
	}

	public static void setReimAccountType(String reimAccountType) {
		MX_Client_BenefitSelectionToolPage.reimAccountType = reimAccountType;
	}

	public boolean verifyPageNavigation() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, benefitSelectionToolPageTitle,
				MobilityXConstants.BENEFIT_SELECTION_TOOL);
		return CoreFunctions.getElementText(driver, benefitSelectionToolPageTitle)
				.equals(MobilityXConstants.BENEFIT_SELECTION_TOOL);
	}

	public boolean isBenefitSelectionToolPageDisplayed() {
		CoreFunctions.explicitWaitTillElementVisibility(driver, benefitSelectionToolPageTitle,
				MobilityXConstants.BENEFIT_SELECTION_TOOL);
		return CoreFunctions.getElementText(driver, benefitSelectionToolPageTitle)
				.equals(MobilityXConstants.BENEFIT_SELECTION_TOOL);
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
				isDefaultPointBalanceCorrect = (Double.parseDouble(CoreFunctions.getPropertyFromConfig(
						"CF_Transferee_AvailablePoints")) == (Double.parseDouble(defaultActualRemainingPointBalance)))
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
		Log.info(CoreFunctions.getElementText(driver, pointBalance_tooltip_content));
		Log.info(pointBalanceDetails());
		return CoreFunctions.getElementText(driver, pointBalance_tooltip_content).equals(pointBalanceDetails());
	}

	public String pointBalanceDetails() {
		String total = CoreFunctions.getElementText(driver, total_points).replace("/", "").trim();
		String remaining = CoreFunctions.getElementText(driver, remaining_points);
		double consumed = Double.parseDouble(total) - Double.parseDouble(remaining);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.POINT_BALANCE_DETAILS.replace("used_points", format.format(consumed))
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

	public boolean selectBenefitsAndProceedToReview() {
		boolean benefitsSelectedSuccessfully = false;
		totalSelectedPoints = 0;
		MX_Client_BenefitsBundlePage.benefitDeletedFlag = false;
		try {
			benefitsSelectedSuccessfully = selectFlexBenefitsonBST() && selectPortionCashOutOnBST()
					&& validatePointsAndClickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (benefitsSelectedSuccessfully) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_BENEFITS_AND_PROCEEDED_TO_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return benefitsSelectedSuccessfully;
	}

	public boolean selectPortionCashOutOnBST() {
		boolean isPortionCashoutSelected = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutSelected = selectPointsForCashout(
						cashoutPoints == 0.0 ? getAvailableCashoutPoints(false) : cashoutPoints * 0.10);
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))) {
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_PORTION_CASHOUT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutSelected) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_PORTION_CASHOUT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS));
//			setReimAccountType(CoreFunctions.getAttributeText(_selectSelectAccount, "title"));
		}
		return isPortionCashoutSelected;
	}

	public boolean validatePointsAndClickOnNext() {
		try {
			CoreFunctions.waitHandler(3);
			if (Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints)) == totalSelectedPoints) {
				CoreFunctions.clickElement(driver, _btn_next);
				CoreFunctions.writeToPropertiesFile("CF_Client_TotalSelectedPoints",
						String.valueOf(totalSelectedPoints));
				CoreFunctions.writeToPropertiesFile("CF_Client_AvailablePoints",
						String.valueOf(totalPointsOnPolicy - totalSelectedPoints));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_POINTS_AND_CLICKING_ON_NEXT_BUTTON_ON_FPT_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean clickOnNext() {
		try {
			CoreFunctions.waitHandler(3);
			CoreFunctions.clickElement(driver, _btn_next);
			CoreFunctions.writeToPropertiesFile("CF_Client_TotalSelectedPoints", String.valueOf(totalSelectedPoints));
			CoreFunctions.writeToPropertiesFile("CF_Client_AvailablePoints", String.valueOf(Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))
					- (Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")))));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints",
					CoreFunctions.getPropertyFromConfig("CF_Client_AvailablePoints"));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_NEXT_BUTTON_ON_BST_PAGE,
							CoreConstants.FAIL, e.getMessage()));
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
		CoreFunctions.clearAndSetTextUsingKeys(driver, _input_cashOutValue, String.valueOf(cashoutPoints),
				MobilityXConstants.CASHOUT_INPUT_FIELD);
		CoreFunctions.clickElement(driver, _buttonSelectThisCashoutPoints);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _buttonSelectedCashoutPoints,
				MobilityXConstants.CASHOUT_SELECTED);
		selectedCashoutPoints = Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value"));
		CoreFunctions.writeToPropertiesFile("CF_Client_SelectedCashOutPoints", String.valueOf(selectedCashoutPoints));
		totalSelectedPoints += selectedCashoutPoints;
		return CoreFunctions.isElementExist(driver, _buttonSelectedCashoutPoints, 2);
	}

	public boolean verifySuggestedBundlesDetails() {
		boolean isCustomBundleHeaderDetailsVerified = false, isCustomBundleBenefitListVerified = false,
				customBundleMatched = false;
		boolean isCustomBundleTotalPointsMatched = false;
		try {
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

	public boolean verifyUserNavigationToSuggestedBundlesPage() {
		try {
			return CoreFunctions.isElementExist(driver, _text_suggestedBundles, 5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_SUGGESTED_BUNDLES_PAGE, CoreConstants.FAIL,
					e.getMessage()));
			return false;
		}
	}

	private boolean verifyCustomBundlePointsDetails() {
		double calculatedTotalPoints = 0;
		for (WebElement element : _suggestedBenefitsPointsList) {
			calculatedTotalPoints += Double.parseDouble(element.getText().replace("pts", "").trim());
		}
		String expectedCustomBundleTotalPoints = String.valueOf(calculatedTotalPoints) + "/"
				+ CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints") + " pts";
		String actualCustomBundleTotalPoints = CoreFunctions.getElementText(driver, _textCustomBundleTotalPoints);

		return (actualCustomBundleTotalPoints.equals(expectedCustomBundleTotalPoints))
				&& validateSuggestedBundlesSelectThisButton(calculatedTotalPoints,
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")));
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
		try {
			return verifyPostSubmissionPointsBalanceSection() && verifyPointBalanceTooltipContent()
					&& validatePointsAfterSubmissionAndClickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.FAILED_TO_VERIFY_UPADTED_POINT_BALANCE_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean validatePointsAfterSubmissionAndClickOnNext() {
		CoreFunctions.waitHandler(1);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		if ((CoreFunctions.getElementText(driver, _afterSubmissionRemainingPoints)).equals(format
				.format(Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))) {
			CoreFunctions.clickElement(driver, _btn_next);
			return true;
		}
		return false;
	}

	public boolean verifyAvailablePointsMessage() {
		try {
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			totalPointsOnPolicy = Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
			String actualPointsBalanceText = CoreFunctions.getElementText(driver, _textTotalPointBalance).replace("\n",
					" ");
			return actualPointsBalanceText.equals(MobilityXConstants.BENEFIT_SELECTION_TOOL_AVAILABLE_POINTS_TEXT
					.replace("available_points", format.format(Double
							.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AVAILABLE_POINTS_MESSAGE_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return false;
	}

	public boolean verifyAvailablePointsMessageAfterBenefitSubmission() {
		try {
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			totalPointsOnPolicy = Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"));
			String actualPointsBalanceText = CoreFunctions.getElementText(driver, _textTotalPointBalance).replace("\n",
					" ");
			return actualPointsBalanceText.equals(MobilityXConstants.BENEFIT_SELECTION_TOOL_AVAILABLE_POINTS_TEXT
					.replace("available_points", format.format(
							Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AVAILABLE_POINTS_MESSAGE_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return false;
	}

	public boolean verifyAvailablePointsMessageAfterSubmission() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return CoreFunctions.getElementText(driver, _textTotalPointBalance)
				.contains(MobilityXConstants.AVAILABLE_POINTS_TEXT.replace("available_points", format.format(
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))));
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
			case MobilityXConstants.BACK_TO_INITIATION:
				CoreFunctions.clickElement(driver, _link_backToIntiation);
				break;
			case MobilityXConstants.BACK_TO_MOBILITY_JOURNEY:
				CoreFunctions.clickElement(driver, _link_backToMobilityJourney);
				break;
			case MobilityXConstants.SUGGESTED_OPTIONS_LINK:
				CoreFunctions.clickElement(driver, _link_suggestedOptions);
				break;
			case MobilityXConstants.EDIT_SUBMITTED_BENEFITS:
				CoreFunctions.clickElement(driver, _buttonEditSubmittedBenefits);
				break;
			case MobilityXConstants.NEXT:
				CoreFunctions.clickElement(driver, _btn_next);
//				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
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

	private boolean selectFlexBenefitsonBST() {
		boolean benefitsSelection = false, benefitsSelectionPerformed = false;
		for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
				CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
			if (benefit.getSelectBenefitOnFPTPage()) {
				Log.info("Selecting " + benefit.getBenefitDisplayName() + " on BST page.");
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
						benefit.getBenefitDisplayName());
				benefitsSelectionPerformed = performFlexBenefitSelection(benefit, indexBenefit);
				if (!benefitsSelectionPerformed) {
					return false;
				} else {
					benefitsSelection = benefitsSelectionPerformed;
				}
			} else {
				benefitsSelection = true;
			}
		}
		return benefitsSelection;
	}

	private boolean performFlexBenefitSelection(Benefit benefit, int indexBenefit) {
		boolean isBenefitSelected = false;
		try {
			CoreFunctions.scrollToElementUsingJS(driver, benefitSelectionToolPageTitle,
					MobilityXConstants.BENEFIT_SELECTION_TOOL);
			CoreFunctions.waitHandler(5);
			double points = Double.parseDouble(benefit.getPoints());
			if ((benefit.getMultipleBenefitSelection()).equals("Yes")) {
				CoreFunctions.scrollClickUsingJS(driver, _buttonSelectThis.get(indexBenefit),
						benefit.getBenefitDisplayName() + " - Select This button");
				CoreFunctions.waitHandler(3);
				totalSelectedPoints += points;
				isBenefitSelected = true;
				for (int j = 1; j < benefit.getNumberOfBenefitSelected(); j++) {
					CoreFunctions.waitHandler(3);
					WebElement benefitSelectPlusButton = CoreFunctions
							.findSubElement(flexBenefits_list.get(indexBenefit), _buttonSelectPlus);
					CoreFunctions.scrollClickUsingJS(driver, benefitSelectPlusButton,
							"Multiple Selection - Plus Button");
					totalSelectedPoints += points;
					isBenefitSelected = true;
				}
			} else {
				BusinessFunctions.selectValueFromListUsingIndex(driver, _buttonSelectThis, indexBenefit);
				totalSelectedPoints += points;
				isBenefitSelected = true;
			}
			CoreFunctions.scrollToElementUsingJS(driver, benefitSelectionToolPageTitle,
					MobilityXConstants.BENEFIT_SELECTION_TOOL);
			CoreFunctions.waitHandler(5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return isBenefitSelected;
	}

	public boolean verifyCashoutSectionDetailsOnBST(boolean isBenefitsSubmitted) {
		boolean isPortionCashoutVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutVerified = verifyInitialCashOutContent(isBenefitsSubmitted);
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
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_FUNCTIONALITY_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public double getAvailableCashoutPoints(boolean submittedBenefits) {
		if (!submittedBenefits) {
			cashoutPoints = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
					* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100;
		} else {
			cashoutPoints = ((Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
					* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100)
					- (Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")));
			cashoutPoints = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))) < cashoutPoints
							? (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
							: cashoutPoints;
		}
		return cashoutPoints;
	}

	public boolean verifyCashoutSectionDetailsOnBSTPostDeleteRequestOperation(String actionPerformed) {
		boolean isPortionCashoutVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutVerified = verifyInitialCashOutContentPostDeleteRequestOperation(actionPerformed);
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
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_FUNCTIONALITY_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public double getAvailableCashoutPointsPostDeleteRequestOperation(String actionPerformed) {
		if (actionPerformed.equals(MobilityXConstants.APPROVED)) {
			cashoutPoints = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
					* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100;
		} else {
			cashoutPoints = ((Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
					* Double.parseDouble(policySetupPageData.flexPolicySetupPage.maxPortionCashoutPercent) / 100)
					- (Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_SelectedCashOutPoints")));
			cashoutPoints = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))) < cashoutPoints
							? (Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")))
							: cashoutPoints;
		}
		return cashoutPoints;
	}

	public boolean verifyInitialCashOutContent(boolean isBenefitsSubmitted) {
		try {
			String expectedCashoutValue = null;
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			getAvailableCashoutPoints(isBenefitsSubmitted);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_cashOutName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutName),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutSuggestion),
					MobilityXConstants.MX_CLIENT_CASHOUT_SUGGESTION_TEXT_DEFAULT,
					MobilityXConstants.CASHOUT_SUGGESTION);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_howManyPoints),
					MobilityXConstants.HOW_MANY_POINTS_WOULD_YOU_LIKE_TO_CASH_OUT,
					MobilityXConstants.HOW_MANY_POINTS_TEXT);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut)),
					cashoutPoints, MobilityXConstants.POINTS_AVAILABLE_FOR_CASHOUT);

			String actualCashoutValue = CoreFunctions.getElementText(driver, _text_cashOutValue);

			if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign").length() == 1) {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ format.format(cashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			} else {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign") + " "
						+ format.format(cashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			}

			CoreFunctions.verifyText(actualCashoutValue, expectedCashoutValue, MobilityXConstants.CASHOUT_VALUE);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					cashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);
			String actualCashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints);
			CoreFunctions.verifyText(actualCashOutInputText, expectedCashoutValue,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			if (cashoutPoints == 0.0 && isBenefitsSubmitted
					&& CoreFunctions.isElementExist(driver, _disabledSubmittedCashoutPointsButton, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_DETAILS_POST_ALL_CASHOUT_VALUE_SUBMISSION_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			} else if (CoreFunctions.isElementExist(driver, _buttonSelectThisCashoutPoints, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_PORTION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyInitialCashOutContentPostDeleteRequestOperation(String actionPerformed) {
		try {
			String expectedCashoutValue = null;
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			getAvailableCashoutPointsPostDeleteRequestOperation(actionPerformed);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_cashOutName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutName),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);			
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutSuggestion).trim(),
					MobilityXConstants.MX_CLIENT_CASHOUT_SUGGESTION_TEXT_DEFAULT,
					MobilityXConstants.CASHOUT_SUGGESTION);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_howManyPoints),
					MobilityXConstants.HOW_MANY_POINTS_WOULD_YOU_LIKE_TO_CASH_OUT,
					MobilityXConstants.HOW_MANY_POINTS_TEXT);			
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut)),
					cashoutPoints, MobilityXConstants.POINTS_AVAILABLE_FOR_CASHOUT);

			String actualCashoutValue = CoreFunctions.getElementText(driver, _text_cashOutValue);

			if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign").length() == 1) {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ format.format(cashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			} else {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign") + " "
						+ format.format(cashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			}
			CoreFunctions.verifyText(actualCashoutValue, expectedCashoutValue, MobilityXConstants.CASHOUT_VALUE);
			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					cashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);			
			String actualCashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints);
			CoreFunctions.verifyText(actualCashOutInputText, expectedCashoutValue,
					MobilityXConstants.CASHOUT_INPUT_FIELD_LABEL_VALUE);
			if (cashoutPoints == 0.0 && actionPerformed.equals(MobilityXConstants.DENIED)
					&& CoreFunctions.isElementExist(driver, _disabledSubmittedCashoutPointsButton, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_DETAILS_POST_DELETE_REQUEST_DENIED_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			} else if (CoreFunctions.isElementExist(driver, _buttonSelectThisCashoutPoints, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_PORTION_CASHOUT_DETAILS_POST_DELETE_REQUEST_DENIED_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
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
			double selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
			while (selectedBenefitPoints <= cashoutPoints) {
				selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
				if (selectedBenefitPoints == cashoutPoints) {
					isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
							selectedBenefitPoints, false, 0);
					break;
				} else {
					CoreFunctions.clickUsingJS(driver, _buttonPlus, COREFLEXConstants.PLUS_BUTTON);
					CoreFunctions.waitHandler(3);
				}
			}
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
			double selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
			while (selectedBenefitPoints < totalPointsOnPolicy) {
				selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
				if (selectedBenefitPoints > cashoutPoints) {
					isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
							selectedBenefitPoints, false, 0);
					break;
				} else {
					CoreFunctions.clickUsingJS(driver, _buttonPlus, COREFLEXConstants.PLUS_BUTTON);
					CoreFunctions.waitHandler(3);
				}
			}
			if (isPortionCashoutVerified) {
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
			double selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
			while (selectedBenefitPoints <= totalPointsOnPolicy) {
				selectedBenefitPoints = Double.parseDouble(CoreFunctions.getElementText(driver, selectedPoints));
				if (selectedBenefitPoints == totalPointsOnPolicy) {
					isPortionCashoutVerified = verifyPortionCashoutDetailsAfterBenefitCashoutSelectionDeselection(
							selectedBenefitPoints, false, 0);
					break;
				} else {
					CoreFunctions.clickUsingJS(driver, _buttonPlus, COREFLEXConstants.PLUS_BUTTON);
					CoreFunctions.waitHandler(3);
				}
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
			String expectedCashoutValue;
			String expectedCashOutInputText;
			double expectedCashOutPoints = 0;
			double remainingPoints = Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"));
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);

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
			CoreFunctions.waitHandler(3);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _text_pointsAvailableForCashOut)),
					expectedCashOutPoints, MobilityXConstants.POINTS_AVAILABLE_FOR_CASHOUT);

			String actualCashoutValue = CoreFunctions.getElementText(driver, _text_cashOutValue);
			if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign").length() == 1) {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ format.format(expectedCashOutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			} else {
				expectedCashoutValue = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign") + " "
						+ format.format(expectedCashOutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			}
			CoreFunctions.verifyText(actualCashoutValue, expectedCashoutValue, MobilityXConstants.CASHOUT_VALUE);

			CoreFunctions.verifyValue(Double.parseDouble(CoreFunctions.getAttributeText(_inputCashoutPoints, "value")),
					selectedCashoutPoints, MobilityXConstants.CASHOUT_INPUT_FIELD);

			String actualCashOutInputText = CoreFunctions.getElementText(driver, _textInputCashoutPoints);

			if (CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign").length() == 1) {
				expectedCashOutInputText = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ format.format(selectedCashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			} else {
				expectedCashOutInputText = CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencySign")
						+ " " + format.format(selectedCashoutPoints) + " ("
						+ CoreFunctions.getPropertyFromConfig("CF_Transferee_CashoutCurrencyCode") + ")";
			}

			CoreFunctions.verifyText(actualCashOutInputText, expectedCashOutInputText,
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
				if (CoreFunctions.isElementExist(driver, _buttonMinus, 4)) {
					CoreFunctions.clickElement(driver, _buttonMinus);
					CoreFunctions.waitHandler(3);
					CoreFunctions.waitForBrowserToLoad(driver);
				} else if (CoreFunctions.isElementExist(driver, _buttonSelectedBenefit, 4)) {
					CoreFunctions.clickElement(driver, _buttonSelectedBenefit);
					CoreFunctions.waitHandler(3);
					CoreFunctions.waitForBrowserToLoad(driver);
				}
			}
		}
	}

	private boolean verifyEnteredCustomPortionCashoutValue(double customCashoutPoints) {
		boolean isPortionCashoutVerified = false;
		try {
			CoreFunctions.clickElement(driver, _buttonSelectedCashoutPoints);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _buttonSelectThisCashoutPoints,
					MobilityXConstants.SELECT_CASHOUT);
			CoreFunctions.clearAndSetTextUsingKeys(driver, _inputCashoutPoints, String.valueOf(customCashoutPoints),
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
			CoreFunctions.scrollToElementUsingJS(driver, benefitSelectionToolPageTitle,
					MobilityXConstants.BENEFIT_SELECTION_TOOL);
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
				CoreFunctions.scrollToElementUsingJS(driver, benefitSelectionToolPageTitle,
						MobilityXConstants.BENEFIT_SELECTION_TOOL);
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

	public boolean verifyPortionCashOutPostSubmissionOnFPT() {
		boolean isPortionCashoutVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutVerified = verifyInitialCashOutContent(true)
						&& verifyCashoutContentBySelectingPointsLessThanMaxPortionCashoutPercent()
						&& selectAllAvailablePointsForCashoutAndVerify()
						&& verifyEnteredCustomPortionCashoutValue(cashoutPoints * 0.20)
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
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_POST_SUBMISSION_CASHOUT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_POST_SUBMISSION_PORTION_CASHOUT_FUNCTIONALITY_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public boolean selectBenefitsForMultipleSubmission() {
		boolean benefitsSelectedSuccessfully = false;
		try {
			benefitsSelectedSuccessfully = selectFlexBenefitsForMultipleSubmissionOnFPT()
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

	private boolean selectFlexBenefitsForMultipleSubmissionOnFPT() {
		boolean benefitsSelection = false, benefitsSelectionPerformed = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getMultipleBenefitSubmission()) {
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					benefitsSelectionPerformed = performFlexBenefitSelection(benefit, indexBenefit);
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

	public boolean verifyBenefitDetailsOnBSTBasedOnPolicyRequiredFor(String policyRequiredFor, String benefitType) {
		switch (benefitType) {
		case COREFLEXConstants.FLEX:
			return verifyFlexBenefitSectionText()
					&& verifyFlexBenefitsDetailsBasedOnPolicyRequiredFor(policyRequiredFor, benefitType);
		case COREFLEXConstants.CORE:
			return verifyCoreBenefitSectionText() && verifyCoreBenefitName();
		case COREFLEXConstants.BOTH:
			return verifyCoreBenefitSectionText()
					&& verifyCoreBenefitsDetailsBasedOnPolicyRequiredFor(policyRequiredFor, benefitType)
					&& verifyFlexBenefitSectionText()
					&& verifyFlexBenefitsDetailsBasedOnPolicyRequiredFor(policyRequiredFor, benefitType);
		default:
			Assert.fail(COREFLEXConstants.INVALID_OPTION);
		}
		return false;
	}

	private boolean verifyCoreBenefitSectionText() {
		return CoreFunctions.getElementText(driver, _textCoreBenefitSectionText)
				.equals(MobilityXConstants.CORE_BENEFIT_CLIENT_SECTION_TEXT);
	}

	private boolean verifyFlexBenefitSectionText() {
		return CoreFunctions.getElementText(driver, _textFlexBenefitSectionText)
				.equals(MobilityXConstants.FLEX_BENEFIT_CLIENT_SECTION_TEXT);
	}

	public boolean verifyFlexBenefitsDetailsBasedOnPolicyRequiredFor(String policyRequiredFor, String benefitType) {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		try {
			for (Benefit benefit : getBenefits(benefitType, policyRequiredFor, "0")) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textAddedBenefitNameList,
						benefit.getBenefitDisplayName());
				isFlexBenefitDetailsOnFTPVerified = verifyFlexPlanningToolBenefitDetails(indexBenefit, benefit);
				if (!isFlexBenefitDetailsOnFTPVerified) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_FLEX_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isFlexBenefitDetailsOnFTPVerified
				&& _textAddedBenefitNameList.size() == getBenefitsListSize(benefitType, policyRequiredFor, "0")) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_FLEX_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isFlexBenefitDetailsOnFTPVerified;
	}

	public boolean verifySuggestedBundlesDetailsBasedOnPolicyRequiredFor(String policyRequiredFor, String benefitType) {
		boolean isCustomBundleHeaderDetailsVerified = false, isCustomBundleBenefitListVerified = false,
				customBundleMatched = false;
		boolean isCustomBundleTotalPointsMatched = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_suggestedBundles,
					MobilityXConstants.SUGGESTED_BUNDLES);
			isCustomBundleHeaderDetailsVerified = ((CoreFunctions.getElementText(driver, _text_suggestedBundles))
					.equals(MobilityXConstants.SUGGESTED_BUNDLES))
					&& (CoreFunctions.getElementText(driver, _customBundleName)
							.equals(policySetupPageData.customBundlesPage.customBundleName));
			isCustomBundleBenefitListVerified = verifyCustomBundlesBenefitListDetailsBasedOnPolicyRequiredFor(
					benefitType, policyRequiredFor);
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

	private boolean verifyCustomBundlesBenefitListDetailsBasedOnPolicyRequiredFor(String benefitType,
			String policyRequiredFor) {
		boolean isFlexBenefitsVerified = false;
		for (Benefit benefit : getBenefits(benefitType, policyRequiredFor, "0")) {
			int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _suggestedBenefitNameList,
					benefit.getBenefitDisplayName());
			isFlexBenefitsVerified = verifySuggestedBenefitDetails(indexBenefit, benefit);
			if (!isFlexBenefitsVerified)
				return false;
		}
		if (isFlexBenefitsVerified
				&& _suggestedBenefitNameList.size() == getBenefitsListSize(benefitType, policyRequiredFor, "0")) {
			Reporter.addStepLog(MessageFormat.format(MobilityXConstants.SUCCESSFULLY_VERIFIED_CUSTOM_BUNDLE_DETAILS,
					CoreConstants.PASS));
		}
		return isFlexBenefitsVerified;
	}

	public boolean verifyBenefitDetailsOnFPTJourneyCards(int numberOfMilestones) {
		boolean isFlexBenefitDetailsOnFTPVerified = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					if (benefit.getNoOfMilestones() != null && benefit.getNoOfMilestones() == numberOfMilestones) {
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

	public boolean selectAiresManagedBenefitsAndProceedToReviewAndSubmit(int noOfTracingPrompts) {
		boolean benefitsSelectedSuccessfully = false;
		totalSelectedPoints = 0;
		MX_Transferee_MyBenefitsBundlePage.benefitDeletedFlag = false;
		try {
			benefitsSelectedSuccessfully = selectAiresManagedBenefitsOnFPT(noOfTracingPrompts)
					&& selectPortionCashOutOnBST() && validatePointsAndClickOnNext();
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

	private boolean selectAiresManagedBenefitsOnFPT(int numberOfMilestones) {
		boolean benefitsSelection = false, benefitsSelectionPerformed = false;
		for (FlexBenefit benefitList : flexBenefits) {
			for (Benefit benefit : benefitList.getBenefits()) {
				if (Objects.equals(benefit.getAiresManagedService(), "Yes") && benefit.getSelectBenefitOnFPTPage()
						&& benefit.getNoOfMilestones() != null
						&& Objects.equals(benefit.getNoOfMilestones(), numberOfMilestones)) {
					System.out.println(benefit.getBenefitDisplayName());
					int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver,
							_textAddedBenefitNameList, benefit.getBenefitDisplayName());
					benefitsSelectionPerformed = performFlexBenefitSelection(benefit, indexBenefit);
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
							|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList;
	}

	private int getBenefitsListSize(String policyType, String policyRequiredFor, String numberOfMilestones) {
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
							|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
							|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList.size();
	}

	public boolean verifyInitiationForText() {
		try {
			return CoreFunctions.getElementText(driver, _textInitiationFor)
					.equalsIgnoreCase((MobilityXConstants.INITIATION_FOR) + " "
							+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
							+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_INITIATION_FOR_TEXT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			Log.info(e.getMessage());
		}
		return false;
	}

	public boolean verifyCoreBenefitsDetailsBasedOnPolicyRequiredFor(String policyRequiredFor, String benefitType) {
		boolean isCoreBenefitDetailsOnBSTVerified = false;
		try {
			for (Benefit benefit : getCoreBenefits(benefitType, policyRequiredFor, "0")) {
				int indexBenefit = BusinessFunctions.returnindexItemFromListUsingText(driver, _textCoreBenefitsNameList,
						benefit.getBenefitDisplayName());
				isCoreBenefitDetailsOnBSTVerified = verifyCorePlanningToolBenefitDetails(indexBenefit, benefit);
				if (!isCoreBenefitDetailsOnBSTVerified) {
					break;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_CORE_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCoreBenefitDetailsOnBSTVerified
				&& _textAddedBenefitNameList.size() == getBenefitsListSize(benefitType, policyRequiredFor, "0")) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_CORE_BENEFIT_DETAILS_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isCoreBenefitDetailsOnBSTVerified;
	}

	private List<Benefit> getCoreBenefits(String policyType, String policyRequiredFor, String numberOfMilestones) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (Benefit benefit : coreBenefits) {
				if ((policyRequiredFor.equals(COREFLEXConstants.ALL_BENEFITS))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				} else if ((policyRequiredFor.equals(COREFLEXConstants.AIRES_MANAGED_BENEFITS_CARDS))
						&& (benefit.getAiresManagedService().equals("Yes"))
						&& (benefit.getNoOfMilestones() == Integer.parseInt(numberOfMilestones))) {
					benefitNameList.add(benefit);
				} else if (((policyRequiredFor.equals(COREFLEXConstants.CLONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.VERSIONING))
						|| (policyRequiredFor.equals(COREFLEXConstants.CLIENT)))
						&& (benefit.getPolicyCreationGroup().contains(policyRequiredFor))) {
					benefitNameList.add(benefit);
				}

			}
		}
		return benefitNameList;
	}

	private boolean verifyCorePlanningToolBenefitDetails(int indexBenefit, Benefit benefit) {
		return (CoreFunctions.getItemsFromListByIndex(driver, _textCoreBenefitsNameList, indexBenefit, true)
				.equals(benefit.getBenefitDisplayName()))
				&& (CoreFunctions.getItemsFromListByIndex(driver, _textCoreAllowanceAmountList, indexBenefit, true)
						.equals(benefit.getBenefitAmount()));
	}

	public boolean selectBenefitsCashoutAndProceedToSaveAndExit() {
		boolean benefitsSelectedSuccessfully = false;
		totalSelectedPoints = 0;
		MX_Client_BenefitsBundlePage.benefitDeletedFlag = false;
		try {
			benefitsSelectedSuccessfully = selectFlexBenefitsonBST() && selectPortionCashOutOnBST()
					&& validatePointsAndClickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_CASHOUT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (benefitsSelectedSuccessfully) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_BENEFITS_CASHOUT_AND_PROCEEDED_TO_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return benefitsSelectedSuccessfully;
	}

	public boolean selectBenefitsAndProceedToSaveAndExit() {
		boolean benefitsSelectedSuccessfully = false;
		totalSelectedPoints = 0;
//		MX_Client_BenefitsBundlePage.benefitDeletedFlag = false;
		try {
			benefitsSelectedSuccessfully = selectFlexBenefitsonBST() && validatePointsAndClickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_BENEFITS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (benefitsSelectedSuccessfully) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_BENEFITS_AND_PROCEEDED_TO_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return benefitsSelectedSuccessfully;
	}

	public boolean selectCashoutAndProceedToSaveAndExit() {
		boolean cashoutSelectedSuccessfully = false;
		try {
			cashoutSelectedSuccessfully = selectPortionCashOutOnBST() && clickOnNext();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_SELECTING_CASHOUT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (cashoutSelectedSuccessfully) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_SELECTED_CASHOUT_AND_PROCEEDED_TO_BENEFITS_BUNDLE_PAGE,
					CoreConstants.PASS));
		}
		return cashoutSelectedSuccessfully;
	}

	public boolean verifyElementPresentOnPage(String elementName) {
		boolean isElementPresentOnPage = false;
		try {
			switch (elementName) {
			case MobilityXConstants.EDIT_SUBMITTED_BENEFITS:
				isElementPresentOnPage = CoreFunctions.isElementExist(driver, _buttonEditSubmittedBenefits, 2);
				break;
			default:
				Assert.fail(COREFLEXConstants.INVALID_ELEMENT);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_ELEMENT_PRESENT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, elementName, e.getMessage()));
			throw new RuntimeException(e);
		}
		if (isElementPresentOnPage) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_ELEMENT_PRESENT_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS, elementName));
		}
		return isElementPresentOnPage;
	}

	public boolean validatePointsAfterSubmissionOnNextButton() {
		CoreFunctions.waitHandler(1);
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		if ((CoreFunctions.getElementText(driver, _afterSubmissionRemainingPoints)).equals(format
				.format(Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))) {
			return true;
		} else
			return false;
	}

	public boolean verifyPortionCashoutDetailsOnBST() {
		boolean isPortionCashoutVerified = false, flag = false;
		try {
			if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT)) {
				isPortionCashoutVerified = verifyCashoutContentBySelectingPointsLessThanMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingPointsEqualToMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingPointsMoreThanMaxPortionCashoutPercent()
						&& verifyCashoutContentBySelectingAllBenefitPoints()
						&& selectAllAvailablePointsForCashoutAndVerify()
						&& verifyEnteredCustomPortionCashoutValue(cashoutPoints * 0.25)
						&& verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMinBenefitValue()
						&& verifyCashoutDetailsWithEnteredCustomPortionCashoutAndMaxBenefitValue()
						&& deselectSelectedCashoutAndBenefits();
				flag = true;
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isPortionCashoutVerified = true;
				flag = false;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isPortionCashoutVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.SUCCESSFULLY_VERIFIED_PORTION_CASHOUT_FUNCTIONALITY_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isPortionCashoutVerified;
	}

	public boolean verifyCashoutDetailsOnBSTBeforeTracingAct() {
		boolean isCashoutDetailsVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isCashoutDetailsVerified = verifyAfterRelocationNoteBeforeTracing()
						&& verifyInitialCashOutContentBeforeActTracing(false);
				flag = true;
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.PORTION_CASHOUT))) {
				isCashoutDetailsVerified = true;
				flag = false;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCashoutDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS, CoreFunctions.getPropertyFromConfig("PolicyCashoutType")));
		}
		return isCashoutDetailsVerified;
	}

	private boolean verifyAfterRelocationNoteBeforeTracing() {
		try {
			if (CoreFunctions.getElementText(driver, _textAfterRelocationNote)
					.equals(MobilityXConstants.RELOCATION_CASHOUT_NOTE_BEFORE_TRACING_FOR_CLIENT)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_AFTER_RELOCATION_CASHOUT_NOTE_BEFORE_TRACING_ACTUALIZATION_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.FAILED_TO_VERIFY_DEFAULT_AFTER_RELOCATION_CASHOUT_NOTE_BEFORE_TRACING_ACTUALIZATION_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.FAIL, MobilityXConstants.RELOCATION_CASHOUT_NOTE_BEFORE_TRACING_FOR_CLIENT,
						CoreFunctions.getElementText(driver, _textAfterRelocationNote)));
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_NOTE_BEFORE_TRACING_ACTUALIZATION_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyInitialCashOutContentBeforeActTracing(boolean isBenefitsSubmitted) {
		try {
			getAvailableCashoutPoints(isBenefitsSubmitted);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_cashOutName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutName),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutSuggestion),
					MobilityXConstants.PORTION_AFTERRELOCATION_CASHOUT_SUGGESTION_TEXT,
					MobilityXConstants.CASHOUT_SUGGESTION);
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
			if (CoreFunctions.isElementExist(driver, _buttonDisabledSelectThisCashoutPoints, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public String getTracingSetSelection(List<Map<String, String>> dataMap) {
		String tracingSetSelection = null;
		int counter = 0;
		try {
			while (counter < dataMap.size()) {
				if (dataMap.get(counter).get("Tracing Set")
						.equals(CoreFunctions.getPropertyFromConfig("Policy_TracingSet"))) {
					tracingSetSelection = dataMap.get(counter).get("Tracing");
					break;
				} else {
					counter++;
				}
			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_FETCHING_TRACING_SET_SELECTION,
							CoreConstants.FAIL, e.getMessage()));
		}
		return tracingSetSelection;
	}

	public boolean verifyCashoutDetailsOnBSTBeforeAuthFormSubmission() {
		boolean isCashoutDetailsVerified = false, flag = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isCashoutDetailsVerified = verifyInitialCashOutContentBeforeAuthFormSubmission(false);
				flag = true;
			} else if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.PORTION_CASHOUT))) {
				isCashoutDetailsVerified = true;
				flag = false;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isCashoutDetailsVerified & flag) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.PASS));
		}
		return isCashoutDetailsVerified;
	}

	public boolean verifyInitialCashOutContentBeforeAuthFormSubmission(boolean isBenefitsSubmitted) {
		try {
			getAvailableCashoutPoints(isBenefitsSubmitted);
			CoreFunctions.explicitWaitTillElementVisibility(driver, _text_cashOutName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutName),
					policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
					MobilityXConstants.CUSTOM_CASHOUT_NAME);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _text_cashOutSuggestion),
					MobilityXConstants.PORTION_AFTERRELOCATION_CASHOUT_SUGGESTION_TEXT,
					MobilityXConstants.CASHOUT_SUGGESTION);
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
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DEFAULT_AFTER_RELOCATION_CASHOUT_DETAILS_ON_BENEFIT_SELECTION_TOOL_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyCashoutNoteNotDisplayedOnBST() {
		try {
			if (CoreFunctions.isElementExist(driver, _textAfterRelocationNote, 2)) {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.AFTER_RELOCATION_CASHOUT_NOTE_DISPLAYED_ON_BENEFIT_SELECTION_TOOL_PAGE_AFTER_ACTUALIZING_TRACING,
						CoreConstants.FAIL));
				return false;
			} else {
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.AFTER_RELOCATION_CASHOUT_NOTE_NOT_DISPLAYED_ON_BENEFIT_SELECTION_TOOL_PAGE_AFTER_ACTUALIZING_TRACING,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_AFTER_RELOCATION_CASHOUT_NOTE_NOT_DISPLAYED_ON_BENEFIT_SELECTION_TOOL_PAGE_AFTER_ACTUALIZING_TRACING,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

}
