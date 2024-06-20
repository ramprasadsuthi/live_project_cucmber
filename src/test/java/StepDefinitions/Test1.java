package StepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

public class Test1 {
	
	@Given("User launches the Application")
	public void user_launches_the_application() {
	    System.out.println("User Launching the Application");
	}
	
	@When("user enters username and password and click on the Login button")
	public void user_enters_username_and_password_and_click_on_the_login_button() {
		 System.out.println("User Enters User Name and Password and clicks on the Login");
	}
	
	@Then("validate the login page")
	public void validate_the_login_page() {
		 System.out.println("Login successful.");
	}


}
