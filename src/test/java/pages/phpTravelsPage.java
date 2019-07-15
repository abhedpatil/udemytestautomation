package pages;

import data.constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class phpTravelsPage implements constants {

    public static final String onesignalPopoverAllowButton = "#onesignal-popover-allow-button";
    public static final String onesignalPopoverCancelButton = "#onesignal-popover-cancel-button";
    public static final String normalPopover = "#normal-popover";
    public static final String popoverBodyMessage = ".popover-body-message";

    @FindBy(css = "#onesignal-popover-allow-button")
    WebElement onesignalPopoverAllowButton1;

    @FindBy(css = "#onesignal-popover-cancel-button")
    WebElement onesignalPopoverCancelButton1;

    @FindBy(css = "#normal-popover")
    WebElement normalPopover1;

    @FindBy(css = ".popover-body-message")
    WebElement popoverBodyMessage1;


    WebDriver driver;

    //*[@id="normal-popover"]/div[1]/div[2]
    public phpTravelsPage(WebDriver driver) {
        //super(driver); //OR
        this.driver = driver;
    }


    public void validateNotificationsDialogBox() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(normalPopover)));

        if (driver.findElement(By.cssSelector(normalPopover)).isDisplayed()) {
            //driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).isDisplayed();
            //driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).isDisplayed();
            Assert.assertTrue(driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).isDisplayed());
            Assert.assertTrue(driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).isDisplayed());
            String notificationsText = driver.findElement(By.cssSelector(popoverBodyMessage)).getText();
            System.out.print("Notifications text is " + notificationsText);
            //SoftAssert softAssert = new SoftAssert();
            Assert.assertEquals(notificationsText, constants.notifications);
            String noThanks = driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).getText();
            String allow = driver.findElement(By.cssSelector(onesignalPopoverAllowButton)).getText();
            Assert.assertEquals(noThanks, constants.noThanks);
            Assert.assertEquals(allow, constants.allow);
        }
    }

    public void validateNotificationsDialogBoxUsingPageFactory() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector(normalPopover)));

        //WebElement element = driver.findElement((By) normalPopover1);
        //if(driver.findElement((By.cssSelector(normalPopover1)).isDisplayed())) {
        //Assert.assertTrue(normalPopover1.isDisplayed());
        Assert.assertTrue(onesignalPopoverAllowButton1.isDisplayed());
        Assert.assertTrue(onesignalPopoverCancelButton1.isDisplayed());
        String notificationsText = popoverBodyMessage1.getText();
        System.out.print("Notifications text is " + notificationsText);
        //SoftAssert softAssert = new SoftAssert();
        Assert.assertEquals(notificationsText, constants.notifications);
        String noThanks = onesignalPopoverAllowButton1.getText();
        String allow = onesignalPopoverAllowButton1.getText();
        Assert.assertEquals(noThanks, constants.noThanks);
        Assert.assertEquals(allow, constants.allow);
        //}
    }

    public void cancelNotificationsPopover() {
        driver.findElement(By.cssSelector(onesignalPopoverCancelButton)).click();
        //List<WebElement> webElementList = driver.

    }


}