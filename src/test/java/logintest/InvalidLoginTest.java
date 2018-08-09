package logintest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ConfigData;
import libs.ExcelData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

public class InvalidLoginTest extends ParentTest {

    private String login;

    private String password;


    public InvalidLoginTest(String browser, String login, String password){
        super(browser);
        this.login = login;
        this.password = password;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "", ""},
                {"chrome", ConfigData.getConfigValue("login"), ""},
//                {"chrome", ConfigData.getConfigValue("login"), "123456"},
//                {"chrome", "", ConfigData.getConfigValue("password")},
//                {"chrome", "qwerty", "dvbdf"},
//                {"chrome", "admin", "admin"},
//                {"chrome", "admin", "123456"}
        });
    }

    /**
     * Can not use screenshot because of crashing inside this library.
     * Can not user quick login therefor this driver does not recognize a text on an alert.
     * Tried in different ways, wasted 3 hours. used desireble capabilities and thread sleep -> did not
     * in the future maybe rewrite to use multiple data from excel and SpreadsheetData library
     */
    @Test
    @Description("Start invalid login test")
    @Severity(SeverityLevel.CRITICAL)
    public void invalidLogin(){
        log.info("Start invalid login test");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");

        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        checkAcceptanceCriteria("Alert do not present", loginPage.isInvalidCredentialAlertPresent(), true);
        Assert.assertEquals("Text is incorrect on the invalid login alert", loginPage.getTextFromInvalidCredentialAlertMessage(),  ExcelData.getData("loginPage").get("invalidAlertText"));
    }
}
