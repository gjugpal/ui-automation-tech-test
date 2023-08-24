package stepDefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import pages.SearchFlightPage;


public class SearchFlightSteps {

    private SearchFlightPage searchFlight;
    public SearchFlightSteps() {
        searchFlight = new SearchFlightPage();
    }

    @Given("I want to fly from {word}")
    public void setWhereFrom(String airportCode) {
        searchFlight.selectWhereFromField();
        searchFlight.deleteSelectedAirport();
        searchFlight.enterAirport(airportCode);
        searchFlight.selectAirportTickBox(airportCode);
    }

    @Given("I want to fly to {word}")
    public void setWhereTo(String airportCode) {
        searchFlight.selectWhereToField();
        searchFlight.deleteSelectedAirport();
        searchFlight.enterAirport(airportCode);
        searchFlight.selectAirportTickBox(airportCode);
    }

    @When("I search for flights")
    public void searchForFlights() {
        searchFlight.clickSearch();
    }

    @Then("I should get the error 'Origin and destination can't be the same'")
    public void assertOriginDestinationErrorIsDisplayed() {
        Assert.assertTrue(searchFlight.isOriginAndDestinationErrorDisplayed());
    }
}
