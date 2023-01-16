package day13_Cookies_WebTables;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03 extends TestBase {
    public void girisYap() {

        driver.get("https://www.hotelmycamp.com");
        driver.findElement(By.xpath("//*[@text()='Log in']")).click();
        Actions actions = new Actions(driver);

        WebElement userName = driver.findElement(By.id("UserName"));
        actions.click(userName)
                .sendKeys("manager")
                .sendKeys(Keys.TAB)
                .sendKeys("Manager1!")
                .sendKeys(Keys.ENTER)
                .perform();

    }
}
