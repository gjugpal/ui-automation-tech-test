package stepDefinitions;

import io.cucumber.java.en.And;
import pages.SelectFlightPage;

public class SelectFlightSteps {

    private SelectFlightPage selectFlightPage;
    public SelectFlightSteps() {
        selectFlightPage = new SelectFlightPage();
    }

    @And("I select the (\\d+)(?:st|nd|rd|th) flight$")
    public void selectFlight(int num) {
        selectFlightPage.clickSeeFlight(num);
        selectFlightPage.clickSelectFlight();
    }
}
