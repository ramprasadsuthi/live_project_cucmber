package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Page elements using @FindBy annotation
    @FindBy(xpath = "//input[@id='username']") 
    public WebElement usernameInput;
    
    @FindBy(xpath = "//input[@id='password']") 
    public WebElement passwordInput;
    
    @FindBy(xpath = "//button[@id='btnsubmit']") 
    public WebElement clickOnLoginButton;

    // Constructor initializes elements with PageFactory
    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(20));
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }

    // Actions performed on the page elements
    public void enterUsername(String username) {
    	wait.until(ExpectedConditions.visibilityOf(usernameInput));
    	usernameInput.clear();
        usernameInput.sendKeys(username);
    }
    
    public void enterPassword(String password) {
    	wait.until(ExpectedConditions.visibilityOf(passwordInput));
    	passwordInput.clear();
    	passwordInput.sendKeys(password);
    }
    
    public void clickOnLoginButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(clickOnLoginButton));
    	clickOnLoginButton.click();
    }

 }

