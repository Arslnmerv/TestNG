package tests.day09;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Homework extends TestBase {


    @Test
    public void test () throws InterruptedException {
        driver.get("https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/");
        //go to web site : https://www.jqueryscript.net/demo/Easy-iFrame-based-Twitter-Emoji-Picker-Plugin-jQuery-Emoojis/
        //maximize the web site --> by TestBase

        driver.switchTo().frame("emoojis");
        driver.findElement(By.xpath("(//span[@class='mdl-tabs__ripple-container mdl-js-ripple-effect'])[2]")).click();


        //click on second emoji

        List<WebElement> allEmojis=driver.findElements(By.xpath("//div[@class='mdl-tabs__panel is-active']/div/img"));
        for (WebElement each:allEmojis)
        {
            each.click();
        }
        //click all second emoji's element

        driver.switchTo().defaultContent();

        //go back parent iframe

        List <WebElement> inputs = driver.findElements(By.tagName("input"));

        List<String> personalize= new ArrayList<>(Arrays.asList("Text","Smiles","Nature","Food","Activities","Places","Objects","Symbols","Flags","Emojis","Tab"));
        for (int i = 0;i<inputs.size(); i++) {
            inputs.get(i).sendKeys(personalize.get(i));
        }

        //fill out the form,(Fill the form with the texts you want)

        driver.findElement(By.id("send")).click();
        //click on apply button
    }
}
