package suites;

import databasetest.DataBaseTest;
import datepickertest.InvalidDatePickerTest;
import datepickertest.ValidDatePickerTest;
import downloadtest.DownloadYahooFileTest;
import downloadtest.UploadFileTest;
import draganddrop.DragAndDropTest;
import dropdownlisttest.MercuryToursTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import popupwindowstest.BlankEmailUserForRegisterUserTest;
import popupwindowstest.InvalidEmailUserCredentialTest;
import popupwindowstest.UserCredentialTest;
import tabletest.RediffMoneyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        DragAndDropTest.class,
        RediffMoneyTest.class,
        InvalidDatePickerTest.class,
        ValidDatePickerTest.class,
        DownloadYahooFileTest.class,
        UploadFileTest.class,
        DataBaseTest.class,
        UserCredentialTest.class,
        InvalidEmailUserCredentialTest.class,
        BlankEmailUserForRegisterUserTest.class,
        MercuryToursTest.class
})

public class StudingSuite {
}
