package pages.gurubank;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class NewCustomerPage extends ParentPage {

    public NewCustomerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(xpath = "//tbody//p[@class='heading3']")
    WebElement AddNewCustoerHeadingXpath;

    @FindBy(name = "name")
    WebElement CustomerNameInputFieldName;

    @FindBy(xpath = "//input[@name='rad1' and @value='m']")
    WebElement MaleRadioButtonXpath;

    @FindBy(xpath = "//input[@name='rad1' and @value='f']")
    WebElement FemaleRadioButtonXpath;

    @FindBy(id = "dob")
    WebElement DateOfBirthdayDatePickerId;

    @FindBy(name = "addr")
    WebElement AddressAreaName;

    @FindBy(name = "city")
    WebElement CityInputFieldName;

    @FindBy(name = "state")
    WebElement StateInputFieldName;

    @FindBy(name = "pinno")
    WebElement PINInputFieldName;

    @FindBy(name = "telephoneno")
    WebElement MobileNumberInputFieldName;

    @FindBy(name = "emailid")
    WebElement EmailInputFieldName;

    @FindBy(name = "password")
    WebElement PasswordInputFieldName;

    @FindBy(name = "sub")
    WebElement SubmitIButtonName;

    @FindBy(name = "res")
    WebElement ResetIButtonName;


    public void inputCustomerName(String customerName){
        actionsWithWebElements.inputValueInField(CustomerNameInputFieldName, customerName);
    }

    public void selectCustomerGender(String gender){
        if(gender.equals("male")){
            actionsWithWebElements.SelectCheckbox(MaleRadioButtonXpath, true);
        }
        else if(gender.equals("female")){
            actionsWithWebElements.SelectCheckbox(FemaleRadioButtonXpath, true);
        }
    }

    public void inputCustomerDateOfBirthday(String customerDateOfBirthday){
        actionsWithWebElements.inputValueInField(DateOfBirthdayDatePickerId, customerDateOfBirthday);
    }

    public void inputCustomerAddress(String customerAddress){
        actionsWithWebElements.inputValueInField(AddressAreaName, customerAddress);
    }

    public void inputCustomerCity(String customerCity){
        actionsWithWebElements.inputValueInField(CityInputFieldName, customerCity);
    }

    public void inputCustomerState(String customerState){
        actionsWithWebElements.inputValueInField(StateInputFieldName, customerState);
    }

    public void inputCustomerPIN(String customerPIN){
        actionsWithWebElements.inputValueInField(PINInputFieldName, customerPIN);
    }

    public void inputCustomerMobileNumber(String customerMobileNumber){
        actionsWithWebElements.inputValueInField(MobileNumberInputFieldName, customerMobileNumber);
    }

    public void inputCustomerEmail(String customerEmail){
        actionsWithWebElements.inputValueInField(EmailInputFieldName, customerEmail);
    }

    public void inputCustomerPassword(String customerPassword){
        actionsWithWebElements.inputValueInField(PasswordInputFieldName, customerPassword);
    }

    public void clickOnSubmitButton(){
        actionsWithWebElements.buttonClick(SubmitIButtonName);
    }

    public void clickOnResetButton(){
        actionsWithWebElements.buttonClick(ResetIButtonName);
    }
}
