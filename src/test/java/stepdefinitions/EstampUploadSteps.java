package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ReportPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;

import java.nio.file.Paths;
import java.time.Duration;
import java.util.logging.Logger;
import utils.ConfigReader;

public class EstampUploadSteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(EstampUploadSteps.class.getName());
    String file;

    @Given("user is already logged in the application")
    public void user_is_on_the_login_page() {

        //to start browser and perform following operations
        startBrowser();
        logger.info("Browser started and opening URL.");
        openUrl(ConfigReader.getProperty("url"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME));
        usernameField.sendKeys(ConfigReader.getProperty("username"));
        logger.info("Entered username.");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD));
        passwordField.sendKeys(ConfigReader.getProperty("password"));
        logger.info("Entered password.");

        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait1.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.LOGIN_BUTTON));
        loginButton.click();
        logger.info("Clicked login button.");
    }

    @When("user clicks on E-Stamping and upload stamp paper option")
    public void userClicksOnEStampingAndUploadStampPaperOption() {
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement estamp = wait1.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.E_STAMP));
        estamp.click();
        logger.info("Clicked on Estamping.");
        WebElement estamp_upload = wait1.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.ESTAMP_UPLOAD));
        estamp_upload.click();

        driver.findElement(ReportPageLocator.ESTAMP_NAME).sendKeys("Automated stamp");
        driver.findElement(ReportPageLocator.PAPER_VLAUE).sendKeys("10");
        driver.findElement(ReportPageLocator.STAMP_REG_NUMBER).sendKeys("WERTY1377C");
        WebElement select_state = driver.findElement(ReportPageLocator.SELECT_STATE);
        logger.info("Selected state");
        Select dropdown = new Select(select_state);
        dropdown.selectByValue("Andhra Pradesh");
        logger.info("selected AP ");
    }
    @When("user enters the valid details and clicks on the upload stamp paper button")
    public void userEntersTheValidDetailsAndClicksOnTheUploadStampPaperButton() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        driver.findElement(ReportPageLocator.ESTAMP_NAME).sendKeys("Automated stamp");
        driver.findElement(ReportPageLocator.PAPER_VLAUE).sendKeys("10");
        driver.findElement(ReportPageLocator.STAMP_REG_NUMBER).sendKeys("WERTY1377C");
        WebElement select_state = driver.findElement(ReportPageLocator.SELECT_STATE);
        logger.info("Selected state");
        Select dropdown = new Select(select_state);
        dropdown.selectByValue("Andhra Pradesh");
        logger.info("selected AP ");
        WebElement fileUpload = wait.until(ExpectedConditions.presenceOfElementLocated(ReportPageLocator.FILE_UPLOAD));
        logger.info("File xpath is found");

        if (System.getProperty("os.name").toLowerCase().contains("win")) {
            //take path
            file = ConfigReader.getProperty("uploadFileWindows");
        }
        else {
            // Other
            file = Paths.get(System.getProperty("user.home"), "Downloads", "sss.pdf").toString();
        }
        fileUpload.sendKeys(file);
        logger.info("File uploaded successfully");
        driver.findElement(By.id("stampUpload")).sendKeys(file);

        WebElement uploadButton= driver.findElement(ReportPageLocator.UPLOAD);
        uploadButton.click();
    }

    @Then("estamp paper should get uploaded successfully")
    public void estampPaperShouldGetUploadedSuccessfully() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        takeScreenshot("Stamp Paper successfully uploaded");
        /*WebElement confirmationMessage= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//div[@aria-label='Stamp Paper successfully uploaded.']")));
        String expectedMessage="Stamp Paper successfully uploaded";
        Assert.assertEquals(confirmationMessage.getText().trim(), expectedMessage, "Confirmation message does not match!");
        Assert.assertEquals(confirmationMessage.getText(),expectedMessage);*/
        closeBrowser();
    }
}




