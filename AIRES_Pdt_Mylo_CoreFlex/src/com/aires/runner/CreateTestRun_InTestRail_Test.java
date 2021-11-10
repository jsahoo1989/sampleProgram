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
import com.aires.businessrules.constants.PDTConstants;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.utilities.Log;
import com.aires.utilities.TestRail;

public class CreateTestRun_InTestRail_Test {
	public static String testRunName = PDTConstants.TEST_RUN_NAME +CoreConstants.TAG_VALUE + PDTConstants.AUTOMATION_TEST_RUN + CoreFunctions.timeStamp;
	
	/*@Test
	public void CreateNew_TestRunID_InTestRail() {
		String testRunID = TestRail.createTestRun(testRunName, AiresConstants.SUITE_ID_AIRES, BusinessFunctions.getTestRailSectionIDAsPerEnvt(), 
				AiresConstants.PROJECT_ID_AIRES, AiresConstants.ASSIGN_TO_ID, AiresConstants.TEST_RAIL_URL, 
				AiresConstants.testRailUseriD, AiresConstants.testRailPassword);
		Log.info(AiresConstants.NEW_TEST_RUN_ID_CREATED_IN_TESTRAIL_AS + testRunID);
		CoreFunctions.writeToPropertiesFile("SniffSuite_TestRunId", testRunID);
	}*/
}