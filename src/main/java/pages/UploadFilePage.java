package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends ParentPage {
    public UploadFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "photoimg")
    WebElement UploadInputButtonID;

    @FindBy(tagName = "h4")
    WebElement successfulUploadFileInfoTagname;

    public void openUploadFilePage(){
        driver.navigate().to("http://demo.guru99.com/test/image_upload/index.php");
    }

    public void sendFileToDownload(String fullFilePath){
        actionsWithWebElements.inputValueInField(UploadInputButtonID, fullFilePath);
    }

    public String getValueOfSuccessfulUploadFileInfo(){
        return successfulUploadFileInfoTagname.getText();
    }
}
