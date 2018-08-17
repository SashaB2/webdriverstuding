package popupwindowstest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.junit.runners.Parameterized;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

public class UserCredentialTest extends ParentTest {

    public UserCredentialTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Test popup window with valid user email")
    @Severity(SeverityLevel.NORMAL)
    public void validGenerationUserCredentialTest(){
        log.info("start a test popup window with valid user email");
        guruBankPopupPage.openPopupPage();
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getGuruBankPopupPageTitle(), "Guru99 Bank Home Page");

        guruBankPopupPage.clickOnClickHereButton();
        guruBankPopupPage.switchToSearchUserByEmailPopupWindow();
        checkAcceptanceCriteria("Do not open search user window", searchUserByEmailPage.getHeadingOfPage(), "Enter your email address to get\naccess details to demo site");

        searchUserByEmailPage.inputUserEmail("b2forwt@gmail.com");
        searchUserByEmailPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Access popup page has not been opened", accessPopupPage.getHeadingOfResultTable(), "Access details to demo site.");

        //verify user credential
        checkAcceptanceCriteria("User id is not present", accessPopupPage.ifUserIdPresent(), true);
        checkAcceptanceCriteria("User password is not present", accessPopupPage.ifUserPasswordPresent(), true);

        accessPopupPage.clickOnClickHereButton();
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getGuruBankPopupPageTitle(), "Guru99 Bank Home Page");
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getPageURL(), "http://demo.guru99.com/popup.php");

    }






}
