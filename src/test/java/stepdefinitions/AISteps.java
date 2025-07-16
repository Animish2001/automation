package stepdefinitions;

import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utils.BrowserActions;
import org.openqa.selenium.*;

import java.time.Duration;
import java.util.logging.Logger;

public class AISteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(AISteps.class.getName());

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
