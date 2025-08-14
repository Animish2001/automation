package stepdefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import locators.ReportPageLocator;
import org.openqa.selenium.*;
import java.util.List;

import org.openqa.selenium.Point;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;

import org.openqa.selenium.support.ui.WebDriverWait;

import org.testng.Assert;
import utils.BrowserActions;
import utils.ConfigReader;


import java.awt.*;
import java.awt.event.InputEvent;
import java.time.Duration;

import java.util.logging.Level;
import java.util.logging.Logger;

public class CreateContractSteps extends BrowserActions {
    private static final Logger logger =Logger.getLogger(CreateContractSteps.class.getName());


    @Given("user is already logged in contractzy application")
    public void user_login()
    {
        try {
            startBrowser();
            logger.info("Browser started and opening URL.");
//            openUrl("https://dev.contractzy.io/");
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
            logger.info("Issue while log in : CreateContractSteps class");
            takeScreenshot("Login_failed_Create_Contract");
            Assert.fail("Exception occurred: " + e.getMessage());
        }

    }
    @And("clicks on create contract")
    public void contract_creation()
    {
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement create= wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.CREATE_CONTRACT));
            create.click();
            logger.info("Clicked on create contract");
        } catch (Exception e) {
            logger.info("Issue while clicking on create contract: CreateContractSteps class");
            takeScreenshot("Failed to click on Create contract");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }

    @And("clicks on pdf")
    public void pdf_creation(){
        try {
            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
            WebElement upload_pdf=wait.until(ExpectedConditions.visibilityOfElementLocated(ReportPageLocator.PDF_UPLOAD));
            upload_pdf.click();
            logger.info("Clicked on pdf");

            WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(
                    ReportPageLocator.FILE_INPUT));

            String filePath = ConfigReader.getProperty("uploadFileWindows");
            fileInput.sendKeys(filePath);
            logger.info("PDF file uploaded successfully");

            WebElement submitButton = wait.until(ExpectedConditions.elementToBeClickable(
                    ReportPageLocator.SUBMIT_BUTTON));

            submitButton.click();

        }catch (Exception e){
            logger.info("Issue while clicking on pdf: CreateContractSteps class");
            takeScreenshot("Failed to click on pdf: CreateContractSteps class");
            Assert.fail("Exception occurred: " + e.getMessage());
        }
    }
    @When("Enters all the details and clicks on the create button")
    public void add_details() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        By dlt = By.xpath("//img[   contains(concat(' ', normalize-space(@class), ' '), ' choose-file ')   and contains(concat(' ', normalize-space(@class), ' '), ' pos-top-7p ')]");
        List<WebElement> dlticns = wait.until(ExpectedConditions.presenceOfAllElementsLocatedBy(dlt));
        System.out.println("found " + dlticns.size() + " dlticns");

        for (int i =1;i<=dlticns.size();i++){
            By indexLocator = By.xpath("//img[   contains(concat(' ', normalize-space(@class), ' '), ' choose-file ')   and contains(concat(' ', normalize-space(@class), ' '), ' pos-top-7p ')]");
            try {
                WebElement icn = wait.until(ExpectedConditions.elementToBeClickable(indexLocator));
                icn.click();
                System.out.println("clicked delete icon #" + i);
            } catch (Exception e) {
                System.out.println("Could not click delete icon" + i + ": " + e.getMessage());
                throw new RuntimeException(e);
            }
        }
//        dlt.click();
        WebElement createBtn = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.CREATE_CONTRACT_1));
        createBtn.click();
//        System.out.println("Clicked on create contract");
//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
//        driver.findElement(By.xpath("//button[contains(@class, 'enable-div') and contains(., 'Create contract')]")).click();
//        logger.info("Clicked on Create contract button");
    }

    @Then("Add signatory")
    public void add_signatory() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
        WebElement addSign = wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.ADD_SIGN));
        addSign.click();
        Thread.sleep(2000);
        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement inputField = wait1.until(ExpectedConditions.elementToBeClickable(
                ReportPageLocator.INPUT_SIGN));
        inputField.click();
//        inputField.sendKeys(Keys.ENTER);
        inputField.sendKeys("animishshrivant508@gmail.com");
//        inputField.sendKeys(Keys.ENTER);

        WebElement option = wait.until(ExpectedConditions.elementToBeClickable(
                By.xpath("//div[@role='option']//span[normalize-space()='animishshrivant508@gmail.com']")));
//        WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//button[@class='btn btn-primary f-14 btn-sm']")));
//        btn.click();
// Step 3: Click on the matching dropdown option
        option.click();
        WebElement btn= wait.until(ExpectedConditions.elementToBeClickable(ReportPageLocator.DROPDOWN));
        btn.click();
        JavascriptExecutor js = (JavascriptExecutor) driver;
