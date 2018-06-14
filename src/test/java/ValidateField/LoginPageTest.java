package ValidateField;

import LandingPage.RightDropDownMenu;
import LandingPage.HeaderComponent;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class LoginPageTest {

    public static WebDriver driver;
    public static LandingPage.LoginPage login;
    public static HeaderComponent headerLogOutContainer;
    public static RightDropDownMenu rightDropDownMenu;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        headerLogOutContainer = new HeaderComponent(driver);
        login = new LandingPage.LoginPage(driver);
        rightDropDownMenu = new RightDropDownMenu(driver);
        driver.get("http://psyquation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/

    @Test
    public void authorizationSuccessful(){
        headerLogOutContainer.login.click();
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        rightDropDownMenu.accountLogo.isDisplayed();

    }

    @Test
    public void authorizationSuccessfulWithlogout(){
        headerLogOutContainer.login.click();
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        rightDropDownMenu.accountLogo.isDisplayed();
        rightDropDownMenu.accountDropDownMenu.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        rightDropDownMenu.logOutButton.click();
    }

    @Test
    public void authorizationEmailIsNotRegistered() {
        headerLogOutContainer.login.click();
        login.emailField.sendKeys("ka@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        //login.errorMsgIncorrectLoginOrPassword.getAttribute("innerText");
        String errorTextEng = "Incorrect login or password. Try again.";
        Assert.assertEquals(errorTextEng, login.errorMsgIncorrectLoginOrPassword.getAttribute("innerText"));
        login.clearAllLoginFields();
        }


    @Test
    public void authorizationEmptyForm(){
        headerLogOutContainer.login.click();
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        login.logInButton.getAttribute("disabled");
    }

    @Test
    public void authorizationEmptyEmailField(){
        headerLogOutContainer.login.click();
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        String errorTextEng = "This field is required.";
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyEmailField.getAttribute("innerText"));
        login.clearAllLoginFields();
    }

    @Test
    public void authorizationEmptyPasswordField(){
        headerLogOutContainer.login.click();
        login.emailField.sendKeys("kate@psyquation.com");
        login.logInButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        String errorTextEng = "This field is required.";
        System.out.println(login.errorMsgInCaseEmptyPasswordField.getAttribute("innerText"));
        Assert.assertEquals(errorTextEng, login.errorMsgInCaseEmptyPasswordField.getAttribute("innerText"));
        login.clearAllLoginFields();
    }


}
