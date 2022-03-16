Feature: Validate the functionality of Mylo Assignment Shipment section
  As a Mylo user, I want to validate the functionality for "Mylo Assignment - Shipment" section

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
   
@IRIS-1059 @Mylo-Regression
Scenario:  Mylo-Validate History Card appearing for Searching Multiple FileIds on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page for file with "No Shipment" subservices
And message "No shipments on this file" is displayed with grayed out shipment button after he hovers on "Shipment" tab
When he clicks on "Shipment" tab after navigating to Mylo Assignment Summary page for file with "One Shipment" subservice
Then he should get redirected to shipment screen no shipment drop-down appearing

@IRIS-1059 @Mylo-Regression
Scenario:  Mylo-Validate History Card appearing for Searching Multiple FileIds on Mylo Assignment page in the current session
Given he is on Mylo Assignment Summary page for file with "Two Shipment" subservices
And corresponding subserviceId should get displayed in the shipment dropdown after he clicks on "Shipment" tab for "Two Shipment" subservices
When he clicks on "Shipment" tab after navigating to Mylo Assignment Summary page for file with "Multiple Shipment" subservice
Then corresponding benefits Id should get displayed in the shipment dropdown for "Multiple Shipment" subservices