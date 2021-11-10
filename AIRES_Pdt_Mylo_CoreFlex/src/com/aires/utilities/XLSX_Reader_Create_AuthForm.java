package com.aires.utilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.text.MessageFormat;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.PageObjectManager_Pdt;
import com.aires.managers.WebDriverManager;
import com.gargoylesoftware.htmlunit.ElementNotFoundException;

@SuppressWarnings("unused")
public class XLSX_Reader_Create_AuthForm {

	private static File file = null;
	private static FileInputStream fis = null;
	private static XSSFWorkbook wb = null;
	private static XSSFSheet sheet = null;
	private static int rowNum = 0;
	private static XSSFRow row = null;
	private static FileOutputStream fos = null;
	private static String authFormName = null;
	private static boolean isChecked = false;
	private WebDriver driver;
	private Map<String, Object> vars;
	JavascriptExecutor js;
	//private MobilityX_LoginPage _loginPage;
	//private MobilityX_AuthorizationHomePage _authorizationPage;
	private WebDriverManager _webDriverManager;
	private PageObjectManager_Pdt _pageObject;
	private boolean _isDisplayed = false;
	private static String _loginValue[] = new String[4];
	/*LoginData loginData = FileReaderManager.getInstance().getJsonReader()
			.getloginDetailsByUserFirstName(AiresConstants.USER_FIRST_NAME);*/

	@BeforeTest()
	public void setUp() {
		System.setProperty("webdriver.chrome.driver", System.getProperty("user.dir") + "/Drivers/chromedriver.exe");
		driver = new ChromeDriver();
		js = (JavascriptExecutor) driver;
		vars = new HashMap<String, Object>();
	}

	@Test(priority = 0)
/*	public void loginMobilityX() throws Exception {
		_pageObject = new PageObjectManager(driver);
		_loginPage = _pageObject.getLoginPage();
		_loginValue = _loginPage.getLoginDataAsPerEnvt(loginData);
		driver.get("https://samltest.aires.com/mobilityx/faces/jsf/Login.jsf");
		driver.manage().window().maximize();
		_loginPage.openApplication();
		driver.findElement(By.id("username::content")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("username::content")).sendKeys("92265testsix");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#nextButton .af_button_text")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("password::content")).click();
		Thread.sleep(2000);
		driver.findElement(By.id("password::content")).sendKeys("relonetng");
		Thread.sleep(2000);
		driver.findElement(By.cssSelector("#loginButton .af_button_text")).click();
		_loginPage.handle_Cookie_AfterLogin();
	}*/

