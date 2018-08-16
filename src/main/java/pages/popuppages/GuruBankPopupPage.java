package pages.popuppages;

import io.qameta.allure.Step;
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


    @Step
    public void openPopupPage(){
        driver.navigate().to("http://demo.guru99.com/popup.php");
    }

    @Step
    public String getGuruBankPopupPageTitle(){
        return getPageTitle();
    }

    @Step
    public void clickOnClickHereButton(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }

    @Step
    public void openArticlePopupWindow(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }

    @Step
    public void switchToSearchUserByEmailPopupWindow(){
        actionsWithWebElements.switchToPopupWindow();
    }



}
