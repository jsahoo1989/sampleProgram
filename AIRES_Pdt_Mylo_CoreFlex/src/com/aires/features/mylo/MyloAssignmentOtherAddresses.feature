Feature: Validate the functionality of Mylo Assignment Other Addresses section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Other Addresses" section

Background: Login to  Mylo application and navigate to MyloAssignment Summart Page for given File Id
    Given he has logged into the 'Mylo' application
   
@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Country and State/Territory Dropdown field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085" 
And "USA" should be the first country to be displayed after he clicks on the "Country" Dropdown field
And remaining countries should be in alphabetical order
And "US states" and Territories should display in the "State/Territory" dropdown not in abbreviated after selecting "USA" as the country
And "India states" and Territories should display in the "State/Territory" dropdown not in abbreviated after selecting "INDIA" as the country
And "Canadian Provinces" and Territories should display in the "Province/Territory" dropdown not in abbreviated after selecting "CANADA" as the country
When he enters "Random" "Country" besides India, US or Canada
Then "State" field should be a free text field
And system should change the "State" field label to "State/Province"
Examples:
|AddressSection    |
|Mailing address   |
|Temporary address |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Warning Messages for City field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085"
And he selects any "State" after selecting "USA" as "Country"
And a warning message should display as "You need to fill in the city field in <AddressSection>!" after clicking on "Save" button
And he enters a "<AddressSection> City" greater than <City Field Limit> characters 
And below warning message should display after clicking on "Save" button for "<AddressSection>" section
|Mailing address   					   |Temporary address     					 					 |
|City maximum length is 25 characters! |Maximum length of City in Temporary address is 60 characters!|
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters 
When he clicks on the "Save" button under the "<AddressSection>" section
Then "<AddressSection> City" should be successfully saved in "<AddressSection> Dropdown" section
And Saved data should get deleted after clicking on "Delete" button under "<AddressSection> Dropdown" section
Examples:
|AddressSection    |City Field Limit|
|Mailing address   |25              |
|Temporary address |60              |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Save functionality and Warning Messages for ZipCode field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085" 
And he selects any "State" after selecting "USA" as "Country"
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters
And he enters a "<AddressSection> ZipCode" greater than <ZipCode Field Limit> characters 
And a warning message should display as "Maximum length of Zip/postal code in <AddressSection> is <ZipCode Field Limit> characters!" after clicking on "Save" button
And he enters a "<AddressSection> ZipCode" less than or equal to <ZipCode Field Limit> characters 
When he clicks on the "Save" button under the "<AddressSection>" section
Then "<AddressSection> ZipCode" should be successfully saved in "<AddressSection> Dropdown" section
And Saved data should get deleted after clicking on "Delete" button under "<AddressSection> Dropdown" section
Examples:
|AddressSection    |ZipCode Field Limit|City Field Limit|
|Mailing address   |10                 |25              |
|Temporary address |10                 |60              |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Save functionality and Warning Messages for State field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085"
And "USA" should be the first country to be displayed after he clicks on the "Country" Dropdown field
And he enters any "Country" besides India, US or Canada
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters
And he enters a "<AddressSection> ZipCode" less than or equal to 10 characters 
And he enters a "<AddressSection> State" greater than <State Field Limit> characters 
And a warning message should display as "Maximum length of state/province in <AddressSection> is <State Field Limit> characters!" after clicking on "Save" button
And he enters a "<AddressSection> State" less than or equal to <State Field Limit> characters 
When he clicks on the "Save" button under the "<AddressSection>" section
Then "<AddressSection> State" should be successfully saved in "<AddressSection> Dropdown" section
And Saved data should get deleted after clicking on "Delete" button under "<AddressSection> Dropdown" section
Examples:
|AddressSection    |State Field Limit  |City Field Limit|
|Mailing address   |60                 |25              |
|Temporary address |60                 |60              |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Warning Messages for Country and State field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085"
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters
Then a warning message should display as "You need to select a country in <AddressSection>!" after clicking on "Save" button
#And he selects "USA" as "Country" under "<AddressSection>"
#And a warning message should display as "" after clicking on "Save" button
When he selects "CANADA" as "Country" under "<AddressSection>"
Then a warning message should display as "Please enter province for CANADA!" after clicking on "Save" button
And he selects "INDIA" as "Country" under "<AddressSection>"
And a warning message should display as "You need to select a state in Property address!" after clicking on "Save" button
Examples:
|AddressSection    |City Field Limit|
|Mailing address   |25              |
|Temporary address |60              |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Save functionality and Warning Messages for Address1 and 2 field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085"
And he selects any "State" after selecting "USA" as "Country"
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters 
And he enters a "<AddressSection> address1" greater than <Address Field Limit> characters 
And below warning message should display after clicking on "Save" button for "<AddressSection>" section
|Mailing address   					      |Temporary address     					 					  |
|Street1 maximum length is 35 characters! |Maximum length of address1 in Temporary address is 200 characters!|
And he enters a "<AddressSection> address1" less than or equal to <Address Field Limit> characters 
And he enters a "<AddressSection> address2" greater than <Address Field Limit> characters 
And below warning message should display after clicking on "Save" button for "<AddressSection>" section
|Mailing address   					      |Temporary address     					 					  |
|Street2 maximum length is 35 characters! |Maximum length of address2 in Temporary address is 200 characters!|
And he enters a "<AddressSection> address2" less than or equal to <Address Field Limit> characters 
When he clicks on the "Save" button under the "<AddressSection>" section
Then "<AddressSection> address1" with "<AddressSection> address2" should be successfully saved in "<AddressSection> Dropdown" section
And Saved data should get deleted after clicking on "Delete" button under "<AddressSection> Dropdown" section
Examples:
|AddressSection    |Address Field Limit |City Field Limit|
|Mailing address   |35                  |25              |
|Temporary address |200                 |60              |

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Save functionality and Warning Messages for FromDate field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085" 
And he selects any "State" after selecting "USA" as "Country"
And he enters a "<AddressSection> City" less than or equal to <City Field Limit> characters 
And he enters a "<AddressSection> FromDate" as "InvalidFormat"
And a warning message should display as "Invalid From Date!" after clicking on "Save" button
And he enters a "<AddressSection> FromDate" as "12/31/999"
And a warning message should display as "Invalid From Date!" after clicking on "Save" button
And he enters a "<AddressSection> FromDate" as "01/02/3000"
And a warning message should display as "Invalid From Date!" after clicking on "Save" button
And he enters a "<AddressSection> FromDate" as "current"
When he clicks on the "Save" button under the "<AddressSection>" section
Then "<AddressSection> FromDate" should be successfully saved in "<AddressSection> Dropdown" section
And Saved data should get deleted after clicking on "Delete" button under "<AddressSection> Dropdown" section
Examples:
|AddressSection    |City Field Limit|
|Mailing address   |25              |
|Temporary address |60              |

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Address1 and ZipCode field with Minimum text limit for Mailing Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "Mailing address" under Other Addresses section after navigating to Assignment Page for file ID "611085" 
And he selects any "State" after selecting "USA" as "Country"
And he enters a "Mailing address City" less than or equal to 25 characters 
And he enters a "Mailing address address1" less than 5 characters
And a warning message should display as "Street1 minimum length is 5 characters!" after clicking on "Save" button
And he enters a "Mailing address address1" less than or equal to 35 characters 
When he enters a "Mailing address ZipCode" less than 5 characters
Then a warning message should display as "Zip Code should be at least of 5 characters for USA!" after clicking on "Save" button

