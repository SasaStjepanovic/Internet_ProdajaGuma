package pages_sale;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class GeneralPage extends BasePage_Sale {


    public GeneralPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='toast-message']")
    WebElement toastmessage;
    @FindBy(xpath = "//span[@id='result_counter']")
    WebElement primeniFiltereButton;

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

    @FindBy(xpath = "//div[@class='Search-Page-Section-1']//h1")
    WebElement titleOfChosenElement;

    public void verifyNegativeMessage(String toast){
        compareText(toastmessage,toast);
    }

    public void verifyNegativeMessageII(String toast) throws InterruptedException {
        comparePartOfText(toastmessage,toast);
    }

    public void clickPrimeniFiltereButton(){
        clickElementJS(primeniFiltereButton, " priemeni filtere button is pressed");
    }

    public void selectMainMenuTitle(String mainMenuTitle) throws InterruptedException {
        Thread.sleep(1000);
        Actions actions = new Actions(driver);
        actions.moveToElement(driver.findElement(By.xpath("//ul[@class='nav-menu']/li/a[text()='"+ mainMenuTitle +"']"))).build().perform();
        System.out.println("Menu title: " + mainMenuTitle + " is selected");
    }

    public void clickMainMenuSubItem(String mainMenuSubTitle){
        WebElement element = driver.findElement(By.xpath(" //h3[@class='sub-menu-title']/a[text()='"+mainMenuSubTitle+"']"));
        clickElement(element, "Element" + mainMenuSubTitle + " is pressed");
    }
    public void clickMainMenuSubSubItem(String mainMenuSubSubTitle){
        WebElement element = driver.findElement(By.xpath(" //div[@class='nav-dropdown']//ul/li/a[contains(text(),'" + mainMenuSubSubTitle + "')]"));
        clickElement(element, "Element" + mainMenuSubSubTitle + " is pressed");
    }

    public void verifyChosenTitleOfEelement(String expectedTitle){
        compareText(titleOfChosenElement, expectedTitle);
    }

    public void applyFilterPretragaGuma(String vrstaVozila, String sezona, String dimenzije, String proizvodjac) throws InterruptedException {
        boolean b = autoGume.isDisplayed();
        if (b) {
            System.out.println("filter 'Pretraga guma' is already expanded");
        } else {
            clickElement(filterPretraga1, " filter 'Pretraga guma' is pressed");
        }

        WebElement element1 = driver.findElement(By.xpath("//a[@title='" + vrstaVozila + "']"));
        clickElementJS(element1, " vrsta vozlila: " + vrstaVozila + " is selected");
        Thread.sleep(3000);
        WebElement element2 = driver.findElement(By.xpath("//a[@title='" + sezona + "']"));
        clickElementJS(element2, " sezona: " + sezona + " is selected");
        Thread.sleep(1000);

        Select dropdown1 = new Select(dimenzijeButton);
        dropdown1.selectByVisibleText(dimenzije);
        System.out.println("Dimenzija: " + dimenzije + " is selected");
    }

    public void applyFilterDetaljnaPretraga(String runflat, String opterecenje, String buka, String indeksBrzine,
                                            String potrosnja, String prijanjanje) {
        try {
            boolean b = filterPretraga2.isDisplayed();
            if (b) {
                clickElementJS(filterPretraga2Color, " filter 'Detaljna pretraga' is pressed");
            } else {
                System.out.println("filter 'Detaljna pretraga' is already expanded");
            }
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("filter 'Detaljna pretraga' is already expanded");
        }

        Select dropdown1 = new Select(runflatButton);
        dropdown1.selectByVisibleText(runflat);
        System.out.println("Runlfat is choosed: ");

        Select dropdown2 = new Select(opterecenjeButton);
        dropdown2.selectByVisibleText(opterecenje);
        System.out.println("Opterecenje is choosed: ");

        Select dropdown3 = new Select(bukaButton);
        dropdown3.selectByVisibleText(buka);
        System.out.println("Buka is choosed: ");

        Select dropdown4 = new Select(indeksBrzineButton);
        dropdown4.selectByVisibleText(indeksBrzine);
        System.out.println("Indeks brzine is choosed: ");

        Select dropdown5 = new Select(potrosnjaButton);
        dropdown5.selectByVisibleText(potrosnja);
        System.out.println("Potrosnja is choosed: ");

        Select dropdown6 = new Select(prijanjanjeButton);
        dropdown6.selectByVisibleText(prijanjanje);
        System.out.println("Prijanjanje is choosed: ");
    }

    public void checkFilteredItems(String[] menuItems) throws InterruptedException {
        List<WebElement> menu = driver.findElements(By.xpath("//div[@id='Searach-Terms']/div"));
        for (int i = 0; i < menu.size(); i++) {
            Thread.sleep(100);
            String item = menu.get(i).getText();
            System.out.println("Actual  filtered element" + i + " is: " + item);
            Thread.sleep(100);
            Assert.assertEquals(item, menuItems[i], "Menu item not displayed");
            System.out.println("Actual  filtered element" + i + " is: " + item);
            Assert.assertTrue(menu.get(i).isDisplayed(), menuItems[i]);
        }
    }
}