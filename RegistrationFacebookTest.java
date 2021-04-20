package clase2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class RegistrationFacebookTest {

    @Test
    public void fullRegistrationTest() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.facebook.com");

        driver.findElement(By.linkText("Crear cuenta nueva")).click();
        Thread.sleep(2000);
        driver.findElement(By.name("firstname")).sendKeys("John");
        driver.findElement(By.name("lastname")).sendKeys("Smith");
        driver.findElement(By.name("reg_email__")).sendKeys("5555555");
        driver.findElement(By.id("password_step_input")).sendKeys("123456789");

        WebElement daysElement = driver.findElement(By.id("day"));
        WebElement monthsElement = driver.findElement(By.id("month"));
        WebElement yearsElement = driver.findElement(By.id("year"));
        Select daySelect = new Select(daysElement);
        Select monthSelect = new Select(monthsElement);
        Select yearSelect = new Select(yearsElement);

        daySelect.selectByIndex(26);
        monthSelect.selectByVisibleText("jun");
        yearSelect.selectByValue("1980");

        List<WebElement> listaSexos = driver.findElements(By.name("sex"));
        Assert.assertEquals(listaSexos.size(),3);

        WebElement sexoMasc = listaSexos.get(0);
        sexoMasc.click();

        Thread.sleep(5000);
        driver.close();
    }
}
