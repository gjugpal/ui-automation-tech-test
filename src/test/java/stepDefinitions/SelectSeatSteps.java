package stepDefinitions;

import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.SelectSeatPage;

public class SelectSeatSteps {

    private SelectSeatPage selectSeatPage;
    public SelectSeatSteps() {
        selectSeatPage = new SelectSeatPage();
    }

    @Then("I should be asked to select my seat")
    public void assertSelectSeatPageIsDisplayed() {
        Assert.assertTrue(selectSeatPage.isSelectSeatPageDisplayed());
    }


}
