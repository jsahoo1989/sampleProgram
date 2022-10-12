package com.aires.pages.mylo;

import java.text.MessageFormat;
import java.util.HashMap;
import java.util.LinkedHashMap;
import org.json.JSONObject;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import com.aires.businessrules.Base;
import com.aires.businessrules.BusinessFunctions;
import com.aires.businessrules.constants.CoreConstants;
import com.aires.businessrules.constants.MYLOConstants;
import com.aires.utilities.Log;
import com.vimalselvam.cucumber.listener.Reporter;

public class Mylo_RestApiRequest extends Base {

	public Mylo_RestApiRequest(WebDriver driver) {
		super(driver);
	}

	RequestSpecification request = RestAssured.given().baseUri(MYLOConstants.MYLO_ASSIGNMENT_BASEURI);
	JSONObject requestParams = new JSONObject();
	Response response;
	LinkedHashMap<String, String> serviceEndPointsMap = new LinkedHashMap<String, String>();
	HashMap<String, Object> createAssignmentPayLoadMap = new HashMap<String, Object>();

	public String getEndpoints(String serviceName) {
		mapServiceEndPoints();
		return serviceEndPointsMap.get(serviceName);
	}

	public void mapServiceEndPoints() {
		serviceEndPointsMap.put(MYLOConstants.CREATE_NEW_ASSIGNMENT, MYLOConstants.CREATE_ASSIGNMENT_API_ENDPOINT);
		serviceEndPointsMap.put(MYLOConstants.GET_ASSIGNMENT, MYLOConstants.GET_ASSIGNMENT_API_ENDPOINT);
	}

	public void createPayLoadMapForCreateAssignment() {
		createAssignmentPayLoadMap.put("loggedInEmpNo", 393);
		createAssignmentPayLoadMap.put("firstName", "Matt");
		createAssignmentPayLoadMap.put("lastName", "Henry");
		createAssignmentPayLoadMap.put("clientId", "92265");
		createAssignmentPayLoadMap.put("providerCode", "AIRES");
		createAssignmentPayLoadMap.put("officeCode", "CRO");
		createAssignmentPayLoadMap.put("journeyTypeCode", "PERM");
		createAssignmentPayLoadMap.put("corporationPolicyId", 7673);
		createAssignmentPayLoadMap.put("policy", "Expat - HNP Policy");
		createAssignmentPayLoadMap.put("newRepatInd", true);
	}

	public void setCreateNewAssignmentPayload() {
		createPayLoadMapForCreateAssignment();
		for (String key : createAssignmentPayLoadMap.keySet()) {
			requestParams.put(key.toString(), createAssignmentPayLoadMap.get(key));
		}
	}

	public void setSamplePayLoad(String serviceName) {
		switch (serviceName) {
		case MYLOConstants.CREATE_NEW_ASSIGNMENT:
			setCreateNewAssignmentPayload();
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		}
	}
	
	public void removeMandatoryFieldInPayLoad(String fieldName) {
		requestParams.remove(fieldName);
	}

	public void requestCall(String httpMethod, String serviceEndPoint) {
		request.header("Content-Type", "application/json");
		request.basePath(serviceEndPoint);
		switch (httpMethod) {
		case MYLOConstants.POST:
			request.body(requestParams.toString());
			response = request.post();
			break;
		case MYLOConstants.GET:
			response = request.get();
			break;
		default:
			Reporter.addStepLog(CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_HTTPMETHOD_NAME);
			Assert.fail(MYLOConstants.ENTER_CORRECT_HTTPMETHOD_NAME);
		}
	}

	public boolean validateResponseStatusCode(int statusCode) {
		boolean flag = false;
		flag = (response.getStatusCode() == statusCode) ? true : false;
		return flag;
	}

	public JSONObject getResponseData() {
		Log.info("Response : ");
		String responseString = response.getBody().prettyPrint();
		JSONObject jsonObject = new JSONObject(responseString);
		return jsonObject;
	}

	public String getResponseFieldValue(JSONObject responseData, String fieldName1, String fieldName2, int index) {
		String requiredValue;
		Assert.assertTrue(checkFieldExistInResponse(responseData, fieldName1),
				CoreConstants.FAIL + MYLOConstants.ENTER_CORRECT_FIELD_NAME);
		switch (fieldName1) {
		case MYLOConstants.PRIMARY_CONTACT_CARD_OBJECT:
			requiredValue = responseData.getJSONObject(MYLOConstants.PRIMARY_CONTACT_CARD_OBJECT).get(fieldName2)
					.toString();
			break;
		case MYLOConstants.ASSIGNMENT_EMPLOYEE_RESPONSE_LIST:
			requiredValue = responseData.getJSONArray(MYLOConstants.ASSIGNMENT_EMPLOYEE_RESPONSE_LIST)
					.getJSONObject(index).get(fieldName2).toString();
			break;
		default:
			requiredValue = responseData.get(fieldName1).toString();
		}
		return requiredValue;
	}

	private boolean checkFieldExistInResponse(JSONObject responseData, String fieldName) {
		boolean flag = responseData.keySet().contains(fieldName);
		if (flag)
			Reporter.addStepLog(
					MessageFormat.format(MYLOConstants.FIELD_NAME_EXIST_IN_RESPONSE, CoreConstants.PASS, fieldName));
		return flag;
	}

	public boolean validateGetAssignmentResponse(JSONObject responseData) {
		boolean flag = false;
		if (responseData.get("companyId").toString().equals(createAssignmentPayLoadMap.get("clientId"))
				&& responseData.get("provider").toString().equals(createAssignmentPayLoadMap.get("providerCode"))
				&& responseData.get("assignmentOfficeCode").toString()
						.equals(createAssignmentPayLoadMap.get("officeCode"))
				&& responseData.get("journeyTypeCode").toString()
						.equals(createAssignmentPayLoadMap.get("journeyTypeCode"))
				&& responseData.get("corporationPolicyId").equals(createAssignmentPayLoadMap.get("corporationPolicyId"))
				&& responseData.get("assignmentPolicy").toString().equals(createAssignmentPayLoadMap.get("policy"))
				&& responseData.get("repatInd").equals(createAssignmentPayLoadMap.get("newRepatInd"))) {
			flag = true;
		}

		return flag;
	}
	
	public boolean validateErrorMessages(String serviceName, String msg) {
		return BusinessFunctions.verifyMyloValidationMessage(msg, getResponseFieldValue(getResponseData(), "message", null, 0), serviceName);
	}
}
