package ch.hslu.ad.sw02.ex2;

public interface StackInterface<T> {
    /**
     * Pushes an element onto the top of the stack.
     *
     * @param o the object to be added to the stack
     */
    public boolean push(T o);

    /**
     * Removes and returns the top element of the stack.
     *
     * @return the top element of the stack
     * @throws java.util.EmptyStackException if the stack is empty
     */
    public T pop();

    /**
     * Returns the number of elements currently in the stack.
     *
     * @return the number of elements in the stack
     */
    public int size();

    /**
     * Checks if the stack is empty.
     *
     * @return {@code true} if the stack contains no elements, {@code false} otherwise
     */
    public boolean isEmpty();
}
