package webdriver.trainings.homeworks.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import webdriver.trainings.homeworks.model.User;

import java.util.List;

/**
 * Created by maksym on 12/19/16.
 */
public class MainPage extends Page{

  public MainPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "#box-account-login a[href $= create_account]")
  public WebElement initCreationNewAccountLocator;

  @FindBy(css = "#box-account a[href $= logout]")
  public WebElement logoutButtonLocator;

  @FindBy(css = "#box-account-login [name=email]")
  public WebElement loginFieldLocator;

  @FindBy(css = "#box-account-login [name=password]")
  public WebElement passwordFieldMainPageLocator;

  @FindBy(css = "#box-account-login [name=login]")
  public WebElement loginButtonLocator;

  @FindBy(css = "#logotype-wrapper img")
  public WebElement logoImgLocator;

  @FindBy(css = "#box-latest-products ul li")
  public List<WebElement> latestProductsListLocator;

  public MainPage open() {
    driver.get("http://localhost/litecart-1.3.6");
    return this;
  }

  public ProductPage clickOnProduct(int i) {
    latestProductsListLocator.get(i).click();
    return new ProductPage(driver);
  }
  public CreateAccountPage initNewAccountCreation() {
    initCreationNewAccountLocator.click();
    return new CreateAccountPage(driver);
  }

  public MainPage login(User user) {
    loginFieldLocator.sendKeys(Keys.chord(user.getEmail()));
    passwordFieldMainPageLocator.sendKeys(Keys.chord(user.getPassword()));
    loginButtonLocator.click();
    return this;
  }

  public MainPage logout() {
    logoutButtonLocator.click();
    return this;
  }

}
