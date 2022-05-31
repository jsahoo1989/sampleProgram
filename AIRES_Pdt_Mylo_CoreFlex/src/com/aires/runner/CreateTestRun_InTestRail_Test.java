/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 20/04/2020			 Rahul Sharma					 This class is used to create a new Test Run in Test Rail during execution
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.runner;

import org.testng.annotations.Test;

import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.utilities.Log;
import com.aires.utilities.TestRail;

public class CreateTestRun_InTestRail_Test {
	public static String testRunName = CoreConstants.TEST_RUN_NAME +System.getProperty("application") + "Regression" + CoreConstants.AUTOMATION_TEST_RUN + CoreFunctions.timeStamp;
	
	@Test
	public void CreateNew_TestRunID_InTestRail() {
		String testRunID = TestRail.createTestRun(testRunName, CoreConstants.SUITE_ID_AIRES, BusinessFunctions.getTestRailSectionIDAsPerApplication(), 
				CoreConstants.PROJECT_ID_AIRES, CoreConstants.ASSIGN_TO_ID, CoreConstants.TEST_RAIL_URL, 
				CoreConstants.testRailUseriD, CoreConstants.testRailPassword);
		Log.info(CoreConstants.NEW_TEST_RUN_ID_CREATED_IN_TESTRAIL_AS + testRunID);
		CoreFunctions.writeToPropertiesFile("SniffSuite_TestRunId", testRunID);
	}
}