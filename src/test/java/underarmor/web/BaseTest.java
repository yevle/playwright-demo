package underarmor.web;

import com.microsoft.playwright.*;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.testng.annotations.*;

import java.util.Optional;


public class BaseTest {
    private static final Logger LOGGER = LogManager.getLogger(BaseTest.class);
    Playwright playwright;
    Browser browser;
    BrowserContext context;
    Page page;
//    Boolean headless = Optional.ofNullable(System.getProperty("HEADLESS")).map(Boolean::valueOf).orElse(false);
    Boolean headless = Boolean.valueOf(System.getProperty("HEADLESS", "true"));


    @BeforeTest
    void launchBrowser() {
        LOGGER.info("HEADLESS MODE: "+headless);
        playwright = Playwright.create();
        browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(headless).setSlowMo(100));
    }

    @AfterTest
    void closeBrowser() {
        playwright.close();
    }

    @BeforeMethod
    void createContextAndPage() {
        context = browser.newContext();
        page = context.newPage();
        page.navigate("https://www.underarmour.com");
    }

    @AfterMethod
    void closeContext() {
        context.close();
    }

}
