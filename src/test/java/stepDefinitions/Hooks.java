package stepDefinitions;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import pages.BrowserManager;

public class Hooks {

    @After
    public void tearDown() {
        BrowserManager.getBrowser().close();
    }

    @Before
    public void setup() {
        BrowserManager.initialize();
    }
}
