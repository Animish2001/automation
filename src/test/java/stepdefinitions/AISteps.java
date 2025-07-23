package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
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

    @Given("user is already logged in site")
    public void LoggedIn(){
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
//            startBrowser();
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement view = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[contains(@class, 'menu-title') and text()='AI']")));
            view.click();
            logger.info("Clicked on ai module");
        }catch (Exception e){
            logger.info("Issue while Click on ai module: AISteps Class");
            takeScreenshot("Failed to click on the ai module");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Then("clicks on dropdown")
    public void clickOnDropdwn(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement drpdwn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(@class, 'dropdown-toggle') and contains(@class, 'btn-shadow')]/img[@src='assets/icons/Icon_addguidebook_Black_Unfilled.svg']/parent::button")));
            drpdwn.click();
            logger.info("Clicked on dropdown");
        }catch (Exception e){
            logger.info("Issue while CLick on dropdown: AISteps Class");
            takeScreenshot("Failed to click on the dropdown");
            Assert.fail("Exception occurred: " + e.getMessage());

        }
    }

    @Then("clicks on Create New")
    public void clickOnCreateNew(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement createnew = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//a[contains(@class, 'dropdown-item') and contains(text(), 'Create New')]")));
            createnew.click();
            logger.info("Clicked on create new");
        }catch (Exception e){
            logger.info("Issue while Click on create new");
            takeScreenshot("Failed to click on create new");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Then("clicks on guide title")
    public void clickOnGuideTitle(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement guidetle = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//input[@formcontrolname='name']")));
            guidetle.click();
            guidetle.sendKeys("test");
            logger.info("Clicked on guide title");
        }catch (Exception e){
            logger.info("Issue while CLicking on guide title");
            takeScreenshot("Failed to click on guide title");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Then("clicks on agreement type")
    public void clickOnAgreementType(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement agreetype = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//ng-select[@formcontrolname='agreementType']//input[   @aria-autocomplete='list' and    contains(@autocomplete, 'a6a5729c1b71') and    @autocapitalize='off' ]")));
            agreetype.click();
            logger.info("Clicked on agreement type");
        }catch (Exception e){
            logger.info("Issue while clicking on agreement type");
            takeScreenshot("Failed to click on agreement type");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

}
