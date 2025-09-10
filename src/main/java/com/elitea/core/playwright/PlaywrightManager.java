package com.elitea.core.playwright;

import com.elitea.core.config.Config;
import com.elitea.core.config.ConfigLoader;
import com.microsoft.playwright.*;

public final class PlaywrightManager {
    private static final ThreadLocal<Playwright> THREAD_PLAYWRIGHT = new ThreadLocal<>();
    private static final ThreadLocal<Browser> THREAD_BROWSER = new ThreadLocal<>();
    private static final ThreadLocal<BrowserContext> THREAD_CONTEXT = new ThreadLocal<>();
    private static final ThreadLocal<Page> THREAD_PAGE = new ThreadLocal<>();

    private PlaywrightManager() { }

    public static Page getPage() {
        Page page = THREAD_PAGE.get();
        if (page == null) {
            initialize();
            page = THREAD_PAGE.get();
        }
        return page;
    }

    public static void initialize() {
        if (THREAD_PLAYWRIGHT.get() != null) {
            return;
        }
        Config cfg = ConfigLoader.load();
        Playwright pw = Playwright.create();
        THREAD_PLAYWRIGHT.set(pw);

        BrowserType browserType;
        switch (cfg.getBrowser().toLowerCase()) {
            case "firefox":
                browserType = pw.firefox();
                break;
            case "webkit":
                browserType = pw.webkit();
                break;
            case "chromium":
            default:
                browserType = pw.chromium();
        }

        Browser browser = browserType.launch(new BrowserType.LaunchOptions().setHeadless(cfg.isHeadless()));
        THREAD_BROWSER.set(browser);

        Browser.NewContextOptions contextOptions = new Browser.NewContextOptions();
        BrowserContext context = browser.newContext(contextOptions);
        THREAD_CONTEXT.set(context);

        Page page = context.newPage();
        page.setDefaultTimeout(cfg.getTimeoutMs());
        THREAD_PAGE.set(page);
    }

    public static void cleanup() {
        Page page = THREAD_PAGE.get();
        if (page != null) {
            page.close();
            THREAD_PAGE.remove();
        }
        BrowserContext context = THREAD_CONTEXT.get();
        if (context != null) {
            context.close();
            THREAD_CONTEXT.remove();
        }
        Browser browser = THREAD_BROWSER.get();
        if (browser != null) {
            browser.close();
            THREAD_BROWSER.remove();
        }
        Playwright pw = THREAD_PLAYWRIGHT.get();
        if (pw != null) {
            pw.close();
            THREAD_PLAYWRIGHT.remove();
        }
    }
}


