package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Exercise07 extends TestBase {

//1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
//3. Verify that home page is visible successfully
//4. Click on 'Test Cases' button
//5. Verify user is navigated to test cases page successfully

    @Test
    public void test() throws InterruptedException {
        //1. Launch browser
        //2. Navigate to url 'http://automationexercise.com
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement sayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(sayfa.isDisplayed());
        //4. Click on 'Test Cases' button
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[text()=' Test Cases']")).click();
        //5. Verify user is navigated to test cases page successfully
        WebElement testCasePage = driver.findElement(By.xpath("//*[text()='Test Cases']"));
        Assert.assertTrue(testCasePage.isDisplayed());
    }
}
