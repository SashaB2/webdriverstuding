package libs;


import org.apache.http.util.Asserts;
import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.NoSuchElementException;

public class ActionsWithWebElements {

     WebDriver driver;
     Logger log;

    public ActionsWithWebElements(WebDriver driver) {
        this.driver = driver;
        this.log = Logger.getLogger(getClass());
    }

    /**
     * refresh window
     */
    public void refreshWindow(){
       driver.navigate().refresh();
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

    public boolean isAlertPresent(){

        try{
            driver.switchTo().alert();
            return true;
        }
        catch (NoAlertPresentException e){
            return false;
        }

    }
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


    //Drag and drop functionality

    /**
     * Drag lement from to
     * @param from element that need to drag
     * @param to place where need o drop element
     */
    public void dragFromTo(WebElement from, WebElement to){
        Actions act = new Actions(driver);
        try {
            act.dragAndDrop(from, to).build().perform();
        }
        catch (Exception e){
            log.error("Element in drag and drop is not found From Exception", e);
            Assert.fail("Element in drag and drop is not found From Exception");
        }
    }


    //download functionality

    /**
     *
     * @param element take from this element source for downloading file
     * @param wgetCommand put main wget command without source download file
     * cmd example = (C:\CV\webdriverstuding\drivers\wget\wget.exe -P C:\CV --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe)
     */
    public void downloadFile(WebElement element, String wgetCommand){
        String sourceLocation = element.getAttribute("href");
        try{
            Process execution = Runtime.getRuntime().exec(wgetCommand + " " + sourceLocation);
            int exitVal = execution.waitFor();
        }
        catch (IOException e){
            log.error("Can't download file of Yahoo", e);
            Assert.fail("Can't download file of Yahoo");
        }
        catch (InterruptedException e){
            log.error("Can't download file of Yahoo", e);
            Assert.fail("Can't download file of Yahoo");
        }
    }

    public boolean ifFilePresent(String location, String fileName){
        File file = new File(location + fileName);
        return file.exists();
    }

    public void deleteFile(String location, String fileName){
        File file = new File(location + fileName);
        Boolean result = false;

        if(file.exists()){
            result = file.delete();
        }

        if(result){
            log.info("File deleted: " + fileName);
        }else{
            log.info("File did not deleted: " + fileName);
        }
    }


}