	public void waitForLoad(WebDriver driver) {
		ExpectedCondition<Boolean> pageLoadCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript("return document.readyState").equals("complete");
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, 30);
		wait.until(pageLoadCondition);
	}

	public void handle_Cookie_AfterLogin() {
		waitForLoad(driver);
		WebDriverWait wait = new WebDriverWait(driver, 412);
		wait.until(ExpectedConditions
				.elementToBeClickable(driver.findElement(By.xpath("//*[@id='cookiePupupButtonId']/a"))));
		driver.findElement(By.xpath("//*[@id='cookiePupupButtonId']/a")).click();
		;
		Log.info("\n PopUp is Clicked Successfully \n");
	}

	public boolean authFormFirstLastName(String authFormName) throws Exception {
		CoreFunctions.waitHandler(5);
		WebDriverWait wait1 = new WebDriverWait(driver, 120);
		wait1.until(ExpectedConditions.elementToBeClickable(
				driver.findElement(By.xpath("//span[contains(text(), 'Create an authorization')]"))));
		driver.findElement(By.xpath("//span[contains(text(), 'Create an authorization')]")).click();
		CoreFunctions.waitHandler(5);

		// Switch to iFrame
		WebElement iframe = driver.findElement(By.xpath("//iframe[starts-with(@id, 'j_id')]"));
		driver.switchTo().frame(iframe);
		CoreFunctions.waitHandler(5);

		// Select Manual Option
		driver.findElement(By.id("xlsbr2::Label0")).click();

		CoreFunctions.waitHandler(2);
		WebElement element = driver.findElement(By.cssSelector("#stec1 .af_button_text"));
		Actions builder = new Actions(driver);
		builder.moveToElement(element).perform();

		String random = CoreFunctions.generateRandomString(5);

		CoreFunctions.waitHandler(5);

		// Enter FirstName
		driver.findElement(By.id("fname::content")).click();
		driver.findElement(By.id("fname::content")).sendKeys("AuthFormTest" + random);

		// Enter LastName
		driver.findElement(By.id("lname::content")).click();
		driver.findElement(By.id("lname::content")).sendKeys("TestFormAuth" + random);

		driver.findElement(By.cssSelector("#stec1 .af_button_text")).click();

		CoreFunctions.waitHandler(2);
		driver.findElement(By.id("cdot2")).click();

		CoreFunctions.waitHandler(2);
		driver.findElement(By.id("soc2::content")).click();

		CoreFunctions.waitHandler(2);
		WebElement dropdown = driver.findElement(By.id("soc2::content"));
		dropdown.findElement(By.xpath("//option[. = '" + authFormName + "']")).click();
		// Thread.sleep(2000);
		driver.findElement(By.id("soc2::content")).click();

		// Thread.sleep(2000);
		driver.findElement(By.cssSelector("#ctb1 .af_button_text")).click();

		// Thread.sleep(2000);
		driver.switchTo().defaultContent();

		// Thread.sleep(2000);
		js.executeScript("window.scrollTo(0,0)");

		CoreFunctions.waitHandler(2);
		if (driver.findElement(By.id("aRegion:0:startDate::content")).isDisplayed())
			return true;
		else
			return false;
	}

	@Test(priority = 1)
	public void runAuthThroughExcel() throws Exception {
		int colIndx = 0;
		try {
			file = new File(System.getProperty("user.dir") + "/Resource/TestData/AuthFormMatrix.xlsm");

			fis = new FileInputStream(file); // obtaining bytes from the file
			wb = new XSSFWorkbook(fis);

			XSSFSheet sheet = wb.getSheet("AuthFormDashboard"); // wb.getSheetAt(1);
			Iterator<Row> itr = sheet.iterator(); // iterating over excel file

			System.out.println(sheet.getLastRowNum());

			while (itr.hasNext()) {
				Row row = itr.next();
				Iterator<Cell> cellIterator = row.cellIterator(); // iterating over each column
				System.out.println("row.getRowNum() : " + row.getRowNum());
				int ro = row.getRowNum();

				while (cellIterator.hasNext()) {
					Cell cell = cellIterator.next();

					System.out.println("cell.getColumnIndex() : " + cell.getColumnIndex());
					colIndx = cell.getColumnIndex();

					switch (cell.getCellType()) {
					case STRING: // field that represents string cell type
						authFormName = cell.getStringCellValue();
						System.out.print(authFormName + "\t\t\t");
						break;
					case NUMERIC: // field that represents number cell type
						rowNum = (int) cell.getNumericCellValue();
						System.out.print(rowNum + "\t\t\t");
						break;
					case BOOLEAN: // field that represents number cell type
						isChecked = cell.getBooleanCellValue();
						System.out.print(isChecked + "\t\t\t");
						break;
					default:
					}
				}
				if (isChecked) {
					authFormFirstLastName(authFormName);
					Thread.sleep(1000);
					getAuthFormValue(wb, authFormName);
					clickSubmitButton();
				}
				System.out.println("");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public boolean verifySuccessDialogDisplayed(WebDriver driver) {
		// Dialog - Success Message - New Transferee Creation
		WebElement _dialogSuccessMessage = driver.findElement(By.xpath("//div[@id='growls']/div"));

		CoreFunctions.explicitWaitTillElementVisibility(driver, _dialogSuccessMessage, PDTConstants.SUCCESS_DIALOG);
		try {
			if (CoreFunctions.verifyElementPresentOnPage(_dialogSuccessMessage, PDTConstants.SUCCESS_DIALOG)) {
				_isDisplayed = true;
				Log.info(CoreConstants.PASS + CoreConstants.VRFIED_THAT + PDTConstants.SUCCESS_MESSAGE_TEXT
						+ CoreConstants.IS_DISPLAYED_AS + "<b>\"" + _dialogSuccessMessage.getText() + "\"</b>");
				Log.info(MessageFormat.format(PDTConstants.NEW_TRANSFEREE_CREATED, CoreConstants.PASS,
						CoreFunctions.getPropertyFromConfig(PDTConstants.FIRST_NAME_TEXT),
						CoreFunctions.getPropertyFromConfig(PDTConstants.LAST_NAME_TEXT)));
			} else {
				Log.info(CoreConstants.FAIL + PDTConstants.SUCCESS_DIALOG + PDTConstants.IS_NOT_DISPLAYED);
				Assert.fail(PDTConstants.SUCCESS_DIALOG + PDTConstants.IS_NOT_DISPLAYED);
			}
		} catch (ElementNotFoundException e) {
			e.printStackTrace();
			Log.info("Exception :" + e);
		}
		CoreFunctions.explicitWaitTillElementInVisibility(driver, _dialogSuccessMessage);
		return _isDisplayed;
	}

	public void clickSubmitButton() throws Exception {
		CoreFunctions.waitHandler(3);
		driver.findElement(By.xpath("//span[contains(text(), 'Submit to Aires')]")).click();
		CoreFunctions.waitHandler(20);
	}

	public void getAuthFormValue(XSSFWorkbook wb, String authFormName) throws Exception {
		String action = null, locatorType = null, locatorValue = null, fieldValue = null;
		sheet = wb.getSheet("AuthFormValue"); // wb.getSheetAt(2);
		for (int rowIndex = 0; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
			row = sheet.getRow(rowIndex);

			if (row.getCell(0).toString().equalsIgnoreCase(authFormName)) {
				int colCount = sheet.getRow(rowIndex).getPhysicalNumberOfCells();
				int cellLastCount = sheet.getRow(rowIndex).getLastCellNum();

				System.out.println("Column Count for Row number '" + rowIndex + "' is : " + colCount);
				System.out.println("Last Cell Count for Row number '" + rowIndex + "' is : " + cellLastCount);

				for (int colIndex = 1; colIndex < colCount; colIndex++) {
					Cell cell = row.getCell(colIndex);
					System.out.println(colIndex + 1);
					switch (cell.getCellType()) {
					case STRING: // field that represents string cell type
						System.out.print(cell.getStringCellValue() + "\t\t\t");
						break;
					case NUMERIC: // field that represents number cell type
						System.out.print((int) cell.getNumericCellValue() + "\t\t\t");
						break;
					case BOOLEAN: // field that represents number cell type
						System.out.print(cell.getBooleanCellValue() + "\t\t\t");
						break;
					default:
					}
					action = sheet.getRow(rowIndex + 1).getCell(colIndex).toString();
					locatorType = sheet.getRow(rowIndex + 2).getCell(colIndex).toString();
					locatorValue = sheet.getRow(rowIndex + 3).getCell(colIndex).toString();
					fieldValue = sheet.getRow(rowIndex + 4).getCell(colIndex).toString();
					performAction(action, locatorType, locatorValue, fieldValue);
				}
			}
			System.out.println("");
		}
	}

	public void performAction(String actionKeyword, String locatorType, String locatorValue, String fieldValue)
			throws Exception {
		System.out.println("");
		switch (actionKeyword.toUpperCase()) {
		case "CLICK":
			Thread.sleep(1000);
			// Perform click
			driver.findElement(this.locatorValue(locatorType, locatorValue)).click();
			System.out.println("Perform CLICK Function");
			By clk = this.locatorValue(locatorType, locatorValue);
			System.out.println(clk);
			break;
		case "INPUT":
			Thread.sleep(1000);
			// Set text on control
			System.out.println("Perform SETTEXT Function");
			By inp = this.locatorValue(locatorType, locatorValue);
			System.out.println(inp);
			driver.findElement(this.locatorValue(locatorType, locatorValue)).clear();
			driver.findElement(this.locatorValue(locatorType, locatorValue)).sendKeys(fieldValue);
			break;

		case "SELECT":
			// Select value from Dropdown
			Select drpCountry = new Select(driver.findElement(this.locatorValue(locatorType, locatorValue)));
			Thread.sleep(1000);
			drpCountry.selectByVisibleText(fieldValue);
			System.out.println(fieldValue);
			System.out.println("Perform SELECT Function");
			By sel = this.locatorValue(locatorType, locatorValue);
			System.out.println(sel);
			break;
		case "CLICK_RADIO":
			// Select value from Radio Button
			Thread.sleep(1000);
			driver.findElement(this.locatorValue(locatorType, locatorValue)).click();
			System.out.println("Perform CLICK RADIO Button Function");
			By rad = this.locatorValue(locatorType, locatorValue);
			System.out.println(rad);
			break;
		default:
			break;
		}
	}

	public By locatorValue(String locatorTpye, String locatorValue) {
		By by;
		switch (locatorTpye) {
		case "id":
			by = By.id(locatorValue);
			break;
		case "name":
			by = By.name(locatorValue);
			break;
		case "xpath":
			by = By.xpath(locatorValue);
			break;
		case "css":
			by = By.cssSelector(locatorValue);
			break;
		case "linkText":
			by = By.linkText(locatorValue);
			break;
		case "partialLinkText":
			by = By.partialLinkText(locatorValue);
			break;
		default:
			by = null;
			break;
		}
		return by;
	}

	@AfterTest
	public void tearDown() {
		driver.close();
	}
}