package tests;

import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pages.phpTravelsPage;

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
    @BeforeMethod
    public void openBrowser() throws Exception {
        setup();
    }

    @AfterTest
    public void closeBrower() throws Exception {
        endBrowser();
    }


    @Test(description = "Dialog Box")
    public void validateNotificationsDialogBox() throws Exception {
        phpTravelsPage phpTravelsPage = new phpTravelsPage(driver);

        phpTravelsPage.validateNotificationsDialogBox();
    }

    @Test(description = "Dialog Box using Page Factory")
    public void validateNotificationsDialogBoxUsingPageFactory() throws Exception {
        phpTravelsPage phpTravelsPage = new phpTravelsPage(driver);

        phpTravelsPage.validateNotificationsDialogBoxUsingPageFactory();
    }


}