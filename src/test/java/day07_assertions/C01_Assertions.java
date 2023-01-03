package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Assertions {
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        driver.get("https://www.amazon.com");
    }

    @AfterClass //Sirali islemler yapacaksak Class olarak aciyoruz
    public static void tearDown() {
        driver.quit();
    }


    @Test
    public void test01() {
        //amazon sayfasina gidin, 3 farkli test methodu olusturarak asagidaki gorevleri yapin
        //1-url nin amazon icerdigini test edin
        String actualUrl = driver.getCurrentUrl();
        String arananKelime = "amazon";
        Assert.assertTrue(actualUrl.contains(arananKelime));

    }
    @Test
     public void test02() {
        //2-titlenin facebook icermedigini test edin
        String actualTitle = driver.getTitle();
        String istenmeyenKelime = "facebook";
        Assert.assertFalse(actualTitle.contains(istenmeyenKelime));
    }
    @Test
     public void test03() {
        //3-sol ust kosede amazon logosunun  gorundugunu test edin
        WebElement logo = driver.findElement(By.id("nav-logo-sprites"));
        Assert.assertTrue(logo.isDisplayed());
    }
}
