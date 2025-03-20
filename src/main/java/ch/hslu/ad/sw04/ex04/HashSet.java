package ch.hslu.ad.sw04.ex04;

import ch.hslu.ad.sw02.ex1.Node;

import java.util.Arrays;

public class HashSet<T> implements IHashSet<T> {

    private static final int SIZE = 10;
    private final Node<T>[] data = new Node[SIZE];
    private int currentSize = 0;

    @Override
    public boolean add(T object) {
        if (!contains(object) && currentSize != SIZE) {
            int index = Math.abs(object.hashCode()) % SIZE;
            data[index] = new Node<>(data[index], object);
            currentSize++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        boolean deleted = false;
        if (data[index] == null) {
            return false;
        }
        Node<T> current = data[index];
        Node<T> previous = null;

        while (current != null) {
            if (current.getData().equals(object)) {
                if (previous == null) {
                    data[index] = current.getNextElement();
                } else {
                    previous.setNextElement(current.getNextElement());
                }
                deleted = true;
                currentSize--;
                break;
            } else {
                previous = current;
                current = current.getNextElement();
            }
        }
        return deleted;
    }

    @Override
    public boolean contains(T object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        boolean found = false;
        Node<T> element = data[index];
        while (element != null) {
            if (element.getData().equals(object)) {
                found = true;
                break;
            } else {
                element = element.getNextElement();
            }
        }
        return found;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public int size() {
        return this.currentSize;
    }

    public boolean full() {
        return this.currentSize == SIZE;
    }
}
