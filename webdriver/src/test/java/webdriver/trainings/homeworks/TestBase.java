package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

/**
 * Created by maksym on 11/23/16.
 */
public class TestBase {
  protected WebDriver driver;
  protected Wait wait;

  @BeforeClass
  public void startBrwoser() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @AfterClass
  public void stopBrowser() {
    driver.quit();
    driver = null;
  }

  protected boolean isFieldEmpty(By locator) {
    return driver.findElement(locator).getAttribute("value").isEmpty();
  }

  protected void clearField(By locator) {
    if (!isFieldEmpty(locator)) {
      driver.findElement(locator).clear();
    }
  }

  protected void sendKeys(By locator, String text) {
    driver.findElement(locator).sendKeys(text);
  }

  protected void click(By selector) {
    driver.findElement(selector).click();
  }

  protected void loginAsUser(By loginFieldLocator, By passwordFieldLocator, By loginButtonLocator, User user) {
    typeText(loginFieldLocator, user.getEmail());
    typeText(passwordFieldLocator, user.getPassword());
    click(loginButtonLocator);
  }

  protected void typeText(By locator, String text) {
    clearField(locator);
    sendKeys(locator, text);
  }

  protected void goTo(String URL) {
    driver.get(URL);
  }

  protected void logoutUser(By locator) {
    click(locator);
  }

  protected void submitNewAccoutCreationForm(By locator) {
    click(locator);
  }

  protected void initNewAccountCreation(By locator) {
    click(locator);
  }
}