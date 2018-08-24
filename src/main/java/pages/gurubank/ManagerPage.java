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

    //
    @FindBy(partialLinkText = "New Customer")
    WebElement NewUserLink;

    @FindBy(xpath = "//td[contains(text(),'Manger Id : ')]")
    WebElement LoggedUserID;

    public void clickOnLogoutLink(){
        actionsWithWebElements.buttonClick(LogoutButtonLink);
    }

    public String getAlertTextOfConfirmationOfLogOut(){
        return actionsWithWebElements.getAlertText();
    }

    public void manageAlertConfirmationOfLogOut(Boolean action){
        actionsWithWebElements.alertActions(action);
    }

    public String getLoggedUserID(){
        return LoggedUserID.getText();
    }

    //navigation bar links
    public void openNewCustomerPage(){
        actionsWithWebElements.buttonClick(NewUserLink);
    }

}
