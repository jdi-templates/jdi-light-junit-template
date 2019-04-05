package org.mytests.tests.example;

import org.junit.jupiter.api.Test;
import org.mytests.tests.TestsInit;

import static org.mytests.tests.preconditions.Preconditions.shouldBeLoggedIn;
import static org.mytests.tests.preconditions.Preconditions.shouldBeLoggedOut;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_CONTACT;
import static org.mytests.uiobjects.example.entities.Defaults.DEFAULT_USER;
import static org.mytests.uiobjects.example.site.SiteJdi.*;
import static org.mytests.uiobjects.example.site.pages.ContactFormPage.contactForm;

public class FormTests extends TestsInit {

    @Test
    public void loginTest() {
        shouldBeLoggedOut();
        userIcon.click();
        loginForm.loginAs(DEFAULT_USER);
        homePage.checkOpened();
    }

    @Test
    public void fillContactFormTest() {
        shouldBeLoggedIn();
        contactFormPage.shouldBeOpened();
        contactForm.submit(DEFAULT_CONTACT);
        contactForm.check(DEFAULT_CONTACT);
    }

    @Test
    public void fillContactsTest() {
        shouldBeLoggedIn();
        contactsPage.shouldBeOpened();
        contactsPage.asForm().submit(DEFAULT_CONTACT);
        contactsPage.asForm().check(DEFAULT_CONTACT);
    }
}
