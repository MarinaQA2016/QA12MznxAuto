package telran.selenium.pages;

import org.openqa.selenium.*;
import org.openqa.selenium.support.Color;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.CharsetEncoder;

/**
 * Abstract class representation of a Page in the UI. Page object pattern
 */
public abstract class PageBase {

  protected WebDriver driver;
  public String PAGE_URL;
  public String PAGE_TITLE;


  public PageBase(WebDriver driver) {
    this.driver = driver;
  }

  public String getTitle() {
    return driver.getTitle();
  }

  public void goBackBrowserButton() {
    driver.navigate().back();
  }

  public void goForwardBrowserButton() {
    driver.navigate().forward();
  }

  public void reloadPage() {
    driver.navigate().refresh();
  }


  public void typeTextField(WebElement el, String text){
    el.click();
    el.clear();
    el.sendKeys(text);
  }

  public String getPageUrl() {

    return PAGE_URL;
  }

  public String getPageTitle() {
    return PAGE_TITLE;
  }

  public void loadPage() {
    driver.get(getPageUrl());
//  Assert.assertEquals(getTitle(), getPageTitle());
  }

  public void setElementText(WebElement element, String text) {
    element.click();
    element.clear();
    //Log.info("entering text '" + text + "' into element " + element);
    element.sendKeys(text);
    // Assert.assertEquals(element.getAttribute("value"), text);
  }


  public void clickElement(WebElement element) {
    // Log.info("clicking on element " + element + "");
    element.click();
  }

  public void waitUntilIsLoadedCustomTime(WebElement element, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      e.printStackTrace();
    }
  }
  public void waitUntilAlertIsLoaded(int time){
    try {
      new WebDriverWait(driver, 40).until(ExpectedConditions.alertIsPresent());
    } catch (Exception e) {
      e.printStackTrace();
    }
  }

  public void waitUntilIsLoaded(WebElement element) {
    try {
      new WebDriverWait(driver, 7).until(ExpectedConditions.visibilityOf(element));
    } catch (Exception e) {
      // Log.info("---------------------------------");
      // Log.info("element " + element + " can not be found by ExpectedConditions.visibilityOf(element)");
      //  Log.info("---------------------------------");
      e.printStackTrace();
    }
  }

  public void waitUntilIsAttributeCustomTime(WebElement element, String attribute, String value, int time) {
    try {
      new WebDriverWait(driver, time).until(ExpectedConditions.attributeContains(element, attribute,value));
    } catch (Exception e) {
      // Log.info("---------------------------------");
      // Log.info("element " + element + " can not be found by ExpectedConditions.elementToBeSelected(element)");
      //  Log.info("---------------------------------");
      e.printStackTrace();
    }
  }

  // public void selectValueInDropdown(WebElement dropdown, String value) {
  //   Select select = new Select(dropdown);
  //  select.selectByValue(value);
  // }

  // Returns label that we chose
  public String selectValueInDropdown(WebElement dropdown, String value) {
    Select select = new Select(dropdown);
    select.selectByValue(value);
    WebElement option = select.getFirstSelectedOption(); // Chooses label that fits the value
    return option.getText();
  }

  public void selectValueInDropdownbyText(WebElement dropdown, String value) {
    Select select = new Select(dropdown);
    select.selectByVisibleText(value);

  }

  public boolean verifyElementIsPresent(WebElement element) {
    try {
      element.getTagName();
      return true;
    } catch (NoSuchElementException e) {
      //  Log.info("---------------------------------");
      //  Log.info("element " + element + " can not be found by  element.getTagName()");
      //   Log.info("---------------------------------");
      return false;
    }
  }

  public void verifyText(WebElement element, String text) {
    try {
      Assert.assertEquals(text, element.getText());
    } catch (Error e) {

    }
  }

  public boolean verifyTextBoolean(WebElement element, String text) {
    //  Log.info("verifying that text from element " + element + " - ('" + element.getText() + "') - is equal to text '" + text + "'");
    return text.equals(element.getText());
  }

  // Verifies that we chose the label that we wanted.
  public boolean verifyTextBooleanInDropDown(String label, String chosenOption) {
    return chosenOption.equals(label);
  }

  public boolean exists(WebElement element) {
    try {
      return element.isDisplayed();
    } catch (NoSuchElementException ignored) {
      return false;
    }
  }

  public void waitUntilElementIsLoaded(WebElement element) throws IOException, InterruptedException {
    new WebDriverWait(driver, 30).until(ExpectedConditions.visibilityOf(element));
  }

  public void waitUntilElementIsDisappeared (String id) throws IOException, InterruptedException {
    new WebDriverWait(driver, 25).until(ExpectedConditions.invisibilityOfElementLocated(By.id(id)));
  }

  public void moveMouseOverElement(WebElement element) {
    String javaScript = "var evObj = document.createEvent('MouseEvents');" +
            "evObj.initMouseEvent(\"mouseover\",true, false, window, 0, 0, 0, 0, 0, false, false, false, false, 0, null);" +
            "arguments[0].dispatchEvent(evObj);";


    ((JavascriptExecutor) driver).executeScript(javaScript, element);
  }
  public void waitForElement(WebDriverWait wait, String element) {
    wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(element)));
  }

  // Pay attention: Works Only for first cell
  public boolean IsCellGreenAfterClick(WebElement locator) {
    clickElement(locator);
    // Is it Green?
    return "#008000".equals(Color.fromString(locator.getCssValue("background-color")).asHex());
  }

  public boolean IsCellColorChangedAfterClick(WebElement cell) {
    String cellColorBeforeClick = Color.fromString(cell.getCssValue("background-color")).asHex();
    clickElement(cell);
    String cellColorAfterClick = Color.fromString(cell.getCssValue("background-color")).asHex();
    return !cellColorBeforeClick.equals(cellColorAfterClick);
  }
  //"ISO-8859-1" for ISO Latin 1, US-ASCII -for USA, CP862 for hebrew, CP855 for cyrillic
  static CharsetEncoder asciiEncoderHE =
          Charset.forName("CP862").newEncoder();
  static CharsetEncoder asciiEncoderEN =
          Charset.forName("US-ASCII").newEncoder();
  static CharsetEncoder asciiEncoderRu =
          Charset.forName("CP855").newEncoder();


  public boolean isPureAscii(String language, String v) {
    // System.out.println("isPureAscii language - "+language);
    //System.out.println("isPureAscii v - "+v);
    switch (language.toLowerCase()) {
      case "he": return (!asciiEncoderEN.canEncode(v) && asciiEncoderHE.canEncode(v));
      case "en": return asciiEncoderEN.canEncode(v);
      case "ru": return (!asciiEncoderEN.canEncode(v) && asciiEncoderRu.canEncode(v));
      default: return false;
    }
  }

}
