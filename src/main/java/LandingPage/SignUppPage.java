package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

public class SignUppPage {
    public WebDriver driver;

    public SignUppPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='firstName']")
    public WebElement firstName;

    @FindBy(xpath = "//input[@name='lastName']")
    public WebElement lastName;

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy(xpath = "//input[@name='password']")
    public WebElement passwordField;

    @FindBy(xpath = "//button/span[text()='Sign up']")
    public WebElement signUpButton;

    @FindBy(css = "span.checkbox__icon")
    public WebElement checkbox;

    @FindBy(xpath = "//span[text()='This field is required.']")
    public List<WebElement> fieldIsNotRequirement;

    public void getFieldIsNotRequirementError() {
        for (WebElement e : fieldIsNotRequirement) {
            e.getText();
        }
    }

    public void clearAllRegistrationFieldsAndCheckbox(){
        firstName.clear();
        lastName.clear();
        emailField.clear();
        passwordField.clear();
        checkbox.clear();
    }
}

