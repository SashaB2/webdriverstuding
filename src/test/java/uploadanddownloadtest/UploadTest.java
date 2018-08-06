package uploadanddownloadtest;

import org.junit.Test;
import parenttest.ParentTest;

public class UploadTest extends ParentTest {

    public UploadTest(String browser) {
        super(browser);
    }

    @Test
    public void validUploadTest(){
        loginPage.loginQuickly();
        log.trace("Logged");
        mainPage.clickOnPartiallLink("Selenium");
        mainPage.clickOnPartiallLink("File Upload using Sikuli Demo");

        //verify if page this page is opened
        checkAcceptanceCriteria("File Upload using Sikuli page does not open", "File Upload using Sikuli", fileUploadSikuliPage.getPageTitle());
        log.trace("Sikuli page opened");


        //upload file
//        fileUploadSikuliPage.clickOnChooseFileButton();
//        log.trace("Choose button clicked");

//        fileUploadSikuliPage.handleWithUploadFile();
//        checkAcceptanceCriteria("File does not upload", "File Upload Successful", fileUploadSikuliPage.resultOfUploadFile());

    }
}
