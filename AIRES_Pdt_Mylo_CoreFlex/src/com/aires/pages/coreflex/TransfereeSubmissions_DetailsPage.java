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
	@FindBy(how = How.CSS, using = "mat-cell[class*='column-Benefit'] > span[class*='BlackText']")
	private List<WebElement> _submittedBenefitList;

	// Submitted Benefit Allowance Amount List
	@FindBy(how = How.CSS, using = "mat-cell[class*='column-Benefit'] > span[class*='ng-star-inserted']")
	private List<WebElement> _submittedBenefitAllowanceAmountList;

	// Submitted Benefit Points List
	@FindBy(how = How.CSS, using = "mat-cell[class*='column-Points'] > span[class*='ng-star-inserted']")
	private List<WebElement> _submittedBenefitPointsList;

	// Submitted Benefit Request Sent Date List
	@FindBy(how = How.CSS, using = "mat-cell[class*='RequestSubmit']")
	private List<WebElement> _submittedBenefitRequestedSentDateList;

	// Submitted Benefit Status List
	@FindBy(how = How.CSS, using = "mat-cell[class*='Status'] > span > span")
	private List<WebElement> _submittedBenefitStatusList;

	// Submitted Benefit Show Comments List
	@FindBy(how = How.CSS, using = "mat-cell[class*='Status'] > span[class*='BlueText']")
	private List<WebElement> _submittedBenefitShowCommentsList;

	// Submitted Benefit Quantity List
	@FindBy(how = How.CSS, using = "mat-cell[class*='mat-column-Quantity']")
	private List<WebElement> _submittedBenefitQuantityList;

	/**********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	public static final List<Benefit> coreBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeCoreBenefitDetails();

	public static final List<FlexBenefit> flexBenefits = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getMXTransfereeFlexBenefitData();

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

		boolean isTransfereeAndPointsDetailsValidated = false;
		try {
			String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
					+ CoreFunctions.getPropertyFromConfig("Transferee_lastName");
			String expectedCorporationName = CoreFunctions.getPropertyFromConfig("Assignment_ClientName");

			/****************** From MXTransferee application ****************/

			String expectedPointsSpent = String.valueOf(MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints);
			String expectedTotalPoints = policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable;
			String expectedPointsBalance = String
					.valueOf(Double.parseDouble(expectedTotalPoints) - Double.parseDouble(expectedPointsSpent));

			/***************************************************************/

			String actualTransfereeName = CoreFunctions.getElementText(driver, _textTransfereeName).trim();
			String actualCorporationName = CoreFunctions.getElementText(driver, _textCorporationName).trim();
			String actualPointsSpent[] = CoreFunctions.getElementText(driver, _textPointsSpent).trim().split("of");
			String actualPointsBalance = CoreFunctions.getElementText(driver, _textPointsBalance).trim();
			String actualTotalPoints = CoreFunctions.getElementText(driver, _textTotalPoints).replace("/", "").trim();

			isTransfereeAndPointsDetailsValidated = ((actualTransfereeName.equals(expectedTransfereeName))
					& (actualCorporationName.equals(expectedCorporationName))
					& ((actualPointsSpent[0].trim()).equals(expectedPointsSpent))
					& (actualPointsBalance.equals(expectedPointsBalance))
					& (actualTotalPoints.equals(expectedTotalPoints)));

			if (!isTransfereeAndPointsDetailsValidated)
				return false;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isTransfereeAndPointsDetailsValidated) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.PASS));
		}
		return isTransfereeAndPointsDetailsValidated;
	}

	public boolean verifySubmittedBenefitsDetails() {
		int count = 0;
		boolean isSubmittedBenefitStatusMatched = false;

		try {
			for (FlexBenefit benefitList : flexBenefits) {
				for (Benefit benefit : benefitList.getBenefits()) {
					for (int index = 0; index < _submittedBenefitList.size(); index++) {
						WebElement submittedBenefit = _submittedBenefitList.get(index);
						if (CoreFunctions.getElementText(driver, submittedBenefit).equals(benefit.getBenefitType())
								& (benefit.getSelectBenefitOnFPTPage())) {
							count += 1;
							String actualBenefitName = _submittedBenefitList.get(index).getText();
							String actualBenefitPoints = _submittedBenefitPointsList.get(index).getText();
							String actualAllowanceAmountMessage = _submittedBenefitAllowanceAmountList.get(index)
									.getText();
							String actualSubmitStatus = _submittedBenefitStatusList.get(index).getText();
							String actualBenefitQuantity = _submittedBenefitQuantityList.get(index).getText();

							isSubmittedBenefitStatusMatched = (actualBenefitName.equals(benefit.getBenefitType()))
									& (actualBenefitPoints.equals(benefit.getPoints()))
									& (actualAllowanceAmountMessage.equals(benefit.getBenefitAmount()))
									& (actualSubmitStatus.equals(COREFLEXConstants.SUBMITTED)) & (actualBenefitQuantity
											.equals(String.valueOf(benefit.getNumberOfBenefitSelected())));

							if (!isSubmittedBenefitStatusMatched)
								break;
						}

					}
				}
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isSubmittedBenefitStatusMatched & (_submittedBenefitList.size() == count)) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_SUBMITTED_BENEFITS_DETAILS_ON_SUBMISSION_DETAILS_PAGE,
					CoreConstants.PASS));
		}		
		return isSubmittedBenefitStatusMatched;
	}
}
