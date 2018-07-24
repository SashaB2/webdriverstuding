package mainpagetest;

import org.junit.Test;
import parenttest.ParentTest;

import java.util.HashMap;
import java.util.Map;

public class MainPageContentTest extends ParentTest {

    public MainPageContentTest(String browser) {
        super(browser);
    }

//    @Test
//    public void checkContentHeaderMainPage(){
//        loginPage.loginQuick();
//        checkAcceptanceCriteria("main page does not open",mainPage.doesAvatarPresent(),true);
//
//        //check content header on  main page
//        checkAcceptanceCriteria("Content Header  does not coincide",mainPage.HeaderContent("./src/main/java/data/testData.xls", "mainPage", "headerContentMainPage"), true);
//    }
//
//    @Test
//    public void checkContentMainPage(){
//        loginPage.loginQuick();
//        checkAcceptanceCriteria("main page does not open",mainPage.doesAvatarPresent(),true);
//
//        //check content on main page
//        HashMap<String, Boolean> values = mainPage.paragraphContent("./src/main/java/data/testData.xls", "mainPage");
//        for (Map.Entry<String, Boolean> pair: values.entrySet()) {
//            if(!pair.getValue()) {
//                log.error("This part of content on main page does not valid: " + pair.getKey());
//            }
//        }
//        checkAcceptanceCriteria("Content on main page does not valid", values.containsKey(false), true);
//
//    }
}
