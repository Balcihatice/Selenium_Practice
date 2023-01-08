package day09;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.WindowType;
import utilities.TestBase;

public class C02_HandleWindows extends TestBase {
    @Test
    public void test() {

        //1-amazon anasayfaya gidelim
        driver.get("https://www.amazon.com");
        String ilkSayfaWindowHandle = driver.getWindowHandle();

        //2-url in amazon icerdigini test edelim
        String url = driver.getCurrentUrl();
        Assert.assertTrue(url.contains("amazon"));

        //3-yeni bir pencere acip bastbuy anasayfaya gidelim
        driver.switchTo().newWindow(WindowType.WINDOW);

        //4-titlenin BestBuy icerdigini test edelim
        driver.get("https://www.bestbuy.com");
        String ikinciWindowHandle = driver.getWindowHandle();

        //5-ilk sayfaya donup sayfada java aratalim
        driver.switchTo().window(ilkSayfaWindowHandle);

        //6-arama sonuclarinin "java" icerdigini test edelim
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java", Keys.ENTER);
        String aramaSonucuText = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']")).getText();
        Assert.assertTrue(aramaSonucuText.contains("Java"));

        //7- yeniden BestBuyin acik oldugu sayfaya gidelim
        driver.switchTo().window(ikinciWindowHandle);

        //8-logonun gorundugunu test edelim
        WebElement logoElementi = driver.findElement(By.xpath("(//*[@class='logo'])[1]"));
        Assert.assertTrue(logoElementi.isDisplayed());
    }
}