package brokenlinkstest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

public class ZltiBrokenLinksTest extends ParentTest {
    public ZltiBrokenLinksTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Saving login and password")
    @Severity(SeverityLevel.BLOCKER)
    public void zltiBrokentLinksTest(){
        log.info("Check if links are broken on Zlti page");
        zltiPage.openZltipage();
        zltiPage.checkLinksOnZltiPage();
    }


}
