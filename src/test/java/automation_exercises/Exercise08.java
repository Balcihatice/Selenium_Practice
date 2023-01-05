package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Exercise08 extends TestBase {
//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Products' button
//5. Verify user is navigated to ALL PRODUCTS page successfully
//6. The products list is visible
//7. Click on 'View Product' of first product
//8. User is landed to product detail page
//9. Verify that detail detail is visible: product name, category, price, availability, condition, brand

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

        //5. Verify user is navigated to ALL PRODUCTS page successfully
        WebElement productPage = driver.findElement(By.xpath("//h2[@class='title text-center']"));
        Assert.assertTrue(productPage.isDisplayed());

        //6. The products list is visible
        WebElement productsList = driver.findElement(By.xpath("//*[@class='features_items']"));
        Assert.assertTrue(productsList.isDisplayed());

        //7. Click on 'View Product' of first product
        WebElement view = driver.findElement(By.xpath("(//*[@class='fa fa-plus-square'])[1]"));
        driver.navigate().refresh();
        view.click();
        //8. User is landed to product detail page
        WebElement urunDetay = driver.findElement(By.xpath("//*[@class='newarrival']"));
        Assert.assertTrue(urunDetay.isDisplayed());

        //9. Verify that detail detail is visible: product name, category, price, availability, condition, brand
        WebElement blueTop = driver.findElement(By.xpath("//*[text()='<h2>Blue Top</h2>']"));
        Assert.assertTrue(blueTop.isDisplayed());
        WebElement category = driver.findElement(By.xpath("//*[text()='Category: Women > Tops']"));
        Assert.assertTrue(category.isDisplayed());
        WebElement price = driver.findElement(By.xpath("//*[text()='Rs. 500']"));
        Assert.assertTrue(price.isDisplayed());
        WebElement availability = driver.findElement(By.xpath("//*[text()='In Stock']"));
        Assert.assertTrue(availability.isDisplayed());
        WebElement condition = driver.findElement(By.xpath("//*[text()='Condition']"));
        Assert.assertTrue(condition.isDisplayed());
        WebElement brand = driver.findElement(By.xpath("//*[text()='Brand']"));
        Assert.assertTrue(brand.isDisplayed());


    }
}
