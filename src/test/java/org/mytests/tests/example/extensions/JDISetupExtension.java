package org.mytests.tests.example.extensions;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.AfterEachCallback;
import org.junit.jupiter.api.extension.BeforeAllCallback;
import org.junit.jupiter.api.extension.BeforeEachCallback;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.mytests.uiobjects.example.site.SiteJdi;

import java.lang.reflect.Method;

import static com.epam.jdi.light.driver.WebDriverUtils.killAllSeleniumDrivers;
import static com.epam.jdi.light.elements.composite.WebPage.openSite;
import static com.epam.jdi.light.settings.WebSettings.TEST_NAME;
import static com.epam.jdi.light.settings.WebSettings.logger;
import static io.qameta.allure.model.Status.FAILED;
import static io.qameta.allure.model.Status.PASSED;
import static org.mytests.uiobjects.example.site.SiteJdi.homePage;

public class JDISetupExtension implements
        BeforeAllCallback, BeforeEachCallback, AfterEachCallback {

    @Override
    public void beforeAll(ExtensionContext extensionContext) {
        extensionContext.getRoot().getStore(ExtensionContext.Namespace.GLOBAL)
                .getOrComputeIfAbsent(DriverKiller.class);
        openSite(SiteJdi.class);
        homePage.open();
        logger.info("Run Tests");
    }

    static class DriverKiller implements ExtensionContext.Store.CloseableResource {
        @Override
        public void close() {
            killAllSeleniumDrivers();
        }
    }

    @Override
    public void beforeEach(ExtensionContext extensionContext) throws Exception {
        Method testMethod = extensionContext.getTestMethod().get();
        if (testMethod.isAnnotationPresent(Test.class)) {
            TEST_NAME.set(testMethod.getName());
            logger.step("== Test '%s' START ==", TEST_NAME.get());
        }
    }

    @Override
    public void afterEach(ExtensionContext extensionContext) throws Exception {
        Boolean isExceptionPresent = extensionContext.getExecutionException().isPresent();
        String result = isExceptionPresent ? FAILED.value() : PASSED.value();
        logger.step("=== Test '%s' %s ===", TEST_NAME.get(), result);
    }
}
