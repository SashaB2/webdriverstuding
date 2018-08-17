package pages.mercurytourspages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class MercuryRegisterPage extends ParentPage {
    public MercuryRegisterPage(WebDriver driver) {
        super(driver);
    }

    //Contact information

    @FindBy(name = "firstName")
    WebElement FirstNameName;

    @FindBy(name = "lastName")
    WebElement LastNameName;

    @FindBy(name = "phone")
    WebElement PhoneName;

    @FindBy(id = "userName")
    WebElement EmailID;

    //Mailing Information

    @FindBy(name = "address1")
    WebElement AddressName;

    @FindBy(name = "city")
    WebElement CityName;

    @FindBy(name = "state")
    WebElement StateName;

    @FindBy(name = "postalCode")
    WebElement PostCodeName;

    @FindBy(name = "country")
    WebElement CountryDropDownName;

    //User Information

    @FindBy(id = "email")
    WebElement UserNameID;

    @FindBy(name = "password")
    WebElement UserPasswordName;

    @FindBy(name = "confirmPassword")
    WebElement UserConfirmPasswordName;

    @FindBy(name = "submit")
    WebElement SubmitButtonName;

    @Step
    public void openRegisterPage() {
        driver.navigate().to("http://demo.guru99.com/test/newtours/register.php");
    }

    //Contact information

    @Step
    public void inputFirstName(String value) {
        actionsWithWebElements.inputValueInField(FirstNameName, value);
    }

    @Step
    public void inputLastName(String value) {
        actionsWithWebElements.inputValueInField(LastNameName, value);
    }

    @Step
    public void inputPhoneNumber(String value) {
        actionsWithWebElements.inputValueInField(PhoneName, value);
    }

    @Step
    public void inputEmail(String value) {
        actionsWithWebElements.inputValueInField(EmailID, value);
    }

    //Mailing Information

    @Step
    public void inputAddress(String value) {
        actionsWithWebElements.inputValueInField(AddressName, value);
    }

    @Step
    public void inputCity(String value) {
        actionsWithWebElements.inputValueInField(CityName, value);
    }

    @Step
    public void inputState(String value) {
        actionsWithWebElements.inputValueInField(StateName, value);
    }

    @Step
    public void inputPostCode(String value) {
        actionsWithWebElements.inputValueInField(PostCodeName, value);
    }

    @Step
    public void chooseCountry(String option) {
        actionsWithWebElements.selectItemInDropDownByVisibleText(CountryDropDownName, option);
    }

    //User Information

    @Step
    public void inputUserName(String value) {
        actionsWithWebElements.inputValueInField(UserNameID, value);
    }

    @Step
    public void inputUserPassword(String value) {
        actionsWithWebElements.inputValueInField(UserPasswordName, value);
    }

    @Step
    public void inputConfirmPassword(String value) {
        actionsWithWebElements.inputValueInField(UserConfirmPasswordName, value);
    }

    @Step
    public void clickOnSubmitButton(){
        actionsWithWebElements.buttonClick(SubmitButtonName);
    }

}
