package pizza_card_page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PizzaCardPage {
    private final WebDriver driver;

    @FindBy(linkText = "корзина")
    WebElement pizzaCard;
    @FindBy(xpath = "//span[contains(text(),'сезона')]")
    WebElement pizzaItemCard;

    public PizzaCardPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void openCart() {
        pizzaCard.click();
    }

    public boolean isOrderCorrect() {
        return pizzaItemCard.isDisplayed();
    }

}
