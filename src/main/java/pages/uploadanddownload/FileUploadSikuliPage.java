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
        String configImageFilePath = ConfigData.getConfigValue("CONFIG_IMAGE_FILE_PATH");
        log.info(configImageFilePath);

        String testFilePath = ConfigData.getConfigValue("TEST_FILE_PATH");
        log.info(testFilePath);

        Screen screen = new Screen();
        Pattern fileInputTextBox = new Pattern(configImageFilePath + "fileTextBox.png");
        Pattern openButton = new Pattern(configImageFilePath + "fileOpenButton.png");

        try {
            screen.wait(fileInputTextBox, 20);
            screen.type(fileInputTextBox, testFilePath);
            screen.click(openButton);
        }catch (FindFailed e){
            log.error("Cannot find element with sikuri", e);
        }
    }

    public String resultOfUploadFile(){
        return resultHeadingOfUploadFile.getText();
    }
}
