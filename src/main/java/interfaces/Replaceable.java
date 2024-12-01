package interfaces;

public interface Replaceable {
    boolean isReplaceable();
    default void replace(){
        System.out.println("The part has been replaced");
    };
}
