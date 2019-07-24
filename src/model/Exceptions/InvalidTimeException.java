package model.Exceptions;

public class InvalidTimeException extends InvalidInputException {

    @Override
    public void printErrorMessage() {
        System.out.println("Please enter a time that is between 0 and 60 minutes");
    }
}
