package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apashchenko on 18.06.2017.
 */
public class TutorialPage {

    public static LoginPage skip() {
        getSkipButton().click();
        return new LoginPage();
    }

    public static SelenideElement getSkipButton() {
        return $(By.id("com.revolut.revolut.test:id/header_next"));
    }

    public static SelenideElement getContinueButton() {
        return $(By.id("com.revolut.revolut.test:id/next_button"));
    }

    public static SelenideElement getImageScreen() {
        return $(By.id("com.revolut.revolut.test:id/header_next"));
    }

    public static SelenideElement getTitleScreen() {
        return $(By.id("com.revolut.revolut.test:id/tutorial_title"));
    }

    public static SelenideElement getSubtitleScreen() {
        return $(By.id("com.revolut.revolut.test:id/tutorial_subtitle"));
    }

    /*First Screen*/
    public static String titleTextScreen1() {
        return "Spend without fees";
    }

    public static String subtitleTextScreen1() {
        return "When using the RevolutCard, you will get the real exchange rate and spending is always free.";
    }


    /*Second Screen*/
    public static String titleTextScreen2() {
        return "Track your expenses";
    }

    public static String subtitleTextScreen2() {
        return "We'll categorise your purchases to show you exactly how much you're spending, on what, and where!";
    }


    /*Third Screen*/
    public static String titleTextScreen3() {
        return "Exchange currencies";
    }

    public static String subtitleTextScreen3() {
        return "Exchange between currencies instantly in the app and lock in a great rate.";
    }

    /*Fourth Screen*/
    public static String titleTextScreen4() {
        return "Control your card security";
    }

    public static String subtitleTextScreen4() {
        return "You can disabled ATM transactions, contactless payments and so much more!";
    }

    /*Fifth Screen*/
    public static String titleTextScreen5() {
        return "Transfer money globally";
    }

    public static String subtitleTextScreen5() {
        return "Send money abroad for free with Revolut. Transfer money to any bank, business or friend at the" +
                " real exchange rate.";
    }

    public static void doCheckTutorialScreen(String title, String subtitle){
        TutorialPage.getImageScreen().exists();
        TutorialPage.getTitleScreen().shouldHave(text(title));
        TutorialPage.getSubtitleScreen().shouldHave(text(subtitle));
        TutorialPage.getContinueButton().click();
    }

    public static void doCheckAllTutorial(){
        TutorialPage.doCheckTutorialScreen(TutorialPage.titleTextScreen1(), TutorialPage.subtitleTextScreen1());
        TutorialPage.doCheckTutorialScreen(TutorialPage.titleTextScreen2(), TutorialPage.subtitleTextScreen2());
        TutorialPage.doCheckTutorialScreen(TutorialPage.titleTextScreen3(), TutorialPage.subtitleTextScreen3());
        TutorialPage.doCheckTutorialScreen(TutorialPage.titleTextScreen4(), TutorialPage.subtitleTextScreen4());
        TutorialPage.doCheckTutorialScreen(TutorialPage.titleTextScreen5(), TutorialPage.subtitleTextScreen5());
    }

}
