package webdriver.trainings.training1;

import org.junit.Test;
import org.openqa.selenium.By;


import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/16/16.
 */
public class FirstClass extends TestBase{

  @Test
  public void oneTest() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
  }

  @Test
  public void twoTest() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
  }

  @Test
  public void threeTest() {
    driver.get("http://www.google.com/");
    driver.findElement(By.name("q")).sendKeys("webdriver");
    driver.findElement(By.name("btnG")).click();
    wait.until(titleIs("webdriver - Пошук Google"));
  }
}
