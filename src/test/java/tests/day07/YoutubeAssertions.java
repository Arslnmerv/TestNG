package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.concurrent.TimeUnit;

public class YoutubeAssertions{

//    1) Bir class oluşturun: YoutubeAssertions

 WebDriver driver;
    @BeforeMethod
    public  void setup(){
        WebDriverManager.chromedriver().setup();
        driver=new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("https://www.youtube.com/");
        //2) https://www.youtube.com adresine gidin
    }
    //3) Aşağıdaki adları kullanarak 4 test metodu oluşturun ve gerekli testleri yapin

    @Test
    public void titleTest(){
        String expectedTitle="YouTube";
        String actualTitle= driver.getTitle();
        Assert.assertEquals(actualTitle,expectedTitle,"Sayfa title'i beklenenden farkli");
        //○ titleTest => Sayfa başlığının “YouTube” oldugunu test edin
    }
    @Test
    public void logoTesti(){
        WebElement logo=driver.findElement(By.xpath("(//yt-icon[@id='logo-icon'])[1]"));
        Assert.assertTrue(logo.isDisplayed(),"Logo gorunmuyor");
        //○ imageTest => YouTube resminin görüntülendiğini (isDisplayed()) test edin
    }
    @Test
    public void aramaKutusuTesti(){
        WebElement aramaKutusu=driver.findElement(By.id("search-input"));
        Assert.assertTrue( aramaKutusu.isEnabled(),"Arama kutusuna ulasilamiyor");
        //○ Search Box 'in erisilebilir oldugunu test edin (isEnabled())
    }
    @Test
    public void yanlisTitleTesti(){
        String istenmeyenBaslik="youtube";
        String actualTitle= driver.getTitle();
        Assert.assertNotEquals(istenmeyenBaslik,actualTitle,"Title istenmeyen kelimeye esit");
        Assert.assertFalse(istenmeyenBaslik.equals(actualTitle),"false mesaji");
        Assert.assertTrue(!istenmeyenBaslik.equals(actualTitle),"True Mesaji");
        //○ wrongTitleTest => Sayfa basliginin “youtube” olmadigini dogrulayin
    }
    @AfterMethod
    public void tearDown(){
        driver.close();
    }

}

