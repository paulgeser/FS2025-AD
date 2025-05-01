package ch.hslu.ad.sw11.exercise.n4.quicksort;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class InsertionSort {

    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);

    /**
     * Sortiert das gesamte Array mit Insertion Sort.
     */
    public static int[] sort(final int[] array) {
        return sort(array, 0, array.length - 1);
    }

    /**
     * Sortiert den Teilbereich [min..max] des Arrays mit Insertion Sort.
     *
     * @param array zu sortierendes Array
     * @param min   unterer Index (inclusive)
     * @param max   oberer Index (inclusive)
     * @return das sortierte Array (gleiche Referenz)
     */
    public static int[] sort(final int[] array, final int min, final int max) {
        for (int i = min + 1; i <= max; i++) {
            int element = array[i];
            int j = i;
            while (j > min && array[j - 1] > element) {
                array[j] = array[j - 1];
                j--;
            }
            array[j] = element;
        }
        return array;
    }
}
