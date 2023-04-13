package pages_sale;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

public class RegistartionPage extends BasePage_Sale {


    public RegistartionPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='logo-box']")
    WebElement baseUrlPageEl;

    @FindBy(xpath = "//input[@name='name']")
    WebElement imePrezimeEl;

    @FindBy(xpath = "//input[@name='email']")
    WebElement emailEl;

    @FindBy(xpath = "//input[@name='password']")
    WebElement lozinkaEl;

    @FindBy(xpath = "//input[@name='password_confirmation']")
    WebElement ponoviLozinkuEl;

    @FindBy(xpath = "//label[@class='Form-Checkbox']/span")
    WebElement prihvatamCheckbox;

    @FindBy(xpath = "//form[@id='form-login']/*[text()='Registruj se']")
    WebElement registrujSeButton;

    @FindBy(xpath = "//input[@name='login-submit']")
    WebElement registrujSeFinalButton;

    @FindBy(xpath = "//div[@class='alert alert-danger']/ul//li")
    WebElement unSuccessfulLoginMessage;

    @FindBy(xpath = "//li[@class='Menu-Item Sub-Items profileMenuDesktop']/a")
    WebElement successfulLoginMessage;

    @FindBy(xpath = "//a[@title='Auto gume']")
    WebElement autoGume;

    @FindBy(xpath = "//div[@class='Search-Filter-Category']")
    WebElement filterPretraga1;

    @FindBy(xpath = "//div[@class='Search-Filter-Category second']")
    WebElement filterPretraga2;

    @FindBy(xpath = "//div[@class='Search-Filter-Category second']//a")
    WebElement filterPretraga2Color;

    @FindBy(xpath = "//label[contains(text(),'Dimenzije')]/..//select")
    WebElement dimenzijeButton;

    @FindBy(xpath = "//label[contains(text(),'Runflat')]/..//select")
    WebElement runflatButton;

    @FindBy(xpath = "//label[contains(text(),'Opterećenje')]/..//select")
    WebElement opterecenjeButton;

    @FindBy(xpath = "//label[contains(text(),'Buka')]/..//select")
    WebElement bukaButton;

    @FindBy(xpath = "//label[contains(text(),'Indeks brzine')]/..//select")
    WebElement indeksBrzineButton;

    @FindBy(xpath = "//label[contains(text(),'Potrošnja')]/..//select")
    WebElement potrosnjaButton;

    @FindBy(xpath = "//label[contains(text(),'Prijanjanje')]/..//select")
    WebElement prijanjanjeButton;

//    @FindBy(xpath = "//div[@class='Search-Filter-Category second Expanded']//div/*[text()='Buka']")
//    WebElement bukaButton;

//    @FindBy(xpath = "//label[contains(text(),'Proizvođači')]/..//select")
//    WebElement proizvodjaciButton;

    @FindBy(xpath = "//span[@id='select2-paramef_proizvodjac-8i-container']//span[text()='izaberi...']")
    WebElement proizvodjaciButton;

    public void clickRegistrujSeButton() {
        clickElementJS(registrujSeButton, " 'Registruj se button is pressed'");
    }

    public void verifyRistrujSeDisabled() {
        Assert.assertEquals(false, registrujSeFinalButton.isEnabled());
    }

    public void verifyRegistrujSeEnabled() {
        Assert.assertEquals(true, registrujSeFinalButton.isEnabled());
    }

    public void enterImePrezime(String imePrezime) {
        typeText(imePrezimeEl, imePrezime, " ime and prezime is entered ");
    }

    public void enterEmail(String email) {
        typeText(emailEl, email, " email is entered ");
    }

    public void enterLozinka(String lozinka) {
        typeText(lozinkaEl, lozinka, " lozinka is entered ");
    }

    public void enterPonoviLozinka(String ponoviLozinka) {
        typeText(ponoviLozinkuEl, ponoviLozinka, " ponoviLozinka is entered ");
    }

    public void checkPrihvatam() {
        checkCheckbox(prihvatamCheckbox, " Prihvatam checkox is checked");
    }

    public String randomEmail() {
        Faker fakerData = new Faker();
        String randomName = fakerData.name().firstName();
        int number = fakerData.number().numberBetween(1, 10000);
        String randomEmail = randomName + number + "@yahoo.com";
        System.out.println("Random email exactly after generate is :" + randomEmail);
        return randomEmail;
    }

    public String randomName() {
        Faker fakerData = new Faker();
        String randomName = fakerData.name().fullName().toUpperCase();
        System.out.println("Random email exactly after generate is :" + randomName);
        return randomName;
    }

    public void registration(String randomTypeYesNo, String imePrezime, String email, String lozinka, String confirmlozinka, String randomName, String randomEmail) {

        if (randomTypeYesNo.equalsIgnoreCase("yes")) {
            enterImePrezime(randomName);
            enterEmail(randomEmail);
        } else {
            enterImePrezime(imePrezime);
            enterEmail(email);
        }
        enterLozinka(lozinka);
        enterPonoviLozinka(confirmlozinka);
        checkPrihvatam();
        clickElement(registrujSeFinalButton, " registruj se button is pressed");
    }

    public void verifyRegistrationAction(String verificationType, String randName, String expectedMessage2) throws InterruptedException {
        if (verificationType.equalsIgnoreCase("successful")) {
            compareText(successfulLoginMessage, randName);
        } else if (verificationType.equalsIgnoreCase("unsuccessful")) {
            compareText(unSuccessfulLoginMessage, expectedMessage2);
        } else {
            System.out.println("Nothing of expected messages for login verification");
        }
    }

}