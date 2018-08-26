package databasetest;

import io.qameta.allure.Description;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import libs.DataBase;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

public class DataBaseTest {
    DataBase dataBase;
    Logger log = Logger.getLogger(getClass());

    @Before
    public void setUp() throws SQLException, ClassNotFoundException {
        dataBase = new DataBase("MySQL_PADB_DB", "MYSQL_PADB_DB_USER", "MYSQL_PADB_DB_PASSWORD", "MySQL");
    }

    @After
    public void tearDown() throws SQLException {
        dataBase.quit();
    }

    @Test
    @Description("Saving login and password")
    @Severity(SeverityLevel.CRITICAL)
    public void saveLoginPasswordToDataBase() throws SQLException {
        log.info("Start to verify saving Login and Password");
        HashMap<String, String> map = dataBase.getValue("select * from seleniumTable;", "login", "passWord");

        String login = "Sviridenko";
        String password = "pass";
        boolean trigger = false;

        for (Map.Entry<String, String> pair: map.entrySet()) {
             if(login.equals(pair.getKey()) && password.equals(pair.getValue())){
                log.info("Login and password saved in the database");
                trigger = true;
                break;
             }
        }

        Assert.assertEquals("Login and password did not save in the database", true, trigger);

    }
}
