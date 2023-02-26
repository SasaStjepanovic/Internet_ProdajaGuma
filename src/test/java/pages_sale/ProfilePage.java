package pages_sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilePage extends BasePage_Sale {


    public ProfilePage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(xpath = "//div[@class='logo-box']")
    WebElement baseUrlPageEl;

    @FindBy(css = "#profil-first_name")
    WebElement imeEl;

    @FindBy(css = "#profil-last_name")
    WebElement prezimeEl;

    @FindBy(css = "#profil-email")
    WebElement emailEl;

    @FindBy(xpath = "//input[@id='company_name']")
    WebElement nazivFirmeEl;

    @FindBy(css = "#company_pib")
    WebElement pibEl;

    @FindBy(css = "#company_maticni_broj")
    WebElement maticniBrojEl;

    @FindBy(css = "#profil-city")
    WebElement mestoEl;

    @FindBy(css = "#profil-zip")
    WebElement pttEl;

    @FindBy(css = "#profil-address")
    WebElement ulicaEl;

    @FindBy(css = "#profil-address_number")
    WebElement kucniBrojEl;

    @FindBy(css = "#profil-mobile")
    WebElement telefonEl;

    @FindBy(css = "#submit-profil")
    WebElement azurirajProfilEl;

    public void goToBaseUrlPage() {
        clickElement(baseUrlPageEl, " go to the base url page button is clicked");
    }

    public void clickAzurirajProfil() {
        clickElement(azurirajProfilEl, " azuriraj profil buttn is pressed");
    }

    public void enterIme(String ime) {
        typeText(imeEl, ime, " 'ime' is entered");
    }

    public void enterPrezme(String prezime) {
        typeText(prezimeEl, prezime, " 'prezime' is entered");
    }

    public void enterNazivFirme(String firma) throws InterruptedException {
        typeTextJS(nazivFirmeEl, firma, " 'firma' is entered");
    }

    public void enterPib(String pib) throws InterruptedException {
        typeTextJS(pibEl, pib, " 'pib' is entered");
    }

    public void enterMaticni(String maticni) throws InterruptedException {
        typeTextJS(maticniBrojEl, maticni, " 'maticni' is entered");
    }

    public void enterMesto(String mesto) throws InterruptedException {
        typeTextJS(mestoEl, mesto, " 'mesto' is entered");
    }

    public void enterPtt(String ptt) throws InterruptedException {
        typeTextJS(pttEl, ptt, " 'ptt' is entered");
    }

    public void enterUlica(String ulica) throws InterruptedException {
        typeTextJS(ulicaEl, ulica, " 'ulica' is entered");
    }

    public void enterKucniBroj(String kucniBroj) throws InterruptedException {
        typeTextJS(kucniBrojEl, kucniBroj, " 'kucniBroj' is entered");
    }

    public void enterTelefon(String tel) throws InterruptedException {
        typeTextJS(telefonEl, tel, " 'tel' is entered");
    }

    public void selectHowYouBuy(String customer) {
        WebElement element = driver.findElement(By.xpath("//div[@class='Profil-Tab-Container']/div/div//label[text()='" + customer + "']"));
        checkCheckbox(element, " radio button: " + customer + " is selected");
    }

    public void enterProfilOwnData(String customer, String randomDataYesNo, String ime, String prezime, String email, String firma, String pib, String maticni) throws InterruptedException {
        selectHowYouBuy(customer);
        if (randomDataYesNo.equalsIgnoreCase("No")) {
            if (customer.equalsIgnoreCase("Fizičko lice")) {
                enterIme(ime);
                enterPrezme(prezime);
            } else {
                enterIme(ime);
                enterPrezme(prezime);
                enterNazivFirme(firma);
                enterPib(pib);
                enterMaticni(maticni);
            }
        } else {
//// uraditi random samo za ime i prezime
        }
    }

    public void enterDeliveryAddress(String mesto, String ptt, String ulica, String kucniBroj, String tel) throws InterruptedException {
        enterMesto(mesto);
        enterPtt(ptt);
        enterUlica(ulica);
        enterKucniBroj(kucniBroj);
        enterTelefon(tel);
    }

    public void verifyProfileCustomerData(String customer, String randomDataYesNo, String imeText, String prezimeText, String emailText, String attributeType,
                                          String firmaText, String pibText, String maticniBrojText) {
        selectHowYouBuy(customer);
        if (randomDataYesNo.equalsIgnoreCase("No")) {
            if (customer.equalsIgnoreCase("Fizičko lice")) {
                getAttribute(imeEl, imeText, attributeType);
                getAttribute(prezimeEl, prezimeText, attributeType);
                getAttribute(emailEl, emailText, attributeType);
            } else {
                getAttribute(imeEl, imeText, attributeType);
                getAttribute(prezimeEl, prezimeText, attributeType);
                getAttribute(emailEl, emailText, attributeType);
                getAttribute(nazivFirmeEl, firmaText, attributeType);
                getAttribute(pibEl, pibText, attributeType);
                getAttribute(maticniBrojEl, maticniBrojText, attributeType);
            }
        } else {
//// samo za radnom ime i prezime
        }
    }

    public void verifyProfileDeliveryAdress(String mesto, String ptt, String ulica, String kucniBroj, String tel, String attributeType){
        getAttribute(mestoEl, mesto, attributeType);
        getAttribute(pttEl, ptt, attributeType);
        getAttribute(ulicaEl, ulica, attributeType);
        getAttribute(kucniBrojEl, kucniBroj, attributeType);
        getAttribute(telefonEl, tel, attributeType);
    }
}