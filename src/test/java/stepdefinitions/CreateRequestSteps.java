//package stepdefinitions;
//
//import io.cucumber.java.en.Given;
//import locators.ReportPageLocator;
//import org.openqa.selenium.WebDriver;
//import org.openqa.selenium.WebElement;
//import org.openqa.selenium.support.ui.ExpectedConditions;
//import org.openqa.selenium.support.ui.WebDriverWait;
//import org.slf4j.LoggerFactory;
//import org.testng.Assert;
//import utils.BrowserActions;
//import utils.ConfigReader;
//
//import java.time.Duration;
//import java.util.logging.Logger;
//
//public class CreateRequestSteps extends BrowserActions {
//    private static final Logger logger = Logger.getLogger(CreateRequestSteps.class.getName());
////    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CreateRequestSteps.class);
//
//    // At class level:
//    private WebDriver driver;
//    private WebDriverWait wait;
//
//    @Given("user is already logged in site")
//    public void LoggedIn() {
//        try {
//            startBrowser(); // make sure this sets 'driver'
//            logger.info("browser started and opening url");
//            openUrl(ConfigReader.getProperty("url"));
//
//            wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//
//            WebElement usernameField = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME)
//            );
//            usernameField.sendKeys(ConfigReader.getProperty("username"));
//            logger.info("entered username");
//
//            WebElement passField = wait.until(
//                    ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD)
//            );
//            passField.sendKeys(ConfigReader.getProperty("password"));
//            logger.info("entered password");
//
//            WebElement btnFld = wait.until(
//                    ExpectedConditions.elementToBeClickable(ReportPageLocator.LOGIN_BUTTON)
//            );
//            btnFld.click();
//            logger.info("button was clicked");
//        } catch (Exception e) {
//            logger.log(Level.SEVERE, "issue while log in: CreateRequestSteps class", e);
//            takeScreenshot("Login_failed_create_request");
//            Assert.fail("Exception occurred: " + e.getMessage());
//        }
//    }
//
//
//}

package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import locators.ReportPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.BrowserActions;
import utils.ConfigReader;

import java.time.Duration;
import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateRequestSteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(CreateRequestSteps.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(CreateRequestSteps.class);

    private WebDriverWait wait;
    public WebDriver getDriver() {
        return driver;
    }

    @Given("user logged in site")
    public void LogIn() {
        try {
            startBrowser(); // ensure this initializes driver in BrowserActions
            logger.info("browser started and opening url");
            openUrl(ConfigReader.getProperty("url"));

            // use the driver from BrowserActions (avoid shadowing)
            WebDriver driver = getDriver();
            wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement usernameField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME)
            );
            usernameField.sendKeys(ConfigReader.getProperty("username"));
            logger.info("entered username");

            WebElement passField = wait.until(
                    ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD)
            );
            passField.sendKeys(ConfigReader.getProperty("password"));
            logger.info("entered password");

            WebElement btnFld = wait.until(
                    ExpectedConditions.elementToBeClickable(ReportPageLocator.LOGIN_BUTTON)
            );
            btnFld.click();
            logger.info("button was clicked");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "issue while log in: CreateRequestSteps class", e);
            takeScreenshot("Login_failed_create_request");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("click on create request")
    public void CreateReq(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement createreq = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CREATE_REQ));
            createreq.click();
            logger.info("clicked on create request");
        }catch (Exception e){
            logger.info("issue while click on create new request");
            takeScreenshot("failed to click on create new request");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("click on request contract button")
    public void ReqBtn(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement reqbtn = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.REQ_BTN));
            reqbtn.click();
            logger.info("clicked on request contract");
        } catch (Exception e) {
            logger.info("issue while clicking on request contract");
            takeScreenshot("failed to click on request contract");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @When("user fills all the details and clicks on submit")
    public void FillDts(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement reqeml = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.REQ_EML));
            reqeml.sendKeys("animish@contractzy.io");
            logger.info("clicked on request email");

            WebElement drp = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.DRP));
            drp.click();
        }catch (Exception e){
            logger.info("issue while clicking on request email");
            takeScreenshot("failed to click on request email");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}

