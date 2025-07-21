package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import locators.ReportPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.BrowserActions;
import org.openqa.selenium.*;
import utils.ConfigReader;

import java.time.Duration;
import java.util.logging.Logger;

public class AISteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(AISteps.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(AISteps.class);

    @Given("user is already logged in")
    public void userLoggedIn(){
        try{
            startBrowser();
            logger.info("Browser started and opening url");
            openUrl(ConfigReader.getProperty("url"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME));
            usernameField.sendKeys(ConfigReader.getProperty("username"));
            logger.info("Entered username");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD));
            passwordField.sendKeys((ConfigReader.getProperty("password")));
            logger.info("Entered password");

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement buttonField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_BUTTON));
            buttonField.click();
            logger.info("button was clicked");
        }catch (Exception e){
            logger.info("Issue while log in: AISteps class");
            takeScreenshot("Login_failed_AI");
            Assert.fail("Exception occurred: " + e.getMessage());

        }
    }

    @When("the user navigates to the AI module")
    public void ai(){
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//        WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'menu-title') and text()='AI']")));
//        view.click();
        try {
            startBrowser();
        }catch (Exception e){

        }
    }

}
