package ders_Notlari01;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C05_GetWindowHandle {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com/");
        System.out.println(driver.getWindowHandle());
        //Benzersiz olarak acilan window`a ait hash kodu verir.bu kodu bilirsek window`lar arasi gezebiliriz
        driver.close();
    }
}
