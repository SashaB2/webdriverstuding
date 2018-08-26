package libs;


import org.apache.log4j.Logger;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

import java.io.File;
import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Set;

public class ActionsWithWebElements {

     WebDriver driver;
     Logger log;

    public ActionsWithWebElements(WebDriver driver) {
        this.driver = driver;
        this.log = Logger.getLogger(getClass());
    }

    public String getTextOfElement(WebElement element){
        String string = "";
        try {
            string = element.getText();
        }
        catch (org.openqa.selenium.NoSuchElementException e){
            log.error("Can not find a such element", e);
        }
        catch (Exception e){
            log.error("Error: ", e);
        }

        return string;
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
            log.error("Element Not found: " + e);
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
     * cmd example = (C:\CV\webdriverstuding\drivers\wget\wget.exe -P C:\CV --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe)
     * for Linux: for destination download folder shall be given chmod 777, because deny access
     * @param wgetCommand put main wget command without source download file
     * @param downloadFileURL download url
     *
     */
    public void downloadFile(String wgetCommand, String downloadFileURL){

        try{
            Process execution = Runtime.getRuntime().exec(wgetCommand + " " + downloadFileURL);
            int exitVal = execution.waitFor();

            log.info("Inpt steam");

            //when file does not download then view logs
//            BufferedReader buf1 = new BufferedReader(new InputStreamReader(execution.getInputStream()));
//            String line1 = "";
//            while ((line1 = buf1.readLine()) != null) {
//                log.info("exec response: " + line1);
//            }
        }
        catch (IOException | InterruptedException e){
            log.error("Can't download file of Yahoo", e);
            Assert.fail("Can't download file of Yahoo");
        }
    }


    public boolean ifFilePresent(String locationFile){
        File file = new File(locationFile);
        return file.exists();
    }

    public void deleteFile(String locationFile){
        File file = new File(locationFile);


        if(file.exists()){
            file.delete();
        }

    }

    //Popup window

    public void switchToPopupWindow(){
        String currentWindowId;
        Set<String> windowsSet = null;

        try{
            currentWindowId = driver.getWindowHandle();
            windowsSet = driver.getWindowHandles();

            for (String windowId : windowsSet) {

                if(!currentWindowId.equalsIgnoreCase(windowId)){
                    driver.switchTo().window(windowId);
                }
            }
        }
        catch (NoSuchWindowException e){
            log.error("Do not find out window", e);
        }
        catch (Exception e){
            log.error("Error with switch to popup", e);
        }
    }


    //Broken links

    /**
     * check is links are either good or broken
     * @param pageUrl set page url
     * @param elements set list of all element
     */
    public void checkBrokenLinks(String pageUrl, List<WebElement> elements ){
        HttpURLConnection httpURLConnection = null;
        String url = "";
        int responceCode;

        for (WebElement element: elements) {
            url = element.getAttribute("href");

            if(url == null || url.isEmpty()){
                log.error("This url is either not configure or empty. URL text: " + element.getText());
                continue;
            }

            if(!url.startsWith(pageUrl)){
                log.trace("This url belongs to another domain. URL text: " + element.getText());
                continue;
            }

            try{
                httpURLConnection = (HttpURLConnection)(new URL(url).openConnection());
                httpURLConnection.setRequestMethod("HEAD");
                httpURLConnection.connect();
                responceCode = httpURLConnection.getResponseCode();

                if(responceCode >= 400){
                    log.error("This url is broken. Url text: " + element.getText());
                }
            }
            catch (MalformedURLException e){
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }


        }

    }

}
