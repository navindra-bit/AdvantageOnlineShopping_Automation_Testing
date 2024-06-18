Feature: Login to Advantage Online Shopping

  Scenario Outline: Trying to login in Advantage Online Shopping with valid/invalid data
    Given Browser is open and user is on Advantage Online Shopping home page
    Then User click on login icon
    When User enters "<username>" and "<password>" and clicks on login button
    Then User is successfully logged in
    Then User logsout

    Examples: 
      | username | password  |
      | naqeeb   | Naqeeb123 |
