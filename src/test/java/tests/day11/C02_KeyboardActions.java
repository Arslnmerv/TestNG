package tests.day11;


import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

public class C02_KeyboardActions extends TestBase {
//1- Bir Class olusturalim D14_KeyboardActions2



//5- videoyu calistirdiginizi test edin

    @Test
    public void test() {

        driver.get("https://html.com/tags/iframe/");

        //2- https://html.com/tags/iframe/ sayfasina gidelim

        Actions actions = new Actions(driver);
        actions.sendKeys(Keys.PAGE_DOWN).perform();

        WebElement element = driver.findElement(By.className("lazy-loaded"));
        driver.switchTo().frame(element);


        WebElement playTusu = driver.findElement(By.xpath("//button[@class='ytp-large-play-button ytp-button']"));

        playTusu.click();


        //3- video’yu gorecek kadar asagi inin

        Assert.assertFalse(playTusu.isDisplayed());

        //4- videoyu izlemek icin Play tusuna basin

    }
}
