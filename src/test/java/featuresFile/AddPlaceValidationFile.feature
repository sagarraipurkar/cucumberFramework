Feature: Verify Add Place Functionality Using Add Place API

Feature: Verify user is able to add a place

  Scenario Outline: Verify user able to add place
    Given Add the Payload "<name>" "<address>" "<website>" "<language>"
    When Call the "AddPlaceAPI" request with the help of "Post" method
    Then verify the status code is 200
    Then extract the place_Id for future use

Examples:
    | name   | address                   	| website                    	| language |
    | Gerage | Woodland Corp Pvt Ltd      | https://www.google.com      | Bangla   |


Scenario: Verify user can retrieve place details
Given Add the Payload for Get Place Request
When Call the "GetPlaceAPI" request with the help of "GET" method
Then verify the status code is 200

Scenario: Verify user can delete the place
Given Add the Payload to delete Place
When Call the "DeletePlaceAPI" request with the help of "POST" method
Then verify the status code is 200
