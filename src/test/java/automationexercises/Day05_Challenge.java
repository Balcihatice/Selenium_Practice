package automationexercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day05_Challenge extends TestBase {

    @Test
    public void test() {

        // Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");

        // click on Phones & PDAs
        driver.findElement(By.xpath("//*[text()='Phones & PDAs']")).click();


        // get the brandName of phones
        List<WebElement> telefonAdi = driver.findElements(By.xpath("//div[@class='caption']"));
        for (WebElement telefon : telefonAdi) {
            System.out.println(telefon);
        }
        // click on add to button for all elements
        List<WebElement> addToCart = driver.findElements(By.xpath("//*[text()='Add to Cart']"));
        for (WebElement w : addToCart) {
            w.click();
        }

        // click on black total added cart button
        driver.findElement(By.xpath("//button[@class='btn btn-inverse btn-block btn-lg dropdown-toggle']")).click();

        // get the names of list from the cart
        List<WebElement> sepet = driver.findElements(By.xpath("//*[@class='text-left']"));
        for (WebElement sepettekiUrun : sepet) {
           if(telefonAdi.contains(sepettekiUrun)){
               System.out.println("Test PASSED");
           }else System.out.println("Test Failed");
        }
        // compare the names from displaying list and cart list



    }
}