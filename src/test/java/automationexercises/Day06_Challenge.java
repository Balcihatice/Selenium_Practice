package automationexercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.util.List;

public class Day06_Challenge extends TestBase {
    @Test
    public void test() {

        //  Given kullanici "https://editor.datatables.net/" sayfasina gider
        driver.get("https://editor.datatables.net/");
        //  Then new butonuna basar
        driver.findElement(By.xpath("//*[text()='New']")).click();
        driver.findElement(By.xpath("//*[@id='DTE_Field_first_name']")).sendKeys("htc", Keys.TAB, "oz");

        //  And editor firstname kutusuna "<firstName>" bilgileri girer
        //  And editor lastname kutusuna "<lastName>" bilgileri girer
        //  And editor position kutusuna "<position>" bilgileri girer
        driver.findElement(By.xpath("//*[@id='DTE_Field_position']"))
                .sendKeys("QA", Keys.TAB, "IT", Keys.TAB, "Senior", Keys.TAB, "2023-01-11", Keys.TAB, "3000", Keys.TAB, Keys.ENTER);
        //  And editor office kutusuna "<office>" bilgileri girer
        //  And editor extension kutusuna "<extension>" bilgileri girer
        //  And editor startdate kutusuna "<startDate>" bilgileri girer
        //  And editor salary kutusuna "<salary>" bilgileri girer
        //  When Create tusuna basar
        //  Then Kullanıcının eklendiğini doğrular.
        // List<WebElement> isimler = driver.findElements(By.xpath("//*[@class='sorting sorting_asc']"));
        driver.findElement(By.xpath("//input[@type='search']")).sendKeys("htc oz");
        waitFor(2);
        Assert.assertTrue(driver.findElement(By.xpath("//*[@class='sorting_1']")).isDisplayed());
        //  And Eklediği kullanıcı kaydını siler
        driver.findElement(By.xpath("//*[@class='sorting_1']")).click();
        waitFor(2);
        driver.findElement(By.xpath("//*[@class='dt-button buttons-selected buttons-remove']")).click();

        driver.findElement(By.xpath("//button[text()='Delete']")).click();


        //  Then Kullanıcinin silindiğini doğrular.
        WebElement bosMu = driver.findElement(By.xpath("//*[@class='dataTables_empty']"));
        Assert.assertTrue(bosMu.isDisplayed());


    }
}