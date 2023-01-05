package automation_exercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class Exercise05 extends TestBase {

// 1. Launch browser
//2. Navigate to url 'http://automationexercise.com'
// 3. Verify that home page is visible successfully
//4. Click on 'Signup / Login' button
//5. Verify 'New User Signup!' is visible
//6. Enter name and already registered email address
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible

    @Test
    public void test() {
//2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
// 3. Verify that home page is visible successfully
        WebElement sayfa = driver.findElement(By.xpath("//*[@src='/static/images/home/logo.png']"));
        Assert.assertTrue(sayfa.isDisplayed());
//4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();
//5. Verify 'New User Signup!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='New User Signup!']")).isDisplayed());
//6. Enter name and already registered email address
        driver.findElement(By.xpath("//*[@data-qa='signup-name']")).sendKeys("hatice", Keys.TAB,
                "h@gmail.com", Keys.TAB, Keys.ENTER);
//7. Click 'Signup' button
//8. Verify error 'Email Address already exist!' is visible
        Assert.assertTrue(driver.findElement(By.xpath("//*[text()='Email Address already exist!']")).isDisplayed());
    }
}
