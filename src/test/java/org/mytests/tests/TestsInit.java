package org.mytests.tests;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mytests.uiobjects.example.site.SiteJdi;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.logger.LogLevels.STEP;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static com.epam.jdi.light.ui.html.PageFactory.initElements;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class TestsInit {
    @BeforeAll
    public static void setUp() {
        logger.setLogLevel(STEP);
        initElements(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
    }

    @AfterAll
    public static void teardown() {
        killAllSeleniumDrivers();
    }
}
