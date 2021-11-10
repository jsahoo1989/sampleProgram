/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			Rahul Sharma					Read data from config file
 * 13/05/2020			Rahul Sharma					Updated methods to include firefox, IE and Edge browsers execution
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.dataProviders;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.PDTConstants;
import com.aires.enums.DriverType;
import com.aires.enums.EnvironmentType;
import com.aires.utilities.Log;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + "\\Configs\\Config.properties";
	private static String _url = null;

	public ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	@SuppressWarnings("unused")
	public String getDriverPath() {
		String driverPath = System.getProperty("user.dir") + properties.getProperty("driverPath");
		if (driverPath != null)
			return driverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:driverPath");
	}

	@SuppressWarnings("unused")
	public String getGeckoDriverPath() {
		String geckoDriverPath = System.getProperty("user.dir") + properties.getProperty("geckoDriverPath");
		if (geckoDriverPath != null)
			return geckoDriverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:geckoDriverPath");
	}

	@SuppressWarnings("unused")
	public String getIEDriverPath() {
		String ieDriverPath = System.getProperty("user.dir") + properties.getProperty("ieDriverPath");
		if (ieDriverPath != null)
			return ieDriverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:ieDriverPath");
	}

	@SuppressWarnings("unused")
	public String getEdgeDriverPath() {
		String edgeDriverPath = System.getProperty("user.dir") + properties.getProperty("edgeDriverPath");
		if (edgeDriverPath != null)
			return edgeDriverPath;
		else
			throw new RuntimeException(
					"Driver Path not specified in the Configuration.properties file for the Key:edgeDriverPath");
	}

	public long getImplicitlyWait() {
		String implicitlyWait = properties.getProperty("implicitlyWait");
		if (implicitlyWait != null) {
			try {
				return Long.parseLong(implicitlyWait);
			} catch (NumberFormatException e) {
				throw new RuntimeException("Not able to parse value : " + implicitlyWait + " in to Long");
			}
		}
		return 30;
	}

	public String getPDTApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("Test"))
			return properties.getProperty("pdtTestURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("QA"))
			return properties.getProperty("pdtQaURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Prod"))
			return properties.getProperty("pdtProdURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Dev"))
			return properties.getProperty("pdtDevURL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getMyloApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("Test"))
			return properties.getProperty("myloTestURL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getCoreFlexApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("Test"))
			return properties.getProperty("coreFlexTestURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("QA"))
			return properties.getProperty("coreFlexQaURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Prod"))
			return properties.getProperty("coreFlexProdURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Dev"))
			return properties.getProperty("coreFlexDevURL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getSpringboardApplicationUrl() {
		String url = properties.getProperty("testURLSpringboard");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public String getPartnerAllocationApplicationUrl() {
		String url = properties.getProperty("urlPartnerAllocation");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}

	public DriverType getBrowser() {
		String browserName = properties.getProperty("browser").toLowerCase();
		switch (browserName) {
		case "chrome":
			return DriverType.CHROME;
		case "firefox":
			return DriverType.FIREFOX;
		case "iexplorer":
		case "ie":
			return DriverType.INTERNETEXPLORER;
		case "edge":
			return DriverType.EDGE;
		default:
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties file is not matched : " + browserName);
		}
			
			/*
			if (browserName == null || browserName.equalsIgnoreCase("chrome"))
			return DriverType.CHROME;
		else if (browserName.equalsIgnoreCase("firefox"))
			return DriverType.FIREFOX;
		else if (browserName.equals("iexplorer") || browserName.equalsIgnoreCase("ie"))
			return DriverType.INTERNETEXPLORER;
		else if (browserName.equalsIgnoreCase("edge"))
			return DriverType.EDGE;
		else
			throw new RuntimeException(
					"Browser Name Key value in Configuration.properties is not matched : " + browserName);*/
	}

	public EnvironmentType getEnvironment() {
		String environmentName = properties.getProperty("environment");
		if (environmentName == null || environmentName.equalsIgnoreCase("local"))
			return EnvironmentType.LOCAL;
		else if (environmentName.equals("remote"))
			return EnvironmentType.REMOTE;
		else
			throw new RuntimeException(
					"Environment Type Key value in Configuration.properties is not matched : " + environmentName);
	}

	public Boolean getBrowserWindowSize() {
		String windowSize = properties.getProperty("windowMaximize");
		if (windowSize != null)
			return Boolean.valueOf(windowSize);
		return true;
	}

	@SuppressWarnings("unused")
	public String getTestDataResourcePath() {
		String testDataResourcePath = System.getProperty("user.dir") + properties.getProperty("testDataResourcePath");
		if (testDataResourcePath != null)
			return testDataResourcePath;
		else
			throw new RuntimeException(
					"Test Data Resource Path not specified in the Configuration.properties file for the Key:testDataResourcePath");
	}

	@SuppressWarnings("unused")
	public String getReportConfigPath() {
		String reportConfigPath = System.getProperty("user.dir") + properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}

	public Map<String, String> getClientUserDetails() {
		Map<String, String> clientUserDetail = new HashMap<>();
		clientUserDetail.put("clientUserName", properties.getProperty("clientUserName"));
		clientUserDetail.put("clientPassword", properties.getProperty("clientPassword"));
		clientUserDetail.put("clientFirstName", properties.getProperty("clientFirstName"));
		clientUserDetail.put("clientLastName", properties.getProperty("clientLastName"));
		return clientUserDetail;
	}

	public Map<String, String> getReportsTab() {
		Map<String, String> reportTab = new HashMap<>();
		reportTab.put("active_ActivityElement", "_txtActivityTabActive");
		reportTab.put("header_ActivityElement", "_txtActivityHistory");
		reportTab.put("active_MyReportElement", "_txtMyReportsTabActive");
		reportTab.put("header_MyReportElement", "_hdrMyFavorites");
		reportTab.put("active_ActivityElementVal", PDTConstants.ACTIVITY);
		reportTab.put("header_ActivityElementVal", PDTConstants.ACTIVITY_HISTORY);
		reportTab.put("active_MyReportElementVal", PDTConstants.MY_REPORTS_TAB);
		reportTab.put("header_MyReportElementVal", PDTConstants.MY_FAVORITES);

		return reportTab;
	}
	
	public String getApproverForRoutingException() {
		return properties.getProperty("approverFullNameforRoutingException");
	}
	
	public String getTransfereFullName() {
		return properties.getProperty("Transferee_firstName") + " "+ properties.getProperty("Transferee_lastName");
	}
	
	public void setBETForumlaFlag() {
		Log.info("Setting BET Formula flag");
		CoreFunctions.writeToPropertiesFile("BETFormula_Flag", "true");
	}
	
	public String getAssistApplicationUrl() {
		String url = properties.getProperty("testURLAssist");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getEmacApplicationUrl() {
		String url = properties.getProperty("testURLEMAC");
		if (url != null)
			return url;
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
}