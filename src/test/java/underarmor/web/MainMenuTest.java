package underarmor.web;

import com.microsoft.playwright.Page;
import org.testng.annotations.Test;
import underarmor.web.pages.HomePage;

import java.nio.file.Paths;

import static org.testng.Assert.assertTrue;

public class MainMenuTest extends BaseTest {

    @Test
    void hoverTest() {

        HomePage homePage = new HomePage(page);

        assertTrue(homePage.getMainMenu().isHoverOverMenuWorks("Curry"));
        page.screenshot(new Page.ScreenshotOptions().setPath(Paths.get("screenshots/example.png")));

    }

}
