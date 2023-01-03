package day_01_02_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C09_ManageMethodlari {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        // 'implicitlyWait' amaci acilana kadar beklemektir,max sureye kadar beklemek degildir
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
        /*
        Ilerde wait konusunu daha genis olarak ele alacagiz
        Bir sayfa acilirken ilk basta sayfani icerisinde bulunan elementlere
        gore bir yuklenme suresine ihtiyac vardir.
        Veya bir web elementini kullanilabilmesi icin zamana ihtiyac olabilir
        'implicitlyWait' bize sayfanin yuklenmesi ve sayfadaki elementlere ulasabilecek
        max sureyi belirleme olanagi verir.
         */

        driver.close();// son acik olan browser`i kapatir
        //driver.quit(); Acik olan tum browser`lari kapatir

    }
}
