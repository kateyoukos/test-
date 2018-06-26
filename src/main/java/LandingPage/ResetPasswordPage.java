package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class ResetPasswordPage {
    public WebDriver driver;

    public ResetPasswordPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "email")
    public WebElement emailInputField;

    @FindBy(css = "[id=\"email\"]+p")
    public WebElement errorMsg;

    @FindBy(css = "button[type=\"submit\"]")
    public WebElement submitButton;
}
