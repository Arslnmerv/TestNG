package tests.myExercises;

import org.openqa.selenium.JavascriptExecutor;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test3_Js_Facebook extends TestBase {

    @Test
    public void setUp () {
        driver.get("https://www.facebook.com");

        JavascriptExecutor js = (JavascriptExecutor)  driver;

        js.executeScript("document.getElementById('email').value='deneme@abc.com';");
        js.executeScript("document.getElementById('pass').value='123456';");

    }
}
