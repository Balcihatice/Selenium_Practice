package ders_Notlari01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_Test {
    /*
    1) https://www.amazon.com  url ine gidin
    2) basligin amazon kelimesi icerdigini test edin
    3) Url nin https://www.amazon.com esit oldugunu test edin
    4) sayfayi kapatin
     */

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        String titleName = driver.getTitle();
        String arananKelime = "Amazon";
        if (titleName.contains(arananKelime)){
            System.out.println("Title Test Passed");
        }else System.out.println("Title Test Failed");

        String actualUrl = driver.getCurrentUrl();
        String expectedUrl = "https://www.amazon.com";
        if (expectedUrl.contains(expectedUrl)){
            System.out.println("Passed");
        }else System.out.println("Failed");


        driver.close();

    }
}
