package pages.gurubank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class ManagerPage extends ParentPage {

    public ManagerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//a[@href='Logout.php']")
    WebElement LogoutButtonLink;

    public void clickOnLogoutLink(){
        actionsWithWebElements.buttonClick(LogoutButtonLink);
    }

    public String getAlertTextOfConfirmationOfLogOut(){
        return actionsWithWebElements.getAlertText();
    }

    public void manageAlertConfirmationOfLogOut(Boolean action){
        actionsWithWebElements.alertActions(action);
    }
}
