package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Exercise09 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Click on 'Products' button
    //5. Verify user is navigated to ALL PRODUCTS page successfully
    //6. Enter product name in search input and click search button
    //7. Verify 'SEARCHED PRODUCTS' is visible
    //8. Verify all the products related to search are visible
    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement sayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(sayfa.isDisplayed());

        //4. Click on 'Products' button
        WebElement products = driver.findElement(By.xpath("//*[@class='material-icons card_travel']"));
        products.click();
        driver.navigate().refresh();

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPage.isDisplayed());

        //6. Enter product name in search input and click search button
        WebElement search = driver.findElement(By.xpath("//input[@id='search_product']"));
        search.sendKeys("Blue Top", Keys.TAB, Keys.ENTER);
        //7. Verify 'SEARCHED PRODUCTS' is visible
        WebElement search_product = driver.findElement(By.xpath("//div[@class='features_items']"));
        Assert.assertTrue(search_product.isDisplayed());
        //8. Verify all the products related to search are visible
        driver.navigate().back();
        List<WebElement> allProducts = driver.findElements(By.xpath("//*[@class='productinfo text-center']/p"));
        for (WebElement w : allProducts) {
            Assert.assertTrue(w.isDisplayed());

        }
    }
}