package day13_Cookies_WebTables;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.Cookie;
import utilities.TestBase;

import java.util.Set;

public class C03_Cookies extends TestBase {

    @Test
    public void testCookies() {
        //Amazon sayfasina gidin
        driver.get("https://www.amazon.com");

        //Tum Cookie leri listeleyin
        Set<Cookie> cookiesSet = driver.manage().getCookies();
        int sayac = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(sayac + " .ci cookie " + each);
            System.out.println("Value : " + each.getValue());
            System.out.println("Name : " + each.getName());
            sayac++;
        }

        //Sayfadaki cookie sayisinin 5 ten buyuk oldugunu test edin
        int cookieSayisi = cookiesSet.size();
        Assert.assertTrue(cookieSayisi > 5);

        //Ismi i18n-prefs olan cooki degerinin "USD" oldugunu test edin
        for (Cookie each : cookiesSet) {
            if (each.getName().equals("i18n-prefs")) {
                Assert.assertEquals("USD", each.getValue());
            }
        }

        //Ismi "en sevdigim cookie" ve degeri "cikolata" olan bir cookie olusturun
        Cookie cookie = new Cookie("en sevdigim cookie", "cikolata");//olusturduk
        driver.manage().addCookie(cookie);
        cookiesSet = driver.manage().getCookies();//Set attik
        sayac = 1;
        for (Cookie each : cookiesSet) {
            System.out.println(sayac + " .ci cookie " + each);
            sayac++;
        }
        //eklediginiz cookinin eklendigini test edin
        Assert.assertTrue(cookiesSet.contains(cookie));

        //ismi skin olan cookie`yi silin
        driver.manage().deleteCookieNamed("skin");
        cookiesSet = driver.manage().getCookies();
        Assert.assertFalse(cookiesSet.contains("skin"));

        //tum cookileri silin ve silindigini test edin
        driver.manage().deleteAllCookies();
        cookiesSet = driver.manage().getCookies();//Set attik ve size`in dn kontrol ettik
        Assert.assertTrue(cookiesSet.isEmpty());
    }
}
