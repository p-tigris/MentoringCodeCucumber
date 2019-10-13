package cucumber.stepDef;

import cucumber.api.java.en.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.PageFactory;
import pages.HomePage;

public class HomePageLoginSteps {

    WebDriver driver;
    HomePage homePage;

    @Given("^I open the browser and navigate to Reddit homepage$")
    public void i_open_the_browser_and_navigate_to_Reddit_homepage() {
        System.setProperty("webdriver.chrome.driver", "src/main/resources/chromedriver");
        driver = new ChromeDriver();
        driver.get("https://old.reddit.com");
    }

    @When("^I land on the homepage of Reddit and I verify the login button is displayed$")
    public void i_land_on_the_homepage_of_Reddit_and_I_verify_the_login_button_is_displayed() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.validateLoginButton();

    }

    @Then("^I click on the login button$")
    public void i_click_on_the_login_button() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.clickOnLoginButton();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @And("^I validate email or username field is displayed$")
    public void i_validate_email_or_username_field_is_displayed() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.validateUsernameField();
    }

    @And("^I validate password field is displayed$")
    public void i_validate_password_field_is_displayed() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.validatePasswordField();
    }

    @Then("^I enter my (.*) and (.*)$")
    public void i_enter_my_username_and_password(String username, String password) {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.fillInUsernameAndPassword(username, password);
    }

    @And("I click on the sign in button")
    public void i_click_on_the_sign_in_button() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.signin();
    }

    @And("^I validate that I have logged in$")
    public void i_validate_that_I_have_logged_in() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.validateLoggedIn();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @But("^I log out$")
    public void i_log_out() {
        homePage = PageFactory.initElements(driver, HomePage.class);
        homePage.logout();
    }

    @Then("^I close the browser$")
    public void i_close_the_browser()  {
        driver.close();
        driver.quit();

    }
}
