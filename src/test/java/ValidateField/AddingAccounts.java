package ValidateField;

import LandingPage.*;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertThat;

public class AddingAccounts {

    public static WebDriver driver;
    public static WebDriverWait wait;
    public static MyAccountsPage myAccountsPage;
    public static RightDropDownMenu rightDropDownMenu;
    public static AddingTradingAccountPage addingTradingAccountPage;
    public static AddAccountPQTPage addAccountPQTPage;
    public static AccountConnectionInProgress accountConnectionInProgress;
    public static LandingPage.LoginPage login;
    public static HeaderComponent headerLogOutContainer;

    @BeforeClass
    public static void setup(){
        driver = new ChromeDriver();
        wait = new WebDriverWait(driver, 20);
        driver.get("http://psyquation.com/");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        headerLogOutContainer = new HeaderComponent(driver);
        login = new LandingPage.LoginPage(driver);
        rightDropDownMenu = new RightDropDownMenu(driver);
        myAccountsPage = new MyAccountsPage(driver);
        addingTradingAccountPage = new AddingTradingAccountPage(driver);
        addAccountPQTPage = new AddAccountPQTPage(driver);
        accountConnectionInProgress = new AccountConnectionInProgress(driver);
        }

    public void authorizationSuccessful(){
        headerLogOutContainer.signIn.click();
        login.emailField.sendKeys("kate@psyquation.com");
        login.passField.sendKeys("159753k");
        login.logInButton.click();
        wait.until(ExpectedConditions.invisibilityOf(login.logInButton));

    }

    /*@After
    public static void afterTest() {
        driver.quit();
    }*/

    public void openMyAccountsPage(){
        rightDropDownMenu.accountDropDownMenu.click();
        rightDropDownMenu.ManageAccountsItem.click();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void addNewAccountPQTSuccessfull(){
        authorizationSuccessful();
        openMyAccountsPage();
        wait.until(ExpectedConditions.elementToBeClickable(myAccountsPage.addNewAccountButton));
        myAccountsPage.addNewAccountButton.click();
        wait.until(ExpectedConditions.elementToBeClickable(addingTradingAccountPage.existingMT4button));
        addingTradingAccountPage.existingMT4button.click();

        wait.until(ExpectedConditions.visibilityOf(addAccountPQTPage.accountNumberInputField));
        //fill PQT adding form

        addAccountPQTPage.accountNumberInputField.click();
        addAccountPQTPage.accountNumberInputField.sendKeys(addAccountPQTPage.accountPQT);
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

        addAccountPQTPage.investorPasswordInputField.click();
        addAccountPQTPage.investorPasswordInputField.sendKeys(addAccountPQTPage.passwordPQT);
        //addAccountPQTPage.serverInputField.click();
        addAccountPQTPage.serverInputField.sendKeys(addAccountPQTPage.serverPQT);
        addAccountPQTPage.addAccountButton.click();

        wait.until(ExpectedConditions.elementToBeClickable(accountConnectionInProgress.myAccountsButton));

        accountConnectionInProgress.myAccountsButton.click();
        wait.until(ExpectedConditions.presenceOfElementLocated(By.cssSelector("h1[class=\"accounts__head-title\"]>span")));

        List<String> accNumbers = new ArrayList<String>();
        for (WebElement element:myAccountsPage.listWebElementsActiveAccounts) {
            accNumbers.add(element.getText());
        }
        assert(accNumbers.contains("#PQT0"+addAccountPQTPage.accountPQT));
        }



}
