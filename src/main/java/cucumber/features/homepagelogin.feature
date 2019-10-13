Feature: Login from homepage validation

  Scenario Outline: UI Validation for Login

    Given I open the browser and navigate to Reddit homepage
    When I land on the homepage of Reddit and I verify the login button is displayed
    Then I click on the login button
    And I validate email or username field is displayed
    And I validate password field is displayed
    Then I enter my <username> and <password>
    And I click on the sign in button
    And I validate that I have logged in
    But I log out
    Then I close the browser

    Examples:
      | username | password |
      | dummyacct123753  | password2  |
