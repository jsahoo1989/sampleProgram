Feature: Validate the functionality of Mylo Dashboard Home page
  I want to test the  functionlity of Mylo Dashboard Home page

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-582 @217537 @Mylo-Regression
Scenario Outline: Mylo-Validate Select Query parameters from Assignment Options
Given he is on Mylo Dashboard Home page
When he clicks on the "<SectionType>" "<SubSection>" option in the Mylo Menu on the sidebar
Then the Select Query Type screen should display with the given parameters
|Row Number  |Parameters                                        |
| First Row  |File,My File,My Active Files,My Unbilled          |
| Second Row |Accounting,Transferee Name,Sub-Service ID,Advanced|
| Third Row  |Shipment,PO Number,History                        |
Examples:
		| SectionType | SubSection |
     	| Journey     |       None |
     	| Hamburger	  |	     Query |

@IRIS-666 @217538 @Mylo-Regression
Scenario: Mylo-Validate the functionality for Search Results in Query UI screen
Given he is on Mylo Dashboard Home page
And he selects "File" section after clicking on "Journey" option in the Mylo Menu on the sidebar
And Select Parameter popup should display with given parameters
|Row Number  |Parameters           |
| First Row  |File ID,Status,Office|
| Second Row |Client ID,Client Name|
| Third Row  |Origin City,Origin Country,Origin State|
| Fourth Row |Destination City,Destination Country,Destination State|
And alert message "Please input a query parameter." is displayed after clicking on Execute button
And Message "No such file found" is displayed after clicking on Execute button with invalid File ID "1234"
When user clicks on Execute button after entering valid Client Id "2", Status "Active", Origin Country "USA" and Destination Country "USA"
Then Query results should appear based on the parameter provided sorted by File ID