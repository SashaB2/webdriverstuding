package logintest;

import org.junit.Assert;
import org.junit.Test;
import org.openqa.selenium.UnhandledAlertException;
import parenttest.ParentTest;

import libs.ConfigData;

import static org.hamcrest.core.Is.is;

public class ValidLoginTest extends ParentTest {

    public ValidLoginTest(String browser){
        super(browser);
    }

    @Test
    public void validLoginTest(){
        //open login page
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");
        log.trace("Login page opened");

        loginPage.inputLogin(ConfigData.getConfigValue("login1"));
        loginPage.inputPassword(ConfigData.getConfigValue("password"));
        loginPage.clickOnLoginButton();

        //check if user logged -> if opened main page
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Manager HomePage");
        checkAcceptanceCriteria("User has not Logged / main page has not opened", mainPage.getValueFromHeading(), "Guru99 Bank");
        log.trace("User Logged");
    }

}
