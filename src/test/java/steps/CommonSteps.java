package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import utils.Utilities;

public class CommonSteps extends Utilities {

    @Before
    public void start(){initDriver();}

    @After
    public void kill(){teardown();}

    @Given("I navigate to {}")
    public void navigate(String url){driver.get("https://"+url);}

    @Then("I wait for {} seconds")
    public void waiting(double duration){
        pause(duration);}
}
