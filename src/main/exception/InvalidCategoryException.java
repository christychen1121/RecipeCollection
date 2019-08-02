package exception;

public class InvalidCategoryException extends InvalidInputException {

    @Override
    public void printErrorMessage() {
        System.out.println("Please enter 'breakfast' or 'main dish' or 'snack' for category");
    }
}
