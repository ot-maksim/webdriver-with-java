package webdriver.trainings.homeworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import static webdriver.trainings.homeworks.utilities.CustomExpectations.isQuantityChanged;

/**
 * Created by maksym on 12/20/16.
 */
public class ProductPage extends Page {
  public ProductPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  private String sizeSelectorLocator = "[name=buy_now_form] .options [name=options\\[Size\\]]";
  private static final String productsQuantityLocator = "#cart .quantity";

  @FindBy(css = "[name=buy_now_form] .quantity [name=add_cart_product]")
  public WebElement addProductToCartLocator;

  @FindBy(css = productsQuantityLocator)
  public WebElement productQuantityLocator;

  public boolean isSizeSelectorLocatorPresent() {
    try {
      driver.findElement(By.cssSelector(sizeSelectorLocator));
      return true;
    } catch (WebDriverException ex) {
      return false;
    }
  }

  public void selectSizeByIndex(int index) {
    Select select = new Select(driver.findElement(By.cssSelector(sizeSelectorLocator)));
    if (select.getOptions().size() > 1) {
      select.selectByIndex(index);
    }
  }

  public int addProductToCart(int expectedQuantity) {
    addProductToCartLocator.click();
    wait.until(isQuantityChanged(By.cssSelector(productsQuantityLocator), expectedQuantity));
    return Integer.parseInt(productQuantityLocator.getText());
  }

  public int getProductNumberFromCart() {
    return Integer.parseInt(productQuantityLocator.getText());
  }
}
