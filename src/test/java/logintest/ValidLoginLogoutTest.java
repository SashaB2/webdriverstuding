package logintest;

import io.qameta.allure.Description;
import io.qameta.allure.Epic;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

import libs.ConfigData;

import static org.hamcrest.core.Is.is;

public class ValidLoginLogoutTest extends ParentTest {

    public ValidLoginLogoutTest(String browser){
        super(browser);
    }

    @Test
    @Description("Valid Login Test")
    @Severity(SeverityLevel.BLOCKER)
    @Epic("Login user")
    public void validLoginLogoutTest(){
        log.info("Start to verify Valid login");
        //open login page
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");

        //input login and password
        loginPage.inputLogin(ConfigData.getConfigValue("login"));
        loginPage.inputPassword(ConfigData.getConfigValue("password"));
        loginPage.clickOnLoginButton();

        //check if user logged -> if opened main page
        checkAcceptanceCriteria("Login page hasn't opened", managerPage.getPageTitle(), "Guru99 Bank Manager HomePage");
        checkAcceptanceCriteria("User has not Logged / main page has not opened", managerPage.getValueFromHeading(), "Guru99 Bank");
        //check if corresponded user logged -> if opened main page
        checkAcceptanceCriteria("User id does not coincide on Manager Page", managerPage.getLoggedUserID(), "Manger Id : " + ConfigData.getConfigValue("login"));

        log.info("Log out verification");
        managerPage.clickOnLogoutLink();
        //verify alert message
        checkAcceptanceCriteria("Text on alert massage has mistakes", "You Have Succesfully Logged Out!!", managerPage.getAlertTextOfConfirmationOfLogOut());
        managerPage.manageAlertConfirmationOfLogOut(true);
        //verify if user logout
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");
    }

}
