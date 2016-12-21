package webdriver.trainings.homeworks.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by maksym on 12/19/16.
 */
public class Page {
  protected WebDriver driver;
  protected WebDriverWait wait;

  public Page(WebDriver driver) {
    this.driver = driver;
    wait = new WebDriverWait(driver, 10);
  }
}
