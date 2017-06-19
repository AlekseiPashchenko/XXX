package test;

import bo.Account;
import com.codeborne.selenide.Configuration;
import driver.AndroidDriverProvider;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import page.AccountPage;
import page.LoginPage;
import page.LogoutPage;
import page.TutorialPage;
import static com.codeborne.selenide.Selenide.close;


/**
 * Created by apashchenko on 18.06.2017.
 */
public class FirstTest {

    private Account account = new Account(662266,1111,"FR14 2004 1010 0505 0001 3M02 606","CCFRFRPP");

    @BeforeMethod
    public void setUp() {
        Configuration.browser = AndroidDriverProvider.class.getName();
    }

    @AfterMethod
    public void theEnd(){
        close();
    }

    @Test(description = "Adding own account as a new beneficiary. Skipping all tutorial screens.")
    public void addBeneficiaryMyself() throws InterruptedException {

        TutorialPage.skip();
        LoginPage.doLogin(account.getPhone(), account.getPasscode());
        AccountPage.doAddBeneficiaryToMe(account.getIban(),account.getSwift());
        LogoutPage.doLogout();
    }

    @Test(description = "Adding own account as a new beneficiary. Checking all tutorial screens.")
    public void addBeneficiaryMyselfSkip() throws InterruptedException {

        TutorialPage.doCheckAllTutorial();
        LoginPage.doLogin(account.getPhone(), account.getPasscode());
        AccountPage.doAddBeneficiaryToMe(account.getIban(),account.getSwift());
        LogoutPage.doLogout();
    }

    @Test(description = "Adding another personal account as a new beneficiary. Skipping all tutorial screens.")
    public void addBeneficiaryAnother() throws InterruptedException {

        TutorialPage.skip();
        LoginPage.doLogin(account.getPhone(), account.getPasscode());
        AccountPage.doAddBeneficiaryToAnother(account.getIban(),account.getSwift());
        LogoutPage.doLogout();

    }

    @Test(description = "Adding another personal account as a new beneficiary. Checking all tutorial screens.")
    public void addBeneficiaryAnother2() throws InterruptedException {

        TutorialPage.doCheckAllTutorial();
        LoginPage.doLogin(account.getPhone(), account.getPasscode());
        AccountPage.doAddBeneficiaryToAnother(account.getIban(),account.getSwift());
        LogoutPage.doLogout();

    }


}

