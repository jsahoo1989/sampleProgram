Feature: Validate the functionality of Mylo Accounting Query
  I want to test the  functionlity of Mylo Accounting Query

Background: Login to  Mylo application
    Given he selects "Query" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application
    
@IRIS-2145 @218346 @Mylo:218518 @Mylo-Regression
Scenario: Mylo-Validate Tag Script Validation Messages for mentioned fields of Mylo Accounting Query section
Given he is on "Accounting Query" popup by selecting "Accounting" option available on "Query" section
Then tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on "Execute" button on "Accounting Query" section
|Field Name                    |Message                                                    |
|TransfereeFirstName           |Tag Scripts are not allowed in transferee first name.      |
|TransfereeLastName            |Tag Scripts are not allowed in transferee last name.       |
|Tracking Number               |Tag Scripts are not allowed in tracking number.            |
|Origin Address Street1        |Tag Scripts are not allowed in origin street 1.            |
|Origin Address Street2        |Tag Scripts are not allowed in origin street 2.            |
|Origin Address City           |Tag Scripts are not allowed in origin city.                |
|Origin Address ZipCode        |Tag Scripts are not allowed in origin zip code.            |    
|Origin Address State Text     |Tag Scripts are not allowed in  origin State/Province.     |
|Destination Address Street1   |Tag Scripts are not allowed in destination street 1.       |
|Destination Address Street2   |Tag Scripts are not allowed in destination street 2.       |
|Destination Address City      |Tag Scripts are not allowed in destination city.           |
|Destination Address ZipCode   |Tag Scripts are not allowed in destination zip code.       |
|Destination Address State Text|Tag Scripts are not allowed in  destination State/Province.|

@IRIS-2145 @218347 @Mylo:218519 @Mylo-Regression
Scenario: Mylo-Validate Boundary Conditions of Character Limit for mentioned fields of Mylo Accounting Query section
Given he is on "Accounting Query" popup by selecting "Accounting" option available on "Query" section
When he enters data beyond character limit for different fields under "Accounting Query" section
|Field Name                    |CharacterLength |
|Assignment ID                 |11              |
|TransfereeFirstName           |31              |
|TransfereeLastName            |61              |
|Sub-Service ID                |11              |
|Tracking Number               |61              |
|Transaction Id                |11              |
|Financial Id                  |11              |
|Origin Address Street1        |101             |
|Origin Address Street2        |101             |
|Origin Address City           |61              |
|Origin Address ZipCode        |11              |    
|Origin Address State Text     |61              |
|Destination Address Street1   |101             |
|Destination Address Street2   |101             |
|Destination Address City      |61              |
|Destination Address ZipCode   |11              |
|Destination Address State Text|61              |
Then values should be successfully entered as per below character limit set for different fields under 'Accounting Query' section
|Field Name                    |CharacterLength |
|Assignment ID                 |10              |
|TransfereeFirstName           |30              |
|TransfereeLastName            |60              |
|Sub-Service ID                |10              |
|Tracking Number               |60              |
|Transaction Id                |10              |
|Financial Id                  |10              |
|Origin Address Street1        |100             |
|Origin Address Street2        |100             |
|Origin Address City           |60              |
|Origin Address ZipCode        |10              |    
|Origin Address State Text     |60              |
|Destination Address Street1   |100             |
|Destination Address Street2   |100             |
|Destination Address City      |60              |
|Destination Address ZipCode   |10              |
|Destination Address State Text|60              |

@IRIS-2183 @218314 @218318 @218319 @Mylo:218520 @Mylo-Regression
Scenario: Mylo-Validate Warning Toast Message on Mandatory Field to enter & Cancel button functionality in Mylo Accounting Query section
Given he is on "Accounting Query" popup by selecting "Accounting" option available on "Query" section
When he clicks on "Execute" button without entering any parameters on "Accounting Query" popup
Then an error popup message "Please input a query parameter." should be displayed for 'Accounting Query' section on Journey page
And search popup should get closed after clicking on "Cancel" button on 'Accounting Query' section

@IRIS-2183 @218313 @Mylo:218521 @Mylo-Regression
Scenario Outline: Mylo-Validate Single Search Result for valid parameters (AssignmentID, TransfereeName, Tracking No, Origin & Destination Address) on Mylo Accounting Query section
Given he has added "Origin Address","Destination Address","Authorization Tracking" information for newly created file on Mylo Journey page
When he clicks on "Execute" button after entering "<Field Name>" values on "Accounting Query" popup
Then journey page should be displayed for resulting 'File' matching the "<Field Name>" entered from "Accounting Query" popup
Examples:
|Field Name           |
|Assignment ID        |
|Transferee Name      |
|Tracking Number      |
|Origin Address       |
|Destination Address  |

@IRIS-2183 @218313 @Mylo:218522 @Mylo-Regression
Scenario: Mylo-Validate Query results with random selection of Service & SubService Status available on Accounting section
Given he is on "Accounting Query" popup by selecting "Accounting" option available on "Query" section
When he clicks on "Execute" button after random selection of "Service" with "Service Status" on 'Accounting' section
Then related files should get appear into the query result modal as per the selected 'Service' with 'Service Status'

@IRIS-2183 @218315 @218316 @Mylo:218523 @Mylo-Regression
Scenario: Mylo-Validate Sorting for different columns in Accounting query result modal
Given he is on "Accounting Query result" modal after random selection of "Service" with "Service Status" on 'Accounting' section
When he clicks on a 'caret' next to any column on 'Accounting Query result' modal
Then that column should be sorted in ascending order with caret pointing upwards on 'Accounting Query result' modal
And that column should be sorted in descending order by again clicking on 'caret' next to it on 'Accounting Query result' modal
And "Please Select a Query Type to Search for a User File" should be displayed after he clicks on "New Query" button on "Accounting Query result" modal

