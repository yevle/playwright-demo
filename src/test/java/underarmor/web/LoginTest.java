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

        HomePage homePage = new HomePage(page);
        homePage.acceptCookies().logIn(email,password);

        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/example.png")));
        assertEquals(page.title(), "Under Armour® Official Store | FREE Shipping Available");
        assertTrue(homePage.isLoggedIn());

    }

}
