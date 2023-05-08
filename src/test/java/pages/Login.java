package pages;

import com.microsoft.playwright.Page;
import utils.ConfigFileReader;

import java.util.Properties;

public class Login {
    Page page;
//    private String txtLogin = "//input[@id='idToken1']";
//    private String txtPassword = "//input[@id='idToken2']";
//    private String btnLogin = "//input[@id='loginButton_0']";
    Properties prop = ConfigFileReader.readProperties();

    public Login(Page page) {
        this.page = page;
    }

    public void inputUserName() {
        page.locator(prop.getProperty("txtLogin")).fill(prop.getProperty("username"));
        page.locator(prop.getProperty("txtPassword")).fill(prop.getProperty("password"));
        page.locator(prop.getProperty("btnLogin")).click();
    }
}
