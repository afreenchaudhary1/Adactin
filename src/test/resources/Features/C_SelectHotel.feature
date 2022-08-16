Feature: Selecting a hotel from SelectHotelPage.

  Scenario: Selecting a hotel
    Given User is on SelectHotel page.
    When User selects a specific hotel
    Then User should click on continue Button.
