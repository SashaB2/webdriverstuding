package logintest;

import libs.ConfigData;
import libs.ExcelData;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.UnhandledAlertException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
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
                {"chrome", "", ConfigData.getConfigValue("password")},
                {"chrome", "qwerty", "dvbdf"},
                {"chrome", "admin", "admin"},
                {"chrome", "admin", "123456"}
        });
    }

    /**
     * Can not use screenshot because of crashing inside this library.
     * Can not user quick login therefor this driver does not recognize a text on an alert.
     * Tried in different ways, wasted 3 hours. used desireble capabilities and thread sleep -> did not
     * in the future maybe rewrite to use multiple data from excel and SpreadsheetData library
     */
    @Test
    public void invalidLogin(){
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");
        loginPage.inputLogin(login);
        loginPage.inputPassword(password);
        loginPage.clickOnLoginButton();
        Assert.assertEquals("Text is incorrect on the invalid login alert", ExcelData.getData("loginPage").get("invalidAlertText"), loginPage.getTextFromInvalidPasswordAlertMessage()); //TO Do: Put text to Exel data
    }
}
