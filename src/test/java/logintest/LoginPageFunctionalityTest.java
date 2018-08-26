package logintest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
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
    @Description("Verify [Reset] Button on Login page")
    @Severity(SeverityLevel.NORMAL)
    public void resetButtonTest(){
        //open login page
        log.info("Start to verify [Reset] button");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", "Guru99 Bank Home Page", loginPage.getPageTitle());

        //input some text in userId and password fields
        loginPage.inputLogin(userId);
        checkAcceptanceCriteria("UserId was not inputted in the userId field", userId, loginPage.getValueOfUserIdField());

        loginPage.inputPassword(password);
        checkAcceptanceCriteria("UserId was not inputted in the userId field", password, loginPage.getValueOfpasswordField());

        //verify clearing values in userId and password fields after clicked [Reset] button
        loginPage.clickOnResetButton();

        checkAcceptanceCriteria("UserId field was not cleared after clicked reset button", "", loginPage.getValueOfUserIdField());
        checkAcceptanceCriteria("Password field was not cleared after clicked reset button", "", loginPage.getValueOfpasswordField());

    }

    @Test
    @Description("check if info hint appears when UserId and Passwords fields are blank")
    @Severity(SeverityLevel.TRIVIAL)
    public void infoHintsAppearedTest(){
        //open login page
        log.info("Start to verify \"Info Hint\" button");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        checkAcceptanceCriteria("Login page hasn't opened", loginPage.getPageTitle(), "Guru99 Bank Home Page");

        loginPage.clickOnUserIdField();
        loginPage.clickOnThePageHeader();

        checkAcceptanceCriteria("Info hint for UserId field did not appear", loginPage.isPresentInfoHintOfUserIdField(), true );
        checkAcceptanceCriteria("Text of info hint for UserId field is correct", loginPage.getTextOfInfoHintOfUserIdField(), ExcelData.getData("loginPage").get("infoHintForUserIdField"));

        loginPage.clickOnPasswordField();
        loginPage.clickOnThePageHeader();

        checkAcceptanceCriteria("Info hint for Password field did not appear", loginPage.isPresentInfoHintOfPasswodField(), true);
        checkAcceptanceCriteria("Text of info hint for Password field is correct", loginPage.getTextOfInfoHintOfPasswordField(), ExcelData.getData("loginPage").get("infoHintForPasswordIdField"));
    }
}
