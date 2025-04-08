package ch.hslu.ad.sw08.a1;

import ch.hslu.ad.sw06.exercise.n2.buffer.DemoBoundedBuffer;
import ch.hslu.ad.sw08.a1.animation.SortingAnimation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static ch.hslu.ad.sw08.a1.SortingMain.getShuffledNumbers;

public class InsertionSort {

    public static boolean gui = false;
    public static long count = 0;

    private static final Logger LOG = LoggerFactory.getLogger(InsertionSort.class);


    public static int[] sort(final int[] array) {
        int element;
        int j;
        count = 0;
        for (int i = 1; i < array.length; i++) {
            element = array[i];
            j = i;
            while (j > 0 && array[j - 1] > element) {
                array[j] = array[j - 1];
                j--;
                count++;
                if (gui) {
                    SortingAnimation.instance().showArray(array, 50);
                }
            }
            array[j] = element;
        }
        LOG.info("Took {} comparisons to sort the input array", count);
        return array;
    }

    public static void main(String[] args) {
        int[] numbers = getShuffledNumbers(50);
        InsertionSort.gui = true;
        int[] test = sort(numbers);
/*
        testTime();
*/
    }

    public static void testTime() {
        InsertionSort.gui = false;
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
2025-04-08 16:31:44.569 [main] INFO  c.h.a.s.a.InsertionSort - Took 2510816511 comparisons to sort the input array
2025-04-08 16:31:47.957 [main] INFO  c.h.a.s.a.InsertionSort - Took 2499344705 comparisons to sort the input array
2025-04-08 16:31:50.977 [main] INFO  c.h.a.s.a.InsertionSort - Took 2508287915 comparisons to sort the input array
2025-04-08 16:31:54.150 [main] INFO  c.h.a.s.a.InsertionSort - Took 2503667144 comparisons to sort the input array
2025-04-08 16:31:57.319 [main] INFO  c.h.a.s.a.InsertionSort - Took 2497295163 comparisons to sort the input array
2025-04-08 16:32:00.495 [main] INFO  c.h.a.s.a.InsertionSort - Took 2493199812 comparisons to sort the input array
2025-04-08 16:32:00.495 [main] INFO  c.h.a.s.a.InsertionSort - For 100000 elements it took on average 3157ms
2025-04-08 16:32:12.435 [main] INFO  c.h.a.s.a.InsertionSort - Took 9979110642 comparisons to sort the input array
2025-04-08 16:32:24.569 [main] INFO  c.h.a.s.a.InsertionSort - Took 10000086712 comparisons to sort the input array
2025-04-08 16:32:37.071 [main] INFO  c.h.a.s.a.InsertionSort - Took 10015282247 comparisons to sort the input array
2025-04-08 16:32:49.507 [main] INFO  c.h.a.s.a.InsertionSort - Took 9992086147 comparisons to sort the input array
2025-04-08 16:33:02.724 [main] INFO  c.h.a.s.a.InsertionSort - Took 10014716503 comparisons to sort the input array
2025-04-08 16:33:15.571 [main] INFO  c.h.a.s.a.InsertionSort - Took 10000551846 comparisons to sort the input array
2025-04-08 16:33:15.572 [main] INFO  c.h.a.s.a.InsertionSort - For 200000 elements it took on average 12615ms
2025-04-08 16:34:06.366 [main] INFO  c.h.a.s.a.InsertionSort - Took 39882045631 comparisons to sort the input array
2025-04-08 16:34:55.716 [main] INFO  c.h.a.s.a.InsertionSort - Took 40016653154 comparisons to sort the input array
2025-04-08 16:35:45.130 [main] INFO  c.h.a.s.a.InsertionSort - Took 39980394945 comparisons to sort the input array
2025-04-08 16:36:34.330 [main] INFO  c.h.a.s.a.InsertionSort - Took 39970553378 comparisons to sort the input array
2025-04-08 16:37:23.698 [main] INFO  c.h.a.s.a.InsertionSort - Took 40013691845 comparisons to sort the input array
2025-04-08 16:38:13.505 [main] INFO  c.h.a.s.a.InsertionSort - Took 39994924188 comparisons to sort the input array
2025-04-08 16:38:13.505 [main] INFO  c.h.a.s.a.InsertionSort - For 400000 elements it took on average 49392ms


*/