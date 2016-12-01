package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;


/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork11 extends TestBase {

  @Test
  public void createNewUserWithLoginLogoutScenario() {
    // URLs
    String mainPage = "http://localhost/litecart-1.3.6";

    // main page locators
    String loginButtonLocator = "#box-account-login [name=login]";
    String loginFieldLocator = "#box-account-login [name=email]";
    String passwordFieldMainPageLocator = "#box-account-login [name=password]";
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
            .postCode(12345)
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
    logoutUser(By.cssSelector(logoutButtonLocator));
    loginAsUser(By.cssSelector(loginFieldLocator), By.cssSelector(passwordFieldMainPageLocator), By.cssSelector(loginButtonLocator), user);
    logoutUser(By.cssSelector(logoutButtonLocator));
  }
}
