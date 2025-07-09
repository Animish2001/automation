package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;
import utils.ConfigReader;

import java.nio.file.Paths;

import java.time.Duration;
import java.util.logging.Logger;

public class LegacyContractStep extends BrowserActions {
    private static final Logger logger =Logger.getLogger(CreateContractSteps.class.getName());
    String filePath;

    @Given("user logged in the app")
    public void user_login()
    {
        try {
            startBrowser();
            logger.info("Browser started and opening URL.");
//            openUrl("https://test.legalcapsule.app/");
            openUrl(ConfigReader.getProperty("url"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmail']")));
//            usernameField.sendKeys("amrita.tamte@contractzy.io");
            usernameField.sendKeys(ConfigReader.getProperty("username"));
            logger.info("Entered username.");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")));
//            passwordField.sendKeys("Amrita@1234");
            passwordField.sendKeys(ConfigReader.getProperty("password"));
            logger.info("Entered password.");

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
            loginButton.click();
            logger.info("Clicked login button.");
        } catch (Exception e) {
            logger.info("Issue while log in : LegacyContractSteps class");
            takeScreenshot("Login_failed_Legacy_Contract");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @And("clicks on the legacy contract")
    public void legacy()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement legacy= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[contains(text(),'Legacy-Contract')]")));
            legacy.click();
            logger.info("Clicked on legacy contract");
        } catch (Exception e) {
            logger.info("Issue while clicking on Legacy contracts : LegacyContractSteps class");
            takeScreenshot("Failed to click on legacy contracts");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @And("clicks on single upload")
    public void singleUpload()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(1));
            WebElement singleUpload= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@id='ngb-nav-6']")));
            singleUpload.click();
            logger.info("Clicked on Single upload");
        } catch (Exception e) {
            logger.info("Issue while clicking on single upload : LegacyContractSteps class");
            takeScreenshot("Failed to click on single upload");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @And("enters the details, clicks on the upload button")
    public void add_details()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement add_details= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[contains(@class,'style-2 form-control')]")));
            add_details.sendKeys("Test automated contract upload");
            logger.info("Entered the contract name");
            WebElement priority = driver.findElement(By.id("medium"));
            priority.click();
            logger.info("Selected Priority");

            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("fileUpload")));
            ((JavascriptExecutor) driver).executeScript("arguments[0].style.display='block';", fileInput);

            if (System.getProperty("os.name").toLowerCase().contains("win")) {
                // Windows path
                filePath = "C:\\Users\\Animish\\Downloads\\stamp.pdf";
            } else {
                // Other
                filePath = Paths.get(System.getProperty("user.home"), "Downloads", "sss.pdf").toString();
            }
            fileInput.sendKeys(filePath);
            logger.info("File uploaded successfully");
            driver.findElement(By.xpath("//img[@src='assets/icons/plus.svg']")).click();

            //Add Details
            WebElement partyName = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='partyName']")));
            partyName.sendKeys("test123");

            //Party Email
            WebElement partyEmail = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@formcontrolname='partyEmail']")));
            partyEmail.sendKeys("amritaaccfortest@gmail.com");

            //Select Signature
            WebElement signatureTypeSelect = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='signatureType']")));
            Select select = new Select(signatureTypeSelect);
            select.selectByVisibleText("Virtual Signature");

            //Click on the Upload button
            WebElement uploadButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[contains(text(),'Upload')]")));
            uploadButton.click();
            logger.info("Clicked on upload button");


        } catch (Exception e) {
            //throw new RuntimeException(e);
            System.out.println("exception"+e.getMessage());
        }

    }
}
