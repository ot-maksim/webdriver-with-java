package webdriver.trainings.homeworks.utilities;

import com.google.common.base.Function;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.Set;

/**
 * Created by maksym on 12/20/16.
 */
public class CustomExpectations {

  public static Function<WebDriver, Boolean> isQuantityChanged(final By locator, final Integer quantity) {
    return (WebDriver webDriver) -> Integer.parseInt(webDriver.findElement(locator).getText()) == (quantity);
  }
  public static Function<WebDriver, Boolean> isQuantityChanged(final WebElement webElement, final Integer quantity) {
    return (WebDriver webDriver) -> Integer.parseInt(webElement.getText()) == (quantity);
  }

  public static Function<WebDriver, String> anyWindowOtherThan(final Set<String> oldWindowHandles) {
    return (WebDriver webDriver) -> {
      Set<String> currentWindowHandles = webDriver.getWindowHandles();
      currentWindowHandles.removeAll(oldWindowHandles);
      return currentWindowHandles.size() > 0 ? currentWindowHandles.iterator().next() : null;
    };
  }
}
