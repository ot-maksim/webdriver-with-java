package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import soft.hamcrestassert.SoftHamcrestAssert;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.not;

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
    String oldTitle = driver.getTitle();
    String newTitle;
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();

    for(int i = 0; i < extLinksNumber; i++) {
      windowHandleOld = driver.getWindowHandle();
      windowHandlesOld = driver.getWindowHandles();
      click(By.cssSelector(".fa-external-link"), i);
      windowHandleNew = String.valueOf(wait.until(anyWindowOtherThan(windowHandlesOld)));
      driver.switchTo().window(windowHandleNew);
      newTitle = driver.getTitle();
      titles.add(newTitle);
      softAssert.assertThat(newTitle, is(not(oldTitle)));
      driver.close();
      driver.switchTo().window(windowHandleOld);
    }

    softAssert.assertThat(extLinksNumber, is(titles.size()));

    softAssert.assertAll();
  }
}
