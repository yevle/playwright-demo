package underarmor.web;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import underarmor.web.pages.HomePage;

import java.nio.file.Paths;

import static org.testng.Assert.assertEquals;
import static org.testng.Assert.assertTrue;

public class LoginTest extends BaseTest {

    private String email = "s.grysh@gmail.com";
    private String password = "Password1!";

    @Test
    void loginTest() {
        page.navigate("https://www.underarmour.com");

        HomePage homePage = new HomePage(page);
        homePage.logIn(email,password);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/example.png")));
        assertEquals(page.title(), "Under Armour® Official Store | FREE Shipping Available");
        assertTrue(homePage.isLoggedIn());

    }

    @Test
    void shouldClickButton() {
        page.navigate("data:text/html,<script>var result;</script><button onclick='result=\"Clicked\"'>Go</button>");
        page.locator("button").click();
        assertEquals("Clicked", page.evaluate("result"));
    }

    @Test
    void shouldCheckTheBox() {
        page.setContent("<input id='checkbox' type='checkbox'></input>");
        page.locator("input").check();
        assertTrue((Boolean) page.evaluate("() => window['checkbox'].checked"));
    }

    @Test
    void shouldSearchWiki() {
        page.navigate("https://www.wikipedia.org/");
        page.locator("input[name=\"search\"]").click();
        page.locator("input[name=\"search\"]").fill("playwright");
        page.locator("input[name=\"search\"]").press("Enter");
        assertEquals("https://en.wikipedia.org/wiki/Playwright", page.url());
    }

}
