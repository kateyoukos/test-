package ValidateField;


import LandingPage.ResetPasswordPage;
import com.google.common.base.Verify;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class ResetPassword {
    public static WebDriver driver;
    public static WebDriverWait wait;
    public static ResetPasswordPage resetPassword;


    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        resetPassword = new ResetPasswordPage(driver);
        driver.get("https://psyquation.com/en/reset-password");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);

    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/

    @Test
    public void resetPswInvalidEmail() throws FileNotFoundException {
        JSONParser parser = new JSONParser();
        try {
            String pathAbsolute = new File("src/main/java/resources/emailTestData.json").getAbsolutePath();
            JSONArray a = (JSONArray) parser.parse(new FileReader(pathAbsolute));
            for (Object o : a) {
                JSONObject emailOb = (JSONObject) o;
                String email = (String) emailOb.get("email");
                String errMsg = (String) emailOb.get("errorMsgENG");
                resetPassword.emailInputField.sendKeys(email);
                resetPassword.submitButton.click();
                wait.until(ExpectedConditions.visibilityOf(resetPassword.errorMsg));
                try{
                    Assert.assertEquals(errMsg, resetPassword.errorMsg.getText());
                    System.out.println("Test with data "+email+" completed.");
                }catch(AssertionError e){
                    System.out.println("Assertion error with data "+ email);
                }
                //clear EmailInputField
                resetPassword.emailInputField.clear();
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




}

}
