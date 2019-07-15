package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.util.Properties;

public class baseTest {

    public WebDriver driver = null;

    public void setup() throws Exception {
        Properties prop = new Properties();
        FileInputStream fileInputStream = new FileInputStream("D:\\Automation\\udemytestautomation\\src\\test\\resources\\config\\env.properties");
        prop.load(fileInputStream);
        if (prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Jar's\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
        }
    }

    public void endBrowser() throws Exception {
        driver.quit();
    }
}
