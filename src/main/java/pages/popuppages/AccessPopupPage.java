package pages.popuppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class AccessPopupPage extends ParentPage {

    public AccessPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table//h2")
    WebElement TableHeadingXpath;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    WebElement UserIdXpath;

    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    WebElement UserPasswordXpath;

    @FindBy(linkText = "Click Here")
    WebElement clickHereLink;

    public String getHeadingOfResultTable(){
        return actionsWithWebElements.getTextOfElement(TableHeadingXpath);
    }

    public boolean ifUserIdPresent(){
        if(actionsWithWebElements.getTextOfElement(UserIdXpath).length() > 0)
            return true;
        else
            return false;

    }

    public Boolean ifUserPasswordPresent(){
        if(actionsWithWebElements.getTextOfElement(UserPasswordXpath).length() > 0)
            return true;
        else
            return false;
    }

    public void clickOnClickHereButton(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }




}
