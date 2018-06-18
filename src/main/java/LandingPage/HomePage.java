package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
    public WebDriver driver;

    public HomePage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(id = "home-traderButton")
    public WebElement traderButton;

    @FindBy(id = "home-investorButton")
    public WebElement investorButton;

    @FindBy(id = "zsiq_float")
    public WebElement chatBlock;

}
