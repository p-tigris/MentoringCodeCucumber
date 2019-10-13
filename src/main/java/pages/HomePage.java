package pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class HomePage {

    @FindBy(xpath = "//a[@class='login-required login-link']")
    public static WebElement loginButton;

    @FindBy(xpath = "//input[@id='user_login']")
    public static WebElement usernameField;

    @FindBy(xpath = "//input[@id='passwd_login']")
    public static WebElement passwordField;

    @FindBy(xpath = "//button[@type='submit' and @class='c-btn c-btn-primary c-pull-right']")
    public static WebElement signinButton;

    @FindBy(xpath = "//a[@class='pref-lang choice']")
    public static WebElement preferencesButton;

    @FindBy(linkText = "logout")
    public static WebElement logoutButton;

    public void validateLoginButton() {
        Assert.assertEquals(loginButton.isDisplayed(), true, "Login button is not displayed");
        if (loginButton.isDisplayed()) {
            System.out.println("Login button is displayed");
        }
    }

    public void clickOnLoginButton() {
        loginButton.click();
    }

    public void validateUsernameField() {
        Assert.assertEquals(usernameField.isDisplayed(), true, "Username field is not displayed");
        if (usernameField.isDisplayed()) {
            System.out.println("Username field is displayed");
        }
    }

    public void validatePasswordField() {
        Assert.assertEquals(passwordField.isDisplayed(), true, "Password field is not displayed");
        if (passwordField.isDisplayed()) {
            System.out.println("Password field is displayed");
        }
    }

    public void fillInUsernameAndPassword(String username, String password) {
        usernameField.sendKeys(username);
        passwordField.sendKeys(password);
    }

    public void signin() {
        signinButton.click();
    }

    public void validateLoggedIn() {
        Assert.assertEquals(preferencesButton.isDisplayed(), true, "User is not logged in");
        if (preferencesButton.isDisplayed()) {
            System.out.println("User is logged in");
        }
    }

    public void logout() {
        logoutButton.click();
        System.out.println("User is logged out");
    }
}
