package telran.selenium.pages;

import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import telran.selenium.LogLog4j;

import java.util.List;

/**
 * Created by Inka on 21-Apr-18.
 */



public class MarketPlacePageHelper_Marina extends PageBase {
    private static Logger Log = Logger.getLogger(LogLog4j.class.getName());

    @FindBy(css = ".divTop")
    List<WebElement> topOptions;

    @FindBy(xpath = "//*[@ng-click=\"toPage('contacts')\"]")
    WebElement contactsMenu;

    @FindBy(xpath = "//div[@ng-show=\"user.login == 'guest'\"]")
    WebElement buttonLoginRegistration;


    public MarketPlacePageHelper_Marina(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }
    //WebElement enterOption = topOptions.get(1);
   // WebElement controlPanelOption = topOptions.get(0);


    public MarketPlacePageHelper_Marina waitUntilPageIsLoaded() {
        WebElement enterOption = defineEnterOption();
         waitUntilIsLoadedCustomTime((enterOption),30);
        //Log.info("enterOption:" + enterOption.getText());
        return this;

    }

    public boolean isMarketPlacePage(){
        return exists(topOptions.get(1));
    }

    private WebElement defineEnterOption() {

        for (WebElement el : topOptions) {
            if (el.getText().equals("Вход/Регистрация"))
                return el;

        }

        return null;
    }

    public void clickContactsMenu() {
        contactsMenu.click();
    }

    public void clickLoginRegistrationButton() {
        this.buttonLoginRegistration.click();
    }
}
