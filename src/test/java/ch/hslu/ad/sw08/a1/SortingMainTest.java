package ch.hslu.ad.sw08.a1;

import org.junit.jupiter.api.Test;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;
import static org.junit.jupiter.api.Assertions.*;

class SortingMainTest {

    @Test
    public void testInsertionSort() {
        // Turn of gui
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