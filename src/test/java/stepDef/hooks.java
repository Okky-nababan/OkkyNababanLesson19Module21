package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;

import static utilties.utility.getDriver;
import static utilties.utility.quitDriver;

public class hooks {
    @Before
    public void beforeTest(){
        getDriver();
    }

    @After
    public static void afterTest(){
        quitDriver();
    }
}
