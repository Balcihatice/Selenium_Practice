package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C02_VideoOynat extends TestBase {

    @Test
    public void test() {

        //https://html.com/tags/iframe/ sayfasina gidin
        driver.get("https://html.com/tags/iframe/");


        //3.videoyu gorecek kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).sendKeys(Keys.PAGE_UP).perform();

        //videoyu izlemek icin play tusuna basin
        //Once iframe olusturalim
        WebElement iframe = driver.findElement(By.xpath("//iframe[@src='https://www.youtube.com/embed/owsfdh4gxyc']"));
        driver.switchTo().frame(iframe);

        WebElement play = driver.findElement(By.xpath("//*[@aria-label='Oynat']"));
        play.click();

        //videonun calistigini test edin
        WebElement youtubeYazisi = driver.findElement(By.xpath("//*[@class='ytp-youtube-button ytp-button yt-uix-sessionlink']"));
        Assert.assertTrue(youtubeYazisi.isDisplayed());
    }
}
