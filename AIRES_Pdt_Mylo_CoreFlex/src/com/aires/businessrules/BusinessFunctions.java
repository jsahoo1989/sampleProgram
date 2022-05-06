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
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import com.aires.businessrules.constants.COREFLEXConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.pages.pdt.PDT_AddNewPolicyPage;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.EmailUtil;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.java.Dialog;
import com.hp.lft.sdk.java.Editor;
import com.hp.lft.sdk.java.EditorDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.vimalselvam.cucumber.listener.Reporter;

public class BusinessFunctions {
	private static String windowTitle;
	private static Editor editor;
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
		CoreFunctions.waitHandler(3);
		for (WebElement row : WebElementList) {
			String text=row.getText();
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + text);
			if (row.getText().equals(itemName)) {
				CoreFunctions.clickUsingJS(driver, row, itemName);
				Reporter.addStepLog(CoreConstants.PASS + text + PDTConstants.IS_CLICKED);
				break;
			}
		}
	}

	public static Boolean verifyItemExistsInList(WebDriver driver, List<WebElement> webElementList, String itemName) {
		Boolean isExists = false;
		CoreFunctions.explicitWaitTillElementListVisibility(driver, webElementList);
		try {
			for (WebElement row : webElementList) {
				if (row.getText().equals(itemName)) {
					isExists = true;
					CoreFunctions.highlightObject(driver, row);
					CoreFunctions.hover(driver, row);
					Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_DISPLAYED);
					break;
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return isExists;
	}

	public static Boolean verifyItemExistsInList(WebDriver driver, List<WebElement> webElementList, String elementName,
			String elementVal, String pageName, boolean displayMsgInReport) {
		Boolean isExists = false;
		CoreFunctions.explicitWaitTillElementListVisibility(driver, webElementList);
		try {
			for (WebElement row : webElementList) {
				if (row.getText().equals(elementVal)) {
					isExists = true;
					CoreFunctions.highlightObject(driver, row);
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_ELEMENT_VALUE_ON_PAGE,
							CoreConstants.PASS, elementName, elementVal, pageName));
					break;
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return isExists;
	}

	public static void selectItemFromListUsingAttribute(WebDriver driver, List<WebElement> WebElementList,
			String itemName, String attributeValue) {
		CoreFunctions.waitHandler(2);
		for (WebElement row : WebElementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getAttribute(attributeValue).equals(itemName)) {
				Reporter.addStepLog(CoreConstants.PASS + row.getAttribute(attributeValue) + PDTConstants.IS_CLICKED);
				CoreFunctions.click(driver, row, itemName);
				break;
			} else {
				System.out.println("Attribute value in else--" + row.getAttribute(attributeValue));
				System.out.println("Itemname in else--" + row.getAttribute(itemName));
			}
		}
	}

	public static void selectRadioAsPerLabelText(WebDriver driver, List<WebElement> WebElementList_Label,
			String labelName) {
		CoreFunctions.waitHandler(2);
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

	public static void selectRadioAsPerLabelText(WebDriver driver, List<WebElement> WebElementList_Label,
			String labelName, String radioBtnLabel) {
		CoreFunctions.waitHandler(2);
		System.out.println("inside radio as per label text");
		System.out.println("count--" + WebElementList_Label.size());
		for (WebElement row : WebElementList_Label) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().equals(labelName)) {
				CoreFunctions.clickElement(driver, row);
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_OPTION_CHOSEN_FOR_RADIO_BTN,
						CoreConstants.PASS, radioBtnLabel, row.getText()));
				break;
			}
		}
	}

	public static void selectCheckBoxFromListAsPerLabelText(WebDriver driver, List<WebElement> WebElementList_Label,
			String labelName) {
		CoreFunctions.waitHandler(2);
		System.out.println("inside radio as per label text");
		System.out.println("count--" + WebElementList_Label.size());
		for (WebElement row : WebElementList_Label) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().equals(labelName)) {
				CoreFunctions.highlightObject(driver, row);
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

	public static Boolean verifyCompanyNameAfterSearch(String expectedCompanyName) throws Exception {
		Boolean isExists = false;
		windowTitle = getWindowText.getActiveWindowText();
		Log.info(windowTitle);
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		editor = window.describe(Editor.class, new EditorDescription.Builder().attachedText("Name*").build());
		if (editor.getText().equalsIgnoreCase(expectedCompanyName)) {
			isExists = true;
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.PARTNER_TAB + CoreConstants.EDITOR_NAME
					+ CoreConstants.IS_DISPLAYED_AS + editor.getText());
		} else {
			Reporter.addStepLog(CoreConstants.FAIL + CoreConstants.PARTNER_TAB + CoreConstants.EDITOR_NAME
					+ PDTConstants.IS_NOT_DISPLAYED);
			Assert.fail(CoreConstants.PARTNER_TAB + CoreConstants.EDITOR_NAME + PDTConstants.IS_NOT_DISPLAYED);
		}
		return isExists;
	}

	public static void closeModuleWindow() throws GeneralLeanFtException {
		windowTitle = getWindowText.getActiveWindowText();
		Window window = Desktop.describe(Window.class, new WindowDescription.Builder().title(windowTitle).build());
		window.close();
	}

	public static void selectCheckBoxAsPerLabelText(WebDriver driver, WebElement WebElementList_Label,
			String labelName) {
		CoreFunctions.waitHandler(2);
		Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + WebElementList_Label.getText());
		if (WebElementList_Label.getText().equals(labelName)) {
			CoreFunctions.click(driver, WebElementList_Label, labelName);
			Reporter.addStepLog(CoreConstants.PASS + WebElementList_Label.getText() + PDTConstants.IS_CLICKED);
		}
	}

	public static WebElement returnItemIfExistsInList(WebDriver driver, List<WebElement> _delElementList,
			List<WebElement> _uploadDocumentFileList, String itemName) {
		WebElement element = null;
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _uploadDocumentFileList);
		try {
			for (WebElement row : _uploadDocumentFileList) {
				if (row.getText().equals(itemName)) {
					return element = _delElementList.get(_uploadDocumentFileList.indexOf(row));
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static WebElement returnItemIfExistsInListUsingAttributeValue(WebDriver driver,
			List<WebElement> _delIconList, List<WebElement> _itemList, String itemName) {
		WebElement element = null;
		CoreFunctions.explicitWaitTillElementListVisibility(driver, _itemList);
		try {
			for (WebElement row : _itemList) {
				if (row.getAttribute("value").equalsIgnoreCase(itemName)) {
					return element = _delIconList.get(_itemList.indexOf(row));
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return element;
	}

	public static void selectValueFromDropdownWithoutReporting(WebElement element, String drpdwnValue) {
		Select dropDown = new Select(element);
		dropDown.selectByVisibleText(drpdwnValue);
	}

	public static void selectValueFromDropdownList(List<WebElement> listWebElement, int index) {
		listWebElement.get(index).click();
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

	public static void selectItemFromListUsingJs(WebDriver driver, List<WebElement> WebElementList, String itemName) {
		CoreFunctions.waitForBrowserToLoad(driver);
		CoreFunctions.waitHandler(3);
		for (WebElement row : WebElementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().equals(itemName)) {
				CoreFunctions.clickUsingJS(driver, row, itemName);
				Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_CLICKED);
				break;
			}
		}
	}

	public static boolean verifySelectedValueInDropdown(WebElement element, String drpdwnValue) {
		if (element.getAttribute("title").equalsIgnoreCase(drpdwnValue)) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFY_VALUE_IN_DROPDOWN, CoreConstants.PASS, drpdwnValue));
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_VALUE_IN_DROPDOWN, CoreConstants.FAIL,
					drpdwnValue));
			return false;
		}
	}

	public static boolean verifyValueInTextFieldByAttribute(WebDriver driver, WebElement element, String drpdwnValue) {
		if (element.getAttribute("value").equalsIgnoreCase(drpdwnValue)) {
			Reporter.addStepLog(
					MessageFormat.format(PDTConstants.VERIFY_VALUE_IN_TEXTFIELD, CoreConstants.PASS, drpdwnValue));
			CoreFunctions.highlightObject(driver, element);
			return true;
		} else {
			Reporter.addStepLog(MessageFormat.format(PDTConstants.FAIL_TO_VERIFY_VALUE_IN_TEXTFIELD, CoreConstants.FAIL,
					drpdwnValue));
			return false;
		}
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

	public static void updateQuery(String url, String query) {
		Connection connection = null;
		try {
			DriverManager.registerDriver(new oracle.jdbc.OracleDriver());
			connection = DriverManager.getConnection(url);
			Statement st = connection.createStatement();
			CoreFunctions.waitHandler(2);
			st.executeUpdate(query);
			CoreFunctions.waitHandler(2);
			st.executeUpdate("commit");
			CoreFunctions.waitHandler(5);
			if (true) {
				Log.info("executed successfully : " + query);
			}
			connection.close();
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex);
		}
	}

	public static void selectOptionValueFromDropdown(WebElement element, int index) {
		Select dropDown = new Select(element);
		dropDown.selectByIndex(index);
		Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_VALUE_SELECTED_IN_DROPDWON, CoreConstants.PASS,
				element.getAttribute("title")));
	}

	public static String getTestRailIdAsPerEnvt(String tagValue, String scenarioTagName) {
		String value = null;
		switch (tagValue) {
		case CoreConstants.VALUE_AT_PRE_PROD:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Pre:") + 4,
					scenarioTagName.lastIndexOf("Pre:") + 10);
			break;
		case CoreConstants.VALUE_AT_POST_PROD:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Post:") + 5,
					scenarioTagName.lastIndexOf("Post:") + 11);
			break;
		case CoreConstants.VALUE_AT_PERFORMANCE:
			value = scenarioTagName.substring(scenarioTagName.indexOf("Perf:") + 5,
					scenarioTagName.lastIndexOf("Perf:") + 11);
			break;
		default:
			Assert.fail(tagValue + PDTConstants.NOT_EXIST);
		}
		return value;
	}

	public static int getTestRailSectionIDAsPerEnvt() {
		int sectionID = 0;
		switch (CoreConstants.TAG_VALUE) {
		case CoreConstants.VALUE_AT_PRE_PROD:
			sectionID = 49625;
			break;
		case CoreConstants.VALUE_AT_POST_PROD:
			sectionID = 49638;
			break;
		case CoreConstants.VALUE_AT_PERFORMANCE:
			sectionID = 49809;
			break;
		default:
			Assert.fail(CoreConstants.TAG_VALUE + PDTConstants.NOT_EXIST);
		}
		return sectionID;
		// return
		// CoreConstants.TAG_VALUE.equalsIgnoreCase(CoreConstants.VALUE_AT_PRE_PROD) ?
		// 49625 : 49638;
	}

	public static int getRandomNumberFromList(int size) {
		Random rand = new Random();
		return rand.nextInt(size);
	}

	public static Boolean verifyTextExistsInList(WebDriver driver, List<WebElement> webElementList, String itemName) {
		Boolean isExists = false;
		CoreFunctions.explicitWaitTillElementListVisibility(driver, webElementList);
		try {
			for (WebElement row : webElementList) {
				if (row.getText().contains(itemName)) {
					isExists = true;
					CoreFunctions.highlightObject(driver, row);
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_EMPL_HEADING_POPUP,
							CoreConstants.PASS, row.getText()));
					break;
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return isExists;
	}

	public static String setMoneyFormat(double amount) {
		DecimalFormat df = new DecimalFormat("0.00");
		df.setRoundingMode(RoundingMode.UP);
		df.setGroupingUsed(true);
		df.setGroupingSize(3);
		return df.format(amount);
	}

	public static void getUserNameAndPasswordFromEmail() throws Exception {

		String userID = EmailUtil.searchEmailAndReturnResult(PDTConstants.HOST_EMAIL_DOMAIN,
				PDTConstants.EMAIL_USERNAME, PDTConstants.AUTO_EMAIL_PWD, PDTConstants.EXCEPTION_EMAIL_SENDER,
				PDTConstants.EMAIL_USERNAME_SUBJECT, PDTConstants.TRANSFEREE_USER_NAME);
		passwordValue = EmailUtil.searchEmailAndReturnResult(PDTConstants.HOST_EMAIL_DOMAIN,
				PDTConstants.EMAIL_USERNAME, PDTConstants.AUTO_EMAIL_PWD, PDTConstants.EXCEPTION_EMAIL_SENDER,
				PDTConstants.EMAIL_PASSWORD_SUBJECT, PDTConstants.TRANSFEREE_PASSWORD);
		String s1 = userID.replace("in main script result==", "");
		String s2 = s1.replace(":", "").trim();
		userNameValue = s2.replace("</span>", "").trim();
		CoreFunctions.writeToPropertiesFile("Transferee_UserNameInEMail", userNameValue);
		CoreFunctions.waitHandler(20);

	}

	public static void selectItemFromListUsingTextAndDoubleClick(WebDriver driver, List<WebElement> WebElementList,
			String itemName) {
		for (WebElement element : WebElementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + element.getText());
			if (element.getText().contains(itemName) && CoreFunctions.verifyElementPresentOnPage(element, itemName)) {
				CoreFunctions.highlightObject(driver, element);
				Actions act = new Actions(driver);
				act.moveToElement(element).doubleClick().build().perform();
			}
		}
	}

	public static int returnindexItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList,
			String itemName) {
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().equals(itemName)) {
					return WebElementList.indexOf(row);
				}
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
		}
		return -1;
	}

	public static void clickItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList, String itemName) {
		CoreFunctions.waitHandler(8);
		for (WebElement row : WebElementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
			if (row.getText().equals(itemName)) {
				CoreFunctions.click(driver, row, row.getText());
				Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_CLICKED);
				break;
			}
		}
	}

	public static void selectOptValueFromDropdown(WebElement element, String drpdwnValue) {
		CoreFunctions.waitHandler(5);
		Select dropDown = new Select(element);
		dropDown.selectByValue(drpdwnValue);
	}

	public static WebElement returnReportNameIfContainsInList(WebDriver driver, List<WebElement> _elementList,
			String itemName) {
		for (WebElement element : _elementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + element.getText());
			System.out
					.println("Substring Report Name " + element.getText().substring(0, element.getText().indexOf('.')));
			if (itemName.contains(element.getText().substring(0, element.getText().indexOf('.')))) {
				return element;
			}
		}
		return null;
	}

	public static WebElement returnItemIfContainsInList(WebDriver driver, List<WebElement> _elementList,
			String itemName) {
		for (WebElement element : _elementList) {
			Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + element.getText());
			if (element.getText().contains(itemName)) {
				return element;
			}
		}
		return null;
	}

	public static String selectRandomValueFormDropDown(WebDriver driver, List<WebElement> dropDownList) {
		WebElement selectedOption = dropDownList.get(ThreadLocalRandom.current().nextInt(1, dropDownList.size()));
		selectedOption.click();
		return selectedOption.getText();
	}

	public static boolean compareList(List<String> actualList, List<String> expectedList) {
		if (actualList.equals(expectedList)) {
			return true;
		} else {
			return false;
		}
	}

	public static List<String> sortList(List<String> listToBeSorted, String sortingOrder) {
		try {
			Comparator<String> c = null;
			switch (sortingOrder) {
			case PDTConstants.DESCENDING:
				c = (I1, I2) -> (I2.compareTo(I1));
				break;
			case PDTConstants.ASCENDING:
				c = (I1, I2) -> (I1.compareTo(I2));
				break;
			default:
				Assert.fail(PDTConstants.INVALID_SORT_OPERATION);
			}
			Collections.sort(listToBeSorted, c);
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex.getMessage());
			Assert.fail(CoreConstants.ERROR + PDTConstants.UNABLE_TO_SORT_LIST);
		}
		return listToBeSorted;
	}

	public static void verifyReimbursedByOtherTextBoxIsDisplayed(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String jsonReimbursedBy, WebElement element,
			String jsonReimbursedByOther, String SubBenefitFormName) {
		try {
			if (jsonReimbursedBy.equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, element, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED,
						CoreConstants.PASS, PDTConstants.REIMBURSED_BY_OTHER, SubBenefitFormName));
				CoreFunctions.clearAndSetText(driver, element, PDTConstants.REIMBURSED_BY_OTHER, jsonReimbursedByOther);
			}
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAILED_TO_FILL_FIELD, PDTConstants.REIMBURSED_BY_OTHER,
					SubBenefitFormName));
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
		CoreFunctions.waitHandler(3);
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
			String subBenefitFormName, WebElement _drpDownElement, List<WebElement> _drpDownElementOptions,
			WebElement _drpDownElementSelected, WebElement _lblDropDown) {
		String randValue = null;
		try {
			CoreFunctions.clickElement(driver, _drpDownElement);
			randValue = _drpDownElementOptions.get(CoreFunctions.getRandomNumber(0, _drpDownElementOptions.size() - 1))
					.getText();
			CoreFunctions.selectItemInListByText(driver, _drpDownElementOptions, randValue, _lblDropDown.getText(),
					PDTConstants.DROP_DOWN, true);
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_SELECT_VALUE_FROM_FIELD, CoreConstants.FAIL,
					randValue, _lblDropDown.getText(), PDTConstants.DROP_DOWN));
		}
		return randValue;
	}

	public static String[] getClientAndPolicyDetails(PDT_LoginDetails _loginDetailsApplication) {
		String clientAndPolicyDetailsArr[] = new String[3];
		switch (CoreFunctions.getPropertyFromConfig("envt").toLowerCase()) {
		case CoreConstants.ENVT_DEV:
			clientAndPolicyDetailsArr[0] = _loginDetailsApplication.dev.clientId;
			clientAndPolicyDetailsArr[1] = _loginDetailsApplication.dev.clientName;
			clientAndPolicyDetailsArr[2] = _loginDetailsApplication.dev.policy;
			break;
		case CoreConstants.ENVT_QA:
			clientAndPolicyDetailsArr[0] = _loginDetailsApplication.qa.clientId;
			clientAndPolicyDetailsArr[1] = _loginDetailsApplication.qa.clientName;
			clientAndPolicyDetailsArr[2] = _loginDetailsApplication.qa.policy;
			break;
		case CoreConstants.ENVT_TEST:
			clientAndPolicyDetailsArr[0] = _loginDetailsApplication.preProd.clientId;
			clientAndPolicyDetailsArr[1] = _loginDetailsApplication.preProd.clientName;
			clientAndPolicyDetailsArr[2] = _loginDetailsApplication.preProd.policy;
			break;
		case CoreConstants.ENVT_UAT:
			clientAndPolicyDetailsArr[0] = _loginDetailsApplication.uat.clientId;
			clientAndPolicyDetailsArr[1] = _loginDetailsApplication.uat.clientName;
			clientAndPolicyDetailsArr[2] = _loginDetailsApplication.uat.policy;
			break;
		case CoreConstants.ENVT_PROD:
			clientAndPolicyDetailsArr[0] = _loginDetailsApplication.prod.clientId;
			clientAndPolicyDetailsArr[1] = _loginDetailsApplication.prod.clientName;
			clientAndPolicyDetailsArr[2] = _loginDetailsApplication.prod.policy;
			break;
		}
		return clientAndPolicyDetailsArr;
	}

	public static String[] getCSMCredentials(PDT_LoginDetails _loginDetailsApplication) {
		String csmCredentials[] = new String[3];
		switch (CoreFunctions.getPropertyFromConfig("envt").toLowerCase()) {
		case CoreConstants.ENVT_DEV:
			csmCredentials[0] = _loginDetailsApplication.dev.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.dev.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.dev.csmUserFirstName;
			break;
		case CoreConstants.ENVT_QA:
			csmCredentials[0] = _loginDetailsApplication.qa.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.qa.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.qa.csmUserFirstName;
			break;
		case CoreConstants.ENVT_TEST:
			csmCredentials[0] = _loginDetailsApplication.preProd.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.preProd.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.preProd.csmUserFirstName;
			break;
		case CoreConstants.ENVT_UAT:
			csmCredentials[0] = _loginDetailsApplication.uat.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.uat.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.uat.csmUserFirstName;
			break;
		case CoreConstants.ENVT_PROD:
			csmCredentials[0] = _loginDetailsApplication.prod.csmUserName;
			csmCredentials[1] = _loginDetailsApplication.prod.csmPassword;
			csmCredentials[2] = _loginDetailsApplication.prod.csmUserFirstName;
			break;
		}
		return csmCredentials;
	}

	public static void verifyAndFillOtherTextBoxForSubBenefitForm(WebDriver driver,
			PDT_AddNewPolicyPage addNewPolicyPage, String subBenefitFormName, WebElement drpDown, String lblDrpDown,
			WebElement otherTextBox, WebElement lblOtherTextBox, String otherTextBoxVal) {
		try {
			if (drpDown.getText().equalsIgnoreCase(PDTConstants.OTHER)
					&& CoreFunctions.isElementExist(driver, otherTextBox, 1)) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFIED_TEXT_BOX_FIELD_DISPLAYED_FOR_DRPDOWN,
						CoreConstants.PASS, lblOtherTextBox.getText(), lblDrpDown, subBenefitFormName));
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
		CoreFunctions.waitHandler(5);		
		}catch (Exception e) {
			Assert.fail(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_CLICKING_ON_ELEMENT_FROM_LIST, CoreConstants.FAIL,
					e.getMessage(),listWebElement.get(index).getText()));
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
			Assert.fail(MessageFormat.format(MobilityXConstants.EXCEPTION_OCCURED_WHILE_RETURNING_INDEX_ITEM_FROM_LIST_USING_TEXT, CoreConstants.FAIL,
					e.getMessage()));
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
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_INVALID_RANGE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
				throw new RuntimeException(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_NOT_DISPLAYED_FOR_INVALID_RANGE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			} else if ((Double.parseDouble(inputValue) >= 0.5 || Double.parseDouble(inputValue) <= 999.5)
					&& !isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.SUCCESSFULLY_VERIFIED_VALIDATION_MESSAGE_NOT_DISPLAYED_ON_FLEX_PLANNING_TOOL_PAGE,
						CoreConstants.PASS, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
			} else if ((Double.parseDouble(inputValue) >= 0.5 || Double.parseDouble(inputValue) <= 999.5)
					&& isValidationMessageDisplayed) {
				Reporter.addStepLog(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
				throw new RuntimeException(MessageFormat.format(
						COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
						CoreConstants.FAIL, COREFLEXConstants.POINT_FIVE_TO_NINE_NINE_NINE_POINT_FIVE_RANGE, inputValue,
						fieldName));
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
			Reporter.addStepLog(MessageFormat.format(
					COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
					CoreConstants.FAIL, validationMessage, inputValue, fieldName));
			throw new RuntimeException(MessageFormat.format(
					COREFLEXConstants.VALIDATION_MESSAGE_DISPLAYED_FOR_VALID_RANGE,
					CoreConstants.FAIL, validationMessage, inputValue, fieldName));
		}
	}
	
	
	public static int returnindexItemFromListUsingText(WebDriver driver, List<WebElement> WebElementList,boolean flag,
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

}