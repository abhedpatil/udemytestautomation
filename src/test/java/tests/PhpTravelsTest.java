package tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.Test;
import pages.PhpTravelsPage;
import pages.PhptravelspageCSSSelector;
import testdata.login;

public class PhpTravelsTest extends BaseTest {

    @AfterMethod
    public void closeBrower() throws Exception {
        tearDownEveryTest();
    }

    @Test(description = "Dialog Box")
    public void validateNotificationsDialogBox() throws Exception {
        driver = initializeDriver();
        PhpTravelsPage phpTravelsPage = new PhpTravelsPage(driver);

        phpTravelsPage.validateNotificationsDialogBox();
    }

    @Test(description = "Dialog Box validation using CSSSelector")
    public void validateNotificationsDialogBoxUsingCSSSelector() throws Exception {
        driver = initializeDriver();
        PhptravelspageCSSSelector phptravelspageCSSSelector = new PhptravelspageCSSSelector(driver);

        phptravelspageCSSSelector.validateNotificationsDialogBox();
    }

    @Test(dataProvider = "trialLogin", dataProviderClass = login.class)
    public void testngDataProvider(String username, String pwd) throws Exception {
        driver = initializeDriver();
        PhptravelspageCSSSelector phptravelspageCSSSelector = new PhptravelspageCSSSelector(driver);

        System.out.println("username is " + username);
        System.out.println("pwd is " + pwd);
    }

    /*
    @DataProvider
    public Object[][] trial(){
        return new Object[][]{
                {"vadapav", "samosa"},
                {"idli", "sambar"}
        };
    }*/
}