package webdriver.trainings.homeworks.utilities;

import org.testng.annotations.DataProvider;
import webdriver.trainings.homeworks.model.User;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * Created by maksym on 12/21/16.
 */
public class UserDataProvider {
  @DataProvider()
  public static Iterator<Object[]> users() {
    List<Object[]> users = new ArrayList<Object[]>();
    users.add(new Object[]{new User.Builder()
            .firstName("firstname")
            .lastName("lastname")
            .address1("address1")
            .address2("address2")
            .postCode("12345")
            .city("city")
            .country("US")
            .zone("AL")
            .email("email-" + System.currentTimeMillis() + "@litecart.com")
            .phone("+380777777777")
            .password("password")
            .build()});
    return users.iterator();
  }
}
