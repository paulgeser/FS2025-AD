package ch.hslu.ad.sw04.ex01;

/**
 * This is an interface that defines which methods a HashSet is required to implement
 *
 * @param <T> The datatype the hashset should store
 */
public interface IHashSet<T> {

    /**
     * Adds an element to the set if it's not already present.
     *
     * @param t the element to be added
     * @return true if the element was added, false if it was already in the set
     */
    boolean add(T t);

    /**
     * Removes an element from the set.
     *
     * @param t the element to be removed
     * @return true if the element was removed, false if it was not present in the set
     */
    boolean remove(T t);

    /**
     * Checks if an element is present in the set.
     *
     * @param t the element to check for
     * @return true if the element is in the set, false otherwise
     */
    boolean contains(T t);
}
