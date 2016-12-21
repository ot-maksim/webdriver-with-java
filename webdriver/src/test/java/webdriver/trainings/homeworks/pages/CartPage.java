package webdriver.trainings.homeworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import java.util.List;

/**
 * Created by maksym on 12/19/16.
 */
public class CartPage extends Page {
  public CartPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  public CartPage open() {
    driver.get("http://localhost/litecart-1.3.6/en/checkout");
    return this;
  }

  @FindBy(css = "#order_confirmation-wrapper td.item")
  public List<WebElement> listOfItemsInOrderSummaryLocator;

  @FindBy(css = "#box-checkout-cart li.shortcut")
  public List<WebElement> listOfItemsInCartLocator;

  @FindBy(css = "#box-checkout-cart a > strong")
  public List<WebElement> productNameLocator;

  @FindBy(css = "#box-checkout-cart [name=remove_cart_item]")
  public List<WebElement> listOfRemoveButtonsLocator;

  public int getNumberOfItemsInOrderSummary() {
    return listOfItemsInOrderSummaryLocator.size();
  }

  public void clickOnItem(int itemNumber) {
    listOfItemsInCartLocator.get(itemNumber).click();
  }

  public String getProductName(int itemNumber) {
    return productNameLocator.get(itemNumber).getText();
  }

  public void clickOnRemoveButtonByIndex(int index) {
    if (listOfRemoveButtonsLocator.size() == 0) {
      listOfRemoveButtonsLocator.get(0).click();
    } else {
      listOfRemoveButtonsLocator.get(index).click();
    }
  }

  public WebElement getProductRow(String productName) {
    return driver.findElement(By.xpath("//*[@id='order_confirmation-wrapper']//td[contains(@class,'item') and contains(.,'" + productName + "')]"));
  }

}
