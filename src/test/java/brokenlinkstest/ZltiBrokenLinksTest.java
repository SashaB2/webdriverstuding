package brokenlinkstest;

import org.junit.Test;
import parenttest.ParentTest;

public class ZltiBrokenLinksTest extends ParentTest {
    public ZltiBrokenLinksTest(String browser) {
        super(browser);
    }

    @Test
    public void zltiBrokentLinksTest(){
        zltiPage.openZltipage();
    }
}
