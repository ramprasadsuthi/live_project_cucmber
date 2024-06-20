package runners;
import org.junit.runner.RunWith;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
 
@RunWith(Cucumber.class)
 
@CucumberOptions(
        		features ="src/test/resources/features/EDI834File.feature",
        		monochrome = true,		
        glue = {"StepDefinitions"},
        plugin = {
                "pretty",
                "html:target/cucumber-reports/cucumber-pretty",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:",
                "json:target/cucumber-reports/CucumberTestReport.json",
                "timeline:target/test-output-thread/"
    }//,tags="@regression12"
)
public class TestRunner {
	
	
    }

