package day09;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C01_HandleWindow extends TestBase {

    @Test
    public void test() {
        //Amazon ana sayfaya gidin
        //Icinde bulundugumuz sayfanin windowHandle ini alma
        driver.get("https://www.amazon.com");
        String ilkSayfaHandle = driver.getWindowHandle();
        System.out.println(ilkSayfaHandle);//Bu acilan sayfanin unique hash kodudur


        //Eger sayfalar arasinda driverimizi gezdiriyorsak ve herhangi bir sayfadan su anda
        // bulundugumuz sayfaya gecmek istiyorsak driver.switchTo().window(handle1); sekilde yazariz
        //driver.switchTo().window(handle1);


        //Nutella icin arama yaptirin
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);

        //Ilk urunun resmini tiklayarak farkli bir tab olarak acin
        WebElement ilkUrunResmi = driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]"));
        driver.switchTo().newWindow(WindowType.TAB);
        /*Bu Komutu kullandigimizda driver otomatik olarak olusturulan newTab a gecer,
        Yeni tab da gorevi gerceklestirmek icin adimlari bastan almamiz gerekir
         */
        driver.get("https://www.amazon.com");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Nutella", Keys.ENTER);
        driver.findElement(By.xpath("(//div[@class='a-section aok-relative s-image-square-aspect'])[1]")).click();


        //Yeni tab da acilan urunun basligini yazdirin
        WebElement urunTitle = driver.findElement(By.xpath("//*[@id='productTitle']"));
        System.out.println(urunTitle.getText());
        System.out.println(driver.getCurrentUrl());//ikinci sayfanin

        //Ilk sayfaya donelim
        driver.switchTo().window(ilkSayfaHandle);
        System.out.println(driver.getCurrentUrl());//birinci sayfanin
    }


}
