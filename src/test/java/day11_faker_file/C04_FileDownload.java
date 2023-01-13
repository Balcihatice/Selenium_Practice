package day11_faker_file;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import utilities.TestBase;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class C04_FileDownload extends TestBase {

    @Test
    public void test() {

        //  https://the-internet.herokuapp.com/download adresine gidelim
        driver.get("https://the-internet.herokuapp.com/download");

        //  empty.txt dosyasini indirelim
        WebElement empty = driver.findElement(By.xpath("//*[text()='empty.txt']"));
        empty.click();

        waitFor(6);

        // dosyanin basari ile indirildigini test edelim

        //Burada bize downloadun dosya yolu lazim

        String farkliKisim = System.getProperty("user.home");
        String ortakKisim = "//Downloads/empty.txt";

        String arananDosyaYolu = farkliKisim + ortakKisim;

        Assert.assertTrue(Files.exists(Paths.get(arananDosyaYolu)));
    }
}
