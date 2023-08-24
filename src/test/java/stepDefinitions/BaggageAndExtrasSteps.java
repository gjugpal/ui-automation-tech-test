package stepDefinitions;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.BaggageAndExtrasPage;

public class BaggageAndExtrasSteps {

    private BaggageAndExtrasPage baggageAndExtrasPage;
    public BaggageAndExtrasSteps() {
        baggageAndExtrasPage = new BaggageAndExtrasPage();
    }

    @Then("I should get the option to add a checked bag")
    public void assertCheckedBagOptionIsAvailable() {
        Assert.assertTrue(baggageAndExtrasPage.isCheckedBagAddOnOptionDisplayed());
    }

    @And(("I add a checked bag"))
    public void addCheckedBag() {
        baggageAndExtrasPage.addCheckedBag();
        baggageAndExtrasPage.clickNext();
    }
 }