// Click at (10, 10) or any coordinate away from dropdowns/buttons
        js.executeScript("document.elementFromPoint(10, 10).click();");

    }

    //this part is new for learning...
    @And("performs drag and drop on party element")
    public void dragAndDropParty() throws InterruptedException {
        try {
            WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));

            // Step 1: Wait for any success toast to disappear
            wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));

            // Step 2: Find the source element to drag
            WebElement fromElement = wait.until(ExpectedConditions.elementToBeClickable(
                    ReportPageLocator.SOURCE_ELE
            ));

            // Step 3: Find a static canvas or drop zone to drop onto
            WebElement toElement = wait.until(ExpectedConditions.visibilityOfElementLocated(
                    ReportPageLocator.TARGET_ELE
            ));

            // Step 4: Perform drag and drop
            Actions actions = new Actions(driver);
            actions
                    .clickAndHold(fromElement)
                    .moveToElement(toElement)
                    .pause(Duration.ofSeconds(1))
                    .release()
                    .build()
                    .perform();

            // Step 5: Now verify the placeholder was created as a result of the drop
            wait.until(ExpectedConditions.visibilityOfElementLocated(
                ReportPageLocator.PLACEHOLDER
            ));

            logger.info("Drag and drop successful.");

        } catch (Exception e) {
            logger.log(Level.SEVERE, "Drag and drop failed: ", e);
            takeScreenshot("drag_and_drop_failure");
            Assert.fail("Drag and drop failed: " + e.getMessage());
        }
    }

//        } catch (Exception e) {
//            logger.info("Drag and drop failed: " + e.getMessage());
//            takeScreenshot("drag_and_drop_failure");
//            Assert.fail("Drag and drop failed");
//        }
    @And("places signature,clicks on the sent for signature button")
    public void placesSignatureClicksOnTheSentForSignatureButton() throws InterruptedException {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
       /* WebElement AddText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
        AddText.click();
        Actions action = new Actions(driver);
        action.sendKeys("This is a sample text").perform();
        logger.info("Added text successfully");*/
        WebElement PlaceSignature = wait.until(ExpectedConditions.presenceOfElementLocated(ReportPageLocator.PLACE_SIGN));
        PlaceSignature.click();
        logger.info("Clicked on place signature");
//        Thread.sleep(4000);
//        WebElement OKbutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Ok']")));
//        OKbutton.click();
//        logger.info("clicked on ok button");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[normalize-space()='Place Signature']")).click();
//        logger.info("Clicked on place signature button");
//        Thread.sleep(10000);
//
//       try {
//
//           wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       /* WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@partyemail='amrita@gmail.com']")));
//        logger.info("source element is found");
//        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='1' and contains(@class, 'example-boundary')]")));
//        logger.info("target element is found");*/
//
//           // Locate source and target elements
//           WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("partydiv")));
//           System.out.println("Source element is found.");
//           WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("getData")));
//           System.out.println("Target element is found.");
//
//           // Drag and drop for placing signature
//           Actions actions = new Actions(driver);
//           actions.dragAndDrop(sourceElement, targetElement).perform();
//           System.out.println("Drag and drop action completed successfully.");
//
//
//       } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        WebElement SendforSignature= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Share for Signature']")));
//        SendforSignature.click();
//        logger.info("Sent for Signature");

        wait.until(ExpectedConditions.invisibilityOfElementLocated(By.className("toast-success")));
    }

    @Given("user sends an email")
    public void emailSent() throws InterruptedException{
        System.setProperty("webdriver.chrome.driver", "C:\\\\Users\\\\Animish\\\\Downloads\\\\chromedriver-win64\\\\chromedriver-win64\\\\chromedriver.exe");
//        String userProfile = "C:\\Users\\Animish\\AppData\\Local\\Microsoft\\Edge\\User Data";
//
//        EdgeOptions options = new EdgeOptions();
//        options.addArguments("user-data-dir=" + userProfile);
//        options.addArguments("profile-directory=Profile 1");

//        driver = new EdgeDriver(options);
//        driver.manage().window().maximize();
//
//        driver.get("https://mail.google.com/mail/u/1/#inbox");
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        // ✅ Navigate to Gmail login
        driver.get("https://accounts.google.com/signin/v2/identifier?service=mail");

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement txtbox =  wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@id='identifierId']")));
        txtbox.click();
        txtbox.sendKeys("animishshrivant508@gmail.com");

//        WebDriverWait wait1 = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement nextbtn = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//span[normalize-space()='Next']")));
        nextbtn.click();
//        inputField.sendKeys(Keys.ENTER);


    }

}



