package webdriver.trainings.homeworks.tests;

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

    int extLinksNumber = app.getDriver().findElements(By.cssSelector(".fa-external-link")).size();
    String windowHandleOld;
    String windowHandleNew;
    Set<String> windowHandlesOld;
    List<String> titles = new ArrayList<>();
    String oldTitle = app.getDriver().getTitle();
    String newTitle;
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();

    for(int i = 0; i < extLinksNumber; i++) {
      windowHandleOld = app.getDriver().getWindowHandle();
      windowHandlesOld = app.getDriver().getWindowHandles();
      click(By.cssSelector(".fa-external-link"), i);
      windowHandleNew = String.valueOf(app.getWait().until(anyWindowOtherThan(windowHandlesOld)));
      app.getDriver().switchTo().window(windowHandleNew);
      newTitle = app.getDriver().getTitle();
      titles.add(newTitle);
      softAssert.assertThat(newTitle, is(not(oldTitle)));
      app.getDriver().close();
      app.getDriver().switchTo().window(windowHandleOld);
    }

    softAssert.assertThat(extLinksNumber, is(titles.size()));

    softAssert.assertAll();
  }
}
