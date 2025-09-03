package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import utils.BrowserActions;

import java.time.Duration;
import java.util.logging.Logger;

public class UserManagementSteps extends BrowserActions {
    private static final Logger logger =Logger.getLogger(UserManagementSteps.class.getName());

    @Given("user logged in for the application")
    public void user_is_on_the_login_page(){

        try {
            startBrowser();
            logger.info("Browser started and opening URL.");
            openUrl("https://test.legalcapsule.app/");

            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement usernameField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputEmail']")));
            usernameField.sendKeys("prajot@thelegalcapsule.com");
            logger.info("Entered username.");

            WebElement passwordField = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='inputPassword']")));
            passwordField.sendKeys("admin");
            logger.info("Entered password.");

            WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement loginButton = wait1.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[text()='Login']")));
            loginButton.click();
            logger.info("Clicked login button.");
        } catch (Exception e) {
            logger.info("Issue while log in : UserManagementSteps class");
            takeScreenshot("Login_failed_User_Management");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }
    @And("clicks on the user_management")
    public void user_management(){
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement user_management= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//span[@class='menu-title ml-3 mr-2 navLinkGenis animated fadeInRight'][normalize-space()='User Management']")));
            user_management.click();
            logger.info("Clicked on user management.");
        } catch (Exception e) {
            logger.info("Issue while clicking on user management: UserManagementSteps class");
            takeScreenshot("Failed to click on User Management");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }
    @And("enters full name, email address, phone no.,department, designation, user group, region")
    public void adding_details() {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement add_user = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//a[@class='btn modal-button ng-star-inserted']//*[name()='svg']")));
            add_user.click();
            logger.info("Adding user");
            WebElement add_name = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='text']")));
            add_name.sendKeys("User_trial");
            logger.info("Adding name");
            WebElement add_email = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='email']")));
            add_email.sendKeys("automateduseradd5@gmail.com");
            logger.info("Adding email");
            WebElement add_phone = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@type='number']")));
            add_phone.sendKeys("8954567865");
            logger.info("Adding phoneno.");
            WebElement select_dept = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@placeholder='Select days']")));
            logger.info("Selected department");
            Select dropdown = new Select(select_dept);
            // Select the option by value
            dropdown.selectByValue("1a618490d1f048d9b13f7e68830fa75c");
            logger.info("selected IT dept ");
            WebElement select_designation = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='designationID']")));
            logger.info("Selected designation");
            Select dropdown1 = new Select(select_designation);
            dropdown1.selectByValue("75b9a9e6d8734aefadf8ea2a6193c1f9");
            logger.info("selected designation tester ");
            WebElement select_region = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//select[@formcontrolname='region_id']")));
            logger.info("Selected region");
            Select dropdown2 = new Select(select_region);
            dropdown2.selectByValue("3385fee430214f0cb23ef5d3ea4a0e2f");
            logger.info("selected region goa");
        } catch (Exception e) {
            logger.info("Issue while adding details for user: UserManagementSteps class");
            takeScreenshot("Failed to add the details");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @And("set user privilege")
    public void setUserPrivilege() {
        try {
            driver.findElement(By.xpath("//input[@id='adminRight']")).click();
            logger.info("selecting the user rights");
        } catch (Exception e) {
            logger.info("Issue while adding user privileges: UserManagementSteps class");
            takeScreenshot("Failed to select user rights");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @Then("clicks on create button")
    public void clicksOnCreateButton() {
        try {
            driver.findElement(By.xpath("//button[normalize-space()='Create']")).click();
            logger.info("Clicked on create button");
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
            WebElement successMessage = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@aria-label='user created successfully']")));
            Assert.assertTrue(successMessage.isDisplayed(),"user created successfully");
            String expectedSuccessMessage = "user created successfully";
            String actualSuccessMessage = successMessage.getText().trim();
            Assert.assertEquals(actualSuccessMessage, expectedSuccessMessage, "Success message matches as expected.");
            takeScreenshot("User Added");
        } catch (Exception e) {
            logger.info("Issue while creating new user : UserManagementSteps class");
            takeScreenshot("Failed to create new user");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
}

