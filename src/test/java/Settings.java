import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import pizza_card_page.PizzaCardPage;
import pizza_catalog_page.PizzaCatalogPage;

public class Settings {
    private final static String URL_CONNECTION = "https://pzz.by/";
    PizzaCatalogPage pizzaCatalogPage;
    PizzaCardPage pizzaCardPage;
    private WebDriver driver;

    @Before
    public void openConnection() {
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(URL_CONNECTION);
        pizzaCatalogPage = new PizzaCatalogPage(driver);
        pizzaCardPage = new PizzaCardPage(driver);
    }

    @After
    public void closeConnection() {
        driver.quit();
    }
}