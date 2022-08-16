Feature: Setting the details of SearchHotelPage.

  Scenario: Adding SearchHotel queries.
    Given User is on SearchHotel page.
    When User selects the location,hotel,roomtype and  number of rooms.
    And User  enters check-in and check-out dates.
    And User selects adults and children per room.
    Then User should click on search Button.
