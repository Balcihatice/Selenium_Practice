package day10;

import com.beust.ah.A;
import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import utilities.TestBase;

public class C03_Actions extends TestBase {

    @Test
    public void test() {

        //https://www.demoga.com/droppable adresine gidin
        driver.get("https://demoqa.com/droppable");

        //"drag me" butonunu tutup "Drop here" kutusunun uzerine birakin

        WebElement dragMe = driver.findElement(By.xpath("//*[text()='Drag me']"));
        WebElement drogHere = driver.findElement(By.xpath("//*[text()='Drop here']"));
        Actions action = new Actions(driver);
        action.dragAndDrop(dragMe, drogHere).perform();

        //"Drop here" yazisini yerine "Dropped!" oldugunu test edin
        WebElement dropped = driver.findElement(By.xpath("//*[text()='Dropped!']"));
        String droppedText = dropped.getText();
        Assert.assertTrue(droppedText.contains("Dropped!"));

    }
}
