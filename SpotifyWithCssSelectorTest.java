package clase3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.Test;

public class SpotifyWithCssSelectorTest {

    private WebDriver getSpotifyDriver(){
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get("https://www.spotify.com/uy/signup/\n");
        return driver;
    }

    @Test
    public void spotifyByPlaceHolderTest() throws InterruptedException {
        WebDriver driver = getSpotifyDriver();

        driver.findElement(By.cssSelector("input[placeholder='Introduce tu correo electrónico.']")).sendKeys("test@email.com");
        driver.findElement(By.cssSelector("input[placeholder='Vuelve a introducir tu correo electrónico.']")).sendKeys("test@email.com");
        driver.findElement(By.cssSelector("input[placeholder='Crea una contraseña.']")).sendKeys("Qwer1234");
        driver.findElement(By.cssSelector("input[placeholder='Introduce un nombre de perfil.']")).sendKeys("AlanSmith");
        driver.findElement(By.cssSelector("input[placeholder='DD']")).sendKeys("20");
        WebElement mes = driver.findElement(By.xpath("//select[@name='month']"));
        Select selectMes = new Select(mes);
        selectMes.selectByVisibleText("Enero");
        driver.findElement(By.xpath("//input[@placeholder='AAAA']")).sendKeys("1994");

        driver.findElement(By.cssSelector("label[for='gender_option_male']")).click();
        driver.findElement(By.cssSelector("label[for='marketing-opt-checkbox']")).click();

        Thread.sleep(5000);
        driver.close();
    }
}
