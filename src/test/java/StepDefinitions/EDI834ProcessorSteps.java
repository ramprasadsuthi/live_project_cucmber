package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class EDI834ProcessorSteps {
    private String filePath;
    private String segmentIdentifier;
    private String expectedValue;
    private boolean isValid;

    @Given("I have an EDI 834 file at {string}")
    public void i_have_an_edi_834_file_at(String filePath) {
        this.filePath = filePath;
    }

    @When("I validate the segment {string} with the expected value {string}")
    public void i_validate_the_segment_with_the_expected_value(String segmentIdentifier, String expectedValue) throws IOException {
        this.segmentIdentifier = segmentIdentifier;
        this.expectedValue = expectedValue;
        this.isValid = validateSegmentValue(filePath, segmentIdentifier, expectedValue);
    }

    @Then("the segment value should match the expected result")
    public void the_segment_value_should_match_the_expected_result() {
        Assert.assertTrue("The segment value does not match the expected result", isValid);
    }

    // Method to validate the value of a specific segment
    public boolean validateSegmentValue(String filePath, String segmentIdentifier, String expectedValue) throws IOException {
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] segments = line.split("~");
                for (String segment : segments) {
                    String[] elements = segment.split("\\*");
                    if (elements[0].equals(segmentIdentifier)) {
                        if (elements.length > 1 && elements[1].equals(expectedValue)) {
                            return true;
                        }
                    }
                }
            }
        }
        return false;
    }
}

