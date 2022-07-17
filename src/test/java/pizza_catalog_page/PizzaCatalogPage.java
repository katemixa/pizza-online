package pizza_catalog_page;

import org.apache.commons.codec.binary.StringUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;

public class PizzaCatalogPage {
    private final WebDriver driver;

    By pizzasCatalogLocator = By.linkText("пиццы");
    By pizzasElementsLocator = By.cssSelector("li.goods__list__li.pizzas");
    By deliveryBlockLocator = By.id("addressModal");

    public PizzaCatalogPage(WebDriver driver) {
        this.driver = driver;
    }

    public void openPizzasCatalog() {
        driver.findElement(pizzasCatalogLocator).click();
    }

    public WebElement findPizzaFourSeasons() {
        List<WebElement> pizzasElements = driver.findElements(pizzasElementsLocator);
        for (WebElement pizzaElement : pizzasElements) {
            if (pizzaElement.findElement(By.cssSelector("h3.goods__list__title")).getText().equals("Четыре сезона")) {
                return pizzaElement;
            }
        }
        return null;
    }

    public void addPizzaFourSeasonToCart(WebElement pizza) {
        JavascriptExecutor jse = (JavascriptExecutor) driver;
        jse.executeScript("window.scrollBy(0,3345)", "");
        pizza.findElements(By.xpath("//div[@data-size='big']"));
        pizza.findElement(By.tagName("button")).click();
    }

    public void choseDeliveryPickup() {
        WebElement deliveriesItem = driver.findElement(deliveryBlockLocator);
        WebElement deliveries = deliveriesItem.findElement(By.cssSelector("ul.nav.nav-pills"));
        deliveries.findElement(By.linkText("самовывоз")).click();
        WebElement addresses = driver.findElement(By.cssSelector("div.buttons"));
        addresses.findElement(By.id("bypickup-2")).click();
    }

}
