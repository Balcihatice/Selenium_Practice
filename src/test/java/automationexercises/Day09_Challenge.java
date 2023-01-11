package automationexercises;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import utilities.TestBase;

import java.time.Duration;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day09_Challenge  {
    WebDriver driver;
    @Before
    public void setUp(){
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }
    @After
    public void tearDown(){
        driver.close();
    }
    @Test
    public void iframeTest() throws InterruptedException {

        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");


        // ikinci emojiye tıklayın
        WebElement iFrame = driver.findElement(By.id("emoojis"));
        driver.switchTo().frame(iFrame);


        // ikinci emoji altındaki tüm öğelere tıklayın
        driver.findElement(By.xpath("(//span[@data-upgraded=',MaterialRipple'])[2]")).click();
        List<WebElement> allEmojiis = driver.findElements(By.xpath("//div[@id='nature']/div/img"));

        allEmojiis.forEach(WebElement::click);


        // ana iframe'e geri dön
        driver.switchTo().defaultContent();


        //formu doldurun,(Formu istediğiniz metinlerle doldurun)
        driver.findElement(By.xpath("//*[@id='text']")).sendKeys("explication", Keys.TAB,"rose",
                Keys.TAB,"LALE",Keys.TAB,"banana",Keys.TAB,"tenis",Keys.TAB,"maison",Keys.TAB,"fenetre",Keys.TAB,"drape",Keys.TAB,"france",
                Keys.TAB,":))",Keys.TAB,"sourire",Keys.TAB,Keys.ENTER);





        // uygula butonuna tıklayın
        driver.findElement(By.id("send")).click();


    }
}