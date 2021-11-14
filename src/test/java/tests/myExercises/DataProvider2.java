package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class DataProvider2 extends TestBase {

    // Siteyi açınız. http://opencart.abstracta.us/index.php?route=account/login ,
   // login yapiniz Email: asd@gmail.com   password : 123qweasd
   // Search fonksiyonunu kullanarak
   // Mac,ipod ve samsung icin Dataprovider ile yapınız.

    @DataProvider
    public static Object[] products() {
        String arr[] = {"Mac", "ipod", "samsung"};
        return arr;
    }

    @Test(dataProvider = "products")
    public void test(String product) {
        driver.get("http://opencart.abstracta.us/index.php?route=account/login");
        WebElement userNameTextbox = driver.findElement(By.id("input-email"));
        WebElement passwordTextbox = driver.findElement(By.id("input-password"));

        userNameTextbox.sendKeys("asd@gmail.com");
        passwordTextbox.sendKeys("123qweasd");

        driver.findElement(By.xpath("//input[@value='Login']")).click();
        WebElement searchArea = driver.findElement(By.xpath("//input[@name='search']"));
        searchArea.clear();
        searchArea.sendKeys(product);
    }

}
