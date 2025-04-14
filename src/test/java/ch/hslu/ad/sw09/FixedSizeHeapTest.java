package ch.hslu.ad.sw09;

import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.*;

class FixedSizeHeapTest {

    @Test
    void testEmptyHeap() {
        // arrange
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap();
        // act

        // assert
        assertTrue(fixedSizeHeap.empty());
        assertEquals(0, fixedSizeHeap.size());
    }

    @Test
    void testFullHeap() {
        // arrange
        FixedSizeHeap fixedSizeHeap = new FixedSizeHeap();
        for (int i = 0; i < 16; i++) {
            fixedSizeHeap.insert(i + 1);
        }

        // act

        // Act & Assert
        assertThatThrownBy(() -> {
            fixedSizeHeap.insert(50);
        })
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Heap is full");
    }

    @Test
    void testHeapInsert1() {
        // arrange
        FixedSizeHeap heap = new FixedSizeHeap();
        // act
        heap.insert(1);

        // assert
        assertFalse(heap.empty());
        assertEquals(1, heap.size());
        assertEquals(1, heap.toArray()[0]);
        assertEquals(-1, heap.toArray()[1]);

    }

    @Test
    void testHeapInsertMultiple() {
        // arrange
        FixedSizeHeap heap = new FixedSizeHeap();
        int[] expectedArray = {15, 7, 10, 1, 5, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // act
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        heap.insert(10);
        heap.insert(7);
        heap.insert(15);

        // assert
        assertFalse(heap.empty());
        assertEquals(6, heap.size());
        int[] result = heap.toArray();
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], result[i]);
        }
    }

    @Test
    void testHeapRemoveMax() {
        // arrange
        FixedSizeHeap heap = new FixedSizeHeap();
        int[] expectedArray = {15, 7, 10, 1, 5, 4, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // act
        heap.insert(1);
        heap.insert(5);
        heap.insert(4);
        heap.insert(7);
        heap.insert(15);
        heap.insert(10);


        // check insert correct
        assertFalse(heap.empty());
        assertEquals(6, heap.size());
        int[] result = heap.toArray();
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], result[i]);
        }

        // act
        int max = heap.removeMax();

        // assert
        assertEquals(15, max);
        assertEquals(10, heap.toArray()[0]);
    }

    @Test
    void testHeapInsertEqual() {
        // arrange
        FixedSizeHeap heap = new FixedSizeHeap();
        int[] expectedArray = {22, 22, 22, 22, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // act
        heap.insert(22);
        heap.insert(22);
        heap.insert(22);
        heap.insert(22);

        // check insert correct
        assertFalse(heap.empty());
        assertEquals(4, heap.size());
        int[] result = heap.toArray();
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], result[i]);
        }
    }

    @Test
    void testHeapUnorderedArray() {
        // arrange
        int[] inputArray = {13, 14, 28, 22, 52, 87};
        int[] expectedArray = {87, 52, 28, 22, 14, 13, -1, -1, -1, -1, -1, -1, -1, -1, -1, -1};
        // act
        FixedSizeHeap heap = new FixedSizeHeap(inputArray);


        // check insert correct
        assertFalse(heap.empty());
        assertEquals(6, heap.size());
        int[] result = heap.toArray();
        for (int i = 0; i < expectedArray.length; i++) {
            assertEquals(expectedArray[i], result[i]);
        }
    }

}