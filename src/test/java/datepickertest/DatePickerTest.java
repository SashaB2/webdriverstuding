package datepickertest;

import org.junit.Test;
import parenttest.ParentTest;

public class DatePickerTest extends ParentTest {
    public DatePickerTest(String browser) {
        super(browser);
    }

    @Test
    public void validDateTest(){
        String inputtedDateInDatePicker = "01012000";
        String inputtedTimeInDatePicker = "0100AM";

        loginPage.loginQuickly();
        mainPage.clickOnPartiallLink("Selenium");
        mainPage.clickOnPartiallLink("Selenium DatePicker Demo");

        //verif if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Select Date from DatePicker Demo Page", datePickerPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Open this page in Chrome", datePickerPage.PageHeader());

        //input date and time
        datePickerPage.inputDateTimeIntoDataPicker(inputtedDateInDatePicker, inputtedTimeInDatePicker);
        datePickerPage.clickOnSubmitButton();
        checkAcceptanceCriteria("\"Birth Date Demo Page\" does not open","Birth Date Demo Page", datePickerPage.getPageTitle());
        checkAcceptanceCriteria("Inputted date into dataPicker does coincide with outputted date", inputtedDateInDatePicker, birthDateDemoPage.getDate());
//        checkAcceptanceCriteria("Inputted time into dataPicker does coincide with outputted time", inputtedDateInDatePicker, birthDateDemoPage.getTime());


        System.out.println(birthDateDemoPage.getDatePickerText());
        System.out.println(birthDateDemoPage.getTime());
    }
}
