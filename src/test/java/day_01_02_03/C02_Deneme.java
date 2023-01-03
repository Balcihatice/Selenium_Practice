package day_01_02_03;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;

public class C02_Deneme {

    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.amazon.com");
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
        System.out.println("Actual title " + driver.getTitle());
        System.out.println(driver.getCurrentUrl());
        System.out.println(driver.getPageSource());

        driver.close();
    }
}
