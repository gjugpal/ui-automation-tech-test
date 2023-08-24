Feature: Booking a flight

  Scenario: Book a flight using valid airports
    Given I want to fly from LHR
    And I want to fly to EDI
    When I search for flights
    And I select the 1st flight
    And I enter in my contact details
      |firstname |lastname |email         |mobile     |gender|dob          |
      |mickey    |mouse    |micky@test.com|07711111111|male  |01-March-1990|
    And I add a checked bag
    Then I should be asked to select my seat


  Scenario: Origin and destination airports cannot be the same
    Given I want to fly from BHX
    And I want to fly to BHX
    When I search for flights
    Then I should get the error 'Origin and destination can't be the same'
