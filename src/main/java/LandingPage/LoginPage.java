package LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='email']")
    public WebElement emailField;

    @FindBy (xpath = "//input[@name='password']")
    public WebElement passField;

    @FindBy(className="checkbox__icon checkbox__icon--light")
    public WebElement rememberMeCheckbox;

    @FindBy (css = "button[id=\"investor-formSubmit-button\"]")
    public WebElement logInButton;

    @FindBy (css = "label[for=\"password\"]+div+p")
    public WebElement errorMsgIncorrectLoginOrPassword;

    @FindBy (css = "input[id=\"email\"]+p")
    public WebElement errorMsgInCaseEmptyEmailField;

    @FindBy (css = "label[for=\"password\"]+div+p")
    public WebElement errorMsgInCaseEmptyPasswordField;

    public void clearAllLoginFields(){
        emailField.clear();
        passField.clear();
    }
}