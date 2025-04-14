package ch.hslu.ad.sw09;

public interface IIntegerHeap {

    void insert(int value);

    int removeMax();

    int getMax();

    int size();

    boolean empty();

    int[] toArray();
}
