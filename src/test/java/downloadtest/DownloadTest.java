package downloadtest;

import org.junit.Test;
import parenttest.ParentTest;

public class DownloadTest extends ParentTest {

    public DownloadTest(String browser) {
        super(browser);
    }

    @Test
    public void downloadFileOfYahoo(){
        log.trace("Open Yahoo download page");
        fileDownloadPage.navigateToYahooDownloadPage();
        checkAcceptanceCriteria("Yahoo download page has not benn opened", "Selenium WebDriver Test", fileDownloadPage.getPageTitle());

        //verify if file present of previous case text and delete the file if it exists
        if(fileDownloadPage.doesDownloadedFilePresent()){
            fileDownloadPage.deleteDownloadedFile();
        }

        //download file
        log.trace("Download file of Yahoo download page");
        fileDownloadPage.downloadFileFromYahooPage();
        checkAcceptanceCriteria("File has not been downloaded", true, fileDownloadPage.doesDownloadedFilePresent());

        //delete download file
        log.trace("Delete file of Yahoo download page");
        fileDownloadPage.deleteDownloadedFile();


    }
}