package logintest;

import libs.ConfigData;
import libs.ExcelData;
import org.junit.Test;
import parenttest.ParentTest;

public class LoginPageFunctionalityTest extends ParentTest {

    public LoginPageFunctionalityTest(String browser) {
        super(browser);
    }

    private String userId = "qwr134";

    private String password = "1wF#brt";

    @Test
    public void resetButtonTest(){
        //open login page
        log.info("Verify [Reset] Button on Login page");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", "Guru99 Bank Home Page", loginPage.getPageTitle());
        log.trace("login page opened");

        //input some text in userId and password fields
        loginPage.inputLogin(userId);
        checkAcceptanceCriteria("UserId was not inputted in the userId field", userId, loginPage.getValueOfUserIdField());
        log.trace("UserId was inputted in the userId field");

        loginPage.inputPassword(password);
        checkAcceptanceCriteria("UserId was not inputted in the userId field", password, loginPage.getValueOfpasswordField());
        log.trace("password was inputted in the password field");

        //verify clearing values in userId and password fields after clicked [Reset] button
        loginPage.clickOnResetButton();


        checkAcceptanceCriteria("UserId field was not cleared after clicked reset button", "", loginPage.getValueOfUserIdField());
        log.trace("UserId field was cleared after clicked reset button");

        checkAcceptanceCriteria("Password field was not cleared after clicked reset button", "", loginPage.getValueOfpasswordField());
        log.trace("Password field was cleared after clicked reset button");

    }

    @Test
    public void infoHintsAppearedTest(){
        //open login page
        log.info("check if info hint appears when UserId and Passwords fields are blank");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");
        log.trace("login page opened");

        loginPage.clickOnUserIdField();
        loginPage.clickOnThePageHeader();

        checkAcceptanceCriteria("Info hint for UserId field did not appear", true, loginPage.isPresentInfoHintOfUserIdField());
        log.trace("Info hint for UserId field appeared");
        checkAcceptanceCriteria("Text of info hint for UserId field is correct", ExcelData.getData("loginPage").get("infoHintForUserIdField"), loginPage.getTextOfInfoHintOfUserIdField());
        log.trace("Text of info hint for UserId field is correct");

        loginPage.clickOnPasswordField();
        loginPage.clickOnThePageHeader();

        checkAcceptanceCriteria("Info hint for Password field did not appear", true, loginPage.isPresentInfoHintOfPasswodField());
        log.trace("Info hint for Password field appeared");
        checkAcceptanceCriteria("Text of info hint for Password field is correct", ExcelData.getData("loginPage").get("infoHintForPasswordIdField"), loginPage.getTextOfInfoHintOfPasswordField());
        log.trace("Text of info hint for Password field is correct");
    }
}
