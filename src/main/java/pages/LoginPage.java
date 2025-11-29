package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

/**
 * Page Object Model pour la page de connexion
 * Encapsule tous les éléments et actions de la page de login
 */
public class LoginPage {

    private WebDriver driver;
    private WebDriverWait wait;

    // Sélecteurs des éléments de la page
    private By usernameField = By.id("username");
    private By passwordField = By.id("password");
    private By loginButton = By.cssSelector("button[type='submit']");
    private By successMessage = By.id("flash");

    public LoginPage(WebDriver driver) {
        this.driver = driver;
        this.wait = new WebDriverWait(driver, Duration.ofSeconds(10));
    }
    /**
     * Ouvre la page de connexion
     */
    public void openLoginPage() {
        driver.get("https://the-internet.herokuapp.com/login");
    }

    /**
     * Saisit le nom d'utilisateur
     * @param username le nom d'utilisateur à saisir
     */
    public void enterUsername(String username) {
        WebElement usernameElement = wait.until(ExpectedConditions.visibilityOfElementLocated(usernameField));
        usernameElement.clear();
        usernameElement.sendKeys(username);
    }

    /**
     * Saisit le mot de passe
     * @param password le mot de passe à saisir
     */
    public void enterPassword(String password) {
        WebElement passwordElement = wait.until(ExpectedConditions.visibilityOfElementLocated(passwordField));
        passwordElement.clear();
        passwordElement.sendKeys(password);
    }

    /**
     * Clique sur le bouton de connexion
     */
    public void clickLoginButton() {
        WebElement loginButtonElement = wait.until(ExpectedConditions.elementToBeClickable(loginButton));
        loginButtonElement.click();
    }

    /**
     * Récupère le message de succès après connexion
     * @return le texte du message de succès
     */
    public String getSuccessMessage() {
        WebElement successMessageElement = wait.until(
                ExpectedConditions.visibilityOfElementLocated(successMessage)
        );
        return successMessageElement.getText();
    }




}
