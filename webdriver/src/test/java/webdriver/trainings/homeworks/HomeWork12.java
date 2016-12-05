package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import static org.openqa.selenium.support.ui.ExpectedConditions.presenceOfElementLocated;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork12 extends TestBase {

  @Test
  public void addNewProductScenario() {

    String productName = "name-" + System.currentTimeMillis();

    goTo("http://localhost/litecart-1.3.6/admin/login.php");
    typeText(By.cssSelector("[name=username]"), "admin");
    typeText(By.cssSelector("[name=password]"), "admin");
    click(By.cssSelector("[name=login]"));

    wait.until(presenceOfElementLocated(By.cssSelector("#sidebar")));

    click(By.cssSelector("#app-"), 1);
    click(By.cssSelector("#doc-catalog a"));
    click(By.cssSelector("#content a.button:nth-of-type(2)"));

    // General tab
    click(By.xpath("//*[contains(@class, 'tabs')]//a[contains(.,'General')]"));

    selectCheckBox(By.cssSelector("#tab-general label:nth-of-type(1) input"));
    typeText(By.cssSelector("#tab-general [name=name\\[en\\]]"), productName);
    typeText(By.cssSelector("#tab-general [name=code]"), "code123");

    selectCheckBox(By.xpath("//*[@id='category-id-0']/../../tr/td[1]/input"), 0);
    selectCheckBox(By.cssSelector("#tab-general [name=product_groups\\[\\]]"), 0);

    typeText(By.cssSelector("#tab-general [name=quantity"), "123");
    selectItemByIndex(By.cssSelector("#tab-general [name=quantity_unit_id"), 1);
    selectItemByIndex(By.cssSelector("#tab-general [name=delivery_status_id"), 1);
    selectItemByIndex(By.cssSelector("#tab-general [name=sold_out_status_id"), 1);

    attachImage("src/test/resources/duck_horror.jpeg", By.cssSelector("#tab-general [name=new_images\\[\\]"));

    typeText(By.cssSelector("#tab-general [name=date_valid_from"), "Keys.ARROW_LEFT, Keys.ARROW_LEFT, \"10122016\"");
    typeText(By.cssSelector("#tab-general [name=date_valid_to"), "Keys.ARROW_LEFT, Keys.ARROW_LEFT, \"10122017\"");

    // Information tab
    click(By.xpath("//*[contains(@class, 'tabs')]//a[contains(.,'Information')]"));

    selectItemByIndex(By.cssSelector("#tab-information [name=manufacturer_id"), 1);
    selectItemByIndex(By.cssSelector("#tab-information [name=supplier_id"), 1);

    typeText(By.cssSelector("#tab-information [name=keywords"), "keywords");
    typeText(By.cssSelector("#tab-information [name=short_description\\[en\\]"), "short_description[en]");
    typeText(By.cssSelector("#tab-information .trumbowyg-editor"), "description[en]");
    typeText(By.cssSelector("#tab-information [name=head_title\\[en\\]"), "head_title[en]");
    typeText(By.cssSelector("#tab-information [name=meta_description\\[en\\]"), "meta_description[en]");

    // Prices tab
    click(By.xpath("//*[contains(@class, 'tabs')]//a[contains(.,'Prices')]"));
    typeText(By.cssSelector("#tab-prices [name=purchase_price]"), "1");

    selectItemByIndex(By.cssSelector("#tab-prices [name=purchase_price_currency_code"), 1);
    selectItemByIndex(By.cssSelector("#tab-prices [name=tax_class_id"), 1);
    typeText(By.cssSelector("#tab-prices [name=prices\\[USD\\]]"), "1");
    typeText(By.cssSelector("#tab-prices [name=prices\\[EUR\\]]"), "1");
    typeText(By.cssSelector("#tab-prices [name=prices\\[EUR\\]]"), "1");

    click(By.cssSelector("#content [name=save]"));
    click(By.xpath("//a[contains(.,'" + productName + "')]"));
  }
}
