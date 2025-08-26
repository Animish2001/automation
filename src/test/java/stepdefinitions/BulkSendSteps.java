package stepdefinitions;

import io.cucumber.java.en.Given;
import locators.ReportPageLocator;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import sun.tools.jinfo.JInfo;
import utils.BrowserActions;
import utils.ConfigReader;

import java.time.Duration;
import java.util.logging.Logger;

public class BulkSendSteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(BulkSendSteps.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BulkSendSteps.class);

    private WebDriverWait wait;
    public WebDriver getDriver(){return driver;}

    @Given("user logged in site")
    public void LoggedIn(){
        try {
            startBrowser();
            logger.info("Browser started and opening url");
            openUrl(ConfigReader.getProperty("url"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME));
            usernameField.sendKeys(ConfigReader.getProperty("username"));
            logger.info("Entered username");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD));
            usernameField.sendKeys(ConfigReader.getProperty("password"));
            logger.info("Entered password");

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement btnField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_BUTTON));
            btnField.click();
            logger.info("button was clicked");
        }catch (Exception e){
            logger.info("Issue while log in: BulkSendSteps class");
            takeScreenshot("Login_failed_bulksend");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}
