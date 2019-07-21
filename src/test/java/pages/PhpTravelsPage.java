package pages;

import data.constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class PhpTravelsPage implements constants {

    WebDriver driver;

    private static final String onesignalPopoverAllowButton = "#onesignal-popover-allow-button";
    private static final String onesignalPopoverCancelButton = "#onesignal-popover-cancel-button";
    private static final String normalPopover = "#normal-popover";
    private static final String popoverBodyMessage = ".popover-body-message";

    public PhpTravelsPage(WebDriver driver) {        //super(driver); //OR
        this.driver = driver;
    }

    public void validateNotificationsDialogBox() throws Exception {
        //WebDriverWait wait = new WebDriverWait(driver, 10);
        //wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(normalPopover)));
        sleep(5000);

        if (driver.findElement(By.cssSelector(normalPopover)).isDisplayed()) {
            //driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).isDisplayed();
            //driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).isDisplayed();
            Assert.assertTrue(driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).isDisplayed());
            Assert.assertTrue(driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).isDisplayed());
            String notificationsText = driver.findElement(By.cssSelector(popoverBodyMessage)).getText();
            System.out.print("Notifications text is " + notificationsText);
            //SoftAssert softAssert = new SoftAssert();
            Assert.assertEquals(notificationsText, constants.notifications);
            String noThanks = driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).getText();
            Assert.assertEquals(noThanks, constants.noThanks);
            String allow = driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).getText();
            Assert.assertEquals(allow, constants.allow);
        }
    }

    public void cancelNotificationsPopover() {
        driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).click();
        //List<WebElement> webElementList = driver.

    }


}