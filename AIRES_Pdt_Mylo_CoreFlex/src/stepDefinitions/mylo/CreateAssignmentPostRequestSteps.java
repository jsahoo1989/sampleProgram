package stepDefinitions.mylo;

import java.util.Set;

import org.json.JSONObject;
import org.testng.Assert;

import com.aires.cucumber.TestContext;
import com.aires.pages.mylo.Mylo_RestApiRequest;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

public class CreateAssignmentPostRequestSteps {

	TestContext testContext;
	Mylo_RestApiRequest myloRestApiRequest;
	JSONObject responseData ;
	String serviceEndPoint,assignmentId;

	public CreateAssignmentPostRequestSteps(TestContext context) {
		testContext = context;
		myloRestApiRequest = testContext.getMyloPageObjectManager().getRestApiRequest();
		responseData = new JSONObject();
	}

	@Given("^he has service api endpoint for \"([^\"]*)\" functionality$")
	public void he_has_service_api_endpoint_for_functionality(String serviceName) {
		serviceEndPoint = myloRestApiRequest.getEndpoints(serviceName);
	}

	@When("^a \"([^\"]*)\" call is made for \"([^\"]*)\"$")
	public void a_call_is_made_for(String httpMethod, String serviceName) {
		myloRestApiRequest.setSamplePayLoad(serviceName);
		myloRestApiRequest.requestCall(httpMethod, serviceEndPoint);
	}

	@Then("^a (\\d+) response code should be received$")
	public void a_response_code_should_be_received(int statusCode) {
		Assert.assertTrue(myloRestApiRequest.validateResponseStatusCode(statusCode));
	}

	@Then("^all fieldValues related to created assignment should be populated in the response body$")
	public void all_fieldValues_related_to_created_assignment_should_be_populated_in_the_response_body() {
		responseData = myloRestApiRequest.getResponseData();
		System.out.println("Assignment Id is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentId", null, 0));
		System.out.println("First Name is: " + myloRestApiRequest.getResponseFieldValue(responseData, "primaryContactCardObject", "firstName", 0));
		System.out.println("Emp Function Code is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentEmployeeResponseList", "empFunctionCode", 1));	
	}
	
	@When("^a \"([^\"]*)\" call is made for \"([^\"]*)\" for value \"([^\"]*)\"$")
	public void a_call_is_made_for_for_value(String httpMethod, String serviceName, String value) {
		myloRestApiRequest.requestCall(httpMethod, serviceEndPoint+value);
	}
	
	@Then("^all fieldValues related to searched assignment should be populated in the response body$")
	public void all_fieldValues_related_to_searched_assignment_should_be_populated_in_the_response_body() {
		responseData = myloRestApiRequest.getResponseData();
		System.out.println("Assignment Id is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentId", null, 0));
	}
	
	@Given("^a \"([^\"]*)\" call has been made using \"([^\"]*)\" service end point$")
	public void a_call_has_been_made_using_service_end_point(String httpMethod, String serviceName) {
		myloRestApiRequest.setSamplePayLoad(serviceName);
		myloRestApiRequest.requestCall(httpMethod, myloRestApiRequest.getEndpoints(serviceName));
	}

	@Given("^(\\d+) response code is received with all field values populated in the response for new assignment$")
	public void response_code_is_received_with_all_field_values_populated_in_the_response_for_new_assignment(int statusCode) {
		Assert.assertTrue(myloRestApiRequest.validateResponseStatusCode(statusCode));
		responseData = myloRestApiRequest.getResponseData();
		System.out.println("Assignment Id from Post Response is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentId", null, 0));
		System.out.println("First Name is: " + myloRestApiRequest.getResponseFieldValue(responseData, "primaryContactCardObject", "firstName", 0));
		System.out.println("Emp Function Code is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentEmployeeResponseList", "empFunctionCode", 1));	
		assignmentId=myloRestApiRequest.getResponseFieldValue(responseData,"assignmentId", null, 0);
	}

	@When("^a \"([^\"]*)\" call is made using \"([^\"]*)\" service end point for above created assignment$")
	public void a_call_is_made_using_service_end_point_for_above_created_assignment(String httpMethod, String serviceName){
		myloRestApiRequest.requestCall(httpMethod, myloRestApiRequest.getEndpoints(serviceName)+assignmentId);
	}

	@Then("^a (\\d+) response code should be received with all assignment details fetched in the response$")
	public void a_response_code_should_be_received_with_all_assignment_details_fetched_in_the_response(int statusCode) {
		Assert.assertTrue(myloRestApiRequest.validateResponseStatusCode(statusCode));
		responseData = myloRestApiRequest.getResponseData();
		System.out.println("Assignment Id from Get Response is: " + myloRestApiRequest.getResponseFieldValue(responseData, "assignmentId", null, 0));
		System.out.println("Company Id is: " + myloRestApiRequest.getResponseFieldValue(responseData, "companyId", null, 0));
	}

	@Then("^assignment fetched should match with the payload provided for the POST request$")
	public void assignment_fetched_should_match_with_the_payload_provided_for_the_POST_request() {
	    Assert.assertTrue(myloRestApiRequest.validateGetAssignmentResponse(responseData));
	}

}