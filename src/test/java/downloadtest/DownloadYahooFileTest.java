package downloadtest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.ConfigData;
import libs.Global;
import org.junit.Test;
import org.openqa.selenium.Platform;
import pages.Main;
import parenttest.ParentTest;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class DownloadYahooFileTest extends ParentTest {

    public DownloadYahooFileTest(String browser) {
        super(browser);
    }

    @Test
    @Description("Open Yahoo download page")
    @Severity(SeverityLevel.CRITICAL)
    public void downloadFileOfYahoo() throws IOException {
//        log.info("Start to verify download file of Yahoo download page");
//        fileDownloadPage.navigateToYahooDownloadPage();
//        checkAcceptanceCriteria("Yahoo download page has not benn opened", fileDownloadPage.getPageTitle(), "Selenium WebDriver Test");

//        verify if file present of a previous case and delete the file if it exists
//        if(fileDownloadPage.doesDownloadedFilePresent(ConfigData.getConfigValue("downloadFileLocation"))){
//            fileDownloadPage.deleteDownloadedFile(ConfigData.getConfigValue("downloadFileLocation"));
//        }
//        log.info(ConfigData.getConfigValue("wgetDownloadFileYahoo"));
        //download file
//        Process execution = Runtime.getRuntime().exec("wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe");
        try {
            Runtime runtime = Runtime.getRuntime();
            Process process = runtime.exec(new String[] { "/bin/bash", "-c", "wget -P /home --no-check-certificate http://demo.guru99.com/test/msgr11us.exe" });
            int exitValue = process.waitFor();
            System.out.println("exit value: " + exitValue);
            BufferedReader buf = new BufferedReader(new InputStreamReader(process.getInputStream()));
            String line = "";
            while ((line = buf.readLine()) != null) {
                System.out.println("exec response: " + line);
            }
        } catch (Exception e) {
            System.out.println(e);
        }
//        Main.runLinCom();
//        fileDownloadPage.downloadFileFromYahooPage(ConfigData.getConfigValue("wgetDownloadFileYahoo"));
//        checkAcceptanceCriteria("File has not been downloaded", fileDownloadPage.doesDownloadedFilePresent(ConfigData.getConfigValue("downloadFileLocation")), true);

//        delete download file
//        fileDownloadPage.deleteDownloadedFile(ConfigData.getConfigValue("downloadFileLocation"));


    }
}
