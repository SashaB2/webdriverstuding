package suites;

import downloadtest.DownloadYahooFileTest;
import downloadtest.UploadFileTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

//TO DO: add download test executing to linux
@RunWith(Suite.class)
@Suite.SuiteClasses({
//        DragAndDropTest.class,
//        RediffMoneyTest.class,
//        InvalidDatePickerTest.class,
//        ValidDatePickerTest.class,
//        InvalidDatePickerTest.class,
//        DownloadYahooFileTest.class
        UploadFileTest.class
})

public class StudingSuite {
}
