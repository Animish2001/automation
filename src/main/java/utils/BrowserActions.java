package utils;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.apache.commons.io.FileUtils;
import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import org.openqa.selenium.OutputType;
import java.text.SimpleDateFormat;
import java.util.Date;
import io.qameta.allure.Attachment;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserActions {
    protected WebDriver driver;

        //Setup a web driver
    public void startBrowser() {
        WebDriverManager.chromedriver().setup();
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--no-sandbox"); // Bypass OS security model
        options.addArguments("--disable-dev-shm-usage"); // Overcome limited resource problems
        options.addArguments("--disable-extensions"); // Disable extensions
        options.addArguments("--disable-software-rasterizer"); // Disable software rasterizer

        driver = new ChromeDriver();
        driver.manage().window().maximize();
    }

    //Opens URL in browser
    public void openUrl(String url) {
        driver.get(url);
    }

    //Close the browser
    public void closeBrowser() {
        if (driver != null) {
            driver.quit();
        }
    }

    // to take screenshot
    public void takeScreenshot(String screenshotName) {
        // Create a screenshot directory if not exists
        Path screenshotDirectory = Paths.get("target", "screenshots");
        File directory = new File(screenshotDirectory.toString());
        if (!directory.exists()) {
            directory.mkdirs();
        }

        // Capture screenshot as File
        File screenshotFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);

        // Save screenshot to the screenshot directory
        LocalDateTime now = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = now.format(formatter);
        String filePath = screenshotDirectory + "/" + screenshotName + "_" + timestamp + ".png";

        try {
            FileUtils.copyFile(screenshotFile, new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
