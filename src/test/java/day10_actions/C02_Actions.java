package day10_actions;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

import java.util.Set;

public class C02_Actions extends TestBase {

    @Test
    public void test() {

        // 2- https://the-internet.herokuapp.com/context_menu sitesine gidelim
        driver.get("https://the-internet.herokuapp.com/context_menu");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        // 3- Cizili alan uzerinde sag click yapalim
        WebElement cizgilialan = driver.findElement(By.id("hot-spot"));

        Actions actions = new Actions(driver);

        actions.contextClick(cizgilialan).perform();
        // 4- Alert’te cikan yazinin “You selected a context menu” oldugunu
        // test edelim.
        String alertYazi = driver.switchTo().alert().getText();
        Assert.assertTrue(alertYazi.contains("You selected a context menu"));

        // 5- Tamam diyerek alert’I kapatalim
        driver.switchTo().alert().accept();

        // 6- Elemental Selenium linkine tiklayalim
        driver.findElement(By.xpath("//*[text()='Elemental Selenium']")).click();

        Set<String> windowHandles = driver.getWindowHandles();//sirali getirmeme ihtimaline karsi
        String ikinciSayfaWindowHandle = "";
        for (String each : windowHandles) {
            if (!each.equals(ilkSayfaWindowHandle)) {
                ikinciSayfaWindowHandle = each;
            }
        }

        // 7- Acilan sayfada h1 taginda “Elemental Selenium” yazdigini test edelim
        driver.switchTo().window(ikinciSayfaWindowHandle);
        WebElement yaziElementi = driver.findElement(By.tagName("h1"));
        String yazi = yaziElementi.getText();
        Assert.assertTrue(yazi.contains("Elemental Selenium"));


    }
}
