package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Exercise11 extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click 'Cart' button
//5. Scroll down to footer
//6. Verify text 'SUBSCRIPTION'
//7. Enter email address in input and click arrow button
//8. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement sayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(sayfa.isDisplayed());

        //4. Click 'Cart' button


        //5. Scroll down to footer


        //6. Verify text 'SUBSCRIPTION'



        //7. Enter email address in input and click arrow button


        //8. Verify success message 'You have been successfully subscribed!'





    }
}