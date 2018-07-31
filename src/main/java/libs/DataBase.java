package libs;

import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DataBase {

    private String dbUrl;

    private String login;

    private String password;

    private String driverdb;

    private Connection connection = null;

    public DataBase(String dbUrl, String login, String password, String driverdb) throws ClassNotFoundException, SQLException {
        this.dbUrl = ConfigData.getConfigValue(dbUrl);
        this.login = ConfigData.getConfigValue(login);
        this.password = ConfigData.getConfigValue(password);
//        this.driverdb = ConfigData.getConfigValue(driverdb);
//        Class.forName(ConfigData.getConfigValue(this.driverdb));
        Class.forName("com.mysql.jdbc.Driver");
//        this.connection = DriverManager.getConnection(this.dbUrl, this.login, this.password);
        this.connection = DriverManager.getConnection("jdbc:mysql://185.25.118.54:3306/old_qa", "old_qa", "PB3Q2F6tdSD9cL3z");
    }

    public HashMap<String, String> getValue(String query, String firstColumnName, String secodColumnName) throws SQLException {
        HashMap<String, String> map = new HashMap<String, String>();

        Statement stmt = connection.createStatement();

        ResultSet resultSet = stmt.executeQuery(query);

        while (resultSet.next()){
            map.put(resultSet.getString(firstColumnName), resultSet.getString(secodColumnName));
        }

        return map;
    }

    public void quit() throws SQLException {
        connection.close();
    }
}
