Feature: Validate the functionality of Mylo Accounting Query
  I want to test the  functionlity of Mylo Accounting Query

Background: Login to  Mylo application
    Given he has logged into the 'Mylo' application
    
@IRIS-2145 @218346 
Scenario:  Mylo-Validate Warning Toast Messages due to SpecialCharacters for mentioned fields of Mylo Accounting Query section
Given he is on "Accounting Query" popup by selecting "Accounting" option available on "Query" section
Then tag script messages should be displayed for entering 'specialCharacters' on below fields after clicking on "Execute" button on "Accounting Query" section
|Field Name                    |Message                                                    |
|TransfereeFirstName           |Tag Scripts are not allowed in transferee first name.      |
|TransfereeLastName            |Tag Scripts are not allowed in transferee last name.       |
|Tracking Number               |Tag Scripts are not allowed in tracking number.            |
|Origin Address Street1        |Tag Scripts are not allowed in origin street 1.            |
|Origin Address Street2        |Tag Scripts are not allowed in origin street 2.            |
|Origin Address City           |Tag Scripts are not allowed in origin city.                |
|Origin Address ZipCode         |Tag Scripts are not allowed in origin zip code.           |    
|Origin Address State Text      |Tag Scripts are not allowed in  origin State/Province.    |
|Destination Address Street1   |Tag Scripts are not allowed in destination street 1.       |
|Destination Address Street2   |Tag Scripts are not allowed in destination street 2.       |
|Destination Address City      |Tag Scripts are not allowed in destination city.           |
|Destination Address ZipCode   |Tag Scripts are not allowed in destination zip code.       |
|Destination Address State Text|Tag Scripts are not allowed in  destination State/Province.|

@IRIS-21451 @218347 
Scenario:  Mylo-Validate Warning Toast Messages due to SpecialCharacters for mentioned fields of Mylo Accounting Query section
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