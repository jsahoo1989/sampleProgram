package com.aires.pages.iris.basepage;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.management.ManagementFactory;
import java.lang.management.RuntimeMXBean;
import java.net.InetAddress;
import java.net.URI;
import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.LinkedHashMap;

import org.testng.Assert;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.IRISConstants;
import com.aires.managers.FileReaderManager;
import com.aires.pages.iris.IRIS_PageMaster;
import com.aires.testdatatypes.coreflex.CoreFlex_LoginInfo;
import com.aires.testdatatypes.pdt.PDT_LoginDetails;
import com.aires.utilities.Log;
import com.aires.utilities.getWindowText;
import com.hp.lft.sdk.Desktop;
import com.hp.lft.sdk.GeneralLeanFtException;
import com.hp.lft.sdk.ModifiableSDKConfiguration;
import com.hp.lft.sdk.SDK;
import com.hp.lft.sdk.java.Button;
import com.hp.lft.sdk.java.ButtonDescription;
import com.hp.lft.sdk.java.Window;
import com.hp.lft.sdk.java.WindowDescription;
import com.hp.lft.sdk.web.Browser;
import com.hp.lft.sdk.web.BrowserDescription;
import com.hp.lft.sdk.web.BrowserFactory;

public class BasePage {
	protected static Window _IRIS;
	private static String _windowTitle = null;
	private static Process _process;
	private Browser[] _browser;
	private static String _path = null;
	private static final String TASKLIST = "tasklist";
	private final String KILL = "taskkill /F /IM ";
	private final String _killByPID = "taskkill /F /PID ";
	private static ArrayList<String> _pid = new ArrayList<String>();
	private static ArrayList<String> _servicePID;
	private static String _processName = "javaw.exe";
	private static String _getAllLFTTasksRunning = "tasklist /fo table /nh /fi \"Imagename eq LFTRuntime.exe\" /v";
	private static String _userName = System.getProperty("user.name").toLowerCase();
	private static String _processName_uftRuntimeEngine = "LFTRuntime.exe";
	private PDT_LoginDetails _loginDetails;
	LinkedHashMap<String, Integer> userPortMap = new LinkedHashMap<String, Integer>();

	private CoreFlex_LoginInfo _coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
			.getLoginInfoByEnviroment((CoreFunctions.getPropertyFromConfig("envt").toLowerCase()));

//	private CoreFlex_LoginInfo _coreFlexLoginInfo = FileReaderManager.getInstance().getCoreFlexJsonReader()
//			.getLoginInfoByEnviroment(System.getProperty("envt").toLowerCase());	

	public BasePage() throws Exception {
		Thread.sleep(2000);
		_windowTitle = getWindowText.getActiveWindowText();
		while (_windowTitle.contains(IRISConstants.PROGRESS_TEXT)) {
			_windowTitle = getWindowText.getActiveWindowText();
			Thread.sleep(2000);
		}
		Log.info(IRISConstants.WINDOW_TITLE + _windowTitle + " done");
		_IRIS = Desktop.describe(Window.class, new WindowDescription.Builder().title(_windowTitle).build());
	}

	public void invokeIrisApplication() throws Exception {
//		getPIDAndKillProces();
		CoreFunctions.waitHandler(2);
		allocateUFTPortToUsers();
		runLFTEngineAsPerStatus();
		CoreFunctions.waitHandler(3);
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		int portNumber = getPortNumberAsPerUserName();
		Log.info("Port Assigned to " + _userName + " is : " + portNumber);
		config.setServerAddress(new URI("ws://localhost:" + portNumber));
		SDK.init(config);
		_path = getIrisPathForApplication(CoreFunctions.getPropertyFromConfig("application"));
//		_path = getIrisPathForApplication(System.getProperty("application"));
		_process = Runtime.getRuntime().exec(_path);
		_windowTitle = getWindowText.getActiveWindowText();
		while (!_windowTitle.contains("Login")) {
			CoreFunctions.waitHandler(2);
			_windowTitle = getWindowText.getActiveWindowText();
		}
		_IRIS = Desktop.describe(Window.class, new WindowDescription.Builder().title(_windowTitle).build());
	}

	public int getPortNumberAsPerUserName() throws Exception {
//		int port = 0;
		// String userName = System.getProperty("user.name").toLowerCase();
		String computerName = InetAddress.getLocalHost().getHostName();
		if (computerName.equalsIgnoreCase("corpprdvw270") || _userName.equalsIgnoreCase("vmallah"))
			return 5090;
		else
			return userPortMap.get(_userName);
	}

