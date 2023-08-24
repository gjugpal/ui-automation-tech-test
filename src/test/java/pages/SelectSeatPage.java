package pages;

import org.openqa.selenium.WebDriver;

import java.time.Duration;

public class SelectSeatPage {

    private WebDriver driver;

    public SelectSeatPage() {

        driver = BrowserManager.getBrowser();
        new Generic().waitForPageTitleToContain("Select your seat", Duration.ofSeconds(6));
    }

    public boolean isSelectSeatPageDisplayed() {
        return driver.getTitle().contains("Select your seat");
    }


}
