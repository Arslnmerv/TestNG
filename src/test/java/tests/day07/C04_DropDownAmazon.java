package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;


public class C04_DropDownAmazon {
//    ● Bir class oluşturun: C3_DropDownAmazon
//● https://www.amazon.com/ adresine gidin.


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.amazon.com/");
    }

    @Test (priority = 1)
    public void test1() {
        // - Test 1
        //    Arama kutusunun yanindaki kategori menusundeki kategori
        //    sayisinin 45 oldugunu test edin

        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(selectElement);
//        select.selectByVisibleText("All Departments");
//        System.out.println(select.getFirstSelectedOption().getText());
        List<WebElement> tumKategoriler = select.getOptions();
        System.out.println("tum opsiyonlar listesi");
        for (WebElement each : tumKategoriler
        ) {
            System.out.println(each.getText());

        }
        System.out.println(tumKategoriler.size());
        Assert.assertTrue(tumKategoriler.size() == 45, "kategori sayisi 45 degildir");
    }

    @Test (priority = 2)
    public void test2() {
        WebElement selectElement = driver.findElement(By.id("searchDropdownBox"));
        Select select = new Select(selectElement);
        select.selectByVisibleText("Books");
        driver.findElement(By.id("twotabsearchtextbox")).sendKeys("Java" + Keys.ENTER);
        WebElement result = driver.findElement(By.xpath("//div[@class='a-section a-spacing-small a-spacing-top-small']"));
        System.out.println(result.getText());
        //Assert.assertTrue(result.getText().contains("Java"), "sonuc Java kelimesini icermiyor");
        if(result.getText().contains("Java")){
            System.out.println("result expected iceriyor: PASS");
        }else {
            System.out.println("result expected icermiyor: FAILED");
        }

        //-Test 2
        //1. Kategori menusunden Books secenegini secin
        //2. Arama kutusuna Java yazin ve aratin
        //3. Bulunan sonuc sayisini yazdirin
        //4. Sonucun Java kelimesini icerdigini test edin
    }


    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
