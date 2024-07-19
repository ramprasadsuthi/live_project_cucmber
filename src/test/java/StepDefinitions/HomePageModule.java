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
import pageObjects.HomePage;
import pageObjects.LoginPage;

public class HomePageModule {
	
	WebDriver driver;
	LoginPage lp;
	HomePage hp;
	
	@Before 
	public void setup(){
		hp = new HomePage();
	}
		
	@Then("click on StockItems menu and validate")
	public void click_on_StockItems_menu_and_validate() {
		hp.clickOnStockItemsMenu();
	}
	
}
