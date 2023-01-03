package day_01_02_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C08_ManageMethodlari {

    public static void main(String[] args) {

        WebDriver driver = new ChromeDriver();

        driver.manage().window().maximize();

        //maxsimize iken boyutlari ve konumu alalim
        System.out.println("Maximize konum:"+ driver.manage().window().getPosition());
        System.out.println("Maximize boyut:"+ driver.manage().window().getSize());

        //Fullscreen iken boyutlari ve konumu alalim
        driver.manage().window().fullscreen();
        System.out.println("Fullscreen konum:"+ driver.manage().window().getPosition());
        System.out.println("Fullscreen boyut:"+ driver.manage().window().getSize());

        //driver`i kapatalim
        driver.close();




    }
}
