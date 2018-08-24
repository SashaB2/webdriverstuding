package dropdownlisttest;

import org.junit.Test;
import parenttest.ParentTest;

public class MercuryToursTest extends ParentTest {

    public MercuryToursTest(String browser) {
        super(browser);
    }

    @Test
    public void registerMercuryTest(){
        String firstName = "Sasha";
        String lastName = "SV";
        String login = "User1";
        String password = "123456";

        log.info("Start verifying to register into Mercury Tours");
        mercuryRegisterPage.openRegisterPage();
        checkAcceptanceCriteria("mergury register page does not open", mercuryRegisterPage.getPageTitle(), "Register: Mercury Tours");

        //input Contact information
        mercuryRegisterPage.inputFirstName(firstName);
        mercuryRegisterPage.inputLastName(lastName);
        mercuryRegisterPage.inputPhoneNumber("56565656");
        mercuryRegisterPage.inputEmail("emailTest@gmail.com");

        //input Mailing Information
        mercuryRegisterPage.inputAddress("String 12/11A");
        mercuryRegisterPage.inputCity("City");
        mercuryRegisterPage.inputState("State");
        mercuryRegisterPage.inputPostCode("1234");
        mercuryRegisterPage.chooseCountry("CENTRAL AFRICAN REPUBLIC");

        //input User Information
        mercuryRegisterPage.inputUserName(login);
        mercuryRegisterPage.inputUserPassword(password);
        mercuryRegisterPage.inputConfirmPassword(password);
        mercuryRegisterPage.clickOnSubmitButton();


        System.out.println(mercuryRegisterSucessPage.getUserRegisteredFirstLastNameInfo());
        System.out.println(mercuryRegisterSucessPage.getUserRegisteredLoginNameInfo());
        checkAcceptanceCriteria("User first or last name does not coincide", mercuryRegisterSucessPage.getUserRegisteredFirstLastNameInfo(), "Dear " + firstName + " " + lastName + ",");
        checkAcceptanceCriteria("User login does not coincide", mercuryRegisterSucessPage.getUserRegisteredLoginNameInfo(), "Note: Your user name is " + login + ".");
    }


}
