package pages;

import io.qameta.allure.Step;
import libs.ConfigData;
import libs.Global;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import pages.ParentPage;

public class FileDownloadPage extends ParentPage {

    public FileDownloadPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(id = "messenger-download")
    WebElement DownloadLinkId;

    @Step
    public void navigateToYahooDownloadPage(){
        driver.navigate().to(ConfigData.getConfigValue("YAHOO_DOWNLOAD_FILE"));
    }

    @Step
    public boolean doesDownloadedFilePresent(){
        return actionsWithWebElements.ifFilePresent("C:\\CV\\", "msgr11us.exe");
    }

    @Step
    public void deleteDownloadedFile(){
        actionsWithWebElements.deleteFile("C:\\CV\\", "msgr11us.exe");
    }

    /**
     * give execution path for wget + "-P" + file download destination + "--no-check-certificates" + method itself take value of attribute href and put download source
     * "-P" - after we put download destination
     * Example real wget command in windows cmd = (C:\CV\webdriverstuding\drivers\wget\wget.exe -P C:\CV --no-check-certificate http://demo.guru99.com/selenium/msgr11us.exe)
     */
    @Step
    public void downloadFileFromYahooPage(){
        String wgetCommand = "";

        if(Global.isPlatform(Platform.WIN10)) {
            wgetCommand = "C:\\CV\\webdriverstuding\\drivers\\wget\\wget.exe -P C:\\CV --no-check-certificate";
        }
        else if(Global.isPlatform(Platform.LINUX)){
            wgetCommand = "wget -P \\opt --no-check-certificate";
        }

        actionsWithWebElements.downloadFile(DownloadLinkId, wgetCommand);
    }








}
