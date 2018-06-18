package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HeaderComponent {

    public WebDriver driver;

    public HeaderComponent(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy (id = "header-home")
    public WebElement logo;

    @FindBy (id = "header-trader")
    public WebElement trader;

    @FindBy (id = "header-investor")
    public WebElement investor;

    @FindBy (css = "[id=\"header-about\"]>div")
    public WebElement about;

    @FindBy (css = "[id=\"header-why_us\"]")
    public WebElement whyUs;

    @FindBy (css = "[id=\"header-faq\"]")
    public WebElement faq;

    @FindBy (css = "[id=\"header-contact_us\"]")
    public WebElement contactUs;

    @FindBy (css = "[id=\"header-knowledge_base\"]")
    public WebElement knowledgeBase;

    @FindBy (css = "[id=\"header-blog\"]")
    public WebElement blog;

    @FindBy (css = "[id=\"header-community\"]>div")
    public WebElement community;

    @FindBy (id = "header-leaderboard")
    public WebElement leaderboard;

    @FindBy (id = "header-incubation_program")
    public WebElement incubationProgram;

    @FindBy (id = "header-connection_process")
    public WebElement connectionProcess;

    @FindBy (id = "header-login")
    public WebElement login;

    @FindBy (id = "header-sign_up")
    public WebElement signUp;

    @FindBy (id = "header-dashboard")
    public WebElement dashboard;


}
