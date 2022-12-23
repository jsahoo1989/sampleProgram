Feature: Validate the functionality of Mylo Dashboard Home page
  I want to test the  functionlity of Mylo Dashboard Home page

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-582 @Mylo:217537 @Mylo-Regression
Scenario: Mylo-Validate Select Query parameters from Assignment Options
Given he is on Mylo Dashboard Home page
When he clicks on the "Journey" "Query" option in the Mylo Menu on the sidebar
Then the Select Query Type screen should display with the given parameters
|Parameters                                                               |
|File,My Files,Advanced,Accounting,Transferee Name,Sub-Service ID,Shipment|

@IRIS-666 @Mylo:217538 @Mylo-Regression
Scenario: Mylo-Validate the functionality for Search Results in Query UI screen
Given he is on Mylo Dashboard Home page
And he selects "File" section after clicking on "Journey" option in the Mylo Menu on the sidebar
And Select Parameter popup should display all the given parameters
|Parameters                                                                                                                                |
|File ID,Status,Office,Client ID,Client Name,Origin Country,Origin City,Origin State/Territory,Destination Country,Destination City,Destination State/Territory|
And alert message "Please input a query parameter." is displayed after clicking on Execute button
And Message "No such file found" is displayed after clicking on Execute button with invalid File ID "1234"
When user clicks on Execute button after entering valid Client Id "2", Status "Active", Origin Country "USA" and Destination Country "USA"
Then Query results should appear based on the parameter provided sorted by File ID

@IRIS-2114 @218300 @218301 @Mylo:218369 @Mylo-Regression
Scenario: Mylo-Validate Dropdown Options available for File Status field on 'My Files' section.
Given he is on "Query Your Files by Status" popup by selecting "My Files" option available on "Query" section
When he clicks on "File Status" dropdown on 'My Files' section
Then "File Status" dropdown should display the below options on "My Files" section
|Status          |
|All             |
|Active          |
|Booked          |
|Canceled        |
|Canceled w/Costs|
|Closed          |
|ISIS            |
|Inactive        |
|Maintenance     | 
And following check boxes should get appear under 'My Files' section
|Checkbox    |
|VIP         |
|EVIP        |
|Confidential|
|Perm Storage|

@IRIS-2114 @218302 @Mylo:218370 @Mylo-Regression
Scenario: Mylo-Validate MyFiles query result with random selection of File Status available on MyFiles section
Given he is on "Query Your Files by Status" popup by selecting "My Files" option available on "Query" section
When he clicks on 'Execute' button after selecting any 'Status' from 'FileStatus'dropdown on 'Query Your Files by Status' popup
Then related files should get appear into the query result modal as per the selected 'Status'

@IRIS-2114 @218303 @Mylo:218371 @Mylo-Regression
Scenario: Mylo-Validate MyFiles query result with random selection of File Status & CheckBox available on MyFiles section
Given he is on "Query Your Files by Status" popup by selecting "My Files" option available on "Query" section
When he clicks on "Execute" button after random selection of 'checkbox' with 'File Status' on 'My Files' section
Then related files should get appear into the query result modal as per the selected 'Status' with 'checkbox'

@IRIS-2114 @218304 @Mylo:218372 @Mylo-Regression
Scenario: Mylo-Validate Cancel button functionality available on MyFiles section
Given he is on "Query Your Files by Status" popup by selecting "My Files" option available on "Query" section
When he clicks on "Cancel" button after random selection of 'checkbox' with 'File Status' on 'My Files' section
Then "Query Your Files by Status" popup should get closed

@IRIS-2114 @218305 @218306 @218307 @Mylo:218373 @Mylo-Regression
Scenario: Mylo-Validate Sorting for different columns in MyFiles query result modal
Given he is on "My Files Query result" modal after random selection of File Status on 'MyFiles' section
When he clicks on a 'caret' next to any column on "My Files Query result" modal
Then that column should be sorted in ascending order with caret pointing upwards
And that column should be sorted in descending order by again clicking on 'caret' next to it
And "Please Select a Query Type to Search for a User File" should be displayed after he clicks on "New Query" button on "My Files Query result" modal

@PerformanceScenario
Scenario: Mylo-Validate Select Query parameters from Assignment Options
Given he queries "Active" files for clientId "45609"
Then he is on "Activity & Finance" section after selecting "Activity & Finance" tab on "MyloDashboard Home Page" for 200 different files selected each time from the query results

@Mylo-Performance  @Mylo:217986 @Mylo-Regression
Scenario: Mylo-Validate Memory Capacity for Loading Files on Mylo Journey Page
Given he is on Mylo Dashboard Home page with different fileIds used for checking memory capacity
When he loads the file alternatively for given number of times on Mylo Journey page
Then browser should not be crashed for loading files continuosly


