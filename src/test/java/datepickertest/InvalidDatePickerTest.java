package datepickertest;

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
//                {"chrome", "asdfghjk", Keys.TAB, "sdfsf"},  need a specific test on it, need to take current value from field. TO DO: in future
                {"chrome", "01012000", Keys.TAB, "1059VB"},
                {"chrome", "a1012000", Keys.RIGHT, "2359AM"},
                {"chrome", "01012000", Keys.SHIFT, "2359AM"}, //verify on switch key
                {"chrome", "01012000", Keys.ALT, "2359AM"}    //verify on switch key
        });
    }

    @Test
    public void validDatePickerTest(){

        loginPage.loginQuickly();
        mainPage.clickOnPartiallLink("Selenium");
        mainPage.clickOnPartiallLink("Selenium DatePicker Demo");

        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Select Date from DatePicker Demo Page", datePickerPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Open this page in Chrome", datePickerPage.headerOfBirthDateDemoPage());

        //input date, click button, input time
        datePickerPage.inputDateIntoDataPicker(inputtedDateInDatePicker);
        datePickerPage.clickOnTabButton(key);
        datePickerPage.inputTimeIntoDataPicker(inputtedTimeInDatePicker);
        datePickerPage.clickOnSubmitButton();
        checkAcceptanceCriteria("Page title does not  coincide", "Select Date from DatePicker Demo Page", datePickerPage.getPageTitle());

    }
}