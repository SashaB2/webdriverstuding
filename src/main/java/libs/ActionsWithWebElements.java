package libs;


import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.util.List;

public class ActionsWithWebElements {

     WebDriver driver;
     Logger log;

    public ActionsWithWebElements(WebDriver driver){
        this.driver = driver;
        this.log = Logger.getLogger(getClass());
    }

    /**
     * click on button
     * @param element
     */
    public void buttonClick(WebElement element){

        try{
            element.click();
        }
        catch (Exception e){
            log.error("Not found " + element);
        }
    }

    /**
     * input value in field
     * @param element
     * @param value
     */
    public void inputValueInField(WebElement element, String value){

        try{
            element.clear();
            element.sendKeys(value);
        }catch (Exception e){
            log.error("Not found " + element);
        }

    }

    /**
     * get page title from header in HTML
     * @return
     */
    public String getPageTitle(){

            return driver.getTitle();
    }

    /**
     * if elment present on page
     * @param element
     * @return
     */
    public boolean isElementPresent(WebElement element){

            return element.isDisplayed() && element.isEnabled();
    }

    public void moveCusorOn(WebElement element){

        try {
            Actions builder = new Actions(driver);
            builder.moveToElement(element).clickAndHold().perform();
        }
        catch (Exception e){
            log.error("Error: ", e);
        }
    }

    /**
     * This method checks or unchecks the checkbox
     *
     * @param element
     * @param neededState
     */
    public void SelectCheckbox(WebElement element, boolean neededState) {
        try {
            if ((element.isSelected() && !neededState) || (!element.isSelected()) && neededState) {
                element.click();
            }
        } catch (Exception e) {
            log.error("Error" + e);
        }
    }

    /**
     * This method selects visible elementDD from Drop Down list by value - valueForSelect
     *
     * @param elementDD
     * @param vallueForSelect
     */
    public void selectItemInDropDownByValue(WebElement elementDD, String vallueForSelect) {
        try {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.deselectByValue(vallueForSelect);
            log.info(vallueForSelect + " was selected DD");
        } catch (Exception e) {
            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * This method selects visible elementDD from Drop Down list by text - textForSelect
     *
     * @param elementDD
     * @param textForSelect
     */
    public void selectItemInDropDownByVisibleText(WebElement elementDD, String textForSelect) {
        try {
            Select optionFromDD = new Select(elementDD);
            optionFromDD.selectByVisibleText(textForSelect);
            log.info(textForSelect + " was selected DD");
        } catch (Exception e) {
            log.error("Cannot work with element");
            Assert.fail("Cannot work with element");
        }
    }

    /**
     * this method checks the presence of two webelements with known text inside them
     * @param elementNum
     * @param elementCom
     * @param num
     * @param com
     * @return
     */
    public boolean areTwoElementPresent(WebElement elementNum, WebElement elementCom, String num, String com){
        return ((num.equalsIgnoreCase(elementNum.getText()))&&(com.equalsIgnoreCase(elementCom.getText())));
    }

    /**
     * get amount of rows
     */
    public int amountRows(List<WebElement> elements){
        return elements.size();
    }

    /**
     * get amount of columns
     */
    public int amountColumns(List<WebElement> elements){
        return elements.size();
    }

    //Alert functional
    /**
     * alert action
     */
    public void alertActions(Boolean action){

        Alert alert;

        try {
            alert = driver.switchTo().alert();

            if(action){
                alert.accept();
            }
            else{
                alert.dismiss();
            }

        }
        catch (NoAlertPresentException e){
        log.error(e);
        Assert.fail("Alert window do not opened");
    }

    }

    /**
     * get text of alert
     */
    public String getAlertText (){

        Alert alert;

        try {
            alert = driver.switchTo().alert();
            return alert.getText();

        }catch (NoAlertPresentException e){
            log.error(e);
            Assert.fail("Alert window do not opened");
        }

        return "";

    }

    /**
     * input text on alert field
     * @param value string value which will be inputted in a alert field
     */
    public void alertInputText (String value){

        Alert alert;

        try {
            alert = driver.switchTo().alert();
            alert.sendKeys(value);

        }catch (NoAlertPresentException e){
            log.error(e);
            Assert.fail("Alert window do not opened");
        }

    }


}
