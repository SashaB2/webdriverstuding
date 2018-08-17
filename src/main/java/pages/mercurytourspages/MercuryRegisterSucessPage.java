package pages.mercurytourspages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class MercuryRegisterSucessPage extends ParentPage {

    public MercuryRegisterSucessPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//p//*[contains(text(), 'Dear')]")
    WebElement RegisteredUserFirstlastNameXpath;

    @FindBy(xpath = "//p//*[contains(text(), 'Note: Your user name is')]")
    WebElement RegisteredUserLoginNameXpath;

    public String getUserRegisteredFirstLastNameInfo(){
        return actionsWithWebElements.getTextOfElement(RegisteredUserFirstlastNameXpath);
    }

    public String getUserRegisteredLoginNameInfo(){
        return actionsWithWebElements.getTextOfElement(RegisteredUserLoginNameXpath);
    }
}
