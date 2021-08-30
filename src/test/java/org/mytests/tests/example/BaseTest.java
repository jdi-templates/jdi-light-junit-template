package org.mytests.tests.example;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.mytests.uiobjects.example.site.SiteJdi;

import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class BaseTest {

    @BeforeEach()
    protected void setUp() {
        logger.info("Running test");
        openSite(SiteJdi.class);
    }

    @AfterEach()
    protected void tearDown() {
        logger.info("Completing test");
        WebDriverFactory.quit();
    }

}
