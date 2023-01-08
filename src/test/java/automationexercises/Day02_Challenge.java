package automationexercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;

public class Day02_Challenge extends TestBase {

    //1-Test01 isimli bir class olusturun
    //2- https://www.amazon.com/ adresine gidin
    //3- Browseri tam sayfa yapin
    //4-Sayfayi “refresh” yapin
    //5-”Salesforce Apex Questions Bank” icin arama yapiniz
    //6- Kac sonuc bulundugunu yaziniz
    //7-Sayfayi kapatin
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();

        //1-Test01 isimli bir class olusturun
        //2- https://www.amazon.com/ adresine gidin
        driver.get("https://www.amazon.com/");

        //3- Browseri tam sayfa yapin
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //4-Sayfayi “refresh” yapin
        driver.navigate().refresh();

        //5-”Salesforce Apex Questions Bank” icin arama yapiniz
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Salesforce Apex Questions Bank", Keys.ENTER);

        //6- Kac sonuc bulundugunu yaziniz
        String aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        aramaSonucu =  aramaSonucu.replaceAll("[^0-9]","");
        System.out.println(aramaSonucu);

        //7-Sayfayi kapatin
        driver.close();

    }

}
