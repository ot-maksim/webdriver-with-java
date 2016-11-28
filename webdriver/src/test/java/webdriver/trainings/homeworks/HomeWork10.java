package webdriver.trainings.homeworks;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import soft.hamcrestassert.SoftHamcrestAssert;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.openqa.selenium.support.ui.ExpectedConditions.titleIs;

/**
 * Created by maksym on 11/23/16.
 */
public class HomeWork10 extends TestBase {

  @Test
  public void checkProductStyle() {

    // NOTE: style assertions are valid only for Chrome (they were not adopted to other browsers)
    
    SoftHamcrestAssert softAssert = new SoftHamcrestAssert();
    driver.get("http://localhost/litecart-1.3.6");
    List<WebElement> campaignsProducts = driver.findElements(By.cssSelector("#box-campaigns ul li"));
    WebElement firstProduct = campaignsProducts.get(0);

    String mainPageProductName = firstProduct.findElement(By.cssSelector("div.name")).getText();
    String mainPageRegularPrice = firstProduct.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getText();
    String mainPageCampaignPrice = firstProduct.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getText();

    String mainPageRegularPriceCssStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getAttribute("class");
    String mainPageCampaignPriceCssStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getAttribute("class");

    // Regular price
    String mainPageRegularPriceColorStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getCssValue("color");
    softAssert.assertThat("Main page product regular price color style mismatches", mainPageRegularPriceColorStyle, is("rgba(119, 119, 119, 1)"));

    String mainPageRegularPriceTextDecorationStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getCssValue("text-decoration");
    softAssert.assertThat("Main page product regular price text-decoration styles mismatch", mainPageRegularPriceTextDecorationStyle, is("line-through"));

    String mainPageRegularPriceFontSizeStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper s.regular-price")).getCssValue("font-size");
    softAssert.assertThat("Main page product regular price font-size styles mismatch", mainPageRegularPriceFontSizeStyle, is("14.4px"));

    // Campaign price
    String mainPageCampaignPriceColorStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getCssValue("color");
    softAssert.assertThat("Main page regular price color styles mismatch", mainPageCampaignPriceColorStyle, is("rgba(204, 0, 0, 1)"));

    String mainPageCampaignPriceFontWeightStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getCssValue("font-weight");
    softAssert.assertThat("Main page regular price text-decoration styles mismatch", mainPageCampaignPriceFontWeightStyle, is("bold"));

    String mainPageCampaignPriceFontSizeStyle = firstProduct.findElement(By.cssSelector("div.price-wrapper strong.campaign-price")).getCssValue("font-size");
    softAssert.assertThat("Main page regular price font-size styles mismatch", mainPageCampaignPriceFontSizeStyle, is("18px"));

    firstProduct.click();

    String productPageProductName = driver.findElement(By.cssSelector("#box-product .title")).getText();
    String productPageRegularPrice = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getText();
    String productPageCampaignPrice = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getText();

    String productPageRegularPriceCssStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getAttribute("class");
    String productPageCampaignPriceCssStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getAttribute("class");

    // Regular price
    String productPageRegularPriceColorStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getCssValue("color");
    softAssert.assertThat("Product page product regular price color styles mismatch", productPageRegularPriceColorStyle, is("rgba(102, 102, 102, 1)"));

    String productPageRegularPriceTextDecorationStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getCssValue("text-decoration");
    softAssert.assertThat("Product page product regular price font-weight styles mismatch", productPageRegularPriceTextDecorationStyle, is("line-through"));

    String productPageRegularPriceFontSizeStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .regular-price")).getCssValue("font-size");
    softAssert.assertThat("Product page product regular price font-size style mismatch", productPageRegularPriceFontSizeStyle, is( "16px"));

    // Campaign price
    String productPageCampaignPriceColorStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getCssValue("color");
    softAssert.assertThat("Product page product campaign price color styles mismatch", productPageCampaignPriceColorStyle, is("rgba(204, 0, 0, 1)"));

    String productPageCampaignPriceFontWeightStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getCssValue("font-weight");
    softAssert.assertThat("Product page product campaign price font-weight styles mismatch", productPageCampaignPriceFontWeightStyle, is("bold"));

    String productPageCampaignPriceFontSizeStyle = driver.findElement(By.cssSelector("#box-product .price-wrapper .campaign-price")).getCssValue("font-size");
    softAssert.assertThat("Product page product campaign price font-size styles mismatch", productPageCampaignPriceFontSizeStyle, is("22px"));


    softAssert.assertThat("Product names mismatch on pages", mainPageProductName, is(productPageProductName));
    softAssert.assertThat("Product regular prices mismatch on pages", mainPageRegularPrice, is(productPageRegularPrice));
    softAssert.assertThat("Product campaign prices mismatch on pages", mainPageCampaignPrice, is(productPageCampaignPrice));
    softAssert.assertThat("Product regular price css styles mismatch on pages", mainPageRegularPriceCssStyle, is(productPageRegularPriceCssStyle));
    softAssert.assertThat("Product campaign price css styles mismatch on pages", mainPageCampaignPriceCssStyle, is(productPageCampaignPriceCssStyle));

    softAssert.assertAll();
  }
}