@IRIS-830 @Mylo-Regression
Scenario Outline:  Mylo-Validate Warning Messages for all fields with SpecialCharacters for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "<AddressSection>" under Other Addresses section after navigating to Assignment Page for file ID "611085"
And "USA" should be the first country to be displayed after he clicks on the "Country" Dropdown field
And he enters any "Country" besides India, US or Canada
And he enters "<AddressSection> State" as "specialCharacterString" with "<AddressSection> City" as "Testing"
And a warning message should display as "Tag Scripts are not allowed in state <MessageType> address." after clicking on "Save" button
And he enters "<AddressSection> State" as "TestingState" with "<AddressSection> City" as "specialCharacterString"
And a warning message should display as "Tag Scripts are not allowed in city <MessageType> address." after clicking on "Save" button
And he enters "<AddressSection> City" as "TestingCity" with "<AddressSection> address1" as "specialCharacterString"
And a warning message should display as "Tag Scripts are not allowed in address1 <MessageType> address." after clicking on "Save" button
And he enters "<AddressSection> address1" as "TestingAddress1" with "<AddressSection> address2" as "specialCharacterString"
And a warning message should display as "Tag Scripts are not allowed in address2 <MessageType> address." after clicking on "Save" button
And he enters "<AddressSection> address2" as "TestingAddress2" with "<AddressSection> ZipCode" as "specialCharacterString"
And a warning message should display as "Tag Scripts are not allowed in zip code <MessageType> address." after clicking on "Save" button
When he enters "<AddressSection> ZipCode" as "TestZip" with "<AddressSection> Comments" as "specialCharacterString"
Then a warning message should display as "Tag Scripts are not allowed in comment <MessageType> address." after clicking on "Save" button
Examples:
|AddressSection    |MessageType|
|Mailing address   |mailing|
|Temporary address |temporary|

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Saved Data and Type Dropdown selection for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he clicks on "Temporary address" under Other Addresses section after navigating to Assignment Page for file ID "611127"
And he clicks on "Save" button after entering below details in "Temporary address" section
|Country|Temporary address address1|Temporary address address2|Temporary address City|State                  |Temporary address ZipCode|Temporary address FromDate|Temporary address Comments|					 	
|USA    |362 Ridgewood Dr          |TestAddress2              |Soldotna              |Alaska                 |99669                    |12/08/2021                |TestComments              |
And he clicks on the "Temporary address Country" Dropdown field after clicking on "Temporary address Edit" button under "Temporary address Dropdown" section
And "USA" should be the first country to be displayed with remaining countries should be in alphabetical order under "Temporary address Dropdown" section
And "US states" and Territories should display in the "State/Territory" dropdown not in abbreviated after selecting "USA" as the country under "Temporary address Dropdown" section
And "India states" and Territories should display in the "State/Territory" dropdown not in abbreviated after selecting "INDIA" as the country under "Temporary address Dropdown" section
And "Canadian Provinces" and Territories should display in the "Province/Territory" dropdown not in abbreviated after selecting "CANADA" as the country under "Temporary address Dropdown" section
And "Temporary address State" field should be a free text field with label "State/Province" after selecting any "Temporary address Country" besides India, US or Canada
And he reset the value of "Temporary address Country" as "USA" with "Temporary address State" as "Alaska"
And "Mailing" and "Temporary" options should be available after clicking on "Temporary address Type" dropdown
When he clicks on "Other Address Save" button after changing the "Temporary address Type" dropdown to "Mailing"
Then System should save the address in "Mailing address Dropdown" with "Temporary address Dropdown" becoming empty
And below fieldValues should appear under "Mailing address Dropdown" section
|Country|Mailing address address1|Mailing address address2|Mailing address City|Mailing address State Dropdown|Mailing address ZipCode|Mailing address FromDate|Mailing address Comments|					 					  
|USA    |362 Ridgewood Dr        |TestAddress2            |Soldotna            |Alaska                        |99669                  |12/08/2021              |TestComments            |
And System should save the address in "Temporary address Dropdown" with "Mailing address Dropdown" becoming empty after changing the "Mailing address Type" dropdown to "Temporary"
And below fieldValues should appear under "Temporary address Dropdown" section
|Country|Temporary address address1|Temporary address address2|Temporary address City|Temporary address State Dropdown|Temporary address ZipCode|Temporary address FromDate|Temporary address Comments|					 					  
|USA    |362 Ridgewood Dr          |TestAddress2              |Soldotna              |Alaska                          |99669                    |12/08/2021                |TestComments              |
And Saved data should get deleted after clicking on "Delete" button under "Temporary address Dropdown" section 