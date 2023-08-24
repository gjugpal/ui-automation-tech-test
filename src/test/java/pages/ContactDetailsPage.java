package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;

import java.time.Duration;

public class ContactDetailsPage {

    private WebDriver driver;
    private By emailField = By.cssSelector("input[name='booker.email']");
    private By mobileNumberField = By.cssSelector("input[name='number']");
    private By firstNameField = By.cssSelector("input[name='passengers.0.firstName'");
    private By lastNameField = By.cssSelector("input[name='passengers.0.lastName'");
    private By genderSelect = By.cssSelector("select[name='passengers.0.gender']");
    private By dayField = By.cssSelector("input[name='passengers.0.birthDate'][placeholder='DD']");
    private By monthSelector = By.cssSelector("select[name='passengers.0.birthDate']");
    private By yearField = By.cssSelector("input[name='passengers.0.birthDate'][placeholder='YYYY']");
    private By nextBtn = By.cssSelector("div.css-b07tw6 > button");
    private By contactDetailsDiv = By.cssSelector("div[data-testid=checkout_form_card_contact_details]");

    public ContactDetailsPage() {
        this.driver = BrowserManager.getBrowser();
        new Generic().waitForPageTitleToContain("Who's flying", Duration.ofSeconds(30));
        new Generic().waitForElementToBeDisplayed(contactDetailsDiv, Duration.ofSeconds(30));
    }

    public void enterEmailAddress(String email) {
        driver.findElement(emailField).sendKeys(email);
    }

    public void enterMobileNumber(String mobile) {
        driver.findElement(mobileNumberField).sendKeys(mobile);
    }

    public void enterFirstName(String fname) {
        driver.findElement(firstNameField).sendKeys(fname);
    }

    public void enterLastName(String lname){
        driver.findElement(lastNameField).sendKeys(lname);
    }

    public void selectGender(String gender) {
        Select genderSelector = new Select(driver.findElement(genderSelect));
        genderSelector.selectByValue(gender);
    }

    public void enterDob(String day, String month, String year) {
        driver.findElement(dayField).sendKeys(day);

        Select ms = new Select(driver.findElement(monthSelector));
        ms.selectByVisibleText(month);

        driver.findElement(yearField).sendKeys(year);
    }

    public boolean isDobFieldDisplayed() {
        return driver.findElement(dayField).isDisplayed();
    }

    public void clickNextBtn(){
        driver.findElement(nextBtn).click();
    }
}
