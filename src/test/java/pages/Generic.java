package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class Generic {

    private WebDriver driver;
    private By acceptCookiesBtn = By.id("onetrust-accept-btn-handler");
    public Generic() {
        this.driver = BrowserManager.getBrowser();
    }

    public void acceptCookies() {
        try {
            waitForElementToBeDisplayed(acceptCookiesBtn,Duration.ofSeconds(3));
            driver.findElement(acceptCookiesBtn).click();
        } catch (NoSuchElementException nse) {

        }
    }

    public void waitForElementToBeDisplayed(By locator, Duration time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.visibilityOfElementLocated(locator));
    }

    public void waitForPageTitleToContain(String title, Duration time) {
        new WebDriverWait(driver, time).until(ExpectedConditions.titleContains(title));
    }
}
