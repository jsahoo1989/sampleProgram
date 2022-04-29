Feature: Validate the functionality of Mylo Assignment Other Addresses section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Other Addresses" section

Background: Login to  Mylo application and navigate to MyloAssignment Summart Page for given File Id
    Given he has logged into the 'Mylo' application
   
@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Country and State/Territory Dropdown field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Mailing address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611127"
And "USA" is the first country to be displayed with remaining countries in alphabetical order in "Country" dropdown field
And corresponding States and Territories is displayed in the 'State/Territory' dropdown after selecting "USA" , "India" and "Canada" as the country respectively
When he enters "Random" "Country" besides India, US or Canada
Then "State" field should be a free text field with label as "State/Province"

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Country and State/Territory Dropdown field for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Temporary address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611127"
And "USA" is the first country to be displayed with remaining countries in alphabetical order in "Country" dropdown field
And corresponding States and Territories is displayed in the 'State/Territory' dropdown after selecting "USA" , "India" and "Canada" as the country respectively
When he enters "Random" "Country" besides India, US or Canada
Then "State" field should be a free text field with label as "State/Province"

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Save functionality and Warning Messages for City, ZipCode, Address1,Address2,State and FromDate field for Mailing Address on Mylo Assignment page under Other Addresses section 
Given he is on "Mailing address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "323419"
And he enters below invalid data for mentioned fields with other mandatory data being provided for "Mailing address" section
|Field Name      |Field Value |Message                                                               |
|City            |26          |City maximum length is 25 characters!                                 |
|Zip Code        |11          |Maximum length of Zip/postal code in Mailing address is 10 characters!|
|Zip Code        |4           |Zip Code should be at least of 5 characters for USA!                  |
|address1        |36          |Address1 maximum length is 35 characters!                             |
|address1        |4           |Address1 minimum length is 5 characters!                              |
|address2        |36          |Address2 maximum length is 35 characters!							 |
|State Text Field|61          |Maximum length of state/province in Mailing address is 60 characters! |
|FromDate        |12/31/999   |Invalid From Date!                                                    |
|FromDate        |01/02/3000  |Invalid From Date!                                                    |
When he clicks on "Save" button after entering below valid data for respective fields
|SectionType    |Country|Mailing address City|State |Mailing address ZipCode|Mailing address FromDate|Mailing address address1|Mailing address address2|					 					  
|Mailing address|USA    |Soldotna            |Alaska|99669                  |12/08/2021              |362 Ridgewood Dr        |PO BOX 1                |
Then below fieldValues should be successfully saved under "Mailing address Dropdown" section
|SectionType    |Country|Mailing address City|State |Mailing address ZipCode|Mailing address FromDate|Mailing address address1|Mailing address address2|				 					  
|Mailing address|USA    |Soldotna            |Alaska|99669                  |12/08/2021              |362 Ridgewood Dr        |PO BOX 1                |
And Saved data should get deleted after clicking on "Delete" button under "Mailing address Dropdown" section

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Save functionality and Warning Messages for City, ZipCode, Address1,Address2,State and FromDate field for Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Temporary address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "323419"
And he enters below invalid data for mentioned fields with other mandatory data being provided for "Temporary address" section
|Field Name      |Field Value |Message                                                                 |
|City            |61          |Maximum length of City in Temporary address is 60 characters!           |
|Zip Code        |11          |Maximum length of Zip/postal code in Temporary address is 10 characters!|
|address1        |201         |Maximum length of address1 in Temporary address is 200 characters!      |
|address2        |201         |Maximum length of address2 in Temporary address is 200 characters!	   |
|State Text Field|61          |Maximum length of state/province in Temporary address is 60 characters! |
|FromDate        |12/31/999   |Invalid From Date!                                                      |
|FromDate        |01/02/3000  |Invalid From Date!                                                      |
When he clicks on "Save" button after entering below valid data for respective fields
|SectionType      |Country|Temporary address City|State |Temporary address ZipCode|Temporary address FromDate|Temporary address address1|Temporary address address2|					 					  
|Temporary address|USA    |Soldotna              |Alaska|99669                    |12/08/2021                |362 Ridgewood Dr          |PO BOX 1                  |
Then below fieldValues should be successfully saved under "Temporary address Dropdown" section
|SectionType      |Country|Temporary address City|State |Temporary address ZipCode|Temporary address FromDate|Temporary address address1|Temporary address address2|				 					  
|Temporary address|USA    |Soldotna              |Alaska|99669                    |12/08/2021                |362 Ridgewood Dr          |PO BOX 1                  |
And Saved data should get deleted after clicking on "Delete" button under "Temporary address Dropdown" section

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for all fields with SpecialCharacters for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Mailing address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611085"
Then messages corresponding to below fields should be displayed after entering "specialCharacters" along with the mandatory data for both "Mailing address", "Temporary address" section 
|Field Name         |Message                                                    |
|City               |Tag Scripts are not allowed in city|
|Zip Code           |Tag Scripts are not allowed in zip code|
|address1           |Tag Scripts are not allowed in address1|
|address2           |Tag Scripts are not allowed in address2|
|State Text Field   |Tag Scripts are not allowed in state|
|Comments           |Tag Scripts are not allowed in comment|

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Save functionality on Boundary Conditions for City, ZipCode, Address1,Address2,State and FromDate field for Mailing Address on Mylo Assignment page under Other Addresses section 
Given he is on "Mailing address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611086"
When he clicks on "Save" button after entering below valid data for respective fields
|SectionType      |Country   |Mailing address City|State |Mailing address ZipCode|Mailing address FromDate|Mailing address address1|Mailing address address2|					 					  
|Mailing address  |Random    |25                  |60    |10                     |01/01/3000              |35                      |35                      |
Then entered data for below fields should be successfully saved in "Mailing address Dropdown" section
|Field Name              |
|Mailing address City    |
|Mailing address ZipCode |
|Mailing address State   |
|Mailing address address1|
|Mailing address address2|
|Mailing address FromDate|
|Mailing address Country |
And Saved data should get deleted after clicking on "Delete" button under "Mailing address Dropdown" section

