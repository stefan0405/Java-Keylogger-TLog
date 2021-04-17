package exceptions;

public class SettingsNotSetException extends RuntimeException {

    public SettingsNotSetException(String message) {
        super(message);
    }
}
