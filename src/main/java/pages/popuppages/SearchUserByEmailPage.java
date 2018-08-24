package pages.popuppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class SearchUserByEmailPage extends ParentPage{

    public SearchUserByEmailPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//table//h2")
    WebElement TableHeadingXpath;

    @FindBy(name = "emailid")
    WebElement EmailIdFieldName;

    @FindBy(id = "message9")
    WebElement ErrorLabelID;

    @FindBy(name = "btnLogin")
    WebElement SubmitButtonID;

    public String getHeadingOfPage(){
        return actionsWithWebElements.getTextOfElement(TableHeadingXpath);
    }

    public void inputUserEmail(String userEmail){
        actionsWithWebElements.inputValueInField(EmailIdFieldName, userEmail);
    }

    public void clickOnSubmitButton(){
        actionsWithWebElements.buttonClick(SubmitButtonID);
    }

    public String getTextOfErrorLable(){
        return actionsWithWebElements.getTextOfElement(ErrorLabelID);
    }

}
