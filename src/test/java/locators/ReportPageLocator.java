package locators;
import org.openqa.selenium.By;


public class ReportPageLocator {
    //login
    public static final By LOGIN_USERNAME = By.xpath("//input[@id='inputEmail']");
    public static final By LOGIN_PASSWORD = By.xpath("//input[@id='inputPassword']");

    public static final By INVALID_USERNAME = By.xpath("//input[@id='inputEmail']");
    public static final By INVALID_PASSWORD = By.xpath("//input[@id='inputPassword']");
    public static final By LOGIN_BUTTON = By.xpath("//button[text()='Login']");

    //clause library
    public static final By CLAUSE_LIBRARY = By.xpath("//span[@class='menu-title ml-3 mr-2 navLinkGenis animated fadeInRight'][normalize-space()='Clause Library']");
    public static final By CUSTOM_CATEGORY = By.id("second");
    public static final By ADD_CATEGORY_BUTTON = By.xpath("//a[normalize-space()='Add Category']");
    public static final By CATEGORY_TYPE = By.xpath("//input[@placeholder='Enter Category Type']");
    public static final By CREATE_BUTTON = By.xpath("//button[normalize-space()='Create']");
    public static final By PDF_UPLOAD = By.xpath("//div[contains(@class, 'card-body')]//p[text()='Upload PDF']");


    //create contract
    public static final By CREATE_CONTRACT = By.xpath("//span[contains(text(),'Create Contract')]");
    public static final By FILE_INPUT = By.xpath("//input[@type='file' and @id='file']");
    public static final By SUBMIT_BUTTON = By.xpath("//button[@type='submit' and text()='Submit' and contains(@class, 'btn-primary')]");
    public static final By CREATE_CONTRACT_1 = By.xpath("//button[contains(@class, 'enable-div') and contains(., 'Create contract')]");
    public static final By ADD_SIGN = By.xpath("//button[contains(@class, 'btn') and contains(@class, 'style-1')]");
    public static final By INPUT_SIGN = By.xpath("//div[@role='combobox']//input[@type='text']");
    public static final By DROPDOWN = By.xpath("//button[@class='btn btn-primary f-14 btn-sm']");
    public static final By SOURCE_ELE = By.xpath("//div[@class='party-item' and @partyname='test' and @partyemail='animishshrivant508@gmail.com']");
    public static final By TARGET_ELE = By.xpath("//div[@id='canvas' or contains(@class, 'page') or contains(@class, 'drop-zone')]");

    //estamp
    public static final By E_STAMP = By.xpath("//span[contains(text(),'E-Stamping')]");
    public static final By ESTAMP_UPLOAD = By.xpath("//a[@href='/app/e-stamp/upload']//span[1]");
    public static final By ESTAMP_NAME = By.xpath("//input[@placeholder='Enter your name ']");
    public static final By PAPER_VLAUE = By.xpath("//input[@placeholder='Enter Stamp Paper Value']");
    public static final By STAMP_REG_NUMBER = By.xpath("//input[@placeholder='Enter Stamp Paper Registration Number ']");
    public static final By SELECT_STATE = By.xpath("//select[@id='exampleFormControlSelect1']");
    public static final By UPLOAD = By.xpath("//button[normalize-space()='Upload Stamp Paper']");
    public static final By FILE_UPLOAD = By.id("stampUpload");

    //report
    public static final By REPORT = By.xpath("//span[@class='menu-title ml-3 navLinkGenis animated fadeInRight']");
    public static final By CUSTOM_REPORT = By.xpath("//a[@class='menu-title pl-3']");
    public static final By REPORT_NAME = By.xpath("//input[@placeholder='Enter the report name']");
    public static final By REPORT_TYPE = By.xpath("//input[@value='contract']");
    public static final By FILTER = By.xpath("//span[contains(text(),'Select Departments')]");
    public static final By OPTION = By.xpath("//ng-multiselect-dropdown[@formcontrolname='dept']//ul[contains(@class, 'item')]/li[@class='multiselect-item-checkbox ng-star-inserted'][3]");
    public static final By OPTION_1 = By.xpath("//body[@id='bodyElement']/app-root[1]/div[1]/app-main-layout[1]/div[1]/div[1]/app-reports[1]/div[1]/div[3]/app-report-list[1]/div[2]/form[1]/div[1]/ng-multiselect-dropdown[1]/div[1]/div[2]/ul[2]/li[6]/div[1]");
    public static final By OPTION_2 = By.xpath("//span[text()='Select User']");
    public static final By OPTION_3 = By.xpath("//div[text()='animish']");
    public static final By OPTION_4 = By.xpath("//span[contains(text(),'Select Priority')]");
    public static final By OPTION_5 = By.xpath("//div[normalize-space()='Low']");
    public static final By OPTION_6 = By.xpath("//div[normalize-space()='Normal']");
    public static final By OPTION_7 = By.xpath("//span[contains(text(),'Select Status')]");
    public static final By OPTION_8 = By.xpath("//div[normalize-space()='Completed']");
    public static final By CALENDAR = By.xpath("(//input[contains(@class,'style-2 form-control')])[2]");
    public static final By GENERATE_REPORT = By.xpath("//button[normalize-space()='Generate Contract Report']");
    public static final By SUCCESS_MESSAGE = By.xpath("//div[@aria-label='Report will be available in some time once generated.']");
    public static final By CRM = By.xpath("//input[@type='radio' and @id='option1' and @value='crm']");
    public static final By CRM_1 = By.xpath("//span[@class='dropdown-btn' and //span[text()='Select Requestor']]");
    public static final By CRM_2 = By.xpath("//span[contains(text(),'Select Requestor')]/ancestor::ng-multiselect-dropdown//div[text()='Select All']");

}
