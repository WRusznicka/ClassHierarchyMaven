package interfaces;

@FunctionalInterface
public interface IFind <E,D> {
    E find(D data);
}
