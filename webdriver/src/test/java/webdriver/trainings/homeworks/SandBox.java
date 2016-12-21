package webdriver.trainings.homeworks;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import webdriver.trainings.homeworks.tests.TestBase;

import java.util.List;
import java.util.Set;

/**
 * Created by maksym on 12/6/16.
 */
public class SandBox extends TestBase {
  @Test
  public void addNewProductScenario() {

    goTo("http://localhost/litecart-1.3.6/admin/login.php");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));
//
//    wait.until(numberOfElementsToBeByAnonimous(By.cssSelector("#app-"), 17));
//    wait.until(numberOfElementsToBeByLambda(By.cssSelector("#app-"), 17));
//
//    fluentWait.until(numberOfElementsToBeByAnonimous(By.cssSelector("#app-"), 17));
//    fluentWait.until(numberOfElementsToBeByLambda(By.cssSelector("#app-"), 17));
//
////    wait.until((WebDriver d) -> d.findElement(By.cssSelector("#sidebar")));
//
////    wait.until((WebDriver d) -> d.findElement(By.cssSelector("#sidebar")));
//
//    WebElement element11 = new WebDriverWait(driver, 10).until((WebDriver d) -> d.findElement(By.cssSelector("#sidebar")));
//
////    WebElement element2 = fluentWait.until((WebDriver d) -> d.findElement(By.cssSelector("#sidebar")));
//    WebElement element22 = new FluentWait<>(driver).withTimeout(10, TimeUnit.MILLISECONDS).until((WebDriver d) -> d.findElement(By.cssSelector("#sidebar")));
//
//    List<WebElement> list1 = new WebDriverWait(driver, 10).until(numberOfElementsToBeByAnonimous(By.cssSelector("#app-"), 17));
//    List<WebElement> list2 = new WebDriverWait(driver, 10).until(numberOfElementsToBeByLambda(By.cssSelector("#app-"), 17));
//
//    System.out.println("list1 " + list1.size());
//    System.out.println("list2 " + list2.size());

//    System.out.println("start");
//
//    driver.manage().window().maximize();
//    String windowHandleOld = driver.getWindowHandle();
//    Set<String> windowHandlesOld = driver.getWindowHandles();
//    ((JavascriptExecutor)driver).executeScript("window.open()");
//    String windowHandleNew = String.valueOf(wait.until(anyWindowOtherThan(windowHandlesOld)));
//    driver.switchTo().window(windowHandleNew);
//    driver.get("http://ukr.net");
//    driver.switchTo().window(windowHandleOld);
//    driver.get("http://meta.ua");
//    driver.switchTo().window(windowHandleNew);
//    driver.close();
//    driver.switchTo().window(windowHandleOld);
//    driver.get("http://localhost/litecart-1.3.6/admin/login.php");



  }

  public static Function<WebDriver, List<WebElement>> numberOfElementsToBeByAnonimous(final By locator, final Integer number) {

    return new Function<WebDriver, List<WebElement>>() {
      private Integer currentNumber = 0;

      @Override
      public List<WebElement> apply(WebDriver webDriver) {
        List<WebElement> elements = webDriver.findElements(locator);
        currentNumber = elements.size();
        return currentNumber.equals(number) ? elements : null;
      }
    };
  }

  public static Function<WebDriver, List<WebElement>> numberOfElementsToBeByLambda(final By locator, final Integer number) {
    return (WebDriver webDriver) -> {
      Integer currentNumber;
      List<WebElement> elements = webDriver.findElements(locator);
      currentNumber = elements.size();
      return currentNumber.equals(number) ? elements : null;};
  }

}
