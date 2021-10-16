package tests.myExercises;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Demo extends TestBase {

    /*
    go to url :http://demo.automationtesting.in/Alerts.html
    click  "Alert with OK" and click 'click the button to display an alert box:'
    accept Alert(I am an alert box!) and print alert on console
    click "Alert with OK & Cancel" and click 'click the button to display a confirm box'
    cancel Alert  (Press a Button !)
    click "Alert with Textbox" and click 'click the button to demonstrate the prompt box'
    and then sendKeys 'TechProEducation' (Please enter your name)
    finally print on console this mesaaje "Hello TechproEducation How are you today"
     */

    @Test
    public void test() {

        driver.get("http://demo.automationtesting.in/Alerts.html");

        driver.findElement(By.xpath("(//a[@class='analystic'])[1]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-danger']")).click();

        System.out.println(driver.switchTo().alert().getText());
        driver.switchTo().alert().accept();

        driver.findElement(By.xpath("(//a[@class='analystic'])[2]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-primary']")).click();
        driver.switchTo().alert().dismiss();

        driver.findElement(By.xpath("(//a[@class='analystic'])[3]")).click();
        driver.findElement(By.xpath("//button[@class='btn btn-info']")).click();

        driver.switchTo().alert().sendKeys("TechProEducation");
        driver.switchTo().alert().accept();

        WebElement message = driver.findElement(By.id("demo1"));
        System.out.println(message.getText());
    }

}
