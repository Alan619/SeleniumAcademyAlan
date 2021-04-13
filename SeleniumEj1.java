import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.Test;

import java.util.List;

public class SeleniumEj1 {

    @Test
    public void ejercicioSelenium1(){
        String URL_NETFLIX= "https://www.netflix.com";
        System.setProperty("webdriver.chrome.driver", "drivers/chromedriver.exe");
        WebDriver driver = new ChromeDriver();
        driver.get(URL_NETFLIX);

        //Elementos H1
        List<WebElement> listah1;
        listah1 = driver.findElements(By.tagName("h1"));
        System.out.println("------->Inicio Elemantos H1 <-------");
        for (WebElement elemtnoH1: listah1) {
            System.out.println(elemtnoH1.getText());
        }
        System.out.println("------->Fin Elemantos H1 <-------");

        //Elementos H2
        List<WebElement> listah2;
        listah2 = driver.findElements(By.tagName("h2"));
        System.out.println("------->Inicio Elemantos H2 <-------");
        for (WebElement elemtnoH2: listah2) {
            System.out.println(elemtnoH2.getText());
        }
        System.out.println("------->Fin Elemantos H2 <-------");

        //Refrescar la página
        driver.navigate().refresh();

        //Texto de los botones que se encuentran en la página
        List<WebElement> listaBotones = driver.findElements(By.tagName("button"));
        System.out.println("------->Inicio Textos Botones <-------");
        for (WebElement boton : listaBotones) {
            System.out.println("Button: "+ boton.getText());
        }
        System.out.println("------->Fin Textos Botones <-------");

        //Cantidad de elementos div que contiene el sitio
        List<WebElement> listadiv = driver.findElements(By.tagName("div"));
        System.out.println("La cantidad de elementos div es: " + listadiv.size());

        //Obtener y mostrar el título de la página
        System.out.println("El titulo de la pagina es: " + driver.getTitle());

        //Elementos de tipo link
        List<WebElement> listaLinks = driver.findElements(By.tagName("link"));
        System.out.println("Cantidad de elementos tipo Links del sitio: " + listaLinks.size());

        driver.close();
    }

}
