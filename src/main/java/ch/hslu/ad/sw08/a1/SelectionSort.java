package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw08.a1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class SelectionSort {

    public static boolean gui = false;
    public static long count = 0;
    private static final Logger LOG = LoggerFactory.getLogger(SelectionSort.class);

    public static int[] sort(final int[] array) {
        int initialElement;
        int positionCurrentMin;
        count = 0;
        for (int i = 0; i < array.length; i++) {
            initialElement = array[i];
            positionCurrentMin = i;
            for (int k = (1 + i); k < (array.length); k++) {
                if (array[positionCurrentMin] > array[k]) {
                    positionCurrentMin = k;
                }
                count++;
            }
            if (positionCurrentMin != i) {
                array[i] = array[positionCurrentMin];
                array[positionCurrentMin] = initialElement;
            }
            if (gui) {
                SortingAnimation.instance().showArray(array, 50);
            }
        }
        LOG.info("Took {} comparisons to sort the input array", count);
        return array;
    }

    public static void main(String[] args) {
        /*int[] numbers = getShuffledNumbers(50);
        SelectionSort.gui = true;
        int[] test = sort(numbers);*/

        testTime();
    }

    public static void testTime() {
        SelectionSort.gui = false;
        int[] numArray = {100_000, 200_000, 400_000};
        for (int i = 0; i < numArray.length; i++) {
            int numberOfRuns = 5;
            long totalTime = 0;
            for (int j = 0; j < (numberOfRuns + 1); j++) {
                int[] numbers = getShuffledNumbers(numArray[i]);
                long start = System.nanoTime();
                int[] test = sort(numbers);
                long end = System.nanoTime();
                if (j != 0) {
                    totalTime += (end - start) / 1000000L;
                }
            }
            LOG.info("For {} elements it took on average {}ms", numArray[i], (totalTime / numberOfRuns));
        }
    }
}

/*

der Algorithmus hat immer genau gleich viele Vergleiche. Weil immer alle elemente ausser die schon sortierten verglichen werden müssen.

2025-04-08 17:02:47.004 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:02:56.623 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:03:01.153 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:03:05.878 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:03:10.522 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:03:15.057 [main] INFO  c.h.a.s.a.SelectionSort - Took 4999950000 comparisons to sort the input array
2025-04-08 17:03:15.057 [main] INFO  c.h.a.s.a.SelectionSort - For 100000 elements it took on average 5590ms
2025-04-08 17:03:33.382 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:03:51.437 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:04:09.674 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:04:27.478 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:04:45.262 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:05:03.265 [main] INFO  c.h.a.s.a.SelectionSort - Took 19999900000 comparisons to sort the input array
2025-04-08 17:05:03.265 [main] INFO  c.h.a.s.a.SelectionSort - For 200000 elements it took on average 17965ms
2025-04-08 17:06:14.829 [main] INFO  c.h.a.s.a.SelectionSort - Took 79999800000 comparisons to sort the input array

*/