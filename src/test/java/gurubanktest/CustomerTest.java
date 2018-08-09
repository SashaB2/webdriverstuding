package gurubanktest;

import org.junit.Test;
import parenttest.ParentTest;

public class CustomerTest extends ParentTest{


    public CustomerTest(String browser) {
        super(browser);
    }

    //TO DO
    @Test
    public void addCustomerTest(){
        log.info("Add -> Edit -> Delete customer");
        //TO DO: develop quicklyAddCustomerMethod, quicklyEditCustomerMethod in NewCustomerPage class

    }

    //TO DO
    @Test
    public void editCustomerTest(){
        log.info("Add -> Edit -> Delete customer");
        //TO DO: develop quicklyAddCustomerMethod in NewCustomerPage class
    }

    @Test
    public void deleteCustomerTest(){
        log.info("Add -> Edit -> Delete customer");
        //TO DO: develop quicklyAddCustomerMethod in NewCustomerPage class
    }

    //TO DO, If needed?
    @Test
    public void addEditDeleteCustomerTest(){
        log.info("Add -> Edit -> Delete customer");

    }
}
