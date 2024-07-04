Feature: Sample Feature File

  @smokeTest
  Scenario: TC-1 Login Test
    Given User launches the Application url
    When user enters username and password and click on the Login button
    Then validate the login page
    
  @regressionTest
  Scenario: TC-2 Logout Test
    Given User launches the Application url
    When user enters username and password and click on the Login button
    Then validate the login page
    And Click on Logout Button and validate Logout is success

