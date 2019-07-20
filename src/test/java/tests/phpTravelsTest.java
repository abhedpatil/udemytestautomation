package tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.PhpTravelsPage;
import pages.PhptravelspageCSSSelector;

public class phpTravelsTest extends baseTest {

    //public WebDriver driver=null;

    // @BeforeMethod
   /*
    public void setup() throws Exception {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\Automation\\udemytestautomation\\src\\test\\resources\\config\\env.properties");
        prop.load(fileInputStream);
        //if(prop.getProperty("browser")).contains("chrome");
        if(prop.getProperty("browser").contains("chrome"))
        {
            driver = new ChromeDriver();
            driver.get(prop.getProperty("url"));
        }*/
    public WebDriver driver;
    @BeforeMethod
    public void openBrowser() throws Exception {
        this.driver = setup();
    }

    @AfterMethod
    public void closeBrower() throws Exception {
        tearDownEveryTest();
    }


    @Test(description = "Dialog Box")
    public void validateNotificationsDialogBox() throws Exception {
        PhpTravelsPage phpTravels = new PhpTravelsPage(this.driver);

        phpTravels.validateNotificationsDialogBox();
    }

    @Test(description = "Dialog Box using Page Factory")
    public void validateNotificationsDialogBoxUsingPageFactory() throws Exception {
        PhptravelspageCSSSelector phptravelspageCSS = new PhptravelspageCSSSelector(this.driver);

        phptravelspageCSS.validateNotificationsDialogBox();
    }


}