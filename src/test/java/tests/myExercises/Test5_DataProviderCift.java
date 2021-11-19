package tests.myExercises;

import org.openqa.selenium.By;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import utilities.TestBase;

public class Test5_DataProviderCift extends TestBase {

    @DataProvider
    public static Object[][] signInTest() {
        Object [][] gmibankData = new Object[2][2];

        gmibankData [0][0] = "username@gmail.com";
        gmibankData [0][1] = "password1";
        gmibankData [1][0] = "username2@gmail.com";
        gmibankData [1][1] = "password2";

   /*    Object gmibankData [][] = {
                {"username1@gmail.com","passwoord1"},
                {"username2@gmail.com","passwoord2"}
        };  */

        return gmibankData;
    }

    @Test (dataProvider = "signInTest")
    public void test(String username , String password) {

        driver.get("https://www.gmibank.com/");

        driver.findElement(By.xpath("//li[@id='account-menu']")).click();
        driver.findElement(By.xpath("//span[text()='Sign in']")).click();
        driver.findElement(By.id("username")).click();
        driver.findElement(By.id("username")).sendKeys(username);
        driver.findElement(By.id("password")).sendKeys(password);
        driver.findElement(By.xpath("(//span[text()='Sign in'])[2]")).click();

    }


}
