@iris
Feature: Create new Corporation Policy
  Validate the functionality of adding new Corporation policy.

  Background: Login to IRIS Application
    Given he is logged into IRIS application

  @Sprint-18  @create
  Scenario: Create new Corporation policy in IRIS application and verify that Policy is visible in PDT application
    Given he has selected "Corporation" module from "Welcome12C" window
    And he has queried corporation from "Corporation" module
    And he has added a new policy in the "Accounting" tab
		And he logins to the PDT application 
    When he searches the newly added policy for client Id in the "Add New Policy" page
    Then newly added Policy should be displayed in Policy drop down of "Add New Policy" page

