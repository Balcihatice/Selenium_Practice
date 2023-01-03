package day_01_02_03;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C10_Locators {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazona gidip Nutella aratalim
        driver.get("https://www.amazon.com");

        //findElement(By ...locator)-->> istedigimiz web elementini bize dondurur
        //bizde o elementi kullanmak icin bir objeye assign ederiz
        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //herhangi bir web elementini aramak istersek

        //Locator alirken gozden kacan detaylar olabilir.Aldigimiz locator calismadiysa
        //baska alternatifler denemeliyiz
        aramaKutusu.sendKeys("Nutella", Keys.ENTER);
        WebElement aramaSonucYazisi = driver.findElement(By.className("sg-col-inner"));
        System.out.println(aramaSonucYazisi.getText());

        driver.close();
    }
}
