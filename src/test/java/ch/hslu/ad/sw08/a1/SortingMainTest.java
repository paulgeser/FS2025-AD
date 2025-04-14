package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw09.ClassicQuickSort;
import org.junit.jupiter.api.Test;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;
import static org.junit.jupiter.api.Assertions.*;

class SortingMainTest {

    @Test
    public void testInsertionSort() {
        // Turn off gui
        InsertionSort.gui = false;
        for (int i = 0; i < 3; i++) {
            // arrange
            int[] unOrderedArray = getShuffledNumbers(100);

            // act
            int[] result = InsertionSort.sort(unOrderedArray);

            // assert
            checkSort(result);
        }
    }

    @Test
    public void testSelectionSort() {
        // Turn off gui
        SelectionSort.gui = false;
        for (int i = 0; i < 3; i++) {
            // arrange
            int[] unOrderedArray = getShuffledNumbers(100);

            // act
            int[] result = SelectionSort.sort(unOrderedArray);

            // assert
            checkSort(result);
        }
    }

    @Test
    public void testBubbleSort() {
        // Turn off gui
        BubbleSort.gui = false;
        for (int i = 0; i < 3; i++) {
            // arrange
            int[] unOrderedArray = getShuffledNumbers(100);

            // act
            int[] result = BubbleSort.sort(unOrderedArray);

            // assert
            checkSort(result);
        }
    }

    @Test
    public void testQuickSort() {
        // Turn off gui
        ClassicQuickSort.gui = false;
        for (int i = 0; i < 3; i++) {
            // arrange
            int[] unOrderedArray = getShuffledNumbers(100);

            // act
            int[] result = ClassicQuickSort.sort(unOrderedArray);

            // assert
            checkSort(result);
        }
    }

    @Test
    public void testShellSort() {
        // Turn off gui
        ShellSort.gui = false;
        for (int i = 0; i < 3; i++) {
            // arrange
            int[] unOrderedArray = getShuffledNumbers(100);

            // act
            int[] result = ShellSort.sort(unOrderedArray);

            // assert
            checkSort(result);
        }
    }

    private int[] getOrderedArray(int numbers) {
        int[] array = new int[numbers];
        for (int i = 1; i <= numbers; i++) {
            array[i - 1] = i;
        }
        return array;
    }

    private void checkSort(int[] inputArray) {
        int[] sortedArray = getOrderedArray(inputArray.length);
        for (int i = 0; i < inputArray.length; i++) {
            assertEquals(inputArray[i], sortedArray[i]);
        }
    }

}