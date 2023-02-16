package tests_bora;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import utilities.PropertyManager;

public class BaseTest_bora {
    public WebDriver driver;

    @BeforeMethod
    public void chromeSetup() {
        System.setProperty("webdriver.chrome.driver", PropertyManager.getInstance().getDriverPath());
        driver = new ChromeDriver(new ChromeOptions().addArguments("--start-maximized"));
        driver.get(PropertyManager.getInstance().getUrl());

    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }
}
