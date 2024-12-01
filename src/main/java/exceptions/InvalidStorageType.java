package exceptions;

public class InvalidStorageType extends Exception {
    public InvalidStorageType() {
        super("Invalid storage type. Should be SSD or HDD.");
    }
}
