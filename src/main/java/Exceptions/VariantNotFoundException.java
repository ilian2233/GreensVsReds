package Exceptions;

public class VariantNotFoundException extends Throwable {

    @Override
    public String getMessage() {
        return "There is no such type cell!";
    }
}
