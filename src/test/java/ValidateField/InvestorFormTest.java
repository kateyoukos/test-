package ValidateField;

import LandingPage.InvestorPage;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

import org.json.simple.parser.ParseException;
import java.io.File;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class InvestorFormTest {
    public static WebDriver driver;
    public static InvestorPage investorPage;


    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        investorPage = new InvestorPage(driver);
        //driver.get("http://psyquation.com/en");
        driver.get("https://pq:test@stg.psyquation.com/en/investor");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/


    /*@Test
    public void investorFormSuccessful(){
        driver.navigate().refresh();
        new Actions(driver).moveToElement(investorPage.firstNameInputField).perform();
        investorPage.firstNameInputField.sendKeys(investorPage.firstNameValid);
        investorPage.lastNameInputField.sendKeys(investorPage.lastNameValid);
        investorPage.emailInputField.sendKeys(investorPage.emailValid);
        investorPage.phoneInputField.click();
        investorPage.phoneInputField.sendKeys(investorPage.phoneValid);
        investorPage.agreelegalCheckbox.click();
        investorPage.submitButton.click();
    }

    @Test
    public void investorFormEmptySubmitButtonIsDisabled(){
        driver.navigate().refresh();
        new Actions(driver).moveToElement(investorPage.firstNameInputField).perform();
        Assert.assertEquals("true", investorPage.submitButton.getAttribute("disabled"));
    }*/

    @Test
    public void investorFormInvalidEmail() throws FileNotFoundException {
        driver.navigate().refresh();
        new Actions(driver).moveToElement(investorPage.firstNameInputField).perform();

        JSONParser parser = new JSONParser();
        try {
            String pathAbsolute = new File("src/main/java/resources/emailTestData.json").getAbsolutePath();
            JSONArray a = (JSONArray) parser.parse(new FileReader(pathAbsolute));
            for (Object o : a) {
                JSONObject employee = (JSONObject) o;

                String email = (String) employee.get("email");
                System.out.println(email);

            }
        }
        catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (ParseException e) {
            e.printStackTrace();
        }

        investorPage.submitButton.click();
    }



}
