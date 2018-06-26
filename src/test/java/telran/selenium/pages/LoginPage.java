package telran.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage extends PageBase {

    @FindBy(xpath = "//p[contains(text(),'Личный кабинет')]")
    WebElement confirmationOfEntry;

    @FindBy(xpath = "//p[contains(text(),'Вход/Регистрация')]")
    WebElement cancel;

    @FindBy(xpath = "//p[contains(text(),'Личный кабинет')]/..//span [@class ='']")
    WebElement userRole;

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    public void waitUntilPageLoaded() {
        this.waitUntilIsLoadedCustomTime(confirmationOfEntry,40);

    }

    public boolean isLoginPage() {
        return exists(confirmationOfEntry);
    }

    public LoginPage waitUntilPageIsLoadedCanсel() {
        this.waitUntilIsLoadedCustomTime(cancel,40);
        return this;
    }

    public boolean isLoginPageCanсel() {
        return exists(cancel);
    }

    public String isUserRole(){
        return userRole.getText();
    }
}
