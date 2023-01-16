package day13_Cookies_WebTables;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.List;

public class C02_WebTables extends TestBase {

    @Test
    public void testTable() {

        // https://www.hotelmycamp.com admin/HotelRoomAdmin adresine gidin
        girisYap();
        // Username : manager
        // Password : Manager1! ●table( ) metodu oluşturun
        // Tüm table body’sinin boyutunu(sutun sayisi) bulun.

        List<WebElement> sutunBasliklariListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        System.out.println("SutunSayisi: " + sutunBasliklariListesi.size());

        // Table’daki tum body’I ve başlıkları(headers) konsolda yazdırın.
        WebElement tumBody = driver.findElement(By.xpath("//tbody"));
         System.out.println(tumBody.getText());//body webelementini locate edip getText() ile yazdirabiliriz


        // printRows( ) metodu oluşturun //tr
        //    table body’sinde bulunan toplam satir(row) sayısını bulun.
        List<WebElement> satirlarListesi = driver.findElements(By.xpath("//tbody//tr"));
        System.out.println(satirlarListesi.size());

        //    Table body’sinde bulunan satirlari(rows) konsolda yazdırın.
        for (WebElement each : satirlarListesi) {
            System.out.println(each.getText());
        }

        // satirdaki(row) elementleri konsolda yazdırın
        List<WebElement> cellList = driver.findElements(By.xpath("//tbody//td"));
        for (WebElement each : cellList) {
            System.out.println(each.getText());
        }
        List<WebElement> baslikListesi = driver.findElements(By.xpath("//thead//tr[1]//th"));
        int emailSutunNo = 0;
        for (int i = 0; i < baslikListesi.size(); i++) {
            if (baslikListesi.get(i).getText().equals("Email")) {
                emailSutunNo = i;
            }
        }

        List<WebElement> emailSutunListesi =
                driver.findElements(By.xpath("//thead//td["+(emailSutunNo+1)+"]"));
        for (WebElement each : emailSutunListesi) {
            System.out.println(each.getText());}
    }




    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@text()='Log in']")).click();
        Actions actions = new Actions(driver);
        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
