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
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Properties;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import java.util.Properties;
import com.aires.enums.DriverType;
import com.aires.enums.EnvironmentType;

public class ConfigFileReader {
	private Properties properties;
	private final String propertyFilePath = System.getProperty("user.dir") + "\\Configs\\Config.properties";
//	private static String _url = null;
	LinkedHashMap<String, String> mapEnvURL = new LinkedHashMap<String, String>();

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
		else if (properties.getProperty("envt").equalsIgnoreCase("Uat"))
			return properties.getProperty("pdtUatURL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	

	public void mapApplicationURL() {
		mapEnvURL.put(CoreConstants.MXTRANSFEREE_QA, CoreConstants.MXTRANSFEREE_QA_URL);
		mapEnvURL.put(CoreConstants.MXTRANSFEREE_UAT, CoreConstants.MXTRANSFEREE_UAT_URL);
		mapEnvURL.put(CoreConstants.MXTRANSFEREE_PREPROD, CoreConstants.MXTRANSFEREE_PREPROD_URL);
		mapEnvURL.put(CoreConstants.TRANSMISSION_SUBMISSION_QA, CoreConstants.TRANSMISSION_SUBMISSION_QA_URL);
		mapEnvURL.put(CoreConstants.TRANSMISSION_SUBMISSION_UAT, CoreConstants.TRANSMISSION_SUBMISSION_UAT_URL);
		mapEnvURL.put(CoreConstants.TRANSMISSION_SUBMISSION_PREPROD, CoreConstants.TRANSMISSION_SUBMISSION_PREPROD_URL);
	}
	
	
	public String getApplicationUrl(String appName) {
		mapApplicationURL();
		return mapEnvURL.get(appName+"_"+System.getProperty("envt"));
		
		//Commented Code is used for Debugging purpose in local
		/*if (properties.getProperty("envt").equalsIgnoreCase("uat"))
			return properties.getProperty("myloUATURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("relonetqa4"))
			return properties.getProperty("myloRelonetQA4URL");
		else if (properties.getProperty("envt").equalsIgnoreCase("preprod"))
			return properties.getProperty("myloPreProdURL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");	*/
	}

	public String getMyloApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("uat"))
			return properties.getProperty("myloUATURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("relonetqa4"))
			return properties.getProperty("myloRelonetQA4URL");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getCoreFlexPolicySetupApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("UAT"))
			return properties.getProperty("coreFlexPolicySetupUatUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("QA"))
			return properties.getProperty("coreFlexPolicySetupQaUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("Prod"))
			return properties.getProperty("coreFlexPolicySetupProdUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("Dev"))
			return properties.getProperty("coreFlexPolicySetupDevUrl");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getCoreFlexTransfereeSubmissionsApplicationUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("UAT"))
			return properties.getProperty("coreFlexTransfereeSubmissionsUatUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("QA"))
			return properties.getProperty("coreFlexTransfereeSubmissionsQaUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("Prod"))
			return properties.getProperty("coreFlexTransfereeSubmissionsProdUrl");
		else if (properties.getProperty("envt").equalsIgnoreCase("Dev"))
			return properties.getProperty("coreFlexTransfereeSubmissionsDevUrl");
		else
			throw new RuntimeException(
					"Application Url not specified in the Configuration.properties file for the Key:url");
	}
	
	public String getMobilityXUrl() {
		if (properties.getProperty("envt").equalsIgnoreCase("UAT"))
			return properties.getProperty("mxTransfereeUatURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("QA"))
			return properties.getProperty("mxTransfereeQaURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Prod"))
			return properties.getProperty("mxTransfereeProdURL");
		else if (properties.getProperty("envt").equalsIgnoreCase("Dev"))
			return properties.getProperty("mxTransfereeDevURL");
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
		//String browserName = properties.getProperty("browser").toLowerCase();
		String browserName = System.getProperty("browser");
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
	
	public String getNameOfCurrentLaunchedApplication() {
		//String appName = properties.getProperty("application");
		String appName = System.getProperty("application");
		if (appName != null)
			return appName;
		else
			throw new RuntimeException(
					"Application Name not specified in the Configuration.properties file for the Key:url");
	}
}