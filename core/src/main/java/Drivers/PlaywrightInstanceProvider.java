package Drivers;

import com.microsoft.playwright.Browser;
import com.microsoft.playwright.BrowserType;
import com.microsoft.playwright.Page;
import com.microsoft.playwright.Playwright;

public class PlaywrightInstanceProvider {

    private static final ThreadLocal<PlaywrightInstanceProvider> INSTANCE = ThreadLocal.withInitial(PlaywrightInstanceProvider::new);

    private Playwright playwright;
    private Browser browser;
    private Page page;

    public static PlaywrightInstanceProvider getInstance() {
        return INSTANCE.get();
    }

    public Page preparePlaywrightInstance() {
        if (page != null) {
            return page;
        }
        playwright = Playwright.create();
        browser = playwright.chromium().launch(
                new BrowserType.LaunchOptions().setHeadless(false));
        page = browser.newPage();
        return page;
    }

    public Page getPage() {
        if (page == null) {
            throw new IllegalStateException("Playwright instance not initialized. Call preparePlaywrightInstance() first.");
        }
        return page;
    }

    public void close() {
        if (browser != null) {
            browser.close();
            browser = null;
        }
        if (playwright != null) {
            playwright.close();
            playwright = null;
        }
        page = null;
    }

    public static void clear() {
        PlaywrightInstanceProvider provider = INSTANCE.get();
        if (provider != null) {
            provider.close();
        }
        INSTANCE.remove();
    }
}
