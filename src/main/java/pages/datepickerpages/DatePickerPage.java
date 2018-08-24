package pages.datepickerpages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class DatePickerPage extends ParentPage {

    public DatePickerPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h3")
    WebElement PageHeaderTagName;

    @FindBy(name = "bdaytime")
    WebElement dataPickerName;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement SubmitButtonXpath;

    public String headerOfBirthDateDemoPage(){
        return PageHeaderTagName.getText();
    }

    public void inputDateIntoDataPicker(String dateValue){
        dataPickerName.sendKeys(dateValue);
    }

    public void inputTimeIntoDataPicker(String timeValue){
        dataPickerName.sendKeys(timeValue);
    }

    public void clickOnTabButton(CharSequence key){
        dataPickerName.sendKeys(key);
    }

    public void clickOnSubmitButton(){
        SubmitButtonXpath.click();
    }


}
