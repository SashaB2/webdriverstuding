package pages;

import io.qameta.allure.Step;
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
    private WebElement UserIdFieldName;

    @FindBy(name = "password")
    private WebElement PasswordFieldName;

    @FindBy(name = "btnLogin")
    private WebElement LoginButtonName;

    @FindBy(name = "btnReset")
    private WebElement ResetButtonName;

    @FindBy(id = "message23")
    private WebElement InfoHintOfUserIdFieldID;

    @FindBy(id = "message18")
    private WebElement InfoHintOfUPasswordFieldID;

    @FindBy(tagName = "a")
    private List<WebElement> allLinksTagName;

    @Step
    public void openLoginPage(String loginPageUrl){
        driver.navigate().to(loginPageUrl);
    }

    @Step("Login: {0}")
    public void inputLogin(String login){
        actionsWithWebElements.inputValueInField(UserIdFieldName, login);
    }

    @Step("Password: {0}")
    public void inputPassword(String password){
        actionsWithWebElements.inputValueInField(PasswordFieldName, password);
    }

    @Step
    public void clickOnLoginButton(){
        actionsWithWebElements.buttonClick(LoginButtonName);
    }

    @Step
    public void clickOnResetButton(){
        actionsWithWebElements.buttonClick(ResetButtonName);
    }

    @Step
    public String getValueOfUserIdField(){
        return UserIdFieldName.getAttribute("value");
    }

    @Step
    public String getValueOfpasswordField(){
        return PasswordFieldName.getAttribute("value");
    }

    @Step
    public String getTextOfInfoHintOfUserIdField(){
        return InfoHintOfUserIdFieldID.getText();
    }

    @Step
    public String getTextOfInfoHintOfPasswordField(){
        return InfoHintOfUPasswordFieldID.getText();
    }

    @Step
    public void clickOnUserIdField(){
        actionsWithWebElements.buttonClick(UserIdFieldName);
    }

    @Step
    public void clickOnPasswordField(){
        actionsWithWebElements.buttonClick(PasswordFieldName);
    }

    @Step
    public boolean isPresentInfoHintOfUserIdField(){
        return actionsWithWebElements.isElementPresent(InfoHintOfUserIdFieldID);
    }

    @Step
    public boolean isPresentInfoHintOfPasswodField(){
        return actionsWithWebElements.isElementPresent(InfoHintOfUPasswordFieldID);
    }

    @Step
    public void clickOnThePageHeader(){
        actionsWithWebElements.buttonClick(PageHeading);
    }


    @Step
    public boolean isInvalidCredentialAlertPresent(){
        return actionsWithWebElements.isAlertPresent();
    }

    @Step
    public  String getTextFromInvalidCredentialAlertMessage(){
        return actionsWithWebElements.getAlertText();
    }


    @Step
    public void loginQuickly(String login, String password){
        openLoginPage(ConfigData.getConfigValue("base_url"));
        inputLogin(login);
        inputPassword(password);
        clickOnLoginButton();
    }

    @Step
    public void loginQuickly(){
        loginQuickly(ConfigData.getConfigValue("login"), ConfigData.getConfigValue("password"));
    }

    /**
     * Links also is in drop-down menu so that we processed to others page
     * @param linkName
     */
    @Step
    public void clickOnPartiallLink(String linkName){
        for (WebElement link : allLinksTagName){
            if( (link.getText()).equals(linkName) ){
                link.click();
                break;
            }
        }
    }




}