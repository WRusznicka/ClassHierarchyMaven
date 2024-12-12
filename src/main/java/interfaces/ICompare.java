package interfaces;

@FunctionalInterface
public interface ICompare<E> {
    void compare(E element1, E element2);
}
