package underarmor.web.pages.components;

import com.microsoft.playwright.ElementHandle;
import com.microsoft.playwright.Locator;
import com.microsoft.playwright.Page;
import underarmor.web.pages.UABasePage;

import java.util.List;
import java.util.stream.Collectors;

public class MainMenu extends UABasePage {

    private List<ElementHandle> menuItems = page.locator("#menu > li > a").elementHandles();
    private List<ElementHandle> menuItemImages = page.locator("#menu img.b-navigation_banner-image").elementHandles();

    public MainMenu(Page page) {
        super(page);
    }

    public boolean isHoverOverMenuWorks(String elementToFilter) {
        List<ElementHandle> filteredMenuItems = menuItems.stream()
                .filter(i -> !i.textContent().contains(elementToFilter))
                .collect(Collectors.toList());
        return filteredMenuItems.stream().allMatch(i -> {
            i.hover();
            return menuItemImages.get(filteredMenuItems.indexOf(i)).isVisible();
        });
    }

}
