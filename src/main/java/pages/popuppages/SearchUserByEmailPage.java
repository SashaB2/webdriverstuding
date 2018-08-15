package pages.popuppages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

import java.util.Iterator;
import java.util.Set;

public class SearchUserByEmailPage extends ParentPage{

    public SearchUserByEmailPage(WebDriver driver) {
        super(driver);
    }
    
    @FindBy(xpath = "//table//h2")
    WebElement tableHeadingXpath;

    @FindBy(name = "emailid")
    WebElement EmailIdFieldName;

    @FindBy(id = "message9")
    WebElement ErrorLabelID;

    @FindBy(name = "btnLogin")
    WebElement SubmitButtonID;

    public String getHeadingOfPage(){
        return actionsWithWebElements.getTextOfElement(tableHeadingXpath);
    }







    public void switchToNewWindow(){
        String mainWindow = driver.getWindowHandle();
        Set<String> windows = driver.getWindowHandles();
        Iterator<String> iterator = windows.iterator();




        while(iterator.hasNext()){
            String childWindow = iterator.next();

            if(!mainWindow.equalsIgnoreCase(childWindow)){
                driver.switchTo().window(childWindow);

                actionsWithWebElements.inputValueInField(EmailIdFieldName, "sviridenko1@gmail.com");
                actionsWithWebElements.buttonClick(SubmitButtonID);
            }
        }
    }
}
