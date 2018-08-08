package pages;

import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.ArrayList;
import java.util.List;

/**
 * use to login in Guru99 Bank
 * use to open training pages with examples
 */
public class LoginPage extends ParentPage {

    public LoginPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(name = "uid")
    WebElement UserIdFieldName;

    @FindBy(name = "password")
    WebElement PasswordFieldName;

    @FindBy(name = "btnLogin")
    WebElement LoginButtonName;

    @FindBy(name = "btnReset")
    WebElement ResetButtonName;

    @FindBy(id = "message23")
    WebElement InfoHintOfUserIdFieldID;

    @FindBy(id = "message18")
    WebElement InfoHintOfUPasswordFieldID;

    @FindBy(tagName = "a")
    List<WebElement> allLinksTagName;

    public void openLoginPage(String loginPageUrl){
        driver.navigate().to(loginPageUrl);
    }

    public void inputLogin(String login){
        actionsWithWebElements.inputValueInField(UserIdFieldName, login);
    }

    public void inputPassword(String password){
        actionsWithWebElements.inputValueInField(PasswordFieldName, password);
    }

    public void clickOnLoginButton(){
        actionsWithWebElements.buttonClick(LoginButtonName);
    }

    public void clickOnResetButton(){
        actionsWithWebElements.buttonClick(ResetButtonName);
    }

    public String getValueOfUserIdField(){
        return UserIdFieldName.getAttribute("value");
    }

    public String getValueOfpasswordField(){
        return PasswordFieldName.getAttribute("value");
    }

    public String getTextOfInfoHintOfUserIdField(){
        return InfoHintOfUserIdFieldID.getText();
    }

    public String getTextOfInfoHintOfPasswordField(){
        return InfoHintOfUPasswordFieldID.getText();
    }

    public void clickOnUserIdField(){
        actionsWithWebElements.buttonClick(UserIdFieldName);
    }

    public void clickOnPasswordField(){
        actionsWithWebElements.buttonClick(PasswordFieldName);
    }

    public boolean isPresentInfoHintOfUserIdField(){
        return actionsWithWebElements.isElementPresent(InfoHintOfUserIdFieldID);
    }

    public boolean isPresentInfoHintOfPasswodField(){
        return actionsWithWebElements.isElementPresent(InfoHintOfUPasswordFieldID);
    }

    public void clickOnThePageHeader(){
        actionsWithWebElements.buttonClick(PageHeading);
    }



    public String getTextFromInvalidPasswordAlertMessage(){
        return actionsWithWebElements.getAlertText();
    }




    public void loginQuickly(String login, String password){
        openLoginPage(ConfigData.getConfigValue("base_url"));
        inputLogin(login);
        inputPassword(password);
        clickOnLoginButton();
    }

    public void loginQuickly(){
        loginQuickly(ConfigData.getConfigValue("login"), ConfigData.getConfigValue("password"));
    }

    /**
     * Links also is in drop-down menu so that we processed to others page
     * @param linkName
     */
    public void clickOnPartiallLink(String linkName){
        for (WebElement link : allLinksTagName){
            if( (link.getText()).equals(linkName) ){
                link.click();
                break;
            }
        }
    }




}