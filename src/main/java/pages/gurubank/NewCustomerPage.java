package pages.gurubank;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class NewCustomerPage extends ParentPage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody//p[@class='heading3']")
    private WebElement AddNewCustoerHeadingXpath;

    @FindBy(name = "name")
    private WebElement CustomerNameInputFieldName;

    @FindBy(xpath = "//input[@name='rad1' and @value='m']")
    private WebElement MaleRadioButtonXpath;

    @FindBy(xpath = "//input[@name='rad1' and @value='f']")
    private WebElement FemaleRadioButtonXpath;

    @FindBy(id = "dob")
    private WebElement DateOfBirthdayDatePickerId;

    @FindBy(name = "addr")
    private WebElement AddressAreaName;

    @FindBy(name = "city")
    private WebElement CityInputFieldName;

    @FindBy(name = "state")
    private WebElement StateInputFieldName;

    @FindBy(name = "pinno")
    private WebElement PINInputFieldName;

    @FindBy(name = "telephoneno")
    private WebElement MobileNumberInputFieldName;

    @FindBy(name = "emailid")
    private WebElement EmailInputFieldName;

    @FindBy(name = "password")
    private WebElement PasswordInputFieldName;

    @FindBy(name = "sub")
    private WebElement SubmitIButtonName;

    @FindBy(name = "res")
    private WebElement ResetIButtonName;

    @Step
    public void inputCustomerName(String customerName){
        actionsWithWebElements.inputValueInField(CustomerNameInputFieldName, customerName);
    }

    @Step
    public void selectCustomerGender(String gender){
        if(gender.equals("male")){
            actionsWithWebElements.SelectCheckbox(MaleRadioButtonXpath, true);
        }
        else if(gender.equals("female")){
            actionsWithWebElements.SelectCheckbox(FemaleRadioButtonXpath, true);
        }
    }

    @Step
    public void inputCustomerDateOfBirthday(String customerDateOfBirthday){
        actionsWithWebElements.inputValueInField(DateOfBirthdayDatePickerId, customerDateOfBirthday);
    }

    @Step
    public void inputCustomerAddress(String customerAddress){
        actionsWithWebElements.inputValueInField(AddressAreaName, customerAddress);
    }

    @Step
    public void inputCustomerCity(String customerCity){
        actionsWithWebElements.inputValueInField(CityInputFieldName, customerCity);
    }

    @Step
    public void inputCustomerState(String customerState){
        actionsWithWebElements.inputValueInField(StateInputFieldName, customerState);
    }

    @Step
    public void inputCustomerPIN(String customerPIN){
        actionsWithWebElements.inputValueInField(PINInputFieldName, customerPIN);
    }

    @Step
    public void inputCustomerMobileNumber(String customerMobileNumber){
        actionsWithWebElements.inputValueInField(MobileNumberInputFieldName, customerMobileNumber);
    }

    @Step
    public void inputCustomerEmail(String customerEmail){
        actionsWithWebElements.inputValueInField(EmailInputFieldName, customerEmail);
    }

    @Step
    public void inputCustomerPassword(String customerPassword){
        actionsWithWebElements.inputValueInField(PasswordInputFieldName, customerPassword);
    }

    @Step
    public void clickOnSubmitButton(){
        actionsWithWebElements.buttonClick(SubmitIButtonName);
    }

    @Step
    public void clickOnResetButton(){
        actionsWithWebElements.buttonClick(ResetIButtonName);
    }
}
