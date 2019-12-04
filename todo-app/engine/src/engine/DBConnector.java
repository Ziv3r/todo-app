package engine;

import engine.exceptions.FailedToConnectToDataBaseException;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnector {
    private Statement m_Statement;

    public DBConnector(String i_DBName, String i_User, String i_Password) throws FailedToConnectToDataBaseException {
        connect(i_DBName, i_User, i_Password);
    }

    private void connect(String i_DBName, String i_User, String i_Password) throws FailedToConnectToDataBaseException {
       //"jdbc:mysql://localhost:3306/sqlpilot"
        String url = "jdbc:mysql://localhost:3306" +"/" + i_DBName;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection connection = DriverManager.getConnection(url, i_User, i_Password);
            m_Statement = connection.createStatement();
        }catch (SQLException ex){
            throw new FailedToConnectToDataBaseException(i_DBName);
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    public void addUser(String i_Username, String i_Password) throws SQLException {
        String sqlCommand;
        sqlCommand = "insert into users(username, password) values(" + "\"" + i_Username + "\"" + ", " + "\"" + i_Password + "\"" + ")";
        m_Statement.executeUpdate(sqlCommand);
    }

    public void removeUser(String i_Username) throws SQLException {
        String sqlCommand;
        sqlCommand = "delete from users where username=" + "\"" + i_Username + "\"";
        m_Statement.executeUpdate(sqlCommand);
    }

}
