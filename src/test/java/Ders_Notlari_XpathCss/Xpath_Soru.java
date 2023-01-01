package Ders_Notlari_XpathCss;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class Xpath_Soru {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));
        //https://the-internet.herokuapp.com/add_remove_elements/ adresine gidin 2- Add Element butonuna basin
        driver.get("https://the-internet.herokuapp.com/add_remove_elements/");
        driver.findElement(By.xpath("//*[@onclick='addElement()']")).click();
        //Delete butonu’nun gorunur oldugunu test edin

        WebElement deleteButonu = driver.findElement(By.xpath("//*[@class='added-manually']"));
        if (deleteButonu.isDisplayed()) {
            System.out.println("Delete Butunu PASSED");
        } else System.out.println("Delete Butunu FAILED");


        //Delete tusuna basin
        deleteButonu.click();
        //Add/Remove Elements yazisinin gorunur olmadigini test edin
        WebElement addRemove = driver.findElement(By.xpath("//h3"));
        if (addRemove.isDisplayed()) {
            System.out.println("Add/Remove PASSED");
        } else System.out.println("Add/Remove FAILED");

       driver.close();
    }
}