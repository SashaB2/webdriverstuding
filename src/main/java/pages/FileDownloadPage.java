package pages;

import libs.ConfigData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class FileDownloadPage extends ParentPage {

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "messenger-download")
    WebElement DownloadLinkId;

    public void navigateToYahooDownloadPage(){
        driver.navigate().to(ConfigData.getConfigValue("YAHOO_DOWNLOAD_FILE"));
    }

    /**
     * input file location + file name
     * @param downloadFileLocation
     * @return
     */
    public boolean doesDownloadedFilePresent(String downloadFileLocation){
        return actionsWithWebElements.ifFilePresent(downloadFileLocation);
    }

    public void deleteDownloadedFile(String downloadFileLocation){
        actionsWithWebElements.deleteFile(downloadFileLocation);
    }

    /**
     * give execution path for wget + "-P" + file download destination + "--no-check-certificates" + method itself take value of attribute href and put download source
     * "-P" - after we put download destination
     * Example real wget command in windows cmd = (C:\CV\webdriverstuding\drivers\wget\wget.exe -P C:\CV --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe)
     * @param wgetCommand to input first part of wget command
     */
    public void downloadFileFromYahooPage(String wgetCommand){
        actionsWithWebElements.downloadFile(wgetCommand, DownloadLinkId.getAttribute("href"));
    }








}
