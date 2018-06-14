package LandingPage;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FooterComponent {

    @FindBy(css = "a[id=\"footer-home\"]>img")
    public WebElement footerLogo;

    @FindBy(css = "a[id=\"footer-home\"][class]")
    public WebElement homeLink;

    @FindBy(id = "footer-trader")
    public WebElement trader;

    @FindBy(id = "footer-investor")
    public WebElement investor;

    @FindBy(id = "footer-leaderboard")
    public WebElement leaderboard;

    @FindBy(id = "footer-incubation_program")
    public WebElement incubationProgram;

    @FindBy(id = "footer-connection_process")
    public WebElement connectionProcess;

    @FindBy(id = "footer-why_us")
    public WebElement whyUs;

    @FindBy(id = "footer-faq")
    public WebElement faq;

    @FindBy(id = "footer-knowledge_base")
    public WebElement knowledgeBase;

    @FindBy(id = "footer-blog")
    public WebElement blog;

    @FindBy(id = "footer-contact_us")
    public WebElement contactUs;

    @FindBy(id = "footer-login")
    public WebElement login;

    @FindBy(id = "footer-sign_up")
    public WebElement signUp;

    @FindBy(id = "footer-terms_and_conditions")
    public WebElement termsAndConditions;

    @FindBy(id = "footer-financial_services_guide")
    public WebElement financialServises;

    @FindBy(id = "footer-data_policy")
    public WebElement dataPolicy;

    @FindBy(id = "footer-privacy_policy")
    public WebElement privacyPolicy;

    @FindBy(id = "footer-select-trigger")
    public WebElement switcherLanguages;

    @FindBy(id = "footer-social-facebook")
    public WebElement facebookIcon;

    @FindBy(id = "footer-social-twitter")
    public WebElement twitterIcon;

    @FindBy(id = "footer-social-linkedin")
    public WebElement lenkedInIcon;

    @FindBy(id = "footer-social-youtube")
    public WebElement youtubeIcon;
}
