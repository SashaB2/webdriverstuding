package datepickertest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ConfigData;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

@RunWith(value = Parameterized.class)
public class InvalidDatePickerTest extends ParentTest {

    private String inputtedDateInDatePicker;

    private String inputtedTimeInDatePicker;

    private CharSequence key;

    public InvalidDatePickerTest(String browser, String inputtedDateInDatePicker, CharSequence key, String inputtedTimeInDatePicker) {
        super(browser);
        this.inputtedDateInDatePicker = inputtedDateInDatePicker;
        this.inputtedTimeInDatePicker = inputtedTimeInDatePicker;
        this.key = key;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "", Keys.TAB, ""},
                {"chrome", "01012000", Keys.TAB, "1059VB"},
                {"chrome", "a1012000", Keys.RIGHT, "2359AM"},
                {"chrome", "01012000", Keys.SHIFT, "2359AM"}, //verify on switch key
                {"chrome", "01012000", Keys.ALT, "2359AM"}    //verify on switch key
        });
    }

    @Test
    @Description("Invalid DatePicker Test")
    @Severity(SeverityLevel.NORMAL)
    public void invalidDatePickerTest(){
        log.info("Start invalid DatePicker Test");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        loginPage.clickOnPartiallLink("Selenium");
        loginPage.clickOnPartiallLink("Selenium DatePicker Demo");

        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", datePickerPage.getPageTitle(), "Select Date from DatePicker Demo Page");
        checkAcceptanceCriteria("Page with date picker does not open", datePickerPage.headerOfBirthDateDemoPage(), "Open this page in Chrome");

        //input date, click button, input time
        datePickerPage.inputDateIntoDataPicker(inputtedDateInDatePicker);
        datePickerPage.clickOnTabButton(key);
        datePickerPage.inputTimeIntoDataPicker(inputtedTimeInDatePicker);
        datePickerPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Page title does not  coincide", datePickerPage.getPageTitle(), "Select Date from DatePicker Demo Page");

    }
}
