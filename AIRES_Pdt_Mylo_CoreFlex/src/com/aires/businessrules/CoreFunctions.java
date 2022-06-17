/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 24/04/2020			Rahul Sharma				Added/updated generic functions
 * 
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.businessrules;

import static org.openqa.selenium.support.locators.RelativeLocator.with;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.DecimalFormat;
import java.text.MessageFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDate;
import java.time.YearMonth;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Collections;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Properties;
import java.util.Random;
import java.util.Set;
import java.util.stream.Collectors;

import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Keys;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.businessrules.constants.MobilityXConstants;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class CoreFunctions {

	public static String timeStamp = new SimpleDateFormat("yyyy.MM.dd.HH.mm.ss").format(new Date());

	/**
	 * Wait handler functionality
	 * 
	 * @param secs
	 * @return void
	 * @Author Automation Team
	 */
	public static void waitHandler(int secs) {
		try {
			Thread.sleep(secs * 1000);
		} catch (InterruptedException e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	/**
	 * @purpose To wait for browser to load
	 * 
	 * @return void
	 * @author Automation Team
	 */
	public static void waitForBrowserToLoad(WebDriver driver) {
		try {
			boolean isReady = checkBrowserReadyState(driver);
			if (!isReady) {
				waitForBrowserToLoad(driver);
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
	}

	/**
	 * Check Browser Ready state
	 * 
	 * @return boolean
	 * @author Automation Team
	 */
	private static boolean checkBrowserReadyState(WebDriver driver) {
		boolean b = false;
		try {
			JavascriptExecutor js = (JavascriptExecutor) driver;
			if (js.executeScript("return document.readyState").toString().equals("complete")) {
				b = true;
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return b;
	}

	/**
	 * Highlights By Locator passed in arguments
	 * 
	 * @param element
	 * @return void
	 * @author Automation Team
	 */
	public static void highlightObject(WebDriver driver, WebElement element) {
		try {
			if (driver != null) {
				waitHandler(1);
				JavascriptExecutor javascript = (JavascriptExecutor) driver;
				javascript.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
						"color: green; border: 3px solid green;");
			} else
				Log.info(CoreConstants.FAIL + CoreConstants.NO_BRWSR_HIGLT_ELE);
		} catch (Exception e) {
			Log.info(CoreConstants.FAIL + CoreConstants.UNABLE_HIGLT_LOCTR);
		}
	}

	/**
	 * To Click on Element
	 * 
	 * @param element
	 * @param name
	 * @return void
	 * @author Automation Team
	 */
	public static void highlightElementAndClick(WebDriver driver, WebElement element, String name) {
		try {
			highlightObject(driver, element);
			Log.info(MessageFormat.format(CoreConstants.VRFY_ELE_CLCK, name));
			click(driver, element, name);
			waitForBrowserToLoad(driver);
			Log.info(MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name), e);
		}
	}

	public static String getElementText(WebDriver driver, WebElement Element) {
		String text = "";
		try {
			text = Element.getText().trim();
			highlightObject(driver, Element);
//			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.TXT_ACTUAL + CoreConstants.IS_DISPLAYED_AS + text);
		} catch (Exception e) {
			Reporter.addStepLog("Could not get element text");
		}
		return text;
	}

	public static String getAttributeText(WebElement Element, String attributeName) {
		Log.info("Getting attribute Name as : " + attributeName);
		String attributeValue = "";
		try {
			attributeValue = Element.getAttribute(attributeName).toString().trim();
			Log.info("Attribute '" + attributeName + "' value is: " + attributeValue);
		} catch (Exception e) {
			Log.info("Could not get attribute text");
			e.printStackTrace();
		}
		return attributeValue;
	}

	/**
	 * Get Property from config
	 * 
	 * @param property
	 * @return String
	 * @author Automation Team
	 */
	public static String getPropertyFromConfig(String property) {
		FileInputStream fi;
		String value = "";
		try {
			fi = new FileInputStream(System.getProperty(CoreConstants.USER_DIR) + CoreConstants.PATH_CONFIG_PROPERTIES);
			Properties prop = new Properties();
			prop.load(fi);
			value = prop.getProperty(property);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return value;
	}

	public static void writeToPropertiesFile(String key, String data) {
		FileOutputStream fileOut = null;
		FileInputStream fileIn = null;
		try {
			Properties configProperty = new Properties();
			File file = new File(System.getProperty("user.dir") + "/Configs/Config.properties");
			fileIn = new FileInputStream(file);
			configProperty.load(fileIn);
			configProperty.setProperty(key, data);
			fileOut = new FileOutputStream(file);
			configProperty.store(fileOut, "Data Saved Successfully");
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			try {
				fileOut.close();
			} catch (IOException ex) {
				ex.printStackTrace();
			}
		}
	}

	/**
	 * verify Element Present On Page
	 * 
	 * @param element
	 * @param name
	 * @return boolean
	 * @author Automation Team
	 */
	public static boolean verifyElementPresentOnPage(WebElement element, String name) {
		boolean flag = false;
		try {
			if (element.isDisplayed()) {
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, name));
				flag = true;
			} else {
				flag = false;
				Reporter.addStepLog(
						MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL, name));
			}
		} catch (NoSuchElementException e) {
			Log.info(CoreConstants.VRFIED_THAT + name + CoreConstants.ELE_NOT_PRESNT);
		}
		return flag;
	}

	public static void explicitWaitTillElementBecomesClickable(WebDriver driver, WebElement Element, String name) {
		Log.info("waiting for " + name + " to be clickable");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.elementToBeClickable(Element));
		Log.info("Pass: " + name + " is clickable");
	}

	public static void explicitWaitTillElementVisibility(WebDriver driver, WebElement Element, String name) {
		Log.info("waiting for " + name + " to display");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		wait.until(ExpectedConditions.visibilityOf(Element));
		Log.info("Pass: " + name + " is displayed");
	}

	public static void explicitWaitTillElementVisibility(WebDriver driver, WebElement Element, String name, long time) {
		Log.info("waiting for " + name + " to display");
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(Element));
		Log.info("Pass: " + name + " is displayed");
	}

	public static String generateRandomChar() {
		Random rnd = new Random();
		char reqChar = CoreConstants.ALPHABET.charAt(rnd.nextInt(CoreConstants.ALPHABET.length()));
		String reqWord = Character.toString(reqChar);
		return reqWord;
	}

	public static void click(WebDriver driver, WebElement Element, String name) {
		explicitWaitTillElementBecomesClickable(driver, Element, name);
		Log.info("Clicking on " + name);
		try {
			Element.click();
			Log.info(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
			Reporter.addStepLog(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
		}
	}

	public static void clickUsingJS(WebDriver driver, WebElement Element, String name) {
		explicitWaitTillElementBecomesClickable(driver, Element, name);
		Log.info("Clicking using JS on: " + name);
		try {
			CoreFunctions.waitHandler(2);
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", Element);
			Log.info("Pass: " + name + " :is clicked");
			Reporter.addStepLog(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
		} catch (Exception e) {
			Log.info("Fail:Could not Click on: " + name);
			e.printStackTrace();
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
		}
	}

	public static void setElementText(WebDriver driver, WebElement Element, String text) {
		Log.info("Setting Element Text");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			Element.clear();
			Element.sendKeys(text);
		} catch (Exception e) {
			Log.info("Could not set text");
			Reporter.addStepLog("Could not set element text");
			e.printStackTrace();
		}
	}

	public static String extractIntValue(String str) {
		// Replacing every non-digit number with a space(" ")
		str = str.replaceAll("[^\\d]", " ");
		// Remove extra spaces from the beginning and the ending of the string
		str = str.trim();
		// Replace all the consecutive white spaces with a single space
		str = str.replaceAll(" +", " ");
		if (str.equals(""))
			return "-1";
		return str;
	}

	public static void explicitWaitTillElementListVisibility(WebDriver driver, List<WebElement> Element) {
		waitHandler(1);
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		for (WebElement ele : Element) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}

	public static void explicitWaitTillElementListVisibilityWithTime(WebDriver driver, List<WebElement> Element,
			long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		for (WebElement ele : Element) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}

	public static void explicitWaitTillElementStaleness(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.stalenessOf(element));
	}

	public static WebElement explicitWaitAndReturnElement(WebDriver driver, WebElement element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOf(element));
		return element;
	}

	public static void waitTillElementVisibleWithCustomTime(WebDriver driver, WebElement element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.visibilityOf(element));
	}

	public static void explicitWaitForElementTextPresent(WebDriver driver, WebElement element, String text, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.textToBePresentInElement(element, text));
	}

	public static void explicitWaitTillElementInVisibility(WebDriver driver, WebElement Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.invisibilityOf(Element));
	}

	public static void explicitWaitTillElementInVisibilityCustomTime(WebDriver driver, WebElement Element, int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.invisibilityOf(Element));
	}

	public static void explicitWaitTillElementListClickable(WebDriver driver, List<WebElement> Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(90));
		for (WebElement ele : Element) {
			wait.until(ExpectedConditions.elementToBeClickable(ele));
		}
	}

	public static boolean isElementByLocatorClickable(WebDriver driver, By locatorKey, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatorKey));
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static void clearTextField(WebDriver driver, WebElement Element, String name) {
		Log.info("Clearing " + name + " text field");
		Reporter.addStepLog("Clearing " + name + " text field");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(Element));
			Element.clear();
			Reporter.addStepLog("Pass: Text Field " + name + " has been cleared");
		} catch (Exception e) {
			Log.info("Fail:Could not clear " + name + " text field");
			Reporter.addStepLog("Fail:Could not clear " + name + " text field");
			e.printStackTrace();
		}
	}

	public static ExpectedCondition<WebElement> elementToBeClickableInFrame(final By locatorFrame, final By locator) {
		return new ExpectedCondition<WebElement>() {

			@Override
			public WebElement apply(WebDriver driver) {
				try {
					driver.switchTo().defaultContent();
					driver.switchTo().frame(driver.findElement(locatorFrame));

					WebElement elem = driver.findElement(locator);
					return elem.isDisplayed() && elem.isEnabled() ? elem : null;

				} catch (Exception e) {
					return null;
				}
			}

			@Override
			public String toString() {
				return "element located by: " + locator + " in " + locatorFrame;
			}
		};
	}

	public static void refreshIFrameByJavaScriptExecutor(WebDriver driver, WebElement iFrameName) {
		((JavascriptExecutor) driver).executeScript(String.format(
				"document.getElementByXpath('{0}').src = " + "document.getElementByXpath('{0}').src", iFrameName));
	}

	public static void clearAndSetText(WebDriver driver, WebElement element, String textToEnter) {
		explicitWaitTillElementVisibility(driver, element, element.getAttribute("placeholder"));
		Log.info(MessageFormat.format(CoreConstants.VRFY_TXT_CLR_VAL, element.getAttribute("placeholder")));
		String elementLabel = element.getAttribute("placeholder");
		try {
			element.clear();
			highlightObject(driver, element);
			element.sendKeys(textToEnter);
			Reporter.addStepLog(CoreConstants.PASS
					+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementLabel, textToEnter));
		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			e.printStackTrace();
		}
	}

	public static void clearAndSetText(WebDriver driver, WebElement element, String textToEnter, boolean reporter) {
		explicitWaitTillElementVisibility(driver, element, element.getAttribute("placeholder"));
		Log.info(MessageFormat.format(CoreConstants.VRFY_TXT_CLR_VAL, element.getAttribute("placeholder")));
		String elementLabel = element.getAttribute("placeholder");
		try {
			element.clear();
			highlightObject(driver, element);
			element.sendKeys(textToEnter);
			if (reporter) {
				Reporter.addStepLog(CoreConstants.PASS
						+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementLabel, textToEnter));
			}

		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			Reporter.addStepLog(
					CoreConstants.FAIL + MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			e.printStackTrace();
		}
	}

	public static void selectItemInListByText(WebDriver driver, List<WebElement> WebElementList, String searchText) {
		boolean itemSearched = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().contains(searchText)) {
					itemSearched = true;
					CoreFunctions.highlightObject(driver, row);
					CoreFunctions.clickUsingJS(driver, row, row.getText());
					break;
				}
			}
			if (!itemSearched) {
				Assert.fail(MessageFormat.format(PDTConstants.SEARCHED_ITEM_NOT_IN_LIST, searchText));
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.COULD_NOT_SELECT_ITEM_FROM_LIST);
		}
	}

	public static WebElement returnItemInListByText(WebDriver driver, List<WebElement> WebElementList,
			String searchText) {
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().contains(searchText)) {
					return row;
				}
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.COULD_NOT_SELECT_ITEM_FROM_LIST);
		}
		return null;
	}

	public static LinkedHashMap<String, String> returnMapFromBothLists(WebDriver driver, List<WebElement> roleNames,
			List<WebElement> memberNames) {
		LinkedHashMap<String, String> mp = new LinkedHashMap<String, String>();
		try {
			for (int i = 0; i < roleNames.size(); i++) {
				if(mp.containsKey(roleNames.get(i).getAttribute(CoreConstants.VALUE)))
					continue;
				mp.put(roleNames.get(i).getAttribute(CoreConstants.VALUE),
						memberNames.get(i).getAttribute(CoreConstants.VALUE));
			}
		} catch (Exception e) {
			Assert.fail(CoreConstants.COULD_NOT_FIND_ITEM);
		}
		return mp;
	}

	public static void selectItemInListByText(WebDriver driver, List<WebElement> WebElementList, String searchText,
			boolean reporter) {
		boolean itemSearched = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().contains(searchText)) {
					itemSearched = true;
					clickRowInResult(driver, row, reporter, searchText);
					break;
				}
			}
			if (!itemSearched) {
				Assert.fail(MessageFormat.format(PDTConstants.SEARCHED_ITEM_NOT_IN_LIST, searchText));
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.COULD_NOT_SELECT_ITEM_FROM_LIST);
			e.printStackTrace();
		}
	}

	public static void clickRowInResult(WebDriver driver, WebElement row, boolean reporter, String searchText) {
		if (reporter) {
			CoreFunctions.clickUsingJS(driver, row, searchText);
		} else {
			CoreFunctions.clickWithoutReporting(driver, row, searchText);
		}
	}

	public static void writeMessageToReport(boolean isExists, String passMsg, String failMsg, String fieldName) {
		if (isExists) {
			Reporter.addStepLog(MessageFormat.format(passMsg, CoreConstants.PASS, fieldName));
		} else {
			Reporter.addStepLog(MessageFormat.format(failMsg, CoreConstants.FAIL, fieldName));
		}
	}

	public static String generateRandomNumberAsGivenLength(int length) {
		int min = (int) Math.pow(10, length - 1);
		int max = (int) Math.pow(10, length);
		Random random = new Random();
		return Integer.toString(random.nextInt(max - min) + min);
	}

	public static void explicitWaitWithLocatorTillElementDisappears(WebDriver driver, By byElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.invisibilityOfElementLocated(byElement));
	}

	public static boolean isElementByLocatorExist(WebDriver driver, By locatorKey, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatorKey));
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static boolean isElementExist(WebDriver driver, WebElement element, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOf(element));
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static void getElementTextAndStoreInList(WebDriver driver, List<WebElement> elementList, List<String> list) {
		for (WebElement elementText : elementList) {
			list.add(elementText.getText().trim());
			CoreFunctions.highlightObject(driver, elementText);
		}
	}

	public static void clickElement(WebDriver driver, WebElement Element) {
		waitTillElementClickable(driver, Element, 60);
		try {
			highlightObject(driver, Element);
			Element.click();
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, Element));
		}
	}

	public static void waitTillElementClickable(WebDriver driver, WebElement element, long time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}

	public static void waitUntilLoaderLoads(WebDriver driver) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		WebElement element = explicitWaitAndReturnElement(driver,
				driver.findElement(By.cssSelector("div[class='AFBlockingGlassPane']")));
		wait.until(ExpectedConditions.visibilityOf(element));
		wait.until(ExpectedConditions.invisibilityOf(element));
	}

	public static void clearAndSetText(WebDriver driver, WebElement element, String elementName, String textToEnter) {
		explicitWaitTillElementVisibility(driver, element, elementName);
		try {
			element.clear();
			highlightObject(driver, element);
			element.sendKeys(textToEnter);
			if (elementName.equalsIgnoreCase("password"))
				Reporter.addStepLog(CoreConstants.PASS
						+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementName, "xxxxxx"));
			else
				Reporter.addStepLog(CoreConstants.PASS
						+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementName, textToEnter));
		} catch (NoSuchElementException e) {
			Assert.fail(
					MessageFormat.format(PDTConstants.WEB_ELEMENT_NOT_FOUND_ON_PAGE, CoreConstants.FAIL, elementName));
		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementName));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementName));
			e.printStackTrace();
		}
	}

	public static void clickWithoutReporting(WebDriver driver, WebElement Element, String name) {
		explicitWaitTillElementBecomesClickable(driver, Element, name);
		Log.info("Clicking on" + name);
		try {
			Element.click();
			Log.info(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, Element));
		}
	}

	/**
	 * Generate Random String
	 *
	 * @return String
	 * @author Automation Team
	 */
	public static String generateRandomString(int stringLength) {
		StringBuilder randomString = new StringBuilder();
		try {
			Random random = new Random();
			boolean alphaType = true;
			for (int i = 0; i <= stringLength; ++i) {
				int j = (random.nextInt(25) + (alphaType == true ? 97 : 97));
				randomString.append((char) j);
				alphaType = !alphaType;
			}
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return randomString.toString();
	}

	public static void scrollVerticallyDownByGivenPixle(WebDriver driver, int pixleSize) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0," + pixleSize + ")");
	}

	public static void checkCheckBox(WebDriver driver, WebElement element, String name) {
		explicitWaitTillElementBecomesClickable(driver, element, name);
		try {
			if (element.isEnabled() && !element.isSelected()) {
				element.click();
			}
			Reporter.addStepLog(
					CoreConstants.PASS + MessageFormat.format(CoreConstants.VERIFIEDCHECKBOX_IS_CLICKED, name));
		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
		}
	}

	@SuppressWarnings("null")
	public static List<WebElement> getItemsFromListByText(WebDriver driver, List<WebElement> WebElementList,
			String searchText) {
		List<WebElement> elementList = null;
		try {
			for (WebElement element : WebElementList) {
				if (element.getText().contains(searchText)) {
					elementList.add(element);
				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return elementList;
	}

	public static long getDifferenceFromCurrentDate(WebDriver driver, Date initiatedDate) {
		long timeDifferenceMilliseconds = new Date().getTime() - initiatedDate.getTime();
		return timeDifferenceMilliseconds / (60 * 60 * 1000 * 24);
	}

	public static String getCurrentDateAsGivenFormat(String dateFormat) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		return sdf.format(new Date());
	}

	public static String addDaysInCurrentDate(String dateFormat, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		GregorianCalendar calender = new GregorianCalendar();
		calender.add(Calendar.DATE, days);
		return sdf.format(calender.getTime());
	}

	public static String subtractDaysInCurrentDate(String dateFormat, int days) {
		SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
		GregorianCalendar calender = new GregorianCalendar();
		calender.add(Calendar.DATE, -days);
		return sdf.format(calender.getTime());
	}

	public static boolean verifyElementPresentOnPage(WebDriver driver, WebElement element, String pageName, int time) {
		try {
			waitTillElementVisibleWithCustomTime(driver, element, time);
			if (element.isDisplayed()) {
				Reporter.addStepLog(
						CoreConstants.PASS + MessageFormat.format(CoreConstants.VERIFY_TAB_EXISTS, pageName));
				CoreFunctions.highlightObject(driver, element);
				return true;
			} else {
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static boolean verifyDownloadedDocumentExist(String documentName) throws Exception {
		String _documentNameFirst = documentName.split("\\.")[0];
		String _downloadedFileFirst = getLatestFilefromDirectory().getName().split("\\.")[0];
		if (!_downloadedFileFirst.contains(_documentNameFirst)) {
			Reporter.addStepLog(CoreConstants.FAIL + CoreConstants.FILE_NOT_DOWNLOADED_MESSAGE + documentName);
			Log.info(CoreConstants.FILE_NOT_DOWNLOADED_MESSAGE + documentName);
			return false;
		} else {
			Assert.assertTrue(_downloadedFileFirst.contains(_documentNameFirst), "Document was not downloaded");
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.FILE_SUCCESSFULLY_DOWNLOADED_MESSAGE + documentName);
			Log.info(CoreConstants.FILE_SUCCESSFULLY_DOWNLOADED_MESSAGE + documentName);
			return true;
		}
	}

	private static File getLatestFilefromDirectory() throws Exception {
		Thread.sleep(8000);
		String downloadPath = System.getProperty("user.home");
		File directory = new File(downloadPath + "/Downloads/");
		File[] files = directory.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}
		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public static boolean searchElementExistsInListByText(WebDriver driver, List<WebElement> WebElementList,
			String searchText) {
		boolean exists = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().contains(searchText)) {
					exists = true;
					CoreFunctions.highlightObject(driver, row);
					Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_DISPLAYED);
					break;
				}
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.COULD_NOT_SEARCH_ITEM_FROM_LIST, searchText));
		}
		return exists;
	}

	/**
	 * Get Current Date
	 *
	 * @author Automation Team
	 */
	public static String getcurrentdate() {
		String d = "";
		try {
			Date date = new Date();
			d = new SimpleDateFormat("dd-MMM-yyyy").format(date);
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return d;
	}

	/**
	 * Add message to report if @param wrtMsgReport is true
	 * 
	 * @param wrtMsgReport
	 * @param message
	 */
	public static void addMessageToReport(boolean wrtMsgReport, String message) {
		if (wrtMsgReport) {
			Reporter.addStepLog(message);
		}
	}

	public static void switchToFrame(WebDriver driver, String frameID) {
		Log.info("switching to frame");
		try {
			driver.switchTo().frame(frameID);
			Log.info("Pass:switched into frame with ID" + frameID);
		} catch (Exception e) {
			Log.info("Fail:Could not switched into frame with ID" + frameID);
			e.printStackTrace();
		}
	}

	public static void switchToFrame(WebDriver driver, WebElement Element) {
		Log.info("switching to frame");
		try {
			driver.switchTo().frame(Element);
			Log.info("Pass:switched into frame");
		} catch (Exception e) {
			Log.info("Fail:Could not switched into frame");
			e.printStackTrace();
		}
	}

	public static void switchToParentWindow(WebDriver driver) {
		Log.info("switchToParentWindow");
		try {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ArrayList windows = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) windows.get(0));
			Log.info("Pass:switched to window 0");
		} catch (Exception e) {
			Log.info("Fail:could not switch to window 0");
			e.printStackTrace();
		}
	}

	public static String getEnvironmentName(String URL) {
		String[] getUrl = URL.split("https://");
		String[] env = getUrl[1].split(".aires");
		return env[0].toUpperCase();
	}

	public static int GetDayofMonthFromDate() {
		int day = 0;
		try {
			LocalDate localDate = LocalDate.now();
			day = localDate.getDayOfMonth();
		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
			e.printStackTrace();
		}
		return day;
	}

	public static WebElement getElementByLocator(WebDriver driver, By locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatorKey));
			return driver.findElement(locatorKey);
		} catch (Exception e) {
		}
		return null;
	}

	public static WebElement getElementByLocator(WebDriver driver, WebElement parentElement, By locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			WebElement childElement = parentElement.findElement(locatorKey);
			wait.until(ExpectedConditions.visibilityOf(childElement));
			return childElement;
		} catch (Exception e) {
		}
		return null;
	}

	public static List<WebElement> getElementListByLocator(WebDriver driver, By locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatorKey));
			return driver.findElements(locatorKey);
		} catch (Exception e) {
		}
		return null;
	}

	public static void clearAndSetTextWOAttrbutes(WebDriver driver, WebElement element, String textToEnter,
			String elementText) {
		explicitWaitTillElementVisibility(driver, element, element.getAttribute("placeholder"));
		try {
			element.clear();
			highlightObject(driver, element);
			element.sendKeys(textToEnter);
			Reporter.addStepLog(CoreConstants.PASS
					+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementText, textToEnter));
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementText));
			e.printStackTrace();
		}
	}

	public static boolean isElementVisible(WebElement element) {
		return element.isDisplayed() && element.isEnabled();
	}

	public static String parenthesisValueInsideAString(String str) {
		return str.substring(str.indexOf("(") + 1, str.indexOf(")"));
	}

	public static void waitTillSpinnerExist(WebDriver driver, By locatorKey, int time) {
		try {
			if (CoreFunctions.isElementByLocatorExist(driver, locatorKey, time)) {
				CoreFunctions.explicitWaitWithLocatorTillElementDisappears(driver, locatorKey);
			}
		} catch (Exception e) {
			Assert.fail("Failed - Waiting for Spinner Exist");
		}
	}

	public static boolean verifyElementOnPage(WebDriver driver, WebElement element, String elementName,
			String elementVal, String pageName, boolean displayMsgInReport) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			if (element.getText().trim().equals(elementVal) && displayMsgInReport) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_ELEMENT_VALUE_ON_PAGE, CoreConstants.PASS,
						elementName, elementVal, pageName));
				CoreFunctions.highlightObject(driver, element);
				return true;
			} else if (element.getText().trim().equals(elementVal) && !displayMsgInReport) {
				CoreFunctions.highlightObject(driver, element);
				return true;
			}
			return false;
		} catch (Exception e) {
			return false;
		}
	}

	public static List<WebElement> explicitWaitAndReturnElementList(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(locator));
		return driver.findElements(locator);
	}

	public static boolean verifyElementOnPage(WebDriver driver, WebElement element, String elementName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			CoreFunctions.highlightObject(driver, element);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	public static String getCurrentPageNameFromUrl(WebDriver driver) {
		return driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/") + 1);
	}

	public static String getPageNameFromUrl(WebDriver driver) {
		return driver.getCurrentUrl().substring(driver.getCurrentUrl().lastIndexOf("/") + 1,
				driver.getCurrentUrl().lastIndexOf("."));
	}

	public static void closeBrowser(WebDriver driver) {
		driver.quit();
	}

	public static void verifyText(String actualText, String expectedText) {
		Log.info("Verifying Text...");
		if (actualText.equalsIgnoreCase(expectedText))
			Reporter.addStepLog(CoreConstants.PASS + CoreConstants.TXT_ACTUAL + actualText + " "
					+ CoreConstants.TXT_EXPECTED + expectedText);
		else {
			Log.info(CoreConstants.FAIL + CoreConstants.TXT_ACTUAL + actualText + " " + CoreConstants.TXT_EXPECTED
					+ expectedText);
			Assert.fail("Failed to verify the Text: Actual Text = " + actualText + "Expected Text = " + expectedText);
		}
	}

	public static void waitUntilPleaseWaitLoaderExist(WebDriver driver) {

		WebElement element = getElementByLocator(driver, By.cssSelector("span[id='busyStateMessage']"));
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
		if (element.getCssValue("cursor").equalsIgnoreCase("auto")) {
			wait.until(d -> element.getCssValue("cursor") == "wait");
			wait.until(d -> element.getCssValue("cursor") == "auto");
		} else {
			wait.until(d -> element.getCssValue("cursor") == "auto");
		}
	}

	public static void waitUntilBrowserReady(WebDriver driver) {
		new WebDriverWait(driver, Duration.ofSeconds(30))
				.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
						.executeScript("return document.readyState").equals("complete"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
	}

	public static WebElement explicitWaitTillVisiblityAndReturnElement(WebDriver driver, By locator) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
		return driver.findElement(locator);
	}

	public static int rowColumnCountInTable(int count) {
		return count + 1;
	}

	public static void hoverAndClick(WebDriver driver, WebElement element,String name) {
		Actions action = new Actions(driver);
		action.moveToElement(element).doubleClick().build().perform();
		Reporter.addStepLog(CoreConstants.PASS
				+ MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
	}

	public static void scrollClickUsingJS(WebDriver driver, WebElement Element, String name) {
		explicitWaitTillElementBecomesClickable(driver, Element, name);
		Log.info("Clicking using JS on: " + name);
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", Element);
			executor.executeScript("arguments[0].click();", Element);
			Log.info("Pass: " + name + " :is clicked");
			Reporter.addStepLog(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLCKED, name));
		} catch (Exception e) {
			Log.info("Fail:Could not Click on: " + name);
			e.printStackTrace();
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, Element));
		}
	}

	public static void switchToNewTab(WebDriver driver) {
		Log.info("switchToNewWindow");
		try {
			@SuppressWarnings({ "rawtypes", "unchecked" })
			ArrayList windows = new ArrayList(driver.getWindowHandles());
			driver.switchTo().window((String) windows.get(1));
			Log.info("Pass:switched to window 1");
		} catch (Exception e) {
			Log.info("Fail:could not switch to window 1");
			e.printStackTrace();
		}
	}

	public static boolean verifyTextEditorValue(WebDriver driver, WebElement element, String textValue,
			String textFieldName) {
		if (element.getText().contains(textValue)) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_TEXT_IN_TEXTFIELD, CoreConstants.PASS,
					textValue, textFieldName));
			CoreFunctions.highlightObject(driver, element);
		}
		return element.getText().equals(textValue);
	}

	public static List<String> getEnabledElementTextAndStoreInList(WebDriver driver, List<WebElement> elementList) {
		List<String> list = new ArrayList<String>();
		for (WebElement elementText : elementList) {
			if (elementText.isEnabled() && !elementText.isSelected()) {
				list.add(elementText.getText().trim());
			}
		}
		return list;
	}

	public static boolean highlightAndclickOnByLocator(WebDriver driver, By locatorKey, int time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfElementLocated(locatorKey));
			WebElement element = driver.findElement(locatorKey);
			highlightObject(driver, element);
			element.click();
			return true;
		} catch (Exception e) {
		}
		return false;
	}

	public static void explicitWaitTillListElementStaleness(WebDriver driver, List<WebElement> elementList) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
		for (WebElement elementText : elementList) {
			wait.until(ExpectedConditions.refreshed(ExpectedConditions.stalenessOf(elementText)));
		}
	}

	public static void handleAlert(WebDriver driver) {
		if (isAlertPresent(driver)) {
			Alert alert = driver.switchTo().alert();
			alert.accept();
		}
	}

	public static boolean isAlertPresent(WebDriver driver) {
		try {
			driver.switchTo().alert();
			return true;
		} catch (NoAlertPresentException ex) {
			return false;
		}
	}

	public static void scrollHorizontalRightUsigActions(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_RIGHT).build().perform();

	}

	public static void scrollHorizontalLeftUsigActions(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.ARROW_LEFT).build().perform();
	}

	public static void scrollDownUsigActions(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.DOWN).build().perform();
	}

	public static void scrollRightUsingJs(WebDriver driver) {
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("document.getElementById('gvLocationHorizontalRail').scrollRight += 900", "");
	}

	public static void scrollUpUsigActions(WebDriver driver) {
		Actions act = new Actions(driver);
		act.sendKeys(Keys.UP).build().perform();
	}

	public static void explicitWaitWithLocatorTillElementAppears(WebDriver driver, By byElement) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
		wait.until(ExpectedConditions.visibilityOfElementLocated(byElement));
	}

	public static void sendKeysUsingAction(WebDriver driver, WebElement element, String text) {
		Actions act = new Actions(driver);
		act.click(element);
		act.sendKeys(text).build().perform();
	}

	public static void clearAndSetTextUsingLocator(WebDriver driver, By locator, String textToEnter) {
		WebElement element = getElementByLocator(driver, locator);
		try {
			element.clear();
			element.sendKeys(textToEnter);
		} catch (Exception e) {
			element = getElementByLocator(driver, locator);
			element.clear();
			element.sendKeys(textToEnter);
		}
	}

	public static void setText(WebDriver driver, By locatorKey, String textToEnter) {
		try {
			if (isElementByLocatorExist(driver, locatorKey, 30)) {
				WebElement element = driver.findElement(locatorKey);
				Log.info(MessageFormat.format(CoreConstants.VRFY_TXT_CLR_VAL, element.getAttribute("placeholder")));
				String elementLabel = element.getAttribute("placeholder");
				element.clear();
				highlightObject(driver, element);
				element.sendKeys(textToEnter);
				Reporter.addStepLog(CoreConstants.PASS
						+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementLabel, textToEnter));
			}
		} catch (Exception e) {
			WebElement element = driver.findElement(locatorKey);
			String elementLabel = element.getAttribute("placeholder");
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			e.printStackTrace();
		}
	}

	public static void selectValueFromDropdownUsingLocator(WebDriver driver, By locatorKey, String drpdwnValue) {
		try {
			if (isElementByLocatorExist(driver, locatorKey, 35)) {
				Log.info("Element found:-" + drpdwnValue);
				WebElement element = driver.findElement(locatorKey);
				Select dropDown = new Select(element);
				String drpDwnName = dropDown.getOptions().get(0).getText();
				dropDown.selectByVisibleText(drpdwnValue);
				if (element.getAttribute("title").equalsIgnoreCase(drpdwnValue))
					Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFY_VALUE_SELECTED_FROM_DROPDWON,
							CoreConstants.PASS, drpDwnName, drpdwnValue));
				else
					Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_SELECT_VALUE_FROM_DROPDOWN,
							CoreConstants.FAIL, drpdwnValue, drpDwnName));
			}
		} catch (Exception ex) {
			Log.info(CoreConstants.ERROR + ex);
		}
	}

	public static boolean verifyElementPresentOnPage(WebDriver driver, WebElement element, String elementName,
			String pageName) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			if (element.isDisplayed() && element.getText().trim().equals(elementName)) {
				CoreFunctions.highlightObject(driver, element);
				Reporter.addStepLog(MessageFormat.format(CoreConstants.VERIFIED_ELEMENT_ON_PAGE, CoreConstants.PASS,
						elementName, pageName));
				return true;
			} else {
				Reporter.addStepLog(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE,
						CoreConstants.FAIL, elementName, pageName));
				return false;
			}
		} catch (NoSuchElementException e) {
			return false;
		}
	}

	public static LinkedHashMap<String, Integer> getCountOfMonthWeekDays(int totalDays) {
		int month = 0, weeks = 0, days = 0, remainingDays = 0;
		month = totalDays / 30;
		remainingDays = totalDays % 30;

		if (remainingDays >= 7) {
			weeks = remainingDays / 7;

			days = remainingDays % 7;
		} else
			days = remainingDays;

		LinkedHashMap<String, Integer> monthWeekDayMap = new LinkedHashMap<String, Integer>();
		monthWeekDayMap.put("month", month);
		monthWeekDayMap.put("weeks", weeks);
		monthWeekDayMap.put("days", days);
		return monthWeekDayMap;
	}

	public static String addDaysMonthYearToCurrentDate(String dateTimeParamName, String dateFormat, int numToAdd) {
		Calendar now = Calendar.getInstance();
		try {
			switch (dateTimeParamName) {
			case PDTConstants.DAYS:
				now.add(Calendar.DATE, numToAdd);
				break;
			case PDTConstants.MONTH:
				now.add(Calendar.MONTH, numToAdd);
				break;
			case PDTConstants.YEAR:
				now.add(Calendar.YEAR, numToAdd);
				break;
			case PDTConstants.HOUR:
				now.add(Calendar.HOUR, numToAdd);
				break;
			case PDTConstants.MINUTES:
				now.add(Calendar.MINUTE, numToAdd);
				break;
			case PDTConstants.SECONDS:
				now.add(Calendar.SECOND, numToAdd);
				break;
			}

		} catch (Exception e) {
			Log.info(CoreConstants.ERROR + e);
		}
		return new SimpleDateFormat(dateFormat).format(now.getTime());
	}

	public static void waitUntilBrowserReadyWithCustomTime(WebDriver driver, int customTime) {
		new WebDriverWait(driver, Duration.ofSeconds(customTime))
				.until((ExpectedCondition<Boolean>) wd -> ((JavascriptExecutor) wd)
						.executeScript("return document.readyState").equals("complete"));
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return((window.jQuery != null) && (jQuery.active === 0))").equals("true");
	}

	public static boolean verifyInputElementOnPage(WebDriver driver, WebElement element, String elementName,
			String elementVal, String pageName, String attributeName, boolean displayMsgInReport) {
		try {
			CoreFunctions.explicitWaitTillElementVisibility(driver, element, elementName);
			if (element.getAttribute(attributeName).equals(elementVal) && displayMsgInReport) {
				Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_ELEMENT_VALUE_ON_PAGE, CoreConstants.PASS,
						elementName, elementVal, pageName));
				CoreFunctions.highlightObject(driver, element);
			} else if (element.getAttribute(attributeName).equals(elementVal) && !displayMsgInReport) {
				CoreFunctions.highlightObject(driver, element);
			}
			return element.getAttribute(attributeName).equals(elementVal);
		} catch (Exception e) {
			return false;
		}
	}

	public static long getNoOfMonthsBtwDates(String startDate, String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM/dd/yyyy");
		long monthsBetween = ChronoUnit.MONTHS.between(YearMonth.from(LocalDate.parse(startDate, formatter)),
				YearMonth.from(LocalDate.parse(endDate, formatter)));
		return monthsBetween;
	}

	public static void hover(WebDriver driver, WebElement element) {
		waitHandler(2);
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();
	}

	public static List<WebElement> waitAndReturnListUntilElementsVisible(WebDriver driver, List<WebElement> Element) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(25));
		for (WebElement ele : Element) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
		return Element;
	}

	public static void writeMessageToReport(boolean isExists, String passMsg, String failMsg, String fieldName,
			String pageName) {
		if (isExists) {
			Reporter.addStepLog(MessageFormat.format(passMsg, CoreConstants.PASS, fieldName, pageName));
		} else {
			Reporter.addStepLog(MessageFormat.format(failMsg, CoreConstants.FAIL, fieldName, pageName));
		}
	}

	public static void switchToTab(WebDriver driver) {
		CoreFunctions.waitHandler(5);
		String currentWindow = driver.getWindowHandle();
		Set<String> handles = driver.getWindowHandles();
		for (String actualWin : handles) {
			if (!actualWin.equalsIgnoreCase(currentWindow)) {
				driver.switchTo().window(actualWin);
				Log.info(driver.getTitle());
				Log.info(driver.getCurrentUrl());
			}
		}
	}

	public static File getLatestFilefromDir(String dirPath) {
		File dir = new File(dirPath);
		File[] files = dir.listFiles();
		if (files == null || files.length == 0) {
			return null;
		}

		File lastModifiedFile = files[0];
		for (int i = 1; i < files.length; i++) {
			if (lastModifiedFile.lastModified() < files[i].lastModified()) {
				lastModifiedFile = files[i];
			}
		}
		return lastModifiedFile;
	}

	public boolean isFileDownloaded(String downloadPath, String fileName) {
		boolean flag = false;
		File dir = new File(downloadPath);
		File[] dir_contents = dir.listFiles();

		for (int i = 0; i < dir_contents.length; i++) {
			if (dir_contents[i].getName().equals(fileName))
				return flag = true;
		}

		return flag;
	}

	/**
	 * This method will wait until the folder is having any downloads
	 * 
	 * @throws InterruptedException
	 */
	public static void waitUntilFileToDownload(String folderLocation) throws InterruptedException {
		File directory = new File(folderLocation);
		boolean downloadinFilePresence = false;
		File[] filesList = null;
		LOOP: while (true) {
			filesList = directory.listFiles();
			for (File file : filesList) {
				// Log.info("FileName == "+file.getName());
				downloadinFilePresence = file.getName().contains(".crdownload");
				// Log.info("downloadinFilePresence == "+downloadinFilePresence);
			}
			if (downloadinFilePresence) {
				for (; downloadinFilePresence;) {
					waitHandler(5);
					continue LOOP;
				}
			} else {
				break;
			}
		}
	}

	public static void deletFile(String folderPath, String fileName) {
		String fileToDelete = folderPath + "/" + fileName;

		try {
			boolean result = Files.deleteIfExists(Paths.get(fileToDelete));
			if (result) {
				System.out.println("File is deleted!");
			} else {
				System.out.println("Sorry, unable to delete the file.");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void waitForFileDownloaded(WebDriver driver, File file, int timeoutSeconds) {
		FluentWait<WebDriver> wait = new FluentWait<>(driver).withTimeout(Duration.ofSeconds(timeoutSeconds))
				.pollingEvery(Duration.ofMillis(500))
				.ignoring(NoSuchElementException.class, StaleElementReferenceException.class);
		wait.until((webDriver) -> file.exists());
	}

	public static int getRandomNumber(int min, int max) {
		Random r = new Random();
		int result = r.nextInt(max - min) + min;
		return result;
	}

	public static void clickAndSetElementTextUsingJS(WebDriver driver, WebElement element, String text) {
		Log.info("Setting Element Text");
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(40));
			wait.until(ExpectedConditions.elementToBeClickable(element));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].setAttribute('style', arguments[1]);", element,
					"color: green; border: 3px solid green;");
			executor.executeScript("arguments[0].click();", element);
			executor.executeScript("arguments[0].value='" + text + "';", element);
		} catch (Exception e) {
			Log.info("Could not set text");
			Reporter.addStepLog("Could not set element text");
			e.printStackTrace();
		}
	}

	public static List<WebElement> getElementsByLocator(WebDriver driver, WebElement parentElement, By locatorKey) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(30));
			List<WebElement> childElements = parentElement.findElements(locatorKey);
			wait.until(ExpectedConditions.visibilityOfAllElements(childElements));
			return childElements;
		} catch (Exception e) {
		}
		return null;
	}

	public static void selectByVisibleText(WebDriver driver, WebElement element, String value) {
		explicitWaitTillElementVisibility(driver, element, value);
		Log.info("Element found:-" + value);
		highlightObject(driver, element);
		Select selectValue = new Select(element);
		selectValue.selectByVisibleText(value);
	}

	public static void set(WebDriver driver, WebElement element, String textToEnter) {
		explicitWaitTillElementVisibility(driver, element, element.getAttribute("placeholder"));
		Log.info(MessageFormat.format(CoreConstants.VRFY_TXT_CLR_VAL, element.getAttribute("placeholder")));
		String elementLabel = element.getAttribute("placeholder");
		try {
			element.sendKeys(textToEnter);
			Reporter.addStepLog(CoreConstants.PASS
					+ MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, elementLabel, textToEnter));
		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, elementLabel));
			e.printStackTrace();
		}
	}

	public static void moveToElement(WebDriver driver, WebElement element) {
		Actions action = new Actions(driver);
		action.moveToElement(element).build().perform();

	}

	public static List<String> getElementTextAndStoreInList(WebDriver driver, List<WebElement> elementList) {
		return (elementList.stream().map(x -> x.getText()).collect(Collectors.toList()));
	}

	public static WebElement getElementFromListByText(List<WebElement> elementList, String text) {
		try {
			for (WebElement element : elementList) {
				if (element.getText().contains(text)) {
					Log.info("Element found in the List by Text :" + element.getText());
					return element;
				}
			}
		} catch (Exception e) {
			Assert.fail("Element with the text " + text + " not found in the list.");
			e.printStackTrace();
		}
		return null;
	}

	public static String generateRandomNumberInGivenRange(int startingRange, int endingRange) {
		return String.valueOf(startingRange + (int) (Math.random() * ((endingRange - startingRange) + 1)));
	}

	public static void selectItemInListByText(WebDriver driver, List<WebElement> WebElementList, String searchText,
			String fieldName, String fieldType, boolean reporter) {
		boolean itemSearched = false;
		try {
			for (WebElement row : WebElementList) {
				if (row.getText().trim().equalsIgnoreCase(searchText)) {
					itemSearched = true;
					CoreFunctions.clickWithoutReporting(driver, row, searchText);
					Reporter.addStepLog(MessageFormat.format(PDTConstants.VERIFY_VALUE_SELECTED_FROM_FIELD,
							CoreConstants.PASS, fieldName, fieldType, searchText));
					break;
				}
			}
			if (!itemSearched) {
				Assert.fail("Searched item:-" + searchText + "does not exist in " + fieldName + " list.");
			}
		} catch (NoSuchElementException e) {
			Assert.fail(
					MessageFormat.format(PDTConstants.WEB_ELEMENT_NOT_FOUND_ON_PAGE, CoreConstants.FAIL, fieldName));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.FAIL_TO_SELECT_VALUE_FROM_FIELD, CoreConstants.FAIL,
					searchText, fieldName, fieldType));
		}
	}

	public static void explicitWaitTillElementListVisibilityCustomTime(WebDriver driver, List<WebElement> Element,
			int time) {
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
		for (WebElement ele : Element) {
			wait.until(ExpectedConditions.visibilityOf(ele));
		}
	}

	public static boolean searchElementExistsInListByTextIgnoreCase(WebDriver driver, List<WebElement> WebElementList,
			String searchText) {
		boolean exists = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().equalsIgnoreCase(searchText)) {
					exists = true;
					CoreFunctions.highlightObject(driver, row);
					break;
				}
			}

		} catch (Exception e) {
			Assert.fail(MessageFormat.format(PDTConstants.COULD_NOT_SEARCH_ITEM_FROM_LIST, searchText));
		}
		return exists;
	}

	public static String getRandomElementValueFromList(WebDriver driver, List<WebElement> WebElementList) {
		return WebElementList.get(getRandomNumber(0, WebElementList.size() - 1)).getText();
	}

	public static String getRandomAndUniqueMultipleSelectDropDownOptions(List<WebElement> dropDown) {
		int randomIndex, temp;
		randomIndex = CoreFunctions.getRandomNumber(0, dropDown.size() - 1);
		temp = CoreFunctions.getRandomNumber(0, dropDown.size() - 1);
		while (temp == randomIndex) {
			temp = CoreFunctions.getRandomNumber(0, dropDown.size() - 1);
		}
		return dropDown.get(randomIndex).getText() + ", " + dropDown.get(temp).getText();
	}

	public static boolean isElementPresent(WebDriver driver, By locator, long time, String name) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.presenceOfElementLocated(locator));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE, CoreConstants.PASS, name));
			return true;
		} catch (Exception e) {
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_NOT_ON_PAGE, CoreConstants.FAIL, name));
		}
		return false;
	}

	public static String getElementCSSProperty(WebDriver driver, WebElement element, String cssProperty) {
		return element.getCssValue(cssProperty);
	}

	public static boolean isElementListExist(WebDriver driver, List<WebElement> element, long time) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(time));
			wait.until(ExpectedConditions.visibilityOfAllElements(element));
			return true;
		} catch (Exception e) {
		}
		return false;

	}

	public static String generateRandomCharOfLength(int charlength, String type, int specCharLength) {
		String reqWord = new String();
		Random rnd = new Random();
		for (int i = 0; i < charlength; i++) {
			char reqChar = CoreConstants.ALPHABET.charAt(rnd.nextInt(CoreConstants.ALPHABET.length()));
			reqWord = reqWord + Character.toString(reqChar);
		}
		switch (type) {
		case MYLOConstants.SPECIAL_CHARACTERS_STRING:
			for (int i = 0; i < specCharLength; i++) {
				char specialChar = CoreConstants.SPECIAL_CHARACTERS
						.charAt(rnd.nextInt(CoreConstants.SPECIAL_CHARACTERS.length()));
				reqWord = reqWord + Character.toString(specialChar);
			}
			break;
		}
		return reqWord;
	}

	public static String getRandomOutOfSelectedElementValueFromList(WebDriver driver, List<WebElement> WebElementList,
			List<String> valuesToIgnore) {
		String selectedValue;
		do {
			selectedValue = WebElementList.get(getRandomNumber(0, WebElementList.size() - 1)).getText();
		} while (valuesToIgnore.contains(valuesToIgnore));
		return selectedValue;
	}

	public static boolean verifyListOrder(List<String> lists, String order) {
		List<String> copyText = new ArrayList<String>(lists);
		Collections.sort(copyText);
		if (order.equals(MYLOConstants.ASCENDING))
			return (lists.equals(copyText));
		else if (order.equals(MYLOConstants.DESCENDING)) {
			Collections.reverse(copyText);
			return (lists.equals(copyText));
		}
		return false;
	}

	public static String getStringDateInFormat(String value, String givenFormat, String expectedFormat) {
		String dateValue = null;
		SimpleDateFormat formatter = new SimpleDateFormat(givenFormat);
		SimpleDateFormat sdf = new SimpleDateFormat(expectedFormat);
		try {
			dateValue = sdf.format(formatter.parse(value));
		} catch (ParseException e) {
		}
		return dateValue;
	}

	public static void click(WebDriver driver, WebElement Element, String name, String fieldName) {
		explicitWaitTillElementBecomesClickable(driver, Element, name);
		Log.info("Clicking on " + name);
		try {
			Element.click();
			Log.info(CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLICKED, name, fieldName));
			Reporter.addStepLog(
					CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFIED_ELE_CLICKED, name, fieldName));
		} catch (Exception e) {
			e.printStackTrace();
			Log.info(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
			Assert.fail(MessageFormat.format(CoreConstants.FAILD_CLCK_ELE, name));
		}
	}

	public static void selectItemInListByText(WebDriver driver, List<WebElement> WebElementList, String searchText,
			boolean reporter, String fieldName) {
		boolean itemSearched = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info(CoreConstants.ACTUAL_ITEM_NAME_IS + row.getText());
				if (row.getText().contains(searchText)) {
					itemSearched = true;
					clickRowInResult(driver, row, reporter, searchText, fieldName);
					break;
				}
			}
			if (!itemSearched) {
				Assert.fail(MessageFormat.format(PDTConstants.SEARCHED_ITEM_NOT_IN_LIST, searchText));
			}
		} catch (Exception e) {
			Assert.fail(PDTConstants.COULD_NOT_SELECT_ITEM_FROM_LIST);
			e.printStackTrace();
		}
	}

	public static void clickRowInResult(WebDriver driver, WebElement row, boolean reporter, String searchText,
			String fieldName) {
		if (reporter) {
			CoreFunctions.click(driver, row, searchText, fieldName);
		} else {
			CoreFunctions.clickWithoutReporting(driver, row, searchText);
		}
	}	

	public static WebElement findSubElement(WebElement ancestor, By childLocator) {
		return ancestor.findElement(childLocator);
	}

	public static List<WebElement> findSubElementList(WebElement ancestor, By childLocator) {
		return ancestor.findElements(childLocator);
	}

	public static void clearAndSetTextUsingKeys(WebDriver driver, WebElement element, String textToEnter,
			String fieldName) {
		explicitWaitTillElementVisibility(driver, element, fieldName);
		Log.info(MessageFormat.format(CoreConstants.VRFY_TXT_CLR_VAL, element.getAttribute("placeholder")));

		String del = Keys.chord(Keys.CONTROL, "a") + Keys.DELETE;
		try {
			highlightObject(driver, element);
			element.sendKeys(del + textToEnter);
			Reporter.addStepLog(
					CoreConstants.PASS + MessageFormat.format(CoreConstants.VRFYD_TXT_CLR_VAL, fieldName, textToEnter));
		} catch (Exception e) {
			Log.info(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, fieldName));
			Reporter.addStepLog(MessageFormat.format(CoreConstants.FAILED_TXT_CLR_VAL, fieldName));
		}
	}

	public static boolean searchElementExistsInListByText(WebDriver driver, List<WebElement> WebElementList,
			String searchText, boolean reporter) {
		boolean exists = false;
		try {
			for (WebElement row : WebElementList) {
				Log.info("The Actual Item Name is :" + row.getText());
				if ((row.getText().trim()).equalsIgnoreCase(searchText)) {
					exists = true;
					CoreFunctions.highlightObject(driver, row);
					Reporter.addStepLog(CoreConstants.PASS + row.getText() + PDTConstants.IS_DISPLAYED);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Could not search item " + searchText + " from list");
		}
		return exists;
	}

	public static String getItemsFromListByIndex(WebDriver driver, List<WebElement> list, int index,
			boolean highlightObject) {
		String result = null;
		try {
			result = list.get(index).getText();
			if (highlightObject) {
				highlightObject(driver, list.get(index));
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return result;
	}

	public static void verifyText(String actualText, String expectedText, String fieldName) {
		if (actualText.equalsIgnoreCase(expectedText))
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + fieldName + " : " + expectedText);
		else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + fieldName + " | "
					+ CoreConstants.VAL_ACTUAL + actualText + " " + CoreConstants.VAL_EXPECTED + expectedText);
			Assert.fail("Failed to verify the fields "+ fieldName +" Text: Actual Text = " + actualText + " | Expected Text = " + expectedText);
		}
	}
	
	public static void verifyText(WebDriver driver, WebElement element, String expectedText, String fieldName) {
		String actualText = element.getText().trim();
		if (actualText.equalsIgnoreCase(expectedText)) {
			highlightObject(driver, element);
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + fieldName + " : " + expectedText);
		}
		else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + fieldName + " | "
					+ CoreConstants.VAL_ACTUAL + actualText + " " + CoreConstants.VAL_EXPECTED + expectedText);
			Assert.fail("Failed to verify the fields "+ fieldName +" Text: Actual Text = " + actualText + " | Expected Text = " + expectedText);
		}
	}

	public static void verifyValue(Double actualValue, Double expectedValue, String fieldName) {
		if (actualValue.equals(expectedValue))
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + fieldName + " : " + expectedValue);
		else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + fieldName + " | "
					+ CoreConstants.VAL_ACTUAL + actualValue + " " + CoreConstants.VAL_EXPECTED + expectedValue);
			Assert.fail("Failed to verify the fields "+ fieldName +" Text: Actual Text = " + actualValue + " | Expected Text = " + expectedValue);
		}
	}
	
	public static void verifyValue(WebDriver driver, WebElement element, Double expectedValue, String fieldName) {
		Double actualValue = Double.parseDouble(element.getText().trim());
		if (actualValue.equals(expectedValue)) {
			highlightObject(driver, element);
			Reporter.addStepLog(
					CoreConstants.PASS + MobilityXConstants.VERIFIED_FIELD_TEXT + fieldName + " : " + expectedValue);
		}
		else {
			Reporter.addStepLog(CoreConstants.FAIL + MobilityXConstants.FAILED_TO_VERIFY + fieldName + " | "
					+ CoreConstants.VAL_ACTUAL + actualValue + " " + CoreConstants.VAL_EXPECTED + expectedValue);
			Assert.fail("Failed to verify the fields "+ fieldName +" Text: Actual Text = " + actualValue + " | Expected Text = " + expectedValue);
		}
	}
	
	
	
	public static void scrollToElementUsingJS(WebDriver driver, WebElement Element, String name) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", Element);
			Reporter.addStepLog(CoreConstants.PASS + MessageFormat.format(CoreConstants.SCROLLED_TO_ELEMENT, name));
		} catch (Exception e) {
			Assert.fail(MessageFormat.format(CoreConstants.FAILED_TO_SCROLL_TO_ELEMENT, name));
		}
	}
	
	public static WebElement getLabelOfElement(WebDriver driver, By baseElement) {
		return driver.findElement((with(By.tagName("label"))).above(baseElement));
	}
	
	public static void refreshPage(WebDriver driver) {
		driver.navigate().refresh();
	}
	
	public static void scrollToElementUsingJavaScript(WebDriver driver, WebElement Element, String name) {
		try {
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].scrollIntoView(true);", Element);
			Log.info("Pass: " + name + " :is Visible");
			Reporter.addStepLog(MessageFormat.format(CoreConstants.VRFIED_ELE_PAGE,CoreConstants.PASS, name));
		} catch (Exception e) {
			Log.info("Fail:Could not find: " + name);
			Assert.fail(MessageFormat.format(CoreConstants.FAIL_TO_VERIFY_ELEMENT_ON_PAGE, Element));
		}
	}
	
	public static String setDifferentFieldsForMylo(WebDriver driver,WebElement element, String fieldName, String fieldValue) {
		String updatedValue;
		try {
			updatedValue = (Integer.parseInt(fieldValue)>200)
					? fieldValue
					: generateRandomCharOfLength(Integer.parseInt(fieldValue),
							MYLOConstants.ONLY_CHARACTERS, 0);
			
		} catch (NumberFormatException e) {
			updatedValue = (fieldValue.equals(MYLOConstants.SPECIAL_CHARACTERS_STRING))
					? generateRandomCharOfLength(4, MYLOConstants.SPECIAL_CHARACTERS_STRING, 2)
					: (fieldValue.equals(""))?setBlankField(driver,element,fieldName):fieldValue;
		}
		clearAndSetText(driver, element, updatedValue);
		return updatedValue;
	}
	
	public static String setBlankField(WebDriver driver,WebElement element,String fieldName) {
			clickElement(driver, element);
			element.sendKeys(Keys.chord(Keys.CONTROL, "a"));
			element.sendKeys(Keys.BACK_SPACE);
			return MYLOConstants.BLANK;
	}
	
	public static String setDifferentDropDownFieldsForMylo(WebDriver driver,String fieldValue,List<WebElement> optionList) {
		String updatedValue=null;
			if (fieldValue.equals(MYLOConstants.RANDOM)) {
				optionList.remove(0);
				updatedValue = CoreFunctions.getRandomElementValueFromList(driver, optionList);
				BusinessFunctions.selectItemFromListUsingText(driver, optionList,
						updatedValue);
			} else {
				updatedValue=fieldValue;
				BusinessFunctions.selectItemFromListUsingText(driver, optionList, fieldValue);
			} 
			return updatedValue;
	}

	public static String calculatePageLoadTime(double tIME_BEFORE_ACTION, double tIME_AFTER_ACTION) {
		DecimalFormat format = new DecimalFormat();
		format.setMaximumFractionDigits(2);
		return format.format((tIME_AFTER_ACTION - tIME_BEFORE_ACTION) / 1000);
	}
	
	public static Map<String, String> convertStringToMapWithStream(String mapAsString) {
	    Map<String, String> map = Arrays.stream(mapAsString.replace("{", "").replace("}", "").split(","))
	      .map(entry -> entry.split("="))
	      .collect(Collectors.toMap(entry -> entry[0], entry -> entry[1]));
	    return map;
	}
}