Feature: Validate EDI 834 segment values

  Scenario: Validate BGN segment value in 834 file
    Given I have an EDI 834 file at "src/test/resources/834file.txt"
    When I validate the segment "BGN" with the expected value "00"
    Then the segment value should match the expected result
