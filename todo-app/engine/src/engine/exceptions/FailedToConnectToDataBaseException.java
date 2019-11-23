package engine.exceptions;

public class FailedToConnectToDataBaseException extends Throwable {
    public FailedToConnectToDataBaseException(String DBName) {
        super("failed to connect to " + DBName);
    }
}
