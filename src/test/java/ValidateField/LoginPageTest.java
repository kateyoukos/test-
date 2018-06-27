package ValidateField;

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
    public static HeaderComponent headerLogOutContainer;
    public static RightDropDownMenu rightDropDownMenu;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 30);
        headerLogOutContainer = new HeaderComponent(driver);
        login = new LandingPage.LoginPage(driver);
        rightDropDownMenu = new RightDropDownMenu(driver);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/

    public void authorizationSuccessful(){
        driver.get("https://psyquation.com/en/login");
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.accountLogo));
    }

    @Test
    public void authorizationSuccessfulWithlogout(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.accountLogo));
        rightDropDownMenu.accountDropDownMenu.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        rightDropDownMenu.logOutButton.click();
    }

    @Test
    public void authorizationEmailIsNotRegistered() {
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.sendKeys("ka@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        String errorTextEng = "Incorrect login or password. Try again.";
        Assert.assertEquals(errorTextEng, login.errorMsgIncorrectLoginOrPassword.getAttribute("innerText"));
        clearAllLoginFields();
        }


    @Test
    public void authorizationEmptyForm(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        String buttonStatus = login.logInButton.getAttribute("disabled");
        Assert.assertEquals("true", login.logInButton.getAttribute("disabled"));
    }

    @Test
    public void authorizationEmptyEmailField(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        String errorTextEng = "Required";
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyEmailField.getAttribute("innerText"));
        clearAllLoginFields();
    }

    @Test
    public void authorizationEmptyPasswordField(){
        driver.get("https://psyquation.com/en/login");
        wait.until(ExpectedConditions.visibilityOf(login.emailField));
        login.emailField.sendKeys("kate@psyquation.com");
        login.logInButton.click();
        String errorTextEng = "Required";
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyPasswordField.getAttribute("innerText"));
        clearAllLoginFields();
    }

    public void clearAllLoginFields(){
        login.emailField.clear();
        login.passField.clear();
    }


}
