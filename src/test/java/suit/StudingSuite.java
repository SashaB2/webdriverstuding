package suit;

import datepickertest.InvalidDatePickerTest;
import datepickertest.ValidDatePickerTest;
import draganddrop.DragAndDropTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import pages.DragAndDropPage;
import tabletest.RediffMoneyTest;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        RediffMoneyTest.class,
        DragAndDropTest.class,
        InvalidDatePickerTest.class,
        ValidDatePickerTest.class

})

public class StudingSuite {
}
