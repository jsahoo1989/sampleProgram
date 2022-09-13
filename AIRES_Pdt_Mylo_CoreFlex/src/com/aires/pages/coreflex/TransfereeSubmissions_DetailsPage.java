package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
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
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
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

	// Expense Reimbursement Tracing Prompt List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//span[contains(@class,'GrayText')][not(contains(text(),'will be sent to the address provided'))]")
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
	@FindBy(how = How.CSS, using = "td > div[class*=benefit-desc]")
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
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.DENY_REQUEST:
				CoreFunctions.clickElement(driver, _requestDialogDenyRadioButton);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
				break;
			case COREFLEXConstants.DENY_ALL:
				CoreFunctions.clickElement(driver, _requestDialogDenyRadioButton);
				CoreFunctions.clickElement(driver, _requestDialogConfirmButton);
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
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestDenied", "false");
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestApproved", "false");
			CoreFunctions.writeToPropertiesFile("CF_Transferee_UndoDeleteBenefit", "false");
			Double availablePointsAfterSubmission = (Double
					.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints"))
					- Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalSelectedPoints")));
			MX_Transferee_MyBenefitsBundlePage.undoDeletedBenefitFlag = false;
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
		try {
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			CoreFunctions.verifyValue(Double.parseDouble(actualPointsSpent[0].trim()),
					MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints, COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.highlightObject(driver, _textPointsSpent);
			CoreFunctions.verifyValue(driver, _textPointsBalance,
					MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission,
					COREFLEXConstants.POINTS_BALANCE);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
			CoreFunctions.clickElement(driver, _textPointsBalance);
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			CoreFunctions.verifyText(driver, _tooltipSpentPoints, COREFLEXConstants.EXPECTED_POINT_SPENT_TOOLTIP_TEXT
					.replace("used_points", format.format(MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints))
					.replace("total_points", CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.POINTS_BALANCE_TOOLTIP_TEXT);
			CoreFunctions.verifyText(driver, _tooltipBalancePoints,
					COREFLEXConstants.EXPECTED_POINT_BALANCE_TOOLTIP_TEXT.replace("remaining_points",
							format.format(MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission)),
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
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
				isSubmittedBenefitStatusMatched = verifyBenefitDetails(benefit);
				if (!isSubmittedBenefitStatusMatched)
					break;
			}
			isSubmittedDetailsMatched = isSubmittedBenefitStatusMatched && verifySubmittedCashoutDetails();
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

	private boolean verifySubmittedCashoutDetails() {
		boolean isSubmittedPortionCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isSubmittedPortionCashoutDetailsVerified = iterateSubmittedBenefitListAndVerifyCashout();
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

	private boolean iterateSubmittedBenefitListAndVerifyCashout() {
		for (WebElement element : _submittedBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver, _submittedBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				benefitCount += 1;
				CoreFunctions.verifyText(driver, _submittedBenefitNameList.get(indexCashout),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.SUBMITTED_CASHOUT_NAME);
				CoreFunctions.verifyValue(
						Double.parseDouble(
								_submittedBenefitPointsList.get(indexCashout).getText().replace("pts", "").trim()),
						Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_SelectedCashOutPoints")),
						COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
				CoreFunctions.highlightObject(driver, _submittedBenefitPointsList.get(indexCashout));
				CoreFunctions.verifyText(driver, _submittedBenefitRequestedSentDateList.get(indexCashout),
						CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), COREFLEXConstants.SUBMITTED_DATE);
				verifyCashoutStatus(indexCashout);
				if (verifyExpenseAllowanceTracing("No", COREFLEXConstants.ALLOWANCE_CASHOUT, indexCashout)) {
					return true;
				} else {
					return false;
				}
			}
		}
		return false;
	}

	private void verifyCashoutStatus(int indexCashout) {
		if (Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitDeleteFlag"))
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

	private String getCashoutAllowanceAmountText() {
		DecimalFormat format = new DecimalFormat();
		format.setMinimumFractionDigits(2);
		String reimAccountType[] = MX_Transferee_FlexPlanningTool_Page.getReimAccountType().split("-");
		String currency[] = reimAccountType[1].split("\\(");
		return (COREFLEXConstants.TRANSFEREE_CASHOUT_ALLOWANCE_TEXT).replace("currency", currency[0].trim())
				.replace("cashout_value", format.format(MX_Transferee_FlexPlanningTool_Page.selectedCashoutPoints))
				.replace("reim_type", reimAccountType[0].trim());
	}

	private boolean verifyBenefitDetails(Benefit benefit) {
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
						CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), COREFLEXConstants.SUBMITTED_DATE);
				if (verifyExpenseAllowanceTracing(benefit.getAiresManagedService(), benefit.getPayments(), index)) {
					return true;
				} else {
					return false;
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
		if (Boolean.valueOf(CoreFunctions.getPropertyFromConfig("CF_Transferee_BenefitDeleteFlag"))
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
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
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

	public boolean verifyBenefitDetailsOnRequestsDialog() {
		try {
			return verifyBenefitDetails() && verifyCashoutDetails();
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyCashoutDetails() {
		boolean isCashoutDetailsVerified = false;
		try {
			if ((CoreFunctions.getPropertyFromConfig("PolicyCashoutType").equals(MobilityXConstants.PORTION_CASHOUT))
					|| (CoreFunctions.getPropertyFromConfig("PolicyCashoutType")
							.equals(MobilityXConstants.AFTER_RELOCATION_ONLY))) {
				isCashoutDetailsVerified = iterateRequestDialogListAndVerifyCashout();
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

	private boolean iterateRequestDialogListAndVerifyCashout() {
		for (WebElement element : _requestDialogBenefitNameList) {
			if (element.getText().equals(policySetupPageData.flexPolicySetupPage.customCashoutBenefitName)) {
				int indexCashout = BusinessFunctions.returnindexItemFromListUsingText(driver,
						_requestDialogBenefitNameList,
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName);
				CoreFunctions.verifyText(driver, _requestDialogBenefitNameList.get(indexCashout),
						policySetupPageData.flexPolicySetupPage.customCashoutBenefitName,
						COREFLEXConstants.SUBMITTED_CASHOUT_NAME);
//				CoreFunctions.verifyText(driver, _requestDialogAllowanceAmountList.get(indexCashout),
//						getCashoutAllowanceAmountText(), COREFLEXConstants.SUBMITTED_CASHOUT_ALLOWANCE_AMOUNT);
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
						CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), COREFLEXConstants.REQUEST_DATE);
				return true;
			}
		}
		return false;
	}

	private boolean verifyBenefitDetails() {
		boolean isBenefitDetailsVerified = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
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
							CoreFunctions.getCurrentDateAsGivenFormat("dd-MMM-yyyy"), COREFLEXConstants.REQUEST_DATE);
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
			CoreFunctions.clearAndSetText(driver, _requestDialogCommentBox, COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
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
			CoreFunctions.writeToPropertiesFile("CF_Transferee_TotalSelectedPoints",
					CoreFunctions.getPropertyFromConfig("CF_Client_TotalSelectedPoints"));
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
			CoreFunctions.writeToPropertiesFile("CF_Transferee_DeleteRequestApproved", "true");
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
			// Reading Transferee Username and Password from email and writing to the Config
			// Properties File
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

	private boolean verifyDeleteRequestDeniedEmail(String host, String userName, String pwd, String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Flex Benefit Delete Request has been Denied";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_DENIED);
			actualResultSubmissionDetails = actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "")
					.replace("\t", "").replace("\r\n", "").replace("<br>", "").trim();
			if (verifyDeniedDeleteRequestEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified 'Mobility Flex Benefit Delete Request has been Approved' Email.");
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_APPROVED_DELETE_REQUEST_EMAIL, CoreConstants.FAIL,
					e.getMessage()));
		}
		return false;
	}

	private boolean verifyDeleteRequestApprovedEmail(String host, String userName, String pwd, String expFromUserName) {
		try {
			// Enter expected email subject
			String expEmailSubject = "Mobility Flex Benefit Delete Request has been Approved";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_APPROVED);
			actualResultSubmissionDetails = actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "")
					.replace("\t", "").replace("\r\n", "").replace("<br>", "").trim();
			if (verifyApprovedDeleteRequestEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified 'Mobility Flex Benefit Delete Request has been Approved' Email.");
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
		String actualEmailContentBenefitDetails[] = emailContent[1].split("</ul>");
		String deleteApprovedBenefitPointDetails[] = actualEmailContentBenefitDetails[0].replace("<ul>", "")
				.replace("<li>", "").replace("</ul>", "").split("</li>");
		String actualDeleteApprovedBenefitPointText = deleteApprovedBenefitPointDetails[0].trim();
		String actualDeleteCommentText = deleteApprovedBenefitPointDetails[1].replace("</li>", "").trim();
		String actualRemainingPointsText = actualEmailContentBenefitDetails[2].trim();
		CoreFunctions.verifyText(actualUserName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
		CoreFunctions.verifyText(actualDeleteApprovedBenefitPointText, getExpectedDeleteApprovedBenefitPointText());
		CoreFunctions.verifyText(actualDeleteCommentText, COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
		CoreFunctions.verifyText(actualRemainingPointsText, getExpectedRemainingPointsToUseText());
		return true;
	}

	private String getExpectedDeleteApprovedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DELETE_REQUEST_APPROVED_BENEFIT_POINT_MESSAGE
				.replace("benefit_name", approvedDeleteRequestBenefitName)
				.replace("delete_request_points", String.valueOf(format.format(deleteRequestTotalPoints)));
	}

	private String getExpectedRemainingPointsToUseText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE.replace("current_balance",
				String.valueOf(format.format(MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission)));
	}

	public boolean verifyApprovedDeleteRequestRemovedFromList() {
		boolean isBenefitRemovedFromList = false;
		try {
			for (Benefit benefit : getBenefits(CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_BenefitType"),
					CoreFunctions.getPropertyFromConfig("CoreFlex_Policy_RequiredFor"), "0")) {
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
		String actualEmailContentBenefitDetails[] = emailContent[1].split("</ul>");
		String deleteDeniedBenefitPointDetails[] = actualEmailContentBenefitDetails[0].replace("<ul>", "")
				.replace("<li>", "").replace("</ul>", "").split("</li>");
		String actualDeleteDeniedBenefitPointText = deleteDeniedBenefitPointDetails[0].trim();
		String actualDeleteCommentText = deleteDeniedBenefitPointDetails[1].replace("</li>", "").trim();
		String[] actualRemainingPointsText = actualEmailContentBenefitDetails[2].split("If");
		CoreFunctions.verifyText(actualUserName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
		CoreFunctions.verifyText(actualDeleteDeniedBenefitPointText, getExpectedDeleteDeniedBenefitPointText());
		CoreFunctions.verifyText(actualDeleteCommentText, COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
		CoreFunctions.verifyText(actualRemainingPointsText[0].trim(),
				getExpectedRemainingPointsToUseTextPostDeniedRequest());
		return true;
	}

	private String getExpectedDeleteDeniedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DELETE_REQUEST_DENIED_BENEFIT_POINT_MESSAGE
				.replace("benefit_name", approvedDeleteRequestBenefitName)
				.replace("delete_request_points", String.valueOf(format.format(deleteRequestTotalPoints)));
	}

	private String getExpectedRemainingPointsToUseTextPostDeniedRequest() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DENIED_DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE.replace("current_balance",
				String.valueOf(format.format(MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission))
						.replace("total_points", String.valueOf(format
								.format(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable))));
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
							|| ((policyRequiredFor.equals(COREFLEXConstants.CLIENT))))
							&& (ben.getPolicyCreationGroup().contains(policyRequiredFor))) {
						benefitNameList.add(ben);
					}
				}
			}
		}
		return benefitNameList;
	}

	public boolean verifyClientAndPointsDetails() {
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
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(CoreFunctions.getPropertyFromConfig("CF_Transferee_TotalAvailablePoints")),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
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
}
