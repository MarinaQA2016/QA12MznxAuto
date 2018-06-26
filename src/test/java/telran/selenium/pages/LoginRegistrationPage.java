package telran.selenium.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginRegistrationPage extends PageBase {
    @FindBy(xpath = "//input[@id='username']")
    WebElement emailField;
    @FindBy(xpath = "//input[@id='password']")
    WebElement passwordField;

    @FindBy(xpath = "//h4[contains(text(),'Регистрация')]")
    WebElement registration;

    @FindBy(xpath = "//input[@id='username']")
    WebElement email;

    @FindBy(xpath = "//input[@id='password']")
    WebElement password;

    @FindBy(xpath = "//button[@type='submit']")
    WebElement buttonSubmit;

    @FindBy(xpath = "//a[@class='flipper'][contains(text(),'Регистрация')]")
    WebElement buttonRegistration;

    @FindBy(xpath = "//input[@id='seller']")
    WebElement buttonSeller;

    @FindBy(xpath = "//input[@id='buyer']")
    WebElement buttonBuyer;

    @FindBy(xpath = "//input[@id='mailRegistration']")
    WebElement mailRegistration;

    @FindBy(xpath = "//input[@id='phoneRegistration']")
    WebElement phoneRegistration;

    @FindBy(xpath = "//input[@id='loginRegistration']")
    WebElement nameUser;

    @FindBy(xpath = "//input[@placeholder='Введите название компании']")
    WebElement nameCompany;

    @FindBy(xpath = "//input[@id='passwordRegistration1']")
    WebElement passwordRegistration1;

    @FindBy(xpath = "//input[@id='passwordRegistration2']")
    WebElement passwordRegistration2;

    @FindBy(xpath = "//input[@id='offerRegistration']")
    WebElement offerRegistration;

    @FindBy(xpath = "//button[@class='personalPageBtnRed'][contains(text(),'Создать пользователя')]")
    WebElement buttonCreateUser;

    @FindBy(xpath = "//button[@class='personalPageBtnRed'][contains(text(),'Отмена')]")
    WebElement buttonCancel;

    @FindBy(xpath = "//button[@type='button']")
    WebElement buttonCancelRegistration;



    public LoginRegistrationPage(WebDriver driver) {
        super(driver);
    }

    public LoginRegistrationPage waitUntilPageLoaded() {
        this.waitUntilIsLoadedCustomTime(emailField,40);
        this.waitUntilIsLoadedCustomTime(passwordField,40);
        this.waitUntilIsLoadedCustomTime(buttonSubmit,40);
        return this;

    }

    public boolean isLoginRegistrationPage() {
        return exists(emailField);
    }

    public LoginRegistrationPage putTextToFieldEmail(String text) {
        typeTextField(email,text);
        return this;
    }
    public LoginRegistrationPage putTextToFieldPassword(String text) {
        typeTextField(password,text);
        return this;
    }

    public LoginRegistrationPage clickButtonSubmit() {
        buttonSubmit.click();
        return this;
    }

    public LoginRegistrationPage clickButtonRegistration() {
        buttonRegistration.click();
        return this;
    }

    public LoginRegistrationPage waitUntilPageLoadedRegistration() {
        this.waitUntilIsLoadedCustomTime(registration,40);
        return  this;
    }

    public LoginRegistrationPage clickButtonSeller() {
        buttonSeller.click();
        return this;
    }

    public LoginRegistrationPage putTextToFielMailRegistration(String text) {
        typeTextField(mailRegistration,text);
        return this;
    }

    public LoginRegistrationPage putTextToFieldPhoneRegistration(String text) {
        typeTextField(phoneRegistration,text);
        return this;
    }

    public LoginRegistrationPage putTextToFieldLoginRegistration(String text) {
        typeTextField(nameUser,text);
        return this;
    }

    public LoginRegistrationPage putTextToFieldnewCompanyName(String text) {
        typeTextField(nameCompany,text);
        return this;
    }

    public LoginRegistrationPage putTextToFieldPasswordRegistration1(String text) {
        typeTextField(passwordRegistration1,text);
        return this;
    }

    public LoginRegistrationPage putTextToFieldPasswordRegistration2(String text) {
        typeTextField(passwordRegistration2,text);
        return this;
    }

    public LoginRegistrationPage clickButtonOfferRegistration() {
        offerRegistration.click();
        return this;
    }

    public LoginRegistrationPage clickButtonCreateUser() {
        buttonCreateUser.click();
        return this;
    }

    public boolean isRegistrationPage() {
        return exists(buttonCreateUser);
    }

    public LoginRegistrationPage clickButtonCancel() {
        buttonCancel.click();
        return this;
    }

    public LoginRegistrationPage clickButtonBuyer() {
      buttonBuyer.click();
      return this;
    }

    public LoginRegistrationPage clickButtonCancelRegistration() {
        buttonCancelRegistration.click();
        return  this;
    }
}
