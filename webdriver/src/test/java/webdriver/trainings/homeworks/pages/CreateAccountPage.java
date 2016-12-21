package webdriver.trainings.homeworks.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

/**
 * Created by maksym on 12/19/16.
 */
public class CreateAccountPage extends Page{
//  String firstNameFieldLocator = "#create-account [name=firstname]";
//  String lastNameFieldLocator = "#create-account [name=lastname]";
//  String firstAddressFieldLocator = "#create-account [name=address1]";
//  String secondAddressFieldLocator = "#create-account [name=address2]";
//  String postCodeFieldLocator = "#create-account [name=postcode]";
//  String cityFieldLocator = "#create-account [name=city]";
//  String emailFieldLocator = "#create-account [name=email]";
//  String phoneFieldLocator = "#create-account [name=phone]";
//  String passwordFieldLocatorCreateAccountPage = "#create-account [name=password]";
//  String confirmPasswordFieldLocator = "#create-account [name=confirmed_password]";
//  String submitNewAccountButtonLocator = "#create-account [name=create_account]";

  public CreateAccountPage(WebDriver driver) {
    super(driver);
    PageFactory.initElements(driver, this);
  }

  @FindBy(css = "#create-account [name=firstname]")
  public WebElement firstNameFieldLocator;

  @FindBy(css = "#create-account [name=lastname]")
  public WebElement lastNameFieldLocator;

  @FindBy(css = "#create-account [name=address1]")
  public WebElement firstAddressFieldLocator;

  @FindBy(css = "#create-account [name=address2]")
  public WebElement secondAddressFieldLocator;

  @FindBy(css = "#create-account [name=postcode]")
  public WebElement postCodeFieldLocator;

  @FindBy(css = "#create-account [name=city]")
  public WebElement cityFieldLocator;

  @FindBy(css = "#create-account [name=email]")
  public WebElement emailFieldLocator;

  @FindBy(css = "#create-account [name=phone]")
  public WebElement phoneFieldLocator;

  @FindBy(css = "#create-account [name=password]")
  public WebElement passwordFieldLocatorCreateAccountPage;

  @FindBy(css = "#create-account [name=confirmed_password]")
  public WebElement confirmPasswordFieldLocator;

  @FindBy(css = "#create-account [name=create_account]")
  public WebElement submitNewAccountButtonLocator;

  public void selectCountry(String country) {
    driver.findElement(By.cssSelector("[id ^= select2-country_code]")).click();
    driver.findElement(By.cssSelector(
            String.format(".select2-results__option[id $= %s]", country))).click();
  }

  public void selectZone(String zone) {
    wait.until((WebDriver d) -> d.findElement(
            By.cssSelector(String.format("select[name=zone_code] option[value=%s]", zone))));
    new Select(driver.findElement(By.name("select[name=zone_code]"))).selectByValue(zone);
  }

  public CreateAccountPage open() {
    driver.get("http://localhost/litecart-1.3.6/en/create_account");
    return this;
  }
}
