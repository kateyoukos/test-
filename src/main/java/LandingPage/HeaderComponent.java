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

    @FindBy (css = "a.header__brand")
    public WebElement logo;

    @FindBy (xpath = "//div[@class = 'header__nav-item dd-toggle']/span/span[text()='For Traders']")
    public WebElement forTraders;

    @FindBy (xpath = "//span[text()='For Traders']/following::i")
    public WebElement iconDropDown;

        @FindBy(xpath = "//div[@class='header__nav-item-menu']/a/span[text()='Platform Overview']")
        public WebElement platformOverview;

        @FindBy(xpath = "//span[text()='Signup']")
        public WebElement signUp;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Allocations']")
        public WebElement allocations;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='About us']")
        public WebElement aboutUs;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Why Us']")
        public WebElement whyUs;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Testimonials']")
        public WebElement testimonials;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Connection Process']")
        public WebElement connectionProcess;

        @FindBy (xpath = "//a[@class = 'header__nav-item']/span/span[text()='For Allocators']")
        public WebElement forAllocators;

        @FindBy (xpath = "//div[@class = 'header__nav-item']/span/span[text()='Community']")
        public WebElement community;

        @FindBy(xpath = "//a[@class = 'header__nav-item-menu-item']/span[text()='Leaderboard']")
        public WebElement leaderBoard;

        @FindBy(xpath = "//a[@class = 'header__nav-item-menu-item']/span[text()='Blog']")
        public WebElement blog;

        @FindBy (xpath = "//div[@class = 'header__nav-item']/span/span[text()='Support']")
        public WebElement support;

        @FindBy(xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Knowledge Base']")
        public WebElement knowledgeBase;

        @FindBy (xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Video Tutorials']")
        public WebElement videoTutorials;

        @FindBy (xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='Contact Us']")
        public WebElement contactUs;

        @FindBy (xpath = "//div[@class = 'header__nav-item-menu']/a/span[text()='F.A.Q.']")
        public WebElement fAq;

        @FindBy (xpath = "//a[@ui-sref='auth.login']")
        public WebElement signIn;
}
