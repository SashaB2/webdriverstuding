package pages.tablepages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.text.NumberFormat;
import java.text.ParseException;
import java.util.List;

public class MoneyRediffPage extends ParentPage{
    public MoneyRediffPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table[@class='dataTable']/tbody/tr")
    List<WebElement> TableRowsXpath;

    @FindBy(xpath = "//table[@class='dataTable']/tbody/tr/td[4]")
    List<WebElement> priceListXpath;

    public void openRediffPage(String url){
        driver.get(url);
    }

    public Double getMaxPriceOfTable(){

        double price = 0;

        double temp = 0;

        String tempStringPriceValue;

        NumberFormat numberFormat = NumberFormat.getInstance();

        Number number;

        int i = 0;

        for (WebElement element : priceListXpath) {
            try {
                tempStringPriceValue = element.getText();
                number = numberFormat.parse(tempStringPriceValue);
                tempStringPriceValue = number.toString();
                temp = Double.parseDouble(tempStringPriceValue);

                if(price < temp)
                    price = temp;

                //take to much time for all, only for the first 100
                if(i++ == 100)
                    break;
            } catch (ParseException e) {
                log.error("Problem with parsing table data", e);
            }catch (NullPointerException e){
                break;
            }
        }

        return price;
    }
}
