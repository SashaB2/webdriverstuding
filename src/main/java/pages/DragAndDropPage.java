package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class DragAndDropPage extends ParentPage{
    public DragAndDropPage(WebDriver driver) {
        super(driver);
    }

    @FindBy(tagName = "h1")
    WebElement PageHeaderTagName;

    @FindBy(id = "credit2")
    WebElement BankItemId;

    @FindBy(id = "bank")
    WebElement BankDropHolderId;

    @FindBy(id = "credit1")
    WebElement SalesItemId;

    @FindBy(id = "loan")
    WebElement SalesDropHolderId;

    //5000 - 1
    @FindBy(xpath = "//li[@id='fourth'][1]")
    WebElement MoneyItemFiveHundredFirstXpath;

    //5000 - 2
    @FindBy(xpath = "//li[@id='fourth'][2]")
    WebElement MoneyItemFiveHundredSecondXpath;

    //for first 500
    @FindBy(id = "amt7")
    WebElement BankMoneyDropId;

    //for second 500
    @FindBy(id = "amt8")
    WebElement SalesMoneyDropId;

    //result table
    @FindBy(xpath = "//div[@id='bal3']/table")
    WebElement ResultTableXpath;

    //for debit movement
    @FindBy(id = "t7")
    WebElement DebitMovementValueId;

    //for credit movement
    @FindBy(id = "t8")
    WebElement CreditMovementValueId;

    public String headerOfDragAndDropPage(){
        return PageHeaderTagName.getText();
    }

    //for bank item
    public void dragAndDropBankItem(){
        actionsWithWebElements.dragFromTo(BankItemId, BankDropHolderId);
    }

    //for sales item
    public void dragAndDropSalesItem(){
        actionsWithWebElements.dragFromTo(SalesItemId, SalesDropHolderId);
    }

    //for first 500
    public void dragAndDropMoneyItemFiveHundredFirstItem(){
        actionsWithWebElements.dragFromTo(MoneyItemFiveHundredFirstXpath, BankMoneyDropId);
    }

    //for second 500
    public void dragAndDropMoneyItemFiveHundredSecondItem(){
        actionsWithWebElements.dragFromTo(MoneyItemFiveHundredSecondXpath, SalesMoneyDropId);
    }
    public boolean doesResultTablePresent(){
        return ResultTableXpath.isDisplayed();
    }

    public String resultDebitMovementValue(){
        return DebitMovementValueId.getText();
    }

    public String resultCreditMovementValue(){
        return CreditMovementValueId.getText();
    }

}
