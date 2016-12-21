package webdriver.trainings.homeworks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.logging.LogEntry;
import org.testng.annotations.Test;
import soft.hamcrestassert.SoftHamcrestAssert;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.CoreMatchers.equalTo;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork17 extends TestBase {

  @Test
  public void getBrowserLogs() {
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();

    goTo("http://localhost/litecart-1.3.6/admin/login.php");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));

    List<LogEntry> productPage = new ArrayList<>();
    goTo("http://localhost/litecart-1.3.6/admin/?app=catalog&doc=catalog&category_id=1");

    int products = app.getDriver().findElements(By.cssSelector("img + [href*='&product_id=']")).size();

    for (int i = 0; i < products; i++) {
      click(By.cssSelector("img + [href*='&product_id=']"), i);
      for (LogEntry l : app.getDriver().manage().logs().get("browser").getAll()) {
        productPage.add(l);
      }
      softAssert.assertThat("There are some issues in browser logs on page with title - " + app.getDriver().getTitle(), productPage.size(), equalTo(0));
      app.getDriver().navigate().back();
    }
    softAssert.assertAll();
  }
}
