package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C05_Actions_Keyboard extends TestBase {

    @Test
    public void test() {


        //facebook ana sayfaya gidelim
        driver.get("https://www.facebook.com");

        //yeni kayit olustur butonuna basin
        driver.findElement(By.xpath("//*[text()='Yeni Hesap Oluştur']")).click();


        //isim kutusunu locate edip geriye kalan kisimlari TAB ile dolasarak formu doldurun
        WebElement name = driver.findElement(By.xpath("//*[@name='firstname']"));
        Actions actions = new Actions(driver);
        actions.click(name)
                .sendKeys("Taha")
                .sendKeys(Keys.TAB,"Alsoy",Keys.TAB,"t@gmail.com",Keys.TAB
                        ,"1234",Keys.TAB,Keys.TAB,"12",Keys.TAB,"06",Keys.TAB,"2022",Keys.TAB,Keys.TAB
                ,Keys.ENTER,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.TAB,Keys.ENTER).perform();
    }
}