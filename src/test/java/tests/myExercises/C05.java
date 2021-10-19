package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class C05 extends TestBase {

    /*
       ~ Navigate to http://tutorialsninja.com/demo/index.php?route=common/home
       ~ click on Phones & PDAs
       ~ get the brandName of phones
       ~ click on add to button for all elements
       ~ click on black total added cart button
       ~ get the names of list from the cart
       ~ compare the names from displaying list and cart list

        */

    static List<WebElement> products = new ArrayList<>();
    static List<WebElement> basket = new ArrayList<>();
    List<String> productsStr = new ArrayList<>();
    List<String> basketStr = new ArrayList<>();

    @Test
    public void clickAllElements() throws InterruptedException {


        driver.get("http://tutorialsninja.com/demo/index.php?route=common/home");
        driver.findElement(By.linkText("Phones & PDAs")).click();

        products.addAll(driver.findElements(By.tagName("h4")));
        List<WebElement> addButtons = driver.findElements(By.xpath("//button[contains(@onclick,'cart.add')]"));

        for (WebElement w : products) {
            System.out.println(w.getText());
            productsStr.add(w.getText());
        }

        for (WebElement w : addButtons) {
            w.click();
            Thread.sleep(1000);
        }

    }

    @Test(dependsOnMethods = "clickAllElements")
    public void getName() {

        driver.findElement(By.id("cart-total")).click();

        basket.addAll(driver.findElements(By.xpath("//td[@class='text-left']")));
        for (WebElement w : basket) {
            System.out.println(w.getText());
            basketStr.add(w.getText());
        }
        
    }

    @Test(dependsOnMethods = "getName")
    public void compareTwoList() {

        Collections.sort(productsStr);
        Collections.sort(basketStr);

        Assert.assertEquals(productsStr, basketStr, "The lists are missmatch!");

    }

}



