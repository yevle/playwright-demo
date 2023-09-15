package underarmor.web.pages;

import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import underarmor.web.pages.components.MainMenu;

public class HomePage extends UABasePage {

    private Locator loginLink = page.locator("button[class='HeaderUtility_header-account-link__v8ydu']");

    private Locator emailField = page.locator("#email-required");

    private Locator passwordFeild = page.locator("#password-required");

    private Locator loginBtn = page.locator(".btn-primary[type]");

    private Locator myAccountBtn = page.locator("#my-account");

    private Locator cookiesModal = page.locator("#truste-consent-track");

    private Locator cookiesAcceptBtn = page.locator("#truste-consent-button");

    private MainMenu mainMenu;

    public HomePage(Page page) {
        super(page);
    }

    public void logIn(String email, String password) {
        loginLink.click();
        emailField.fill(email);
        passwordFeild.fill(password);
        loginBtn.click();
        page.waitForCondition(() -> !emailField.isVisible());
    }

    public boolean isLoggedIn() {
        return myAccountBtn.textContent().toLowerCase().contains("my account");
    }

    public HomePage acceptCookies() {
        if (cookiesModal.isVisible()) cookiesAcceptBtn.click();
        return new HomePage(page);
    }

    public MainMenu getMainMenu() {
        return mainMenu = new MainMenu(page);
    }

}
