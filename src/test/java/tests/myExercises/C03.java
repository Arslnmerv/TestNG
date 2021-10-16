package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;


public class C03 extends TestBase {


    @Test
    public void test() throws InterruptedException {

//        1- https://www.facebook.com adresine gidelim

        driver.get("https://www.facebook.com");

//        2- Yeni hesap olustur butonuna basalim

        driver.findElement(By.xpath("//*[@class='_42ft _4jy0 _6lti _4jy6 _4jy2 selected _51sy']")).click();


//        3- Ad, soyad, mail ve sifre kutularina deger yazalim ve kaydol tusuna
//        basalim

        Actions actions = new Actions(driver);
        WebElement ad = driver.findElement(By.xpath("//*[@class='inputtext _58mg _5dba _2ph-']"));
        actions.clickAndHold(ad).perform();
        ad.sendKeys("ayse" + Keys.TAB + "aralik" + Keys.TAB + "aralikayse@gmail.com");

        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[4]")).click();
        driver.findElement(By.xpath("(//input[@class='inputtext _58mg _5dba _2ph-'])[4]")).sendKeys("aralikayse@gmail.com" + Keys.TAB + "1453");


//        4- Kaydol tusuna basalim

        driver.findElement(By.name("websubmit")).click();


    }
}
