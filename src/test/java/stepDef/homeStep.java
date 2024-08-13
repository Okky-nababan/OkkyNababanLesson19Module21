package stepDef;

import io.cucumber.java.en.*;
import pages.homePage;

public class homeStep  {

    homePage HomePage;
    public homeStep(){
        this.HomePage = new homePage();
    }

    @Then("user will direct to homepage")
    public void userWillDirectToHomepage() {
        HomePage.validateHomepage();
    }

    @When("user click add to cart")
    public void userClickAddToCart() {
        HomePage.clickAddToCartButton();
    }

    @And("user click cart icon")
    public void userClickCartIcon() {
        HomePage.clickCartIcon();
    }

    @Then("number of items appear on cart icon {string}")
    public void numberOfItemsAppearOnCartIcon(String item) {
        HomePage.validateNumberOfItems(item);
    }

    @And("user remove item from cart")
    public void userRemoveItemFromCart() {
        HomePage.clickRemoveButton();
    }
}
