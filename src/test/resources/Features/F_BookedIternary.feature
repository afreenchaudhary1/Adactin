Feature: Verify and Cancel BookedItinerary Page

  Scenario: User will verify OrderId
    Given User is on BookedItinerary Page.
    When User will Copy order id of first record
    And User will paste the OrderId
    Then User should click on Go Button.

  Scenario: Cancel a booked hotel
    Given User is on BookedItinerary Page.
    When User clicks on Cancel Selected Button
    Then User should click on OK Button.
