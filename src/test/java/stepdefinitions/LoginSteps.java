package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;
import java.time.Duration;
import java.util.logging.Logger;
import utils.ConfigReader;
import locators.ReportPageLocator;

public class LoginSteps extends BrowserActions {

    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());

    @Given("user is on the Login page")
    public void user_is_on_the_Login_page() {
        startBrowser();
        logger.info("Browser started and opening URL.");
//        openUrl("https://dev.contractzy.io/");
        openUrl(ConfigReader.getProperty("url"));
    }

    @When("user enters valid username and password")
    public void user_enters_valid_username_and_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME));
//        usernameField.sendKeys("prajot@thelegalcapsule.com");
        usernameField.sendKeys(ConfigReader.getProperty("username"));
        logger.info("Entered username.");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD));
//        passwordField.sendKeys("admin");
        passwordField.sendKeys(ConfigReader.getProperty("password"));
        logger.info("Entered password.");
    }

    @When("user enters invalid username and password")
    public void user_enters_invalid_username_and_password() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.INVALID_USERNAME));
        usernameField.sendKeys(ConfigReader.getProperty("in_username"));
        logger.info("Entered username.");

        WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.INVALID_PASSWORD));
        passwordField.sendKeys(ConfigReader.getProperty("in_password"));
        logger.info("Entered password.");
    }

    @And("clicks on the login button")
    public void clicks_on_the_login_button() {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement loginButton = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
        loginButton.click();
        logger.info("Clicked login button.");
    }

    @Then("user is navigated to the home page")
    public void user_is_navigated_to_the_home_page() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            wait.until(ExpectedConditions.urlToBe("url_1"));
            String actualUrl = driver.getCurrentUrl();
            logger.info("Current URL: " + actualUrl);
            Assert.assertEquals(actualUrl, "url_1", "User not navigated to the home page after login.");
            takeScreenshot("login_success");
            closeBrowser();
            logger.info("Browser closed.");
        } catch (Exception e) {
            e.printStackTrace();
            logger.info("Exception occured in user_is_navigated_to_the_home_page()");
           // closeBrowser();
        }
    }

    @Then("user should see an error message")
    public void user_should_see_an_error_message() {
        try {

            Thread.sleep(4000); // 2 seconds

            WebElement errorMessage = driver.findElement(By.xpath("//span[@class='text-danger']"));
            Assert.assertTrue(errorMessage.isDisplayed(), "Error message is not displayed.");
            String expectedErrorMessage = "Invalid credentials. Please try again.";
            String actualErrorMessage = errorMessage.getText().trim();
            Assert.assertEquals(actualErrorMessage, expectedErrorMessage, "Error message text doesn't match expected.");
            takeScreenshot("login_error");
            //closeBrowser();
            //logger.info("Browser closed.");
        } catch (AssertionError e) {
            // Handle assertion failure
            String errorMessage = "Assertion failed: " + e.getMessage();
            takeScreenshot("login_error_assertion_failed"); // Capture screenshot on assertion failure
            Assert.fail(errorMessage); // Fail the test explicitly
        } catch (Exception e) {
            // Handle other exceptions
            e.printStackTrace();
            takeScreenshot("login_error_exception"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage()); // Fail the test explicitly
        }
        finally {

            //takeScreenshot("login_error"); // Capture screenshot on failure
           // closeBrowser();
        }
    }

}
