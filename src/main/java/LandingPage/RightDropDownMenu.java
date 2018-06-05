package LandingPage;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class RightDropDownMenu {
    public WebDriver driver;

    public RightDropDownMenu(WebDriver driver) {
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    @FindBy(css="img[ng-if=\"currentAccount.logo\"]")
    public WebElement accountLogo;

    @FindBy(css="[ng-click=\"toggleDropdown($event)\"]")
    public WebElement accountDropDownMenu;

    @FindBy(css="a[href=\"#!/home/profile\"]")
    public WebElement ProfileSettings;

    @FindBy(css="a[href='#!/home/accounts']")
    public WebElement ManageAccountsItem;

    @FindBy(css="[ng-click=\"logout($event)\"]")
    public WebElement logOutButton;




}
