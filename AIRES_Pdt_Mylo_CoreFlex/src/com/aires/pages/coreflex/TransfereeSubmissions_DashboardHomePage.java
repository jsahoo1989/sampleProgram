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
import com.aires.utilities.Log;
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
	@FindBy(how = How.CSS, using = "div[class='logo-title'] > a[class='simple-text']")
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
	private List<WebElement> _TotalPointsList;

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

	/**********************************************************************/

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
				int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _transfereeNameList,
						CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
								+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
				CoreFunctions.clickElement(driver, _reviewOpenButtonList.get(index));
				CoreFunctions.explicitWaitTillElementInVisibility(driver, _progressBar);
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

	public boolean verifyUserlogin(String userName, String pageName) {
		CoreFunctions.waitHandler(4);
		CoreFunctions.explicitWaitTillElementVisibility(driver, _txtApplicationTitle, COREFLEXConstants.TRANSFEREE_SUBMISSIONS, 5);
		if ((getUserName().equalsIgnoreCase(userName)) && (CoreFunctions.getElementText(driver, _txtApplicationTitle)
				.equals(COREFLEXConstants.TRANSFEREE_SUBMISSIONS))) {
			CoreFunctions.highlightObject(driver, _userName);
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VERIFIED_USERNAME_IS_DISPLAYED,
					CoreConstants.PASS, userName, pageName));
			Log.info("Verified username");
			return true;
		}
		Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.FAILED_TO_VERIFY_USERNAME, CoreConstants.FAIL,
				pageName, userName, getUserName()));
		return false;
	}

	public String getUserName() {
		CoreFunctions.explicitWaitTillElementBecomesClickable(driver, _userName, COREFLEXConstants.USERNAME);
		System.out.println(_userName.getText().trim());
		return _userName.getText().trim();
	}

	public boolean verifyTransfereeBundleSubmissionDetails() {

		boolean isTransfereeBundleDetailsValidated = false;
		int index = 0;
		try {
			String expectedTransfereeName = CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
					+ CoreFunctions.getPropertyFromConfig("Transferee_lastName");
			String expectedCorporationName = CoreFunctions.getPropertyFromConfig("Assignment_ClientName");			
			
			/***********To Be Passed From MXTransferee application***********/
			String expectedAllowanceType = "POINTS";
			String expectedPointsSpent = "175";
			String expectedTotalPoints = "500";
			String expectedSubmittedDate = "Feb 8, 2022";
			/***************************************************************/
			
			index = BusinessFunctions.returnindexItemFromListUsingText(driver, _transfereeNameList,
					CoreFunctions.getPropertyFromConfig("Transferee_firstName") + " "
							+ CoreFunctions.getPropertyFromConfig("Transferee_lastName"));
			String actualTransfereeName = _transfereeNameList.get(index).getText().trim();
			String actualCorporationName = _corporationNameList.get(index).getText().trim();
			String actualAllowanceType = _allowanceTypeList.get(index).getText().trim();
			String actualPointsSpent = _pointsSpentList.get(index).getText().trim();
			String actualTotalPoints = _TotalPointsList.get(index).getText().replace("/", "").trim();
			String actualSubmittedDate = _submittedDateList.get(index).getText().trim();

			isTransfereeBundleDetailsValidated = ((actualTransfereeName.equals(expectedTransfereeName))
					& (actualCorporationName.equals(expectedCorporationName))
					& (actualAllowanceType.equals(expectedAllowanceType))
					& (actualPointsSpent.equals(expectedPointsSpent)) & (actualTotalPoints.equals(expectedTotalPoints))
					& (actualSubmittedDate.equals(expectedSubmittedDate)));
			
			if(!isTransfereeBundleDetailsValidated)
				return false;

		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.EXCEPTION_OCCURED_WHILE_VALIDATING_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.FAIL, e.getMessage()));
		}
		if (isTransfereeBundleDetailsValidated) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VALIDATED_TRANSFEREE_SUBMISSION_DETAILS_ON_DASHBOARD_HOME_PAGE,
					CoreConstants.PASS));			
		}
		return isTransfereeBundleDetailsValidated;
	}
	
	

}
