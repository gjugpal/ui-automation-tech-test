package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class BaggageAndExtrasPage {

    private By addCheckedBag = By.cssSelector("label[data-testid=ancillary_product_baggage_per_person_CHECKED_IN_1]");
    private By nextBtn = By.cssSelector("div.css-b07tw6 > button");
    private By baggageExtrasDiv = By.cssSelector("div.css-16yo5ny > div > div.css-k456he");

    private WebDriver driver;
    public BaggageAndExtrasPage() {
        driver = BrowserManager.getBrowser();
        new Generic().waitForPageTitleToContain("Baggage and extras", Duration.ofSeconds(6));
        new Generic().waitForElementToBeDisplayed(baggageExtrasDiv, Duration.ofSeconds(15));
    }

    public boolean isCheckedBagAddOnOptionDisplayed(){
        return driver.findElement(addCheckedBag).isDisplayed();
    }

    public void addCheckedBag() {
        new Generic().waitForElementToBeDisplayed(addCheckedBag,Duration.ofSeconds(15));
        driver.findElement(addCheckedBag).click();
    }

    public void clickNext() {
        driver.findElement(nextBtn).click();
    }
}
