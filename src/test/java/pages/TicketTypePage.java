package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class TicketTypePage {

    private WebDriver driver;
    private By flexibleTicketOption = By.cssSelector("div[data-testid=ticket_type_radio_flexible]");
    private By standardTicketOption = By.cssSelector("div[data-testid=ticket_type_radio_standard]");
    private By nextBtn = By.cssSelector("div.css-b07tw6 > button");

    public TicketTypePage() {
        driver = BrowserManager.getBrowser();
    }

    public void selectFlexibleTicket() {
        driver.findElement(flexibleTicketOption).click();
    }

    public void selectStandardTicket() {
        driver.findElement(standardTicketOption).click();
    }

    public void clickNext() {
        driver.findElement(nextBtn).click();
    }

    public boolean isDisplayed() {
        return driver.findElement(By.cssSelector("head > title")).getText().equalsIgnoreCase("Ticket Type");
    }
}
