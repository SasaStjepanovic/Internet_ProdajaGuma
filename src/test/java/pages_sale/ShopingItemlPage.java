package pages_sale;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class ShopingItemlPage extends BasePage_Sale {


    public ShopingItemlPage(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    @FindBy(xpath = "//div[@class='Product-Items Results']/article[1]//div[@class='add-to-cart']/a[@class='Product-Item-Qty-Change  Plus ']")
    WebElement addItem;

    @FindBy(xpath = "//div[@class='Product-Items Results']/article[1]//div[@class='add-to-cart']/a[@class='Product-Item-Qty-Change  Minus ']")
    WebElement removeItem;

    @FindBy(xpath = "//div[@class='Product-Items Results']/article[1]//label")
    WebElement availableNumberOfTires;

    @FindBy(xpath = "//div[@class='Product-Items Results']/article[1]//div[@class='add-to-cart']/input[@value='Dodaj']")
    WebElement dodajButton;

    @FindBy(xpath = "//span[@id='Cart-Items']")
    WebElement numItemsInTheBasket;

    @FindBy(xpath = "//div[@id='cart_container']")
    WebElement emptyBasket;
    @FindBy(xpath = "//div[@class='header-basket']//a/span[2]")
    WebElement korpaButton;


    public void verifyNumberOfItemsInTheBasket(String numItems) throws InterruptedException {
        compareText(numItemsInTheBasket, numItems);
    }

    public int availableNumberofTires() {
        String actualValue1 = availableNumberOfTires.getText();
        System.out.println("Actual available number of elements : " + actualValue1);
        if (actualValue1.equalsIgnoreCase("10+")) {
            int actualValue2 = Integer.parseInt("12");
            return actualValue2;
        } else {
            int actualValue3 = Integer.parseInt(actualValue1);
            return actualValue3;
        }
    }

    public void addItemShoppingBasket() {
        if (availableNumberofTires() == 1) {
            System.out.println("One item is minimum in the shopping basket");
        }
        else if (availableNumberofTires() <= 5) {
            System.out.println("One item is always in the shopping basket");
            clickElementJS(addItem, "First item: is added in the basket");
            clickElementJS(addItem, "Second item: is added in the basket");
        }
        else {
                for (int i = 1; i < availableNumberofTires(); i++) {
                    clickElementJS(addItem, "item: " + i + " is added in the basket");
//                }
            }
        }
    }

    public void addMoreItemsInTheBasket(String numItems) {
        for (int i = 1; i <= Integer.parseInt(numItems); i++) {
            WebElement element1 = driver.findElement(By.xpath("//div[@class='Product-Items Results']/article[" + i + "]//div[@class='add-to-cart']/input[@value='Dodaj']"));
            System.out.println(element1);
            clickElementJS(element1, "item: " + i + " is added in the basket");
            goBack();
        }
    }

    public void clickDodajButton() {
        clickElement(dodajButton, " dodaj button is pressed");
    }

    public void goBack() {
        driver.navigate().back();
    }

    public void enterKorpa(){
        clickElementJS(korpaButton, " kopra button is pressed");
    }

    public void deleteAllCheckLists() throws InterruptedException {
       enterKorpa();
        List<WebElement> listOfCheckList = driver.findElements(By.xpath("//div[@class='Cart-Box']/../div"));
        if (emptyBasket.getText().equals("Korpa je prazna ")) {
            System.out.println("list of items are empty !!!");
        } else {
            for (int i = 0; i <= listOfCheckList.size(); i++) {
                try {
                    WebElement element = driver.findElement(By.xpath(" //div[@class='Cart-Box']/../div[1]/div[1]/a"));
                    clickXbutton(element, " x button is pressed: " + i + " time");
                    Thread.sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                    System.out.println("list is empty, there are no elements");
                }
            }

        }
    }
}

