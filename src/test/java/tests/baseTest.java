package tests;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class baseTest {

    public WebDriver driver;
    public Properties prop;

    public WebDriver setup() throws Exception {
        Properties prop = new Properties();
        try {
            FileInputStream fileInputStream = new FileInputStream("D:\\Automation\\udemytestautomation\\src\\test\\resources\\config\\env.properties");
            prop.load(fileInputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        if (prop.getProperty("browser").contains("chrome")) {
            System.setProperty("webdriver.chrome.driver", "D:\\Automation\\Selenium Jar's\\chromedriver_win32\\chromedriver.exe");
            driver = new ChromeDriver();
            driver.manage().window().maximize();
            driver.get(prop.getProperty("url"));
        } else if (prop.getProperty("browser").contains("Internet Explorer")) {
            System.setProperty("webdriver.ie.driver", "path");
            driver = new ChromeDriver();
        } else {
            driver = new ChromeDriver();
        }
        return driver;
    }

    public void tearDownEveryTest() throws Exception {
        if (driver == null)
            return;
        driver.quit();
    }
}
