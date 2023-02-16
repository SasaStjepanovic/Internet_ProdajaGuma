package tests_bora;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import utilities.PropertyManager;

public class LoginTest extends BaseTest_bora {
    private static final String USERNAMEFIELDXPATH = "//*[@id='user-name' or @name='email']";
    private static final String PASSWORDFIELDXPATH = "//*[contains(@type,'password')]";
    private static final String LOGINBUTTONXPATH = "//*[contains(@type,'submit')]";

    @Test
    public void SuccessfullLogin() {

        driver.findElement(By.xpath(USERNAMEFIELDXPATH)).clear();
        driver.findElement(By.xpath(PASSWORDFIELDXPATH)).clear();
        driver.findElement(By.xpath(USERNAMEFIELDXPATH)).sendKeys(PropertyManager.getInstance().getUsername());
        driver.findElement(By.xpath(PASSWORDFIELDXPATH)).sendKeys(PropertyManager.getInstance().getPassword());
        driver.findElement(By.xpath(LOGINBUTTONXPATH)).click();

        driver.findElement(By.xpath("//*[@class='shopping_cart_container' or @class='header-basket']"));


    }
}
