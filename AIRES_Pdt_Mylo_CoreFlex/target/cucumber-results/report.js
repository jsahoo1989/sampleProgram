$(document).ready(function() {var formatter = new CucumberHTML.DOMFormatter($('.cucumber-report'));formatter.uri("coreFlex/CoreFlex_AddNewPolicy.feature");
formatter.feature({
  "line": 1,
  "name": "Validate the functionality of Add New Policy",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy",
  "keyword": "Feature"
});
formatter.scenarioOutline({
  "line": 7,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@CF-25"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid \u003cClientID\u003e in \u0027Client ID\u0027 dropdown list",
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered \u003cClientID\u003e Client ID/Name",
  "keyword": "Then "
});
formatter.examples({
  "line": 12,
  "name": "",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;",
  "rows": [
    {
      "cells": [
        "ClientID"
      ],
      "line": 13,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;1"
    },
    {
      "cells": [
        "924"
      ],
      "line": 14,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;2"
    },
    {
      "cells": [
        "949"
      ],
      "line": 15,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;3"
    },
    {
      "cells": [
        "9494"
      ],
      "line": 16,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;4"
    },
    {
      "cells": [
        "94943"
      ],
      "line": 17,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;5"
    },
    {
      "cells": [
        "49211"
      ],
      "line": 18,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;6"
    },
    {
      "cells": [
        "AIR"
      ],
      "line": 19,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;7"
    },
    {
      "cells": [
        "Equifax"
      ],
      "line": 20,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;8"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 5526719458,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 5229072061,
  "status": "passed"
});
formatter.scenario({
  "line": 14,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid 924 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 924 Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3683847040,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "924",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3637367389,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "924",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 1130787292,
  "error_message": "java.lang.AssertionError: Fail ::  Failed to verify Policy Name Dropdown field for valid ClientID. expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:496)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat stepDefinitions.coreFlex.CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(CoreFlex_AddNewPolicy_Steps.java:67)\r\n\tat ✽.Then \u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 924 Client ID/Name(coreFlex/CoreFlex_AddNewPolicy.feature:10)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 159906078,
  "status": "passed"
});
formatter.after({
  "duration": 1214319488,
  "status": "passed"
});
formatter.before({
  "duration": 4215575793,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4972538968,
  "status": "passed"
});
formatter.scenario({
  "line": 15,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid 949 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 949 Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3625851819,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "949",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3839897040,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "949",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 11338810520,
  "status": "passed"
});
formatter.after({
  "duration": 367923,
  "status": "passed"
});
formatter.after({
  "duration": 1251430070,
  "status": "passed"
});
formatter.before({
  "duration": 4254700458,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 5044036743,
  "status": "passed"
});
formatter.scenario({
  "line": 16,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid 9494 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 9494 Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3448860889,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9494",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3810672585,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "9494",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 11293211009,
  "status": "passed"
});
formatter.after({
  "duration": 180260,
  "status": "passed"
});
formatter.after({
  "duration": 1192550170,
  "status": "passed"
});
formatter.before({
  "duration": 4144530800,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4938399224,
  "status": "passed"
});
formatter.scenario({
  "line": 17,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid 94943 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 94943 Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3441143427,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "94943",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3568731361,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "94943",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 11288869256,
  "status": "passed"
});
formatter.after({
  "duration": 192483,
  "status": "passed"
});
formatter.after({
  "duration": 1186991713,
  "status": "passed"
});
formatter.before({
  "duration": 4197509600,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4962918472,
  "status": "passed"
});
formatter.scenario({
  "line": 18,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;6",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid 49211 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered 49211 Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3600556635,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "49211",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3522010060,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "49211",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 11340136596,
  "status": "passed"
});
formatter.after({
  "duration": 192133,
  "status": "passed"
});
formatter.after({
  "duration": 1176620492,
  "status": "passed"
});
formatter.before({
  "duration": 4151260635,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4984448583,
  "status": "passed"
});
formatter.scenario({
  "line": 19,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;7",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid AIR in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered AIR Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3430668563,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AIR",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3572821197,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "AIR",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 11322128022,
  "status": "passed"
});
formatter.after({
  "duration": 249473,
  "status": "passed"
});
formatter.after({
  "duration": 1185731427,
  "status": "passed"
});
formatter.before({
  "duration": 4064028389,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4955484286,
  "status": "passed"
});
formatter.scenario({
  "line": 20,
  "name": "CoreFlex - Verify behavior of ClientID field for Valid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-valid-data;;8",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 6,
      "name": "@ClientIDValidDataCheck"
    },
    {
      "line": 6,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 6,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 8,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 9,
  "name": "he enters valid Equifax in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 10,
  "name": "\u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered Equifax Client ID/Name",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3482914658,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Equifax",
      "offset": 16
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3676701089,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Equifax",
      "offset": 88
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(String)"
});
formatter.result({
  "duration": 1149188095,
  "error_message": "java.lang.AssertionError: Fail ::  Failed to verify Policy Name Dropdown field for valid ClientID. expected [true] but found [false]\r\n\tat org.testng.Assert.fail(Assert.java:94)\r\n\tat org.testng.Assert.failNotEquals(Assert.java:496)\r\n\tat org.testng.Assert.assertTrue(Assert.java:42)\r\n\tat stepDefinitions.coreFlex.CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_be_displayed_having_all_the_policies_tied_to_entered_Client_ID_Name(CoreFlex_AddNewPolicy_Steps.java:67)\r\n\tat ✽.Then \u0027Policy Name\u0027 dropdown list should be displayed having all the policies tied to entered Equifax Client ID/Name(coreFlex/CoreFlex_AddNewPolicy.feature:10)\r\n",
  "status": "failed"
});
formatter.after({
  "duration": 130736867,
  "status": "passed"
});
formatter.after({
  "duration": 1164131125,
  "status": "passed"
});
formatter.scenarioOutline({
  "line": 23,
  "name": "CoreFlex - Verify behavior of ClientID field for Invalid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data",
  "type": "scenario_outline",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@CF-25"
    },
    {
      "line": 22,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 22,
      "name": "@ClientIDInvalidDataCheck"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "he enters invalid \u003cClientID\u003e in \u0027Client ID\u0027 dropdown list",
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "\u0027No items found\u0027 text should be displayed in dropdown list followed by \u0027Record does not exist\u0027 Error popup for Invalid \u003cClientID\u003e",
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "\u0027Policy Name\u0027 dropdown list should not be displayed for Invalid \u003cClientID\u003e",
  "keyword": "And "
});
formatter.examples({
  "line": 29,
  "name": "",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;",
  "rows": [
    {
      "cells": [
        "ClientID"
      ],
      "line": 30,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;1"
    },
    {
      "cells": [
        "123"
      ],
      "line": 31,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;2"
    },
    {
      "cells": [
        "10002"
      ],
      "line": 32,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;3"
    },
    {
      "cells": [
        "zzz"
      ],
      "line": 33,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;4"
    },
    {
      "cells": [
        "Euiqfax"
      ],
      "line": 34,
      "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;5"
    }
  ],
  "keyword": "Examples"
});
formatter.before({
  "duration": 4213229405,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4921869330,
  "status": "passed"
});
formatter.scenario({
  "line": 31,
  "name": "CoreFlex - Verify behavior of ClientID field for Invalid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;2",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@ClientIDInvalidDataCheck"
    },
    {
      "line": 22,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 22,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "he enters invalid 123 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "\u0027No items found\u0027 text should be displayed in dropdown list followed by \u0027Record does not exist\u0027 Error popup for Invalid 123",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "\u0027Policy Name\u0027 dropdown list should not be displayed for Invalid 123",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3626433597,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123",
      "offset": 18
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_invalid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 1278192550,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123",
      "offset": 119
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.no_items_found_text_should_be_displayed_in_dropdown_list_followed_by_Record_does_not_exist_Error_popup_for_Invalid(String)"
});
formatter.result({
  "duration": 3253541372,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "123",
      "offset": 64
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_not_be_displayed_for_Invalid(String)"
});
formatter.result({
  "duration": 10092229319,
  "status": "passed"
});
formatter.after({
  "duration": 183124,
  "status": "passed"
});
formatter.after({
  "duration": 1220127837,
  "status": "passed"
});
formatter.before({
  "duration": 4746832629,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 5060167004,
  "status": "passed"
});
formatter.scenario({
  "line": 32,
  "name": "CoreFlex - Verify behavior of ClientID field for Invalid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;3",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@ClientIDInvalidDataCheck"
    },
    {
      "line": 22,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 22,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "he enters invalid 10002 in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "\u0027No items found\u0027 text should be displayed in dropdown list followed by \u0027Record does not exist\u0027 Error popup for Invalid 10002",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "\u0027Policy Name\u0027 dropdown list should not be displayed for Invalid 10002",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3542051923,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10002",
      "offset": 18
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_invalid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 1270819755,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10002",
      "offset": 119
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.no_items_found_text_should_be_displayed_in_dropdown_list_followed_by_Record_does_not_exist_Error_popup_for_Invalid(String)"
});
formatter.result({
  "duration": 3248609460,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "10002",
      "offset": 64
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_not_be_displayed_for_Invalid(String)"
});
formatter.result({
  "duration": 10045072279,
  "status": "passed"
});
formatter.after({
  "duration": 191155,
  "status": "passed"
});
formatter.after({
  "duration": 1165407335,
  "status": "passed"
});
formatter.before({
  "duration": 4019630498,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4871270441,
  "status": "passed"
});
formatter.scenario({
  "line": 33,
  "name": "CoreFlex - Verify behavior of ClientID field for Invalid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;4",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@ClientIDInvalidDataCheck"
    },
    {
      "line": 22,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 22,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "he enters invalid zzz in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "\u0027No items found\u0027 text should be displayed in dropdown list followed by \u0027Record does not exist\u0027 Error popup for Invalid zzz",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "\u0027Policy Name\u0027 dropdown list should not be displayed for Invalid zzz",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3435151395,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zzz",
      "offset": 18
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_invalid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 1280435851,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zzz",
      "offset": 119
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.no_items_found_text_should_be_displayed_in_dropdown_list_followed_by_Record_does_not_exist_Error_popup_for_Invalid(String)"
});
formatter.result({
  "duration": 3255916604,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "zzz",
      "offset": 64
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_not_be_displayed_for_Invalid(String)"
});
formatter.result({
  "duration": 10028134791,
  "status": "passed"
});
formatter.after({
  "duration": 183194,
  "status": "passed"
});
formatter.after({
  "duration": 1160996579,
  "status": "passed"
});
formatter.before({
  "duration": 4099586051,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4914312853,
  "status": "passed"
});
formatter.scenario({
  "line": 34,
  "name": "CoreFlex - Verify behavior of ClientID field for Invalid data",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-behavior-of-clientid-field-for-invalid-data;;5",
  "type": "scenario",
  "keyword": "Scenario Outline",
  "tags": [
    {
      "line": 22,
      "name": "@ClientIDInvalidDataCheck"
    },
    {
      "line": 22,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 22,
      "name": "@CF-25"
    }
  ]
});
formatter.step({
  "line": 24,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 25,
  "name": "he enters invalid Euiqfax in \u0027Client ID\u0027 dropdown list",
  "matchedColumns": [
    0
  ],
  "keyword": "When "
});
formatter.step({
  "line": 26,
  "name": "\u0027No items found\u0027 text should be displayed in dropdown list followed by \u0027Record does not exist\u0027 Error popup for Invalid Euiqfax",
  "matchedColumns": [
    0
  ],
  "keyword": "Then "
});
formatter.step({
  "line": 27,
  "name": "\u0027Policy Name\u0027 dropdown list should not be displayed for Invalid Euiqfax",
  "matchedColumns": [
    0
  ],
  "keyword": "And "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3426908797,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Euiqfax",
      "offset": 18
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_enters_invalid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 1279482099,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Euiqfax",
      "offset": 119
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.no_items_found_text_should_be_displayed_in_dropdown_list_followed_by_Record_does_not_exist_Error_popup_for_Invalid(String)"
});
formatter.result({
  "duration": 3253652419,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "Euiqfax",
      "offset": 64
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.policy_Name_dropdown_list_should_not_be_displayed_for_Invalid(String)"
});
formatter.result({
  "duration": 10065708700,
  "status": "passed"
});
formatter.after({
  "duration": 214134,
  "status": "passed"
});
formatter.after({
  "duration": 1179164600,
  "status": "passed"
});
formatter.before({
  "duration": 4197629098,
  "status": "passed"
});
formatter.background({
  "line": 3,
  "name": "Login to  Policy Digitization Tool (PDT) application",
  "description": "",
  "type": "background",
  "keyword": "Background"
});
formatter.step({
  "line": 4,
  "name": "he has logged into \u0027Aires Policy Tool\u0027 application as a \"Client Service Manager\" user",
  "keyword": "Given "
});
formatter.match({
  "arguments": [
    {
      "val": "Client Service Manager",
      "offset": 57
    }
  ],
  "location": "LoginToPDT_Steps.he_has_logged_into_Aires_Policy_Tool_application_as_a_user(String)"
});
formatter.result({
  "duration": 4943378488,
  "status": "passed"
});
formatter.scenario({
  "line": 37,
  "name": "CoreFlex - Verify user is navigated to \u0027General Information\u0027 page after clicking on Next button",
  "description": "",
  "id": "validate-the-functionality-of-add-new-policy;coreflex---verify-user-is-navigated-to-\u0027general-information\u0027-page-after-clicking-on-next-button",
  "type": "scenario",
  "keyword": "Scenario",
  "tags": [
    {
      "line": 36,
      "name": "@CF-25"
    },
    {
      "line": 36,
      "name": "@CoreFlex-PolicyUpdate-Sprint1"
    },
    {
      "line": 36,
      "name": "@NextButtonAndNavigationCheck"
    }
  ]
});
formatter.step({
  "line": 38,
  "name": "he has navigated to \"Add New Policy Form\" menu from left navigation of \u0027Aires Policy Tool\u0027 homepage",
  "keyword": "Given "
});
formatter.step({
  "line": 39,
  "name": "he has entered a valid \"49211\" in \u0027Client ID\u0027 dropdown list",
  "keyword": "And "
});
formatter.step({
  "line": 40,
  "name": "he has selected a policy from \u0027Policy Name\u0027 dropdown list",
  "keyword": "And "
});
formatter.step({
  "line": 41,
  "name": "he clicks on \u0027Next\u0027 button",
  "keyword": "When "
});
formatter.step({
  "line": 42,
  "name": "user should be navigated to the \"General Information\" page of the selected Client Policy",
  "rows": [
    {
      "cells": [
        "ClientID",
        "ClientName"
      ],
      "line": 43
    },
    {
      "cells": [
        "49211",
        "AIRES-CIS-DEMO\u0026\u0027TEST(CLIENT)"
      ],
      "line": 44
    }
  ],
  "keyword": "Then "
});
formatter.match({
  "arguments": [
    {
      "val": "Add New Policy Form",
      "offset": 21
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_navigated_to_menu_from_left_navigation_of_Aires_Policy_Tool_homepage(String)"
});
formatter.result({
  "duration": 3573020733,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "49211",
      "offset": 24
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_entered_a_valid_in_Client_ID_dropdown_list(String)"
});
formatter.result({
  "duration": 3610566496,
  "status": "passed"
});
formatter.match({
  "location": "CoreFlex_AddNewPolicy_Steps.he_has_selected_a_policy_from_Policy_Name_dropdown_list()"
});
formatter.result({
  "duration": 18905751709,
  "status": "passed"
});
formatter.match({
  "location": "CoreFlex_AddNewPolicy_Steps.he_clicks_on_Next_button()"
});
formatter.result({
  "duration": 1291694476,
  "status": "passed"
});
formatter.match({
  "arguments": [
    {
      "val": "General Information",
      "offset": 33
    }
  ],
  "location": "CoreFlex_AddNewPolicy_Steps.user_should_be_navigated_to_the_page_of_the_selected_Client_Policy(String,DataTable)"
});
formatter.result({
  "duration": 3229866924,
  "status": "passed"
});
formatter.after({
  "duration": 193460,
  "status": "passed"
});
formatter.after({
  "duration": 1171687952,
  "status": "passed"
});
});