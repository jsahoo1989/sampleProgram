Feature: Validate the functionality of Mylo SubServiceID Query
  I want to test the functionality of Mylo SubServiceID Query

  Background: Login to Mylo application
    Given he selects "Query" option under "Journey" section available on left panel of Home Page after successfully logging into the 'Mylo' application

  @MYLO2-161 @C218342 @C218343 @Mylo:218545 @Mylo-Regression
  Scenario: Mylo- Validate Shipment and Non Shipment subserviceId search from query by subserviceID section
    Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query PopUp" section
    When he clicks on "Execute" button after entering "Non-Shipment" subServiceId in the "Sub-Service ID" field on "QueryBySub-ServiceID" section
    Then he should be taken to the Summary Overview section for that subservice without shipment sidescreen being displayed on Mylo Journey page
    And he should be taken to the Summary Overview page with shipment sidescreen being displayed after entering "Shipment" subServiceId on "QueryBySub-ServiceID" section

  @MYLO2-161 @C218352 @C218344 @C218353 @Mylo:218546 @Mylo-Regression
  Scenario: Mylo-Validate Boundary Conditions of Number Limit for sub-service Id field & Cancel button functionality of Query By Sub-Service Id section
    Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query PopUp" section
    When he enters data beyond number limit for "Sub-Service ID" field under "QueryBySub-ServiceID" section
    Then values should be successfully entered as per number limit 10 set for "Sub-Service ID" field under "QueryBySub-ServiceID" section
    And he should not be able to enter any character in "Sub-Service ID" field under "QueryBySub-ServiceID" section
    And "Query By Sub-Service ID" modal should be closed after clicking on "Cancel" button

  @MYLO2-161 @C218345 @Mylo:218547 @Mylo-Regression
  Scenario: Mylo: Validate No such file popup for invalid sub-serviceID and Close icon functionality of Query By Sub-Service Id section
    Given he is on "Query By Sub-Service ID" popup by selecting "Sub-Service ID" option available on "Query PopUp" section
    When he clicks on "Execute" button after entering an invalid sub-service id in the "Sub-Service ID" field on "QueryBySub-ServiceID" section
    Then "No such file found" popup message should be displayed above "QueryBySub-ServiceID" popup
    And "Query By Sub-Service ID" modal should be closed after clicking on "Close" icon on "QueryBySub-ServiceID" section
