package pages.uploadanddownload;

import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.sikuli.script.FindFailed;
import org.sikuli.script.Pattern;
import org.sikuli.script.Screen;
import pages.ParentPage;

public class FileUploadSikuliPage extends ParentPage{

    public FileUploadSikuliPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "photoimg")
    WebElement uploadField;

    @FindBy(tagName = "h4")
    WebElement resultHeadingOfUploadFile;

    public void clickOnChooseFileButton(){
        actionsWithWebElements.buttonClick(uploadField);
    }

    public void handleWithUploadFile(){
        String filePath = ConfigData.getConfigValue("FILE_PATH");
        String inputFileName = "C:\\CV\\webdriverstuding\\src\\main\\java\\data\\testimage.jpg";
        Screen screen = new Screen();
        Pattern fileInputTextBox = new Pattern(filePath + "fileTextBox.png");
        Pattern openButton = new Pattern(filePath + "fileOpenButton.png");

        try {
            screen.wait(fileInputTextBox, 20);
            screen.type(fileInputTextBox, inputFileName);
            screen.click(openButton);
        }catch (FindFailed e){
            log.error("Cannot find element with sikuri", e);
        }
    }

    public String resultOfUploadFile(){
        return resultHeadingOfUploadFile.getText();
    }
}
