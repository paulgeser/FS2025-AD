package ch.hslu.ad.sw04.ex03;

import java.util.Arrays;
import java.util.Objects;

public class HashSet<T> implements IHashSet<T> {

    private static final int SIZE = 10;
    private final Object[] data = new Object[SIZE];
    private int currentSize = 0;

    @Override
    public boolean add(T object) {
        if (!contains(object) && currentSize != SIZE) {
            int index = Math.abs(object.hashCode()) % SIZE;
            while (data[index] != null) {
                index = (index + 1) % SIZE;
            }
            data[index] = object;
            currentSize++;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T object) {
        final int objectHashCode = object.hashCode();
        int index = Math.abs(object.hashCode()) % SIZE;
        boolean deleted = false;
        // Delete entry
        while (data[index] != null) {
            if (data[index].equals(object)) {
                data[index] = null;
                currentSize--;
                deleted = true;
                break;
            }
            index = (index + 1) % SIZE;
        }

        // Rotate values
        if (deleted) {
            index = Math.abs(object.hashCode()) % SIZE;
            boolean emptySlotPossible = true;
            while (emptySlotPossible) {
                if (data[index] == null) {
                    emptySlotPossible = false;
                    if (data[(index + 1) % SIZE] == null) {
                        break;
                    }
                    int nextItemHashPlace = data[(index + 1) % SIZE].hashCode() % SIZE;
                    if (nextItemHashPlace == (objectHashCode % SIZE)) {
                        data[index] = data[(index + 1) % SIZE];
                        data[(index + 1) % SIZE] = null;
                        emptySlotPossible = true;
                    }
                } else if (data[index].hashCode() == objectHashCode) {
                    continue;
                } else {
                    break;
                }
                index = (index + 1) % SIZE;
            }
        }
        return deleted;
    }

    @Override
    public boolean contains(T object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        boolean found = false;
        while (data[index] != null) {
            if (data[index].equals(object)) {
                found = true;
                break;
            }
            index = (index + 1) % SIZE;
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
