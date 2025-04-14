package ch.hslu.ad.sw09;

import java.util.Arrays;

public class MyApp {

    public static void main(String[] args) {
        FixedSizeHeap heap = new FixedSizeHeap();

        heap.insert(2);
        heap.insert(5);
        heap.insert(3);
        heap.insert(51);
        heap.insert(25);
        heap.insert(32);

        System.out.println(Arrays.toString(heap.toArray()));

        int max = heap.removeMax();

        System.out.println("Max= " + max);
        System.out.println(Arrays.toString(heap.toArray()));

    }
}
