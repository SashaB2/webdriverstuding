package pages;

import io.qameta.allure.Step;
import org.apache.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import libs.ActionsWithWebElements;

public class ParentPage {

    public WebDriver driver;
    public Logger log;
    public ActionsWithWebElements actionsWithWebElements;

    public ParentPage(WebDriver driver){
        this.driver = driver;
        this.log = Logger.getLogger(getClass());
        this.actionsWithWebElements = new ActionsWithWebElements(driver);
        PageFactory.initElements(driver, this);
    }

    @FindBy(tagName = "h2")
    WebElement PageHeading;

    @Step
    public String getPageURL(){
        return driver.getCurrentUrl();
    }

    //all pages has heading
    @Step
    public String getValueFromHeading(){
        return PageHeading.getText();
    }

    @Step
    public String getPageTitle(){
        return driver.getTitle();
    }

    @Step
    public void refreshWindow(){
        actionsWithWebElements.refreshWindow();
    }

}