package ValidateField;

import LandingPage.HeaderComponent;
import LandingPage.SignUppPage;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

import static ValidateField.SignupPageTest.signUppPage;

public class LoginPageTest {

    public static WebDriver driver;
    public static LandingPage.LoginPage login;
    public static HeaderComponent headerLogOutContainer;

    @Before
    public static void setup(){
        driver = new ChromeDriver();
        headerLogOutContainer = new HeaderComponent(driver);
        signUppPage = new SignUppPage(driver);
        login = new LandingPage.LoginPage(driver);

        driver.get("http://psyquation.com/");
        driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    }

    @After
    public static void afterTest() {
        driver.quit();
    }

    @Test
    public void positiveAllFields(){
        headerLogOutContainer.signIn.click();

    }
}
