package CheckPagesOn404;

import LandingPage.Error404Page;
import LandingPage.FooterComponent;
import LandingPage.HeaderComponent;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import io.restassured.RestAssured;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class CheckPageStatus {
    public static WebDriver driver;
    public static HeaderComponent headerComponent;
    public static FooterComponent footerComponent;
    public static Error404Page error404Page;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        driver.get("https://psyquation.com/en");
        driver.manage().window().maximize();
        footerComponent = new LandingPage.FooterComponent(driver);
        error404Page = new Error404Page(driver);
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    }

    @AfterClass
    public static void driverGuit() {
        driver.quit();
    }

    @Test
    public void checkPagesStatus200() throws IOException, ParseException {
        JSONParser parser = new JSONParser();
        try {
            String pathAbsolute = new File("src/main/java/resources/landingPagesList.json").getAbsolutePath();
            JSONArray a = (JSONArray) parser.parse(new FileReader(pathAbsolute));
            for (Object o : a) {
                JSONObject emailOb = (JSONObject) o;
                String url = (String) emailOb.get("url");
                try{
                    driver.get(url);
                    String expectedText404 = "404 Not Found";
                    //Assert.assertEquals(expectedText404, error404Page.text404.getText());
                    try{
                        Assert.assertEquals(200, RestAssured.get(url).statusCode());
                        Assert.assertTrue(error404Page.text404.isEmpty());
                    }catch (AssertionError e){
                        System.out.println("Not 200 with "+ url + " or 404 text on it.");
                    }
                }catch(AssertionError e){
                    System.out.println("Assertion error 404 for url "+ url);
                }
            }
        }catch(FileNotFoundException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch(IOException e){
                // TODO Auto-generated catch block
                e.printStackTrace();
            } catch(ParseException e){
                e.printStackTrace();
            }
    }

}
