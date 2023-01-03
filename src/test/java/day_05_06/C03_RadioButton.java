package day_05_06;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C03_RadioButton {
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
    public void test() throws InterruptedException {
        // Bir class oluşturun : RadioButtonTest
        // Gerekli yapiyi olusturun ve aşağıdaki görevi tamamlayın.
        // https://www.facebook.com adresine gidin - “Create an Account” button’una basin
        driver.get("https://www.facebook.com");
        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();
        //“radio buttons” elementlerini locate edin
        WebElement femaleButton = driver.findElement(By.xpath("(//input[@class='_8esa'])[1]"));
        WebElement maleButton = driver.findElement(By.xpath("//*[@class='_8esa']"));
        WebElement customButton = driver.findElement(By.xpath("//*[@value='-1']"));
        Thread.sleep(3000);
        //Secili degilse cinsiyet butonundan size uygun olani secin
        if (!femaleButton.isSelected()) {
            femaleButton.click();
        }
        Thread.sleep(3000);

    }
}