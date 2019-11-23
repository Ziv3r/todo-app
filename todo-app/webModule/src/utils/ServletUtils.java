package utils;

import engine.exceptions.FailedToConnectToDataBaseException;
import engine.managers.EngineManager;

import javax.servlet.ServletContext;


public class ServletUtils {

    private static final String ENGINE_MANAGER_ATTRIBUTE_NAME = "engineManager";

    /*
    Note how the synchronization is done only on the question and\or creation of the relevant managers and once they exists -
    the actual fetch of them is remained un-synchronized for performance POV
     */
    private static final Object EngineManagerLock = new Object();


    public static EngineManager getEngineManager(ServletContext servletContext) throws FailedToConnectToDataBaseException {
        synchronized (EngineManagerLock ) {
            if (servletContext.getAttribute(ENGINE_MANAGER_ATTRIBUTE_NAME) == null) {
                servletContext.setAttribute(ENGINE_MANAGER_ATTRIBUTE_NAME, new EngineManager());
            }
        }
        return (EngineManager) servletContext.getAttribute(ENGINE_MANAGER_ATTRIBUTE_NAME);
    }

}
