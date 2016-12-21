package webdriver.trainings.homeworks.tests;

import org.testng.annotations.Test;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork18 extends TestBase {

  @Test
  public void startWithProxy() throws Exception {
    goTo("http://localhost/litecart-1.3.6/admin/login.php");
  }
}
