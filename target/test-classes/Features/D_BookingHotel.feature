Feature: Booking a hotel from BookAHotelPage.

  Scenario: Booking a hotel
    Given User is on BookAHotel page.
    When User enters firstname,lastname,billing address and credit card number
    And User selects credit card type and expiry date
    And User enters CVV number
    Then User should click on Book Now Button.
   
   