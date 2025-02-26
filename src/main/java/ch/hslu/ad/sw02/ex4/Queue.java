package ch.hslu.ad.sw02.ex4;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;

public class Queue {
    private static final Logger LOG = LoggerFactory.getLogger(Queue.class);


    private final char[] queue;
    private int headPointer;
    private int tailPointer;
    private static final int QUEUE_CAPACITY = 8;

    public Queue() {
        queue = new char[QUEUE_CAPACITY];
    }

    public void enqueue(char c) {
        this.queue[tailPointer] = c;
        tailPointer = (tailPointer + 1) % QUEUE_CAPACITY;
    }

    public char dequeue() {
        char temp = this.queue[this.headPointer];
        this.headPointer = (this.headPointer + 1) % QUEUE_CAPACITY;
        return temp;
    }

    public char checkNextItem() {
        return this.queue[this.headPointer];
    }

    @Override
    public String toString() {
        return Arrays.toString(queue);
    }
}
