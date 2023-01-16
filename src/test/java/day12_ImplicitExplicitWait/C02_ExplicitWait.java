package day12_ImplicitExplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;
import java.util.List;
import java.util.Set;

public class C02_ExplicitWait extends TestBase {

    @Test
    public void test01() {
        // 3. https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        //Textbox  etkin olmadigini dogrulayin
        WebElement enableKutusu = driver.findElement(By.xpath("//*[@type = 'text']"));
        Assert.assertFalse(enableKutusu.isEnabled());

        //enable butonu a tiklayin ve textbox etkin alana kadar bekleyin
        driver.findElement(By.xpath(("//button[text()='Enable']"))).click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
        wait.until(ExpectedConditions.elementToBeClickable(enableKutusu));


        // It’s enable!" mesajinin gorundugunu test edin
        WebElement itsEnable = driver.findElement(By.xpath("//*[text()=\"It's enabled!\"]"));
        Assert.assertTrue(itsEnable.isEnabled());

        //Textbot in gorunur oldugunu dogrulayin
        Assert.assertTrue(enableKutusu.isEnabled());


    }
}
