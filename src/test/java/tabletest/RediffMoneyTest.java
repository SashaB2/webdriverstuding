package tabletest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

public class RediffMoneyTest extends ParentTest {
    public RediffMoneyTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Start Rediff Table Test")
    @Severity(SeverityLevel.CRITICAL)
    public void TableTest(){
        log.info("Start to Price oof table on Rediff page");
        moneyRediffPage.openRediffPage("https://money.rediff.com/gainers/bse/daily/groupall");
        checkAcceptanceCriteria("Money Rediff page does not open", "Daily Gainers: BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks", moneyRediffPage.getPageTitle());

        //check if price more than twi thousand is
        checkAcceptanceCriteria("No 2000 price available", true, moneyRediffPage.getMaxPriceOfTable() > 2000);


    }
}
