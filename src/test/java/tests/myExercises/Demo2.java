package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;
import utilities.TestBase;

import java.util.Set;

public class Demo2 extends TestBase {

     /*
      go to url :http://demo.guru99.com/popup.php
      get the first window
      clicking on click here button
      get all the window in the set
      switch to window
      input email id (someone@gmail.com) and type something in that input
      Clicking on the submit button
      verify title as expected
      switch to first window

     */

    @Test
    public void test() {

        driver.get("http://demo.guru99.com/popup.php");

        String firstWindow = driver.getWindowHandle();

        driver.findElement(By.linkText("Click Here")).click();

        Set<String> allWindows = driver.getWindowHandles();
        String secondWindow = "";

        for (String w : allWindows) {

            if (!w.equals(firstWindow)) {
                secondWindow = w;
            }
        }

        driver.switchTo().window(secondWindow);

        WebElement input = driver.findElement(By.xpath("//input[@name='emailid']"));
        input.click();
        input.sendKeys("someone@gmail.com");

        driver.findElement(By.name("btnLogin")).click();

        SoftAssert softAssert = new SoftAssert();
        softAssert.assertTrue(driver.getTitle().equals("Guru99 Bank Home Page"), "The titles are missmatch");
        softAssert.assertAll();

        driver.switchTo().window(firstWindow);


    }
}
