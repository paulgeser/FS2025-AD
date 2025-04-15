package ch.hslu.ad.sw09;

import ch.hslu.ad.sw08.a1.BubbleSort;
import ch.hslu.ad.sw08.a1.InsertionSort;
import ch.hslu.ad.sw08.a1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.Collections;

import static ch.hslu.ad.sw08.a1.InsertionSort.getOrderedArray;
import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class ClassicQuickSort {

    public static boolean gui = false;
    public static long count = 0;
    private static final Logger LOG = LoggerFactory.getLogger(ClassicQuickSort.class);

    public static int[] sort(final int[] array) {
        count = 0;

        quickSortHoare(array, 0, array.length - 1);

        return array;
    }

    public static int[] quickSortSelf(final int[] array) {
        LOG.info("entering new quicksort with input value: {}", Arrays.toString(array));

        if (array.length <= 1) {
            return array;
        }

        if (array.length == 2) {
            if (array[0] > array[1]) {
                return new int[]{array[1], array[0]};
            } else {
                return array;
            }
        }

        int[] arr = Arrays.copyOf(array, array.length); // Work on a copy
        int i = 0;
        int j = arr.length - 1;
        int pivot = arr[0];

        System.out.println(Arrays.toString(arr));

        while (i <= j) {
            LOG.info("------------------------");

            while (i <= j && arr[i] < pivot) {
                LOG.info("I shifting");
                i++;
            }

            while (i <= j && arr[j] > pivot) {
                LOG.info("J shifting");
                j--;
            }

            LOG.info("maybe stuff, i({})={}, j({})={}", i, (i < arr.length ? arr[i] : "out"), j, (j >= 0 ? arr[j] : "out"));

            if (i <= j) {
                LOG.info("will move stuff");
                LOG.info(Arrays.toString(arr));
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                i++;
                j--;
                LOG.info("DONE");
                LOG.info(Arrays.toString(arr));
            }

            LOG.info("------------------------");
        }

        // Split at the right place (inclusive j, exclusive i)
        int[] left = (j >= 0) ? quickSortSelf(Arrays.copyOfRange(arr, 0, j + 1)) : new int[0];
        int[] right = (i < arr.length) ? quickSortSelf(Arrays.copyOfRange(arr, i, arr.length)) : new int[0];

        int[] combined = new int[left.length + right.length];
        System.arraycopy(left, 0, combined, 0, left.length);
        System.arraycopy(right, 0, combined, left.length, right.length);
        return combined;
    }

    public static void quickSortHoare(final int[] array, final int start, final int end) {
        if (start < end) {
            count++;
            int p = partition(array, start, end);
            quickSortHoare(array, start, p);
            quickSortHoare(array, p + 1, end);
        }
    }

    public static int partition(final int[] array, final int start, final int end) {
        int pivot = array[start];
        int i = start - 1;
        int j = end + 1;
        Collections.sort(null);

        while (true) {
            do {
                i++;
                count++;
            } while (array[i] < pivot);

            do {
                j--;
                count++;

            } while (array[j] > pivot);

            if (i >= j) {
                count++;
                return j;
            }

            // Swap elements
            int temp = array[i];
            array[i] = array[j];
            array[j] = temp;
            if (gui) {
                SortingAnimation.instance().showArray(array, 50);
            }
        }
    }


    public static void main(String[] args) {
        int[] numbers = getShuffledNumbers(50);
        ClassicQuickSort.gui = true;
        int[] test = sort(numbers);
        LOG.info("count {}", count);

        /**/
        /*testTime();*/

        /*sort(getOrderedArray(100));
        LOG.info("{}", count);*/
    }

    public static void testTime() {
        ClassicQuickSort.gui = false;
        int[] numArray = {100_000, 200_000, 400_000, 800_000, 1_600_000, 3_200_000, 6_400_000};
        for (int i = 0; i < numArray.length; i++) {
            int numberOfRuns = 5;
            long totalTime = 0;
            long totalCounts = 0;
            for (int j = 0; j < (numberOfRuns + 1); j++) {
                int[] numbers = getShuffledNumbers(numArray[i]);
                long start = System.nanoTime();
                int[] test = sort(numbers);
                long end = System.nanoTime();
                if (j != 0) {
                    totalTime += (end - start) / 1000000L;
                    totalCounts += count;
                }
            }
            LOG.info("For {} elements it took on average {}ms and on average {} comparisons", numArray[i], (totalTime / numberOfRuns), totalCounts / numberOfRuns);
        }
    }
}

/*

2025-04-14 20:45:33.119 [main] INFO  c.h.a.s.ClassicQuickSort - For 100000 elements it took on average 7ms and on average 2803996 comparisons
2025-04-14 20:45:33.270 [main] INFO  c.h.a.s.ClassicQuickSort - For 200000 elements it took on average 14ms and on average 5960572 comparisons
2025-04-14 20:45:33.556 [main] INFO  c.h.a.s.ClassicQuickSort - For 400000 elements it took on average 31ms and on average 12700756 comparisons
2025-04-14 20:45:34.412 [main] INFO  c.h.a.s.ClassicQuickSort - For 800000 elements it took on average 63ms and on average 26398262 comparisons
2025-04-14 20:45:35.710 [main] INFO  c.h.a.s.ClassicQuickSort - For 1600000 elements it took on average 134ms and on average 55592377 comparisons
2025-04-14 20:45:38.512 [main] INFO  c.h.a.s.ClassicQuickSort - For 3200000 elements it took on average 278ms and on average 116293192 comparisons
2025-04-14 20:45:44.278 [main] INFO  c.h.a.s.ClassicQuickSort - For 6400000 elements it took on average 579ms and on average 238433450 comparisons
* */
