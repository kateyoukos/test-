package VerifyingElements;

import LandingPage.HeaderComponent;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class HeaderComponents {
    public static WebDriver driver;
    public static HeaderComponent headerComponent;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.get("http://psyquation.com/en");
        driver.manage().window().maximize();
        headerComponent = new LandingPage.HeaderComponent(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void driverGuit() {
        driver.quit();
    }

    @Test
    public void checkLogoHeaderIsDisplayed() {
        Assert.assertTrue(headerComponent.logo.isDisplayed());
    }

    @Test
    public void checkTraderTextHeader() {
        String traderLinkTextENG = "TRADER";
        Assert.assertEquals(traderLinkTextENG, headerComponent.trader.getAttribute("innerText"));
    }

    @Test
    public void checkInvestorTextHeader() {
        String investorLinkTextENG = "INVESTOR";
        Assert.assertEquals(investorLinkTextENG, headerComponent.investor.getAttribute("innerText"));
    }



    @Test
    public void checkWhyUsTextHeader() {
        String whyUsLinkTextENG = "WHY US";
        headerComponent.about.click();
        Assert.assertEquals(whyUsLinkTextENG, headerComponent.whyUs.getAttribute("innerText"));
    }

    @Test
    public void checkFAQTextHeader() {
        String faqLinkTextENG = "F.A.Q.";
        headerComponent.about.click();
        Assert.assertEquals(faqLinkTextENG, headerComponent.faq.getAttribute("innerText"));
    }

    @Test
    public void checkKnowledgeBaseTextHeader() {
        String knowledgeBaseLinkTextENG = "KNOWLEDGE BASE";
        headerComponent.about.click();
        Assert.assertEquals(knowledgeBaseLinkTextENG, headerComponent.knowledgeBase.getAttribute("innerText"));
    }

    @Test
    public void checkBlogTextHeader() {
        String blogLinkTextENG = "BLOG";
        headerComponent.about.click();
        Assert.assertEquals(blogLinkTextENG, headerComponent.blog.getAttribute("innerText"));
    }

    @Test
    public void checkContactUsTextHeader() {
        String contactUsLinkTextENG = "CONTACT US";
        headerComponent.about.click();
        Assert.assertEquals(contactUsLinkTextENG, headerComponent.contactUs.getAttribute("innerText"));
    }

    @Test
    public void checkLeaderboardTextHeader() {
        String leaderboardLinkTextENG = "LEADERBOARD";
        headerComponent.community.click();
        Assert.assertEquals(leaderboardLinkTextENG, headerComponent.leaderboard.getAttribute("innerText"));
    }

    @Test
    public void checkIncubationProgramTextHeader() {
        String incubationProgramLinkTextENG = "INCUBATION PROGRAM";
        headerComponent.community.click();
        Assert.assertEquals(incubationProgramLinkTextENG, headerComponent.incubationProgram.getAttribute("innerText"));
    }

    @Test
    public void checkConnectionProcessTextHeader() {
        String connectionProcessLinkTextENG = "CONNECTION PROCESS";
        headerComponent.community.click();
        Assert.assertEquals(connectionProcessLinkTextENG, headerComponent.connectionProcess.getAttribute("innerText"));
    }

    @Test
    public void checkLoginTextHeader() {
        String loginLinkTextENG = "LOGIN";
        Assert.assertEquals(loginLinkTextENG, headerComponent.login.getAttribute("innerText"));
    }

    @Test
    public void checkSignUpTextHeader() {
        String signUpLinkTextENG = "SIGN UP";
        Assert.assertEquals(signUpLinkTextENG, headerComponent.signUp.getAttribute("innerText"));
    }




}
