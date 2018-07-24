package pages.autherification;

import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

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

    public String getTextFromInvalidPasswordAlertMessage(){
        return actionsWithWebElements.getAlertText();
    }


    public void loginQuickly(String login, String password){
        openLoginPage(ConfigData.getConfigValue("base_url"));
        inputLogin(login);
        inputPassword(password);
        clickOnLoginButton();
    }





//    @FindBy(xpath = "//input[@name='_username']")
//    WebElement InputFieldXpath;
//
//    @FindBy(id = "password")
//    WebElement PasswordFieldId;
//
//    @FindBy(xpath = "//button[@type='submit']")
//    WebElement SubmitButtonXpath;
//
//    public void openLoginPage(){
//
//        try {
//        driver.get(ConfigData.getConfigValue("base_url"));
//        }
//        catch (Exception e){
//            e.printStackTrace();
//        }
//
//    }
//
//    public String getLoginPageTitle(){
//
//            try {
//                return actionsWithWebElements.getPageTitle();
//            }
//            catch (Exception e){
//                return null;
//            }
//
//    }
//
//    public void inputLogin(String login){
//        actionsWithWebElements.inputValueInField(InputFieldXpath, login);
//    }
//
//    public void inputPassword(String password){
//        actionsWithWebElements.inputValueInField(PasswordFieldId, password);
//    }
//
//    public void clickOnsubmitButton(){
//        actionsWithWebElements.buttonClick(SubmitButtonXpath);
//    }
//
//    /**
//     * Quckly login
//     * @param login
//     * @param password
//     */
//    public void loginQuick(String login, String password){
//        openLoginPage();
//        inputLogin(login);
//        inputPassword(password);
//        clickOnsubmitButton();
//    }
//
//    /**
//     * login quickly without parameters
//     */
//    public void loginQuick(){
//        openLoginPage();
//        inputLogin(ConfigData.getConfigValue("login"));
//        inputPassword(ConfigData.getConfigValue("password"));
//        clickOnsubmitButton();
//    }



}