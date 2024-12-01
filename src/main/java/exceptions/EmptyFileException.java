package exceptions;

public class EmptyFileException extends Exception {
    public EmptyFileException() {
        System.out.println("File is empty, no data found");
    }
}
