package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.testng.Assert.assertTrue;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork14 extends TestBase {

  @Test
  public void openNewWindowsScenario() {
    goTo("http://localhost/litecart-1.3.6/admin/");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));

    goTo("http://localhost/litecart-1.3.6/admin/?app=countries&doc=countries");
    click(By.cssSelector("#content a.button"));

    int extLinksNumber = driver.findElements(By.cssSelector(".fa-external-link")).size();
    String windowHandleOld;
    String windowHandleNew;
    Set<String> windowHandlesOld;
    List<String> titles = new ArrayList<>();

    for(int i = 0; i < extLinksNumber; i++) {
      windowHandleOld = driver.getWindowHandle();
      windowHandlesOld = driver.getWindowHandles();
      click(By.cssSelector(".fa-external-link"), i);
      windowHandleNew = String.valueOf(wait.until(anyWindowOtherThan(windowHandlesOld)));
      driver.switchTo().window(windowHandleNew);
      titles.add(driver.getTitle());
      driver.close();
      driver.switchTo().window(windowHandleOld);
    }

    assertTrue(extLinksNumber == titles.size());
  }
}
