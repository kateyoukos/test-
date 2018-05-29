package LandingPage;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage {

    public WebDriver driver;

    public LoginPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(xpath = "//input[@name='email']")
    private WebElement emailField;

    @FindBy (xpath = "//input[@name='password']")
    private WebElement passField;

    @FindBy (xpath = "//button[@ng-click]")
    private WebElement logInButton;

    public void clearAllLoginFields(){
        emailField.clear();
        passField.clear();
    }
}
