package webdriver.trainings.homeworks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;


/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork8 extends TestBase {

  @Test
  public void checkStickersForAllProductsOnMainPage() {
    String stickerSelector = "div[class^=sticker]";
    goTo("http://localhost/litecart-1.3.6/");

    List<WebElement> mostPopularProducts = app.getDriver().findElements(By.cssSelector("#box-most-popular ul li"));
    for (WebElement mostPopularProduct : mostPopularProducts) {
      Assert.assertTrue(mostPopularProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }

    List<WebElement> campaignsProducts = app.getDriver().findElements(By.cssSelector("#box-campaigns ul li"));
    for (WebElement campaignsProduct : campaignsProducts) {
      Assert.assertTrue(campaignsProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }

    List<WebElement> latestProducts = app.getDriver().findElements(By.cssSelector("#box-latest-products ul li"));
    for (WebElement latestProduct : latestProducts) {
      Assert.assertTrue(latestProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }
  }
}
