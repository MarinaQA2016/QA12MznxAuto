package telran.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Inka on 14-May-18.
 */

public class ContactsInformationPage_Marina extends PageBase {

    @FindBy(xpath = "//*[contains(text(),'info@feedman.co.il')]")
    WebElement textEmail;

    public ContactsInformationPage_Marina(WebDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
    }


    public ContactsInformationPage_Marina waitUntilPageLoaded() {
        waitUntilIsLoadedCustomTime(textEmail,30);
        return this;
    }

    public boolean isContactsPage(){
        return exists(textEmail);
    }


}
