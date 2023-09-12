package underarmor.web;

import com.microsoft.playwright.*;
import org.testng.annotations.*;


public class BaseTest {
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;

    @BeforeTest
    void launchBrowser() {
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(100));
    }

    @AfterTest
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

}
