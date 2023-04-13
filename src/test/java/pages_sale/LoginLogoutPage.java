package pages_sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginLogoutPage extends BasePage_Sale{


    public LoginLogoutPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    @FindBy(xpath = "//a//span[text()='Prijava']/..")
    WebElement prijavaButton;

    @FindBy(css = "#login-user")
    WebElement email;

    @FindBy(css = "#login-pass")
    WebElement password;

    @FindBy(css = "#login-submit")
    WebElement loginButton;

    @FindBy(xpath = "//li[@class='Menu-Item Sub-Items profileMenuDesktop']/a")
    WebElement successfulLoginMessage;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ul//li")
    WebElement unSuccessfulLoginMessage;

    public void pressPrijavaButton() throws InterruptedException {
        clickElement(prijavaButton, " prijava button is pressed");
    }

    public void pressLoginButton(){
        clickElement(loginButton, "login button is pressed");
    }

    public void enterEmail(String emailAddress){
        typeText(email, emailAddress, " email is entered");
    }

    public void enterPassword(String pass){
        typeText(password, pass, " password is entered");
    }

    public void login(String emailAddress, String pass){
        enterEmail(emailAddress);
        enterPassword(pass);
        pressLoginButton();
    }

    public void verifyLoginAction(String verificationType, String expectedMessage, String emptyEmailPasswordMessage2) throws InterruptedException {
        if (verificationType.equalsIgnoreCase("validEmailPassword")) {
            compareText(successfulLoginMessage, expectedMessage);
        } else if (verificationType.equalsIgnoreCase("emptyEmail")) {
            compareText(unSuccessfulLoginMessage, expectedMessage);
        }  else if (verificationType.equalsIgnoreCase("emptyPassword")) {
            compareText(unSuccessfulLoginMessage, expectedMessage);
        }  else if (verificationType.equalsIgnoreCase("emptyEmailPassword")) {
            WebElement element1 = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ul//li[contains(text(),'"+ expectedMessage +"')]"));
            compareText(element1, expectedMessage);
            WebElement element2 = driver.findElement(By.xpath("//div[@class='alert alert-danger']/ul//li[contains(text(),'"+ emptyEmailPasswordMessage2 +"')]"));
            compareText(element2, emptyEmailPasswordMessage2);
        }  else if (verificationType.equalsIgnoreCase("InvalidEmailPassword")) {
            compareText(unSuccessfulLoginMessage, expectedMessage);
        }  else {
            System.out.println("Nothing of expected messages for login verification");
        }
    }

    // Logout
    public void clickProfileMenuSubItem(String profileSubItem) throws InterruptedException {
        Actions actions = new Actions(driver);
        actions.moveToElement(successfulLoginMessage).build().perform();
        WebElement element1 = driver.findElement(By.xpath("//li[@class='Menu-Item Sub-Items profileMenuDesktop']//*[contains(text(),'"+ profileSubItem +"')]"));
        clickElementJS(element1, "Button: " + profileSubItem + " is pressed");
    }

    public void verifyLogoutAction(String urlAddressExtension){
        checkUrlPage(urlAddressExtension);
    }
}
