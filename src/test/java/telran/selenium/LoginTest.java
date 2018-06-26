package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.selenium.pages.HomePageHelper;
import telran.selenium.pages.LoginPage;
import telran.selenium.pages.LoginRegistrationPage;
import telran.selenium.pages.MarketPlacePageHelper_Marina;

import java.util.concurrent.TimeUnit;

public class LoginTest extends TestBase {
    private HomePageHelper homepage;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private MarketPlacePageHelper_Marina marketPlace;
    private LoginRegistrationPage loginRegistrationPage;
    private LoginPage loginPage;


    @BeforeMethod(alwaysRun = true)
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        marketPlace = PageFactory.initElements(driver, MarketPlacePageHelper_Marina.class);
        loginRegistrationPage=PageFactory.initElements(driver,LoginRegistrationPage.class);
        loginPage=PageFactory.initElements(driver,LoginPage.class);

        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homepage.clickMarketPlace();
        marketPlace.waitUntilPageIsLoaded();
        marketPlace.clickLoginRegistrationButton();

    }
    @Test(groups = {"seller", "regression"}, dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationSeller")
    public void authorizationSeller(String email, String password){
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonSubmit();
        loginPage.waitUntilPageLoaded();
        Assert.assertTrue(loginPage.isLoginPage()&&loginPage.isUserRole().equals("поставщик"));

    }

    @Test(groups = {"buyer", "regression"}, dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationBuyer")
    public void authorizationBuyer(String email, String password) {
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonSubmit();
        loginPage.waitUntilPageLoaded();
        Assert.assertTrue(loginPage.isLoginPage()&&loginPage.isUserRole().equals("покупатель"));
    }

    @Test(groups = {"admin", "regression"}, dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationAdmin")
    public void authorizationAdmin(String email, String password) {
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonSubmit();
        loginPage.waitUntilPageLoaded();
        Assert.assertTrue(loginPage.isLoginPage()&&loginPage.isUserRole().equals("администратор"));
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationSeller")
    public void authorizationAndCancelSeller(String email, String password) {
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonCancel();
        loginPage.waitUntilPageIsLoadedCanсel();
        Assert.assertTrue(loginPage.isLoginPageCanсel());
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationBuyer")
    public void authorizationAndCancelBuyer(String email, String password) {
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonCancel();
        loginPage.waitUntilPageIsLoadedCanсel();
        Assert.assertTrue(loginPage.isLoginPageCanсel());
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveAuthorizationAdmin")
    public void authorizationAndCancelAdmin(String email, String password) {
        loginRegistrationPage.waitUntilPageLoaded()
                             .putTextToFieldEmail(email)
                             .putTextToFieldPassword(password)
                             .clickButtonCancel();
        loginPage.waitUntilPageIsLoadedCanсel();
        Assert.assertTrue(loginPage.isLoginPageCanсel());
    }
}
