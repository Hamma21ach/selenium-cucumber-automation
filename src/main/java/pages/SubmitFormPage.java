package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SubmitFormPage {

    WebDriver driver;

    // Elements
    @FindBy(name = "my-text")
    private WebElement textField;

    @FindBy(name = "my-password")
    private WebElement passwordField;

    @FindBy(name = "my-disabled")
    private WebElement disabledInput;

    @FindBy(name = "my-select")
    private WebElement selectDropdown;

    @FindBy(css = "button[type='submit']")
    private WebElement submitButton;

    // Constructor
    public SubmitFormPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    // Actions
    public void enterText(String text) {
        textField.clear();
        textField.sendKeys(text);
    }

    public void enterPassword(String password) {
        passwordField.clear();
        passwordField.sendKeys(password);
    }

    public boolean isDisabledInputEnabled() {
        return disabledInput.isEnabled();
    }

    public void selectOption(String value) {
        org.openqa.selenium.support.ui.Select dropdown = new org.openqa.selenium.support.ui.Select(selectDropdown);
        dropdown.selectByValue(value);
    }

    public void submitForm() {
        submitButton.click();
    }
}



