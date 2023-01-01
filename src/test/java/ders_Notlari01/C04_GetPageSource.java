package ders_Notlari01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C04_GetPageSource {

    //amazon sitesine gidip kaynak kodlarinda "Gateway" yazdigini test edin.

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://amazon.com");
        String sayfaKaynakKodlari = driver.getPageSource();

        String arananKelime = "Gateway";
        if (sayfaKaynakKodlari.contains(arananKelime)) {
            System.out.println("Passed");
        } else System.out.println("Failed");
        driver.close();

    }
}
