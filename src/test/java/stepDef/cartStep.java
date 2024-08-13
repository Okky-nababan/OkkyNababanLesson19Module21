package stepDef;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import pages.cartPage;
import pages.homePage;
import utilties.utility;

import static utilties.utility.driver;

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
