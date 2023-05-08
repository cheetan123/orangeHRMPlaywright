package pages;

import com.microsoft.playwright.Page;
import org.junit.Assert;
import utils.ConfigFileReader;

import java.util.Properties;

public class Home {

    Page page;
//    private String btnLeftNav = "navbar__right-arrow-icon";
//    private String btnAutomation = "navbar__level-item automation";
//    private String btnTask = "navbar__level-item tasks";

    public Home(Page page) {
        this.page = page;
    }

    public void verifyProfile() {
        Assert.assertTrue(page.locator(ConfigFileReader.readProperties().getProperty("profile")).isVisible());
    }

    public void logout() {

        page.locator(ConfigFileReader.readProperties().getProperty("profile")).click();
        page.locator(ConfigFileReader.readProperties().getProperty("logout")).click();
    }
}
