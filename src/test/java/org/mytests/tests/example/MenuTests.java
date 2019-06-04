package org.mytests.tests.example;

import org.junit.jupiter.api.Test;
import org.mytests.tests.TestsInit;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mytests.tests.states.States.*;
import static org.mytests.uiobjects.example.entities.LeftMenuData.*;
import static org.mytests.uiobjects.example.site.SiteJdi.*;

class MenuTests extends TestsInit {

    @Test
    void menuTest() {
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
        leftMenu.select(Service, Dates);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
    @Test
    void customMenuTest() {
        shouldBeLoggedIn();
        homePage.shouldBeOpened();
        menu.select(ContactForm);
        assertEquals(menu.selected(), ContactForm.value);
        menu.select(Service, Dates);
        menu.is().selected(Dates.value);
        datesPage.checkOpened();
        leftMenu.select(ElementsPacks, HTML5);
        html5Page.checkOpened();
    }
}
