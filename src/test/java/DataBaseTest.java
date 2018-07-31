import libs.DataBase;
import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import javax.swing.text.html.parser.Entity;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
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
    public void justTest() throws SQLException {
        HashMap<String, String> map = dataBase.getValue("select * from seleniumTable;", "login", "passWord");

        String login = "Sviridenko";
        String password = "pass";
        boolean trigger = false;

        for (Map.Entry<String, String> pair: map.entrySet()) {
             if(login.equals(pair.getKey()) && password.equals(pair.getValue())){
                log.info("Login and password saved in the database");
                trigger = true;
             }
        }

        if(!trigger){
            log.error("Login and password did not save in the database");
        }
    }
}
