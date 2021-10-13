package tests.myExercises;


import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.util.concurrent.TimeUnit;

public class C01 {

    /**
     * Navigate to  https://www.saucedemo.com/
     * Enter the user name  as standard_user
     * Enter the password as   secret_sauce
     * Click on login button
     * Choose price low to high
     * Verify item prices are sorted from low to high
     */

    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.navigate().to("https://www.saucedemo.com/");
    }

    @Test
    public void test() {

        driver.findElement(By.id("user-name")).sendKeys("standard_user" + Keys.TAB + "secret_sauce");
        driver.findElement(By.id("login-button")).click();

        WebElement dropdown = driver.findElement(By.className("product_sort_container"));
        Select select = new Select(dropdown);
        select.selectByVisibleText("Price (low to high)");

        WebElement boxText = driver.findElement(By.className("active_option"));
        String expectedExpression = "PRICE (LOW TO HIGH)";
        String actualExpression = boxText.getText();
        SoftAssert softAssert = new SoftAssert();
        softAssert.assertEquals(actualExpression, expectedExpression, "Prices didn't sorted from low to high!");
        softAssert.assertAll();

    }


    @AfterClass
    public void tearDown() {
        driver.close();

    }
}


