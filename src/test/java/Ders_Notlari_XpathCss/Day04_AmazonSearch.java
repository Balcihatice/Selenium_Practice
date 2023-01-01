package Ders_Notlari_XpathCss;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class Day04_AmazonSearch {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //amazon sayfasina gidin
        driver.get("https://www.amazon.com");
        //Search kutusuna" city bike"
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("city bike" + Keys.ENTER);
        //goruntulenen ilgili sonuclarin sayisini yazdirin
        List<WebElement> istenenListe = driver.findElements(By.className("sg-col-inner"));
        WebElement sonucYazisielementi = istenenListe.get(0);
        System.out.println(sonucYazisielementi.getText());
        //ilk resme tiklayin
        List<WebElement> urunResimleri = driver.findElements(By.className("s-image"));
        WebElement ilkUrunResmi = urunResimleri.get(0);
        ilkUrunResmi.click();

        //sayfayi kapatin
        driver.close();

    }
}
