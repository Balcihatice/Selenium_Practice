package ders_Notlari01;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class  C13_WebElementMethodlari {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

        //Amazon.com a gidip arama kutusunu locat edin
        driver.get("https://www.amazon.com");

        //arama kutusunun tagnameinin input oldugunu test edin
        WebElement aramaKutusu =  driver.findElement(By.id("twotabsearchtextbox"));

        //arama kutusunun tagnameinin input oldugunu test edin
        String expectedTagName = "input";
        String actualTagName = aramaKutusu.getTagName();

        if (expectedTagName.equals(actualTagName)) {
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");

        //arama kutusunun name attributte`un degerinin ..field-keywords.... oldugunu test edin
        String expectedNAmeDegeri = "field-keywords";
        String actualNameDegeri = aramaKutusu.getAttribute("name");
        if (expectedTagName.equals(actualNameDegeri)) {
            System.out.println("Name Attributte Test PASSED");
        } else System.out.println("Name Attributte Test FAILED");


        driver.close();

       /*
        webElementIsmi.getTagName() -->> daha once locate ettigimiz bir webelementin tagname`ini
        dondurur,
        webElementIsmi.getAttribute(attributeIsmi) ==>> daha once locate ettigimiz bir
        webelementin istedigimiz attributenunun degerini dondurur
       */

    }
}
