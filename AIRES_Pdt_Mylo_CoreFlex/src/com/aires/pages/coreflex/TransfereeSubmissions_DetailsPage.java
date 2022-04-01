package com.aires.pages.coreflex;

import java.text.MessageFormat;
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
import com.aires.managers.FileReaderManager;
import com.aires.testdatatypes.coreflex.Benefit;
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.aires.testdatatypes.coreflex.FlexBenefit;
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
	@FindBy(how = How.CSS, using = "mat-cell[class*='column-Points'] > span[class*='ng-star-inserted']")
	private List<WebElement> _submittedBenefitPointsList;

	// Submitted Benefit Request Sent Date List
	@FindBy(how = How.CSS, using = "mat-cell[class*='RequestSubmit']")
	private List<WebElement> _submittedBenefitRequestedSentDateList;

	// Submitted Benefit Status List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'Status')]/span/span")
	private List<WebElement> _submittedBenefitStatusList;

	// Submitted Benefit Show Comments List
	@FindBy(how = How.CSS, using = "mat-cell[class*='Status'] > span[class*='BlueText']")
	private List<WebElement> _submittedBenefitShowCommentsList;

	// Submitted Benefit Quantity List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//mat-cell[contains(@class,'mat-column-Quantity')]")
	private List<WebElement> _submittedBenefitQuantityList;

	// Expense Reimbursement Tracing Prompt List
	@FindBy(how = How.XPATH, using = "//div[contains(@class,'tblBenefits')]//img[contains(@class,'Warning')]/following-sibling::span")
	private List<WebElement> _reimbursementAllowanceTracingList;

	/**********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

	static int benefitCount;

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
				if(!isSubmittedBenefitStatusMatched)
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
		}
		else 
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
					CoreFunctions.verifyValue(
							Double.parseDouble(_submittedBenefitPointsList.get(index).getText().replace("pts", "")),
							Double.parseDouble(benefit.getPoints()),
							COREFLEXConstants.SUBMITTED_BENEFIT_ALLOWANCE_AMOUNT);
					CoreFunctions.verifyText(driver, _submittedBenefitStatusList.get(index),
							COREFLEXConstants.SUBMITTED, COREFLEXConstants.SUBMITTED_BENEFIT_STATUS);
					CoreFunctions.verifyText(driver, _submittedBenefitQuantityList.get(index),
							String.valueOf(benefit.getNumberOfBenefitSelected()),
							COREFLEXConstants.SUBMITTED_BENEFIT_SELECTED_QUANTITY);
					return true;
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
}
