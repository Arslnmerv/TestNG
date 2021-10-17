package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

// 1. Bir class olusturun : EnableTest
public class EnableTest extends TestBase {

//2. Bir metod olusturun : isEnabledTest()

    @Test
    public void isEnabledTest() {
        //3. https://the-internet.herokuapp.com/dynamic_controls adresine gidin.
        driver.get("https://the-internet.herokuapp.com/dynamic_controls");

        //4. Textbox’in etkin olmadigini(enabled) dogrulayın
        WebElement textBox=driver.findElement(By.xpath("//input[@type='text']"));
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertFalse(textBox.isEnabled(),"The textbox is enabled");


        //5. Enable butonuna tıklayın ve textbox etkin oluncaya kadar bekleyin
        driver.findElement(By.xpath("(//button[@autocomplete='off'])[2]")).click();
        WebDriverWait wait = new WebDriverWait(driver,30);
         wait.until(ExpectedConditions.visibilityOfElementLocated(By.id("message")));

        //6. “It’s enabled!” mesajinin goruntulendigini dogrulayın.
        WebElement itsEnabled = driver.findElement(By.id("message"));
        softAssert.assertTrue(itsEnabled.isDisplayed(),"The message of \"It’s enabled!\" unenabled");

       //7. Textbox’in etkin oldugunu(enabled) dogrulayın
       softAssert.assertTrue(textBox.isEnabled(),"The textbox isn't enabled");
       softAssert.assertAll();


    }
}
