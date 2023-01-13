package day11_faker_file;


import org.junit.Assert;
import org.junit.Test;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.sql.SQLOutput;

public class C03_FileExist {

    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
        System.out.println(System.getProperty("user.home"));

        //homePath + "/Downloads"

        String dosyaYolu = System.getProperty("user.home") + "/Desktop";
        System.out.println(dosyaYolu);

        //Masa ustundeki jpeg dosyasinin varligini test edin
        String resim = System.getProperty("user.home") + "/Desktop/logo.jpeg";
        System.out.println(resim);

        //Bilgisayarda bir dosyanin varligini test etmek icin once dosyaya ulasmamiz gerekir
        //Java da dosyaya erisim icin dosya yoluna yani paatj e ihtiyac vardir
        //Her bilgisayarin kullanici adi farkli olacagindan masa ustu dosya yolu da birbirinden farkli olacaktir
        //Testlerimizin tum ortamlarda calismasi icin dosya yolunu dinamik yapmaliyiz

        //Bunun icin her bilgisayarin birbirinden farkli olan yolunu bulmak icin
        String farkliKisim = System.getProperty("user.home");

        //Herkeste ortak olan kisim ise
        String ortakKisim = "/Desktop/logo.jpeg";

        String masaUstuDosyaYolu = farkliKisim + ortakKisim;


        System.out.println(Files.exists(Paths.get(masaUstuDosyaYolu)));
        //asser ile de kontrol edelim
        Assert.assertTrue(Files.exists(Paths.get(masaUstuDosyaYolu)));
    }
}
