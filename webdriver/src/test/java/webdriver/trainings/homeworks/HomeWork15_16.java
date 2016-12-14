package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork15_16 extends TestBase {

  @Test
  public void runOnGridExtras() {
    goTo("http://192.168.1.47/litecart-1.3.6/admin/login.php");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));

    // browserstack.com remote run
//    driver.get("http://www.google.com");
//    WebElement element = driver.findElement(By.name("q"));
//
//    element.sendKeys("BrowserStack");
//    element.submit();

    System.out.println(driver.getTitle());
  }
}
