package ValidateField;

import LandingPage.*;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.Random;
import java.util.concurrent.TimeUnit;

public class SignupPageTest {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static SignUppPage signUppPage;
    public static HeaderComponent headerComponent;
    public static WelcomeToPsyPage newAccPage;
    public static RightDropDownMenu rightDropDownMenu;
    public static HomePage homePage;

    @BeforeClass
    public static void setup() {
        driver = new ChromeDriver();
        headerComponent = new HeaderComponent(driver);
        rightDropDownMenu = new RightDropDownMenu(driver);
        homePage =new HomePage(driver);
        wait = new WebDriverWait(driver, 30);
        signUppPage = new SignUppPage(driver);
        newAccPage = new WelcomeToPsyPage(driver);
        driver.get("https://psyquation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@After
    public void deleteAllCookies(){
        driver.manage().deleteAllCookies();
        driver.navigate().refresh();
    }*/

    @AfterClass
    public static void driverGuit() {
        driver.quit();
    }

    @Test
    public void positiveRegisterTest() {
        //fill in email field
        Random random = new Random();
        String randomEmail = "qa+".concat(String.valueOf(random.nextInt(1000)).concat("@psyquation.com")) ;
        headerComponent.signUp.click();
        wait.until(ExpectedConditions.visibilityOf(signUppPage.emailField));
        signUppPage.firstName.sendKeys("Tesname");
        signUppPage.lastName.sendKeys("Testsurname");
        signUppPage.emailField.sendKeys(randomEmail);
        signUppPage.passwordField.sendKeys("test1");

        //work with Country drop-down list
        Actions actions = new Actions(driver);
        actions.moveToElement(signUppPage.countryList);
        actions.click();
        actions.sendKeys("Australia");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

        signUppPage.checkbox.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        signUppPage.signUpButton.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.accountDropDownMenu));
        rightDropDownMenu.accountDropDownMenu.click();
        wait.until(ExpectedConditions.visibilityOf(rightDropDownMenu.logOutButton));
        rightDropDownMenu.logOutButton.click();
        wait.until(ExpectedConditions.visibilityOf(homePage.investorButton));
        //https://psyquation.com/app/#!/home/welcome
    }

    @Test
    public void  emailIsAlreadyRegisteredTest() {
        headerComponent.signUp.click();
        wait.until(ExpectedConditions.visibilityOf(signUppPage.emailField));
        signUppPage.firstName.sendKeys("Ira");
        signUppPage.lastName.sendKeys("Bilet");
        signUppPage.emailField.sendKeys("iryna@psyquation.com");
        signUppPage.passwordField.sendKeys("test123");
        //work with Country drop-down list
        Actions actions = new Actions(driver);
        actions.moveToElement(signUppPage.countryList);
        actions.click();
        actions.sendKeys("Australia");
        actions.sendKeys(Keys.ENTER);
        actions.build().perform();

        signUppPage.checkbox.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        signUppPage.signUpButton.click();
        wait.until(ExpectedConditions.visibilityOf(signUppPage.errorMsgEmailAlreadyRegistered));

        Assert.assertEquals("client with this email already exists.",
                signUppPage.errorMsgEmailAlreadyRegistered.getText());
        }

    @Test
    public void  SignUpButtonIsInactiveTest(){
        headerComponent.signUp.click();
        wait.until(ExpectedConditions.visibilityOf(signUppPage.emailField));
        driver.findElement(By.tagName("button")).getAttribute("disabled");
    }
}
