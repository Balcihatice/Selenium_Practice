package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.Set;

public class C03_WindowHandle extends TestBase {

    @Test
    public void test() {

        // Tests package’inda yeni bir class olusturun: WindowHandle2
        // https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        String ilkSayfaHandle = driver.getWindowHandle();
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.
        String opening = driver.findElement(By.xpath("//h3")).getText();
        Assert.assertTrue(opening.contains("Opening a new window"));
        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String sayfaBasligi = driver.getTitle();
        Assert.assertTrue(sayfaBasligi.contains("The Internet"));

        //● Click Here butonuna basın.
        driver.findElement(By.linkText("Click Here")).click();
        /*
        switchTo().newWindow();demeden link tiklayarak yeni tab vey window olustugunda
        biz driver`a yeni sayfaya gec demeden ,driver eski sayfada kalir
        ve yeni sayfa ile ilgili hic bir islem yapamaz.Yeni sayfada driveri calistirmek
        isstersek once driveri yeni sayfaya gondermeliyiz
         */

        Set<String> windowHandleSeti = driver.getWindowHandles();
        //Set`te index yoktur.
        String ikinciSayfaWindowHandleDegeri="";
        for (String each : windowHandleSeti){
            if (!each.equals("ilkSayfaHandle")){
                ikinciSayfaWindowHandleDegeri =each;
            }
        }
        driver.switchTo().window(ikinciSayfaWindowHandleDegeri);


        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String newTitle = driver.getTitle();
        Assert.assertTrue(newTitle.contains("New Window"));
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        WebElement newtext = driver.findElement(By.xpath("//h3"));
        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.
        driver.switchTo().window(ilkSayfaHandle);
        String ilkSayfaTitle = driver.getTitle();
        Assert.assertTrue(ilkSayfaTitle.contains("The Internet"));

    }
}
