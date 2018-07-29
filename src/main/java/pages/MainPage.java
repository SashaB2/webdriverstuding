package pages;

import libs.ExcelData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.HashMap;
import java.util.List;

public class MainPage extends ParentPage {

    public MainPage(WebDriver driver){
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> allLinksTagName;

    /**
     * Links also is in drop-down menu so that we processed to others page
     * @param linkName
     */
    public void clickOnPartiallLink(String linkName){
        for (WebElement link : allLinksTagName){
            if( (link.getText()).equals(linkName) ){
                link.click();
                break;
            }
        }
    }

}
