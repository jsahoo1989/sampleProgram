Feature: Validate the functionality of Mylo Dashboard Home page
  I want to test the  functionlity of Mylo Dashboard Home page

Background: Login to  Mylo application
    Given he has logged into 'Mylo' application
    
@IRIS-583
Scenario: Mylo-Validate Select Query parameters from Assignment Options
Given he is on Mylo Dashboard Home page
When he clicks on the "Assignment" option in the Mylo Menu on the sidebar
Then the Select Query Type screen should display with the given parameters
|Row Number  |Parameters                                        |
| First Row  |File,My File,My Active Files,My Unbilled          |
| Second Row |Accounting,Transferee Name,Sub-Service ID,Advanced|
| Third Row  |Shipment,PO Number,History                        |

@IRIS-582
Scenario: Mylo-Validate Select Query parameters from Query Options in Hamburger Menu
Given he is on Mylo Dashboard Home page
And he clicks on the "Assignment" option in the Mylo Menu on the sidebar
And he clicks on Hamburger Menu after closing the Assignment option
When he clicks on "Query" Option in the Hamburger Menu
Then the Select Query Type screen should display with the given parameters
|Row Number  |Parameters                                        |
| First Row  |File,My File,My Active Files,My Unbilled          |
| Second Row |Accounting,Transferee Name,Sub-Service ID,Advanced|
| Third Row  |Shipment,PO Number,History                        |

@IRIS-666
Scenario: Mylo-Validate the functionality for Search Results in Query UI screen
Given he is on Mylo Dashboard Home page
And he selects "File" section after clicking on "Assignment" option in the Mylo Menu on the sidebar
And Select Parameter popup should display with given parameters
|Row Number  |Parameters           |
| First Row  |File ID,Status,Office|
| Second Row |Client ID,Client Name|
| Third Row  |Origin City,Origin Country,Origin State|
| Fourth Row |Destination City,Destination Country,Destination State|
And Message "Please input a query parameter." is displayed after clicking on Execute button
And Message "No such file found" is displayed after clicking on Execute button with invalid File ID "1234"
When he clicks on Execute button after entering valid Client Id "49211", Status "Active", Origin Country "USA" and Destination Country "USA"
Then Query results should appear based on the parameter provided sorted by File ID