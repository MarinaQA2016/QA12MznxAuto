package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.Alert;
import org.openqa.selenium.NoAlertPresentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Wait;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.selenium.pages.HomePageHelper;
import telran.selenium.pages.LoginRegistrationPage;
import telran.selenium.pages.MarketPlacePageHelper_Marina;
import telran.selenium.pages.RegistrationPage;

import java.util.concurrent.TimeUnit;

public class RegistrationTest extends TestBase {
    private HomePageHelper homepage;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private MarketPlacePageHelper_Marina marketPlace;
    private LoginRegistrationPage loginRegistrationPage;
    private RegistrationPage registrationPage;
    private Alert alert;
    private Wait wait;

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
        System.out.println("isAlert:" + isAlertPresent(driver));
        //safeAlertDissmiss();
        //alert = driver.switchTo().alert();
        //alert.dismiss();
    }


    @Test(/*dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationSeller"*/)
    public void goToRegistrationPageSeller(/*String email,String phofen,String userName,
                                           String companyName,String password1 ,String password2*/){
        String email = "mmmm99@hhhh";
        String phoneNumber = "8 903 454 24 99";
        String userName = "Petya99";
        String companyName = "R&K99";
        String password1 = "12345678Aa";
        String password2 = "12345678Aa";
        loginRegistrationPage.clickButtonRegistration()
                             .waitUntilPageLoadedRegistration()
                             .clickButtonSeller()
                             .putTextToFielMailRegistration(email)
                             .putTextToFieldPhoneRegistration(phoneNumber)
                             .putTextToFieldLoginRegistration(userName)
                             .putTextToFieldnewCompanyName(companyName)
                             .putTextToFieldPasswordRegistration1(password1)
                             .putTextToFieldPasswordRegistration2(password2)
                             .clickButtonOfferRegistration()
                             .clickButtonCreateUser()
                             .waitUntilAlertIsLoaded(40);
        alert = driver.switchTo().alert();
        System.out.println("Text of the alert: " + alert.getText());
        alert.accept();


        loginRegistrationPage.clickButtonCreateUser();
        registrationPage.waitUntilPageLoaded();


        Assert.assertTrue(registrationPage.isRegistrationPage());
    }

    @Test(dataProviderClass = DataProviders.class, dataProvider = "positiveRegistrationBuyer")
    public void goToRegistrationPageBuyer(String email,String phofen,String userName,
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
                             .clickButtonCreateUser()
                             .waitUntilAlertIsLoaded(40);
        alert = driver.switchTo().alert();
        registrationPage.waitUntilPageLoaded();
        Assert.assertTrue(registrationPage.isRegistrationPage());
    }



    public boolean isAlertPresent(WebDriver wd) {
        try {
            wd.switchTo().alert();
            return true;
        } catch (NoAlertPresentException e) {
            return false;
        }
    }
    protected void safeAlertDissmiss() {
        try {
            driver.switchTo().alert().dismiss();
        } catch (NoAlertPresentException e) {
            // ничего не делаем, алерта итак нет
        }
    }

}
