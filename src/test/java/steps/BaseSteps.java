package steps;

import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.Reporter;
import pages_sale.*;
import tests_sale.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    String ScrShoot1 = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrShoot1");

    String ScrShootDesc = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrShootDesc");

    boolean AllureScrYesOrNo = Boolean.parseBoolean(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("AllureScrYesOrNo"));
    boolean ScrYesOrNo = Boolean.parseBoolean(Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("ScrYesOrNo"));

    RegistartionPage rp = new RegistartionPage(driver);

    String randomEmail;
    String randomName;

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        openInternetProdajaGumaApp(env);

        randomEmail = rp.randomEmail();
        randomName = rp.randomName();
    }

    @After
    public void tearDown() throws IOException {
        new BasePage_Sale(driver).reportScreenshotAllure(ScrShoot1, ScrShootDesc, ScrYesOrNo);
        new BasePage_Sale(driver).takeScreenshot(ScrShoot1, true);
        quit();
    }

    @Given("a user reads test data from {string} {string} by id {string}")
    public void aUserReadsTestDataFromById(String fileName, String sheetName, String id) throws Exception {
        data = new ExcelSupport().getDataByID(fileName, sheetName, id);
    }

    @And("users clicks on prijava button")
    public void usersClicksOnPrijavaButton() throws InterruptedException {
        new LoginLogoutPage(driver).pressPrijavaButton();
    }

    @When("user enters email and password for login")
    public void userEntersEmailAndPasswordForLogin() {
        new LoginLogoutPage(driver).login(data.get("email"), data.get("password"));
    }

    @Then("user should be verified login action")
    public void userShouldBeVerifiedLoginAction() throws InterruptedException {
        new LoginLogoutPage(driver).verifyLoginAction(data.get("verificationType"), data.get("expectedMessage"), data.get("emptyEmailPasswordMessage2"));

    }

    @And("users clicks on odjavi se button")
    public void usersClicksOnOdjaviSeButton() throws InterruptedException {
        new LoginLogoutPage(driver).clickProfileMenuSubItem(data.get("profileSubItem"));
    }

    @Then("user should be verified logout action")
    public void userShouldBeVerifiedLogoutAction() {
        new LoginLogoutPage(driver).verifyLogoutAction(data.get("urlAddressExtension"));
    }

    @And("users clicks on profile button")
    public void usersClicksOnProfileButton() throws InterruptedException {
        new LoginLogoutPage(driver).clickProfileMenuSubItem(data.get("profileSubItem"));
    }

    @When("user enters profile own data")
    public void userEntersProfileOwnData() throws InterruptedException {
        new ProfilePage(driver).enterProfilOwnData(data.get("customer"), data.get("randomDataYesNo"),data.get("ime"), data.get("prezime"),
                data.get("email"), data.get("nazivFirme"),data.get("pib"), data.get("maticniBroj"));
    }

    @And("user clicks azuriraj button")
    public void userClicksAzurirajButton() {
        new ProfilePage(driver).clickAzurirajProfil();
    }

    @When("user reverts on the base url page")
    public void userRevertsOnTheBaseUrlPage() {
        new ProfilePage(driver).goToBaseUrlPage();
    }

    @Then("user should verify changed customer data in the profile section")
    public void userShouldVerifyChangedCustomerDataInTheProfileSection() {
        new ProfilePage(driver).verifyProfileCustomerData(data.get("customer"), data.get("randomDataYesNo"),data.get("ime"), data.get("prezime"),
                data.get("email"), data.get("attributeType"),data.get("nazivFirme"),data.get("pib"), data.get("maticniBroj"));
    }

    @When("user enters delivery address")
    public void userEntersDeliveryAddress() throws InterruptedException {
        new ProfilePage(driver).enterDeliveryAddress(data.get("mesto"), data.get("ptt"),data.get("ulica"),data.get("brojUl"), data.get("telefon"));
    }

    @Then("user should verify changed delivery data in the profile section")
    public void userShouldVerifyChangedDeliveryDataInTheProfileSection() {
        new ProfilePage(driver).verifyProfileDeliveryAdress(data.get("mesto"), data.get("ptt"),data.get("ulica"),data.get("brojUl"), data.get("telefon"),data.get("attributeType"));
    }

    @When("user enters profile own empty data")
    public void userEntersProfileOwnEmptyData() throws InterruptedException {
        new ProfilePage(driver).enterProfilOwnData(data.get("customer"), data.get("randomDataYesNo"),data.get("imeEmpty"), data.get("prezimeEmpty"),
                data.get("email"), data.get("nazivFirmeEmpty"),data.get("pibEmpty"), data.get("maticniBrojEmpty"));
    }

    @And("user clicks on registruj se button")
    public void userClicksOnRegistrujSeButton() {
        new RegistartionPage(driver).clickRegistrujSeButton();
    }

    @Then("user should verify applicable of registruj se button")
    public void userShouldVerifyApplicableOfRegistrujSeButton() {
        new RegistartionPage(driver).verifyRistrujSeDisabled();
    }

    @When("user enter registration data")
    public void userEnterRegistrationData() {
        new RegistartionPage(driver).registration(data.get("randomTypeYesNo"),data.get("nameUsername"), data.get("email"),data.get("password"),data.get("passwordConfirm"), randomName, randomEmail);
    }

    @Then("user should be verified registration action")
    public void userShouldBeVerifiedRegistrationAction() throws InterruptedException {
        new RegistartionPage(driver).verifyRegistrationAction(data.get("verificationType"),randomName ,data.get("expectedMessage2"));
    }

    @Then("user should be verified that registryj se button is disabled")
    public void userShouldBeVerifiedThatRegistryjSeButtonIsDisabled() {
        new RegistartionPage(driver).verifyRistrujSeDisabled();
    }

    @And("user check prihvatam checkbox")
    public void userCheckPrihvatamCheckbox() {
        new RegistartionPage(driver).checkPrihvatam();
    }

    @Then("user should be verified that registryj se button is enabled")
    public void userShouldBeVerifiedThatRegistryjSeButtonIsEnabled() {
        new RegistartionPage(driver).verifyRegistrujSeEnabled();
    }

    @And("user click pretraga filter")
    public void userClickPretragaFilter(){
        new GeneralPage(driver).applyFilterDetaljnaPretraga(data.get("runflat"),data.get("optereenje"),data.get("buka"),data.get("indeksBrzine"),data.get("potrosnja"),data.get("prijanjanje"));
    }

    @And("user clicks main menu title")
    public void userClicksMainMenuTitle() throws InterruptedException {
        new GeneralPage(driver).selectMainMenuTitle(data.get("menuTitle"));
    }

    @And("user clicks main menu sub title")
    public void userClicksMainMenuSubTitle() {
        new GeneralPage(driver).clickMainMenuSubItem(data.get("menuSubTitle"));
    }

    @Then("user should be verify chosen elements")
    public void userShouldBeVerifyChosenElements() {
        new GeneralPage(driver).verifyChosenTitleOfEelement(data.get("actuallTitle"));
    }

    @And("user clicks main menu subsub title")
    public void userClicksMainMenuSubsubTitle() {
        new GeneralPage(driver).clickMainMenuSubSubItem(data.get("menuSubSubTitle"));
    }

    @And("user clicks pretraga guma filter")
    public void userClicksPretragaGumaFilter() throws InterruptedException {
        new GeneralPage(driver).applyFilterPretragaGuma(data.get("vrstaVozila"),data.get("sezona"),data.get("dimenzije"),data.get("proizvodjac"));
    }

    @And("user clicks detaljan pretraga filter")
    public void userClicksDetaljanPretragaFilter() throws InterruptedException {
        new GeneralPage(driver).applyFilterDetaljnaPretraga(data.get("runflat"),data.get("opterecenje"),data.get("buka"),data.get("indeksBrzine"),data.get("potrosnja"),data.get("prijanjanje"));
    }

    @When("user clicks primeni filter button")
    public void userClicksPrimeniFilterButton() {
        new GeneralPage(driver).clickPrimeniFiltereButton();
    }

    @Then("user should verify filtered values")
    public void userShouldVerifyFilteredValues() throws InterruptedException {
        new GeneralPage(driver).checkFilteredItems(new String[]{data.get("actuallFiltered1"), data.get("actuallFiltered2"), data.get("actuallFiltered3"), data.get("actuallFiltered4"), data.get("actuallFiltered5"),
                data.get("actuallFiltered6"), data.get("actuallFiltered7"), data.get("actuallFiltered8"), data.get("actuallFiltered9"), data.get("actuallFiltered10")});
    }

    @Then("user should verify negative toast message")
    public void userShouldVerifyNegativeToastMessage() {
        new GeneralPage(driver).verifyNegativeMessage(data.get("toastMessage"));
    }

    @And("user adds tires in the shopping basket")
    public void userAddsTiresInTheShoppingBasket() {
        new ShopingItemlPage(driver).addItemShoppingBasket();
    }

    @And("user clicks dodaj button")
    public void userClicksDodajButton() {
        new ShopingItemlPage(driver).clickDodajButton();
    }

    @And("user clicks back button")
    public void userClicksBackButton() {
        new ShopingItemlPage(driver).goBack();
    }

    @Then("user should verify negative toast message II")
    public void userShouldVerifyNegativeToastMessageII() throws InterruptedException {
        new GeneralPage(driver).verifyNegativeMessageII(data.get("toastMessage"));
    }

    @And("user adds more items in the shopping basket")
    public void userAddsMoreItemsInTheShoppingBasket() {
        new ShopingItemlPage(driver).addMoreItemsInTheBasket(data.get("numItems"));

    }

    @Then("user should be verify number of items in the basket")
    public void userShouldBeVerifyNumberOfItemsInTheBasket() throws InterruptedException {
        new ShopingItemlPage(driver).verifyNumberOfItemsInTheBasket(data.get("numItems"));
    }

    @Then("user delete all items from the basket")
    public void userDeleteAllItemsFromTheBasket() throws InterruptedException {
        new ShopingItemlPage(driver).deleteAllCheckLists();
    }

    @And("user clicks korpa button")
    public void userClicksKorpaButton() {
        new ShopingItemlPage(driver).enterKorpa();
    }
}
