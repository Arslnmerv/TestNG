package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_Actions extends TestBase {


    @Test
    public void test() throws InterruptedException {

        //amazon sayfasina gidin

        driver.get("https://amazon.com");
        //nutella icin  arama yapin

        WebElement aramaKutusu = driver.findElement(By.id("twotabsearchtextbox"));
        aramaKutusu.sendKeys("nutella" + Keys.ENTER);

        //9.urunu tiklayin

        Thread.sleep(2000);
        driver.findElement(By.xpath("(//span[@class='a-size-base-plus a-color-base a-text-normal'])[9]")).click();
    }
}
