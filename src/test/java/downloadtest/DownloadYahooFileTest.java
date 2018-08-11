package downloadtest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ConfigData;
import org.junit.Test;
import parenttest.ParentTest;

import java.io.IOException;

public class DownloadYahooFileTest extends ParentTest {

    public DownloadYahooFileTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Open Yahoo download page")
    @Severity(SeverityLevel.CRITICAL)
    public void downloadFileOfYahoo() throws IOException {
        log.info("Start to verify download file of Yahoo download page");
        fileDownloadPage.navigateToYahooDownloadPage();
        checkAcceptanceCriteria("Yahoo download page has not benn opened", fileDownloadPage.getPageTitle(), "Selenium WebDriver Test");

//        verify if file present of a previous case and delete the file if it exists
        if(fileDownloadPage.doesDownloadedFilePresent(ConfigData.getConfigValue("downloadFileLocation"))){
            fileDownloadPage.deleteDownloadedFile(ConfigData.getConfigValue("downloadFileLocation"));
        }

        //download file
        fileDownloadPage.downloadFileFromYahooPage(ConfigData.getConfigValue("wgetDownloadFileYahoo"));
//        checkAcceptanceCriteria("File has not been downloaded", fileDownloadPage.doesDownloadedFilePresent(ConfigData.getConfigValue("downloadFileLocation")), true);

//        delete download file
//        fileDownloadPage.deleteDownloadedFile(ConfigData.getConfigValue("downloadFileLocation"));


    }
}
