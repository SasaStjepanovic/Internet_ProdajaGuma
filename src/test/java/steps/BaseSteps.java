package steps;

import excel.ExcelSupport;
import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.testng.Reporter;
import pages_sale.LoginLogoutPage;
import tests_sale.BaseTest;

import java.io.IOException;
import java.util.Map;

public class BaseSteps extends BaseTest {

    Map<String, String> data;

    String browser = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("browser");
    String env = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("env");
    String wait = Reporter.getCurrentTestResult().getTestContext().getCurrentXmlTest().getParameter("wait");

    @Before
    public void setup() throws Exception {
        init(browser, wait);
        openInternetProdajaGumaApp(env);
    }

    @After
    public void tearDown() throws IOException {
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

    @And("user enters email and password for login")
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
}
