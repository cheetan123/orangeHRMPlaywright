package stepDefinition;
import com.microsoft.playwright.Page;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.qa.tasking.factory.PlayWrightFactory;
import pages.Home;
import pages.Login;
import utils.ConfigFileReader;

public class Launch {

    PlayWrightFactory pf = new PlayWrightFactory();
    Login login;
    Home home;
    Page page;

    @Given("User launch the browser")
    public void launchBrowser() {
        // Write code here that turns the phrase above into concrete actions
        System.out.println("User on welcome page");
        page = pf.initBrowser(ConfigFileReader.readProperties().getProperty("browser"));
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User login to portal")
    public void loginPortal() {
        login = new Login(page);
        login.inputUserName();
        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @When("User navigate to task page")
    public void navigateToTask() {
        home = new Home(page);
        home.navigateToTask();

        try {
            Thread.sleep(30000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    @Then("User close the browser")
    public void closeBrowser() {
        page.close();

    }
}
