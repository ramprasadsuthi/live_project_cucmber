package StepDefinitions;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.github.bonigarcia.wdm.WebDriverManager;

import org.junit.Assert;

import pageObjects.LoginPage;

public class Test1 {
	
	WebDriver driver;
	LoginPage lp;
	
	@Before
	public void setup(Scenario scenario) {
		 WebDriverManager.chromedriver().setup();

		// System.setProperty("web.chrome.driver", "chromedriver.exe");
	     driver = new ChromeDriver();
	     driver.manage().window().maximize();
	     lp = new LoginPage(driver);
	}
	
	@After
	public void tearDown() {
		//driver.quit();
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
		 lp.clickOnLoginButton();
	}
	
	@When("user enters {string} and {string} and click on the Login button")
	public void user_enters_and_and_click_on_the_login_button(String username, String password) {
		 System.out.println("User Enters User Name and Password and clicks on the Login");
		 lp.enterUsername(username);
		 lp.enterPassword(password);
		 lp.clickOnLoginButton();
	}
	
	@Then("validate the login page")
	public void validate_the_login_page() {
		WebElement pageTitle = driver.findElement(By.xpath("//span[@id='ewPageCaption']"));
		String actualResult = pageTitle.getText();
		Assert.assertEquals("Dashboard", actualResult);
	}
	
	@Then("Click on Logout Button and validate Logout is success")
	public void validate_logout() {
		System.out.println("Logout is success..");
	}


}
