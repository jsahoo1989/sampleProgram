package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

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
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
import com.aires.utilities.EmailUtil;
import com.vimalselvam.cucumber.listener.Reporter;

public class TransfereeSubmissions_DetailsPage extends Base {

	public TransfereeSubmissions_DetailsPage(WebDriver driver) {
		super(driver);
	}

	/********************* Page Objects ************************************/

	// User name
	@FindBy(how = How.CSS, using = "a.nav-link.nav_username")
	private WebElement _userName;

	// Transferee Submissions Logo Title
	@FindBy(how = How.CSS, using = "div[class='logo-title'] > a[class='simple-text']")
	private WebElement _txtApplicationTitle;

	// Progress Bar
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'loading-foreground')] | //div[contains(@class,'foreground-closing')]")
	private WebElement _progressBar;

	// Back to Transferee List Link
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Back to Transferees List')] ")
	private WebElement _linkBackToTransfereeList;

	// Transferee Name
	@FindBy(how = How.CSS, using = "span[class='transfereeName']")
	private WebElement _textTransfereeName;

	// Corporation Name
	@FindBy(how = How.XPATH, using = "//span[@class='transfereeName']//following-sibling::span[@class='normalText']")
	private WebElement _textCorporationName;

	// Points Balance
	@FindBy(how = How.CSS, using = "span[class='Points-Spent']")
	private WebElement _textPointsBalance;

	// Total Points List
	@FindBy(how = How.CSS, using = "span[class='TotalPoints']")
	private WebElement _textTotalPoints;

	// Points Spent
	@FindBy(how = How.CSS, using = "span[class*='points_spent']")
	private WebElement _textPointsSpent;

	// Submitted Benefit List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'column-Benefit')]/span[not(contains(@class,'ng-star-inserted'))]")
	private List<WebElement> _submittedBenefitNameList;

	// Submitted Benefit Allowance Amount List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'column-Benefit')]/span[contains(@class,'ng-star-inserted')][contains(@class,'BlackText')]")
	private List<WebElement> _submittedBenefitAllowanceAmountList;

	// Submitted Benefit Points List
	@FindBy(how = How.XPATH, using = "//mat-cell[contains(@class,'column-Points')]//span[contains(@class,'ng-star-inserted')] | //mat-cell//span[@class='mat-checkbox-label']")
	private List<WebElement> _submittedBenefitPointsList;

	// Submitted Benefit Request Sent Date List
	@FindBy(how = How.CSS, using = "mat-cell[class*='RequestSubmit']")
	private List<WebElement> _submittedBenefitRequestedSentDateList;

	// Submitted Benefit Status List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'Status')]/span/span")
	private List<WebElement> _submittedBenefitStatusList;

	// Submitted Benefit Show Comments List
	@FindBy(how = How.XPATH, using = "//span[contains(text(),'Show Comments')]")
	private List<WebElement> _submittedBenefitShowCommentsList;

	// Submitted Benefit Quantity List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'mat-column-Quantity')]")
	private List<WebElement> _submittedBenefitQuantityList;

	// Expense Reimbursement Tracing Prompt Symbol List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//span[contains(@class,'GrayText ')]/preceding-sibling::img[contains(@class,'Warning')]")
	private List<WebElement> _reimbursementAllowanceTracingSymbolList;

	By tracingPromptIcon = By.xpath(".//preceding-sibling::img[contains(@class,'Warning')]");

	By allowanceAmountMessage = By
			.xpath(".//following-sibling::span[contains(@class,'ng-star-inserted')][contains(@class,'BlackText')]");

	By clientSubmissionIcon = By.xpath("./span/img[contains(@src,'Company_Selected_Benefit_Icon')]");

	// Expense Reimbursement Tracing Prompt List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//span[@style='display: block;']//span[contains(@class,'GrayText')]")
	private List<WebElement> _reimbursementAllowanceTracingList;

	// Comments Benefit List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'mat-column-Benefit')][not(contains(@style,'background-color'))]")
	private List<WebElement> _submittedBenefitComments;

	// Resolve Button
	@FindBy(how = How.CSS, using = "mat-cell[class*='resolveAlign']")
	private List<WebElement> _buttonResolveDeleteRequest;

	// Request Dialog Benefit List
	@FindBy(how = How.CSS, using = "td > div[class*=benefit-name]")
	private List<WebElement> _requestDialogBenefitNameList;

	// Request Dialog Allowance Amount List
	@FindBy(how = How.XPATH, using = "//td/div[contains(@class,'benefit-desc')] | //div[contains(@class,'benefit-desc')]")
	private List<WebElement> _requestDialogAllowanceAmountList;

	/// Request Dialog Points List
	@FindBy(how = How.XPATH, using = "//td[@class='description']/preceding-sibling::td")
	private List<WebElement> _requestDialogPointsList;

	// Request Dialog Request Sent Date List
	@FindBy(how = How.CSS, using = "td[class='req-date']")
	private List<WebElement> _requestDialogRequestedDateList;

	// Request Dialog Status List
	@FindBy(how = How.CSS, using = "td[class='open-req']")
	private List<WebElement> _requestDialogStatusList;

	// Request Dialog Status List
	@FindBy(how = How.CSS, using = "td[class='qty']")
	private List<WebElement> _requestDialogQuantityList;

	// Request Dialog Comment Box
	@FindBy(how = How.CSS, using = "textarea[class*='commentBox']")
	private WebElement _requestDialogCommentBox;

	// Request Dialog Approve Radio Button
	@FindBy(how = How.CSS, using = "div[class*='approve'] > div > label")
	private WebElement _requestDialogApproveRadioButton;

	// Request Dialog Deny Radio Button
	@FindBy(how = How.CSS, using = "div[class*='deny'] > div > label")
	private WebElement _requestDialogDenyRadioButton;

	// Request Dialog Confirm Button
	@FindBy(how = How.CSS, using = "button[class='btn confirm']")
	private WebElement _requestDialogConfirmButton;

	// Request Dialog Go Back Button
	@FindBy(how = How.CSS, using = "a[class='btn-link']")
	private WebElement _requestDialogGoBackButton;

	// Request Dialog Go Back Button
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'popup-heading')][contains(text(),'Requests')]")
	private WebElement _requestDialogHeading;

	// Request Dialog Go Back Button
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'alert-success')]//span")
	private WebElement _requestCompletedGrowlMessage;

	// Tracing text message
	@FindBy(how = How.XPATH, using = "//span[contains(@class,'deleteRequest')]/following-sibling::span[not(contains(@class,'points'))]")
	private WebElement _tracingTextMessage;

	// Check All Checkbox
	@FindBy(how = How.CSS, using = "mat-checkbox[id='mat-checkbox-1']")
	private WebElement _checkAllCheckbox;

	// Resolve Multiple
	@FindBy(how = How.XPATH, using = "//button[contains(text(),'Resolve Multiple')]")
	private WebElement _resolveMultipleButton;

	// Point Spent ToolTip Text
	@FindBy(how = How.CSS, using = "div[class*='popper'] > span[class*='pointTooltip']")
	private WebElement _tooltipSpentPoints;

	// Point Balance ToolTip Text
	@FindBy(how = How.CSS, using = "div[class*='popper'] > span[class*='greenColor']")
	private WebElement _tooltipBalancePoints;

	// Transferee History Section Header
	@FindBy(how = How.CSS, using = "app-transferee-history  a[class*='collapsed'] > span")
	private WebElement _transfereeHistorySectionHeader;

	// Transferee History - Benefit Name
	@FindBy(how = How.CSS, using = "app-transferee-history  mat-cell[class*='description'] > span[class*='BlackText'][style*='600']")
	private List<WebElement> _transfereeHistoryBenefitNameList;

	// Transferee History - Benefit Allowance Amount
	@FindBy(how = How.CSS, using = "app-transferee-history  mat-cell[class*='description'] > span[class*='BlackText'][style*='500']")
	private List<WebElement> _transfereeHistoryAllowanceAmountList;

	// Transferee History - Benefit Points
	@FindBy(how = How.CSS, using = "app-transferee-history  mat-cell[class*='column-Points'] > span")
	private List<WebElement> _transfereeHistoryBenefitPointsList;

	// Transferee History - Benefit Status
	@FindBy(how = How.CSS, using = "app-transferee-history  mat-cell[class*='column-Status'] > span > span")
	private List<WebElement> _transfereeHistoryBenefitStatusList;

	// Transferee History - Benefit Quantity
	@FindBy(how = How.CSS, using = "app-transferee-history  mat-cell[class*='column-Quantity']")
	private List<WebElement> _transfereeHistoryBenefitQuantityList;

	// Deny Request Dialog Request Comment Select List
	@FindBy(how = How.CSS, using = "mat-select[formcontrolname='reasonList']")
	private WebElement _denyRequestDialogCommentSelect;

	// Deny Request Dialog Request Comment Select List Options
	@FindBy(how = How.CSS, using = "span[class='mat-option-text']")
	private List<WebElement> _denyRequestDialogCommentSelectList;

	/**********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	static int benefitCount;
	static double deleteRequestTotalPoints;
	static boolean isDeleteRequestApproved;
	static String approvedDeleteRequestBenefitName;
	static boolean isDeleteRequestDenied;

	/**********************************************************************/

	/**
	 * Method to get Navigated Page Details.
	 * 
	 * @param pageName
	 * 
	 * @return
	 */
	public boolean verifiyPageNavigation(String pageName) {
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkBackToTransfereeList,
					COREFLEXConstants.BACK_TO_TRANSFEREES_LIST);
			CoreFunctions.highlightObject(driver, _linkBackToTransfereeList);
			return CoreFunctions.isElementExist(driver, _linkBackToTransfereeList, 10);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.FAIL, pageName, e.getMessage()));
		}
		return false;
	}

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.BACK_TO_TRANSFEREES_LIST:
				CoreFunctions.clickElement(driver, _linkBackToTransfereeList);
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				break;
			case COREFLEXConstants.RESOLVE:
				resolveDeleteRequestPending();
				break;
			case COREFLEXConstants.CHECK_ALL:
				CoreFunctions.clickElement(driver, _checkAllCheckbox);
				CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _resolveMultipleButton,
						COREFLEXConstants.RESOLVE_MULTIPLE);
				break;
			case COREFLEXConstants.RESOLVE_MULTIPLE:
				CoreFunctions.clickElement(driver, _resolveMultipleButton);
				CoreFunctions.explicitWaitTillElementVisibility(driver, _requestDialogHeading,
						COREFLEXConstants.REQUESTS_DIALOG);
				break;
			case COREFLEXConstants.APPROVE_REQUEST:
				CoreFunctions.clickElement(driver, _requestDialogApproveRadioButton);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.APPROVE_ALL:
				CoreFunctions.clickElement(driver, _requestDialogApproveRadioButton);
				CoreFunctions.clearAndSetText(driver, _requestDialogCommentBox,
						COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.DENY_REQUEST:
				CoreFunctions.clickElement(driver, _requestDialogDenyRadioButton);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.DENY_ALL:
				CoreFunctions.clickElement(driver, _requestDialogDenyRadioButton);
				CoreFunctions.clickElement(driver, _denyRequestDialogCommentSelect);
				CoreFunctions.selectItemInListByText(driver, _denyRequestDialogCommentSelectList,
						COREFLEXConstants.DENY_DIALOG_COMMENT_SELECTION);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.TRANSFEREE_HISTORY_SECTION:
				CoreFunctions.clickElement(driver, _transfereeHistorySectionHeader);
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

	public boolean verifyTransfereeAndPointsDetails() {
		try {
			isDeleteRequestDenied = false;
			isDeleteRequestApproved = false;
			Double availablePointsAfterSubmission = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))
					- Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")));
			CoreFunctions.verifyText(driver, _textTransfereeName,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					COREFLEXConstants.TRANSFEREE_NAME);
			CoreFunctions.verifyText(driver, _textCorporationName,
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"), COREFLEXConstants.CORPORATION_NAME);
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			CoreFunctions.verifyValue(Double.parseDouble(actualPointsSpent[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")),
					COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.highlightObject(driver, _textPointsSpent);
			CoreFunctions.verifyValue(driver, _textPointsBalance, availablePointsAfterSubmission,
					COREFLEXConstants.POINTS_BALANCE);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
			CoreFunctions.clickElement(driver, _textPointsBalance);
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			CoreFunctions
					.verifyText(driver, _tooltipSpentPoints,
							COREFLEXConstants.EXPECTED_POINT_SPENT_TOOLTIP_TEXT
									.replace("used_points",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))))
									.replace("total_points",
											CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
							COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			CoreFunctions.verifyText(driver, _tooltipBalancePoints,
					COREFLEXConstants.EXPECTED_POINT_BALANCE_TOOLTIP_TEXT.replace("remaining_points",
							format.format(Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))),
					COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.PASS));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints",
					String.valueOf(availablePointsAfterSubmission));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyPointBalancePostDeleteRequestAction(String action, String pageName) {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		try {
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			CoreFunctions.verifyValue(Double.parseDouble(actualPointsSpent[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")),
					COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.highlightObject(driver, _textPointsSpent);
			CoreFunctions.verifyValue(driver, _textPointsBalance,
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")),
					COREFLEXConstants.POINTS_BALANCE);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
			CoreFunctions.clickElement(driver, _textPointsBalance);
			CoreFunctions.verifyText(driver, _tooltipSpentPoints, COREFLEXConstants.EXPECTED_POINT_SPENT_TOOLTIP_TEXT
					.replace("used_points", CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints"))
					.replace("total_points", CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			CoreFunctions.verifyText(driver, _tooltipBalancePoints,
					COREFLEXConstants.EXPECTED_POINT_BALANCE_TOOLTIP_TEXT.replace("remaining_points",
							CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")),
					COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_POINTS_BALANCE_DETAILS_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.PASS, pageName));

			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifySubmittedBenefitsDetails() {
		boolean isSubmittedDetailsMatched = false;
		boolean isSubmittedBenefitStatusMatched = false;
		benefitCount = 0;
		try {
//			CoreFunctions.waitHandler(2);
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkBackToTransfereeList,
					COREFLEXConstants.BACK_TO_TRANSFEREES_LIST);
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				isSubmittedBenefitStatusMatched = verifyBenefitDetails(benefit, MobilityXConstants.TRANSFEREE);
				if (!isSubmittedBenefitStatusMatched)
					break;
			}
			isSubmittedDetailsMatched = isSubmittedBenefitStatusMatched
					&& verifySubmittedCashoutDetails(MobilityXConstants.TRANSFEREE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedDetailsMatched && (_submittedBenefitNameList.size() == benefitCount) && isDeleteRequestDenied) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE_POST_DENYING_DELETE_BENEFIT_REQUEST,
					CoreConstants.PASS));
			return true;
		} else if (isSubmittedDetailsMatched && (_submittedBenefitNameList.size() == benefitCount)
				&& !(isDeleteRequestDenied)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	private boolean verifySubmittedCashoutDetails(String submittedBy) {
		boolean isSubmittedPortionCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isSubmittedPortionCashoutDetailsVerified = iterateSubmittedBenefitListAndVerifyCashout(submittedBy);
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			} else {
				return false;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_CASHOUT_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedPortionCashoutDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_CASHOUT_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
		}
		return isSubmittedPortionCashoutDetailsVerified;
	}

	private boolean iterateSubmittedBenefitListAndVerifyCashout(String submittedBy) {
		boolean isClientSubmissionIconVerified = false;
		for (WebElement element : _submittedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _submittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				benefitCount += 1;
				CoreFunctions.verifyText(driver, _submittedBenefitNameList.get(indexCashout),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.SUBMITTED_CASHOUT_NAME);
				WebElement allowanceAmount = CoreFunctions.findSubElement(_submittedBenefitNameList.get(indexCashout),
						allowanceAmountMessage);
				CoreFunctions.verifyTextContains(CoreFunctions.getElementText(driver, allowanceAmount),
						submittedBy.equals(MobilityXConstants.CLIENT)
								? BusinessFunctions.getMXClientSubmissionsExpectedCashoutDescription()
								: BusinessFunctions.getExpectedCashoutDescriptionWithDecimalPrecesion(),
						COREFLEXConstants.CASHOUT_DESCRIPTION);
				CoreFunctions.verifyValue(
						Double.parseDouble(
								_submittedBenefitPointsList.get(indexCashout).getText().replace("pts", "").trim()),
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
						COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
				CoreFunctions.highlightObject(driver, _submittedBenefitPointsList.get(indexCashout));
				CoreFunctions.verifyText(driver, _submittedBenefitRequestedSentDateList.get(indexCashout),
						CoreFunctions.getPropertyFromConfig("CF_Benefit_SubmittedDate"), COREFLEXConstants.SUBMITTED_DATE);
				verifyCashoutStatus(indexCashout);
				if (submittedBy.equals(MobilityXConstants.CLIENT)) {
					isClientSubmissionIconVerified = (CoreFunctions.verifyElementPresentOnPage(CoreFunctions
							.findSubElement(_submittedBenefitNameList.get(indexCashout), clientSubmissionIcon),
							COREFLEXConstants.CLIENT_SUBMISSION_ICON));
					CoreFunctions.highlightObject(driver, CoreFunctions
							.findSubElement(_submittedBenefitNameList.get(indexCashout), clientSubmissionIcon));
					return isClientSubmissionIconVerified
							&& verifyExpenseAllowanceTracing("No", COREFLEXConstants.ALLOWANCE_CASHOUT, indexCashout);
				} else {
					return verifyExpenseAllowanceTracing("No", COREFLEXConstants.ALLOWANCE_CASHOUT, indexCashout);
				}
			}
		}
		return false;
	}

	private void verifyCashoutStatus(int indexCashout) {
		if (Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitDeletedFlag"))
				&& !(isDeleteRequestDenied)
				&& !(Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitUndoFlag")))) {
			CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(indexCashout),
					COREFLEXConstants.DELETE_REQUEST_PENDING, COREFLEXConstants.DELETE_REQUEST_PENDING_STATUS);
			CoreFunctions.verifyText(driver, _buttonResolveDeleteRequest.get(indexCashout), COREFLEXConstants.RESOLVE,
					COREFLEXConstants.DELETE_REQUEST_RESOLVE_BUTTON);
		} else {
			CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(indexCashout), COREFLEXConstants.SUBMITTED,
					COREFLEXConstants.SUBMITTED_BENEFIT_STATUS);
		}

	}

	private boolean verifyBenefitDetails(Benefit benefit, String submittedBy) {
		boolean isClientSubmissionIconVerified = false;
		try {
			if (benefit.getSelectBenefitOnFPTPage()) {
				int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _submittedBenefitNameList,
						benefit.getBenefitDisplayName());
				benefitCount += 1;
				CoreFunctions.verifyText(driver, _submittedBenefitNameList.get(index), benefit.getBenefitDisplayName(),
						COREFLEXConstants.SUBMITTED_BENEFIT_NAME);
				WebElement allowanceAmount = CoreFunctions.findSubElement(_submittedBenefitNameList.get(index),
						allowanceAmountMessage);
				CoreFunctions.verifyText(driver, allowanceAmount, benefit.getBenefitAmount(),
						COREFLEXConstants.SUBMITTED_BENEFIT_ALLOWANCE_AMOUNT);
				CoreFunctions.verifyValue(
						Double.parseDouble(_submittedBenefitPointsList.get(index).getText().replace("pts", "").trim()),
						(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
						COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
				CoreFunctions.highlightObject(driver, _submittedBenefitPointsList.get(index));
				verifyBenefitStatus(benefit, index);
				CoreFunctions.verifyText(driver, _submittedBenefitQuantityList.get(index),
						String.valueOf(benefit.getNumberOfBenefitSelected()),
						COREFLEXConstants.SUBMITTED_BENEFIT_SELECTED_QUANTITY);
				CoreFunctions.verifyText(driver, _submittedBenefitRequestedSentDateList.get(index),
						CoreFunctions.getPropertyFromConfig("CF_Benefit_SubmittedDate"), COREFLEXConstants.SUBMITTED_DATE);

				if (submittedBy.equals(MobilityXConstants.CLIENT)) {
					isClientSubmissionIconVerified = (CoreFunctions.verifyElementPresentOnPage(
							CoreFunctions.findSubElement(_submittedBenefitNameList.get(index), clientSubmissionIcon),
							COREFLEXConstants.CLIENT_SUBMISSION_ICON));
					CoreFunctions.highlightObject(driver,
							CoreFunctions.findSubElement(_submittedBenefitNameList.get(index), clientSubmissionIcon));
					return isClientSubmissionIconVerified && verifyExpenseAllowanceTracing(
							benefit.getAiresManagedService(), benefit.getPayments(), index);
				} else {
					return verifyExpenseAllowanceTracing(benefit.getAiresManagedService(), benefit.getPayments(),
							index);
				}
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private void verifyBenefitStatus(Benefit benefit, int index) {
		if (Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitDeletedFlag"))
				&& benefit.getDeleteBenefitOnMBBPage() && !(isDeleteRequestDenied)
				&& !(Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitUndoFlag")))) {
			CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(index),
					COREFLEXConstants.DELETE_REQUEST_PENDING, COREFLEXConstants.DELETE_REQUEST_PENDING_STATUS);
			CoreFunctions.verifyText(driver, _buttonResolveDeleteRequest.get(index), COREFLEXConstants.RESOLVE,
					COREFLEXConstants.DELETE_REQUEST_RESOLVE_BUTTON);
		} else {
			CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(index), COREFLEXConstants.SUBMITTED,
					COREFLEXConstants.SUBMITTED_BENEFIT_STATUS);
		}
	}

	private boolean verifyExpenseAllowanceTracing(String isAiresManagedService, String payments, int index) {
		try {
			if (isAiresManagedService.equals("Yes")) {
				CoreFunctions.verifyText(driver, _reimbursementAllowanceTracingList.get(index),
						COREFLEXConstants.AIRES_MANAGED_BENEFIT_TRACING,
						COREFLEXConstants.SUBMITTED_BENEFIT_TRACING_SET_MESSAGE);
				WebElement allowanceTracingIcon = CoreFunctions
						.findSubElement(_reimbursementAllowanceTracingList.get(index), tracingPromptIcon);
				CoreFunctions.highlightObject(driver, allowanceTracingIcon);
				return CoreFunctions.isElementExist(driver, allowanceTracingIcon, 2);
			} else if (isAiresManagedService.equals("No") && payments.equals(COREFLEXConstants.EXPENSE_REIMBURSEMENT)) {
				CoreFunctions.verifyText(driver, _reimbursementAllowanceTracingList.get(index),
						COREFLEXConstants.REIMBURSEMENT_TRACING,
						COREFLEXConstants.SUBMITTED_BENEFIT_TRACING_SET_MESSAGE);
				return true;
			} else if (isAiresManagedService.equals("No") && payments.equals(COREFLEXConstants.ALLOWANCE_CASHOUT)) {
				CoreFunctions.verifyText(driver, _reimbursementAllowanceTracingList.get(index),
						COREFLEXConstants.ALLOWANCE_TRACING, COREFLEXConstants.SUBMITTED_BENEFIT_TRACING_SET_MESSAGE);
				WebElement allowanceTracingIcon = CoreFunctions
						.findSubElement(_reimbursementAllowanceTracingList.get(index), tracingPromptIcon);
				CoreFunctions.highlightObject(driver, allowanceTracingIcon);
				CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _tracingTextMessage),
						COREFLEXConstants.TRACING_EXPECTED_MESSAGE);
				return CoreFunctions.isElementExist(driver, allowanceTracingIcon, 2);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private void resolveDeleteRequestPending() {
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _submittedBenefitNameList,
						benefit.getBenefitDisplayName());
				if (benefit.getDeleteBenefitOnMBBPage()) {
					CoreFunctions.verifyText(driver, _buttonResolveDeleteRequest.get(index), COREFLEXConstants.RESOLVE,
							COREFLEXConstants.DELETE_REQUEST_RESOLVE_BUTTON);
					CoreFunctions.clickElement(driver, _buttonResolveDeleteRequest.get(index));
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_RESOLVE_BUTTON_ON_SUBMISSION_DETAILS_PAGE,
							CoreConstants.PASS, benefit.getBenefitDisplayName()));
					break;
				}
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_RESOLVE_BUTTON_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
	}

	public boolean verifyBenefitDetailsOnRequestsDialog(String action) {
		try {
			deleteRequestTotalPoints = 0.0;
			return verifyBenefitDetails(action) && verifyCashoutDetails(COREFLEXConstants.TRANSFEREE);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyBenefitDetailsOnRequestsDialogClient(String action) {
		try {
			deleteRequestTotalPoints = 0.0;
			return verifyBenefitDetails(action) && verifyCashoutDetails(COREFLEXConstants.CLIENT);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCashoutDetails(String submittedBy) {
		boolean isCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isCashoutDetailsVerified = iterateRequestDialogListAndVerifyCashout(submittedBy);
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_CASHOUT_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isCashoutDetailsVerified) {
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestTotalPoints",
					String.valueOf(deleteRequestTotalPoints));
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_ON_REQUEST_DIALOG, CoreConstants.PASS));
		}
		return isCashoutDetailsVerified;
	}

	private boolean iterateRequestDialogListAndVerifyCashout(String submittedBy) {

		for (WebElement element : _requestDialogBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_requestDialogBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				CoreFunctions.verifyText(driver, _requestDialogBenefitNameList.get(indexCashout),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.SUBMITTED_CASHOUT_NAME);
				CoreFunctions.verifyTextContains(
						CoreFunctions.getElementText(driver, _requestDialogAllowanceAmountList.get(indexCashout)),
						submittedBy.equals(MobilityXConstants.CLIENT)
								? BusinessFunctions.getMXClientSubmissionsExpectedCashoutDescription()
								: BusinessFunctions.getExpectedCashoutDescriptionWithDecimalPrecesion(),
						COREFLEXConstants.SUBMITTED_CASHOUT_ALLOWANCE_AMOUNT);
				CoreFunctions.verifyValue(
						Double.parseDouble(
								_requestDialogPointsList.get(indexCashout).getText().replace("pts", "").trim()),
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
						COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
				deleteRequestTotalPoints += Double
						.parseDouble(_requestDialogPointsList.get(indexCashout).getText().replace("pts", "").trim());
				CoreFunctions.highlightObject(driver, _requestDialogPointsList.get(indexCashout));
				CoreFunctions.verifyText(driver, _requestDialogStatusList.get(indexCashout),
						COREFLEXConstants.DELETE_REQUEST_PENDING, COREFLEXConstants.DELETE_REQUEST_PENDING_STATUS);
				CoreFunctions.verifyText(driver, _requestDialogRequestedDateList.get(indexCashout),
						CoreFunctions.getPropertyFromConfig("CF_Benefit_SubmittedDate"), COREFLEXConstants.REQUEST_DATE);
				return true;
			}
		}
		return false;
	}

	private boolean verifyBenefitDetails(String action) {
		boolean isBenefitDetailsVerified = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _requestDialogBenefitNameList,
						benefit.getBenefitDisplayName());
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()
						&& CoreFunctions.getElementText(driver, _requestDialogBenefitNameList.get(index))
								.equals(benefit.getBenefitDisplayName())) {
					CoreFunctions.verifyText(driver, _requestDialogBenefitNameList.get(index),
							benefit.getBenefitDisplayName(), COREFLEXConstants.REQUEST_DIALOG_BENEFIT_NAME);
					CoreFunctions.verifyText(driver, _requestDialogAllowanceAmountList.get(index),
							benefit.getBenefitAmount(), COREFLEXConstants.REQUEST_DIALOG_BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyValue(
							Double.parseDouble(_requestDialogPointsList.get(index).getText().replace("pts", "").trim()),
							(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.REQUEST_DIALOG_BENEFIT_POINTS);
					deleteRequestTotalPoints += Double
							.parseDouble(_requestDialogPointsList.get(index).getText().replace("pts", "").trim());
					CoreFunctions.highlightObject(driver, _requestDialogPointsList.get(index));
					CoreFunctions.verifyText(driver, _requestDialogStatusList.get(index),
							COREFLEXConstants.DELETE_REQUEST_PENDING,
							COREFLEXConstants.REQUEST_DIALOG_DELETE_REQUEST_PENDING_STATUS);
					CoreFunctions.verifyText(driver, _requestDialogRequestedDateList.get(index),
							CoreFunctions.getPropertyFromConfig("CF_Benefit_SubmittedDate"), COREFLEXConstants.REQUEST_DATE);
					CoreFunctions.verifyText(driver, _requestDialogQuantityList.get(index),
							String.valueOf(benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.REQUEST_DIALOG_BENEFIT_SELECTED_QUANTITY);
					Reporter.addStepLog(MessageFormat.format(
							COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_REQUEST_BENEFITS_DETAILS_ON_REQUESTS_DIALOG,
							CoreConstants.PASS, benefit.getBenefitDisplayName()));
					approvedDeleteRequestBenefitName = benefit.getBenefitDisplayName();
					isBenefitDetailsVerified = true;
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isBenefitDetailsVerified) {
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestTotalPoints",
					String.valueOf(deleteRequestTotalPoints));
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFIT_DETAILS_ON_REQUEST_DIALOG, CoreConstants.PASS));
		}
		return isBenefitDetailsVerified;
	}

	public boolean verifyActionCompletedMessage(String actionPerformed, String pageName) {
		boolean isActionCompletedMessageVerified = false;
		try {
			if (actionPerformed.equals(COREFLEXConstants.APPROVE_REQUEST)) {
				isActionCompletedMessageVerified = verifyApprovedRequestActionCompletedMessage(pageName);
			} else if (actionPerformed.equals(COREFLEXConstants.DENY_REQUEST)) {
				isActionCompletedMessageVerified = verifyDenyRequestActionCompletedMessage(pageName);
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_GROWL_MESSAGE_AFTER_PERFORMING_DELETE_REQUEST_ACTION,
					CoreConstants.FAIL, e.getMessage(), pageName));
		}
		return isActionCompletedMessageVerified;
	}

	private boolean verifyDenyRequestActionCompletedMessage(String pageName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _requestCompletedGrowlMessage,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			CoreFunctions.verifyText(driver, _requestCompletedGrowlMessage, COREFLEXConstants.ACTION_COMPLETED_MESSAGE,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_DENY_GROWL_ACTION_COMPLETED_MESSAGE_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS, COREFLEXConstants.ACTION_COMPLETED_MESSAGE));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestDenied", "true");
			isDeleteRequestDenied = true;
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkBackToTransfereeList,
					COREFLEXConstants.BACK_TO_TRANSFEREES_LIST);
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_GROWL_MESSAGE_AFTER_DENYING_DELETE_REQUEST_ACTION,
					CoreConstants.FAIL, e.getMessage(), pageName));
		}
		return false;
	}

	private boolean verifyApprovedRequestActionCompletedMessage(String pageName) {
		try {
			Double totalPointsSelectedAfterDeleteApproval, availablePointsAfterDeleteApproval;
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);

			if (CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_PersonResponsible")
					.equals(MobilityXConstants.CLIENT_INITIATOR)) {
				CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalSelectedPoints",
						CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints"));
			}
			String expectedGrowlMessage = MobilityXConstants.DELETE_ACTION_COMPLETED.replace("approvedDeletedPoints",
					format.format(Double.parseDouble(
							CoreFunctions.getPropertyFromConfig("CF_Transferee_DeleteRequestTotalPoints"))));
			CoreFunctions.explicitWaitTillElementVisibility(driver, _requestCompletedGrowlMessage,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			CoreFunctions.verifyText(driver, _requestCompletedGrowlMessage, expectedGrowlMessage,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_APPROVED_GROWL_ACTION_COMPLETED_MESSAGE_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS, expectedGrowlMessage));
			totalPointsSelectedAfterDeleteApproval = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")))
					- (Double.parseDouble(
							CoreFunctions.getPropertyFromConfig("CF_Transferee_DeleteRequestTotalPoints")));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalSelectedPoints",
					String.valueOf(totalPointsSelectedAfterDeleteApproval));
			availablePointsAfterDeleteApproval = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))
					+ (Double.parseDouble(
							CoreFunctions.getPropertyFromConfig("CF_Transferee_DeleteRequestTotalPoints")));
			CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints",
					String.valueOf(availablePointsAfterDeleteApproval));
			isDeleteRequestApproved = true;
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeletedRequestApproved", "true");
			CoreFunctions.writeToPropertiesFile("CF_Client_TotalSelectedPoints",
					String.valueOf(totalPointsSelectedAfterDeleteApproval));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_GROWL_MESSAGE_AFTER_ARRPOVING_DELETE_REQUEST_ACTION,
					CoreConstants.FAIL, e.getMessage(), pageName));
		}
		return false;
	}

	public boolean verifyBenefitDeleteRequestEmail(String actionPerformed) {
		try {
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";

			switch (actionPerformed) {
			case COREFLEXConstants.APPROVE_REQUEST:
				return verifyDeleteRequestApprovedEmail(host, userName, pwd, expFromUserName);
			case COREFLEXConstants.DENY_REQUEST:
				return verifyDeleteRequestDeniedEmail(host, userName, pwd, expFromUserName);
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_CREDENTIALS_FROM_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	/**
	 * Method to verify Delete request Denied Email Contents -- EmailSubject,
	 * TransfereeName Requested Delete Operation, Benefits Name, Deny Request
	 * Comment added by MSPEC and Available/Total points
	 * 
	 * @param host
	 * @param userName
	 * @param pwd
	 * @param expFromUserName
	 * @return
	 */
	private boolean verifyDeleteRequestDeniedEmail(String host, String userName, String pwd, String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Benefit Delete Request has been Denied";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_DENIED);
			actualResultSubmissionDetails = removeHTMLTagsFromEmailContent(actualResultSubmissionDetails);
			if (verifyDeniedDeleteRequestEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITY_BENEFIT_DELETE_REQUEST_DENIED_EMAIL_CONTENTS,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_DENIED_DELETE_REQUEST_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private String removeHTMLTagsFromEmailContent(String actualResultSubmissionDetails) {
		return actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "").replace("\t", "")
				.replace("\r\n", "").replace("<br>", "").replace("<ul>", "").replace("<li>", "").replace("</ul>", "")
				.replace("<li style=\"word-break:break-all\">", "").replace("</li>", "").replace("</p>", "").trim();
	}

	private boolean verifyDeleteRequestApprovedEmail(String host, String userName, String pwd, String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Benefit Delete Request has been Approved";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_APPROVED);
			actualResultSubmissionDetails = removeHTMLTagsFromEmailContent(actualResultSubmissionDetails);
			if (verifyApprovedDeleteRequestEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITY_BENEFIT_DELETE_REQUEST_APPROVED_EMAIL_CONTENTS,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_APPROVED_DELETE_REQUEST_EMAIL, CoreConstants.FAIL,
					e.getMessage()));
		}
		return false;
	}

	private boolean verifyApprovedDeleteRequestEmailContents(String actualResultSubmissionDetails) {
		String emailContent[] = actualResultSubmissionDetails.split(",");
		String actualUserName = emailContent[0];
		String actualEmailContentBenefitDetails = emailContent[1];
		CoreFunctions.verifyText(actualUserName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails, getExpectedDeleteApprovedBenefitPointText(),
				MobilityXConstants.APPROVED_DELETE_REQUEST_REMAINING_POINTS_TO_USE);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails, COREFLEXConstants.REQUESTS_DIALOG_COMMENT,
				MobilityXConstants.APPROVE_DIALOG_COMMENT);
		verifyDeniedApprovedDeleteRequestEmailBenefits(actualEmailContentBenefitDetails);
		return true;

	}

	private String getExpectedDeleteApprovedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.APPROVE_DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE
				.replace("current_balance",
						format.format(Double
								.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))
				.replace("total_points", format.format(
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))));
	}

	public boolean verifyApprovedDeleteRequestRemovedFromList() {
		boolean isBenefitRemovedFromList = false;
		try {
			CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _linkBackToTransfereeList,
					COREFLEXConstants.BACK_TO_TRANSFEREES_LIST);
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
					int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _submittedBenefitNameList,
							benefit.getBenefitDisplayName());
					if (index == -1) {
						isBenefitRemovedFromList = true;
						continue;
					} else {
						isBenefitRemovedFromList = false;
						break;
					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_BENEFIT_REQUEST_REMOVED_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		Reporter.addStepLog(MessageFormat.format(
				COREFLEXConstants.SUCCESSFULLY_REMOVED_APPROVED_DELETE_BENEFIT_REQUEST_FROM_TRANSFEREE_SUBMISSIONS_DETAILS_LIST,
				CoreConstants.PASS));
		return isBenefitRemovedFromList;
	}

	private boolean verifyDeniedDeleteRequestEmailContents(String actualResultSubmissionDetails) {
		String emailContent[] = actualResultSubmissionDetails.split(",");
		String actualUserName = emailContent[0];
		String actualEmailContentBenefitDetails = emailContent[1];
		CoreFunctions.verifyText(actualUserName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				getExpectedRemainingPointsToUseTextPostDeniedRequest(),
				MobilityXConstants.DENIED_DELETE_REQUEST_REMAINING_POINTS_TO_USE);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				COREFLEXConstants.DENY_DIALOG_COMMENT_SELECTION, MobilityXConstants.DENY_DIALOG_COMMENT);
		verifyDeniedApprovedDeleteRequestEmailBenefits(actualEmailContentBenefitDetails);
		return true;
	}

	private void verifyDeniedApprovedDeleteRequestEmailBenefits(String actualEmailContentBenefitDetails) {
		for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
				CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
			if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()) {
				CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails, benefit.getBenefitDisplayName(),
						MobilityXConstants.DELETE_REQUEST_BENEFIT);
			}
		}
	}

	private String getExpectedRemainingPointsToUseTextPostDeniedRequest() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DENIED_DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE
				.replace("current_balance",
						format.format(Double
								.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))
				.replace("total_points", format.format(
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))));
	}

	public boolean verifyRequestsDialogDisplayed() {
		try {
			return CoreFunctions.isElementExist(driver, _requestDialogHeading, 5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_REQUEST_DIALOG_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	private List<Benefit> getBenefits(String policyType, String policyRequiredFor) {
		List<Benefit> benefitNameList = new ArrayList<Benefit>();
		if (policyType.equals(COREFLEXConstants.FLEX) || policyType.equals(COREFLEXConstants.BOTH)) {
			for (FlexBenefit benefit : flexBenefits) {
				for (Benefit ben : benefit.getBenefits()) {
					if (ben.getPolicyCreationGroup().contains(policyRequiredFor)) {
						benefitNameList.add(ben);
					} 
				}
			}
		}
		return benefitNameList;
	}

	public boolean verifyClientAndPointsDetails() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		try {
			isDeleteRequestDenied = false;
			isDeleteRequestApproved = false;
			CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestDenied", "false");
			CoreFunctions.writeToPropertiesFile("CF_Client_DeleteRequestApproved", "false");
			CoreFunctions.writeToPropertiesFile("CF_Client_UndoDeleteBenefit", "false");
			Double availablePointsAfterSubmission = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))
					- Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")));

			CoreFunctions.verifyText(driver, _textTransfereeName,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					COREFLEXConstants.TRANSFEREE_NAME);
			CoreFunctions.verifyText(driver, _textCorporationName,
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"), COREFLEXConstants.CORPORATION_NAME);
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			CoreFunctions.verifyValue(Double.parseDouble(actualPointsSpent[0].trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints")),
					COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.highlightObject(driver, _textPointsSpent);
			CoreFunctions.verifyValue(driver, _textPointsBalance, availablePointsAfterSubmission,
					COREFLEXConstants.POINTS_BALANCE);
			CoreFunctions.writeToPropertiesFile("CF_Transferee_AvailablePoints",
					String.valueOf(availablePointsAfterSubmission));
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_DETAILS_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
			CoreFunctions.clickElement(driver, _textPointsBalance);

			CoreFunctions
					.verifyText(driver, _tooltipSpentPoints,
							COREFLEXConstants.EXPECTED_POINT_SPENT_TOOLTIP_TEXT
									.replace("used_points",
											format.format(Double.parseDouble(CoreFunctions
													.getPropertyFromConfig("CF_Client_TotalSelectedPoints"))))
									.replace("total_points",
											CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
							COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			CoreFunctions.verifyText(driver, _tooltipBalancePoints,
					COREFLEXConstants.EXPECTED_POINT_BALANCE_TOOLTIP_TEXT.replace("remaining_points",
							format.format(Double.parseDouble(
									CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints")))),
					COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SPENT_REMAINING_AND_TOTAL_POINTS_DETAILS_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_POINTS_DETAILS_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifySubmittedBenefitsCashoutDetailsByClient() {
		boolean isSubmittedDetailsMatched = false;
		boolean isSubmittedBenefitStatusMatched = false;
		benefitCount = 0;
		try {
//			CoreFunctions.waitHandler(3);
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				isSubmittedBenefitStatusMatched = verifyBenefitDetails(benefit, MobilityXConstants.CLIENT);
				if (!isSubmittedBenefitStatusMatched)
					break;
			}
			isSubmittedDetailsMatched = isSubmittedBenefitStatusMatched
					&& verifySubmittedCashoutDetails(MobilityXConstants.CLIENT);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedDetailsMatched && (_submittedBenefitNameList.size() == benefitCount) && isDeleteRequestDenied) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE_POST_DENYING_DELETE_BENEFIT_REQUEST,
					CoreConstants.PASS));
			return true;
		} else if (isSubmittedDetailsMatched && (_submittedBenefitNameList.size() == benefitCount)
				&& !(isDeleteRequestDenied)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	public boolean verifyTransfereeHistorySection(String action) {
		try {
			return verifyBenefitDetailsInHistorySection(action) && verifyCashoutDetailInHistorySection(action);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyBenefitDetailsInHistorySection(String action) {
		boolean isBenefitHistoryDetailsVerified = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"))) {
				int index = BusinessFunctions.returnindexItemFromListUsingTextWithoutHighlight(driver,
						_transfereeHistoryBenefitNameList, benefit.getBenefitDisplayName());
				if (benefit.getSelectBenefitOnFPTPage() && benefit.getDeleteBenefitOnMBBPage()
						&& (_transfereeHistoryBenefitNameList.get(index).getText())
								.equals(benefit.getBenefitDisplayName())) {
					CoreFunctions.verifyText(_transfereeHistoryBenefitNameList.get(index).getText(),
							benefit.getBenefitDisplayName(),
							COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_BENEFIT_NAME);
					CoreFunctions.verifyText(_transfereeHistoryAllowanceAmountList.get(index).getText(),
							benefit.getBenefitAmount(),
							COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyValue(
							Double.parseDouble(
									_transfereeHistoryBenefitPointsList.get(index).getText().replace("pts", "").trim()),
							(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_BENEFIT_POINTS);
					CoreFunctions.verifyText(_transfereeHistoryBenefitStatusList.get(index).getText(),
							action.equalsIgnoreCase(COREFLEXConstants.APPROVED) ? COREFLEXConstants.DELETED
									: COREFLEXConstants.REQUEST_DENIED,
							COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_DELETE_REQUEST_STATUS);
					CoreFunctions.verifyText(_transfereeHistoryBenefitQuantityList.get(index).getText(),
							String.valueOf(benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_BENEFIT_SELECTED_QUANTITY);
					isBenefitHistoryDetailsVerified = true;
				} else {
					continue;
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_BENEFIT_DETAILS_DISPLAYED_UNDER_HISTORY_SECTION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isBenefitHistoryDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_BENEFIT_DETAILS_DISPLAYED_UNDER_HISTORY_SECTION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.PASS));
		}
		return isBenefitHistoryDetailsVerified;
	}

	private boolean verifyCashoutDetailInHistorySection(String action) {
		boolean isCashoutHistoryDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isCashoutHistoryDetailsVerified = iterateHistorySectionListAndVerifyCashout(action);
			} else if (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
					.equals(MobilityXConstants.CASHOUT_NOT_AUTHORIZED)) {
				return true;
			} else {
				return false;
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_CASHOUT_DETAILS_DISPLAYED_UNDER_HISTORY_SECTION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		if (isCashoutHistoryDetailsVerified) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_CASHOUT_DETAILS_DISPLAYED_UNDER_HISTORY_SECTION_ON_TRANSFEREE_SUBMISSIONS_DETAILS_PAGE,
					CoreConstants.PASS));
		}
		return isCashoutHistoryDetailsVerified;
	}

	private boolean iterateHistorySectionListAndVerifyCashout(String action) {
		for (WebElement element : _transfereeHistoryBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingTextWithoutHighlight(driver,
						_transfereeHistoryBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				CoreFunctions.verifyText(_transfereeHistoryBenefitNameList.get(indexCashout).getText(),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_CASHOUT_NAME);
				CoreFunctions.verifyTextContains((_transfereeHistoryAllowanceAmountList.get(indexCashout).getText()),
						BusinessFunctions.getExpectedCashoutDescriptionWithDecimalPrecesion(),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_CASHOUT_DESCRIPTION);
				CoreFunctions.verifyValue(
						Double.parseDouble(_transfereeHistoryBenefitPointsList.get(indexCashout).getText()
								.replace("pts", "").trim()),
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_CASHOUT_POINTS);
				CoreFunctions.verifyText(_transfereeHistoryBenefitStatusList.get(indexCashout).getText(),
						action.equalsIgnoreCase(COREFLEXConstants.APPROVED) ? COREFLEXConstants.DELETED
								: COREFLEXConstants.REQUEST_DENIED,
						COREFLEXConstants.TRANSFEREE_SUBMISSIONS_HISTORY_DELETE_REQUEST_STATUS);
				return true;
			}
		}
		return false;
	}

	public boolean verifyBenefitDeleteRequestEmailClient(String actionPerformed) {
		try {
			String host = "outlook.office365.com";
			// Enter Your Email ID
			String userName = "airesautomation@aires.com";
			// Enter your email outlook password
			String pwd = CoreConstants.AUTO_EMAIL_PWD;
			// Enter expected From complete email address
			String expFromUserName = "testrelonet@aires.com";

			switch (actionPerformed) {
			case COREFLEXConstants.APPROVE_REQUEST:
				return verifyDeleteRequestApprovedEmailClient(host, userName, pwd, expFromUserName);
			case COREFLEXConstants.DENY_REQUEST:
				return verifyDeleteRequestDeniedEmailClient(host, userName, pwd, expFromUserName);
			default:
				Assert.fail(COREFLEXConstants.INVALID_OPTION);

			}

		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_CREDENTIALS_FROM_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyDeleteRequestApprovedEmailClient(String host, String userName, String pwd,
			String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Benefit Delete Request has been Approved";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_APPROVED);
			actualResultSubmissionDetails = removeHTMLTagsFromEmailContent(actualResultSubmissionDetails);
			if (verifyApprovedDeleteRequestClientEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITY_BENEFIT_DELETE_REQUEST_APPROVED_EMAIL_CONTENTS,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_APPROVED_DELETE_REQUEST_EMAIL, CoreConstants.FAIL,
					e.getMessage()));
		}
		return false;
	}

	private boolean verifyApprovedDeleteRequestClientEmailContents(String actualResultSubmissionDetails) {
		CoreFlex_LoginInfo _loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginInfoByEnviroment((CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
		String emailContent[] = actualResultSubmissionDetails.split(",");
		String actualUserName = emailContent[0];
		String actualEmailContentBenefitDetails = emailContent[1];
		CoreFunctions.verifyText(actualUserName, (_loginInfo.details.mxClientUserProfileName).split(" ")[0]);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				COREFLEXConstants.APPROVED_DELETE_REQUEST_EXPECTED_TEXT
						.replace("TransfereeFN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
						.replace("TransfereeLN", CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
				MobilityXConstants.APPROVED_DELETE_REQUEST_TEXT);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				getExpectedClientDeleteApprovedBenefitPointText(),
				MobilityXConstants.APPROVED_DELETE_REQUEST_REMAINING_POINTS_TO_USE);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails, COREFLEXConstants.REQUESTS_DIALOG_COMMENT,
				MobilityXConstants.APPROVE_DIALOG_COMMENT);
		verifyDeniedApprovedDeleteRequestEmailBenefits(actualEmailContentBenefitDetails);
		return true;
	}

	private String getExpectedClientDeleteApprovedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.APPROVE_DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE_CLIENT
				.replace("current_balance",
						format.format(Double
								.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))
				.replace("total_points",
						format.format(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))))
				.replace("TransfereeFN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
				.replace("TransfereeLN", CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
	}

	/**
	 * Method to verify Delete request Denied Email Client Contents -- EmailSubject,
	 * TransfereeName Requested Delete Operation, Benefits Name, Deny Request
	 * Comment added by MSPEC and Available/Total points
	 * 
	 * @param host
	 * @param userName
	 * @param pwd
	 * @param expFromUserName
	 * @return
	 */
	private boolean verifyDeleteRequestDeniedEmailClient(String host, String userName, String pwd,
			String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Benefit Delete Request has been Denied";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_DENIED);
			actualResultSubmissionDetails = removeHTMLTagsFromEmailContent(actualResultSubmissionDetails);
			if (verifyDeniedDeleteRequestClientEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_MOBILITY_BENEFIT_DELETE_REQUEST_DENIED_EMAIL_CONTENTS,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_DENIED_DELETE_REQUEST_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyDeniedDeleteRequestClientEmailContents(String actualResultSubmissionDetails) {
		CoreFlex_LoginInfo _loginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
				.getLoginInfoByEnviroment((CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));
		String emailContent[] = actualResultSubmissionDetails.split(",");
		String actualUserName = emailContent[0];
		String actualEmailContentBenefitDetails = emailContent[1];
		CoreFunctions.verifyText(actualUserName, (_loginInfo.details.mxClientUserProfileName).split(" ")[0]);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				COREFLEXConstants.DENIED_DELETE_REQUEST_EXPECTED_TEXT
						.replace("TransfereeFN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
						.replace("TransfereeLN", CoreFunctions.getPropertyFromConfig("Transferee_lastName")),
				MobilityXConstants.DENIED_DELETE_REQUEST_TEXT);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				getExpectedClientDeleteDeniedBenefitPointText(),
				MobilityXConstants.DENIED_DELETE_REQUEST_REMAINING_POINTS_TO_USE);
		CoreFunctions.verifyTextContains(actualEmailContentBenefitDetails,
				COREFLEXConstants.DENY_DIALOG_COMMENT_SELECTION, MobilityXConstants.DENY_DIALOG_COMMENT);
		verifyDeniedApprovedDeleteRequestEmailBenefits(actualEmailContentBenefitDetails);
		return true;
	}

	private String getExpectedClientDeleteDeniedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DENIED_DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE_CLIENT
				.replace("current_balance",
						format.format(Double
								.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_AvailablePoints"))))
				.replace("total_points",
						format.format(Double.parseDouble(
								CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))))
				.replace("TransfereeFN", CoreFunctions.getPropertyFromConfig("Transferee_firstName"))
				.replace("TransfereeLN", CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
	}
}
