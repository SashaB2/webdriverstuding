package pages.gurubank;

import io.qameta.allure.Step;
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

    @Step
    public void clickOnLogoutLink(){
        actionsWithWebElements.buttonClick(LogoutButtonLink);
    }

    @Step
    public String getAlertTextOfConfirmationOfLogOut(){
        return actionsWithWebElements.getAlertText();
    }

    @Step
    public void manageAlertConfirmationOfLogOut(Boolean action){
        actionsWithWebElements.alertActions(action);
    }

    @Step
    public String getLoggedUserID(){
        return LoggedUserID.getText();
    }

    //navigation bar links
    @Step
    public void openNewCustomerPage(){
        actionsWithWebElements.buttonClick(NewUserLink);
    }

}
