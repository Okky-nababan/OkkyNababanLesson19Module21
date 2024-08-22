package stepDef;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;

public class cartStep {

    cartPage CartPage;
    public cartStep(){
        this.CartPage = new cartPage();
    }

    @Then("user will direct to cart page")
    public void userWillDirectToCartPage() {
        CartPage.validateCartpage();
    }

    @When("user click checkout button")
    public void userClickCheckoutButton() {
        CartPage.clickCheckoutButton();
    }
}
