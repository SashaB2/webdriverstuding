package pages.autherification;

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

    @FindBy(xpath = "//div/img[@class='img-circle']")
    WebElement avatarXpath;

    @FindBy(xpath = "//li[@id='dictionary']/a[//child::i]")
    WebElement SlovariXpath;

    @FindBy(xpath = "//li[@id='apparat']/a")
    WebElement AparatXpath;

    @FindBy(xpath = "//h3[@class='box-title']")
    WebElement headerContentXpath;

    @FindBy(xpath = "//div[@class='box-body']//div[@class='box-body']/p")
    List<WebElement> contentElementXpath;

//    public String getMainPageHeading(){
//
//        try {
//            return PageHeading.getText();
//        }
//        catch (Exception e){
//            return null;
//        }
//    }

    public boolean doesAvatarPresent(){
        return actionsWithWebElements.isElementPresent(avatarXpath);
    }

    public void openSlovariList(){

        actionsWithWebElements.buttonClick(SlovariXpath);

    }

    public void openAparatPage(){

        actionsWithWebElements.buttonClick(AparatXpath);

    }

    public boolean HeaderContent(String excelFileName, String sheetName,String key){

        return headerContentXpath.getText().equals(ExcelData.getData(excelFileName, sheetName).get(key));

    }

    public HashMap<String, Boolean> paragraphContent(String excelFileName, String sheetName){

        HashMap<String, Boolean> testResult = new HashMap<String, Boolean>();

        String contentValue = null;

        boolean coincidence;

            for (WebElement element : contentElementXpath) {
                contentValue = element.getText();
                coincidence = ExcelData.getData(excelFileName, sheetName).containsValue(contentValue);
                testResult.put(contentValue, coincidence);
            }

        return testResult;

    }



}
