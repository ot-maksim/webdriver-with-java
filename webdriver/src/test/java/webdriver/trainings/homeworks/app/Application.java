package webdriver.trainings.homeworks.app;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import webdriver.trainings.homeworks.model.User;
import webdriver.trainings.homeworks.pages.CartPage;
import webdriver.trainings.homeworks.pages.CreateAccountPage;
import webdriver.trainings.homeworks.pages.MainPage;
import webdriver.trainings.homeworks.pages.ProductPage;

import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;

/**
 * Created by maksym on 12/19/16.
 */
public class Application {

  private WebDriver driver;
  private WebDriverWait wait;
  private CartPage cartPage;
  private CreateAccountPage createAccountPage;
  private MainPage mainPage;
  private ProductPage productPage;

  public Application() {
    driver = new ChromeDriver();
    wait = new WebDriverWait(driver, 10);
    cartPage = new CartPage(driver);
    createAccountPage = new CreateAccountPage(driver);
    mainPage = new MainPage(driver);
    productPage = new ProductPage(driver);
  }

  public WebDriver getDriver() {
    return this.driver;
  }

  public WebDriverWait getWait() {
    return this.wait;
  }

  public void stopBrowser() {
    driver.quit();
    driver = null;
  }

  protected void loginAsUser(User user) {
    mainPage.open();
    mainPage.login(user);
  }

  public void logout() {
    mainPage.logout();
  }

  public void registerNewUser(User user) {
    createAccountPage.open();
    createAccountPage.firstNameFieldLocator.sendKeys(Keys.chord(user.getEmail()));
    createAccountPage.lastNameFieldLocator.sendKeys(Keys.chord(user.getLastName()));
    createAccountPage.firstAddressFieldLocator.sendKeys(Keys.chord(user.getAddress1()));
    createAccountPage.secondAddressFieldLocator.sendKeys(Keys.chord(user.getAddress2()));
    createAccountPage.postCodeFieldLocator.sendKeys(Keys.chord(user.getPostCode()));
    createAccountPage.cityFieldLocator.sendKeys(Keys.chord(user.getCity()));
    createAccountPage.selectCountry(user.getCountry());
//    createAccountPage.selectZone(user.getZone());
    createAccountPage.emailFieldLocator.sendKeys(Keys.chord(user.getEmail()));
    createAccountPage.phoneFieldLocator.sendKeys(Keys.chord(user.getPhone()));
    createAccountPage.passwordFieldLocatorCreateAccountPage.sendKeys(Keys.chord(user.getPassword()));
    createAccountPage.confirmPasswordFieldLocator.sendKeys(Keys.chord(user.getPassword()));
    createAccountPage.submitNewAccountButtonLocator.click();
  }

  public void addExactNumberProductsToCart(int desiredQuantity) {
    mainPage.open();
    int actualQuantity = Integer.parseInt(productPage.productQuantityLocator.getText());
    for (int i = 0; i < desiredQuantity; i++) {
      mainPage.clickOnProduct(i);

      if (productPage.isSizeSelectorLocatorPresent()){
        productPage.selectSizeByIndex(1);
      }
      actualQuantity += 1;
      productPage.addProductToCart(actualQuantity);
      mainPage.logoImgLocator.click();
    }
  }

  public void deleteAllProductsFromCart() {
    cartPage.open();
    int numOfItems = cartPage.getNumberOfItemsInOrderSummary();
    for (int i = 1; i <= numOfItems; i++) {
      if (cartPage.getNumberOfItemsInOrderSummary() == 1) {
        cartPage.clickOnRemoveButtonByIndex(0);
      } else {
        cartPage.clickOnItem(0);
        String productName = cartPage.getProductName(0);
        WebElement productRow = cartPage.getProductRow(productName);
        cartPage.clickOnRemoveButtonByIndex(0);
        wait.until(stalenessOf(productRow));
      }
    }
  }

  public int getProductquantityInCart() {
    mainPage.open();
    return productPage.getProductNumberFromCart();
  }
}
