package pages.popuppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.Iterator;
import java.util.Set;

public class GuruBankPopupPage extends ParentPage {

    public GuruBankPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(linkText = "Click Here")
    WebElement clickHereLink;


    public void openPopupPage(){
        driver.navigate().to("http://demo.guru99.com/popup.php");
    }

    public String getGuruBankPopupPageTitle(){
        return getPageTitle();
    }

    public void clickOnClickHereButton(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }

    public void openArticlePopupWindow(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }

    public void switchToSearchUserByEmailPopupWindow(){
        actionsWithWebElements.switchToPopupWindow();
    }



}
