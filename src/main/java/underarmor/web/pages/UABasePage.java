package underarmor.web.pages;

import com.microsoft.playwright.Page;

public abstract class UABasePage {

    protected Page page;

    public UABasePage(Page page) {
        this.page = page;
    }

}
