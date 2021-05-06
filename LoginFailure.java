package clase4;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginFailure {

    WebDriver driver;
    public static final String SALEFORCE_URL = "https://login.salesforce.com/?locale=eu";

    @BeforeMethod
    public void setup(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        driver = new ChromeDriver();
        driver.get(SALEFORCE_URL);
    }

    @Test (priority = 3)
    public void loginFailureTest(){

        WebElement img = driver.findElement(By.xpath("//*[contains(@alt,'Salesforce')]"));
        Assert.assertNotNull(img);
        driver.findElement(By.xpath("//*[contains(@name,'username')]")).sendKeys("test@test.com");
        driver.findElement(By.xpath("//*[contains(@name,'pw')]")).sendKeys("123466");
        driver.findElement(By.xpath("//*[contains(@name,'Login')]")).click();

        WebElement elementError = driver.findElement(By.id("error"));
        System.out.println(elementError.getText());

        Assert.assertEquals(elementError.getText(),"Your access to salesforce.com has been disabled by your system administrator. Please contact your Administrator for more information.");

    }

    @AfterMethod
    public void closeDriver() throws InterruptedException {
        Thread.sleep(5000);
        driver.close();
    }
}
