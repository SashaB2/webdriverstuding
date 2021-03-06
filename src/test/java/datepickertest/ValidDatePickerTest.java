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
public class ValidDatePickerTest extends ParentTest {

    private String inputtedDateInDatePicker;

    private String inputtedTimeInDatePicker;

    private CharSequence key;

    public ValidDatePickerTest(String browser, String inputtedDateInDatePicker, CharSequence key, String inputtedTimeInDatePicker) {
        super(browser);
        this.inputtedDateInDatePicker = inputtedDateInDatePicker;
        this.inputtedTimeInDatePicker = inputtedTimeInDatePicker;
        this.key = key;
    }

    @Parameterized.Parameters
    public static Collection testData(){
        return Arrays.asList(new Object[][]{
                {"chrome", "01012000", Keys.TAB, "0101AM"},
                {"chrome", "12312999", Keys.TAB, "1200PM"},
                {"chrome", "01010001", Keys.TAB, "0959am"},
                {"chrome", "01012000", Keys.TAB, "1059pm"},
                {"chrome", "12319999", Keys.TAB, "0101AM"},
                {"chrome", "01012000", Keys.RIGHT, "1159PM"}
        });
    }

    @Test
    @Description("Start valid DatePicker Test")
    @Severity(SeverityLevel.NORMAL)
    public void validDatePickerTest(){
        log.info("Start valid DatePicker Test");
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
        checkAcceptanceCriteria("\"Birth Date Demo Page\" does not open",datePickerPage.getPageTitle(), "Birth Date Demo Page");

        checkAcceptanceCriteria("Inputted date into dataPicker does coincide with outputted date", birthDateDemoPage.takeDate(), inputtedDateInDatePicker);
        checkAcceptanceCriteria("Inputted time into dataPicker does coincide with outputted time", birthDateDemoPage.takeTime(), inputtedTimeInDatePicker.toUpperCase());
    }
}
