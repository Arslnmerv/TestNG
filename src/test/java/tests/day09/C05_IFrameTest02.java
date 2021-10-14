package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C05_IFrameTest02 extends TestBase {

    @Test
    public void test() throws InterruptedException {

        driver.get("http://demo.guru99.com/test/guru99home/");
        //            1) http://demo.guru99.com/test/guru99home/ sitesine gidiniz


        List<WebElement> allIframes = driver.findElements(By.tagName("iframe"));
        System.out.println("Iframe sayisi = " + allIframes.size());

        //            2) sayfadaki iframe sayısını bulunuz.
        driver.switchTo().frame(driver.findElement(By.xpath("//iframe[@wmode='transparent']")));
        driver.findElement(By.xpath("//div[@id='player']")).click();
        Thread.sleep(2000);
        //            3) ilk iframe'deki (Youtube) play butonuna tıklayınız.

        driver.switchTo().defaultContent();
        //            4) ilk iframe'den çıkıp ana sayfaya dönünüz

        driver.switchTo().frame("a077aa5e");
        driver.findElement(By.xpath("//img[@src='Jmeter720.png']")).click();
        //            5) ikinci iframe'deki (Jmeter Made Easy) linke (https://www.guru99.com/live-seleniumproject.html) tıklayınız

    }
}
