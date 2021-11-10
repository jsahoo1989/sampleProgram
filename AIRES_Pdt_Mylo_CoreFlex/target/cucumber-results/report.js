$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("MobilityX_BudgetEstimate.feature");
formatter.feature({
  "line": 1,
  "name": "Verify Budget Estimation with Authorization",
  "description": "I want to verify the functionality of Budget Estimates",
  "id": "verify-budget-estimation-with-authorization",
  "keyword": "Feature"
});
formatter.before({
  "duration": 7674074219,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Login to MobilityX application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "he is logged into MobilityX application as a client user",
  "keyword": "Given "
});
formatter.match({
  "location": "SharedSteps.he_is_logged_into_MobilityX_application_as_a_client_user()"
});
formatter.result({
  "duration": 21137961180,
  "status": "passed"
});
formatter.scenario({
  "line": 8,
  "name": "Verify Budget Estimation with Authorization",
  "description": "",
  "id": "verify-budget-estimation-with-authorization;verify-budget-estimation-with-authorization",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 7,
      "name": "@Regression"
    },
    {
      "line": 7,
      "name": "@201727"
    },
    {
      "line": 7,
      "name": "@Sprint-Fourteen"
    },
    {
      "line": 7,
      "name": "@Post-Prod"
    },
    {
      "line": 7,
      "name": "@Post:208930"
    },
    {
      "line": 7,
      "name": "@Pre-Prod"
    },
    {
      "line": 7,
      "name": "@Pre:206665"
    }
  ]
});
formatter.step({
  "line": 9,
  "name": "he has initiated a new budget from MobilityX dashboard with policy type as \"Long Term Assignment\"",
  "keyword": "Given "
});
formatter.step({
  "line": 10,
  "name": "he has estimated budget after providing mandatory fields on \u0027Employee Details\u0027 and \u0027Policy Benefits\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 11,
  "name": "he has validated the budget estimate after clicking \u0027View\u0027 link from \u0027Budget Estimate\u0027 tab",
  "keyword": "And "
});
formatter.step({
  "line": 12,
  "name": "he has validated the budget estimate after downloading excel from \u0027Budget Estimate\u0027 tab",
  "keyword": "And "
});
formatter.step({
  "line": 13,
  "name": "he has added an authorization from Budget Estimate after selecting option as \"A new transfer or assignment\"",
  "keyword": "And "
});
formatter.step({
  "line": 14,
  "name": "he clicks on \"Submit to Aires\" link",
  "keyword": "When "
});
formatter.step({
  "line": 15,
  "name": "the newly created budget should be visible for recently created transferee",
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Long Term Assignment",
      "offset": 76
    }
  ],
  "location": "SharedSteps.he_has_initiated_a_new_budget_from_mobilityx_dashboard_with_policy_type_as_something(String)"
});
formatter.result({
  "duration": 44578629057,
  "status": "passed"
});
formatter.match({
  "location": "SharedSteps.he_has_estimated_budget_after_providing_mandatory_fields_on_employee_details_and_policy_benefits()"
});
formatter.result({
  "duration": 26179632886,
  "status": "passed"
});
formatter.match({
  "location": "SharedSteps.he_has_validated_the_budget_estimate_after_clicking_view_link_from_budget_estimate_tab()"
});
formatter.result({
  "duration": 2368611024,
  "status": "passed"
});
formatter.match({
  "location": "SharedSteps.he_has_validated_the_budget_estimate_after_downloading_excel_from_budget_estimate_tab()"
});
formatter.result({
  "duration": 20668543768,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "A new transfer or assignment",
      "offset": 78
    }
  ],
  "location": "MobilityX_DashboardHome_Steps.he_has_added_an_authorization_from_budget_estimate_after_selecting_option_as_something(String)"
});
formatter.result({
  "duration": 51634171871,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Submit to Aires",
      "offset": 14
    }
  ],
  "location": "MobilityX_DashboardHome_Steps.he_clicks_on_link(String)"
});
formatter.result({
  "duration": 40825140067,
  "status": "passed"
});
formatter.match({
  "location": "MobilityX_DashboardHome_Steps.the_newly_created_budget_should_be_visible_for_recently_created_transferee()"
});
formatter.result({
  "duration": 19528097845,
  "status": "passed"
});
formatter.after({
  "duration": 1133245,
  "status": "passed"
});
formatter.after({
  "duration": 1160462992,
  "status": "passed"
});
formatter.before({
  "duration": 6128096099,
  "status": "passed"
});
formatter.background({
  "line": 4,
  "name": "Login to MobilityX application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 5,
  "name": "he is logged into MobilityX application as a client user",
  "keyword": "Given "
});
formatter.match({
  "location": "SharedSteps.he_is_logged_into_MobilityX_application_as_a_client_user()"
});
formatter.result({
  "duration": 21242021402,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "Create a Budget through Authorization form",
  "description": "",
  "id": "verify-budget-estimation-with-authorization;create-a-budget-through-authorization-form",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 31,
      "name": "@206320"
    },
    {
      "line": 31,
      "name": "@Sprint-Sixteen"
    },
    {
      "line": 31,
      "name": "@SmokeTest"
    },
    {
      "line": 31,
      "name": "@Post-Prod"
    },
    {
      "line": 31,
      "name": "@Post:211593"
    },
    {
      "line": 31,
      "name": "@Pre-Prod"
    },
    {
      "line": 31,
      "name": "@Pre:206668"
    }
  ]
});
formatter.step({
  "line": 33,
  "name": "he is on \u0027Authorization Home Page\u0027 after selecting option as \"A new transfer or assignment\" for an employee",
  "keyword": "Given "
});
formatter.step({
  "line": 34,
  "name": "he should be able to fill all the mandatory information on \u0027Authorization Home Page\u0027",
  "keyword": "And "
});
formatter.step({
  "line": 35,
  "name": "he has initiated a new budget after providing mandatory fields from MobilityX dashboard with policy type as \"Long Term Assignment\"",
  "keyword": "And "
});
formatter.step({
  "line": 36,
  "name": "he estimates budget after providing mandatory fields on \u0027Employee Details\u0027 and \u0027Policy Benefits\u0027",
  "keyword": "When "
});
formatter.step({
  "line": 37,
  "name": "budget should be created on \u0027Budget\u0027 page",
  "keyword": "Then "
});
formatter.step({
  "line": 38,
  "name": "user should be able to expand or collapse form on \"Detailed budget estimate\" page after clicking on \u0027View\u0027 link",
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "A new transfer or assignment",
      "offset": 62
    }
  ],
  "location": "MobilityX_DashboardHome_Steps.he_is_on_Authorization_Home_Page_after_selecting_option_as_for_an_employee(String)"
});
formatter.result({
  "duration": 17473913165,
  "status": "passed"
});
formatter.match({
  "location": "MobilityX_DashboardHome_Steps.he_should_be_able_to_fill_all_the_mandatory_information_on_authorization_home_page()"
});
