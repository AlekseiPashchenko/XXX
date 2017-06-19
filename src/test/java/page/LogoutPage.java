package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apashchenko on 18.06.2017.
 */
public class LogoutPage {
    public static SelenideElement getMoreButton() {
        return $(By.id("com.revolut.revolut.test:id/bottom_bar_more_title"));
    }

    public static SelenideElement getProfileButton() {
        return $(By.id("com.revolut.revolut.test:id/view_profile"));
    }

    public static SelenideElement getLogoutButton() {
        return $(By.id("com.revolut.revolut.test:id/settings_log_out_button"));
    }

    public static SelenideElement getLogoutYesButton() {
        return $(By.id("com.revolut.revolut.test:id/bt_yes"));
    }

    public static void doLogout(){
        LogoutPage.getMoreButton().click();
        LogoutPage.getProfileButton().click();
        LogoutPage.getLogoutButton().click();
        LogoutPage.getLogoutYesButton().click();
    }
}
