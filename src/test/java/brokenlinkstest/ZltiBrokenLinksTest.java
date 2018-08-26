package brokenlinkstest;

import org.junit.Test;
import parenttest.ParentTest;

public class ZltiBrokenLinksTest extends ParentTest {
    public ZltiBrokenLinksTest(String browser) {
        super(browser);
    }

    @Test
    public void zltiBrokentLinksTest(){
        log.info("Check if links are broken on Zlti page");
        zltiPage.openZltipage();
        zltiPage.checkLinksOnZltiPage();
    }


}
