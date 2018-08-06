package suit;

import datepickertest.InvalidDatePickerTest;
import draganddrop.DragAndDropTest;
import logintest.LoginPageFunctionalityTest;
import logintest.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLoginTest.class,
        LoginPageFunctionalityTest.class,
        DragAndDropTest.class,
//        InvalidDatePickerTest.class

})
public class LoginSuite {
}
