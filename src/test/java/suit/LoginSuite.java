package suit;

import logintest.InvalidLoginTest;
import logintest.ValidLoginTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLoginTest.class,
        InvalidLoginTest.class

})
public class LoginSuite {
}
