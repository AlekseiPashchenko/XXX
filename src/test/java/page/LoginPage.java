package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import java.util.LinkedList;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apashchenko on 18.06.2017.
 */

public class LoginPage {
    public static SelenideElement getSignupTitle() {
        return $(By.id("com.revolut.revolut.test:id/signup_title"));
    }

    public static String signupTitleText() {
        return "Hi, welcome to Revolut!";
    }

    public static SelenideElement getCountryDropdown() {
        return $(By.id("com.revolut.revolut.test:id/uic_edit_country_code"));
    }

    public static SelenideElement getSignupButton() {
        return $(By.id("com.revolut.revolut.test:id/signup_next"));
    }

    public static SelenideElement getPhoneField() {
        return $(By.id("com.revolut.revolut.test:id/uic_edit_phone_number"));
    }

    public static SelenideElement getPasscodeText() {
        return $(By.id("com.revolut.revolut.test:id/main_title"));
    }

    public static void enterPasscodeNumber(int number) {
        $(By.id("com.revolut.revolut.test:id/digit" + number)).click();
    }

    public static void doLogin(int phone, int passcode){
        LoginPage.getSignupTitle().shouldHave(text(LoginPage.signupTitleText()));
        LoginPage.getPhoneField().exists();
        LoginPage.getPhoneField().sendKeys(Integer.toString(phone));
        LoginPage.getSignupButton().click();

        LoginPage.getPasscodeText().exists();
        LoginPage.enterPasscode(passcode);
        LoginPage.getNotNowButton().exists();
        LoginPage.getNotNowButton().click();
    }

    public static void enterPasscode(int passcode) {
        LinkedList<Integer> stack = new LinkedList<Integer>();
        while (passcode > 0) {
            stack.push( passcode % 10 );
            passcode = passcode / 10;
        }

        while (!stack.isEmpty()) {
            $(By.id("com.revolut.revolut.test:id/digit" + stack.pop())).click();
        }
    }

    public static SelenideElement getNotNowButton() {
        return $(By.id("com.revolut.revolut.test:id/uic_header_next"));
    }
}
