package ch.hslu.ad.sw02.ex2;

public class Stack<T> implements StackInterface<T> {

    private final T[] stack;
    private final int stackSize;
    private int pointer = -1;

    public Stack(final int stackSize){
        this.stackSize = stackSize;
        this.stack = (T[]) new Object[stackSize];
    }

    @Override
    public boolean push(T o) {
        if (pointer == stackSize - 1) {
            return false;
        }
        stack[++pointer] = o;
        return true;
    }

    @Override
    public T pop() {
        if (pointer == -1) {
            return null;
        }
        return stack[pointer--];
    }

    @Override
    public int size() {
        return this.pointer + 1;
    }

    @Override
    public boolean isEmpty() {
        return this.pointer == -1;
    }
}
