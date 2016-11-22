package webdriver.trainings.training0;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.HasCapabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.opera.OperaDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.safari.SafariDriver;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/17/16.
 */
public class AdminLogin {
  private WebDriver driver;
  private Wait wait;

//  @BeforeMethod
  public void startBrowser() {
    DesiredCapabilities caps = new DesiredCapabilities();

    // Chrome
//    ChromeOptions options = new ChromeOptions();
//    options.addArguments("start-maximized");
//    driver = new ChromeDriver(options);
//    driver = new ChromeDriver();

    // Firefox
//    старая схема:
//    caps.setCapability(FirefoxDriver.MARIONETTE, false);

//    новая схема:
    driver = new FirefoxDriver();

//    новая схема более явно:
//    caps.setCapability(FirefoxDriver.MARIONETTE, true);

//    driver = new FirefoxDriver(caps);

    // Safari
//    driver = new SafariDriver();

//    wait = new WebDriverWait(driver, 10);
//    System.out.println(((HasCapabilities) driver).getCapabilities());
  }

  @Test
  public void checkGoogleTitle1() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle2() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle3() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle4() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle5() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle6() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

  @Test
  public void checkGoogleTitle7() throws InterruptedException {
    driver.get("http://software-testing.ru");
//    driver.get("http://localhost/litecart-1.3.6/admin/");
//    driver.findElement(By.name("username")).sendKeys("admin");
//    driver.findElement(By.name("password")).sendKeys("admin");
//    driver.findElement(By.name("login")).click();
//    wait.until(titleIs("My Store"));
  }

//  @AfterMethod
  public void stopBrowser() {
    driver.quit();
    driver = null;
  }
}
