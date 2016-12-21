package webdriver.trainings.homeworks.tests;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import webdriver.trainings.homeworks.model.User;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;
import static org.openqa.selenium.support.ui.ExpectedConditions.stalenessOf;
import static org.testng.Assert.assertTrue;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork13 extends TestBase {

  @Test
  public void addAndRemoveProductsFromCart() {
    // URLs
    String mainPage = "http://localhost/litecart-1.3.6";

    // main page locators
    String initCreationNewAccountLocator = "#box-account-login a[href $= create_account]";
    String logoutButtonLocator = "#box-account a[href $= logout]";

    // create account page locators
    String firstNameFieldLocator = "#create-account [name=firstname]";
    String lastNameFieldLocator = "#create-account [name=lastname]";
    String firstAddressFieldLocator = "#create-account [name=address1]";
    String secondAddressFieldLocator = "#create-account [name=address2]";
    String postCodeFieldLocator = "#create-account [name=postcode]";
    String cityFieldLocator = "#create-account [name=city]";
    String emailFieldLocator = "#create-account [name=email]";
    String phoneFieldLocator = "#create-account [name=phone]";
    String passwordFieldLocatorCreateAccountPage = "#create-account [name=password]";
    String confirmPasswordFieldLocator = "#create-account [name=confirmed_password]";
    String submitNewAccountButtonLocator = "#create-account [name=create_account]";

    User user = new User.Builder()
            .firstName("firstname")
            .lastName("lastname")
            .address1("address1")
            .address2("address2")
            .postCode("12345")
            .city("city")
            .email("email-" + System.currentTimeMillis() + "@litecart.com")
            .phone("+380777777777")
            .password("password")
            .build();

    goTo(mainPage);
    initNewAccountCreation(By.cssSelector(initCreationNewAccountLocator));

    typeText(By.cssSelector(firstNameFieldLocator), user.getFirstName());
    typeText(By.cssSelector(lastNameFieldLocator), user.getLastName());
    typeText(By.cssSelector(firstAddressFieldLocator), user.getAddress1());
    typeText(By.cssSelector(secondAddressFieldLocator), user.getAddress2());
    typeText(By.cssSelector(postCodeFieldLocator), String.valueOf(user.getPostCode()));
    typeText(By.cssSelector(cityFieldLocator), user.getCity());
    typeText(By.cssSelector(emailFieldLocator), user.getEmail());
    typeText(By.cssSelector(phoneFieldLocator), user.getPhone());
    typeText(By.cssSelector(passwordFieldLocatorCreateAccountPage), user.getPassword());
    typeText(By.cssSelector(confirmPasswordFieldLocator), user.getPassword());

    submitNewAccoutCreationForm(By.cssSelector(submitNewAccountButtonLocator));

    int quantity = 0;
    int numOfUniqueItems = 3;

    // add unique items to the cart
    for (int i = 0; i < numOfUniqueItems; i++) {
      click(By.cssSelector("#box-latest-products ul li"), i);

      if (isElementPresent(By.cssSelector("[name=buy_now_form] .options [name=options\\[Size\\]]"))) {
        selectItemByIndex(By.cssSelector("[name=buy_now_form] .options [name=options\\[Size\\]]"), 1);
      }
      click(By.cssSelector("[name=buy_now_form] .quantity [name=add_cart_product]"));
      quantity = Integer.parseInt(app.getDriver().findElement(By.cssSelector("#cart .quantity")).getText());
      app.getWait().until(isQuantityChanged(By.cssSelector("#cart .quantity"), quantity + 1));
      click(By.cssSelector("#logotype-wrapper img"));
    }

    assertTrue(Integer.parseInt(app.getDriver().findElement(By.cssSelector("#cart .quantity")).getText()) == numOfUniqueItems);
    // go to the cart
    click(By.cssSelector("#cart a.link"));

    // remove all items from the cart
    int numOfItems = app.getDriver().findElements(By.cssSelector("#order_confirmation-wrapper td.item")).size();
    for (int i = 1; i <= numOfItems; i++) {
      if (app.getDriver().findElements(By.cssSelector("#order_confirmation-wrapper td.item")).size() == 1) {
        click(By.cssSelector("#box-checkout-cart [name=remove_cart_item]"));
        app.getWait().until(presenceOfElementLocated(By.cssSelector("#checkout-cart-wrapper em")));
      } else {
        click(By.cssSelector("#box-checkout-cart li.shortcut"), 0);
        String productName = app.getDriver().findElements(By.cssSelector("#box-checkout-cart a > strong")).get(0).getText();
        WebElement productRow = app.getDriver().findElement(By.xpath("//*[@id='order_confirmation-wrapper']//td[contains(@class,'item') and contains(.,'" + productName + "')]"));
        click(By.cssSelector("#box-checkout-cart [name=remove_cart_item]"), 0);
        app.getWait().until(stalenessOf(productRow));
        assertTrue(app.getDriver().findElements(By.cssSelector("#order_confirmation-wrapper td.item")).size() == (numOfItems - i));
      }
    }

    click(By.cssSelector("#logotype-wrapper img"));
    assertTrue(Integer.parseInt(app.getDriver().findElement(By.cssSelector("#cart .quantity")).getText()) == 0);
    logoutUser(By.cssSelector(logoutButtonLocator));
  }

}
