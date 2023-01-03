package day_01_02_03;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.time.Duration;
import java.util.List;

public class C12_Locators {
    public static void main(String[] args) {
        WebDriver driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));


        //"http://a.testaddressbook.com " sitesine gidin
        driver.get("http://a.testaddressbook.com");

        //singin butonuna basin
        WebElement signInLinki = driver.findElement(By.linkText("Sign in"));
        signInLinki.click();

        //email,textbox,password ve singing butonlarini locate ediniz
        WebElement emailTextBox = driver.findElement(By.id("session_email"));
        WebElement passwordTextBox = driver.findElement(By.name("session[password]"));
        WebElement singingButonu = driver.findElement(By.name("commit"));

        //Kullanici adini ve sifresini asagidaki gibi girsin.
        //   Username: testtechproed@gmail.com
        //   Password: Test1234!
        emailTextBox.sendKeys("testtechproed@gmail.com");
        passwordTextBox.sendKeys("Test1234!");
        singingButonu.click();

        //Expected user id nin testtechproed@gmail.com oldugunu dogrulayin
        WebElement actualKullaniciAdi = driver.findElement(By.className("navbar-text"));
        System.out.println(actualKullaniciAdi.getText());
        //Bir web elementin uzerinde ne yazdigini gormek istersek gettext() kullaniriz
        String expectedUserMail = "testtechproed@gmail.com";
        if (expectedUserMail.equals(actualKullaniciAdi.getText())) {
            System.out.println("Test Passed");
        } else System.out.println("Test Failed");


        //Adresses ve song out textlerinin goruntulendigini(displayed) dogrulayin(verify)
        WebElement adressesElementi = driver.findElement(By.linkText("Addreses"));
        WebElement singoutElementi = driver.findElement(By.linkText("Sing out"));

        if (adressesElementi.isDisplayed()) {
            System.out.println("Adresses Passed");
        } else System.out.println("Adreses Failed");

        if (singoutElementi.isDisplayed()) {
            System.out.println("Singout Passed");
        } else System.out.println("Singout Failed");


        //Sayfada kac tane link oldugunu bulun
        List<WebElement> linklerListesi = driver.findElements(By.tagName("a"));
        System.out.println(linklerListesi.size());

        //Linkleri yazdiralim --->>>>listemiz webelementlerden olustugu icin direk yazdiramayiz
        //Direk yazdirirsak referance`lari yazdirir. Onun yerine for-each loop ile herbir webElementi
        //uzerindeki yaziyi yazdirmaliyiz
        for (WebElement w : linklerListesi) {
            System.out.println(w.getText());
        }

        //Sayfayi kapatalim
        driver.close();

    }
}
