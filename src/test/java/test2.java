package Tests;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.sql.Driver;
import java.util.concurrent.TimeUnit;

public class test2 {

    public WebDriver driver;
    //public WebDriverWait wait;
    @Before
    public void setupDriver(){
        System.setProperty("webdriver.gecko.driver","C:/Users/kLc/Desktop/demo-web-automation/driver/geckodriver.exe");
        driver = new FirefoxDriver();
        String url = "http://www.gittigidiyor.com/";
        driver.get(url);
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
    }
    @Test
    public void TestSearch() throws InterruptedException {

        // Arama çubuğunda 'Bilgisayar' kelimesi aranması
        WebElement searchBox = driver.findElement(By.name("k"));
        searchBox.click();
        searchBox.sendKeys("Bilgisayar");
        driver.findElement(By.xpath(".//*[@id='main-header']/div[3]/div/div/div/div[2]/form/div/div[2]/button")).click();
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);

        /* Arama sonucunda 2. sayfanın açılması ve rastgele bir ürüne tıklanamsı */
        String url = "https://www.gittigidiyor.com/arama/?k=bilgisayar&sf=2";
        driver.get(url);
        driver.findElement(By.xpath("//*[@id='product_id_675470944']")).click();

        /* Açılan ürün sayfasında ürünün sepete eklenmesi*/
        driver.findElement(By.id("add-to-basket")).click();
Thread.sleep(3000);

        /* Sepetteki ürün adetinin artırılması */
         driver.get("https://www.gittigidiyor.com/sepetim");
Thread.sleep(3000);

        /* Sepetteki ürün adetinin artırılması */
        WebElement CheckBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[4]/div/div[2]/select/option[2]"));
        CheckBox.click();

Thread.sleep(3000);
        /* Sepetteki ürünlerin boşaltılması */
        driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div[1]/form/div/div[2]/div[2]/div/div/div[6]/div[2]/div[2]/div[1]/div[3]/div/div[2]/div/a")).click();

Thread.sleep(5000);
    }
    @After
    public void quitDriver(){
        driver.manage().timeouts().implicitlyWait(45, TimeUnit.SECONDS);
        driver.quit();
    }
}
