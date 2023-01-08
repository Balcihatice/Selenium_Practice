package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class Exercise10 extends TestBase {

    //1. Launch browser
    //2. Navigate to url 'http://automationexercise.com'
    //3. Verify that home page is visible successfully
    //4. Scroll down to footer
    //5. Verify text 'SUBSCRIPTION'
    //6. Enter email address in input and click arrow button
    //7. Verify success message 'You have been successfully subscribed!' is visible

    @Test
    public void test() {
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");

        //3. Verify that home page is visible successfully
        WebElement sayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(sayfa.isDisplayed());
        //4. Scroll down to footer
        Actions actions = new Actions(driver);

        actions
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .sendKeys(Keys.PAGE_DOWN)
                .perform();


        //5. Verify text 'SUBSCRIPTION'
        WebElement subscription = driver.findElement(By.xpath("//h2[text()='Subscription']"));
        Assert.assertTrue(subscription.isDisplayed());
        //6. Enter email address in input and click arrow button
        driver.findElement(By.id("susbscribe_email")).sendKeys("htc@gmail.com", Keys.TAB, Keys.ENTER);
        waitFor(5);
    }
}