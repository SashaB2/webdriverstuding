package popupwindowstest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

public class GuruBankPopupTest extends ParentTest {

    public GuruBankPopupTest(String browser) {
        super(browser);
    }


    @Test
    @Description("Guru Bnk Popup window test")
    @Severity(SeverityLevel.NORMAL)
    public void guruBankPopupTest(){
        log.info("start Guru Bnk Popup window test");
        guruBankPopupPage.openPopupPage();
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getGuruBankPopupPageTitle(), "Guru99 Bank Home Page");

        guruBankPopupPage.clickOnClickHereButton();
        guruBankPopupPage.switchToSearchUserByEmailPopupWindow();
        System.out.println(searchUserByEmailPage.getHeadingOfPage());
        checkAcceptanceCriteria("Do not open search user window", searchUserByEmailPage.getHeadingOfPage(), "Enter your email address to get\naccess details to demo site");

    }
}
