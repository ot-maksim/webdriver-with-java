package webdriver.trainings.homeworks.tests;

import com.google.common.base.Function;
import org.openqa.selenium.*;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.BrowserType;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeSuite;
import webdriver.trainings.homeworks.app.Application;
import webdriver.trainings.homeworks.model.User;

import java.net.MalformedURLException;
import java.nio.file.Paths;
import java.util.NoSuchElementException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * Created by maksym on 11/23/16.
 */
public class TestBase {
//  protected WebDriver driver;
//  protected Wait wait;
//  protected Wait fluentWait;
//  protected BrowserMobProxy proxy;
//  protected Proxy proxy;

  protected Application app;

//  public static final String USERNAME = "maksim109";
//  public static final String AUTOMATE_KEY = "dUzpyKw6Fx98MeaH7NH8";
//  public static final String URL = "https://" + USERNAME + ":" + AUTOMATE_KEY + "@hub-cloud.browserstack.com/wd/hub";

  @BeforeSuite
  public void startBrowser() {
    app = new Application();
//    app.startBrowser();
//    // Windows
//    DesiredCapabilities ieWin = new DesiredCapabilities();
//    ieWin.setBrowserName(BrowserType.IE);
//    ieWin.setPlatform(Platform.WINDOWS);
//
//    DesiredCapabilities chromeWin = new DesiredCapabilities();
//    chromeWin.setBrowserName(BrowserType.CHROME);
//    chromeWin.setPlatform(Platform.WINDOWS);
//
//    DesiredCapabilities foxWin = new DesiredCapabilities();
//    foxWin.setCapability(FirefoxDriver.MARIONETTE, false);
//    foxWin.setBrowserName(BrowserType.FIREFOX);
//    foxWin.setPlatform(Platform.WINDOWS);
//
//    //Mac
//    DesiredCapabilities chromeMac = new DesiredCapabilities();
//    chromeMac.setBrowserName(BrowserType.CHROME);
//    chromeMac.setPlatform(Platform.MAC);
//
//    DesiredCapabilities foxMac = new DesiredCapabilities();
//    foxMac.setCapability(FirefoxDriver.MARIONETTE, false);
//    foxMac.setBrowserName(BrowserType.FIREFOX);
//    foxMac.setPlatform(Platform.MAC);
//
//    DesiredCapabilities safariMac = new DesiredCapabilities();
//    safariMac.setBrowserName(BrowserType.SAFARI);
//    safariMac.setPlatform(Platform.MAC);
//
//    //Linux
//    DesiredCapabilities chromeLinux = new DesiredCapabilities();
//    chromeLinux.setBrowserName(BrowserType.CHROME);
//    chromeLinux.setPlatform(Platform.LINUX);
//
//    DesiredCapabilities foxLinux = new DesiredCapabilities();
//    foxLinux.setCapability(FirefoxDriver.MARIONETTE, false);
//    foxLinux.setBrowserName(BrowserType.FIREFOX);
//    foxLinux.setPlatform(Platform.LINUX);
//
//    // browserstack.com caps
//    DesiredCapabilities caps = new DesiredCapabilities();
//    caps.setCapability("browser", "IE");
//    caps.setCapability("browser_version", "7.0");
//    caps.setCapability("os", "Windows");
//    caps.setCapability("os_version", "XP");
//    caps.setCapability("browserstack.debug", "true");
//    caps.setCapability("browserstack.local", "true");
//    driver = new RemoteWebDriver(new URL(URL), caps);

//    driver = new RemoteWebDriver(new URL("http://192.168.1.47:4444/wd/hub"), chromeLinux);

//    driver run through proxy
//    DesiredCapabilities capsBMP = new DesiredCapabilities();

//    proxy = new Proxy();
//    proxy.setHttpProxy("localhost:8080");
//    capsBMP.setCapability("proxy", proxy);

//    proxy = new BrowserMobProxyServer();
//    proxy.start(8080);
//    Proxy seleniumProxy = ClientUtil.createSeleniumProxy(proxy);
//    capsBMP.setCapability(CapabilityType.PROXY, seleniumProxy);
//
//    driver = new ChromeDriver(capsBMP);

//    Local
//    driver = new ChromeDriver();
//
////    System.out.println(((HasCapabilities)driver).getCapabilities());
//    wait = new WebDriverWait(driver, 10);
//    fluentWait = new FluentWait<>(driver)
//            .withTimeout(10, TimeUnit.MILLISECONDS)
//            .ignoring(NoSuchElementException.class);
  }

  @AfterSuite
  public void stopBrowser() {
    app.stopBrowser();
//    driver.quit();
//    driver = null;
//    proxy.stop();
  }

  protected boolean isFieldOrTextAreaEmpty(By locator) {
    WebElement textFieldOrTextArea = app.getDriver().findElement(locator);
    String valueAttibute = textFieldOrTextArea.getAttribute("value");
    if (valueAttibute != null) {
      return valueAttibute.isEmpty();
    } else {
      return textFieldOrTextArea.getText().isEmpty();
    }
  }

  protected void clearField(By locator) {
    if (!isFieldOrTextAreaEmpty(locator)) {
      app.getDriver().findElement(locator).clear();
    }
  }

  protected void sendKeys(By locator, String text) {
    app.getDriver().findElement(locator).sendKeys(Keys.chord(text));
  }

  protected void typeText(By locator, String text) {
    clearField(locator);
    sendKeys(locator, text);
  }

  protected void click(By locator) {
    app.getDriver().findElement(locator).click();
  }

  protected void click(By locator, int index) {
    app.getDriver().findElements(locator).get(index).click();
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
    app.getDriver().get(URL);
  }

  protected void initNewAccountCreation(By locator) {
    click(locator);
  }

  protected void submitNewAccoutCreationForm(By locator) {
    click(locator);
  }

  protected void attachImage(By locator, String pathToImage) {
    String duckHorror = Paths.get(pathToImage).toAbsolutePath().toString();
    app.getDriver().findElement(locator).sendKeys(duckHorror);
  }

  protected void selectItemByIndex(By locator, int index) {
    WebElement dropBoxElement = app.getDriver().findElement(locator);
    Select select = new Select(dropBoxElement);
    if (select.getOptions().size() > 1) {
      select.selectByIndex(index);
    }
  }

  protected void selectCheckBox(By locator) {
    WebElement checkBox = app.getDriver().findElement(locator);
    if (checkBox.getAttribute("checked") == null) {
      checkBox.click();
    }
  }

  protected void selectCheckBox(By locator, int index) {
    WebElement checkBox = app.getDriver().findElements(locator).get(index);
    if (checkBox.getAttribute("checked") == null) {
      checkBox.click();
    }
  }

  protected boolean isElementPresent(By locator) {
    try {
      app.getDriver().findElement(locator);
      return true;
    } catch (WebDriverException ex) {
      return false;
    }
  }

  public static Function<WebDriver, Boolean> isQuantityChanged(final By locator, final Integer quantity) {
    return (WebDriver webDriver) -> Integer.parseInt(webDriver.findElement(locator).getText()) == (quantity);
  }

  public static Function<WebDriver, String> anyWindowOtherThan(final Set<String> oldWindowHandles) {
    return (WebDriver webDriver) -> {
      Set<String> currentWindowHandles = webDriver.getWindowHandles();
      currentWindowHandles.removeAll(oldWindowHandles);
      return currentWindowHandles.size() > 0 ? currentWindowHandles.iterator().next() : null;
    };
  }
}