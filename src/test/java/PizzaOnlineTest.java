import org.junit.Assert;
import org.junit.Test;

public class PizzaOnlineTest extends Settings {
    @Test
    public void pizzaTest() {
        pizzaCatalogPage.openPizzasCatalog();
        pizzaCatalogPage.addPizzaFourSeasonToCart(pizzaCatalogPage.findPizzaFourSeasons());
        pizzaCatalogPage.choseDeliveryPickup();
        pizzaCardPage.openCart();
        Assert.assertTrue(pizzaCardPage.isOrderCorrect());
    }

}
