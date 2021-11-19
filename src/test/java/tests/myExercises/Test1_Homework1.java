package tests.myExercises;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test1_Homework1 extends TestBase {

    @Test
    public void setUp () {

        driver.get("https://shop.polymer-project.org");
        JavascriptExecutor jsExecutor =  (JavascriptExecutor)driver;

        WebElement shopNowButton = (WebElement) jsExecutor.executeScript(
                "return document.querySelector(\"body > shop-app\")." +
                        "shadowRoot.querySelector(\"iron-pages > shop-home\")." +
                        "shadowRoot.querySelector(\"div:nth-child(2) > shop-button > a\")");
        shopNowButton.click();
    }
}
