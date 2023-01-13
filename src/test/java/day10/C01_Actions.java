package day10;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C01_Actions extends TestBase {
    // Uc adimda Actions classi kullanabiliriz
    //1-object olustur
    // Actions action = new Actions(driver);
    //2-WebElementi ogesini locate et

    //3-action.click().perform();

    //perform() yazmazsak action islemi gerceklestirmez

    @Test
    public void test01() {

        //Amazon a gidin
        driver.get("https://www.amazon.com");

        //Account bolumunden  create a list linkine tikla
        WebElement account = driver.findElement(By.xpath("//*[text()='Account & Lists']"));
        Actions action = new Actions(driver);
        action.moveToElement(account).perform();
        waitFor(5);

        WebElement createLink = driver.findElement(By.xpath("//span[text()='Create a List']"));
        createLink.click();


    }
}
