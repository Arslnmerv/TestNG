package tests.myExercises;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test2_Homework2 extends TestBase {
    @Test
    public void setUp () {

        driver.get("https://books-pwakit.appspot.com");
        JavascriptExecutor jsExecutor =  (JavascriptExecutor)driver;

        WebElement aramaKutusu = (WebElement) jsExecutor.executeScript(
                "return document.querySelector(\"body > book-app\")." +
                        "shadowRoot.querySelector(\"#input\")");

        aramaKutusu.sendKeys("Basitmis degil mi?");
    }
}
