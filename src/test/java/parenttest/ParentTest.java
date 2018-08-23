package parenttest;

import libs.ConfigData;
import libs.Global;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxBinary;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.firefox.FirefoxProfile;

import java.io.File;
import java.io.IOException;
import libs.ScreenShots;

import pages.*;
import pages.datepickerpages.BirthDateDemoPage;
import pages.datepickerpages.DatePickerPage;
import pages.gurubank.ManagerPage;
import pages.gurubank.NewCustomerPage;
import pages.mercurytourspages.MercuryRegisterPage;
import pages.mercurytourspages.MercuryRegisterSucessPage;
import pages.popuppages.AccessPopupPage;
import pages.popuppages.GuruBankPopupPage;
import pages.popuppages.SearchUserByEmailPage;
import pages.tablepages.MoneyRediffPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

@RunWith(value = Parameterized.class)
public class ParentTest {

    //for driver
    private WebDriver driver;
    private String browser;
    protected Logger log;

    //for external libraries
    private ScreenShots screenShots = new ScreenShots();
    private String pathToScreenShot;
    private boolean isTestPass = false;

    //for pages
    protected LoginPage loginPage;
    protected DatePickerPage datePickerPage;
    protected BirthDateDemoPage birthDateDemoPage;
    protected DragAndDropPage dragAndDropPage;
    protected FileDownloadPage fileDownloadPage;
    protected MoneyRediffPage moneyRediffPage;
    protected ManagerPage managerPage;
    protected NewCustomerPage newCustomerPage;
    protected UploadFilePage uploadFilePage;
    protected GuruBankPopupPage guruBankPopupPage;
    protected SearchUserByEmailPage searchUserByEmailPage;
    protected AccessPopupPage accessPopupPage;
    protected MercuryRegisterPage mercuryRegisterPage;
    protected MercuryRegisterSucessPage mercuryRegisterSucessPage;


    public ParentTest(String browser){
        this.browser = browser;
        this.log = Logger.getLogger(getClass());
    }

    //knocking to name of class
    @Rule
    public TestName testName = new TestName();

    //choose browser
    @Parameterized.Parameters
    public static Collection testData() throws IOException{
        return Arrays.asList(new Object[][]{
                {"chrome"},
//                {"fireFox"},
        });
    }

    @Before
    public void setUp(){
        pathToScreenShot = "./target/screenshot/" + this.getClass().getPackage().getName() + "/" + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        switch (browser) {

            case "chrome":

                try {
                    File fileFF = new File(ConfigData.getConfigValue("chrome_driver"));
                    System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());
                    ChromeOptions chromeOptions = new ChromeOptions();

                    //additional setting for Chrome on Linux
                    if(Global.isPlatform(Platform.LINUX)){
                        chromeOptions.setBinary(new File("/opt/browsers/chrome/chrome"));
                        chromeOptions.addArguments("--headless");
                        chromeOptions.addArguments("--no-sandbox");
                        chromeOptions.addArguments("--disable-dev-shm-usage");
                    }

                    chromeOptions.addArguments("--lang=en");
                    chromeOptions.addArguments("--start-maximized");
                    chromeOptions.addArguments("--ignore-certificate-errors");
                    chromeOptions.addArguments("--disable-popup-blocking");
                    chromeOptions.addArguments("--incognito");
                    driver = new ChromeDriver(chromeOptions);
                    log.info("Chrome is started");
                } catch (Exception e) {
                    log.error("error to start Chrome", e);
                }

                break;

            case "fireFox":

                try {

                    File fileFF = new File(ConfigData.getConfigValue("gecko_driver"));
                    System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());

                    //for linux launching
                    FirefoxBinary firefoxBinary = new FirefoxBinary();
                    FirefoxOptions firefoxOptions = new FirefoxOptions();
                    firefoxOptions.addArguments("--start-maximized");

                    if(Global.isPlatform(Platform.LINUX)){
                        firefoxBinary.addCommandLineOptions("--headless");
                        firefoxOptions.setBinary(firefoxBinary);
                    }

                    FirefoxProfile profile = new FirefoxProfile();
                    profile.setPreference("browser.startup.page", 0); // Empty start page
                    profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" pag
                    driver = new FirefoxDriver(firefoxOptions);
                    log.info(" FireFox is started");
                } catch (Exception e) {
                    log.error("error to start FireFox", e);
                }

                break;

        }

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
        //for load pages
        driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);
        //delete cookies
        driver.manage().deleteAllCookies();

        //Page initialization
        loginPage = new LoginPage(driver);
        datePickerPage = new DatePickerPage(driver);
        birthDateDemoPage = new BirthDateDemoPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        fileDownloadPage = new FileDownloadPage(driver);
        moneyRediffPage = new MoneyRediffPage(driver);
        managerPage = new ManagerPage(driver);
        newCustomerPage = new NewCustomerPage(driver);
        uploadFilePage = new UploadFilePage(driver);
        guruBankPopupPage = new GuruBankPopupPage(driver);
        searchUserByEmailPage = new SearchUserByEmailPage(driver);
        accessPopupPage = new AccessPopupPage(driver);
        mercuryRegisterPage = new MercuryRegisterPage(driver);
        mercuryRegisterSucessPage = new MercuryRegisterSucessPage(driver);
    }

    @After
    public void tearDown(){

        if(!isTestPass){
            screenShots.screenShot(pathToScreenShot, driver);
        }

        driver.quit();

    }

    protected void checkAcceptanceCriteria(String message, String actual, String expected){

        if(!actual.equals(expected)){

            screenShots.screenShot(pathToScreenShot, driver);

        }

        Assert.assertThat(message , actual, is (expected));
        isTestPass = true;
    }

    protected void checkAcceptanceCriteria(String message, boolean actual, boolean expected){

        if(actual != expected){

            screenShots.screenShot(pathToScreenShot, driver);
        }

        Assert.assertThat(message, actual, is(expected));
        isTestPass = true;

    }

}
