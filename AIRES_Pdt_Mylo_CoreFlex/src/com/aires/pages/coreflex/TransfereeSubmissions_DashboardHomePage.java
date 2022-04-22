package com.aires.pages.coreflex;

import java.text.MessageFormat;
import java.util.List;

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
import com.aires.testdatatypes.coreflex.CoreFlex_PolicySetupPagesData;
import com.vimalselvam.cucumber.listener.Reporter;

public class TransfereeSubmissions_DashboardHomePage extends Base {

	public TransfereeSubmissions_DashboardHomePage(WebDriver driver) {
		super(driver);
	}

	/********************* Page Objects ************************************/

	// User name
	@FindBy(how = How.CSS, using = "a.nav-link.nav_username")
	private WebElement _userName;

	// Transferee Submissions Logo Title
	@FindBy(how = How.CSS, using = "div[class='logo-title'] > span[class='simple-text']")
	private WebElement _txtApplicationTitle;

	// Transferee Name List
	@FindBy(how = How.CSS, using = "div[class='tranfereeFont']")
	private List<WebElement> _transfereeNameList;

	// Transferee File# List
	@FindBy(how = How.CSS, using = "span[class='fileNameStyle']")
	private List<WebElement> _transfereeFileNumberList;

	// Corporation Name List
	@FindBy(how = How.XPATH, using = "//div[@class='Points']//ancestor::div[contains(@class,'d-flex')]/preceding-sibling::div/span[@class='normalText']")
	private List<WebElement> _corporationNameList;

	// Allowance Type List
	@FindBy(how = How.CSS, using = "div[class='Points']")
	private List<WebElement> _allowanceTypeList;

	// Points Spent List
	@FindBy(how = How.CSS, using = "span[class='Points-Spent']")
	private List<WebElement> _pointsSpentList;

	// Total Points List
	@FindBy(how = How.CSS, using = "span[class='Total-Points']")
	private List<WebElement> _totalPointsList;

	// Submitted Date List
	@FindBy(how = How.XPATH, using = "//span[@class='Points-Spent']//ancestor::div[contains(@class,'d-flex')]/following-sibling::div/span[@class='normalText']")
	private List<WebElement> _submittedDateList;

	// Review/Open Button List
	@FindBy(how = How.CSS, using = "button[class*='btn']")
	private List<WebElement> _reviewOpenButtonList;

	// Search Icon
	@FindBy(how = How.CSS, using = "i[class*='fa-search']")
	private WebElement _searchIcon;

	// Dashboard Transferee Submissions Records List
	@FindBy(how = How.CSS, using = "div[class*='row bgColor ng-star-inserted']")
	private List<WebElement> _dashboardRecordsList;

	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;

	// AIRES Flex Logo Image
	@FindBy(how = How.CSS, using = "img[src='assets/img/AiresFleXLogo.png']")
	private WebElement _imgAIRESFlexLogo;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	/**********************************************************************/

	CoreFlex_PolicySetupPagesData policySetupPageData = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getPolicySetupPagesDataList(COREFLEXConstants.POLICY_SETUP);

	/**********************************************************************/

	/**
	 * Generic Method to Click on an Element on a Page.
	 * 
	 * @param elementName
	 */
	public void clickElementOfPage(String elementName) {
		try {
			switch (elementName) {
			case COREFLEXConstants.REVIEW:
			case COREFLEXConstants.OPEN:
				int indexTransferee = BusinessFunctions.returnindexItemFromListUsingText(driver, _transfereeNameList,
						true, CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
								+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
				CoreFunctions.clickElement(driver, _reviewOpenButtonList.get(indexTransferee));
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
				Reporter.addStepLog(MessageFormat.format(
						MobilityXConstants.SUCCESSFULLY_CLICKED_ON_REVIEW_BUTTON_FOR_BUNDLE_SUBMITTED_BY_TRANSFEREE,
						CoreConstants.PASS));
				break;
			case COREFLEXConstants.SEARCH:
				CoreFunctions.clickElement(driver, _searchIcon);
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

	public boolean verifyUserNavigationToDashboardPage() {
		try {
			if (CoreFunctions.isElementExist(driver, _spinner, 5))
				CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 10);
			return CoreFunctions.isElementExist(driver, _txtApplicationTitle, 5);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_NAVIGATING_TO_TRANSFEREE_SUBMISSIONS_DASHBOARD_PAGE,
					CoreConstants.FAIL, e.getMessage()));
			return false;
		}
	}

	public boolean verifyUserLogin(String userName, String pageName) {
		if (CoreFunctions.isElementExist(driver, _spinner, 5))
			CoreFunctions.explicitWaitTillElementInVisibilityCustomTime(driver, _spinner, 30);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _txtApplicationTitle,
				COREFLEXConstants.TRANSFEREE_SUBMISSIONS, 20);
		if ((getUserName().equalsIgnoreCase(userName))
				&& (CoreFunctions.getElementText(driver, _txtApplicationTitle)
						.equals(COREFLEXConstants.TRANSFEREE_SUBMISSIONS))
				&& CoreFunctions.isElementExist(driver, _imgAIRESFlexLogo, 2)) {
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VERIFIED_USERNAME_IS_DISPLAYED,
					CoreConstants.PASS, userName, pageName));
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL,
				pageName, userName, getUserName()));
		return false;
	}

	public String getUserName() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _userName, COREFLEXConstants.USERNAME);
		return _userName.getText().trim();
	}

	public boolean verifyTransfereeBundleSubmissionDetails() {
		int indexTransferee = 0;
		try {
			indexTransferee = BusinessFunctions.returnindexItemFromListUsingText(driver, _transfereeNameList, true,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
			if (verifyTransfereeBundleDetailsOnDashboard(indexTransferee)) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
						CoreConstants.PASS));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

	private boolean verifyTransfereeBundleDetailsOnDashboard(int indexTransferee) {
		try {
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _transfereeNameList);
			CoreFunctions.verifyText(driver, _transfereeNameList.get(indexTransferee),
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"),
					COREFLEXConstants.TRANSFEREE_NAME);
			String[] fileNumber = _transfereeFileNumberList.get(indexTransferee).getText().split("#");
			CoreFunctions.verifyText(fileNumber[1].trim(), CoreFunctions.getPropertyFromConfig("Assignment_FileID"),
					COREFLEXConstants.TRANSFEREE_FILE_ID);
			CoreFunctions.verifyText(driver, _corporationNameList.get(indexTransferee),
					CoreFunctions.getPropertyFromConfig("Assignment_ClientName"), COREFLEXConstants.CORPORATION_NAME);
			CoreFunctions.verifyText(driver, _allowanceTypeList.get(indexTransferee), COREFLEXConstants.POINTS,
					COREFLEXConstants.ALLOWANCE);
			CoreFunctions.verifyValue(driver, _pointsSpentList.get(indexTransferee),
					MX_Transferee_FlexPlanningTool_Page.totalSelectedPoints, COREFLEXConstants.POINTS_SPENT);
			CoreFunctions.verifyValue(
					Double.parseDouble(_totalPointsList.get(indexTransferee).getText().replace("/", "").trim()),
					Double.parseDouble(policySetupPageData.flexPolicySetupPage.StaticFixedTotalPointsAvailable),
					COREFLEXConstants.TOTAL_POINTS);
			CoreFunctions.highlightObject(driver, _totalPointsList.get(indexTransferee));
			return true;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		return false;
	}

}
