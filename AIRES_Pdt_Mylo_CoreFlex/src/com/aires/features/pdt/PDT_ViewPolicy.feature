Feature: Validate the functionality of View Policy page
   I want to verify the functionality of View Policy page

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  #  Background: Login to Policy Digitization Application
  #    Given he is logged into Policy App application with below credentials
  #      | userName | password |
  #| kbrian   | kbrian   |
  #      | ckitts   | ckitts   |
  @Sprint-14 @PDT-Regression @Pdt:217666
  Scenario: PDT - Verify search operation on View Policy Page
    Given he is on "View Policy" page
    Then he should be able to verify Policy data on "View Policy" page after performing below SearchBy operations
      | SearchBy    | SearchText                    | ClientId | CompanyName                   |
      | Policy      | Global Transfer Core/Flex - US Expat |    50270 | American Eagle Outfitters     |
      #| Policy      | Integrated Services           |     7403 | Dow Chemical Company (Global) |
      #| Policy      | Canada Transfer               |     7403 | Dow Chemical Company (Global) |
      | Client Id   |                         50270 |    50270 | American Eagle Outfitters     |
      | Client Name | Dow Chemical Company (Global) |     7403 | Dow Chemical Company (Global) |
			#| Client Name | Seagen                       |    93835 | Seagen                 |
      #| Policy      | Extended Business Traveler	 |     7311 | GAP, Inc. Headquarters |
      #| Client Id   |                         7311 |     7311 | GAP, Inc. Headquarters |
