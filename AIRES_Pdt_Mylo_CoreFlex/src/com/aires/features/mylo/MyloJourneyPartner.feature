Feature: Validate the functionality of Mylo Journey Partner section
  As a Mylo user, I want to validate the functionality for "Mylo Journey - Partner" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-1450 @217120 @217121 @217122 @217123 @217124 @Mylo-Regression
Scenario:  Mylo-Validate Options available for Different Partner Dropdown fields on Mylo Journey page with the Database
Given he is on "Add Partner" section after clicking on 'Add' link displayed in right panel under "Transferee and Family" section for  "Active Assignment" fileID
When he clicks on below Partner dropdown fields
|Field Name        |
|Gender            |
|New Destination   |
#|Relationships    |
#|Citizenship      |
Then list of values displayed in the dropdown for below Partner fields should match with the values present in respective tables on database
|Field Name        |
|Gender            |
|New Destination   |
#|Relationships    |
#|Citizenship      |