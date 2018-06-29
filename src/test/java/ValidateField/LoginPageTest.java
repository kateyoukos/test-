package ValidateField;

import LandingPage.HomePage;
import LandingPage.RightDropDownMenu;
import LandingPage.HeaderComponent;
import groovy.transform.ToString;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static LandingPage.LoginPage login;
    public static HeaderComponent headerComponent;
    public static RightDropDownMenu rightDropDownMenu;
    public static HomePage homePage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        homePage = new HomePage(driver);
        driver.get("https://psyquation.com/");
        headerComponent = new HeaderComponent(driver);
        login = new LandingPage.LoginPage(driver);
        rightDropDownMenu = new RightDropDownMenu(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }


    @AfterClass
    public static void driverGuit() {
        driver.quit();
    }

    public void authorizationSuccessful(){
        headerComponent.login.click();
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.accountLogo));
    }

    @Test
    public void authorizationSuccessfulWithlogout(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.clear();
        login.passField.clear();
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.accountDropDownMenu));
        rightDropDownMenu.accountDropDownMenu.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.logOutButton));
        rightDropDownMenu.logOutButton.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.investorButton));
    }

    @Test
    public void authorizationEmailIsNotRegistered() {
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.clear();
        login.emailField.sendKeys("qa@psyquation.com");
        login.passField.sendKeys("test11");
        login.logInButton.click();
        String errorTextEng = "Incorrect login or password. Try again.";
        wait.until(ExpectedConditions.visibilityOf(login.errorMsgIncorrectLoginOrPassword));
        Assert.assertEquals(errorTextEng, login.errorMsgIncorrectLoginOrPassword.getAttribute("innerText"));
    }

    @Test
    public void authorizationEmptyForm(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.clear();
        login.passField.clear();
        String buttonStatus = login.logInButton.getAttribute("disabled");
        Assert.assertEquals("true", login.logInButton.getAttribute("disabled"));
    }

    @Test
    public void authorizationEmptyEmailField(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.passField.sendKeys("159753k");
        login.emailField.clear();
        login.logInButton.click();
        String errorTextEng = "Required";
        wait.until(ExpectedConditions.visibilityOf(login.errorMsgInCaseEmptyEmailField));
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyEmailField.getAttribute("innerText"));
        }

    @Test
    public void authorizationEmptyPasswordField(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.sendKeys("qa1@psyquation.com");
        login.passField.clear();
        login.logInButton.click();
        String errorTextEng = "Required";
        wait.until(ExpectedConditions.visibilityOf(login.errorMsgInCaseEmptyPasswordField));
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyPasswordField.getAttribute("innerText"));
        login.emailField.clear();
    }

    public void clearAllLoginFields(){
        login.emailField.clear();
        login.passField.clear();
    }
}
