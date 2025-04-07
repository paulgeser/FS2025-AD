package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw08.a1.animation.SortingAnimation;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class InsertionSort {

    public static boolean gui = false;

    public static int[] sort(final int[] array) {
        int element;
        int j;
        for (int i = 1; i < array.length; i++) {
            element = array[i];
            j = i;
            while (j > 0 && array[j - 1] > element) {
                array[j] = array[j - 1];
                j--;
                if (gui) {
                    SortingAnimation.instance().showArray(array, 50);
                }
            }
            array[j] = element;
        }
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = getShuffledNumbers(50);

        int[] test = sort(numbers);
    }
}
