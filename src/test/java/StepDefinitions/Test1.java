package StepDefinitions;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import dataManager.ExcelDataReader;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;
import pageObjects.LoginPage;

public class Test1 {
	
	WebDriver driver;
	LoginPage lp;
	private List<Map<String, String>> excelData;
    String username;
    String password;
	
	@Before
	public void setup(Scenario scenario) throws IOException {
		 WebDriverManager.chromedriver().setup();

		// System.setProperty("web.chrome.driver", "chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     lp = new LoginPage(driver);
	     ExcelDataReader reader = new ExcelDataReader();
	     String filePath = "TestData.xlsx";  // Replace with your actual file path
	     String sheetName = "loginDetails";            // Replace with your actual sheet name
	     excelData = reader.readExcelData(filePath, sheetName);
	     for (Map<String, String> rowData : excelData) {
	            username = rowData.get("username");
	            password = rowData.get("password");
	            System.out.println("Username : " + username);
	            System.out.println("Password : " + password);
	     }
     
	}
	
	@After
	public void tearDown() {
		driver.quit();
	}
	
	@Given("User launches the Application url")
	public void user_launches_the_application() {
	    System.out.println("User Launching the Application");
	    driver.get("http://webapp.qedgetech.com/login.php");
	}
	
	@When("user enters username and password and click on the Login button")
	public void user_enters_username_and_password_and_click_on_the_login_button() {
		 System.out.println("User Enters User Name and Password and clicks on the Login");
		 lp.enterUsername("admin");
		 lp.enterPassword("master");
		 lp.clickLoginButton();
	}
	
	@When("user enters {string} and {string} and click on the Login button")
	public void user_enters_and_and_click_on_the_login_button(String username, String password) {
		 System.out.println("User Enters User Name and Password and clicks on the Login");
		 lp.enterUsername(username);
		 lp.enterPassword(password);
		 lp.clickLoginButton();
	}
	
	@When("user enters username and password from excel and click on the Login button")
	public void login_with_excelData() {
		
	try {
		 System.out.println("User Enters User Name and Password and clicks on the Login");
		 // Iterate over the Excel data and invoke the scenario steps
		 lp.enterUsername(username);
		 lp.enterPassword(password);
		 lp.clickLoginButton();
	} catch (Exception error) {
		throw error;
	}
	
	}
	
	@Then("validate the login page")
	public void validate_the_login_page() {
	  try {
		WebElement pageTitle = driver.findElement(By.xpath("//span[@id='ewPageCaption']"));
		String actualResult = pageTitle.getText();
		Assert.assertEquals("Dashboard", actualResult);
	  } catch (AssertionError error) {
		  throw error;
	  }
	}
	
	@Then("Click on Logout Button and validate Logout is success")
	public void validate_logout() {
		System.out.println("Logout is success..");
	}


}
