package draganddrop;

import libs.ConfigData;
import org.junit.Test;
import parenttest.ParentTest;

public class DragAndDropTest extends ParentTest {

    public DragAndDropTest(String browser) {
        super(browser);
    }

    @Test
    public void validDragAndDropTest(){
        log.info("Start valid Drag and Drop test DatePicker Test");
        loginPage.openLoginPage(ConfigData.getConfigValue("base_url"));
        loginPage.clickOnPartiallLink("Selenium");
        loginPage.clickOnPartiallLink("Drag and Drop Action");

        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Drag and Drop Action", dragAndDropPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Selenium Drag and Drop Example:", dragAndDropPage.headerOfDragAndDropPage());
        log.trace("Opened Drag and Drop page");

        //if bank item dropped
        dragAndDropPage.dragAndDropBankItem();
        checkAcceptanceCriteria("Bank item is not drag_drop, result table doesn't appear", true, dragAndDropPage.doesResultTablePresent());
        log.trace("Bank item was Drag and Drop");

        //refresh page because need to verify if sales item dropped
        dragAndDropPage.refreshWindow();
        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Drag and Drop Action", dragAndDropPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Selenium Drag and Drop Example:", dragAndDropPage.headerOfDragAndDropPage());
        log.trace("Drag and Drop page opened after refreshed");

        //if bank item dropped
        dragAndDropPage.dragAndDropSalesItem();
        checkAcceptanceCriteria("Sales item is not drag_drop, result table doesn't appear", true, dragAndDropPage.doesResultTablePresent());
        log.trace("Bank item was Drag and Drop");

        //verify to drop first 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredFirstItem();
        checkAcceptanceCriteria("First 5000 item is not drag_drop, a result is incorrect in a result table", "5000", dragAndDropPage.resultDebitMovementValue());
        log.trace("5000 item was Drag and Drop");


        //verify to drop second 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredSecondItem();
        checkAcceptanceCriteria("Second 5000 item is not drag_drop, a result is incorrect in a result table", "5000", dragAndDropPage.resultCreditMovementValue());
        log.trace("second 5000 item was Drag and Drop");



    }

    //TO DO: develop in the future!!!!!!!!!!!!!
//    @Test
//    public void DragAndDropNotAllovedItems(){
//
//    }
}
