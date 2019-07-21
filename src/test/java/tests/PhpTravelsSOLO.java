package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class PhpTravelsSOLO {

    @FindBy(css = "#onesignal-popover-allow-button")
    WebElement onesignalPopoverAllowButton1;

    @FindBy(css = "#onesignal-popover-cancel-button")
    WebElement onesignalPopoverCancelButton1;

    @FindBy(css = "#normal-popover")
    WebElement normalPopover1;

    @FindBy(css = ".popover-body-message")
    WebElement popoverBodyMessage1;

    //WebElement element = driver.findElement(By.id("onesignal-popover-allow-button"));


    WebDriver driver = null;

    @BeforeMethod
    public void setup() throws Exception {
        System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Jar's\\chromedriver_win32\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://phptravels.com/");
        driver.manage().timeouts().pageLoadTimeout(20, TimeUnit.SECONDS);
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS); //Global Wait applicable for all elements the driver is interacting
    }

    @AfterMethod
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void validateNotificationsDialogBox() throws Exception {


    }


}
