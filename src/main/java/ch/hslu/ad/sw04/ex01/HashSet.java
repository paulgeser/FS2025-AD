package ch.hslu.ad.sw04.ex01;

import java.util.Arrays;

public class HashSet<T> implements IHashSet<T> {

    private static final int SIZE = 10;
    private final Object[] data = new Object[SIZE];

    @Override
    public boolean add(T object) {
        if (!contains(object)) {
            int index = Math.abs(object.hashCode()) % SIZE;
            data[index] = object;
            return true;
        }
        return false;
    }

    @Override
    public boolean remove(T object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        if (data[index] != null && data[index].equals(object)) {
            data[index] = null;
            return true;
        }
        return false;
    }

    @Override
    public boolean contains(T object) {
        int index = Math.abs(object.hashCode()) % SIZE;
        if (data[index] != null && data[index].equals(object)) {
            return true;
        }
        return false;
    }

    @Override
    public String toString() {
        return Arrays.toString(data);
    }

    public static void main(String[] args) {
        HashSet<String> set = new HashSet<>();
        String text1 = "Hello";
        int hashCod1 = text1.hashCode();
        System.out.println(text1 + ": :" + Math.abs(hashCod1) % SIZE);
        set.add(text1);
        String text2 = "Cool stuff";
        int hashCod2 = text2.hashCode();
        System.out.println(text2 + ": :" + Math.abs(hashCod2) % SIZE);
        set.add(text2);
        String text3 = "Wow crazy";
        int hashCod3 = text3.hashCode();
        System.out.println(text3 + ": :" + Math.abs(hashCod3) % SIZE);
        set.add(text3);
        String text4 = "HSLU";
        int hashCod4 = text4.hashCode();
        System.out.println(text4 + ": :" + Math.abs(hashCod4) % SIZE);
        set.add(text4);

        System.out.println(set);
    }
}
