package popupwindowstest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import org.junit.runners.Parameterized;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;
import java.util.Date;

public class InvalidEmailUserCredentialTest extends ParentTest {

    static volatile int testCount = 0;

    String userEmail;

    public InvalidEmailUserCredentialTest(String browser, String userEmail) {
        super(browser);
        this.userEmail = userEmail;
    }

    @Parameterized.Parameters
    public static Collection testData(){return Arrays.asList(new Object[][]{
            {"chrome","1"},
            {"chrome","q"},
            {"chrome","@afafaf"},
            {"chrome","afafaf@"},
            {"chrome","afa@faf"},
            {"chrome","afafaf@gmail"},
            {"chrome","afafaf@gmail."},
            {"chrome","afafafgmail.com"},
            {"chrome","@.com"},
    });
    }


    @Test
    @Description("Test popup window with invalid user email")
    @Severity(SeverityLevel.NORMAL)
    public void invalidUserEmailForgenerationCredential(){
        Date date = new Date();

        System.out.println(date);

        log.info("start a test popup window with invalid user email");
        guruBankPopupPage.openPopupPage();
        checkAcceptanceCriteria("Guru Bank Popup pagee title does not coincide", guruBankPopupPage.getGuruBankPopupPageTitle(), "Guru99 Bank Home Page");

        guruBankPopupPage.clickOnClickHereButton();
        guruBankPopupPage.switchToSearchUserByEmailPopupWindow();
        checkAcceptanceCriteria("Do not open search user window", searchUserByEmailPage.getHeadingOfPage(), "Enter your email address to get\naccess details to demo site");

        searchUserByEmailPage.inputUserEmail(userEmail);
        searchUserByEmailPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Access popup page has not been opened", searchUserByEmailPage.getTextOfErrorLable(), "Email ID is not valid");

        System.out.println("-----------------------" + ++testCount + "-------------------------------------");

        System.out.println(date);

    }
}
