package automationexercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import utilities.TestBase;

public class Day07_Challenge extends TestBase {
    @Test
    public void test() {

     // https://rahulshettyacademy.com/AutomationPractice/ adresine gidin
    driver.get("https://rahulshettyacademy.com/AutomationPractice/");
     // Dropdown Example menüsünün görünür olduğunu doğrulayın.
        WebElement dropExam = driver.findElement(By.xpath("//*[@name='dropdown-class-example']"));
        Assert.assertTrue(dropExam.isDisplayed());
     // Option3 ü seçin.
        Select select = new Select(dropExam);
        select.selectByVisibleText("Option3");
     // Option3 ün seçili olduğunu doğrulayın.
        String sectigim = select.getFirstSelectedOption().getText();
        Assert.assertTrue(sectigim.contains("Option3"));



    }
}