Feature: Validate the functionality of Mylo Advanced Query
  I want to test the  functionlity of Mylo Advanced Query

Background: Login to  Mylo application
    Given he selects "Query" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application
    
@IRIS-2203 @218348 @Mylo:218524 @Mylo-Regression
Scenario: Mylo-Validate Tag Script Validation Messages for mentioned fields of Mylo Advanced Query section
Given he is on "Advanced Query" popup by selecting "Advanced" option available on "Query" section
Then tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on "Execute" button on 'Advanced Query' section
|Field Name             |Message                                              |
|Phone Number           |Tag Scripts are not allowed in phone number.         |
|Tracking Number        |Tag Scripts are not allowed in tracking number.      |
|Transferee First Name  |Tag Scripts are not allowed in transferee first name.|
|Transferee Last Name   |Tag Scripts are not allowed in transferee last name. |
|Family First Name      |Tag Scripts are not allowed in family first name.    |    
|Family Last Name       |Tag Scripts are not allowed in family last name.     |
|Sub-Service ID         |Tag Scripts are not allowed in sub service id.       |
|Client ID              |Tag Scripts are not allowed in client Id.            |
|Lead Company ID        |Tag Scripts are not allowed in lead company Id.      |
|Partner ID             |Tag Scripts are not allowed in partner Id.           |  
|Booking #              |Tag Scripts are not allowed in Booking               | 
|Origin City            |Tag Scripts are not allowed in origin city           |
|Destination City       |Tag Scripts are not allowed in destination city      |
|PO Number              |Tag Scripts are not allowed in PO Number             |
|Street 1               |Tag Scripts are not allowed in street 1.             |
|Street 2               |Tag Scripts are not allowed in street 2.             |
|City                   |Tag Scripts are not allowed in city.                 |
|Zip/Postal Code        |Tag Scripts are not allowed in zip code.             |
   
@IRIS-2203 @218349 @Mylo:218525 @Mylo-Regression
Scenario: Mylo-Validate Boundary Conditions of Character Limit for mentioned fields of Mylo Advanced Query section
Given he is on "Advanced Query" popup by selecting "Advanced" option available on "Query" section
When he enters data beyond character limit for different fields under 'Advanced Query' section
|Field Name                |CharacterLength |
|Transferee ID             |11              |
|Phone Number              |31              |
|Tracking Number           |201             |
|Transferee First Name     |31              |
|Transferee Last Name      |61              |
|Family First Name         |31              |
|Family Last Name          |61              |
|Sub-Service ID            |11              |
|Client ID                 |61              |
|Lead Company ID           |11              |
|Partner ID                |11              |    
|Booking #                 |21              |
|Origin City               |61              |
|Destination City          |61              |
|PO Number                 |51              |
|Street 1                  |61              |
|Street 2                  |61              |
|City                      |61              |
|Zip/Postal Code           |11              |
Then values should be successfully entered as per below character limit set for different fields under 'Advanced Query' section
|Field Name                |CharacterLength |
|Transferee ID             |10              |
|Phone Number              |30              |
|Tracking Number           |200             |
|Transferee First Name     |30              |
|Transferee Last Name      |60              |
|Family First Name         |30              |
|Family Last Name          |60              |
|Sub-Service ID            |10              |
|Client ID                 |60              |
|Lead Company ID           |10              |
|Partner ID                |10              |    
|Booking #                 |20              |
|Origin City               |60              |
|Destination City          |60              |
|PO Number                 |50              |
|Street 1                  |60              |
|Street 2                  |60              |
|City                      |60              |
|Zip/Postal Code           |10              |

@IRIS-2239 @218320 @218338 @Mylo:218526 @Mylo-Regression
Scenario: Mylo-Validate Warning Toast Message on Mandatory Field to enter & Cancel button functionality in Mylo Advanced Query section
Given he is on "Advanced Query" popup by selecting "Advanced" option available on "Query" section
When he clicks on "Execute" button without entering any parameters on 'Advanced Query popup
Then an error popup message "Please input a query parameter." should be displayed for "Advanced Query" section on Journey page
And search popup should get closed after clicking on "Cancel" button on 'Advanced Query' section

@IRIS-2239 @218313 @Mylo:218527 @Mylo-Regression
Scenario Outline: Mylo-Validate Single Search Result for valid parameters (TransfereeID,ClientID,LeadCompanyID,TransfereeFirstName,TransfereeLastName,Email,Mspec,PPC,PhoneNumber,FamilyFirstName,FamilyLastName,Tracking No) on Mylo Advanced Query section
Given he has added "Transferee Details","Partner","Aires File Team","Authorization Tracking" information for newly created Vendor file on Mylo Journey page
When he clicks on "Execute" button after entering "<Field Name>" values on 'Advanced Query' popup
Then journey page should be displayed for resulting 'File' matching the "Assignment ID" entered from "Advanced Query" popup
Examples:
|Field Name                                                     |
|Client ID,Lead Company ID,Phone Number                       |
|Transferee First Name,Transferee Last Name,Email,PPC,MSpec     |
|Tracking Number,Family First Name,Family Last Name|




