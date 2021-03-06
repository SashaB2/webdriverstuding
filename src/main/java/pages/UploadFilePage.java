package pages;

import io.qameta.allure.Step;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class UploadFilePage extends ParentPage {
    public UploadFilePage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "photoimg")
    private WebElement UploadInputButtonID;

    @FindBy(tagName = "h4")
    private WebElement successfulUploadFileInfoTagname;

    @Step
    public void openUploadFilePage(){
        driver.navigate().to("http://demo.guru99.com/test/image_upload/index.php");
    }

    @Step
    public void sendFileToDownload(String fullFilePath){
        actionsWithWebElements.inputValueInField(UploadInputButtonID, fullFilePath);
    }

    @Step
    public String getValueOfSuccessfulUploadFileInfo(){
        return successfulUploadFileInfoTagname.getText();
    }
}