	public Window getIRISWindowAfterLogin() throws Exception {
		Thread.sleep(10000);
		_windowTitle = getWindowText.getActiveWindowText();
		while (_windowTitle.contains(IRISConstants.PROGRESS_TEXT)) {
			Thread.sleep(2000);
			_windowTitle = getWindowText.getActiveWindowText();
		}
		return _IRIS = Desktop.describe(Window.class, new WindowDescription.Builder().title(_windowTitle).build());
	}

	public static Window getIRISWindow() throws Exception {
		Thread.sleep(8000);
		_windowTitle = getWindowText.getActiveWindowText();
		System.out.println("WindowTitle : "+_windowTitle);
		return Desktop.describe(Window.class, new WindowDescription.Builder().title(_windowTitle).build());
	}

	public Process getIRISProcess() {
		return _process;
	}

	public void killProcess(String serviceName) throws Exception {
		Runtime.getRuntime().exec(KILL + serviceName);
	}

	public Browser[] getIrisInvokedBrowsers() throws GeneralLeanFtException {
		return BrowserFactory.getAllOpenBrowsers(new BrowserDescription.Builder().build());
	}

	public void killExistingBrowsers() throws GeneralLeanFtException {
		_browser = getIrisInvokedBrowsers();
		if (_browser.length > 0) {
			for (Browser browser : _browser) {
				browser.close();
			}
			// _browser[0].closeAllTabs();
			_browser = null;
		}
	}

	public void closeIRISApplication() throws Exception {
		Thread.sleep(2000);
		_IRIS = Desktop.describe(Window.class, new WindowDescription.Builder().title("Welcome").build());
		if (_IRIS.exists() && _IRIS.isVisible()) {
			_IRIS.describe(Button.class, new ButtonDescription.Builder().label("exit_32").build()).click();
		}
		Thread.sleep(2000);
		_IRIS = null;
		Runtime.getRuntime().gc();
	}

	public void cleanIrisProcesses() throws Exception {
//		killExistingBrowsers();
		closeIRISApplication();
	}

	public String getWindowTitle() throws Exception {
		return _IRIS.getTitle();
	}

	public ArrayList<String> getPIDAsPerServiceName(String processName) throws Exception {
		_process = Runtime.getRuntime().exec(TASKLIST);
		BufferedReader reader = new BufferedReader(new InputStreamReader(_process.getInputStream()));
		String line;
		while ((line = reader.readLine()) != null) {
			// Log.info(line); //for debugging purpose
			if (line.contains(processName)) {
				// Need to implement logic in this manner as PID can be 3, 4, 5 digits and
				// substring function sometime didn't work
				String[] linePID_Split = line.split(processName, 2);
				String[] getPID = linePID_Split[1].trim().split(" ", 2);
				Log.info("The PID value is : " + getPID[0]);
				_pid.add(getPID[0]);
			}
		}
		return _pid;
	}

	public void killProcess(ArrayList<String> pid, long jvmPID) throws Exception {
		for (String processID : pid) {
			Log.info("PID is : " + processID.trim());
			if (processID.equalsIgnoreCase(Long.toString(jvmPID))) {
				Log.info("This is a JVM PID");
			} else {
				Log.info(_killByPID + processID.trim());
				Runtime.getRuntime().exec(_killByPID + processID.trim());
			}
		}
	}

	public void getPIDAndKillProces() throws Exception {
		RuntimeMXBean bean = ManagementFactory.getRuntimeMXBean();
		// Get name representing the running Java virtual machine. It returns something
		// like 6460@AURORA. Where the value before the @ symbol is the PID.
		String _jvmName = bean.getName();
		Log.info("JVM Name = " + _jvmName);
		// Extract the PID by splitting the string returned by the bean.getName()
		// method.
		long _jvmPID = Long.valueOf(_jvmName.split("@")[0]);
		Log.info("JVM PID = " + _jvmPID);
		_servicePID = getPIDAsPerServiceName(_processName);
		if (_servicePID.size() > 0) {
			killProcess(_servicePID, _jvmPID);
		}
	}

	public boolean getRunningStatus_LFTRuntimeEngine(String processName) {
		try {
			_process = Runtime.getRuntime().exec(_getAllLFTTasksRunning);
			BufferedReader reader = new BufferedReader(new InputStreamReader(_process.getInputStream()));
			String line;
			while ((line = reader.readLine()) != null) {
				// Log.info(line);
				if (line.contains(processName) && line.contains(_userName))
					return true;
			}
		} catch (Exception e) {
			Log.info("Error Message : " + e);
		}
		return false;
	}

