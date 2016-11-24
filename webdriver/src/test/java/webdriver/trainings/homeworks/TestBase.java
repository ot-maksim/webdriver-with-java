package webdriver.trainings.homeworks;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

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
}
