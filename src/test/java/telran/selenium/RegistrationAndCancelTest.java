package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.selenium.pages.HomePageHelper;
import telran.selenium.pages.LoginRegistrationPage;
import telran.selenium.pages.MarketPlacePageHelper_Marina;
import telran.selenium.pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationAndCancelTest extends TestBase {
    private HomePageHelper homepage;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private MarketPlacePageHelper_Marina marketPlace;
    private LoginRegistrationPage loginRegistrationPage;
    private RegistrationPage registrationPage;

    @BeforeMethod
    public void initPageObjects() {
        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        marketPlace = PageFactory.initElements(driver, MarketPlacePageHelper_Marina.class);
        loginRegistrationPage=PageFactory.initElements(driver,LoginRegistrationPage.class);
        registrationPage=PageFactory.initElements(driver,RegistrationPage.class);

        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homepage.clickMarketPlace();
        marketPlace.waitUntilPageIsLoaded();
        marketPlace.clickLoginRegistrationButton();
        loginRegistrationPage.waitUntilPageLoaded();
        Assert.assertTrue(loginRegistrationPage.isLoginRegistrationPage());

    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationSeller")
    public void goToRegistrationPageSellerCansel(String email,String phofen,String userName,
                                           String companyName,String password1 ,String password2){
        loginRegistrationPage.clickButtonRegistration()
                             .waitUntilPageLoadedRegistration()
                             .clickButtonSeller()
                             .putTextToFielMailRegistration(email)
                             .putTextToFieldPhoneRegistration(phofen)
                             .putTextToFieldLoginRegistration(userName)
                             .putTextToFieldnewCompanyName(companyName)
                             .putTextToFieldPasswordRegistration1(password1)
                             .putTextToFieldPasswordRegistration2(password2)
                             .clickButtonOfferRegistration()
                             .clickButtonCancelRegistration();
        registrationPage.waitUntilPageIsLoadedCancel();
        Assert.assertTrue(registrationPage.isLoginPageCancel());
    }
    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationBuyer")
    public void goToRegistrationPageBuyerCansel(String email,String phofen,String userName,
                                                 String companyName,String password1 ,String password2){
        loginRegistrationPage.clickButtonRegistration()
                             .waitUntilPageLoadedRegistration()
                             .clickButtonBuyer()
                             .putTextToFielMailRegistration(email)
                             .putTextToFieldPhoneRegistration(phofen)
                             .putTextToFieldLoginRegistration(userName)
                             .putTextToFieldnewCompanyName(companyName)
                             .putTextToFieldPasswordRegistration1(password1)
                             .putTextToFieldPasswordRegistration2(password2)
                             .clickButtonOfferRegistration()
                             .clickButtonCancelRegistration();
        registrationPage.waitUntilPageIsLoadedCancel();
        Assert.assertTrue(registrationPage.isLoginPageCancel());
    }
}
