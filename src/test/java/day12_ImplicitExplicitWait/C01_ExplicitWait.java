package day12_ImplicitExplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import utilities.TestBase;

import java.time.Duration;

public class C01_ExplicitWait extends TestBase {

    // 2. Iki tane metod olusturun : implicitWait() , explicitWait()
    // Iki metod icin de asagidaki adimlari test edin.
    @Test
    public void test01() {

        // 3. https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");
        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick  ='swapCheckbox()']")).click();
        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebElement itsgone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
        Assert.assertTrue(itsgone.isDisplayed());
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();
        // 7. It’s back mesajinin gorundugunu test edin
        WebElement itsBack = driver.findElement(By.xpath("//p[text()=\"It's back!\"]"));
        Assert.assertTrue(itsBack.isDisplayed());


    }

    @Test
    public void test02() {
        // 3. https://the-internet.herokuapp.com/
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        // 4. Remove butonuna basin.
        driver.findElement(By.xpath("//button[@onclick  ='swapCheckbox()']")).click();

        // 5. “It’s gone!” mesajinin goruntulendigini dogrulayin.
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(15));
          //WebElement itsgone = driver.findElement(By.xpath("//p[text()=\"It's gone!\"]"));
          //wait.until(ExpectedConditions.visibilityOf(itsgone));
          //Assert.assertTrue(itsgone.isDisplayed());
        //Yazinin gorunur olmasini beklerken yazini locateini olusturmak sorun olusturur,Henuz gorunmeyen yazinin
        //locate edilmesi olmayabilir.Bu durumda bekleme islemini birlikte yapmaliyiz.

        WebElement itsgoneYaziElementi = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's gone!\"]")));
        // 6. Add buttonuna basin
        driver.findElement(By.xpath("//button[text()='Add']")).click();

        // 7. It’s back mesajinin gorundugunu test edin

        WebElement itsBack = wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//p[text()=\"It's back!\"]")));

        Assert.assertTrue(itsBack.isDisplayed());
    }
}
