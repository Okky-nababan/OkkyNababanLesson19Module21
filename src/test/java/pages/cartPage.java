package pages;

import org.openqa.selenium.By;
import utilties.utility;

public class cartPage extends utility {

    By checkout_button = By.id("checkout");

    public void validateCartpage(){
        driver.findElement(checkout_button).isDisplayed();
    }
    public void clickCheckoutButton(){
        driver.findElement(checkout_button).click();
    }
}
