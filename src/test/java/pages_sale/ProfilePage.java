package pages_sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ProfilPage extends BasePage_Sale {


    public ProfilPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(css = "#profil-first_name")
    WebElement imeEl;

    @FindBy(css = "#profil-last_name")
    WebElement prezimeEl;

    @FindBy(css = "#profil-email")
    WebElement emailEl;

    @FindBy(css = "#company_name")
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
    WebElement adresaEl;

    @FindBy(css = "#profil-address_number")
    WebElement kucniBrojEl;

    @FindBy(css = "#profil-mobile")
    WebElement telefonEl;

    @FindBy(css = "#submit-profil")
    WebElement azurirajProfilEl;

    public void clickAzurirajProfil(){
        clickElement(azurirajProfilEl, " azuriraj profil buttn is pressed");
    }

    public void enterIme(String ime){
        typeText(imeEl, ime, " 'ime' is entered");
    }

    public void enterPrezme(String prezime){
        typeText(prezimeEl, prezime, " 'prezime' is entered");
    }

    public void enterNazivFirme(String firma){
        typeText(nazivFirmeEl, firma, " 'firma' is entered");
    }

    public void enterPib(String pib){
        typeText(pibEl, pib, " 'pib' is entered");
    }

    public void enterMaticni(String maticni){
        typeText(maticniBrojEl, maticni, " 'maticni' is entered");
    }

    public void selectHowYouBuy(String customer) {
        WebElement element = driver.findElement(By.xpath("//div[@class=\"Profil-Tab-Container\"]/div/div//label[text()='" + customer + "']"));
        checkCheckbox(element, " radio button: " + customer + " is selected");
    }

    public void enterProfilOwnData(String customer, String randomDataYesNo, String ime, String prezime, String email, String firma, String pib, String maticni) {
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

        }
    }
}