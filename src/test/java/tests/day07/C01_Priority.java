package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class C01_Priority {

    //3 test methodu olusturun
    //ve sayfa title;larini yazdirsin
    WebDriver driver;
    @BeforeMethod
    public void setup () {
        WebDriverManager.chromedriver().setup();
        driver= new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15,TimeUnit.SECONDS);
    }
    @Test (priority = 1)
    public void amazonTest () {
        driver.get("https://www.amazon.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //1.amazon ana sayfasina
    }
    @Test (priority = -1)
    public void techProTest () {
        driver.get("https://www.techproeducation.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //2.techproeducation ana sayfasina
    }
    @Test //priority yazmayinca 0 gibi algilar. Default 0 kabul eder
    public void faceTest () {
        driver.get("https://www.facebook.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());
        //3.facebook ana sayfaya gitsin
    }
    @Test //priority yazilmayan iki test varsa onlari kendi icinde alfabetik siralar
    public void yahooTest () {
        driver.get("https://www.yahoo.com");
        System.out.println("driver.getTitle() = " + driver.getTitle());

    }
    @AfterMethod
    public void tearDown () {
        driver.quit();
    }
}
