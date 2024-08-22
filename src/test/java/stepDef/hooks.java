package stepDef;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.Scenario;

import java.util.Objects;

import static helper.utility.getDriver;
import static helper.utility.quitDriver;

public class hooks {

    static String tagsRunning = null;

    @Before
    public void beforeTest(Scenario scenario){

        String[] tags = scenario.getSourceTagNames().toArray(new String[0]);
        tagsRunning = tags[0];
        if (Objects.equals(tagsRunning, "@WEB")) {
            getDriver();
        }
    }

    @After
    public static void afterTest(){
        if (Objects.equals(tagsRunning, "@WEB")) {
            quitDriver();
        }
    }
}
