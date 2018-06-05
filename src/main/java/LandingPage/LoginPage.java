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

    @FindBy (xpath = "//button[@ng-click]")
    public WebElement logInButton;

    @FindBy (css = "div[ng-if=\"hasError\"]>div>span[class=\"ng-scope\"]")
    public WebElement errorMsgIncorrectLoginOrPassword;

    @FindBy (css = "translate[translate-comment=\"Located under the email field when email blank\"]>span")
    public WebElement errorMsgInCaseEmptyEmailField;

    @FindBy (css = "translate[translate-comment=\"Located under the password field when password blank\"]>span")
    public WebElement errorMsgInCaseEmptyPasswordField;

    public void clearAllLoginFields(){
        emailField.clear();
        passField.clear();
    }
}
