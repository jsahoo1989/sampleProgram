/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	    : AIRES
 * Class Name                                           : BusinessFunctions
 * Owner                                                : Automation Team
 *****************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                      ---------
 * 27/02/2020			Rahul Sharma				Create Basic Structure
 * 03/03/2020			Rahul Sharma				Added application specific function to select drop down values by text and value
 * 07/04/2020			Rahul Sharma				Added common IRIS function to verify company name after search and close module windows
 * 21/05/2020			Rahul Sharma				Updated List function and replace Report class with Reporter
 *****************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 *  
 *****************************************************************************************************************
 * Functional Test Coverage Description   			   : Defined functional reusable methods 														   
 *****************************************************************************************************************
 * Notes                                                : NA
 * Assumptions                                          : NA
 * Limitations                                          : NA
=============List of Resources used====================================================================================
 * User Defined Functions                        	   : Business Functions
 * Recovery Scenarios                            	   : NA
 * Data Tables                                         : NA
 ***********************************Header End*********************************************************************************/
package com.aires.businessrules;

import java.math.RoundingMode;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.time.Duration;
import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.pages.pdt.PDT_GeneralInformationPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.Editor;
import com.vimalselvam.cucumber.listener.Reporter;

import stepDefinitions.pdt.PDT_SharedSubBenefit_Steps;

public class BusinessFunctions {
	public static int count = 0;
	static Logger LOG = Logger.getLogger(BusinessFunctions.class);
	public static String userNameValue, passwordValue;

	public static String encodedPassword(String password) {
		byte[] encodedBytes = Base64.encodeBase64(password.getBytes());
		Log.info("The Encrypted Password is :" + new String(encodedBytes));
		return new String(encodedBytes);
	}

