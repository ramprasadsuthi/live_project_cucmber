Feature: Sample Feature File

  @nonDataDrivenTest, @smokeTest
  Scenario: TC-1 Login Test
    Given User launches the Application url
    When user enters username and password and click on the Login button
    Then validate the login page
    
  @nonDataDrivenTest
  Scenario: TC-2 Logout Test
    Given User launches the Application url
    When user enters username and password and click on the Login button
    Then validate the login page
    And Click on Logout Button and validate Logout is success
    
  @dataDrivenTest
  Scenario: TC-3 Login Test with DataDriven
    Given User launches the Application url
    When user enters "<username>" and "<password>" and click on the Login button
    Then validate the login page
    
  Examples:
  | username | password |
  | admin    | master   |
  
  @dataDrivenTest
  Scenario: TC-4 Login Test with Excel
    Given User launches the Application url
    When user enters username and password from excel and click on the Login button
    Then validate the login page
    

