package org.mytests.tests.example;

import com.epam.jdi.light.driver.WebDriverFactory;
import org.junit.AfterClass;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.mytests.uiobjects.example.site.SiteJdi;

import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.logger;

public class BaseTest {

    @BeforeAll()
    static public void setUp() {
        logger.info("Running test");
        openSite(SiteJdi.class);
    }

    @AfterAll()
    static public void tearDown() {
        logger.info("Completing test");
    }

    @AfterClass
    static public void shutDown(){
        WebDriverFactory.quit();
    }

}
