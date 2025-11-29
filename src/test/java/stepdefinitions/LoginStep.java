package stepdefinitions;

import base.TestBase;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.LoginPage;

import static org.junit.jupiter.api.Assertions.assertTrue;

public class LoginStep {

    private LoginPage loginPage;

    @Given("the user is on the login page")
    public void userIsOnLoginPage() {
        if (TestBase.getDriver() == null) {
            TestBase.setUp();
        }
        loginPage = new LoginPage(TestBase.getDriver());
        loginPage.openLoginPage();
        if (utils.ExtentTestManager.getTest() != null) {
            utils.ExtentTestManager.getTest().pass("Opened login page");
        }
    }

    @When("the user enters a username")
    public void userEntersUsername() {
        userEntersUsernameAs("tomsmith");
    }

    @When("the user enters a username as {string}")
    public void userEntersUsernameAs(String username) {
        try {
            loginPage.enterUsername(username);
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().pass("Entered username: " + username);
        } catch (Exception e) {
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().fail("Failed to enter username: " + e.getMessage());
            throw e;
        }
    }

    @When("the user enters a password")
    public void userEntersPassword() {
        userEntersPasswordAs("SuperSecretPassword!");
    }

    @When("the user enters a password as {string}")
    public void userEntersPasswordAs(String password) {
        try {
            loginPage.enterPassword(password);
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().pass("Entered password: " + password);
        } catch (Exception e) {
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().fail("Failed to enter password: " + e.getMessage());
            throw e;
        }
    }

    @When("clicks on the login button")
    public void clicksOnTheLoginButton() {
        try {
            loginPage.clickLoginButton();
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().pass("Clicked login button");
        } catch (Exception e) {
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().fail("Failed to click login button: " + e.getMessage());
            throw e;
        }
    }

    @Then("the user should see a success message")
    public void the_user_should_see_a_success_message() {
        String successMessage = loginPage.getSuccessMessage();
        try {
            assertTrue(successMessage.contains("You logged into a secure area!"), "Expected success message but got: " + successMessage);
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().pass("Success message displayed: " + successMessage);
            System.out.println("✅ Test de connexion (Cucumber) réussi! Message: " + successMessage);
        } catch (AssertionError e) {
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }

    @Then("the user should see an error message")
    public void the_user_should_see_an_error_message() {
        String msg = loginPage.getSuccessMessage();
        try {
            assertTrue(msg.toLowerCase().contains("invalid") || msg.toLowerCase().contains("your username is invalid") || msg.toLowerCase().contains("your password is invalid"),
                    "Expected an error message but got: " + msg);
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().pass("Error message displayed: " + msg);
        } catch (AssertionError e) {
            if (utils.ExtentTestManager.getTest() != null) utils.ExtentTestManager.getTest().fail("Assertion failed: " + e.getMessage());
            throw e;
        }
    }
}
