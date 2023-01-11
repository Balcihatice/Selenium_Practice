package automationexercises;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import utilities.TestBase;

public class Day08_Challenge extends TestBase {
    @Test
    public void test() {
        // go to url :http://demo.automationtesting.in/Alerts.html
        driver.get("http://demo.automationtesting.in/Alerts.html");

        //    click  "Alert with OK" and click 'click the button to display an alert box:'
        driver.findElement(By.xpath("(//*[@class='analystic'])[1]")).click();

        //"Alert with OK" butonuna tıklayın ve "click the button to display an  alert box:" 'a tıklayın
        driver.findElement(By.xpath("//*[@onclick='alertbox()']")).click();

        //    accept Alert(I am an alert box!) and print alert on console
        System.out.println(driver.switchTo().alert().getText());

        //Alert(I am an alert box!) konsolda yazdırın ve Alert'ü kabul edin.
        driver.switchTo().alert().accept();

        //    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[2]")).click();

        Assert.assertTrue(driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).isDisplayed());

        driver.findElement(By.xpath("//*[@onclick='confirmbox()']")).click();


        System.out.println(driver.switchTo().alert().getText());

        //    cancel Alert  (Press a Button !)
        //Alert'ü kapatın
        driver.switchTo().alert().dismiss();


        //    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
        driver.findElement(By.xpath("(//*[@class='analystic'])[3]")).click();

        //"Alert with Textbox" butonuna tıklayın ve "click the button to demonstrate the prompt box " butonuna tıklayın.
        Assert.assertTrue(driver.findElement(By.xpath("//*[@onclick='promptbox()']")).isDisplayed());

        driver.findElement(By.xpath("//*[@onclick='promptbox()']")).click();
        //    and then sendKeys 'TechProEducation' (Please enter your name)

        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        //    finally print on console this mesaaje "Hello TechproEducation How are you today"
        Assert.assertTrue(driver.findElement(By.xpath("//*[@id='demo1']")).isDisplayed());
    }
}