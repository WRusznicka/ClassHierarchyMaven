package interfaces;

@FunctionalInterface
public interface IFilter<E, L, C> {
    E findInListByCriteria(L list, C criteria);
}
