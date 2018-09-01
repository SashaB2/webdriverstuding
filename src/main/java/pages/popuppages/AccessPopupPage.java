package pages.popuppages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class AccessPopupPage extends ParentPage {

    public AccessPopupPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//table//h2")
    private WebElement TableHeadingXpath;

    @FindBy(xpath = "//tbody/tr[4]/td[2]")
    private WebElement UserIdXpath;

    @FindBy(xpath = "//tbody/tr[5]/td[2]")
    private WebElement UserPasswordXpath;

    @FindBy(linkText = "Click Here")
    private WebElement clickHereLink;

    @Step
    public String getHeadingOfResultTable(){
        return actionsWithWebElements.getTextOfElement(TableHeadingXpath);
    }

    @Step
    public boolean ifUserIdPresent(){
        if(actionsWithWebElements.getTextOfElement(UserIdXpath).length() > 0)
            return true;
        else
            return false;

    }

    @Step
    public Boolean ifUserPasswordPresent(){
        if(actionsWithWebElements.getTextOfElement(UserPasswordXpath).length() > 0)
            return true;
        else
            return false;
    }

    @Step
    public void clickOnClickHereButton(){
        actionsWithWebElements.buttonClick(clickHereLink);
    }




}
