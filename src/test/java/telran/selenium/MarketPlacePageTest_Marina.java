package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.selenium.pages.ContactsInformationPage_Marina;
import telran.selenium.pages.HomePageHelper;
import telran.selenium.pages.MarketPlacePageHelper_Marina;

import java.util.concurrent.TimeUnit;

/**
 * Created by Inka on 14-May-18.
 */
public class MarketPlacePageTest_Marina extends TestBase {

    private HomePageHelper homepage;
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
    private MarketPlacePageHelper_Marina marketPlace;
    private ContactsInformationPage_Marina contactsInfoPage;

    @BeforeMethod
    public void initPageObjects() {

        homepage = PageFactory.initElements(driver, HomePageHelper.class);
        marketPlace = PageFactory.initElements(driver, MarketPlacePageHelper_Marina.class);
        contactsInfoPage = PageFactory.initElements(driver, ContactsInformationPage_Marina.class);
        driver.get(baseUrl);
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
        homepage.clickMarketPlace();
        marketPlace.waitUntilPageIsLoaded();
    }

    @Test
    public void goToContacts(){
        marketPlace.clickContactsMenu();
        contactsInfoPage.waitUntilPageLoaded();
        Assert.assertTrue(contactsInfoPage.isContactsPage());

    }

}
