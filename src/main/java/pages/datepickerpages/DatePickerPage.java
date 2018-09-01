package pages.datepickerpages;

import io.qameta.allure.Step;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class DatePickerPage extends ParentPage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    private WebElement PageHeaderTagName;

    @FindBy(name = "bdaytime")
    private WebElement dataPickerName;

    @FindBy(xpath = "//input[@type='submit']")
    private WebElement SubmitButtonXpath;

    @Step
    public String headerOfBirthDateDemoPage(){
        return PageHeaderTagName.getText();
    }

    @Step
    public void inputDateIntoDataPicker(String dateValue){
        dataPickerName.sendKeys(dateValue);
    }

    @Step
    public void inputTimeIntoDataPicker(String timeValue){
        dataPickerName.sendKeys(timeValue);
    }

    @Step
    public void clickOnTabButton(CharSequence key){
        dataPickerName.sendKeys(key);
    }

    @Step
    public void clickOnSubmitButton(){
        SubmitButtonXpath.click();
    }


}
