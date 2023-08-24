package stepDefinitions;

import io.cucumber.java.en.And;
import pages.TicketTypePage;

public class TicketTypeSteps {

    private TicketTypePage ticketTypePage;

    public void TicketTypeSteps() {
        ticketTypePage = new TicketTypePage();
    }

    @And("I select a {word} ticket")
    public void selectTicketType(String ticketType) {
        if(ticketType == "flexible") {
            ticketTypePage.selectFlexibleTicket();
        }else {
            ticketTypePage.selectStandardTicket();
        }
    }
}