@IRIS-830 @Mylo-Regression 
Scenario:  Mylo-Validate Save functionality on Boundary Conditions for City, ZipCode, Address1,Address2,State and FromDate field for Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Temporary address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611086"
When he clicks on "Save" button after entering below valid data for respective fields
|SectionType      |Country   |Temporary address City|State |Temporary address ZipCode|Temporary address FromDate|Temporary address address1|Temporary address address2|					 					  
|Temporary address|Random    |60                    |60    |10                       |01/01/1000                |200                       |200                       |
Then entered data for below fields should be successfully saved in "Temporary address Dropdown" section
|Field Name                |
|Temporary address City    |
|Temporary address ZipCode |
|Temporary address State   |
|Temporary address address1|
|Temporary address address2|
|Temporary address FromDate|
|Temporary address Country |
And Saved data should get deleted after clicking on "Delete" button under "Temporary address Dropdown" section

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields of Mailing Address on Mylo Assignment page under Other Addresses section 
Given he is on "Mailing address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "482352"
And he enters below invalid data combination for mandatory fields for "Mailing address" section
|Country   |State     |City |Message                                               | 
|USA       |Alaska    |     |You need to fill in the city field in Mailing address!|
|Select One|60        |25   |You need to select a country in Mailing address!      |
|Canada    |Select One|25   |Please enter province for CANADA!                     |
|India     |Select One|25   |You need to select a state in Property address!       |
|USA       |Select One|25   |Please select state for USA!                          |
When he enters below valid data for mandatory fields for "Mailing address" section
|Country   |State                     |Mailing address City |                              
|Random    |60        		          |25                   |
Then entered data for below fields should be successfully saved in "Mailing address Dropdown" section
|Field Name              |
|Mailing address City    |
|Mailing address State   |
|Mailing address Country |
And Saved data should get deleted after clicking on "Delete" button under "Mailing address Dropdown" section

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Warning Messages for Mandatory fields of Temporary Address on Mylo Assignment page under Other Addresses section 
Given he is on "Temporary address" section after clicking on 'Add' link displayed in left panel under "Other Address" section for file ID "611090"
And he enters below invalid data combination for mandatory fields for "Temporary address" section
|Country   |State     |City |Message                                                 | 
|USA       |Alaska    |     |You need to fill in the city field in Temporary address!|
|Select One|60        |25   |You need to select a country in Temporary address!      |
|India     |Select One|25   |You need to select a state in Property address!         |
When he enters below valid data for mandatory fields for "Temporary address" section
|Country   |State                     |Temporary address City |                              
|Random    |60        		          |25                   |
Then entered data for below fields should be successfully saved in "Temporary address Dropdown" section
|Field Name              |
|Temporary address City    |
|Temporary address State   |
|Temporary address Country |
And Saved data should get deleted after clicking on "Delete" button under "Temporary address Dropdown" section

@IRIS-830 @Mylo-Regression
Scenario:  Mylo-Validate Saved Data and Type Dropdown selection for both Mailing and Temporary Address on Mylo Assignment page under Other Addresses section 
Given he has saved below data on "Temporary address" under Other Addresses section after navigating to Assignment Page for file ID "611127"
|SectionType      |Country|Temporary address City|State |Temporary address ZipCode|Temporary address FromDate|Temporary address address1|Temporary address address2|					 					  
|Temporary address|USA    |Soldotna              |Alaska|99669                    |12/08/2021                |362 Ridgewood Dr          |PO BOX 1                  |
And "USA" is the first country to be displayed with remaining countries in alphabetical order on "Temporary address Country" under "Temporary address Dropdown" section
And corresponding States and Territories is displayed in the 'State/Territory' dropdown after selecting "USA" , "India" and "Canada" as the country respectively under "Temporary address Dropdown" section
And "Temporary address State" field is a free text field with label "State/Province" after selecting any "Temporary address Country" besides India, US or Canada
When he clicks on "Other Address Save" button after changing the "Temporary address Type" dropdown to "Mailing"
Then below fieldValues should be successfully saved under "Mailing address Dropdown" section
|SectionType    |Country|Mailing address City|State |Mailing address ZipCode|Mailing address FromDate|Mailing address address1|Mailing address address2|				 					  
|Mailing address|USA    |Soldotna            |Alaska|99669                  |12/08/2021              |362 Ridgewood Dr        |PO BOX 1                |
And below fieldValues should be successfully saved under "Temporary address Dropdown" section after changing the "Mailing address Type" dropdown to "Temporary" on clicking "Mailing address Edit" button
|SectionType      |Country|Temporary address City|State |Temporary address ZipCode|Temporary address FromDate|Temporary address address1|Temporary address address2|					 					  
|Temporary address|USA    |Soldotna              |Alaska|99669                    |12/08/2021                |362 Ridgewood Dr          |PO BOX 1                  |
And Saved data should get deleted after clicking on "Delete" button under "Temporary address Dropdown" section