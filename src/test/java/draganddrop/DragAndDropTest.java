package draganddrop;

import org.junit.Test;
import parenttest.ParentTest;

public class DragAndDropTest extends ParentTest {

    public DragAndDropTest(String browser) {
        super(browser);
    }

    @Test
    public void validDragAndDropTest(){
        loginPage.loginQuickly();
        mainPage.clickOnPartiallLink("Selenium");
        mainPage.clickOnPartiallLink("Drag and Drop Action");

        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Drag and Drop Action", dragAndDropPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Selenium Drag and Drop Example:", dragAndDropPage.headerOfDragAndDropPage());

        //if bank item dropped
        dragAndDropPage.dragAndDropBankItem();
        checkAcceptanceCriteria("Bank item is not drag_drop, result table doesn't appear", true, dragAndDropPage.doesResultTablePresent());

        //refresh page because need to verify if sales item dropped
        dragAndDropPage.refreshWindow();
        //verify if page opens
        checkAcceptanceCriteria("Page title does not  coincide", "Drag and Drop Action", dragAndDropPage.getPageTitle());
        checkAcceptanceCriteria("Page with date picker does not open", "Selenium Drag and Drop Example:", dragAndDropPage.headerOfDragAndDropPage());

        //if bank item dropped
        dragAndDropPage.dragAndDropSalesItem();
        checkAcceptanceCriteria("Sales item is not drag_drop, result table doesn't appear", true, dragAndDropPage.doesResultTablePresent());

        //verify to drop first 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredFirstItem();
        checkAcceptanceCriteria("First 5000 item is not drag_drop, a result is incorrect in a result table", "5000", dragAndDropPage.resultDebitMovementValue());

        //verify to drop second 5000 tem
        dragAndDropPage.dragAndDropMoneyItemFiveHundredSecondItem();
        checkAcceptanceCriteria("Second 5000 item is not drag_drop, a result is incorrect in a result table", "5000", dragAndDropPage.resultCreditMovementValue());

    }

    //TO DO: develop in the future!!!!!!!!!!!!!
//    @Test
//    public void DragAndDropNotAllovedItems(){
//
//    }
}
