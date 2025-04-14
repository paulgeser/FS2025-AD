package ch.hslu.ad.sw09;

import java.util.Arrays;

public class FixedSizeHeap implements IIntegerHeap {

    private int[] array = new int[16];
    private int size = 0;


    public FixedSizeHeap() {
        Arrays.fill(array, -1);
    }

    public FixedSizeHeap(final int[] input) {
        Arrays.fill(array, -1);
        for (int i = 0; i < input.length; i++) {
            array[i] = input[i];
        }
        size = input.length;
        for (int i = size / 2 - 1; i >= 0; i--) {
            heapify(array, i, size - 1);
        }
    }

    @Override
    public void insert(int value) {
        if (size >= array.length) {
            throw new IllegalStateException("Heap is full");
        }
        array[size] = value;
        siftUp(size);
        size++;
    }

    private void siftUp(int index) {
        while (index > 0) {
            int parent = (index - 1) / 2;
            if (array[parent] >= array[index]) {
                break;
            }
            // Swap
            int temp = array[parent];
            array[parent] = array[index];
            array[index] = temp;

            index = parent;
        }
    }

    @Override
    public int removeMax() {
        if (size == 0) {
            throw new RuntimeException("Heap is empty");
        }
        ;
        int max = array[0];
        array[0] = array[size - 1];
        array[size - 1] = -1;
        size--;
        heapify(array, 0, size - 1);
        return max;
    }

    @Override
    public int getMax() {
        return array[0];
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean empty() {
        return size == 0;
    }

    @Override
    public int[] toArray() {
        return array;
    }

    private void heapify(int[] array, int li, int re) {
        int k = 2 * li + 1;
        if (k > re) {
            return;
        }
        if (k + 1 > re) {
            if (array[k] > array[li]) {
                int temp = array[li];
                array[li] = array[k];
                array[k] = temp;
            }
            return;
        }
        if (array[k] < array[k + 1]) {
            k++;
        }

        if (array[li] < array[k]) {
            int temp = array[li];
            array[li] = array[k];
            array[k] = temp;
            heapify(array, k, re);
        }
    }
}
