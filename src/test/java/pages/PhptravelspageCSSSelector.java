package pages;

import data.constants;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

public class PhptravelspageCSSSelector implements constants {

    WebDriver driver;
    public WebElement onesignalPopoverAllowButton = driver.findElement(By.cssSelector("#onesignal-popover-allow-button"));
    public WebElement onesignalPopoverCancelButton = driver.findElement(By.cssSelector("#onesignal-popover-cancel-button"));
    public WebElement normalPopover = driver.findElement(By.cssSelector("#normal-popover"));
    public WebElement popoverBodyMessage = driver.findElement(By.cssSelector(".popover-body-message"));

    public PhptravelspageCSSSelector(WebDriver driver) {
        this.driver = driver;
    }

    public void validateNotificationsDialogBox() throws Exception {
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.visibilityOf(normalPopover));
        //wait(10);

        if (normalPopover.isDisplayed()) {
            Assert.assertTrue(onesignalPopoverAllowButton.isDisplayed(), "Allow button is displayed");
            Assert.assertTrue(onesignalPopoverCancelButton.isDisplayed(), "Cancel button is displayed");
            String notificationsText = popoverBodyMessage.getText();
            System.out.print("Notifications text is " + notificationsText);
            Assert.assertEquals(notificationsText, constants.notifications);
            String noThanks = onesignalPopoverCancelButton.getText();
            Assert.assertEquals(noThanks, constants.noThanks); //OR
            //Assert.assertEquals(onesignalPopoverCancelButton.getText(), constants.noThanks);

            String allow = onesignalPopoverAllowButton.getText();
            Assert.assertEquals(allow, constants.allow);
        }
    }
}
