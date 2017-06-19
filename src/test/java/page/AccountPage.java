package page;

import com.codeborne.selenide.SelenideElement;
import org.openqa.selenium.By;
import static com.codeborne.selenide.Selenide.$;

/**
 * Created by apashchenko on 18.06.2017.
 */
public class AccountPage {

    public static SelenideElement getMainMenuButton() {
        return $(By.id("com.revolut.revolut.test:id/button_transfer"));
    }

    public static SelenideElement getBankAccountButton() {
        return $(By.xpath("//android.widget.TextView[@text='To bank account']"));
    }

    public static SelenideElement getSkipButton() {
        return $(By.id("com.revolut.revolut.test:id/header_next"));
    }

    public static SelenideElement addNewBeneficiaryButton() {
        return $(By.id("com.revolut.revolut.test:id/list_add_new_item_text"));
    }

    public static SelenideElement chooseTransferButtonToMe() {
        return $(By.xpath("//android.widget.TextView[@text='To myself']"));
    }

    public static SelenideElement chooseTransferButtonToAnother() {
        return $(By.xpath("//android.widget.TextView[@text='To another person']"));
    }

    public static SelenideElement getNextButton() {
        return $(By.id("com.revolut.revolut.test:id/button_next"));
    }

    public static SelenideElement getIBANField() {
        return $(By.id("com.revolut.revolut.test:id/server_field_0"));
    }

    public static SelenideElement editCountryField() {
        return $(By.id("com.revolut.revolut.test:id/edit_country"));
    }

    public static SelenideElement searchCountryField() {
        return $(By.id("com.revolut.revolut.test:id/search_src_text"));
    }

    public static SelenideElement editCurrency() {
        return $(By.id("com.revolut.revolut.test:id/edit_currency_overlay"));
    }

    public static SelenideElement getSWIFTField() {
        return $(By.id("com.revolut.revolut.test:id/server_field_1"));
    }

    public static SelenideElement getSuccesCreateScreen() {
        return $(By.id("com.revolut.revolut.test:id/operation_state_title"));
    }

    public static String succesCreateText() {
        return "was successfully created";
    }

    public static SelenideElement getDoneCreateButton() {
        return $(By.id("com.revolut.revolut.test:id/operation_status_button"));
    }

    public static SelenideElement getCloseButton() {
        return $(By.xpath("//android.widget.ImageButton"));
    }

    public static void doAddBeneficiaryToMe(String IBAN, String SWIFT){
        AccountPage.getMainMenuButton().exists();
        AccountPage.getMainMenuButton().click();
        AccountPage.getBankAccountButton().click();
        AccountPage.getSkipButton().click();
        AccountPage.addNewBeneficiaryButton().click();
        AccountPage.chooseTransferButtonToMe().click();
        AccountPage.getNextButton().click();

        AccountPage.getNextButton().click();
        AccountPage.getIBANField().sendKeys(IBAN);
        AccountPage.getSWIFTField().sendKeys(SWIFT);
        AccountPage.getNextButton().click();

        AccountPage.getNextButton().click();
        AccountPage.getSuccesCreateScreen().getText().contains(AccountPage.succesCreateText());
        AccountPage.getDoneCreateButton().click();
        AccountPage.getCloseButton().click();
    }

    public static void doAddBeneficiaryToAnother(String IBAN, String SWIFT){
        AccountPage.getMainMenuButton().exists();
        AccountPage.getMainMenuButton().click();
        AccountPage.getBankAccountButton().click();
        AccountPage.getSkipButton().click();
        AccountPage.addNewBeneficiaryButton().click();
        AccountPage.chooseTransferButtonToAnother().click();
        AccountPage.getNextButton().click();
        AccountPage.editCountryField().click();
        AccountPage.searchCountryField().sendKeys("Albania");
        $(By.id("com.revolut.revolut.test:id/country_icon")).click();
        AccountPage.getNextButton().click();
        $(By.id("com.revolut.revolut.test:id/first_name")).sendKeys("XXX");
        $(By.id("com.revolut.revolut.test:id/last_name")).sendKeys("XXX");
        AccountPage.getNextButton().click();
        AccountPage.getIBANField().sendKeys(IBAN);
        AccountPage.getSWIFTField().sendKeys(SWIFT);
        AccountPage.getNextButton().click();
        $(By.id("com.revolut.revolut.test:id/address_postal_code")).sendKeys("01111");
        $(By.id("com.revolut.revolut.test:id/address_line_1")).sendKeys("Address");
        $(By.id("com.revolut.revolut.test:id/address_line_2")).sendKeys("Address");
        $(By.id("com.revolut.revolut.test:id/address_city")).sendKeys("City");
        $(By.id("com.revolut.revolut.test:id/address_region")).sendKeys("Region");
        AccountPage.getNextButton().click();
        AccountPage.getSuccesCreateScreen().getText().contains(AccountPage.succesCreateText());
        AccountPage.getDoneCreateButton().click();
        AccountPage.getCloseButton().click();
    }
}
