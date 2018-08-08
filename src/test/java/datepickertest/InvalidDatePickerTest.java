package datepickertest;

import libs.ConfigData;
import org.junit.Test;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Keys;
import parenttest.ParentTest;

import java.util.Arrays;
import java.util.Collection;

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
    public void invalidDatePickerTest(){
        log.info("Start invalid DatePicker Test");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        loginPage.clickOnPartiallLink("Selenium");
        loginPage.clickOnPartiallLink("Selenium DatePicker Demo");

        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Select Date from DatePicker Demo Page", datePickerPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Open this page in Chrome", datePickerPage.headerOfBirthDateDemoPage());
        log.trace("Opened DataPicker page");

        //input date, click button, input time
        datePickerPage.inputDateIntoDataPicker(inputtedDateInDatePicker);
        datePickerPage.clickOnTabButton(key);
        datePickerPage.inputTimeIntoDataPicker(inputtedTimeInDatePicker);
        datePickerPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Page title does not  coincide", "Select Date from DatePicker Demo Page", datePickerPage.getPageTitle());

    }
}
