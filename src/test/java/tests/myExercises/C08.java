package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.List;

public class C08 extends TestBase {
    // http://the-internet.herokuapp.com/add_remove_elements/
// click on the "Add Element" button 100 times
// write a function that takes a number, and clicks the "Delete" button
// given number of times, and then validates that given number of
// buttons was deleted

    @Test
    public void test() {

        driver.get("http://the-internet.herokuapp.com/add_remove_elements/");
          createButtons(100);
          deleteButtonandValidate(90);
    }

    private void createButtons(int numberofButtontoAdd) {
        WebElement button = driver.findElement(By.xpath("(//button[@onclick='addElement()'])"));
        for (int i = 0; i < numberofButtontoAdd; i++) {
            button.click();
        }
    }

    private void deleteButtonandValidate (int number) {

        List <WebElement> deleteElements = driver.findElements(By.xpath("(//button[@onclick='deleteElement()'])"));
         int size = deleteElements.size();
         List <WebElement> removeDeleteButtons = driver.findElements(By.xpath("(//button[@onclick='deleteElement()'])"));
         int count =0;

        for (WebElement w:removeDeleteButtons
             ) {
            count++;
            if (count>number) {
                break;
            }
            w.click();
        }

        List<WebElement> elementAfter = driver.findElements(By.xpath("//button[@onclick='deleteElement()']"));
        int sizeAfterDeleting = elementAfter.size();
        if ((size- number) == sizeAfterDeleting ) {
            System.out.println("PASS");
        }else
            System.out.println("FAIL");
    }
    }




