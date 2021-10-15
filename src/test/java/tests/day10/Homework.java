package tests.day10;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Homework extends TestBase {

    @Test
    public void test() {

        //    Go to http://demo.guru99.com/test/drag_drop.html url

        driver.get("http://demo.guru99.com/test/drag_drop.html");

        //    Drag and drop the SALES button to the Account section in CREDIT SIDE

        Actions actions = new Actions(driver);

        WebElement salesButton = driver.findElement(By.xpath("(//a[@class='button button-orange'])[6]"));
        WebElement accountInCredit = driver.findElement(By.xpath("(//h3[@class='ui-widget-header'])[5]"));

        actions.dragAndDrop(salesButton, accountInCredit).perform();


        //    Drag and drop the 5000 button to the Amount section in DEBIT SIDE

        WebElement button5000 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[2]"));
        WebElement amountInDebit = driver.findElement(By.xpath("(//h3[@class='ui-widget-header'])[3]"));

        actions.dragAndDrop(button5000, amountInDebit).perform();


        //    Drag and drop the second 5000 button to the Amount section in CREDIT SIDE

        WebElement secondButton5000 = driver.findElement(By.xpath("(//a[@class='button button-orange'])[4]"));
        WebElement amoundInCredit = driver.findElement(By.xpath("(//h3[@class='ui-widget-header'])[6]"));

        actions.dragAndDrop(secondButton5000, amoundInCredit).perform();


    }

}
