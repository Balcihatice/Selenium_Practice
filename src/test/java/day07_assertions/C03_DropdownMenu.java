package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class C03_DropdownMenu {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @After
    public void tearDown() {
        driver.quit();
    }

    @Test
    public void test() throws InterruptedException {
        //amazon`a gidip dropdown dan books secenegini secip Java aratalim
        // arama sonuclarinin java icerdigini test edin
        driver.get("https://www.amazon.com");

        //Dropdown dan bir option secmek icin 3 adim vardir
        //1.Adim dropdownu locate edelim
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        // 2.Bir select objesi olusturup parametre olarak bir onceki adimdaki webElementi yazalim
        Select select = new Select(ddm);

        //3.Dropdown`da var olan option`lardan istediginiz bir taneyi secelim.
        // select.selectByValue("search-alias=stripbooks-intl-ship");value ile secseydik bu sekilde yazacaktik
        //select.selectByIndex(5);indexle secebiliriz
        select.selectByVisibleText("Books");

        //arama kutusuna "java" yazdiralim
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);


        WebElement sonucYazisi = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        String sonucYazisiStr = sonucYazisi.getText();
        Assert.assertTrue(sonucYazisiStr.contains("Java"));

        Thread.sleep(2000);

    }
}
