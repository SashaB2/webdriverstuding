package parenttest;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxProfile;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;

import java.io.File;
import java.io.IOException;
import libs.ScreenShots;
import java.net.MalformedURLException;
import java.net.URL;

import pages.DragAndDropPage;
import pages.datepickerpages.BirthDateDemoPage;
import pages.LoginPage;
import pages.MainPage;
import pages.datepickerpages.DatePickerPage;
import pages.uploadanddownload.FileDownloadPage;
import pages.uploadanddownload.FileUploadSikuliPage;

import java.util.Arrays;
import java.util.Collection;
import java.util.concurrent.TimeUnit;

import static org.hamcrest.core.Is.is;

@RunWith(value = Parameterized.class)
public class ParentTest {

    //for driver
    private WebDriver driver;
    private String browser;
    public Logger log;

    //for external libraries
    private ScreenShots screenShots = new ScreenShots();
    private String pathToScreenShot;
    private boolean isTestPass;

    //for pages
    public LoginPage loginPage;
    public MainPage mainPage;
    public DatePickerPage datePickerPage;
    public BirthDateDemoPage birthDateDemoPage;
    public DragAndDropPage dragAndDropPage;
    public FileUploadSikuliPage fileUploadSikuliPage;
    public FileDownloadPage fileDownloadPage;


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
//
        });
    }

    @Before
    public void setUp(){

        pathToScreenShot = "./target/screenshot/" + this.getClass().getPackage().getName() + "/" + this.getClass().getSimpleName() + this.testName.getMethodName() + ".jpg";

        if(browser.equals("chrome")){
            try {
                log.info("Chrome will be started");
                    File fileFF = new File("./drivers/chromedriver.exe");
//                File fileFF = new File("./drivers/chromedriver");
                System.setProperty("webdriver.chrome.driver", fileFF.getAbsolutePath());

//                DesiredCapabilities dc = new DesiredCapabilities();
//                dc.setCapability(CapabilityType.UNEXPECTED_ALERT_BEHAVIOUR, UnexpectedAlertBehaviour.IGNORE);

                ChromeOptions chromeOptions = new ChromeOptions();

//                chromeOptions.setBinary("/opt/google/chrome/chrome");
//                chromeOptions.addArguments("--no-sandbox");
//                chromeOptions.addArguments("--disable-dev-shm-usage");
//                chromeOptions.merge(dc);
                chromeOptions.addArguments("--lang=en");
                chromeOptions.addArguments("--start-maximized");
                chromeOptions.addArguments("--ignore-certificate-errors");
                chromeOptions.addArguments("--disable-popup-blocking");
                chromeOptions.addArguments("--incognito");
                driver = new ChromeDriver(chromeOptions);
                log.info("Chrome is started");
            }
            catch (Exception e){
                log.error("error to start GChrome", e);
            }
        }
        else if ("IE".equals(browser)) {

            try {
                log.info("IE will be started");
                File file1 = new File("./drivers/IEDriverServer.exe");
                System.setProperty("webdriver.ie.driver", file1.getAbsolutePath());
                DesiredCapabilities caps = DesiredCapabilities.internetExplorer();
                caps.setCapability(InternetExplorerDriver.INTRODUCE_FLAKINESS_BY_IGNORING_SECURITY_DOMAINS, true);
                caps.setCapability(InternetExplorerDriver.INITIAL_BROWSER_URL, "http://v3.qalight.com.ua/login");
                driver = new InternetExplorerDriver(caps);
                log.info(" IE is started");
            }
            catch (Exception e){
                log.error("error to start InternetExplorer", e);
            }
        }
        else if ("fireFox".equals(browser)) {

            try {
                log.info("FireFox will be started");
                File fileFF = new File("./drivers/geckodriver.exe");
                System.setProperty("webdriver.gecko.driver", fileFF.getAbsolutePath());
                FirefoxProfile profile = new FirefoxProfile();
                profile.setPreference("browser.startup.page", 0); // Empty start page
                profile.setPreference("browser.startup.homepage_override.mstone", "ignore"); // Suppress the "What's new" page
                driver = new FirefoxDriver();
                log.info(" FireFox is started");
            }
            catch (Exception e){
                log.error("error to start FireFox", e);
            }
        }
        else if("remote".equals(browser)){

            try{
                log.info("remote browser will be started");
                driver = new RemoteWebDriver(new URL("http://localhost:4444/wd/hub"), DesiredCapabilities.chrome());
                log.info("remote browser is started");
            }
            catch (MalformedURLException e) {
                log.error("can not connect to remote server", e);
            }

        }

        //implicitly wait
        driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);

        //Page initialization
        loginPage = new LoginPage(driver);
        mainPage = new MainPage(driver);
        datePickerPage = new DatePickerPage(driver);
        birthDateDemoPage = new BirthDateDemoPage(driver);
        dragAndDropPage = new DragAndDropPage(driver);
        fileUploadSikuliPage = new FileUploadSikuliPage(driver);
        fileDownloadPage = new FileDownloadPage(driver);
    }

    @After
    public void tearDown(){

        if(!isTestPass){
            screenShots.screenShot(pathToScreenShot, driver);
        }

//        driver.quit();

    }

    public void checkAcceptanceCriteria(String message, String expected, String actual){

        if(!expected.equals(actual)){

            screenShots.screenShot(pathToScreenShot, driver);

        }

//        Assert.assertThat(message, expected, is (actual));
        Assert.assertThat(message , actual, is (expected));
        isTestPass = true;
    }

    public void checkAcceptanceCriteria(String message, boolean expected, boolean actual){

        if(expected != actual){

            screenShots.screenShot(pathToScreenShot, driver);
        }

        Assert.assertThat(message, expected, is(actual));
        isTestPass = true;

    }

}