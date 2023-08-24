package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.time.Duration;

public class SelectFlightPage {

    private WebDriver driver;
    private By seeBtn = By.cssSelector("div > div > div.css-1lhjur2 > div:nth-child(2) > button > span");
    private By selectBtn = By.cssSelector("div.css-95bx75 > div:nth-child(2) > button > span");
    private By flightDetailsPopup = By.cssSelector("div.css-95bx75");

    public SelectFlightPage() {
        this.driver = BrowserManager.getBrowser();
        new Generic().acceptCookies();
    }

    public void clickSeeFlight(int flightCard) {
        new Generic().waitForElementToBeDisplayed(By.id("flight-card-0"), Duration.ofSeconds(15));
        WebElement flight = driver.findElement(By.id("flight-card-" + flightCard));
        flight.findElement(seeBtn).click();
    }

    public void clickSelectFlight() {
        new Generic().waitForElementToBeDisplayed(flightDetailsPopup, Duration.ofSeconds(6));
        driver.findElement(selectBtn).click(); // select the flight via the popup
    }
}
