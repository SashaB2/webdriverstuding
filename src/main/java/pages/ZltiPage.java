package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;

public class ZltiPage extends ParentPage{
    public ZltiPage(WebDriver driver) {
        super(driver);
    }

    final String pageUrl = "http://www.zlti.com";

    @FindBy(tagName = "a")
    private List<WebElement> Links;


    @Step
    public void openZltipage(){
        driver.navigate().to(pageUrl);
    }

    @Step
    public void checkLinksOnZltiPage(){
        actionsWithWebElements.checkBrokenLinks(pageUrl, Links);
    }




}
