package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class ZltiPage extends ParentPage{
    public ZltiPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "a")
    List<WebElement> Links;


    @Step
    public void openZltipage(){
        driver.navigate().to("http://www.zlti.com");
    }

    @Step




}
