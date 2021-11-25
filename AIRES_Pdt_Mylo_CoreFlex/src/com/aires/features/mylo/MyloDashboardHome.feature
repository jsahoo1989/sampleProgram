Feature: Validate the functionality of Mylo Dashboard Home page
  I want to test the  functionlity of Mylo Dashboard Home page

Background: Login to  Mylo application
    Given he has logged into 'Mylo' application
    
@IRIS-582
Scenario: Mylo-Validate Select Query parameters from Assignment Options
Given he is on Mylo Dashboard Home page
When he clicks on the Assignment option in the Mylo Menu on the sidebar
Then the Select Query Type screen should display with the given parameters

| First Row  | File       | My File | My Active Files  | My Unbilled   |
| Second Row | Accounting | Transfee Name  | Sub-Service ID| Advanced |
| Third Row  |Shipment    | PO Number        | History       ||

@IRIS-582
Scenario: Mylo-Validate Select Query parameters from Query Options in Hamburger Menu
Given he is on Mylo Dashboard Home page
And he clicks on the Assignment option in the Mylo Menu on the sidebar
And he clicks on Hamburger Menu after closing the Assignment option
When he clicks on "Query" Option in the Hamburger Menu
Then the Select Query Type screen should display with the given parameters

| First Row  | File       | My File | My Active Files  | My Unbilled   |
| Second Row | Accounting | Transfee Name  | Sub-Service ID| Advanced |
| Third Row  |Shipment    | PO Number        | History       ||