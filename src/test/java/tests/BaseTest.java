package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class BaseTest {

    public static WebDriver driver = null;

    public WebDriver initializeDriver() throws IOException {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\Automation\\udemytestautomation\\src\\test\\resources\\config\\env.properties");
        prop.load(fileInputStream);
        String browserName = prop.getProperty("browser");
        String url = prop.getProperty("url");
        System.out.println("BrowserName is " + browserName);

        if (browserName.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Jar's\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.manage().deleteAllCookies();
            driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
            driver.get(url);
            System.out.println("URL Loaded");
        } else if (browserName.equals("Internet Explorer")) {
            System.setProperty("webdriver.ie.driver", "path");
            driver = new InternetExplorerDriver();
        } else {
            System.out.println("In final else box.. somethings wrong");
            driver = new ChromeDriver();
        }

        //driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        //System.out.println("Impicit Wait . . .");
        return driver;
    }

    public void tearDownEveryTest() throws Exception {
        BaseTest.driver.quit();
    }
}
