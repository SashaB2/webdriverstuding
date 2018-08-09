package suit;

import datepickertest.InvalidDatePickerTest;
import datepickertest.ValidDatePickerTest;
import downloadtest.DownloadTest;
import draganddrop.DragAndDropTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.DragAndDropPage;
import tabletest.RediffMoneyTest;

//TO DO: add download test executing to linux
@RunWith(Suite.class)
@Suite.SuiteClasses({
        DragAndDropTest.class
//        RediffMoneyTest.class,
//        InvalidDatePickerTest.class,
//        ValidDatePickerTest.class,
//        InvalidDatePickerTest.class

})

public class StudingSuite {
}
