package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class SearchFlightPage {

    private WebDriver driver;
    private By whereFromField = By.cssSelector("div.css-lgj0h8 > div > button:nth-child(1)");
    private By enterAirportField = By.cssSelector("input[class='css-1ejj2j9']");
    private By whereToField = By.cssSelector("div.css-lgj0h8 > div > button:nth-child(3)");
    private By searchBtn = By.cssSelector("button[data-ui-name='button_search_submit']");
    private By selectedAirportOption = By.cssSelector("span.Icon-module__root___tiYlo.css-lyj9ft.Icon-module__root--size-small___UwcQH");

    public SearchFlightPage() {
        this.driver = BrowserManager.getBrowser();
        new Generic().acceptCookies();
    }

    public void selectWhereFromField() {
        driver.findElement(whereFromField).click();
        new Generic().waitForElementToBeDisplayed(enterAirportField, Duration.ofSeconds(6));
    }

    public void enterAirport(String airport) {
        driver.findElement(enterAirportField).sendKeys(airport);
    }

    public void selectWhereToField() {
        driver.findElement(whereToField).click();
        new Generic().waitForElementToBeDisplayed(enterAirportField, Duration.ofSeconds(6));
    }
    public void selectAirportTickBox(String airport) {
        new WebDriverWait(driver, Duration.ofSeconds(4)).until(ExpectedConditions.visibilityOfElementLocated(By.id("listbox")));
        driver.findElement(By.cssSelector("input[name=AIRPORT" + airport + "]")).click();
    }

    public void clickSearch() {
        driver.findElement(searchBtn).click();

    }

    public void deleteSelectedAirport() {
        try {
            driver.findElement(selectedAirportOption).click();
        } catch (NoSuchElementException nse) {
            // nothing to do
        }
    }

    public boolean isOriginAndDestinationErrorDisplayed() {
        return driver.findElement(By.cssSelector("div[class=css-1m5itar]")).isDisplayed();
    }
}
