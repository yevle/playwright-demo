package org.example;


import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

import java.nio.file.Paths;

public class App {
    public static void main(String[] args) {
        try (Playwright playwright = Playwright.create()) {
//            Browser browser = playwright.firefox().launch();
            Browser browser = playwright.chromium().launch(new BrowserType.LaunchOptions().setHeadless(false).setSlowMo(500));
            Page page = browser.newPage();
            page.navigate("https://www.underarmour.com");
            page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/example.png")));
            System.out.println(page.title());
        }
    }
}
