package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        // Yeni bir class olusturalim: D15_MouseActions4
        // 1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

        // 2- Yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("//a[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();

        // 3- Ad, soyad, mail ve sifre kutularina deger yazalim

        driver.findElement(By.name("firstname")).sendKeys("Ahmet" + Keys.TAB + "Kaya"
                + Keys.TAB + "ahmetkaya0101@gmail.com"
                + Keys.TAB + "AhmetKaya27Ak.");

        // 4- Bu secimleri yaptiktan sonra 5 saniye bekleyelim

        Thread.sleep(5000);

        // 5- Dogum tarihi bolumundeki gun,ay ve yil kutularina deger yazalim

        WebElement dogumTarihiGun = driver.findElement(By.xpath("//select[@id='day']"));
        dogumTarihiGun.click();
        Select secim1 = new Select(dogumTarihiGun);
        secim1.selectByValue("7");
        WebElement dogumTarihiAy = driver.findElement(By.xpath("//select[@id='month']"));
        dogumTarihiAy.click();
        Select secim2 = new Select(dogumTarihiAy);
        secim2.selectByVisibleText("Tem");
        WebElement dogumTarihiYil = driver.findElement(By.xpath("//select[@id='year']"));
        dogumTarihiYil.click();
        Select secim3 = new Select(dogumTarihiYil);
        secim3.selectByVisibleText("1985");

        // 6- Cinsiyet kutucugunu belirleyip isaretleyelim

        WebElement cinsiyetSecimi = driver.findElement(By.xpath("//input[@value='2']"));
        cinsiyetSecimi.click();

        // 7- Bu secimleri yaptiktan sonra 5 saniye bekleyelim

        Thread.sleep(5000);

        // 8- Kaydol tusuna basalim

        WebElement kaydolButtonu = driver.findElement(By.name("websubmit"));
        kaydolButtonu.click();

        // Tam sorunu bilmemekle beraber, 2 ekran kullanimindan ya da Test Page Database kaynakli bir
        // sorundan dolayi; acilan WebPage' de kayit ol butonuna bastiktan sonra, bizden yeniden e-mail
        // girmemizi istiyor. Halbuki normal tarayicidan siteye giris yaptigimizda sayfadaki form
        // tablosunda en basta sadece 1 sefer e-mail girisi yapilacak yer gozukuyor. Bu yüzden ben de
        // böyle bir yol gelistirip, sisteme : " Biz her türlü kayit oluruz kardes, sen rahat ol " sosyal
        // mesajini vermis oldum :D

        WebElement emailTekrari = driver.findElement(By.xpath("(//input[@data-type='text'])[4]"));
        emailTekrari.click();
        emailTekrari.sendKeys("ahmetkaya0101@gmail.com");
        kaydolButtonu.click();
    }

}
