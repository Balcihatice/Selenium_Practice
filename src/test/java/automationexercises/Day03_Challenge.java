package automationexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

public class Day03_Challenge extends TestBase {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        //  1. http://zero.webappsecurity.com sayfasina gidin
        driver.get("http://zero.webappsecurity.com");

        //  2. Signin buttonuna tiklayin
        driver.findElement(By.xpath("//button[@id='signin_button']")).click();
        //  3. Login alanine  "username" yazdirin
        driver.findElement(By.xpath("//input[@id='user_login']")).sendKeys("username");


        //  4. Password alanine "password" yazdirin
        //  5. Sign in buttonuna tiklayin (hata mesaji icin back tusuna tiklayin)
        driver.findElement(By.xpath("//input[@id='user_password']"))
                .sendKeys("password", Keys.TAB, Keys.TAB, Keys.ENTER);
        driver.navigate().back();

        //  6. Online Banking menusunden Pay Bills sayfasina gidin
        driver.findElement(By.xpath("//*[@id='onlineBankingMenu']")).click();
        driver.findElement(By.xpath("//*[@id='pay_bills_link']")).click();

        //  7. amount kismina yatirmak istediginiz herhangi bir miktari yazin
        driver.findElement(By.xpath("//*[@name='amount']")).sendKeys("2000$");


        //  8. tarih kismina "2020-09-10" yazdirin
        driver.findElement(By.xpath("//*[@name='date']")).sendKeys("2020-09-10");

        //  9. Pay buttonuna tiklayin
        driver.findElement(By.xpath("//*[@type='submit']")).click();

        //  10. "The payment was successfully submitted." mesajinin ciktigini kontrol edin
        String submitYazisi = driver.findElement(By.xpath("//*[text()='The payment was successfully submitted.']")).getText();

        if (submitYazisi.equals("The payment was successfully submitted.")) {
            System.out.println("Test PASS");
        } else {
            System.out.println("Test FAIL");
        }

        driver.close();
    }


}