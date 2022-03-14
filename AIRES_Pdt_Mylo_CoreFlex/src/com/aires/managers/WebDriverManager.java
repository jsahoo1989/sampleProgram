/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			Rahul Sharma					manage the driver initiation, invoke browsers as per the value parsed.
 * 21/04/2020			Rahul Sharma					Updated chrome option dependencies
 * 13/05/2020			Rahul Sharma					Updated methods to incorporate all the browsers, so that script can run on all the browsers
 * 02/06/2021			Rahul Sharma					Updated driver close method so that driver instance should be closed completely and implementation of WebDrievr Manager
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.managers;

import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import org.openqa.selenium.PageLoadStrategy;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.ie.InternetExplorerOptions;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.aires.businessrules.CoreFunctions;
import com.aires.enums.DriverType;
import com.aires.enums.EnvironmentType;

public class WebDriverManager {
	private WebDriver driver;
	private static DriverType driverType;
	private static EnvironmentType environmentType;
	// private static final String CHROME_DRIVER_PROPERTY =
	// "webdriver.chrome.driver";
	// private static final String GECKO_DRIVER_PROPERTY = "webdriver.gecko.driver";
	// private static final String IE_DRIVER_PROPERTY = "webdriver.ie.driver";
	// private static final String EDGE_DRIVER_PROPERTY = "webdriver.edge.driver";
	String downloadFilepath = System.getProperty("user.home") + "/Downloads/";

	public WebDriverManager() {
		driverType = FileReaderManager.getInstance().getConfigReader().getBrowser();
		environmentType = FileReaderManager.getInstance().getConfigReader().getEnvironment();
	}

	public WebDriver getDriver() {
		if (driver == null)
			driver = createDriver();
		return driver;
	}

	private WebDriver createDriver() {
		switch (environmentType) {
		case LOCAL:
			driver = createLocalDriver();
			break;
		case REMOTE:
			driver = createRemoteDriver();
			break;
		}
		return driver;
	}

	private WebDriver createRemoteDriver() {
		throw new RuntimeException("RemoteWebDriver is not yet implemented");
	}

	private WebDriver createLocalDriver() {
		switch (driverType) {
		case FIREFOX:
			invokeFirefoxBrowser();
			break;
		case CHROME:
			invokeChromeBrowser();
			break;
		case INTERNETEXPLORER:
			invokeInternetExplorerBrowser();
			break;
		case EDGE:
			invokeEdgeBrowser();
			break;
		}

		if (FileReaderManager.getInstance().getConfigReader().getBrowserWindowSize())
			driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(FileReaderManager.getInstance().getConfigReader().getImplicitlyWait(),
				TimeUnit.SECONDS);
		return driver;
	}

	public void invokeChromeBrowser() {
		HashMap<String, Object> chromePrefs = new HashMap<String, Object>();
		chromePrefs.put("profile.default_content_settings.popups", 0);
		downloadFilepath = downloadFilepath.replace("/", "\\");
		chromePrefs.put("download.default_directory", downloadFilepath);
		// System.setProperty(CHROME_DRIVER_PROPERTY,
		// FileReaderManager.getInstance().getConfigReader().getDriverPath());
		io.github.bonigarcia.wdm.WebDriverManager.chromedriver().setup();
		ChromeOptions chromeOption = new ChromeOptions();
		chromeOption.setExperimentalOption("useAutomationExtension", false);
		chromeOption.setPageLoadStrategy(PageLoadStrategy.NONE);
		chromeOption.addArguments("start-maximized");
		chromeOption.addArguments("enable-automation");
		chromeOption.addArguments("--no-sandbox");
		chromeOption.addArguments("--disable-infobars");
		chromeOption.addArguments("--disable-dev-shm-usage");
		chromeOption.addArguments("--disable-browser-side-navigation");
		chromeOption.addArguments("--disable-gpu");
		chromeOption.addArguments("--ignore-certificate-errors");

		//Use below options to run script on Incognito Chrome Browser
		//chromeOption.addArguments("--incognito");
		//chromeOption.setCapability(ChromeOptions.CAPABILITY, chromeOption);
		
		chromeOption.setExperimentalOption("prefs", chromePrefs);
		driver = new ChromeDriver(chromeOption);
	}

	public void invokeFirefoxBrowser() {
		System.setProperty(FirefoxDriver.SystemProperty.BROWSER_LOGFILE, "false"); // to disable marionette logs
		// System.setProperty(GECKO_DRIVER_PROPERTY,
		// FileReaderManager.getInstance().getConfigReader().getGeckoDriverPath());
		io.github.bonigarcia.wdm.WebDriverManager.firefoxdriver().setup();
		FirefoxProfile firefoxProfile = new FirefoxProfile();
		firefoxProfile.setPreference("browser.download.folderList", 2);
		downloadFilepath = downloadFilepath.replace("/", "\\");
		firefoxProfile.setPreference("browser.download.dir", downloadFilepath);
		firefoxProfile.setPreference("browser.helperApps.neverAsk.saveToDisk", "application/jpg");
		FirefoxOptions options = new FirefoxOptions();
		options.setProfile(firefoxProfile);
		options.setBinary(CoreFunctions.getPropertyFromConfig("binaryFirefoxPath"));
		driver = new FirefoxDriver(options);
	}

	public void invokeInternetExplorerBrowser() {
		DesiredCapabilities cap = new DesiredCapabilities();
		// System.setProperty(IE_DRIVER_PROPERTY,
		// FileReaderManager.getInstance().getConfigReader().getIEDriverPath());
		io.github.bonigarcia.wdm.WebDriverManager.iedriver().setup();
		cap.setCapability(InternetExplorerDriver.IE_ENSURE_CLEAN_SESSION, true);
		InternetExplorerOptions options = new InternetExplorerOptions(cap);
		driver = new InternetExplorerDriver(options);
	}

	public void invokeEdgeBrowser() {
		// System.setProperty(EDGE_DRIVER_PROPERTY,
		// FileReaderManager.getInstance().getConfigReader().getEdgeDriverPath());
		io.github.bonigarcia.wdm.WebDriverManager.edgedriver().setup();
		EdgeOptions options = new EdgeOptions();		
		options.setPageLoadStrategy(PageLoadStrategy.NORMAL);
		driver = new EdgeDriver(options);
	}

	public void closeDriver() {
		driver.quit();
		driver = null;
	}
}