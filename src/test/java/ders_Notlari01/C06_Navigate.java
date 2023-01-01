package ders_Notlari01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C06_Navigate {
   /*
    Eger testimiz sirasinda birden fazla sayfa arasindaileri geri gideceksek
    driver.get() yerine driver.navigate().to() methodunu kullaniriz.
    Ve sonrasinda forward(),back() veya refresh() methodlarini kullanabiliriz
   */
    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        //Amazona gidelim
        driver.navigate().to("https://www.amazon.com");
        Thread.sleep(2000);

        //Sonra facebook`a gidelim
        driver.navigate().to("https://www.facebook.com");
        Thread.sleep(2000);

        //Amazon`a geri donelim
        driver.navigate().back();
        Thread.sleep(2000);

        //yeniden facebook`a gidelim
        driver.navigate().forward();

        //sayfayi refresh yapalim
        driver.navigate().refresh();

        //Sayfayi kapatalim
        driver.close();
    }
}
