package engine.managers;


import engine.DBConnector;
import engine.User;
import engine.exceptions.FailedToConnectToDataBaseException;

import java.util.HashMap;
import java.util.Map;

public class UsersManager {
    private Map<String, User> m_Users;
    private DBConnector m_DBConnector;

    public UsersManager() throws FailedToConnectToDataBaseException {
        this.m_Users = new HashMap<>();
        this.m_DBConnector = new DBConnector("todo-app", "root", "123456");
    }

    public void register(String i_Username, String i_Password) throws Exception {
        if (!isExists(i_Username)){
            // register user if it doesn't exists
            // maybe validate password?
            m_DBConnector.addUser(i_Username, i_Password);
            m_Users.put(i_Username, new User(i_Username));
        }
        else{
            throw new Exception("User Already Exist");
        }
    }

    private boolean isExists(String i_Username) {
        return m_Users.containsValue(i_Username);
    }
}
