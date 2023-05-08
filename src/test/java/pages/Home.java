package pages;

import com.microsoft.playwright.Page;
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

    public void navigateToTask() {

        page.getByTestId(ConfigFileReader.readProperties().getProperty("btnLeftNav")).click();
        page.getByTestId(ConfigFileReader.readProperties().getProperty("btnAutomation")).click();
        page.getByTestId(ConfigFileReader.readProperties().getProperty("btnTask")).click();
    }
}
