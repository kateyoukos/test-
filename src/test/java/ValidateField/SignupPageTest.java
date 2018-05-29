package ValidateField;

import LandingPage.HeaderComponent;
import LandingPage.WelcomeToPsyPage;
import LandingPage.SignUppPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.concurrent.TimeUnit;

public class SignupPageTest {

    public static WebDriver driver;
    public static SignUppPage signUppPage;
    public static HeaderComponent headerComponent;
    public static WelcomeToPsyPage newAccPage;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        headerComponent = new HeaderComponent(driver);
        signUppPage = new SignUppPage(driver);
        newAccPage = new WelcomeToPsyPage(driver);

        driver.get("https://psyquation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @After
    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }

    @AfterClass
    public static void driverGuit() {
        driver.quit();
    }

    @Test
    public void positiveRegisterTest() {
            headerComponent.signUp.click();
            signUppPage.firstName.sendKeys("Ira");
            signUppPage.lastName.sendKeys("Bilet");
            signUppPage.emailField.sendKeys("iryna+31@psyquation.com");
            signUppPage.passwordField.sendKeys("test123");
            signUppPage.checkbox.click();
            signUppPage.signUpButton.click();

            driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
            newAccPage.welcomeToPsyQuation.isDisplayed();
    }

    @Test
    public void  emailIsAlreadyRegisteredTest() {
            headerComponent.signUp.click();
            signUppPage.firstName.sendKeys("Ira");
            signUppPage.lastName.sendKeys("Bilet");
            signUppPage.emailField.sendKeys("iryna@psyquation.com");
            signUppPage.passwordField.sendKeys("test123");
            signUppPage.checkbox.click();
            signUppPage.signUpButton.click();

                   Assert.assertEquals("client with this email already exists.",
                           driver.findElement(By.xpath("//div[@aria-hidden=\"false\"]")).getText());
                }

    @Test
    public void  SignUpButtonIsInactiveTest(){
            headerComponent.signUp.click();
            driver.findElement(By.tagName("button")).getAttribute("disabled");
    }

//    @Test
//    public void  checkboxIsUncheckedTest() {
//        headerComponent.signUp.click();
//        signUppPage.firstName.sendKeys("Ira");
//        signUppPage.lastName.sendKeys("Bilet");
//        signUppPage.emailField.sendKeys("iryna+90@psyquation.com");
//        signUppPage.passwordField.sendKeys("test123");
//        signUppPage.signUpButton.click();
//
//        Assert.assertEquals("please accept Terms & Conditions and Privacy Policy to proceed",
//                driver.findElement(By.cssSelector("span.text-ng-binding")).getText());
//    }

}
