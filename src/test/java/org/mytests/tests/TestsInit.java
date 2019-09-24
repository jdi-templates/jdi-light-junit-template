package org.mytests.tests;

import com.epam.jdi.light.ui.html.HtmlSettings;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mytests.uiobjects.example.site.SiteJdi;

import static com.epam.jdi.light.elements.init.PageFactory.initElements;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    private static boolean initialized = false;
    @BeforeAll
    public static void setUp() {
        if (initialized)  return;
        logger.setLogLevel(STEP);
        HtmlSettings.init();
        initElements(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
        initialized = true;
    }

    @AfterAll
    public static void teardown() {
        /*killAllSeleniumDrivers();*/
    }
}
