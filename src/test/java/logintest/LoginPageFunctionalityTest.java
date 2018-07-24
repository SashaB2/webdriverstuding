package logintest;

import libs.ConfigData;
import org.junit.Test;
import parenttest.ParentTest;

public class LoginPageFunctionalityTest extends ParentTest {

    public LoginPageFunctionalityTest(String browser) {
        super(browser);
    }

    //TO DO
    @Test
    public void resetButtonTest(){
        //open login page
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");

    }
}
