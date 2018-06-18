package VerifyingElements;

import LandingPage.FooterComponent;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class FooterComponents {

    public static WebDriver driver;
    public static FooterComponent footerComponent;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        //driver.get("http://psyquation.com/en");
        driver.get("http://pq:test@stg.psyquation.com/en");
        driver.manage().window().maximize();
        footerComponent = new LandingPage.FooterComponent(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/

    @Test
    public void checkLogoFooterIsDisplayed() {
        Assert.assertTrue(footerComponent.logo.isDisplayed());
    }

    @Test
    public void checkHomeTextFooter() {
        String homeLinkTextENG = "HOME";
        Assert.assertEquals(homeLinkTextENG, footerComponent.homeLink.getAttribute("innerText"));
    }

    @Test
    public void checkTraderTextFooter() {
        String traderLinkTextENG = "TRADER";
        Assert.assertEquals(traderLinkTextENG, footerComponent.trader.getAttribute("innerText"));
    }

    @Test
    public void checkInvestorTextFooter() {
        String investorLinkTextENG = "INVESTOR";
        Assert.assertEquals(investorLinkTextENG, footerComponent.investor.getAttribute("innerText"));
    }

    @Test
    public void checkLeaderboardTextFooter() {
        String leaderboardLinkTextENG = "Leaderboard";
        Assert.assertEquals(leaderboardLinkTextENG, footerComponent.leaderboard.getAttribute("innerText"));
    }

    @Test
    public void checkIncubationProgramTextFooter() {
        String incubationProgramLinkTextENG = "Incubation Program";
        Assert.assertEquals(incubationProgramLinkTextENG, footerComponent.incubationProgram.getAttribute("innerText"));
    }

    @Test
    public void checkConnectionProcessTextFooter() {
        String connectionProcessLinkTextENG = "Connection Process";
        Assert.assertEquals(connectionProcessLinkTextENG, footerComponent.connectionProcess.getAttribute("innerText"));
    }

    @Test
    public void checkWhyUsTextFooter() {
        String whyUsLinkTextENG = "Why Us";
        Assert.assertEquals(whyUsLinkTextENG, footerComponent.whyUs.getAttribute("innerText"));
    }

    @Test
    public void checkFAQTextFooter() {
        String faqLinkTextENG = "F.A.Q.";
        Assert.assertEquals(faqLinkTextENG, footerComponent.faq.getAttribute("innerText"));
    }

    @Test
    public void checkKnowledgeBaseTextFooter() {
        String knowledgeBaseLinkTextENG = "Knowledge Base";
        Assert.assertEquals(knowledgeBaseLinkTextENG, footerComponent.knowledgeBase.getAttribute("innerText"));
    }

    @Test
    public void checkBlogTextFooter() {
        String blogLinkTextENG = "Blog";
        Assert.assertEquals(blogLinkTextENG, footerComponent.blog.getAttribute("innerText"));
    }

    @Test
    public void checkContactUsTextFooter() {
        String contactUsLinkTextENG = "Contact Us";
        Assert.assertEquals(contactUsLinkTextENG, footerComponent.contactUs.getAttribute("innerText"));
    }

    @Test
    public void checkLogInTextFooter() {
        String logInLinkTextENG = "LOGIN";
        Assert.assertEquals(logInLinkTextENG, footerComponent.login.getAttribute("innerText"));
    }

    @Test
    public void checkSignInTextFooter() {
        String signUpLinkTextENG = "SIGN UP";
        Assert.assertEquals(signUpLinkTextENG, footerComponent.signUp.getAttribute("innerText"));
    }

    @Test
    public void checkTermsAndConditionsTextFooter() {
        String termsAndConditionsLinkTextENG = "Terms & Conditions";
        Assert.assertEquals(termsAndConditionsLinkTextENG, footerComponent.termsAndConditions.getAttribute("innerText"));
    }

    @Test
    public void checkFinancialServicesTextFooter() {
        String financialServicesLinkTextENG = "Financial Services";
        Assert.assertEquals(financialServicesLinkTextENG, footerComponent.financialServises.getAttribute("innerText"));
    }

    @Test
    public void checkDataPolicyTextFooter() {
        String dataPolicyLinkTextENG = "Data Policy";
        Assert.assertEquals(dataPolicyLinkTextENG, footerComponent.dataPolicy.getAttribute("innerText"));
    }

    @Test
    public void checkPrivacyPolicyTextFooter() {
        String privacyPolicyLinkTextENG = "Privacy Policy";
        Assert.assertEquals(privacyPolicyLinkTextENG, footerComponent.privacyPolicy.getAttribute("innerText"));
    }

    @Test
    public void checkLanguageSwitcherFooterIsDisplayed() {
        Assert.assertTrue(footerComponent.switcherLanguages.isDisplayed());;
    }

    @Test
    public void checkFBIconFooter() {
        Assert.assertTrue(footerComponent.facebookIcon.isDisplayed());;
    }

    @Test
    public void checkTwitterIconFooter() {
        Assert.assertTrue(footerComponent.twitterIcon.isDisplayed());;
    }

    @Test
    public void checkYoutubeIconFooter() {
        Assert.assertTrue(footerComponent.youtubeIcon.isDisplayed());;
    }

    @Test
    public void checkLinkedInIconFooter() {
        Assert.assertTrue(footerComponent.linkedInIcon.isDisplayed());;
    }

}
