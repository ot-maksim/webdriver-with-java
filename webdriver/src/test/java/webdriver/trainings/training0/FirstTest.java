package webdriver.trainings.training0;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/16/16.
 */
public class FirstTest {
  private WebDriver driver;
  private Wait wait;

  @Before
  public void startBrowser() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
  }

  @Test
  public void checkGoogleTitle() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
  }

  @After
  public void stopBrowser() {
    driver.quit();
    driver = null;
  }
}
