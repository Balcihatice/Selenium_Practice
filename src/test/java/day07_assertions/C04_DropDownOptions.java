package day07_assertions;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;
import java.util.List;

public class C04_DropDownOptions {
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
    public void test() {

        //amazon sayfasina gidelim
        driver.get("https://www.amazon.com");
        //dropdown menusunden books`u secelim
        WebElement ddm = driver.findElement(By.xpath("//*[@id='searchDropdownBox']"));
        Select select = new Select(ddm);
        select.selectByVisibleText("Books");

        //sectigimiz optioni yazdiralim

        //Bir dropdown ile calisiyorken son secilen optiona ulasmak istersek getFirstSelectedOption() methodunu
        //kullanmaliyiz .Bu method bize webElement dondurur,uzerindeki yaziyi yazdirmak icin gettext() dememiz gerekie
        System.out.println(select.getFirstSelectedOption().getText());

        //dropwon daki optionlarin toplam sayinin 28 oldugunu test edin
        List<WebElement> optionList = select.getOptions();
        int actualOption = optionList.size();
        int expectedOption = 28;
        Assert.assertEquals(expectedOption, actualOption);

    }
}
