package downloadtest;

import libs.ConfigData;
import libs.ExcelData;
import org.junit.Test;
import org.openqa.selenium.By;
import parenttest.ParentTest;

public class UploadFileTest extends ParentTest {
    public UploadFileTest(String browser) {
        super(browser);
    }

    @Test
    public void uploadFileTest(){
        log.info("Start testing to upload file via Selenium functionality");
        uploadFilePage.openUploadFilePage();
        checkAcceptanceCriteria("Ypload file page does not open", uploadFilePage.getPageTitle(), "File Upload using Sikuli");

        uploadFilePage.sendFileToDownload(ConfigData.getConfigValue("UploadFilePFullPath"));
        checkAcceptanceCriteria("File has been upload unsuccesfully", uploadFilePage.getValueOfSuccessfulUploadFileInfo(), ExcelData.getData("uploadFilePage").get("successfulUploadFileInfo"));
    }
}
