package Exceptions;

public class BoardNotCompatibleException extends Throwable {

    @Override
    public String getMessage() {
        return "The columns or rows that have been entered does not match the board!";
    }
}
