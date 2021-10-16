package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class ActionsClassHomeWork extends TestBase {

    //Yeni Class olusturun ActionsClassHomeWork

    @Test
    public void test() {

        //"http://webdriveruniversity.com/Actions" sayfasina gidin

        driver.get("http://webdriveruniversity.com/Actions");

        //2- Hover over Me First" kutusunun ustune gelin

        Actions actions = new Actions(driver);
        WebElement hover = driver.findElement(By.xpath("// button[text()='Hover Over Me First!']"));
        actions.moveToElement(hover).perform();

        //3- Link 1" e tiklayin

        WebElement link1 = driver.findElement(By.xpath("//a[@class='list-alert']"));
        actions.click(link1).perform();

        //4- Pop-up mesajini yazdirin

        String message = driver.switchTo().alert().getText();
        System.out.println(message);

        //5- Pop-up'i tamam diyerek kapatin

        driver.switchTo().alert().accept();

        //6- “Click and hold" kutusuna basili tutun

        WebElement clickandhold = driver.findElement(By.id("click-box"));
        actions.clickAndHold(clickandhold).perform();

        //7-“Click and hold" kutusunda cikan yaziyi yazdirin

        WebElement welldone = driver.findElement(By.xpath("//*[text()='Well done! keep holding that click now.....']"));
        System.out.println(welldone.getText());

        //8- “Double click me" butonunu cift tiklayin

        WebElement doubleClick = driver.findElement(By.tagName("h2"));
        actions.doubleClick(doubleClick).perform();
    }

}
