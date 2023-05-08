Feature: Login Test

  Scenario: Browser Launch
    Given User launch the browser
    When User login to portal
    Then User login successfully
    And User logout from portal
    And User close the browser
