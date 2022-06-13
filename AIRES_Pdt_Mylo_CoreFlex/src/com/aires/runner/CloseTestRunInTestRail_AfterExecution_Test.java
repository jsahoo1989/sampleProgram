/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 22/04/2020			 Rahul Sharma					 This class is used to close a newly created Test Run in Test Rail after test execution
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

import com.aires.businessrules.CoreFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.utilities.Log;
import com.aires.utilities.TestRail;

public class CloseTestRunInTestRail_AfterExecution_Test {

	@Test
	public void closeTestRunInTestRail() {
		TestRail.closeTestRun(Integer.parseInt(CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId")), 
				CoreConstants.TEST_RAIL_URL, CoreConstants.testRailUseriD, CoreConstants.testRailPassword);
		Log.info(CoreConstants.EXECUTION_DONE_CLOSE_TEST_RUN_ID + CoreFunctions.getPropertyFromConfig("SniffSuite_TestRunId"));
	}
}