	public void runLFTEngineAsPerStatus() throws Exception {
		if (getRunningStatus_LFTRuntimeEngine(_processName_uftRuntimeEngine))
			Log.info("UFT Developer Runtime is Up and Running for User Name: " + _userName);
		else {
			Log.info("UFT Developer Runtime Engine is not running..\nStarting the Runtime engine now...");
			Runtime.getRuntime().exec("C:\\Program Files (x86)\\Micro Focus\\UFT Developer\\bin\\leanft.bat start");
		}
	}

	public String getIrisPathForApplication(String appName) {
		String irisBuildPath = null;
		Log.info("appName=" + appName);
		switch (appName) {
		case CoreConstants.APP_PDT:
			_loginDetails = FileReaderManager.getInstance().getJsonReader()
					.getLoginByApplication(CoreConstants.APP_PDT);
			/*
			 * irisBuildPath = getIRISPathAsPerEnvtForPDT(_loginDetails,
			 * CoreFunctions.getPropertyFromConfig("envt").toLowerCase());
			 */
			irisBuildPath = getIRISPathAsPerEnvtForPDT(_loginDetails, System.getProperty("envt").toLowerCase());
			break;
		case CoreConstants.APP_COREFLEX:
			_loginDetails = FileReaderManager.getInstance().getJsonReader()
					.getLoginByApplication(CoreConstants.APP_COREFLEX);
			irisBuildPath = getIRISPathAsPerEnvtForCoreFlex(_coreFlexLoginInfo);
			break;
		default:
			/*
			 * Assert.fail(MessageFormat.format(CoreConstants.INVALID_APPLICATION,
			 * CoreFunctions.getPropertyFromConfig("application")));
			 */
			Assert.fail(MessageFormat.format(CoreConstants.INVALID_APPLICATION, System.getProperty("application")));
		}
		return irisBuildPath;
	}

	public String getIRISPathAsPerEnvtForPDT(PDT_LoginDetails _loginDetails, String appEnv) {
		String irisBuildPath = null;
		switch (appEnv) {
		case CoreConstants.ENVT_DEV:
			irisBuildPath = _loginDetails.dev.irisBuildPath;
			break;
		case CoreConstants.ENVT_QA:
			irisBuildPath = _loginDetails.qa.irisBuildPath;
			break;
		case CoreConstants.ENVT_UAT:
			irisBuildPath = _loginDetails.uat.irisBuildPath;
			break;
		case CoreConstants.ENVT_TEST:
			irisBuildPath = _loginDetails.preProd.irisBuildPath;
			break;
		case CoreConstants.ENVT_PROD:
			irisBuildPath = _loginDetails.prod.irisBuildPath;
			break;
		default:
			Assert.fail(MessageFormat.format(CoreConstants.INVALID_ENVIRONMENT,
					CoreFunctions.getPropertyFromConfig("application")));
			/*
			 * Assert.fail(MessageFormat.format(CoreConstants.INVALID_ENVIRONMENT,
			 * System.getProperty("application")));
			 */
		}
		return irisBuildPath;
	}

	public String getIRISPathAsPerEnvtForCoreFlex(CoreFlex_LoginInfo _coreFlexLoginInfo) {
		return _coreFlexLoginInfo.details.irisBuildPath;
	}

	public void allocateUFTPortToUsers() {
		userPortMap.put("spant", 5095);
		userPortMap.put("rsharma", 5096);
		userPortMap.put("pdash", 5097);
		userPortMap.put("vmallah", 5090);
	}

	public void reLaunchIrisToAvoidFreezingIssue() throws Exception {
//		getPIDAndKillProces();
		if (!getRunningStatus_LFTRuntimeEngine(_processName_uftRuntimeEngine)) {
			invokeIrisApplication();
			closeIRISLoginWindow();
		}
		ModifiableSDKConfiguration config = new ModifiableSDKConfiguration();
		int portNumber = getPortNumberAsPerUserName();
		config.setServerAddress(new URI("ws://localhost:" + portNumber));
		SDK.init(config);
		String _path = getIrisPathForApplication(CoreFunctions.getPropertyFromConfig("application"));
//		String _path = getIrisPathForApplication(System.getProperty("application"));
		Runtime.getRuntime().exec(_path);
		String _windowTitle = getWindowText.getActiveWindowText();
		while (!_windowTitle.contains("Login")) {
			CoreFunctions.waitHandler(5);
			_windowTitle = getWindowText.getActiveWindowText();
		}
		Desktop.describe(Window.class, new WindowDescription.Builder().title(_windowTitle).build());
	}

	private void closeIRISLoginWindow() {
		try {
			IRIS_PageMaster.getWindowObject(IRISConstants.LOGIN_WINDOW_TITLE).close();
		} catch (Exception e) {
			Assert.fail(CoreConstants.ERROR + e.getMessage());
		}
	}
}