package testdata;

import org.testng.annotations.DataProvider;

public class login {


    @DataProvider(name = "trialLogin")
    public static Object[][] trial() {
        return new Object[][]{
                {"vadapav", "samosa"},
                {"idli", "sambar"}
        };
    }

    @DataProvider
    public Object[][] loginInfo() {
        return new Object[][]{
                {"useri", "pwd1"},
                {"user2", "pwd2"}
        };
    }
}