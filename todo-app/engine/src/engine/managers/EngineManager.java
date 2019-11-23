package engine.managers;

import engine.exceptions.FailedToConnectToDataBaseException;

public class EngineManager {
    UsersManager m_UsersManager;

    public UsersManager getUsersManager() {
        return m_UsersManager;
    }

    public EngineManager() throws FailedToConnectToDataBaseException {
        m_UsersManager = new UsersManager();
    }
}
