Feature: Add new Policy form with Benefit Categories
  Validate the functionality of Add new Policy form

  Background: Login to  Policy Digitization Tool (PDT) application
    Given he is logged into 'Aires Policy Tool' application as a "Client Service Manager" user

  @Sprint-14 @PDT-Regression @PDT-276 @Pdt:217605
  Scenario: Verify Core/Flex policy drop down should display as "No" on General Information section for selected PDT policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    When he clicks on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    Then by default "No" option should be selected for 'Core/Flex policy' drop down on "General Information" page
    And 'Benefit Package Type' drop down should display below options
      | Bundle     |
      | A la carte |

  @Sprint-14 @PDT-Regression @PDT-279 @Pdt:217606
  Scenario: PDT - Verify Policy Benefit Categories are displayed on the 'Policy Benefits' page while adding a new Policy
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    When he clicks on the 'Next' button after entering mandatory information on 'General Information' page
    Then all the available benefit categories should be displayed on the "Policy Benefits" page

  @Sprint-14 @PDT-Regression @PDT-282 @Pdt:217607
  Scenario: PDT - Validate that sub benefit form should show & hide after selecting sub benefit checkbox as checked or unchecked
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
    And sub benefit category form should appear after selecting below categories on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    When he unchecks the below sub benefit categories  on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then below sub benefit categories form should disappear from  "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |

  @Sprint-15 @PDT-Regression @PDT-335 @Pdt:217608
  Scenario: PDT - Add new Policy form using Pre-Acceptance Services as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Pre-Acceptance Services" page
      | Candidate Selection | Pre-Acceptance Trip Transportation | Pre-Acceptance Trip Lodging | Pre-Acceptance Trip Meals |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-16 @PDT-Regression @PDT-366 @Pdt:217609
  Scenario: PDT - Add new Policy form using Immigration as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Immigration" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Immigration" page
      | Immigration Fees | Immigration Travel |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-16 @PDT-Regression @PDT-367 @Pdt:217610
  Scenario: PDT - Validate the display of tabs on Sub benefits form depending upon the selection/deselection of Benefit differs for Employee type, Benefit differs for Homeowner types
    Given he is on the "Add New Policy Form" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has selected below information for form fields on 'General Information' page followed by selection of "Pre-Acceptance Services" as Benefit Category on "Policy Benefit" page
      | PolicyType    | EmployeeType                                          | HomeownerType                                | BenefitPackageType | CappedPolicy     | ExpenseManagementClient |
      | International | Current Employee + New Hire - benefits differ by type | Homeowner + Renter - benefits differ by type | Bundle             | Partially Capped | No                      |
    When he selects 'Benefit differs for Employee type', 'Benefit differs for Homeowner type' for below Sub benefits on "Pre-Acceptance Services" page
      | SubBenefit                         | Benefit_differs_for_Employee_type | Benefit_differs_for_Home_Owner_type |
      | Candidate Selection                | Yes                               | No                                  |
      | Pre-Acceptance Trip Transportation | No                                | Yes                                 |
      | Pre-Acceptance Trip Lodging        | Yes                               | Yes                                 |
    Then below Tabs should appear in Sub benefit form on "Pre-Acceptance Services" page
      | SubBenefit                         | Benefit_differs_for_Employee_type | Benefit_differs_for_Home_Owner_type | Tabs                                                                                             |
      | Candidate Selection                | Yes                               | No                                  | Current Employee, New Hire                                                                       |
      | Pre-Acceptance Trip Transportation | No                                | Yes                                 | Home Owner, Renter                                                                               |
      | Pre-Acceptance Trip Lodging        | Yes                               | Yes                                 | Current Employee - HomeOwner, Current Employee - Renter, New Hire - HomeOwner, New Hire - Renter |

  @Sprint-17 @PDT-Regression @PDT-383 @Pdt:217611
  Scenario: PDT - Add new Policy form using House Hunting Trip as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "House Hunting Trip" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "House Hunting Trip" page
      | House Hunting Trip Transportation | House Hunting Trip Lodging | House Hunting Trip Meals |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-17 @PDT-Regression @PDT-384 @Pdt:217612
  Scenario: PDT - Add new Policy form using Language Training as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Language Training" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Language Training" page
      | Language Training Employee | Language Training Family |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-17 @PDT-Regression @PDT-385 @Pdt:217613
  Scenario: PDT - Add new Policy form using Cultural Training as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Cultural Training" page
      | Cultural Training Employee | Cultural Training Family |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-18 @PDT-Regression @PDT-429 @Pdt:217614
  Scenario: PDT - Add new Policy form using Final Move as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Final Move" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Final Move" page
      | Final Move Transportation | Final Move Lodging | Final Move Meals |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-19 @PDT-Regression @PDT-547 @Pdt:217615
  Scenario: PDT - Add new Policy form using Temporary Living as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Temporary Living" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Temporary Living" page
      | Temporary Living Lodging | Temporary Living Meals | Temporary Living Transportation |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-19 @PDT-Regression @PDT-546 @Pdt:217616
  Scenario: PDT - Add new Policy form using Home Leave as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Leave" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Leave" page
      | Home Leave Transportation | Home Leave Lodging | Home Leave Meals |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-20 @PDT-Regression @PDT-590 @Pdt:217617
  Scenario: PDT - Add new Policy form using Destination Services as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Destination Services" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Destination Services" page
      | Airport Pickup | Area Tour | Auto Rental During Assignment | Concierge Services | Departure Services | Furniture Rental | Reimbursement of Membership Dues | Education Assistance | Settling In Services | Transition Assistance Program | Tuition/Education Payments |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-21 @PDT-Regression @PDT-548 @Pdt:217618
  Scenario: PDT - Add new Policy form using Rental Assistance as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Rental Assistance" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Rental Assistance" page
      | Rental Tour | Finder's Fee |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-21 @PDT-Regression @PDT-587 @Pdt:217619
  Scenario: PDT - Add new Policy form using Compensation Services as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Compensation Services" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Compensation Services" page
      | Letter of Assignment | Cost Estimate with Tax | Cost Estimate without Tax | Balance Sheets | Allowance Updates (no balance sheet) | Global Data Collection | Payroll Instructions |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-21 @PDT-Regression @PDT-549 @Pdt:217620
  Scenario: PDT - Add new Policy form using Assignment Housing (Company Sponsored) as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Assignment Housing (Company Sponsored)" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Assignment Housing (Company Sponsored)" page
      | Assignment Housing | Security Deposit | Finder's Fee |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-21 @PDT-Regression @PDT-588 @Pdt:217621
  Scenario: PDT - Add new Policy form using Duplicate Housing as Benefit Category
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Duplicate Housing" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information on "Duplicate Housing" page
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-22 @PDT-Regression @PDT-544 @PDT-703 @Pdt:217622
  Scenario: PDT - Add new Policy form using One Time Payments and Reimbursements as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "One Time Payments/Reimbursements" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "One Time Payments/Reimbursements" page
      | Miscellaneous Relocation Allowance | Lump Sum | Lease Break | Appliance Allowance | Auto Registration Costs | Auto Loss on Sale | Other One Time Payment |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-23 @PDT-Regression @PDT-735 @PDT-736 @Pdt:217623
  Scenario: PDT - Add new Policy form using Ongoing Payments and Reimbursements as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Ongoing Payments/Reimbursements" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Ongoing Payments/Reimbursements" page
      | COLA | Per Diem | Mobility Premium | Transportation Allowance | Housing Allowance | Home Maintenance Allowance | Furniture Allowance | Hardship Allowance | Banking Allowance | At Sea Allowance | Commuter Allowance | Differential Allowance | Goods & Services Allowance | Home Leave Allowance | Home Retention Allowance | Housekeeping Allowance | Utility Allowance | Other Ongoing Allowance |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-24 @PDT-Regression @PDT-589 @Pdt:217624
  Scenario: PDT - Add new Policy form using Property Management as Benefit Category
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Property Management" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information on "Property Management" page
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-24 @PDT-Regression @PDT-734 @Pdt:217625
  Scenario: PDT - Add new Policy form using Home Purchase as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Home Purchase" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Home Purchase" page
      | Home Purchase Closing Costs | Home Purchase Points | Home Purchase Inspections | Home Purchase Bonus | Mortgage Differentials | Mortgage Subsidy |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-25 @PDT-Regression @PDT-897 @Pdt:217626
  Scenario: PDT - Add new Policy form using Household Goods as Benefit Category including their sub benefit categories
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Household Goods" as Benefit Category on "Policy Benefit" page
    When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the below selected sub benefits on "Household Goods" page
      | US Domestic Vanline Shipment | Auto Shipment | Self Move | Air Shipment | Sea Shipment | Non-US Inland Shipment | Permanent Storage | Pet Shipment | Discard and Donate |
    Then Policy Status should be changed to "Submitted" along with Version "V1" on the "Policy Benefit" page
    And newly created Policy should be displayed under "View Policy" page after clicking on 'EXIT' button

  @Sprint-27 @PDT-951 @PDT-Regression @Pdt:217627
  Scenario: PDT - Verify the Exit button functionality on sub-benefit page.
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page followed by selection of "Cultural Training" as Benefit Category on "Policy Benefit" page
    And he has clicked on "EXIT" button after entering mandatory information for all the below selected sub benefits on "Cultural Training" page
      | Cultural Training Employee | Cultural Training Family |
    And he has navigated to "View Policy" page after clicking on the "OK" button of 'Confirmation' dialog on "Cultural Training" page
    When he views the newly created policy
    Then information should not be saved for below sub-benefits of "Cultural Training" page
      | Cultural Training Employee | Cultural Training Family |

  @BLUE-07 @BLUE-432 @exp
  Scenario: PDT - Add new Policy form using Expense Management Category as Yes and validate that Gross-Up/Reimbursed by field should display their updated values after any udpates
    Given he is on the "Add New Policy" page after clicking on the link "Add New Policy Form" displayed under the left navigation menu on the 'View Policy' page
    And he has clicked on the 'Next' button after selecting client, policy information on the 'Add New Policy' page
    And he has entered mandatory information on 'General Information' page with 'Expense Management client' as 'Yes' followed by selection of below categories on "Policy Benefit Category" page
      | Language Training | Cultural Training |
    And he has entered mandatory information for all the benefit forms after verifying the default selected option for Gross-Up, Reimbursed by fields on each benefit
    #And the sub-benefit form of above benefit categories displays the default selected option for Gross-Up, Reimbursed by fields
    #When he clicks on "SAVE & SUBMIT" button after entering mandatory information for all the sub-benefit forms
    When he clicks on "SAVE & SUBMIT" button on last benefit page
    Then submitted value of Gross-Up, Reimbursed by fields should be displayed on all sub-benefit forms