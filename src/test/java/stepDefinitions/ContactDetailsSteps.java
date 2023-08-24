package stepDefinitions;

import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.And;
import pages.ContactDetailsPage;
import pages.TicketTypePage;

import java.util.List;
import java.util.Map;

public class ContactDetailsSteps {

    private ContactDetailsPage contactDetailsPage;

    public ContactDetailsSteps() {
        contactDetailsPage = new ContactDetailsPage();
    }

    @And("I enter in my contact details")
    public void enterInContactDetails(DataTable dataTable) {

        TicketTypePage ticketTypePage = new TicketTypePage();

        if(ticketTypePage.isDisplayed()) {
            ticketTypePage.selectStandardTicket();
            ticketTypePage.clickNext();
        }

        List<Map<String, String>> rows = dataTable.asMaps(String.class, String.class);
        Map<String,String> data = rows.get(0);

        contactDetailsPage.enterEmailAddress(data.get("email"));
        contactDetailsPage.enterMobileNumber(data.get("mobile"));
        contactDetailsPage.enterFirstName(data.get("firstname"));
        contactDetailsPage.enterLastName(data.get("lastname"));
        contactDetailsPage.selectGender(data.get("gender"));

        if(contactDetailsPage.isDobFieldDisplayed()) {
            String[] dob = data.get("dob").split("-");
            contactDetailsPage.enterDob(dob[0], dob[1], dob[2]);
        }

        contactDetailsPage.clickNextBtn();
    }
}
