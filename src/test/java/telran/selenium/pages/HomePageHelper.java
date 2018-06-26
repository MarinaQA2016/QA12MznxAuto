package telran.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import telran.selenium.LogLog4j;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Sample page
 */
public class HomePageHelper extends PageBase {

//for logging
  private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

//elements definition

  @FindBy(xpath = "//p[@class = 'nav']/a[contains(text(),'Я ПРОДАВЕЦ')]")
  WebElement imSellerMenu;

  @FindBy(xpath = "//p[@class = 'nav']/a[contains(text(),'Я ПОКУПАТЕЛЬ')]")
  WebElement imBuyerMenu;

  @FindBy(xpath = "//p[@class = 'nav']/a[contains(text(),'ТОРГОВАЯ ПЛОЩАДКА')]")
  WebElement marketPlaceMenu;

  @FindBy (xpath = "//button[@class = 'flag']/img[@alt = 'russian']")
  WebElement languageRus;

  @FindBy (xpath = "//button[@class = 'flag']/img[@alt = 'english']")
  WebElement languageEngl;

  @FindBy (xpath = "//button[@class = 'flag']/img[@alt = 'hebrew']")
  WebElement languageHebrew;

  @FindBy(className  = "flag")
  List<WebElement> languagesButtons;

  @FindBy(className = "nav")
  List<WebElement> menuCommands;

  // Elements on the screen

  @FindBy(css = "span.ng-binding")
  WebElement centralText;

  @FindBy(className = "message")
  WebElement centralMessage;

  @FindBy(id = "screen4")
  WebElement advertisingBlock;

  @FindBy (css = ".sc2")
  WebElement sellersAbiities;

  @FindBy (css = ".sc3")
  WebElement buyersAbiities;





  public HomePageHelper(WebDriver webDriver) {

    super(webDriver);
    PageFactory.initElements(driver, this);
  }

  //methods

  public HomePageHelper clickLangRussian(){
    this.languageRus.click();
    return this;
  }

  public HomePageHelper clickLangEnglish(){
    this.languageEngl.click();
    return this;
  }

  public HomePageHelper clickLangHebrew(){
    this.languageHebrew.click();
    return this;
  }
  public HomePageHelper clickImSellerMenu(){
    this.imSellerMenu.click();
    return this;
  }
  public HomePageHelper clickImBuyerMenu(){
    this.imBuyerMenu.click();
    return this;
  }
  public HomePageHelper clickMarketPlace(){
     this.marketPlaceMenu.click();

    return this;
  }

  public boolean allElementsInRus() {
    Log.info("allElementsInRus method (class HomePageHelper) is started");

    //another elements from HomePage verification, russian language
    Log.info("text in the central message is in Russian");
    if (!this.isPureAscii("ru", this.textFromCentralMessage())) return false;
    Log.info("text in the advertising block is in Russian");
    if (!this.isPureAscii("ru", this.textFromAdvBlock())) return false;
    Log.info("text in the sellers abilities block is in Russian");
    if (!this.isPureAscii("ru", this.textFromSellerAbilities())) return false;
    Log.info("text in the buyers abilities block is in Russian");
    if (!this.isPureAscii("ru", this.textFromBuyersAbilities())) return false;

    //menu commands verification, russian language
    Log.info("text in the menu commands is in Russian");
    if (!allMenuCommandsInLang("ru")) return false;
    Log.info("allElementsInRus: all elements are in Russian");
    return true;
  }

  public boolean allElementsInEng() {
    Log.info("allElementsInEng method (class HomePageHelper) is started");

    //another elements from HomePage verification, english language
    Log.info("text in the central message is in English");
    if (!this.isPureAscii("en", this.textFromCentralMessage())) return false;
    Log.info("text in advertising block is in English");
    if (!this.isPureAscii("en", this.textFromAdvBlock())) return false;
    Log.info("text in buyers abilities block is in English");
    if (!this.isPureAscii("en", this.textFromBuyersAbilities())) return false;
    Log.info("text in sellers abilities block is in English");
    if (!this.isPureAscii("en", this.textFromSellerAbilities())) return false;

    //menu commands verification, englisn language
    Log.info("text in menu commands is in English");
    if (!allMenuCommandsInLang("en")) return false;
    Log.info("allElementsInEng: all elements are in English");
    return true;
  }

  public boolean allElementsInHebrew(){
    Log.info("allElementsInHebrew method (class HomePageHelper) is started");

    //another elements from HomePage verification, hebrew language
    Log.info("text in the central message is in Hebrew");
    if (!this.isPureAscii("he", this.textFromCentralMessage())) return false;
    Log.info("text in advertising block is in Hebrew");
    if (!this.isPureAscii("he", this.textFromAdvBlock())) return false;
    Log.info("text in buyers abilities block is in Hebrew");
    if (!this.isPureAscii("he", this.textFromBuyersAbilities())) return false;
    Log.info("text in sellers abilities block is in Hebrew");
    if (!this.isPureAscii("he", this.textFromSellerAbilities())) return false;
    System.out.println(this.textFromSellerAbilities());

    //menu commands verification, hebrew language
    Log.info("text in menu commands is in Hebrew");
    if (!allMenuCommandsInLang("he")) return false;
    Log.info("allElementsInHebrew: all elements are in Hebrew");
    return true;
  }


  private boolean allMenuCommandsInLang(String lang) {
    String names[];
    switch (lang){
      case "ru": names = new String[]{"Я ПОСТАВЩИК", "Я ПОКУПАТЕЛЬ", "ТОРГОВАЯ ПЛОЩАДКА"};break;
      case "en": names = new String[] {"I AM SELLER", "I AM BUYER", "MARKET PLACE"};break;
      case "he": names = new String[] {"אני מוכר","אני קונה","רְחָבַת שׁוּק"};break;
      default:  return false;
    }
    List<String> namesList = new ArrayList<String>(Arrays.asList(names));
    for(WebElement el : menuCommands){
      if (!namesList.contains(el.getText())) return false;
    }
    return true;
  }

  public String textFromCentralMessage(){
    return centralMessage.getText();
  }

  public String textFromAdvBlock(){
    return advertisingBlock.getText();
  }

  public String textFromSellerAbilities(){
    return sellersAbiities.getText();
  }

  public String textFromBuyersAbilities(){
    return buyersAbiities.getText();
  }



  // ----- just for code testing ----------
  public HomePageHelper writeTextOfButtons(){
    System.out.println ("Quantity of elements: " + languagesButtons.size());
    for(WebElement el : languagesButtons){
      System.out.println("Tag Name: " + el.getTagName());
      System.out.println("attr: ng-click - " + el.getAttribute("ng-click"));
    }
    return this;
  }

  // ----- just for code testing ----------
  public HomePageHelper writeTextOfMenuCommands(){
    System.out.println ("Quantity of elements: " + menuCommands.size());
    for(WebElement el : menuCommands){
      System.out.println("Name of menu: " + el.getText());
    }
    return this;
  }

}
