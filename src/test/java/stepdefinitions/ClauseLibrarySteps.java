package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;
import utils.ConfigReader;
import locators.ReportPageLocator;

import java.time.Duration;
import java.util.logging.Logger;

public class ClauseLibrarySteps extends BrowserActions {

    private static final Logger logger = Logger.getLogger(LoginSteps.class.getName());

    @Given("user is already logged in")
    public void userAlreadyLoggedIn(){
        try {
            startBrowser();
            logger.info("Browser started and opening URL.");
            openUrl(ConfigReader.getProperty("url"));
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_USERNAME));
//            usernameField.sendKeys("prajot@thelegalcapsule.com");
            usernameField.sendKeys(ConfigReader.getProperty("username"));
            logger.info("Entered username.");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.LOGIN_PASSWORD));
//            passwordField.sendKeys("admin");
            passwordField.sendKeys(ConfigReader.getProperty("password"));
            logger.info("Entered password.");

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait1.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.LOGIN_BUTTON));
            loginButton.click();
            logger.info("Clicked login button.");
        } catch (Exception e) {
            logger.info("Issue while log in : ClauseLibrarySteps Class");
            takeScreenshot("Login_failed_Clause_Library"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @When("user clicks on clause library")
    public void clickOnLibrary(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            // Locate the hyperlink using XPath
            WebElement clauseLibraryLink = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CLAUSE_LIBRARY));
            // Click on the hyperlink
            clauseLibraryLink.click();
            logger.info("Clicked on the Clause Library");
        } catch (Exception e) {
            logger.info("Issue while clicking on clause library : ClauseLibrarySteps Class");
            takeScreenshot("Click_failed_Clause_Library"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @When("clicks on the custom category")
    public void clickOnCustomLibrary(){
        try {

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement customCategory = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CUSTOM_CATEGORY));

            customCategory.click();
            logger.info("Clicked on the Custom Category");
        } catch (Exception e) {
            logger.info("Issue while Click on Custom Category : ClauseLibrarySteps Class");
            takeScreenshot("Failed to click on the Custom Category"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @When("click on add category button")
    public void clickOnAddCategories(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            WebElement addCategoryLink = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.ADD_CATEGORY_BUTTON));

            addCategoryLink.click();
            logger.info("Clicked on the Add Category");
        } catch (Exception e) {
            logger.info("Issue while Clicking on Add Category: ClauseLibrarySteps Class");
            takeScreenshot("Add_Category_failed"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @When("enter the category type")
    public void enterCategoryTypes(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement categoryInput = wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.CATEGORY_TYPE));
            categoryInput.clear();
            categoryInput.sendKeys("Test Automation");
            logger.info("Entered the text");
        } catch (Exception e) {
            logger.info("Issue while adding the category text : ClauseLibrarySteps Class");
            takeScreenshot("Category_text_failed"); // Capture screenshot on other exceptions
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }

    @When("click on create button")
    public void createCategory(){
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement createButton = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CREATE_BUTTON));
            createButton.click();
            logger.info("Category Created");
            // WebElement successMessage = driver.findElement(By.xpath("//div[@aria-label='Clause category was created.']"));
            //logger.info("1");
            //Assert.assertTrue(successMessage.isDisplayed(), "Success message is not displayed.");
            //logger.info("2");
           // String expectedSuccessMessage = "Clause category was created.";
            //String actualSuccessMessage = successMessage.getText().trim();
            //Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message text doesn't match expected.");
            //takeScreenshot("Category_Created");
        } catch (AssertionError e) {
        // Handle assertion failure
        String errorMessage = "Assertion failed: " + e.getMessage();
        takeScreenshot("Category_Creation_failed"); // Capture screenshot on assertion failure
        Assert.fail(errorMessage); // Fail the test explicitly
    } catch (Exception e) {
        //Handle other exceptions
        e.printStackTrace();
        takeScreenshot("Category_Creation"); // Capture screenshot on other exceptions
        Assert.fail("Exception occurred: " + e.getMessage()); // Fail the test explicitly
    } finally {
            closeBrowser();
        }

    }
}
