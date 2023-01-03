package day_05_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C04_Assertions {
    WebDriver driver;

    @Before
    public void setUp() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @After
    public void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){
        //Eger test metodumuzda hic bir test yoksa,test calistiktan sonra hic bir problemle
        // karsilasilmadigini raporlamak icin test passed yazisi cikar
        //eger testleri if ile yapaarsak test failed olsa bile kodlar problemsiz calistigi icin kod calismasi bittiginde
        //ekranin sol alt kisminda test passed yazacaktir.Junit ile if-else donemini kapatiyoruz.

        driver.get("https:www.amazon.com");
        //url in "https://www.facebook.com oldugunu test edin
        String expectedUrl = "https://www.facebook.com";
        String actualUrl = driver.getCurrentUrl();

        Assert.assertEquals("Url beklenenden farkli " ,expectedUrl, actualUrl);
    }
    //Assert ile yaptigimiz testlerde assertion failed olursa java kodlarin calismasini durdurur
    //ve Assert class`i bizi hata konusunda bilgilendirir.
    //Boylece hatanin ne oldugunu arastirmaya gerek kalmadan Junit bizi bilgilendirecek

}
