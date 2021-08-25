package org.mytests.uiobjects.example.site;

import com.epam.jdi.light.elements.common.UIElement;
import com.epam.jdi.light.elements.complex.JList;
import com.epam.jdi.light.elements.complex.Menu;
import com.epam.jdi.light.elements.composite.Form;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.Css;
import com.epam.jdi.light.elements.pageobjects.annotations.locators.UI;
import com.epam.jdi.light.ui.html.elements.common.Button;
import com.epam.jdi.light.ui.html.elements.common.TextField;
import org.mytests.uiobjects.example.entities.User;
import org.mytests.uiobjects.example.site.custom.MenuItem;
import org.mytests.uiobjects.example.site.pages.*;
import org.openqa.selenium.WebElement;

//@JSite("https://jdi-testing.github.io/jdi-light/")
public class SiteJdi {
    public static HomePage homePage;
    public static JDIPerformancePage performancePage;
    public static ContactFormPage contactFormPage;
    public static ContactsPage contactsPage;
    public static DatesPage datesPage;
    public static Html5Page html5Page;
    public static UsersPage usersPage;
    @Css("#login-form")
    public static Form<User> loginForm = new LoginForm();

    @Css(".profile-photo [ui=label]")
    public static UIElement userName;
    @Css(".fa-sign-out")
    public static WebElement logout;
    @Css("img#user-icon")
    public static UIElement userIcon;
    @UI(".sidebar-menu span")
    public static Menu leftMenu;
    @UI(".sidebar-menu li")
    public static JList<MenuItem> menu;

    // temporary solution to make tests working
    public static class LoginForm extends Form<User> {
        @UI("#name")
        TextField name;
        @UI("#password")
        TextField password;
        @UI("#login-button")
        Button loginButton;

        @Override
        public void submit(User entity) {
            name.setValue(entity.name);
            password.setValue(entity.password);
            loginButton.click();
        }
    }
}
