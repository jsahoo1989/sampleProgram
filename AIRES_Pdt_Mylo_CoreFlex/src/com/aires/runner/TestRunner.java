/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 17/04/2020			Rahul Sharma					created Runner test for execution of BDD scenarios using JUnit
 * 18/04/2020			Rahul Sharma					Updated TestRunnser class to run test through Extent Report of TestNG
 * 21/04/2020			Rahul Sharma					Updated class file for generate unique extent report during every execution and display 
 * 														configuration in report
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods.
 *  
 ******************************************************************************************************************************************************
 * Cucumber Options:
 * Option Type		Purpose																Default Value
 * dryRun			true: Checks if all the Steps have the Step Definition				false
 * features			set: The path of feature file										{}
 * glue				set: The path of step definition file								{}
 * tags				instruct: What tags in features files should be executed			{}
 * monochrome		true: Display the console output in much readable way				false
 * format			set: What all report formatters to use								false
 * stick			true: Will fail execution if there are undefined or pending steps	false													   
 ***********************************Header End***********************************************************************************************************/

package com.aires.runner;

import java.io.File;

import org.apache.log4j.PropertyConfigurator;
import org.junit.runner.RunWith;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.managers.FileReaderManager;
import com.aires.managers.WebDriverManager;
import com.vimalselvam.cucumber.listener.ExtentProperties;
import com.vimalselvam.cucumber.listener.Reporter;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@RunWith(Cucumber.class)
@CucumberOptions(
		features = "src/com/aires/features/"
		,glue = {"stepDefinitions"}
		,dryRun = false
		//,tags = {"@SmokeTest, @Regression"}
		//,tags = {"@Pre-Prod","~@ignoreIRIS"}
		//,tags = (CoreConstants.TAG_VALUE)
		//,tags =("@214455")
		,tags = {"@shipment"}
		,plugin = { "com.vimalselvam.cucumber.listener.ExtentCucumberFormatter:", "junit:target/cucumber-results.xml", "html:target/cucumber-results", "json:target/cucumber-results.json"},
		monochrome = true
		)

public class TestRunner extends AbstractTestNGCucumberTests {
	static String ReportName = "AIRESAutomation_Report"+CoreFunctions.timeStamp;
	
	@BeforeClass
	 public static void setup() {
        ExtentProperties extentProperties = ExtentProperties.INSTANCE;
        extentProperties.setReportPath("TestReports/"+ReportName+".html");
        CoreFunctions.writeToPropertiesFile("ReportName", ReportName+".html");
        PropertyConfigurator.configure(".//src//log4j.properties");
    }
	
	@AfterClass
	public static void writeExtentReport() {
		WebDriverManager wdm = new WebDriverManager();
		System.out.println(FileReaderManager.getInstance().getConfigReader().getReportConfigPath());
		Reporter.loadXMLConfig(new File(FileReaderManager.getInstance().getConfigReader().getReportConfigPath()));
		Reporter.setSystemInfo("User Name", System.getProperty("user.name"));
	    Reporter.setSystemInfo("Time Zone", System.getProperty("user.timezone"));
	    Reporter.setSystemInfo("Machine", 	System.getProperty("os.name"));
	    Reporter.setSystemInfo("Selenium Version", "3.141.59");
	    Reporter.setSystemInfo("Maven", "3.5.2");
	    Reporter.setSystemInfo("Java Version", System.getProperty("java.version"));
	    //Reporter.setSystemInfo("Test Environment", CoreFunctions.getEnvironmentName(FileReaderManager.getInstance().getConfigReader().getPDTApplicationUrl()));
	    Reporter.setSystemInfo("Browser Name", CoreFunctions.getPropertyFromConfig("browser").toUpperCase());
	}
}