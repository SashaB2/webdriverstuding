package downloadtest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import org.junit.Test;
import parenttest.ParentTest;

public class DownloadTest extends ParentTest {

    public DownloadTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Open Yahoo download page")
    @Severity(SeverityLevel.CRITICAL)
    public void downloadFileOfYahoo(){
        log.info("Start to verify download file of Yahoo download page");
        fileDownloadPage.navigateToYahooDownloadPage();
        checkAcceptanceCriteria("Yahoo download page has not benn opened", fileDownloadPage.getPageTitle(), "Selenium WebDriver Test");

        //verify if file present of previous case text and delete the file if it exists
        if(fileDownloadPage.doesDownloadedFilePresent()){
            fileDownloadPage.deleteDownloadedFile();
        }

        //download file
        fileDownloadPage.downloadFileFromYahooPage();
        checkAcceptanceCriteria("File has not been downloaded", fileDownloadPage.doesDownloadedFilePresent(), true);

        //delete download file
        fileDownloadPage.deleteDownloadedFile();


    }
}