	public static void selectItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList, String itemName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		for (WebElement row : WebElementList) {
			String text = row.getText();
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + text);
			if (row.getText().equals(itemName)) {
				CoreFunctions.clickUsingJS(driver, row, itemName);
				Reporter.addStepLog(CoreConstants.PASS + text + PDTConstants.IS_CLICKED);
				break;
			}
		}
	}

	public static void selectRadioAsPerLabelText(WebDriver driver, List<WebElement> WebElementList_Label,
			String labelName) {
		System.out.println("inside radio as per label text");
		System.out.println("count--" + WebElementList_Label.size());
		for (WebElement row : WebElementList_Label) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if ((row.getText().trim()).equals(labelName)) {
				CoreFunctions.click(driver, row, labelName);
				Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_CLICKED);
				break;
			}
		}
	}

	public static void generateUniqueValuesAndWriteToConfig(int uniqueStringLenght) {
		String randomString = CoreFunctions.generateRandomString(uniqueStringLenght);
		CoreFunctions.writeToPropertiesFile(PDTConstants.FIRST_NAME_TEXT, PDTConstants.FNAME + randomString);
		CoreFunctions.writeToPropertiesFile(PDTConstants.LAST_NAME_TEXT, PDTConstants.LNAME + randomString);
		CoreFunctions.writeToPropertiesFile(PDTConstants.RANDOM_STRING_TEXT, randomString);
		CoreFunctions.writeToPropertiesFile(PDTConstants.SPOUSE_NAME_TEXT, PDTConstants.SPOUSE_NAME + randomString);
		CoreFunctions.writeToPropertiesFile(PDTConstants.EMP_ID_TEXT, PDTConstants.EMP_ID + randomString);
	}

	public static void selectValueFromDropdown(WebElement element, String drpdwnValue) {
		Select dropDown = new Select(element);
		String elementName = element.getAttribute("title");
		dropDown.selectByVisibleText(drpdwnValue);
		if (element.getAttribute("title").equalsIgnoreCase(drpdwnValue))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_VALUE_SELECTED_IN_DROPDWON, CoreConstants.PASS,
					elementName, drpdwnValue));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_SELECT_VALUE_IN_DROPDOWN, CoreConstants.FAIL,
					drpdwnValue, elementName));
	}

	/**
	 * Verify message on alert dialogs.
	 * 
	 * @param dialog
	 * @param msg
	 * @param dialogName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public static boolean verifyMsgOnDialog(Dialog dialog, String msg, String dialogName)
			throws GeneralLeanFtException {
		if (dialog.getVisibleText().contains(msg)) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFIED_MESSAGE_ON_DIALOG, CoreConstants.PASS, msg,
					dialogName));
		}
		return dialog.getVisibleText().contains(msg);
	}

	/**
	 * Verify Text editor value in IRIS application.
	 * 
	 * @param editorName
	 * @param editorVal
	 * @param tabName
	 * @return
	 * @throws GeneralLeanFtException
	 */
	public static boolean verifyTextEditorValueInIris(Editor editorObj, String editorName, String editorVal,
			String tabName) throws GeneralLeanFtException {
		if (editorObj.getText().equals(editorVal))
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFIED_FIELD_ON_TAB, CoreConstants.PASS,
					editorName, editorVal, tabName));

		return editorObj.getText().equals(editorVal);
	}

	public static WebElement returnItemIfExistsInList(WebDriver driver, List<WebElement> _uploadDocumentFileList,
			String itemName) {
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _uploadDocumentFileList);
		for (WebElement element : _uploadDocumentFileList) {
			if (element.getText().equals(itemName)) {
				return element;
			}
		}
		return null;
	}

	public static void selectOptionValueFromDropdown(WebElement element, String drpdwnValue) {
		Select dropDown = new Select(element);
		String elementName = element.getAttribute("value");
		Log.info("elementName=" + elementName);
		dropDown.selectByValue(drpdwnValue);
		if (element.getAttribute("value").equalsIgnoreCase(drpdwnValue))
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_VALUE_SELECTED_IN_DROPDWON, CoreConstants.PASS,
					elementName, drpdwnValue));
		else
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_SELECT_VALUE_IN_DROPDOWN, CoreConstants.FAIL,
					drpdwnValue, elementName));
	}

	public static String getTestRailIdAsPerApplication(String appName, String scenarioTagName) {
		String value = null;
		switch (appName) {
		case CoreConstants.MYLO:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Mylo:") + 5,
					scenarioTagName.lastIndexOf("Mylo:") + 11);
			break;
		case CoreConstants.PDT:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Pdt:") + 4,
					scenarioTagName.lastIndexOf("Pdt:") + 10);
			break;
		case CoreConstants.COREFLEX:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Coreflex:") + 9,
					scenarioTagName.lastIndexOf("Coreflex:") + 15);
			break;
		default:
			Assert.fail(appName + PDTConstants.NOT_EXIST);
		}
		return value;
	}

	public static int getTestRailSectionIDAsPerApplication() {
		int sectionID = 0;
		// Commented Code is for debugging purpose
		/*
		 * String propertyFilePath = System.getProperty("user.dir") +
		 * "\\Configs\\Config.properties"; Properties properties = new Properties();
		 * properties.load(new FileReader(propertyFilePath)); String
		 * applicationName=properties.getProperty("application");
		 */
		String applicationName = System.getProperty("application");
		switch (applicationName) {
		case CoreConstants.MYLO:
			sectionID = 49911;
			break;
		case CoreConstants.PDT:
			sectionID = 49817;
			break;
		case CoreConstants.COREFLEX:
			sectionID = 49912;
			break;
		default:
			Assert.fail(CoreConstants.TAG_VALUE + PDTConstants.NOT_EXIST);
		}
		return sectionID;
	}

	public static int returnindexItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList,
			String itemName) {
		try {
			for (WebElement row : WebElementList) {
				CoreFunctions.hover(driver, row);
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().equals(itemName)) {
					CoreFunctions.highlightObject(driver, row);
					return WebElementList.indexOf(row);
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void verifyOtherTextBoxIsDisplayed(WebDriver driver, String jsonReimbursedBy, WebElement element,
			String jsonReimbursedByOther, String SubBenefitFormName, String lblOtherTextBox) {
		try {
			if (jsonReimbursedBy.equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, element, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, lblOtherTextBox, SubBenefitFormName));
				CoreFunctions.clearAndSetText(driver, element, lblOtherTextBox, jsonReimbursedByOther);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_FIELD, lblOtherTextBox, SubBenefitFormName));
		}
	}

	public static int returnindexItemFromListUsingAttribute(WebDriver driver, List<WebElement> WebElementList,
			String itemName, String attribute) {
		try {
			for (WebElement row : WebElementList) {
				Log.info("The Actual Item Name is :" + row.getAttribute(attribute));
				if (row.getAttribute(attribute).equals(itemName)) {
					return WebElementList.indexOf(row);
				}
			}
		} catch (ElementNotFoundException e) {
		}
		return -1;
	}

	public static WebElement returnItemFromListUsingAttribute(WebDriver driver, List<WebElement> WebElementList,
			String itemName, String attribute) {
		try {
			for (WebElement row : WebElementList) {
				Log.info("The Actual Item Name is :" + row.getAttribute(attribute));
				if (row.getAttribute(attribute).equals(itemName)) {
					return row;
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return null;
	}

	public static String selectAndReturnRandomValueFromDropDown(WebDriver driver, PDT_AddNewPolicyPage addNewPolicyPage,
			String subBenefitFormName, WebElement drpDownElement, List<WebElement> drpDownElementOptions,
			WebElement drpDownElementSelected, String lblDropDown) {
		String randValue = null;
		try {
			CoreFunctions.clickElement(driver, drpDownElement);
			if (drpDownElementOptions.size() == 0)
				Assert.fail("Drop down options are not populated for " + lblDropDown + " dropdown.");
			int index = CoreFunctions.getRandomNumber(0, drpDownElementOptions.size() - 1);
			randValue = drpDownElementOptions.get(index).getText();
			CoreFunctions.selectItemInListByText(driver, drpDownElementOptions, randValue, lblDropDown,
					PDTConstants.DROP_DOWN, true);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_SELECT_VALUE_FROM_FIELD, CoreConstants.FAIL,
					randValue, lblDropDown, PDTConstants.DROP_DOWN));
		}
		return randValue;
	}

	public static String[] getCSMCredentials(PDT_LoginDetails _loginDetailsApplication) {
		String csmCredentials[] = new String[7];
		//switch (CoreFunctions.getPropertyFromConfig("envt").toLowerCase()) {
		 switch (System.getProperty("envt").toLowerCase()) {
		case CoreConstants.ENVT_DEV:
			csmCredentials[0] = _loginDetailsApplication.dev.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.dev.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.dev.firstName + " " + _loginDetailsApplication.dev.lastName;
			csmCredentials[3] = _loginDetailsApplication.dev.mobilityxUrl;
			csmCredentials[4] = _loginDetailsApplication.dev.mobilityxUserName;
			csmCredentials[5] = _loginDetailsApplication.dev.mobilityxPassword;
			csmCredentials[6] = _loginDetailsApplication.dev.profileName;
			break;
		case CoreConstants.ENVT_QA:
			csmCredentials[0] = _loginDetailsApplication.qa.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.qa.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.qa.firstName + " " + _loginDetailsApplication.qa.lastName;
			csmCredentials[3] = _loginDetailsApplication.qa.mobilityxUrl;
			csmCredentials[4] = _loginDetailsApplication.qa.mobilityxUserName;
			csmCredentials[5] = _loginDetailsApplication.qa.mobilityxPassword;
			csmCredentials[6] = _loginDetailsApplication.qa.profileName;
			break;
		case CoreConstants.ENVT_TEST:
			csmCredentials[0] = _loginDetailsApplication.preProd.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.preProd.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.preProd.firstName + " "
					+ _loginDetailsApplication.preProd.lastName;
			csmCredentials[3] = _loginDetailsApplication.preProd.mobilityxUrl;
			csmCredentials[4] = _loginDetailsApplication.preProd.mobilityxUserName;
			csmCredentials[5] = _loginDetailsApplication.preProd.mobilityxPassword;
			csmCredentials[6] = _loginDetailsApplication.preProd.profileName;
			break;
		case CoreConstants.ENVT_UAT:
			csmCredentials[0] = _loginDetailsApplication.uat.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.uat.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.uat.firstName + " " + _loginDetailsApplication.uat.lastName;
			csmCredentials[3] = _loginDetailsApplication.uat.mobilityxUrl;
			csmCredentials[4] = _loginDetailsApplication.uat.mobilityxUserName;
			csmCredentials[5] = _loginDetailsApplication.uat.mobilityxPassword;
			csmCredentials[6] = _loginDetailsApplication.uat.profileName;
			break;
		case CoreConstants.ENVT_PROD:
			csmCredentials[0] = _loginDetailsApplication.prod.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.prod.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.prod.firstName + " " + _loginDetailsApplication.prod.lastName;
			csmCredentials[3] = _loginDetailsApplication.prod.mobilityxUrl;
			csmCredentials[4] = _loginDetailsApplication.prod.mobilityxUserName;
			csmCredentials[5] = _loginDetailsApplication.prod.mobilityxPassword;
			csmCredentials[6] = _loginDetailsApplication.prod.profileName;
			break;
		}
		return csmCredentials;
	}

	public static void verifyAndFillOtherTextBoxForSubBenefitForm(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, WebElement drpDown, String lblDrpDown,
			WebElement otherTextBox, String lblOtherTextBox, String otherTextBoxVal) {
		try {
			if (drpDown.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, otherTextBox, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED_FOR_DRPDOWN,
						CoreConstants.PASS, lblOtherTextBox, lblDrpDown, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, otherTextBox, PDTConstants.OTHER, otherTextBoxVal);
			} else if (drpDown.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& !CoreFunctions.isElementExist(driver, otherTextBox, 1)) {
				Assert.fail(MessageFormat.format(PDTConstants.OTHER_TEXTBOX_NOT_DISPLAYED, CoreConstants.FAIL,
						PDTConstants.OTHER, lblDrpDown, subBenefitFormName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.EXCEPTION_OCCURED_VERIFY_OTHER_TEXT_BOX, CoreConstants.FAIL,
					PDTConstants.OTHER, lblDrpDown, subBenefitFormName));
		}
	}

	public static void selectValueFromListUsingIndex(WebDriver driver, List<WebElement> listWebElement, int index) {
		try {
			CoreFunctions.explicitWaitTillElementListClickable(driver, listWebElement);
			listWebElement.get(index).click();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_ELEMENT_FROM_LIST,
					CoreConstants.FAIL, e.getMessage(), listWebElement.get(index).getText()));
		}
	}

	public static int returnindexItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList,
			String itemName, boolean flag) {
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if ((row.getText().trim()).contains(itemName))
					return WebElementList.indexOf(row);
			}
		} catch (ElementNotFoundException e) {
			Assert.fail(MessageFormat.format(
					MobilityXConstants.EXCEPTION_OCCURED_WHILE_RETURNING_INDEX_ITEM_FROM_LIST_USING_TEXT,
					CoreConstants.FAIL, e.getMessage()));
		}
		return -1;
	}

	public static void checkValidationBasedOnInput(boolean isValidationMessageDisplayed, String fieldName,
			String inputValue) {

		try {
			if ((Double.parseDouble(inputValue) < 0.5 || Double.parseDouble(inputValue) > 999.5)
					&& isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATIONS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			} else if ((Double.parseDouble(inputValue) < 0.5 || Double.parseDouble(inputValue) > 999.5)
					&& !isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_INVALID_RANGE, CoreConstants.FAIL,
						COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue, fieldName));
				throw new RuntimeException(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_INVALID_RANGE, CoreConstants.FAIL,
						COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue, fieldName));
			} else if ((Double.parseDouble(inputValue) >= 0.5 || Double.parseDouble(inputValue) <= 999.5)
					&& !isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATION_MESSAGE_NOT_DISPLAYED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			} else if ((Double.parseDouble(inputValue) >= 0.5 || Double.parseDouble(inputValue) <= 999.5)
					&& isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
				throw new RuntimeException(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE, CoreConstants.FAIL,
						COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue, fieldName));
			}
		} catch (NumberFormatException e) {
			if (isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATIONS_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			} else {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_NON_NUMERIC_INVALID_VALUE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
				throw new RuntimeException(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_NON_NUMERIC_INVALID_VALUE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			}
		}
	}

	public static void checkValidationBasedOnInput(String validationMessage, String fieldName, String inputValue) {

		if ((Double.parseDouble(inputValue) <= 0.99)
				&& validationMessage.equals(COREFLEXConstants.FIELD_VALUE_CANNOT_BE_LESS_THAN_ONE)) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATIONS_ON_FLEX_PLANNING_TOOL_PAGE,
							CoreConstants.PASS, validationMessage, inputValue, fieldName));
		} else if ((Double.parseDouble(inputValue) > 100)
				&& validationMessage.equals(COREFLEXConstants.FIELD_VALUE_CANNOT_BE_GREATER_THAN_HUNDRED)) {
			Reporter.addStepLog(
					MessageFormat.format(COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATIONS_ON_FLEX_PLANNING_TOOL_PAGE,
							CoreConstants.PASS, validationMessage, inputValue, fieldName));
		} else if ((Double.parseDouble(inputValue) >= 1) && (Double.parseDouble(inputValue) <= 100)
				&& ((validationMessage.isEmpty()))) {
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATION_MESSAGE_NOT_DISPLAYED_ON_FLEX_PLANNING_TOOL_PAGE,
					CoreConstants.PASS, validationMessage, inputValue, fieldName));
		} else if ((Double.parseDouble(inputValue) >= 1) && (Double.parseDouble(inputValue) <= 100)
				&& ((validationMessage.equals(COREFLEXConstants.FIELD_VALUE_CANNOT_BE_LESS_THAN_ONE))
						|| (validationMessage.equals(COREFLEXConstants.FIELD_VALUE_CANNOT_BE_GREATER_THAN_HUNDRED)))) {
			Reporter.addStepLog(MessageFormat.format(COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
					CoreConstants.FAIL, validationMessage, inputValue, fieldName));
			throw new RuntimeException(
					MessageFormat.format(COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
							CoreConstants.FAIL, validationMessage, inputValue, fieldName));
		}
	}

	public static int returnindexItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList, boolean flag,
			String itemName) {
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().equalsIgnoreCase(itemName)) {
					CoreFunctions.highlightObject(driver, row);
					return WebElementList.indexOf(row);
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static boolean verifyDisplayOfIndicateNumOfWeeksBefore(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, WebElement drpDown, String lblDrpDown,
			WebElement drpDownIndicateNumOfWeeksBefore) {
		try {
			if (drpDown.getText().equalsIgnoreCase(PDTConstants.NumOfWeeksBeforeStartTransferDate)
					&& CoreFunctions.isElementExist(driver, drpDownIndicateNumOfWeeksBefore, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DRP_DOWN_FIELD_DISPLAYED_FOR_OPTION,
						CoreConstants.PASS, PDTConstants.INDICATE_NUM_OF_WEEKS_BEFORE,
						PDTConstants.NumOfWeeksBeforeStartTransferDate, lblDrpDown, subBenefitFormName));
				return true;

			} else if (drpDown.getText().equalsIgnoreCase(PDTConstants.NumOfWeeksBeforeStartTransferDate)
					&& !CoreFunctions.isElementExist(driver, drpDownIndicateNumOfWeeksBefore, 1)) {
				Assert.fail(MessageFormat.format(PDTConstants.INDICATE_NUM_OF_WEEKS_BEFORE_NOT_DISPLAYED,
						CoreConstants.FAIL, PDTConstants.INDICATE_NUM_OF_WEEKS_BEFORE,
						PDTConstants.NumOfWeeksBeforeStartTransferDate, lblDrpDown, subBenefitFormName));
				return false;
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_AND_FILL_DROP_DOWN, CoreConstants.FAIL,
					PDTConstants.INDICATE_NUM_OF_WEEKS_BEFORE, subBenefitFormName));
		}
		return false;
	}

	public static void verifyTextBoxIsDisplayedAndEnterTextBoxVal(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, WebElement element, String lblElement,
			String expectedElementLabel, String elementVal) {
		try {
			if (lblElement.equalsIgnoreCase(expectedElementLabel) && CoreFunctions.isElementExist(driver, element, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, lblElement, subBenefitFormName));
				CoreFunctions.clearAndSetText(driver, element, lblElement, elementVal);
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_AND_FILL_TEXTBOX, CoreConstants.FAIL,
						lblElement, subBenefitFormName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_AND_FILL_TEXTBOX, CoreConstants.FAIL,
					lblElement, subBenefitFormName));
		}
	}

	public static void verifyDrpDownIsDisplayedAndSelectDropDownVal(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, WebElement drpDownElement,
			List<WebElement> drpDownElementOptions, String lblDropDown, String expectedDrpDownLabel,
			String drpDownVal) {
		try {
			if (CoreFunctions.isElementExist(driver, drpDownElement, 1)
					&& lblDropDown.equalsIgnoreCase(expectedDrpDownLabel)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DWN_FIELD_DISPLAYED,
						CoreConstants.PASS, lblDropDown, subBenefitFormName));
				CoreFunctions.clickElement(driver, drpDownElement);
				CoreFunctions.selectItemInListByText(driver, drpDownElementOptions, drpDownVal, lblDropDown,
						PDTConstants.DROP_DOWN, true);
			} else {
				Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_AND_SELECT_DRP_DOWN, CoreConstants.FAIL,
						drpDownVal, lblDropDown, subBenefitFormName));
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_AND_SELECT_DRP_DOWN, CoreConstants.FAIL,
					drpDownVal, lblDropDown, subBenefitFormName));
		}
	}

	public static boolean verifyDefaultOptionIsSelectedInDrpDown(String selectedOptionText, String expectedOption,
			String lblDrpDown) {
		if (selectedOptionText.equalsIgnoreCase(expectedOption)) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DEFAULT_OPTION_SELECTED, CoreConstants.PASS,
					expectedOption, lblDrpDown));
			return true;
		}
		return false;
	}

	public static void fluentWaitForSpinnerToDisappear(WebDriver driver, WebElement element) {
		if (CoreFunctions.isElementExist(driver, element, 9)) {
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(120))
					.pollingEvery(Duration.ofMillis(1000)).withMessage("Timeout occured!")
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
	}

	public static void printTimeTakenByPageToLoad(long timeBeforeAction, long timeAfterAction, String pageName) {
		DecimalFormat pgToLoadformat = new DecimalFormat();
		pgToLoadformat.setMaximumFractionDigits(3);
		Reporter.addStepLog("<b>Time taken by '" + pageName + "' page to Load is :"
				+ pgToLoadformat.format((timeAfterAction - timeBeforeAction) / 1000) + " Seconds </b>");
	}

	public static void printTimeTakenByPageToLoad(long timeBeforeAction, long timeAfterAction, String pageName,
			String subBenefitName) {
		DecimalFormat pgToLoadformat = new DecimalFormat();
		pgToLoadformat.setMaximumFractionDigits(3);
		Reporter.addStepLog(
				"<b>Time taken by sub-benefit:-'" + subBenefitName + "' to Load on '" + pageName + "' benefit page is:-"
						+ pgToLoadformat.format((timeAfterAction - timeBeforeAction) / 1000) + " Seconds </b>");
	}

	/**
	 * @param msg
	 * @param sectionType
	 * @return Verify Toast Messages appearing for Different Sections
	 */
	public static boolean verifyMyloToastMessage(WebDriver driver, WebElement element, String msg, String sectionType) {
		boolean flag = false;
		try {
			CoreFunctions.isElementVisible(element);
			CoreFunctions.highlightObject(driver, element);
			flag = (element.getAttribute("innerHTML").split("<")[0].equals(msg));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, MYLOConstants.ALERT_MESSAGE, sectionType));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, MYLOConstants.JOURNEY));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_ALERT_MESSAGE_NOT_DISPLAYED,
					CoreConstants.FAIL, msg, MYLOConstants.JOURNEY));
		return flag;
	}

	/**
	 * @param msg
	 * @param sectionType
	 * @return Verify Toast Messages appearing for Different Sections
	 */
	public static boolean verifyMyloPopUpMessage(WebDriver driver, WebElement element, String msg, String pageName) {
		boolean flag = false;
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, element.getText(), 60);
			CoreFunctions.highlightObject(driver, element);
			flag = (element.getText().equals(msg));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, CoreConstants.FAIL,
					MYLOConstants.EXPECTED_POPUP_MESSAGE+msg, pageName));
		}
		if (flag)
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.VERIFIED_POPUP_MESSAGE_DISPLAYED, CoreConstants.PASS,
					msg, pageName));
		else
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, msg,
					element.getText(), pageName));
		return flag;

	}

	public static boolean verifyMyloValidationMessage(String expectedMessage, String actualMessage,
			String sectionName) {
		boolean flag = actualMessage.equalsIgnoreCase(expectedMessage);
		String msg = (flag)
				? MessageFormat.format(MYLOConstants.VERIFIED_MESSAGE_DISPLAYED, CoreConstants.PASS, actualMessage,
						sectionName)
				: MessageFormat.format(MYLOConstants.EXPECTED_MESSAGE_DISPLAYED, CoreConstants.FAIL, expectedMessage,
						actualMessage, sectionName);
		Reporter.addStepLog(msg);
		return flag;
	}

	public static boolean verifyMyloButtonEnabilityStatus(String type, WebElement element, String btnName,
			String sectionName, String pageName) {
		boolean flag = false;
		List<String> disableTypeList = Stream.of(MYLOConstants.CANCELED, MYLOConstants.CLOSED,
				MYLOConstants.PAYMENT_CUT_OFF_COMPLETION, MYLOConstants.DISABLE).collect(Collectors.toList());
		try {
			flag = CoreFunctions.isElementVisible(element);
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_SECTION,
					CoreConstants.FAIL, element, sectionName));
		}
		if (disableTypeList.contains(type)||type.contains(MYLOConstants.WITHOUT)) {
			Assert.assertFalse(flag, MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.FAIL, btnName,
					sectionName, pageName));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.PASS, btnName,
					sectionName, pageName));
		} else {
			Assert.assertTrue(flag, MessageFormat.format(MYLOConstants.BUTTON_DISABLED, CoreConstants.FAIL, btnName,
					sectionName, pageName));
			Reporter.addStepLog(MessageFormat.format(MYLOConstants.BUTTON_ENABLED, CoreConstants.PASS, btnName,
					sectionName, pageName));
		}
		return flag;
	}

	/**
	 * Set any Mylo Input fields based on the parameter passed for fieldName,
	 * fieldValue, element,type and returns the UpdatedValue
	 * 
	 * @param driver
	 * @param fieldName
	 * @param fieldValue
	 * @param element
	 * @param type
	 * @return
	 */
	public static String setMyloInputFields(WebDriver driver, String fieldName, String fieldValue, WebElement element,
			String type) {
		String updatedValue = "";
		type = (fieldValue.equals(MYLOConstants.BLANK)) ? MYLOConstants.BLANK : type;
		switch (type) {
		case MYLOConstants.RANDOM_STRING:
			updatedValue = CoreFunctions.generateRandomCharacters(Integer.parseInt(fieldValue), 0);
			break;
		case MYLOConstants.RANDOM_INTEGER:
			updatedValue = String.valueOf(CoreFunctions.generateRandomNumberOfLength(Integer.parseInt(fieldValue)));
			break;
		case MYLOConstants.BLANK:
			updatedValue = CoreFunctions.setBlankField(driver, element, fieldName);
			break;
		case MYLOConstants.SPECIAL_CHARACTERS_STRING:
			updatedValue = CoreFunctions.generateRandomCharacters(4, 2);
			break;
		case MYLOConstants.VALUE:
			updatedValue = fieldValue;
			break;
		default:
			Assert.fail(MYLOConstants.ENTER_CORRECT_TYPE);
		}
		CoreFunctions.clearAndSetText(driver, element, fieldName, updatedValue);
		return updatedValue;
	}

	/**
	 * Set any Mylo Dropdown fields based on the parameter passed for
	 * fieldValue,locator,type and returns the UpdatedValue
	 * 
	 * @param driver
	 * @param locator
	 * @param fieldValue
	 * @return
	 */
	public static String setMyloDropdownFields(WebDriver driver, By locator, String fieldType, String fieldName) {
		String updatedValue = null;
		List<WebElement> optionList = CoreFunctions.getElementListByLocator(driver, locator);
		try {
			if (fieldType.equals(MYLOConstants.RANDOM)) {
				optionList.remove(0);
				updatedValue = CoreFunctions.getRandomElementValueFromList(driver, optionList);
			} else
				updatedValue = fieldType;
			selectItemFromListUsingText(driver, optionList, updatedValue);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_SELECT_VALUE_FROM_DROPDOWN, CoreConstants.FAIL,
					fieldType, fieldName));
		}
		return updatedValue;
	}

	/**
	 * Wait for Mylo Spinner to disappear
	 * 
	 * @param driver
	 * @param element
	 */
	public static void fluentWaitForMyloSpinnerToDisappear(WebDriver driver, WebElement element) {
		if (CoreFunctions.isElementExist(driver, element, 5)) {
			FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(90))
					.pollingEvery(Duration.ofMillis(1000)).withMessage("Timeout occured!")
					.ignoring(NoSuchElementException.class);
			wait.until(ExpectedConditions.invisibilityOf(element));
		}
	}

	public static WebElement returnElementFromListUsingAttribute(WebDriver driver, List<WebElement> WebElementList,
			String itemName, String attribute) {
		try {
			for (WebElement row : WebElementList) {
				Log.info("The Actual Item Name is :" + row.getAttribute(attribute));
				if (row.getAttribute(attribute).toLowerCase().contains(itemName.toLowerCase().replace(" ", "")))
					return row;
			}
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Assert.fail(CoreConstants.ERROR + PDTConstants.ELEMENT_NOT_FOUND);
		}
		return null;
	}

	public static ArrayList<String> getSubBenefitList(String key) {
		ArrayList<String> langTraining = new ArrayList<String>();
		langTraining.add(PDTConstants.LANGUAGE_TRAINING_EMPLOYEE);
		langTraining.add(PDTConstants.LANGUAGE_TRAINING_FAMILY);

		ArrayList<String> cultTraining = new ArrayList<String>();
		cultTraining.add(PDTConstants.CULTURAL_TRAINING_EMPLOYEE);
		cultTraining.add(PDTConstants.CULTURAL_TRAINING_FAMILY);

		ArrayList<String> immigration = new ArrayList<String>();
		immigration.add(PDTConstants.IMMIGRATION_FEES);
		immigration.add(PDTConstants.IMMIGRATION_TRAVEL);

		ArrayList<String> compServices = new ArrayList<String>();
		compServices.add(PDTConstants.LETTER_OF_ASSIGNMENT);
		compServices.add(PDTConstants.COST_ESTIMATE_WITH_TAX);
		compServices.add(PDTConstants.COST_ESTIMATE_WITHOUT_TAX);
		compServices.add(PDTConstants.BALANCE_SHEET);
		compServices.add(PDTConstants.ALLOWANCE_UPDATES);
		compServices.add(PDTConstants.GLOBAL_DATA_COLLECTION);
		compServices.add(PDTConstants.PAYROLL_INSTRUCTIONS);

		ArrayList<String> homeLeave = new ArrayList<String>();
		homeLeave.add(PDTConstants.HOME_LEAVE_TRANSPORTATION);
		homeLeave.add(PDTConstants.HOME_LEAVE_LODGING);
		homeLeave.add(PDTConstants.HOME_LEAVE_MEALS);

		ArrayList<String> houseHuntingTrip = new ArrayList<String>();
		houseHuntingTrip.add(PDTConstants.HOUSE_HUNTING_TRIP_TRANSPORTATION);
		houseHuntingTrip.add(PDTConstants.HOUSE_HUNTING_TRIP_LODGING);
		houseHuntingTrip.add(PDTConstants.HOUSE_HUNTING_TRIP_MEALS);

		ArrayList<String> oneTimePayments = new ArrayList<String>();
		oneTimePayments.add(PDTConstants.MISC_RELOCATION_ALLOWANCE);
		oneTimePayments.add(PDTConstants.LUMP_SUM);
		oneTimePayments.add(PDTConstants.LEASE_BREAK);
		oneTimePayments.add(PDTConstants.APPLIANCE_ALLOWANCE);
		oneTimePayments.add(PDTConstants.AUTO_REGISTRATION_COSTS);
		oneTimePayments.add(PDTConstants.AUTO_LOSS_ON_SALE);
		oneTimePayments.add(PDTConstants.OTHER_ONE_TIME_PAYMENT);

		ArrayList<String> houseHoldGoods = new ArrayList<String>();
		houseHoldGoods.add(PDTConstants.US_DOM_VANLINE_SHIPMENT);
		houseHoldGoods.add(PDTConstants.AUTO_SHIPMENT);
		houseHoldGoods.add(PDTConstants.SELF_MOVE);
		houseHoldGoods.add(PDTConstants.AIR_SHIPMENT);
		houseHoldGoods.add(PDTConstants.SEA_SHIPMENT);
		houseHoldGoods.add(PDTConstants.NONUS_INLAND_SHIPMENT);
		houseHoldGoods.add(PDTConstants.PERMANENT_STORAGE);
		houseHoldGoods.add(PDTConstants.PET_SHIPMENT);
		houseHoldGoods.add(PDTConstants.DISCARD_DONATE);

		ArrayList<String> finalMove = new ArrayList<String>();
		finalMove.add(PDTConstants.FINAL_MOVE_TRANSPORTATION);
		finalMove.add(PDTConstants.FINAL_MOVE_LODGING);
		finalMove.add(PDTConstants.FINAL_MOVE_MEALS);

		ArrayList<String> destinationServices = new ArrayList<String>();
		destinationServices.add(PDTConstants.AIRPORT_PICKUP);
		destinationServices.add(PDTConstants.AREA_TOUR);
		destinationServices.add(PDTConstants.AUTO_RENTAL_DURING_ASSIGNMENT);
		destinationServices.add(PDTConstants.CONCIERGE_SERVICES);
		destinationServices.add(PDTConstants.DEPARTURE_SERVICES);
		destinationServices.add(PDTConstants.FURNITURE_RENTAL);
		destinationServices.add(PDTConstants.REIMBURSEMENT_OF_MEMEBERSHIP_DUES);
		destinationServices.add(PDTConstants.EDUCATION_ASSISTANCE);
		destinationServices.add(PDTConstants.SETTLING_IN_SERVICES);
		destinationServices.add(PDTConstants.TRANSITION_ASSISTANCE_PROGRAM);
		destinationServices.add(PDTConstants.TUTION_AND_EDUCATION);

		ArrayList<String> tempLiving = new ArrayList<String>();
		tempLiving.add(PDTConstants.TEMPORARY_LIVING_LODGING);
		tempLiving.add(PDTConstants.TEMPORARY_LIVING_MEALS);
		tempLiving.add(PDTConstants.TEMPORARY_LIVING_TRANSPORTATION);

		ArrayList<String> assignmentHousing = new ArrayList<String>();
		assignmentHousing.add(PDTConstants.ASSIGNMENT_HOUSING);
		assignmentHousing.add(PDTConstants.SECURITY_DEPOSIT);
		assignmentHousing.add(PDTConstants.ASSIGNMENT_FINDER_FEES);

		ArrayList<String> homePurchase = new ArrayList<String>();
		homePurchase.add(PDTConstants.HOME_PURCHASE_CLOSING_COSTS);
		homePurchase.add(PDTConstants.HOME_PURCHASE_POINTS);
		homePurchase.add(PDTConstants.HOME_PURCHASE_INSPECTIONS);
		homePurchase.add(PDTConstants.HOME_PURCHASE_BONUS);
		homePurchase.add(PDTConstants.MORTGAGE_DIFFERENTIALS);
		homePurchase.add(PDTConstants.MORTGAGE_SUBSIDY);

		ArrayList<String> rentalAssistance = new ArrayList<String>();
		rentalAssistance.add(PDTConstants.RENTAL_TOUR);
		rentalAssistance.add(PDTConstants.FINDER_FEES);

		ArrayList<String> preAcceptance = new ArrayList<String>();
		preAcceptance.add(PDTConstants.CANDIDATE_SELECTION);
		preAcceptance.add(PDTConstants.PRE_ACCEPTANCE_TRIP_TRANSPORTATION);
		preAcceptance.add(PDTConstants.PRE_ACCEPTANCE_TRIP_LODGING);
		preAcceptance.add(PDTConstants.PRE_ACCEPTANCE_TRIP_MEALS);

		ArrayList<String> ongoingPayment = new ArrayList<String>();
		ongoingPayment.add(PDTConstants.COLA);
		ongoingPayment.add(PDTConstants.PER_DIEM);
		ongoingPayment.add(PDTConstants.MOBILITY_PREMIUM);
		ongoingPayment.add(PDTConstants.TRANSPORTATION_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HOUSING_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HOME_MAINTENANCE_ALLOWANCE);
		ongoingPayment.add(PDTConstants.FURNITURE_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HARDSHIP_ALLOWANCE);
		ongoingPayment.add(PDTConstants.BANKING_ALLOWANCE);
		ongoingPayment.add(PDTConstants.AT_SEA_ALLOWANCE);
		ongoingPayment.add(PDTConstants.COMMUTER_ALLOWANCE);
		ongoingPayment.add(PDTConstants.DIFFERENTIAL_ALLOWANCE);
		ongoingPayment.add(PDTConstants.GOODS_AND_SERVICES_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HOME_LEAVE_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HOME_RETENTION_ALLOWANCE);
		ongoingPayment.add(PDTConstants.HOUSEKEEPING_ALLOWANCE);
		ongoingPayment.add(PDTConstants.UTILITY_ALLOWANCE);
		ongoingPayment.add(PDTConstants.OTHER_ONGOING_ALLOWANCE);

		LinkedHashMap<String, ArrayList<String>> subBenefitMap = new LinkedHashMap<String, ArrayList<String>>();

		subBenefitMap.put(PDTConstants.LANG_TRAINING, langTraining);
		subBenefitMap.put(PDTConstants.CULT_TRAINING, cultTraining);
		subBenefitMap.put(PDTConstants.COMPENSATION_SERVICES, compServices);
		subBenefitMap.put(PDTConstants.HOME_LEAVE, homeLeave);
		subBenefitMap.put(PDTConstants.IMMIGRATION, immigration);
		subBenefitMap.put(PDTConstants.HOUSE_HUNTING_TRIP, houseHuntingTrip);
		subBenefitMap.put(PDTConstants.ONE_TIME_PAYMENTS_REIMBURSEMENTS, oneTimePayments);
		subBenefitMap.put(PDTConstants.HOUSEHOLD_GOODS, houseHoldGoods);
		subBenefitMap.put(PDTConstants.FINAL_MOVE, finalMove);
		subBenefitMap.put(PDTConstants.DESTINATION_SERVICES, destinationServices);
		subBenefitMap.put(PDTConstants.TEMPORARY_LIVING, tempLiving);
		subBenefitMap.put(PDTConstants.ASSIGNMENT_HOUSING_COMPANY_SPONSORED, assignmentHousing);
		subBenefitMap.put(PDTConstants.HOME_PURCHASE, homePurchase);
		subBenefitMap.put(PDTConstants.RENTAL_ASSISTANCE, rentalAssistance);
		subBenefitMap.put(PDTConstants.PRE_ACCEPTANCE_SERVICES, preAcceptance);
		subBenefitMap.put(PDTConstants.ONGOING_PAYMENTS_REIMBURSEMENTS, ongoingPayment);
		return subBenefitMap.get(key);
	}

	public static boolean checkIfBenefitHaveEditLabelFunctionality(String pageName) {
		ArrayList<String> benefitsHavingEditLabelFunct = new ArrayList<String>();
		benefitsHavingEditLabelFunct.add(PDTConstants.PRE_ACCEPTANCE_SERVICES);
		if (benefitsHavingEditLabelFunct.contains(pageName))
			return true;
		else
			return false;
	}

	public static void expandSubBenefitIfCollapsed(WebElement subBenefitFormHeader, String subBenefitName,
			WebDriver driver) {
		try {
			if (subBenefitFormHeader.getAttribute("class").equalsIgnoreCase("collapsed"))
				CoreFunctions.clickElement(driver, subBenefitFormHeader);
		} catch (Exception e) {
			Assert.fail("Failed to expand sub benefit form:-" + subBenefitName);
		}
	}

	public static boolean verifySubBenefitFormHeaderIsDisplayed(WebDriver driver, WebElement element,
			String subBenefitName, String pageName) {
		CoreFunctions.explicitWaitTillElementVisibility(driver, element, subBenefitName);
		if (element.isDisplayed()) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_FORM_IS_DISPLAYED, CoreConstants.PASS,
					subBenefitName, pageName));
			return true;
		}
		return false;
	}

	public static boolean verifySelectedPolicyBenefitCategoryName(WebDriver driver, WebElement element,
			String pageName) {
		try {
			CoreFunctions.explicitWaitForElementTextPresent(driver, element, pageName, 3);
			return CoreFunctions.verifyElementOnPage(driver, element, PDTConstants.POLICY_BENEFIT_CATEGORY, pageName,
					pageName, true);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_ELEMENT_VAL_ON_PAGE, CoreConstants.FAIL,
					PDTConstants.POLICY_BENEFIT_CATEGORY, pageName, pageName, element.getText()));
			return false;
		}
	}

	public static boolean verifySubBenefitCategoriesAreDisplayed(WebDriver driver,
			List<String> subBenefitsFromDataTable, String pageName, List<WebElement> _subBenefitCategories) {
		CoreFunctions.explicitWaitTillElementListClickable(driver, _subBenefitCategories);
		if (subBenefitsFromDataTable
				.equals(CoreFunctions.getElementTextAndStoreInList(driver, _subBenefitCategories))) {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SUB_BENEFITS_DISPLAYED, CoreConstants.PASS,
					subBenefitsFromDataTable.toString(), pageName));
			return true;
		} else
			return false;
	}

	public static boolean verifyPopUpContent(WebDriver driver, WebElement element, String elementName,
			String elementVal, String popupName, boolean displayMsgInReport) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			if (element.getText().trim().equals(elementVal) && displayMsgInReport) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_POPUP_CONTENTS, CoreConstants.PASS,
						elementName, elementVal, popupName));
				CoreFunctions.highlightObject(driver, element);
				return true;
			} else if (element.getText().trim().equals(elementVal) && !displayMsgInReport) {
				CoreFunctions.highlightObject(driver, element);
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_POPUP_CONTENTS, CoreConstants.FAIL,
						elementName, elementVal, popupName, element.getText()));
				return false;
			}

		} catch (Exception e) {
			return false;
		}
	}

	public static boolean verifyAllExpenseCodesArePopulatedForSubBenefit(WebDriver driver, String benefitName,
			String subBenefitName, List<WebElement> _drpDownOptionsExpenseCode) {
		try {
			if (CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsExpenseCode)
					.equals(DbFunctions.getExpenseCodeListForBenefit(benefitName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_POPULATED,
						CoreConstants.PASS, subBenefitName));
				return true;
			}
			// Log.info(driver.findElements(By.cssSelector("ng-select[formcontrolname='culturalTrainingEmployeeExpenseCodeList']
			// span.ng-option-label.ng-star-inserted")).get(2).getText());
		} catch (Exception e) {
			Reporter.addStepLog("Exception occured while verifying expense code for sub-benefit:-" + subBenefitName);
			return false;
		}
		return false;
	}

	public static List<String> getExpenseCode(WebDriver driver, List<WebElement> _drpDownOptionsExpenseCode) {
		List<String> drpDownOptions = CoreFunctions.getElementTextAndStoreInList(driver, _drpDownOptionsExpenseCode);
		List<String> expenseCodesList = new ArrayList<String>();
		for (String options : drpDownOptions) {
			expenseCodesList.add(options.substring(0, options.indexOf("-") - 1).trim());
		}
		return expenseCodesList;
	}

	public static boolean verifyAllExpenseCodesListForSubBenefit(WebDriver driver, String benefitName,
			String subBenefitName, List<WebElement> _drpDownOptionsExpenseCode) {
		try {
			if (getExpenseCode(driver, _drpDownOptionsExpenseCode)
					.equals(DbFunctions.getExpenseCodeForBenefit(benefitName))) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EXPENSE_CODE_OPTIONS_POPULATED,
						CoreConstants.PASS, subBenefitName));
				return true;
			}
		} catch (Exception e) {
			Reporter.addStepLog("Exception occured while verifying expense code for sub-benefit:-" + subBenefitName);
			return false;
		}
		return false;
	}

	/**
	 * Select random Multiple drop down options
	 * 
	 * @param driver
	 * @param dropDownName
	 * @param _drpDown
	 * @param _drpDownOptions
	 * @param _drpDownSelectedOptions
	 * @param randOptions
	 * @param subBenefitFormName
	 */
	public static void selectRandomDropDownOption(WebDriver driver, String dropDownName, WebElement _drpDown,
			List<WebElement> _drpDownOptions, List<WebElement> _drpDownSelectedOptions, List<String> randOptions,
			String subBenefitFormName) {
		try {

			for (String options : randOptions) {
				CoreFunctions.selectItemInListByText(driver, _drpDownOptions, options.trim(), dropDownName,
						PDTConstants.DROP_DOWN, true);
			}
			if (_drpDownSelectedOptions.size() > 1 && randOptions
					.equals(CoreFunctions.getElementTextAndStoreInList(driver, _drpDownSelectedOptions).toString())) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_DROP_DOWN_MULTISELECT,
						CoreConstants.PASS, dropDownName,
						CoreFunctions.getElementTextAndStoreInList(driver, _drpDownSelectedOptions).toString()));
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_SELECT_MULTIPLE_OPTIONS, CoreConstants.FAIL,
					dropDownName, subBenefitFormName));
		}
	}
	
	public static String setDifferentDropDownFieldsForMylo(WebDriver driver, String fieldValue,
			List<WebElement> optionList) {
		String updatedValue = null;
		if (fieldValue.equals(MYLOConstants.RANDOM)) {
			optionList.remove(0);
			updatedValue = CoreFunctions.getRandomElementValueFromList(driver, optionList);
			BusinessFunctions.selectItemFromListUsingText(driver, optionList, updatedValue);
		} else {
			updatedValue = fieldValue;
			BusinessFunctions.selectItemFromListUsingText(driver, optionList, fieldValue);
		}
		return updatedValue;
	}


	/**
	 * Select and Return single random drop down option
	 * 
	 * @param driver
	 * @param _drpDown
	 * @param _drpDownOptions
	 * @param _lblDrpDown
	 * @return
	 */
	public static String selectAndReturnRandomOptionFromDropDown(WebDriver driver, WebElement _drpDown,
			List<WebElement> _drpDownOptions, WebElement _lblDrpDown) {
		String randOptionDrpDown = null;
		try {
			CoreFunctions.clickElement(driver, _drpDown);
			CoreFunctions.explicitWaitTillElementListVisibility(driver, _drpDownOptions);
			randOptionDrpDown = _drpDownOptions.get(CoreFunctions.getRandomNumber(0, _drpDownOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownOptions, randOptionDrpDown, _lblDrpDown.getText(),
					PDTConstants.DROP_DOWN, true);

		} catch (Exception e) {
			Assert.fail("Failed to select random option from drop down:-" + _lblDrpDown.getText());
		}
		return randOptionDrpDown;
	}

	/**
	 * Select and return random value from radio button.
	 * 
	 * @param driver
	 * @param radioButtonList
	 * @param lblRadioButton
	 * @return
	 */
	public static String selectAndReturnRandomValFromRadioButton(WebDriver driver, List<WebElement> radioButtonList,
			WebElement lblRadioButton) {
		String randRadioButton = null;
		try {
			randRadioButton = radioButtonList.get(CoreFunctions.getRandomNumber(0, radioButtonList.size() - 1))
					.getText().trim();
			CoreFunctions.selectItemInListByText(driver, radioButtonList, randRadioButton, lblRadioButton.getText(),
					PDTConstants.RADIO_BUTTON_LIST, true);
		} catch (Exception e) {
			Assert.fail("Failed to select random value from radio button:-" + lblRadioButton.getText());
		}
		return randRadioButton;
	}

	public static boolean verifyRadioButtonIsSelected(WebDriver driver, List<WebElement> _radioLabelList,
			List<WebElement> _radioButtonList, String expectedSelection, String fieldName, String lblSelectedText) {
		int index = BusinessFunctions.returnindexItemFromListUsingText(driver, _radioLabelList, expectedSelection);
		if (_radioButtonList.get(index).getAttribute("checked").equalsIgnoreCase("true")) {
			CoreFunctions.highlightObject(driver, _radioButtonList.get(index));
			Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_SELECTED_VAL_FOR_RADIO_BTN,
					CoreConstants.PASS, lblSelectedText, fieldName, expectedSelection));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_SELECTED_VAL_FOR_RADIO_BTN,
					CoreConstants.PASS, lblSelectedText, fieldName, expectedSelection));
			return false;
		}
	}

	public static void verifyDefaultSelectedRadioButtonForField(WebDriver driver, List<WebElement> _radioLabelList,
			List<WebElement> _radioButtonList, String fieldName, String expectedSelection,
			PDT_GeneralInformationPage generalInfoPage, PDT_SharedSubBenefit_Steps sharedSubBenefitStep) {
		if (generalInfoPage.getExpenseMgmt().equalsIgnoreCase(PDTConstants.YES)) {
			sharedSubBenefitStep.getCustomSoftAssertObj().assertTrue(
					verifyRadioButtonIsSelected(driver, _radioLabelList, _radioButtonList, expectedSelection, fieldName,
							PDTConstants.DEFAULT_SELECTED),
					MessageFormat.format(PDTConstants.FAILED_TO_VERIFY_RADIO_BTN, CoreConstants.FAIL, PDTConstants.DEFAULT_SELECTED, fieldName,
							expectedSelection));
		}
	}
}