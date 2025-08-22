package stepdefinitions;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.LoggerFactory;
import utils.BrowserActions;

import java.util.logging.Logger;

public class BulkSendSteps extends BrowserActions {
    private static final Logger logger = Logger.getLogger(BulkSendSteps.class.getName());
    private static final org.slf4j.Logger log = LoggerFactory.getLogger(BulkSendSteps.class);

    private WebDriverWait wait;
    public WebDriver getDriver(){return driver;}


}
