package tests.day09;

import org.openqa.selenium.By;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class C04_WindowHandle extends TestBase {

    @Test
    public void test() {
        //● Tests package’inda yeni bir class olusturun: C04_WindowHandle
        //● https://the-internet.herokuapp.com/windows adresine gidin.
        driver.get("https://the-internet.herokuapp.com/windows");
        //● Sayfadaki textin “Opening a new window” olduğunu doğrulayın.

        String actualText = driver.findElement(By.tagName("h3")).getText();
        String expectedText = "Opening a new window";
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualText, expectedText,"test");


        //● Sayfa başlığının(title) “The Internet” olduğunu doğrulayın.
        String actualTitle = driver.getTitle();
        String expectedTitle = "The Internet";

        softAssert.assertEquals(actualTitle, expectedTitle,"tets1");



        driver.findElement(By.linkText("Click Here")).click();
        String ilkHandle = driver.getWindowHandle();

        System.out.println("ilkHandle = " + ilkHandle);
        Set<String> tumWindowlar = driver.getWindowHandles();
        String ikinciHandle = "";
        for (String w : tumWindowlar
        ) {
            if (!w.equals(ilkHandle)) {
                ikinciHandle = w;
            }
        }
        //● Click Here butonuna basın.

        System.out.println(tumWindowlar);
        System.out.println(ikinciHandle);
        driver.switchTo().window(ikinciHandle);

        //● Acilan yeni pencerenin sayfa başlığının (title) “New Window” oldugunu dogrulayin.
        String actualTitle1 = driver.getTitle();
        String expectedTitle1 = "New Window";

        softAssert.assertEquals(actualTitle1, expectedTitle1,"test2");
        //● Sayfadaki textin “New Window” olduğunu doğrulayın.
        String actualTextNew = driver.findElement(By.tagName("h3")).getText();
        String expectedTextNew = "New Window";

        softAssert.assertTrue(actualTextNew.equals(expectedTextNew),"test3");

        //● Bir önceki pencereye geri döndükten sonra sayfa başlığının “The Internet” olduğunu doğrulayın.

        driver.switchTo().window(ilkHandle);
        String actualTitle2 = driver.getTitle();

        softAssert.assertTrue(actualTitle2.equals(expectedTitle));
        softAssert.assertAll();

    }
}
