package webdriver.trainings.homeworks.tests;

import org.testng.annotations.Test;
import webdriver.trainings.homeworks.model.User;
import webdriver.trainings.homeworks.utilities.UserDataProvider;

import static org.testng.Assert.assertTrue;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork19 extends TestBase {

  @Test(dataProvider = "users", dataProviderClass = UserDataProvider.class)
  public void addAndRemoveProductsFromCart(User user) {
    app.registerNewUser(user);
    app.addExactNumberProductsToCart(3);
    assertTrue(app.getProductquantityInCart() == 3);
    app.deleteAllProductsFromCart();
    assertTrue(app.getProductquantityInCart() == 0);
  }

}
