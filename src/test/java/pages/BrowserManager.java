package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class BrowserManager {

    private static WebDriver webDriver;

    public static synchronized WebDriver getBrowser(){
        return webDriver;
    }

    public static void initialize() {
        ChromeOptions options = new ChromeOptions();
        options.addArguments("start-maximized");
        options.addArguments("--ignore-ssl-errors=yes");
        options.addArguments("--ignore-certificate-errors");
        options.addArguments("--allow-running-insecure-content");
        webDriver = new ChromeDriver(options);
        webDriver.get("https://www.booking.com/flights");
    }

}
