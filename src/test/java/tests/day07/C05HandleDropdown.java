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

import java.util.concurrent.TimeUnit;

public class C05HandleDropdown {

//1. http://zero.webappsecurity.com/ Adresine gidin


    WebDriver driver;

    @BeforeClass
    public void setup() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(15, TimeUnit.SECONDS);
        driver.get("http://zero.webappsecurity.com/");
    }

    @Test
    public void test() throws InterruptedException {
        WebElement signIn = driver.findElement(By.id("signin_button"));
        signIn.click();
        //  2. Sign in butonuna basin

        WebElement userName = driver.findElement(By.id("user_login"));
        userName.sendKeys("username" + Keys.TAB + "password");
        Thread.sleep(2000);
        //3. Login kutusuna “username” yazin
        // 4. Password kutusuna “password.” yazin

        WebElement signIn2 = driver.findElement(By.name("submit"));
        signIn2.click();
        driver.navigate().to("http://zero.webappsecurity.com");
        //5. Sign in tusuna basin

        WebElement onlineBanking = driver.findElement(By.xpath("//strong[text()='Online Banking']"));
        onlineBanking.click();

        WebElement payBills = driver.findElement(By.id("pay_bills_link"));
        payBills.click();
//        driver.get("http://zero.webappsecurity.com");
//        driver.findElement(By.id("user_login"));
//        userName.sendKeys("username" + Keys.TAB + "password");
        //6. Pay Bills sayfasina gidin

        WebElement pfc = driver.findElement(By.linkText("Purchase Foreign Currency"));
        pfc.click();
//7. “Purchase Foreign Currency” tusuna basin

        WebElement dropDownInput = driver.findElement(By.id("pc_currency"));
        Select choose = new Select(dropDownInput);
        choose.selectByValue("EUR");
        Thread.sleep(2000);
//8. “Currency” drop down menusunden Eurozone’u secin

        WebElement amount = driver.findElement(By.id("pc_amount"));
        amount.sendKeys("20");
//9. “amount” kutusuna bir sayi girin

        WebElement usDollars = driver.findElement(By.id("pc_inDollars_true"));

        Assert.assertFalse(usDollars.isSelected(), "buton secili!");
//10. “US Dollars” in secilmedigini test edin

        WebElement selectedCurrently = driver.findElement(By.id("pc_inDollars_false"));
        selectedCurrently.click();

//11. “Selected currency” butonunu secin

        WebElement calculateCosts = driver.findElement(By.id("pc_calculate_costs"));
        calculateCosts.click();

        WebElement purchase = driver.findElement(By.id("purchase_cash"));
        purchase.click();
//12. “Calculate Costs” butonuna basin sonra “purchase” butonuna basin

        Assert.assertTrue(driver.findElement(By.id("alert_content")).isDisplayed(), "yazi cikmadi!");
        System.out.println("Foreign currency cash was successfully purchased. ifadesi gozukuyor");

//13. “Foreign currency cash was successfully purchased.” yazisinin ciktigini kontrol edin

    }

    @AfterClass
    public void tearDown() {
        driver.close();
    }

}
