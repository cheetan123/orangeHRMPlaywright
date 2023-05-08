package net.qa.tasking.factory;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Playwright;
import com.microsoft.playwright.Page;
import utils.ConfigFileReader;

public class PlayWrightFactory {

    Playwright playwright;
    Browser browser;
    BrowserContext browserContext;
    Page page;
    public Page initBrowser(String browserName) {
        System.out.println("Browser : "+ browserName);
        playwright = Playwright.create();

        switch(browserName.toLowerCase()) {
            case "chromium":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false));
            case "chrome":
                browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setChannel("chrome").setHeadless(false));

            default:
                break;
        }

        browserContext = browser.newContext(new Browser.NewContextOptions().setViewportSize(1920,1080));
        page = browserContext.newPage();
        page.navigate(ConfigFileReader.readProperties().getProperty("url"));
        return page;

    }

    public Page getPage() {
        return page;
    }
}
