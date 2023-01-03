package automation_exercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class Exercise01 {
    public static void main(String[] args) {
        WebDriverManager.chromedriver().setup();
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //2. Navigate to url 'http://automationexercise.com'
        driver.get("http://automationexercise.com");
        //3. Verify that home page is visible successfully
        WebElement gorunur = driver.findElement(By.xpath("//div[@class='logo pull-left']"));
        if (gorunur.isDisplayed()) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");
        //4. Click on 'Signup / Login' button
        driver.findElement(By.xpath("//a[@href='/login']")).click();
        //5. eni Kullanıcı Kaydı'nı doğrulayın! görünür
        WebElement userSignup = driver.findElement(By.className("signup-form"));
        if (userSignup.isDisplayed()) {
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");
        //6. Enter name and email address
        driver.findElement(By.xpath("//input[@name='name']")).sendKeys("Rose", Keys.ENTER);
        driver.findElement(By.xpath("(//input[@type='email'])[2]")).sendKeys("htc@gmail.com", Keys.ENTER);

        //7. Click 'Signup' button
        driver.findElement(By.xpath("(//button[@class='btn btn-default'])[2]"));
        //8. Verify that 'ENTER ACCOUNT INFORMATION' is visible
        WebElement account = driver.findElement(By.xpath("//button[@type='submit']"));
        if (account.isDisplayed()) {
            System.out.println("Account Test PASSED");
        } else System.out.println("Account Test FAILED");
        //9. Fill details: Title, Name, Email, Password, Date of birth
        driver.findElement(By.xpath("//*[@id='id_gender2']")).click();

        WebElement password = driver.findElement(By.xpath("//*[@id='password']"));
        password.click();
        password.sendKeys("password");
        WebElement day = driver.findElement(By.xpath("//*[@name='days']"));
        day.click();
        day.sendKeys("20");
        WebElement month = driver.findElement(By.xpath("//*[@id='months']"));
        month.click();
        month.sendKeys("May", Keys.ENTER);
        WebElement year = driver.findElement(By.xpath("//select[@id='years']"));
        year.click();
        year.sendKeys("2020");
        //10. Select checkbox 'Sign up for our newsletter!'
        driver.findElement(By.xpath("//*[@id='newsletter']")).click();
        //11. Select checkbox 'Receive special offers from our partners!'
        driver.findElement(By.xpath("//*[@id='optin']")).click();
        //12. Fill details: First name, Last name, Company, Address, Address2, Country, State, City, Zipcode, Mobile Number
        WebElement firstName = driver.findElement(By.xpath("//*[@name='first_name']"));
        firstName.sendKeys("Rose");
        WebElement lastName = driver.findElement(By.xpath("//*[@name='last_name']"));
        lastName.sendKeys("Edwards");
        WebElement company = driver.findElement(By.xpath("//*[@name='company']"));
        company.sendKeys("cosmos");
        WebElement address = driver.findElement(By.xpath("//*[@name='address1']"));
        address.sendKeys("Mugla");
        WebElement address2 = driver.findElement(By.xpath("//*[@name='address2']"));
        address2.sendKeys("Fethiye");

        WebElement country = driver.findElement(By.xpath("//*[@id='country']"));
        //country.click();
        //account.sendKeys("Canada".toLowerCase());
        Select select = new Select(country);
        select.selectByValue("Canada");

        WebElement state = driver.findElement(By.xpath("//*[@id='state']"));
        state.sendKeys("Ottowa");
        WebElement city = driver.findElement(By.xpath("//*[@id='city']"));
        city.sendKeys("banaz");
        WebElement zipcode = driver.findElement(By.xpath("//*[@id='zipcode']"));
        zipcode.sendKeys("07100");
        WebElement mobileNumber = driver.findElement(By.xpath("//*[@id='mobile_number']"));
        mobileNumber.sendKeys("1234567");
        //13. Click 'Create Account button'
        driver.findElement(By.xpath("(//*[@type='submit'])[1]")).click();
        //14. Verify that 'ACCOUNT CREATED!' is visible
        WebElement accountCreate = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(accountCreate.isDisplayed());
        //15. Click 'Continue' button
        driver.findElement(By.xpath("//*[@data-qa='continue-button']")).click();
        //16. Verify that 'Logged in as username' is visible
        WebElement loggedUser = driver.findElement(By.xpath("//*[@class='fa fa-user']"));
        Assert.assertTrue(loggedUser.isDisplayed());
        //17. Click 'Delete Account' button
        driver.findElement(By.xpath("//*[@text()='Delete Account'")).click();
        //18. Verify that 'ACCOUNT DELETED!' is visible and click 'Continue' button
        WebElement accountDeleted = driver.findElement(By.xpath("//*[@class='title text-center']"));
        Assert.assertTrue(accountDeleted.isDisplayed());
        driver.close();


    }
}