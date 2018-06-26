package telran.selenium;

import org.apache.log4j.Logger;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import telran.selenium.pages.HomePageHelper;
import telran.selenium.pages.MarketPlacePageHelper_Marina;

import java.util.concurrent.TimeUnit;

public class HomePageTest extends TestBase {

  private HomePageHelper homepage;
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());
  private MarketPlacePageHelper_Marina marketPlace;


  @BeforeMethod
  public void initPageObjects() {

    homepage = PageFactory.initElements(driver, HomePageHelper.class);
    marketPlace = PageFactory.initElements(driver, MarketPlacePageHelper_Marina.class);
    driver.get(baseUrl);
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  // ---this test verifies that all elements on HomePage screen are in Russian ---
  @Test
  public void allElemetsInRussian() {

    Log.info("---- Test allElementsInRussian is executed -----");
    Log.info("User presses Russian language button");
    homepage.clickLangRussian();
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

    Log.info("Timeout - wait 30 sec");
    Assert.assertTrue(homepage.allElementsInRus());
  }

  // --- this test verifies that all elements on HomePage screen are in English ---
  @Test
  public void allElemetsInEnglish() {
    Log.info("---- Test allElementsInEnglish is executed -----");
    Log.info("User presses English language button");
    homepage.clickLangEnglish();
    Log.info("Timeout - wait 30 sec");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    //homepage.writeTextOfMenuCommands();
    Assert.assertTrue(homepage.allElementsInEng());
  }

  // --- this test verifies that all elements on HomePage screen are in Hebrew ---
  @Test
  public void allElemetsInHebrew() {
    Log.info("---- Test allElementsInHebrew is executed -----");
    Log.info("User presses Hebrew language button");
    homepage.clickLangHebrew();

    Log.info("Timeout - wait 30 sec");
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
   // System.out.println(homepage.textFromBuyersAbilities());
    //homepage.writeTextOfMenuCommands();
    Assert.assertTrue(homepage.allElementsInHebrew());
  }

  @Test
  public void goToMarketPlace(){
    homepage.clickMarketPlace();
    marketPlace.waitUntilPageIsLoaded();
    Assert.assertTrue(marketPlace.isMarketPlacePage());
  }



}
