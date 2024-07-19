package utils;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import utils.DriverManager;

public class Hooks {

    @Before
    public void setUp() {
        // Initialize WebDriver before each scenario
        DriverManager.getDriver();
    }

    @After
    public void tearDown() {
        // Quit WebDriver after each scenario
        DriverManager.quitDriver();
    }
}
