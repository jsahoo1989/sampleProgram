package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.testng.Assert;

import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.DbFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.CustomSoftAssert;
import com.aires.utilities.Log;
import com.aires.utilities.MyloNewFileUtil;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.DataTable;

public class MyloJourneyPage_QueryByServiceID extends Base {

	public MyloJourneyPage_QueryByServiceID(WebDriver driver) {
		super(driver);
	}

	//Query by subservice ID popup
	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _queryByServiceIDPopup;
	
	@FindBy(how = How.CSS, using = "input#subServiceId")
	private WebElement _txtSubServiceID;
	
	@FindBy(how = How.CSS, using = "button[type='Submit']")
	private WebElement _executeBtn;
	
	@FindBy(how = How.XPATH, using = "//button[text()='Cancel']")
	private WebElement _cancelBtn;
	
	@FindBy(how = How.CSS, using = "button[class='btn-close']")
	private WebElement _closeBtn;
	
	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _noSuchFilePopup;
	
	@FindBy(how = How.XPATH, using = "//button[text()='OK']")
	private WebElement _noSuchFilePopupOkButton;
	
	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;
	
	@FindBy(how = How.CSS, using = "//div[class*='mylocontent']")
	private WebElement _summaryPage;
	
	@FindBy(how = How.CSS, using = "//div[class='webswing-banner']")
	private WebElement _shipmentSubScreen;
	
	@FindBy(how = How.CSS, using = "h2[id='headingOne']")
	private WebElement _fileInformationSidePanel;
	
	
	/**
	 * Clicks on Execute Button in Query By SubSerieID popup
	 */
	public void clickExecuteButton() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _executeBtn, _executeBtn.getText(), 10);
			CoreFunctions.highlightElementAndClick(driver, _executeBtn, _executeBtn.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.EXECUTE));
		}
	}
	
	/**
	 * Enter value in SubServiceID input field
	 */
	public void setSubServiceIDValue(String fieldValue) {
		try {
			CoreFunctions.verifyElementPresentOnPage(_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID);
			CoreFunctions.setElementText(driver, _txtSubServiceID, fieldValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID));
		}
	}
	
	/**
	 * Enter random in SubServiceID input field
	 */
	public void setRandomSubServiceIDValue(int length) {
		try {
			CoreFunctions.verifyElementPresentOnPage(_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID);
			CoreFunctions.setElementText(driver,_txtSubServiceID,CoreFunctions.generateRandomNumberOfLength(length));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID));
		}
	}
	
	
	/**
	 * Enter random character in SubServiceID input field
	 */
	public void setRandomCharInSubServiceID(int stringLength) {
		try {
			CoreFunctions.verifyElementPresentOnPage(_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID);
			CoreFunctions.setElementText(driver, _txtSubServiceID, CoreFunctions.generateRandomString(stringLength));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID));
		}
	}
	
	/**
	 * Verify if no such file pop-up is displayed
	 */
	public boolean isNoSuchFilePopUpExist() {
		boolean isExists = false;
		try {
			isExists = CoreFunctions.isElementExist(driver, _noSuchFilePopup, 5);
			if(isExists) {
		    CoreFunctions.verifyText(driver, _noSuchFilePopup, MYLOConstants.NO_SUCH_FILE_FOUND, MYLOConstants.NO_SUCH_FILE_FOUND);
		    BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		    CoreFunctions.clickElement(driver, _noSuchFilePopupOkButton);
			}	
		} catch (Exception e) {
		    Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
		    		_noSuchFilePopup, MYLOConstants.NO_SUCH_FILE_FOUND));
		}	
		return isExists;
		
	}

	
	
	/**
	 * Clicks on Close Button in Query By SubSerieID popup
	 */
	public void clickCloseButton() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _closeBtn, MYLOConstants.CLOSE, 10);
			CoreFunctions.highlightElementAndClick(driver, _closeBtn, MYLOConstants.CLOSE);
			 BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, MYLOConstants.CLOSE));
		}
	}
	
	
	/**
	 * Clicks on Cancel Button in Query By SubSerieID popup
	 */
	public void clickCancelButton() {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, _cancelBtn, _cancelBtn.getText(), 10);
			CoreFunctions.highlightElementAndClick(driver, _cancelBtn, _cancelBtn.getText());
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, _cancelBtn.getText()));
		}
	}
	
	/**
	 * Return SubServiceID field value
	 */
	public String getSubServiceIDValue() {		
		String subSericeIDValue ="";
		try
		{
		  subSericeIDValue = CoreFunctions.getAttributeText(_txtSubServiceID, MYLOConstants.VALUE);		
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_GET_VALUE_FROM_ELEMET,_txtSubServiceID));
		}
		return subSericeIDValue;
	}
	
	/**
	 * Verify if query by serice id popup is displayed
	 */
	public boolean isQueryBySubServiceIDPopUpExist() {
		boolean isExists = false;
		try {
			isExists = CoreFunctions.isElementExist(driver, _queryByServiceIDPopup, 5);	
		} catch (Exception e) {
		    Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
		    		_queryByServiceIDPopup, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
		}	
		return isExists;
	}
	
	
	/**
	 * Verify if summary overview is displayed
	 */
	public boolean isSummaryDisplayed() {
		boolean isExists = false;
		try {
			isExists = CoreFunctions.isElementExist(driver, _summaryPage, 5);	
		}  catch (Exception e) {
		    Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
		    		_summaryPage, MYLOConstants.SUMMARY));
		}	
		return isExists;
	}
	
	
	/**
	 * Verify if ShipmentSubService is displayed
	 */
	public boolean isShipmentSubServiceDisplayed() {
		boolean isExists = false;
		try {
			isExists = CoreFunctions.isElementExist(driver, _shipmentSubScreen, 5);	
		}  catch (Exception e) {
		    Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
		    		_shipmentSubScreen, MYLOConstants.SHIPMENT_WEBSWING));
		}	
		return isExists;
	}
	
	
	
	/**
	 * Verify if file information side panel is displayed
	 */
	public boolean isFileInformationSidePanelExist() {
		boolean isExists = false;
		try {
			isExists = CoreFunctions.isElementExist(driver, _fileInformationSidePanel, 5);
			CoreFunctions.verifyText(CoreFunctions.getElementText(driver, _fileInformationSidePanel).trim(),MYLOConstants.FILE_INFORMATION_SECTION);
		} catch (Exception e) {
		    Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
		    		_fileInformationSidePanel, MYLOConstants.FILE_INFORMATION_SECTION));
		}	
		return isExists;
	}
}
