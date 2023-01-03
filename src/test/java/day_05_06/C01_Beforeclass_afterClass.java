package day_05_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.*;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C01_Beforeclass_afterClass {
   /*
   Beforeclass ve AfterClass methodlari sadece static methodlar icin calisir
   */
    static WebDriver driver;

    @BeforeClass
    public static void setUp() {
        WebDriverManager.chromedriver().setup();//chromun ayarlarini yaptik
        driver = new ChromeDriver(); //driver objesi olusturduk
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
    }

    @AfterClass
    public static void tearDown() {
        driver.quit();
    }
    @Test
    public void test(){
        driver.get("https://www.amazon.com");
    }
}
