package com.aires.pages.coreflex;

import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.util.List;
import java.util.stream.Collectors;

import org.apache.commons.math3.random.CorrelatedRandomVectorGenerator;
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

	// Expense Reimbursement Tracing Prompt List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//img[contains(@class,'Warning')]/following-sibling::span")
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
	@FindBy(how = How.CSS, using = "div[class='approve']")
	private WebElement _requestDialogApproveRadioButton;

	// Request Dialog Deny Radio Button
	@FindBy(how = How.CSS, using = "div[class='deny']")
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

	/**********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	static int benefitCount;
	static double approvedDeleteRequestTotalPoints;
	static boolean isDeleteRequestApproved;
	static String approvedDeleteRequestBenefitName;

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
			case COREFLEXConstants.APPROVE_REQUEST:
				CoreFunctions.clickElement(driver, _requestDialogApproveRadioButton);
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
			CoreFunctions.verifyText(driver, _textTransfereeName,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					COREFLEXConstants.TRANSFEREE_NAME);
			CoreFunctions.verifyText(driver, _textCorporationName,
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"), COREFLEXConstants.CORPORATION_NAME);
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			CoreFunctions.verifyValue(Double.parseDouble(actualPointsSpent[0].trim()),
					MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints, COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.highlightObject(driver, _textPointsSpent);
			CoreFunctions.verifyValue(driver, _textPointsBalance,
					MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission,
					COREFLEXConstants.POINTS_BALANCE);
			CoreFunctions.verifyValue(
					Double.parseDouble(CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim()),
					Double.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _textTotalPoints);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.PASS));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifySubmittedBenefitsDetails() {
		boolean isSubmittedBenefitStatusMatched = false;
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					isSubmittedBenefitStatusMatched = verifyBenefitDetails(benefit);
				}
				if (!isSubmittedBenefitStatusMatched)
					break;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedBenefitStatusMatched & (_submittedBenefitNameList.size() == benefitCount)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
			return true;
		} else
			return false;
	}

	private boolean verifyBenefitDetails(Benefit benefit) {
		try {
			for (int index = 0; index < _submittedBenefitNameList.size(); index++) {
				WebElement submittedBenefit = _submittedBenefitNameList.get(index);
				if (CoreFunctions.getElementText(driver, submittedBenefit).equals(benefit.getBenefitDisplayName())
						& (benefit.getSelectBenefitOnFPTPage())) {
					benefitCount += 1;
					CoreFunctions.verifyText(driver, _submittedBenefitNameList.get(index),
							benefit.getBenefitDisplayName(), COREFLEXConstants.SUBMITTED_BENEFIT_NAME);
					CoreFunctions.verifyText(driver, _submittedBenefitAllowanceAmountList.get(index),
							benefit.getBenefitAmount(), COREFLEXConstants.SUBMITTED_BENEFIT_ALLOWANCE_AMOUNT);
					String expectedPaymentOption = benefit.getPayments().equals(COREFLEXConstants.EXPENSE_REIMBURSEMENT)
							? COREFLEXConstants.REIMBURSEMENT_TRACING
							: (benefit.getPayments().equals(COREFLEXConstants.ALLOWANCE_CASHOUT))
									? COREFLEXConstants.ALLOWANCE_TRACING
									: null;
					CoreFunctions.verifyText(driver, _reimbursementAllowanceTracingList.get(index),
							expectedPaymentOption, COREFLEXConstants.SUBMITTED_BENEFIT_TRACING_SET_MESSAGE);
					CoreFunctions.verifyValue(
							Double.parseDouble(
									_submittedBenefitPointsList.get(index).getText().replace("pts", "").trim()),
							(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.SUBMITTED_BENEFIT_POINTS);
					CoreFunctions.highlightObject(driver, _submittedBenefitPointsList.get(index));
					if (MX_Transferee_MyBenefitsBundlePage.benefitDeletedFlag && benefit.getDeleteBenefitOnMBBPage()) {
						CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(index),
								COREFLEXConstants.DELETE_REQUEST_PENDING,
								COREFLEXConstants.DELETE_REQUEST_PENDING_STATUS);
						CoreFunctions.verifyText(driver, _buttonResolveDeleteRequest.get(index),
								COREFLEXConstants.RESOLVE, COREFLEXConstants.DELETE_REQUEST_RESOLVE_BUTTON);
					} else {
						CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(index),
								COREFLEXConstants.SUBMITTED, COREFLEXConstants.SUBMITTED_BENEFIT_STATUS);
					}
					CoreFunctions.verifyText(driver, _submittedBenefitQuantityList.get(index),
							String.valueOf(benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.SUBMITTED_BENEFIT_SELECTED_QUANTITY);
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
		return true;
	}

	private void resolveDeleteRequestPending() {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					for (int index = 0; index < _submittedBenefitNameList.size(); index++) {
						if ((benefit.getDeleteBenefitOnMBBPage())
								&& (CoreFunctions.getElementText(driver, _submittedBenefitNameList.get(index))
										.equals(benefit.getBenefitDisplayName()))) {
							CoreFunctions.verifyText(driver, _buttonResolveDeleteRequest.get(index),
									COREFLEXConstants.RESOLVE, COREFLEXConstants.DELETE_REQUEST_RESOLVE_BUTTON);
							CoreFunctions.clickElement(driver, _buttonResolveDeleteRequest.get(index));
							Reporter.addStepLog(MessageFormat.format(
									COREFLEXConstants.SUCCESSFULLY_CLICKED_ON_RESOLVE_BUTTON_ON_SUBMISSION_DETAILS_PAGE,
									CoreConstants.PASS, benefit.getBenefitDisplayName()));
							CoreFunctions.explicitWaitTillElementVisibility(driver, _requestDialogHeading,
									COREFLEXConstants.REQUESTS_DIALOG);
						}
					}
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
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					for (int index = 0; index < _requestDialogBenefitNameList.size(); index++) {
						if ((benefit.getDeleteBenefitOnMBBPage())
								& CoreFunctions.getElementText(driver, _requestDialogBenefitNameList.get(index))
										.equals(benefit.getBenefitDisplayName())) {
							CoreFunctions.verifyText(driver, _requestDialogBenefitNameList.get(index),
									benefit.getBenefitDisplayName(), COREFLEXConstants.REQUEST_DIALOG_BENEFIT_NAME);
							CoreFunctions.verifyText(driver, _requestDialogAllowanceAmountList.get(index),
									benefit.getBenefitAmount(),
									COREFLEXConstants.REQUEST_DIALOG_BENEFIT_ALLOWANCE_AMOUNT);
							CoreFunctions.verifyValue(
									Double.parseDouble(
											_requestDialogPointsList.get(index).getText().replace("pts", "").trim()),
									(Double.parseDouble(benefit.getPoints()) * benefit.getNumberOfBenefitSelected()),
									COREFLEXConstants.REQUEST_DIALOG_BENEFIT_POINTS);
							if (action.equals(COREFLEXConstants.APPROVE_REQUEST)) {
								approvedDeleteRequestTotalPoints += Double.parseDouble(
										_requestDialogPointsList.get(index).getText().replace("pts", "").trim());
							}
							CoreFunctions.highlightObject(driver, _requestDialogPointsList.get(index));
							CoreFunctions.verifyText(driver, _requestDialogStatusList.get(index),
									COREFLEXConstants.DELETE_REQUEST_PENDING,
									COREFLEXConstants.REQUEST_DIALOG_DELETE_REQUEST_PENDING_STATUS);
							CoreFunctions.verifyText(driver, _requestDialogQuantityList.get(index),
									String.valueOf(benefit.getNumberOfBenefitSelected()),
									COREFLEXConstants.REQUEST_DIALOG_BENEFIT_SELECTED_QUANTITY);
							CoreFunctions.clearAndSetText(driver, _requestDialogCommentBox,
									COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
							Reporter.addStepLog(MessageFormat.format(
									COREFLEXConstants.SUCCESSFULLY_VERIFIED_DELETE_REQUEST_BENEFITS_DETAILS_ON_REQUESTS_DIALOG,
									CoreConstants.PASS, benefit.getBenefitDisplayName()));
							approvedDeleteRequestBenefitName = benefit.getBenefitDisplayName();
							return true;
						}
					}
				}
			}

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_DELETE_REQUEST_BENEFIT_DETAILS_ON_REQUEST_DIALOG,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	public boolean verifyApprovedRequestActionCompletedMessage(String pageName) {
		try {
			DecimalFormat format = new DecimalFormat();
			format.setDecimalSeparatorAlwaysShown(false);
			String expectedGrowlMessage = MobilityXConstants.DELETE_ACTION_COMPLETED.replace("approvedDeletedPoints",
					format.format(approvedDeleteRequestTotalPoints));
			CoreFunctions.explicitWaitTillElementVisibility(driver, _requestCompletedGrowlMessage,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			CoreFunctions.verifyText(driver, _requestCompletedGrowlMessage, expectedGrowlMessage,
					COREFLEXConstants.REQUEST_ACTION_COMPLETED_GROWL);
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_GROWL_ACTION_COMPLETED_MESSAGE_ON_TRANSFEREE_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS, expectedGrowlMessage));
			MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints -= approvedDeleteRequestTotalPoints;
			MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission += approvedDeleteRequestTotalPoints;
			isDeleteRequestApproved = true;
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VERIFYING_GROWL_MESSAGE_AFTER_PERFORMING_DELETE_REQUEST_ACTION,
					CoreConstants.FAIL, e.getMessage(), pageName));
		}
		return false;
	}

	public boolean verifyApprovedDeleteRequestRemovedFromList() {
		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					for (int index = 0; index < _submittedBenefitNameList.size(); index++) {
						if ((benefit.getDeleteBenefitOnMBBPage())
								& CoreFunctions.getElementText(driver, _submittedBenefitNameList.get(index))
										.equals(benefit.getBenefitDisplayName())) {
							return false;
						}
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
		return true;
	}

	public boolean verifyBenefitDeleteRequestApprovedEmail() {
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
			// Enter expected email subject
			String expEmailSubject = "Mobility Flex Benefit Delete Request has been Approved";
			String actualResultSubmissionDetails = EmailUtil.searchEmailAndReturnResult(host, userName, pwd,
					expFromUserName, expEmailSubject, MobilityXConstants.DELETE_REQUEST_APPROVED);
			actualResultSubmissionDetails = actualResultSubmissionDetails.replace("<span>", "").replace("</span>", "")
					.replace("\t", "").replace("\r\n", "").replace("<br>", "").trim();
			if (verifyDeleteRequestEmailContents(actualResultSubmissionDetails)) {
				Reporter.addStepLog(CoreConstants.PASS
						+ "Successfully verified 'Mobility Flex Benefit Delete Request has been Approved' Email.");
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.EXCEPTION_OCCURED_WHILE_READING_CREDENTIALS_FROM_EMAIL,
							CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyDeleteRequestEmailContents(String actualResultSubmissionDetails) {
		String emailContent[] = actualResultSubmissionDetails.split(",");
		String actualUserName = emailContent[0];
		String actualEmailContentBenefitDetails[] = emailContent[1].split("</ul>");
		String deleteApprovedBenefitPointDetails[] = actualEmailContentBenefitDetails[0].replace("<ul>", "").replace("<li>", "")
				.replace("</ul>", "").split("</li>");
		String actualDeleteApprovedBenefitPointText = deleteApprovedBenefitPointDetails[0].trim();	
		String actualDeleteCommentText = deleteApprovedBenefitPointDetails[1].replace("</li>", "").trim();
		String actualRemainingPointsText = actualEmailContentBenefitDetails[2].trim();
		CoreFunctions.verifyText(actualUserName, CoreFunctions.getPropertyFromConfig("Transferee_firstName"));
		CoreFunctions.verifyText(actualDeleteApprovedBenefitPointText,getExpectedDeleteApprovedBenefitPointText());
		CoreFunctions.verifyText(actualDeleteCommentText,COREFLEXConstants.REQUESTS_DIALOG_COMMENT);
		CoreFunctions.verifyText(actualRemainingPointsText,getExpectedRemainingPointsToUseText());
		return true;
	}

	private String getExpectedDeleteApprovedBenefitPointText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DELETE_REQUEST_APPROVED_BENEFIT_POINT_MESSAGE.replace("benefit_name", approvedDeleteRequestBenefitName)
				.replace("delete_request_points", String.valueOf(format.format(approvedDeleteRequestTotalPoints)));
	}

	private String getExpectedRemainingPointsToUseText() {
		DecimalFormat format = new DecimalFormat();
		format.setDecimalSeparatorAlwaysShown(false);
		return MobilityXConstants.DELETE_REQUEST_REMAINING_POINTS_TO_USE_MESSAGE
				.replace("current_balance", String.valueOf(format.format(MX_Transferee_MyBenefitsBundlePage.availablePointsAfterSubmission)));
	}
}
