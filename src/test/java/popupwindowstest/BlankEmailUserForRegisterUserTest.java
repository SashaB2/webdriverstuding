package popupwindowstest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

public class BlankEmailUserForRegisterUserTest extends ParentTest {

    public BlankEmailUserForRegisterUserTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Test popup window with blank user email")
    @Severity(SeverityLevel.NORMAL)
    public void name() {
        log.info("start a test popup window with blank user email");
        guruBankPopupPage.openPopupPage();
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getGuruBankPopupPageTitle(), "Guru99 Bank Home Page");

        guruBankPopupPage.clickOnClickHereButton();
        guruBankPopupPage.switchToSearchUserByEmailPopupWindow();
        checkAcceptanceCriteria("Do not open search user window", searchUserByEmailPage.getHeadingOfPage(), "Enter your email address to get\naccess details to demo site");

        searchUserByEmailPage.inputUserEmail("");
        searchUserByEmailPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Access popup page has not been opened", searchUserByEmailPage.getTextOfErrorLable(), "Email ID must not be blank");

    }
}
