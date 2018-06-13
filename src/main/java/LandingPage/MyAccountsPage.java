package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.ArrayList;
import java.util.List;

public class MyAccountsPage {
    public WebDriver driver;


    public MyAccountsPage(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css = "div[class=\"accounts__head\"]>button[href=\"#!/home/account/select\"]")
    public WebElement addNewAccountButton;

    @FindBy(css = "h1[class=\"accounts__head-title\"]>span")
    public WebElement headTitleActiveAccounts;

    @FindBy(css = "p[class=\"account-box-title ng-binding\"]")
    public List<WebElement> listWebElementsActiveAccounts;
}
