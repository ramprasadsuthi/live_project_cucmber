package pageObjects;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.DriverManager;

public class LoginPage {
    private WebDriver driver;
    private WebDriverWait wait;

    // Page elements using @FindBy annotation
    @FindBy(xpath = "//input[@id='username']")
    public WebElement usernameInput;

    @FindBy(xpath = "//input[@id='password']")
    public WebElement passwordInput;

    @FindBy(xpath = "//button[@id='btnsubmit']")
    public WebElement loginButton;
    
    @FindBy(xpath = "//button[@id='btnreset']")
    public WebElement resetButton;
    
    @FindBy(xpath = "//li[@id='mi_logout']")
    private WebElement logoutButton;
    
    @FindBy(xpath = "//div[@class='alert alert-danger ewError']")
    private WebElement errorMesg;
    
    @FindBy(xpath = "//a[text()='Forgot Password']']")
    private WebElement forgotPasswordLink;
    
     // Constructor initializes elements with PageFactory
    public LoginPage() {
      //  this.driver = driver;
    	this.driver = DriverManager.getDriver();
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
      // driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
        PageFactory.initElements(driver, this);
    }
    
    public void launchApp(String url) {
    	driver.get(url);;
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

    public void clickLoginButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButton.click();
     }
    
    public void clickOnResetButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(resetButton));
    	resetButton.click();
     }
    
    public void clickOnLogoutButton() {
    	wait.until(ExpectedConditions.elementToBeClickable(logoutButton));
    	logoutButton.click();
     }
    
    public String getErrorMesg() {
    	wait.until(ExpectedConditions.visibilityOf(errorMesg));
    	return errorMesg.getText();
    }
    
    public void clickOnForgotPasswordLink() {
    	wait.until(ExpectedConditions.elementToBeClickable(forgotPasswordLink));
    	forgotPasswordLink.click();
     }
}

