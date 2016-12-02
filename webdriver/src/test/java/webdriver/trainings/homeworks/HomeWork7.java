package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork7 extends TestBase{

  @Test
  public void iterateOverAllMenuItems() {
    goTo("http://localhost/litecart-1.3.6/admin/login.php");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));

    List<WebElement> elements = driver.findElements(By.cssSelector("#app-"));

    for (int i = 1; i <= elements.size(); i++) {
      click(By.cssSelector("#app-:nth-of-type(" + i + ")"));
      if (driver.findElements(By.cssSelector("ul.docs")).size() > 0) {
        int subMenuItems = driver.findElements(By.cssSelector("ul.docs li")).size();
        for (int j = 1; j <= subMenuItems; j++) {
          click(By.cssSelector("ul.docs li:nth-of-type(" + j + ")"));
          wait.until(titleIs(driver.getTitle()));
        }
      } else {
        wait.until(titleIs(driver.getTitle()));
      }
    }
  }
}
