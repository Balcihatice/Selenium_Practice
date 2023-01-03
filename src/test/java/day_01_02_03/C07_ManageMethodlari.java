package day_01_02_03;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C07_ManageMethodlari {

    public static void main(String[] args) throws InterruptedException {

        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();

        System.out.println("Pencere olculeri : " + driver.manage().window().getSize());
        System.out.println("Pencere Konumu : " + driver.manage().window().getPosition());

        Thread.sleep(3000);

        //pencerenin konumunu ve buyuklugunu degistirelim
        driver.manage().window().setPosition(new Point(15, 40));
        driver.manage().window().setSize(new Dimension(600, 600));
        //emin olmak icin sonrasinda yazdirip gorebiliriz
        System.out.println("Yeni Pencere olculeri : " + driver.manage().window().getSize());
        System.out.println("Yeni Pencere Konumu : " + driver.manage().window().getPosition());

        driver.close();
    }
}
