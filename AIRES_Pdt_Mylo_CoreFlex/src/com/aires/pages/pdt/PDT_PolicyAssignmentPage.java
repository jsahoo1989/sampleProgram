package com.aires.pages.pdt;

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
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class PDT_PolicyAssignmentPage extends Base {
	public PDT_PolicyAssignmentPage(WebDriver driver) {
		super(driver);
	}

	@FindBy(how = How.CSS, using = "td[class*='mat-column-transfereeName']")
	private List<WebElement> _listTransfereeName;

	@FindBy(how = How.CSS, using = "td[class*='cdk-column-assignmentStatusCode']")
	private List<WebElement> _listAssignmentStatus;

	@FindBy(how = How.CSS, using = "td[class*='cdk-column-bookDate']")
	private List<WebElement> _listAssignmentBookDate;
	
	@FindBy(how = How.XPATH, using = "//span[text()='EXIT']/parent::button")
	private WebElement _btnExit;
	
	@FindBy(how = How.CSS, using = "button.swal2-confirm")
	private WebElement _btnOk;
	
	@FindBy(how = How.CSS, using = "div.swal2-container.swal2-backdrop-show")
	private WebElement _popuSwal2;
	
	// Progress Bar
	@FindBy(how = How.CSS, using = "div.ngx-progress-bar.ngx-progress-bar-ltr")
	private WebElement _progressBar;
	
	public void waitForProgressBarToDisapper() {
		if(CoreFunctions.isElementExist(driver, _progressBar, 3)) {		
			BusinessFunctions.fluentWaitForSpinnerToDisappear(driver, _progressBar);			
		}
	}
	

	public boolean verifyAssignmentInfo(WebElement element, String expectedVal, String elementName) {
		try {
			if (element.getText().trim().equalsIgnoreCase(expectedVal.trim())) {
				CoreFunctions.highlightObject(driver, element);
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_ASSIGMENT_INFO, CoreConstants.PASS,
						elementName, expectedVal));
				return true;
			}
		} catch (Exception e) {

		}
		Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_ASSIGNMENT_INFO, CoreConstants.FAIL,
				elementName, expectedVal, element.getText()));
		return false;
	}

	public boolean verifyAssignmentInfo() {
		try {
			String transfereeName = CoreFunctions.getPropertyFromConfig(MobilityXConstants.FIRST_NAME_TEXT) + " "
					+ CoreFunctions.getPropertyFromConfig(MobilityXConstants.LAST_NAME_TEXT);
			int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _listTransfereeName, transfereeName);
			if (index != -1) {
				return (verifyAssignmentInfo(_listTransfereeName.get(index), transfereeName,
						PDTConstants.TRANSFEREE_NAME)
						&& verifyAssignmentInfo(_listAssignmentStatus.get(index), PDTConstants.ASSIGNMENT_STATUS_BOOKED, PDTConstants.ASSIGNMENT_STATUS)
						&& verifyAssignmentInfo(_listAssignmentBookDate.get(index), CoreFunctions.getcurrentdate(), PDTConstants.BOOKED_DATE));

			} else {
				Assert.fail("Failed to search transfere");
			}

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e.getStackTrace());
		}
		return false;
	}
	
	public int getTransfereeCount() {
		return _listTransfereeName.size();
	}
	
	public void exitAssignmentTransfereePage() {
		CoreFunctions.highlightElementAndClick(driver, _btnExit, _btnExit.getText());
		waitForProgressBarToDisapper();
		//CoreFunctions.explicitWaitTillElementVisibility(driver, _popuSwal2, "Confirmation");
		//CoreFunctions.highlightElementAndClick(driver, _btnOk, _btnOk.getText());
	}
}
