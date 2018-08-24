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
        checkAcceptanceCriteria("Page title does not  coincide", dragAndDropPage.getPageTitle(), "Drag and Drop Action");
        checkAcceptanceCriteria("Page with date picker does not open", dragAndDropPage.headerOfDragAndDropPage(), "Selenium Drag and Drop Example:");

        //if bank item dropped
        dragAndDropPage.dragAndDropBankItem();
        checkAcceptanceCriteria("Bank item is not drag_drop, result table doesn't appear", dragAndDropPage.doesResultTablePresent(), true);

        //refresh page because need to verify if sales item dropped
        dragAndDropPage.refreshWindow();
        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", dragAndDropPage.getPageTitle(), "Drag and Drop Action");
        checkAcceptanceCriteria("Page with date picker does not open", dragAndDropPage.headerOfDragAndDropPage(), "Selenium Drag and Drop Example:");

        //if bank item dropped
        dragAndDropPage.dragAndDropSalesItem();
        checkAcceptanceCriteria("Sales item is not drag_drop, result table doesn't appear", dragAndDropPage.doesResultTablePresent(), true);

        //verify to drop first 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredFirstItem();
        checkAcceptanceCriteria("First 5000 item is not drag_drop, a result is incorrect in a result table", dragAndDropPage.resultDebitMovementValue(), "5000");


        //verify to drop second 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredSecondItem();
        checkAcceptanceCriteria("Second 5000 item is not drag_drop, a result is incorrect in a result table", dragAndDropPage.resultCreditMovementValue(), "5000");

    }

    //TO DO: develop in the future!!!!!!!!!!!!!
//    @Test
//    public void DragAndDropNotAllovedItems(){
//
//    }
}
