package ValidateField;

import LandingPage.InvestorPage;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.util.concurrent.TimeUnit;

public class InvestorFormTest {
    public static WebDriver driver;
    public static InvestorPage investorPage;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        investorPage = new InvestorPage(driver);
        //driver.get("http://psyquation.com/en");
        driver.get("http://pq:test@stg.psyquation.com/en/investor");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/


    @Test
    public void investorFormSuccessful(){
        new Actions(driver).moveToElement(investorPage.firstNameInputField).perform();
        investorPage.firstNameInputField.sendKeys(investorPage.firstNameValid);
        investorPage.lastNameInputField.sendKeys(investorPage.lastNameValid);
        investorPage.emailInputField.sendKeys(investorPage.emailValid);
        investorPage.phoneInputField.click();
        investorPage.phoneInputField.sendKeys(investorPage.phoneValid);
        investorPage.agreelegalCheckbox.click();
        investorPage.submitButton.click();
    }

}
