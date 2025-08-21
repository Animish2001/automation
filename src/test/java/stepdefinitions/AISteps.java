package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import locators.ReportPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import org.testng.Assert;
import utils.BrowserActions;
import org.openqa.selenium.*;
import utils.ConfigReader;

import java.nio.file.Paths;
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
            WebElement view = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.AI_NAV));
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
            WebElement drpdwn = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.DRP_DWN));
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
            WebElement createnew = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CREATE_NEW));
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
            WebElement guidetle = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.GUIDE_TITLE));
            guidetle.click();
            guidetle.sendKeys("test");
            logger.info("Clicked on guide title");
        }catch (Exception e){
            logger.info("Issue while CLicking on guide title");
            takeScreenshot("Failed to click on guide title");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

//    @Then("clicks on agreement type")
//    public void clickOnAgreementType(){
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement agreetype = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@aria-autocomplete='list' and @autocomplete='ae44aae295f4']")));
//            agreetype.click();
//            logger.info("Clicked on agreement type");
//        }catch (Exception e){
//            logger.info("Issue while clicking on agreement type");
//            takeScreenshot("Failed to click on agreement type");
//            Assert.fail("Exception occurred: " + e.getMessage());
//        }
//    }

    @Then("clicks on title")
    public void clickOnTitle(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement title = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='title' and contains(@class, 'form-control') and @placeholder='Enter title']")));
            title.click();
            title.sendKeys("test");
            logger.info("Clicked on title");
        }catch (Exception e){
            logger.info("Issue while clicking on title");
            takeScreenshot(("Failed to check on title"));
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Then("clicks on severity")
    public void clickOnSeverity(){
        WebElement severityDropdown = driver.findElement(By.xpath("//select[@formcontrolname='severity']"));
        Select select = new Select(severityDropdown);
        select.selectByVisibleText("High");
        select.selectByValue("high");
    }

    @Then("clicks on guideline")
    public void clickOnGuideline(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement guideline = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//textarea[@formcontrolname='guideline']")));
            guideline.click();
            guideline.sendKeys("Enter the required guideline");
            logger.info("clicked on guideline");
        }catch (Exception e){
            logger.info("Issue while clicking on guideline");
            takeScreenshot("Failed to check on guideline");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

//    @Then("clicks on add field")
//    public void clickOnAdd(){
//        try {
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement add = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(@class, 'choose-file') and contains(text(), 'Add')]")));
//            add.click();
//        }catch (Exception e){
//            logger.info("Issue while clicking on add field");
//            takeScreenshot("Failed to add new field");
//            Assert.fail("Exception occurred: " + e.getMessage());
//        }
//    }

    @Then("clicks on submit")
    public void clickOnSubmit(){
        try {
            WebDriverWait wait= new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement submit = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[text()='Submit' and contains(@class, 'btn-primary')]")));
            submit.click();
        }catch (Exception e){
            logger.info("Issue while clicking on submit button");
            takeScreenshot("Failed to click on submit");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @Then("clicks on previous arrow")
    public void clickOnPrev(){
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement previous_page = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'contract') and contains(normalize-space(), 'Create Guidebook')]")));
            previous_page.click();
        }catch (Exception e){
            logger.info("Issue while clicking on previous arrow");
            takeScreenshot("Failed to click on previous page");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

//    @Then("clicks on upload")
//    public void clickOnUpload(){
//
//            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//            WebElement upload = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//a[contains(@class, 'dropdown-item') and normalize-space(text())='Upload']")));
//            upload.click();
//            WebElement upload_1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//label[contains(@class, 'active-text') and normalize-space(text())='Browse']")));
//            upload_1.click();
//            logger.info("File xpath is found");
//
//        String file;
//        if (System.getProperty("os.name").toLowerCase().contains("win")) {
//                //take path
//                file = ConfigReader.getProperty("uploadFileWindows_1");
//            }
//            else {
//                file = Paths.get(System.getProperty("user.home"), "Downloads", "sss.pdf").toString();
//            }
//            upload_1.sendKeys(file);
//            logger.info("File uploaded successfully");
////            driver.findElement(By.id("stampUpload")).sendKeys(file);
//    }

}

