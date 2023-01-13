package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

public class C05_FileUpload extends TestBase {

    @Test
    public void uploadTest() {
        //Dosya yukleme

        // https://the-internet.herokuapp.com/upload sayfasina gidelim

        driver.get("https://the-internet.herokuapp.com/upload");
        //choose file butonuna basalim
        //yuklemek istediginiz dosyayi secin
    /*
    Bu islemi selenium ile yapmak imkansiz ,Cunku web tabanli bir uygulama degil,
    Bu durumda sendkeys() imdadimiza yetisir. Eger chooseFile butonuna var olan bir dosya
    yolunu yollarsak secme islemi otoatik olarak yapilmis olacaktir.
    */
        //1.Adim choose file butonunu locate edelim
        WebElement dosyaSec = driver.findElement(By.xpath("//input[@name='file']"));

        //2. Adim yuklemek istedgin dosyanin dosya yolunu olusturalim.

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "//Downloads/some-file (1).txt";

        String yuklenecekDosya = farkliKisim + ortakKisim;
        //3.Adim sendKey ile dosya yolunu secme butonuna gonderelim

        dosyaSec.sendKeys(yuklenecekDosya);

        waitFor(5);
        //Upload butonuna basin
        driver.findElement(By.xpath("//*[@value='Upload']")).click();

        //File Uploaded! textinin goruntulendigini test edelim
        Assert.assertTrue(driver.findElement(By.xpath("//h3")).isDisplayed());

    }

}
