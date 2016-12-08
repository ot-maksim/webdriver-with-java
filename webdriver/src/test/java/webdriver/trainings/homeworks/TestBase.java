package webdriver.trainings.homeworks;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

/**
 * Created by maksym on 11/23/16.
 */
public class TestBase {
  protected WebDriver driver;
  protected Wait wait;
  protected Wait fluentWait;

  public static Function<WebDriver, Boolean> isQuantityChanged(final By locator, final Integer quantity) {
    return (WebDriver webDriver) -> Integer.parseInt(webDriver.findElement(locator).getText()) == (quantity);
  }

  @BeforeClass
  public void startBrowser() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    fluentWait = new FluentWait<>(driver)
            .withTimeout(10, TimeUnit.MILLISECONDS)
            .ignoring(NoSuchElementException.class);
  }

  @AfterClass
  public void stopBrowser() {
    driver.quit();
    driver = null;
  }

  protected boolean isFieldOrTextAreaEmpty(By locator) {
    WebElement textFieldOrTextArea = driver.findElement(locator);
    String valueAttibute = textFieldOrTextArea.getAttribute("value");
    if (valueAttibute != null) {
      return valueAttibute.isEmpty();
    } else {
      return textFieldOrTextArea.getText().isEmpty();
    }
  }

  protected void clearField(By locator) {
    if (!isFieldOrTextAreaEmpty(locator)) {
      driver.findElement(locator).clear();
    }
  }

  protected void sendKeys(By locator, String text) {
    driver.findElement(locator).sendKeys(Keys.chord(text));
  }

  protected void typeText(By locator, String text) {
    clearField(locator);
    sendKeys(locator, text);
  }

  protected void click(By locator) {
    driver.findElement(locator).click();
  }

  protected void click(By locator, int index) {
    driver.findElements(locator).get(index).click();
  }

  protected void loginAsUser(By loginFieldLocator, By passwordFieldLocator, By loginButtonLocator, User user) {
    typeText(loginFieldLocator, user.getEmail());
    typeText(passwordFieldLocator, user.getPassword());
    click(loginButtonLocator);
  }

  protected void logoutUser(By locator) {
    click(locator);
  }

  protected void goTo(String URL) {
    driver.get(URL);
  }

  protected void initNewAccountCreation(By locator) {
    click(locator);
  }

  protected void submitNewAccoutCreationForm(By locator) {
    click(locator);
  }

  protected void attachImage(By locator, String pathToImage) {
    String duckHorror = Paths.get(pathToImage).toAbsolutePath().toString();
    driver.findElement(locator).sendKeys(duckHorror);
  }

  protected void selectItemByIndex(By locator, int index) {
    WebElement dropBoxElement = driver.findElement(locator);
    Select select = new Select(dropBoxElement);
    if (select.getOptions().size() > 1) {
      select.selectByIndex(index);
    }
  }

  protected void selectCheckBox(By locator) {
    WebElement checkBox = driver.findElement(locator);
    if (checkBox.getAttribute("checked") == null) {
      checkBox.click();
    }
  }

  protected void selectCheckBox(By locator, int index) {
    WebElement checkBox = driver.findElements(locator).get(index);
    if (checkBox.getAttribute("checked") == null) {
      checkBox.click();
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      driver.findElement(locator);
      return true;
    } catch (WebDriverException ex) {
      return false;
    }
  }
}