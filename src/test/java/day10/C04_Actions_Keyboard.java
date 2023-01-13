package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C04_Actions_Keyboard extends TestBase {

    @Test
    public void test() {

        //amazona gidelim
        driver.get("https://www.amazon.com");
        WebElement aramaKuutusu = driver.findElement(By.id("twotabsearchtextbox"));

        //once arama kutusuna click yapalim
        //sonra harf harf Nutella yazalim sonra enter tusuna basalim
        Actions actions = new Actions(driver);
        actions.click(aramaKuutusu).perform();

        //keyDown(Keys.SHIFT) shift`e bastik -- keyUp(Keys.SHIFT) shift`e elimizi cektik
        actions.keyDown(Keys.SHIFT).sendKeys("n").keyUp(Keys.SHIFT)
                .sendKeys("u")
                .sendKeys("t")
                .sendKeys("e")
                .sendKeys("l")
                .sendKeys("l")
                .sendKeys("a")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
