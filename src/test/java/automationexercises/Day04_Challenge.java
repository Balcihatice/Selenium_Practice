package automationexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Day04_Challenge extends TestBase {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //1. "https://www.saucedemo.com" Adresine gidin
        driver.get("https://www.saucedemo.com");

        //2. Username kutusuna "standard_user" yazdirin
        driver.findElement(By.id("user-name")).sendKeys("standard_user");

        //3. Password kutusuna "secret_sauce" yazdirin
        driver.findElement(By.xpath("//input[@id='password']")).sendKeys("secret_sauce");

        //4. Login tusuna basin
        driver.findElement(By.xpath("//input[@id='login-button']")).click();

        //5. Ilk urunun ismini kaydedin ve bu urunun sayfasina gidin
        String ilkUrun = driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).getText();
        driver.findElement(By.xpath("//div[text()='Sauce Labs Backpack']")).click();

        //6. Add to Cart butonuna basin
        driver.findElement(By.xpath("//button[@id='add-to-cart-sauce-labs-backpack']")).click();

        //7. Alisveris sepetine tiklayin
        driver.findElement(By.xpath("//div[@id='shopping_cart_container']")).click();

        //8. Sectiginiz urunun basarili olarak sepete eklendigini control edin
        String actualName = driver.findElement(By.xpath("//*[@class='inventory_item_name']")).getText();
        if (ilkUrun.equals(actualName)) {
            System.out.println("Test PASSED");
        } else System.out.println("Test FAILED");

        //9. Sayfayi kapatin
        driver.close();

    }

}
