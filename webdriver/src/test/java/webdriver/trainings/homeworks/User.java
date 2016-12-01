package webdriver.trainings.homeworks;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by maksym on 11/25/16.
 */
public class User {

  private String firstName;
  private String lastName;
  private String address1;
  private String address2;
  private int postCode;
  private String city;
  private String email;
  private String phone;
  private String password;


  private User() {
    super();
  }

  private User(User.Builder builder) {
    this.firstName = builder.firstName;
    this.lastName = builder.lastName;
    this.address1 = builder.address1;
    this.address2 = builder.address2;
    this.postCode = builder.postCode;
    this.city = builder.city;
    this.email = builder.email;
    this.phone = builder.phone;
    this.password = builder.password;
  }

  public static class Builder {
    private String firstName = "firstName";
    private String lastName = "lastName";
    private String address1 = "address1";
    private String address2 = "address2";
    private int postCode = 12345;
    private String city = "city";
    private String email = "email-" + System.currentTimeMillis() + "@litecart.com";
    private String phone = "phone";
    private String password = "password";


    public User.Builder firstName(String firstName) {
      this.firstName = firstName;
      return this;
    }

    public User.Builder lastName(String lastName) {
      this.lastName = lastName;
      return this;
    }
    public User.Builder address1(String address1) {
      this.address1 = address1;
      return this;
    }

    public User.Builder address2(String address2) {
      this.address2 = address2;
      return this;
    }

    public User.Builder postCode(int postCode) {
      this.postCode = postCode;
      return this;
    }

    public User.Builder city(String city) {
      this.city = city;
      return this;
    }

    public User.Builder email(String email) {
      this.email = email;
      return this;
    }

    public User.Builder phone(String phone) {
      this.phone = phone;
      return this;
    }

    public User.Builder password(String password) {
      this.password = password;
      return this;
    }

    public User build(){
      return new User(this);
    }

  }

  public String getFirstName() {
    return firstName;
  }

  public String getLastName() {
    return lastName;
  }

  public String getAddress1() {
    return address1;
  }

  public String getAddress2() {
    return address2;
  }

  public int getPostCode() {
    return postCode;
  }

  public String getCity() {
    return city;
  }

  public String getEmail() {
    return email;
  }

  public String getPhone() {
    return phone;
  }

  public String getPassword() {
    return password;
  }

  @Override
  public String toString() {
    return "User{" +
            "firstName='" + firstName + '\'' +
            ", lastName='" + lastName + '\'' +
            '}';
  }

  public static List<User> creatShortList(){
    List<User> users = new ArrayList<>();

    return users;
  }
}
