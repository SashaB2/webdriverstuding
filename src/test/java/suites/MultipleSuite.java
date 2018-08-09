package suites;


import org.junit.runner.RunWith;
import org.junit.runners.Suite;

@RunWith(Suite.class)
@Suite.SuiteClasses({
    LoginSuite.class,
        StudingSuite.class
})
public class MultipleSuite {

}
