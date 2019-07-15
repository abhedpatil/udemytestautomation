package setup;

import org.openqa.selenium.WebDriver;

public abstract class abstractScreen {

    WebDriver driver;

    public abstractScreen(WebDriver driver) {
        this.driver = driver;
        //super(driver);
    }

}