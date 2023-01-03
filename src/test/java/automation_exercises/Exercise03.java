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

public class Exercise03 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test() {
        //  Test Case 3: Login User with incorrect email and password
        //  1. Launch browser
        //  2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //  3. Verify that home page is visible successfully
        WebElement sayfaGorunur = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        Assert.assertTrue(sayfaGorunur.isDisplayed());

        //  4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//*[@class='fa fa-lock']")).click();

        //  5. Verify 'Login to your account' is visible
        WebElement loginToAccount = driver.findElement(By.xpath("//h2"));
        Assert.assertTrue(loginToAccount.isDisplayed());

        //  6. Enter incorrect email address and password
        driver.findElement(By.xpath("//input[@data-qa='login-email']")).sendKeys("h@gmail.com", Keys.TAB,"12345",Keys.TAB);
       // driver.findElement(By.xpath("//input[@data-qa='login-password']")).sendKeys("12345", Keys.ENTER);
        //  7. Click 'login' button
        driver.findElement(By.xpath("(//button[@type='submit'])[1]")).click();
        //  8. Verify error 'Your email or password is incorrect!' is visible
        WebElement incorrect = driver.findElement(By.xpath("//*[text()='Your email or password is incorrect!']"));
        Assert.assertTrue(incorrect.isDisplayed());


    }
}
