package automation_exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Exercise02 {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void finish() {
        // driver.close();
    }

    @Test
    public void test1() {
        driver.get("http://automationexercise.com");
        WebElement sayfaGorunurlugu = driver.findElement(By.xpath("//*[@class='logo pull-left']"));
        Assert.assertTrue(sayfaGorunurlugu.isDisplayed());
        // 4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. Verify 'Login to your account' is visible
        WebElement loginToYourAcc = driver.findElement(By.xpath("//h2[normalize-space()='Login to your account']"));
        Assert.assertTrue(loginToYourAcc.isDisplayed());

        driver.findElement(By.xpath("(//input[@name='email'])[1]")).sendKeys("rose@gmail.com", Keys.ENTER);
        driver.findElement(By.xpath("//input[@name='password']")).sendKeys("password", Keys.ENTER);
        //7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();

        //8. Verify that 'Logged in as username' is visible
        WebElement loggedUser = driver.findElement(By.xpath("//li[10]//a[1]"));
        Assert.assertTrue(loggedUser.isDisplayed());
        // 9. Click 'Delete Account' button
        driver.findElement(By.xpath("//a[normalize-space()='Delete Account']")).click();
        // 10. Verify that 'ACCOUNT DELETED!' is visible
        WebElement accountDelete = driver.findElement(By.xpath("//b[normalize-space()='Account Deleted!']"));
        Assert.assertTrue(accountDelete.isDisplayed());

    }

}
