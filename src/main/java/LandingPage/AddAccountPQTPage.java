package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddAccountPQTPage {

    public WebDriver driver;
    public String accountPQT =  "611710503";
    public String passwordPQT =  "5rovpk1";
    public String serverPQT =  "mtdemo1.leverate.com";

    public AddAccountPQTPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(name = "accountNumber")
    public WebElement accountNumberInputField;

    @FindBy(name = "accountPassword")
    public WebElement investorPasswordInputField;

    @FindBy(name = "accountServer")
    public WebElement serverInputField;

    @FindBy(css = "button[ng-click=\"createAccount(form)\"]")
    public WebElement addAccountButton;


}
