package tests.day12;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

//1. Bir class olusturun : ExplicitlyWaitTest
public class ExplicitlyWaitTest extends TestBase {

    //2. Bir metod olusturun : enableTest()
    @Test
    public void enableTest() {
        //3. https://demoqa.com/dynamic-properties adresine gidin.
        driver.get("https://demoqa.com/dynamic-properties");

        //4. Will enable 5 seconds’in etkin olmadigini(enabled) test edin
        WebElement button = driver.findElement(By.id("enableAfter"));
        Assert.assertFalse(button.isEnabled(), "Will enable 5 seconds button is enabled");

        //5. Will enable 5 seconds etkin oluncaya kadar bekleyin ve enabled oldugunu test edin
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(button));
        Assert.assertTrue(button.isEnabled(), "Will enable 5 seconds button is unenabled");

    }

    //6. Bir metod olusturun : visibleTest()
    @Test
    public void visibleTest() {
        //7. Ayni sayfaya tekrar gidin, Visible After 5 Seconds butonunun gorunmesini bekleyin, ve gorunur oldugunu test edin.
        driver.get("https://demoqa.com/dynamic-properties");

        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("visibleAfter")));
        WebElement buttonAfter = driver.findElement(By.id("visibleAfter"));
        Assert.assertTrue(buttonAfter.isEnabled(), "Will enable 5 seconds button is unenabled");
    }
}
