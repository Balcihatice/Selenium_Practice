package day_01_02_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C11_FindElements {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //Amazon sayfasinda kac tane link bulundugunu yazdirin
        driver.get("https://www.amazon.com");
        List<WebElement> linkListesi = driver.findElements(By.tagName("a"));
        System.out.println(linkListesi.size());
        driver.close();
    }
}
