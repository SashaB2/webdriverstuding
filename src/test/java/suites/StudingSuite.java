package suites;

import downloadtest.DownloadYahooFileTest;
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
        DownloadYahooFileTest.class

})

public class StudingSuite {
}
