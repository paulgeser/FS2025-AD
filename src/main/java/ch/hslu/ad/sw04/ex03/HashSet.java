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
            int index = Math.abs(object.hashCode() % SIZE);
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
        int index = Math.abs(object.hashCode() % SIZE);
        boolean deleted = false;
        while (data[index] != null) {
            if (data[index].equals(object)) {
                data[index] = null;
                currentSize--;
                deleted = true;
                break;
            }
            index = (index + 1) % SIZE;
        }
        return deleted;
    }

    @Override
    public boolean contains(T object) {
        int index = Math.abs(object.hashCode() % SIZE);
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

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String text1 = "Hello";
        int hashCod1 = text1.hashCode();
        System.out.println(text1 + ": :" + hashCod1 % SIZE);
        set.add(text1);
        String text2 = "Cool stuff";
        int hashCod2 = text2.hashCode();
        System.out.println(text2 + ": :" + hashCod2 % SIZE);
        set.add(text2);
        String text3 = "Wow crazy";
        int hashCod3 = text3.hashCode();
        System.out.println(text3 + ": :" + hashCod3 % SIZE);
        set.add(text3);
        String text4 = "HSLU";
        int hashCod4 = text4.hashCode();
        System.out.println(text4 + ": :" + hashCod4 % SIZE);
        set.add(text4);
        System.out.println(set.size());
        System.out.println(set.toString());
    }
}
