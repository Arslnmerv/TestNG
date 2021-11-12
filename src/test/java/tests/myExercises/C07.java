package tests.myExercises;

import com.github.javafaker.Faker;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.Set;

public class C07 extends TestBase {

    @Test
    public void test() {
        // 1."http://webdriveruniversity.com/" adresine gidin
        driver.get("http://webdriveruniversity.com/");

        //2."Login Portal" a kadar asagi inin
        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        //3."Login Portal" a tiklayin
        driver.findElement(By.xpath("(//div[@class='section-title'])[2]")).click();

        //4.Diger window'a gecin
        String firstHandle = driver.getWindowHandle();
        Set<String> handles = driver.getWindowHandles();
        String secondHandle = "";

        for (String w : handles) {
            if (!w.equals(firstHandle)) {
                secondHandle = w;
            }
        }
        driver.switchTo().window(secondHandle);

        //5."username" ve "password" kutularina deger yazdirin
        WebElement username = driver.findElement(By.id("text"));
        WebElement password = driver.findElement(By.id("password"));
        Faker faker = new Faker();
        username.click();
        username.sendKeys(faker.name().name() + Keys.TAB);
        password.sendKeys(faker.internet().password());

        //6."login" butonuna basin
        driver.findElement(By.id("login-button")).click();

        //7.Popup'ta cikan yazinin "validation failed" oldugunu test edin
        driver.switchTo().alert();
        String alertText = driver.switchTo().alert().getText();
        Assert.assertTrue(alertText.contains("validation failed"));

        //8.Ok diyerek Popup'i kapatin
        driver.switchTo().alert().accept();

        //9.Ilk sayfaya geri donun
        driver.switchTo().window(firstHandle);

        //10.Ilk sayfaya donuldugunu test edin.
        String actualIlkSayfaTitle = driver.getTitle();
        String expectedIlkSayfaTitle = "WebDriverUniversity.com";
        Assert.assertEquals(actualIlkSayfaTitle, expectedIlkSayfaTitle);
    }
}
