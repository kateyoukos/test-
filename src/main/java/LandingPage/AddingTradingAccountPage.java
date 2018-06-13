package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class AddingTradingAccountPage {

    public WebDriver driver;

    public AddingTradingAccountPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "a[ng-click=\"selectedType($event, 4)\"]")
    public WebElement existingMT4button;


}
