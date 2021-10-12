package tests.day07;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class C02_DropDown {

    WebDriver driver;

    @BeforeMethod
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);

    }

    @Test
    public void test() {
        driver.get("https://the-internet.herokuapp.com/dropdown");
        //1.adim dropdownu loccate etmek
        WebElement dropDown = driver.findElement(By.id("dropdown"));
        //2.adim select classini kullanarak bir obje olustur ve
        //parametre olarak locate ettigimiz webelementi yaz
        Select select = new Select(dropDown);
        //istedigin option'i select objesi kullanarak sec
        //1.Index kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByIndex(1);
        System.out.println(select.getFirstSelectedOption().getText());


        //2.Value kullanarak Seçenek 2'yi (Option 2) seçin ve yazdırın
        select.selectByValue("2");
        System.out.println(select.getFirstSelectedOption().getText());

        //3.Visible Text(Görünen metin) kullanarak Seçenek 1’i (Option 1) seçin ve yazdırın
        select.selectByVisibleText("Option 1");
        System.out.println(select.getFirstSelectedOption().getText());

        //4.Tüm dropdown değerleri(value) yazdırın
        List<WebElement> tumOpsiyonlar = select.getOptions();
        System.out.println("tum opsiyonlar listesi");
        for (WebElement each : tumOpsiyonlar
        ) {
            System.out.println(each.getText());

            //5. Dropdown’un boyutunu bulun, Dropdown’da 4 öğe varsa konsolda True , degilse False yazdırın.
            System.out.println(tumOpsiyonlar.size());
            if (tumOpsiyonlar.size() == 4) {
                System.out.println("true");
            } else {
                System.out.println("false");
            }
            //  Assert.assertEquals(tumOpsiyonlar.size(),4);
            //System.out.println(options.size()>=4 ? "True" : "False");

        }
    }

    @AfterMethod
    public void tearDown() {
        driver.close();
    }

}
