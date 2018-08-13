package suites;

import databasetest.DataBaseTest;
import datepickertest.InvalidDatePickerTest;
import datepickertest.ValidDatePickerTest;
import downloadtest.DownloadYahooFileTest;
import downloadtest.UploadFileTest;
import draganddrop.DragAndDropTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import tabletest.RediffMoneyTest;

//TO DO: add download test executing to linux
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DragAndDropTest.class,
        RediffMoneyTest.class,
        InvalidDatePickerTest.class,
        ValidDatePickerTest.class,
        DownloadYahooFileTest.class,
        UploadFileTest.class,
        DataBaseTest.class
})

public class StudingSuite {
}
