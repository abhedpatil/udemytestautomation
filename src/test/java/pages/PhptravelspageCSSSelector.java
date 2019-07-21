package pages;

import data.constants;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

import static java.lang.Thread.sleep;

public class PhptravelspageCSSSelector implements constants {

    WebDriver driver;

    @FindBy(css = "#onesignal-popover-allow-button")
    WebElement onesignalPopoverAllowButton;
    @FindBy(css = "#onesignal-popover-cancel-button")
    WebElement onesignalPopoverCancelButton;
    @FindBy(css = "#normal-popover")
    WebElement normalPopover;
    @FindBy(css = ".popover-body-message")
    WebElement popoverBodyMessage;

    public PhptravelspageCSSSelector(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    //private WebElement onesignalPopoverAllowButton = driver.findElement(By.cssSelector("#onesignal-popover-allow-button"));
    //private WebElement onesignalPopoverCancelButton = driver.findElement(By.cssSelector("#onesignal-popover-cancel-button"));
    //private WebElement normalPopover = driver.findElement(By.cssSelector("#normal-popover"));
    //private WebElement popoverBodyMessage = driver.findElement(By.cssSelector(".popover-body-message"));

    public void validateNotificationsDialogBox() throws Exception {
        System.out.println("Executing Sleep for 5 secs");
        try {
            sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

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
        } else {
            Assert.fail("Notifications Object not displayed");
        }
    }
}
