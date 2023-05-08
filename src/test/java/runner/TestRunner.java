package runner;

import com.microsoft.playwright.BrowserContext;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;
import io.cucumber.java.AfterStep;
import io.cucumber.java.Scenario;
import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import net.qa.tasking.factory.PlayWrightFactory;
import org.junit.runner.RunWith;

import java.nio.file.Paths;

@RunWith(Cucumber.class)
@CucumberOptions(
        publish = true,
        features = { "src/test/java/features" },
        glue = { "stepDefinition" },
        monochrome = true,
        dryRun = false,
        plugin = { "pretty", "json:target/cucumber-reports/Cucumber.json",
                "junit:target/cucumber-reports/Cucumber.xml",
                "html:target/cucumber-reports/report.html",
                "com.aventstack.extentreports.cucumber.adapter.ExtentCucumberAdapter:" }
)
public class TestRunner {

//    PlayWrightFactory pf = new PlayWrightFactory();
//    @AfterStep
//    public void endStep(Scenario scenario) {



//        if (scenario.isFailed()) {
////            pf.getPage().screenshot(new Page.ScreenshotOptions()
////                    .setPath(Paths.get("screenshot.png"))
////                    .setFullPage(true));
//        byte[] buffer = pf.getPage().screenshot();
//        scenario.attach(buffer, "image/png", "scr-shot");
//        }
//    }
}
