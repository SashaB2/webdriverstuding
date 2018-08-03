package suit;

import draganddrop.DragAndDropTest;
import logintest.InvalidLoginTest;
import logintest.LoginPageFunctionalityTest;
import logintest.ValidLoginTest;
import mainpagetest.MainPageContentTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLoginTest.class,
        LoginPageFunctionalityTest.class,
        MainPageContentTest.class,
        DragAndDropTest.class,

})
public class LoginSuite {
}
