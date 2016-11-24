package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork8 extends TestBase{

  @Test
  public void checkStickersForAllProductsOnMainPage() throws InterruptedException {
    String stickerSelector = "div[class^=sticker]";

    driver.get("http://localhost/litecart-1.3.6/");

    List<WebElement> mostPopularProducts = driver.findElements(By.cssSelector("#box-most-popular ul li"));
    for (WebElement mostPopularProduct : mostPopularProducts) {
      Assert.assertTrue(mostPopularProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }

    List<WebElement> campaignsProducts = driver.findElements(By.cssSelector("#box-campaigns ul li"));
    for (WebElement campaignsProduct : campaignsProducts) {
      Assert.assertTrue(campaignsProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }

    List<WebElement> latestProducts = driver.findElements(By.cssSelector("#box-latest-products ul li"));
    for (WebElement latestProduct : latestProducts) {
      Assert.assertTrue(latestProduct.findElements(By.cssSelector(stickerSelector)).size() == 1, "only one sticker should be present");
    }
  }
}
