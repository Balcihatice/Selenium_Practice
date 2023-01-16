package day12_ImplicitExplicitWait;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

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

//
    }
}
