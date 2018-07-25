package pages.datepickerpages;

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
    WebElement PageHeaderTagName;

    @FindBy(name = "bdaytime")
    WebElement dataPickerName;

    @FindBy(xpath = "//input[@type='submit']")
    WebElement SubmitButtonXpath;

    public String PageHeader(){
        return PageHeaderTagName.getText();
    }

    public void inputDateTimeIntoDataPicker(String dateValue, String timeValue){
        dataPickerName.sendKeys(dateValue);
        dataPickerName.sendKeys(Keys.TAB);
        dataPickerName.sendKeys(timeValue);
    }

    public void clickOnSubmitButton(){
        SubmitButtonXpath.click();
    }


}
