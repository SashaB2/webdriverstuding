package tabletest;

import org.junit.Test;
import parenttest.ParentTest;

public class RediffMoneyTest extends ParentTest {
    public RediffMoneyTest(String browser) {
        super(browser);
    }

    @Test
    public void twoThousantPriceAvailableTest(){
        moneyRediffPage.openRediffPage("https://money.rediff.com/gainers/bse/daily/groupall");
        checkAcceptanceCriteria("Money Rediff page does not open", "Daily Gainers: BSE, NSE, Stock quotes, share market, stock market, stock tips: Rediff Stocks", moneyRediffPage.getPageTitle());
        log.trace("Money Rediff page opened");

        //check if price more than twi thousand is
        System.out.println(moneyRediffPage.getMaxPriceOfTable());
//        double price = moneyRediffPage.getMaxPriceOfTable()
        checkAcceptanceCriteria("No 2000 price available", true, moneyRediffPage.getMaxPriceOfTable() > 200);

    }
}
