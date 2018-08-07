package suit;

import datepickertest.InvalidDatePickerTest;
import draganddrop.DragAndDropTest;
import logintest.InvalidLoginTest;
import logintest.LoginPageFunctionalityTest;
import logintest.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLoginTest.class,
//        LoginPageFunctionalityTest.class,
//        InvalidLoginTest.class
})
public class LoginSuite {
}
