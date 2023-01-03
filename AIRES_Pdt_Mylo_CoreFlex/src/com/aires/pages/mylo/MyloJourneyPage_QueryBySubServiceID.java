package com.aires.pages.mylo;

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
import com.aires.businessrules.constants.MYLOConstants;

public class MyloJourneyPage_QueryBySubServiceID extends Base {

	public MyloJourneyPage_QueryBySubServiceID(WebDriver driver) {
		super(driver);
	}

	// Query by subservice ID popup

	@FindBy(how = How.CSS, using = "#cdk-overlay-1")
	private WebElement _queryByServiceIDPopup;

	@FindBy(how = How.CSS, using = "h5[class='modal-title']")
	private WebElement _queryByServiceIDPopupHeading;

	@FindBy(how = How.CSS, using = "input#subServiceId")
	private WebElement _txtSubServiceID;

	@FindBy(how = How.CSS, using = "app-sub-service-id-popup button")
	private List<WebElement> _queryBySubServiceIDButtons;

	@FindBy(how = How.CSS, using = "div[class*='mylo-errorpopup']")
	private WebElement _noSuchFilePopup;

	@FindBy(how = How.CSS, using = "h1[class='errortext']")
	private WebElement _noSuchFilePopupHeader;

	@FindBy(how = How.CSS, using = "button[class*='swal2-confirm']")
	private WebElement _noSuchFilePopupOkButton;

	@FindBy(how = How.CSS, using = "div[class='sk-three-strings']")
	private WebElement _spinner;

	@FindBy(how = How.CSS, using = "div[class*='mylocontent']")
	private WebElement _summaryPage;

	@FindBy(how = How.CSS, using = "div[class='webswing-banner']")
	private WebElement _shipmentSubScreen;

	private boolean _isExists = false;
	private String _subServiceIDUpdatedValue = "";

	/**
	 * Enter value in subservice ID input field
	 * 
	 * @param subserviceIDValue
	 */
	public void setSubServiceIDValue(String subserviceIDValue, String valueType) {
		try {
			CoreFunctions.verifyElementPresentOnPage(_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID);
			_subServiceIDUpdatedValue = BusinessFunctions.setMyloInputFields(driver, MYLOConstants.SUB_SERVICE_ID,
					subserviceIDValue, _txtSubServiceID, valueType);

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_txtSubServiceID, MYLOConstants.SUB_SERVICE_ID));
		}
	}

	/**
	 * Verify if no such file pop-up is displayed
	 * 
	 * @return
	 */
	public boolean isNoSuchFilePopUpExist() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _noSuchFilePopup, MYLOConstants.WAIT);
			if (_isExists) {
				CoreFunctions.verifyText(driver, _noSuchFilePopupHeader, MYLOConstants.NO_SUCH_FILE_FOUND,
						MYLOConstants.NO_SUCH_FILE_FOUND);
				BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
				CoreFunctions.clickElement(driver, _noSuchFilePopupOkButton);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_noSuchFilePopup, MYLOConstants.NO_SUCH_FILE_FOUND));
		}
		return _isExists;

	}

	/**
	 * Return SubServiceID field value
	 * 
	 * @return
	 */
	public String getSubServiceIDValue() {
		String subSericeIDValue = "";
		try {
			subSericeIDValue = CoreFunctions.getAttributeText(_txtSubServiceID, MYLOConstants.VALUE);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MYLOConstants.FAILED_TO_GET_VALUE_FROM_ELEMENT, _txtSubServiceID));
		}
		return subSericeIDValue;
	}

	/**
	 * Verify if query by service id popup is displayed
	 * 
	 * @return
	 */
	public boolean isQueryBySubServiceIDPopUpExist() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _queryByServiceIDPopup, MYLOConstants.WAIT);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_queryByServiceIDPopup, MYLOConstants.QUERY_BY_SUB_SERVICE_ID));
		}
		return _isExists;
	}

	/**
	 * Verify if summary overview is displayed
	 *
	 * @return
	 */
	public boolean isSummaryDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _summaryPage, MYLOConstants.WAIT);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_summaryPage, MYLOConstants.SUMMARY));
		}
		return _isExists;
	}

	/**
	 * Verify if ShipmentSubService Screen is displayed
	 * 
	 * @return
	 */
	public boolean isShipmentSubServiceScreenDisplayed() {

		try {
			_isExists = CoreFunctions.isElementExist(driver, _shipmentSubScreen, MYLOConstants.WAIT);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION, CoreConstants.FAIL,
					_shipmentSubScreen, MYLOConstants.SHIPMENT_WEBSWING));
		}
		return _isExists;
	}

	/**
	 * Click Button in Query By Sub Service ID popup
	 * 
	 * @param buttonName
	 */
	public void clickButtonInQueryBySubServiceIDPopUp(String buttonName) {
		try {
			WebElement fieldElement = BusinessFunctions.returnElementFromListUsingAttribute(driver,
					_queryBySubServiceIDButtons, buttonName, MYLOConstants.CLASS);
			CoreFunctions.highlightElementAndClick(driver, fieldElement, buttonName);
			BusinessFunctions.fluentWaitForMyloSpinnerToDisappear(driver, _spinner);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, buttonName));
		}
	}

	/**
	 * Verify text's length in subservice id is according to the max length
	 * 
	 * @return
	 */
	public boolean verifySubServiceIDMaxLength() {
		return CoreFunctions.verifyTextForMaxLength(getSubServiceIDValue(),
				_subServiceIDUpdatedValue.substring(0, MYLOConstants.SUB_SERVICE_ID_FIELD_LIMIT),
				MYLOConstants.QUERY_BY_SUB_SERVICE_ID, getSubServiceIDValue().length(),
				MYLOConstants.SUB_SERVICE_ID_FIELD_LIMIT);

	}

	/**
	 * Check if SubServie ID text field is empty
	 * 
	 * @return
	 */
	public boolean isSubServiceIDFieldEmpty() {
		return getSubServiceIDValue().equalsIgnoreCase("");
	}

}