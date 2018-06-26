package telran.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class RegistrationPage extends PageBase {

    @FindBy(xpath = "//h4[contains(text(),'Данные компании')]")
    WebElement companyData;

    @FindBy(xpath = "//p[contains(text(),'Вход/Регистрация')]")
    WebElement cancelRegistration;

    public RegistrationPage(WebDriver driver) {
        super(driver);
    }

    public RegistrationPage waitUntilPageLoaded() {
        this.waitUntilIsLoadedCustomTime(companyData,40);
        return this;
    }

    public boolean isRegistrationPage() {
        return exists(companyData);
    }

    public RegistrationPage waitUntilPageIsLoadedCancel() {
        this.waitUntilIsLoadedCustomTime(cancelRegistration,40);
        return this;
    }


    public boolean isLoginPageCancel() {
        return exists(cancelRegistration);
    }
}
