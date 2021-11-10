/***********************************Header Start*********************************************************************************
 * Application/ Module Name                      	  : AIRES
 * Owner                                              : AutomationTeam
 ****************************************************************************************************************************************************
 * Creation /Modification Log: 
 * Date                     By                                Notes                                    
 ---------                ----------                          ---------
 * 22/04/2020			 Rahul Sharma					 Added Test Rail utility
 ****************************************************************************************************************************************************
 * Review/Feedback Log: 
 * Date                     By                                Notes                                    
 ---------                 --------                   	 ----------
 * [Date]                   [Reviewer]                 [Brief description of the review/feedback comments]
 ******************************************************************************************************************************************************
 * Functional Test Coverage Description   			   : It defined all the Selenium dependent methods. 														   
 ***********************************Header End*********************************************************************************/

package com.aires.utilities;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

import org.apache.http.HttpResponse;
import org.testng.ITestContext;

import com.aires.utilities.testrailAPI.APIClient;
import com.aires.utilities.testrailAPI.APIException;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class TestRail {
	
	static HttpResponse response;

	//This method is to set result for a class based test case.Dont delete it or use
	public static void addResultForTestCase(String testCaseId, int actRes, String testRunId, String url, String userName, String password, String logError) {
		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		Map data = new HashMap();
		System.out.println("The Actual Result is === "+actRes);
		if(actRes==5) {
			data.put("status_id", actRes);
			data.put("comment", "Test Executed - Status updated by Selenium Test Automation.\nTest Case Failed due to below reason: \n"+logError);
		}else {
			data.put("status_id", actRes);
			data.put("comment", "Pass :: Test Executed - Status updated by Selenium test automation.");
		}
		try {
			client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
			
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	//This method is to set result for steps
public static void addResultForTestCase(String testCaseId, String testRunId, String url, String userName, String password) {
		
		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		Map data = new HashMap();
		data.put("status_id", 1);
		data.put("comment", "Test Executed - Status updated by Selenium test automation.");
		try {
			client.sendPost("add_result_for_case/" + testRunId + "/" + testCaseId + "", data);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public static void addResultForTestCaseSteps(String testCaseId, String testRunID, String url, String userName, String password) {

		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		
		//String TestRunId=CoreFunctions.getPropertyFromConfig("Aires_SniffSuite_TestRunId"); //IDataConstants.testRunID;
		
		String TestRunId=testRunID;
		Map data = new HashMap();
		data.put("status_id", 1);
		data.put("comment", "Test Executed - Status updated automatically from Selenium test automation.");
		try {
			client.sendPost("add_result_for_case/" + TestRunId + "/" + testCaseId + "", data);
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	public synchronized static void setTestRailCaseID(ITestContext context,String caseId,ITestContext contextForTestrail,String sniffSuiteRunID){
		context.setAttribute("TestRailCaseId", caseId);
	    contextForTestrail.setAttribute("testrailRunID", sniffSuiteRunID);
	}
	
	public static String createTestRun(String testRunName, int suiteID, int sectionID, int projectID, int assignTo_ID, String url, String userName, String password) {
		String runID="";
		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		
		System.out.println("Suite ID: "+suiteID);
		System.out.println("Section ID: "+sectionID);
		
		Map data = new HashMap();
		data.put("suite_id", suiteID);
		data.put("name", testRunName);
		data.put("include_all", false);
		data.put("case_ids", TestRail.getCaseIds(suiteID, sectionID, projectID, url, userName, password));
		//data.put("assignedto_id", 47); // Rahul Sharma ID - 47
		data.put("assignedto_id", assignTo_ID);
		
		try {
			JSONObject obj = (JSONObject) client.sendPost("add_run/"+projectID, data);
			runID= obj.get("id").toString();
			
		} catch (IOException | APIException e) {
			e.printStackTrace();
		}
		return runID;
	}
	
	public static HashSet<String> getCaseIds(int suiteId, int sectionId, int projectID, String url, String userName, String password){
		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		JSONArray r = null;
		HashSet<String> caseIds=new HashSet<>();
		
		System.out.println("Suite ID: "+suiteId);
		System.out.println("Section ID: "+sectionId);
		
		Map data = new HashMap();
		data.put("suite_id", suiteId);
		data.put("section_id", sectionId);
		try {
			r = (JSONArray) client.sendGet("get_cases/"+projectID+"/"+"&suite_id="+suiteId+"&section_id="+sectionId);
			System.out.println(r.size());
			for (int i=0;i<r.size();i++) {
				
				JSONObject object1 = (JSONObject) r.get(i);
				caseIds.add(object1.get("id").toString());
			}
		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return caseIds;
	}
	
	public static void closeTestRun(int testRunID, String url, String userName, String password) {
		APIClient client = new APIClient(url);
		client.setUser(userName);
		client.setPassword(password);
		
		Map data = new HashMap();
		
		try {
			JSONObject r = (JSONObject) client.sendPost("close_run/"+testRunID, data);
		} catch (IOException | APIException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}