package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class InvestorPage {
    public WebDriver driver;
    public String firstNameValid = "Ivan";
    public String lastNameValid = "Lorem";
    public String emailValid = "test@psyquation.com";
    public String emailInvalid = "kate@psyquation.com";
    public String phoneValid = "123456111";



    public InvestorPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "input[id=\"firstName\"]")
    public WebElement firstNameInputField;

    @FindBy(css = "input[id=\"lastName\"]")
    public WebElement lastNameInputField;

    @FindBy(css = "input[id=\"email\"]")
    public WebElement emailInputField;

    @FindBy(css = "[id=\"phone-wrapper\"] input")
    public WebElement phoneInputField;

    @FindBy(css = "label[for=\"agreeLegal\"]")
    public WebElement agreelegalCheckbox;

    @FindBy(css = "input[id=\"agreeToReceive\"]")
    public WebElement agreeToReceiveCheckBox;

    @FindBy(id = "investor-formSubmit-button")
    public WebElement submitButton;

    @FindBy(id = "zsiq_float")
    public WebElement chatBlock;


}
