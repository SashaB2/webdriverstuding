package suites;

import logintest.InvalidLoginTest;
import logintest.LoginPageFunctionalityTest;
import logintest.ValidLoginLogoutTest;
import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
        ValidLoginLogoutTest.class,
        LoginPageFunctionalityTest.class,
        InvalidLoginTest.class
})
public class LoginSuite {
}
