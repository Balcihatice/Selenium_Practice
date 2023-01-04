package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.devtools.v106.overlay.model.IsolatedElementHighlightConfig;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.Arrays;
import java.util.List;

public class Practice01 {

    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com/");
    }

    @After //Sirali islemler yapacaksak Class olarak aciyoruz
    public void tearDown() {
        driver.quit();
    }


    @Test
    public void test01() {

        // Arama kutusunun yanindaki kategori menusundeki kategori sayisinin 28 oldugunu test edin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        List<WebElement> tumOptions = select.getOptions();
        int actualOptions = tumOptions.size();
        int expectedOptions = 28;
        Assert.assertEquals(expectedOptions, actualOptions);

    }

    @Test
    public void test02() {

        //1. Kategori menusunden Books secenegini secin
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //2. Arama kutusuna Java yazin ve aratin
        WebElement aramaKutusu = driver.findElement(By.xpath("//*[@id='twotabsearchtextbox']"));
        aramaKutusu.sendKeys("Java", Keys.ENTER);

        //3. Bulunan sonuc sayisini yazdirin
        WebElement aramaSonucu = driver.findElement(By.xpath("//*[@class='a-section a-spacing-small a-spacing-top-small']"));
        String[] sonucYazisi = aramaSonucu.getText().split(" ");
        System.out.println(sonucYazisi[3]);

        //4. Sonucun Java kelimesini icerdigini test edin
        String actualSonucYazisi = aramaSonucu.getText();
        Assert.assertTrue(actualSonucYazisi.contains("Java"));

    }
}
