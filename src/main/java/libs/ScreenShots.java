package libs;


import org.apache.commons.io.FileUtils;
import org.junit.Assert;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;

import java.io.File;
import java.io.IOException;

public class ScreenShots {

    /**
     * make screenshot
     * @param pathToScreenShot
     * @param driver
     */
    public void screenShot(String pathToScreenShot, WebDriver driver){
        File screenPhoto = ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);

        try{
            FileUtils.copyFile(screenPhoto, new File(pathToScreenShot));
        }
        catch (IOException e) {
            e.printStackTrace();
            Assert.fail("Crash screen shot!");
        }

    }

}
