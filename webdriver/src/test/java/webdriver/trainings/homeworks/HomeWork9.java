package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

import soft.hamcrestassert.SoftHamcrestAssert;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork9 extends TestBase {

  @BeforeMethod
  public void login() {
    goTo("http://localhost/litecart-1.3.6/admin/");
    if (driver.findElements(By.cssSelector("#sidebar .header")).size() == 0) {
      typeText(By.cssSelector("[name=username]"), "admin");
      typeText(By.cssSelector("[name=password]"), "admin");
      click(By.cssSelector("[name=login]"));
    }
  }

  @Test
  public void checkCountriesSortingOrder() {

    ArrayList<String> countries = new ArrayList<>();
    goTo("http://localhost/litecart-1.3.6/admin/?app=countries&doc=countries");

    List<WebElement> countryRows = driver.findElements(By.cssSelector("#content tr.row"));

    for (WebElement countryRow : countryRows) {
      WebElement nameColumn = countryRow.findElements(By.cssSelector("td")).get(4);
      String countryName = nameColumn.findElement(By.cssSelector("a")).getText();
      countries.add(countryName);
    }
    List<String> countriesSortedInAscOrder = countries.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());

    assertThat(Objects.equals(countriesSortedInAscOrder, countries), is(true));
  }

  @Test
  public void checkCountryZonesSortingOrder() {
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();
    Integer countryZonesNumber;
    List<WebElement> allCountryZoneRows;
    List<String> countryZoneNames = new ArrayList<>();

    goTo("http://localhost/litecart-1.3.6/admin/?app=countries&doc=countries");

    int countryQuantity = driver.findElements(By.xpath("//*[@id='content']//tr[contains(@class,'row')]")).size();

    WebElement countryRow;
    List<WebElement> countryRowColumns;
    WebElement countryNameColumn;

    for (int i = 1; i <= countryQuantity; i++) {
      countryRow = driver.findElement(By.xpath("//*[@id='content']//tr[contains(@class,'row')][" + i + "]"));
      countryRowColumns = countryRow.findElements(By.cssSelector("td"));
      countryZonesNumber = Integer.parseInt(countryRowColumns.get(5).getText());

      if (countryZonesNumber > 0) {

        countryNameColumn = countryRowColumns.get(4);
        countryNameColumn.findElement(By.cssSelector("a")).click();

        wait.until(titleIs("Edit Country | My Store"));

        allCountryZoneRows = driver.findElements(By.xpath("//*[@id='table-zones']//tr/td[1]/input/../.."));

        for (WebElement allCountryZoneRow : allCountryZoneRows) {
          List<WebElement> allColumnsFromRow = allCountryZoneRow.findElements(By.cssSelector("td"));
          WebElement zoneNameColumn = allColumnsFromRow.get(2);
          countryZoneNames.add(zoneNameColumn.findElement(By.cssSelector("input")).getAttribute("value"));
        }
        List<String> countryZonesSortedInAscOrder = countryZoneNames.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
        softAssert.assertThat("Sorting should be in ascending order", Objects.equals(countryZonesSortedInAscOrder, countryZoneNames), is(true));

        countryZoneNames = new ArrayList<>();
        driver.navigate().back();
      }
    }

    softAssert.assertAll();
  }

  @Test
  public void checkCountryGeoZonesSortingOrder() {
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();
    goTo("http://localhost/litecart-1.3.6/admin/?app=geo_zones&doc=geo_zones");

    List<WebElement> countryRows = driver.findElements(By.cssSelector("#content form[name=geo_zones_form] tr.row"));
    List<WebElement> zoneRows;
    WebElement countryRow;
    WebElement countryNameColumn;
    WebElement zoneNameColum;
    List<WebElement> zoneRowColumns;
    List<String> zoneNames = new ArrayList<>();


    for (int i = 1; i <= countryRows.size(); i++) {
      countryRow = driver.findElement(By.xpath("//*[@id='content']//form[@name='geo_zones_form']//tr[contains(@class,'row')][" + i + "]"));
      countryNameColumn = countryRow.findElements(By.cssSelector("td")).get(2);
      countryNameColumn.findElement(By.cssSelector("a")).click();
      wait.until(titleIs("Edit Geo Zone | My Store"));
      zoneRows = driver.findElements((By.xpath("//*[@id='table-zones']//tr/td[1]/input/../..")));
      for (WebElement zoneRow : zoneRows) {
        zoneRowColumns = zoneRow.findElements(By.cssSelector("td"));
        zoneNameColum = zoneRowColumns.get(2);
        String zoneName = zoneNameColum.findElement(By.cssSelector("select option[selected]")).getText();
        zoneNames.add(zoneName);
      }
      List<String> zonesSortedInAscOrder = zoneNames.stream().sorted(Comparator.naturalOrder()).collect(Collectors.toList());
      softAssert.assertThat("Sorting should be in ascending order", Objects.equals(zonesSortedInAscOrder, zoneNames), is(true));
      driver.navigate().back();
      zoneNames = new ArrayList<>();
    }

    softAssert.assertAll();
  }
}
