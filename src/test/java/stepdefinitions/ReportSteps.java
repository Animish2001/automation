package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import locators.ReportPageLocator;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;

import java.time.Duration;
import java.util.logging.Logger;

import utils.ConfigReader;

public class ReportSteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(ReportSteps.class.getName());

    @Given("user logged in")
    public void user_is_on_the_login_page() {

        try {
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
        } catch (Exception e) {
            logger.info("Issue while log in : ReportSteps class");
            takeScreenshot("Login_failed_Report_Generation");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }

    @And("clicks on the reports")
    public void user_clicks_on_report() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement report = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.REPORT));
            report.click();
            logger.info("Clicked on reports.");
        } catch (Exception e) {
            logger.info("Issue while clicking on reports: ReportSteps class");
            takeScreenshot("Failed to click on reports");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("clicks on custom reports")
    public void custom_reports() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement custom_report = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.CUSTOM_REPORT));
            custom_report.click();
            logger.info("Clicked on custom reports.");
        } catch (Exception e) {
            logger.info("Issue while clicking on custom reports: ReportSteps class");
            takeScreenshot("Failed to click on custom reports");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("enters a report name")
    public void report_name() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement report_name = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.REPORT_NAME));
            report_name.sendKeys("Automated report");
            logger.info("Entered a report name.");
        } catch (Exception e) {
            logger.info("Issue while entering report name: ReportSteps class");
            takeScreenshot("Failed to enter the report name");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("selects the type of report")
    public void report_type() {
        try {
            driver.findElement(ReportPageLocator.REPORT_TYPE).click();
            logger.info("Clicked on contract radio button");
        } catch (Exception e) {
            logger.info("Issue while selecting type of report: ReportSteps class");
            takeScreenshot("Failed to select type of report");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("selects filters")
    public void select_filter() {
        try {
            driver.findElement(ReportPageLocator.FILTER).click();
            logger.info("Selected departments");

            driver.findElement(ReportPageLocator.OPTION).click();
            logger.info("Clicked on the option ");
            driver.findElement(ReportPageLocator.OPTION_1).click();
            logger.info("Clicked on the IT option ");
            driver.findElement(ReportPageLocator.OPTION_2).click();
            logger.info("Clicked on the user option ");
            driver.findElement(ReportPageLocator.OPTION_3).click();
            logger.info("Clicked on Amrita test option ");
            driver.findElement(ReportPageLocator.OPTION_4).click();
            logger.info("Selected Priority");
            driver.findElement(ReportPageLocator.OPTION_5).click();
            logger.info("Clicked on the low option ");
            driver.findElement(ReportPageLocator.OPTION_6).click();
            logger.info("Clicked on the Normal option ");
            driver.findElement(ReportPageLocator.OPTION_7).click();
            logger.info("Selected Status");
            driver.findElement(ReportPageLocator.OPTION_8).click();
            logger.info("selected Completed status ");
            // Open the calendar widget
            driver.findElement(ReportPageLocator.CALENDAR).click();
        } catch (Exception e) {
            logger.info("Issue while selecting filters: ReportSteps class");
            takeScreenshot("Failed to select filters");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }

    @And("clicks on the 'Generate contract report' button")
    public void generate_report() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(ReportPageLocator.GENERATE_REPORT).click();
            logger.info("Clicked on generate button");
            WebElement successMessage = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.SUCCESS_MESSAGE));
            Assert.assertTrue(successMessage.isDisplayed(),"Report will be available in some time once generated.");
            String expectedSuccessMessage = "Report will be available in some time once generated.";
            String actualSuccessMessage = successMessage.getText().trim();
            Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message matches as expected.");
            takeScreenshot("Report Generated");
        } catch (Exception e) {
            logger.info("Issue while clicking button: ReportSteps class");
            takeScreenshot("Failed to generate report");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }

    @And("clicks on CRM")
    public void crm() {
        try{
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            driver.findElement(ReportPageLocator.CRM).click();
            logger.info("Clicked on crm radio button");

            driver.findElement(ReportPageLocator.CRM_1).click();
            logger.info("Selected Requestor");

            //note this xpath might change because in future text might change
            driver.findElement(ReportPageLocator.CRM_2).click();
            logger.info("Selected Requestor");
        }catch (Exception e){
            logger.info("Issue while selecting radiobutton: ReportSteps class");
            takeScreenshot("Failed to select crm radiobutton");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}






