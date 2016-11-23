package webdriver.trainings.training1;

import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;


/**
 * Created by maksym on 11/21/16.
 */
public class TestBase {
//  private static ThreadLocal<WebDriver> tlDriver = new ThreadLocal<>();
  public static WebDriver driver;
  public static WebDriverWait wait;

  @BeforeClass
  public void start() {
//    if (tlDriver.get() != null) {
//      driver = tlDriver.get();
//      wait = new WebDriverWait(driver, 10);
//      return;
//    }
    DesiredCapabilities caps = new DesiredCapabilities();
    caps.setCapability(FirefoxDriver.MARIONETTE, false);
    driver = new FirefoxDriver(caps);
//    tlDriver.set(driver);
    System.out.println(((HasCapabilities) driver).getCapabilities());
    wait = new WebDriverWait(driver, 10);

//    Runtime.getRuntime().addShutdownHook(
//            new Thread(() -> { driver.quit(); driver = null; }));
  }

  @AfterClass
  public void stop() {
    driver.quit();
    driver = null;
  }

}