//    @And("clicks on create new")
//    public void click_create()
//    {
//        try {
//            WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//            WebElement create_new= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[normalize-space()='Create New']")));
//            create_new.click();
//            logger.info("Clicked on create new");
//        } catch (Exception e) {
//            logger.info("Issue while clicking on create new: CreateContractSteps class");
//            takeScreenshot("Failed to click on create new");
//            Assert.fail("Exception occurred: " + e.getMessage());
//        }
//    }
//    @When("Enters all the details and clicks on the create button")
//    public void add_details() throws InterruptedException {
//
//        WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(10));
//        WebElement SelectElement = wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("ng-select[formcontrolname='contractType']")));
//        SelectElement.click();
//        logger.info("Clicked on contract type");
//        WebElement newAgreementOption = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//span[text()='New Agreement']")));
//        newAgreementOption.click();
//        logger.info("Selected New agreement");
//        // Enter contract name
//        WebElement contractNameInput = driver.findElement(By.cssSelector("input[formcontrolname='contractName']"));
//        contractNameInput.sendKeys("Test agreement");
//        logger.info("Entered contract name");
//        // Find and click the high priority button
//        WebElement highButton = driver.findElement(By.id("high"));
//        highButton.click();
//        logger.info("Selected Priority");
//        //Enter the tag
////        WebElement Tag = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='item' and @placeholder=' Add tag']")));
////        // Enter the tag name and press Enter
////        Tag.sendKeys("TagName");
////        Tag.sendKeys(org.openqa.selenium.Keys.ENTER);
//        // Entering 'Party Name
//        try {
//            Thread.sleep(7000);
//        } catch (InterruptedException e) {
//            throw new RuntimeException(e);
//        }
//        WebElement PartyEmail= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@type='text' and @autocomplete='a10356a4c189']")));
////        PartyEmail.clear();
//        PartyEmail.sendKeys("amritaaccfortest@gmail.com");
//        WebElement PartyName= wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//input[@placeholder='Enter party name']")));
//        PartyName.clear();
//        PartyName.sendKeys("Amrita");
//        driver.findElement(By.xpath("//button[normalize-space()='Add Party']")).click();
//        //WebElement fileInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Upload Annexure']")));
//        //fileInput.click();
//        //WebElement fileInput1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@accept='application/pdf']/following-sibling::label[1]")));
//        //fileInput1.click();
//        // Specify the file path to upload
//        //File file = new File("D:/Pdf_files/test-2.pdf");
//        // Enter the file path into the file input element
//        //fileInput.sendKeys(file.getAbsolutePath());
//        //String filePath = "D:/Pdf_files/test-2.pdf";
//        // Enter the file path into the file input element
//        //fileInput.sendKeys(filePath);
//        //System.out.println("File path: " + filePath);
//        WebElement StampInput = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Select Stamp Papers']")));
//        StampInput.click();
//        WebElement StampInput1 = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//input[@formcontrolname='select']")));
//        StampInput1.click();
//        driver.findElement(By.xpath("//button[normalize-space()='Save changes']")).click();
//        logger.info("Clicked on Save changes");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[normalize-space()='Create contract']")).click();
//        logger.info("Clicked on Create contract button");
//        Thread.sleep(3000);
//        driver.findElement(By.xpath("//button[text()='Proceed']")).click();
//        logger.info("Clicked on Proceed");
//    }
//
//
//    @And("places signature,clicks on the sent for signature button")
//    public void placesSignatureClicksOnTheSentForSignatureButton() throws InterruptedException {
//        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       /* WebElement AddText = wait.until(ExpectedConditions.presenceOfElementLocated(By.id("")));
//        AddText.click();
//        Actions action = new Actions(driver);
//        action.sendKeys("This is a sample text").perform();
//        logger.info("Added text successfully");*/
//        WebElement PlaceSignature = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Place Signature']")));
//        PlaceSignature.click();
//        logger.info("Clicked on place signature");
//        Thread.sleep(4000);
//        WebElement OKbutton = wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Ok']")));
//        OKbutton.click();
//        logger.info("clicked on ok button");
//        Thread.sleep(2000);
//        driver.findElement(By.xpath("//button[normalize-space()='Place Signature']")).click();
//        logger.info("Clicked on place signature button");
//        Thread.sleep(10000);
//
//       try {
//
//           wait = new WebDriverWait(driver, Duration.ofSeconds(10));
//       /* WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@partyemail='amrita@gmail.com']")));
//        logger.info("source element is found");
//        WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//div[@id='1' and contains(@class, 'example-boundary')]")));
//        logger.info("target element is found");*/
//
//           // Locate source and target elements
//           WebElement sourceElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("partydiv")));
//           System.out.println("Source element is found.");
//           WebElement targetElement = wait.until(ExpectedConditions.elementToBeClickable(By.id("getData")));
//           System.out.println("Target element is found.");
//
//           // Drag and drop for placing signature
//           Actions actions = new Actions(driver);
//           actions.dragAndDrop(sourceElement, targetElement).perform();
//           System.out.println("Drag and drop action completed successfully.");
//
//
//       } catch (Exception e) {
//            throw new RuntimeException(e);
//        }
//        WebElement SendforSignature= wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath("//button[normalize-space()='Share for Signature']")));
//        SendforSignature.click();
//        logger.info("Sent for Signature");
//
//    }}
