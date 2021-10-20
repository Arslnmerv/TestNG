package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C06 extends TestBase {

     /*
    go to url : http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html
    Fill in capitals by country
     */

    @Test
    public void test () throws InterruptedException {

        driver.get("http://www.dhtmlgoodies.com/scripts/drag-drop-custom/demo-drag-drop-3.html");

        List<WebElement> list = driver.findElements(By.xpath("//div[contains(@id,'box')]"));

        for (int i = 0; i < list.size(); i++) {
            Actions actions = new Actions(driver);
            actions.dragAndDrop(list.get(1),list.get(12)).perform();
            actions.dragAndDrop(list.get(2),list.get(13)).perform();
            actions.dragAndDrop(list.get(4),list.get(11)).perform();
            actions.dragAndDrop(list.get(5),list.get(7)).perform();
            actions.dragAndDrop(list.get(3),list.get(10)).perform();
            actions.dragAndDrop(list.get(0),list.get(9)).perform();
            actions.dragAndDrop(list.get(6),list.get(8)).perform();

            break;
        }

    }

}
